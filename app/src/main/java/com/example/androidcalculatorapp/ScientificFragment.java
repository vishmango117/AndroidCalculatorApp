package com.example.androidcalculatorapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.lang.Math;

public class ScientificFragment extends Fragment {

    // BUTTONS FOR SCIENTIFIC FUNCTIONS
    Button button_log, button_sqroot, button_square,
            button_sin, button_cos, button_tan;

    // BUTTONS FOR NUMBER PAD
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button00;

    // BUTTONS FOR ARITHMETIC EXPRESSIONS
    Button buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonC, buttonEqual;

    // INPUT TEXT
    private EditText myEditText;

    double mValueOne, mValueTwo;

    int degree_value;

    boolean cAddition, cSubtract, cMultiply, cDivision,
            cSin, cCos, cTan, cLog, cSq, cSqrt, cInverse;


    // BUTTONS FOR CALCULATOR MODES
    Button button_programmer, button_basic, button_unitconverter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scientific, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //CREATING BUTTONS and TEXT OBJECTS
        //BUTTONS FOR NUMBER PAD
        button0 = (Button) view.findViewById(R.id.button0);
        button00 = (Button) view.findViewById(R.id.button00);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);
        button6 = (Button) view.findViewById(R.id.button6);
        button7 = (Button) view.findViewById(R.id.button7);
        button8 = (Button) view.findViewById(R.id.button8);
        button9 = (Button) view.findViewById(R.id.button9);

        //BUTTONS FOR ARITHMETIC FUNCTIONS
        buttonAdd = (Button) view.findViewById(R.id.button_add);
        buttonSub = (Button) view.findViewById(R.id.button_sub);
        buttonMul = (Button) view.findViewById(R.id.button_mul);
        buttonDivision = (Button) view.findViewById(R.id.button_div);
        buttonEqual = (Button) view.findViewById(R.id.button_eql);
        myEditText = (EditText) view.findViewById(R.id.edt1);

        // BUTTONS FOR OTHER MODES
        buttonC = (Button) view.findViewById(R.id.btn_clear);
        button_basic = (Button) view.findViewById(R.id.btn_calculator_basic);
        button_programmer = (Button) view.findViewById(R.id.btn_calculator_programmer);

        // BUTTONS FOR SCIENTIFIC PURPOSES
        button_sin = (Button) view.findViewById(R.id.button_sin);
        button_cos = (Button) view.findViewById(R.id.button_cos);
        button_tan = (Button) view.findViewById(R.id.button_tan);
        button_log = (Button) view.findViewById(R.id.button_log);

        //---------------------- ON CLICK LISTENER FOR NUMBER PAD------------------------

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myEditText == null) {
                    myEditText.setText("");
                } else {
                    mValueOne = Float.parseFloat(myEditText.getText() + "");
                    cAddition = true;
                    myEditText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(myEditText.getText() + "");
                cSubtract = true;
                myEditText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(myEditText.getText() + "");
                cMultiply = true;
                myEditText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(myEditText.getText() + "");
                cDivision = true;
                myEditText.setText(null);
            }
        });

        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree_value = Integer.parseInt(myEditText.getText() + "");
                cSin = true;
                myEditText.setText(null);
            }
        });

        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree_value = Integer.parseInt(myEditText.getText() + "");
                cCos = true;
                myEditText.setText(null);
            }
        });

        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree_value = Integer.parseInt(myEditText.getText() + "");
                cTan = true;
                myEditText.setText(null);
            }
        });

        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree_value = Integer.parseInt(myEditText.getText() + "");
                cLog = true;
                myEditText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cAddition == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    myEditText.setText(mValueOne + mValueTwo + "");
                    cAddition = false;
                }

                if (cSubtract == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    myEditText.setText(mValueOne - mValueTwo + "");
                    cSubtract = false;
                }

                if (cMultiply == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    myEditText.setText(mValueOne * mValueTwo + "");
                    cMultiply = false;
                }

                if (cDivision == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    myEditText.setText(mValueOne / mValueTwo + "");
                    cDivision = false;
                }

                if (cSin == true) {
                    if (cInverse == true) {
                        myEditText.setText(Math.asin(degree_value) + "");
                        cInverse = false;

                    } else {
                        myEditText.setText(Math.sin((degree_value*3.14) / 180) + "");
                    }
                    cSin = false;
                }
                if (cCos == true) {
                    if (cInverse == true) {
                        myEditText.setText(Math.acos(degree_value) + "");
                        cInverse = false;

                    } else {
                        myEditText.setText(Math.cos(degree_value) + "");
                    }
                    cCos = false;
                }
                if (cTan == true) {
                    if (cInverse == true) {
                        myEditText.setText(Math.atan(degree_value) + "");
                        cInverse = false;

                    } else {
                        myEditText.setText(Math.tan(degree_value) + "");
                    }
                    cTan = false;
                }
                if (cLog == true) {
                    myEditText.setText(Math.log(mValueOne) + "");
                    cLog = false;
                }
            }
        });


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(null);
            }
        });

        button_programmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ScientificFragment.this)
                        .navigate(R.id.action_ScientificFragment_to_programmerFragment);
            }
        });

        button_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ScientificFragment.this)
                        .navigate(R.id.action_ScientificFragment_to_BasicFragment);
            }
        });
//        button_unitconverter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(BasicFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_programmerFragment);
//            }
//        });
    }
}
