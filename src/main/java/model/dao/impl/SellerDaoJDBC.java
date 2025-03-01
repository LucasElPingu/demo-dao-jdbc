package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	//=======================================================================================================================================

	@Override
	public void insert(Seller Seller) {
		// TODO Auto-generated method stub

	}

	//=======================================================================================================================================

	@Override
	public void update(Seller Seller) {
		// TODO Auto-generated method stub

	}

	//=======================================================================================================================================

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	//=======================================================================================================================================

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT seller.*, department.Name AS DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();

			if(rs.next()) {
				Department derp = instantiateDepartment(rs);
				Seller seller = instantiateSeller(rs, derp);
				return seller;
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
	public List<Seller> findByDepartment(Department dep) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Map<Integer, Department>depMap = new HashMap<>();
		List<Seller> sellerList = new ArrayList<>();

		try {
			st = conn.prepareStatement("SELECT seller.*, department.Name AS DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON DepartmentId=department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY seller.Name;");
			st.setInt(1, dep.getId());
			rs = st.executeQuery();

			while(rs.next()) {

				Department derp = depMap.get(rs.getInt("DepartmentId"));

				if(derp == null) {
					derp = instantiateDepartment(rs);
					depMap.put(rs.getInt("DepartmentId"), derp);
				}

				Seller seller = instantiateSeller(rs, derp);
				sellerList.add(seller);
			}
			
			return sellerList;

		}catch(SQLException e) {
			throw new DbException("Erro :" + e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	//=======================================================================================================================================

	@Override
	public List<Seller> findAll() {
		return null;
	}

	//=======================================================================================================================================

	private Seller instantiateSeller(ResultSet rs, Department derp) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		LocalDate datee = rs.getDate("BirthDate").toLocalDate();
		seller.setDepartment(derp);
		seller.setBirthDate(datee);
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException{
		Department derp = new Department();
		derp.setId(rs.getInt("DepartmentId")); //seller.DerpartmentId (Esse e o ID) = department.Id
		derp.setName(rs.getString("DepName"));
		return derp;
	}

}
