package com.naseeha.filereading;

//public class FileReading {
import java.io.*;
import java.util.ArrayList;

public class FileReading extends BufferedReader{
    public FileReading(Reader reader) {
		super(reader);
		
	}

	  @Override
	    public String readLine() throws IOException {
	         String line = super.readLine();
	        if (line != null) {
	        	line = ChangeUppercase(line);
	        }

	        return line;
	    }



	private String ChangeUppercase(String line) {
		String str="";
		for(char c: line.toCharArray()){
			int b=c;
			if(b>=97&&b<=122){
				b = b-32;
			}
			str= str+(char)b;
		}
		return str;
	}

	public static void main(String [] args) {
        String fileName = "news.txt";

        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);
            FileReading bufferedReader = 
                new FileReading(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
         
        }
    }
}