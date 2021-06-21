package cn.bdqn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件工具类--单例模式（有且仅有一个实例）
public class ConfigManager {

	//读取配置文件Properties.load(inputstream)
	private static ConfigManager configManager;
	private static Properties properties;
	
	//构造方法(把配置文件load到properties)
	private ConfigManager(){
		String configFile = "database.properties";
		properties = new Properties();
		//通过classpath获取资源 ，通过当前类所在包的根目录下去查找资源文件
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 线程不安全，在并发环境下，很有可能会出现多个configManager实例
	 * 需要考虑同步，可以采用synchronized
	 * 懒汉模式
	 */
	//提供一个全局的访问点
	public static synchronized ConfigManager getInstance(){
		if(configManager == null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	public String getString(String key){
		return properties.getProperty(key);
		
	}
}
