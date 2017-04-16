package com.assignment.abhijeet.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.assignment.abhijeet.models.Student;
import com.assignment.abhijeet.models.StudentLocalDataSource;
import com.assignment.abhijeet.views.MainView;

import java.util.List;

/**
 * The type Main presenter.
 */
public class MainPresenter extends BasePresenter<List<Student>, MainView> {
    private boolean isLoadingData = false;
    private final Context context;

    /**
     * Instantiates a new Main presenter.
     *
     * @param context the context
     */
    public MainPresenter(Context context) {
        this.context = context;
    }

    @Override
    protected void updateView() {
        if (model.size() == 0) {
            view().showEmpty();
        } else {
            view().showStudents(model);
        }
    }

    @Override
    public void bindView(@NonNull MainView view) {
        super.bindView(view);
        if (!isLoadingData) {
            view().showLoading();
            loadData();
        }
    }

    private void loadData() {
        isLoadingData = true;
        setModel(StudentLocalDataSource.getInstance(context).getStudents());
    }


}
