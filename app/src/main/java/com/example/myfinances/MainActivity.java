package com.example.myfinances;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editAccountNumber, editInitialBalance, editCurrentBalance, editInterestRate, editPaymentAmount;
    private RadioGroup radioGroup;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editAccountNumber = findViewById(R.id.editAccountNumber);
        editInitialBalance = findViewById(R.id.editInitialBalance);
        editCurrentBalance = findViewById(R.id.editCurrentBalance);
        editInterestRate = findViewById(R.id.editInterestRate);
        editPaymentAmount = findViewById(R.id.editPaymentAmount);
        radioGroup = findViewById(R.id.radioGroup);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }
    private void saveData() {
        // Retrieve data from input fields
        String accountNumber = editAccountNumber.getText().toString();
        String initialBalance = editInitialBalance.getText().toString();
        String currentBalance = editCurrentBalance.getText().toString();
        String interestRate = editInterestRate.getText().toString();
        String paymentAmount = editPaymentAmount.getText().toString();

        int selectedId = radioGroup.getCheckedRadioButtonId();
        String accountType = "";
        if (selectedId == R.id.buttonCD) {
            accountType = "CDs";
        } else if (selectedId == R.id.buttonLoans) {
            accountType = "Loans";
        } else if (selectedId == R.id.buttonCheckingAccounts) {
            accountType = "Checking Accounts";
        } else {
            Toast.makeText(this, "Please select an account type.", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Data Saved for " + accountType, Toast.LENGTH_SHORT).show();
    }
    private void clearFields() {
        // Clear all input fields
        editAccountNumber.setText("");
        editInitialBalance.setText("");
        editCurrentBalance.setText("");
        editInterestRate.setText("");
        editPaymentAmount.setText("");
        radioGroup.clearCheck();
    }
}