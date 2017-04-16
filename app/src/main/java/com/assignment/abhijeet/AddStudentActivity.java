package com.assignment.abhijeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.assignment.abhijeet.models.Student;
import com.assignment.abhijeet.models.StudentLocalDataSource;


/**
 * The type Add student activity.
 */
public class AddStudentActivity extends AppCompatActivity {
    private EditText editTextStudentName;
    private EditText editTextMarathiMarks;
    private EditText editTextMathsMarks;
    private EditText editTextHistoryMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        Button btnAdd_Student = (Button) findViewById(R.id.btnAdd_Student);
        editTextStudentName = (EditText) findViewById(R.id.editTextStudentName);
        editTextHistoryMarks = (EditText) findViewById(R.id.editTextHistoryMarks);
        editTextMarathiMarks = (EditText) findViewById(R.id.editTextMarathiMarks);
        editTextMathsMarks = (EditText) findViewById(R.id.editTextMathsMarks);
        btnAdd_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                boolean isValid = true;
                String studentName = editTextStudentName.getText().toString();
                String strhistoryMarks = editTextHistoryMarks.getText().toString();
                String strmararathiMarks = editTextMarathiMarks.getText().toString();
                String strmathsMarks = editTextMathsMarks.getText().toString();
                if (studentName.isEmpty()) {
                    isValid = false;
                    Toast.makeText(AddStudentActivity.this, "Student Name can't be blank", Toast.LENGTH_LONG).show();
                } else {
                    student.setSTUDENT_NAME(studentName);
                }
                try {
                    Integer marathiMarks = Integer.parseInt(strmararathiMarks);
                    if (marathiMarks <= 100 && marathiMarks > -1) {
                        student.setMARATHI_MARKS(marathiMarks);
                    } else {
                        Toast.makeText(AddStudentActivity.this, "Marks should be non-negative and less than 100", Toast.LENGTH_LONG).show();
                        isValid = false;
                    }
                    Integer historyMarks = Integer.parseInt(strhistoryMarks);
                    if (historyMarks <= 100 && historyMarks > -1) {
                        student.setHISTORY_MARKS(historyMarks);
                    } else {
                        Toast.makeText(AddStudentActivity.this, "Marks should be non-negative and less than 100", Toast.LENGTH_LONG).show();
                        isValid = false;
                    }
                    Integer mathsMarks = Integer.parseInt(strmathsMarks);
                    if (mathsMarks <= 100 && mathsMarks > -1) {
                        student.setMATHS_MARKS(mathsMarks);
                    } else {
                        Toast.makeText(AddStudentActivity.this, "Marks should be non-negative and less than 100", Toast.LENGTH_LONG).show();
                        isValid = false;
                    }

                } catch (Exception ex) {
                    isValid = false;
                    Toast.makeText(AddStudentActivity.this, "Marks should be numbers", Toast.LENGTH_LONG).show();

                }
                if (isValid) {
                    if(StudentLocalDataSource.getInstance(AddStudentActivity.this).checkStudent(student.getSTUDENT_NAME()))
                    {
                  if(  StudentLocalDataSource.getInstance(AddStudentActivity.this).saveStudent(student))
                  {
                      Toast.makeText(AddStudentActivity.this, "Saved Successfully", Toast.LENGTH_LONG).show();

                  }
                  else
                  {
                      Toast.makeText(AddStudentActivity.this, "Error in Saving", Toast.LENGTH_LONG).show();

                  }
                }
                else
                    {
                        Toast.makeText(AddStudentActivity.this, "Already student exists with this name", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_student_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuShowAll:
                Intent showAllStudents = new Intent(AddStudentActivity.this, MainActivity.class);
                startActivity(showAllStudents);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
