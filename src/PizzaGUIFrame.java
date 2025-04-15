import javax.swing.*;
import java.awt.*;

public class PizzaGUIFrame extends JFrame {
    static UserChoices userChoices = new UserChoices();
    int baseCost = 0;
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
        JPanel crustMenu = new JPanel(new BorderLayout());
        JPanel crustButtons = new JPanel(new BorderLayout());
        JPanel sizeMenu = new JPanel(new BorderLayout());
        JPanel toppingMenu = new JPanel(new GridLayout(3, 3));
        crustMenu.setBorder(BorderFactory.createSoftBevelBorder(0));
        sizeMenu.setBorder(BorderFactory.createSoftBevelBorder(0));
        toppingMenu.setBorder(BorderFactory.createSoftBevelBorder(0));
        commandPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // elements
        // - meta
        Font headerFont = new Font("Verdana", Font.BOLD, 18);

        // - crust
        JLabel crustHeader = new JLabel("CRUST");
        crustHeader.setFont(headerFont);
        JRadioButton crustSelectThinButton = new JRadioButton("Thin");
        JRadioButton crustSelectRegularButton = new JRadioButton("Regular (+$1.00)");
        JRadioButton crustSelectDeepButton = new JRadioButton("Deep-dish (+$2.00)");
        ButtonGroup crustSelectionGroup = new ButtonGroup();
        crustHeader.setHorizontalAlignment(SwingConstants.LEFT);
        crustSelectionGroup.add(crustSelectThinButton);
        crustSelectionGroup.add(crustSelectRegularButton);
        crustSelectionGroup.add(crustSelectDeepButton);

        // - size
        String[] sizeChoice = {"- - select - -", "Small - $8.00", "Medium - $12.00", "Large - $16.00", "Super - $20.00"};
        JLabel sizeHeader = new JLabel("SIZE");
        JComboBox<String> sizeBox = new JComboBox<>(sizeChoice);
        sizeHeader.setFont(headerFont);
        sizeHeader.setHorizontalAlignment(SwingConstants.LEFT);

        // - topping
        JLabel toppingLabel = new JLabel("TOPPINGS");
        JLabel toppingCostLabel = new JLabel("+$1.00 per topping");
        toppingLabel.setFont(headerFont);
        JCheckBox extraCheese = new JCheckBox("Extra cheese");
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox mushroom = new JCheckBox("Mushrooms");
        JCheckBox anchovies = new JCheckBox("Anchovies");
        JCheckBox pineapple = new JCheckBox("Pineapple");
        JCheckBox aluminumFoil = new JCheckBox("Aluminum foil");

        // - commands
        JButton orderButton = new JButton("Order!");
        orderButton.addActionListener(_ -> {
            System.out.println("order button pressed");

            if (crustSelectionGroup.getSelection() != null) {
                if (crustSelectThinButton.isSelected()) {
                    userChoices.setCrustSelection("thin");
                } else if (crustSelectRegularButton.isSelected()) {
                    userChoices.setCrustSelection("regular");
                    baseCost++;

                } else if (crustSelectDeepButton.isSelected()) {
                    userChoices.setCrustSelection("deep-dish");
                    baseCost += 2;
                }
                if (sizeBox.getSelectedIndex() != 0) {
                    if (sizeBox.getSelectedIndex() == 1) {
                        userChoices.setSizeSelection("Small");
                        baseCost += 8;
                    } else if (sizeBox.getSelectedIndex() == 2) {
                        userChoices.setSizeSelection("Medium");
                        baseCost += 12;
                    } else if (sizeBox.getSelectedIndex() == 3) {
                        userChoices.setSizeSelection("Large");
                        baseCost += 16;
                    } else if (sizeBox.getSelectedIndex() == 4) {
                        userChoices.setSizeSelection("Super");
                        baseCost += 20;
                    }
                    userChoices.setCheeseSelected(extraCheese.isSelected());
                    userChoices.setPepperoniSelected(pepperoni.isSelected());
                    userChoices.setMushroomSelected(mushroom.isSelected());
                    userChoices.setAnchoviesSelected(anchovies.isSelected());
                    userChoices.setPineappleSelected(pineapple.isSelected());
                    userChoices.setAluminumFoilSelected(aluminumFoil.isSelected());
                    userChoices.setBaseCost(baseCost);
                    JFrame orderFrame = new OrderFrame();   // To anyone reading this: please don't make the same mistake I did where I set the changes to the userChoices instance *AFTER* creating the OrderFrame. So many hours of pulling my hair out just from that :P
                } else {
                    JOptionPane.showMessageDialog(null, "No size was selected.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No crust was selected.");
            }
            baseCost = 0;
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(_ -> {
            System.out.println("clear button pressed");
            crustSelectionGroup.clearSelection();
            sizeBox.setSelectedIndex(0);
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
        container.add(orderForm, BorderLayout.CENTER);
        orderForm.add(northMenu);
        orderForm.add(southMenu);
        orderForm.add(commandPanel);
        northMenu.add(crustMenu);
        northMenu.add(sizeMenu);
        crustMenu.add(crustHeader, BorderLayout.NORTH);
        crustMenu.add(crustButtons, BorderLayout.CENTER);
        crustButtons.add(crustSelectThinButton, BorderLayout.NORTH);
        crustButtons.add(crustSelectRegularButton, BorderLayout.CENTER);
        crustButtons.add(crustSelectDeepButton, BorderLayout.SOUTH);
        sizeMenu.add(sizeHeader, BorderLayout.NORTH);
        sizeMenu.add(sizeBox, BorderLayout.CENTER);
        southMenu.add(toppingMenu);
        toppingMenu.add(toppingLabel);
        toppingMenu.add(toppingCostLabel);
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
