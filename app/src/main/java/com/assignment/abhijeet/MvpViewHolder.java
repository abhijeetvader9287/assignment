package com.assignment.abhijeet;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.assignment.abhijeet.presenters.BasePresenter;


/**
 * The type Mvp view holder.
 *
 * @param <P> the type parameter
 */
public abstract class MvpViewHolder<P extends BasePresenter> extends RecyclerView.ViewHolder {
    private P presenter;

    /**
     * Instantiates a new Mvp view holder.
     *
     * @param itemView the item view
     */
    protected MvpViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Bind presenter.
     *
     * @param presenter the presenter
     */
    public void bindPresenter(P presenter) {
        this.presenter = presenter;
        presenter.bindView(this);
    }

    /**
     * Unbind presenter.
     */
    public void unbindPresenter() {
        presenter = null;
    }
}
