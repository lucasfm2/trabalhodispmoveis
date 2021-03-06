package com.ucsal.trabalhodispmoveis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ucsal.trabalhodispmoveis.repositories.StudentRepository;

public class DeleteStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
    }

    public void deleteButtonPressed(View view) {
        EditText editText = findViewById(R.id.deleteEditText);
        String text = editText.getText().toString();
        int deleted = StudentRepository.deleteUsingName(text);
        Toast.makeText(this, deleted +" records deleted", Toast.LENGTH_SHORT).show();
        editText.setText("");
    }
}
