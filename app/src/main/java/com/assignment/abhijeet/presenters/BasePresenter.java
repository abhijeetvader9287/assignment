package com.assignment.abhijeet.presenters;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * The type Base presenter.
 *
 * @param <M> the type parameter
 * @param <V> the type parameter
 */
public abstract class BasePresenter<M, V> {
    /**
     * The Model.
     */
    M model;
    private WeakReference<V> view;

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(M model) {
        resetState();
        this.model = model;
        if (setupDone()) {
            updateView();
        }
    }

    private void resetState() {
    }

    /**
     * Bind view.
     *
     * @param view the view
     */
    public void bindView(@NonNull V view) {
        this.view = new WeakReference<>(view);
        if (setupDone()) {
            updateView();
        }
    }

    /**
     * Unbind view.
     */
    public void unbindView() {
        this.view = null;
    }

    /**
     * View v.
     *
     * @return the v
     */
    V view() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    /**
     * Update view.
     */
    protected abstract void updateView();

    private boolean setupDone() {
        return view() != null && model != null;
    }
}
