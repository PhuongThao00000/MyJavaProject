package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends JFrame {
    public WelcomeUI() {
        setTitle("HỆ THỐNG QUẢN LÝ NHÀ THUỐC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Panel nền ngoài cùng
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(120, 156, 230)); // Màu xanh nhạt
        outerPanel.setLayout(new BorderLayout(0, 0));

        // Tiêu đề trên cùng
        JLabel titleLabel = new JLabel("HỆ THỐNG QUẢN LÝ NHÀ THUỐC", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        outerPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel giữa (chứa khối xanh đậm và chữ IOU)
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(120, 156, 230));
        centerPanel.setLayout(new GridBagLayout());

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(new Color(41, 98, 173)); // Màu xanh đậm
        bluePanel.setPreferredSize(new Dimension(700, 220));
        bluePanel.setLayout(new GridBagLayout());

        // Tạo 2 label riêng biệt để dễ căn chỉnh
        JLabel iouLabel = new JLabel("IOU");
        iouLabel.setFont(new Font("Arial", Font.BOLD, 80));
        iouLabel.setForeground(Color.WHITE);

        JLabel dashLabel = new JLabel(" – ");
        dashLabel.setFont(new Font("Arial", Font.BOLD, 50));
        dashLabel.setForeground(Color.WHITE);

        JLabel toiTrongBanLabel = new JLabel("Tôi trong bạn");
        toiTrongBanLabel.setFont(new Font("Arial", Font.BOLD, 50));
        toiTrongBanLabel.setForeground(Color.WHITE);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(41, 98, 173));
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        textPanel.add(iouLabel);
        textPanel.add(dashLabel);
        textPanel.add(toiTrongBanLabel);

        bluePanel.add(textPanel);
        centerPanel.add(bluePanel);
        outerPanel.add(centerPanel, BorderLayout.CENTER);
 
        // Nút Đăng nhập
        JButton loginButton = new JButton("Đăng nhập");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setBackground(new Color(200, 220, 255));
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        // Thêm sự kiện chuyển sang LoginUI
        loginButton.addActionListener(e -> {
            new LoginUI(); // Mở giao diện đăng nhập
            dispose();     // Đóng WelcomeUI
        });

        // Panel cho nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(120, 156, 230));
        buttonPanel.add(loginButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        outerPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(outerPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomeUI().setVisible(true);
        });
    }
}