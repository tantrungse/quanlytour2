package com.myclass.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.myclass.bus.KHTourBUS;
import com.myclass.bus.TaiKhoanBUS;
import com.myclass.bus.TourBUS;
import com.myclass.dao.TaiKhoanDAO;
import com.myclass.dto.KHTourDTO;
import com.myclass.dto.TaiKhoanDTO;
import com.myclass.dto.TourDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

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
	private DefaultTableModel hdvTblModel;
	
	private JTable tblTaiKhoan;
	private JTable tblTour;
	private JTable tblHdv;
	
	private int selectedRow;
	
	private JTextField txtUpdateTenTaiKhoan;
	private JTextField txtUpdateMatKhau;
	
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
		sidePane.setBounds(0, 0, 250, 800);
		contentPane.add(sidePane);
		sidePane.setLayout(null);
		
		lblDashboard = new JLabel("Dashboard", SwingConstants.CENTER);
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblDashboard.setBounds(0, 50, 250, 100);
		sidePane.add(lblDashboard);
		
		JPanel menuSidePane = new JPanel();
		menuSidePane.setBackground(Color.GRAY);
		menuSidePane.setBounds(0, 300, 250, 400);
		sidePane.add(menuSidePane);
		menuSidePane.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblAdminMgmt = new JLabel("Quản lý tài khoản hệ thống");
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
		cardsPane.setBounds(250, 0, 950, 800);
		contentPane.add(cardsPane);
		cardLayout = (CardLayout) cardsPane.getLayout();
		
		// ===== ADMIN LAYOUT START HERE =====
		JPanel cardQuanLyTaiKhoan = new JPanel();
		cardsPane.add(cardQuanLyTaiKhoan, "name_4535705721900");
		cardQuanLyTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyTaiKhoan, "cardAdminMgmt");
		
		JLabel lblTaiKhoan_Header = new JLabel("Trang quản lý tài khoản");
		lblTaiKhoan_Header.setBounds(0, 0, 400, 100);
		lblTaiKhoan_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyTaiKhoan.add(lblTaiKhoan_Header);
		
		JScrollPane taiKhoanScrollPane = new JScrollPane();
		taiKhoanScrollPane.setBounds(150, 450, 300, 300);
		cardQuanLyTaiKhoan.add(taiKhoanScrollPane);
		
		JLabel lblTaiKhoanSearch = new JLabel("Tìm kiếm:");
		lblTaiKhoanSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTaiKhoanSearch.setBounds(20, 400, 80, 30);
		cardQuanLyTaiKhoan.add(lblTaiKhoanSearch);
		
		JTextField txtTaiKhoanSearch = new JTextField();
		txtTaiKhoanSearch.setBounds(100, 400, 200, 30);
		cardQuanLyTaiKhoan.add(txtTaiKhoanSearch);
		txtTaiKhoanSearch.setColumns(10);
		
		JButton btnTaiKhoanSearch = new JButton("Tìm\r\n");
		btnTaiKhoanSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TaiKhoanDTO> listKQ = taiKhoanBUS.getByTenTK(txtTaiKhoanSearch.getText());
				taiKhoanTblModel.setRowCount(0); // xoa tat ca row
				for(TaiKhoanDTO dto : listKQ) {
					taiKhoanTblModel.addRow(new Object[] {
							dto.getTenTK(), dto.getMatKhau(), dto.getQuyen()
					});
				}
			}
		});
		btnTaiKhoanSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanSearch.setBounds(310, 400, 80, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanSearch);
		
		tblTaiKhoan = new JTable();
		tblTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tblTaiKhoan.getSelectedRow();
				txtUpdateTenTaiKhoan.setText((String) tblTaiKhoan.getValueAt(selectedRow, 0));
				txtUpdateMatKhau.setText((String) tblTaiKhoan.getValueAt(selectedRow, 1));
			}
		});
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
		
		JButton btnTaiKhoanReload = new JButton("Tải lại bảng");
		btnTaiKhoanReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taiKhoanTblModel.setRowCount(0);
				loadTblTaiKhoan();
			}
		});
		btnTaiKhoanReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanReload.setBounds(475, 450, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanReload);
		
		JButton btnTaiKhoanDel = new JButton("Xóa tài khoản");
		btnTaiKhoanDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				String tenTK = String.valueOf(tblTaiKhoan.getValueAt(selectedRow, 0));
				
				taiKhoanBUS.deleteByTenTK(tenTK);
				TaiKhoanBUS.listTaiKhoanDTO.remove(selectedRow);
				taiKhoanTblModel.removeRow(selectedRow);
			}
		});
		btnTaiKhoanDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanDel.setBounds(475, 500, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanDel);
		
		JButton btnTaiKhoan_Add = new JButton("Thêm tài khoản");
		btnTaiKhoan_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddTaiKhoan");
			}
		});
		btnTaiKhoan_Add.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoan_Add.setBounds(475, 550, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoan_Add);
		
		JButton btnTaiKhoan_Update = new JButton("Cập nhật tài khoản");
		btnTaiKhoan_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardUpdateTaiKhoan");
			}
		});
		btnTaiKhoan_Update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoan_Update.setBounds(475, 600, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoan_Update);
		
		JButton btnTaiKhoanExit = new JButton("");
		btnTaiKhoanExit.setIcon(new ImageIcon(Application.class.getResource("/com/myclass/gui/IMG/exit-1852366-1573369 (1).png")));
		btnTaiKhoanExit.setBounds(703, 5, 25, 29);
		btnTaiKhoanExit.addActionListener(new ActionListener() {
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
		cardQuanLyTaiKhoan.add(btnTaiKhoanExit);
		// ===== ADMIN LAYOUT END HERE =====
		
		// ===== ADMIN ADD LAYOUT START HERE =====
		JPanel cardAddTaiKhoan = new JPanel();
		cardsPane.add(cardAddTaiKhoan);
		cardAddTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardAddTaiKhoan, "cardAddTaiKhoan");
		
		JLabel lblAddAdminContent = new JLabel("Trang thêm tài khoản");
		lblAddAdminContent.setBounds(0, 0, 400, 100);
		lblAddAdminContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddTaiKhoan.add(lblAddAdminContent);
		
		JLabel lblAddTenTaiKhoan = new JLabel("Nhập tên tài khoản:");
		lblAddTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenTaiKhoan.setBounds(50, 150, 150, 30);
		cardAddTaiKhoan.add(lblAddTenTaiKhoan);
		
		JTextField txtAddTenTaiKhoan = new JTextField();
		txtAddTenTaiKhoan.setColumns(10);
		txtAddTenTaiKhoan.setBounds(200, 150, 300, 30);
		cardAddTaiKhoan.add(txtAddTenTaiKhoan);
		
		JLabel lblAddMatKhau = new JLabel("Nhập mật khẩu:");
		lblAddMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMatKhau.setBounds(50, 200, 150, 30);
		cardAddTaiKhoan.add(lblAddMatKhau);
		
		JTextField txtAddMatKhau = new JTextField();
		txtAddMatKhau.setColumns(10);
		txtAddMatKhau.setBounds(200, 200, 300, 30);
		cardAddTaiKhoan.add(txtAddMatKhau);
		
		JLabel lblAddQuyen = new JLabel("Chọn quyền:");
		lblAddQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddQuyen.setBounds(50, 250, 150, 30);
		cardAddTaiKhoan.add(lblAddQuyen);
		
		String[] addRoles = {"Admin", "Guest"};
		JComboBox<Object> cbAddQuyen = new JComboBox<>(addRoles);
		cbAddQuyen.setSelectedItem(null);
		cbAddQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbAddQuyen.setBounds(200, 250, 100, 30);
		cardAddTaiKhoan.add(cbAddQuyen);
		
		JButton btnAddTaiKhoan_Add = new JButton("Thêm mới");
		btnAddTaiKhoan_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanDTO dto = new TaiKhoanDTO();
				
				dto.setTenTK(txtAddTenTaiKhoan.getText());
				dto.setMatKhau(txtAddMatKhau.getText());
				dto.setQuyen(cbAddQuyen.getSelectedIndex());
				
				taiKhoanBUS.add(dto);
				TaiKhoanBUS.listTaiKhoanDTO.add(dto);
				addRow(dto);
				cardLayout.show(cardsPane, "cardAdminMgmt");
			}
		});
		btnAddTaiKhoan_Add.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddTaiKhoan_Add.setBounds(150, 300, 120, 30);
		cardAddTaiKhoan.add(btnAddTaiKhoan_Add);
		
		JButton btnAddTaiKhoan_QuayLai = new JButton("Quay lại");
		btnAddTaiKhoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAdminMgmt");
			}
		});
		btnAddTaiKhoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddTaiKhoan_QuayLai.setBounds(300, 300, 100, 30);
		cardAddTaiKhoan.add(btnAddTaiKhoan_QuayLai);
		// ===== ADMIN ADD LAYOUT END HERE =====
		
		// ===== ADMIN UPDATE LAYOUT START HERE =====
		JPanel cardUpdateTaiKhoan = new JPanel();
		cardsPane.add(cardUpdateTaiKhoan);
		cardUpdateTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateTaiKhoan, "cardUpdateTaiKhoan");
		
		JLabel lblUpdateAdminContent = new JLabel("Trang cập nhật tài khoản");
		lblUpdateAdminContent.setBounds(0, 0, 400, 100);
		lblUpdateAdminContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateTaiKhoan.add(lblUpdateAdminContent);
		
		JLabel lblUpdateTenTaiKhoan = new JLabel("Nhập tên tài khoản:");
		lblUpdateTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenTaiKhoan.setBounds(50, 150, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateTenTaiKhoan);
		
		txtUpdateTenTaiKhoan = new JTextField();
		txtUpdateTenTaiKhoan.setColumns(10);
		txtUpdateTenTaiKhoan.setBounds(200, 150, 300, 30);
		cardUpdateTaiKhoan.add(txtUpdateTenTaiKhoan);
		
		JLabel lblUpdateMatKhau = new JLabel("Nhập mật khẩu:");
		lblUpdateMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMatKhau.setBounds(50, 200, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateMatKhau);
		
		txtUpdateMatKhau = new JTextField();
		txtUpdateMatKhau.setColumns(10);
		txtUpdateMatKhau.setBounds(200, 200, 300, 30);
		cardUpdateTaiKhoan.add(txtUpdateMatKhau);
		
		JLabel lblUpdateQuyen = new JLabel("Chọn quyền:");
		lblUpdateQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateQuyen.setBounds(50, 250, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateQuyen);
		
		String[] updateRoles = {"Admin", "Guest"};
		JComboBox<Object> cbUpdateQuyen = new JComboBox<>(updateRoles);
		cbUpdateQuyen.setSelectedItem(null);
		cbUpdateQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbUpdateQuyen.setBounds(200, 250, 100, 30);
		cardUpdateTaiKhoan.add(cbUpdateQuyen);
		
		JButton btnUpdateTaiKhoan = new JButton("Cập nhật");
		btnUpdateTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				TaiKhoanDTO dto = new TaiKhoanDTO();
				
				if(!taiKhoanTblModel.getValueAt(selectedRow, 0).equals(txtUpdateTenTaiKhoan.getText())) {
					JOptionPane.showMessageDialog(new JFrame(), "Không được thay đổi tên tài khoản!");
					return;
				}
				
				dto.setTenTK(txtUpdateTenTaiKhoan.getText());
				dto.setMatKhau(txtUpdateMatKhau.getText());
				dto.setQuyen(cbUpdateQuyen.getSelectedIndex());
				
				taiKhoanBUS.update(dto);
				TaiKhoanBUS.listTaiKhoanDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
			}
		});
		btnUpdateTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTaiKhoan.setBounds(150, 300, 100, 30);
		cardUpdateTaiKhoan.add(btnUpdateTaiKhoan);
		
		JButton btnUpdateTaiKhoan_QuayLai = new JButton("Quay lại");
		btnUpdateTaiKhoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAdminMgmt");
			}
		});
		btnUpdateTaiKhoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTaiKhoan_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdateTaiKhoan.add(btnUpdateTaiKhoan_QuayLai);
		// ===== ADMIN UPDATE LAYOUT END HERE =====
		
		// ===== TOUR LAYOUT START HERE =====
		JPanel cardTourMgmt = new JPanel();
		cardsPane.add(cardTourMgmt, "name_4568411886400");
		cardTourMgmt.setLayout(null);
		cardLayout.addLayoutComponent(cardTourMgmt, "cardTourMgmt");
		
		JLabel lblTourCard = new JLabel("Trang quản lý tour");
		lblTourCard.setBounds(0, 0, 400, 100);
		lblTourCard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardTourMgmt.add(lblTourCard);
		
		JLabel lblMaTour = new JLabel("Nhập mã tour:");
		lblMaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaTour.setBounds(50, 100, 150, 30);
		cardTourMgmt.add(lblMaTour);
		
		JTextField txtMaTour = new JTextField();
		txtMaTour.setColumns(10);
		txtMaTour.setBounds(200, 100, 300, 30);
		cardTourMgmt.add(txtMaTour);
		
		JLabel lblTenTour = new JLabel("Nhập tên tour:");
		lblTenTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenTour.setBounds(50, 150, 150, 30);
		cardTourMgmt.add(lblTenTour);
		
		JTextField txtTenTour = new JTextField();
		txtTenTour.setColumns(10);
		txtTenTour.setBounds(200, 150, 300, 30);
		cardTourMgmt.add(txtTenTour);
		
		JLabel lblGiaVe = new JLabel("Nhập giá vé:");
		lblGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiaVe.setBounds(50, 200, 150, 30);
		cardTourMgmt.add(lblGiaVe);
		
		JTextField txtGiaVe = new JTextField();
		txtGiaVe.setColumns(10);
		txtGiaVe.setBounds(200, 200, 300, 30);
		cardTourMgmt.add(txtGiaVe);
		
		JLabel lblMaKHTour = new JLabel("Nhập mã kế hoạch:");
		lblMaKHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaKHTour.setBounds(50, 250, 150, 30);
		cardTourMgmt.add(lblMaKHTour);
		
		JTextField txtMaKHTour = new JTextField();
		txtMaKHTour.setColumns(10);
		txtMaKHTour.setBounds(200, 250, 300, 30);
		cardTourMgmt.add(txtMaKHTour);
		
		JLabel lblmaHD = new JLabel("Nhập mã hợp đồng:");
		lblmaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmaHD.setBounds(50, 300, 150, 30);
		cardTourMgmt.add(lblmaHD);
		
		JTextField txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(200, 300, 300, 30);
		cardTourMgmt.add(txtMaHD);
		
		JLabel lblmaDoan = new JLabel("Nhập mã đoàn:");
		lblmaDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmaDoan.setBounds(50, 350, 150, 30);
		cardTourMgmt.add(lblmaDoan);
		
		JTextField txtMaDoan= new JTextField();
		txtMaDoan.setColumns(10);
		txtMaDoan.setBounds(200, 350, 300, 30);
		cardTourMgmt.add(txtMaDoan);
		
		JButton btnAddKHTour = new JButton("Tạo kế hoạch");
		btnAddKHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKHTour.setBounds(550, 200, 150, 30);
		cardTourMgmt.add(btnAddKHTour);
		
		JButton btnAddHD = new JButton("Tạo hợp đồng");
		btnAddHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddHD.setBounds(550, 250, 150, 30);
		cardTourMgmt.add(btnAddHD);
		
		JButton btnTourAdd = new JButton("Thêm");
		btnTourAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TourDTO dto = new TourDTO();
	
				dto.setMaTour(txtMaTour.getText());
				dto.setTenTour(txtTenTour.getText());
				dto.setGiaVe(Double.parseDouble(txtGiaVe.getText()));
				dto.setMaKHTour(txtMaKHTour.getText());
				dto.setMaHD(txtMaHD.getText());
				dto.setMaDoan(txtMaDoan.getText());
				
				tourBUS.add(dto);
				TourBUS.listTourDTO.add(dto);
				addRow(dto);
			}
		});
		btnTourAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourAdd.setBounds(550, 100, 80, 30);
		cardTourMgmt.add(btnTourAdd);
		
		JButton btnTourUpdate = new JButton("Sửa");
		btnTourUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTour.getSelectedRow();
				TourDTO dto = new TourDTO();
				
				if(!tourTblModel.getValueAt(selectedRow, 0).equals(txtMaTour.getText())) {
					JOptionPane.showMessageDialog(new JFrame(), "Không được thay đổi mã tour!");
					return;
				}
				
				dto.setMaTour(txtMaTour.getText());
				dto.setTenTour(txtTenTour.getText());
				dto.setGiaVe(Double.parseDouble(txtGiaVe.getText()));
				dto.setMaKHTour(txtMaKHTour.getText());
				dto.setMaHD(txtMaHD.getText());
				
				tourBUS.update(dto);
				TourBUS.listTourDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
			}
		});
		btnTourUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourUpdate.setBounds(550, 150, 80, 30);
		cardTourMgmt.add(btnTourUpdate);
		
		JLabel lblTourSearch = new JLabel("Tìm kiếm:");
		lblTourSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTourSearch.setBounds(20, 400, 80, 30);
		cardTourMgmt.add(lblTourSearch);
		
		JTextField txtTourSearch = new JTextField();
		txtTourSearch.setBounds(100, 400, 200, 30);
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
		btnTourSearch.setBounds(310, 400, 80, 30);
		cardTourMgmt.add(btnTourSearch);
		
		JScrollPane tourScrollPane = new JScrollPane();
		tourScrollPane.setBounds(150, 450, 500, 300);
		cardTourMgmt.add(tourScrollPane);
		
		tblTour = new JTable();
		tblTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRowSelected = tblTour.getSelectedRow();
				
				txtMaTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 0));
				txtTenTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 1));
				txtGiaVe.setText(String.valueOf( tourTblModel.getValueAt(indexRowSelected, 2) ));
				txtMaKHTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 3));
				txtMaHD.setText((String) tourTblModel.getValueAt(indexRowSelected, 4));
				txtMaDoan.setText((String) tourTblModel.getValueAt(indexRowSelected, 5));
			}
		});
		tblTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour.setRowHeight(50);
		tourTblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã tour", "Tên tour", "Giá vé", "Mã kế hoạch tour", "Mã hợp đồng", "Mã đoàn"
				}
			);
		tblTour.setModel(tourTblModel);
		loadTblTour();
		
		tourScrollPane.setViewportView(tblTour);
		tblTour.setFillsViewportHeight(true);
		
		JButton btnTourDel = new JButton("Xóa bản ghi");
		btnTourDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTour.getSelectedRow();
				String maTour = (String) tblTour.getValueAt(selectedRow, 0);
				
				tourBUS.deleteById(maTour);
				tourTblModel.removeRow(selectedRow);
			}
		});
		btnTourDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourDel.setBounds(675, 500, 120, 30);;
		cardTourMgmt.add(btnTourDel);
		
		JButton btnTourReload = new JButton("Tải lại bảng");
		btnTourReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tourTblModel.setRowCount(0);
				loadTblTour();
			}
		});
		btnTourReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourReload.setBounds(675, 450, 120, 30);
		cardTourMgmt.add(btnTourReload);
		// ===== TOUR LAYOUT END HERE =====
		
		// ===== HDV LAYOUT START HERE =====
		JPanel cardHdvMgmt = new JPanel();
		cardsPane.add(cardHdvMgmt, "name_4568411886400");
		cardHdvMgmt.setLayout(null);
		cardLayout.addLayoutComponent(cardHdvMgmt, "cardHdvMgmt");
		
		JLabel lblHdvCard = new JLabel("Trang quản lý hướng dẫn viên");
		lblHdvCard.setBounds(0, 0, 500, 100);
		lblHdvCard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardHdvMgmt.add(lblHdvCard);
		
		JLabel lblMaHdv = new JLabel("Nhập mã hướng dẫn viên:");
		lblMaHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaHdv.setBounds(50, 100, 150, 30);
		cardHdvMgmt.add(lblMaHdv);
		
		JTextField txtMaHdv = new JTextField();
		txtMaHdv.setColumns(10);
		txtMaHdv.setBounds(200, 100, 300, 30);
		cardHdvMgmt.add(txtMaHdv);
		
		JLabel lblHoTen = new JLabel("Nhập họ tên:");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoTen.setBounds(50, 150, 150, 30);
		cardHdvMgmt.add(lblHoTen);
		
		JTextField txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(200, 150, 300, 30);
		cardHdvMgmt.add(txtHoTen);
		
		JLabel lblNgaySinh = new JLabel("Nhập ngày sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(50, 200, 150, 30);
		cardHdvMgmt.add(lblNgaySinh);
		
		JTextField txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(200, 200, 300, 30);
		cardHdvMgmt.add(txtNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Nhập giới tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(50, 250, 150, 30);
		cardHdvMgmt.add(lblGioiTinh);
		
		JTextField txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(200, 250, 300, 30);
		cardHdvMgmt.add(txtGioiTinh);
		
		JLabel lblDiaChi = new JLabel("Nhập địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiaChi.setBounds(50, 300, 150, 30);
		cardHdvMgmt.add(lblDiaChi);
		
		JTextField txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(200, 300, 300, 30);
		cardHdvMgmt.add(txtDiaChi);
		
		JLabel lblSdt = new JLabel("Nhập số điện thoại:");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt.setBounds(50, 350, 150, 30);
		cardHdvMgmt.add(lblSdt);
		
		JTextField txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(200, 350, 300, 30);
		cardHdvMgmt.add(txtSdt);
		
		JButton btnHdvAdd = new JButton("Thêm");
		btnHdvAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TourDTO dto = new TourDTO();
//	
//				dto.setMaTour(txtMaTour.getText());
//				dto.setTenTour(txtTenTour.getText());
//				dto.setGiaVe(Double.parseDouble(txtGiaVe.getText()));
//				dto.setMaKHTour(txtMaKHTour.getText());
//				dto.setMaHD(txtMaHD.getText());
//				
//				tourBUS.add(dto);
//				TourBUS.listTourDTO.add(dto);
//				addRow(dto);
			}
		});
		btnHdvAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvAdd.setBounds(550, 100, 80, 30);
		cardHdvMgmt.add(btnHdvAdd);
		
		JButton btnHdvUpdate = new JButton("Sửa");
		btnHdvUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int selectedRow = tblTour.getSelectedRow();
