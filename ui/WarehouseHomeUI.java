package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarehouseHomeUI extends JFrame {
    public WarehouseHomeUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Quản lý kho - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add( Sidebar.create(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST );

        // Right panel: Dashboard for kho
        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);

        // Title
        JPanel title = new JPanel();
        title.setBackground(new Color(54,104,181));
        title.setPreferredSize(new Dimension(0, 100));
        JLabel lbl = new JLabel("Quản lý kho");
        lbl.setFont(new Font("Arial", Font.BOLD, 48));
        lbl.setForeground(Color.WHITE);
        title.add(lbl);
        right.add(title, BorderLayout.NORTH);

        // Buttons 3 x vertically
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(50,200,50,200));
        String[] texts = {"Nhập kho","Xuất kho","Kiểm tra tồn kho","Xem danh mục Thuốc"};
        for (String t : texts) {
            JButton b = new JButton(t);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setFont(new Font("Arial", Font.BOLD, 28));
            b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            b.setBackground(new Color(220,220,220));
            b.setFocusPainted(false);
            btnPanel.add(b);
            btnPanel.add(Box.createVerticalStrut(20));

            // Navigation
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switch (t) {
                        case "Nhập kho":
                            new ImportWarehouseUI(tenDangNhap,hoTen,ngaySinh,sdt,email,role).setVisible(true);
                            break;
                        case "Xuất kho":
                            new ExportWarehouseUI(tenDangNhap, hoTen, ngaySinh, sdt, email, role).setVisible(true);
                            break;
                        case "Kiểm tra tồn kho":
                            new InventoryCheckUI(tenDangNhap,hoTen,ngaySinh,sdt,email,role).setVisible(true);
                            break;
                        case "Xem danh mục Thuốc":
                            new ViewMedicineListUI(tenDangNhap,hoTen,ngaySinh,sdt,email,role).setVisible(true);
                            break;
                    }  
                    dispose();
                }
            });
        }
        right.add(btnPanel, BorderLayout.CENTER);
        

        // Thêm panel phải vào main
        mainPanel.add(right, BorderLayout.CENTER);
        setContentPane(mainPanel);

        setContentPane(mainPanel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WarehouseHomeUI(
            "admin","Nguyễn Văn A","04/05/2025","09001008","a@gmail.com","quanly"
        ).setVisible(true));
    }
}

