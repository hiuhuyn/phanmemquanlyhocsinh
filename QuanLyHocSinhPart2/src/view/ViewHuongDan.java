package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class ViewHuongDan extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Create the frame.
	 */
	
	
	
	public ViewHuongDan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewHuongDan.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		
		setTitle("Hướng dẫn");
		
		setBounds(100, 100, 580, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		String huongdan = "Cách sử dụng\r\n"
				+ "\r\n"
				+ "* Quản lý tài khoản\r\n"
				+ "- Thông tin tài khoản\r\n"
				+ "+ Cập nhật thông tin: Nhập thông tin mới -> Ấn cập nhật tài khoản -> Nhập mật khẩu -> OK\r\n"
				+ "+ Xóa tài khoản: Click \"Xóa tài khoản\" -> Nhập mật khẩu -> OK.\r\n"
				+ "\r\n"
				+ "- Đổi mật khẩu: Nhập mật khẩu cũ -> Nhập mật khẩu mới -> click \"Đổi mật khẩu\"\r\n"
				+ "\r\n"
				+ "* Quản lý học sinh - Hồ sơ học sinh\r\n"
				+ "- Tìm: Nhập mã học sinh cần tìm -> click \"Tim\"\r\n"
				+ "- Lưu: Nhập thông tin vào các ô nhập -> click \"Lưu\" -> nếu có rồi thì xác nhận cập nhật,\r\n"
				+ "nếu chưa có thì xác nhận Lưu\r\n"
				+ "- Reset: Click reset -> các ô nhập được gán bằng khoảng chống\r\n"
				+ "- Xóa: Nhập mã học sinh -> click \"Xóa\" -> xác nhận.\r\n"
				+ "\r\n"
				+ "* Quản lý lớp\r\n"
				+ "- Danh sách các lớp\r\n"
				+ "+ Tìm lớp: Nhập mã lớp -> click \"Tìm lớp\"\r\n"
				+ "+ Tạo/Cập nhật: Nhập thông tin lớp -> click \"Tạo/Cập nhật\"\r\n"
				+ "+ Xóa: Nhập mã lớp -> click xóa\r\n"
				+ "\r\n"
				+ "- Danh sách học sinh theo lớp\r\n"
				+ "+ Tìm: Chọn mã lớp -> click \"Tìm\"\r\n"
				+ "\r\n"
				+ "* Quản lý điểm - Bảng điểm môn\r\n"
				+ "- Tìm kiếm: chọn mã môn -> click \"Tìm kiếm\"\r\n"
				+ "- Lưu: Chọn mã môn, mã học sinh, mã học kỳ, nhập điểm -> click \"Lưu\"\r\n"
				+ "- Reset: Click reset -> các ô nhập được gán bằng khoảng chống\r\n"
				+ "- Xóa:  Chọn mã môn, mã học sinh, mã học kỳ -> click \"Xóa\"\r\n"
				+ "\r\n"
				+ "* Thống kê - Thống kê\r\n"
				+ "- Lập báo cáo: chọn bất kỳ Mã lớp hoặc mã học kỳ -> click \"Lập báo cao\".\r\n"
				+ "- Lấy đường dẫn: click \"Lấy đường dẫn\" -> nhập địa chỉ tên file muốn lưu/tạo \r\n"
				+ "-> địa chỉ sau khi chọn sẽ hiểu thị ở link file ( có thể click vào và chỉnh sửa )\r\n"
				+ "- In báo cáo: sau khi có được link file -> click \"In báo cáo\" -> mở file đã chọn\r\n"
				+ "\r\n"
				+ "* Quy định\r\n"
				+ "- Môn học\r\n"
				+ "+ Lưu: Nhập mã môn, tên môn -> click \"Lưu\". ( mã môn đã có thì sẽ cập nhật )\r\n"
				+ "+ Xóa: Nhập mã môn -> click \"Xóa\"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "- Học kỳ\r\n"
				+ "+ Lưu: Nhập thông tin học kỳ -> click \"Lưu\". ( mã học kỳ đã có thì sẽ cập nhật )\r\n"
				+ "+ Xóa: Nhập mã học kỳ -> click \"Xóa\".";
		
		
		textPane.setText(huongdan);
		
		
		setVisible(false);
		
	}

}
