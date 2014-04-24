public class Test
{
	public static void main(String args[])
	{
		Maze m = new Maze("maze.txt");
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
		m.movePoint(3,0);
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
		m.movePoint(0,3);
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
		m.movePoint(6,0);
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
	}
}
