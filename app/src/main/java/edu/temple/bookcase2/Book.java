package edu.temple.bookcase2;

import android.content.Context;

public class Book {

    Context context;
    private int id;
    private String title;
    private String author;
    private int year;
    private String coverURL;

    public Book(int id, String title, String author, int year, String coverURL, Context context){
        this.context = context;
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.coverURL = coverURL;
    }
}
