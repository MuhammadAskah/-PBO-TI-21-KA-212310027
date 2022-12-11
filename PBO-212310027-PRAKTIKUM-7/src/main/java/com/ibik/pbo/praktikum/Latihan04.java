package com.ibik.pbo.praktikum;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class Latihan04 {

	public static void main(String[] args) {
		  JFrame frame = new JFrame("Penilaian Matakuliah PBO");
		  frame.setSize(725, 400);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  JPanel panel = new JPanel();
		  frame.add(panel);
		  placeComponents(panel, frame);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
		}

	private static void placeComponents(JPanel panel, final JFrame frame) {
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("FORM PENILAIAN MATAKULIAH PBO");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 10, 750, 25);
		panel.add(titleLabel);
		
		JLabel namaLabel = new JLabel("Nama:");
		namaLabel.setBounds(10, 40, 80, 25);
		panel.add(namaLabel);

		final JTextField namaField = new JTextField(20);
		namaField.setBounds(100, 40, 160, 25);
		panel.add(namaField);

		JLabel nimLabel = new JLabel("NIM:");
		nimLabel.setBounds(10, 70, 80, 25);
		panel.add(nimLabel);

		final JTextField nimField = new JTextField(20);
		nimField.setBounds(100, 70, 160, 25);
		panel.add(nimField);

		JLabel matkulLabel = new JLabel("Matakuliah:");
		matkulLabel.setBounds(10, 100, 80, 25);
		panel.add(matkulLabel);

		final JTextField matkulField = new JTextField(20);
		matkulField.setBounds(100, 100, 160, 25);
		panel.add(matkulField);

		JLabel nilaiLabel = new JLabel("Nilai:");
		nilaiLabel.setBounds(10, 130, 80, 25);
		panel.add(nilaiLabel);

		final JRadioButton aButton = new JRadioButton("A");
		aButton.setBounds(25, 150, 50, 25);
		panel.add(aButton);

		final JRadioButton bButton = new JRadioButton("B");
		bButton.setBounds(75, 150, 50, 25);
		panel.add(bButton);

		final JRadioButton cButton = new JRadioButton("C");
		cButton.setBounds(125, 150, 50, 25);
		panel.add(cButton);

		final JRadioButton dButton = new JRadioButton("D");
		dButton.setBounds(175, 150, 50, 25);
		panel.add(dButton);

		final JRadioButton eButton = new JRadioButton("E");
		eButton.setBounds(225, 150, 50, 25);
		panel.add(eButton);

		ButtonGroup group = new ButtonGroup();
		group.add(aButton);
		group.add(bButton);
		group.add(cButton);
		group.add(dButton);
		group.add(eButton);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(10, 190, 80, 25);
		panel.add(saveButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(100, 190, 80, 25);
		panel.add(deleteButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(190, 190, 80, 25);
		panel.add(clearButton);
		
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
		


		final JTable table = new JTable(model);

		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		table.setFillsViewportHeight(true);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(300, 40, 400, 280);
		panel.add(scrollPane);
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
		JMenuItem saveToPdfItem = new JMenuItem("Save to PDF");
		saveToPdfItem.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			    // show a file chooser dialog to prompt the user for a filename
			    JFileChooser fileChooser = new JFileChooser();
			    fileChooser.setDialogTitle("Save to PDF");
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
		frame.setJMenuBar(menuBar);
		
		JMenuItem menuItem = new JMenuItem("Exit");
		menu.add(menuItem);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}