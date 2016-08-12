package com.example.ibrahim.toddlerssamertbook;

import android.content.Context;
import android.media.AudioManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Ibrahim on 4/7/2016.
 */
public class ReadName extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    private LayoutInflater layoutInflater;

    public ReadName(MainActivity ctx){tts = new TextToSpeech(ctx, this);}
    private boolean ready = false;

    private boolean allowed = false;




    public boolean isAllowed(){
        return allowed;
    }

    public void allow(boolean allowed){
        this.allowed = allowed;
    }


    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            // Change this to match your
            // locale
            tts.setLanguage(Locale.US);
            tts.setPitch(1.2f);
            tts.setSpeechRate(0.7f);
            ready = true;
        }else{
            ready = false;
        }
    }
    public void speak(String text){

        // Speak only if the TTS is ready
        // and the user has allowed speech

        if(ready && allowed) {
           /* HashMap<String, String> hash = new HashMap<String,String>();
            hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM,
                    String.valueOf(AudioManager.STREAM_NOTIFICATION));*/
            tts.speak(text, TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

}



