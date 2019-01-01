/**
 * A button and title with separated background 
 */
package ui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * @author hieu
 *
 */
@SuppressWarnings("serial")
public class IkIconButton extends JComponent {

	protected IkButton button;
	protected JLabel text;

	public static MouseListener focusListener = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);
			((JButton) e.getSource()).setBorderPainted(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			((JButton) e.getSource()).setBorderPainted(false);
		}
	};

	public IkIconButton() {
		initialize();
	}

	public IkIconButton(Icon icon) {
		initialize();
		setIcon(icon);
	}

	public IkIconButton(String text) {
		initialize();
		setText(text);
	}

	public IkIconButton(Icon icon, String text) {
		initialize();
		setIcon(icon);
		setText(text);
	}

	private void initialize() {
		button = new IkButton();
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.addMouseListener(focusListener);
		button.setOpaque(false);

		text = new JLabel("", javax.swing.SwingConstants.CENTER);
		text.setForeground(IkConst.LIGHT_FOREGROUND);
		text.setBackground(IkConst.LIGHT_BACKGROUND);
		text.setFont(IkConst.IK_FONT);
		text.setAlignmentX(CENTER_ALIGNMENT);
		text.setOpaque(true);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(button);
		this.add(text);
	}

	public void setText(String text) {
		this.text.setText(text);
	}

	public String getText() {
		return text.getText();
	}

	public void setIcon(Icon icon) {
		this.button.setIcon(icon);
		this.button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
	}

	public Icon getIcon() {
		return button.getIcon();
	}

	public void setId(int id) {
		this.button.setId(id);
	}

	public int getId() {
		return this.button.getId();
	}

	public void setTextOpaque(boolean b) {
		text.setOpaque(b);
	}

	@Override
	public synchronized void addMouseListener(MouseListener l) {
		button.addMouseListener(l);
	}
}
