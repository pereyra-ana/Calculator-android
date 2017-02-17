package com.ana_pc.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ana-pc on 17/02/2017.
 */

public class EqualButtonOnClickListener implements View.OnClickListener{
    private Integer valueOne = null;
    private char currentOperation;
    private ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public EqualButtonOnClickListener(EditText text, Button button) {
    }

    @Override
    public void onClick(View v)
    {

    }
}
