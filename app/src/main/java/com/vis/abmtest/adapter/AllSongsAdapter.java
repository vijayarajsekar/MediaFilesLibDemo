package com.vis.abmtest.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vis.abmtest.R;
import com.vis.abmtest.models.AllSongsModel;

import java.util.List;

public class AllSongsAdapter extends RecyclerView.Adapter<AllSongsAdapter.SongsHolder> {

    private List<AllSongsModel> mSongsList;

    public class SongsHolder extends RecyclerView.ViewHolder {

        public TextView mTitle, mSubTitle;
        public ImageView mAlbumImage;

        public SongsHolder(View view) {
            super(view);

            mTitle = view.findViewById(R.id.text_title);
            mSubTitle = view.findViewById(R.id.text_diaplayname);
            mAlbumImage = view.findViewById(R.id.album_image);
        }
    }

    public AllSongsAdapter(List<AllSongsModel> moviesList) {
        this.mSongsList = moviesList;
    }

    @Override
    public SongsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_songs_rowitem, parent, false);

        return new SongsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongsHolder holder, int position) {

        mSongsList.get(position);

        holder.mTitle.setText(mSongsList.get(position).getTitle());
        holder.mSubTitle.setText(mSongsList.get(position).getDisplayName());

        Bitmap bm = BitmapFactory.decodeFile(mSongsList.get(position).getAlbumUri());

        holder.mAlbumImage.setImageBitmap(bm);

    }

    @Override
    public int getItemCount() {
        return mSongsList.size();
    }
}