package com.relfor.mydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmpActivity extends AppCompatActivity {
    EditText edtEmpName, edtEmpAddress, edtEmpPhone, edtEmpSalary;
    Button btnSave;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);

        edtEmpName = findViewById(R.id.edtEmpName);
        edtEmpAddress = findViewById(R.id.edtEmpAddress);
        edtEmpPhone = findViewById(R.id.edtEmpPhone);
        edtEmpSalary = findViewById(R.id.edtEmpSalary);

        btnSave = findViewById(R.id.btnSave);

        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtEmpName.getText().toString().trim();

                String address = edtEmpAddress.getText().toString().trim();
                String phone = edtEmpPhone.getText().toString().trim();
                String salary = edtEmpSalary.getText().toString().trim();

                double empSalary = Double.parseDouble(salary);

                Employee employee = new Employee();
                employee.setEmpName(name);
                employee.setEmpAddress(address);
                employee.setEmpPhone(phone);
                employee.setEmpSalary(empSalary);
               boolean isInserted = dbHelper.addEmployee(employee);
               if(isInserted){
                   edtEmpSalary.setText("");
                   edtEmpName.setText("");
                   edtEmpPhone.setText("");
                   edtEmpAddress.setText("");
                   Toast.makeText(getBaseContext(), "Emplyee details inserted", Toast.LENGTH_LONG).show();
               }

            }
        });
    }
}