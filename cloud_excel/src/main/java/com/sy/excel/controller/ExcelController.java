package com.sy.excel.controller;

import com.alibaba.excel.EasyExcel;
import com.sy.excel.config.DemoData;
import com.sy.excel.config.DemoExceptionListener;
import com.sy.excel.config.ExceptionDemoData;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author siyuan
 * @create 2020/6/18
 */
@RequestMapping("/excel")
@RestController
public class ExcelController {

    /**
     * 数据转换等异常处理
     *
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ExceptionDemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoExceptionListener}
     * <p>
     * 3. 直接读即可
     */
    @PostMapping("/import")
    public void exceptionRead(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(file.getInputStream(), DemoData.class, new DemoExceptionListener()).sheet().doRead();
    }

    @PostMapping("/name")
    public void excelName(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        boolean setDisposition = isSetDisposition(file);
    }

    public static boolean isSetDisposition(MultipartFile file) {
        String text1 = ".xlsx";
        String text2 = ".xls";
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        if (text1.equals(suffix) || text2.equals(suffix)) {
            return true;
        }
        return false;
    }


    private static byte[] lock = new byte[0];

    // 位数，默认是8位
    private final static long w = 100000000;


    public static void main(String[] args) {


    }

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return System.currentTimeMillis() + String.valueOf(r).substring(1);
    }
}
