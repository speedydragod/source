package com.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * 双向加密
 * @author kai.long
 * 对称加密
 *default DES DESede(TripleDES,就是3DES) AES 
 */
public class SymmetricEncrypt {
	
	public static final String DES = "DES"; 
	public static final String AES = "AES"; 
	public static final String DESede = "DESede"; 
	public static final String _3DES = "DESede"; 
	public static final String TripleDES = "DESede"; 
	//KeyGenerator 提供对称密钥生成器的功能，支持各种算法  
	protected KeyGenerator keygen;
	//SecretKey 负责保存对称密钥  	
	protected SecretKey key;
	//Cipher负责完成加密或解密工作  	
	protected Cipher cipher;
	//该字节数组负责保存加密的结果  	
	protected byte[] cipherByte;
	/**
	 * 
	 * @param crypt
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public SymmetricEncrypt(String encrypt) throws NoSuchAlgorithmException, NoSuchPaddingException   {
		 Security.addProvider(new com.sun.crypto.provider.SunJCE());  
	        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)  
	        keygen = KeyGenerator.getInstance(encrypt);  
	        //生成密钥  
	        key = keygen.generateKey();  
	        //生成Cipher对象,指定其支持的DES算法  
	        cipher = Cipher.getInstance(encrypt);  
	}
	/**
	 * 加密字符串
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	protected byte[] Encryptor(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		cipher.init(Cipher.ENCRYPT_MODE, key);
		cipherByte=cipher.doFinal(str.getBytes());
		return cipherByte;
		
	}
	/**
	 * 解密字符串
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	protected byte[] decryptor(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		cipher.init(Cipher.DECRYPT_MODE, key);
		cipherByte=cipher.doFinal(str.getBytes());
		return cipherByte;
		
	}
}
