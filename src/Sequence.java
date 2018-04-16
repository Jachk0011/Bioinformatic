
public class Sequence {
	public String sequence;
	public String chromosome;
	public int inicio, fin;
	public Sequence next = null;
	
	public Sequence() {
		
	}
	
	public Sequence(String seq, String chr, int ini, int fin) {
		this.sequence = seq;
		this.chromosome = chr;
		this.inicio = ini;
		this.fin = fin;
	}
	
	public String toString() {
		return "Sequence: " + sequence + "\t Chromosome: "+ chromosome + "\t Start: " + inicio + "\t End: " + fin + "\n";
	}
}
