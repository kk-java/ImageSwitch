package com.liucanwen.imageswitch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewSwitcher;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.KenBurnsView.TransitionListener;
import com.flaviofaria.kenburnsview.Transition;

public class MultiImageActivity extends Activity implements TransitionListener {

    private static final int TRANSITIONS_TO_SWITCH = 2;

    private ViewSwitcher mViewSwitcher;

    private int mTransitionsCount = 0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_image);

        mViewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        
        addImageViews();
    }
    
    public void addImageViews()
    {
    	for(int i = 0; i < getImages().length; i++)
    	{
    		KenBurnsView kbv = (KenBurnsView)ImageSwitchUtil.loadNetImage(MultiImageActivity.this, getImages()[i]);
        	kbv.setTransitionListener(this);
        	
        	mViewSwitcher.addView(kbv);
    	}
    }
    
    @Override
    public void onTransitionStart(Transition transition) {
    }

    @Override
    public void onTransitionEnd(Transition transition) {
        mTransitionsCount++;
        if (mTransitionsCount == TRANSITIONS_TO_SWITCH) {
            mViewSwitcher.showNext();
            mTransitionsCount = 0;
        }
    }
    
    public String[] getImages()
    {
    	String url1 = "https://raw.githubusercontent.com/kk-java/ImageSwitch/master/screenshot1.jpg";
    	String url2 = "https://raw.githubusercontent.com/kk-java/ImageSwitch/master/screenshot2.jpg";
    	
    	String[] strs = {url1, url2};
    	
    	return strs;
    }
}
