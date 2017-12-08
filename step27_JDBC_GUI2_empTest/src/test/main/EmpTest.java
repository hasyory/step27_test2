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
	//����ʵ� ����
	//���̺� ��
	DefaultTableModel model;
	JTable table;
	//������
	public EmpTest() {
		initUI();
	}
	//UI�ʱ�ȭ �۾� �޼ҵ�
	public void initUI() {
		//���̾ƿ� ����
		setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		
//		JLabel label1=new JLabel("�����ȣ");
//		JLabel label2=new JLabel("�̸�");
//		JLabel label3=new JLabel("�μ���");
//		JLabel label4=new JLabel("�μ�����ġ");
//		
//		panel.add(label1);
//		panel.add(label2);
//		panel.add(label3);
//		panel.add(label4);
		
		add(panel,BorderLayout.NORTH);
		
		//���̺� Į�� ���� String[]�� ��´�.
		String[] colNames= {"�����ȣ","�̸�","�μ���","�μ�����ġ"};
		
		//�⺻ ���̺� �� ��ü ����
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
