package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewMedicineListUI extends JFrame {
    public ViewMedicineListUI(String ten, String hoTen, String ns, String sdt, String email, String role) {
        setTitle("Xem danh mục Thuốc - Hệ thống quản lý nhà thuốc");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400,800);
        setLocationRelativeTo(null); 

        JPanel main = new JPanel(new BorderLayout());  
        main.add(Sidebar.create(ten,hoTen,ns,sdt,email,role),BorderLayout.WEST);

        JPanel right = new JPanel(new BorderLayout()); right.setBackground(Color.WHITE);
        JPanel title = new JPanel(); title.setBackground(new Color(54,104,181)); title.setPreferredSize(new Dimension(0,100));
        JLabel lbl = new JLabel("Xem danh mục Thuốc"); lbl.setFont(new Font("Arial", Font.BOLD|Font.ITALIC,48)); lbl.setForeground(Color.WHITE);
        title.add(lbl); right.add(title,BorderLayout.NORTH);

        String[] cols = {"Tên Thuốc","Công Dụng","Đơn Giá","Nhà Sản Xuất","Ghi Chú"};
        JTable table = new JTable(new DefaultTableModel(cols,0));
        right.add(new JScrollPane(table), BorderLayout.CENTER);

        main.add(right,BorderLayout.CENTER);
        setContentPane(main);
    }
}