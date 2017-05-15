package com.encrypt;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSAEncryptInfo {

	//KeyPairGenerator类用于生成公钥和私钥对
	KeyPairGenerator keyPairGen;
	 //生成一个密钥对，保存在keyPair中
	KeyPair keyPair;
	//私钥  
	RSAPrivateKey privateKey;
	//公钥  
    RSAPublicKey publicKey;
    //Cipher负责完成加密或解密工作
	Cipher cipher;
	//结果
	byte[] cipherByte;
	
	public RSAEncryptInfo() throws NoSuchAlgorithmException{
		  //KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
         keyPairGen = KeyPairGenerator.getInstance("RSA");  
        //初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(1024);  
        //生成一个密钥对，保存在keyPair中  
         keyPair = keyPairGen.generateKeyPair();  
        //得到私钥  
         privateKey = (RSAPrivateKey)keyPair.getPrivate();               
        //得到公钥  
         publicKey = (RSAPublicKey)keyPair.getPublic();  
	}
	//公钥和私钥都有它们自己独特的比特编码，可以通过getEncoded()方法获取
	public  byte[] getEncodedByPrivateKey(RSAPrivateKey key){
		
		return key.getEncoded();
	}
	public  byte[] getEncodedByPublicKey(RSAPublicKey key){
			
			return key.getEncoded();
		}
	
	//通过byte[]可以再度将公钥或私钥还原出来
	public static PublicKey getPublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey key = factory.generatePublic(keySpec);
		return key;
	}
	
	public static PrivateKey getPrivateKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey key = factory.generatePrivate(keySpec);
		return key;
		
	}
	
}
