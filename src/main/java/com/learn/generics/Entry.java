package com.learn.generics;

/**
 * This is a generic class with key value pair
 * 
 * @author Sujay
 *
 * @param <K>
 *            Key
 * @param <V>
 *            Value
 */
public class Entry<K, V> {

	private final K k;
	private final V v;

	/**
	 * This constructor initializes the key value pair
	 * 
	 * @param k
	 *            key
	 * @param v
	 *            value
	 */
	public Entry(K k, V v) {
		this.k = k;
		this.v = v;
	}

	/**
	 * This method gets the Key
	 * 
	 * @return key
	 */
	public K getKey() {
		return k;
	}

	/**
	 * This method gets the Value
	 * 
	 * @return value
	 */
	public V getValue() {
		return v;
	}

	/**
	 * This method prints the key value pair
	 * 
	 * @return String of Key-Value pair
	 */
	public String toString() {
		return "(" + k + ", " + v + ")";
	}

}