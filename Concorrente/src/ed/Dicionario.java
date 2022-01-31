package ed;

public class Dicionario<K, V> {
	private int MAX;
	private NO<K, V>[] nodes = null;
	
	public Dicionario(){
		init(3);
	}
	public Dicionario(int n) {
		init(n);
	}
	@SuppressWarnings("unchecked")
	private void init(int n) {
		MAX = n;
		nodes = new NO[MAX];
		for(int i=0;i<MAX;i++)
			nodes[i] = null;		
	}
	
	private int hash(K key) { return key.hashCode()%MAX; }
	public void add(K key, V value){
		int k = hash(key);
		nodes[k] = addNO(nodes[k], key, value);
	}
	private NO<K, V> addNO(NO<K, V> head, K key, V value){
		if(head==null){
			head = new NO<K, V>(key,value);
			return head;
		}
		NO<K, V> h = head;
		while(h.next!=null) {
			if(h.key==key) return head;
			h = h.next;
		}
		h.next = new NO<K, V>(key, value);
		return head;
	}
	public void del(K key){
		int k = hash(key);
		nodes[k] = deleteGetHeadNO(nodes[k], key);
	}
	private NO<K, V> deleteGetHeadNO(NO<K, V> head, K key){
		if(head==null) return null;
		if(head.key.equals(key)){
			NO<K, V> n = head.next;
			//free(head);
			return n;
		}
		NO<K, V> del = head;//pode ser head.next
		NO<K, V> ant = head;
		while(del!=null) {
			if(del.key.equals(key))
				break;
			ant = del;
			del = del.next;
		}
		if(del!=null){
			ant.next = del.next;
			//free(del);
		}
		return head;
	}
	public void toStringHash(){
		for(int k=0; k < MAX; k++){
			System.out.format("index(%d): ", k);
			if(nodes[k]!=null)
				toStringNO(nodes[k]);
			System.out.format("\n");
		}
	}
	public void toStringNO(NO<K, V> head){
		NO<K, V> end = head;
		while(end!=null){
			System.out.format("[%s, %s] ",end.key.toString(), end.value.toString());
			end = end.next;
		}
	}
	public V valor(K key){
		int k = hash(key);
		return valueNO(nodes[k], key);
	}
	private V valueNO(NO<K, V> head, K key){
		NO<K, V> end = head;
		while(end!=null){
			if(end.key.equals(key)) return end.value;
			end = end.next;
		}
		return null;
	}
	private class NO<TKey, TValue>{
		public TKey key;
		public TValue value;
		public NO<TKey, TValue> next = null;
		public NO(TKey key, TValue value) {
			this.key = key;
			this.value = value;
		}
	}
}
