package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class EmpTest extends JFrame{
	//멤버필드 정의
	//테이블 모델
	DefaultTableModel model;
	JTable table;
	//생성자
	public EmpTest() {
		initUI();
	}
	//UI초기화 작업 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		
//		JLabel label1=new JLabel("사원번호");
//		JLabel label2=new JLabel("이름");
//		JLabel label3=new JLabel("부서명");
//		JLabel label4=new JLabel("부서의위치");
//		
//		panel.add(label1);
//		panel.add(label2);
//		panel.add(label3);
//		panel.add(label4);
		
		add(panel,BorderLayout.NORTH);
		
		//테이블 칼럼 명을 String[]에 담는다.
		String[] colNames= {"사원번호","이름","부서명","부서의위치"};
		
		//기본 테이블 모델 객체 생성
		model= new DefaultTableModel(colNames,0);
		table=new JTable();
		
		table.setModel(model);
		
		JScrollPane sPanel=new JScrollPane(table);
		add(sPanel,BorderLayout.CENTER);
		
		setBounds(200,200,800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		displayMember();		
	}
	public static void main(String[] args) {
		
		new EmpTest();
	}
	public void displayMember() {
		MemberDao dao=MemberDao.getInstance();
		 List<MemberDto> list=dao.getList();
		 
		 model.setRowCount(0);
		 for(MemberDto tmp:list) {
			 Object[] rowData= {tmp.getempNum(),tmp.getName(),tmp.getdName(),tmp.getloc()};
			 model.addRow(rowData);
		 }
	}
}
