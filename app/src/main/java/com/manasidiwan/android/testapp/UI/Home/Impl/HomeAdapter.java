package com.manasidiwan.android.testapp.UI.Home.Impl;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.R;
import com.manasidiwan.android.testapp.UI.Home.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.RoboGuice;

/**
 * @author manasidiwan on 01/08/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HomePresenter mPresenter;
    private Context mContext;
    private List<Movie> mListData;
    private static final int HEADER = 0;
    private static final int LIST_ITEM = 1;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.movie_title)
        public TextView mMovieTitle;

        @Bind(R.id.item_image)
        public SimpleDraweeView mImageView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public HomeAdapter(Context context, HomePresenter presenter) {
        mPresenter = presenter;
        mContext = context.getApplicationContext();
        RoboGuice.getInjector(context).injectMembers(this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = mListData.get(viewHolder.getAdapterPosition());
                mPresenter.movieClicked(movie);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).mMovieTitle.setText(mListData.get(position).getTitle());
            Uri imageUri = Uri.parse(mListData.get(position).getPoster());
            ((ViewHolder) holder).mImageView.setImageURI(imageUri);
        }
    }

    @Override
    public int getItemCount() {
        return (mListData == null) ? 0 : mListData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == HEADER) {
            return HEADER;
        } else {
            return LIST_ITEM;
        }
    }

    public void setNewData(List<Movie> data) {
        mListData = data;
        notifyDataSetChanged();
    }
}
