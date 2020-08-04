package com.sy.excel.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sy.common.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 读取转换异常
 *
 * @author Jiaju Zhuang
 */
public class DemoExceptionListener extends AnalysisEventListener<DemoData> {

    @Autowired
    private SpringContextUtils springContextUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoExceptionListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<ExceptionDemoData> list = new ArrayList<ExceptionDemoData>();
    private static  int FAIL_COUNT = 0;
    private static  int SUCESS_COUNT = 0;
    /**
     * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        LOGGER.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        FAIL_COUNT+=1;
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
            LOGGER.error("第{}行，第{}列解析异常，数据为:{}", excelDataConvertException.getRowIndex(),
                excelDataConvertException.getColumnIndex(), excelDataConvertException.getCellData());
        }
    }

    /**
     * 这里会一行行的返回头
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        LOGGER.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        SUCESS_COUNT +=1;
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        RedisService redisService = (RedisService)springContextUtils.getBean("redisService");
        redisService.setCacheObject("FAIL_COUNT",FAIL_COUNT);
        redisService.setCacheObject("SUCESS_COUNT",SUCESS_COUNT);
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }
}
