package com.practise.googlenewspractiseusingmvvm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Articles {

 @SerializedName("source")
 @Expose
 private source source;


 @SerializedName("author")
 @Expose
 private String author;
 @SerializedName("title")
 @Expose
 private String title;
 @SerializedName("description")
 @Expose
 private String description;

 private String url;
 private String urlToImage;
 private String publishedAt;
 private String content;

/* author : "Gina Kolata"
 title : "Alzheimer’s Tests Soon May Be Common. Should You Get One? - The New York Times"
 description : "Diagnostic tests for Alzheimer’s disease are already here. But the results may raise as many questions as they answer."
 url : "https://www.nytimes.com/2019/12/20/health/alzheimers-disease-diagnosis.html"
 urlToImage : "https://static01.nyt.com/images/2019/12/20/science/20SCI-ALZHEIMERS01/20SCI-ALZHEIMERS01-facebookJumbo.jpg"
 publishedAt : "2019-12-21T01:56:00Z"
 content : "So he received brain scan*/

 public String getAuthor() {
  return author;
 }

 public String getTitle() {
  return title;
 }

 public String getDescription() {
  return description;
 }

 public source getSource() {
  return source;
 }

 public String getUrl() {
  return url;
 }

 public String getUrlToImage() {
  return urlToImage;
 }

 public String getPublishedAt() {
  return publishedAt;
 }

 public String getContent() {
  return content;
 }


}
