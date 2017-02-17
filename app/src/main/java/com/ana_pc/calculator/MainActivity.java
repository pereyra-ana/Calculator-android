package com.ana_pc.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends Activity {

    private Integer valueOne = null;
    private String currentOperation;
    private ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    private TextView editText ;
    private NumberOnClickListener clickNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) this.findViewById(R.id.infoTextView);

        clickNumero = new NumberOnClickListener(editText);

        final Button buttonOne = (Button) this.findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(clickNumero);

        final Button buttonTwo = (Button) this.findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(clickNumero);


        final Button buttonThree = (Button) this.findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(clickNumero);

        final Button buttonFour = (Button) this.findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(clickNumero);

        final Button buttonFive = (Button) this.findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(clickNumero);

        final Button buttonSix = (Button) this.findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(clickNumero);

        final Button buttonSeven = (Button) this.findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(clickNumero);

        final Button buttonEight = (Button) this.findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(clickNumero);

        final Button buttonNine = (Button) this.findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(clickNumero);

        final Button buttonZero = (Button) this.findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(clickNumero);

        View.OnClickListener handlerOperadores = new View.OnClickListener(){

            public void onClick(View v){
                Button operador = (Button)v;
                if(valueOne != null){
                    try {
                        operarYMostrarResultado();
                    }catch(Exception e){
                        return;
                    }
                }
                currentOperation = operador.getText().toString();
                valueOne = getCurrentValue();
                clickNumero.borrarTodoYMostrar = true;
            }
        };

        final Button buttonAdd = (Button) this.findViewById(R.id.buttonAdd);
        final Button buttonSubstract = (Button) this.findViewById(R.id.buttonSubstract);
        final Button buttonMultiply = (Button) this.findViewById(R.id.buttonMultiply);
        final Button buttonDivide = (Button) this.findViewById(R.id.buttonDivide);


        buttonAdd.setOnClickListener(handlerOperadores);
        buttonSubstract.setOnClickListener(handlerOperadores);
        buttonMultiply.setOnClickListener(handlerOperadores);
        buttonDivide.setOnClickListener(handlerOperadores);

        final Button buttonEqual = (Button) this.findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    operarYMostrarResultado();
                    Log.d("Calculadora", "Llame al igual: " + editText.getText());
                }catch(Exception e){

                }
            }
        });

        final Button buttonClear = (Button) this.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("0");
                Log.d("Calculadora", "Aprete Borrar: " + editText.getText());
                valueOne = null;
                currentOperation = null;
            }
        });
    }

    private int getCurrentValue(){
        if(this.editText.getText().toString().length() == 0){
            return 0;
        }else{
            return Integer.parseInt(this.editText.getText().toString());
        }
    }

    private void operarYMostrarResultado() throws Exception{
        if(valueOne == null){
            return;
        }

        int valueTwo = getCurrentValue();


        int resultado = 0;

        switch(currentOperation){
            case "+": resultado = valueOne + valueTwo;break;
            case "-": resultado = valueOne - valueTwo;break;
            case "*": resultado = valueOne * valueTwo;break;
            case "/":
                if(valueTwo == 0){
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_LONG).show();
                    throw new Exception("No se puede dividir por cero");
                }
                resultado = valueOne / valueTwo;
                break;
        }

        editText.setText(resultado);

    }
}
