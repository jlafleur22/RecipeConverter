import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class RunInstance {
    public static String stringOutput = "";
    public boolean toImperial = false;
    public RunInstance() {

    }

    public String SetRecipe() throws  IOException {
        //create converter from user input to string
        BufferedReader bufferedString = new BufferedReader(new InputStreamReader(System.in));

        //command to enter file name to user
        System.out.println("Enter the recipe name: ");

        //call to set user input to variable
        return bufferedString.readLine();
    }
    //ask user if they want imperial or metric measurements
    public void ConversionType(){
        System.out.println("Enter System of recipe measurements, i for Imperial or m for metric");
        Scanner userIn = new Scanner(System.in);
        char userInput = userIn.next().charAt(0);

        //change toImperial if necessary
        if (userInput == 'i'){
            toImperial = true;
        }
    }
    //Might be wholly useless, unless I just want to call the recipe
    public void ReadFile() throws IOException{
        String s = SetRecipe();
        //set file path
        String path = ("files/" + s + ".txt");

        //create instance of filestream
        InputStream is = new FileInputStream(path);

        //Try block to check for exceptions
        try (Scanner sc = new Scanner(
                is, StandardCharsets.UTF_8)){
            while (sc.hasNextLine()){
                //set variable to store change and check
                StringBuilder line = new StringBuilder(sc.nextLine());
                //check first position of string
                    //Add check to if value and if line = 0 skip
                //if first position of the string == !, do the conversion
                if(line.charAt(0) == '!'){//weight conversion
                    line = new StringBuilder(line.substring(1));
                    String[] lineArray = line.toString().split(" ");
                    Weight w = new Weight();
                    lineArray[0] = String.valueOf(w.CompareWeight(toImperial, Double.parseDouble(lineArray[0])));
                    lineArray[1] = w.ConvertSystem(toImperial);
                    //reset line to empty string
                    line.setLength(0);
                    for (String strLine : lineArray) {
                        line.append(strLine + " ");
                    }
                } else if (line.charAt(0) == '&'){//volume conversion
                    line = new StringBuilder(line.substring(1));
                    String[] lineArray = line.toString().split(" ");
                    Volume v = new Volume();
                    lineArray[0] = String.valueOf(v.CompareVolume(toImperial, Double.parseDouble(lineArray[0])));
                    lineArray[1] = v.ConvertSystem(toImperial);
                    line.setLength(0);
                    for (String strLine : lineArray){
                        line.append(strLine + " ");
                    }
                } else if (line.charAt(0) == '@'){//temperature conversion
                    //delete first character
                    line = new StringBuilder(line.substring(1));
                    //break string
                    String[] lineArray = line.toString().split(" ");
                    //pass the numeric value and boolean
                    Temperature t = new Temperature();
                    lineArray[0] = String.valueOf(t.CompareTemp(toImperial, Double.parseDouble(lineArray[0])));
                    //convert words to proper system
                    lineArray[1] = t.ConvertSystem(toImperial);
                    //reconstruct string and set = to line
                    line.setLength(0);
                    for (String strLine : lineArray){
                        line.append(strLine + " ");
                    }
                }
                //write to string
                stringOutput += line + "\n";
            }
        }
    }

    public void WriteFile() throws IOException {
        BufferedReader newRecipeString = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Enter new recipe name: ");

        //new recipe filename and file writer path
        String newRecipe = newRecipeString.readLine();
        Path newRecipeFile = Path.of("files/" + newRecipe + ".txt");

        //Write contents to new file
        Files.writeString(newRecipeFile, stringOutput);
    }
}
