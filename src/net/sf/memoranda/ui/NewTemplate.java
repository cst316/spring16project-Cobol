package net.sf.memoranda.ui;
/*
 * @mmehan
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
//import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JCheckBox;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.util.Local;
/**
 *
 * @author micahmehan
 */
public class NewTemplate extends JDialog{
    
	JPanel mainPanel = new JPanel(new BorderLayout());
        JButton newTemplate = new JButton();
	Border border1;
	
	public NewTemplate(Frame frame, String title)
	{
		super(frame, title, true);
		ttInit();
		pack();
	}

	void ttInit()
	{
		this.setResizable(true);
		this.setSize(new Dimension(1200, 800));
        border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        
        //mainPanel.setBorder(border1);
        newTemplate.setText("can't do nothing");
        newTemplate.setMinimumSize(new Dimension(100, 26));
        newTemplate.setVisible(true);
        
        newTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
        
        this.add(mainPanel, null);
        mainPanel.setBorder(border1);
        mainPanel.add(newTemplate, null);
	}
	
}

