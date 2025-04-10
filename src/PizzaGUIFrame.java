import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PizzaGUIFrame extends JFrame {
    public PizzaGUIFrame() {
        // window sizing
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 4, screenSize.height / 4);
        setSize(400, 400);

        // panels
        JPanel container = new JPanel(new BorderLayout());
        JPanel orderForm = new JPanel(new GridLayout(3, 1));
        JPanel northMenu = new JPanel(new GridLayout(1, 2));
        JPanel southMenu = new JPanel(new GridLayout(1, 1));
        JPanel commandPanel = new JPanel(new GridLayout(2, 3));
        JPanel headerA = new JPanel(new BorderLayout());
        JPanel crustHead = new JPanel();
        JPanel sizeHead = new JPanel();
        JPanel crustMenu = new JPanel(new BorderLayout());
        JPanel crustButtons = new JPanel(new BorderLayout());
        JPanel sizeMenu = new JPanel(new BorderLayout());
        JPanel toppingMenu = new JPanel(new GridLayout(3, 3));
        crustMenu.setBorder(BorderFactory.createSoftBevelBorder(0));
        sizeMenu.setBorder(BorderFactory.createSoftBevelBorder(0));
        toppingMenu.setBorder(BorderFactory.createSoftBevelBorder(0));
        commandPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // elements
        // - meta
        Font headerFont = new Font("Verdana", Font.BOLD, 18);

        // - crust
        JLabel crustHeader = new JLabel("CRUST");
        crustHeader.setFont(headerFont);
        JRadioButton crustSelectThinButton = new JRadioButton("Thin");
        JRadioButton crustSelectRegularButton = new JRadioButton("Regular");
        JRadioButton crustSelectDeepButton = new JRadioButton("Deep-dish");
        ButtonGroup crustSelectionGroup = new ButtonGroup();
        crustHeader.setHorizontalAlignment(SwingConstants.LEFT);
        crustSelectionGroup.add(crustSelectThinButton);
        crustSelectionGroup.add(crustSelectRegularButton);
        crustSelectionGroup.add(crustSelectDeepButton);

        // - size
        String[] sizeChoice = {"- - select - -", "Small - $8.00", "Medium - $12.00", "Large - $16.00", "Super - $20.00"};
        JLabel sizeHeader = new JLabel("SIZE");
        JComboBox<String> sizeBox = new JComboBox(sizeChoice);
        sizeHeader.setFont(headerFont);
        sizeHeader.setHorizontalAlignment(SwingConstants.LEFT);

        // - topping
        JLabel toppingLabel = new JLabel("TOPPINGS");
        toppingLabel.setFont(headerFont);
        JCheckBox extraCheese = new JCheckBox("extra cheese");
        extraCheese.addActionListener(_ -> {
            System.out.println(extraCheese.isSelected());
        });
        JCheckBox pepperoni = new JCheckBox("pepperoni");
        JCheckBox mushroom = new JCheckBox("mushrooms");
        JCheckBox anchovies = new JCheckBox("anchovies");
        JCheckBox pineapple = new JCheckBox("pineapple");
        JCheckBox aluminumFoil = new JCheckBox("aluminum foil");

        // - commands
        JButton orderButton = new JButton("Order!");
        orderButton.addActionListener(_ -> {
            System.out.println("order button pressed");
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(_ -> {
            System.out.println("clear button pressed");
            extraCheese.setSelected(false);
            pepperoni.setSelected(false);
            mushroom.setSelected(false);
            anchovies.setSelected(false);
            pineapple.setSelected(false);
            aluminumFoil.setSelected(false);
        });
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(_ -> {
            int yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
            if (yn == 0) {
                System.exit(0);
            }
        });

        // add to panels
        /*
        container.add(orderForm, BorderLayout.CENTER);
        orderForm.add(northHeaders);
        orderForm.add(northMenu);
        northHeaders.add(crustHeader);
        northHeaders.add(sizeHeader);
        northMenu.add(crustSelectThinButton);
        northMenu.add(crustSelectRegularButton);
        northMenu.add(crustSelectDeepButton);

         */
        container.add(orderForm, BorderLayout.CENTER);
        orderForm.add(northMenu);
        orderForm.add(southMenu);
        orderForm.add(commandPanel);
        northMenu.add(crustMenu);
        northMenu.add(sizeMenu);      // wtf??
        crustMenu.add(crustHeader, BorderLayout.NORTH);
        crustMenu.add(crustButtons, BorderLayout.CENTER);
        crustButtons.add(crustSelectThinButton, BorderLayout.NORTH);
        crustButtons.add(crustSelectRegularButton, BorderLayout.CENTER);
        crustButtons.add(crustSelectDeepButton, BorderLayout.SOUTH);
        sizeMenu.add(sizeHeader, BorderLayout.NORTH);
        sizeMenu.add(sizeBox, BorderLayout.CENTER);
        southMenu.add(toppingMenu);
        toppingMenu.add(toppingLabel);
        toppingMenu.add(Box.createGlue());
        toppingMenu.add(Box.createGlue());
        toppingMenu.add(extraCheese);
        toppingMenu.add(pepperoni);
        toppingMenu.add(mushroom);
        toppingMenu.add(anchovies);
        toppingMenu.add(pineapple);
        toppingMenu.add(aluminumFoil);
        commandPanel.add(Box.createGlue());
        commandPanel.add(Box.createGlue());
        commandPanel.add(Box.createGlue());
        commandPanel.add(orderButton);
        commandPanel.add(clearButton);
        commandPanel.add(quitButton);

        add(container);
        // meta
        setVisible(true);
        setTitle("Pizza Order Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
