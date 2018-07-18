package kehaofei.com.ui.main;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.Box;

import java.awt.Scrollbar;
import java.awt.List;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;

import kehaofei.com.utils.Constant_Properties;

/**
 * ø’√Ê∞Â
 * @author XCCD
 *
 */
public class LeftView_ScrollPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField textField;

	/**
	 * Create the panel.
	 */
	public LeftView_ScrollPanel() {
		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("ParamSet")));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {95};
		gridBagLayout.rowHeights = new int[] {20, 20, 20, 20, 20, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.01, 0.01, 0.01, 0.01, 0.01, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.add("ZZZZZ", new JPanel());
		tabbedPane.add("ZZZZZ", new JPanel());
		tabbedPane.add("ZZZZZ", new JPanel());
		tabbedPane.add("ZZZZZ", new JPanel());
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		add(tabbedPane, gbc_tabbedPane);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
	}

}
