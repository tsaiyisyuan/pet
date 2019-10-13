package com.tw.dao;

import java.sql.SQLException;
import java.util.List;

import com.tw.vo.PetBean;



public interface PetInterface {
	public List<PetBean> queryAll();
	public void queryDB(PetBean PB) throws SQLException;
	public void insert (PetBean PB)throws SQLException;
	public void update (PetBean PB) throws SQLException;
    public void delete(int productId) throws SQLException; //int number?
    public void createConn() throws SQLException;
	public void closeConn() throws SQLException;
	
	
	
	
}
