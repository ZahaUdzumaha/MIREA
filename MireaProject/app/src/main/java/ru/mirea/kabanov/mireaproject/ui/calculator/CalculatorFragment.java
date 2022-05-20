package ru.mirea.kabanov.mireaproject.ui.calculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.kabanov.mireaproject.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment {
    private Float firstDigit;
    private Float secondDigit;
    private String operation = null;
    private String actualOperation = null;
    private boolean flag = false;

    private FragmentCalculatorBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.button3.setOnClickListener(this::onNumberButtonClick);
        binding.button5.setOnClickListener(this::onNumberButtonClick);
        binding.button6.setOnClickListener(this::onNumberButtonClick);
        binding.button7.setOnClickListener(this::onNumberButtonClick);
        binding.button8.setOnClickListener(this::onNumberButtonClick);
        binding.button9.setOnClickListener(this::onNumberButtonClick);
        binding.button11.setOnClickListener(this::onNumberButtonClick);
        binding.button12.setOnClickListener(this::onNumberButtonClick);
        binding.button13.setOnClickListener(this::onNumberButtonClick);
        binding.button16.setOnClickListener(this::onNumberButtonClick);

        binding.buttonDivision.setOnClickListener(this::onOperationButtonClick);
        binding.buttonMinus.setOnClickListener(this::onOperationButtonClick);
        binding.buttonMultiplication.setOnClickListener(this::onOperationButtonClick);
        binding.buttonPlus.setOnClickListener(this::onOperationButtonClick);
        binding.buttonEquals.setOnClickListener(this::onOperationButtonClick);


        return root;
    }

    private void onNumberButtonClick(View v) {
        Button b = (Button) v;
        String text = binding.textCalc.getText().toString();
        if (text.equals("0")) {
            binding.textCalc.setText(b.getText());
        }
        else {
            binding.textCalc.setText(text + b.getText());
        }
    }


    private void onOperationButtonClick(View view) {
        if (flag){
            binding.textHistory.setText(null);
            flag = false;
        }
        String result = binding.textHistory.getText().toString();
        String text = binding.textCalc.getText().toString();
        if (operation == null) {
            binding.textHistory.setText(null);
            firstDigit = Float.parseFloat(text);
        } else {
            secondDigit = Float.parseFloat(text);
        }
        result += text;
        binding.textCalc.setText(null);
        Button button = (Button) view;
        operation = button.getText().toString();
        result += " " + operation + " ";

        if (operation.equals("=")) {
            Float resultText = calculate();
            binding.textCalc.setText(resultText.toString());
            firstDigit = null;
            secondDigit = null;
            operation = null;
            flag = true;
        } else {
            actualOperation = operation;
        }

        binding.textHistory.setText(result);
    }

    private Float calculate() {
        Float result = 0f;

        if (actualOperation.equals("+")) {
            result = firstDigit + secondDigit;
        } else if (actualOperation.equals("-")) {
            result = firstDigit - secondDigit;
        } else if (actualOperation.equals("*")) {
            result = firstDigit * secondDigit;
        } else if (actualOperation.equals("/")) {
            result = firstDigit / secondDigit;
        }

        return result;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}