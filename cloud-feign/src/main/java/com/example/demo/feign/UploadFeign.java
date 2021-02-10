package com.example.demo.feign;

//import com.example.demo.config.UploadConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

//@FeignClient(value = "cloud-provider", configuration = UploadConfig.class)
@FeignClient(value = "cloud-provider")
public interface UploadFeign {
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFile(@RequestPart("file") MultipartFile file);
}