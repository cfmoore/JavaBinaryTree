
public class TreeBuilder {
	
	public void insertNode(Node node, Node parent)
	{
		//IF there is no nodes in the tree, start a fresh node in tree
		if(parent == null)
		{
			node.depth = 0;
			return;
		}
		
		//Check if it goes to left node
		if(node.getNum().getNumber() < parent.getNum().getNumber())
		{
			if(parent.getLNode() == null)//Make sure child node is empty
			parent.setLNode(node);
			else insertNode(node, parent.getLNode());//If not, recursively call mehtod
		}
		
		//Check if it goes in right node
		else if(node.getNum().getNumber() > parent.getNum().getNumber())
		{
			if(parent.getRNode() == null)//if childe node is empty insert
			parent.setRNode(node);
			else insertNode(node, parent.getRNode());//if not, recursively call
		}
		//Build checker for balance	
	}
	
	public void treePrinter(Node node)
	{
		//Work through tree left, center, thenn right
		if(node.getLNode() != null) 
		{
			treePrinter(node.getLNode());
			System.out.println("Left Node: " + node.getNum().getNumber());
		}
		System.out.println("Center Node:"+ node.getNum().getNumber());
		if(node.getRNode() != null) 
		{
			treePrinter(node.getRNode());
			System.out.println("Right Node: " + node.getNum().getNumber());
		}
		
	}
	
}
