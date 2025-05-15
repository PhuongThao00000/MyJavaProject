package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class ManagerDashboardUI extends JFrame {
    public ManagerDashboardUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Trang chủ Quản lý - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        // Main panel chia 2
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Sidebar tái sử dụng
        mainPanel.add(createSidebar(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST);

        // Panel phải: Dashboard
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);

        // --- Tiêu đề ---
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(54, 104, 181));
        titlePanel.setPreferredSize(new Dimension(0, 100));
        JLabel lblTitle = new JLabel("IOU-Tôi trong bạn");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 48));
        lblTitle.setForeground(Color.WHITE);
        titlePanel.add(lblTitle);
        rightPanel.add(titlePanel, BorderLayout.NORTH);

        // --- Nút chức năng: 2x2 grid ---
        JPanel gridPanel = new JPanel(new GridLayout(2, 2, 30, 30));
        gridPanel.setBackground(Color.WHITE);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 100, 100));

        String[] btnLabels = {
            "Thêm người dùng",
            "Quản lý thuốc",
            "Quản lý kho",
            "Báo cáo, thống kê"
        };
        for (String text : btnLabels) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 32));
            btn.setBackground(new Color(220, 220, 220));
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(300, 150));
            gridPanel.add(btn);
        }
        // Đưa gridPanel vào center
        rightPanel.add(gridPanel, BorderLayout.CENTER);

        mainPanel.add(rightPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }

    private JPanel createSidebar(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(120, 156, 230));
        sidebar.setPreferredSize(new Dimension(350, 800));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.add(Box.createVerticalStrut(30));

        // Avatar
        String firstChar = tenDangNhap.substring(0, 1).toUpperCase();
        AvatarCircle avatar = new AvatarCircle(firstChar, new Color(41, 98, 173), 140);
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(avatar);
        sidebar.add(Box.createVerticalStrut(10));

        // Vai trò
        JLabel lblRole = new JLabel(role.equalsIgnoreCase("quanly") ? "Quản Lý" : "Nhân Viên");
        lblRole.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 28));
        lblRole.setForeground(Color.WHITE);
        lblRole.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(lblRole);
        sidebar.add(Box.createVerticalStrut(20));

        // Thông tin cá nhân
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(180, 200, 240));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        infoPanel.setMaximumSize(new Dimension(320, 200));

        JLabel infoTitle = new JLabel("Thông tin cá nhân");
        infoTitle.setFont(new Font("Arial", Font.BOLD, 22));
        infoTitle.setForeground(Color.DARK_GRAY);
        infoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(infoTitle);
        infoPanel.add(Box.createVerticalStrut(10));

        JLabel lblInfo = new JLabel("<html>Họ tên: " + hoTen +
                                   "<br>Ngày sinh: " + ngaySinh +
                                   "<br>SĐT: " + sdt +
                                   "<br>Email: " + email + "</html>");
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(lblInfo);

        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(infoPanel);

        sidebar.add(Box.createVerticalGlue());

        // Log out
        JButton btnLogout = new JButton("Log out");
        btnLogout.setFont(new Font("Arial", Font.BOLD, 22));
        btnLogout.setBackground(new Color(54, 104, 181));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFocusPainted(false);
        btnLogout.setMaximumSize(new Dimension(200, 50));
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBorder(BorderFactory.createLineBorder(new Color(54, 104, 181), 1, true));
        sidebar.add(btnLogout);
        sidebar.add(Box.createVerticalStrut(30));

        return sidebar;
    }

    // AvatarCircle giữ nguyên từ ManagerHomeUI
    static class AvatarCircle extends JPanel {
        private final String letter;
        private final Color bgColor;
        private final int size;
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
        SwingUtilities.invokeLater(() ->
            new ManagerDashboardUI("admin", "Nguyễn Văn A", "04/05/1995", "0900123456", "a@example.com", "quanly")
                .setVisible(true)
        );
    }
}
