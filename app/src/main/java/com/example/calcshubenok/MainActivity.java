package com.example.calcshubenok;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public double firstChislo = 0;
    public double secondChislo = 0;
    public int numClicks;
    public String operation = "";
    public String preOpertion;
    public int countOper;
public EditText text;
public Button btnDelDigit;
public  Button btnOchist;
    public  Button btnRavno;
public Button btnPlus;
public Button btnMinus;
public Button btnUmnozh;
public Button btnDelenie;
public Button btnOneDelenie;
public Button btnPercent;
public  Button btnSqrtTwo;
public Button btnPowTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //кнопки вычислительных операций
        btnPlus = (Button) findViewById(R.id.plusBtn);
        btnMinus = (Button) findViewById(R.id.minusBtn);
        btnUmnozh = (Button) findViewById(R.id.umnozhBtn);
        btnDelenie = (Button)findViewById(R.id.delBtn);
        btnRavno = (Button)findViewById(R.id.ravnoBtn);
        btnOchist = (Button) findViewById(R.id.ochistBtn);
        btnDelDigit = (Button) findViewById(R.id.delDigitBtn);
        btnOneDelenie = (Button)findViewById(R.id.onedelenieBtn);
        btnPercent = (Button)findViewById(R.id.percentBtn);
        btnSqrtTwo = (Button)findViewById(R.id.sqrttwo);
        btnPowTwo = (Button)findViewById(R.id.powtwo);
        btnPlus.setOnClickListener(plusClickListener);
        btnMinus.setOnClickListener(minusClickListener);
        btnUmnozh.setOnClickListener(umnozhClickListener);
        btnDelenie.setOnClickListener(delenieClickListener);
        btnRavno.setOnClickListener(ravnoClickListener);
        btnOchist.setOnClickListener(ochistClickListener);
        btnDelDigit.setOnClickListener(delDigitClickListener);
        btnOneDelenie.setOnClickListener(oneDelenieClickListener);
        btnPercent.setOnClickListener(percentClickListener);
        btnSqrtTwo.setOnClickListener(sqrtTwoClickListener);
        btnPowTwo.setOnClickListener(powTwoClickListener);
        text = (EditText) findViewById(R.id.textChislo);

    }

    private void Firstoper()
    {
        if (countOper == 1)
        {
            firstChislo = Double.parseDouble(text.getText().toString());
            operation = "";
        }

    }

    private View.OnClickListener sqrtTwoClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            countOper+=1;
            Firstoper();
            Operation("sqrt2");
            countOper++;
            Operation(operation);


        }
    };
    private View.OnClickListener powTwoClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            countOper+=1;
            Firstoper();
            Operation("^2");
            Operation(operation);

        }
    };

    private View.OnClickListener oneDelenieClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            countOper+=1;
            Firstoper();
            Operation(operation);
            operation = "1/x";


        }
        };
    private View.OnClickListener percentClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            countOper += 1;
            if (operation == "*" || operation == "/")
            {
                operation = "%";

            }
            Operation(operation);
            operation="";
        }
    };
    private View.OnClickListener plusClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            countOper+=1;
            Firstoper();
            Operation(operation);
            operation = "+";
            text.setText("");

        }
    };
    private View.OnClickListener minusClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            countOper+=1;
            Firstoper();
            Operation(operation);
            operation="-";
            text.setText("");
        }
    };
    private View.OnClickListener umnozhClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            countOper+=1;
            Firstoper();
            Operation(operation);
            operation="*";
            text.setText("");

        }
    };
    private View.OnClickListener delenieClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            countOper+=1;
            Firstoper();
            Operation(operation);
            operation="/";
            text.setText("");

        }
    };
    private View.OnClickListener ravnoClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            countOper = 0;
            Firstoper();
            Operation(operation);
            String result = "" + firstChislo;
            text.setText(result);

            operation = "";
        }
    };
    private View.OnClickListener ochistClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            firstChislo = 0;
            secondChislo = 0;
            operation = "";
            countOper = 0;
            text.setText("");
        }
        };
    private View.OnClickListener delDigitClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            String value = text.getText().toString();
            value.replaceAll(".$", "");
            text.setText(value);
        }
        };
    public void Operation (String operation) {
        secondChislo = Double.parseDouble(text.getText().toString());
        switch (operation)
        {
            case "+":
                firstChislo+=secondChislo;
                break;
            case "-":
                firstChislo-=secondChislo;
                break;
            case "*":
                firstChislo*=secondChislo;
                break;
            case "/":
                firstChislo/=secondChislo;
                break;
            case "1/x":
                firstChislo=1/secondChislo;
                break;
            case "%":
                firstChislo = secondChislo/firstChislo;
                break;
            case "sqrt2":
                secondChislo = Math.sqrt(secondChislo);
                break;
            case "^2":
                firstChislo = Math.pow(firstChislo,2);
                break;
            default:
                break;


        }

    };


}



