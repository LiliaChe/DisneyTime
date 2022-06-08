package com.example.disney_time02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class R_role extends AppCompatActivity {
    private Button btnPress;
    private ImageView imageVariable;
    private Button btnTryAgain, back;
    private TextView text;
    private enum variables {protagonists, antagonists, dynamic, round, flat, stock};
    private enum result {answer};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrole);
        setActionBar("");
        this.btnPress = findViewById(R.id.press);
        this.imageVariable = findViewById(R.id.imageVariable);
        this.btnTryAgain = findViewById(R.id.tryagain);
        this.back = findViewById(R.id.back);
        this.text = findViewById(R.id.text);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                imageVariable.setImageResource(R.drawable.question);
                text.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printResult();
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void printResult() {
        int num= (int)(Math.random() * 6);
        result result = getResult(makeShape(num),num);
    }
    @SuppressLint("SetTextI18n")
    public result getResult(variables variable, int num) {
        printShape(variable);
        text.setText(makeName(num));
        return result.answer;
    }
    public String makeName(int number) {
        switch (number) {
            case 0:
                return "Protagonists- the leading character in the story";
            case 1:
                return "Antagonists- one that contends with or opposes another";
            case 2:
                return "Dynamic- marked by usually continuous and productive activity or change a dynamic";
            case 3:
                return "Round- significant player who is often the star of the story";
            case 4:
                return "Flat- relatively uncomplicated and do not change throughout the story";
            default:
                return "Stock- a character that represents a type and that is recognizable as belonging to a certain genre";
        }
    }
    public variables makeShape(int number) {
        switch (number) {
            case 0:
                return variables.protagonists;
            case 1:
                return variables.antagonists;
            case 2:
                return variables.dynamic;
            case 3:
                return variables.round;
            case 4:
                return variables.flat;
            default:
                return variables.stock;
        }
    }

    public void printShape(variables variable) {
        switch (variable) {
            case protagonists:
                imageVariable.setImageResource(R.drawable.mickey);
                break;
            case antagonists:
                imageVariable.setImageResource(R.drawable.ursula);
                break;
            case dynamic:
                imageVariable.setImageResource(R.drawable.aladdin);
                break;
            case round:
                imageVariable.setImageResource(R.drawable.mulan);
                break;
            case flat:
                imageVariable.setImageResource(R.drawable.pocahontas);
                break;
            default:
                imageVariable.setImageResource(R.drawable.lady);
        }
    }
    public void setActionBar(String heading) {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(androidx.cardview.R.color.cardview_dark_background, null)));
        actionBar.setTitle(heading);
    }
}