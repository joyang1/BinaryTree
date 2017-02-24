package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	public List<TreeNode> initTree(int[] arrs) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int data : arrs) {
			nodes.add(new TreeNode(data));
		}
		//arrs.length / 2 - 1是确保最后一个节点的左右子节点都存在 
		for (int parentIndex = 0; parentIndex < arrs.length / 2 - 1; parentIndex++) {
			nodes.get(parentIndex).leftNode = nodes.get(parentIndex * 2 + 1);
			nodes.get(parentIndex).rightNode = nodes.get(parentIndex * 2 + 2); 
		}
		
		int lastParentIndex = arrs.length / 2 - 1;
		nodes.get(lastParentIndex).leftNode = nodes.get(lastParentIndex * 2 + 1);
		if(arrs.length % 2 != 0){
			nodes.get(lastParentIndex).rightNode = nodes.get(lastParentIndex * 2 + 2);
		}
		return nodes;
	}
	
	/*
	 * 先序遍历二叉树： 根左右
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void preOrderTraverse(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraverse(node.leftNode);
		preOrderTraverse(node.rightNode);
	}
	
//	public void preOrderTraverse1(List<TreeNode> nodes){
//		for (TreeNode node : nodes) {
//			
//		}
//	}
	
	/*
	 * 中序遍历二叉树： 左根右
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void inOrderTraverse(TreeNode node){
		if(node == null)
			return;
		inOrderTraverse(node.leftNode);
		System.out.print(node.data + " ");
		inOrderTraverse(node.rightNode);
	}
	
	/*
	 * 后序遍历二叉树： 左右根
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void afterOrderTraverse(TreeNode node){
		if(node == null)
			return;
		afterOrderTraverse(node.leftNode);
		afterOrderTraverse(node.rightNode);
		System.out.print(node.data + " ");
	}
}
