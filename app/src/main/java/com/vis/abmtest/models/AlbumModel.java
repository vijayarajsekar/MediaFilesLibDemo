package com.vis.abmtest.models;

public class AlbumModel {

    private String aId;
    private String aName;
    private String aArtist;
    private String aArt;
    private String aSongsCount;


    public AlbumModel(String alb_id, String alb_name, String alb_artist, String alb_art, String alb_songs_count) {

        this.aId = alb_id;
        this.aName = alb_name;
        this.aArtist = alb_artist;
        this.aArt = alb_art;
        this.aSongsCount = alb_songs_count;

    }

    public String getId() {
        return aId;
    }

    public String getName() {
        return aName;
    }

    public String getArtist() {
        return aArtist;
    }

    public String getArt() {
        return aArt;
    }

    public String getSongsCount() {
        return aSongsCount;
    }

}
