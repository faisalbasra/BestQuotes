package com.redrabbit.bestquotes;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyPagerAdapter extends PagerAdapter {

	private Context ctx;
	private QuoteViewBuilder viewBuilder;
	private HashMap<Integer, View> views;

	public MyPagerAdapter(Context ctx) {
		this.ctx = ctx;
		this.viewBuilder = new QuoteViewBuilder(ctx);
		views = new HashMap<Integer, View>();
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (View) arg1;
	}

	@Override
	public Object instantiateItem(View collection, int position) {
		View v = null;
		if (views.containsKey(position))
			v = views.get(position);
		else
			v = viewBuilder.createQuoteView(); 
		((ViewPager) collection).addView(v);
		views.put(position, v);
		return v;
	}

	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		((ViewPager) arg0).removeView((View) arg2);
		views.remove(arg1);
	}

}
