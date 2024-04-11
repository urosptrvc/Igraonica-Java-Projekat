import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



public class JFrameIgraonica extends JFrame {

	private JPanel contentPane;
	private JTextField tfVreme;
	private JTable tableIgraonica;
	private JTextField tfPazar;
	private JTextField tfUplata;
	private ArrayList<RacunarPice> ls = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIgraonica frame = new JFrameIgraonica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameIgraonica() {
		setTitle("EliteGaming");
		setForeground(new Color(77, 77, 77));
		setBackground(new Color(77, 77, 77));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Uros\\Downloads\\download.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(77, 77, 77));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(77, 77, 77));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Unos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(21, 27, 265, 331);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Odabir racunara:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(140, 24, 115, 14);
		panel.add(lblNewLabel);
		
		JComboBox cbRedniBr = new JComboBox();
		cbRedniBr.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		cbRedniBr.setBounds(131, 43, 110, 22);
		panel.add(cbRedniBr);
		
		JLabel lblNewLabel_1 = new JLabel("Vreme:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(163, 74, 63, 14);
		panel.add(lblNewLabel_1);
		
		tfVreme = new JTextField();
		tfVreme.setBounds(139, 91, 86, 20);
		panel.add(tfVreme);
		tfVreme.setColumns(10);
		
		JCheckBox chckUltra = new JCheckBox("Ultra");
		chckUltra.setForeground(new Color(255, 255, 255));
		chckUltra.setBackground(new Color(77, 77, 77));
		chckUltra.setBounds(126, 181, 97, 23);
		panel.add(chckUltra);
		
		JCheckBox chckRedBul = new JCheckBox("Red Bull");
		chckRedBul.setForeground(new Color(255, 255, 255));
		chckRedBul.setBackground(new Color(77, 77, 77));
		chckRedBul.setBounds(126, 206, 97, 23);
		panel.add(chckRedBul);
		
		JCheckBox chckCola = new JCheckBox("Coca Cola");
		chckCola.setForeground(new Color(255, 255, 255));
		chckCola.setBackground(new Color(77, 77, 77));
		chckCola.setBounds(127, 234, 97, 23);
		panel.add(chckCola);
		
		tfUplata = new JTextField();
		tfUplata.setHorizontalAlignment(SwingConstants.CENTER);
		tfUplata.setText("Za uplatu:");
		tfUplata.setBounds(149, 290, 86, 20);
		panel.add(tfUplata);
		tfUplata.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 33, 405, 285);
		contentPane.add(scrollPane);
		
		tableIgraonica = new JTable();
		tableIgraonica.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Redni br:", "Vreme:", "Pice:",
			}
		));
		tableIgraonica.setForeground(new Color(102, 102, 102));
		tableIgraonica.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(tableIgraonica);
		
		JButton btnPazar = new JButton("Ukupan pazar");
		btnPazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfPazar.setText("");
				int sum=0;
				for(RacunarPice rp:ls)
					sum=sum+rp.uplata(rp.getVreme(), rp.getPice());
				tfPazar.setText(sum+"");
				
			}
		});
		btnPazar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnPazar.setBounds(451, 330, 133, 28);
		contentPane.add(btnPazar);
		
		tfPazar = new JTextField();
		tfPazar.setHorizontalAlignment(SwingConstants.CENTER);
		tfPazar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPazar.setBounds(606, 329, 114, 29);
		contentPane.add(tfPazar);
		tfPazar.setColumns(10);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int rb = Integer.parseInt(cbRedniBr.getSelectedItem().toString());
					int v=Integer.parseInt(tfVreme.getText().toString());
					String p = "Nista";
					if(chckUltra.isSelected())
						p="Ultra";
					if(chckRedBul.isSelected())
						p="RedBull";
					if(chckCola.isSelected())
						p="CocaCola";
						
					RacunarPice rp = new RacunarPice(rb,v,p);
					
					ls.add(rp);
					
					tfUplata.setText("");
					tfUplata.setText((rp.uplata(v, p))+"");
					
					cbRedniBr.setSelectedIndex(0);
					tfVreme.setText("");
					chckUltra.setSelected(false);
					chckRedBul.setSelected(false);
					chckCola.setSelected(false);
					
					JTableIgraonica model = new JTableIgraonica(ls);
					tableIgraonica.setModel(model);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Pogresan unos!");
					e1.printStackTrace();
				}
			}
		});
		btnUnesi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnUnesi.setBounds(27, 283, 89, 31);
		panel.add(btnUnesi);
		
		JLabel lblbg = new JLabel("");
		lblbg.setIcon(new ImageIcon("C:\\Users\\Uros\\Downloads\\Group 1 (1).png"));
		lblbg.setBounds(-9, -14, 792, 434);
		contentPane.add(lblbg);
	}
}
