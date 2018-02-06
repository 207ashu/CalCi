package com.example.ashu.calci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultsTextView;
    String runningNumber = "0", leftValue = "", rightVlaue = "";
    Operation incomingOperation;
    double result = 0;
    boolean booleanAC = false, booleanClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonAC = findViewById(R.id.buttonAC);
        Button buttonDot = findViewById(R.id.buttonDot);

        ImageButton buttonMul = findViewById(R.id.imageButtonMultiply);
        ImageButton buttonDiv = findViewById(R.id.imageButtonDivide);
        ImageButton buttonAdd = findViewById(R.id.imageButtonAdd);
        ImageButton buttonSub = findViewById(R.id.imageButtonSubtract);
        ImageButton buttonClear = findViewById(R.id.imageButtonClear);
        ImageButton buttonEqual = findViewById(R.id.imageButtonEqual);

        resultsTextView = findViewById(R.id.textViewResult);
        resultsTextView.setText("0");


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(".");

            }
        });
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleanAC = true;
                runningNumber = "0";
                leftValue = "";
                rightVlaue = "";
                result = 0;
                incomingOperation = null;

                resultsTextView.setText("0");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOPeration(Operation.ADD);


            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOPeration(Operation.MULTIPLY);


            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOPeration(Operation.DIVIDE);


            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOPeration(Operation.SUBTRACT);


            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                booleanClear = true;
                runningNumber = resultsTextView.getText().toString();
                int length = runningNumber.length();

                if (length == 0 || length == 1) {
                    runningNumber = "0";
                    resultsTextView.setText("0");
                } else if (length == 2 && runningNumber.startsWith("-")) {
                    runningNumber = "0";
                    resultsTextView.setText("0");
                } else {
                    runningNumber = runningNumber.substring(0, length - 1);
                    resultsTextView.setText(runningNumber);
                }

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOPeration(Operation.EQUAL);
            }
        });


    }

    public void numberPressed(String number) {
        if (runningNumber == "0" && booleanAC == true) {
            runningNumber = String.valueOf(number);
            booleanAC = false;
        }
        else if (runningNumber=="0"){
            runningNumber=String.valueOf(number);
        }else
            runningNumber += String.valueOf(number);
        resultsTextView.setText(runningNumber);
    }

    public void processOPeration(Operation operation) {
        booleanAC = false;

        if (incomingOperation != null) {
            if (runningNumber != "") {

                rightVlaue = runningNumber;


                switch (incomingOperation) {
                    case ADD:
                        try {
                            result = Double.parseDouble(leftValue) + Double.parseDouble(rightVlaue);
                        } catch (NumberFormatException e) {
                            Toast t = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
                            t.show();
                        }
                        break;
                    case SUBTRACT:
                        try {
                            result = Double.parseDouble(leftValue) - Double.parseDouble(rightVlaue);
                        } catch (NumberFormatException e) {
                            Toast t = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
                            t.show();
                        }
                        break;
                    case MULTIPLY:
                        try {
                            result = Double.parseDouble(leftValue) * Double.parseDouble(rightVlaue);
                            if(result==-0.0)
                                result=0;
                        } catch (NumberFormatException e) {
                            Toast t = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
                            t.show();
                        }
                        break;
                    case DIVIDE:
                        try {
                            result = Double.parseDouble(leftValue) / Double.parseDouble(rightVlaue);
                        } catch (NumberFormatException e) {
                            Toast t = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
                            t.show();
                        }
                        break;
                    case EQUAL:
                        break;
                }

                if (booleanClear == true && operation != Operation.EQUAL) {
                    leftValue = runningNumber;
                    rightVlaue = "";
                    runningNumber = "";
                    booleanClear = false;
                } else
                    leftValue = "" + result;

                int resultLength = leftValue.length();
                if (leftValue.endsWith(".0"))
                    leftValue = leftValue.substring(0, resultLength - 2);

                resultsTextView.setText(leftValue);
                runningNumber = "";
            } else {
                rightVlaue = runningNumber;
            }
        } else {
            leftValue = runningNumber;
            runningNumber = "";
        }
        incomingOperation = operation;


    }


    public enum Operation {ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL}
}
