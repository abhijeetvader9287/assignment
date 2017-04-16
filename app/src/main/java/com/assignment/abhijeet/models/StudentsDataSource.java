
package com.assignment.abhijeet.models;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * The interface Students data source.
 */
interface StudentsDataSource {

    /**
     * Gets students.
     *
     * @return the students
     */
    List<Student> getStudents();

    /**
     * Save student boolean.
     *
     * @param Student the student
     * @return the boolean
     */
    boolean saveStudent(@NonNull Student Student);

    /**
     * Check student boolean.
     *
     * @param StudentName the student name
     * @return the boolean
     */
    boolean checkStudent(@NonNull String StudentName);

}
