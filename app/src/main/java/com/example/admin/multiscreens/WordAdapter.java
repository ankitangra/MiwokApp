package com.example.admin.multiscreens;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 1/15/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {



    int colorID;

    //constructor called
    public WordAdapter(Activity context, ArrayList<Word> wordlist,int color_id) {
        super(context, 0, wordlist);
       this.colorID=color_id;
    }
//static MediaPlayer mp;

    //getView overrided

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Word word = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);
        }

        //setting color to listView background

        View textContainer = convertView.findViewById(R.id.container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),colorID);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        TextView eng =(TextView)convertView.findViewById(R.id.english_word);

        eng.setText(word.getEnglish());

        TextView hin =(TextView)convertView.findViewById(R.id.hindi_word);

        hin.setText(word.getHindi());




        ImageView icon =(ImageView)convertView.findViewById(R.id.icon);

        if(word.hasImage()) {
            icon.setVisibility(View.VISIBLE);
            icon.setImageResource(word.getImage());

        }
        else
        icon.setVisibility(View.GONE);


//        ImageView icon2 =(ImageView)convertView.findViewById(R.id.icon2);
//        icon2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mp = MediaPlayer.create(getContext(),word.getAudio());
//                mp.start();
//            }
//        });

        return convertView;
    }
}
