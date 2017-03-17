package ktech1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class View {

	protected static Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	private static Table table;
	private Text first;
	private Text last;
	private Text id;
	private Text major;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			View window = new View();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
	    
	    Button btnRemove = new Button(shell, SWT.NONE);
	    btnRemove.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		MessageBox check = new MessageBox(shell, SWT.YES | SWT.NO | SWT.ICON_QUESTION);
	    		check.setText("Confirm");
	    		check.setMessage("Are you sure you want to delete the selected student?");
	    		int cc = check.open();
	    		if (cc == SWT.YES) {
	    		
	    			TableItem[] tt = table.getSelection();
	    		
	    			for (int t = 0; t < tt.length; t++) {
	    				int i = 1;
	    				String test = "";
	    				while (!tt[t].getText(i).isEmpty()) {
	    					test = test + "," + tt[t].getText(i);
	    					i++;
	    				}
	    				String lineToRemove = test.substring(1);
	    				try {
	    					File inFile = new File("data.txt");
	    					if (!inFile.isFile()) {
	    						MessageBox err = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
	    						err.setText("Error!");
	    						err.setMessage("Cannot find file.");
	    						err.open();
	    						return;
	    					}
	    					File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
	    					BufferedReader br = new BufferedReader(new FileReader(inFile));
	    					PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	    					String line ;
	    					while ((line = br.readLine()) != null) {
	    						if (!line.trim().equals(lineToRemove)) {
	    							pw.println(line);
	    							pw.flush();	
	    						}
	    					}
	    					pw.close();
	    					br.close();
	            
	    					if (!inFile.delete()) {
	    						System.out.println("Could not delete file");
	    						return;
	    					}
	    					if (!tempFile.renameTo(inFile))
	    						System.out.println("Could not rename file");	  
	    				}
	    				catch (IOException e4) {
	    					e4.printStackTrace();
	    				}
	    		
	    			}
	    			showAll();	
	    		}
	    	}
	    	
	    });
	    btnRemove.setBounds(117, 184, 75, 25);
	    formToolkit.adapt(btnRemove, true, true);
	    btnRemove.setText("Remove");

	    first = new Text(shell, SWT.BORDER);
	    first.setBounds(74, 47, 118, 21);
	    formToolkit.adapt(first, true, true);
	    
	    last = new Text(shell, SWT.BORDER);
	    last.setBounds(74, 74, 118, 21);
	    formToolkit.adapt(last, true, true);
	    
	    id = new Text(shell, SWT.BORDER);
	    id.setBounds(74, 101, 118, 21);
	    formToolkit.adapt(id, true, true);
	    
	    major = new Text(shell, SWT.BORDER);
	    major.setBounds(74, 128, 118, 21);
	    formToolkit.adapt(major, true, true);
	    
	    Label lblFirstName = new Label(shell, SWT.NONE);
	    lblFirstName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	    lblFirstName.setBounds(10, 53, 55, 15);
	    formToolkit.adapt(lblFirstName, true, true);
	    lblFirstName.setText("First name");
	    
	    Label lblLastName = new Label(shell, SWT.NONE);
	    lblLastName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	    lblLastName.setBounds(10, 80, 55, 15);
	    formToolkit.adapt(lblLastName, true, true);
	    lblLastName.setText("Last name");
	    
	    Label lblNewLabel = new Label(shell, SWT.NONE);
	    lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	    lblNewLabel.setBounds(10, 107, 55, 15);
	    formToolkit.adapt(lblNewLabel, true, true);
	    lblNewLabel.setText("ID");
	    
	    Label lblMajor = new Label(shell, SWT.NONE);
	    lblMajor.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	    lblMajor.setBounds(10, 131, 55, 15);
	    formToolkit.adapt(lblMajor, true, true);
	    lblMajor.setText("Major");
	    
	    Button btnSearch = new Button(shell, SWT.NONE);
	    btnSearch.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		ArrayList<String> search = new ArrayList<String>();
	    		if (first.getText().isEmpty() && last.getText().isEmpty() && id.getText().isEmpty() && major.getText().isEmpty()) {
	    			MessageBox ee = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
	    			ee.setText("Empty fields");
	    			ee.setMessage("Please fill atleast one search field.");
	    			ee.open();
	    		}
	    		else {
	    			if (!first.getText().isEmpty()) {
	    				search.add(first.getText());
	    			}
	    			if (!last.getText().isEmpty()) {
	    				search.add(last.getText());
	    			}
	    			if (!id.getText().isEmpty()) { 
	    				search.add(id.getText());
	    			}
	    			if (!major.getText().isEmpty()) {
	    				search.add(major.getText());
	    			}
	    			ArrayList<String> result = new ArrayList<String>();
	    			try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
	    				String all;
	    			
	    				while ((all = br.readLine()) != null) { 
	    					for (String s : search) { 
	    						if (all.toLowerCase().contains(s.toLowerCase())) { 
	    							result.add(all);
	    						}
	    					}
	    				}
	    			
	    			}
	    			catch (IOException ee) { 
	    				MessageBox er = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
	    				er.setText("Error!");
	    				er.setMessage("Data file is not created yet!");
	    				er.open();
	    			}
	    			HashSet<String> kk = new HashSet<String>();
	    			kk.addAll(result);
	    			ArrayList<String> remove = new ArrayList<String>();
	    			result.clear();
	    			result.addAll(kk);
	    			for (String s : result) { 
	    				for (String d : search) {
	    					if (!s.toLowerCase().contains(d.toLowerCase())) { 
	    						remove.add(s);
	    					}
	    				}
	    			}
	    			for (String k : remove) {
	    				for (int i = 0; i < result.size(); i++) {
	    					if (result.get(i).toLowerCase().equals(k.toLowerCase())) {
	    						result.remove(i);
	    					}
	    				}
	    			}
	    			table.removeAll();
	    			String titles[] = { "No." , "ID" , "First Name" , "Last Name" , "Major" };
	    			int no = 1;
	    			for (String d : result) {
	    				String[] test1 = d.split("\\,");
	    				TableItem item = new TableItem(table, SWT.NONE);
	    				item.setText(0, Integer.toString(no));
	    				item.setText(1, test1[0]);
	    				item.setText(2, test1[1]);
	    				item.setText(3, test1[2]);
	    				item.setText(4, test1[3]);
	    				no++;
	    			}
	    			for (int i = 0; i < titles.length; i++) {
	    				table.getColumn(i).pack();
	    			}
	    			table.setSize(table.computeSize(SWT.DEFAULT, 400));
	    		
	    		}
	    	}
	    });
	    btnSearch.setBounds(33, 184, 75, 25);
	    formToolkit.adapt(btnSearch, true, true);
	    btnSearch.setText("Search");
	    
	    Label lblNewLabel_1 = new Label(shell, SWT.NONE);
	    lblNewLabel_1.setBounds(33, 275, 190, 177);
	    formToolkit.adapt(lblNewLabel_1, true, true);
	    lblNewLabel_1.setText("This is where we view all students,\nsearch for particular students,\nremove students, and \nclear the table.");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(656, 467);
		shell.setText("View Students");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				showAll();
				
			}
		});
		btnNewButton.setBounds(33, 215, 75, 25);
		formToolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("Show all");
		
		table = formToolkit.createTable(shell, SWT.NONE | SWT.MULTI | SWT.FULL_SELECTION);
		table.setBounds(303, 35, 315, 454);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Button btnClear = formToolkit.createButton(shell, "Clear", SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
			}
		});
		btnClear.setBounds(117, 215, 75, 25);
		String titles[] = { "No." , "ID" , "First Name" , "Last Name" , "Major" };
		for (int i = 0; i < titles.length; i++) {
			 TableColumn column = new TableColumn(table, SWT.NONE);
		      column.setText(titles[i]);
		}
		
	

	}
	public static void showAll() { 
		table.removeAll();
		String titles[] = { "No." , "ID" , "First Name" , "Last Name" , "Major" };
		
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			String temp;
			int no = 1;
			while ((temp = br.readLine()) != null) {
				String[] test = temp.split("\\,");
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, Integer.toString(no));
				item.setText(1, test[0]);
				item.setText(2, test[1]);
				item.setText(3, test[2]);
				item.setText(4, test[3]);
				no++;
				
			}
			 for (int i = 0; i < titles.length; i++) {
			      table.getColumn(i).pack();
			    }
			 table.setSize(table.computeSize(SWT.DEFAULT, 400));
		}
		catch (IOException e1) {
			MessageBox er = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
			er.setText("Error!");
			er.setMessage("Data file is not created yet!");
			er.open();
		}
	}
}
