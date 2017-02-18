package com.ana_pc.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ana-pc on 16/02/2017.
 */

public class NumberOnClickListener implements View.OnClickListener {

    public Button button;
    public TextView text;
    public boolean deleteAndShow = true;

    public NumberOnClickListener(TextView text) {
        this.text = text;
    }

    @Override
    public void onClick(View v)
    {
        this.button = (Button)v;
        if (deleteAndShow)
        {
            this.text.setText("0");
            deleteAndShow = false;
        }
        String newValue = this.text.getText().toString() + button.getText();
        this.text.setText(Integer.parseInt(newValue)+"");
    }




}
