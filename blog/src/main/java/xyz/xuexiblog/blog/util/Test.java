package xyz.xuexiblog.blog.util;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws MessagingException {
        /**
         * 新建邮箱类
         */
        Properties prop=new Properties();
        //设置代理邮箱服务武器
        prop.put("mail.host","smtp.126.com" );
        //设置邮箱代理服务器的格式
        prop.put("mail.transport.protocol", "smtp");
    //是否验证身份true是 false表示不验证
        prop.put("mail.smtp.auth", true);
        /**
         * 来週
         * 再来週
         * 先週
         * 売店
         * ばいてん
         * 車駅
         * 駅
         */
        //使用java发送邮件5步骤
        //1.创建sesssion
        //以session维持传输
        Session session=Session.getInstance(prop);
        //开启session的调试模式，可以查看当前邮件发送状态
        //开启session的log模式查看发送状态
        session.setDebug(true);

        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport ts=session.getTransport();
        //3.通过邮件用户名密码链接
        ts.connect("zx1092771091zx@126.com", "xuexiniangxuexi1");
        /**
         *
         */

        for (int i = 0; i <99 ; i++) {




        //4.创建邮件
        Message msg=createSimpleMail(session);

        //5.发送电子邮件
        ts.sendMessage(msg, msg.getAllRecipients());
        }
    }

    public static MimeMessage createSimpleMail(Session session) throws AddressException,MessagingException{
        //创建邮件对象
        MimeMessage mm=new MimeMessage(session);
        //设置发件人
        mm.setFrom(new InternetAddress("zx1092771091zx@126.com"));
        //设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress("zx1092771091zx@163.com"));
        //设置抄送人
        mm.setRecipient(Message.RecipientType.CC, new InternetAddress("zx1092771091zx@126.com"));
        em();
        mm.setSubject("第一封JAVA邮件！");
        mm.setContent("咱们开会吧", "text/html;charset=utf-8");
        return mm;
    }


    public static void em(){
        String imapserver = "imap.126.com"; // 邮件服务器
        String user = "zx1092771091zx@126.com";
        String password = "xuexiniangxuexi1";     // 根据自已的密码修改
        // 获取默认会话
        Properties prop = System.getProperties();
        prop.put("mail.imap.host",imapserver);

        prop.put("mail.imap.auth.plain.disable","true");
        Session mailsession=Session.getInstance(prop,null);
        mailsession.setDebug(false); //是否启用debug模式
        IMAPFolder folder= null;
        IMAPStore store=null;
        int total= 0;
        try{
            store=(IMAPStore)mailsession.getStore("imap");  // 使用imap会话机制，连接服务器
            store.connect(imapserver,user,password);
            folder=(IMAPFolder)store.getFolder("INBOX"); //收件箱
            // 使用只读方式打开收件箱
            folder.open(Folder.READ_WRITE);
            //获取总邮件数
            total = folder.getMessageCount();
            System.out.println("-----------------您的邮箱共有邮件：" + total+" 封--------------");
            // 得到收件箱文件夹信息，获取邮件列表
            Message[] msgs =folder.getMessages();
            System.out.println("\t收件箱的总邮件数：" + msgs.length);
            System.out.println("\t未读邮件数：" + folder.getUnreadMessageCount());
            System.out.println("\t新邮件数：" + folder.getNewMessageCount());
            System.out.println("----------------End------------------");
        }
        catch(MessagingException ex){
            System.err.println("不能以读写方式打开邮箱!");
            ex.printStackTrace();
        }finally {
            // 释放资源
            try{
                if(folder!=null)
                    folder.close(true); //退出收件箱时,删除做了删除标识的邮件
                if (store != null)
                    store.close();
            }catch(Exception bs){
                bs.printStackTrace();
            }
        }
    }
}
