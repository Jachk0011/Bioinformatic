import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class GenerateSequences {
	
	public static String nucleotide() {
		Random rd = new Random();
		switch(rd.nextInt(4)) {
			case 0: return "A";
			case 1: return "C";
			case 2: return "G";
			case 3: return "T";
			default: return "";
		}
	}
	
	public static String chromosome() 
	{
		Random rd = new Random();
		return "chr" + (rd.nextInt(23)+1);		
	}
	
	public static String sequence(int tamano) 
	{
		if(tamano==1)
			return nucleotide();
		else
			return nucleotide() + sequence(tamano-1);
	}
	
	public static void llamada() 
	{	
		try 
		{
			FileWriter archivo = new FileWriter("archivo.txt");
			BufferedWriter bw = new BufferedWriter(archivo);
			Random rd = new Random();
			int tamano, inicio, tamArchivo = 10;
			String dato;
			for(int i=0; i<tamArchivo; i++) 
			{
				tamano = rd.nextInt(46)+5;
				inicio = rd.nextInt(1000)+1;
				dato = sequence(tamano)+","+chromosome()+","+ inicio + "," + (inicio+tamano-1);
				bw.write(dato+"\n");
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
		llamada();		
	}

}
