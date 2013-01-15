package com.redrabbit.bestquotes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpenHelper extends SQLiteOpenHelper {
	
	private static final String BASE_NAME = "bestquotes.db";
	private static final int BASE_VERSION = 1;
	private static final String TABLE_QUOTE = "quote";
	private static final String COLUMN_ID = "id_quote";
	private static final int COLUMN_ID_ID = 0;
	private static final String COLUMN_QUOTE = "quote";
	private static final int COLUMN_QUOTE_ID = 1;
	private static final String COLUMN_AUTHOR = "author";
	private static final int COLUMN_AUTHOR_ID = 2;
	private static final String COLUMN_CATEGORY = "category";
	private static final int COLUMN_CATEGORY_ID = 3;
	private static final String COLUMN_FAVOURITE = "favourite";
	private static final int COLUMN_FAVOURITE_ID = 4;

	public static final String TABLE_CREATION_QUOTE = "create table " + TABLE_QUOTE
			+ " (" + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_QUOTE
			+ " text not null, " + COLUMN_AUTHOR + " text not null, " + COLUMN_CATEGORY
			+ " text not null, " + COLUMN_FAVOURITE	+ " integer);";

	public MyDBOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(TABLE_CREATION_QUOTE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE " + TABLE_CREATION_QUOTE + ";");
		onCreate(db);
	}

}
