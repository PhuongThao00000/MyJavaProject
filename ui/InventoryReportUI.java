// InventoryReportUI.java
package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryReportUI extends JFrame {
    public InventoryReportUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Báo cáo tồn kho - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(Sidebar.create(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST);

        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(54, 104, 181));
        header.setPreferredSize(new Dimension(0, 120));

        JLabel title = new JLabel("BÁO CÁO TỒN KHO", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 42));
        title.setForeground(Color.WHITE);
        header.add(title, BorderLayout.NORTH);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        filterPanel.setOpaque(false);
        filterPanel.add(new JLabel("Từ ngày:"));
        filterPanel.add(new JTextField(12));
        filterPanel.add(new JLabel("Loại sản phẩm:"));
        filterPanel.add(new JComboBox<>(new String[]{"Tất cả", "Thuốc", "Thiết bị y tế"}));
        header.add(filterPanel, BorderLayout.SOUTH);

        right.add(header, BorderLayout.NORTH);

        String[] columns = {"STT", "Mã hàng", "Tên hàng hóa", "ĐVT", "Tồn đầu kỳ", "Nhập trong kỳ", "Xuất trong kỳ", "Tồn cuối kỳ"};
        JTable table = new JTable(new DefaultTableModel(columns, 0));
        right.add(new JScrollPane(table), BorderLayout.CENTER);

        mainPanel.add(right, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }

	public InventoryReportUI() {
		// TODO Auto-generated constructor stub
	}
}
