package com.io2.service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by Niki on 2017-05-06.
 */
public interface FileService {
    String uploadFile(InputStream file);

    void getFile(String filename, HttpServletResponse response);

}
