package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Dao => Data Access Object �� ����
 *  
 *  - ȸ�� ������ ���ؼ� SELECT , INSERT, UPDATE, DELETE 
 *    �۾��� ������ ��ü�� �����ϱ����� Ŭ���� �����ϱ�
 *  
 *  - Application �������� MemberDao ��ü�� ���� 1���� 
 *    �����ɼ� �ֵ��� �����Ѵ�.
 */
public class MemberDao {
	//1. �ڽ��� �������� ���� private static �ʵ� �����
	private static MemberDao dao;
	//2. �ܺο��� ��ü �����Ҽ� ������ �������� ���������ڸ�
	//   private �� ���� 
	private MemberDao() {}
	//3. �ڽ��� �������� �������ִ� static �ɹ� �޼ҵ� ����� 
	public static MemberDao getInstance() {
		if(dao==null) {
			dao=new MemberDao();
		}
		return dao;
	}
	

	// DB �� ȸ�� ����� �������ִ� �޼ҵ�
	public List<MemberDto> getList(){
		Connection conn=null;
		//�ʿ��� ��ü�� ���� ���� ����� 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//MemberDto ��ü�� ���� ArrayList ��ü����
		List<MemberDto> list=new ArrayList<>();
		try{
			conn=new DBConnect().getConn();
			//������ sql �� �غ� 
			String sql="SELECT empno, ename, dname, loc FROM emp e, dept d WHERE e.deptno=d.deptno ORDER BY empno ASC";//�������� ���� DESC
			//PreparedStatement ��ü�� ������ ������
			//(sql ���� ��� �������� ��ü)
			pstmt=conn.prepareStatement(sql);
			//ResultSet ��ü�� ������ ������ 
			//(SELECT ���� ���� ��� ���� ������ �ִ� ��ü)
			rs=pstmt.executeQuery();
			//�ݺ��� ���鼭 cursor �� ��ĭ�� ������. 
			while(rs.next()){
				//���� cursor �� ��ġ�� ���� 
				//row ���� ���ϴ� Į���� �����͸� ���´�.
				int empNum=rs.getInt("empno");
				String name=rs.getString("ename");
				String dName=rs.getString("dname");
				String loc=rs.getString("loc");
				
				//MemberDto ��ü�� ȸ������ ���
				MemberDto dto=new MemberDto(empNum, name, dName, loc);
				//ArrayList ��ü�� MemberDto ��� 
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}//try
		
		return list;
	}
}