//				TourDTO dto = new TourDTO();
//				
//				if(!tourTblModel.getValueAt(selectedRow, 0).equals(txtMaTour.getText())) {
//					JOptionPane.showMessageDialog(new JFrame(), "Không được thay đổi mã tour!");
//					return;
//				}
//				
//				dto.setMaTour(txtMaTour.getText());
//				dto.setTenTour(txtTenTour.getText());
//				dto.setGiaVe(Double.parseDouble(txtGiaVe.getText()));
//				dto.setMaKHTour(txtMaKHTour.getText());
//				dto.setMaHD(txtMaHD.getText());
//				
//				tourBUS.update(dto);
//				TourBUS.listTourDTO.set(selectedRow, dto);
//				setRow(dto, selectedRow);
			}
		});
		btnHdvUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvUpdate.setBounds(550, 150, 80, 30);
		cardHdvMgmt.add(btnHdvUpdate);
		
		JLabel lblHdvSearch = new JLabel("Tìm kiếm:");
		lblHdvSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblHdvSearch.setBounds(20, 400, 80, 30);
		cardHdvMgmt.add(lblHdvSearch);
		
		JTextField txtHdvSearch = new JTextField();
		txtHdvSearch.setBounds(100, 400, 200, 30);
		cardHdvMgmt.add(txtHdvSearch);
		txtHdvSearch.setColumns(10);
		
		JButton btnHdvSearch = new JButton("Tìm\r\n");
		btnHdvSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<TaiKhoanDTO> listKQ = taiKhoanBUS.getByTenTK(txtTourSearch.getText());
