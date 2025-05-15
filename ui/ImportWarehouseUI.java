package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ImportWarehouseUI extends JFrame {
    public ImportWarehouseUI(String tenDangNhap, String hoTen, String ngaySinh, String sdt, String email, String role) {
        setTitle("Nhập kho - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout());
        main.add( Sidebar.create(tenDangNhap, hoTen, ngaySinh, sdt, email, role), BorderLayout.WEST );

        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);
        // Title 
        JPanel title = new JPanel();
        title.setBackground(new Color(54,104,181));
        title.setPreferredSize(new Dimension(0,100));
        title.add(new JLabel("Nhập kho")).setFont(new Font("Arial", Font.BOLD|Font.ITALIC, 48));
        right.add(title, BorderLayout.NORTH);

        // Center: table + form
        JPanel center = new JPanel(new GridLayout(1,2,20,20));
        center.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        // Table
        String[] cols = {"ID Thuốc","Mã Thuốc","Tên Thuốc","Số Lượng"};
        JTable table = new JTable(new DefaultTableModel(cols,0));
        center.add(new JScrollPane(table));

        // Form panel
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0; gbc.gridy=0;
        form.add(new JLabel("Ngày Nhập:"),gbc);
        gbc.gridx=1; form.add(new JComboBox<>(),gbc);
        gbc.gridx=0; gbc.gridy=1; form.add(new JLabel("Mã Nhập kho:"),gbc);
        gbc.gridx=1; form.add(new JTextField(),gbc);
        gbc.gridx=0; gbc.gridy=2; form.add(new JLabel("Hạn Sử Dụng:"),gbc);
        gbc.gridx=1; form.add(new JTextField(),gbc);
        gbc.gridx=0; gbc.gridy=3; form.add(new JLabel("Ngày sản xuất:"),gbc);
        gbc.gridx=1; form.add(new JComboBox<>(),gbc);

        // Button thêm
        JPanel btnP = new JPanel(); btnP.setBackground(Color.WHITE);
        JButton b = new JButton("Thêm Thuốc Mới Vào Kho");
        btnP.add(b);
        gbc.gridx=0; gbc.gridy=4; gbc.gridwidth=2;
        form.add(btnP,gbc);

        center.add(form);
        right.add(center, BorderLayout.CENTER);

        main.add(right, BorderLayout.CENTER);
        setContentPane(main);
    }
}