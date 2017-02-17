package com.ana_pc.calculator;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Ana-pc on 16/02/2017.
 */

public class NumberOnClickListener implements View.OnClickListener {

    public Button button;
    public TextView text;
    public boolean borrarTodoYMostrar = true;

    public NumberOnClickListener(TextView text) {
        this.text = text;
    }

    @Override
    public void onClick(View v)
    {
        this.button = (Button)v;
        if(borrarTodoYMostrar){
            this.text.setText("0");
            borrarTodoYMostrar=false;
        }
        String nuevoValor = this.text.getText().toString() + button.getText();
        this.text.setText(Integer.parseInt(nuevoValor));
        Log.d("Calculadora", "Estoy aprendo numero: " + this.text.getText().toString());


    }




}
