import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


class DodajKlasa implements ActionListener {

    JFrame frame=new JFrame();

    JButton button_1=new JButton("Dodaj Klase");
    JButton button_2=new JButton("Powrot");

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPnl = new JPanel();
    JPanel btnPnl = new JPanel(new BorderLayout(8, 8));

    JTextField  Name = new JTextField("Nazwa Klasy", 20);


    public ClassContainer Group;

    DodajKlasa(ClassContainer Group)
    {
        this.Group = Group;

        prepareGUI();
        buttonProperties();
    }
 
    

    public void prepareGUI()
    {
        mainPanel.setSize(650,350);


        Name.setBounds(50,150, 200,50);  

        frame.add(Name);

        mainPanel.add(btnPnl, BorderLayout.EAST);

        frame.setLocationRelativeTo(null);
        frame.setSize(700,400);
        frame.setTitle("My Window");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(mainPanel);

        


    }
    public void buttonProperties()
    {
        button_1.setPreferredSize(new Dimension(150, 165));
        btnPnl.add(button_1, BorderLayout.NORTH);
        button_1.addActionListener(this);

        button_2.setPreferredSize(new Dimension(150, 200));
        btnPnl.add(button_2, BorderLayout.CENTER);
		button_2.addActionListener(new ButtonBListener());
        

    }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
		System.out.println("Dodaj Klase");

        String text1 = Name.getText();

        System.out.println(text1);
        Class ClassZXC = new Class(text1, 15);


		this.Group.addClass(ClassZXC.group, ClassZXC);

        frame.dispose();
        SwingWindow test1 = new SwingWindow(Group);

    }

    private class ButtonBListener implements ActionListener
	{
		@Override

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Powrot");

            frame.dispose();
            SwingWindow test = new SwingWindow(Group);

		}
	}

}