package cn.smlcx.universal.utils;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 重命名文件
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 */
	public static String renameFileName(String path, String fileName) {
		File file = new File(path +"/"+ fileName);// 获取要报存的文件路径
		System.out.println(StringUtil.getFileType(fileName));
		if (file.exists()
				&& (StringUtil.getFileType(fileName).equals("jpg")
						|| StringUtil.getFileType(fileName).equals("jpeg")
						|| StringUtil.getFileType(fileName).equals("png") || StringUtil
						.getFileType(fileName).equals("bmp")))// 如果文件已存在就重命名，不存在就直接返回
		{
			return System.currentTimeMillis()+"."+StringUtil.getFileType(fileName) ;
		}
		return fileName;
	}

	/**
	 * 判断字符串是否非空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNullOrEmpty(String s) {
		if (null == s || "".equals(s)) {
			return true;
		}
		return false;
	}

	/**
	 * 根据文件名获得文件类型
	 * 
	 * @param s
	 * @return
	 */
	public static String getFileType(String s) {
		return s.substring(s.lastIndexOf(".") + 1);
	}

	public static String getFileName(String s) {
		return s.substring(0, s.lastIndexOf("."));
	}
	
	
	public static boolean isNumber(String str){
		boolean flag = false;
		//判断正负数都可以
		//Pattern pattern = Pattern.compile("^[-]{0,1}[0-9]+$");
		Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
		Matcher isNum = pattern.matcher(str);
		if(isNum.matches()){
			flag = true;
		}
		return flag;
	}
	
	public static String getPropValue(String key){
		// action配置文件路径  
		@SuppressWarnings("unused")
		String config_path = "WEB-INF/classes/config.properties";
		// 属性文件   
		Properties prop = new Properties();
		// 把文件读入文件输入流，存入内存中     
		InputStream fis;
		try {
			//fis = new FileInputStream(new File(path + config_path));
			fis =StringUtil.class.getClassLoader().getResourceAsStream("config.properties");
			//加载文件流的属性     
			prop.load(fis); 
			return prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}     
	}
	
	public static String getNewString(String str) throws UnsupportedEncodingException
    {
       return new String(str.getBytes("ISO-8859-1"),"UTF-8");
    }
}
