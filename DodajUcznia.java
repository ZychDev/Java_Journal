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


class DodajUcznia implements ActionListener {

    JFrame frame=new JFrame();
    JButton button_1=new JButton("Dodaj ucznia");
    JButton button_2=new JButton("Powrot");
    //StudentCondition.Absent
    

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPnl = new JPanel();
    JPanel btnPnl = new JPanel(new BorderLayout(8, 8));

    JTextField  Name = new JTextField("Name", 20);
    JTextField  Surname = new JTextField("Surname", 20);
    JTextField  Condition = new JTextField("Condition", 20);
    JTextField  Date = new JTextField("Born Date", 20);
    JTextField  Points = new JTextField("Points", 20);


    public ClassContainer Group;
    public Class obiekt;

    DodajUcznia(Class obiekt, ClassContainer Group)
    {
        this.obiekt = obiekt;
        this.Group = Group;

        prepareGUI(obiekt);
        buttonProperties();
    }
 
    

    public void prepareGUI(Class obiekt)
    {
        mainPanel.setSize(650,350);


        Name.setBounds(50,15, 200,50);  
        Surname.setBounds(50,90, 200,50);  
        Condition.setBounds(50,165, 200,50);  
        Date.setBounds(50,250, 140,50);  
        Points.setBounds(50,315, 200,50);  

        frame.add(Name);
        frame.add(Surname);
        frame.add(Condition);
        frame.add(Date);
        frame.add(Points);

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
    StudentCondition PrepareStatus(String tmp)
	{
        boolean areEqual2 = tmp.equals("Present");
        boolean areEqual = tmp.equals("Absent");

		if(areEqual2)
		{
			return StudentCondition.Present;
		}
		else if(areEqual)
		{
			return StudentCondition.Absent;
		}
		else
		{
			return StudentCondition.Sick;
		}
		
	}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
		System.out.println("Dodaj ucznia");

        String text1 = Name.getText();
        String text2 = Surname.getText();
        String text3 = Condition.getText();
        String text4 = Date.getText();
        String text5 = Points.getText();

        int number1 = Integer.parseInt(text4);
        int number2 = Integer.parseInt(text5);

        StudentCondition status = PrepareStatus(text3);

        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
        System.out.println(number1);
        System.out.println(number2);

        Student studentZXC = new Student(text1, text2, status, number1, number2); 			
        this.obiekt.addStudent(studentZXC);

        frame.dispose();
        UIKlasa test2 = new UIKlasa(obiekt, Group);


    }

    private class ButtonBListener implements ActionListener
	{
		@Override

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Powrot");
            frame.dispose();
            UIKlasa test2 = new UIKlasa(obiekt, Group);

		}
	}

}