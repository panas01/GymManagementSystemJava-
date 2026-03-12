package GYM_CW;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GymGUI extends JFrame {
    private ArrayList<GymMember> members;
    private JTextField idField, nameField, locationField, phoneField, emailField, referralSourceField, paidAmountField, removalReasonField, trainerNameField;
    private JTextField PriceField, premiumPlanChargeField, discountAmountField;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<String> planComboBox, dobDayCombo, dobMonthCombo, dobYearCombo, membershipDayCombo, membershipMonthCombo, membershipYearCombo;
    private JTextArea memberDetailsArea;

    public GymGUI() {
        members = new ArrayList<>();
        setTitle("Gym Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Main panel with two sub-panels (left for input, right for display)
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Left panel for input fields using GridBagLayout for alignment
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Initialize text fields with uniform size
        Dimension textFieldSize = new Dimension(200, 25);
        idField = new JTextField();
        nameField = new JTextField();
        locationField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        referralSourceField = new JTextField();
        paidAmountField = new JTextField();
        removalReasonField = new JTextField();
        trainerNameField = new JTextField();
        PriceField = new JTextField("6500");
        premiumPlanChargeField = new JTextField("50000");
        discountAmountField = new JTextField();

        // Set preferred size for all text fields
        JTextField[] textFields = {
            idField, nameField, locationField, phoneField, emailField, referralSourceField,
            paidAmountField, removalReasonField, trainerNameField, PriceField,
            premiumPlanChargeField, discountAmountField
        };
        for (JTextField field : textFields) {
            field.setPreferredSize(textFieldSize);
        }
        PriceField.setEditable(false);
        premiumPlanChargeField.setEditable(false);
        discountAmountField.setEditable(false);

        // Input fields with labels
        int row = 0;

        // ID
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(idField, gbc);
        row++;

        // Name
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("NAME:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);
        row++;

        // Location
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("LOCATION:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(locationField, gbc);
        row++;

        // Phone
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("PHONE:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(phoneField, gbc);
        row++;

        // Email
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("EMAIL:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(emailField, gbc);
        row++;

        // Gender
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("GENDER:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        inputPanel.add(genderPanel, gbc);
        row++;

        // DOB (using JComboBox)
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("DOB:"), gbc);
        gbc.gridx = 1;
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dobDayCombo = new JComboBox<>(generateDays());
        dobMonthCombo = new JComboBox<>(generateMonths());
        dobYearCombo = new JComboBox<>(generateYears());
        dobPanel.add(dobDayCombo);
        dobPanel.add(dobMonthCombo);
        dobPanel.add(dobYearCombo);
        inputPanel.add(dobPanel, gbc);
        row++;

        // Membership Start Date (using JComboBox)
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("MEMBERSHIP START DATE:"), gbc);
        gbc.gridx = 1;
        JPanel membershipStartPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        membershipDayCombo = new JComboBox<>(generateDays());
        membershipMonthCombo = new JComboBox<>(generateMonths());
        membershipYearCombo = new JComboBox<>(generateYears());
        membershipStartPanel.add(membershipDayCombo);
        membershipStartPanel.add(membershipMonthCombo);
        membershipStartPanel.add(membershipYearCombo);
        inputPanel.add(membershipStartPanel, gbc);
        row++;

        // Referral Source
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("REFERRAL SOURCE:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(referralSourceField, gbc);
        row++;

        // Paid Amount
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("PAID AMOUNT:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(paidAmountField, gbc);
        row++;

        // Removal Reason
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("REMOVAL REASON:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(removalReasonField, gbc);
        row++;

        // Trainer Name
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("TRAINER NAME:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(trainerNameField, gbc);
        row++;

        // Plan
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("PLAN:"), gbc);
        gbc.gridx = 1;
        planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        planComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPlan = planComboBox.getSelectedItem().toString().toLowerCase();
                RegularMember tempMember = new RegularMember(0, "", "", "", "", "", "", "", "");
                double price = tempMember.getPlanPrice(selectedPlan);
                PriceField.setText(String.valueOf(price));
            }
        });
        inputPanel.add(planComboBox, gbc);
        row++;

        // Regular Plan Price
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel(" PRICE:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(PriceField, gbc);
        row++;

        // Premium Plan Charge
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("PREMIUM PLAN CHARGE:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(premiumPlanChargeField, gbc);
        row++;

        // Discount Amount
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel("DISCOUNT AMOUNT:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(discountAmountField, gbc);
        row++;

        mainPanel.add(new JScrollPane(inputPanel));

        // Right panel for member details
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Member Details"));
        memberDetailsArea = new JTextArea();
        memberDetailsArea.setEditable(false);
        displayPanel.add(new JScrollPane(memberDetailsArea), BorderLayout.CENTER);
        mainPanel.add(displayPanel);

        add(mainPanel, BorderLayout.CENTER);

        // Bottom panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 8, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addRegularButton = new JButton("Add Regular Member");
        JButton addPremiumButton = new JButton("Add Premium Member");
        JButton activateButton = new JButton("Activate Membership");
        JButton deactivateButton = new JButton("Deactivate Membership");
        JButton markAttendanceButton = new JButton("Mark Attendance");
        JButton upgradePlanButton = new JButton("Upgrade Plan");
        JButton calculateDiscountButton = new JButton("Calculate Discount");
        JButton revertRegularButton = new JButton("Revert Regular Member");
        JButton revertPremiumButton = new JButton("Revert Premium Member");
        JButton payDueButton = new JButton("Pay Due Amount");
        JButton removeMemberButton = new JButton("Remove Member");
        JButton searchMemberButton = new JButton("Search Member");
        JButton displayAllButton = new JButton("Display All");
        JButton clearFieldsButton = new JButton("Clear Fields");
        JButton saveToFileButton = new JButton("Save to File");
        JButton readFromFileButton = new JButton("Read from File");

        // First row of buttons
        buttonPanel.add(addRegularButton);
        buttonPanel.add(addPremiumButton);
        buttonPanel.add(activateButton);
        buttonPanel.add(deactivateButton);
        buttonPanel.add(markAttendanceButton);
        buttonPanel.add(upgradePlanButton);
        buttonPanel.add(calculateDiscountButton);
        buttonPanel.add(revertRegularButton);

        // Second row of buttons
        buttonPanel.add(revertPremiumButton);
        buttonPanel.add(payDueButton);
        buttonPanel.add(removeMemberButton);
        buttonPanel.add(searchMemberButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(clearFieldsButton);
        buttonPanel.add(saveToFileButton);
        buttonPanel.add(readFromFileButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addRegularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    // Check for duplicate ID
                    for (GymMember member : members) {
                        if (member.getId() == id) {
                            JOptionPane.showMessageDialog(null, "Member ID already exists!");
                            return;
                        }
                    }
                    String name = nameField.getText();
                    String location = locationField.getText();
                    String phone = phoneField.getText();
                    String email = emailField.getText();
                    String gender = maleRadio.isSelected() ? "Male" : (femaleRadio.isSelected() ? "Female" : "");
                    String dob = dobDayCombo.getSelectedItem() + "/" + dobMonthCombo.getSelectedItem() + "/" + dobYearCombo.getSelectedItem();
                    String membershipStart = membershipDayCombo.getSelectedItem() + "/" + membershipMonthCombo.getSelectedItem() + "/" + membershipYearCombo.getSelectedItem();
                    String referralSource = referralSourceField.getText();
                    String selectedPlan = planComboBox.getSelectedItem().toString().toLowerCase();

                    if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || referralSource.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all required fields!");
                        return;
                    }

                    RegularMember member = new RegularMember(id, name, location, phone, email, gender, dob, membershipStart, referralSource);
                    if (!selectedPlan.equals("basic")) {
                        member.upgradePlan(selectedPlan);
                    }
                    members.add(member);
                    PriceField.setText(String.valueOf(member.getPrice()));
                    JOptionPane.showMessageDialog(null, "Regular Member added successfully!");
                    clearFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        addPremiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    // Check for duplicate ID
                    for (GymMember member : members) {
                        if (member.getId() == id) {
                            JOptionPane.showMessageDialog(null, "Member ID already exists!");
                            return;
                        }
                    }
                    String name = nameField.getText();
                    String location = locationField.getText();
                    String phone = phoneField.getText();
                    String email = emailField.getText();
                    String gender = maleRadio.isSelected() ? "Male" : (femaleRadio.isSelected() ? "Female" : "");
                    String dob = dobDayCombo.getSelectedItem() + "/" + dobMonthCombo.getSelectedItem() + "/" + dobYearCombo.getSelectedItem();
                    String membershipStart = membershipDayCombo.getSelectedItem() + "/" + membershipMonthCombo.getSelectedItem() + "/" + membershipYearCombo.getSelectedItem();
                    String trainerName = trainerNameField.getText();

                    if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || trainerName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all required fields!");
                        return;
                    }

                    PremiumMember member = new PremiumMember(id, name, location, phone, email, gender, dob, membershipStart, trainerName);
                    members.add(member);
                    JOptionPane.showMessageDialog(null, "Premium Member added successfully!");
                    clearFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id) {
                            member.activateMembership();
                            JOptionPane.showMessageDialog(null, "Membership activated!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id) {
                            if (!member.getActiveStatus()) {
                                JOptionPane.showMessageDialog(null, "Membership is already deactivated!");
                                return;
                            }
                            member.deactivateMembership();
                            JOptionPane.showMessageDialog(null, "Membership deactivated!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id) {
                            if (!member.getActiveStatus()) {
                                JOptionPane.showMessageDialog(null, "Membership is not active! Please activate first.");
                                return;
                            }
                            member.markAttendance();
                            JOptionPane.showMessageDialog(null, "Attendance marked!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        upgradePlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String newPlan = planComboBox.getSelectedItem().toString().toLowerCase();
                    for (GymMember member : members) {
                        if (member.getId() == id && member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            String result = regularMember.upgradePlan(newPlan);
                            PriceField.setText(String.valueOf(regularMember.getPrice()));
                            JOptionPane.showMessageDialog(null, result);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found or not a Regular Member!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        calculateDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id && member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;
                            premiumMember.calculateDiscount();
                            discountAmountField.setText(String.valueOf(premiumMember.getDiscountAmount()));
                            JOptionPane.showMessageDialog(null, "Discount calculated!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found or not a Premium Member!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        revertRegularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String removalReason = removalReasonField.getText();
                    if (removalReason.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please provide a removal reason!");
                        return;
                    }
                    for (GymMember member : members) {
                        if (member.getId() == id && member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            regularMember.revertRegularMember(removalReason);
                            PriceField.setText("6500");
                            JOptionPane.showMessageDialog(null, "Regular Member reverted!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found or not a Regular Member!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        revertPremiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id && member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;
                            premiumMember.revertPremiumMember();
                            discountAmountField.setText("");
                            JOptionPane.showMessageDialog(null, "Premium Member reverted!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found or not a Premium Member!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        payDueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    double paidAmount = Double.parseDouble(paidAmountField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id && member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;
                            String result = premiumMember.payDueAmount(paidAmount);
                            JOptionPane.showMessageDialog(null, result);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found or not a Premium Member!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers for ID and Paid Amount.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        removeMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (int i = 0; i < members.size(); i++) {
                        if (members.get(i).getId() == id) {
                            members.remove(i);
                            JOptionPane.showMessageDialog(null, "Member removed!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        searchMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getId() == id) {
                            memberDetailsArea.setText(member.display());
                            JOptionPane.showMessageDialog(null, "Member found! Check the Member Details area.");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Member ID not found!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID! Please enter a number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memberDetailsArea.setText("");
                if (members.isEmpty()) {
                    memberDetailsArea.setText("No members to display.");
                    return;
                }
                for (GymMember member : members) {
                    memberDetailsArea.append(member.display());
                    memberDetailsArea.append("------------------------\n");
                }
            }
        });

        clearFieldsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Save to File functionality is not implemented.");
            }
        });

        readFromFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Read from File functionality is not implemented.");
            }
        });

        setVisible(true);
    }

    // Helper methods to generate date components
    private String[] generateDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.format("%02d", i);
        }
        return days;
    }

    private String[] generateMonths() {
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = String.format("%02d", i);
        }
        return months;
    }

    private String[] generateYears() {
        int currentYear = 2025;
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        return years;
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        dobDayCombo.setSelectedIndex(0);
        dobMonthCombo.setSelectedIndex(0);
        dobYearCombo.setSelectedIndex(0);
        membershipDayCombo.setSelectedIndex(0);
        membershipMonthCombo.setSelectedIndex(0);
        membershipYearCombo.setSelectedIndex(0);
        referralSourceField.setText("");
        paidAmountField.setText("");
        removalReasonField.setText("");
        trainerNameField.setText("");
        discountAmountField.setText("");
        planComboBox.setSelectedIndex(0);
        PriceField.setText("6500");
    }

    public static void main(String[] args) {
        new GymGUI();
    }
}