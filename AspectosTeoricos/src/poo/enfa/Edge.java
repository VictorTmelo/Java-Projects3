package poo.enfa;

public class Edge {
	private Character c;
	
	public Edge(Character c) {
		this.setC(c);
	}
	
	public Character getC() { return c; }
	public void setC(Character c) { this.c = c; }
	
	public static Edge instance(Character pc) { return new Edge(pc); }	
	
	public static boolean testAB(Character a, Character b) {
		if(a!=null) return a.equals(b);
		if(b!=null) return b.equals(a);
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Edge) {
			Edge e = (Edge) o;
			return testAB(this.c, e.getC());
		}
		return false;
	}
	@Override
	public int hashCode() {
		int hc = c!=null?c.hashCode():0;
		return hc;
	}
	@Override
	public String toString() {
		return "edge{c="+c+"}";
	}
}
