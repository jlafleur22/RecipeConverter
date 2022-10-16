//Weight conversions held here
public class Weight {
    Weight(){

    }
    Double OuncesToGrams(double oz){
        //Formula for converting celsius to fahrenheit.
        double g = oz * 28.34952;
        double finalGram = Math.round(g * 100);
        finalGram = finalGram/100;
        return finalGram;
    }
    Double GramsToOunces(double g){
        //Formula for converting celsius to fahrenheit.
        double oz = g * .03527396;
        double finalOunce = Math.round(oz * 100);
        finalOunce = finalOunce/100;
        return finalOunce;
    }
    Double PoundsToOunces(double lb){
        //Formula for converting celsius to fahrenheit.
        double oz = lb * 16.00;
        double finalOunce = Math.round(oz * 100);
        finalOunce = finalOunce/100;
        return finalOunce;
    }
    Double CompareWeight(boolean toImperial, double w){//User inputting imperial measurements
        if (toImperial){
            return this.GramsToOunces(w);
        } else {
            return this.OuncesToGrams(w);
        }
    }
    String ConvertSystem(boolean toImperial) {
        if (toImperial) {
            return "ounces";
        } else {
            return "grams";
        }
    }
}
