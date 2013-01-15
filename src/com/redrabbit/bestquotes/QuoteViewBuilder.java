package com.redrabbit.bestquotes;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.redrabbit.bestquotes.db.QuoteDBAdapter;
import com.redrabbit.bestquotes.db.QuoteORM;

public class QuoteViewBuilder {

	private Context ctx;
	private ArrayList<Integer> viewedQuotes = new ArrayList<Integer>();
	QuoteDBAdapter quoteAdapter = new QuoteDBAdapter(ctx);
	
	public QuoteViewBuilder(Context ctx){
		this.ctx = ctx;
	}
	
	public View createQuoteView(){
		
		LinearLayout finalView = new LinearLayout(ctx);
		finalView.setOrientation(LinearLayout.VERTICAL);
		
		QuoteORM quote;
        quoteAdapter.open();

        do {
        	quote = quoteAdapter.getRandomQuote();
        } while (!viewedQuotes.contains(quote.getId_quote()));
        viewedQuotes.add(quote.getId_quote());
        
        quoteAdapter.close();
		
		TextView textView = new TextView(ctx);
		LayoutParams tvLP = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		textView.setLayoutParams(tvLP);
		textView.setText(quote.toString());
		
		finalView.addView(textView);
		
		return finalView;
	}
}
