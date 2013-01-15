package com.redrabbit.bestquotes.db;

import android.content.Context;

public class DataMgr {

	private Context ctx;
	private QuoteDBAdapter adapter;

	public DataMgr(Context ctx) {
		this.ctx = ctx;
		this.adapter = new QuoteDBAdapter(ctx);
	}
	
	public void clearDB(){
		adapter.open();
		adapter.removeAll();
		adapter.close();
	}
	
	public void generateTestData(){
		QuoteORM quote1 = new QuoteORM("Cast off the shackles of this modern oppression and take back what is rightfully yours, because as William Shakespeare never wrote, 'Life is but a bullring, and we are but matadors trying to dodge all the horns.'", "Matthew Clayfield", "inspirational", 0);
		QuoteORM quote2 = new QuoteORM("Television is where you watch people in your living room that you would not want near your house.", "Groucho Marx", "funny", 0);
		QuoteORM quote3 = new QuoteORM("The music business is a cruel and shallow money trench, a long plastic hallway where thieves and pimps run free, and good men die like dogs. There's also a negative side.", "Hunter S. Thompson", "inspirational", 0);
		
		adapter.open();
		adapter.putQuoteOrm(quote1);
		adapter.putQuoteOrm(quote2);
		adapter.putQuoteOrm(quote3);
		adapter.close();
	}
}
