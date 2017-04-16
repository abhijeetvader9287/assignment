
package com.assignment.abhijeet.models;

/**
 * The type Student.
 */
public final class Student {
   // String STUDENT_ID ;
   private String STUDENT_NAME;
    private Integer MARATHI_MARKS ;
    private Integer MATHS_MARKS;
    private Integer HISTORY_MARKS;
    private Double PERCENTAGE;

    /**
     * Gets student name.
     *
     * @return the student name
     */
    public String getSTUDENT_NAME() {
        return STUDENT_NAME;
    }

    /**
     * Sets student name.
     *
     * @param STUDENT_NAME the student name
     */
    public void setSTUDENT_NAME(String STUDENT_NAME) {
        this.STUDENT_NAME = STUDENT_NAME;
    }

    /**
     * Gets marathi marks.
     *
     * @return the marathi marks
     */
    public Integer getMARATHI_MARKS() {
        return MARATHI_MARKS;
    }

    /**
     * Sets marathi marks.
     *
     * @param MARATHI_MARKS the marathi marks
     */
    public void setMARATHI_MARKS(Integer MARATHI_MARKS) {
        this.MARATHI_MARKS = MARATHI_MARKS;
    }

    /**
     * Gets maths marks.
     *
     * @return the maths marks
     */
    public Integer getMATHS_MARKS() {
        return MATHS_MARKS;
    }

    /**
     * Sets maths marks.
     *
     * @param MATHS_MARKS the maths marks
     */
    public void setMATHS_MARKS(Integer MATHS_MARKS) {
        this.MATHS_MARKS = MATHS_MARKS;
    }

    /**
     * Gets history marks.
     *
     * @return the history marks
     */
    public Integer getHISTORY_MARKS() {
        return HISTORY_MARKS;
    }

    /**
     * Sets history marks.
     *
     * @param HISTORY_MARKS the history marks
     */
    public void setHISTORY_MARKS(Integer HISTORY_MARKS) {
        this.HISTORY_MARKS = HISTORY_MARKS;
    }

    /**
     * Gets percentage.
     *
     * @return the percentage
     */
    public Double getPERCENTAGE() {
        return PERCENTAGE;
    }

    /**
     * Sets percentage.
     *
     * @param PERCENTAGE the percentage
     */
    public void setPERCENTAGE(Double PERCENTAGE) {
        this.PERCENTAGE = PERCENTAGE;
    }

    /**
     * Instantiates a new Student.
     */
    public Student() {

    }

    /**
     * Instantiates a new Student.
     *
     * @param STUDENT_NAME  the student name
     * @param MARATHI_MARKS the marathi marks
     * @param MATHS_MARKS   the maths marks
     * @param HISTORY_MARKS the history marks
     * @param PERCENTAGE    the percentage
     */
    public Student(String STUDENT_NAME, Integer MARATHI_MARKS, Integer MATHS_MARKS, Integer HISTORY_MARKS, Double PERCENTAGE) {
        this.STUDENT_NAME = STUDENT_NAME;
        this.MARATHI_MARKS = MARATHI_MARKS;
        this.MATHS_MARKS = MATHS_MARKS;
        this.HISTORY_MARKS = HISTORY_MARKS;
        this.PERCENTAGE = PERCENTAGE;
    }


}
