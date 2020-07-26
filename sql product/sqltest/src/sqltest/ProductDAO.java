package sqltest;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class ProductDAO {
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://127.0.0.1/javadb";
	Connection conn;

	PreparedStatement pstmt = null;
	ResultSet rs;

	Vector<String> items = null;
	String sql;

	public ArrayList<Product> getAll() {
		connectDB();
		sql = "selct * from product";

		ArrayList<Product> datas = new ArrayList<Product>();

		items = new Vector<String>();
		items.add("ÀüÃ¼");

		try {
			while (rs.next()) {
				Product p = new Product();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManufacture(rs.getString("manufacture"));
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public void connectDB() {
		try {
			Class.forName(jdbcDriver);

			conn = DriverManager.getConnection(jdbcUrl, "Seoin", "eogkrrkwk15");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Product getProduct(int prcode) {
		sql = "select *from product where prcode = ?";
		Product p = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			rs = pstmt.executeQuery();
			rs.next();
			p = new Product();
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManufacture(rs.getString("manufacture"));
		}catch(SQLException e) {
			e.printStackTrace();
			}
		return p;
	}

	public boolean newProduct(Product product) {
		sql = "insert into product(prname, price , manufacture) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrcode());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delProduct(int prcode) {
		sql = "delete product prcode = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			pstmt.executeUpdate("DELETE FROM product WHERE prcode <= 1");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		sql = "update product set prname = ?, preice = ?, manufacture = ? where prcode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrcode());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Vector<String> getItems(){
		return items;
	}

}