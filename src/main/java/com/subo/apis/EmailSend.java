package com.subo.apis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.ValidationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subo.Constants.Code;
import com.subo.Constants.Message;
import com.subo.Constants.SubCode;
import com.subo.RequestDTO.RequestEmailSendDTO;
import com.subo.common.ResponseDTO;
import com.subo.entity.MailBean;
import com.subo.utils.ParamValidation;
import com.subo.utils.SendMail;
import com.subo.utils.TransferRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/email")
@Component
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML,MediaType.TEXT_HTML})
@Consumes({MediaType.APPLICATION_JSON})
public class EmailSend {

	@Autowired
	ObjectMapper objectMapper;

	@SuppressWarnings("rawtypes")
	@Path("/send")
	@POST
	public ResponseDTO sendEmail(@QueryParam("email")String email) throws IOException, ValidationException {
		/**
		 * 将body参数的值传入并封装成对象
		 * **/
		String requestBody = TransferRequestBody.transferRequestBodyStream();
		RequestEmailSendDTO requestEmailSendDTO = objectMapper.readValue(requestBody,RequestEmailSendDTO.class);

		/**
		 * 获得相关属性
		 * **/
		String context = requestEmailSendDTO.getContext();
		String sendTo = requestEmailSendDTO.getSendTo();
		String subject = requestEmailSendDTO.getEmailSubject();
		String from = requestEmailSendDTO.getFrom();
		String password = requestEmailSendDTO.getPassword();
		String emailType = requestEmailSendDTO.getEmailType();

		/**
		 * 验证body参数是否为空
		 * **/
		Map parameterInfos = new HashMap<String,String>();
		parameterInfos.put("context",context);
		parameterInfos.put("sendTo",sendTo);
		parameterInfos.put("from",from);
		parameterInfos.put("password",password);
		parameterInfos.put("emailType",emailType);
		ParamValidation.validateRequiredData(parameterInfos);

		/**
		 * 封装新的对象
		 * **/
		MailBean mailBean = new MailBean();
		mailBean.setTo(sendTo);
    	mailBean.setContent(context);
    	mailBean.setSubject(subject);
    	mailBean.setFrom(from);
    	mailBean.setPassword(password);
    	mailBean.setEmailType(emailType);

    	/**
		 * 邮件发送
		 * **/
		SendMail.sendMail(mailBean);
		
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(Code.SUCCESS.value());
		responseDTO.setMessage(Message.SUCCESS.value());
		
		return responseDTO;
		
	}
	
}
