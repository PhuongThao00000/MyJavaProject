// ExportWarehouseUI.java
package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class ExportWarehouseUI extends JFrame {
    public ExportWarehouseUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Xuất kho - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout());
        main.add(Sidebar.create(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST);

        // Right panel
        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);

        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(54, 104, 181));
        titlePanel.setPreferredSize(new Dimension(0, 100));
        JLabel lblTitle = new JLabel("Xuất kho");
        lblTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 48));
        lblTitle.setForeground(Color.WHITE);
        titlePanel.add(lblTitle);
        right.add(titlePanel, BorderLayout.NORTH);

        // Form panel with GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // First column weight
        gbc.weightx = 0.2;
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Mã Thuốc:"), gbc);
        gbc.weightx = 0.8; gbc.gridx = 1;
        formPanel.add(new JTextField(), gbc);

        gbc.weightx = 0.2; gbc.gridx = 2;
        formPanel.add(new JLabel("Người Lập phiếu:"), gbc);
        gbc.weightx = 0.8; gbc.gridx = 3;
        formPanel.add(new JTextField(), gbc);

        gbc.gridy = 1; gbc.gridx = 0; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Tên Thuốc:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        gbc.gridx = 2; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Ngày Xuất kho:"), gbc);
        gbc.gridx = 3; gbc.weightx = 0.8;
        JComboBox<String> cbDateOut = new JComboBox<>();
        formPanel.add(cbDateOut, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Mã Phiếu Xuất:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        gbc.gridx = 2; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Số Lượng:"), gbc);
        gbc.gridx = 3; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Người Nhận:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        gbc.gridx = 2; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Đơn Vị tính:"), gbc);
        gbc.gridx = 3; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        right.add(formPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        buttonPanel.setBackground(Color.WHITE);
        JButton btnSave = new JButton("LƯU");
        btnSave.setFont(new Font("Arial", Font.BOLD, 24));
        btnSave.setPreferredSize(new Dimension(150, 50));
        JButton btnBack = new JButton("TRỞ VỀ");
        btnBack.setFont(new Font("Arial", Font.BOLD, 24));
        btnBack.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnBack);
        right.add(buttonPanel, BorderLayout.SOUTH);

        main.add(right, BorderLayout.CENTER);
        setContentPane(main);
    }
}