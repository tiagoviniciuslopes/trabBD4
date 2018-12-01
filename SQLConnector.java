

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnector {

	private Connection connection;
	private Statement statement;

	public SQLConnector() throws Exception {
		String url = "jdbc:mysql://127.0.0.1/sanepar?autoReconnect=true&useSSL=false";
		String usuario = "root";
		String senha = "bancodedados";
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, usuario, senha);
		statement = connection.createStatement();
	}

	public ResultSet executeQuery(String cmd) throws Exception {
		return statement.executeQuery(cmd);
	}

	public ResultSet getKeys() throws Exception {
		return statement.getGeneratedKeys();
	}

	public void executeUpdate(String cmd) throws Exception {
		statement.executeUpdate(cmd, Statement.RETURN_GENERATED_KEYS);
	}
	
	public int executeUpdateLastInserId(String cmd) throws Exception { 
		statement.executeUpdate(cmd, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs;
		rs=statement.getGeneratedKeys();
		
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	public boolean execute(String cmd) throws Exception {
		return statement.execute(cmd);
	}
	
	public int updateCount() throws Exception {
		return statement.getUpdateCount();
	}

	public void close() throws Exception {
		statement.close();
		connection.close();
	}

	public static String queryString(String src) {
		if (src == null) {
			return "NULL";
		}
		String result = "\"";
		int length = src.length();
		for (int i=0; i<length; ++i) {
			char chr = src.charAt(i);
			if (chr == '\n') {
				result += "\\n";
			} else if (chr == '\t') {
				result += "\\t";
			} else {
				if (chr == '"' || chr == '\\')
					result += '\\';
				result += chr;
			}
		}
		return result + "\"";
	}

}