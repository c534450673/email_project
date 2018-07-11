package com.subo.entity;

import java.util.Vector;

import lombok.Data;

@Data
public class MailBean {
	private String to; // 收件人
	private String from; // 发件人
	private String host; // SMTP主机
	private String username; // 发件人的用户名
	private String password; // 发件人的密码
	private String subject; // 邮件主题
	private String content; // 邮件正文
	Vector<String> file; // 多个附件
	private String filename; // 附件的文件名
	private String type; // type text html类别
	private String nick; // 昵称

	public Vector<String> getFile() {
		return file;
	}

	public void attachFile(String fileName) {
		if (file == null)
			file = new Vector<String>();
		file.addElement(fileName);
	}
}
