package com.redrabbit.bestquotes.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QuoteDBAdapter {

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

	private SQLiteDatabase db;
	private MyDBOpenHelper helper;

	public QuoteDBAdapter(Context ctx) {
		helper = new MyDBOpenHelper(ctx, BASE_NAME, null, BASE_VERSION);
	}

	public SQLiteDatabase open() {
		db = helper.getWritableDatabase();
		return db;
	}

	public void close() {
		db.close();
	}

	public boolean isOpen() {
		return db.isOpen();
	}

	public SQLiteDatabase getBaseDonnees() {
		return db;
	}

	public QuoteORM getQuoteOrm(int id) {
		Cursor c = db.query(TABLE_QUOTE, new String[] { COLUMN_ID, COLUMN_QUOTE,
				COLUMN_AUTHOR, COLUMN_CATEGORY, COLUMN_FAVOURITE }, null, null,
				COLUMN_ID, COLUMN_ID + " LIKE " + id, null);
		return cursorToQuoteOrm(c);
	}

	public ArrayList<QuoteORM> getAllQuoteOrms() {
		Cursor c = db.query(TABLE_QUOTE, new String[] { COLUMN_ID, COLUMN_QUOTE,
				COLUMN_AUTHOR, COLUMN_CATEGORY, COLUMN_FAVOURITE }, null, null, null,
				null, null);
		return cursorToQuoteOrms(c);
	}

	public QuoteORM getRandomQuote() {
		Cursor c = db.query(TABLE_QUOTE, new String[] { COLUMN_ID, COLUMN_QUOTE,
				COLUMN_AUTHOR, COLUMN_CATEGORY, COLUMN_FAVOURITE }, null, null, null,
				null, "RANDOM()");
		return cursorToQuoteOrm(c);
	}

	public long putQuoteOrm(QuoteORM a) {
		ContentValues cv = new ContentValues();
		// cv.put(COLUMN_ID, n.getId());
		cv.put(COLUMN_QUOTE, a.getQuote());
		cv.put(COLUMN_AUTHOR, a.getAuthor());
		cv.put(COLUMN_CATEGORY, a.getCategory());
		cv.put(COLUMN_FAVOURITE, a.getFavourite());
		long result = db.insert(TABLE_QUOTE, null, cv);
		return result;
	}

	public long updateQuoteOrm(QuoteORM a) {
		ContentValues cv = new ContentValues();
		// cv.put(COLUMN_ID, n.getId());
		cv.put(COLUMN_QUOTE, a.getQuote());
		cv.put(COLUMN_AUTHOR, a.getAuthor());
		cv.put(COLUMN_CATEGORY, a.getCategory());
		cv.put(COLUMN_FAVOURITE, a.getFavourite());
		removeQuoteOrm(a.getId_quote());
		return db.insert(TABLE_QUOTE, COLUMN_ID + " LIKE " + a.getId_quote(), cv);
	}

	public long removeQuoteOrm(int id) {
		return db.delete(TABLE_QUOTE, COLUMN_ID + " LIKE " + id, null);
	}

	public void removeAll() {
		db.delete(TABLE_QUOTE, null, null);
	}

	private QuoteORM cursorToQuoteOrm(Cursor c) {
		if (c.getCount() == 0)
			return null;

		QuoteORM a = new QuoteORM();
		c.moveToFirst();
		a.setId_quote(c.getInt(COLUMN_ID_ID));
		a.setQuote(c.getString(COLUMN_QUOTE_ID));
		a.setAuthor(c.getString(COLUMN_AUTHOR_ID));
		a.setCategory(c.getString(COLUMN_CATEGORY_ID));
		a.setFavourite(c.getInt(COLUMN_FAVOURITE_ID));

		return a;
	}

	private ArrayList<QuoteORM> cursorToQuoteOrms(Cursor c) {
		if (c.getCount() == 0)
			return new ArrayList<QuoteORM>(0);

		ArrayList<QuoteORM> activityOrms = new ArrayList<QuoteORM>(c.getCount());
		c.moveToFirst();
		do {
			QuoteORM a = new QuoteORM();
			a.setId_quote(c.getInt(COLUMN_ID_ID));
			a.setQuote(c.getString(COLUMN_QUOTE_ID));
			a.setAuthor(c.getString(COLUMN_AUTHOR_ID));
			a.setCategory(c.getString(COLUMN_CATEGORY_ID));
			a.setFavourite(c.getInt(COLUMN_FAVOURITE_ID));
			activityOrms.add(a);
		} while (c.moveToNext());

		return activityOrms;
	}
}
