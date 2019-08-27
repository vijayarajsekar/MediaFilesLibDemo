package com.vis.abmtest.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vis.abmtest.R;
import com.vis.abmtest.listeners.AlbumDetailsListener;
import com.vis.abmtest.models.AlbumModel;
import com.vis.abmtest.models.AllSongsModel;
import com.vis.abmtest.utils.MediaLoader;

import java.util.List;

public class AlbumSongsFragment extends Fragment implements AlbumDetailsListener {

    private View mRootView;

    private Context mContext;

    public static AlbumDetailsListener mListener;

    private List<AllSongsModel> mSongsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.album_songs, container, false);

        mContext = getActivity();

        mListener = this;

        return mRootView;
    }

    @Override
    public void selectedAlbum(AlbumModel mModel) {

        Toast.makeText(getActivity(), "FRAGE " + mModel.getName(), Toast.LENGTH_SHORT).show();

        mSongsList = MediaLoader.getAllSongsBasedonAlbumId(mContext, mModel.getId());

        Log.d("Album Songs Size : ", "" + mSongsList.size());

    }
}