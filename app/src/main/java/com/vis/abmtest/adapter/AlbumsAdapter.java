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
import com.vis.abmtest.listeners.AlbumItemClickListener;
import com.vis.abmtest.models.AlbumModel;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.SongsHolder> {

    private List<AlbumModel> mAlbumList;
    private final AlbumItemClickListener listener;

    public class SongsHolder extends RecyclerView.ViewHolder {

        public TextView mTitle, mSubTitle;
        public ImageView mAlbumImage;

        public SongsHolder(View view) {
            super(view);

            mTitle = view.findViewById(R.id.text_title);
            mSubTitle = view.findViewById(R.id.text_diaplayname);
            mAlbumImage = view.findViewById(R.id.album_image);
        }

        public void bind(final AlbumModel mItem, final AlbumItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(mItem);
                    }
                }
            });
        }
    }

    public AlbumsAdapter(List<AlbumModel> moviesList, AlbumItemClickListener itemClickListener) {
        this.mAlbumList = moviesList;
        this.listener = itemClickListener;
    }

    @Override
    public SongsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_songs_rowitem, parent, false);

        return new SongsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongsHolder holder, int position) {

        AlbumModel mItem = mAlbumList.get(position);

        holder.bind(mItem, listener);

        holder.mTitle.setText(mItem.getName());
        holder.mSubTitle.setText(mItem.getSongsCount() + " songs");

        Bitmap bm = BitmapFactory.decodeFile(mItem.getArt());

        holder.mAlbumImage.setImageBitmap(bm);

    }

    @Override
    public int getItemCount() {
        return mAlbumList.size();
    }
}