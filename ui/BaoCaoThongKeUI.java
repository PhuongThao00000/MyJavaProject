package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main Dashboard UI
public class BaoCaoThongKeUI extends JFrame {

    public BaoCaoThongKeUI(String ten, String hoTen, String ns, String sdt, String email, String role) {
        setTitle("Dashboard - Hệ thống quản lý nhà thuốc");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());

        // Sidebar (giả định đã có class Sidebar với phương thức create)
        main.add(Sidebar.create(ten, hoTen, ns, sdt, email, role), BorderLayout.WEST);

        // Nội dung trung tâm
        JPanel content = new JPanel(new GridLayout(2, 2, 20, 20));
        content.setBackground(new Color(240, 240, 240));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        String[] menus = {"Báo cáo tồn kho", "Báo cáo nhập/xuất", "Thống kê doanh thu", "Quản lý nhân viên"};
        for (String menu : menus) {
            JPanel card = createMenuCard(menu);
            card.addMouseListener(new MenuClickListener(menu));
            content.add(card);
        }

        main.add(content, BorderLayout.CENTER);
        setContentPane(main);
    }

    private JPanel createMenuCard(String title) {
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(300, 200));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(54, 104, 181), 2));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(new Color(54, 104, 181));

        card.add(label, BorderLayout.CENTER);
        return card;
    }

    // Xử lý khi click vào card chức năng
    private class MenuClickListener extends MouseAdapter {
        private final String menuName;

        public MenuClickListener(String menuName) {
            this.menuName = menuName;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JFrame nextUI = null;

            switch (menuName) {
                case "Báo cáo tồn kho":
                    nextUI = new InventoryReportUI();
                    break;
                case "Báo cáo nhập/xuất":
                    nextUI = new ImportExportReportUI(); 
                    break;
                case "Thống kê doanh thu":
                    nextUI = new SalesReportUI();
                    break;
            }

            if (nextUI != null) {
                nextUI.setVisible(true);
                dispose();
            } 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BaoCaoThongKeUI("Admin", "Nguyễn Văn A", "01/01/1990",
                    "0900123456", "admin@pharmacy.com", "Quản lý").setVisible(true);
        });
    }
}
