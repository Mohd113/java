package ktech1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;


public class Ttt {

	protected Shell shell;
	protected Text first;
	protected Text last;
	protected Text id;
	protected Combo combo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ttt window = new Ttt();
			
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
	    
	    combo = new Combo(shell, SWT.READ_ONLY);
	    combo.add("MIS");
	    combo.add("E-Commerce");
	    combo.add("Sales & Marketing");
	    combo.add("SAP");
	    combo.add("WAP");
	    combo.add("Network Design");
	    combo.add("Network Security");
	    combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	    combo.setBounds(143, 112, 143, 23);
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
		shell.setSize(417, 273);
		shell.setText("Add Students");
		
		first = new Text(shell, SWT.BORDER);
		first.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		first.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		first.setBounds(143, 31, 143, 21);
		
		Label lblFullName = new Label(shell, SWT.NONE);
		lblFullName.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblFullName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblFullName.setBounds(52, 34, 69, 15);
		lblFullName.setText("First Name");
		
		last = new Text(shell, SWT.BORDER);
		last.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		last.setBounds(143, 58, 143, 21);
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblId.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblId.setBounds(52, 64, 69, 15);
		lblId.setText("Last Name");
		
		id = new Text(shell, SWT.BORDER);
		id.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		id.setBounds(143, 85, 143, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(52, 91, 55, 15);
		lblNewLabel.setText("K-Tech ID");
		
		Label lblMajor = new Label(shell, SWT.NONE);
		lblMajor.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMajor.setBounds(52, 118, 55, 15);
		lblMajor.setText("Major");
		
		Button addButton = new Button(shell, SWT.NONE);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (first.getText() != "" && last.getText() != "" && id.getText() != "" && combo.getText() != "") {
				String test = id.getText() + "," + first.getText() + "," + last.getText() + "," + combo.getText();  
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt", true))) {
					bw.write(test);
					bw.newLine();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				MessageBox mb = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
				mb.setText("Saved.");
				mb.setMessage("Student was added");
				mb.open();
				}
				else { 
					MessageBox er = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
					er.setText("Error");
					er.setMessage("Please fill all required fields");
					er.open();
				}
				
			}
		});
		addButton.setBounds(147, 168, 55, 25);
		addButton.setText("Add");
		
		Button resetButton = new Button(shell, SWT.NONE);
		resetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				first.setText("");
				last.setText("");
				id.setText("");
				combo.deselectAll();
				
				
				
			}
		});
		resetButton.setBounds(222, 168, 55, 25);
		resetButton.setText("Reset");

	}
}
