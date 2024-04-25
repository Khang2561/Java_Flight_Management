package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public interface DAOInterface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
		return null;
	}
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
	
}