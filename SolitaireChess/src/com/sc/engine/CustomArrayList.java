package com.sc.engine;

import java.util.ArrayList;

/**
 * A custom array list which skips adding null value into the list.
 * 
 * @author Mahdi Ziaee
 *
 * @param <T>
 */
public class CustomArrayList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8260196798213452028L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(T e) {
		if (e != null) {
			return super.add(e);
		}
		return false;
	}
}
