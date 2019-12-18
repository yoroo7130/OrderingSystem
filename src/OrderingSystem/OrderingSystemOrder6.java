package OrderingSystem;

import java.util.ArrayList;

public class OrderingSystemOrder6 {
	
	ArrayList<String> foodName2, foodCount2, foodPrice2;
	int menuCount, tableNum, n;
	static String[] foodList1, foodList2, foodList3;
	static int menuNo, tableCount;;
	String[] tableN = new String[20];
	String[] tableC = new String[20];
	String[] tableP = new String[20];
	
	public OrderingSystemOrder6(ArrayList foodName2, ArrayList foodCount2, ArrayList foodPrice2, int menuCount, int tableNum) {
		this.foodName2 = foodName2;
		this.foodCount2 = foodCount2;
		this.foodPrice2 = foodPrice2;
		this.menuCount = menuCount;
		this.tableNum = tableNum;
		
		for (int i = 0; i < 8; i++) {
	         if (tableNum == i) {
	            for (int r = 0; r < menuCount; r++) {
		               tableN[r]=(String) foodName2.get(r);
		               tableC[r]=(String) foodCount2.get(r);
		               tableP[r]=(String) foodPrice2.get(r);
	            }
	            tableCount=menuCount;
	         }
	      }
		
		OrderingSystemOrder6 order = new OrderingSystemOrder6();
		for (int i = 0; i < 8; i++) {
			if (tableNum == i) {
				n = i;
			}
		}
		
		order.foodList1=tableN;
		order.foodList2=tableC;
		order.foodList3=tableP;
		order.menuNo=n;
		
	}
	public OrderingSystemOrder6() {
		
	}
}
