package com.imageslider.maroof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mSlider;
    private ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlider = (SliderLayout)findViewById(R.id.slider);
        mListview = (ListView)findViewById(R.id.animation_listview);

        HashMap<String,Integer> images = new HashMap<String, Integer>();
        images.put("Cupcake",R.drawable.cupcake);
        images.put("Donut",R.drawable.donut);
        images.put("Eclair",R.drawable.eclair);
        images.put("Froyo", R.drawable.froyo);
        images.put("Gingerbread", R.drawable.gingerbread);
        images.put("Honeycomb", R.drawable.honeycomb);
        images.put("Ice Cream Sandwich", R.drawable.icecreamsandwich);
        images.put("Jelly Bean", R.drawable.jellybean);
        images.put("KitKat", R.drawable.kitkat);
        images.put("Lollipop", R.drawable.lollipop);
        images.put("Marshmallow", R.drawable.marshmallow);
        images.put("Nougat", R.drawable.nougat);

        for(String name : images.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(images.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mSlider.addSlider(textSliderView);
        }

        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(3000);
        mSlider.addOnPageChangeListener(this);

        mListview.setAdapter(new ListAdapter(this));
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSlider.setPresetTransformer(((TextView) view).getText().toString());
                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
