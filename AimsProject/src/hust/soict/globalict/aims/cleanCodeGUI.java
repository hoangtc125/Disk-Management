package hust.soict.globalict.aims;

import hust.soict.globalict.aims.order.*;
import java.awt.*; // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*; // Using Swing components and containers
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class cleanCodeGUI extends JFrame implements ActionListener {

	private final JFileChooser fileDialog = new JFileChooser();
	private MemoryDaemon deamon = new MemoryDaemon();
	private Collection<Order> orders = new ArrayList<Order>();
	private final String title = "Aims Project";
	private final String author = "Trần Công Hoàng 20194060";
	private int widthGraphicsPanl = 1000;
	private int heightGraphicsPanl = 0;
	private JPanel multiPanel, addPanel, removePanel, showPanel, totalPanel, orderPanel, menuPanel, showDetailPanel, btnPanel, formPanel = new JPanel();
	private JPanel DVDPanel, CDPanel, BookPanel;
	private JRadioButton [] radTypeItem = new JRadioButton[3];
	private JButton btnCreateOrder, btnAddItem, btnRemoveItem, btnDisplayListItems, btnDisplayLuckyList;
	private JButton btnAdd, btnRemove, btnImage, btnSort, showFileDialogButton, btnRemoveAll, btnPlay;
	private JRadioButton [] radOrders = new JRadioButton[5];
	private JRadioButton [] radPlay = new JRadioButton[10];
	private JTextField tfStatus = createTextField(), tfTitle = createTextField(), tfRemoveId = createTextField(), tfCategory = createTextField(), tfCost = createTextField(), tfLenght = createTextField(), tfArtist = createTextField(), tfDirectory = createTextField(), tfAuthor = createTextField();
	private JTextField [] tfShow = new JTextField[10];
	private JTextField tfNbOrders, tfNbItems, tfTotalCost, tfMemoryUsed;
	private String city[] = { "Ha Noi", "Vinh Phuc", "Da Nang", "TP. Ho Chi Minh", "Nha Trang" };
	private JComboBox cb;
	private ButtonGroup btnGOrder = new ButtonGroup(), btnGPlay = new ButtonGroup();

	public cleanCodeGUI() {
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
		panel.add(createTitlePanel(), BorderLayout.PAGE_START);
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

	private JPanel makeDVDPanel() {
		DVDPanel = new JPanel(new GridLayout(5, 2, 2, 2));
		DVDPanel.setBorder(new TitledBorder("Add an item"));
		DVDPanel.add(new JLabel("Enter Title"));
		DVDPanel.add(tfTitle);
		DVDPanel.add(new JLabel("Enter Category"));
		DVDPanel.add(tfCategory);
		DVDPanel.add(new JLabel("Enter Directory"));
		DVDPanel.add(tfDirectory);
		DVDPanel.add(new JLabel("Enter Cost"));
		DVDPanel.add(tfCost);
		DVDPanel.add(new JLabel("Enter Lenght"));
		DVDPanel.add(tfLenght);
		return DVDPanel;
	}
	
	private JPanel makeCDPanel() {
		CDPanel = new JPanel(new GridLayout(6, 2, 2, 2));
		CDPanel.setBorder(new TitledBorder("Add an item"));
		CDPanel.add(new JLabel("Enter Artist"));
		CDPanel.add(tfArtist);
		CDPanel.add(new JLabel("Enter Title"));
		CDPanel.add(tfTitle);
		CDPanel.add(new JLabel("Enter Category"));
		CDPanel.add(tfCategory);
		CDPanel.add(new JLabel("Enter Directory"));
		CDPanel.add(tfDirectory);
		CDPanel.add(new JLabel("Enter Cost"));
		CDPanel.add(tfCost);
		CDPanel.add(new JLabel("Enter Lenght"));
		CDPanel.add(tfLenght);
		return CDPanel;
	}
	
	private JPanel makeBookPanel() {
		BookPanel = new JPanel(new GridLayout(6, 2, 2, 2));
		BookPanel.setBorder(new TitledBorder("Add an item"));
		BookPanel.add(new JLabel("Enter Author"));
		BookPanel.add(tfAuthor);
		BookPanel.add(new JLabel("Enter Title"));
		BookPanel.add(tfTitle);
		BookPanel.add(new JLabel("Enter Category"));
		BookPanel.add(tfCategory);
		BookPanel.add(new JLabel("Enter Directory"));
		BookPanel.add(tfDirectory);
		BookPanel.add(new JLabel("Enter Cost"));
		BookPanel.add(tfCost);
		BookPanel.add(new JLabel("Enter Lenght"));
		BookPanel.add(tfLenght);
		return BookPanel;
	}
	
	private JPanel createControlPanel() {

		menuPanel = new JPanel(new GridLayout(3, 1, 2, 2));
		menuPanel.setBorder(new TitledBorder("MENU"));
		menuPanel.add(btnCreateOrder = createButton("Create an Order"));
		menuPanel.add(new JLabel("Choose an order:"));
		orderPanel = new JPanel(new GridLayout(1, 5, 2, 2));
		menuPanel.add(orderPanel);
		JPanel optionsPanel = new JPanel(new GridLayout(5, 1, 2, 2));
		optionsPanel.setBorder(new TitledBorder("Choose an order to do"));
		optionsPanel.add(btnAddItem = createButton("Add an items to Order"));
		optionsPanel.add(btnRemoveItem = createButton("Remove an items to Order"));
		optionsPanel.add(btnDisplayListItems = createButton("Display all items in the Order"));
		optionsPanel.add(btnDisplayLuckyList = createButton("Get a lucky item"));
		optionsPanel.add(showFileDialogButton = createButton("Open File"));
		JPanel runPanel = new JPanel(new GridLayout(7, 2, 2, 2));
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
		cb = new JComboBox(city);
        cb.setBounds(100, 50, 150, 20);
        runPanel.add(new JLabel("Your Address: "));
		runPanel.add(cb);
		deamon.run();
		tfMemoryUsed.setText(deamon.getMemoryUsed() + "");
		tfMemoryUsed.setEditable(false);
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(menuPanel, BorderLayout.PAGE_START);
		contentPanel.add(optionsPanel, BorderLayout.CENTER);
		contentPanel.add(runPanel, BorderLayout.PAGE_END);
		Order order = new Order();
		orders.add(order);
		tfNbOrders.setText(orders.size() + "");
		orderPanel.add(radOrders[orders.size() - 1] = createRadioButton("Order" + orders.size(), true));
		radOrders[orders.size() - 1].setVisible(true);
		radOrders[orders.size() - 1].setBackground(Color.green);
		btnGOrder.add(radOrders[orders.size() - 1]);
		JPanel panel = new JPanel();
		panel.add(contentPanel);
		heightGraphicsPanl = (int) contentPanel.getPreferredSize().getHeight();
		return panel;
	}

	private JPanel createShowPanel() {
		multiPanel = new JPanel();
		multiPanel.setBorder(new TitledBorder("Job Screen"));
		multiPanel.setLayout(new GridLayout(1, 2, 2, 2));
		JPanel addRemoveJPanel = new JPanel(new BorderLayout());
		addPanel = new JPanel(new BorderLayout());
		addPanel.setBorder(new TitledBorder("Add an item"));
		JPanel choosePanel = new JPanel(new GridLayout(1, 3, 2, 2));
		choosePanel.setBorder(new TitledBorder("Choose type of your item"));
		choosePanel.add(radTypeItem[0] = createRadioButton("BOOK", true));
		choosePanel.add(radTypeItem[1] = createRadioButton("CD", true));
		choosePanel.add(radTypeItem[2] = createRadioButton("DVD", true));
		radTypeItem[0].setBackground(Color.green);
		radTypeItem[1].setBackground(Color.green);
		radTypeItem[2].setBackground(Color.green);
		ButtonGroup btnG = new ButtonGroup();
		for (JRadioButton jRadioButton : radTypeItem) {
			btnG.add(jRadioButton);
		}
		addPanel.add(choosePanel, BorderLayout.PAGE_START);
		addPanel.add(btnAdd = createButton("Add"), BorderLayout.PAGE_END);
		formPanel = makeBookPanel();
		addPanel.add(formPanel, BorderLayout.CENTER);
		addPanel.setVisible(true);
		removePanel = new JPanel(new BorderLayout());
		removePanel.setBorder(new TitledBorder("Remove an item"));
		removePanel.add(new JLabel("Enter Id "), BorderLayout.WEST);
		removePanel.add(tfRemoveId = createTextField(), BorderLayout.CENTER);
		removePanel.add(btnRemove = createButton("Remove"), BorderLayout.EAST);
		removePanel.add(btnRemoveAll = createButton("Remove All"), BorderLayout.PAGE_END);
		removePanel.setVisible(true);
		addRemoveJPanel.add(addPanel, BorderLayout.CENTER);
		addRemoveJPanel.add(removePanel, BorderLayout.PAGE_END);
		showDetailPanel = new JPanel(new BorderLayout());
		btnPanel = new JPanel(new GridLayout(11, 1, 0, 0));
		btnPanel.setBorder(new TitledBorder("Choose"));
		for (JRadioButton jbutton : radPlay) {
			btnPanel.add(jbutton = createRadioButton("", true));
			btnGPlay.add(jbutton);
			jbutton.setVisible(true);
		}
		btnPanel.add(btnPlay = createButton("Play"));
		showPanel = new JPanel(new GridLayout(10, 1, 4, 4));
		showPanel.setBorder(new TitledBorder("Show all items"));
		tfShow = new JTextField[10];
		for (JTextField jTextField : tfShow) {
			showPanel.add(jTextField = createTextField());
			jTextField.setText("NULL");
			jTextField.setEditable(false);
		}
		totalPanel = new JPanel(new GridLayout(2, 2, 0, 0));
		totalPanel.add(new JLabel("Total cost: "));
		totalPanel.add(tfTotalCost = createTextField());
		tfTotalCost.setEditable(false);
		totalPanel.add(btnImage = createButton("Print Screen"));
		totalPanel.add(btnSort = createButton("Sort"));
		JPanel tempPanel = new JPanel(new BorderLayout());
		tempPanel.add(showPanel, BorderLayout.CENTER);
		tempPanel.add(totalPanel, BorderLayout.PAGE_END);
		showDetailPanel.add(tempPanel, BorderLayout.CENTER);
		showDetailPanel.add(btnPanel, BorderLayout.EAST);
		showPanel.setVisible(true);
		totalPanel.setVisible(true);
		multiPanel.add(addRemoveJPanel);
		multiPanel.add(showDetailPanel);
		return multiPanel;
	}

	private JPanel createAuthorPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JLabel(author.toUpperCase()), BorderLayout.PAGE_START);
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
	
	private void update(Order anOrder) {
		tfNbItems.setText(anOrder.getItemsOrdered().size() + "");
		showPanel.removeAll();
		int i = 0;
		for (JTextField jTextField : tfShow) {
			if(i < anOrder.getItemsOrdered().size()) {
				showPanel.add(jTextField = createTextField());
				jTextField.setText(anOrder.getDetail(i));
				jTextField.setBackground(Color.WHITE);
				if(anOrder.getLucky() == i) {
					jTextField.setBackground(Color.yellow);
				}
				jTextField.setEditable(false);
				i++;
			} else {
				showPanel.add(jTextField = createTextField());
				jTextField.setText("NULL");
				jTextField.setEditable(false);
			}
		}
		tfTotalCost.setText(anOrder.totalCost() + "");
		tfTotalCost.setBackground(Color.PINK);
		deamon.run();
		tfMemoryUsed.setText(deamon.getMemoryUsed() + "");
		pack();
		return;
	}
	
	private int chooseOrder() {
		int i = 0;
		for (JRadioButton jRadioButton : radOrders) {
			if(jRadioButton.isSelected()) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
	private int choosePlay() {
		int i = 0;
		for (JRadioButton jRadioButton : radPlay) {
			if(jRadioButton.isSelected()) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
	private int chooserType() {
		int i = 0;
		for (JRadioButton jRadioButton : radTypeItem) {
			if(jRadioButton.isSelected()) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == showFileDialogButton) {
			int returnVal = fileDialog.showOpenDialog(menuPanel);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                java.io.File file = fileDialog.getSelectedFile();
                tfStatus.setText("File Selected :" + file.getName());
                
            } else {
                tfStatus.setText("Open command cancelled by user.");
            }
		}
		if (e.getSource() == btnCreateOrder) {
			if(orders.size() <= 4) {
				tfStatus.setText("an order has been created");
				tfStatus.setEditable(false);
				Order order = new Order();
				orders.add(order);
				tfNbOrders.setText(orders.size() + "");
				orderPanel.add(radOrders[orders.size() - 1] = createRadioButton("Order" + orders.size(), true));
				radOrders[orders.size() - 1].setVisible(true);
				radOrders[orders.size() - 1].setBackground(Color.green);
				btnGOrder.add(radOrders[orders.size() - 1]);
				deamon.run();
				tfMemoryUsed.setText(deamon.getMemoryUsed() + "");
				pack();
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
			btnAddItem.requestFocus();
			return;
		}
		
		if (e.getSource() == btnRemoveItem) {
			tfStatus.setText("Enter Id of item");
			tfStatus.setEditable(false);
			btnRemoveItem.requestFocus();
			return;
		}
		
		if (e.getSource() == btnDisplayListItems) {
			tfStatus.setText("List of all items");
			tfStatus.setEditable(false);
			((ArrayList<Order>) orders).get(chooseOrder()).setLucky(-1);
			update(((ArrayList<Order>) orders).get(chooseOrder()));
			return;
		}
		
		if (e.getSource() == btnDisplayLuckyList) {
			tfStatus.setText("Lucky item");
			tfStatus.setEditable(false);
			((ArrayList<Order>) orders).get(chooseOrder()).getALuckyItem();
			update(((ArrayList<Order>) orders).get(chooseOrder()));
			btnRemoveItem.requestFocus();
			return;
		}
		
		if(radTypeItem[chooserType()].isSelected()) {
			addPanel.remove(formPanel);
			if(chooserType() == 0) {
				formPanel = makeBookPanel();
			} else if(chooserType() == 1) {
				formPanel = makeCDPanel();
			} else {
				formPanel = makeDVDPanel();
			}
			addPanel.add(formPanel, BorderLayout.CENTER);
			pack();
		}
		
		if(e.getSource() == btnAdd) {
			if(radTypeItem[2].isSelected() && (tfTitle.getText().isEmpty() || tfCategory.getText().isEmpty() || tfDirectory.getText().isEmpty() || 
				tfCost.getText().isEmpty() || tfLenght.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(radTypeItem[1].isSelected() && (tfArtist.getText().isEmpty() || tfTitle.getText().isEmpty() || tfCategory.getText().isEmpty() || tfDirectory.getText().isEmpty() || 
				tfCost.getText().isEmpty() || tfLenght.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(radTypeItem[0].isSelected() && (tfAuthor.getText().isEmpty() || tfTitle.getText().isEmpty() || tfCategory.getText().isEmpty() || tfDirectory.getText().isEmpty() || 
				tfCost.getText().isEmpty() || tfLenght.getText().isEmpty())) {
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
			if(((ArrayList<Order>) orders).get(chooseOrder()).getItemsOrdered().size() == 10) {
				JOptionPane.showMessageDialog(null, "Đã đủ items không thể thêm nữa", "Số lượng items đã tối đa", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(radTypeItem[0].isSelected()) {
				Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText().toString()));
				((ArrayList<Order>) orders).get(chooseOrder()).addMedia(tmpBook);

			} else if(radTypeItem[1].isSelected()) {
				CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
						Float.parseFloat(tfCost.getText().toString()), tfArtist.getText(), null);
				((ArrayList<Order>) orders).get(chooseOrder()).addMedia(tmpCompactDisc);
			} else {
				DigitalVideoDisc tmpMedia = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirectory.getText(), 
						Integer.parseInt(tfLenght.getText().toString()), Float.parseFloat(tfCost.getText().toString()));
				((ArrayList<Order>) orders).get(chooseOrder()).addMedia(tmpMedia);
			}
			update(((ArrayList<Order>) orders).get(chooseOrder()));
			btnAdd.requestFocus();
			return;
		}
		
		if(e.getSource() == btnRemove) {
			try {
				String [] tmp = tfRemoveId.getText().split(",");
				for(int i = tmp.length - 1; i >= 0; i--) {
					int key = Integer.parseInt(tmp[i].trim());
					if(radOrders[chooseOrder()].isSelected()) {
						if(key > 0 && key <= ((ArrayList<Order>) orders).get(chooseOrder()).getItemsOrdered().size()) {
							((ArrayList<Order>) orders).get(chooseOrder()).setLucky(-1);
							((ArrayList<Order>) orders).get(chooseOrder()).removeMedia(key - 1);
							update(((ArrayList<Order>) orders).get(chooseOrder()));
						} else {
							JOptionPane.showMessageDialog(null, "Id không tồn tại", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Dữ liệu phải là số", "Lỗi nhập Id", JOptionPane.ERROR_MESSAGE);
				return;
			}
			btnRemove.requestFocus();
			return;
		}
		
		if(e.getSource() == btnRemoveAll) {
			int key = JOptionPane.showConfirmDialog(null, "Remove All ?", "Are you sure ?", JOptionPane.INFORMATION_MESSAGE);
			if(key == 0) {
				((ArrayList<Order>) orders).get(chooseOrder()).setLucky(-1);
				while(((ArrayList<Order>) orders).get(chooseOrder()).getItemsOrdered().size() > 0) {
					((ArrayList<Order>) orders).get(chooseOrder()).removeMedia(((ArrayList<Order>) orders).get(chooseOrder()).getItemsOrdered().size() - 1);
				}
				update(((ArrayList<Order>) orders).get(chooseOrder()));
			}
			btnRemoveAll.requestFocus();
			return;
		}
		
		if(e.getSource() == radOrders[chooseOrder()]) {
			((ArrayList<Order>) orders).get(chooseOrder()).setLucky(-1);
			update(((ArrayList<Order>) orders).get(chooseOrder()));
			return;
		}
		
		if(e.getSource() == btnImage) {
			makeScreenshot(this);
			btnImage.requestFocus();
			return;
		}
		
		if(e.getSource() == btnSort) {
			((ArrayList<Order>) orders).get(chooseOrder()).sort();
			update(((ArrayList<Order>) orders).get(chooseOrder()));
			btnSort.requestFocus();
			return;
		}
		
		if(e.getSource() == btnPlay) {
			try {
				Media media = ((ArrayList<Order>) orders).get(chooseOrder()).getItemsOrdered(choosePlay());
				if(media instanceof Book) {
					JOptionPane.showMessageDialog(null, "Book can not play", "Type Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					if(media instanceof DigitalVideoDisc) {
						try {
							((DigitalVideoDisc) media).play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						try {
							((CompactDisc) media).play();
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Can not play, " + e2.getMessage(), "Type Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
	}
	
	public static final void makeScreenshot(JFrame argFrame) {
	    Rectangle rec = argFrame.getBounds();
	    BufferedImage bufferedImage = new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
	    argFrame.paint(bufferedImage.getGraphics());
	    try {
	        // Create temp file
	        File temp = File.createTempFile("PrtScr_AimsProject", ".png", new File("C:/Users/ADMIN/Desktop"));
	        // Use the ImageIO API to write the bufferedImage to a temporary file
	        ImageIO.write(bufferedImage, "png", temp);
	        // Delete temp file when program exits
	        temp.deleteOnExit();
	        JOptionPane.showMessageDialog(null, "Successfully", "Done", JOptionPane.INFORMATION_MESSAGE);
			return;
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cleanCodeGUI cleanCodeGUI = new cleanCodeGUI(); // Let the constructor do the job
				}
			});
	}

}