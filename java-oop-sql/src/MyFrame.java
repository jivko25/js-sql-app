import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class MyFrame extends JFrame{
	
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	MyModel model = null;
	int id = -1; //selected id
	
	JTabbedPane tab1JTabbedPane  = new JTabbedPane();
	
	JTable Customerstable = new JTable();
	JTable Employeestable = new JTable();
	JTable Orderstable = new JTable();
	JScrollPane scroller3 = new JScrollPane(Orderstable);
	JScrollPane scroller = new JScrollPane(Customerstable);
	JScrollPane scroller2 = new JScrollPane(Employeestable);

	JPanel CustomersPanel = new JPanel();
    JPanel EmployeePanel = new JPanel();
    JPanel OrdersPanel = new JPanel();
    
    //Orders
    JPanel upPanelOrders = new JPanel();
	JPanel midPanelOrders = new JPanel();
	JPanel downPanelOrders = new JPanel();
    
	JButton addButtonOrders = new JButton("Add");
	JButton delButtonOrders = new JButton("Delete");
	JButton editButtonOrders = new JButton("Edit");
	
	JLabel lnameLabelCustomerOrders = new JLabel("Customer:");
	JLabel lnameLabelEmployeeOrders = new JLabel("Employee:");
	JLabel startdatelabel = new JLabel("Start date:");
	JLabel enddatelabel = new JLabel("End date:");
	JTextField lnameTFieldCustomerOrders = new JTextField();
	JTextField lnameTFieldEmployeeOrders = new JTextField();
	SpinnerDateModel startdatemodel = new SpinnerDateModel();
	SpinnerDateModel enddatemodel = new SpinnerDateModel();
	JSpinner startdate = new JSpinner(startdatemodel);
	JSpinner enddate = new JSpinner(enddatemodel);
	JComboBox CustomersOrders = new JComboBox();
	JComboBox EmployeeOrders = new JComboBox();
    
    //Employees
	JPanel upPanelEmployees = new JPanel();
	JPanel midPanelEmployees = new JPanel();
	JPanel downPanelEmployees = new JPanel();
    
	JButton addButtonEmployees = new JButton("Add");
	JButton delButtonEmployees = new JButton("Delete");
	JButton editButtonEmployees = new JButton("Edit");
	
	JLabel fnameLabelEmployees = new JLabel("First Name:");
	JLabel lnameLabelEmployees = new JLabel("Last Name:");
	JLabel phoneLabelEmployees = new JLabel("Phone:");
	JLabel emailLabelEmployees = new JLabel("Email:");
	JTextField fnameTFieldEmployees = new JTextField();
	JTextField lnameTFieldEmployees = new JTextField();
	JTextField phoneTFieldEmployees = new JTextField();
	JTextField emailTFieldEmployees = new JTextField();
	
	
	//Customers
	JPanel upPanelCustomers = new JPanel();
	JPanel midPanelCustomers = new JPanel();
	JPanel downPanelCustomers = new JPanel();
	
	JButton addButtonCustomers = new JButton("Add");
	JButton delButtonCustomers = new JButton("Delete");
	JButton editButtonCustomers = new JButton("Edit");
	JButton searchButtonCustomers = new JButton("Search");
	
	JLabel fnameLabelCustomers = new JLabel("First Name:");
	JLabel lnameLabelCustomers = new JLabel("Last Name:");
	JLabel adressLabelCustomers = new JLabel("Adress:");
	JLabel emailLabelCustomers = new JLabel("Email:");
	JLabel departmentLabelCustomers = new JLabel("Department:");
	JTextField fnameTFieldCustomers = new JTextField();
	JTextField lnameTFieldCustomers = new JTextField();
	JTextField adressTFieldCustomers = new JTextField();
	JTextField emailTFieldCustomers = new JTextField();
	String[] departments = {"Java Development","Web Development","Game Development", "Server Hosting", "Finance department"};
	JComboBox<String> DepartmentCombo = new JComboBox<>(departments);
	
	public MyFrame() {
		//Orders
		
		OrdersPanel.setLayout(new GridLayout(3,1));
		OrdersPanel.add(upPanelOrders);
		OrdersPanel.add(midPanelOrders);
		OrdersPanel.add(downPanelOrders);
		
		//upPanel
				upPanelOrders.setLayout(new GridLayout(5,2));
				upPanelOrders.add(lnameLabelCustomerOrders);
				upPanelOrders.add(lnameTFieldCustomerOrders);
				upPanelOrders.add(lnameLabelEmployeeOrders);
				upPanelOrders.add(lnameTFieldEmployeeOrders);
				upPanelOrders.add(startdatelabel);
				upPanelOrders.add(startdate);
				upPanelOrders.add(enddatelabel);
				upPanelOrders.add(enddate);
				//midPanel
				midPanelOrders.add(addButtonOrders);
				midPanelOrders.add(delButtonOrders);
				midPanelOrders.add(editButtonOrders);
				addButtonEmployees.addActionListener(new AddActionOrders());
//				delButtonEmployees.addActionListener(new DeleteActionOrders());
//				editButtonEmployees.addActionListener(new EditActionOrders());
				//downPanel
				scroller3.setPreferredSize(new Dimension(500,200));
				downPanelOrders.add(scroller3);
				refreshTableEmployees("orders");
			    Orderstable.addMouseListener(new MouseAction3());
				OrdersPanel.add(upPanelOrders);
				OrdersPanel.add(midPanelOrders);
				OrdersPanel.add(downPanelOrders);
		
		//Employees
//		EmployeePanel.setVisible(true);
//		EmployeePanel.setSize(800, 800);
//		EmployeePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmployeePanel.setLayout(new GridLayout(3,1));
		EmployeePanel.add(upPanelEmployees);
		EmployeePanel.add(midPanelEmployees);
		EmployeePanel.add(downPanelEmployees);
		
		//upPanel
				upPanelEmployees.setLayout(new GridLayout(5,2));
				upPanelEmployees.add(fnameLabelEmployees);
				upPanelEmployees.add(fnameTFieldEmployees);
				upPanelEmployees.add(lnameLabelEmployees);
				upPanelEmployees.add(lnameTFieldEmployees);
				upPanelEmployees.add(emailLabelEmployees);
				upPanelEmployees.add(emailTFieldEmployees);
				upPanelEmployees.add(phoneLabelEmployees);
				upPanelEmployees.add(phoneTFieldEmployees);
				//midPanel
				midPanelEmployees.add(addButtonEmployees);
				midPanelEmployees.add(delButtonEmployees);
				midPanelEmployees.add(editButtonEmployees);
				addButtonEmployees.addActionListener(new AddActionEmployees());
				delButtonEmployees.addActionListener(new DeleteActionEmployees());
				editButtonEmployees.addActionListener(new EditActionEmployees());
				//downPanel
				scroller2.setPreferredSize(new Dimension(500,200));
				downPanelEmployees.add(scroller2);
				refreshTableEmployees("employees");
			    Employeestable.addMouseListener(new MouseAction2());
				EmployeePanel.add(upPanelEmployees);
				EmployeePanel.add(midPanelEmployees);
				EmployeePanel.add(downPanelEmployees);
		
		
		//Customers
		this.setVisible(true);
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CustomersPanel.setLayout(new GridLayout(3,1));
		this.add(upPanelCustomers);
		this.add(midPanelCustomers);
		this.add(downPanelCustomers);
		
		
		//upPanel
		upPanelCustomers.setLayout(new GridLayout(5,2));
		upPanelCustomers.add(fnameLabelCustomers);
		upPanelCustomers.add(fnameTFieldCustomers);
		upPanelCustomers.add(lnameLabelCustomers);
		upPanelCustomers.add(lnameTFieldCustomers);
		upPanelCustomers.add(adressLabelCustomers);
		upPanelCustomers.add(adressTFieldCustomers);
		upPanelCustomers.add(emailLabelCustomers);
		upPanelCustomers.add(emailTFieldCustomers);
		upPanelCustomers.add(departmentLabelCustomers);
		upPanelCustomers.add(DepartmentCombo);
		//midPanel
		midPanelCustomers.add(addButtonCustomers);
		midPanelCustomers.add(delButtonCustomers);
		midPanelCustomers.add(editButtonCustomers);
		midPanelCustomers.add(searchButtonCustomers);
		addButtonCustomers.addActionListener(new AddActionCustomers());
		delButtonCustomers.addActionListener(new DeleteActionCustomers());
		editButtonCustomers.addActionListener(new EditActionCustomers());
		searchButtonCustomers.addActionListener(new SearchCustomers());
		//downPanel
		scroller.setPreferredSize(new Dimension(500,200));
		downPanelCustomers.add(scroller);
		refreshTableCustomers("customers");
		Customerstable.addMouseListener(new MouseAction());
		CustomersPanel.add(upPanelCustomers);
		CustomersPanel.add(midPanelCustomers);
		CustomersPanel.add(downPanelCustomers);
		
		tab1JTabbedPane.add("Customers", CustomersPanel);
		tab1JTabbedPane.add("Employees", EmployeePanel);
		tab1JTabbedPane.add("Orders", OrdersPanel);
		
		add(tab1JTabbedPane);
		
	}//end constructor
	
	public void refreshTableOrders(String tableName) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
			Orderstable.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void refreshTableCustomers(String tableName) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
			Customerstable.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshTableEmployees(String tableName) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
			Employeestable.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class DeleteActionOrders implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			conn = DBConnector.getConnection();
			String sql = "delete from Orders where order_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTableCustomers("Orders");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class DeleteActionCustomers implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			conn = DBConnector.getConnection();
			String sql = "delete from Customers where customer_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTableCustomers("Customers");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class DeleteActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			conn = DBConnector.getConnection();
			String sql = "delete from Employees where employee_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTableEmployees("Employees");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class MouseAction3 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = Employeestable.getSelectedRow();
			id = Integer.parseInt(Employeestable.getValueAt(row, 0).toString());
			if(e.getClickCount() > 1) {
				lnameTFieldCustomerOrders.setText(Orderstable.getValueAt(row, 1).toString());
				lnameTFieldEmployeeOrders.setText(Orderstable.getValueAt(row, 2).toString());
				startdate.setToolTipText(Orderstable.getValueAt(row, 3).toString());
				enddate.setToolTipText(Orderstable.getValueAt(row, 4).toString());

			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class MouseAction2 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
				int row = Employeestable.getSelectedRow();
				id = Integer.parseInt(Employeestable.getValueAt(row, 0).toString());
				if(e.getClickCount() > 1) {
					fnameTFieldEmployees.setText(Employeestable.getValueAt(row, 1).toString());
					lnameTFieldEmployees.setText(Employeestable.getValueAt(row, 2).toString());
					phoneTFieldEmployees.setText(Employeestable.getValueAt(row, 3).toString());
					emailTFieldEmployees.setText(Employeestable.getValueAt(row, 4).toString());
					
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MouseAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = Customerstable.getSelectedRow();
			id = Integer.parseInt(Customerstable.getValueAt(row, 0).toString());
			if(e.getClickCount() > 1) {
				fnameTFieldCustomers.setText(Customerstable.getValueAt(row, 1).toString());
				lnameTFieldCustomers.setText(Customerstable.getValueAt(row, 2).toString());
				adressTFieldCustomers.setText(Customerstable.getValueAt(row, 3).toString());
				emailTFieldCustomers.setText(Customerstable.getValueAt(row, 4).toString());
				if(Customerstable.getValueAt(row, 5).equals("Java")) {
					DepartmentCombo.setSelectedIndex(0);
				}
				else if(Customerstable.getValueAt(row, 5).equals("Web"))
				{
					DepartmentCombo.setSelectedIndex(1);
				}
				else if(Customerstable.getValueAt(row, 5).equals("GAME"))
				{
					DepartmentCombo.setSelectedIndex(2);
				}
				else if(Customerstable.getValueAt(row, 5).equals("Server"))
				{
					DepartmentCombo.setSelectedIndex(3);
				}
				else if(Customerstable.getValueAt(row, 5).equals("Finance"))
				{
					DepartmentCombo.setSelectedIndex(4);
				}
			}
		}
		

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class AddActionOrders implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cname = lnameLabelCustomerOrders.getText();
			String ename = lnameTFieldEmployeeOrders.getText();
			String sdate = startdate.getToolTipText();
			String edate = enddate.getToolTipText();
			
			
			conn = DBConnector.getConnection();
			String query = "insert into orders values(null,?,?,?, ?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, cname);
				state.setString(2, ename);
				state.setString(3, sdate);
				state.setString(4, edate);
				state.execute();
				refreshTableEmployees("Orders");
				clearFormEmployees();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}
	
	class AddActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String fname = fnameTFieldEmployees.getText();
			String lname = lnameTFieldEmployees.getText();
			String email = emailTFieldEmployees.getText();
			String phone = phoneTFieldEmployees.getText();
			
			
			conn = DBConnector.getConnection();
			String query = "insert into employees values(null,?,?,?,?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, fname);
				state.setString(2, lname);
				state.setString(3, email);
				state.setString(4, phone);
				state.execute();
				refreshTableEmployees("Employees");
				clearFormEmployees();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}//end AddAction
	
	class AddActionCustomers implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String fname = fnameTFieldCustomers.getText();
			String lname = lnameTFieldCustomers.getText();
			String adress = adressTFieldCustomers.getText();
			String email = emailTFieldCustomers.getText();
			String departments = DepartmentCombo.getSelectedItem().toString();
			/*if(DepartmentCombo.getSelectedIndex() == 0) {
				departments = "Java";
			}
			else if(DepartmentCombo.getSelectedIndex() == 1)
			{
				departments = "Web";
			}
			else if(DepartmentCombo.getSelectedIndex() == 2)
			{
				departments = "Game";
			}
			else if(DepartmentCombo.getSelectedIndex() == 3)
			{
				departments = "Server";
			}
			else if(DepartmentCombo.getSelectedIndex() == 4)
			{
				departments = "Finance";
			}*/
			
			conn = DBConnector.getConnection();
			String query = "insert into customers values(null,?,?,?,?,?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, fname);
				state.setString(2, lname);
				state.setString(3, adress);
				state.setString(4, email);
				state.setString(5, departments);
				state.execute();
				refreshTableCustomers("Customers");
				clearFormCustomers();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}//end AddAction
	
	class EditActionCustomers implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String fname = fnameTFieldCustomers.getText();
			String lname = lnameTFieldCustomers.getText();
			String address = adressTFieldCustomers.getText();
			String email = emailTFieldCustomers.getText();
			String departments = DepartmentCombo.getSelectedItem().toString();
			
			
			conn = DBConnector.getConnection();
			String query = "update customers set fname=?,lname=?,address=?,email=?,departments=? where customer_id = ?;";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, fname);
				state.setString(2, lname);
				state.setString(3, address);
				state.setString(4, email);
				state.setString(5, departments);
				state.setInt(6, id);
				state.execute();
				refreshTableCustomers("Customers");
				clearFormCustomers();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}
	
	class EditActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String fname = fnameTFieldEmployees.getText();
			String lname = lnameTFieldEmployees.getText();
			String email = emailTFieldEmployees.getText();
			String phone = phoneTFieldEmployees.getText();
			
			
			conn = DBConnector.getConnection();
			String query = "update employees set fname=?,lname=?,email=?,phone=? where employee_id = ?;";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, fname);
				state.setString(2, lname);
				state.setString(3, email);
				state.setString(4, phone);
				state.setInt(5, id);
				state.execute();
				refreshTableEmployees("Employees");
				clearFormEmployees();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}
	
	public void clearFormCustomers() {
		fnameTFieldCustomers.setText("");
		lnameTFieldCustomers.setText("");
		adressTFieldCustomers.setText("");
		emailTFieldCustomers.setText("");
	}
	
	public void clearFormEmployees() {
		fnameTFieldEmployees.setText("");
		lnameTFieldEmployees.setText("");
		emailTFieldEmployees.setText("");
		phoneTFieldEmployees.setText("");
		
	}
	
	
	public class SearchCustomers implements ActionListener {
	public ResultSet search(String a) {
		conn = DBConnector.getConnection();
		ResultSet rs = null;
		PreparedStatement state = null;
		try {
		state = conn.prepareStatement("select * from customers where fname = ?");
		state.setString(1, a);
		rs = state.executeQuery();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		SearchCustomers SearchResult = new SearchCustomers();
		ResultSet rs = null;
		String fn = "fname";
		String ln = "lname";
		String email = "email";
		String address = "address";
		
		rs = SearchResult.search(fnameTFieldCustomers.getText());
		try {
			if(rs.next()) {
				lnameTFieldCustomers.setText(rs.getString("lname"));
				emailTFieldCustomers.setText(rs.getString("email"));
				adressTFieldCustomers.setText(rs.getString("address"));
			}
		}
			catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}	


