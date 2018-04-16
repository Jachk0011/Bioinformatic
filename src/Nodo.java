
public class Nodo {
	
	String nota;
	double valor;
	Nodo next = null;
	
	public Nodo() {	}
	
	public Nodo(String n, double v)
	{
		this.nota = n;
		this.valor = v;
	}
	
	public String toString()
	{
		return "Tipo: "+ nota + "\t Valor: " + valor + "\n";
	}
	
	public Nodo clone() 
	{
		Nodo temp = new Nodo(this.nota, this.valor);
		return temp;
	}
}
