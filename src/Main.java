
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	Lista sequencesList = new Lista();
	int max_occurrences = Integer.MIN_VALUE;
	String motifWinner = "";
	
	public void compareMotif(String motifCandidate)
	{
		int counter = counterOccurences(motifCandidate);
		if(counter > max_occurrences)//always true at the beginning
		{
			max_occurrences = counter;
			motifWinner = motifCandidate;
		}
	}
	
	public int counterOccurences(String motifCandidate) 
	{
		int counter = 0;
		String gen_sequence;
		Sequence temp = sequencesList.cabeza;		
		while(temp != null)
		{
			gen_sequence = temp.sequence;
			
			for(int i=0; i<(gen_sequence.length()-motifCandidate.length()); i++)			
				if(gen_sequence.substring(i, i + motifCandidate.length()).equals(motifCandidate))
				{
					counter++;
					i += motifCandidate.length()-1;
				}
			
			
			temp = temp.next;
		}
		
		return counter;
	}
	
	public void generateCombinations(String subsequence, int size)
	{
		if(size == 1)
		{
			compareMotif(subsequence + "A");
			compareMotif(subsequence + "C");
			compareMotif(subsequence + "G");
			compareMotif(subsequence + "T");			
		}
		else 
		{
			generateCombinations(subsequence + "A", size-1);
			generateCombinations(subsequence + "C", size-1);
			generateCombinations(subsequence + "G", size-1);
			generateCombinations(subsequence + "T", size-1);
		}
	}
	
	public void countChromosomes() throws IOException 
	{
		int[] chromosomes = new int[23];
		String chr;
		int index;
		Sequence temp = sequencesList.cabeza;		
		while(temp != null)
		{
			
			if(temp.sequence.contains(motifWinner))
			{
				//chromosomes[Integer.parseInt(temp.chromosome.replace("chr", "")) - 1] +=1;
				chr = temp.chromosome;
				chr = chr.replace("chr", "");
				index = Integer.parseInt(chr)-1;
				chromosomes[index] += 1;
			}
			temp = temp.next;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<23; i++)		
			bw.write("Chromosome: "+(i+1) + ": "+ chromosomes[i] +"\n");
		bw.flush();
		
	}
	
	
	
	public static void main(String[] args) {
		try
		{
			FileReader fr = new FileReader("archivo.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String input = br.readLine();
			Main run = new Main();
			
			
			while(input != null)
			{
				String[] data = input.split(",");
				run.sequencesList.insertarFinal(new Sequence(data[0],data[1],Integer.parseInt(data[2])
						,Integer.parseInt(data[3])));
				input = br.readLine();
			}
			//run.sequencesList.imprimirLista();
			run.generateCombinations("", 4);
			System.out.println("Motif Winner: "+ run.motifWinner + "\tOcurrencias: " + run.max_occurrences);
			run.countChromosomes();
			
		}catch(IOException e){
			
		}
	}

}
