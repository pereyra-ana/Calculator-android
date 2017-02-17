package com.ana_pc.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends Activity {

    private Integer valueOne = null;
    private char currentOperation;
    private ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) this.findViewById(R.id.infoTextView);

        final EditText editText = (EditText) this.findViewById(R.id.editText);

        final Button buttonOne = (Button) this.findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new NumberOnClickListener(editText, buttonOne));

        final Button buttonTwo = (Button) this.findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new NumberOnClickListener(editText, buttonTwo));


        final Button buttonThree = (Button) this.findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(new NumberOnClickListener(editText, buttonThree));

        final Button buttonFour = (Button) this.findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(new NumberOnClickListener(editText, buttonFour));

        final Button buttonFive = (Button) this.findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(new NumberOnClickListener(editText, buttonFive));

        final Button buttonSix = (Button) this.findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(new NumberOnClickListener(editText, buttonSix));

        final Button buttonSeven = (Button) this.findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(new NumberOnClickListener(editText, buttonSeven));

        final Button buttonEight = (Button) this.findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(new NumberOnClickListener(editText, buttonEight));

        final Button buttonNine = (Button) this.findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(new NumberOnClickListener(editText, buttonNine));

        final Button buttonZero = (Button) this.findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(new NumberOnClickListener(editText, buttonZero));

        final Button buttonAdd = (Button) this.findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    if (valueOne == null){
                        valueOne = new Integer(editText.getText().toString());
                    }
                    else
                    {
                        if (!textView.getText().toString().isEmpty()) {
                            valueOne = valueOne + new Integer(editText.getText().toString());
                        }
                        else
                        {
                        }
                    }
                    textView.setText(valueOne.toString() + buttonAdd.getText());
                    editText.setText("");
                    currentOperation = '+';
                }
            }
        });

        final Button buttonSubstract = (Button) this.findViewById(R.id.buttonSubstract);
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    if (valueOne == null) {
                        valueOne = new Integer(editText.getText().toString());
                    } else {
                        if (!textView.getText().toString().isEmpty()) {
                            valueOne = valueOne - new Integer(editText.getText().toString());
                            textView.setText(valueOne.toString() + buttonSubstract.getText());
                        } else {
                            currentOperation = '-';
                        }
                    }
                }
                editText.setText("");
            }
        });

        final Button buttonMultiply = (Button) this.findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    if (valueOne == null){
                        valueOne = new Integer(editText.getText().toString());
                    }
                    else
                    {
                        if (!textView.getText().toString().isEmpty()) {
                            valueOne = valueOne * new Integer(editText.getText().toString());
                            textView.setText(valueOne.toString() + buttonMultiply.getText());
                        }
                        else
                        {
                            currentOperation = '*';
                        }
                    }
                }
                editText.setText("");
            }
        });

        final Button buttonDivide = (Button) this.findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    if (valueOne == null){
                        valueOne = new Integer(editText.getText().toString());
                    }
                    else
                    {
                        if (!textView.getText().toString().isEmpty()) {
                            try
                            {
                                valueOne = valueOne / new Integer(editText.getText().toString());
                                textView.setText(valueOne.toString() + buttonDivide.getText());
                            }
                            catch (Exception e)
                            {
                                textView.setText("Math error");
                                valueOne = null;
                            }
                        }
                        else
                        {
                            currentOperation = '/';
                        }
                    }
                }
                editText.setText("");
            }
        });

        final Button buttonEqual = (Button) this.findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logger.getLogger("app").log(Level.INFO, "edit text: '" + editText.getText().toString() + "'");

                if (valueOne != null && !(editText.getText().toString().equals(""))) {
                    try {
                        if (currentOperation == '+') {
                            valueOne = valueOne + new Integer(editText.getText().toString());
                        } else if (currentOperation == '-') {
                            valueOne = valueOne - new Integer(editText.getText().toString());
                        } else if (currentOperation == '*') {
                            valueOne = valueOne * new Integer(editText.getText().toString());
                        } else if (currentOperation == '/') {
                            valueOne = valueOne / new Integer(editText.getText().toString());
                        }
                        textView.setText(valueOne.toString());
                    }
                    catch (Exception e)
                    {
                        textView.setText("Math error");
                        valueOne = null;
                    }
                } else {
                    if (!(textView.getText().toString().equals(""))) {
                        if (operators.contains(textView.getText().toString().substring(textView.getText().toString().length() - 1))
                                && editText.getText().toString().equals("")) {
                            textView.setText("Syntax error");
                            valueOne = null;
                        }
                        else {
                            try
                            {
                                valueOne = new Integer(textView.getText().toString());
                                textView.setText(valueOne.toString());
                            }
                            catch (Exception e)
                            {
                                Logger.getLogger("app").log(Level.INFO, "Not setting value because its not an integer");
                            }
                        }
                    }
                    if (!(editText.getText().toString().equals(""))) {
                        valueOne = new Integer(editText.getText().toString());
                        textView.setText(valueOne.toString());
                    }
                }
                editText.setText("");
            }
        });

        final Button buttonClear = (Button) this.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(null);
                Logger.getLogger("app").log(Level.INFO, "text view: " + textView.getText());
                editText.setText(null);
                valueOne = null;
            }
        });
    }
}
