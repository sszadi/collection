package com.io2.service;

import java.io.InputStream;

/**
 * Created by Niki on 2017-05-06.
 */
public interface FileService {
    boolean uploadFile(InputStream file);

    boolean getFile(String filename);
}
