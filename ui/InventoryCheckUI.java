package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryCheckUI extends JFrame {
    public InventoryCheckUI(String ten, String hoTen, String ns, String sdt, String email, String role) {
        setTitle("Kiểm tra tồn kho - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400,800);
        setLocationRelativeTo(null);
 
        JPanel main = new JPanel(new BorderLayout());
        main.add(Sidebar.create(ten,hoTen,ns,sdt,email,role),BorderLayout.WEST);

        JPanel right = new JPanel(new BorderLayout()); right.setBackground(Color.WHITE);
        JPanel title = new JPanel(); title.setBackground(new Color(54,104,181)); title.setPreferredSize(new Dimension(0,100));
        JLabel lbl = new JLabel("Kiểm tra tồn kho"); lbl.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,48)); lbl.setForeground(Color.WHITE);
        title.add(lbl); right.add(title,BorderLayout.NORTH);

        JPanel topSearch = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10)); topSearch.setBackground(new Color(230,240,255));
        topSearch.add(new JLabel(new ImageIcon("search_icon.png")));
        topSearch.add(new JTextField(30));
        JButton btnCheck = new JButton("Kiểm Tra Tồn Kho");
        topSearch.add(btnCheck);
        right.add(topSearch,BorderLayout.NORTH);

        String[] cols = {"Mã Sản Phẩm","Tên Sản Phẩm","Số Lượng","Đơn Vị","Giá Trị Tồn Kho"};
        JTable table = new JTable(new DefaultTableModel(cols,0));
        right.add(new JScrollPane(table), BorderLayout.CENTER);

        // Footer stats
        JPanel footer = new JPanel(new GridLayout(2,3,20,10)); footer.setBorder(BorderFactory.createEmptyBorder(10,30,30,30)); footer.setBackground(Color.WHITE);
        footer.add(new JLabel("Số Lượng Đã Bán:")); footer.add(new JTextField()); footer.add(new JLabel());
        footer.add(new JLabel("Số Lượng Đã Nhập:")); footer.add(new JTextField()); footer.add(new JLabel());
        right.add(footer, BorderLayout.SOUTH);

        main.add(right,BorderLayout.CENTER);
        setContentPane(main);
    }
}