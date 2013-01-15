package com.redrabbit.bestquotes;

import android.content.Context;
import android.widget.Toast;

public class Toaster {

	public void toast(Context ctx, String msg){
		Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
	}
	
}
