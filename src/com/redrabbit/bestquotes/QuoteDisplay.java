package com.redrabbit.bestquotes;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.redrabbit.bestquotes.db.DataMgr;

public class QuoteDisplay extends Activity {

	Toaster t = new Toaster();
	DataMgr dataMgr = new DataMgr(this);
	ArrayList<Integer> viewedQuotes = new ArrayList<Integer>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_display);
        
        dataMgr.clearDB();
        dataMgr.generateTestData();
        
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(this));
        viewPager.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quote_display, menu);
        return true;
    }
}
