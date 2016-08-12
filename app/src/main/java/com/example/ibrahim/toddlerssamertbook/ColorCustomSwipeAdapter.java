package com.example.ibrahim.toddlerssamertbook;

import android.content.Context;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;


/**
 * Created by Ibrahim on 3/19/2016.
 */
public class ColorCustomSwipeAdapter extends PagerAdapter  {

  ReadName sayNames;

    private int[] image_resources={R.drawable.red,R.drawable.green,R.drawable.blue,R.drawable.pink,R.drawable.gray,R.drawable.yellow,R.drawable.brown,
            R.drawable.black,R.drawable.purple,R.drawable.orange,R.drawable.white};
    private String[] color_name={"Red","Green","Blue","Pink","Gray","Yellow","Brown","Black","Purple","Orange","White"};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public String temp;
    public ColorCustomSwipeAdapter(MainActivity ctx){this.ctx=ctx;
sayNames=new ReadName(ctx);
       }
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
        int tempos=position;
        imageView.setImageResource(image_resources[position]);
        textView.setText(color_name[position] + " " + position);

//temp=color_name[position];

        sayNames.allow(true);
        sayNames.speak(color_name[tempos]);
      Toast.makeText(ctx, temp.toString(),Toast.LENGTH_SHORT).show();
        container.addView(item_view);
        return item_view;
        }
/*public String itemNameSender(){

    return temp;
}*/
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }


}




