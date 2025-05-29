package com.mylifeserver.pojo;


public class Note {
    private String account;
    private String uuid;
    private String title;
    private String content;
    private String date;
    private String mood;
    private String weather;

    public Note() {}

    public Note(String account,String uuid,String title, String content, String date, String mood, String weather) {
        this.account = account;
        this.title = title;
        this.uuid= uuid;
        this.content = content;
        this.date = date;
        this.mood = mood;
        this.weather = weather;
    }

    // Getters and Setters
    public String getUuid() { return uuid; }
    public void setId(String id) { this.uuid = uuid; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }
    public String getWeather() { return weather; }
    public void setWeather(String weather) { this.weather = weather; }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
