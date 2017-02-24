package tree;

import java.util.List;

public class RunTest {
	public static void main(String[] args) {
		//假设二叉树中的数据为： 1,2,3,4,5,6,7,8,9从上到下，从左至右
		int[] arrs = new int[]{1,2,3,4,5,6,7,8,9};
		BinaryTree binaryTree = new BinaryTree();
		List<TreeNode> binaryTreeNodes = binaryTree.initTree(arrs);
		TreeNode rootNode = binaryTreeNodes.get(0);
		//先序遍历结果
		System.out.println("先序遍历结果: ");
		binaryTree.preOrderTraverse(rootNode);
		//中序遍历结果
		System.out.println("\n中序遍历结果: ");
		binaryTree.inOrderTraverse(rootNode);
		//后序遍历结果
		System.out.println("\n后序遍历结果: ");
		binaryTree.afterOrderTraverse(rootNode);		
	}	
}
