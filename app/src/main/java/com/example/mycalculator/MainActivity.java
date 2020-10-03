package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycalculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private double valueOne = 0.0;
    private double valueTwo;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        final DecimalFormat decimalFormat = new DecimalFormat("#.##########");

        binding.buttonZero.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s0", binding.editText.getText().toString()));
            }
        });
        binding.buttonOne.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s1", binding.editText.getText().toString()));
            }
        });
        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s2", binding.editText.getText().toString()));
            }
        });
        binding.buttonThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s3", binding.editText.getText().toString()));
            }
        });
        binding.buttonFour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s4", binding.editText.getText().toString()));
            }
        });
        binding.buttonFive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s5", binding.editText.getText().toString()));
            }
        });
        binding.buttonSix.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s6", binding.editText.getText().toString()));
            }
        });
        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s7", binding.editText.getText().toString()));
            }
        });
        binding.buttonEight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s8", binding.editText.getText().toString()));
            }
        });
        binding.buttonNine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s9", binding.editText.getText().toString()));
            }
        });

        binding.buttonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CURRENT_ACTION = 'P';
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%sP", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CURRENT_ACTION = 'M';
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%sC", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CURRENT_ACTION = 'p';
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%s^", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });


        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CURRENT_ACTION = ADDITION;
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%s+", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });


        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CURRENT_ACTION = SUBTRACTION;
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%s-", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CURRENT_ACTION = MULTIPLICATION;
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%s*", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CURRENT_ACTION = DIVISION;
                valueOne = Double.parseDouble(binding.editText.getText().toString());
                binding.infoTextView.setText(String.format("%s/", valueOne));
                binding.editText.setText("");
                computeCalculation();
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                if ((CURRENT_ACTION == 'T' && valueTwo % 90 == 0) || (CURRENT_ACTION == 't' && valueTwo % 90 == 0))
                    binding.infoTextView.setText(String.format("%s = UNDEFINED", binding.infoTextView.getText().toString()));
                else
                    binding.infoTextView.setText(String.format("%s = %s", binding.infoTextView.getText().toString(), decimalFormat.format(valueOne)));

                CURRENT_ACTION = '0';
            }
        });
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText(String.format("%s.", binding.editText.getText()));
            }
        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                binding.editText.setText("");
                binding.infoTextView.setText("");
            }
        });
        binding.buttonLn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 'l';
                binding.infoTextView.setText("Ln ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonLog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 'L';
                binding.infoTextView.setText("Log ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonSin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 'S';
                binding.infoTextView.setText("Sin ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonCos.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 'C';
                binding.infoTextView.setText("Cos ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonTan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 'T';
                binding.infoTextView.setText("Tan ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonASin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 's';
                binding.infoTextView.setText("Cosec ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonACos.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 'c';
                binding.infoTextView.setText("Sec ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonATan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = 't';
                binding.infoTextView.setText("Cot ");
                binding.editText.setText("");
                computeCalculation();
            }
        });
        binding.buttonE.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                binding.editText.setText("2.71828182846");
            }
        });
        binding.buttonPI.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                binding.editText.setText("3.14285714286");
            }
        });
    }

    public void computeCalculation() {
        if (!binding.editText.getText().toString().equals("")) {

            valueTwo = Double.parseDouble(binding.editText.getText().toString());


            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
            else if (CURRENT_ACTION == 'S')
                valueOne = Math.sin(valueTwo * Math.PI / 180.0);
            else if (CURRENT_ACTION == 'C')
                valueOne = Math.cos(valueTwo * Math.PI / 180.0);
            else if (CURRENT_ACTION == 'T')
                valueOne = Math.tan(valueTwo * Math.PI / 180.0);
            else if (CURRENT_ACTION == 's')
                valueOne = 1.0 / Math.sin(valueTwo * Math.PI / 180.0);
            else if (CURRENT_ACTION == 'c')
                valueOne = 1.0 / Math.cos(valueTwo * Math.PI / 180.0);
            else if (CURRENT_ACTION == 't')
                valueOne = 1.0 / Math.tan(valueTwo * Math.PI / 180.0);
            else if (CURRENT_ACTION == 'L')
                valueOne = Math.log10(valueTwo);
            else if (CURRENT_ACTION == 'l')
                valueOne = Math.log(valueTwo);
            else if (CURRENT_ACTION == 'p')
                valueOne = Math.pow(this.valueOne, valueTwo);
            else if (CURRENT_ACTION == 'P') {
                int n = (int) this.valueOne, r = (int) valueTwo;
                valueOne = fact(n) / fact(n - r);
            } else if (CURRENT_ACTION == 'M') {
                int n = (int) this.valueOne, r = (int) valueTwo;
                valueOne = fact(n) / fact(n - r) / fact(r);
            }
            binding.editText.setText(String.valueOf(valueOne));
            binding.infoTextView.setText(String.format("%s%s", binding.infoTextView.getText().toString(), valueTwo));
        } else
            binding.infoTextView.setText(binding.infoTextView.getText().toString());
    }

    public double fact(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++)
            f = f * i;
        return f;
    }
}