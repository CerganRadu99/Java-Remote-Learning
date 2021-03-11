package com.iquestgroup.remotelearning.week5.w5p4.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Display {

  private JFrame frame;
  private JTextArea textArea;
  private JScrollPane scrollPane;

  public Display() {
    configureTextArea();
  }

  public JTextArea getTextArea() {
    return textArea;
  }

  public void configureFrame() {
    frame = new JFrame("Converted sentences");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    frame.getContentPane().setBackground(new Color(200, 200, 200));
    frame.setLayout(new FlowLayout());
    frame.add(scrollPane);
  }

  public void configureTextArea() {
    textArea = new JTextArea();
    textArea.setBounds(50, 50, 500, 300);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setBackground(new Color(200, 200, 200));
    textArea.setBorder(BorderFactory.createBevelBorder(1));
    textArea.setForeground(new Color(55, 55, 55));
    textArea.setFont(new Font("Comic Sans", Font.ITALIC, 15));
    textArea.setEditable(false);
  }

  public void configurePanel() {
    scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 300));
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  }

  public void showFrame() {
    frame.setVisible(true);
  }
}