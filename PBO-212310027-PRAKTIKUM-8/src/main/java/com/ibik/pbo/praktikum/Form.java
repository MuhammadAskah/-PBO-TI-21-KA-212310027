package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class Form extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2010852426529829766L;

	Form() {
		  pack();
		  setLocationRelativeTo(null);
		  setSize(875, 510);
		  setTitle("Form");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  placeComponents(this);
		  setVisible(true);
	}
	public static void main(String[] args) {
		new Form();
		}

	private void placeComponents(final Form frame) {
        JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);
		
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
        panel.add(headerPanel, BorderLayout.NORTH);
        JLabel headerTitle = new JLabel("FORM PENILAIAN MATAKULIAH PBO");
        headerTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        headerPanel.add(headerTitle);
		
        Border lftPanelBorder = BorderFactory.createTitledBorder("Input Data Mahasiswa");
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(400, 480));
        panel.add(leftPanel, BorderLayout.WEST);
		
		JLabel namaLabel = new JLabel("Nama:");
		namaLabel.setBounds(10, 40, 80, 25);
		leftPanel.add(namaLabel);

		final JTextField namaField = new JTextField(20);
		namaField.setBounds(100, 40, 160, 25);
		leftPanel.add(namaField);

		JLabel nimLabel = new JLabel("NIM:");
		nimLabel.setBounds(10, 70, 80, 25);
		leftPanel.add(nimLabel);

		final JTextField nimField = new JTextField(20);
		nimField.setBounds(100, 70, 160, 25);
		leftPanel.add(nimField);

		JLabel matkulLabel = new JLabel("Lab/Teori:");
		matkulLabel.setBounds(10, 100, 80, 25);
		leftPanel.add(matkulLabel);

		final JTextField matkulField = new JTextField(20);
		matkulField.setBounds(100, 100, 160, 25);
		leftPanel.add(matkulField);

		JLabel nilaiLabel = new JLabel("Nilai:");
		nilaiLabel.setBounds(10, 130, 80, 25);
		leftPanel.add(nilaiLabel);

		final JRadioButton aButton = new JRadioButton("A");
		aButton.setBounds(10, 155, 35, 25);
		leftPanel.add(aButton);

		final JRadioButton bButton = new JRadioButton("B");
		bButton.setBounds(60, 155, 35, 25);
		leftPanel.add(bButton);

		final JRadioButton cButton = new JRadioButton("C");
		cButton.setBounds(110, 155, 35, 25);
		leftPanel.add(cButton);

		final JRadioButton dButton = new JRadioButton("D");
		dButton.setBounds(160, 155, 35, 25);
		leftPanel.add(dButton);

		final JRadioButton eButton = new JRadioButton("E");
		eButton.setBounds(210, 155, 35, 25);
		leftPanel.add(eButton);

		final JRadioButton fButton = new JRadioButton("F");
		fButton.setBounds(260, 155, 35, 25);
		leftPanel.add(fButton);

		ButtonGroup group = new ButtonGroup();
		group.add(aButton);
		group.add(bButton);
		group.add(cButton);
		group.add(dButton);
		group.add(eButton);
		group.add(fButton);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(15, 190, 80, 25);
		leftPanel.add(saveButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(115, 190, 80, 25);
		leftPanel.add(deleteButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(205, 190, 80, 25);
		leftPanel.add(clearButton);
		leftPanel.setBorder(lftPanelBorder);
		String[] columns = { "Nama", "NIM", "Matakuliah", "Nilai" };
		final DefaultTableModel model = new DefaultTableModel(columns, 0);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nama = namaField.getText();
				String nim = nimField.getText();
				String matkul = matkulField.getText();

				String nilai = "";
				if (aButton.isSelected()) {
					nilai = "A";
				} else if (bButton.isSelected()) {
					nilai = "B";
				} else if (cButton.isSelected()) {
					nilai = "C";
				} else if (dButton.isSelected()) {
					nilai = "D";
				} else if (eButton.isSelected()) {
					nilai = "E";
				} else if (fButton.isSelected()) {
					nilai = "F";
				}

				String[] data = { nama, nim, matkul, nilai };
				model.addRow(data);
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
			    namaField.setText("");
			    nimField.setText("");
			    matkulField.setText("");
			  }
			});
		
		Border rightBorder = BorderFactory.createTitledBorder("Data Mahasiswa");
		JPanel rightPanel = new JPanel(new BorderLayout());
        panel.add(rightPanel);


		final JTable table = new JTable(model);
		// Get the dimensions of the right panel
		Dimension panelSize = rightPanel.getSize();

		// Set the preferred size of the table's scrollable viewport
		table.setPreferredScrollableViewportSize(panelSize);
		table.setFillsViewportHeight(true);
		rightPanel.add(table, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(300, 40, 500, 400);
		rightPanel.add(scrollPane);
		rightPanel.setBorder(rightBorder);
		deleteButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
			    // get the selected row index
			    int selectedRow = table.getSelectedRow();
			    if (selectedRow >= 0) {
			      // remove the row from the table model
			      model.removeRow(selectedRow);
			    }
			  }
			});
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem saveToPdfItem = new JMenuItem("Save");
		saveToPdfItem.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			    // show a file chooser dialog to prompt the user for a filename
			    JFileChooser fileChooser = new JFileChooser();
			    fileChooser.setDialogTitle("Save");
			    fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
			    int userSelection = fileChooser.showSaveDialog(frame);

			    // check if the user selected a file
			    if (userSelection == JFileChooser.APPROVE_OPTION) {
			      File fileToSave = fileChooser.getSelectedFile();

			      // create the PDF document
			      try {
			    	  // create the PDF document
			    	  Document document = new Document();

			    	  // create a writer to write the PDF document
			    	  PdfWriter.getInstance(document, new FileOutputStream(fileToSave));

			    	  // open the document
			    	  document.open();

			    	  // add the data from the JTable to the PDF document
			    	  PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
			    	  for (int i = 0; i < table.getColumnCount(); i++) {
			    	    pdfTable.addCell(table.getColumnName(i));
			    	  }
			    	  for (int i = 0; i < table.getRowCount(); i++) {
			    	    for (int j = 0; j < table.getColumnCount(); j++) {
			    	      pdfTable.addCell(table.getValueAt(i, j).toString());
			    	    }
			    	  }
			    	  document.add(pdfTable);

			    	  // close the document
			    	  document.close();

			    	  // show a success message
			    	  JOptionPane.showMessageDialog(null, "Data saved to PDF successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			    	} catch (Exception ex) {
			    	  // show an error message
			    	  JOptionPane.showMessageDialog(null, "Error saving data to PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    	}
			    }
		  }
		});
		
		
		menu.add(saveToPdfItem);
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Exit");
		menu.add(menuItem);
		menuBar.add(menu);

        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
        
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
}