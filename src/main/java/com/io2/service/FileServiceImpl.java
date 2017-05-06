package com.io2.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Niki on 2017-05-06.
 */
@Service
@PropertySource("classpath:S3settings.properties")

public class FileServiceImpl implements FileService {

    private String bucketName = "sneakers-images";
    @Value("${amazon.accessKey}")
    private String accessKey;
    @Value("${amazon.secretKey}")
    private String secretKey;
    private Logger logger = Logger.getLogger(FileService.class.getName());

    @Override
    public String uploadFile(InputStream file) {
        String filename = null;
        try {
            UUID uuid = UUID.randomUUID();
            filename = "upload_" + uuid.toString();
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withRegion(Regions.US_EAST_1)
                    .build();
            s3Client.putObject(new PutObjectRequest(
                    bucketName, filename, file, new ObjectMetadata()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    @Override
    public void getFile(String filename, HttpServletResponse response) {
        try {
            logger.log(Level.INFO, "DUPA");
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withRegion(Regions.US_EAST_1)
                    .build();
            S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, filename));
            InputStream is = object.getObjectContent();
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
//            response.setStatus(404);
            ex.printStackTrace();
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
