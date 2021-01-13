package pack.member;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;



import javax.naming.Context;

import javax.naming.InitialContext;

import javax.sql.DataSource;



public class MemberMgr {

		private Connection conn;

		private PreparedStatement pstmt;

		private ResultSet rs;

		private DataSource ds;

	

	public MemberMgr() {

		try {

			Context context = new InitialContext();

			ds = (DataSource)context.lookup("java:comp/env/jdbc/system");
			

		} catch (Exception e) {

			System.out.println("BoardMgr err : " + e);

		}

	}
	

	public boolean checkId(String id) { // regform�� ���ļ� registerproc.jsp �� ���ư�

		boolean b = false;

		try {

			String sql = "select id from member where id=?";

			conn =ds.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			b = rs.next();	

		} catch (Exception e) {

			System.out.println("checkId err" + e);

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return b;

	}

	

	public boolean memInsert(MemberBean bean) {

		boolean b = false;

		try {

			conn = ds.getConnection();

			String sql = "insert into member values(?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getId());

			pstmt.setString(2, bean.getPasswd());

			pstmt.setString(3, bean.getname());

			pstmt.setString(4, bean.getEmail());

			pstmt.setString(5, bean.getPhone());

			pstmt.setString(6, bean.getAddress());


			if(pstmt.executeUpdate() > 0) b = true;

			

		} catch (Exception e) {

			// TODO: handle exception

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return b;

	}

	

	public boolean loginCheck(String id, String passwd) {

		boolean b = false;

		try {

			conn = ds.getConnection();

			String sql = "select * from member where id=? and passwd=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			pstmt.setString(2, passwd);

			rs = pstmt.executeQuery();

			b = rs.next();

		} catch (Exception e) {

			// TODO: handle exception

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return b;

	}

	

	public MemberBean getMember(String id) { //memberupdate.jsp�� ���� ��

		MemberBean bean = null;

		try {

			conn = ds.getConnection();

			String sql = "select * from member where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				bean = new MemberBean();

				bean.setId(rs.getString("id"));

				bean.setPasswd(rs.getString("passwd"));

				bean.setname(rs.getString("name"));

				bean.setEmail(rs.getString("email"));

				bean.setPhone(rs.getString("phone"));

				bean.setAddress(rs.getString("address"));

	

			}

			

		} catch (Exception e) {

			System.out.println("getMember err: " + e);

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return bean;

	}

	

	public boolean memberUpdate(MemberBean bean, String id) {

		boolean b = false;

		try {

			conn = ds.getConnection();

			String sql = "update member set passwd=?, name=?, email=?, phone=?, address=? where id=?";

			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, bean.getPasswd());

			pstmt.setString(2, bean.getname());

			pstmt.setString(3, bean.getEmail());

			pstmt.setString(4, bean.getPhone());

			pstmt.setString(5, bean.getAddress());

            pstmt.setString(6, id);

			if(pstmt.executeUpdate() > 0) b = true; //����� 0 �̻��̸� return



		} catch (Exception e) {

			System.out.println("memeberUpdate err : " + e);

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return b;

	}

	

	public boolean adminLoginCheck(String adminid, String adminpasswd) {

		boolean b = false;

		try {

			conn = ds.getConnection();

			String sql = "select * from admin where admin_id=? and admin_passwd=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, adminid);

			pstmt.setString(2, adminpasswd);

			rs = pstmt.executeQuery();

			b = rs.next();	

		} catch (Exception e) {

			// TODO: handle exception

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return b;

	}

	



	

	public ArrayList<MemberBean> getMemberAll() {

		ArrayList<MemberBean> list = new ArrayList<>();

		try {

			conn = ds.getConnection();

			String sql = "select * from member";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				MemberBean bean = new MemberBean();

				bean.setId(rs.getString("id"));

				bean.setname(rs.getString("name"));

				bean.setEmail(rs.getString("email"));

				bean.setPhone(rs.getString("phone"));

				list.add(bean);	

			}

		} catch (Exception e) {

			System.out.println("getMemberAll err:" + e);

		}finally {

			try {

				if(rs != null) rs.close();

				if(pstmt != null) pstmt.close();

				if(conn != null) conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}	

		}

		return list;

	}



	

}