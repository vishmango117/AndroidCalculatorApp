package com.example.androidcalculatorapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgrammerFragment extends Fragment {

    // BUTTONS FOR NUMBER PAD
    Button button0, button1, button2, button3,
            button4, button5, button6, button7,
            button8, button9, buttonA, buttonB,
            buttonC, buttonD, buttonE, buttonF;

    // BUTTONS FOR ARITHEMATIC EXPRESSIONS
    Button buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonClear, buttonEqual;

    // INPUT TEXT
    EditText myEditText;

    TextView display_operation, previous_operation;

    float mValueOne, mValueTwo;

    // ADDING SHARED PREFERENCES FOR PERSISTANT DATA
    private SharedPreferences myprefs;
    private SharedPreferences.Editor editor;

    boolean cAddition, cSubtract, cMultiply, cDivision;

    Button button_scientific, button_basic;

    public ProgrammerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programmer, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //BUTTONS FOR NUMBER PAD
        button0 = (Button) view.findViewById(R.id.button0);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);
        button6 = (Button) view.findViewById(R.id.button6);
        button7 = (Button) view.findViewById(R.id.button7);
        button8 = (Button) view.findViewById(R.id.button8);
        button9 = (Button) view.findViewById(R.id.button9);
        buttonA = (Button) view.findViewById(R.id.buttonA);
        buttonB = (Button) view.findViewById(R.id.buttonB);
        buttonC = (Button) view.findViewById(R.id.buttonC);
        buttonD = (Button) view.findViewById(R.id.buttonD);
        buttonE = (Button) view.findViewById(R.id.buttonE);
        buttonF = (Button) view.findViewById(R.id.buttonF);


        //BUTTONS FOR SPECIAL FUNCTIONS



        // BUTTONS FOR OTHER CALCULATOR MODES
        button_basic = view.findViewById(R.id.btn_calculator_basic);
        button_scientific = view.findViewById(R.id.btn_calculator_scientific);

        // INPUT AND TEXT VIEWS FOR THE INPUT AND DISPLAYS OF THE CALCULATOR
        previous_operation = (TextView) view.findViewById(R.id.previous_operation);
        display_operation = (TextView) view.findViewById(R.id.display_operations);
        myEditText = (EditText) view.findViewById(R.id.input_text);

        //DISABLE SOFT KEYBOARD
        myEditText.setShowSoftInputOnFocus(false);
        myEditText.setInputType(InputType.TYPE_NULL);
        myEditText.setFocusable(false);



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

        //-------------- ON CLICK LISTENER FOR CALCULATOR MODES ------------------------

        button_scientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProgrammerFragment.this)
                        .navigate(R.id.action_programmerFragment_to_ScientificFragment);
            }
        });

        button_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProgrammerFragment.this)
                        .navigate(R.id.action_programmerFragment_to_BasicFragment);
            }
        });
    }
}
