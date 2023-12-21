package com.example.taskagitmakas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String playerChoice = button.getText().toString();
        String computerChoice = getRandomChoice();
        String result = determineWinner(playerChoice, computerChoice);

        resultText.setText("Sonuç: Sen " + playerChoice + " seçtin, Bilgisayar " + computerChoice + " seçti. " + result);
    }

    private String getRandomChoice() {
        String[] choices = {"Taş", "Kağıt", "Makas"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Berabere!";
        } else if ((playerChoice.equals("Taş") && computerChoice.equals("Makas")) ||
                (playerChoice.equals("Kağıt") && computerChoice.equals("Taş")) ||
                (playerChoice.equals("Makas") && computerChoice.equals("Kağıt"))) {
            return "Kazandın!";
        } else {
            return "Kaybettin!";
        }
    }
}