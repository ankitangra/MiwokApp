package com.example.admin.multiscreens;

/**
 * Created by Admin on 1/15/2017.
 */

public class Word {

    String englishWord, hindiWord;
    final int noimage=-1;
    int image=noimage ,audio;

    public Word(String eng , String hin , int aud)
    {
        this.englishWord=eng;
        this.hindiWord=hin;
        this.audio=aud;
    }

    public Word(String eng , String hin , int img , int aud)
    {
        this.englishWord=eng;
        this.hindiWord=hin;
        this.image=img;
        this.audio=aud;
    }


    public String getEnglish()
    {
        return  englishWord;
    }

    public String getHindi()
    {
        return  hindiWord;
    }

    public int getImage()
    {
        return image;
    }
public boolean hasImage()
{
    return image!=noimage;
}

public int getAudio()
{
    return audio;
}


}