//				taiKhoanTblModel.setRowCount(0); // xoa tat ca row
//				for(TaiKhoanDTO dto : listKQ) {
//					taiKhoanTblModel.addRow(new Object[] {
//							dto.getTenTK(), dto.getMatKhau(), dto.getQuyen()
//					});
//				}
			}
		});
		btnHdvSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvSearch.setBounds(310, 400, 80, 30);
		cardHdvMgmt.add(btnHdvSearch);
		
		JScrollPane hdvScrollPane = new JScrollPane();
		hdvScrollPane.setBounds(150, 450, 500, 300);
		cardHdvMgmt.add(hdvScrollPane);
		
		tblHdv = new JTable();
		tblHdv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRowSelected = tblHdv.getSelectedRow();
				
//				txtMaTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 0));
//				txtTenTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 1));
//				txtGiaVe.setText(String.valueOf( tourTblModel.getValueAt(indexRowSelected, 2) ));
//				txtMaKHTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 3));
//				txtMaHD.setText((String) tourTblModel.getValueAt(indexRowSelected, 4));
			}
		});
		tblHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblHdv.setRowHeight(50);
		hdvTblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã HDV", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại"
				}
			);
		tblHdv.setModel(hdvTblModel);
		loadTblHdv();
		
		hdvScrollPane.setViewportView(tblHdv);
		tblHdv.setFillsViewportHeight(true);
		
		JButton btnHdvDel = new JButton("Xóa bản ghi");
		btnHdvDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int selectedRow = tblTour.getSelectedRow();
