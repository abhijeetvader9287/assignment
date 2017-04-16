package com.assignment.abhijeet.views;

import android.view.View;
import android.widget.TextView;

import com.assignment.abhijeet.MvpViewHolder;
import com.assignment.abhijeet.R;
import com.assignment.abhijeet.presenters.StudentPresenter;

/**
 * The type Student view holder.
 */
public class StudentViewHolder extends MvpViewHolder<StudentPresenter> implements StudentView {
    private final TextView student_percentage;
    private final TextView student_Name;

    /**
     * Instantiates a new Student view holder.
     *
     * @param itemView the item view
     */
    public StudentViewHolder(View itemView) {
        super(itemView);
        student_percentage = (TextView) itemView.findViewById(R.id.student_percentage);
        student_Name = (TextView) itemView.findViewById(R.id.student_Name);

    }

    @Override
    public void setSTUDENT_NAME(String STUDENT_NAME) {
        student_Name.setText( "STUDENT NAME: "+ STUDENT_NAME);
    }


    @Override
    public void setPERCENTAGE(Double PERCENTAGE) {
        student_percentage.setText("PERCENTAGE: "+Double.toString( PERCENTAGE));
    }

}
