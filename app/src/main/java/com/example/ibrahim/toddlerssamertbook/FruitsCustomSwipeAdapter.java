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

/**
 * Created by Ibrahim on 3/19/2016.
 */
public class FruitsCustomSwipeAdapter extends PagerAdapter {
    ReadName sayNames;
    private int[] image_resources={R.drawable.apple,R.drawable.kiwi,R.drawable.cherries,R.drawable.peach,R.drawable.pear,R.drawable.banana,R.drawable.strawberry,R.drawable.blueberries,R.drawable.raspberries,R.drawable.blackberry,R.drawable.apricot,
            R.drawable.pomegranate,R.drawable.grape,R.drawable.orangef,R.drawable.mandarin,R.drawable.lemon,R.drawable.grapefruit,R.drawable.melon,R.drawable.watermelon,R.drawable.avocado,R.drawable.dragonfruit,R.drawable.pineapple,R.drawable.date,R.drawable.fig};
    private String[] fruit_name={"Apple","Kiwi","Cherry","Peach","Pear","Banana","Strawberry","Blueberry","Raspberry","Blackberry","Apricot","Pomegranate","Grape","Orange","Mandarin","Lemon"
            ,"Grapefruit","Melon","Watermelon","Avocado","Dragonfruit","Pineapple","Date","Fig"};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public FruitsCustomSwipeAdapter(MainActivity ctx){this.ctx=ctx;
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
        textView.setText(fruit_name[position]);
        sayNames.allow(true);
        sayNames.speak(fruit_name[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
