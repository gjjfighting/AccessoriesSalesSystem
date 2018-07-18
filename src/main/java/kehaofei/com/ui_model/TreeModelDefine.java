package kehaofei.com.ui_model;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.springframework.ui.Model;

public class TreeModelDefine extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static List<Model> MeterList;

	public TreeModelDefine(Object userObject) {

		this.getTreeList();
	}

	private void getTreeList() {
		for(int i=0; i<10 ; i++){
			
		}
	}
	
	

}
