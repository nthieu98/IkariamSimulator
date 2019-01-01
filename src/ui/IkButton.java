/**
 * 
 */
package ui;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author hieu
 *
 */
@SuppressWarnings("serial")
public class IkButton extends JButton {

	private int id;

	public IkButton() {
		super();
		initialize();
	}

	public IkButton(String text) {
		super(text);
		initialize();
	}

	public IkButton(Icon icon) {
		super(icon);
		initialize();
	}

	public IkButton(String text, Icon icon) {
		super(text, icon);
		initialize();
	}

	private void initialize() {
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setForeground(IkConst.BASE_FOREGROUND);
		this.setBackground(IkConst.BASE_BACKGROUND);
		this.setFont(IkConst.IK_FONT);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
