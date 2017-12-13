package com.sxt.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期类型转换器
 * @author Administrator
 *
 */
public class DateConverter implements Converter<String, Date> {
    
	private SimpleDateFormat[] sdfs = {new SimpleDateFormat("yyyy-MM-dd"),
			                           new SimpleDateFormat("yyyy/MM/dd"),
			                           new SimpleDateFormat("yyyy.MM.dd")};
	
	//将日期字符串转变成日期对象
	public Date convert(String dataStr) {
    	Date date = null; 
    	
    	for (SimpleDateFormat sdf : sdfs) {
			try {
				date = sdf.parse(dataStr);
				return date;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	return date;
    }
}
