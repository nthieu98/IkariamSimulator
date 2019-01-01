/**
 * Overview panel 
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import image.Images;
import ui.IkIconButton;

/**
 * @author nc
 *
 */
@SuppressWarnings("serial")
public class PanelOverview extends JComponent {

	public final static int TOWN = 0;
	public final static int MILITARY = 1;
	public final static int RESEARCH = 2;
	public final static int DIPLOMACY = 3;

	private final Dimension PANEL_SIZE = new Dimension(750, 130);

	private JLabel panelGround;
	JPanel pnSpeed, pnTurn;
	JLabel lblSpeed, lblPercent, lblTurn, lblSecond;
	JSlider sldSpeed, sldTurn;
	JTextField txtSpeed, txtTurn;
	JButton btnSpeed, btnTurn;
	public IkIconButton townBtn, militaryBtn, researchBtn, diplomacyBtn;

	public PanelOverview() {
		panelGround = new JLabel(Images.ovBackgroundImg);
		townBtn = new IkIconButton(Images.townOvImg, "Towns");
		militaryBtn = new IkIconButton(Images.militaryOvImg, "Military");
		researchBtn = new IkIconButton(Images.researchOvImg, "Research");
		diplomacyBtn = new IkIconButton(Images.diplomacyOvImg, "Diplomacy");
		initialize();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
        sldSpeed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtSpeed.setText(String.valueOf(sldSpeed.getValue()));
            }
        });
		
        txtSpeed.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtSpeed.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                	txtSpeed.setText("0");
                }
                if (IntVal < 0) {
                	txtSpeed.setText("0");
                } else if (IntVal >= 100) {
                	txtSpeed.setText("100");
                }
                sldSpeed.setValue(Integer.valueOf(txtSpeed.getText()));
            }
        });
        
        sldTurn.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
            	txtTurn.setText(String.valueOf(sldTurn.getValue()));
            }
        });
		
        txtTurn.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtTurn.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                	txtTurn.setText("0");
                }
                if (IntVal < 0) {
                	txtTurn.setText("0");
                } else if (IntVal >= 900) {
                	txtTurn.setText("900");
                }
                sldTurn.setValue(Integer.valueOf(txtTurn.getText()));
            }
        });
	}

	public void initialize() {
		panelGround.setSize(PANEL_SIZE);

		townBtn.setBounds(20, 17, 90, 110);
		townBtn.setId(TOWN);
		townBtn.setTextOpaque(false);

		militaryBtn.setBounds(110, 17, 90, 110);
		militaryBtn.setId(MILITARY);
		militaryBtn.setTextOpaque(false);

		researchBtn.setBounds(200, 17, 90, 110);
		researchBtn.setId(RESEARCH);
		researchBtn.setTextOpaque(false);

		diplomacyBtn.setBounds(290, 17, 90, 110);
		diplomacyBtn.setId(DIPLOMACY);
		diplomacyBtn.setTextOpaque(false);
		
		pnSpeed = new JPanel(null);
        this.add(pnSpeed);
        pnSpeed.setBounds(400, 0, 393, 70);
		pnSpeed.setBackground(new Color(251, 232, 193));
		lblSpeed = new JLabel("Arrival speed:");
        lblSpeed.setBounds(10, 15, 120, 20);
        pnSpeed.add(lblSpeed);
        sldSpeed = new JSlider(0, 100);
        sldSpeed.setBounds(130, 15, 150, 20);
        sldSpeed.setBackground(new Color(251, 232, 193));
        sldSpeed.setValue(100);
        sldSpeed.setMinimum(1);
        pnSpeed.add(sldSpeed);
        txtSpeed = new JTextField(40);
        txtSpeed.setBounds(290, 15, 30, 20);
        txtSpeed.setText("100");
        pnSpeed.add(txtSpeed);
        lblPercent = new JLabel("%");
        lblPercent.setBounds(325, 15, 10, 20);
        pnSpeed.add(lblPercent);

        
        pnTurn = new JPanel(null);
        pnTurn.setBounds(400, 60, 393, 70);
        pnTurn.setBackground(new Color(251, 232, 193));
        this.add(pnTurn);
        lblTurn = new JLabel("Turn's speed:");
        lblTurn.setBounds(10, 15, 120, 20);
        pnTurn.add(lblTurn);
        sldTurn = new JSlider(0, 900);
        sldTurn.setBounds(130, 15, 150, 20);
        sldTurn.setBackground(new Color(251, 232, 193));
        sldTurn.setValue(900);
        sldTurn.setMinimum(1);
        pnTurn.add(sldTurn);
        txtTurn = new JTextField(40);
        txtTurn.setBounds(290, 15, 30, 20);
        txtTurn.setText("900");
        pnTurn.add(txtTurn);
        lblSecond = new JLabel("s");
        lblSecond.setBounds(325, 15, 10, 20);
        pnTurn.add(lblSecond);
        btnSpeed = new JButton("Apply");
        btnSpeed.setBounds(270, 45, 80, 20);
        pnTurn.add(btnSpeed);
		this.setLayout(null);
		this.add(townBtn);
		this.add(militaryBtn);
		this.add(researchBtn);
		this.add(diplomacyBtn);
		this.add(panelGround);
		this.setSize(PANEL_SIZE);
		this.setOpaque(false);
		this.setPreferredSize(PANEL_SIZE);
	}
}