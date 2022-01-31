package ed;

public class MainTest {
	public static void main(String[] args) {
		Dicionario<Integer, String> h = new Dicionario<>();

		h.add(1,"joao"); 
		h.add(2, "maria"); 
		h.add(3, "ana");
		h.add(4, "pedro"); 
		h.add(5, "telma"); 
		h.add(6, "julia");
		System.out.println("Imprimindo:"); 
		h.toStringHash();
		
		h.del(1); 
		h.del(4); 
		h.del(6);
		System.out.println("\n ***** Deletados *****"); 
		h.toStringHash();
		
		h.add(4, "pedro"); 
		h.add(1,"joao"); 
		h.add(6, "julia");
		System.out.println("\n ***** Inseridos *****"); 
		h.toStringHash();
	}
}
