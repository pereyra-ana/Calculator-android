package com.ana_pc.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ana-pc on 16/02/2017.
 */

public class NumberOnClickListener implements View.OnClickListener {

    public Button button;
    public EditText text;

    public NumberOnClickListener(EditText text, Button button) {
        this.button = button;
        this.text = text;
    }

    @Override
    public void onClick(View v)
    {
        this.text.setText(this.text.getText().toString() + button.getText());
    }


}
