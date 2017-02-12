package com.sc.main;

import java.util.ArrayList;

public class CustomArrayList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8260196798213452028L;

	@Override
	public boolean add(T e) {
		if (e != null) {
			return super.add(e);
		}
		return false;
	}
}
