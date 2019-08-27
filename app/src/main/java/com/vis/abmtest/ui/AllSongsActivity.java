package com.vis.abmtest.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vis.abmtest.utils.MediaLoader;
import com.vis.abmtest.R;
import com.vis.abmtest.adapter.AllSongsAdapter;
import com.vis.abmtest.models.AllSongsModel;

import java.util.ArrayList;
import java.util.List;

public class AllSongsActivity extends AppCompatActivity {

    private Context mContext;

    private List<AllSongsModel> mSongsList;

    private RecyclerView recyclerView;
    private AllSongsAdapter mAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_songs);

        mContext = this;

        mSongsList = new ArrayList<>();

        getMediaFiles();

        recyclerView = findViewById(R.id.songs_list);

        mAdapter = new AllSongsAdapter(mSongsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

    }

    private void getMediaFiles() {

        mSongsList = MediaLoader.getAllSongs(mContext);

        Log.d("Songs List Size ", "" + mSongsList.size());

    }
}