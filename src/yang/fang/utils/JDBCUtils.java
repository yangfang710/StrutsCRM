package yang.fang.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库操作工具类
 * 
 * @author Administrator
 * 
 */
public class JDBCUtils {
	// 初始化 c3p0 连接池
	// private static DataSource dataSource = new
	// ComboPooledDataSource();//上下两句都可以
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 获得数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	// 生成客户编号 UUID
	public static String generateCustomerId() {
		String uuid = UUID.randomUUID().toString();
		int hashcode = Math.abs(uuid.hashCode());
		return "customer_" + hashcode;
	}
}
