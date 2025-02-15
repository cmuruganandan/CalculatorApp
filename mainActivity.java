package com.gfg.calculator_java;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText e1, e2;
    TextView t1;
    int num1, num2;

    public boolean getNumbers() {
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        t1 = findViewById(R.id.result);

        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            t1.setText("Error: Please enter both values");
            return false;
        }

        num1 = Integer.parseInt(s1);
        num2 = Integer.parseInt(s2);

        return true;
    }

    public void doSum(View v) {
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void clearTextNum1(View v) {
        e1.getText().clear();
    }

    public void clearTextNum2(View v) {
        e2.getText().clear();
    }

    public void doPow(View v) {
        if (getNumbers()) {
            double sum = Math.pow(num1, num2);
            t1.setText(Double.toString(sum));
        }
    }

    public void doSub(View v) {
        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void doMul(View v) {
        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void doDiv(View v) {
        if (getNumbers()) {
            if (num2 == 0) {
                t1.setText("Error: Division by zero");
            } else {
                double sum = num1 / (num2 * 1.0);
                t1.setText(Double.toString(sum));
            }
        }
    }

    public void doMod(View v) {
        if (getNumbers()) {
            double sum = num1 % num2;
            t1.setText(Double.toString(sum));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
    }
}
/// web interface configurartion ///
// Define an interface for the API
public interface CalculatorApi {
    @GET("calculate")
    Call<Double> calculate(@Query("num1") int num1, @Query("num2") int num2, @Query("operation") String operation);
}

