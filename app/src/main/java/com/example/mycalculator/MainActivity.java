package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displaySum = findViewById(R.id.displaySum);

        displaySum.setShowSoftInputOnFocus(false);

        displaySum.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                Toast.makeText(MainActivity.this, "onTouch1", Toast.LENGTH_SHORT).show();

                if (getResources().getString(R.string.display).equalsIgnoreCase(((EditText) view).getText().toString()))
                    displaySum.setText("");
                return false;
            }
        });

//        displaySum.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_LONG).show();
//
//                if (getResources().getString(R.string.display).equalsIgnoreCase(((EditText) view).getText().toString()))
//                    displaySum.setText("");
//            }
//        });

    }

    private void UpdateText(String strToAdd)
    {
        int coursorPosition = displaySum.getSelectionStart();

        if (getText(R.string.display).toString().equals(displaySum.getText().toString()))
        {
            displaySum.setText(strToAdd);
            displaySum.setSelection(coursorPosition + 1);
            return;
        } else
        {
            String oldStr = displaySum.getText().toString();
            String leftStr = oldStr.substring(0, coursorPosition);
            String rightStr = oldStr.substring(coursorPosition);
            displaySum.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            displaySum.setSelection(coursorPosition + 1);
        }

    }

    private EditText displaySum;

    public void buttonZeroOnCLick(View view)
    {
        UpdateText("0");
    }

    public void buttonOneOnCLick(View view)
    {
        UpdateText("1");
    }

    public void buttonTwoOnCLick(View view)
    {
        UpdateText("2");
    }

    public void buttonThreeOnCLick(View view)
    {
        UpdateText("3");
    }

    public void buttonFourOnCLick(View view)
    {
        UpdateText("4");
    }

    public void buttonFiveOnCLick(View view)
    {
        UpdateText("5");
    }

    public void buttonSixOnCLick(View view)
    {
        UpdateText("6");
    }

    public void buttonSevenOnCLick(View view)
    {
        UpdateText("7");
    }

    public void buttonEightOnCLick(View view)
    {
        UpdateText("8");
    }

    public void buttonNineOnCLick(View view)
    {
        UpdateText("9");
    }

// -----------------

    public void buttonClearOnClick(View view)
    {
        displaySum.setText("");
    }

    public void buttonParenthesisOnClick(View view)
    {
        int cursorPosition = displaySum.getSelectionStart();
        String s = displaySum.getText().toString();

        if (cursorPosition == -1)
            displaySum.setSelection(s.length());

        int countClosed = 0;
        int countOpened = 0;

        for (int i = 0; i < cursorPosition; i++)
        {
            if (s.charAt(i) == '(')
                countOpened++;
            else if (s.charAt(i) == ')')
                countClosed++;

        }

        if(countOpened > countClosed)
            UpdateText(")");
        else
            UpdateText("(");

    }

    public void buttonExponentOnClick(View view)
    {
        UpdateText("^");
    }

    public void buttonDivideOnClick(View view)
    {
        UpdateText("/");
    }

    public void buttonMultiplyOnClick(View view)
    {
        UpdateText("*");
    }


    public void buttonSubstractOnClick(View view)
    {
        UpdateText("-");
    }


    public void buttonAddOnClick(View view)
    {
        UpdateText("+");
    }


    public void buttonPlusMinusOnClick(View view)
    {

    }


    public void buttonPointOnClick(View view)
    {
        UpdateText(".");
    }

    public void buttonEqualsOnClick(View view)
    {

    }

    public void buttonDeleteOnClick(View view)
    {
        if (getText(R.string.display).toString().equals(displaySum.getText().toString()))
        {
            displaySum.setText("");
            displaySum.setSelection(0);
            return;
        }

        int cursorPosition = displaySum.getSelectionStart();
        if (cursorPosition > 0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) displaySum.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            displaySum.setText(selection);
            displaySum.setSelection(cursorPosition - 1);
        }

    }
}