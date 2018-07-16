package com.subo.entity;

import java.util.Vector;

import lombok.Data;

@Data
public class MailBean {
	private String to; // �ռ���
	private String from; // ������
	private String host; // SMTP����
	private String username; // �����˵��û���
	private String password; // �����˵�����
	private String subject; // �ʼ�����
	private String content; // �ʼ�����
	Vector<String> file; // �������
	private String filename; // �������ļ���
	private String type; // type text html���
	private String nick; // �ǳ�
	private String emailType; // �ʼ�����

	public enum EMAIL_TYPE{

		EARTH("earth"),
		QQ("qq"),
		NET_EASE("netEase");

		private final String value;
		EMAIL_TYPE(String value) {
			this.value = value;
		}
		public String value() {
			return value;
		}

	}

	public Vector<String> getFile() {
		return file;
	}

	public void attachFile(String fileName) {
		if (file == null)
			file = new Vector<String>();
		file.addElement(fileName);
	}
}
