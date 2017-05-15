package com.encrypt;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * 双向加密
 * 非对称加密   UnsymmetricEncrypt
 * @author kai.long001
 *default RSA Elgamal 背包算法 Rabin  D-H ECC（椭圆曲线加密算法）
 */
public class RSAEncrypt {

	public static final String RSA="RSA";
	
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
	
	public RSAEncrypt() throws NoSuchAlgorithmException{
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
	
	protected byte[]  RSAencryptWithPrivateKey(PrivateKey privateKey,int mode,String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		//Cipher负责完成加密或解密工作，基于RSA
		cipher=Cipher.getInstance(RSA);
		 //根据公钥，对Cipher对象进行初始化  
		cipher.init(mode, privateKey);
		 cipherByte = cipher.doFinal(str.getBytes());  
		return cipherByte;
	}
	protected byte[]  RSAdencryptWithPublicKey(PublicKey publicKey,int mode,String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		//Cipher负责完成加密或解密工作，基于RSA
		cipher=Cipher.getInstance(RSA);
		 //根据公钥，对Cipher对象进行初始化  
		cipher.init(mode, publicKey);
		 cipherByte = cipher.doFinal(str.getBytes());  
		return cipherByte;
	}
	 public RSAPrivateKey getPrivateKey() {
			return privateKey;
		}

		public RSAPublicKey getPublicKey() {
			return publicKey;
		}
}
