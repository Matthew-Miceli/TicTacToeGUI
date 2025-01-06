import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;

public class TttGUIDriver {
	public static int turnCount = 0;
	public static boolean gameOver = false;

	public static void main(String[] args) {
		new TttGUIDriver();
	}

	public TttGUIDriver() {
		TttGUIDisplay tttGUIDisplay = new TttGUIDisplay();
		tttGUIDisplay.displayGUI();
		listen(tttGUIDisplay);
	}

	public void listen(TttGUIDisplay tttGUIDisplay) {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton clickedButton = (JButton) e.getSource();
				JButton[][] list = {
						{ tttGUIDisplay.btn1, tttGUIDisplay.btn2, tttGUIDisplay.btn3 },
						{ tttGUIDisplay.btn4, tttGUIDisplay.btn5, tttGUIDisplay.btn6 },
						{ tttGUIDisplay.btn7, tttGUIDisplay.btn8, tttGUIDisplay.btn9 }
				};

				if (clickedButton.getText().equals(" ") && !gameOver) {
					if (turnCount % 2 == 0) {
						clickedButton.setText(" X ");
						tttGUIDisplay.message.setText("It is Player 2's turn.");
					} else {
						clickedButton.setText(" O ");
						tttGUIDisplay.message.setText("It is Player 1's turn.");
					}

					win(list, tttGUIDisplay);
				}
			}

		};

		ActionListener restart = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tttGUIDisplay.message.setText("It is player 1's turn.");

				tttGUIDisplay.btn1.setText(" ");
				tttGUIDisplay.btn2.setText(" ");
				tttGUIDisplay.btn3.setText(" ");
				tttGUIDisplay.btn4.setText(" ");
				tttGUIDisplay.btn5.setText(" ");
				tttGUIDisplay.btn6.setText(" ");
				tttGUIDisplay.btn7.setText(" ");
				tttGUIDisplay.btn8.setText(" ");
				tttGUIDisplay.btn9.setText(" ");

				tttGUIDisplay.panel0.remove(tttGUIDisplay.restartBtn);

				gameOver = false;
				turnCount = 0;
			}
		};

		tttGUIDisplay.btn1.addActionListener(actionListener);
		tttGUIDisplay.btn2.addActionListener(actionListener);
		tttGUIDisplay.btn3.addActionListener(actionListener);
		tttGUIDisplay.btn4.addActionListener(actionListener);
		tttGUIDisplay.btn5.addActionListener(actionListener);
		tttGUIDisplay.btn6.addActionListener(actionListener);
		tttGUIDisplay.btn7.addActionListener(actionListener);
		tttGUIDisplay.btn8.addActionListener(actionListener);
		tttGUIDisplay.btn9.addActionListener(actionListener);
		tttGUIDisplay.restartBtn.addActionListener(restart);
	}

	public void win(JButton[][] list, TttGUIDisplay tttGUIDisplay) {
		for (JButton[] row : list) {
			Map<String, Integer> rowMap = new HashMap<>();
			for (JButton val : row) {
				rowMap.put(val.getText(), rowMap.getOrDefault(val.getText(), 0) + 1);
			}
			if (rowMap.containsKey(" X ") && rowMap.get(" X ") == 3) {
				tttGUIDisplay.message.setText("Player 1 wins.");
				gameOver = true;
				return;
			}
			if (rowMap.containsKey(" O ") && rowMap.get(" O ") == 3) {
				tttGUIDisplay.message.setText("Player 2 wins.");
				gameOver = true;
				return;
			}
		}
		for (int col = 0; col < list[0].length; col++) {
			Map<String, Integer> colMap = new HashMap<>();
			for (int row = 0; row < list.length; row++) {
				colMap.put(list[row][col].getText(),
						colMap.getOrDefault(list[row][col].getText(), 0) + 1);
			}
			if (colMap.containsKey(" X ") && colMap.get(" X ") == 3) {
				tttGUIDisplay.message.setText("Player 1 wins.");
				gameOver = true;
				return;
			}
			if (colMap.containsKey(" O ") && colMap.get(" O ") == 3) {
				tttGUIDisplay.message.setText("Player 2 wins.");
				gameOver = true;
				return;
			}
		}
		if (list[0][0].getText().equals(" X ") && list[1][1].getText().equals(" X ")
				&& list[2][2].getText().equals(" X ")) {
			tttGUIDisplay.message.setText("Player 1 wins.");
			gameOver = true;
			return;
		}
		if (list[0][2].getText().equals(" X ") && list[1][1].getText().equals(" X ")
				&& list[2][0].getText().equals(" X ")) {
			tttGUIDisplay.message.setText("Player 1 wins.");
			gameOver = true;
			return;
		}
		if (list[0][0].getText().equals(" O ") && list[1][1].getText().equals(" O ")
				&& list[2][2].getText().equals(" O ")) {
			tttGUIDisplay.message.setText("Player 2 wins.");
			gameOver = true;
			return;

		}
		if (list[0][2].getText().equals(" O ") && list[1][1].getText().equals(" O ")
				&& list[2][0].getText().equals(" O ")) {
			tttGUIDisplay.message.setText("Player 2 wins.");
			gameOver = true;
			return;
		}

		boolean draw = true;
		for (JButton[] row : list) {
			for (JButton val : row) {
				if (val.getText().equals(" ")) {
					draw = false;
					break;
				}
			}
			if (!draw)
				break;
		}

		if (draw) {
			tttGUIDisplay.message.setText("This game is a draw.");
			gameOver = true;
		}

		turnCount++;

		if (gameOver) {
			tttGUIDisplay.panel0.add(tttGUIDisplay.restartBtn);
		}

	}
}
