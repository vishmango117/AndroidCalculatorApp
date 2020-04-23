package com.example.androidcalculatorapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ScientificFragment extends Fragment {

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

        button_basic = view.findViewById(R.id.btn_calculator_basic);
        button_programmer = view.findViewById(R.id.btn_calculator_programmer);

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
