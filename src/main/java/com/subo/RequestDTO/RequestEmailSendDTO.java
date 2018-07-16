package com.subo.RequestDTO;

import lombok.Data;

@Data
public class RequestEmailSendDTO {

    private String sendTo;

    private String context;

    private String emailSubject;

    private String from;

    private String password;

    private String emailType;

}

