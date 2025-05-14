package QuanLyNhaThuoc.ui;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import QuanLyNhaThuoc.service.NguoiDungService;
import QuanLyNhaThuoc.model.NguoiDung;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class LoginUI extends JFrame {
	private NguoiDungService nguoiDungService = new NguoiDungService();

	public LoginUI() {
		setTitle("IOU - Đăng Nhập");
		setSize(900, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Panel trái - chào mừng
		JPanel leftPanel = new JPanel() {
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
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setPreferredSize(new Dimension(400, 550));

		// Panel cho nội dung trung tâm phía trái
		JPanel leftContentPanel = new JPanel();
		leftContentPanel.setOpaque(false);
		leftContentPanel.setLayout(new BoxLayout(leftContentPanel, BoxLayout.Y_AXIS));
		leftContentPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

		JLabel welcomeLabel = new JLabel("CHÀO MỪNG ĐẾN VỚI", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Logo panel with rounded corners
		RoundedPanel logoPanel = new RoundedPanel(15, new Color(40, 80, 160));
		logoPanel.setLayout(new GridBagLayout());
		logoPanel.setMaximumSize(new Dimension(250, 120));
		logoPanel.setPreferredSize(new Dimension(250, 120));
		logoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel logoLabel = new JLabel("IOU", SwingConstants.CENTER);
		logoLabel.setFont(new Font("Arial", Font.BOLD, 80));
		logoLabel.setForeground(Color.WHITE);
		logoPanel.add(logoLabel);

		// Slogan	
		leftContentPanel.add(Box.createVerticalGlue());
		leftContentPanel.add(welcomeLabel);
		leftContentPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		leftContentPanel.add(logoPanel);
		leftContentPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		leftContentPanel.add(Box.createVerticalGlue());

		leftPanel.add(leftContentPanel);

		// Panel phải - form đăng nhập
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setBackground(new Color(240, 245, 255));

		JPanel loginFormPanel = new JPanel(new GridBagLayout());
		loginFormPanel.setBackground(Color.WHITE);
		loginFormPanel.setBorder(BorderFactory.createCompoundBorder(
			new ShadowBorder(20, 10),
			BorderFactory.createEmptyBorder(30, 40, 40, 40)));
		loginFormPanel.setPreferredSize(new Dimension(380, 460));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;

		// User icon
		JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		iconPanel.setOpaque(false);
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/QuanLyNhaThuoc/ui/img/user.png"));
		Image scaledImage = userIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
		iconPanel.add(iconLabel);
		loginFormPanel.add(iconPanel, gbc);

		gbc.gridy++;
		JLabel formTitle = new JLabel("ĐĂNG NHẬP");
		formTitle.setFont(new Font("Arial", Font.BOLD, 24));
		formTitle.setForeground(new Color(54, 104, 181));
		formTitle.setHorizontalAlignment(SwingConstants.CENTER);
		loginFormPanel.add(formTitle, gbc);

		gbc.gridy++;
		gbc.gridwidth = 2;
		loginFormPanel.add(Box.createRigidArea(new Dimension(0, 15)), gbc);

		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel userLabel = new JLabel("Tên đăng nhập");
		userLabel.setFont(new Font("Arial", Font.BOLD, 14));
		loginFormPanel.add(userLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField userField = new JTextField();
		userField.setFont(new Font("Arial", Font.PLAIN, 16));
		userField.setPreferredSize(new Dimension(300, 40));
		userField.setMaximumSize(new Dimension(Short.MAX_VALUE, 40));
		userField.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(new Color(200, 210, 225), 1, true),
			BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		loginFormPanel.add(userField, gbc);

		gbc.gridy++;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		JLabel passLabel = new JLabel("Mật khẩu");
		passLabel.setFont(new Font("Arial", Font.BOLD, 14));
		loginFormPanel.add(passLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JPasswordField passField = new JPasswordField();
		passField.setFont(new Font("Arial", Font.PLAIN, 16));
		passField.setPreferredSize(new Dimension(300, 40));
		passField.setMaximumSize(new Dimension(Short.MAX_VALUE, 40));
		passField.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(new Color(200, 210, 225), 1, true),
			BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		passField.setEchoChar('•');
		loginFormPanel.add(passField, gbc);

		gbc.gridy++;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		JCheckBox showPass = new JCheckBox("Hiển thị mật khẩu");
		showPass.setFont(new Font("Arial", Font.PLAIN, 14));
		showPass.setBackground(Color.WHITE);
		showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showPass.setFocusPainted(false);
		loginFormPanel.add(showPass, gbc);

		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		loginFormPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);

		gbc.gridy++;
		JButton loginButton = new JButton("Đăng nhập");
		loginButton.setFont(new Font("Arial", Font.BOLD, 18));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(54, 104, 181));
		loginButton.setFocusPainted(false);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		loginButton.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));
		loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				loginButton.setBackground(new Color(75, 125, 200));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				loginButton.setBackground(new Color(54, 104, 181));
			}
		});
		loginFormPanel.add(loginButton, gbc);

		rightPanel.add(loginFormPanel);

		// Add action listeners
		loginButton.addActionListener(e -> {
			String username = userField.getText().trim();
			String password = new String(passField.getPassword());

			NguoiDung nd = nguoiDungService.dangNhap(username, password);
			if (nd != null) {
				// Đăng nhập thành công
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				// Mở giao diện chính
				if ("quanly".equals(nd.getVaiTro())) {
					new MedicineManageUI(
						nd.getTenDangNhap(),
						nd.getHoTen(),
						nd.getNgaySinh() != null ? nd.getNgaySinh().toString() : "",
						nd.getSdt(),
						nd.getEmail(),
						nd.getVaiTro()
					).setVisible(true);
				} else if ("nhanvien".equals(nd.getVaiTro())) {
					new StaffHomeUI(
						nd.getTenDangNhap(),
						nd.getHoTen(),
						nd.getNgaySinh() != null ? nd.getNgaySinh().toString() : "",
						nd.getSdt(),
						nd.getEmail(),
						nd.getVaiTro()
					).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "Vai trò không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				dispose(); // Đóng LoginUI
			} else {
				// Đăng nhập thất bại
				JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Xử lý checkbox
		showPass.addActionListener(e -> {
			passField.setEchoChar(showPass.isSelected() ? (char) 0 : '•');
		});

		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	// Panel with rounded corners
	static class RoundedPanel extends JPanel {
		private int cornerRadius;
		private Color bgColor;

		public RoundedPanel(int radius, Color bgColor) {
			super();
			this.cornerRadius = radius;
			this.bgColor = bgColor;
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(bgColor);
			g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
			g2d.dispose();
		}
	}

	// Shadow border for panels
	static class ShadowBorder extends AbstractBorder {
		private int shadowSize = 5;
		private int cornerRadius = 15;
		
		public ShadowBorder(int cornerRadius, int shadowSize) {
			this.cornerRadius = cornerRadius;
			this.shadowSize = shadowSize;
		}
		
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			Color shadowColor = new Color(0, 0, 0, 50);
			g2.setColor(shadowColor);
			for (int i = 0; i < shadowSize; i++) {
				// Vẽ bóng đổ
				int shadowOffset = i;
				g2.fill(new RoundRectangle2D.Double(x + shadowOffset, y + shadowOffset, 
					   width - shadowOffset*2, height - shadowOffset*2, cornerRadius, cornerRadius));
			}
			
			// Vẽ nền trắng đè lên bóng đổ
			g2.setColor(Color.WHITE);
			g2.fill(new RoundRectangle2D.Double(x, y, width - shadowSize, height - shadowSize, cornerRadius, cornerRadius));
			
			g2.dispose();
		}
		
		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(shadowSize, shadowSize, shadowSize*2, shadowSize*2);
		}
		
		@Override
		public Insets getBorderInsets(Component c, Insets insets) {
			insets.left = insets.top = shadowSize;
			insets.right = insets.bottom = shadowSize*2;
			return insets;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new LoginUI());
	}
}
