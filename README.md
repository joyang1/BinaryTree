## 二叉树(Binary Tree)定义:
二叉树是每个节点最多有两个子树的树结构。通常子树被称作“左子树”（left subtree）和“右子树”（right subtree）。二叉树常被用于实现二叉查找树和二叉堆。

二叉树的每个结点至多只有二棵子树(不存在度大于2的结点)，二叉树的子树有左右之分，次序不能颠倒。二叉树的第i层至多有2^{i-1}个结点；深度为k的二叉树至多有2^k-1个结点；对任何一棵二叉树T，如果其终端结点数为n_0，度为2的结点数为n_2，则n_0=n_2+1。

一棵深度为k，且有2^k-1个节点称之为满二叉树；深度为k，有n个节点的二叉树，当且仅当其每一个节点都与深度为k的满二叉树中，序号为1至n的节点对应时，称之为完全二叉树。

## Create Binary Tree Using Java

```sh
//arrs为放入到树节点的数据，demo中将int类型的数据置入节点中
public List<TreeNode> initTree(int[] arrs) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int data : arrs) {
			nodes.add(new TreeNode(data));
		}
		//此处每个父节点的index < (arrs.length / 2 - 1)是确保每个父节点的左右子节点都存在 
		for (int parentIndex = 0; parentIndex < arrs.length / 2 - 1; parentIndex++) {
			nodes.get(parentIndex).leftNode = nodes.get(parentIndex * 2 + 1);
			nodes.get(parentIndex).rightNode = nodes.get(parentIndex * 2 + 2); 
		}
		//(arrs.length / 2 - 1)最后一个父节点，通过二叉树的定义可知		
                int lastParentIndex = arrs.length / 2 - 1;
		nodes.get(lastParentIndex).leftNode = nodes.get(lastParentIndex * 2 + 1);
		//arrs.length % 2 != 0,作为判断最后一个父节点的右子节点是否存在的判断条件		
                if(arrs.length % 2 != 0){
			nodes.get(lastParentIndex).rightNode = nodes.get(lastParentIndex * 2 + 2);
		}
		return nodes;
}
```
上述方法中提到的TreeNode对象在code(src.test.TreeNode)中可以查看。

##三种遍历方式

(1). 先序遍历
(2). 中序遍历
(3). 后序遍历
三种遍历方式，也就是遍历的顺序不一样。
先序遍历: "根左右"，遍历的顺序: 根节点->左节点->右节点。
中序遍历: "左根右"，遍历的顺序: 左节点->根节点->右节点。
后序遍历: "左右根"，遍历的顺序: 左节点->右节点->根节点。

##先序遍历

```sh
	/*
	 * 先序遍历二叉树： 根左右
	 * 
	 * @param node
	 *       遍历的节点
	 * */
	public void preOrderTraverse(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.data + " "); //第一次进来是rootNode
		preOrderTraverse(node.leftNode);  //递归输出左节点		
                preOrderTraverse(node.rightNode); //递归输出右节点
	}
```

##中序遍历

```sh
	/*
	 * 中序遍历二叉树： 左根右
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
```
##后序遍历

```sh
	/*
	 * 后序遍历二叉树： 左右根
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
```
