package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public interface DAOInterface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public void selectAll() throws SQLException, ClassNotFoundException;
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
	
}