package com.vis.abmtest.utils;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.vis.abmtest.models.AlbumModel;
import com.vis.abmtest.models.AllSongsModel;

import java.util.ArrayList;
import java.util.List;

import static com.vis.abmtest.utils.Utils.PROJ_ALBUM;
import static com.vis.abmtest.utils.Utils.PROJ_ALBUM_IMAGE;
import static com.vis.abmtest.utils.Utils.PROJ_ALLSONG;
import static com.vis.abmtest.utils.Utils.SEL_ALBUM;
import static com.vis.abmtest.utils.Utils.SEL_ALBUM_ID;
import static com.vis.abmtest.utils.Utils.SEL_ALLSONG;
import static com.vis.abmtest.utils.Utils.URI_ALBUM;
import static com.vis.abmtest.utils.Utils.URI_AUDIO;

public class MediaLoader {

    /**
     * @param _mContext
     * @return All Audio Files
     */
    public static List<AllSongsModel> getAllSongs(Context _mContext) {

        List<AllSongsModel> mSongs = new ArrayList<>();

        Cursor cursor = _mContext.getContentResolver().query(
                URI_AUDIO,
                PROJ_ALLSONG,
                SEL_ALLSONG,
                null,
                null);

        if (cursor != null) {

            Log.d("~ COUNT ~ ", "" + cursor.getCount());

            while (cursor.moveToNext()) {

                mSongs.add(new AllSongsModel(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7), cursor.getString(8),
                        cursor.getString(9), cursor.getString(10), cursor.getString(11), getAllMusicPathLists(_mContext, cursor.getString(10))));

//                getAllMusicPathLists(_mContext, cursor.getString(10));
            }
        }

        return mSongs;
    }

    /**
     * @param _mContext
     * @return All Audio Files
     */
    public static List<AllSongsModel> getAllSongsBasedonAlbumId(Context _mContext, String _albumId) {

        List<AllSongsModel> mSongs = new ArrayList<>();

        Cursor cursor = _mContext.getContentResolver().query(
                URI_AUDIO,
                PROJ_ALLSONG,
                SEL_ALLSONG + " and " + SEL_ALBUM_ID + _albumId,
                null,
                null);

        if (cursor != null) {

            Log.d("~ COUNT ~ ", "" + cursor.getCount());

            while (cursor.moveToNext()) {

                mSongs.add(new AllSongsModel(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7), cursor.getString(8),
                        cursor.getString(9), cursor.getString(10), cursor.getString(11), getAllMusicPathLists(_mContext, cursor.getString(10))));
            }
        }

        return mSongs;
    }

    /**
     * @param context
     * @param _albumId
     * @return Album Art Based On AlbumId
     */
    public static String getAllMusicPathLists(Context context, String _albumId) {

        Cursor cursorAudio = context.getContentResolver().query(URI_ALBUM, PROJ_ALBUM_IMAGE, SEL_ALBUM_ID + _albumId, null, null);

        String albumCoverPath = "";

        if (cursorAudio != null && cursorAudio.moveToFirst()) {

            do {
                albumCoverPath = cursorAudio.getString(1);
                Log.d(" ~ URI ~ ", albumCoverPath);
            } while (cursorAudio.moveToNext());
        }

        return albumCoverPath;
    }


    public static List<AlbumModel> getAllAlbum(Context _mContext) {

        List<AlbumModel> mAllAlbums = new ArrayList<>();

        Cursor mCursorAlbum = _mContext.getContentResolver().query(URI_ALBUM, PROJ_ALBUM, null, null, SEL_ALBUM);

        if (mCursorAlbum != null) {

            Log.d("~ ALBUMS COUNT ~ ", "" + mCursorAlbum.getCount());

            while (mCursorAlbum.moveToNext()) {

                mAllAlbums.add(new AlbumModel(mCursorAlbum.getString(0), mCursorAlbum.getString(1), mCursorAlbum.getString(2),
                        mCursorAlbum.getString(3), mCursorAlbum.getString(4)));
            }
        }

        return mAllAlbums;
    }


//
//    public static ArrayList<CommonModel> getAllMusicPathList(Context context) {
//
//        ArrayList<CommonModel> musicPathArrList = new ArrayList<>();
//        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//
//        Cursor cursorAudio = context.getContentResolver().query(songUri, null, null, null, null);
//        if (cursorAudio != null && cursorAudio.moveToFirst()) {
//
//            Cursor cursorAlbum;
//            if (cursorAudio != null && cursorAudio.moveToFirst()) {
//
//                do {
//
//                    Long albumId = Long.valueOf(cursorAudio.getString(cursorAudio.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)));
//
//                    cursorAlbum = context.getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
//                            new String[]{MediaStore.Audio.Albums._ID, MediaStore.Audio.Albums.ALBUM_ART},
//                            MediaStore.Audio.Albums._ID + "=" + albumId, null, null);
//
//                    if (cursorAlbum != null && cursorAlbum.moveToFirst()) {
//
//                        String albumCoverPath = cursorAlbum.getString(cursorAlbum.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
//                        String data = cursorAudio.getString(cursorAudio.getColumnIndex(MediaStore.Audio.Media.DATA));
//
//                        musicPathArrList.add(new CommonModel(data, albumCoverPath, false, String.valueOf(albumId)));
//                    }
//
//                } while (cursorAudio.moveToNext());
//            }
//        }
//        return musicPathArrList;
//    }
}