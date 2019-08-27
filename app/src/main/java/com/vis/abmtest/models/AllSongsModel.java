package com.vis.abmtest.models;

public class AllSongsModel {

    private String mId;
    private String mTitle;
    private String mData;
    private String mDisplayName;
    private String mDutation;
    private String mDateAdded;
    private String mArtist;
    private String mArtistId;
    private String mArtistKey;
    private String mAlbum;
    private String mAlbumId;
    private String mAlbumKey;

    private String mAlbumUri;

    public AllSongsModel(String _id, String _title, String _data, String _displayName, String _duration, String _data_added, String _artist, String _artist_id, String _artist_key,
                         String _album, String _album_id, String _album_key, String _albumUri) {
        this.mId = _id;
        this.mTitle = _title;
        this.mData = _data;
        this.mDisplayName = _displayName;
        this.mDutation = _duration;
        this.mDateAdded = _data_added;
        this.mArtist = _artist;
        this.mArtistId = _artist_id;
        this.mArtistKey = _artist_key;
        this.mAlbum = _album;
        this.mAlbumId = _album_id;
        this.mAlbumKey = _album_key;
        this.mAlbumUri = _albumUri;

    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getData() {
        return mData;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getDutation() {
        return mDutation;
    }

    public String getDateAdded() {
        return mDateAdded;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getArtistId() {
        return mArtistId;
    }

    public String getArtistKey() {
        return mArtistKey;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getAlbumId() {
        return mAlbumId;
    }

    public String getAlbumKey() {
        return mAlbumKey;
    }

    public String getAlbumUri() {
        return mAlbumUri;
    }

}