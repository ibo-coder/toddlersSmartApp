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
import android.widget.Toast;

import java.text.CollationElementIterator;

/**
 * Created by Ibrahim on 3/19/2016.
 */
public class NumberCustomSwipeAdapter extends PagerAdapter {
    ReadName sayNames;
    private int[] image_resources={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten
    };
    private String[] number_name={"One","Two","Three","Four","Five","Six","seven","Eight","Nine","Ten"};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public NumberCustomSwipeAdapter(MainActivity ctx){this.ctx=ctx;
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
        textView.setText(number_name[position]);
        sayNames.allow(true);
        sayNames.speak(number_name[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
