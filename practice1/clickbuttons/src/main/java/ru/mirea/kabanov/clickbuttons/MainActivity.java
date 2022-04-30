package ru.mirea.kabanov.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private TextView tvOut;
    private Button buttonCancel;
    private Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_buttons);
        tvOut = (TextView) findViewById(R.id.tvOut);
        buttonOk = (Button) findViewById(R.id.btnOk);
        buttonCancel = (Button) findViewById(R.id.btnCancel);
        View.OnClickListener oclBtnOk = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tvOut.setText("Нажата кнопка ОК");
            }
        };
        buttonOk.setOnClickListener(oclBtnOk);
    }
    public void onMyButtonClick(View view)
    {
        tvOut.setText("Нажата кнопка Cancel");
        Toast.makeText(this, "Ещё один способ!", Toast.LENGTH_SHORT).show();
    }
}