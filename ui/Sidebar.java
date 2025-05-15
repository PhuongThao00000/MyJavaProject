package QuanLyNhaThuoc.ui;

import javax.swing.*;
import java.awt.*;

public class Sidebar {
    public static JPanel create(String tenDn, String hoTen, String ns, String sdt, String email, String role) {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(120,156,230));
        sidebar.setPreferredSize(new Dimension(350,800));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.add(Box.createVerticalStrut(30));
        AvatarCircle av = new AvatarCircle(tenDn.substring(0,1).toUpperCase(), new Color(41,98,173), 140);
        av.setAlignmentX(Component.CENTER_ALIGNMENT); sidebar.add(av);
        sidebar.add(Box.createVerticalStrut(10));
        JLabel r = new JLabel(role.equalsIgnoreCase("quanly")?"Quản Lý":"Nhân Viên");
        r.setFont(new Font("Arial", Font.ITALIC|Font.BOLD,28)); r.setForeground(Color.WHITE); r.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(r); sidebar.add(Box.createVerticalStrut(20));
        JPanel info = new JPanel(); info.setBackground(new Color(180,200,240)); info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        info.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); info.setMaximumSize(new Dimension(320,220));
        info.add(new JLabel("Thông tin cá nhân")); info.add(Box.createVerticalStrut(10));
        info.add(new JLabel("Họ tên: " + hoTen)); info.add(new JLabel("Ngày sinh: " + ns));
        info.add(new JLabel("SĐT: " + sdt)); info.add(new JLabel("Email: " + email));
        sidebar.add(info);
        sidebar.add(Box.createVerticalGlue());
        JButton lo = new JButton("←  Log out"); lo.setFont(new Font("Arial",Font.BOLD,22)); lo.setBackground(new Color(54,104,181)); lo.setForeground(Color.WHITE);
        lo.setMaximumSize(new Dimension(200,50)); lo.setAlignmentX(Component.CENTER_ALIGNMENT); sidebar.add(lo);
        sidebar.add(Box.createVerticalStrut(30));
        return sidebar;
    }

    // AvatarCircle inner class
    static class AvatarCircle extends JPanel {
        private String letter; private Color bg; private int size;
        public AvatarCircle(String letter, Color bg, int size) { this.letter=letter; this.bg=bg; this.size=size;
            setPreferredSize(new Dimension(size,size)); setMaximumSize(new Dimension(size,size)); setOpaque(false);
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(bg); g2.fillOval(0,0,size,size);
            g2.setColor(Color.WHITE); g2.setFont(new Font("Arial",Font.BOLD,size/2));
            FontMetrics fm=g2.getFontMetrics();
            int x=(size-fm.stringWidth(letter))/2;
            int y=(size-fm.getHeight())/2+fm.getAscent();
            g2.drawString(letter,x,y);
        }
    }
}
