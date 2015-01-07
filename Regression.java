import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

 /*****************************************************************
 *
 *
 *
 * ***************************************************************/

public class Regression extends JFrame implements ActionListener {

	// Frame variable 
 	private static int screen_width = 600;
 	private static int screen_height = 600;
 
 	// Buttons
 	private JButton menu = new JButton("Go");
 	private JButton menu_back = new JButton("menu"); 
 	private JButton calcular = new JButton("calcular"); 

 	// textFields
 	private JTextField menu_text = new JTextField();
 	private int num_text = 12; 								// Number that assins the elements of the x_text Erray
 	private JTextField[] x_text;
 	private JTextField[] y_text;

 	// Labels
 	private JLabel menu_label = new JLabel("Ingrese un integer 0 < n < 12");
 	private JLabel x_tag = new JLabel("x");
 	private JLabel y_tag = new JLabel("y");
 	private JLabel mb_tag = new JLabel();
 	private JLabel line_equation = new JLabel();
 

	// Lineal regression variables 
	private	String m = " "; 		// slope
	private String b = "";	

	JPanel panel;
	// Constructor
	
	public Regression() {
		// panel	
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(screen_width, screen_height));
		getContentPane().add(panel);
		panel.setLayout(null);
		 
		// setting up erray to add a certain mumber of text fiedls 
		menu_text.setText("12");
		num_text = Integer.valueOf(menu_text.getText()).intValue();
		x_text = new JTextField[num_text];
		y_text = new JTextField[num_text];

		//x_text = new JTextField[num_text];
		initUI();
		// add

		// buttons
		panel.add(menu);
		panel.add(menu_back);
		panel.add(calcular);

		// TextFields
		panel.add(menu_text);

		for(int i = 0; i < x_text.length; i++) {
			panel.add(x_text[i]);
			panel.add(y_text[i]);
		}

		// labels
		panel.add(menu_label);
		panel.add(x_tag);
		panel.add(y_tag);
		panel.add(mb_tag);
		panel.add(line_equation);

