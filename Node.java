import java.util.ArrayList;
import java.util.Arrays;


public class Node {
	int depth = 0;
	Number num;
	Node lnode;
	Node  rnode;
 	Node parentNode;
	String printer =""; 
	int arrayplace = 0;
	ArrayList<Node> nodeList = new ArrayList<Node>();
	
	
	public void insertNode(Node node, Node parent)
	{
		//IF there is no nodes in the tree, start a fresh node in tree
		if(parent == null)
		{
			//System.out.println("Root Node = "+ node.getNum().getNumber());
			node.setDepth(depth);
			parentNode = null;
			nodeList.add(node);
			return;
		}
		//Check if it goes to left node
		if(node.getNum().getNumber() < parent.getNum().getNumber())
		{
			if(parent.getLNode() == null) {//Make sure child node is empty
				//System.out.println(node.getNum().getNumber()+" is LC of "+parent.getNum().getNumber());
				parent.setLNode(node);// set child node, this is for location
				node.setParent(parent);// set parent node for balancing
				node.setDepth(parent.getDepth()+1);// set depth for balance check
				//System.out.println(node.checkBalance(node));//print line for debug will comment out
				nodeList.add(node);
			}
			else insertNode(node, parent.getLNode());//If not, recursively call method
		}
		
		//Check if it goes in right node
		if(node.getNum().getNumber() > parent.getNum().getNumber())
		{
			if(parent.getRNode() == null) {//if childe node is empty insert
				//System.out.println(node.getNum().getNumber()+" is RIGHTC of "+parent.getNum().getNumber());
				parent.setRNode(node);// set child node to this location
				node.setParent(parent);//set parent node for balancing
				node.setDepth(parent.getDepth()+1);//set deoth for balance check
				//System.out.println(node.checkBalance(node));// print line for debugging
				nodeList.add(node);
			}
			else insertNode(node, parent.getRNode());//if not, recursively call
		}
		//Build checker for balance	
	}
	
	public String treePrinterInOrder(Node node)
	{
		//Start all the way down the left side of tree for least to greatest
		if(node.getLNode()!=null) treePrinterInOrder(node.getLNode());
		//All left side will collapse here and print left and center nodes
		printer += ""+ node.getNum().getNumber()+" DEPTH =:"+node.getDepth()+"\n";//String printer for file IO
		//Work all the way down to the right sides to get greatest, then collapse back 
		if(node.getRNode()!=null) treePrinterInOrder(node.getRNode());
		
		return printer; //return premade string for file IO
	}
	
	public String treePrinterBredthFirst()
	{
		for(int i = 0; i < nodeList.size(); i++) System.out.println(nodeList.get(i).getNum().getNumber()+" Depth: "+nodeList.get(i).getDepth()+"\n");
		return printer;
	}
	
	
	public boolean checkBalance(Node checkedNode)
	{
		boolean checkResult = true;//Set bool to true so if error occurs balance doesnt happen
		Node root = checkedNode;//Copy node
		while(root.getParent()!=null) root = root.getParent();//get to root node
		Node oppositeNode = root;// hold onto root node, set a new var for traversing tree
		while(checkedNode.getNum().getNumber()<root.getNum().getNumber() 
				&& oppositeNode.getLNode() != null) oppositeNode = oppositeNode.getLNode();// get to farthest down left node
		while(checkedNode.getNum().getNumber() > root.getNum().getNumber()
				&& oppositeNode.getRNode() != null) oppositeNode = oppositeNode.getRNode();//get to farthest down right node
		if(Math.abs(oppositeNode.getDepth()-checkedNode.getDepth()) > 1) checkResult = false;//If depth diference is greater than 1, rebalance
		if((root.getLNode() == null || root.getRNode() == null) 
				&& checkedNode.getDepth() > 1 ) checkResult = false;//Check to make sure no
		
		return checkResult;
	}
	
	public void setNumber(Number num)
	{
		this.num = num;
	}
	
	public Number getNum()
	{
		return num;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public void setLNode(Node node)
	{
		lnode = node;
	}
	
	public Node getLNode()
	{
		return lnode;
	}
	
	public void setRNode(Node node)
	{
		rnode = node;
	}
	
	public Node getRNode()
	{
		return rnode;
	}
	
	public void setParent(Node node)
	{
		this.parentNode = node;
	}
	
	public Node getParent()
	{
		return this.parentNode;
	}
}

