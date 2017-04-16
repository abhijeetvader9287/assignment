package com.assignment.abhijeet.presenters;


import com.assignment.abhijeet.models.Student;
import com.assignment.abhijeet.views.StudentView;

/**
 * The type Student presenter.
 */
public class StudentPresenter extends BasePresenter<Student, StudentView> {

    @Override
    protected void updateView() {
        view().setSTUDENT_NAME(model.getSTUDENT_NAME());
         view().setPERCENTAGE(model.getPERCENTAGE());
    }

}
