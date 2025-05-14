package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class WelcomeUI extends JFrame {
    public WelcomeUI() {
        setTitle("HỆ THỐNG QUẢN LÝ NHÀ THUỐC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        
        // Panel chính với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 245, 255));
        
        // Header panel với gradient
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Gradient background
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(54, 104, 181), 
                    0, getHeight(), new Color(120, 156, 230));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        headerPanel.setPreferredSize(new Dimension(0, 100));
        headerPanel.setLayout(new BorderLayout());
        
        // Tiêu đề
        JLabel titleLabel = new JLabel("HỆ THỐNG QUẢN LÝ NHÀ THUỐC", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Panel trung tâm chứa logo và slogan
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(240, 245, 255));
        
        // Panel logo với viền bo tròn
        RoundedPanel logoPanel = new RoundedPanel(20, new Color(41, 98, 173));
        logoPanel.setPreferredSize(new Dimension(700, 280));
        logoPanel.setLayout(new GridBagLayout());
        
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        
        // Logo Panel
        JPanel textLogoPanel = new JPanel();
        textLogoPanel.setOpaque(false);
        textLogoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        
        JLabel iouLabel = new JLabel("IOU");
        iouLabel.setFont(new Font("Arial", Font.BOLD, 90));
        iouLabel.setForeground(Color.WHITE);
        
        JLabel dashLabel = new JLabel("–");
        dashLabel.setFont(new Font("Arial", Font.BOLD, 60));
        dashLabel.setForeground(Color.WHITE);
        
        JLabel toiTrongBanLabel = new JLabel("Tôi trong bạn");
        toiTrongBanLabel.setFont(new Font("Arial", Font.BOLD, 60));
        toiTrongBanLabel.setForeground(Color.WHITE);
        
        textLogoPanel.add(iouLabel);
        textLogoPanel.add(dashLabel);
        textLogoPanel.add(toiTrongBanLabel);
        contentPanel.add(textLogoPanel, BorderLayout.CENTER);
        
        // Slogan
        JLabel sloganLabel = new JLabel("Chăm sóc sức khỏe - Tận tâm phục vụ", SwingConstants.CENTER);
        sloganLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        sloganLabel.setForeground(new Color(200, 220, 255));
        sloganLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        contentPanel.add(sloganLabel, BorderLayout.SOUTH);
        
        logoPanel.add(contentPanel);
        
        centerPanel.add(logoPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Panel chứa nút đăng nhập
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(240, 245, 255));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 40, 0));
        
        // Nút đăng nhập với style đẹp
        JButton loginButton = new JButton("ĐĂNG NHẬP");
        loginButton.setFont(new Font("Arial", Font.BOLD, 24));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(54, 104, 181));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 220, 255), 1),
            BorderFactory.createEmptyBorder(12, 40, 12, 40)));
        
        // Hiệu ứng hover cho nút
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(75, 125, 200));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(54, 104, 181));
            }
        });
        
        // Thêm sự kiện chuyển sang LoginUI
        loginButton.addActionListener(e -> {
            new LoginUI(); // Mở giao diện đăng nhập
            dispose();     // Đóng WelcomeUI
        });
        
        bottomPanel.add(loginButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        setContentPane(mainPanel);
    }
    
    // Class để tạo panel với góc bo tròn
    static class RoundedPanel extends JPanel {
        private int cornerRadius;
        private Color backgroundColor;
        
        public RoundedPanel(int radius, Color bgColor) {
            super();
            this.cornerRadius = radius;
            this.backgroundColor = bgColor;
            setOpaque(false);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Add shadow effect
            g2d.setColor(new Color(30, 70, 120, 50));
            g2d.fill(new RoundRectangle2D.Double(5, 5, getWidth()-10, getHeight()-10, cornerRadius+2, cornerRadius+2));
            
            // Fill panel
            g2d.setColor(backgroundColor);
            g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth()-5, getHeight()-5, cornerRadius, cornerRadius));
            
            g2d.dispose();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomeUI().setVisible(true);
        });
    }
}
