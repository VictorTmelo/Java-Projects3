package poo.enfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {
	private final String name;
	private Boolean isFinal = false;
	private final List<Transition> transitions = new ArrayList<Transition>();
	
	public State(String name) {
		this.name = name;
	}
	
	public String getName() { return this.name; }
	public void setFinal() { this.isFinal = true; }
	public Boolean getFinal() { return this.isFinal; }
	
	public State addTransition(State state, Character c) {
		return addTransiton(state, Edge.instance(c));
	}
	private State addTransiton(State state, Edge ...edges) {
		for (Edge e : edges) {
			Transition transition = new Transition(state, e);
			if(transitions.contains(transition))
				continue;
			transitions.add(transition);
		}
		return this;
	}
	public Set<State> states(Character ch) {
		Set<State> r = new HashSet<State>();
		for(Transition t: transitions) {
			Edge e = t.getEdge();
			boolean a = (ch==null && e.getC()==null);
			boolean b = e.getC()!=null && e.getC().equals(ch); 
			if(a || b)
				r.add(t.getState());
		}
		return r;
	}
	public static Set<State> merge(Set<State> a, Set<State> b) {
		Set<State> r = new HashSet<State>();
		for(State s: a) if(!r.contains(s)) r.add(s);
		for(State s: b) if(!r.contains(s)) r.add(s);
		return r;
	}
	public static Set<State> eclose(Set<State> estados){
		Set<State> r = merge(new HashSet<State>(), estados);
		for(State i: estados){
			Set<State> aux1 = i.states(null);
			Set<State> aux2 = eclose(aux1);
			r = merge(r, aux1);
			r = merge(r, aux2);
		}
		return r;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof State) {
			State s = (State) o;
			return s.getName().equals(this.getName());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
}
