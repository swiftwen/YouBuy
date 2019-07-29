package com.wp.youbuy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 正则表达式工具类
 * @author swiftwen
 * @date 2019年1月23日 下午5:17:07
 */
@Component
public class RegexUtil {

	/**
	 * 匹配图片券码
	 * @param content
	 * @param recognizeStrs
	 * @return
	 */
	public String matchCode(String content, String[] recognizeStrs){
		Pattern p=Pattern.compile("[0-9a-zA-Z]+"); 
		
		String ans = "";
		for(String s : recognizeStrs){
			Matcher m=p.matcher(s); 
			
			while(m.find()) { 
			    if(StringUtils.isNotBlank(content)){
			    	String tmpStr = m.group();
			    	if(s.contains(content)){
			    		ans = tmpStr;
			    	}
			    }
			} 
		}
		return ans;
	}
	
	
	/*public static void main(String[] args) throws Exception{
		
		Pattern p=Pattern.compile("[0-9a-zA-Z]+"); 
		Matcher m=p.matcher("我们cc1234aaa"); 
		if(m.find()) { 
		     System.out.println(m.group()); 
		} 
	}*/
	
}
