public class Test
{
	public static void main(String args[])
	{
		Maze m = new Maze("maze.txt");
		System.out.println(m);
		m.solveMethod(1);
		System.out.println(m.returnSize());
	}
}
