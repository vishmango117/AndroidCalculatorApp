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

import org.w3c.dom.Text;

public class BasicFragment extends Fragment {

    // BUTTONS FOR NUMBER PAD
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button00;

    // BUTTONS FOR ARITHEMATIC EXPRESSIONS
    Button buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonC, buttonEqual;

    // BUTTONS FOR CALCULATOR MODES
    Button button_programmer, button_scientific, button_unitconverter;

    // INPUT TEXT
    EditText myEditText;

    // TEXT VIEWS FOR DISPLAY PREVIOUS COMMANDS AND DISPLAY OPERATIONS NEEDED
    private TextView previous_operation, display_operation;

    float mValueOne, mValueTwo;

    // ADDING SHARED PREFERENCES FOR PERSISTANT DATA
    private SharedPreferences myprefs;
    private SharedPreferences.Editor editor;

    boolean cAddition, cSubtract, cMultiply, cDivision;

    public float addition(float x, float y) {
        return x+y;
    }

    public float subtraction(float x, float y) {
        return x-y;
    }

    public float multiplication(float x, float y) {
        return x*y;
    }

    public float division(float x, float y) {
        return x/y;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic, container, false);
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

        //INITIALISING TEXT VIEWS AND EDIT TEXT
        previous_operation = (TextView) view.findViewById(R.id.previous_operation);
        display_operation = (TextView) view.findViewById(R.id.display_operations);
        myEditText = (EditText) view.findViewById(R.id.input_text);

        //DISABLE SOFT KEYBOARD
        myEditText.setShowSoftInputOnFocus(false);
        myEditText.setInputType(InputType.TYPE_NULL);
        myEditText.setFocusable(false);

        // BUTTONS FOR OTHER MODES
        buttonC = (Button) view.findViewById(R.id.btn_clear);
        button_programmer = (Button) view.findViewById(R.id.btn_calculator_programmer);
        button_scientific = (Button) view.findViewById(R.id.btn_calculator_scientific);

        //OBJECTS TO LOAD/SAVE DATA FROM SHAREDPREFERENCES
        myprefs = this.getActivity().getSharedPreferences("persistantdata", Context.MODE_PRIVATE);
        editor = this.getActivity().getSharedPreferences("persistantdata", Context.MODE_PRIVATE).edit();
        previous_operation.setText(myprefs.getString("PREVIOUS_OPS", ""));
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

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText(myEditText.getText() + "00");
            }
        });

        //---------------------- ON CLICK LISTENER FOR ARITHMETIC FUNCTIONS ------------------------

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

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(myEditText.getText() + "");

                if (cAddition == true) {
                    myEditText.setText(addition(mValueOne, mValueTwo) + "");
                    previous_operation.setText(mValueOne + "+" + mValueTwo);

                    cAddition = false;
                }

                if (cSubtract == true) {
                    myEditText.setText(subtraction(mValueOne, mValueTwo) + "");
                    previous_operation.setText(mValueOne + "-" + mValueTwo);
                    cSubtract = false;
                }

                if (cMultiply == true) {
                    myEditText.setText(multiplication(mValueOne, mValueTwo) + "");
                    previous_operation.setText(mValueOne + "*" + mValueTwo);

                    cMultiply = false;
                }

                if (cDivision == true) {
                    myEditText.setText(division(mValueOne, mValueTwo) + "");
                    previous_operation.setText(mValueOne + "/" + mValueTwo);
                    cDivision = false;
                }
                editor.putString("PREVIOUS_OPS",previous_operation.getText() + "");
                editor.apply();
            }
        });

        //ON CLICK LISTENER FOR CLEAR

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText("");
            }
        });

        //-------------- ON CLICK LISTENER FOR CALCULATOR MODES ------------------------


        button_programmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BasicFragment.this)
                        .navigate(R.id.action_BasicFragment_to_programmerFragment);
            }
        });

        button_scientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BasicFragment.this)
                        .navigate(R.id.action_BasicFragment_to_ScientificFragment);
            }
        });

    }



}
