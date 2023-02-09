
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Asteroids{
    public static void minerals(){
        String everything;    
    try(BufferedReader br = new BufferedReader(new FileReader("Data/AsteroidInput.txt"))) {
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
        String oreName = data[0];
        int oreQuantity = Integer.parseInt(data[1].trim());
        String asteroidArr[] = new String[9];
        int calculatedArr[] = new int[9];
    if(data.length == 2){
        int option = 0;  
        String everything2;    
        try(BufferedReader bs = new BufferedReader(new FileReader("Data/AsteroidData3.txt"))) {
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
        int a = 0;
        for( int i = 0; i < 48; i++){  
        if((data2[i].trim().replaceAll("0","").trim().equals(oreName.trim()))){
            System.out.println("Item found!");
            l = i;
            option = l;
            a =+ 1;
            i = 48;
        }
        if(i == 47 && a == 0){
            System.out.println("Item not found! Exiting program...");
            //System.exit(0);
            
        }
        }
        if( a == 1){
        for( int i = option; i < option+8; i++){
            asteroidArr[i-option] = data2[i];
        }     
        for( int i = 1; i < 8; i++){
            calculatedArr[i] = (Integer.parseInt(asteroidArr[i]) * (oreQuantity / 100));
        }
        DecimalFormat d = new DecimalFormat("###,###,###,###,###,###");
        System.out.println( "\n" + d.format(oreQuantity) + " " + oreName + " creates:\nTritanium: " + d.format(calculatedArr[1]) + "\nPyerite: " + d.format(calculatedArr[2]) + "\nMexallon: " + d.format(calculatedArr[3]) + "\nIsogen: " + d.format(calculatedArr[4]) + "\nNocxium: " + d.format(calculatedArr[5]) + "\nZydrine: " + d.format(calculatedArr[6]) + "\nMegacyte: " + d.format(calculatedArr[7]) + "\nMorphite: " + d.format(calculatedArr[8]) );
        }}
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
    }


