package com.springboot.jpa.mvc.Util;

public interface Encryption {
	
	public String encrypt(String original);
	public String decrypt(String encrypted);
}
