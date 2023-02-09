import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class Ships{
    public static void ships(){
        String everything; 
            try(BufferedReader br = new BufferedReader(new FileReader("Data/ShipInput.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
            }
            everything = sb.toString();
        }
        catch( FileNotFoundException e ){
            System.out.println( "File could not be found" );
            return;
        }
        catch( IOException e ){
            System.out.println( "Error while reading from file" );
            return;
        }
        catch( NumberFormatException e ){
            System.out.print( "File was not formated correctly" );
            return;
        }
        String[] data = everything.split(" ");
        String shipName = data[0];
        String shipArr[] = new String[9];
        int calculatedArr[] = new int[9];
        int option = 0;  
        String everything2;    
        try(BufferedReader bs = new BufferedReader(new FileReader("Data/T1Ships.txt"))) {
        StringBuilder sc = new StringBuilder();
        String line = bs.readLine();
        while (line != null) {
            sc.append(line);
            sc.append(System.lineSeparator());
            line = bs.readLine();
        }
        everything2 = sc.toString();
        String[] data2 = everything2.split(" ");
        int l = 0;
        int k = 0;
        for( int i = 0; i < 194; i++){  
        if((data2[i].trim().replaceAll("0","").trim().equals(shipName.trim()))){
            System.out.println("Ship found!");
            l = i;
            option = l;
            i = 194;
            k = 1;
            }
        if(i == 193 && k == 0){
            System.out.println("Ship not found! Exiting program...");
            System.exit(1);
        }
        }
        if( k == 1){
        for( int i = option; i < option+8; i++){
            shipArr[i-option] = data2[i];
        }
        DecimalFormat d = new DecimalFormat("###,###,###,###,###,###");
        System.out.println( "\nConstructing a " + (shipName).trim() + " requires:\nTritanium: " + d.format(Integer.parseInt(shipArr[1])) + "\nPyerite: " + d.format(Integer.parseInt(shipArr[2])) + "\nMexallon: " + d.format(Integer.parseInt(shipArr[3])) + "\nIsogen: " +d.format(Integer.parseInt(shipArr[4])) + "\nNocxium: " + d.format(Integer.parseInt(shipArr[5])) + "\nZydrine: " + d.format(Integer.parseInt(shipArr[6])) + "\nMegacyte: " + d.format(Integer.parseInt(shipArr[7])) );
        
            for( int i = 0; i < 1; i++){
        for( int j = 0; j < 1; j++){
        
        }
        File file = new File( "Data/ShipInputResults.txt" );//writes string to .txt
        try{
            BufferedWriter writer = new BufferedWriter( new FileWriter( file ) );
            writer.write( (shipName).trim() + " " + shipArr[1].trim() + " " + shipArr[2].trim() + " " + shipArr[3].trim() + " " + shipArr[4].trim() + " " + shipArr[5].trim() + " " + shipArr[6].trim() + " " + shipArr[7].trim());
            writer.close();
        }
        catch( IOException e ){
            System.out.println( "Error occurred while writing to file" );
        }        
        }
        }
    
    
        }
        catch( FileNotFoundException e ){
            System.out.println( "File could not be found" );
            return;
        }
        catch( IOException e ){
            System.out.println( "Error while reading from file" );
            return;
        }
        catch( NumberFormatException e ){
            System.out.print( "File was not formated correctly" );
            return;
        }
         
    
    }

}