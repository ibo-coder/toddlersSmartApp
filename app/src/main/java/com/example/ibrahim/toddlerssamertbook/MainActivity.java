package com.example.ibrahim.toddlerssamertbook;

//import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private int CHECK_CODE = 0;
    private ReadName speaker;
    public String itemname;
    ViewPager viewPager;
    NatureCustomSwipeAdapter adapterNature;
    FruitsCustomSwipeAdapter adapterFruits;
    CustomSwipeAdapter adapterAnimal;
    ColorCustomSwipeAdapter adapterColor;
    ShapeCustomSwipeAdapter adapterShape;
    NumberCustomSwipeAdapter adapterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        final RelativeLayout rt= (RelativeLayout)findViewById(R.id.rltvLayout);

        final ImageButton animalButton=(ImageButton)findViewById(R.id.imbtnAnimal);
        final ImageButton fruitButton=(ImageButton)findViewById(R.id.imbtnFruits);
        final ImageButton natureButton=(ImageButton)findViewById(R.id.imbtnNature);
        final ImageButton colorButton=(ImageButton)findViewById(R.id.imbtnColors);
        final ImageButton shapeButton=(ImageButton)findViewById(R.id.imbtnShapes);
        final ImageButton numberButton=(ImageButton)findViewById(R.id.imbtnNumbers);
        final LinearLayout mainLinearlaout=(LinearLayout)findViewById(R.id.main_linear_layout);
        final ImageButton btnPlayStop=(ImageButton)findViewById(R.id.btnPlay);
        final ImageButton btnReturn= (ImageButton) findViewById(R.id.homebtnRet);
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        mainLinearlaout.setVisibility(LinearLayout.VISIBLE);
        btnReturn.setVisibility(ImageButton.INVISIBLE);
        viewPager.setVisibility(ViewPager.INVISIBLE);

        checkTTS();

        animalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rt.setBackgroundColor(Color.parseColor("#fff0f5"));
                mainLinearlaout.setVisibility(LinearLayout.INVISIBLE);
                btnReturn.setVisibility(ImageButton.VISIBLE);
                btnPlayStop.setVisibility(ImageButton.VISIBLE);
                viewPager.setVisibility(ViewPager.VISIBLE);
                adapterAnimal = new CustomSwipeAdapter(MainActivity.this);
                viewPager.setAdapter(adapterAnimal);


            }
        });
        fruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rt.setBackgroundColor(Color.parseColor("#e6e6fa"));
                mainLinearlaout.setVisibility(LinearLayout.INVISIBLE);
                btnReturn.setVisibility(ImageButton.VISIBLE);
                viewPager.setVisibility(ViewPager.VISIBLE);
                adapterFruits=new FruitsCustomSwipeAdapter(MainActivity.this);
                viewPager.setAdapter(adapterFruits);

            }
        });
natureButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        rt.setBackgroundColor(Color.parseColor("#ccccff"));
        mainLinearlaout.setVisibility(LinearLayout.INVISIBLE);
        btnReturn.setVisibility(ImageButton.VISIBLE);
        viewPager.setVisibility(ViewPager.VISIBLE);
        adapterNature=new NatureCustomSwipeAdapter(MainActivity.this);
        viewPager.setAdapter(adapterNature);
    }
});

       /*btnPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname=adapterColor.itemNameSender();
                speaker.allow(true);
                speaker.speak(itemname);
            }
        });*/
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rt.setBackgroundColor(Color.parseColor("#ec87fa"));
                mainLinearlaout.setVisibility(LinearLayout.VISIBLE);
                btnReturn.setVisibility(ImageButton.INVISIBLE);
                btnPlayStop.setVisibility(ImageButton.INVISIBLE);
                viewPager.setVisibility(ViewPager.INVISIBLE);
            }
        });
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rt.setBackgroundColor(Color.parseColor("#b1ffb1"));
                mainLinearlaout.setVisibility(LinearLayout.INVISIBLE);
                btnReturn.setVisibility(ImageButton.VISIBLE);
                btnPlayStop.setVisibility(ImageButton.VISIBLE);
                viewPager.setVisibility(ViewPager.VISIBLE);
                adapterColor = new ColorCustomSwipeAdapter(MainActivity.this);
                 viewPager.setAdapter(adapterColor);
            }
        });
        shapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rt.setBackgroundColor(Color.parseColor("#d5f8e8"));
                mainLinearlaout.setVisibility(LinearLayout.INVISIBLE);
                btnReturn.setVisibility(ImageButton.VISIBLE);
                viewPager.setVisibility(ViewPager.VISIBLE);
                adapterShape = new ShapeCustomSwipeAdapter(MainActivity.this);
                viewPager.setAdapter(adapterShape);
            }
        });
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rt.setBackgroundColor(Color.parseColor("#e0b0ff"));
                mainLinearlaout.setVisibility(LinearLayout.INVISIBLE);
                btnReturn.setVisibility(ImageButton.VISIBLE);
                viewPager.setVisibility(ViewPager.VISIBLE);
                adapterNumber = new NumberCustomSwipeAdapter(MainActivity.this);
                viewPager.setAdapter(adapterNumber);
            }
        });


    }


    private void checkTTS(){
        Intent check = new Intent();
        check.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(check, CHECK_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CHECK_CODE){
            if(resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
                speaker = new ReadName(this);
            }else {
                Intent install = new Intent();
                install.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(install);
            }
        }
    }

}
