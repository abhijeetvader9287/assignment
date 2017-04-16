package com.assignment.abhijeet.models;

import android.provider.BaseColumns;

/**
 * The type Student entry.
 */
abstract class StudentEntry implements BaseColumns {
    /**
     * The constant TABLE_NAME.
     */
    public static final String TABLE_NAME = "students";
    /**
     * The constant STUDENT_NAME.
     */
    public static final String STUDENT_NAME = "STUDENT_NAME";
    /**
     * The constant MATHS_MARKS.
     */
    public static final String MATHS_MARKS = "MATHS_MARKS";
    /**
     * The constant MARATHI_MARKS.
     */
    public static final String MARATHI_MARKS = "MARATHI_MARKS";
    /**
     * The constant HISTORY_MARKS.
     */
    public static final String HISTORY_MARKS = "HISTORY_MARKS";
    /**
     * The constant PERCENTAGE.
     */
    public static final String PERCENTAGE = "PERCENTAGE";

}