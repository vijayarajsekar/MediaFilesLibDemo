package com.vis.abmtest.utils;

import android.net.Uri;
import android.provider.MediaStore;

public class Utils {

    // Audio Uri
    public static final Uri URI_AUDIO = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

    // Audio Uri
    public static final Uri URI_ALBUM = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;


    /**
     * Display All songs
     */
    public static final String SEL_ALLSONG = MediaStore.Audio.Media.IS_MUSIC + " != 0";


    public static final String[] PROJ_ALLSONG = new String[]
            {
                    MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA,
                    MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.DATE_ADDED,
                    MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ARTIST_ID, MediaStore.Audio.Media.ARTIST_KEY,
                    MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ALBUM_ID, MediaStore.Audio.Media.ALBUM_KEY
            };

    /**
     * Display Album Images
     */

    public static final String[] PROJ_ALBUM_IMAGE = new String[]
            {
                    MediaStore.Audio.Albums._ID, MediaStore.Audio.Albums.ALBUM_ART
            };

    public static final String SEL_ALBUM_ID = MediaStore.Audio.Albums._ID + "=";

    /**
     *
     */
    public static final String SEL_ALBUM = MediaStore.Audio.Media.ALBUM + " ASC";

    public static final String[] PROJ_ALBUM = new String[]
            {
                    MediaStore.Audio.Albums._ID, MediaStore.Audio.Albums.ALBUM, MediaStore.Audio.Albums.ARTIST,
                    MediaStore.Audio.Albums.ALBUM_ART, MediaStore.Audio.Albums.NUMBER_OF_SONGS
            };
}