package oop;

import java.awt.*;
import java.awt.event.*;

public class GUI {

    public static void main(String[] args) {
        // AWT basic learning
        //new AWT1();
        //new AWT2();
        //new AWT3();
        
        // AWT layout management
        //new Layout().FlowLayoutPractice();
        //new Layout().BorderLayoutPractice();
        //new Layout().GridLayoutPractice();
        //new Layout().CardLayout();
        //new Layout().GridBagLayoutPractice();
        new Components();
    }
}

// Normal basic to understand GUI.
class AWT1 {
    
    Frame frame;
    Label label;
    Button button;
    
    public AWT1() {
        // Create a frame (window)
        frame = new Frame("Simple AWT Example");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout()); // Set the layout manager

        // Create a label
        label = new Label("Hello, AWT!");
        frame.add(label);

        // Create a button
        button = new Button("Click Me");
        frame.add(button);

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Add a window listener to handle the close operation
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose(); // Closes the window
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}

// Action performed, implementing ActionListener
// Window closing, implementing WindowListener
class AWT2 implements ActionListener, WindowListener {

    Frame frame;
    Label label;
    Button button;
    
    public AWT2() {
        // Create a frame (window)
        frame = new Frame("Simple AWT Example");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout()); // Set the layout manager

        // Create a label
        label = new Label("Hello, AWT!");
        frame.add(label);

        // Create a button
        button = new Button("Click Me");
        frame.add(button);

        // Add an action listener to the button
        button.addActionListener(this);
        // Add a window listener to handle the close operation
        frame.addWindowListener(this);

        // Make the frame visible
        frame.setVisible(true);
    }

    
    // Astract method of ActionListener
    @Override 
    public void actionPerformed(ActionEvent ae) { 
        label.setText("Button Clicked!");
    }

    // Astract method of WindowListener
    @Override
    public void windowOpened(WindowEvent we) { }
    @Override
    public void windowClosing(WindowEvent we) { 
        we.getWindow().dispose();
    }
    @Override
    public void windowClosed(WindowEvent we) { }
    @Override
    public void windowIconified(WindowEvent we) { }
    @Override
    public void windowDeiconified(WindowEvent we) { }
    @Override
    public void windowActivated(WindowEvent we) { }
    @Override
    public void windowDeactivated(WindowEvent we) { }
    
}

// Window closing, extending WindowAdapter
class AWT3 extends WindowAdapter implements ActionListener {

    Frame frame;
    Label label;
    Button button;
    
    public AWT3() {
        // Create a frame (window)
        frame = new Frame("Simple AWT Example");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout()); // Set the layout manager

        // Create a label
        label = new Label("Hello, AWT!");
        frame.add(label);

        // Create a button
        button = new Button("Click Me");
        frame.add(button);

        // Add an action listener to the button
        button.addActionListener(this);
        // Add a window listener to handle the close operation
        frame.addWindowListener(this);

        // Make the frame visible
        frame.setVisible(true);
    }

    
    // Astract method of ActionListener
    @Override 
    public void actionPerformed(ActionEvent ae) { 
        label.setText("Button Clicked!");
    }

    public void windowClosing(WindowEvent we) {
        we.getWindow().dispose();
    }
}

//------------------------------------------------Layout management
class Layout {
    
    Frame frame;

