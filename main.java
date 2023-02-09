import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
  
public class main{
    public static void main(String[] args) throws Exception {       
    
        
    Item[] items = new Item[368620];
    int[] idArray;
    idArray = new int[368620]; 
    String[] strArray;
    strArray = new String[368620];
    double[] avgBuyArray;
    avgBuyArray = new double[368620];
    double[] avgSellArray;
    avgSellArray = new double[368620];
   
System.out.println("-----EVE COMPANION TOOL-----\n1.) Update market info\n2.) Search for info on an item\n3.) Ore to mineral converter\n4.) Ship industry tool\n0.) Exit program");
Scanner inputChoice = new Scanner(System.in);
//EXAMPLE SEARCHES FOR TESTING
//1.) no input required
//2.) Miner II
//3.) Veldspar105543
//4.) Vexor
System.out.print("Enter your choice: ");
int choice = inputChoice.nextInt();
while( choice < 0 || choice > 4 ){
    System.out.print("Invalid input! Enter a number between 0-4.\nTry Again:");
    choice = inputChoice.nextInt();
}

inputChoice.close();
while(choice != 0){      
System.out.print("Fetching data...");    
    if ( choice == 1 ){
    System.out.println("\nThis will take some time. Files will begin to update from the top.\nRetreiving data from evemarketer.com...");
    long startTime = System.nanoTime();
    //----------create xmlFile.txt from evemarketer.com then splits it into multiple lines----------    
    try{
    for( int i = 0; i < 22367; i++){
        URL url = new URL("https://api.evemarketer.com/ec/marketstat?typeid=" + i);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine; 
    while ((inputLine = in.readLine()) != null){
            String Str = new String(inputLine);
            for( int j = 0; j < 1; j++){
            Str = Str.replaceAll(">","\n");
            Str = Str.replaceAll("<","\n");
            File file = new File( "Data/xmlFile" + i + ".txt" );//writes string to .txt
            try{
                BufferedWriter writer = new BufferedWriter( new FileWriter( file ) );
                writer.write( Str );
                writer.close();
            }
            catch( IOException e ){
                System.out.println( "Error occurred while writing to file" );
            }
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


    
    
        //----------create xmlFile.txt from evemarketer.com then splits it into multiple lines----------
        try{
        for( int i = 0; i < 34490; i++){//34489 is last file
            URL url = new URL("https://api.evemarketer.com/ec/marketstat?typeid=" + idArray[i]);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine; 
        while ((inputLine = in.readLine()) != null){
            String Str = new String(inputLine);
        for( int j = 0; j < 1; j++){
            Str = Str.replaceAll(">","\n");
            Str = Str.replaceAll("<","\n");
        File file = new File( "Data/xmlFile" + idArray[i] + ".txt" );//writes string to .txt
        try{
            BufferedWriter writer = new BufferedWriter( new FileWriter( file ) );
            writer.write( Str );
            writer.close();
        }
        catch( IOException e ){
            System.out.println( "Error occurred while writing to file" );
        }
        }
        }
        }
    }
    catch( FileNotFoundException e ){
        System.out.println( "File could not be found[1]" );
        return;
    }
    catch( IOException e ){
        System.out.println( "Error while reading from file[1]" );
        return;
    }
    catch( NumberFormatException e ){
        System.out.print( "File was not formated correctly[1]" );
        return;
    }
    long endTime = System.nanoTime();
    long duration = ((endTime - startTime)/1000000000);
    if(duration < 60){
        System.out.println("Done! That took " + duration + " second(s).\n");    
    }
    else if(duration > 60){
        duration = duration / 60;
        System.out.println("Done! That took " + duration + " minute(s).\n");
    }
}//end choice1    

    




    //----------reads IDs.txt to retrive id and name----------    
try{
    BufferedReader reader = new BufferedReader( new FileReader( "Data/IDs.txt" ));
    reader.readLine();
    for( int i = 0; i < 22367; i++){ 
        String line = reader.readLine();
        String[] columns = line.split("      ");//splits between spaces
        int id = Integer.parseInt( columns[0] );
        String name = columns[1];
        idArray[id] = id;
        strArray[id] = name;
    }
    reader.close();
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

    
    //----------reads xmlFile.txt to get xml data----------
try{
    for( int i = 0; i < 34490; i++){
        BufferedReader reader = new BufferedReader( new FileReader ( "Data/xmlFile" + idArray[i] + ".txt" ));
        BufferedReader reader2 = new BufferedReader( new FileReader ( "Data/xmlFile" + idArray[i] + ".txt" ));
        reader.readLine();
        reader2.readLine();
    
        BufferedReader br = new BufferedReader(reader);
        BufferedReader br2 = new BufferedReader(reader2);
    for (int lineNo = 1; lineNo < 15; lineNo++) {
    if (lineNo == 14) {
        avgSellArray[i] = Double.valueOf(br.readLine());
        lineNo = 15;
    } else
        br.readLine();
    }
    for (int lineNo = 1; lineNo < 47; lineNo++) {
    if (lineNo == 46) {
        avgBuyArray[i] = Double.valueOf(br2.readLine());
        lineNo = 47;
    } else
        br2.readLine();
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
    
    
    
    //----------creates items object----------
for( int i = 0; i < 368619; i++){
    int id = idArray[i];
    String name = strArray[i];
    double avgBuy = avgBuyArray[i];
    double avgSell = avgSellArray[i];
        
    items[id] = new Item(id, name, avgBuy, avgSell);    
    }
    System.out.println(" Done!");


    
    
       
    //2.) Search for info on an item   
if( choice == 2 ){    
    int option = 1;
    int option2 = 0;
    String search = "";
    Scanner sc = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    int result = 0;
    System.out.print("\nType an item name to search: ");
    search = input.nextLine(); 
    sc.close();
    try{
        BufferedReader reader = new BufferedReader( new FileReader( "Data/IDs.txt" ));
        reader.readLine();
        for( int i = 0; i < 22367; i++){
        String line = reader.readLine();
        String[] columns = line.split("      ");//splits between spaces
        int id = Integer.parseInt( columns[0] );
        String name = columns[1];
        idArray[id] = id;
        strArray[id] = name;
        int a = 0;
        int l = 0;
        if((columns[1].trim()).equals(search.trim())){//==
            System.out.println("Item found!");
            a = 1;
            l = i;
            i = 22367;
            option = l;
            }
        if(i == 22366 && a == 0){
            System.out.println("Item not found! Exiting program...");
            System.exit(0);
        }
        for (int lineNo = 1; lineNo < 22382; lineNo++) {
        if (lineNo == option) {
            option2 = Integer.parseInt(columns[0]);
            lineNo = 22382;
        } else
            reader.readLine();
        }  
        }
        reader.close();
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
    System.out.println( items[option2] );
    
    DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
    DecimalFormat d = new DecimalFormat("###,###,###,###,###,###");
    
    Scanner sd = new Scanner(System.in);
    System.out.print("Enter a quanity of " + items[option2].getName().trim() + ": ");
    double quantity = input.nextDouble();
    while(quantity <= -1){
        System.out.print("Invalid input! Quantity must be a positive number.\nEnter a quantity of " + items[option2].getName().trim() + ": ");
        quantity = input.nextDouble();
    }
    double totalBuy = items[option2].getAvgBuy() * quantity;
    double totalSell = items[option2].getAvgSell() * quantity;
    System.out.println("\n" + d.format(quantity) + " " + items[option2].getName().trim() + ":\nSells for: " + df.format(totalSell) + "\nBuys for: " + df.format(totalBuy));
    sd.close();
    
    inputChoice.close();
    Scanner ic = new Scanner(System.in);
    System.out.print("\nEnter your choice: ");
    choice = ic.nextInt();
    while( choice < 0 || choice > 4 ){
    System.out.print("Invalid input! Enter a number between 0-4.\nTry Again:");
    choice = ic.nextInt();
    }
    }
    

  
    
    
if( choice == 3 ){//ex. "Veldspar39"
    Scanner input = new Scanner(System.in);
    System.out.println("\nCopy and paste or type ore here (ore followed by quantity): ");
    String asteroidInput = input.nextLine();
    String inputLine; 
    for( int i = 0; i < 1; i++){
        for( int j = 0; j < 1; j++){
        asteroidInput = asteroidInput.replaceFirst("(?!^)([1-9])" , " $1");
        }
        File file = new File( "Data/AsteroidInput.txt" );//writes string to .txt
        try{
            BufferedWriter writer = new BufferedWriter( new FileWriter( file ) );
            writer.write( asteroidInput );
            writer.close();
        }
        catch( IOException e ){
            System.out.println( "Error occurred while writing to file" );
        }        
    }
    Asteroids.minerals();
    
    inputChoice.close();
    Scanner ic = new Scanner(System.in);
    System.out.print("\nEnter your choice: ");
    choice = ic.nextInt();
    while( choice < 0 || choice > 4 ){
    System.out.print("Invalid input! Enter a number between 0-4.\nTry Again:");
    choice = ic.nextInt();
    }
    }
    

    
    
       
if( choice == 4){
    Scanner input = new Scanner(System.in);
    System.out.println("\nEnter a ship name: ");
    String asteroidInput = input.nextLine();
    String inputLine; 
    for( int i = 0; i < 1; i++){
        for( int j = 0; j < 1; j++){
        asteroidInput = asteroidInput;
        }
        File file = new File( "Data/ShipInput.txt" );//writes string to .txt
        try{
            BufferedWriter writer = new BufferedWriter( new FileWriter( file ) );
            writer.write( asteroidInput );
            writer.close();
        }
        catch( IOException e ){
            System.out.println( "Error occurred while writing to file" );
        }        
    }
    Ships.ships();
    
    
    
    String everything; 
            try(BufferedReader br = new BufferedReader(new FileReader("Data/ShipInputResults.txt"))) {
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
        int tri = Integer.parseInt(data[1]);
        int pye = Integer.parseInt(data[2]);
        int mex = Integer.parseInt(data[3]);
        int iso = Integer.parseInt(data[4]);
        int noc = Integer.parseInt(data[5]);
        int zyd = Integer.parseInt(data[6]);
        int meg = Integer.parseInt(data[7].trim());

    DecimalFormat d = new DecimalFormat("###,###,###,###,###,###");
    
    
    double mineralBuyOrder = ((items[34].getAvgBuy()*tri) + (items[35].getAvgBuy()*pye) + (items[36].getAvgBuy()*mex) + (items[37].getAvgBuy()*iso) + (items[38].getAvgBuy()*noc) + (items[39].getAvgBuy()*zyd) + (items[40].getAvgBuy()*meg) );
    double mineralSellOrder = ((items[34].getAvgSell()*tri) + (items[35].getAvgSell()*pye) + (items[36].getAvgSell()*mex) + (items[37].getAvgSell()*iso) + (items[38].getAvgSell()*noc) + (items[39].getAvgSell()*zyd) + (items[40].getAvgSell()*meg) );
    
    System.out.println("\nThe total cost of minerals is:\nBuy Order: " + d.format(mineralBuyOrder) + "\nSell Order: " + d.format(mineralSellOrder) ); 
    inputChoice.close();
    Scanner ic = new Scanner(System.in);
    System.out.print("\nEnter your choice: ");
    choice = ic.nextInt();
    while( choice < 0 || choice > 4 ){
    System.out.print("Invalid input! Enter a number between 0-4.\nTry Again:");
    choice = ic.nextInt();
    }
}      
}  
}   
}
   
  