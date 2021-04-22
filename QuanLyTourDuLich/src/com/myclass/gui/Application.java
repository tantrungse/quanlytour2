package com.myclass.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.myclass.bus.TaiKhoanBUS;
import com.myclass.bus.TourBUS;
import com.myclass.dto.TaiKhoanDTO;

import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Application extends JFrame {

	private JPanel contentPane;
	private TaiKhoanBUS taiKhoanBUS;
	private TourBUS	tourBUS;
	private JPanel sidePane;
	private JLabel lblDashboard;
	private JPanel cardsPane;
	private CardLayout cardLayout;
	
	private DefaultTableModel taiKhoanTblModel;
	private DefaultTableModel tourTblModel;
	private JTable tblTaiKhoan;
	private JTable tblTour;
	
	public static Application appInstance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		taiKhoanBUS = new TaiKhoanBUS();
		tourBUS = new TourBUS();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ===== SIDE START HERE =====
		
		sidePane = new JPanel();
		sidePane.setBackground(Color.GRAY);
		sidePane.setBounds(0, 0, 250, 600);
		contentPane.add(sidePane);
		sidePane.setLayout(null);
		
		lblDashboard = new JLabel("Dashboard", SwingConstants.CENTER);
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblDashboard.setBounds(0, 50, 250, 100);
		sidePane.add(lblDashboard);
		
		JPanel menuSidePane = new JPanel();
		menuSidePane.setBackground(Color.GRAY);
		menuSidePane.setBounds(0, 200, 250, 400);
		sidePane.add(menuSidePane);
		menuSidePane.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblAdminMgmt = new JLabel("Quản lý quyền hệ thống");
		lblAdminMgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardAdminMgmt");
			}
		});
		lblAdminMgmt.setForeground(Color.WHITE);
		lblAdminMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblAdminMgmt);
		
		JLabel lblTourMgmt = new JLabel("Quản lý tour");
		lblTourMgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardTourMgmt");
			}
		});
		lblTourMgmt.setForeground(Color.WHITE);
		lblTourMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblTourMgmt);
		
		JLabel lblPersonnelMgmt = new JLabel("Qu\u1EA3n l\u00FD h\u01B0\u1EDBng d\u1EABn vi\u00EAn");
		lblPersonnelMgmt.setForeground(Color.WHITE);
		lblPersonnelMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblPersonnelMgmt);
		
		JLabel lblFinanceMgmt = new JLabel("Qu\u1EA3n l\u00FD t\u00E0i ch\u00EDnh");
		lblFinanceMgmt.setForeground(Color.WHITE);
		lblFinanceMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblFinanceMgmt);
		
		JLabel lblVehicleMgmt = new JLabel("Qu\u1EA3n l\u00FD kh\u00E1ch h\u00E0ng");
		lblVehicleMgmt.setForeground(Color.WHITE);
		lblVehicleMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblVehicleMgmt);

		// ===== SIDE END HERE ===== 
		
		cardsPane = new JPanel(new CardLayout());
		cardsPane.setBackground(Color.WHITE);
		cardsPane.setBounds(250, 0, 750, 600);
		contentPane.add(cardsPane);
		cardLayout = (CardLayout) cardsPane.getLayout();
		
		// ===== ADMIN LAYOUT START HERE =====
		
		JPanel cardAdminMgmt = new JPanel();
		cardsPane.add(cardAdminMgmt, "name_4535705721900");
		cardAdminMgmt.setLayout(null);
		cardAdminMgmt.setBounds(75, 250, 600, 300);
		cardLayout.addLayoutComponent(cardAdminMgmt, "cardAdminMgmt");
		
		JLabel lblNewLabel = new JLabel("Admin card");
		lblNewLabel.setBounds(29, 5, 368, 98);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAdminMgmt.add(lblNewLabel);
		
		JScrollPane taiKhoanScrollPane = new JScrollPane();
		taiKhoanScrollPane.setBounds(125, 250, 300, 300);
		cardAdminMgmt.add(taiKhoanScrollPane);
		
		tblTaiKhoan = new JTable();
		tblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTaiKhoan.setRowHeight(50);
		taiKhoanTblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Tài khoản", "Mật khẩu", "Quyền"
				}
			);
		tblTaiKhoan.setModel(taiKhoanTblModel);
		loadTblTaiKhoan();
		
		taiKhoanScrollPane.setViewportView(tblTaiKhoan);
		tblTaiKhoan.setFillsViewportHeight(true);
		
		JLabel lblAdminSearch = new JLabel("Tìm kiếm:");
		lblAdminSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblAdminSearch.setBounds(29, 206, 93, 23);
		cardAdminMgmt.add(lblAdminSearch);
		
		JTextField txtAdminSearch = new JTextField();
		txtAdminSearch.setBounds(125, 206, 142, 23);
		cardAdminMgmt.add(txtAdminSearch);
		txtAdminSearch.setColumns(10);
		
		JButton btnAdminSearch = new JButton("Tìm\r\n");
		btnAdminSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TaiKhoanDTO> listKQ = taiKhoanBUS.getByTenTK(txtAdminSearch.getText());
				taiKhoanTblModel.setRowCount(0); // xoa tat ca row
				for(TaiKhoanDTO dto : listKQ) {
					taiKhoanTblModel.addRow(new Object[] {
							dto.getTenTK(), dto.getMatKhau(), dto.getQuyen()
					});
				}
			}
		});
		btnAdminSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminSearch.setBounds(271, 206, 85, 21);
		cardAdminMgmt.add(btnAdminSearch);
		
		JButton btnAdminReload = new JButton("Tải lại");
		btnAdminReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taiKhoanTblModel.setRowCount(0);
				loadTblTaiKhoan();
			}
		});
		btnAdminReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminReload.setBounds(434, 253, 85, 21);
		cardAdminMgmt.add(btnAdminReload);
		
		JButton btnAdminAdd = new JButton("Thêm");
		btnAdminAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTaiKhoanFrame addFrame = new AddTaiKhoanFrame();
				addFrame.setVisible(true);
			}
		});
		btnAdminAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminAdd.setBounds(435, 284, 85, 21);
		cardAdminMgmt.add(btnAdminAdd);
		
		JButton btnAdminDel = new JButton("Xóa");
		btnAdminDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				String tenTK = String.valueOf(tblTaiKhoan.getValueAt(selectedRow, 0));
				
				taiKhoanBUS.deleteByTenTK(tenTK);
				taiKhoanTblModel.removeRow(selectedRow);
			}
		});
		btnAdminDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminDel.setBounds(435, 315, 85, 21);
		cardAdminMgmt.add(btnAdminDel);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(Application.class.getResource("/com/myclass/gui/IMG/exit-1852366-1573369 (1).png")));
		btnExit.setBounds(703, 5, 25, 29);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reponse=JOptionPane.showConfirmDialog(rootPane, "Do you want to exit ?","Exit",JOptionPane.YES_NO_OPTION);
	        	if(reponse==0)
	        	{
	        		System.exit(0);
	        	}else
	        	{
	        		return;
	        	}	
	        	
			}
			
		});
		cardAdminMgmt.add(btnExit);
		
		// ===== ADMIN LAYOUT END HERE =====
		
		// ===== TOUR LAYOUT START HERE =====
		
		JPanel cardTourMgmt = new JPanel();
		cardsPane.add(cardTourMgmt, "name_4568411886400");
		cardTourMgmt.setLayout(null);
		cardLayout.addLayoutComponent(cardTourMgmt, "cardTourMgmt");
		
		JLabel lblTourCard = new JLabel("Tour card");
		lblTourCard.setBounds(31, 22, 286, 59);
		lblTourCard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardTourMgmt.add(lblTourCard);
		
		JScrollPane tourScrollPane = new JScrollPane();
		tourScrollPane.setBounds(75, 250, 500, 300);
		cardTourMgmt.add(tourScrollPane);
		
		tblTour = new JTable();
		tblTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour.setRowHeight(50);
		tourTblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã tour", "Tên tour", "Giá vé", "Ngày bắt đầu", "Ngày kết thúc"
				}
			);
		tblTour.setModel(tourTblModel);
		loadTblTaiKhoan();
		
		tourScrollPane.setViewportView(tblTour);
		tblTour.setFillsViewportHeight(true);
		
		JLabel lblTourSearch = new JLabel("Tìm kiếm:");
		lblTourSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTourSearch.setBounds(29, 206, 93, 23);
		cardTourMgmt.add(lblTourSearch);
		
		JTextField txtTourSearch = new JTextField();
		txtTourSearch.setBounds(125, 206, 142, 23);
		cardTourMgmt.add(txtTourSearch);
		txtTourSearch.setColumns(10);
		
		JButton btnTourSearch = new JButton("Tìm\r\n");
		btnTourSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TaiKhoanDTO> listKQ = taiKhoanBUS.getByTenTK(txtTourSearch.getText());
				taiKhoanTblModel.setRowCount(0); // xoa tat ca row
				for(TaiKhoanDTO dto : listKQ) {
					taiKhoanTblModel.addRow(new Object[] {
							dto.getTenTK(), dto.getMatKhau(), dto.getQuyen()
					});
				}
			}
		});
		btnTourSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourSearch.setBounds(271, 206, 85, 21);
		cardTourMgmt.add(btnTourSearch);
		
		JButton btnTourDel = new JButton("Xóa");
		btnTourDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTour.getSelectedRow();
				String maTour = (String) tblTour.getValueAt(selectedRow, 0);
				
				tourBUS.deleteById(maTour);
				tourTblModel.removeRow(selectedRow);
			}
		});
		
		JButton btnTourAdd = new JButton("Thêm");
		btnTourAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTaiKhoanFrame addFrame = new AddTaiKhoanFrame();
				addFrame.setVisible(true);
			}
		});
		
		JButton btnTourReload = new JButton("Tải lại");
		btnTourReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tourTblModel.setRowCount(0);
				loadTblTour();
			}
		});
		
		btnTourReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourReload.setBounds(585, 251, 85, 21);
		cardTourMgmt.add(btnTourReload);
		
		btnTourAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourAdd.setBounds(585, 283, 85, 21);
		cardTourMgmt.add(btnTourAdd);
		
		btnTourDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourDel.setBounds(585, 314, 85, 21);
		cardTourMgmt.add(btnTourDel);
		
		// ===== TOUR LAYOUT END HERE =====
		
	}
	
	public void loadTblTaiKhoan() {
		for(TaiKhoanDTO dto : TaiKhoanBUS.listTaiKhoanDTO) {
			taiKhoanTblModel.addRow(new Object[] {
					dto.getTenTK(), dto.getMatKhau(), dto.getQuyen()
			});
		}
	}
	
	public void loadTblTour() {
		
	}

    public static Application getAppInstance() {
        if(appInstance == null) 
            appInstance = new Application();
        return appInstance;
    }
    
}
