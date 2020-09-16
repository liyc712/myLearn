package com.liyc.common.utill.test;

import com.liyc.common.util.easyexcel.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Author lyc
 * @Date 2020-8-26 16:43
 * @ClassName ExcelTest
 * @Description TODO
 */
public class ExcelTest {


    @Test
    public void readExcel(){
        String filePath = "C:\\Users\\lyc\\Desktop\\xm.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
        objects.forEach(System.out::println);
    }
}
