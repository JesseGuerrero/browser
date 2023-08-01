// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package com.jessenerio.ui;

import com.jessenerio.Tab;
import org.cef.OS;
import org.cef.browser.CefBrowser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TabsPanel extends JPanel {
	private final int currentTab;
	private final int maxTabs = 10;
	private final List<Tab> tabs = new ArrayList<Tab>();

    public TabsPanel(CefBrowser browser) {
        assert browser != null;
		currentTab = 0;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
		add(Box.createHorizontalStrut(5));
		add(Box.createHorizontalStrut(5));
		add(new JButton("+"));
		add(Box.createHorizontalStrut(5));
		add(Box.createHorizontalStrut(5));
		tabs.add(new Tab(this, browser));

    }

	public void updateTitle(String title) {
		Tab currentTab = tabs.get(this.currentTab);
		currentTab.updateTitle(title);
	}


}