		// marco
		setTitle("Regrecion Lineal y Multiple");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		// Implement Action Listener
		menu.addActionListener(this);
		menu_back.addActionListener(this);
		calcular.addActionListener(this);
	}
	
	/*
	 *  Button options
	 */
	public void initUI() {

		int m_lw = 170, m_tw = 200, m_bw = 60;
		int h = 30;

		int m_x = screen_width/2;
		int m_y = screen_width/2;

 		// Menu object.
 		// setBounds(x, y, width, height);
		menu_label.setBounds((m_x - (m_lw/2)), m_y - 40, m_lw, h);
		menu_text.setBounds((m_x - (m_tw/2)), m_y, m_tw, h);
		menu.setBounds((m_x - (m_bw/2)), m_y+40, m_bw, h);
		
		// Buttons
		calcular.setBounds(50,540,90,30);
		calcular.setVisible(false);

		menu_back.setBounds(500,10, 90,h);
		menu_back.setVisible(false);

		// init_textFiedls otherwise they are null <-- how anoying java
		for( int i = 0; i < x_text.length ;i++){
			x_text[i] = new  JTextField();
			x_text[i].setVisible(false);
			
			y_text[i] = new JTextField();
			y_text[i].setVisible(false);
		}

		// Init data from second scrreen
		// TextFields
		int yt_position = 50;	
		int xt_position =  50;
		for(int i = 0; i < x_text.length; i++) {
			x_text[i].setBounds(xt_position,yt_position,40,30);
			x_text[i].setText(0 + "");
			
			yt_position += 40;
		}

		xt_position = 100;
		yt_position = 50;

		for(int i = 0; i < x_text.length; i++) {
			y_text[i].setBounds(xt_position,yt_position,40,30);
			y_text[i].setText(0 + "");
			yt_position += 40;
		}

		// Labels
		x_tag.setBounds(70,25,10,15);
		x_tag.setVisible(false);
		y_tag.setBounds(110,25,10,15);
		y_tag.setVisible(false);

		mb_tag.setBounds(300,50 ,300, 20);
		mb_tag.setVisible(false);
		line_equation.setBounds(300,70,300, 20);
		line_equation.setVisible(false);
	}
	
	public void getValues(double[] x_values, double[] y_values) {
		
		double n = Double.valueOf(menu_text.getText()).doubleValue();
		double sum_x = 0;
		double sum_y = 0;

		double sum_x2 = 0;
		double sum_y2 = 0;

	
		double sum_xy = 0;


//		mb_tag.setText("xi: " + String.format("%.3f", sum_x)+ "yi " + String.format("%.e3f",sum_y) + "xi2 " + String.format("%.3f", sum_x2)  + "yi2" +String.format("%.3f", sum_y2));
		// cuadro
		for(int i = 0; i < x_values.length; i++) {
			sum_x += x_values[i];
			sum_y += y_values[i];

			sum_x2 += x_values[i] * x_values[i];
			sum_y2 += y_values[i] * y_values[i];

			sum_xy += x_values[i] * y_values[i];

		}

		double media_x = sum_x/n ;
		double media_y = sum_y/n ;
		double sxy = sum_xy/n - (media_x*media_y);
		double sx_2 = sum_x2/n - (media_x*media_x);
		double sy_2 = sum_y2/n - (media_y*media_y);
		double b = sxy/sx_2;

		double a = media_y - (b*media_x) ;
//		double R = sxy/Math.sqrt(sum_x) * (Math.sqrt(sum_xy));

//		System.out.println(R);

		
		System.out.println("a" +  a);
		System.out.println("b" + b);

		System.out.println("sum_X" + sum_x + " sum_y " + sum_y + " x2" +  sum_x2 + "y2 " + sum_y2); 

	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		// setting up button's actions
		//
		if("Go".equals(event.getActionCommand())) {

			// Making everuthing for the second screen vivisble
			menu.setVisible(false);
			menu_text.setVisible(false);
			menu_label.setVisible(false);

			for(int i = 0; i < Integer.valueOf(menu_text.getText()).intValue(); i++) {
				x_text[i].setVisible(true); 
				y_text[i].setVisible(true);
			}

			// Labels
			x_tag.setVisible(true);
			y_tag.setVisible(true);

			// Button
			calcular.setVisible(true);
			menu_back.setVisible(true);

			} else if("menu".equals(event.getActionCommand())) {
			
			menu_back.setVisible(false);
		
			// Making everything of the second screen not visible
			// and showing optons for menu
			
			menu.setVisible(true);
			menu_text.setVisible(true);
			menu_label.setVisible(true); 

			for(int i = 0; i < Integer.valueOf(menu_text.getText()).intValue(); i++) {
				x_text[i].setVisible(false); 
				y_text[i].setVisible(false); 
			}

			// Labels
			x_tag.setVisible(false);
			y_tag.setVisible(false);

			// Button
			calcular.setVisible(false);
			} else if("calcular".equals(event.getActionCommand())) {

 			double[] x_values = new double[x_text.length];
 			double[] y_values = new double[y_text.length];

			for(int i = 0; i < x_text.length; i++) {

				x_values[i] = Double.valueOf(x_text[i].getText()).doubleValue();
				y_values[i] = Double.valueOf(y_text[i].getText()).doubleValue();
			}

			getValues(x_values,y_values);

		//	m = getSlope(x_values, y_values);
	//		m = String.format("%.3f ",getSlope(x_values, y_values));
	//		b = String.format("%.3f", getB(x_values, y_values));

			/*
			mb_tag.setText("m = " + m + "   b = " + b);
			mb_tag.setVisible(true);
			line_equation.setText("y = "+ m+"x" + " + " + b);
			line_equation.setVisible(true);


			System.out.println(m);
			System.out.println(b);
			*/

			}
		}

	public static void main(String[] args){
		Regression programa = new Regression();
		programa.setVisible(true);
	}
}