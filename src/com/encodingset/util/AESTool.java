package com.encodingset.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 *@Author tangqianfeng 
 *@Version 1.0
 *
 */
public class AESTool {
	/**
     * 初始化 AES Cipher
     * @param sKey
     * @param cipherMode
     * @return
     */
	public static final String key = "123456789"; 
	
    private static Cipher initAESCipher(String sKey, int cipherMode) {
        //创建Key gen
        KeyGenerator keyGenerator = null;
        Cipher cipher = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(sKey.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] codeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(codeFormat, "AES");
            cipher = Cipher.getInstance("AES");
            //初始化
            cipher.init(cipherMode, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();  
        } catch (InvalidKeyException e) {
            e.printStackTrace();  
        }
        return cipher;
    }
    
    /**
     * 对文件进行AES加密
     * @param sourceFile
     * @param fileType
     * @param sKey
     * @return
     */
    public static File encryptFile(File sourceFile,String fileType, String sKey){
        //新建临时加密文件
    	File encrypfile = new File(AESTool.class.getResource("/Administrators.properties").getFile()); 
        System.out.println(encrypfile.getAbsolutePath());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        CipherInputStream cipherInputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            if(!encrypfile.exists()){
            	 encrypfile.createNewFile();
            }
            outputStream = new FileOutputStream(encrypfile);
            Cipher cipher = initAESCipher(sKey,Cipher.ENCRYPT_MODE);
            //以加密流写入文件
            cipherInputStream = new CipherInputStream(inputStream, cipher);
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = cipherInputStream.read(cache)) != -1) {
            	System.out.println(cache);
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
        }  catch (FileNotFoundException e) {
            e.printStackTrace();  
        }  catch (IOException e) {
            e.printStackTrace();  
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  
            }
            try {
				cipherInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return encrypfile;
    }
    
    /**
     * AES方式解密文件
     * @param sourceFile
     * @return
     */
    public static File decryptFile(InputStream sourceFile,String fileType,String sKey){
        File decryptFile = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            decryptFile = File.createTempFile("TEMP",fileType);
            Cipher cipher = initAESCipher(sKey,Cipher.DECRYPT_MODE);
            inputStream = sourceFile;
            outputStream = new FileOutputStream(decryptFile);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
            byte [] buffer = new byte [1024];
            int r;
            while ((r = inputStream.read(buffer)) >= 0) {
                cipherOutputStream.write(buffer, 0, r);
            }
            cipherOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();  
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  
            }
        }
        return decryptFile;
    }
    
    
    public static void main(String[] args){
    	//initAESCipher(AESTool.key,Cipher.ENCRYPT_MODE);
    	File file = new File("D:\\yade\\区卫前置机基础数据管理系统\\Administrators.properties");
    	encryptFile(file,null,AESTool.key);
    }
}

