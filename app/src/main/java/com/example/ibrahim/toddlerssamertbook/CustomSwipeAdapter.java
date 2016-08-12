package com.example.ibrahim.toddlerssamertbook;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Ibrahim on 3/19/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {
    ReadName sayNames;
    private int[] image_resources={R.drawable.dog,R.drawable.cat,R.drawable.cow,R.drawable.buffalo,R.drawable.sheep,R.drawable.goat,R.drawable.pig,R.drawable.hen,R.drawable.goose,R.drawable.duck,R.drawable.turkey,R.drawable.donkey
            ,R.drawable.zebra,R.drawable.horse,R.drawable.deer,R.drawable.rat,R.drawable.wolf,R.drawable.fox,R.drawable.monkey,R.drawable.lion,R.drawable.tiger,R.drawable.rhinho,R.drawable.hippo,R.drawable.giraffe,R.drawable.bear,R.drawable.elephant,R.drawable.squirrel,R.drawable.pinguin,R.drawable.goldfish,R.drawable.wale,R.drawable.dolphin,R.drawable.shark,R.drawable.alligator,R.drawable.snail,R.drawable.snake,R.drawable.frog,R.drawable.chameleons,R.drawable.spider,R.drawable.bat,R.drawable.butterfly,R.drawable.tourle,};
   private String[] animal_name={"Dog","Cat","Cow","Buffalo","Sheep","Goat","Pig","Hen","Goose","Duck","Turkey","Donkey","Zebra","Horse","Deer","Rat","Wolf","Fox","Monkey","Lion","Tiger","Rhinho","Hippo","Giraffe","Bear","Elephant","Squirrel","Pinguin","Goldfish","Wale","Dolphin","Shark","Alligator","Snail","Snake","Frog","Chameleons","Spider","Bat","Butterfly","Parrot"};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter(MainActivity ctx){this.ctx=ctx;
        sayNames=new ReadName(ctx);}
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView=(ImageView)item_view.findViewById(R.id.image_view);
        TextView textView=(TextView)item_view.findViewById(R.id.name);
        imageView.setImageResource(image_resources[position]);
        textView.setText(animal_name[position]);
        sayNames.allow(true);
        sayNames.speak(animal_name[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((LinearLayout)object);
    }
}
