package com.josse.emile.mynews.Model;

public class ArticlePojo {
    private String imageUrl;
    private String title;
    private String articleUrl;
    private String date;

    public ArticlePojo(String imageUrl, String title, String articleUrl, String date) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.articleUrl = articleUrl;
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
