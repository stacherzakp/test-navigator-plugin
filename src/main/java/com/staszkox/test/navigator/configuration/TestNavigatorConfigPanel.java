package com.staszkox.test.navigator.configuration;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

class TestNavigatorConfigPanel
{
    private JPanel panel;
    private JTextField suffixesTextField;

    TestNavigatorConfigPanel(String actualSuffixes)
    {
        setUp(actualSuffixes);
    }

    private void setUp(String actualSuffixes)
    {
        panel = new JPanel(new GridLayoutManager(3, 2, JBUI.emptyInsets(), -1, -1));
        panel.setRequestFocusEnabled(true);

        final JLabel suffixesLabel = new JLabel("Test class suffixes:");
        panel.add(suffixesLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(80, 16), null, 0, false));

        suffixesTextField = new JTextField();
        suffixesTextField.setAutoscrolls(true);
        suffixesTextField.setEditable(true);
        suffixesTextField.setEnabled(true);
        suffixesTextField.setHorizontalAlignment(10);
        suffixesTextField.setText(actualSuffixes);
        panel.add(suffixesTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        final JLabel fieldDescription = new JLabel();
        fieldDescription.setText("Delimit possible test class suffixes with a comma (e.g. \"Test, TestLong, IT\").");
        fieldDescription.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(fieldDescription, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        suffixesLabel.setLabelFor(suffixesTextField);
    }

    JPanel getPanel()
    {
        return panel;
    }

    String getSuffixes()
    {
        return suffixesTextField.getText();
    }

    void setSuffixes(String suffixes)
    {
        suffixesTextField.setText(suffixes);
    }
}
