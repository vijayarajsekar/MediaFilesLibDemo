package com.vis.abmtest.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vis.abmtest.Fragments.AlbumSongsFragment;
import com.vis.abmtest.R;
import com.vis.abmtest.adapter.AlbumsAdapter;
import com.vis.abmtest.listeners.AlbumItemClickListener;
import com.vis.abmtest.models.AlbumModel;
import com.vis.abmtest.utils.MediaLoader;

import java.util.ArrayList;
import java.util.List;

public class AlbumsActivity extends AppCompatActivity {

    private Context mContext;

    private List<AlbumModel> mAlbumsModel;

    private RecyclerView recyclerView;
    private AlbumsAdapter mAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_albums);

        mContext = this;


        mAlbumsModel = new ArrayList<>();

        getAllAlbum();

        recyclerView = findViewById(R.id.albums_list);

        mAdapter = new AlbumsAdapter(mAlbumsModel, new AlbumItemClickListener() {
            @Override
            public void onItemClick(AlbumModel item) {
                if (AlbumSongsFragment.mListener != null)
                    AlbumSongsFragment.mListener.selectedAlbum(item);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

    }

    private void getAllAlbum() {

        mAlbumsModel = MediaLoader.getAllAlbum(mContext);

        Log.d("Album List Size ", "" + mAlbumsModel.size());

    }
}