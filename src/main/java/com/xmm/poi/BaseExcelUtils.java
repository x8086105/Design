package com.xmm.poi;

import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xuemingming
 * @Date: 2019/2/1 9:51
 **/

    public  class BaseExcelUtils<T,S> {

    public void exportExcelBySXSSF(String[] titles, Integer headerMerge, Map<T, List<S>> map) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        //keep 100 rows in memory, exceeding rows will be flushed to disk
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sheet = wb.createSheet();
        AtomicInteger rowSize = new AtomicInteger(1);
        //填充表头
        Row headRow = sheet.createRow(0);
        //合并组名
        Cell headCell = headRow.createCell(0);
        headCell.setCellValue(titles[0]);
        // CellRangeAddress 1.起始行 2.结束行 3.起始列 4.结束列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
        for(int i = 1;i<titles.length; i++){
            Cell cell = headRow.createCell(i+1);
            cell.setCellValue(titles[i]);
        }
//            Type superClass = this.getClass().getGenericSuperclass();
//            Type oriType = ((ParameterizedType) superClass).getActualTypeArguments()[1];
        int endRowIndex = rowSize.get();
        for (Map.Entry<T, List<S>> entry : map.entrySet()) {
            T t = entry.getKey();
            List<S> v = entry.getValue();
            // 填充实体数据start
            for (int i = endRowIndex; i < v.size() + endRowIndex; i++) {
                S s = v.get(0);
                Class classz = s.getClass();
                Field[] fis = classz.getDeclaredFields();
                Row row = sheet.createRow(i);
                for (int o = headerMerge; o < fis.length + headerMerge; o++) {
                    Field field = fis[o - headerMerge];
                    String firstChar = field.getName().substring(0, 1).toUpperCase();
                    Method method = classz.getMethod("get" + firstChar + field.getName().substring(1));
                    Object value = method.invoke(s);
                    Cell cell = row.createCell(o);
                    cell.setCellValue(value.toString());
                }
            }
            // 填充实体数据end
            //填充 分组组名
            Row row = sheet.getRow(endRowIndex);
            Cell cell = row.createCell(0);
            cell.setCellValue(t.toString());
            // CellRangeAddress 1.起始行 2.结束行 3.起始列 4.结束列
            sheet.addMergedRegion(new CellRangeAddress(endRowIndex, endRowIndex + v.size(), 0, headerMerge - 1));
            endRowIndex += v.size();
        }


        FileOutputStream out = new FileOutputStream("D:\\new.xlsx");
        wb.write(out);
        out.close();
        wb.dispose();

    }


    /**
     * 从数据源导出Excel文档（大数据）
     * 根据组进行分组显示
     *
     * @param
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Map<String, List<Person>> m = new HashMap<>();
        m.put("xx1", Lists.newArrayList(Person.builder().age(1).name("x1").build()));
        m.put("xx2", Lists.newArrayList(Person.builder().age(2).name("x2").build()));
        m.put("xx3", Lists.newArrayList(Person.builder().age(3).name("x3").build()));
        m.put("xx4", Lists.newArrayList(Person.builder().age(4).name("x4").build()));
        new BaseExcelUtils<String, Person>() {
        }.exportExcelBySXSSF(new String[]{"组名","年龄","姓名"}, 2, m);
    }

}
