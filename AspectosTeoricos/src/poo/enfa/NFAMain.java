package poo.enfa;

public class NFAMain { // NFA = (Q, Σ, δ, q0, F)
	public static void main(String[] args) {
		//a0();
		//a1();
		a2();
	}
	public static void a2(){
		System.out.println("L = {+\n"+
				"  n=0 e/ou\n"+
				"  a^n in Σ^* | \n"+
				"  n eh par e/ou termina com p. \n"+
				"  Ou eh multiplo de 3 e/ou termina com i\n"+
				"}:");
		State q0 = new State("q0");
		State q1 = new State("q1");
		State q2 = new State("q2");
		State q3 = new State("q3");
		State q4 = new State("q4");
		State q5 = new State("q5");
		State q6 = new State("q6");
		State q7 = new State("q7");
		q6.setFinal();
		q7.setFinal();
		
		q0.addTransition(q1, null).addTransition(q2, null);
		
		//eh par
		q1.addTransition(q3, 'a').addTransition(q6, null);
		q3.addTransition(q1, 'a');
		
		//eh multiplo de 3
		q2.addTransition(q4, 'a').addTransition(q7, null);
		q4.addTransition(q5, 'a');
		q5.addTransition(q2, 'a');
		
		q6.addTransition(q6, 'p');
		q7.addTransition(q7, 'i');
		
		String w = "aap";
		ENFA enfa = new ENFA(q0);
		checkout(enfa.run(w),w);
		System.out.println("*****************************");
	}	
	
	public static void a1(){
		/*
		 * L = {a^n in Σ^* | n eh par ou multiplo de 3}
		 */
		System.out.println("L = {a^n in Σ^* | n eh par ou multiplo de 3}:");
		State q0 = new State("q0");
		State q1 = new State("q1");
		State q2 = new State("q2");
		State q3 = new State("q3");
		State q4 = new State("q4");
		State q5 = new State("q5");
		q1.setFinal();
		q2.setFinal();
		
		q0.addTransition(q1, null).addTransition(q2, null);
		
		//eh par
		q1.addTransition(q3, 'a');
		q3.addTransition(q1, 'a');
		
		//eh multiplo de 3
		q2.addTransition(q4, 'a');
		q4.addTransition(q5, 'a');
		q5.addTransition(q2, 'a');
		
		String w = "aaaaaa";
		ENFA enfa = new ENFA(q0);
		checkout(enfa.run(w),w);
		System.out.println("*****************************");
	}
	public static void a0(){
		/*
		 * L = {w in Σ^* | w[w.len-2]=b}
		 */
		System.out.println("*****************************\nProcessamento de L1:");
		State q0 = new State("q0");
		State q1 = new State("q1");
		State q2 = new State("q2");
		State q3 = new State("q3");
		q3.setFinal();
		q0.addTransition(q0, 'a');
		q0.addTransition(q0, 'b');
		q0.addTransition(q1, 'b');
		
		q1.addTransition(q2, 'a');
		q1.addTransition(q2, 'b');
		
		q2.addTransition(q3, 'a'); 
		q2.addTransition(q3, 'b'); 
		
		String w = "aabbabaa";
		ENFA nfa = new ENFA(q0);
		checkout(nfa.run(w),w);
		System.out.println("*****************************");
	}
	public static void checkout(boolean b, String w) {
		if(b)
			System.out.println("reconheceu: " + w);
		else 
			System.out.println("Nao reconheceu: " + w);
	}
}
