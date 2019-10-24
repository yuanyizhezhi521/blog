package xyz.xuexiblog.blog.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UtilTest {
    private static Map users = new HashMap();//用于模拟数据库

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String userName = "zyg";
        String password = "123";
        String encryptedPwd = MD5Util.getEncryptedPwd(password);
        System.out.println(encryptedPwd);

        boolean b = MD5Util.validPassword(password, encryptedPwd);
        if (b){
            byte[] bytes = MD5Util.hexStringToByte(encryptedPwd);
            String s = MD5Util.byteToHexString(bytes);
            System.out.println(s);
        }

    }

    /**
     * 注册用户
     *
     * @param userName
     * @param password
     */
    public static void registerUser(String userName,String password){
        String encryptedPwd = null;
        try {
            encryptedPwd = MD5Util.getEncryptedPwd(password);

            users.put(userName, encryptedPwd);

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 验证登陆
     *
     * @param userName
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean loginValid(String userName,String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String pwdInDb = (String)users.get(userName);
        if(null!=pwdInDb){ // 该用户存在
            return MD5Util.validPassword(password, pwdInDb);
        }else{
            System.out.println("不存在该用户！！！");
            return false;
        }
    }

}
