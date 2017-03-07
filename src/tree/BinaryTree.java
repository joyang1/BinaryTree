package tree;

import java.util.ArrayList;
import java.util.LinkedList;
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
	 * 使用递归
	 * 
	 * @param node
	 *      遍历的节点
	 * */
	public void preOrderTraverse(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraverse(node.leftNode);
		preOrderTraverse(node.rightNode);
	}
	
	/*
	 * 先序遍历二叉树： 根左右
	 * 
	 * 使用循环
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void preOrderTraverseByWhile(TreeNode node){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(node);
		TreeNode currentNode;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			System.out.print(currentNode.data + " ");
			if(currentNode.rightNode != null){
				stack.push(currentNode.rightNode);
			}
			if (currentNode.leftNode != null) {
				stack.push(currentNode.leftNode);
			}
		}
	}
	
	/*
	 * 中序遍历二叉树： 左根右
	 * 
	 * 使用递归
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void inOrderTraverse(TreeNode node){
		if(node == null)
			return;
		inOrderTraverse(node.leftNode); //递归输出左节点
		System.out.print(node.data + " "); 
		inOrderTraverse(node.rightNode); //递归输出右节点
	}
	
	/*
	 * 中序遍历二叉树： 左根右
	 * 
	 * 使用循环
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void inOrderTraverseByWhile(TreeNode node){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode currentNode = node;
		while (currentNode != null || !stack.isEmpty()) {
			while(currentNode != null){
				stack.push(currentNode);
				currentNode = currentNode.leftNode;
			}
			if(!stack.isEmpty()){
				currentNode = stack.pop();
				System.out.print(currentNode.data + "");
				currentNode = currentNode.rightNode;
			}
		}
	}
	
	/*
	 * 后序遍历二叉树： 左右根
	 * 
	 *  使用递归
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void afterOrderTraverse(TreeNode node){
		if(node == null)
			return;
		afterOrderTraverse(node.leftNode);//递归输出左节点
		afterOrderTraverse(node.rightNode);//递归输出右节点
		System.out.print(node.data + " ");
	}
	
	/*
	 * 后序遍历二叉树： 左右根
	 * 
	 *  使用循环
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void afterOrderTraverseByWhile(TreeNode node){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode rightNode = null;
		TreeNode currentNode = node;
		while (currentNode != null || !stack.isEmpty()) {
			while(currentNode != null){
				stack.push(currentNode);
				currentNode = currentNode.leftNode;
			}
			currentNode = stack.pop();
			//当上一个访问的结点是右孩子或者当前结点没有右孩子则访问当前结点
			while(currentNode != null && (currentNode.rightNode == null || currentNode.rightNode == rightNode)){
				System.out.print(currentNode.data + " ");
				rightNode = currentNode;
				if(stack.isEmpty()){
					return;
				}
				currentNode = stack.pop();
			}
			stack.push(currentNode);
			currentNode = currentNode.rightNode;
		}
	}
}
