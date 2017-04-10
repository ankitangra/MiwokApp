package com.example.admin.multiscreens;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    MediaPlayer mp;

    AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener listener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
            {
                mp.pause();
                mp.seekTo(0);
            }

            else if(focusChange== AudioManager.AUDIOFOCUS_GAIN)
            {
                mp.start();
            }
            else if(focusChange== AudioManager.AUDIOFOCUS_LOSS)
            {
                mp.release();
            }
        }
    };





    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMedia();
        }
    };



    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView=inflater.inflate(R.layout.word_list_view,container,false);


        audioManager=(AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE) ;


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi" ,R.drawable.color_red,R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә" ,R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә" ,R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("green", "chokokki" ,R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki" ,R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));

        WordAdapter wd = new WordAdapter(getActivity(),words,R.color.colorsBackground);
        ListView lw= (ListView)rootView.findViewById(R.id.list_view);
        lw.setAdapter(wd);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word =words.get(position);
                releaseMedia();

                int result=audioManager.requestAudioFocus(listener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN) ;
                {
                    if (result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mp= MediaPlayer.create(getActivity(),word.getAudio());

                        mp.start();
                    }
                }



                mp.setOnCompletionListener(mCompletionListener);
            }
        });


return  rootView;


    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMedia();
    }

    public void releaseMedia()
    {
        if(mp!=null)
        {
            mp.release();
            mp=null;
            audioManager.abandonAudioFocus(listener);
        }
    }
}


