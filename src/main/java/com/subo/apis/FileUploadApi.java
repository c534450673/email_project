package com.subo.apis;

import com.subo.common.ResponseDTO;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Component
@Path("/file")
public class FileUploadApi {

    @Path("/upload")
    @POST
    public ResponseDTO fileUpload(){

        


        return null;
    }
}
