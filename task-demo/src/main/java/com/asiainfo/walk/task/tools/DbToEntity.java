package com.asiainfo.walk.task.tools;

import org.walkframework.base.system.common.Common;
import org.walkframework.batis.tools.dbtobean.CreateBeanConfig;
import org.walkframework.batis.tools.dbtobean.CreateBeans;
import org.walkframework.data.util.IData;

/**
 * 根据数据库表生成实体类
 *
 */
public abstract class DbToEntity {
	
    @SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
    	IData resource = Common.getInstance().getProperties("boot-ds.xml", "Resource");
		CreateBeanConfig appConfig = new CreateBeanConfig();
		appConfig.setDriverClassName(resource.getString("driverClassName"));
		appConfig.setDburl(resource.getString("jdbcUrl"));
		appConfig.setDbusername(resource.getString("username"));
		appConfig.setDbpassword(resource.getString("password"));
		
		String packageName = "com.asiainfo.walk.task.mvc.entity";
		String packagePath = "D:\\Workspace\\github\\walk-demo\\task-demo\\src\\main\\java\\com\\asiainfo\\walk\\task\\mvc\\entity";

		String[][] tables = new String[][] {
			new String[] {"TD_M_USER", packageName, packagePath},
		};
		CreateBeans.createJavaBean(tables, appConfig);
    }
}
