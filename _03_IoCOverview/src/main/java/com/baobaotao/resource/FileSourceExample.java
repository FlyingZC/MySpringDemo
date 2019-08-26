package com.baobaotao.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * spring resource接口实现类
 * FileSystemResource, ClassPathResource
 */
public class FileSourceExample {
    public static void main(String[] args) {
        try {
            String filePath = "D:\\myworkspace\\00opendemo\\Spring3.xEnterpriseAppDevInAction\\_03_IoCOverview\\src\\main\\resources\\conf\\file1.txt";
            // 使用系统文件路径加载文件
            Resource res1 = new FileSystemResource(filePath);
            // 使用类路径加载文件
            Resource res2 = new ClassPathResource("conf/file1.txt");

            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();
            System.out.println("res1:" + res1.getFilename());
            System.out.println("res2:" + res2.getFilename());

            // 如果有web环境,还可以用 ServletContextResource以相对于Web应用根目录的方式访问文件资源
            // Resource res3 = new ServletContextResource(servletContext, "/WEB-INF/classes/conf/file1.txt")

            // 对于位于远程服务器（Web服务器或FTP服务器）的文件资源，用户可以方便地通过UrlResource进行访问。

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
