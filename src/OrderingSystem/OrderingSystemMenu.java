package OrderingSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.swing.table.*;

public class OrderingSystemMenu extends JFrame implements ActionListener{
	JButton cancel;
	JButton order;
	JButton delete;
	JButton btn[];
	JButton charge;
	JTable table;
	int tableNum, menuNo;
	int tableCount;
	DefaultTableModel model;
	OrderingSystemIndex index;
	String input1[] = {"후라이드 치킨","양념 치킨","간장 치킨","마늘 치킨",
			"파닭 치킨","뿌링클 치킨","갈비 치킨", "볼케이노 치킨",
			"자메이카 치킨","코코넛 치킨","콜라","사이다"};
	String input2[] = {"1","1","1","1","1","1","1","1","1","1","1","1"};
	String input3[] = {"13000","14000","15000","15000","16000","16000","16000","17000","17500","18000","2000","2000"};
	ArrayList<String> foodName2=new ArrayList<>();
	ArrayList<String> foodCount2=new ArrayList<>();
	ArrayList<String> foodPrice2=new ArrayList<>();
	
	public OrderingSystemMenu(OrderingSystemIndex index, int tableNum, String[] foodList1, String[] foodList2, String[] foodList3, int menuNo, int tableCount) {
		this.index=index;
		this.tableNum=tableNum;
		this.tableCount=tableCount;
		this.menuNo=menuNo;
		JLabel text2=new JLabel("자바 포스기 입니다.");
		JPanel pan2=new JPanel();
		JPanel pan3=new JPanel();
		JPanel pan4=new JPanel();
		JPanel pan=new JPanel(new GridLayout(4, 3));
		order=new JButton("주문");
		order.addActionListener(this);
		cancel=new JButton("취소");
		cancel.addActionListener(this);
		delete=new JButton("삭제");
		charge=new JButton("계산");
		pan2.setLayout(new BorderLayout(0,10));
		pan3.setLayout(new BorderLayout(0,5));
		JLabel text3=new JLabel("주문 목록");
      
		btn = new JButton[12];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(input1[i]);
			pan.add(btn[i]);
			btn[i].addActionListener(this);
		}
      
		String header[] = {"종류","수량","가격"};
		String contents[][] = { };
		model = new DefaultTableModel(contents, header);
		table=new JTable(model);
      
		for (int i = 0; i < tableCount; i++) {
			String[] inputAll2 = { foodList1[i], foodList2[i], foodList3[i] };
			model.addRow(inputAll2);
		}
		
		DefaultTableCellRenderer cel=new DefaultTableCellRenderer();
		cel.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumn("종류").setCellRenderer(cel);
		table.getColumn("수량").setPreferredWidth(10);
		table.getColumn("수량").setCellRenderer(cel);
		table.getColumn("가격").setPreferredWidth(20);
		table.getColumn("가격").setCellRenderer(cel);
      
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(330, 300));
		pan.setPreferredSize(new Dimension(620, 600));
		pan2.add(text3,"North");
		pan2.add(scrollpane,"East");
		pan4.add(order,"West");
		pan4.add(delete,"East");
		pan3.add(pan4,"North");
		pan3.add(charge,"Center");
		pan3.add(cancel,"South");
		pan2.add(pan3,"South");
		add(pan,"West");
		add(pan2,"East");
		add(text2,"South");
		
		charge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				
				switch (tableNum) {
				case 0:
					new OrderingSystemOrder1(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;

				case 1:
					new OrderingSystemOrder2(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
					
				case 2:
					new OrderingSystemOrder3(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
					
				case 3:
					new OrderingSystemOrder4(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
					
				case 4:
					new OrderingSystemOrder5(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
					
				case 5:
					new OrderingSystemOrder6(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
					
				case 6:
					new OrderingSystemOrder7(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
					
				case 7:
					new OrderingSystemOrder8(foodName2, foodCount2, foodPrice2, 0, tableNum);
					break;
				}
				index.btn[tableNum].setText((tableNum+1)+"번");
				dispose();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() == -1)
					return;
				else
					model.removeRow(table.getSelectedRow());
			}
		});
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setTitle("PointOfSale");
		setBounds(screenSize.width/2 - 485,screenSize.height/2 - 250, 970, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == order) {
				String[] foodName1 = new String[model.getRowCount()];
				String[] foodCount1 = new String[model.getRowCount()];
				String[] foodPrice1 = new String[model.getRowCount()];
				String[] foodAll1 = new String[model.getRowCount()];
				String foodAll2 = new String("<html>");
				
				ArrayList<String> foodName2 = new ArrayList<>();
				ArrayList<String> foodCount2 = new ArrayList<>();
				ArrayList<String> foodPrice2 = new ArrayList<>();
				
				for (int i=0; i < model.getRowCount(); i++) {
					foodName1[i] = (String)(model.getValueAt(i, 0));
					foodCount1[i] = (String)(model.getValueAt(i, 1));
					foodPrice1[i] = (String)(model.getValueAt(i, 2));
					foodAll1[i] = (foodName1[i] + " " + foodCount1[i] + "EA" +"<br>");
					
					foodName2.add(foodName1[i]);
					foodCount2.add(foodCount1[i]);
					foodPrice2.add(foodPrice1[i]);
				}
				
				for (int i=0; i < model.getRowCount(); i++) {
					foodAll2 += foodAll1[i];
				}
				foodAll2 += "</html>";
				index.btn[tableNum].setText((foodAll2));
				
				switch (tableNum) {
				case 0:
					new OrderingSystemOrder1(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;

				case 1:
					new OrderingSystemOrder2(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
					
				case 2:
					new OrderingSystemOrder3(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
					
				case 3:
					new OrderingSystemOrder4(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
					
				case 4:
					new OrderingSystemOrder5(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
					
				case 5:
					new OrderingSystemOrder6(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
					
				case 6:
					new OrderingSystemOrder7(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
					
				case 7:
					new OrderingSystemOrder8(foodName2, foodCount2, foodPrice2, model.getRowCount(), tableNum);
					break;
				}
				dispose();
			}
			
			int re = 0, n = 0;
			
			for (int i= 0; i < 12; i++) {
				if(e.getSource() == btn[i]) {
					n = i;
				}
			}
			
			for (int i = 0; i < model.getRowCount(); i++) {
				if(model.getValueAt(i, 0)==input1[n]) {
					int product = Integer.parseInt((String) model.getValueAt(i, 1))+1;
					int productPrice = Integer.parseInt((String) model.getValueAt(i, 2))+Integer.parseInt(input3[n]);
					model.setValueAt(product+"", i, 1);
					model.setValueAt(productPrice+"", i, 2);
					re++;
				}
			}
			
			if(re == 0) {
				String[] inputAll = { input1[n], input2[n], input3[n] };
				model.addRow(inputAll);
			}
							
			if (e.getSource() == cancel) {
				dispose();
			}
		}
}