package com.liucanwen.imageswitch;

import android.content.Context;
import android.view.View;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class ImageSwitchUtil {

	public static View loadNetImage(Context cxt, String url)
	{
		KenBurnsView kbv = new KenBurnsView(cxt);
    	
    	loadImage(kbv, url, cxt);
    	
    	return kbv;
	}
	
    private static void loadImage(final KenBurnsView image, String url, Context cxt)
    {
    	Picasso.with(cxt).load(url).placeholder(R.drawable.empty_photo).into(image);
    }
}
