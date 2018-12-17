package huse2018.j2ee.teaching.servlet.day05;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CharacterUtils {
	/**
	 * MD5加密工具类
	 * @param str
	 * @return
	 */
	public synchronized static final String getMD5Str(String str) { // md5加密
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(getMD5Str("汪洋"));
		System.out.println(getMD5Str("wangyang"));
		System.out.println(getMD5Str("wangyang"));
	}
}
