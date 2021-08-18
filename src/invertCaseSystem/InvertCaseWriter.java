package invertCaseSystem;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class InvertCaseWriter extends Writer{
	public static void main(String[] args) {
		//4.d) e 4.e)
		String frase = "OlÁ, Meu NOme é SAMUEL";
		try {
			char[] caracteres = frase.toCharArray();
			for(int i=0; i < caracteres.length; i++) {
				char ch = caracteres[i];
				
				if(Character.isUpperCase(ch)) {
					caracteres[i] = Character.toLowerCase(ch);
				}
				else if(Character.isLowerCase(ch)) {
					caracteres[i] = Character.toUpperCase(ch);
				}
			}
			
			//Imprimindo no arquivo
			OutputStream outputstream = new FileOutputStream("outputInvertCase.txt");
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            
            BufferedWriter bufferwriter = new BufferedWriter(outputstreamwriter);
            
            bufferwriter.write(caracteres);
            bufferwriter.close();
            
            //Imprimindo no consoloe
            for(int i=0; i < caracteres.length; i++) {
            	System.out.printf("%c", caracteres[i]);
            }
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(char[] arg0, int arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
