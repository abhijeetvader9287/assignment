package com.assignment.abhijeet;


import com.assignment.abhijeet.presenters.BasePresenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Mvp recycler list adapter.
 *
 * @param <M>  the type parameter
 * @param <P>  the type parameter
 * @param <VH> the type parameter
 */
public abstract class MvpRecyclerListAdapter<M, P extends BasePresenter, VH extends MvpViewHolder<P>> extends MvpRecyclerAdapter<M, P, VH> {
    private final List<M> models;

    /**
     * Instantiates a new Mvp recycler list adapter.
     */
    MvpRecyclerListAdapter() {
        models = new ArrayList<>();
    }

    /**
     * Clear and add all.
     *
     * @param data the data
     */
    public void clearAndAddAll(Collection<M> data) {
        models.clear();
        presenters.clear();

        for (M item : data) {
            addInternal(item);
        }

        notifyDataSetChanged();
    }


    private void addInternal(M item) {
        System.err.println("Adding item " + getModelId(item));
        models.add(item);
        presenters.put(getModelId(item), createPresenter(item));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    protected M getItem(int position) {
        return models.get(position);
    }
}
