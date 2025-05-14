package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class MedicineManageUI extends JFrame {
    public MedicineManageUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Quản lý thuốc - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        // Panel chính với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // SIDEBAR - Điều chỉnh kích thước và căn đối
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(120, 156, 230));
        sidebar.setPreferredSize(new Dimension(300, 800)); // Thu gọn chiều rộng sidebar
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        
        // Điều chỉnh khoảng cách trên cùng
        sidebar.add(Box.createVerticalStrut(40));

        // Avatar kích thước nhỏ hơn để cân đối
        AvatarCircle avatar = new AvatarCircle(hoTen.substring(0, 1).toUpperCase(), new Color(200, 220, 255), 120);
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(avatar);
        
        sidebar.add(Box.createVerticalStrut(15));

        // Vai trò - Điều chỉnh font
        JLabel lblRole = new JLabel("Quản Lý");
        lblRole.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 28));
        lblRole.setForeground(Color.WHITE);
        lblRole.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(lblRole);

        sidebar.add(Box.createVerticalStrut(30));

        // Thông tin cá nhân - Điều chỉnh kích thước và giao diện
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(220, 230, 245));
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(100, 140, 220), 2, true),
            BorderFactory.createEmptyBorder(10, 15, 15, 15)));
        infoPanel.setMaximumSize(new Dimension(270, 250));
        
        // Tiêu đề info panel
        JLabel infoTitle = new JLabel("Thông tin cá nhân");
        infoTitle.setFont(new Font("Arial", Font.BOLD, 22));
        infoTitle.setForeground(new Color(40, 60, 100));
        infoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(infoTitle);
        
        infoPanel.add(Box.createVerticalStrut(15));
        
        // Thông tin người dùng - Style đồng nhất
        JPanel userDataPanel = new JPanel();
        userDataPanel.setLayout(new GridLayout(4, 1, 0, 8));
        userDataPanel.setOpaque(false);
        
        JLabel lblHoTen = new JLabel("Họ tên: " + hoTen);
        lblHoTen.setFont(new Font("Arial", Font.PLAIN, 18));
        userDataPanel.add(lblHoTen);
        
        JLabel lblNgaySinh = new JLabel("Ngày sinh: " + ngaySinh);
        lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 18));
        userDataPanel.add(lblNgaySinh);
        
        JLabel lblSdt = new JLabel("SĐT: " + sdt);
        lblSdt.setFont(new Font("Arial", Font.PLAIN, 18));
        userDataPanel.add(lblSdt);
        
        JLabel lblEmail = new JLabel("Email: " + email);
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        userDataPanel.add(lblEmail);
        
        infoPanel.add(userDataPanel);
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(infoPanel);

        // Đẩy nút logout xuống cuối
        sidebar.add(Box.createVerticalGlue());

        // Nút logout đẹp hơn
        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(new Color(54, 104, 181));
        btnLogout.setFocusPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setMaximumSize(new Dimension(180, 45));
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        sidebar.add(btnLogout);
        sidebar.add(Box.createVerticalStrut(30));

        // PHẦN NỘI DUNG CHÍNH - Điều chỉnh cân đối
        JPanel rightPanel = new JPanel(new BorderLayout(0, 20));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        // Tiêu đề ngắn gọn hơn
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(54, 104, 181));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 10));
        titlePanel.setPreferredSize(new Dimension(0, 90));
        
        JLabel lblTitle = new JLabel("Quản lý thuốc");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 42));
        lblTitle.setForeground(Color.WHITE);
        titlePanel.add(lblTitle, BorderLayout.WEST);
        
        rightPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel chứa các nút chức năng - Thiết kế đẹp hơn
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        // Các nút chức năng với style nhất quán
        String[] btnTexts = {
            "Chỉnh sửa thông tin Thuốc",
            "Nhập thông tin Thuốc",
            "Xóa Thuốc",
            "Tìm kiếm và xem Thuốc"
        };
        
        for (String text : btnTexts) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.setBackground(new Color(230, 235, 245));
            btn.setForeground(new Color(40, 70, 120));
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(120, 156, 230), 2, true),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)));
            
            // Hiệu ứng hover đơn giản
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(200, 220, 250));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(230, 235, 245));
                }
            });
            
            buttonPanel.add(btn, gbc);
        }

        // Thêm panel nút vào container chính với căn giữa
        JPanel centeringPanel = new JPanel(new GridBagLayout());
        centeringPanel.setBackground(Color.WHITE);
        centeringPanel.add(buttonPanel);
        rightPanel.add(centeringPanel, BorderLayout.CENTER);

        // Thêm vào panel chính
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    // Class avatar với hiển thị chữ cái đầu
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
            
            // Vẽ hình tròn avatar
            g2.setColor(bgColor);
            g2.fillOval(0, 0, size, size);
            
            // Vẽ viền
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
            g2.drawOval(1, 1, size-3, size-3);
            
            // Vẽ chữ cái
            if (!letter.isEmpty()) {
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, size/2));
                FontMetrics fm = g2.getFontMetrics();
                int x = (size - fm.stringWidth(letter)) / 2;
                int y = (size - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString(letter, x, y);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Tạo dữ liệu mẫu để kiểm tra
            new MedicineManageUI(
                "admin123", 
                "Nguyễn Văn A", 
                "01/01/1990", 
                "0912345678", 
                "nguyenvana@example.com", 
                "quanly"
            ).setVisible(true);
        });
    }

}
