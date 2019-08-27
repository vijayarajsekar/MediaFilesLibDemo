package com.vis.abmtest.models;

public class CommonModel {

    private String path;
    private String albumId;
    private boolean selected;

    public String getAlbumCoverPath() {
        return albumCoverPath;
    }

    public String getAlbumid() {
        return albumId;
    }

    private String albumCoverPath;

    public CommonModel(String path, String albumCoverPath, boolean b, String albumid) {
        this.path = path;
        this.albumCoverPath = albumCoverPath;
        this.selected = b;
        this.albumId = albumid;
    }

    public String getPath() {
        return path;
    }

    public boolean getSelected() {
        return selected;
    }

}