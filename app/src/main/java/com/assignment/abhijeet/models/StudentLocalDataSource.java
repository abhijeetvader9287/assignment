
package com.assignment.abhijeet.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The type Student local data source.
 */
public class StudentLocalDataSource implements StudentsDataSource {

    private static StudentLocalDataSource INSTANCE;

    private final StudentDbHelper mDbHelper;

    private StudentLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mDbHelper = new StudentDbHelper(context);
    }

    /**
     * Gets instance.
     *
     * @param context the context
     * @return the instance
     */
    public static StudentLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new StudentLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                StudentEntry.STUDENT_NAME,
                StudentEntry.MATHS_MARKS,
                StudentEntry.MARATHI_MARKS,
                StudentEntry.HISTORY_MARKS,
                StudentEntry.PERCENTAGE

        };
        Cursor c = db.query(
                StudentEntry.TABLE_NAME, projection, null, null, null, null, StudentEntry.PERCENTAGE + " DESC");
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String STUDENT_NAME = c.getString(c.getColumnIndexOrThrow(StudentEntry.STUDENT_NAME));
                Integer MARATHI_MARKS =
                        c.getInt(c.getColumnIndexOrThrow(StudentEntry.MARATHI_MARKS));
                Integer MATHS_MARKS =
                        c.getInt(c.getColumnIndexOrThrow(StudentEntry.MATHS_MARKS));
                Integer HISTORY_MARKS =
                        c.getInt(c.getColumnIndexOrThrow(StudentEntry.HISTORY_MARKS));
                Double PERCENTAGE =
                        c.getDouble(c.getColumnIndexOrThrow(StudentEntry.PERCENTAGE));
                Student student = new Student(STUDENT_NAME, MARATHI_MARKS, MATHS_MARKS, HISTORY_MARKS, PERCENTAGE);
                students.add(student);
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return students;
    }


    @Override
    public boolean saveStudent(@NonNull Student student) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        try {
            checkNotNull(student);
            ContentValues values = new ContentValues();
            values.put(StudentEntry.STUDENT_NAME, student.getSTUDENT_NAME());
            values.put(StudentEntry.MARATHI_MARKS, student.getMARATHI_MARKS());
            values.put(StudentEntry.MATHS_MARKS, student.getMATHS_MARKS());
            values.put(StudentEntry.HISTORY_MARKS, student.getHISTORY_MARKS());
            Integer totalMarks = student.getHISTORY_MARKS() + student.getMARATHI_MARKS() + student.getMATHS_MARKS();
            Double percentage = Double.valueOf(((totalMarks * 100) / 300));
            student.setPERCENTAGE(percentage);
            values.put(StudentEntry.PERCENTAGE, student.getPERCENTAGE());
            db.insert(StudentEntry.TABLE_NAME, null, values);
            db.close();
            return true;
        } catch (Exception ex) {
            db.close();
            return false;
        }
    }

    @Override
    public boolean checkStudent(@NonNull String studentName) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                StudentEntry.STUDENT_NAME,
                StudentEntry.MATHS_MARKS,
                StudentEntry.MARATHI_MARKS,
                StudentEntry.HISTORY_MARKS

        };
        String selection = StudentEntry.STUDENT_NAME + " LIKE ?";
        String[] selectionArgs = {studentName};
        Cursor c = db.query(
                StudentEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        Student student = null;
        if (c != null && c.getCount() > 0) {
            if (c != null) {
                c.close();
            }
            db.close();
            return false;
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return true;
    }


}
