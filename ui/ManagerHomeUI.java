package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class ManagerHomeUI extends JFrame {
    public ManagerHomeUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Quản lý thuốc - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        // Main panel chia 2 bên
        JPanel mainPanel = new JPanel(new BorderLayout());

        // ===== Sidebar trái =====
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(120, 156, 230)); 
        sidebar.setPreferredSize(new Dimension(350, 800));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Spacer trên
        sidebar.add(Box.createVerticalStrut(30));

        // Avatar hình tròn
        String firstChar = tenDangNhap.substring(0, 1).toUpperCase();
        AvatarCircle avatar = new AvatarCircle(firstChar, new Color(41, 98, 173), 140);
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(avatar);

        // Spacer nhỏ
        sidebar.add(Box.createVerticalStrut(10));

        // Vai trò
        JLabel lblRole = new JLabel(role.equalsIgnoreCase("quanly") ? "Quản Lý" : "Nhân Viên");
        lblRole.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 28));
        lblRole.setForeground(Color.WHITE);
        lblRole.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(lblRole);

        // Spacer nhỏ
        sidebar.add(Box.createVerticalStrut(20));

        // Thông tin cá nhân (dùng HTML để tự xuống dòng)
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(180, 200, 240));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        infoPanel.setMaximumSize(new Dimension(320, 220));

        JLabel infoTitle = new JLabel("Thông tin cá nhân");
        infoTitle.setFont(new Font("Arial", Font.BOLD, 22));
        infoTitle.setForeground(Color.DARK_GRAY);
        infoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(infoTitle);
        infoPanel.add(Box.createVerticalStrut(10));

        JLabel lblHoTen = new JLabel("<html>Họ tên: " + hoTen + "<br>Ngày sinh: " + ngaySinh +
                "<br>SĐT: " + sdt + "<br>Email: " + email + "</html>");
        lblHoTen.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(lblHoTen);

        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(infoPanel);

     // Spacer lớn để đẩy Log out xuống dưới
        sidebar.add(Box.createVerticalGlue());

        // Nút Log out (JButton)
        JButton btnLogout = new JButton("Log out");
        btnLogout.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        btnLogout.setBackground(new Color(54, 104, 181));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFocusPainted(false);
        btnLogout.setMaximumSize(new Dimension(200, 50));
        btnLogout.setPreferredSize(new Dimension(200, 50));
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBorder(BorderFactory.createLineBorder(new Color(54, 104, 181), 1, true));

        // Thêm nút vào sidebar
        sidebar.add(btnLogout);
        sidebar.add(Box.createVerticalStrut(30)); // Spacer dưới cùng

        // ===== Phần phải =====
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);

        // Tiêu đề
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(54, 104, 181));
        titlePanel.setPreferredSize(new Dimension(0, 100));
        JLabel lblTitle = new JLabel("Quản lý thuốc");
        lblTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 54));
        lblTitle.setForeground(Color.WHITE);
        titlePanel.add(lblTitle);
        rightPanel.add(titlePanel, BorderLayout.NORTH);

        // Các nút chức năng
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Dàn đều các nút bằng glue
        buttonPanel.add(Box.createVerticalGlue());

        String[] btnTexts = {
            "Chỉnh sửa thông tin Thuốc",
            "Nhập thông tin Thuốc",
            "Xóa Thuốc",
            "Tìm kiếm và xem Thuốc"
        };
        for (String text : btnTexts) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 32));
            btn.setBackground(new Color(220, 220, 220));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(600, 100));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            buttonPanel.add(btn);
            buttonPanel.add(Box.createVerticalGlue());
        }
        rightPanel.add(buttonPanel, BorderLayout.CENTER);

        // Thêm vào main panel
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    // Class vẽ avatar tròn với chữ cái đầu
    static class AvatarCircle extends JPanel {
        private String letter;
        private Color bgColor;
        private int size;
        public AvatarCircle(String letter, Color bgColor, int size) {
            this.letter = letter;
            this.bgColor = bgColor;
            this.size = size;
            setPreferredSize(new Dimension(size, size));
            setMaximumSize(new Dimension(size, size));
            setOpaque(false);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(bgColor);
            g2.fillOval(0, 0, size, size);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, size / 2));
            FontMetrics fm = g2.getFontMetrics();
            int x = (size - fm.stringWidth(letter)) / 2;
            int y = (size - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(letter, x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManagerHomeUI("admin", "Admin User", "01/01/1990", "1234567890", "admin@example.com", "quanly").setVisible(true);
        });
    }
}