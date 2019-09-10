package io.github.rhildred.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
        implements TextView.OnEditorActionListener, View.OnClickListener {

    //variable names to interact with views/widgets

    EditText editTextBillAmt;
    TextView textViewPercent;
    Button btnPercentDn;
    Button btnPercentUp;
    TextView textViewTip;
    TextView textViewTotal;
    Float nPercent = .15f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link controls to xml

        editTextBillAmt = findViewById(R.id.editTextBillAmt);
        textViewPercent = findViewById(R.id.textViewPercent);
        btnPercentDn = findViewById(R.id.btnPercentDn);
        btnPercentUp = findViewById(R.id.btnPercentUp);
        textViewTip = findViewById(R.id.textViewTip);
        textViewTotal = findViewById(R.id.textViewTotal);

        // wire events to controls

        editTextBillAmt.setOnEditorActionListener(this);
        btnPercentDn.setOnClickListener(this);
        btnPercentUp.setOnClickListener(this);
    }

    @Override
    public boolean onEditorAction(TextView textViewV, int nId, KeyEvent keyEventEvt ){
        calculateTip();
        return false;
    }

    private void calculateTip() {
        String sAmount = editTextBillAmt.getText().toString();
        Float nAmount = Float.parseFloat(sAmount);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Float nTip = nAmount * this.nPercent;
        textViewTip.setText(currency.format(nTip));
        Float nTotal = nAmount + nTip;
        textViewTotal.setText(currency.format(nTotal));
    }

    @Override
    public void onClick(View viewV){

    }
}
