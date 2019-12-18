package OrderingSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class OrderingSystemIndex extends JFrame implements ActionListener{
	JButton[] btn = new JButton[8];
	
	String[] foodList1;
	String[] foodList2;
	String[] foodList3;
	int tableCount;
	int menuNo;
	
	public OrderingSystemIndex() {
		setLayout(null);
		
		int[] x= {20, 290, 560, 830, 20, 290, 560, 830};
		int[] y= {20, 20, 20, 20, 290, 290, 290, 290};
		for (int i = 0; i<btn.length; i++) {
			btn[i]=new JButton(i+1+"¹ø");
			btn[i].setBounds(x[i], y[i], 250, 250);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setTitle("PointOfSale");
		setBounds(screenSize.width/2 - 500,screenSize.height/2 - 300, 1120, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			int num = 0;
			for (int i= 0; i < btn.length; i++) {
				if(e.getSource() == btn[i]) {
					num = i;
				}
			}
			
			switch (num) {
			case 0:
				OrderingSystemOrder1 order1 = new OrderingSystemOrder1();
				foodList1=order1.foodList1;
				foodList2=order1.foodList2;
				foodList3=order1.foodList3;
				menuNo=order1.menuNo;
				tableCount=order1.tableCount;
				break;

			case 1:
				OrderingSystemOrder2 order2 = new OrderingSystemOrder2();
				foodList1=order2.foodList1;
				foodList2=order2.foodList2;
				foodList3=order2.foodList3;
				menuNo=order2.menuNo;
				tableCount=order2.tableCount;
				break;
				
			case 2:
				OrderingSystemOrder3 order3 = new OrderingSystemOrder3();
				foodList1=order3.foodList1;
				foodList2=order3.foodList2;
				foodList3=order3.foodList3;
				menuNo=order3.menuNo;
				tableCount=order3.tableCount;
				break;
				
			case 3:
				OrderingSystemOrder4 order4 = new OrderingSystemOrder4();
				foodList1=order4.foodList1;
				foodList2=order4.foodList2;
				foodList3=order4.foodList3;
				menuNo=order4.menuNo;
				tableCount=order4.tableCount;
				break;
				
			case 4:
				OrderingSystemOrder5 order5 = new OrderingSystemOrder5();
				foodList1=order5.foodList1;
				foodList2=order5.foodList2;
				foodList3=order5.foodList3;
				menuNo=order5.menuNo;
				tableCount=order5.tableCount;
				break;
				
			case 5:
				OrderingSystemOrder6 order6 = new OrderingSystemOrder6();
				foodList1=order6.foodList1;
				foodList2=order6.foodList2;
				foodList3=order6.foodList3;
				menuNo=order6.menuNo;
				tableCount=order6.tableCount;
				break;
				
			case 6:
				OrderingSystemOrder7 order7 = new OrderingSystemOrder7();
				foodList1=order7.foodList1;
				foodList2=order7.foodList2;
				foodList3=order7.foodList3;
				menuNo=order7.menuNo;
				tableCount=order7.tableCount;
				break;
				
			case 7:
				OrderingSystemOrder8 order8 = new OrderingSystemOrder8();
				foodList1=order8.foodList1;
				foodList2=order8.foodList2;
				foodList3=order8.foodList3;
				menuNo=order8.menuNo;
				tableCount=order8.tableCount;
				break;
			}

			
			new OrderingSystemMenu(this, num, foodList1, foodList2, foodList3, menuNo, tableCount);
			
		}
}