package com.example.recyclerview;

import java.util.ArrayList;

public class PlaylistDeezer {
    private int id,nbTrack,fans;
    private String title,link,picture,pictureSmall,pictureMedium,pictureBig,pictureXL,trackList,creationDate,type;
    private int duration;
    private boolean publique,isLovedTrack,collaborative;
    private User creator;

    public int getNbTrack() {
        return nbTrack;
    }

    public int getFans() {
        return fans;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getPicture() {
        return picture;
    }

    public String getPictureSmall() {
        return pictureSmall;
    }

    public String getPictureMedium() {
        return pictureMedium;
    }

    public String getPictureBig() {
        return pictureBig;
    }

    public String getPictureXL() {
        return pictureXL;
    }

    public String getTrackList() {
        return trackList;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isPublique() {
        return publique;
    }

    public boolean isLovedTrack() {
        return isLovedTrack;
    }

    public boolean isCollaborative() {
        return collaborative;
    }

    public User getCreator() {
        return creator;
    }
}
