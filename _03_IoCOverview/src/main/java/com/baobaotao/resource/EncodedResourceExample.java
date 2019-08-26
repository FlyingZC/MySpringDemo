package com.baobaotao.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 *
 */
public class EncodedResourceExample {
    public static void main(String[] args) throws Throwable {
        Resource res = new ClassPathResource("conf/file1.txt");
        // 资源加载时默认采用系统编码读取资源内容，如果资源文件采用特殊的编码格式，
        // 那么可以通过EncodedResource对资源进行编码，以保证资源内容操作的正确性
        EncodedResource encRes = new EncodedResource(res, "UTF-8");
        String content = FileCopyUtils.copyToString(encRes.getReader());
        System.out.println(content);
    }
}
