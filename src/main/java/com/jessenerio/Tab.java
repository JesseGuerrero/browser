package com.jessenerio;

import org.cef.browser.CefBrowser;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import static java.awt.Component.LEFT_ALIGNMENT;

public class Tab {

	JButton tabButton;
	JButton closeButton;
	CefBrowser browser;

	public Tab(JPanel tabMenu, CefBrowser browser) {
		this.browser = browser;
		this.tabButton = new JButton();
		this.closeButton = new JButton("X");
		tabButton.setAlignmentX(LEFT_ALIGNMENT);
		tabMenu.add(tabButton);
		tabMenu.add(closeButton);
		tabMenu.add(Box.createHorizontalStrut(8));
	}

	public void updateTitle(String title) {
		tabButton.setText(title);
	}
}
