package com.example.androidcalculatorapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private TextView scientific_operation, display_operation;

    double mValueOne, mValueTwo, mygenericvalue;

    int degree_value;

    boolean cAddition, cSubtract, cMultiply, cDivision,
            cSin, cCos, cTan, cLog, cSq, cSqrt, cInverse;

    //ADDED SHARED PREFERENCES FOR PERSISTANT DATA
    private SharedPreferences myprefs;
    private SharedPreferences.Editor editor;


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

        scientific_operation = (TextView) view.findViewById(R.id.scientific_ops_message);
        myEditText = (EditText) view.findViewById(R.id.input_text);
        display_operation = (TextView) view.findViewById(R.id.display_operations);

        //DISABLE SOFT KEYBOARD
        myEditText.setShowSoftInputOnFocus(false);
        myEditText.setInputType(InputType.TYPE_NULL);
        myEditText.setFocusable(false);

        // BUTTONS FOR OTHER MODES
        buttonC = (Button) view.findViewById(R.id.btn_clear);
        button_basic = (Button) view.findViewById(R.id.btn_calculator_basic);
        button_programmer = (Button) view.findViewById(R.id.btn_calculator_programmer);

        // BUTTONS FOR SCIENTIFIC PURPOSES
        button_sin = (Button) view.findViewById(R.id.button_sin);
        button_cos = (Button) view.findViewById(R.id.button_cos);
        button_tan = (Button) view.findViewById(R.id.button_tan);
        button_log = (Button) view.findViewById(R.id.button_log);
        button_sqroot = (Button) view.findViewById(R.id.button_sqroot);
        button_square = (Button) view.findViewById(R.id.button_square);

        //OBJECTS TO LOAD/SAVE DATA FROM SHAREDPREFERENCES
        myprefs = this.getActivity().getSharedPreferences("persistantdata", Context.MODE_PRIVATE);
        editor = this.getActivity().getSharedPreferences("persistantdata", Context.MODE_PRIVATE).edit();
        scientific_operation.setText(myprefs.getString("PREVIOUS_OPS", ""));

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
                    display_operation.setText("+");
                    myEditText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(myEditText.getText() + "");
                cSubtract = true;
                display_operation.setText("-");
                myEditText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(myEditText.getText() + "");
                cMultiply = true;
                display_operation.setText("*");
                myEditText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(myEditText.getText() + "");
                cDivision = true;
                display_operation.setText("/");
                myEditText.setText(null);
            }
        });

        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cSin = true;
                display_operation.setText("Sin()");

                myEditText.setText(null);
            }
        });

        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cCos = true;
                display_operation.setText("Cos()");
                myEditText.setText(null);
            }
        });

        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cTan = true;
                display_operation.setText("Tan()");
                myEditText.setText(null);
            }
        });

        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cLog = true;
                display_operation.setText("Log()");

                myEditText.setText(null);
            }
        });

        button_sqroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cSqrt = true;
            }
        });

        button_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cSq = true;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cAddition == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    scientific_operation.setText(mValueOne + "+" + mValueTwo);
                    myEditText.setText(mValueOne + mValueTwo + "");
                    cAddition = false;
                }

                if (cSubtract == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    myEditText.setText(mValueOne + mValueTwo + "");
                    scientific_operation.setText(mValueOne + "-" + mValueTwo);
                    myEditText.setText(mValueOne - mValueTwo + "");
                    cSubtract = false;
                }

                if (cMultiply == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    scientific_operation.setText(mValueOne + "*" + mValueTwo);
                    myEditText.setText(mValueOne * mValueTwo + "");
                    cMultiply = false;
                }

                if (cDivision == true) {
                    mValueTwo = Float.parseFloat(myEditText.getText() + "");
                    scientific_operation.setText(mValueOne + "/" + mValueTwo);
                    myEditText.setText(mValueOne / mValueTwo + "");
                    cDivision = false;
                }

                if (cSin == true) {
                    if (cInverse == true) {
                        degree_value = Integer.parseInt(myEditText.getText() + "");
                        scientific_operation.setText("aSin(" + degree_value +")");
                        myEditText.setText(Math.asin((degree_value*3.14) / 180) + "");
                        cInverse = false;

                    } else {
                        degree_value = Integer.parseInt(myEditText.getText() + "");
                        scientific_operation.setText("Sin(" + degree_value +")");
                        myEditText.setText(Math.sin((degree_value*3.14) / 180) + "");
                    }
                    cSin = false;
                }
                if (cCos == true) {
                    if (cInverse == true) {
                        degree_value = Integer.parseInt(myEditText.getText() + "");
                        scientific_operation.setText("aCos(" + degree_value +")");
                        myEditText.setText(Math.acos(degree_value) + "");
                        cInverse = false;

                    } else {
                        degree_value = Integer.parseInt(myEditText.getText() + "");
                        scientific_operation.setText("Cos(" + degree_value +")");
                        myEditText.setText(Math.cos((degree_value*3.14) / 180) + "");
                    }
                    cCos = false;
                }
                if (cTan == true) {
                    if (cInverse == true) {
                        degree_value = Integer.parseInt(myEditText.getText() + "");
                        scientific_operation.setText("aTan(" + degree_value +")");
                        myEditText.setText(Math.atan(degree_value) + "");
                        cInverse = false;

                    } else {
                        degree_value = Integer.parseInt(myEditText.getText() + "");
                        scientific_operation.setText("Tan(" + degree_value +")");
                        myEditText.setText(Math.tan((degree_value*3.14) / 180) + "");
                    }
                    cTan = false;
                }
                if (cLog == true) {
                    mygenericvalue = Double.parseDouble(myEditText.getText() + "");
                    scientific_operation.setText("Log(" + mygenericvalue +")");
                    myEditText.setText(Math.log(mygenericvalue) + "");
                    cLog = false;
                }

                if(cSq == true) {
                    mygenericvalue = Double.parseDouble(myEditText.getText() + "");
                    scientific_operation.setText("Square(" + mygenericvalue + ")");
                    myEditText.setText((mygenericvalue * mygenericvalue) + "");
                    cSq = false;
                }

                if(cSqrt == true) {
                    mygenericvalue = Double.parseDouble(myEditText.getText() + "");
                    scientific_operation.setText("Sqrt(" + mygenericvalue +")");
                    myEditText.setText(Math.sqrt(mygenericvalue) + "");
                }

                editor.putString("PREVIOUS_OPS",scientific_operation.getText() + "");
                editor.apply();
            }
        });


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scientific_operation.setText(null);
                myEditText.setText(null);
                display_operation.setText(null);
            }
        });

        // ON CLICK LISTENERS FOR NAVIGATION BETWEEN MODES
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
    }
}
