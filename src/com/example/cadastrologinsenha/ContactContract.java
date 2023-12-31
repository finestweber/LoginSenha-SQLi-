package com.example.cadastrologinsenha;

import android.provider.BaseColumns;

public final class ContactContract {
	private  ContactContract(){}
	
	public static class ContactEntry implements BaseColumns{
		public static String TABLE_USERS ="users"; 
		public static String COLUMN_USERNAME = "username";
		public static String COLUMN_PASSWORD= "password";
	}
}
