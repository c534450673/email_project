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

	public Vector<String> getFile() {
		return file;
	}

	public void attachFile(String fileName) {
		if (file == null)
			file = new Vector<String>();
		file.addElement(fileName);
	}
}
