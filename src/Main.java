import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RunInstance recipe = new RunInstance();
        recipe.ConversionType();
        recipe.ReadFile();
        recipe.WriteFile();
    }
}