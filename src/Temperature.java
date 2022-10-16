//Temperature conversions stored here
public class Temperature {
    Temperature(){

    }
    Double Celsius(double f){
        //this will need to pass in the value in the string
        //Formula for converting celsius to fahrenheit.
        double c = (f - 32) * (.55);
        double finalC = Math.round(c * 100);
        finalC = finalC/100;
        return finalC;
    }
    Double Fahrenheit(double c){
        //Formula for converting celsius to fahrenheit.
        double f = c * 1.8 + 32;
        return f;
    }
    Double CompareTemp(boolean toImperial, double t){//User inputting imperial measurements
        if (toImperial){
            return this.Fahrenheit(t);
        } else {
            return this.Celsius(t);
        }
    }
    String ConvertSystem(boolean toImperial){
        if (toImperial){
            return "fahrenheit";
        }else{
            return "celsius";
        }
    }
}
