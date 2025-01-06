import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.JFrame;

public class TttGUIDisplay {
	JFrame frame = new JFrame();

	JButton btn1 = new JButton(" ");
	JButton btn2 = new JButton(" ");
	JButton btn3 = new JButton(" ");
	JButton btn4 = new JButton(" ");
	JButton btn5 = new JButton(" ");
	JButton btn6 = new JButton(" ");
	JButton btn7 = new JButton(" ");
	JButton btn8 = new JButton(" ");
	JButton btn9 = new JButton(" ");
	JLabel message = new JLabel("It is Player 1's turn");
	JButton restartBtn = new JButton("Retry?");

	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

	public void displayGUI() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		btn2.setBorder(null);
		btn3.setBorder(null);
		btn4.setBorder(null);
		btn5.setBorder(null);
		btn6.setBorder(null);
		btn7.setBorder(null);
		btn8.setBorder(null);
		btn9.setBorder(null);

		btn1.setPreferredSize(new Dimension(100, 100));
		btn2.setPreferredSize(new Dimension(101, 100));
		btn3.setPreferredSize(new Dimension(100, 100));
		btn4.setPreferredSize(new Dimension(100, 100));
		btn5.setPreferredSize(new Dimension(101, 101));
		btn6.setPreferredSize(new Dimension(100, 100));
		btn7.setPreferredSize(new Dimension(100, 100));
		btn8.setPreferredSize(new Dimension(101, 100));
		btn9.setPreferredSize(new Dimension(100, 100));

		Border top = BorderFactory.createMatteBorder(0, 10, 0, 10, Color.BLACK);
		Border right = BorderFactory.createMatteBorder(10, 0, 10, 0, Color.BLACK);
		Border bot = BorderFactory.createMatteBorder(0, 10, 0, 10, Color.BLACK);
		Border left = BorderFactory.createMatteBorder(10, 0, 10, 0, Color.BLACK);
		Border middle = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK);
		Border empty = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK);

		btn2.setBorder(top);
		btn4.setBorder(left);
		btn8.setBorder(bot);
		btn6.setBorder(right);
		btn5.setBorder(middle);
		btn1.setBorder(empty);
		btn3.setBorder(empty);
		btn7.setBorder(empty);
		btn9.setBorder(empty);

		Font font = new Font("Arial", Font.BOLD, 60);

		btn1.setFont(font);
		btn2.setFont(font);
		btn3.setFont(font);
		btn4.setFont(font);
		btn5.setFont(font);
		btn6.setFont(font);
		btn7.setFont(font);
		btn8.setFont(font);
		btn9.setFont(font);

		panel0.add(message);

		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);

		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);

		panel3.add(btn7);
		panel3.add(btn8);
		panel3.add(btn9);

		frame.add(panel0);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		frame.setSize(350, 360);

		frame.setVisible(true);
	}
}
