package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUserUI extends JFrame {
    public AddUserUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Thêm người dùng - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        // Main panel chia 2 (sidebar + rightPanel)
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Sidebar tái sử dụng
        mainPanel.add(createSidebar(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST);

        // Right panel: tiêu đề + form + button
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);

        // Tiêu đề
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(54, 104, 181));
        titlePanel.setPreferredSize(new Dimension(0, 100));
        JLabel lblTitle = new JLabel("Thêm người dùng");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 48));
        lblTitle.setForeground(Color.WHITE);
        titlePanel.add(lblTitle);
        rightPanel.add(titlePanel, BorderLayout.NORTH);

        // --- Định dạng cho trường ngày sinh ---
        SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
        DateFormatter df = new DateFormatter(sf);
        df.setAllowsInvalid(false);
        JFormattedTextField ftfDate = new JFormattedTextField(new DefaultFormatterFactory(df));
        ftfDate.setValue(new Date());
        ftfDate.setColumns(10);

        // Form với GridBagLayout đã căn chỉnh hợp lý
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label cột nhỏ
        gbc.weightx = 0.2;
        // Field cột lớn
        // Row 0: Vai trò
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Vai Trò Người Dùng:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        JComboBox<String> cbRole = new JComboBox<>(new String[]{"Quản lý", "Nhân viên"});
        formPanel.add(cbRole, gbc);

        // Row 1: Họ tên
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Họ tên:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        // Row 2: Ngày sinh
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Ngày sinh:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(ftfDate, gbc);

        // Row 3: Số điện thoại
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Số điện thoại:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        // Row 4: Địa chỉ Email
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Địa chỉ Email:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        // Row 5: Tên đăng nhập
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Tên đăng nhập:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JTextField(), gbc);

        // Row 6: Mật khẩu
        gbc.gridx = 0; gbc.gridy = 6; gbc.weightx = 0.2;
        formPanel.add(new JLabel("Mật khẩu:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.8;
        formPanel.add(new JPasswordField(), gbc);

        // Button panel, căn giữa
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        buttonPanel.setBackground(Color.WHITE);
        JButton btnSave = new JButton("LƯU");
        btnSave.setFont(new Font("Arial", Font.BOLD, 24));
        btnSave.setPreferredSize(new Dimension(160, 50));
        JButton btnBack = new JButton("TRỞ VỀ");
        btnBack.setFont(new Font("Arial", Font.BOLD, 24));
        btnBack.setPreferredSize(new Dimension(160, 50));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnBack);

        rightPanel.add(formPanel, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

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
        lblRole.setFont(new Font("Arial", Font.BOLD, 28));
        lblRole.setForeground(Color.WHITE);
        lblRole.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(lblRole);
        sidebar.add(Box.createVerticalStrut(20));

        // Thông tin cá nhân
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
        infoPanel.add(Box.createVerticalStrut(30));
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

    // Class vẽ avatar tròn
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
        SwingUtilities.invokeLater(() -> {
            new AddUserUI(
                "admin",            // tenDangNhap
                "Nguyễn Văn A",     // hoTen
                "01/01/1990",       // ngaySinh
                "0900123456",       // sdt
                "a@example.com",    // email
                "quanly"            // role
            ).setVisible(true);
        });
    }
} 
