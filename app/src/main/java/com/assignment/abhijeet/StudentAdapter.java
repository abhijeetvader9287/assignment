package com.assignment.abhijeet;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.assignment.abhijeet.models.Student;
import com.assignment.abhijeet.presenters.StudentPresenter;
import com.assignment.abhijeet.views.StudentViewHolder;

/**
 * The type Student adapter.
 */
public class StudentAdapter extends MvpRecyclerListAdapter<Student, StudentPresenter, StudentViewHolder> {
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false));
    }

    @NonNull
    @Override
    protected StudentPresenter createPresenter(@NonNull Student student) {
        StudentPresenter presenter = new StudentPresenter();
        presenter.setModel(student);
        return presenter;
    }

    @NonNull
    @Override
    protected Object getModelId(@NonNull Student model) {
        return model.getSTUDENT_NAME();
    }
}
