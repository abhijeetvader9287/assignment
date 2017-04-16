/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.assignment.abhijeet.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * The type Student db helper.
 */
class StudentDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "student.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER = " INTEGER";

    private static final String DOUBLE = " DOUBLE";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +StudentEntry. TABLE_NAME + " (" + StudentEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    StudentEntry.  STUDENT_NAME + TEXT_TYPE + COMMA_SEP +
                    StudentEntry. MARATHI_MARKS + INTEGER + COMMA_SEP +
                    StudentEntry.  MATHS_MARKS + INTEGER + COMMA_SEP +
                    StudentEntry.  HISTORY_MARKS + INTEGER + COMMA_SEP +
                    StudentEntry.  PERCENTAGE + DOUBLE +
                    " )";

    /**
     * Instantiates a new Student db helper.
     *
     * @param context the context
     */
    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }
}
