package com.jikexueyuan.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int randomNum = random.nextInt(100);

    private EditText editText;
    private TextView result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.result);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inputNum;
                if (!(TextUtils.isEmpty(editText.getText()))) {

                    inputNum = Integer.parseInt(editText.getText().toString());
                    if (inputNum < 0 || inputNum >= 100) {
                        result.setText("请输入一个0到100之间[0,100)的整数");
                        button1.setClickable(true);
                    } else if (inputNum < randomNum) {
                        result.setText("输入的数字小了");
                        button1.setClickable(true);
                    } else if (inputNum > randomNum) {
                        result.setText("输入的数字大了");
                        button1.setClickable(true);
                    } else if (inputNum == randomNum) {
                        result.setText("正确");
                    }
                } else {
                    result.setText("请输入一个0到100之间[0,100)的整数");
                }

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum = random.nextInt(100);
                editText.setText("");
                result.setText("");
                button1.setClickable(true);
            }
        });
    }
}
