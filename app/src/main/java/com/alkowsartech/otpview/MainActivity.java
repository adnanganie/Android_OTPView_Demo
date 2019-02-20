package com.alkowsartech.otpview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity {
    private Button btnSubmit;
    private OtpView optView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setButtonListener();
        setOTPListener();
    }

    private void init() {
        optView = findViewById(R.id.otp_view);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    private void setButtonListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, optView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOTPListener() {
        optView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                Toast.makeText(MainActivity.this, otp, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

