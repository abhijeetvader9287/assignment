package com.assignment.abhijeet.views;


import com.assignment.abhijeet.models.Student;

import java.util.List;

/**
 * The interface Main view.
 */
public interface MainView {
    /**
     * Show students.
     *
     * @param students the students
     */
    void showStudents(List<Student> students);

    /**
     * Show loading.
     */
    void showLoading();

    /**
     * Show empty.
     */
    void showEmpty();
}
