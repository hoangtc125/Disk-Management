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
	private JRadioButton rad1, rad2, rad3, rad4, rad5;
	private JTextField tfNbOrders, tfNbItems, tfTotalCost, tfMemoryUsed;
//	private Order anOrder = new Order();
	private ButtonGroup btnGOrder = new ButtonGroup();

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
		tfNbOrders.setText("0");
		runPanel.add(new JLabel("The item number: "));
		runPanel.add(tfNbItems = createTextField());
		tfNbItems.setText("0");
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
		addPanel.setBorder(new TitledBorder("Add an item"));
		JPanel choosePanel = new JPanel(new GridLayout(1, 3, 2, 2));
		choosePanel.setBorder(new TitledBorder("Choose type of your item"));
		choosePanel.add(radBook = createRadioButton("BOOK", true));
		choosePanel.add(radCD = createRadioButton("CD", true));
		choosePanel.add(radDVD = createRadioButton("DVD", true));
		radBook.setBackground(Color.green);
		radCD.setBackground(Color.green);
		radDVD.setBackground(Color.green);
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(radBook);
		btnG.add(radCD);
		btnG.add(radDVD);
		addPanel.add(choosePanel, BorderLayout.PAGE_START);
		JPanel formPanel = new JPanel(new GridLayout(6, 2, 2, 2));
		formPanel.setBorder(new TitledBorder("Add an item"));
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
		addPanel.add(btnAdd = createButton("Done"), BorderLayout.PAGE_END);
		addPanel.add(formPanel, BorderLayout.CENTER);
		addPanel.setVisible(true);
		
		removePanel = new JPanel(new BorderLayout());
		removePanel.setBorder(new TitledBorder("Remove an item"));
		removePanel.add(new JLabel("Enter Id"), BorderLayout.PAGE_START);
		removePanel.add(tfRemoveId = createTextField(), BorderLayout.CENTER);
		removePanel.add(btnRemove = createButton("Done"), BorderLayout.PAGE_END);
		removePanel.setVisible(true);
		
		showPanel = new JPanel(new GridLayout(11, 1, 1, 1));
		showPanel.setBorder(new TitledBorder("Show all items"));
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
	
	public void update(Order anOrder) {
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
				
				if(orders.size() == 1) {
					orderPanel.add(rad1 = createRadioButton("Order1", true));
					rad1.setVisible(true);
					rad1.setBackground(Color.green);
					btnGOrder.add(rad1);
				} else if(orders.size() == 2) {
					orderPanel.add(rad2 = createRadioButton("Order2", true));
					rad2.setVisible(true);
					rad2.setBackground(Color.green);
					btnGOrder.add(rad2);
				} else if(orders.size() == 3) {
					orderPanel.add(rad3 = createRadioButton("Order3", true));
					rad3.setVisible(true);
					rad3.setBackground(Color.green);
					btnGOrder.add(rad3);
				} else if(orders.size() == 4) {
					orderPanel.add(rad4 = createRadioButton("Order4", true));
					rad4.setVisible(true);
					rad4.setBackground(Color.green);
					btnGOrder.add(rad4);
				} else if(orders.size() == 5) {
					orderPanel.add(rad5 = createRadioButton("Order5", true));
					rad5.setVisible(true);
					rad5.setBackground(Color.green);
					btnGOrder.add(rad5);
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
			addPanel.setBorder(new TitledBorder(new LineBorder(Color.red), "Add an item"));
			removePanel.setBorder(new TitledBorder("Remove an item"));
			showPanel.setBorder(new TitledBorder("Show all items"));
			btnAddItem.requestFocus();
			return;
		}
		if (e.getSource() == btnRemoveItem) {
			tfStatus.setText("Enter Id of item");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder("Add an item"));
			removePanel.setBorder(new TitledBorder(new LineBorder(Color.red), "Remove an item"));
			showPanel.setBorder(new TitledBorder("Show all items"));
			btnRemoveItem.requestFocus();
			return;
		}
		if (e.getSource() == btnDisplayListItems) {
			if(Integer.parseInt(tfNbOrders.getText()) == 0) {
				JOptionPane.showMessageDialog(null, "Chưa có order nào được tạo", "Order chưa được tạo", JOptionPane.ERROR_MESSAGE);
				return;
			}
			tfStatus.setText("List of all items");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder("Add an item"));
			removePanel.setBorder(new TitledBorder("Remove an item"));
			showPanel.setBorder(new TitledBorder(new LineBorder(Color.red), "Show all items"));
			if(rad1.isSelected()) {
				((ArrayList<Order>) orders).get(0).setLucky(-1);
				update(((ArrayList<Order>) orders).get(0));
				return;
			}
			if(rad2.isSelected()) {
				((ArrayList<Order>) orders).get(1).setLucky(-1);
				update(((ArrayList<Order>) orders).get(1));
				return;
			}
			if(rad3.isSelected()) {
				((ArrayList<Order>) orders).get(2).setLucky(-1);
				update(((ArrayList<Order>) orders).get(2));
				return;
			}
			if(rad4.isSelected()) {
				((ArrayList<Order>) orders).get(3).setLucky(-1);
				update(((ArrayList<Order>) orders).get(3));
				return;
			}
			if(rad5.isSelected()) {
				((ArrayList<Order>) orders).get(4).setLucky(-1);
				update(((ArrayList<Order>) orders).get(4));
				return;
			}
			return;
		}
		if (e.getSource() == btnDisplayLuckyList) {
			if(Integer.parseInt(tfNbOrders.getText()) == 0) {
				JOptionPane.showMessageDialog(null, "Chưa có order nào được tạo", "Order chưa được tạo", JOptionPane.ERROR_MESSAGE);
				return;
			}
			tfStatus.setText("Lucky item");
			tfStatus.setEditable(false);
			addPanel.setBorder(new TitledBorder("Add an item"));
			removePanel.setBorder(new TitledBorder("Remove an item"));
			showPanel.setBorder(new TitledBorder(new LineBorder(Color.red), "Show all items"));
			if(rad1.isSelected()) {
				((ArrayList<Order>) orders).get(0).getALuckyItem();
				update(((ArrayList<Order>) orders).get(0));
				return;
			}
			if(rad2.isSelected()) {
				((ArrayList<Order>) orders).get(1).getALuckyItem();
				update(((ArrayList<Order>) orders).get(1));
				return;
			}
			if(rad3.isSelected()) {
				((ArrayList<Order>) orders).get(2).getALuckyItem();
				update(((ArrayList<Order>) orders).get(2));
				return;
			}
			if(rad4.isSelected()) {
				((ArrayList<Order>) orders).get(3).getALuckyItem();
				update(((ArrayList<Order>) orders).get(3));
				return;
			}
			if(rad5.isSelected()) {
				((ArrayList<Order>) orders).get(4).getALuckyItem();
				update(((ArrayList<Order>) orders).get(4));
				return;
			}
			btnRemoveItem.requestFocus();
			return;
		}
		if(e.getSource() == btnAdd) {
			if(Integer.parseInt(tfNbOrders.getText()) == 0) {
				JOptionPane.showMessageDialog(null, "Chưa có order nào được tạo", "Order chưa được tạo", JOptionPane.ERROR_MESSAGE);
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
			if(rad1.isSelected()) {
				if(((ArrayList<Order>) orders).get(0).getItemsOrdered().size() == 10) {
					JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(radBook.isSelected()) {
					Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(0).addMedia(tmpBook);

				} else if(radCD.isSelected()) {
					CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
					((ArrayList<Order>) orders).get(0).addMedia(tmpCompactDisc);
				} else {
					DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(0).addMedia(tmpMedia);
				}
				update(((ArrayList<Order>) orders).get(0));
				return;
			}
			if(rad2.isSelected()) {
				if(((ArrayList<Order>) orders).get(1).getItemsOrdered().size() == 10) {
					JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(radBook.isSelected()) {
					Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(1).addMedia(tmpBook);

				} else if(radCD.isSelected()) {
					CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
					((ArrayList<Order>) orders).get(1).addMedia(tmpCompactDisc);
				} else {
					DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(1).addMedia(tmpMedia);
				}
				update(((ArrayList<Order>) orders).get(1));
				return;
			}
			if(rad3.isSelected()) {
				if(((ArrayList<Order>) orders).get(2).getItemsOrdered().size() == 10) {
					JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(radBook.isSelected()) {
					Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(2).addMedia(tmpBook);

				} else if(radCD.isSelected()) {
					CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
					((ArrayList<Order>) orders).get(2).addMedia(tmpCompactDisc);
				} else {
					DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(2).addMedia(tmpMedia);
				}
				update(((ArrayList<Order>) orders).get(2));
				return;
			}
			if(rad4.isSelected()) {
				if(((ArrayList<Order>) orders).get(3).getItemsOrdered().size() == 10) {
					JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(radBook.isSelected()) {
					Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(3).addMedia(tmpBook);

				} else if(radCD.isSelected()) {
					CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
					((ArrayList<Order>) orders).get(3).addMedia(tmpCompactDisc);
				} else {
					DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(3).addMedia(tmpMedia);
				}
				update(((ArrayList<Order>) orders).get(3));
				return;
			}
			if(rad5.isSelected()) {
				if(((ArrayList<Order>) orders).get(4).getItemsOrdered().size() == 10) {
					JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(radBook.isSelected()) {
					Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(4).addMedia(tmpBook);

				} else if(radCD.isSelected()) {
					CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
					((ArrayList<Order>) orders).get(4).addMedia(tmpCompactDisc);
				} else {
					DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
							Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
					((ArrayList<Order>) orders).get(4).addMedia(tmpMedia);
				}
				update(((ArrayList<Order>) orders).get(4));
				return;
			}
			
			btnAdd.requestFocus();
			return;
		}
		if(e.getSource() == btnRemove) {
			if(Integer.parseInt(tfNbOrders.getText()) == 0) {
				JOptionPane.showMessageDialog(null, "Chưa có order nào được tạo", "Order chưa được tạo", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				int key = Integer.parseInt(tfRemoveId.getText());
				if(rad1.isSelected()) {
					if(key > 0 && key <= ((ArrayList<Order>) orders).get(0).getItemsOrdered().size()) {

						((ArrayList<Order>) orders).get(0).removeMedia(key - 1);
						update(((ArrayList<Order>) orders).get(0));
					} else {
						JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if(rad2.isSelected()) {
					if(key > 0 && key <= ((ArrayList<Order>) orders).get(1).getItemsOrdered().size()) {

						((ArrayList<Order>) orders).get(1).removeMedia(key - 1);
						update(((ArrayList<Order>) orders).get(1));
					} else {
						JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if(rad3.isSelected()) {
					if(key > 0 && key <= ((ArrayList<Order>) orders).get(2).getItemsOrdered().size()) {

						((ArrayList<Order>) orders).get(2).removeMedia(key - 1);
						update(((ArrayList<Order>) orders).get(2));
					} else {
						JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if(rad4.isSelected()) {
					if(key > 0 && key <= ((ArrayList<Order>) orders).get(3).getItemsOrdered().size()) {

						((ArrayList<Order>) orders).get(3).removeMedia(key - 1);
						update(((ArrayList<Order>) orders).get(3));
					} else {
						JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if(rad5.isSelected()) {
					if(key > 0 && key <= ((ArrayList<Order>) orders).get(4).getItemsOrdered().size()) {

						((ArrayList<Order>) orders).get(4).removeMedia(key - 1);
						update(((ArrayList<Order>) orders).get(4));
					} else {
						JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
						return;
					}
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


