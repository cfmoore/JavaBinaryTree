import java.io.*;

/**
 * Driver Class for the binary tree
 * @author chad
 *
 */
public class Test {

	/**
	 * 
	 * @param number The class numbe with the node position and the number
	 */
	public static void fileWrite(Number number)
	{
		if(number.getSpot() == 0)
		{
			try {
				FileWriter fw = new FileWriter("list.txt");
				fw.flush();
				fw.close();
			}
			catch(IOException e) { System.out.println("Something Went Wrong");}
		}
		try {
			FileWriter fw = new FileWriter("list.txt", true);
			fw.append("Node Numeber: " + number.getSpot() +" Number: "+ number.getNumber()+"\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double random;
		Node root = new Node();
		root = null;
		for(int i = 0; i<10; i++)
		{
			random = Math.floor(Math.random()*1000);
			Node node = new Node();
			Number num = new Number();
			num.setNumber((int)random);
			num.setSpot(i);
			node.setNumber(num);
			node.insertNode(node, root);
			if(root == null) root = node;
			fileWrite(num);
		}
		System.out.print(root.treePrinterBredthFirst());
		System.out.println("done");
		
	}

}
