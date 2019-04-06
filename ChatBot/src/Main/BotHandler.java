package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BotHandler extends JFrame{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField txtEnter = new JTextField();
	private JTextArea txtChat = new JTextArea();
	private JPanel ProductCategory;
	 private JTextField pIDtxt;
	 private JTextField pBrandtxt;
	 private JTextField pModeltxt;
	 private JTextField pCameratxt;
	 private JTextField pRamtxt;
	 private JTextField pDisplaySizetxt;
	 private JTextField pPricetxt;
	 private JTextField pProcessortxt;
	 private JTextField pGraphicCardtxt;
	 private JTextField pMotherBoardtxt;
	 private JTextField pStorageSpacetxt;
	 private JTextField pWashingCapacitytxt;
	 private JTextField pEnergyClasstxt;
	 private JTextField pRotationSpeedxt;
	 private JTextField pLitretxt;
	 private JTextField pProgramNumbertxt;
	 private JTextField pDiaphragmtxt;
	 private JTextField pZoomtxt;
	 private JTextField pMegaPixeltxt;
	 
	 public ArrayList<CellPhone> cellPhoneList = new ArrayList<CellPhone>();
	 public ArrayList<NoteBook> noteBookList = new ArrayList<NoteBook>();
	 ArrayList<WashingMachine> washingMachineList = new ArrayList<WashingMachine>();
	 ArrayList<Fridge> fridgeList =new ArrayList<Fridge>();
	 ArrayList<DishWasher> dishWasherList = new ArrayList<DishWasher>();
	 ArrayList<Camera> cameraList = new ArrayList<Camera>();
	 public Twitter tweetci = new Twitter();
	 SenticNetSingleton instance = SenticNetSingleton.getInstance() ;
	 
	public BotHandler() throws IOException {
		

		try (BufferedReader in = new BufferedReader(new FileReader("senticnet4.txt"))) {
	            String line = "";
	            while ((line = in.readLine()) != null) {
	                String parts[] = line.split("\t");
	                instance.put(parts[0], parts[2]);
	            }
	        }
	
            
             SenticNetSingleton instance = SenticNetSingleton.getInstance() ;

		ArrayList<String> exceptionMessageList = new ArrayList<String>(
		Arrays.asList("Ozur dilerim anlayamadim", "Yeniden Yazar Misin", "???"));

		ArrayList<String> greetingMessageList = new ArrayList<String>(
		Arrays.asList("Merhaba Dostum", "Selaaaaam", "merhabaaaaa"));
		ArrayList<String> conditionMessageList = new ArrayList<String>(
				Arrays.asList("Iyiyim Sen Nasilsin?", "Yuvarlanip Gidiyoruz Sen Nabiyon?", "Sukur Canim Ya Senden Naber?"));
				
				ArrayList<String> exitMessageList = new ArrayList<String>(
				Arrays.asList("Gorusuruz Canim Yine Beklerim", "Ozletme Kendini", "Yine Gel..."));
				
		setCellPhoneProducts(cellPhoneList);
		setNoteBookProducts(noteBookList);
		setCameraProducts(cameraList);		
		setFridgeProducts(fridgeList);		
		setDishWasherProducts(dishWasherList);				
		setWashingMachineProducts(washingMachineList);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100, 11000, 650);
		this.setSize(1100, 850);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Botcu Baba");

		txtEnter.setLocation(5, 720);
		txtEnter.setSize(1090, 40);
		txtEnter.requestFocusInWindow();

		txtChat.setLocation(5, 5);
		txtChat.setSize(1090, 700);
		txtChat.setEditable(false);
						
		//Action
		txtEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uText = txtEnter.getText();
				txtChat.append("You: " + uText + "\n");
				txtEnter.setText("");

				if (uText.contains("selam") || uText.contains("Selam") || uText.contains("Merhaba") || uText.contains("merhaba")) {
					decideRandom(greetingMessageList);

				} else if (uText.contains("urun sececegim") || uText.contains("urun secmek istiyorum")) {
					// urun secimi
					txtChat.append("AI: " + "Lutfen Sectiginiz Urunun Numarasini Giriniz:" + "\n");
					txtChat.append("AI: " + "1: Cep Telefonu" + "\n");
					txtChat.append("AI: " + "2: Dizustu Bilgisayar" + "\n");
					txtChat.append("AI: " + "3: Kamera" + "\n");
					txtChat.append("AI: " + "4: Buzdolabi" + "\n");
					txtChat.append("AI: " + "5: Bulasik Makinasi" + "\n");
					txtChat.append("AI: " + "6: Camasir Makinasi" + "\n");

				} else if (uText.equals("1")) {
					txtChat.append("AI: " + "Cep Telefonu secildi..." + "\n");
					txtChat.append("AI: " + "Listedeki Telefonlar:" + "\n");
					Collections.sort(cellPhoneList);
					for (CellPhone cellP : cellPhoneList) {
						
						txtChat.append("AI: " + cellP.getpModel() + " Ozellikleri: " + cellP.toString() +  "\n");
					}
					txtChat.append("Bu ürünü oneriyorum:\n");
					txtChat.append(cellPhoneList.get(0).toString());


				} else if (uText.equals("2")) {
					txtChat.append("AI: " + "Dizustu Bilgisayar secildi..." + "\n");
					txtChat.append("AI: " + "Listedeki Dizustu Bilgisayarlar:" + "\n");
					Collections.sort(noteBookList);
					for(NoteBook noteB : noteBookList) {
						txtChat.append("AI: " + noteB.getpModel() + " Ozellikleri: " + noteB.toString() + "\n");
					}
					txtChat.append("Bu ürünü oneriyorum:\n");
					txtChat.append(noteBookList.get(0).toString());

				}
					
					else if (uText.equals("3")) {
						txtChat.append("AI: " + "Kamera secildi..." + "\n");
						txtChat.append("AI: " + "Listedeki Kameralar:" + "\n");
						Collections.sort(cameraList);
						for(Camera camera : cameraList) {
							txtChat.append("AI: " + camera.getpModel() + " Ozellikleri: " + camera.toString() + "\n");
						}
						txtChat.append("Bu ürünü oneriyorum:\n");
						txtChat.append(cameraList.get(0).toString());

					}
						else if (uText.equals("4")) {
							txtChat.append("AI: " + "Buzdolabi secildi..." + "\n");
							txtChat.append("AI: " + "Listedeki Buzdolaplari:" + "\n");
							Collections.sort(fridgeList);
							for(Fridge fridge : fridgeList) {
								txtChat.append("AI: " + fridge.getpModel() + " Ozellikleri: " + fridge.toString() + "\n");
							}
							txtChat.append("Bu ürünü oneriyorum:\n");
							txtChat.append(fridgeList.get(0).toString());

						}
							
							else if (uText.equals("5")) {
								txtChat.append("AI: " + "BulasikMakinasi secildi..." + "\n");
								txtChat.append("AI: " + "Listedeki Bulasik Makinalari:" + "\n");
								Collections.sort(dishWasherList);
								for(DishWasher dishW : dishWasherList) {
									txtChat.append("AI: " + dishW.getpModel() + " Ozellikleri: " + dishW.toString() + "\n");
								}
								
								txtChat.append("Bu ürünü oneriyorum:\n");
								txtChat.append(dishWasherList.get(0).toString());
							}
								
								else if (uText.equals("6")) {
									txtChat.append("AI: " + "Camasir Makinasi secildi..." + "\n");
									txtChat.append("AI: " + "Listedeki Camasir Makinalari:" + "\n");
									Collections.sort( washingMachineList);
									for(WashingMachine washingM : washingMachineList) {
										txtChat.append("AI: " + washingM.getpModel() + " Ozellikleri: " + washingM.toString() + "\n");
									}
									txtChat.append("Bu ürünü oneriyorum:\n");
									txtChat.append(washingMachineList.get(0).toString());


								} 
									else if(uText.equals("urun eklemek istiyorum")) {
																						
										txtChat.append("AI: " + "Lutfen Sectiginiz Urunun Adini Giriniz:" + "\n");
										txtChat.append("AI: " + "1: Cep Telefonu" + "\n");
										txtChat.append("AI: " + "2: Dizüstü Bilgisayar" + "\n");
										txtChat.append("AI: " + "3: Kamera" + "\n");
										txtChat.append("AI: " + "4: Buzdolabi" + "\n");
										txtChat.append("AI: " + "5: Bulasik Makinasi" + "\n");
										txtChat.append("AI: " + "6: Camasir Makinasi" + "\n");
																				
								     }
				
									else if(uText.equals("Cep Telefonu") || uText.equals("cep telefonu")) // Add CellPhone
									{
										 CellPhone cellPhone = new CellPhone();
										 
									 	setTitle("Add CellPhone");
									  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  setBounds(100, 100, 728, 424);
									  ProductCategory = new JPanel();
									  ProductCategory.setBorder(new EmptyBorder(5, 5, 5, 5));
									  setContentPane(ProductCategory);
									  ProductCategory.setLayout(null);
									  
									  pIDtxt = new JTextField();
									  pIDtxt.setBounds(5, 150, 41, 22);
									  ProductCategory.add(pIDtxt);
									  pIDtxt.setColumns(10);
									  
									  pBrandtxt = new JTextField();
									  pBrandtxt.setBounds(85, 150, 63, 22);
									  ProductCategory.add(pBrandtxt);
									  pBrandtxt.setColumns(10);
									  
									  pModeltxt = new JTextField();
									  pModeltxt.setBounds(193, 150, 63, 22);
									  ProductCategory.add(pModeltxt);
									  pModeltxt.setColumns(10);
									  
									  pCameratxt = new JTextField();
									  pCameratxt.setBounds(5, 231, 56, 22);
									  ProductCategory.add(pCameratxt);
									  pCameratxt.setColumns(10);
									  
									  pRamtxt = new JTextField();
									  pRamtxt.setText("");
									  pRamtxt.setBounds(85, 231, 63, 22);
									  ProductCategory.add(pRamtxt);
									  pRamtxt.setColumns(10);
									  
									  JLabel lblNewLabel = new JLabel("ID");
									  lblNewLabel.setBounds(5, 123, 56, 16);
									  ProductCategory.add(lblNewLabel);
									  
									  JLabel lblNewLabel_1 = new JLabel("Brand");
									  lblNewLabel_1.setBounds(85, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_1);
									  
									  JLabel lblNewLabel_2 = new JLabel("Model");
									  lblNewLabel_2.setBounds(193, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_2);
									  
									  JLabel lblNewLabel_3 = new JLabel("Camera");
									  lblNewLabel_3.setBounds(5, 204, 56, 16);
									  ProductCategory.add(lblNewLabel_3);
									  
									  JLabel lblNewLabel_4 = new JLabel("Ram Size");
									  lblNewLabel_4.setBounds(85, 204, 56, 16);
									  ProductCategory.add(lblNewLabel_4);
									  BotHandler product = new BotHandler();
									  JButton PhKayitButon = new JButton("Add Product");
									  PhKayitButon.addActionListener(new ActionListener() { 
									   public void actionPerformed(ActionEvent e) {
									    
										   String pBrand  = pBrandtxt.getText();
										    int pId = Integer.parseInt(pIDtxt.getText());
										    String pModel  = pModeltxt.getText();
										    try {
												tweetci.getTweet("#"+pBrand);
											} catch (IOException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
										    double pPrice = Double.parseDouble(pPricetxt.getText());
										    
										    double pPoint = 0;
											try {
												pPoint = sentic1.SenticSina(pBrand, map1.mapBuilder());
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										    int pCameraSize = Integer.parseInt(pCameratxt.getText());
										    String pRam = pRamtxt.getText();
										    double pDisplaySize = Double.parseDouble(pDisplaySizetxt.getText());

										    CellPhone cellPhone = new CellPhone(pId, pBrand, pModel, pPrice,pPoint, pCameraSize,pRam,pDisplaySize );										    
										 										    
										    product.cellPhoneList.add(cellPhone);
										    										    
									   }
									  });
									  cellPhoneList.add(cellPhone);
									  PhKayitButon.setBounds(25, 339, 142, 25);
									  ProductCategory.add(PhKayitButon);
									  
									  pDisplaySizetxt = new JTextField();
									  pDisplaySizetxt.setBounds(188, 232, 68, 20);
									  ProductCategory.add(pDisplaySizetxt);
									  pDisplaySizetxt.setColumns(10);
									  
									  pPricetxt = new JTextField();
									  pPricetxt.setBounds(280, 151, 86, 20);
									  ProductCategory.add(pPricetxt);
									  pPricetxt.setColumns(10);
									  
									  JLabel lblPrice = new JLabel("Price");
									  lblPrice.setBounds(280, 123, 61, 16);
									  ProductCategory.add(lblPrice);
									  
									  JLabel lblNewLabel_5 = new JLabel("Display Size");
									  lblNewLabel_5.setBounds(188, 204, 86, 16);
									  ProductCategory.add(lblNewLabel_5);
									  
									  JLabel lblNewLabel_6 = new JLabel("CellPhone");
									  lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
									  lblNewLabel_6.setBounds(5, 51, 108, 22);
									  ProductCategory.add(lblNewLabel_6);	
									  
									}
				
									else if(uText.equals("Dizüstü Bilgisayar") || uText.equals("dizüstü bilgisayar")) { // Add NoteBook
										
									  NoteBook noteBook = new NoteBook();
									  
									  setTitle("Add NoteBook");
									  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  setBounds(100, 100, 728, 424);
									  ProductCategory = new JPanel();
									  ProductCategory.setBorder(new EmptyBorder(5, 5, 5, 5));
									  setContentPane(ProductCategory);
									  ProductCategory.setLayout(null);
									  
									  pIDtxt = new JTextField();
									  pIDtxt.setBounds(5, 150, 41, 22);
									  ProductCategory.add(pIDtxt);
									  pIDtxt.setColumns(10);
									  
									  pBrandtxt = new JTextField();
									  pBrandtxt.setBounds(85, 150, 63, 22);
									  ProductCategory.add(pBrandtxt);
									  pBrandtxt.setColumns(10);
									  
									  pModeltxt = new JTextField();
									  pModeltxt.setBounds(193, 150, 63, 22);
									  ProductCategory.add(pModeltxt);
									  pModeltxt.setColumns(10);
									  
									  pProcessortxt = new JTextField();
									  pProcessortxt.setBounds(5, 231, 56, 22);
									  ProductCategory.add(pProcessortxt);
									  pProcessortxt.setColumns(10);
									  
									  pRamtxt = new JTextField();
									  pRamtxt.setText("");
									  pRamtxt.setBounds(85, 231, 63, 22);
									  ProductCategory.add(pRamtxt);
									  pRamtxt.setColumns(10);
									  
									  pDisplaySizetxt = new JTextField();
									  pDisplaySizetxt.setBounds(188, 232, 68, 20);
									  ProductCategory.add(pDisplaySizetxt);
									  pDisplaySizetxt.setColumns(10);
									  
									  pPricetxt = new JTextField();
									  pPricetxt.setBounds(280, 151, 86, 20);
									  ProductCategory.add(pPricetxt);
									  pPricetxt.setColumns(10);																	 
									  									
									  pGraphicCardtxt = new JTextField();
									  pGraphicCardtxt.setBounds(286, 229, 80, 26);
									  ProductCategory.add(pGraphicCardtxt);
									  pGraphicCardtxt.setColumns(10);
									  
									  pMotherBoardtxt = new JTextField();
									  pMotherBoardtxt.setBounds(5, 314, 86, 26);
									  ProductCategory.add(pMotherBoardtxt);
									  pMotherBoardtxt.setColumns(10);
									  
									  pStorageSpacetxt = new JTextField();
									  pStorageSpacetxt.setBounds(133, 314, 95, 26);
									  ProductCategory.add(pStorageSpacetxt);
									  pStorageSpacetxt.setColumns(10);
									  
									  JLabel lblNewLabel_7 = new JLabel("Graphic Card");
									  lblNewLabel_7.setBounds(288, 204, 95, 16);
									  ProductCategory.add(lblNewLabel_7);
									  
									  JLabel lblNewLabel_8 = new JLabel("Mother Board");
									  lblNewLabel_8.setBounds(5, 286, 95, 16);
									  ProductCategory.add(lblNewLabel_8);
									  
									  JLabel lblNewLabel_9 = new JLabel("Storage Space");
									  lblNewLabel_9.setBounds(133, 286, 95, 16);
									  ProductCategory.add(lblNewLabel_9);
									  
									  JLabel lblNewLabel = new JLabel("ID");
									  lblNewLabel.setBounds(5, 123, 56, 16);
									  ProductCategory.add(lblNewLabel);
									  
									  JLabel lblNewLabel_1 = new JLabel("Brand");
									  lblNewLabel_1.setBounds(85, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_1);
									  
									  JLabel lblNewLabel_2 = new JLabel("Model");
									  lblNewLabel_2.setBounds(193, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_2);
									  
									  JLabel lblNewLabel_3 = new JLabel("Processor");
									  lblNewLabel_3.setBounds(5, 204, 68, 16);
									  ProductCategory.add(lblNewLabel_3);
									  
									  JLabel lblNewLabel_4 = new JLabel("Ram Size");
									  lblNewLabel_4.setBounds(85, 204, 56, 16);
									  ProductCategory.add(lblNewLabel_4);
									  
									  
									  JLabel lblPrice = new JLabel("Price");
									  lblPrice.setBounds(280, 123, 61, 16);
									  ProductCategory.add(lblPrice);
									  
									  JLabel lblNewLabel_5 = new JLabel("Display Size");
									  lblNewLabel_5.setBounds(188, 204, 86, 16);
									  ProductCategory.add(lblNewLabel_5);
									  
									  JLabel lblNewLabel_6 = new JLabel("NoteBook");
									  lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
									  lblNewLabel_6.setBounds(5, 51, 108, 22);
									  ProductCategory.add(lblNewLabel_6);
									  
									  BotHandler product = new BotHandler();
									  JButton PhKayitButon = new JButton("Add Product");
									  
									  PhKayitButon.addActionListener(new ActionListener() { 
									   public void actionPerformed(ActionEvent e) {
									    
										   String pBrand  = pBrandtxt.getText();
										    int pId = Integer.parseInt(pIDtxt.getText());
										    String pModel  = pModeltxt.getText();
										    try {
										    	tweetci.getTweet("#"+pBrand);
											} catch (IOException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
										    double pPrice = Double.parseDouble(pPricetxt.getText());
										    
										    double pPoint = 0;
											try {
												pPoint = sentic1.SenticSina(pBrand, map1.mapBuilder());
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}										    
										    
										    String pProcessor = pProcessortxt.getText();
										    String pRam = pRamtxt.getText();
										    String pDisplaySize = pDisplaySizetxt.getText();
										    String pGraphicCard = pGraphicCardtxt.getText();
										    String pMotherBoard = pMotherBoardtxt.getText();
										    String pStorageSpace = pStorageSpacetxt.getText();

										    NoteBook noteBook = new NoteBook(pId,pBrand,pModel,pPrice,pPoint,pRam,pProcessor,pDisplaySize,pGraphicCard,pMotherBoard, pStorageSpace);
										    										    										   
										    product.noteBookList.add(noteBook);								    
									   }
									  });
									 
									  noteBookList.add(noteBook);
									  PhKayitButon.setBounds(23, 358, 142, 25);
									  ProductCategory.add(PhKayitButon);									  
									}
				
									else if(uText.equals("Camasir Makinasi") || uText.equals("camasir makinasi")) // Add Washing Machine

									{
										WashingMachine washingMachine = new WashingMachine();
									 	setTitle("Add Washing Machine");
									  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  setBounds(100, 100, 728, 424);
									  ProductCategory = new JPanel();
									  ProductCategory.setBorder(new EmptyBorder(5, 5, 5, 5));
									  setContentPane(ProductCategory);
									  ProductCategory.setLayout(null);
									  
									  pIDtxt = new JTextField();
									  pIDtxt.setBounds(5, 150, 41, 22);
									  ProductCategory.add(pIDtxt);
									  pIDtxt.setColumns(10);
									  
									  pBrandtxt = new JTextField();
									  pBrandtxt.setBounds(85, 150, 63, 22);
									  ProductCategory.add(pBrandtxt);
									  pBrandtxt.setColumns(10);
									  
									  pRotationSpeedxt = new JTextField();
									  pRotationSpeedxt.setBounds(280, 232, 86, 20);
									  ProductCategory.add(pRotationSpeedxt);
									  pRotationSpeedxt.setColumns(10);
									  
									  pPricetxt = new JTextField();
									  pPricetxt.setBounds(280, 151, 86, 20);
									  ProductCategory.add(pPricetxt);
									  pPricetxt.setColumns(10);
									  
									  pModeltxt = new JTextField();
									  pModeltxt.setBounds(193, 150, 63, 22);
									  ProductCategory.add(pModeltxt);
									  pModeltxt.setColumns(10);
									  
									  pWashingCapacitytxt = new JTextField();
									  pWashingCapacitytxt.setBounds(5, 231, 108, 22);
									  ProductCategory.add(pWashingCapacitytxt);
									  pWashingCapacitytxt.setColumns(10);
									  
									  pEnergyClasstxt = new JTextField();
									  pEnergyClasstxt.setText("");
									  pEnergyClasstxt.setBounds(147, 231, 91, 22);
									  ProductCategory.add(pEnergyClasstxt);
									  pEnergyClasstxt.setColumns(10);
									  
									  JLabel lblNewLabel = new JLabel("ID");
									  lblNewLabel.setBounds(5, 123, 56, 16);
									  ProductCategory.add(lblNewLabel);								  

									  JLabel lblPrice = new JLabel("Price");
									  lblPrice.setBounds(280, 123, 61, 16);
									  ProductCategory.add(lblPrice);
									  
									  JLabel lblNewLabel_5 = new JLabel("Rotation Speed");
									  lblNewLabel_5.setBounds(280, 204, 108, 16);
									  ProductCategory.add(lblNewLabel_5);
									  
									  JLabel lblNewLabel_6 = new JLabel("Washing Machine");
									  lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
									  lblNewLabel_6.setBounds(5, 51, 175, 22);
									  ProductCategory.add(lblNewLabel_6);
									  
									  JLabel lblNewLabel_1 = new JLabel("Brand");
									  lblNewLabel_1.setBounds(85, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_1);
									  
									  JLabel lblNewLabel_2 = new JLabel("Model");
									  lblNewLabel_2.setBounds(193, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_2);
									  
									  JLabel lblNewLabel_3 = new JLabel("Washing Capacity");
									  lblNewLabel_3.setBounds(5, 203, 130, 16);
									  ProductCategory.add(lblNewLabel_3);
									  
									  JLabel lblNewLabel_4 = new JLabel("Energy Class");
									  lblNewLabel_4.setBounds(147, 204, 91, 16);
									  ProductCategory.add(lblNewLabel_4);
									  BotHandler product = new BotHandler();
									  JButton PhKayitButon = new JButton("Add Product");
									  PhKayitButon.addActionListener(new ActionListener() {
									   public void actionPerformed(ActionEvent e) { 									    
										   String pBrand  = pBrandtxt.getText();
										    int pId = Integer.parseInt(pIDtxt.getText());
										    String pModel  = pModeltxt.getText();
										    try {
										    	tweetci.getTweet("#"+pBrand);
											} catch (IOException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
										    double pPrice = Double.parseDouble(pPricetxt.getText());
										    
										    double pPoint = 0;
											try {
												pPoint = sentic1.SenticSina(pBrand, map1.mapBuilder());
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										    
										    String pWashingCapacity = pWashingCapacitytxt.getText();
										    String pEnergyClass = pEnergyClasstxt.getText();
										    int pRotationSpeed = Integer.parseInt(pRotationSpeedxt.getText());

										    WashingMachine washingMachine = new WashingMachine(pId, pBrand, pModel, pPrice,pPoint, pWashingCapacity,pEnergyClass,pRotationSpeed );										    										   
										    
										    product.washingMachineList.add(washingMachine);									    
									   }
									  });
									  washingMachineList.add(washingMachine);
									  PhKayitButon.setBounds(23, 358, 142, 25);
									  ProductCategory.add(PhKayitButon);									  									 									  
									 									}
				
									else if(uText.equals("Buzdolabi") || uText.equals("buzdolabi")) // Add Fridge
									{
										Fridge fridge = new Fridge();
										 
									 	setTitle("Add Fridge");
									  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  setBounds(100, 100, 728, 424);
									  ProductCategory = new JPanel();
									  ProductCategory.setBorder(new EmptyBorder(5, 5, 5, 5));
									  setContentPane(ProductCategory);
									  ProductCategory.setLayout(null);
									  
									  pIDtxt = new JTextField();
									  pIDtxt.setBounds(5, 150, 41, 22);
									  ProductCategory.add(pIDtxt);
									  pIDtxt.setColumns(10);
									  
									  pBrandtxt = new JTextField();
									  pBrandtxt.setBounds(85, 150, 63, 22);
									  ProductCategory.add(pBrandtxt);
									  pBrandtxt.setColumns(10);
									  
									  pModeltxt = new JTextField();
									  pModeltxt.setBounds(193, 150, 63, 22);
									  ProductCategory.add(pModeltxt);
									  pModeltxt.setColumns(10);
									  
									  pLitretxt = new JTextField();
									  pLitretxt.setBounds(5, 231, 108, 22);
									  ProductCategory.add(pLitretxt);
									  pLitretxt.setColumns(10);
									  
									  pEnergyClasstxt = new JTextField();
									  pEnergyClasstxt.setText("");
									  pEnergyClasstxt.setBounds(147, 231, 91, 22);
									  ProductCategory.add(pEnergyClasstxt);
									  pEnergyClasstxt.setColumns(10);
									  
									  JLabel lblNewLabel = new JLabel("ID");
									  lblNewLabel.setBounds(5, 123, 56, 16);
									  ProductCategory.add(lblNewLabel);
									  
									  JLabel lblNewLabel_1 = new JLabel("Brand");
									  lblNewLabel_1.setBounds(85, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_1);
									  
									  JLabel lblNewLabel_2 = new JLabel("Model");
									  lblNewLabel_2.setBounds(193, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_2);
									  
									  JLabel lblNewLabel_3 = new JLabel("Litre");
									  lblNewLabel_3.setBounds(5, 203, 130, 16);
									  ProductCategory.add(lblNewLabel_3);
									  
									  JLabel lblNewLabel_4 = new JLabel("Energy Class");
									  lblNewLabel_4.setBounds(147, 204, 91, 16);
									  ProductCategory.add(lblNewLabel_4);
									  BotHandler product = new BotHandler();
									  JButton PhKayitButon = new JButton("Add Product");
									  PhKayitButon.addActionListener(new ActionListener() {
									   public void actionPerformed(ActionEvent e) {
									    
										   String pBrand  = pBrandtxt.getText();
										    int pid = Integer.parseInt(pIDtxt.getText());
										    String pModel  = pModeltxt.getText();
										    try {
										    	tweetci.getTweet("#"+pBrand);
											} catch (IOException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
										    double pPrice = Double.parseDouble(pPricetxt.getText());
										    
										    double pPoint = 0;
											try {
												pPoint = sentic1.SenticSina(pBrand, map1.mapBuilder());
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										    
										    String pLitre = pLitretxt.getText();
										    String pEnergyClass = pEnergyClasstxt.getText();

										    Fridge fridge = new Fridge(pid, pBrand, pModel, pPrice,pPoint, pEnergyClass, pLitre );										    										    
										    
										    product.fridgeList.add(fridge);									    
									   }
									  });
									  fridgeList.add(fridge);
									  PhKayitButon.setBounds(23, 358, 142, 25);
									  ProductCategory.add(PhKayitButon);
									  
									  pPricetxt = new JTextField();
									  pPricetxt.setBounds(280, 151, 86, 20);
									  ProductCategory.add(pPricetxt);
									  pPricetxt.setColumns(10);
									  
									  JLabel lblPrice = new JLabel("Price");
									  lblPrice.setBounds(280, 123, 61, 16);
									  ProductCategory.add(lblPrice);
									  
									  JLabel lblNewLabel_6 = new JLabel("Fridge");
									  lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
									  lblNewLabel_6.setBounds(5, 51, 108, 22);
									  ProductCategory.add(lblNewLabel_6);
									}
				
									else if(uText.equals("Bulasik Makinasi") || uText.equals("bulasik makinasi")) // Add DishWasher
									{
										DishWasher dishWasher = new DishWasher();
										 
									 	setTitle("Add DishWasher");
									  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  setBounds(100, 100, 728, 424);
									  ProductCategory = new JPanel();
									  ProductCategory.setBorder(new EmptyBorder(5, 5, 5, 5));
									  setContentPane(ProductCategory);
									  ProductCategory.setLayout(null);
									  
									  pIDtxt = new JTextField();
									  pIDtxt.setBounds(5, 150, 41, 22);
									  ProductCategory.add(pIDtxt);
									  pIDtxt.setColumns(10);
									  
									  pBrandtxt = new JTextField();
									  pBrandtxt.setBounds(85, 150, 63, 22);
									  ProductCategory.add(pBrandtxt);
									  pBrandtxt.setColumns(10);
									  
									  pModeltxt = new JTextField();
									  pModeltxt.setBounds(193, 150, 63, 22);
									  ProductCategory.add(pModeltxt);
									  pModeltxt.setColumns(10);
									  
									  pProgramNumbertxt = new JTextField();
									  pProgramNumbertxt.setBounds(5, 231, 108, 22);
									  ProductCategory.add(pProgramNumbertxt);
									  pProgramNumbertxt.setColumns(10);
									  
									  pEnergyClasstxt = new JTextField();
									  pEnergyClasstxt.setText("");
									  pEnergyClasstxt.setBounds(147, 231, 91, 22);
									  ProductCategory.add(pEnergyClasstxt);
									  pEnergyClasstxt.setColumns(10);
									  
									  JLabel lblNewLabel = new JLabel("ID");
									  lblNewLabel.setBounds(5, 123, 56, 16);
									  ProductCategory.add(lblNewLabel);
									  
									  JLabel lblNewLabel_1 = new JLabel("Brand");
									  lblNewLabel_1.setBounds(85, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_1);
									  
									  JLabel lblNewLabel_2 = new JLabel("Model");
									  lblNewLabel_2.setBounds(193, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_2);
									  
									  JLabel lblNewLabel_3 = new JLabel("ProgramNumber");
									  lblNewLabel_3.setBounds(5, 203, 130, 16);
									  ProductCategory.add(lblNewLabel_3);
									  
									  JLabel lblNewLabel_4 = new JLabel("Energy Class");
									  lblNewLabel_4.setBounds(147, 204, 91, 16);
									  ProductCategory.add(lblNewLabel_4);
									  BotHandler product = new BotHandler();
									  JButton PhKayitButon = new JButton("Add Product");
									  PhKayitButon.addActionListener(new ActionListener() {
									   public void actionPerformed(ActionEvent e) {
									    
										   String pBrand  = pBrandtxt.getText();
										    int pid = Integer.parseInt(pIDtxt.getText());
										    String pModel  = pModeltxt.getText();
										    try {
										    	tweetci.getTweet("#"+pBrand);
											} catch (IOException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
										    double pPrice = Double.parseDouble(pPricetxt.getText());
										    
										    double pPoint = 0;
											try {
												pPoint = sentic1.SenticSina(pBrand, map1.mapBuilder());
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										    
										    int pProgramNumber = Integer.parseInt(pProgramNumbertxt.getText());
										    String pEnergyClass = pEnergyClasstxt.getText();
										    
										    DishWasher dishWasher = new DishWasher(pid, pBrand, pModel, pPrice,pPoint, pEnergyClass,pProgramNumber);
										    										   										    
										    product.dishWasherList.add(dishWasher);									    
									   }
									  });
									  dishWasherList.add(dishWasher);
									  PhKayitButon.setBounds(23, 358, 142, 25);
									  ProductCategory.add(PhKayitButon);
									  
									  pPricetxt = new JTextField();
									  pPricetxt.setBounds(280, 151, 86, 20);
									  ProductCategory.add(pPricetxt);
									  pPricetxt.setColumns(10);
									  
									  JLabel lblPrice = new JLabel("Price");
									  lblPrice.setBounds(280, 123, 61, 16);
									  ProductCategory.add(lblPrice);
									  
									  JLabel lblNewLabel_6 = new JLabel("DishWasher");
									  lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
									  lblNewLabel_6.setBounds(5, 51, 143, 22);
									  ProductCategory.add(lblNewLabel_6);
									}
				
									else if(uText.equals("Kamera") || uText.equals("kamera")) // Add Camera
									{
										Camera camera = new Camera();
										 									 	
										setTitle("Add Camera");
									  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  setBounds(100, 100, 728, 424);
									  ProductCategory = new JPanel();
									  ProductCategory.setBorder(new EmptyBorder(5, 5, 5, 5));
									  setContentPane(ProductCategory);
									  ProductCategory.setLayout(null);
									  
									  pIDtxt = new JTextField();
									  pIDtxt.setBounds(5, 150, 41, 22);
									  ProductCategory.add(pIDtxt);
									  pIDtxt.setColumns(10);
									  
									  pBrandtxt = new JTextField();
									  pBrandtxt.setBounds(85, 150, 63, 22);
									  ProductCategory.add(pBrandtxt);
									  pBrandtxt.setColumns(10);
									  
									  pModeltxt = new JTextField();
									  pModeltxt.setBounds(193, 150, 63, 22);
									  ProductCategory.add(pModeltxt);
									  pModeltxt.setColumns(10);
									  
									  pDiaphragmtxt = new JTextField();
									  pDiaphragmtxt.setBounds(5, 231, 108, 22);
									  ProductCategory.add(pDiaphragmtxt);
									  pDiaphragmtxt.setColumns(10);
									  
									  pZoomtxt = new JTextField();
									  pZoomtxt.setText("");
									  pZoomtxt.setBounds(147, 231, 91, 22);
									  ProductCategory.add(pZoomtxt);
									  pZoomtxt.setColumns(10);
									  
									  JLabel lblNewLabel = new JLabel("ID");
									  lblNewLabel.setBounds(5, 123, 56, 16);
									  ProductCategory.add(lblNewLabel);
									  
									  JLabel lblNewLabel_1 = new JLabel("Brand");
									  lblNewLabel_1.setBounds(85, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_1);
									  
									  JLabel lblNewLabel_2 = new JLabel("Model");
									  lblNewLabel_2.setBounds(193, 123, 56, 16);
									  ProductCategory.add(lblNewLabel_2);
									  
									  JLabel lblNewLabel_3 = new JLabel("Diaphragm");
									  lblNewLabel_3.setBounds(5, 203, 130, 16);
									  ProductCategory.add(lblNewLabel_3);
									  
									  JLabel lblNewLabel_4 = new JLabel("Zoom");
									  lblNewLabel_4.setBounds(147, 203, 91, 16);
									  ProductCategory.add(lblNewLabel_4);
									  BotHandler product = new BotHandler();
									  JButton PhKayitButon = new JButton("Add Product");
									  PhKayitButon.addActionListener(new ActionListener() {
									   public void actionPerformed(ActionEvent e) {
									    
										   String pBrand  = pBrandtxt.getText();
										    int pid = Integer.parseInt(pIDtxt.getText());
										    String pModel  = pModeltxt.getText();
										    try {
										    	tweetci.getTweet("#"+pBrand);
											} catch (IOException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
										    double pPrice = Double.parseDouble(pPricetxt.getText());
										    
										    double pPoint = 0;
											try {
												pPoint = sentic1.SenticSina(pBrand, map1.mapBuilder());
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										    
										    String pDiaphragm = pDiaphragmtxt.getText();
										    String pZoom = pZoomtxt.getText();										    
										    	String pMegaPixel = pMegaPixeltxt.getText();
										    Camera camera = new Camera(pid, pBrand, pModel, pPrice,pPoint, pZoom,pDiaphragm,pMegaPixel);
										    										    
										    product.cameraList.add(camera);									    
									   }
									  });
									  cameraList.add(camera);
									  PhKayitButon.setBounds(23, 358, 142, 25);
									  ProductCategory.add(PhKayitButon);
									  
									  pPricetxt = new JTextField();
									  pPricetxt.setBounds(280, 151, 86, 20);
									  ProductCategory.add(pPricetxt);
									  pPricetxt.setColumns(10);
									  
									  JLabel lblPrice = new JLabel("Price");
									  lblPrice.setBounds(280, 123, 61, 16);
									  ProductCategory.add(lblPrice);
									  
									  JLabel lblNewLabel_6 = new JLabel("Camera");
									  lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
									  lblNewLabel_6.setBounds(5, 51, 143, 22);
									  ProductCategory.add(lblNewLabel_6);
									  
									  pMegaPixeltxt = new JTextField();
									  pMegaPixeltxt.setBounds(280, 229, 130, 26);
									  ProductCategory.add(pMegaPixeltxt);
									  pMegaPixeltxt.setColumns(10);
									  
									  JLabel lblNewLabel_5 = new JLabel("MegaPixel");
									  lblNewLabel_5.setBounds(280, 203, 108, 16);
									  ProductCategory.add(lblNewLabel_5);
									 
									}
									else if(uText.equals("Tweet Al")){ // Show Tweets
										Twitter tweets = new Twitter();
										mapper map = new mapper();
										SenticNet sentic = new SenticNet();
										for(CellPhone alinanUrun : cellPhoneList )
										{
											try {
												tweets.getTweet("#"+alinanUrun.getpBrand());
												
											} catch (IOException e1) {
												
												
											}
										}
										for(NoteBook alinanUrun : noteBookList )
										{
											try {
												tweets.getTweet("#"+alinanUrun.getpBrand());
												
											} catch (IOException e1) {
												
												
											}
										}
										for(DishWasher alinanUrun : dishWasherList )
										{
											try {
												tweets.getTweet("#"+alinanUrun.getpBrand());
												
											} catch (IOException e1) {
												
												
											}
										}
										for(Camera alinanUrun : cameraList )
										{
											try {
												tweets.getTweet("#"+alinanUrun.getpBrand());
												
											} catch (IOException e1) {
												
												
											}
										}
										for(WashingMachine alinanUrun : washingMachineList )
										{
											try {
												tweets.getTweet("#"+alinanUrun.getpBrand());
												
											} catch (IOException e1) {
												
												
											}
										}
										for(Fridge alinanUrun : fridgeList )
										{
											try {
												tweets.getTweet("#"+alinanUrun.getpBrand());
												
											} catch (IOException e1) {
												
												
											}
										}
										
									}
									else if(uText.equals("Nasilsin") || uText.equals("Naber"))
									{
										decideRandom(conditionMessageList);
									}
									
									else if(uText.equals("Iyiyim") || uText.equals("Idare eder"))
									{
										txtChat.append("Ne Yapmak Istiyorsun?\n");
									}
				
									else if(uText.equals("Güle Güle") || uText.equals("Bye Bye") || uText.equals("Gorusuruz"))
									{
										decideRandom(exitMessageList);
										 
									}
										else {
											decideRandom(exceptionMessageList);
										}
			   }
		});

		// elemanlari JFrame'e ekle
		this.add(txtEnter);
		this.add(txtChat);
	}
	SenticNet sentic1 = new SenticNet();
	mapper map1 = new mapper();	

	private void decideRandom(ArrayList<String> messageList) {
		int decider = (int) (Math.random() * messageList.size());
		txtChat.append("AI: " + messageList.get(decider) + "\n");
	}
	
	private ArrayList<CellPhone> setCellPhoneProducts(ArrayList<CellPhone> cellPhoneList) {
			
		try {
			cellPhoneList.add(new CellPhone(1, "Asus", "Zenphone3", 1000.00,sentic1.SenticSina("Asus", map1.mapBuilder()), 12, "3GB",5.5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cellPhoneList.add(new CellPhone(2, "Apple", "IphoneX", 6500.00,sentic1.SenticSina("Apple", map1.mapBuilder()), 12, "2GB",6.0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			cellPhoneList.add(new CellPhone(3, "Samsung", "Note8", 4000.00,sentic1.SenticSina("Samsung", map1.mapBuilder()), 12, "6GB",6.3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return cellPhoneList;
	}
	
	private ArrayList<NoteBook> setNoteBookProducts(ArrayList<NoteBook> noteBookList) {
		
		try {
			noteBookList.add(new NoteBook(1, "Lenovo", "IdeaPad520", 3200.00, sentic1.SenticSina("Lenovo", map1.mapBuilder()),"16 GB", "Intel i7", "15.6inc", "GForce 950","Z170","1TB"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			noteBookList.add(new NoteBook(2, "Monster", "Tulpar", 4400.00,sentic1.SenticSina("Monster", map1.mapBuilder()), "16 GB", "Intel i7", "17inc", "GForce 1050","Z270","1TB"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			noteBookList.add(new NoteBook(3, "APPLE", "MacbookAir", 4000.00,sentic1.SenticSina("APPLE", map1.mapBuilder()), "4 GB", "Intel i5", "13inc", "IntelGraphic","Apple","256GB"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noteBookList;
	}
	
	private ArrayList<Camera> setCameraProducts(ArrayList<Camera> cameraList) {
		
		try {
			cameraList.add(new Camera(1, "Nikon","D5300", 3100.00,sentic1.SenticSina("Nikon", map1.mapBuilder()), "8x", "1.8f", "24.2MP"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cameraList.add(new Camera(2,"Canon","EOS200D", 2700.00,sentic1.SenticSina("Canon", map1.mapBuilder()), "16x", "2.0f", "18MP"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cameraList.add(new Camera(3,"Sony", "A6000", 2450.00,sentic1.SenticSina("Sony", map1.mapBuilder()), "4x", "3.5f", "24.3MP"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cameraList;
	}
	
	private ArrayList <Fridge> setFridgeProducts(ArrayList<Fridge> fridgeList) {
		
		try {
			fridgeList.add(new Fridge(1,"Samsung","RT46", 1900.00,sentic1.SenticSina("Samsung", map1.mapBuilder()), "A+", "468Lt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fridgeList.add(new Fridge(2,"Lg", "GRM31", 9999.00,sentic1.SenticSina("Lg", map1.mapBuilder()), "A++", "931Lt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fridgeList.add(new Fridge(3,"Siemens", "KG86", 4800.00,sentic1.SenticSina("Siemens", map1.mapBuilder()), "A+++", "682Lt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fridgeList;
	}
	
	private ArrayList<DishWasher> setDishWasherProducts(ArrayList<DishWasher> dishWasherList) {
		
		try {
			dishWasherList.add(new DishWasher(1,"Samsung","DW60", 3050.00,sentic1.SenticSina("Samsung", map1.mapBuilder()),"A++", 5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dishWasherList.add(new DishWasher(2,"lg","D1454",3000.00,sentic1.SenticSina("lg", map1.mapBuilder()), "A++", 7));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dishWasherList.add(new DishWasher(3,"Vestel", "BM1004", 1600.00,sentic1.SenticSina("zenphone3", map1.mapBuilder()),"A+++",10));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dishWasherList;		
	}
	
	private ArrayList<WashingMachine> setWashingMachineProducts(ArrayList<WashingMachine> washingMachineList) {
		
		try {
			washingMachineList.add(new WashingMachine(1,"Bosch","WAY287", 3700.00,sentic1.SenticSina("Bosch", map1.mapBuilder()), "8Kg", "A+++",1400));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			washingMachineList.add(new WashingMachine(2,"Samsung","WD90K",3000.00,sentic1.SenticSina("Samsung", map1.mapBuilder()),"9Kg","A",1400));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			washingMachineList.add(new WashingMachine(3,"Vestel","9614",2200.00,sentic1.SenticSina("Vestel", map1.mapBuilder()),"9Kg","A",1400));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return washingMachineList;
	}

	public static void main(String[] args) throws IOException {
		
		new BotHandler();			
	}
}
