package cn.alia.test;

import cn.alia.dto.DemoData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;

public class TestEasyExcel {

    @Test
    public void testRead1() {
        //读取的文件路径
        String fileName="user11.xlsx";
        Class<DemoData> head = DemoData.class; //创建一个数据格式来承装读取到数据
        //读取数据
        EasyExcel.read(fileName, head, new AnalysisEventListener<DemoData>() {

            /**
             * 解析每一条数据的时候被调用
             */
            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                //在这里操作，将解析的每一条数据保存到数据库中,在这里可以调用数据库
                System.out.println("解析的数据为: "+data);
            }

            /**
             * 解析完所有数据的时候被调用
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("数据解析完成..........");
            }
        }).sheet().doRead();

    }



    /*
     * 最简单的读取Excel内容(方式二)
     * 默认读取Excel文件中的第一个sheet
     */
    @Test
    public void testRead2() {
        //读取的文件路径
        String fileName="user11.xlsx";
        Class<DemoData> head = DemoData.class; //创建一个数据格式来承装读取到数据
        //创建ExcelReader对象
        ExcelReader excelReader = EasyExcel.read(fileName, head, new AnalysisEventListener<DemoData>() {

            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                System.out.println("读取到的数据为:"+data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("数据解析已完成");
            }
        }).build();
        //创建sheet对象,并读取Excel的第1个sheet(下标从0开始)
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        //关闭流操作，在读取文件时会创建临时文件,如果不关闭,磁盘爆掉
        excelReader.finish();
    }
}
