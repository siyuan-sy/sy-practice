package com.sy.common;

import java.io.Serializable;

public class KeyValuePair<K, V> implements Serializable{
	
	private K key;
	
	private V value;
	
	public static <K, V> KeyValuePair<K, V> create(K key, V value){
		return new KeyValuePair<>(key, value);
	}
	
	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
