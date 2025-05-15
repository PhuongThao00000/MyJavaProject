package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class EditMedicineUI extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(54, 104, 181);
    private static final Color SECONDARY_COLOR = new Color(120, 156, 230);
    private static final Color LIGHT_BG_COLOR = new Color(240, 245, 255);
    
    public EditMedicineUI() {
        setTitle("Chỉnh sửa Thuốc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("Chỉnh sửa Thuốc");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        
        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        // ID Thuốc with Search
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.setBackground(Color.WHITE);
        JLabel idLabel = new JLabel("ID Thuốc");
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        idPanel.add(idLabel);
        
        JTextField idField = new JTextField(15);
        idPanel.add(idField);
        
        JButton searchBtn = new JButton("Tìm Kiếm");
        styleButton(searchBtn);
        idPanel.add(searchBtn);
        
        formPanel.add(idPanel);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Tên Thuốc
        addLabelAndField(formPanel, "Tên Thuốc", 20);
        
        // Số Thuốc
        addLabelAndField(formPanel, "Số Thuốc", 20);
        
        // Ngày sản xuất
        addLabelAndField(formPanel, "Ngày sản xuất", 20);
        
        // Ngày Hết Hạn
        addLabelAndField(formPanel, "Ngày Hết Hạn", 20);
        
        // Số Lượng Có Sẵn
        addLabelAndField(formPanel, "Số Lượng Có Sẵn", 10);
        
        // Thêm Số Lượng
        addLabelAndField(formPanel, "Thêm Số Lượng", 10);
        
        // Giá cho Mỗi Đơn Vị
        addLabelAndField(formPanel, "Giá cho Mỗi Đơn Vị", 10);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.WHITE);
        
        JButton updateBtn = new JButton("Cập Nhật");
        styleButton(updateBtn, new Color(76, 175, 80));
        buttonPanel.add(updateBtn);
        
        JButton reloadBtn = new JButton("Tải Lại");
        styleButton(reloadBtn);
        buttonPanel.add(reloadBtn);
        
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(buttonPanel);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        setContentPane(mainPanel);
    }
    
    private void addLabelAndField(JPanel parent, String labelText, int fieldSize) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.WHITE);
        
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(label);
        
        JTextField textField = new JTextField(fieldSize);
        panel.add(textField);
        
        parent.add(panel);
        parent.add(Box.createVerticalStrut(10));
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }
    
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EditMedicineUI().setVisible(true);
        });
    }
}