    public Layout() {
        frame = new Frame("Layout");
                // Close operation
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    //This layout arranges components in a line (left-to-right) and wraps them to the next line if there isn’t enough horizontal space. It’s the default layout for panels.
    public void FlowLayoutPractice() {
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Adding buttons to the frame
        frame.add(new Button("Button 1"));
        frame.add(new Button("Button 2"));
        frame.add(new Button("Button 3"));
        
        frame.setVisible(true);
    }
    
    //BorderLayout divides the container into five regions: NORTH, SOUTH, EAST, WEST, and CENTER. Each region can contain only one component, and the center region expands to fill any remaining space.
    public void BorderLayoutPractice() {
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Adding buttons to different regions
        frame.add(new Button("North"), BorderLayout.NORTH);
        frame.add(new Button("South"), BorderLayout.SOUTH);
        frame.add(new Button("East"), BorderLayout.EAST);
        frame.add(new Button("West"), BorderLayout.WEST);
        frame.add(new Button("Center"), BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
    
    //GridLayout arranges components in a rectangular grid. Each cell in the grid has the same size, and components are added row by row.
    public void GridLayoutPractice() {
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns

        // Adding buttons to the grid
        for (int i = 1; i <= 6; i++) {
            frame.add(new Button("Button " + i));
        }
        
        frame.setVisible(true);
    }
    
    // CardLayout lets you stack components (like cards) and show only one at a time, similar to a deck of cards. It’s useful for creating tabbed interfaces or wizards.
    public void CardLayout() {
        frame.setSize(300, 200);
        CardLayout cardLayout = new CardLayout();
        frame.setLayout(cardLayout);

        // Creating panels as cards
        Panel card1 = new Panel();
        card1.add(new Label("Card 1"));
        card1.add(new Button("Go to Card 2"));

        Panel card2 = new Panel();
        card2.add(new Label("Card 2"));
        card2.add(new Button("Go to Card 1"));

        // Adding panels to the frame
        frame.add(card1, "Card 1");
        frame.add(card2, "Card 2");

        // Button actions to switch cards
        ((Button) card1.getComponent(1)).addActionListener(e -> cardLayout.show(frame, "Card 2"));
        ((Button) card2.getComponent(1)).addActionListener(e -> cardLayout.show(frame, "Card 1"));
        
        frame.setVisible(true);
    }
    
    //GridBagLayout is the most flexible and complex layout manager in AWT. It arranges components in a grid but allows for varying row/column sizes and components to span multiple rows or columns.
    public void GridBagLayoutPractice() {
        frame = new Frame("GridBagLayout Example");
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Button btn1 = new Button("Button 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        frame.add(btn1, gbc);

        Button btn2 = new Button("Button 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(btn2, gbc);

        Button btn3 = new Button("Button 3");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        frame.add(btn3, gbc);
        
        frame.setVisible(true);
    }
}

//-------------------Components of AWT
class Components {

    public Components() {
        test();
    }
    
    public void test() {
        // Create the main frame
        Frame frame = new Frame("AWT Components in Separate Panels");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(7, 1)); // 6 rows, 1 column

        // Panel for Button
        Panel buttonPanel = new Panel();
        Button button = new Button("Click Me");
        button.addActionListener(e -> System.out.println("Button clicked!"));
        buttonPanel.add(button);

        // Panel for Label
        Panel labelPanel = new Panel();
        Label label = new Label("Hello, AWT!");
        labelPanel.add(label);

        // Panel for TextField
        Panel textFieldPanel = new Panel();
        TextField textField = new TextField(20);
        textFieldPanel.add(textField);

        // Panel for TextArea
        Panel textAreaPanel = new Panel();
        TextArea textArea = new TextArea(3, 20);
        textAreaPanel.add(textArea);

        // Panel for Checkbox
        Panel checkBoxPanel = new Panel();
        Checkbox checkBox = new Checkbox("Accept Terms and Conditions");
        checkBoxPanel.add(checkBox);

        // Panel for Choice (Drop-Down List)
        Panel choicePanel = new Panel();
        Choice choice = new Choice();
        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");
        choicePanel.add(choice);

        // Add all panels to the frame
        frame.add(buttonPanel);
        frame.add(labelPanel);
        frame.add(textFieldPanel);
        frame.add(textAreaPanel);
        frame.add(checkBoxPanel);
        frame.add(choicePanel);
        
        // Create a MenuBar
        MenuBar menuBar = new MenuBar();

        // Create a Menu
        Menu fileMenu = new Menu("File");
        
        // Create MenuItems for the File menu
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");

        // Add MenuItems to the File menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Adds a separator line
        fileMenu.add(exitItem);

        // Add action listeners for menu items
        openItem.addActionListener(e -> System.out.println("Open selected"));
        saveItem.addActionListener(e -> System.out.println("Save selected"));
        exitItem.addActionListener(e -> frame.dispose());

        // Add File menu to the MenuBar
        menuBar.add(fileMenu);

        // Set the frame's MenuBar
        frame.setMenuBar(menuBar);

        // Set the frame's MenuBar
        frame.setMenuBar(menuBar);
        
        // Create a Dialog
        Dialog dialog = new Dialog(frame, "Dialog Example", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new FlowLayout());

        // Add a Label and a Close button to the Dialog
        Label dialogLabel = new Label("This is a dialog box!");
        Button closeDialogButton = new Button("Close");
        dialog.add(dialogLabel);
        dialog.add(closeDialogButton);

        // Close button action for the dialog
        closeDialogButton.addActionListener(e -> dialog.setVisible(false));

        // Button to open the dialog
        Button openDialogButton = new Button("Open Dialog");
        openDialogButton.addActionListener(e -> dialog.setVisible(true));
        
        Panel dialogPanel = new Panel();
        dialogPanel.add(openDialogButton);
        frame.add(dialogPanel);

        // Add window listener to close the frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}