package com.subo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.subo.exception.BaseException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.subo.entity.MailBean;

public class SendMail {
	
	private final static Logger logger = LoggerFactory.getLogger(SendMail.class);

	private static String fromEmail ;

	private static String password;
	/*private static Log log = Log.getLogger(SendMail.class);
    public static String toChinese(String text) {
        try {
            text = MimeUtility.encodeText(new String(text.getBytes(), "GB2312"), "GB2312", "B");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
    
    static StringBuffer buffer = new StringBuffer(); 
    static Map<String,String> map = new HashMap<String,String>();
    static{
		try {
			InputStream input=Area.class.getClassLoader().getResourceAsStream("email.properties");
			BufferedReader br=new BufferedReader(new InputStreamReader(input));
			String line=br.readLine();
			
			while(line!=null){
				if(line.indexOf(":")>=0){
					String[] val = line.split(":");
					buffer.append(val[1]+",");
				}else{
					String[] val=line.split("=");
					map.put(val[0], val[1]);
				}
				line=br.readLine();
			}
		} catch (IOException e) {
			log.error(e);
		}
    }*/
    /**
     * 邮件发送
     * @param mb
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static boolean sendMail(MailBean mb) throws UnsupportedEncodingException {
    	logger.debug("read obj");
        fromEmail = mb.getFrom();//邮件发送人
        //String subject = PropertyUtil.getProperty("subject");//邮件主题
        String subject = mb.getSubject();
        String content = mb.getContent();
        String fileName = mb.getFilename();
        Vector<String> file = mb.getFile();
        String type = mb.getType();
        String nick = mb.getNick();
        String emailType = mb.getEmailType();
        password = mb.getPassword();
        
        logger.debug("read properties");
        Properties props = System.getProperties();
        logger.debug("get host");
        String host = "";
        if(MailBean.EMAIL_TYPE.QQ.value().equalsIgnoreCase(emailType)){
            host = PropertyUtil.getProperty("qqHost");                              // 设置SMTP的主机
        }else if(MailBean.EMAIL_TYPE.EARTH.value().equalsIgnoreCase(emailType)){
            host = PropertyUtil.getProperty("earthHost");
        }else if(MailBean.EMAIL_TYPE.NET_EASE.value().equalsIgnoreCase(emailType)){
            host = PropertyUtil.getProperty("netEaseHost");
        }

        props.put("mail.smtp.host",host);

        props.put("mail.smtp.auth", "true");            // 需要经过验证
        if(host.contains("gmail")){
        	props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
        	props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
        	props.setProperty("mail.smtp.port", "465"); 
        	props.setProperty("mail.smtp.socketFactory.port", "465"); 
        }
 
        logger.debug("authen password");
        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail,   password);
            }
        });
 
        try {
        	logger.debug("connect nick");
            MimeMessage msg = new MimeMessage(session);
            if(StringUtils.isNotBlank(nick)){
            	nick = MimeUtility.encodeText(nick);
                fromEmail = nick+"<"+fromEmail+">";
            }
            msg.setFrom(new InternetAddress(fromEmail));
            new InternetAddress();
            logger.debug("转化发送地址！");
			InternetAddress[] address = InternetAddress.parse(mb.getTo());
            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(toChinese(subject));
            msg.setSubject(subject);
 
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbpContent = new MimeBodyPart();
            if("html".equals(type)){
            	mbpContent.setContent(content, "text/html;charset=gb2312");
            }else {
            	mbpContent.setText(content);
			}
            mp.addBodyPart(mbpContent);
 
            logger.debug("add file");
            /*    往邮件中添加附件    */
            if(null!=file){
            	Enumeration<String> efile = file.elements();
            	while (efile.hasMoreElements()) {
            		MimeBodyPart mbpFile = new MimeBodyPart();
            		fileName = efile.nextElement().toString();
            		FileDataSource fds = new FileDataSource(fileName);
            		mbpFile.setDataHandler(new DataHandler(fds));
            		mbpFile.setFileName(fds.getName());
            		mp.addBodyPart(mbpFile);
            	}
            }
 
            msg.setContent(mp);
            msg.setSentDate(new Date());
            try {
            	logger.debug("send email");
            	Transport.send(msg);
			} catch (Exception e) {
				throw new BaseException("发送失败");
			}
            
            
        } catch (MessagingException me) {
            me.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
        return true;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
		
    	/*MailBean mailBean = new MailBean();
    	mailBean.setContent("越哥你真帅！");
    	mailBean.setSubject("邮件主题");
    	mailBean.setTo("1225342162@qq.com");
		SendMail.sendMail(mailBean);*/
		String test = "aaaaa,vvvvv,vvvvdd,ddd";
		int a = test.indexOf(",");
		int b = test.indexOf(",",test.indexOf(",")+1);
		String d = test.substring(a,b);
		System.out.print(d);
	}
}

