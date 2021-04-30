package hust.soict.globalict.aims;

import hust.soict.globalict.aims.order.*;

import java.awt.*; // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*; // Using Swing components and containers
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class GUI extends JFrame implements ActionListener {

	private MemoryDaemon deamon = new MemoryDaemon();
	private Collection<Order> orders = new ArrayList<Order>();
	private final String title = "Aims Project";
	private final String author = "Trần Công Hoàng 20194060";
	private int widthGraphicsPanl = 1000;
	private int heightGraphicsPanl = 0;
	private JPanel multiPanel, addPanel, removePanel, showPanel, totalPanel, orderPanel, menuPanel;
	private JRadioButton radDVD, radCD, radBook;

	private JButton btnCreateOrder, btnAddItem, btnRemoveItem, btnDisplayListItems, btnDisplayLuckyList;
	private JButton btnAdd, btnRemove;
	private JRadioButton [] btnOrder;
	private JTextField tfStatus, tfTitle, tfRemoveId, tfCategory, tfCost, tfLenght, tfArtist, tfDirectory;
	private JTextField [] tfShow;
	private JTextField tfNbOrders, tfNbItems, tfTotalCost, tfMemoryUsed;
	private Order anOrder = new Order();

	public GUI() {
		add(createMainPanel());
		setDisplay();
	}

	private void setDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
//		panel.add(createTitlePanel(), BorderLayout.PAGE_START);
		panel.add(createControlPanel(), BorderLayout.WEST);
		panel.add(createShowPanel(), BorderLayout.CENTER);
		panel.add(createAuthorPanel(), BorderLayout.PAGE_END);
		panel.setBorder(new LineBorder(Color.blue));

		multiPanel.setPreferredSize(new Dimension(widthGraphicsPanl, heightGraphicsPanl));
		return panel;
	}

	private JPanel createTitlePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel(title.toUpperCase()));
		return panel;
	}

	private JPanel createControlPanel() {

		menuPanel = new JPanel(new GridLayout(3, 1, 2, 2));
		menuPanel.setBorder(new TitledBorder("MENU"));
		menuPanel.add(btnCreateOrder = createButton("Create an Order"));
		menuPanel.add(new JLabel("Choose an order:"));

		orderPanel = new JPanel(new GridLayout(1, 5, 2, 2));
		btnOrder = new JRadioButton[5];
		int i = 1;
		for (JRadioButton jButton : btnOrder) {
			orderPanel.add(jButton = createRadioButton("Order" + i++, true));
			jButton.setVisible(false);
		}
		menuPanel.add(orderPanel);

		JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 2, 2));
		optionsPanel.setBorder(new TitledBorder("Choose an order to do"));
		optionsPanel.add(btnAddItem = createButton("Add an items to Order"));
		optionsPanel.add(btnRemoveItem = createButton("Remove an items to Order"));
		optionsPanel.add(btnDisplayListItems = createButton("Display all items in the Order"));
		optionsPanel.add(btnDisplayLuckyList = createButton("Get a lucky item"));
		JPanel runPanel = new JPanel(new GridLayout(6, 2, 2, 2));
		runPanel.setSize(menuPanel.getWidth(), optionsPanel.getHeight());
		runPanel.setBorder(new TitledBorder("Status"));
		runPanel.add(new JLabel("Status:"));
		runPanel.add(tfStatus = createTextField());
		tfStatus.setEditable(false);
		runPanel.add(new JLabel("The Order number: "));
		runPanel.add(tfNbOrders = createTextField());
		tfNbOrders.setText(Order.nbOrders + "");
		runPanel.add(new JLabel("The item number: "));
		runPanel.add(tfNbItems = createTextField());
		tfNbItems.setText(anOrder.getItemsOrdered().size() + "");
		tfNbOrders.setEditable(false);
		tfNbItems.setEditable(false);
		runPanel.add(new JLabel("The maximum numbers of Order:"));
		runPanel.add(new JLabel("5"));
		runPanel.add(new JLabel("The maximum items can be added:"));
		runPanel.add(new JLabel("10"));
		runPanel.add(new JLabel("Memory used:"));
		runPanel.add(tfMemoryUsed = createTextField());
		deamon.run();
		tfMemoryUsed.setText(deamon.getMemoryUsed() + "");
		tfMemoryUsed.setEditable(false);
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(menuPanel, BorderLayout.PAGE_START);
		contentPanel.add(optionsPanel, BorderLayout.CENTER);
		contentPanel.add(runPanel, BorderLayout.PAGE_END);

		JPanel panel = new JPanel();
		panel.add(contentPanel);
		heightGraphicsPanl = (int) contentPanel.getPreferredSize().getHeight();
		return panel;
	}

	private JPanel createShowPanel() {

		multiPanel = new JPanel();
		multiPanel.setBorder(new TitledBorder("Job Screen"));
		multiPanel.setLayout(new GridLayout(1, 4, 2, 2));
		
		addPanel = new JPanel(new BorderLayout());
		addPanel.setBorder(new TitledBorder("add an item"));
		JPanel choosePanel = new JPanel(new GridLayout(1, 3, 2, 2));
		choosePanel.setBorder(new TitledBorder("Choose type of your item"));
		choosePanel.add(radBook = createRadioButton("BOOK", true));
		choosePanel.add(radCD = createRadioButton("CD", true));
		choosePanel.add(radDVD = createRadioButton("DVD", true));
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(radBook);
		btnG.add(radCD);
		btnG.add(radDVD);
		addPanel.add(choosePanel, BorderLayout.PAGE_START);
		JPanel formPanel = new JPanel(new GridLayout(6, 2, 2, 2));
		formPanel.setBorder(new TitledBorder("add an item"));
		formPanel.add(new JLabel("Enter Title"));
		formPanel.add(tfTitle = createTextField());
		formPanel.add(new JLabel("Enter Artist"));
		formPanel.add(tfArtist = createTextField());
		formPanel.add(new JLabel("Enter Category"));
		formPanel.add(tfCategory = createTextField());
		formPanel.add(new JLabel("Enter Directory"));
		formPanel.add(tfDirectory = createTextField());
		formPanel.add(new JLabel("Enter Cost"));
		formPanel.add(tfCost = createTextField());
		formPanel.add(new JLabel("Enter Lenght"));
		formPanel.add(tfLenght = createTextField());
		addPanel.add(btnAdd = createButton("Hoàn tất"), BorderLayout.PAGE_END);
		addPanel.add(formPanel, BorderLayout.CENTER);
		addPanel.setVisible(true);
		
		removePanel = new JPanel(new BorderLayout());
		removePanel.setBorder(new TitledBorder("remove an item"));
		removePanel.add(new JLabel("Enter Id"), BorderLayout.PAGE_START);
		removePanel.add(tfRemoveId = createTextField(), BorderLayout.CENTER);
		removePanel.add(btnRemove = createButton("Hoàn tất"), BorderLayout.PAGE_END);
//		removePanel.setPreferredSize(new Dimension(50, heightGraphicsPanl));
		removePanel.setVisible(true);
		
		showPanel = new JPanel(new GridLayout(11, 1, 1, 1));
		showPanel.setBorder(new TitledBorder("show all items"));
		tfShow = new JTextField[10];
		for (JTextField jTextField : tfShow) {
			showPanel.add(jTextField = createTextField());
			jTextField.setText("NULL");
			jTextField.setEditable(false);
		}
		totalPanel = new JPanel(new GridLayout(1, 2, 2, 2));
		showPanel.add(totalPanel);
		totalPanel.add(new JLabel("Total cost: "));
		totalPanel.add(tfTotalCost = createTextField());
		tfTotalCost.setEditable(false);
		showPanel.setVisible(true);
		totalPanel.setVisible(true);
		
		multiPanel.add(addPanel);
		multiPanel.add(removePanel);
		multiPanel.add(showPanel);
		return multiPanel;
	}

	private JPanel createAuthorPanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel(author.toUpperCase()));
		return panel;
	}

	private JButton createButton(String text) {
		JButton btn = new JButton(text);
		btn.addActionListener(this);
		return btn;
	}

	private JRadioButton createRadioButton(String text, boolean select) {
		JRadioButton rad = new JRadioButton(text, select);
		rad.addActionListener(this);
		return rad;
	}
	
	private JTextField createTextField() {
		JTextField tf = new JTextField();
		tf.setEditable(true);
		return tf;
	}
	
	public void update() {
		tfNbItems.setText(anOrder.getItemsOrdered().size() + "");
		tfNbOrders.setEditable(false);
		showPanel.removeAll();
		tfShow = new JTextField[10];
		int i = 0;
		for (JTextField jTextField : tfShow) {
			if(i < anOrder.getItemsOrdered().size()) {
				showPanel.add(jTextField = createTextField());
				jTextField.setText(anOrder.getDetail(i));
				jTextField.setEditable(false);
				i++;
			} else {
				showPanel.add(jTextField = createTextField());
				jTextField.setText("NULL");
				jTextField.setEditable(false);
			}
		}
		showPanel.add(totalPanel);
		tfTotalCost.setText(anOrder.totalCost() + "");
		deamon.run();
		tfMemoryUsed.setText(deamon.getMemoryUsed() + "");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		return;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCreateOrder) {
			if(orders.size() <= 4) {
				tfStatus.setText("an order has been created");
				tfStatus.setEditable(false);
				Order order = new Order();
				orders.add(order);
				tfNbOrders.setText(orders.size() + "");
				orderPanel.removeAll();
				btnOrder = new JRadioButton[5];
				int i = 1;
				ButtonGroup btnG = new ButtonGroup();
				for (JRadioButton jButton : btnOrder) {
					if(i <= orders.size()) {
						orderPanel.add(jButton = createRadioButton("Order" + i, true));
						jButton.setVisible(true);
						btnG.add(jButton);
						btnG.add(jButton);
						i++;
					} else {
						orderPanel.add(jButton = createRadioButton("Order" + i, true));
						jButton.setVisible(false);
						i++;
					}
				}
				deamon.run();
				tfMemoryUsed.setText(deamon.getMemoryUsed() + "");
				pack();
				setLocationRelativeTo(null);
				setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Đã đủ orders không thể thêm nữa", "Số lượng orders đã tối đa", JOptionPane.ERROR_MESSAGE);
				return;
			}
			btnCreateOrder.requestFocus();
			return;
		}
		if (e.getSource() == btnAddItem) {
			tfStatus.setText("Enter Info of item");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder(new LineBorder(Color.red), "add an item"));
			removePanel.setBorder(new TitledBorder("remove an item"));
			showPanel.setBorder(new TitledBorder("show all items"));
			btnAddItem.requestFocus();
			return;
		}
		if (e.getSource() == btnRemoveItem) {
			tfStatus.setText("Enter Id of item");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder("add an item"));
			removePanel.setBorder(new TitledBorder(new LineBorder(Color.red), "remove an item"));
			showPanel.setBorder(new TitledBorder("show all items"));
			btnRemoveItem.requestFocus();
			return;
		}
		if (e.getSource() == btnDisplayListItems) {
			tfStatus.setText("List of all items");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder("add an item"));
			removePanel.setBorder(new TitledBorder("remove an item"));
			showPanel.setBorder(new TitledBorder(new LineBorder(Color.red), "show all items"));
			anOrder.setLucky(0);
			update();
			return;
		}
		if (e.getSource() == btnDisplayLuckyList) {
			tfStatus.setText("Lucky item");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder("add an item"));
			removePanel.setBorder(new TitledBorder("remove an item"));
			showPanel.setBorder(new TitledBorder(new LineBorder(Color.red), "show all items"));
			anOrder.getALuckyItem();
			update();
			btnRemoveItem.requestFocus();
			return;
		}
		if(e.getSource() == btnAdd) {
			if(anOrder.getItemsOrdered().size() == 10) {
				JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tfTitle.getText().isEmpty() || tfCategory.getText().isEmpty() || tfDirectory.getText().isEmpty() || 
				tfCost.getText().isEmpty() || tfLenght.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Float.parseFloat(tfCost.getText());
				Integer.parseInt(tfLenght.getText());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Dữ liệu phải là số", "Lỗi nhập Cost/Lenght", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(radBook.isSelected()) {
				Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
				anOrder.addMedia(tmpBook);

			} else if(radCD.isSelected()) {
				CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
						Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
				anOrder.addMedia(tmpCompactDisc);
			} else {
				DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
						Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
				anOrder.addMedia(tmpMedia);
			}
			update();
			btnAdd.requestFocus();
			return;
		}
		if(e.getSource() == btnRemove) {
			try {
				int key = Integer.parseInt(tfRemoveId.getText());
				if(key > 0 && key <= anOrder.getItemsOrdered().size()) {
					anOrder.removeMedia(key - 1);
					update();
				} else {
					JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Dữ liệu phải là số", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
				return;
			}
			btnRemove.requestFocus();
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI(); // Let the constructor do the job
				}
			});
	}

}


