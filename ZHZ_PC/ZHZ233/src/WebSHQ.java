import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.json.JSONObject;

public class WebSHQ extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_ddh;
	private Map<String, Key> keyMap;
	private String _access;
	private String _passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					WebSHQ frame = new WebSHQ();
					frame.setVisible(true);
					ShutdownCallbackThread hook = new ShutdownCallbackThread();
			        Runtime.getRuntime().addShutdownHook(hook);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	public WebSHQ() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SHQ.class.getResource("/img/sy_public_logo.gif")));
		setBounds(600, 150, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				ImageIcon imageIcon = new ImageIcon("src/img/sy_public_logo.gif");
				Image img = imageIcon.getImage();
				g.drawImage(img, 0, 0, 260, 155, imageIcon.getImageObserver());
			}
		};
		panel.setBounds(0, 0, 260, 155);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		textField_ddh = new JTextField("�������Ķ�����");
		textField_ddh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_ddh.setText("");
			}
		});
		textField_ddh.setColumns(10);
		textField_ddh.setBounds(273, 52, 304, 32);
		this.getContentPane().add(textField_ddh);
		
		
		JButton btnNewButton = new JButton("��ȡ����");
		btnNewButton.setBounds(374, 97, 97, 23);
		this.getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
			
		panel_1.setBounds(24, 162, 236, 125);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel();
		ImageIcon icon1 = new ImageIcon("src/img/404.jpg");
		icon1.setImage(icon1.getImage().getScaledInstance(226, 125,  Image.SCALE_DEFAULT));  
		lblNewLabel_1.setIcon(icon1);
		panel_1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(274, 132, 284, 155);
		this.getContentPane().add(textArea);
		textArea.setText("��Ϸ������Ϣ�ٴ˴���ʾ");
		
		JButton button = new JButton("��¼/ע��");
		button.setBounds(480, 97, 97, 23);
		this.getContentPane().add(button);
		
		JButton button_1 = new JButton("��ȡ����");
		
		button_1.setBounds(10, 315, 97, 23);
		this.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("��ҪͶ��");
		button_2.setBounds(252, 315, 97, 23);
		this.getContentPane().add(button_2);
		
		JButton btnNewButton_1 = new JButton("��Ҫ����");
		btnNewButton_1.setBounds(477, 315, 97, 23);
		this.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("<html>��ܰ��ʾ��1.�Ϻ�ǰ���ȵ�¼�˺Ų���ȡ����<br>"+
										"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.�����һ���Ϻš����Ϻ������Զ�����������Ϻ�<br>"
										+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.ʹ��ǰ��ȷ��ϵͳ�Ѱ�װFirefox�����</html>");
		lblNewLabel.setBounds(10, 348, 516, 55);
		this.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("��ǰ��¼�˺ţ�");
		label.setForeground(new Color(224, 74, 59));
		label.setBounds(274, 19, 107, 18);
		this.getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setForeground(new Color(224, 74, 59));
		lblNewLabel_2.setBounds(374, 19, 152, 18);
		FileInputStream inputStream = new FileInputStream(new File("src/lib/UserInfo.mkey"));
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String userName = bufferedReader.readLine();
		String session = bufferedReader.readLine();
		if(userName!=null && session!=null) {
			lblNewLabel_2.setText(userName);
		}
		this.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("һ���Ϻ�");
		btnNewButton_2.setBounds(274, 97, 97, 23);
		getContentPane().add(btnNewButton_2);
		
		//������ȡ��ť����ʱ��
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String userName = null;
				String session = null;
				try {
					FileInputStream inputStream = new FileInputStream(new File("src/lib/UserInfo.mkey"));
					InputStreamReader reader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(reader);
					userName = bufferedReader.readLine();
					session = bufferedReader.readLine();
					if(userName==null || session==null) {
						JOptionPane.showMessageDialog(new JPanel(), "��¼�������", "����",JOptionPane.WARNING_MESSAGE); 
						return;
					}//��֤��½Ϊtrue
					
					String orderNo = textField_ddh.getText();
					if(!Utils.IsNumber(orderNo)) {
						JOptionPane.showMessageDialog(new JPanel(), "������ȷ�Ķ����ź��˺ţ�", "����",JOptionPane.WARNING_MESSAGE); 
						return;
					}
					// RSA ��ȡ��Կ
					RSACoder RSA = new RSACoder();
					String publicKey = null;
					String privateKey = null;
					keyMap = RSA.initKey();
					publicKey = RSA.getPublicKey(keyMap);
					privateKey = RSA.getPrivateKey(keyMap);
					System.out.println(publicKey);

					// �������
					MySocket mySocket = new MySocket();
					byte[] bytePass = null;
					byte[] data;
					try {
						data = mySocket.run(orderNo, publicKey, userName, session);
						if (data.length != 0) {
							bytePass = RSA.decryptByPrivateKey(data, privateKey);
						}else {
							bytePass = "NULL".getBytes();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String passWord = new String(bytePass);
					// ��ȡ������Ϣ
					String orderInfo = mySocket.getOrderInfo(userName, session, orderNo);
					if(orderInfo.equals("�û���Ϣ���ڣ����µ�½")) {
						JOptionPane.showMessageDialog(new JPanel(), "�û���Ϣ���ڣ����µ�¼", "����",JOptionPane.WARNING_MESSAGE);
						return;
					} else if (!orderInfo.isEmpty()) {
						JSONObject jsonObject = new JSONObject(orderInfo);
						textArea.setText(
								jsonObject.getString("goods_theme") + "\r\n" + "�����ţ�" + jsonObject.getString("order_no")
										+ "\r\n" + "��ʼʱ�䣺" + jsonObject.getString("order_start_time")
										+ "\r\n" + "����ʱ�䣺" + jsonObject.getString("order_end_time") 
										+ "\r\n" + "��Ϸ����"+ jsonObject.getString("game_name")
										+ "\r\n" + "������"+ jsonObject.getString("goods_area") + jsonObject.getString("goods_server")
										+ "\r\n" + "�˺ţ�"+jsonObject.getString("goods_access"));
						_access = jsonObject.getString("goods_access");
						_passWord = passWord;
						
						if(jsonObject.getString("game_name").equals("Ӣ������")) {
							ImageIcon imageIcon = new ImageIcon("src/img/LOL.jpg");
							imageIcon.setImage(imageIcon.getImage().getScaledInstance(226, 125,  Image.SCALE_DEFAULT));  
							lblNewLabel_1.setIcon(imageIcon);
						}else if(jsonObject.getString("game_name").equals("��������")) {
							ImageIcon imageIcon = new ImageIcon("src/img/cj.jpg");
							imageIcon.setImage(imageIcon.getImage().getScaledInstance(226, 125,  Image.SCALE_DEFAULT));  
							lblNewLabel_1.setIcon(imageIcon);
						}else if(jsonObject.getString("game_name").equals("4399")) {
							ImageIcon imageIcon = new ImageIcon("src/img/4399.jpg");
							imageIcon.setImage(imageIcon.getImage().getScaledInstance(226, 125,  Image.SCALE_DEFAULT));  
							lblNewLabel_1.setIcon(imageIcon);
						}else {
							ImageIcon imageIcon = new ImageIcon("src/img/404.jpg");
							imageIcon.setImage(imageIcon.getImage().getScaledInstance(226, 125,  Image.SCALE_DEFAULT));  
							lblNewLabel_1.setIcon(imageIcon);
						}
						//��ʱ���߶�ʱ����
						QuartzDoing rescue = new QuartzDoing(orderNo);
						new Thread(rescue).start();
					}else {
						textArea.setText("ϵͳ����");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		/**
		 * ��½ע����ť
		 */
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = null;
				String session = null;
				FileInputStream inputStream;
				try {
					inputStream = new FileInputStream(new File("src/lib/UserInfo.mkey"));
					InputStreamReader reader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(reader);
					userName = bufferedReader.readLine();
					session = bufferedReader.readLine();
					if (userName == null || session == null) {
						Login L = new Login(WebSHQ.this);
						L.setVisible(true);
						lblNewLabel_2.setText(L.getLabelValue());
						return;
					}else {
						Cancel C = new Cancel(WebSHQ.this);
						C.setVisible(true);
						if(C.isCancel()) {
							lblNewLabel_2.setText("");
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		/**
		 * һ���ϺŰ�ť����
		 */
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Schedul4399Utils Utils = new Schedul4399Utils();
		        Utils.Schedul4399(_access, _passWord);
			}
		});
	}
	
	static class ShutdownCallbackThread extends Thread {
		public void run() {
			System.out.println("����Ҫ�ر���");
			String closeSteam = "taskkill /f /t /im geckodriver.exe";
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec(closeSteam);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//ִ��CMD����
		}// ���ùرշ�ֵ
	}
}