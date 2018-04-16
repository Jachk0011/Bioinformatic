import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Lista {

	Sequence cabeza = null;
	
	public boolean vacia()
	{
		return cabeza == null ? true : false;
	}


	public void imprimirLista() 
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Sequence temp = cabeza;
		
		try 
		{
			bw.write("Notas\n");
			while(temp != null)
			{
				bw.write(temp.toString());
				temp = temp.next;
			}
			bw.flush();//imprime
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	public void insertarInicio(Sequence nuevoSequence)
	{
		nuevoSequence.next = cabeza;
		cabeza = nuevoSequence;
	}
	
	public void insertarFinal(Sequence nuevoSequence)
	{
		if(vacia())
			cabeza = nuevoSequence;
		else
		{
			Sequence temp = cabeza;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			
			temp.next = nuevoSequence;
		}
	}
	
	public void eliminarInicio() 
	{
		Sequence temp = cabeza; // se ncesesita para eliminar de memoria
		cabeza = cabeza.next;
		temp = null;
		//System.gc();//garbageCollector
	}
	
	public void eliminarFinal() 
	{
		Sequence t = cabeza;
		while(t.next.next != null)
			t = t.next;
		t.next=null;	
	}
	
	public void eliminarN(int n) 
	{
		Sequence temp = cabeza;
		
		for(int i=0; i<n-1; i++)
			temp = temp.next;
		temp.next = temp.next.next;		
	}
	
	public void insertarN (Sequence nuevoSequence, int n)
	{
		Sequence temp = cabeza;
		
		for(int i=0; i<n-1; i++)
			temp = temp.next;
		
		nuevoSequence.next = temp.next;
		temp.next = nuevoSequence;		
	}
	

	
	public static void main(String[] args) 
	{
		
	}

}
