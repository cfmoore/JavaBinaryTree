import java.io.*;

public class Test {

	public static void fileWrite(int number, int node)
	{
		if(node == 0)
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
			fw.append("Node Numeber: " + node +" Number: "+ number+"\n");
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
			node.setNumber(num);
			node.insertNode(node, root);
			if(root == null) root = node;
			fileWrite((int)random, i);
		}
		System.out.print(root.treePrinterBredthFirst());
		/**try {
			FileWriter fc = new FileWriter("Nodes.txt");
			fc.flush();
			fc.close();
			FileWriter fw = new FileWriter("Nodes.txt",true);
			String writer = root.treePrinter(root);
			fw.append(writer);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		System.out.println("done");
		
	}

}
