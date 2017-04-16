package com.assignment.abhijeet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.assignment.abhijeet.presenters.BasePresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Mvp recycler adapter.
 *
 * @param <M>  the type parameter
 * @param <P>  the type parameter
 * @param <VH> the type parameter
 */
abstract class MvpRecyclerAdapter<M, P extends BasePresenter, VH extends MvpViewHolder> extends RecyclerView.Adapter<VH> {
    /**
     * The Presenters.
     */
    final Map<Object, P> presenters;

    /**
     * Instantiates a new Mvp recycler adapter.
     */
    MvpRecyclerAdapter() {
        presenters = new HashMap<>();
    }

    @NonNull
    private P getPresenter(@NonNull M model) {
        System.err.println("Getting presenter for item " + getModelId(model));
        return presenters.get(getModelId(model));
    }

    /**
     * Create presenter p.
     *
     * @param model the model
     * @return the p
     */
    @NonNull protected abstract P createPresenter(@NonNull M model);

    /**
     * Gets model id.
     *
     * @param model the model
     * @return the model id
     */
    @NonNull protected abstract Object getModelId(@NonNull M model);


    @Override
    public void onViewRecycled(VH holder) {
        super.onViewRecycled(holder);

        holder.unbindPresenter();
    }

    @Override
    public boolean onFailedToRecycleView(VH holder) {
        holder.unbindPresenter();

        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindPresenter(getPresenter(getItem(position)));
    }

    /**
     * Gets item.
     *
     * @param position the position
     * @return the item
     */
    protected abstract M getItem(int position);
}
