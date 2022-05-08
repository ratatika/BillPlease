package sg.edu.rp.c346.id20006092.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etAmount;
    EditText etPax;
    ToggleButton tbtnSVS;
    ToggleButton tbtnGST;
    TextView tvTotalBill;
    TextView tvEachPays;
    Button btnSplit;
    Button btnReset;
    EditText etDiscount;
    RadioGroup rgMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmount);
        etPax = findViewById(R.id.etPax);
        tbtnSVS = findViewById(R.id.tBtnSVS);
        tbtnGST = findViewById(R.id.tBtnGST);
        btnSplit = findViewById(R.id.btnSplit);
        btnReset = findViewById(R.id.btnReset);
        etDiscount = findViewById(R.id.etDiscount);
        tvTotalBill = findViewById(R.id.tvTotalBill);
        tvEachPays = findViewById(R.id.tvEachPays);
        rgMode = findViewById(R.id.rgMode);

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data1 = etAmount.getText().toString();
                String data2 = etPax.getText().toString();

                double amount = Double.parseDouble(data1);
                double newAmount = 0;
                int pax = Integer.parseInt(data2);

                if (tbtnSVS.isChecked() == true && tbtnGST.isChecked() == true) {

                    newAmount = amount * 1.10 * 1.07;

                } else if (tbtnSVS.isChecked() == false && tbtnGST.isChecked() == true) {

                    newAmount = amount * 1.07;

                } else if (tbtnSVS.isChecked() == true && tbtnGST.isChecked() == false) {

                    newAmount = amount * 1.10;

                }

                double eachPays = newAmount / pax;
                tvTotalBill.setText("$" + newAmount + "");
                tvEachPays.setText("$" + eachPays + "");


            }

        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAmount.setText("");
                etPax.setText("");
                etDiscount.setText("");
                tbtnSVS.setEnabled(true);
                tbtnGST.setEnabled(true);
            }
        });



    }
}