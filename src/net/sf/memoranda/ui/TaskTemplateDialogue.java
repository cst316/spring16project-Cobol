package net.sf.memoranda.ui;

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
import net.sf.memoranda.*;
import net.sf.memoranda.util.CurrentStorage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
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

public class TaskTemplateDialogue extends JDialog
{
	JPanel mainPanel = new JPanel(new BorderLayout());
	JButton standardTemplate_B = new JButton();
	JButton cancelButton = new JButton();
	TaskTemplate CurrentTaskTemplate;
	
	Border border1;
	
	public TaskTemplateDialogue(Frame frame, String title)
	{
		super(frame, title, true);
		ttInit();
		pack();
	}

	void ttInit()
	{
		this.setResizable(true);
		this.setSize(new Dimension(700, 400));
        this.setLayout(new GridBagLayout());
        border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        
        //mainPanel.setBorder(border1);
        
        standardTemplate_B.setText("Standard Template");
        //standardTemplate_B.setMinimumSize(new Dimension(100, 26));
        standardTemplate_B.setVisible(true);
        standardTemplate_B.setBounds(10,10,40,40);
        standardTemplate_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//dispose();
            	standardTemplate_B_Action(e);
            }
        });
        
        cancelButton.setText("Cancel");
        cancelButton.setMinimumSize(new Dimension(50, 26));
        cancelButton.setVisible(true);
        cancelButton.setBounds(10,10,500,500);
        cancelButton.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		cancelButtonAction(e);
        	}
        });
        
        mainPanel.setBorder(border1);
        this.add(standardTemplate_B);
        this.add(cancelButton);
        mainPanel.setVisible(true);
        //this.add(mainPanel, null);
        //this.setVisible(true);
	}
	
	void standardTemplate_B_Action (ActionEvent e)
	{
		CurrentTaskTemplate = new TaskTemplateImpl(0);
		CurrentTaskTemplate.createTask();
		//BlackBox Testing
		BBTemplateTest();
		//WhiteBox Testing
		WBTemplateTest();
		CurrentStorage.get().storeTaskList(CurrentProject.getTaskList(), CurrentProject.get());
		dispose();
	}
	
	void cancelButtonAction(ActionEvent e)
	{
		dispose();
	}
	
	//BlackBox Testing
	void BBTemplateTest()
	{
		if(CurrentProject.getTaskList().getTask("This is Standard Template Task") != null)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
	}

	void WBTemplateTest()
	{
		CurrentTaskTemplate = new TaskTemplateImpl(0);
		CurrentTaskTemplate.createTask();
		
		CurrentTaskTemplate = new TaskTemplateImpl(1);
		CurrentTaskTemplate.createTask();
		
		CurrentTaskTemplate = new TaskTemplateImpl(-1);
		CurrentTaskTemplate.createTask();
	
	}
}

