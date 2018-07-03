import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.sun.glass.events.WindowEvent;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cancel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JButton btnNewButton;
	private boolean flag;
	/**
	 * Create the dialog.
	 */
	public Cancel(Frame shq) {
		super(shq,"Cancel",true);
		setResizable(false);
		setBounds(700, 250, 340, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btnNewButton = new JButton("确定");
		}
		{
			label = new JLabel("\u662F\u5426\u6CE8\u9500\u5F53\u524D\u7528\u6237\uFF1F");
		}
		
		JButton btnNewButton_1 = new JButton("取消");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(78)
							.addComponent(label)))
					.addGap(54))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(label)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(47)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(48)
							.addComponent(btnNewButton_1)))
					.addGap(16))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		/**
		 * 点击事件
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File file = new File("src/lib/UserInfo.mkey");
				try {
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write("");
					fileWriter.flush();
					fileWriter.close();
					flag = true;
					dispose();
				} catch (Exception e1) {
					flag = false;
					e1.printStackTrace();
				}
			}
		});
		
		/**
		 * 取消按钮点击事件
		 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
	
	public boolean isCancel() {
		return this.flag;
	}
}
