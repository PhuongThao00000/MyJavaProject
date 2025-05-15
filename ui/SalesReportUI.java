package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SalesReportUI extends JFrame {
    public SalesReportUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Thống kê doanh thu - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(Sidebar.create(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST);

        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);

        JPanel filterPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        filterPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        String[] filters = {"Theo ngày", "Theo tháng", "Theo NV", "Theo danh mục", "Tổng hợp"};
        for (String filter : filters) {
            JButton btn = new JButton(filter);
            btn.setFont(new Font("Arial", Font.PLAIN, 16));
            filterPanel.add(btn);
        }

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tablePanel = new JPanel(new BorderLayout());
        String[] cols = {"STT", "Thời gian", "Nhân viên", "Doanh thu", "Tỷ lệ"};
        JTable table = new JTable(new DefaultTableModel(cols, 0));
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        tabbedPane.addTab("Dạng bảng", tablePanel);
        tabbedPane.addTab("Biểu đồ", new JPanel());

        right.add(filterPanel, BorderLayout.NORTH);
        right.add(tabbedPane, BorderLayout.CENTER);

        mainPanel.add(right, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }

	public SalesReportUI() {
		// TODO Auto-generated constructor stub
	}
}