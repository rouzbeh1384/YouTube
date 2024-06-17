package com.example.youtube.Model;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Video {
    private String ID;
    private LocalDate uploadTime;
    private Integer view;
    private LocalDate duration; //??
    private Integer like;
    private Integer deslike;
    private String name;
    private String description;
    private ArrayList<String> hashtags;
    private Video(String ID,String name,String description,String uplaodTime,
                  String duration,Integer like,Integer deslike,Integer view,String hashtags) {
        this.name = name;
        this.description = description;
        this.view = view;
        this.like = like;
        this.deslike = deslike;
        this.uploadTime = LocalDate.parse(uplaodTime);
        this.duration=LocalDate.parse(duration); //format???
        this.ID=ID;
        this.hashtags=new ArrayList<>(Arrays.asList(hashtags.split(",")));
    }

    public String getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDeslike() {
        return deslike;
    }

    public String getName() {
        return name;
    }

    public Integer getLike() {
        return like;
    }

    public Integer getView() {
        return view;
    }

    public LocalDate getDuration() {
        return duration;
    }

    public LocalDate getUploadTime() {
        return uploadTime;
    }

    public ArrayList<String> getHashtagsList() {
        return hashtags;
    }

    public void editName(String name) {
        this.name = name;
    }

    public void editDescription(String description) {
        this.description = description;
    }

    public void Deslike(Integer change) {
        this.deslike += change;
    }

    public void Like(Integer change) {
        this.like += change;
    }

    public void appendView() {
        this.view ++;
    }

    public void addHashtags(String hashtag) {
        this.hashtags.add(hashtag);
    }
    public void removeHashtag(String hashtag){
        this.hashtags.remove(hashtag);
    }
    public String getHashtagString(){
        String hashtags="";
        for(String hashtag : this.hashtags){
             hashtags += hashtag+",";
        }
        return (hashtags.substring(0,hashtags.length()-1)); // -1 or -2 ??
    }
}