//				String maTour = (String) tblTour.getValueAt(selectedRow, 0);
//				
//				tourBUS.deleteById(maTour);
//				tourTblModel.removeRow(selectedRow);
			}
		});
		btnHdvDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvDel.setBounds(675, 500, 120, 30);;
		cardHdvMgmt.add(btnHdvDel);
		
		JButton btnHdvReload = new JButton("Tải lại bảng");
		btnHdvReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tourTblModel.setRowCount(0);
				loadTblTour();
			}
		});
		btnHdvReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvReload.setBounds(675, 450, 120, 30);
		cardHdvMgmt.add(btnHdvReload);
		// HDV LAYOUT END HERE
		
	}
	
	private void loadTblHdv() {
		// TODO Auto-generated method stub
		
	}

	public void loadTblTaiKhoan() {
		for(TaiKhoanDTO taiKhoan : TaiKhoanBUS.listTaiKhoanDTO) {
			String tenQuyen = null;
			if(taiKhoan.getQuyen() == 0) {
				tenQuyen = "Quản trị viên";
			}
			else if(taiKhoan.getQuyen() == 1) {
				tenQuyen = "Nhân viên";
			}
			taiKhoanTblModel.addRow(new Object[] {
					taiKhoan.getTenTK(), taiKhoan.getMatKhau(), tenQuyen
			});
		}
	}
	
	public void loadTblTour() {
		for(TourDTO tour : TourBUS.listTourDTO) {
			tourTblModel.addRow(new Object[] {
					tour.getMaTour(), tour.getTenTour(), tour.getGiaVe(), tour.getMaKHTour(), tour.getMaHD(), tour.getMaDoan()
			});
		}
	}
	
	public void addRow(TaiKhoanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		String tenQuyen = null;
		if(dto.getQuyen() == 0) {
			tenQuyen = "Quản trị viên";
		}
		else if(dto.getQuyen() == 1) {
			tenQuyen = "Nhân viên";
		}
		
		rowData.add(dto.getTenTK());
		rowData.add(dto.getMatKhau());
		rowData.add(tenQuyen);
		
		taiKhoanTblModel.addRow(rowData);
	}
	
	public void addRow(TourDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaTour());
		rowData.add(dto.getTenTour());
		rowData.add(String.valueOf(dto.getGiaVe()));
		rowData.add(dto.getMaKHTour());
		rowData.add(dto.getMaHD());
		rowData.add(dto.getMaDoan());
		
		tourTblModel.addRow(rowData);
	}
	
	public void setRow(TaiKhoanDTO dto, int selectedRow) {
		String tenQuyen = null;
		if(dto.getQuyen() == 0) {
			tenQuyen = "Quản trị viên";
		}
		else if(dto.getQuyen() == 1) {
			tenQuyen = "Nhân viên";
		}
		taiKhoanTblModel.setValueAt(dto.getTenTK(), selectedRow, 0);
		taiKhoanTblModel.setValueAt(dto.getMatKhau(), selectedRow, 1);
		taiKhoanTblModel.setValueAt(tenQuyen, selectedRow, 2);
	}
	
	public void setRow(TourDTO dto, int selectedRow) {
		tourTblModel.setValueAt(dto.getMaTour(), selectedRow, 0);
		tourTblModel.setValueAt(dto.getTenTour(), selectedRow, 1);
		tourTblModel.setValueAt(dto.getGiaVe(), selectedRow, 2);
		tourTblModel.setValueAt(dto.getMaKHTour(), selectedRow, 3);
		tourTblModel.setValueAt(dto.getMaHD(), selectedRow, 4);
	}

    public static Application getAppInstance() {
        if(appInstance == null) 
            appInstance = new Application();
        return appInstance;
    }
    
}
