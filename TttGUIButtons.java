import java.awt.*;
import javax.swing.*;

public class TttGUIButtons {
	private String button;
	private String buttonContents;
	private int[] buttonPosition;

	public TttGUIButtons(String buttonName, JButton button) {
		this.button = buttonName;
		this.buttonContents = button.getText();
	}

	public String getButton() {
		return button + ": " + buttonContents;
	}

}
