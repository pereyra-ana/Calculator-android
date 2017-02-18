package com.ana_pc.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Integer valueOne = null;
    private String currentOperation;
    private TextView editText ;
    private NumberOnClickListener numberClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) this.findViewById(R.id.infoTextView);

        numberClick = new NumberOnClickListener(editText);

        final Button buttonOne = (Button) this.findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(numberClick);

        final Button buttonTwo = (Button) this.findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(numberClick);

        final Button buttonThree = (Button) this.findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(numberClick);

        final Button buttonFour = (Button) this.findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(numberClick);

        final Button buttonFive = (Button) this.findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(numberClick);

        final Button buttonSix = (Button) this.findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(numberClick);

        final Button buttonSeven = (Button) this.findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(numberClick);

        final Button buttonEight = (Button) this.findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(numberClick);

        final Button buttonNine = (Button) this.findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(numberClick);

        final Button buttonZero = (Button) this.findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(numberClick);

        View.OnClickListener operatorHandler = new View.OnClickListener(){

            public void onClick(View v){
                Button operator = (Button)v;
                if (valueOne != null)
                {
                    try
                    {
                        processAndShowResult();
                    }
                    catch (Exception e)
                    {
                        Log.e("CALCULATOR", "Error ocurred: " + e.getMessage());
                        valueOne = null;
                        currentOperation = "";
                        editText.setText("");
                    }
                }
                currentOperation = operator.getText().toString();
                valueOne = getCurrentValue();
                numberClick.deleteAndShow = true;
            }
        };

        final Button buttonAdd = (Button) this.findViewById(R.id.buttonAdd);
        final Button buttonSubstract = (Button) this.findViewById(R.id.buttonSubstract);
        final Button buttonMultiply = (Button) this.findViewById(R.id.buttonMultiply);
        final Button buttonDivide = (Button) this.findViewById(R.id.buttonDivide);

        buttonAdd.setOnClickListener(operatorHandler);
        buttonSubstract.setOnClickListener(operatorHandler);
        buttonMultiply.setOnClickListener(operatorHandler);
        buttonDivide.setOnClickListener(operatorHandler);

        final Button buttonEqual = (Button) this.findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    processAndShowResult();
                    valueOne = null;
                    currentOperation = "";
                }
                catch (Exception e)
                {
                    Log.e("CALCULATOR", "Error ocurred: " + e.getMessage());
                    valueOne = null;
                    currentOperation = "";
                    editText.setText("");
                }
            }
        });

        final Button buttonClear = (Button) this.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("0");
                valueOne = null;
                currentOperation = "";
            }
        });
    }

    private int getCurrentValue()
    {
        if (this.editText.getText().toString().length() == 0)
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(this.editText.getText().toString());
        }
    }

    private void processAndShowResult() throws Exception
    {
        if (valueOne == null)
        {
            return;
        }
        int valueTwo = getCurrentValue();
        int result = 0;

        switch(currentOperation)
        {
            case "+":
            {
                result = valueOne + valueTwo;
                break;
            }
            case "-":
            {
                result = valueOne - valueTwo;
                break;
            }
            case "*":
            {
                result = valueOne * valueTwo;
                break;
            }
            case "/":
            {
                if (valueTwo == 0)
                {
                    Toast.makeText(this, "Can't divide by zero", Toast.LENGTH_LONG).show();
                    throw new Exception("Can't divide by zero");
                }
                result = valueOne / valueTwo;
                break;
            }
        }
        editText.setText(result+"");
    }
}
