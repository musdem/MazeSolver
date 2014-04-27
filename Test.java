public class Test
{
	public static void main(String args[])
	{
		Maze m = new Maze("maze.txt");
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
		m.movePoint(2,2);
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
		m.movePoint(2,-2);
		System.out.println(m);
		System.out.println(m.currentPos());
		System.out.println(m.endingPos());
		System.out.println(m.isIllegal(new Point(6,4)));//should be false
		System.out.println(m.isIllegal(new Point(6,5)));//should be true
		System.out.println(m.isIllegal(new Point(7,4)));//should be true
		System.out.println(m.isIllegal(new Point(3,2)));//should be true
		System.out.println(m.isIllegal(new Point(-1,-1)));//should be true
	}
}
