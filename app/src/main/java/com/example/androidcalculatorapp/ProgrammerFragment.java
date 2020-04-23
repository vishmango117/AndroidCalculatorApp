package com.example.androidcalculatorapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgrammerFragment extends Fragment {

    Button button_scientific, button_basic, button_unitconverter;

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

        button_basic = view.findViewById(R.id.btn_calculator_basic);
        button_scientific = view.findViewById(R.id.btn_calculator_scientific);

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
