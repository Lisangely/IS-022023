import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

 class ContarLineasArchivo {
    public static void main(String[] args) {
        long lNumeroLineas = 0;
		
		try {
			FileReader fr = new FileReader("src/tu_archivo.txt");
		
			BufferedReader bf = new BufferedReader(fr);
			
			while ((bf.readLine())!=null) {
			  lNumeroLineas++;
			}
			
			bf.close();
			
		} catch (FileNotFoundException fnfe){
			  fnfe.printStackTrace();
		} catch (IOException ioe){
		  ioe.printStackTrace();
		}
		
		System.out.println("El fichero tiene " + lNumeroLineas + " lineas");
		
	}

    }

