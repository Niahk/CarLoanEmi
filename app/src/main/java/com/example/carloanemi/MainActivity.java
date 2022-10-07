package com.example.carloanemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtPrinicple,txtDownPayment,txtInterestRate,txtLoanTerm;
    Button btnCalculate;
    TextView lblResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPrinicple=(EditText)findViewById(R.id.txt_principal);
        txtDownPayment=(EditText)findViewById(R.id.txt_downnpayment);
        txtInterestRate=(EditText)findViewById(R.id.txt_interestrate);
        txtLoanTerm=(EditText)findViewById(R.id.txt_termmonths);
        btnCalculate=(Button)findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(this);
        lblResult=(TextView)findViewById(R.id.editTextTextPersonName2);
    }

    @Override
    public void onClick(View v) {
            try
            {
                DecimalFormat formatter=new DecimalFormat("#0.00");
                double prinicipleAmount= Double.parseDouble(txtPrinicple.getText().toString());
                double downPayment=Double.parseDouble(txtDownPayment.getText().toString());
                prinicipleAmount = prinicipleAmount-downPayment;
                double interestRate=Double.parseDouble(txtInterestRate.getText().toString());
                interestRate= interestRate/(12*100);
                double loanTerm=Double.parseDouble(txtLoanTerm.getText().toString());
                double emi=prinicipleAmount* (interestRate*Math.pow((1+interestRate),loanTerm)) /(Math.pow((1+interestRate),loanTerm)-1);
                lblResult.setText(String.valueOf(formatter.format(emi)));
    }
            catch(Exception e)
            {
                Toast.makeText(getBaseContext(),"InvalidInput",Toast.LENGTH_LONG).show();
            }
    }
}