import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;
public class AICTYT {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AICTYT window = new AICTYT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AICTYT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Add your text");
		lblName.setBounds(93, 67, 100, 14);
		frame.getContentPane().add(lblName);
		
		JButton btnSubmit = new JButton("Ok");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = action(textField.getText());
				//check if the input have any space or not. see below in line 79
				if (text == "null"){
					JOptionPane.showMessageDialog(null, "The input does not contain any spaces");
				}
				//copying the text to clipboard
				else{
    				StringSelection textSel = new StringSelection(text);
					Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboardObj.setContents(textSel, null);
					JOptionPane.showMessageDialog(null, "Output copied to your clipboard");
				}
			}
		});
		btnSubmit.setBounds(93, 121, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(204, 64, 167, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public String action(String inputRaw){
		String output = new String();
		//checking if the input has any spaces or not
		if (!(inputRaw.contains(" "))){
			output = "null";
			return output;
		}
		//adding 30 invisible characters
		else{
			//removes the spaces from each end
			String input = inputRaw.trim();
			output = input.replace(" ", " ‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌‌");
			return output;
		}
	}
}
