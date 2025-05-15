package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ImportExportReportUI extends JFrame {
    public ImportExportReportUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Báo cáo nhập/xuất - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(Sidebar.create(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST);

        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);

        JPanel filterPanel = new JPanel(new BorderLayout());
        filterPanel.setBackground(new Color(54, 104, 181));

        JLabel title = new JLabel("BÁO CÁO NHẬP/XUẤT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 42));
        title.setForeground(Color.WHITE);
        filterPanel.add(title, BorderLayout.NORTH);

        JPanel dateFilters = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        dateFilters.setOpaque(false);
        dateFilters.add(new JLabel("Ngày nhập:"));
        dateFilters.add(new JTextField(12));
        dateFilters.add(new JLabel("Ngày xuất:"));
        dateFilters.add(new JTextField(12));
        dateFilters.add(new JButton("Xem báo cáo"));
        filterPanel.add(dateFilters, BorderLayout.SOUTH);

        right.add(filterPanel, BorderLayout.NORTH);

        String[] cols = {"STT", "Mã hàng", "Tên hàng hóa", "Đơn vị", "SL nhập", "SL xuất"};
        JTable table = new JTable(new DefaultTableModel(cols, 0));
        right.add(new JScrollPane(table), BorderLayout.CENTER);

        mainPanel.add(right, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }

	public ImportExportReportUI() {
		// TODO Auto-generated constructor stub
	}
}