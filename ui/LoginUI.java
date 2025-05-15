package QuanLyNhaThuoc.ui;

import javax.swing.*;
import QuanLyNhaThuoc.service.NguoiDungService;
import QuanLyNhaThuoc.model.NguoiDung;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
	private NguoiDungService nguoiDungService = new NguoiDungService();
    public LoginUI() {
        setTitle("IOU Login");
        setSize(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel trái - chào mừng
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(118, 150, 229)); // Màu xanh nhạt
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(400, 450));

        JLabel welcomeLabel = new JLabel("CHÀO MỪNG ĐẾN VỚI", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoLabel = new JLabel("IOU", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 80));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setBackground(new Color(40, 80, 160)); // Màu xanh đậm
        logoLabel.setOpaque(true);
        logoLabel.setPreferredSize(new Dimension(300, 120));
        logoLabel.setMaximumSize(new Dimension(300, 120));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel loginText = new JLabel("Đăng nhập vào trang chủ");
        loginText.setFont(new Font("Arial", Font.ITALIC, 14));
        loginText.setForeground(Color.WHITE);
        loginText.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginText.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(welcomeLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(logoLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(loginText);
        leftPanel.add(Box.createVerticalGlue());

        // Panel phải - form đăng nhập	
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);

     // Load icon từ file user.png
        ImageIcon userIcon = new ImageIcon(getClass().getResource("/QuanLyNhaThuoc/ui/img/user.png"));
        Image scaledImage = userIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
        iconLabel.setBounds(180, 20, 80, 80);
        rightPanel.add(iconLabel);


        JLabel userLabel = new JLabel("Tên đăng nhập");
        userLabel.setBounds(100, 100, 200, 20);
        rightPanel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 125, 250, 30);
        rightPanel.add(userField);

        JLabel passLabel = new JLabel("Mật khẩu");
        passLabel.setBounds(100, 170, 200, 20);
        rightPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 195, 250, 30);
        rightPanel.add(passField);

        JCheckBox showPass = new JCheckBox("Hiển thị mật khẩu");
        showPass.setBounds(100, 230, 200, 20);
        rightPanel.add(showPass);

        JButton loginButton = new JButton("Đăng nhập");
        loginButton.setBounds(100, 270, 250, 40);
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        rightPanel.add(loginButton);
        
        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword());

            NguoiDung nd = nguoiDungService.dangNhap(username, password);
            if (nd != null) {
                // Đăng nhập thành công
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Mở giao diện chính (ManagerHomeUI)
               if(nd.getVaiTro()=="admin") {
            	   new ManagerHomeUI(
                    nd.getTenDangNhap(),
                    nd.getHoTen(),
                    nd.getNgaySinh() != null ? nd.getNgaySinh().toString() : "",
                    nd.getSdt(),
                    nd.getEmail(),
                    nd.getVaiTro()
                ).setVisible(true);
               } else {
            	   new StaffHomeUI(
                    nd.getTenDangNhap(),
                    nd.getHoTen(),
                    nd.getNgaySinh() != null ? nd.getNgaySinh().toString() : "",
                    nd.getSdt(),
                    nd.getEmail(),
                    nd.getVaiTro()
                ).setVisible(true);
               }
                dispose(); // Đóng LoginUI
            } else {
                // Đăng nhập thất bại
                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Xử lý checkbox
        showPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passField.setEchoChar(showPass.isSelected() ? (char) 0 : '•');
            }
        });

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
