package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn=conn;
	}

	//=======================================================================================================================================

	@Override
	public void insert(Department department) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO department(Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, department.getName());
			int rows = st.executeUpdate();
			if(rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					department.setId(id);
				}
				DB.closeResultSet(rs);
			}
		}catch(SQLException e) {
			throw new DbException("Erro :" + e.getLocalizedMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	//=======================================================================================================================================

	@Override
	public void update(Department department) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE department "
					+ "SET Id = ?, Name = ? "
					+ "WHERE Id = ?");
			st.setInt(1, department.getId());
			st.setString(2, department.getName());
			st.setInt(3, department.getId());
			st.executeUpdate();

		}catch(SQLException e) {
			throw new DbException("Erro :" + e.getLocalizedMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	//=======================================================================================================================================

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM department "
					+ "WHERE Id = ?");
			st.setInt(1, id);
			int rows = st.executeUpdate();
			if(rows == 0)
				throw new DbException("Employee from Id: " + id + " Inexistent!!!");

		}catch(SQLException e) {
			throw new DbException("Erro :" + e.getLocalizedMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	//=======================================================================================================================================

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM department WHERE id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			if(rs.next()) {
				Department derp = instantiateDepartment(rs);
				return derp;
			}

			return null;

		}catch(SQLException e) {
			throw new DbException("Erro :" + e.getLocalizedMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	//=======================================================================================================================================

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> depList = new ArrayList<>();

		try {
			st = conn.prepareStatement("SELECT * FROM department");

			rs = st.executeQuery();

			while(rs.next()) {
				Department d = instantiateDepartment(rs);
				depList.add(d);
			}

			return depList;

		}catch(SQLException e) {
			throw new DbException("Erro :" + e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	//=======================================================================================================================================

	private Department instantiateDepartment(ResultSet rs) throws SQLException{
		Department derp = new Department();
		derp.setId(rs.getInt("Id")); //seller.DerpartmentId (Esse e o ID) = department.Id
		derp.setName(rs.getString("Name"));
		return derp;
	}
}
