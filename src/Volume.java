//Volume conversions stored here
public class Volume {
    //currently fluidInput as universal. Likely won't use in final build.
    void Volume(){

    }
    //Fluid Ounce to Liter
    Double FlozToLiter(double l){
        //Formula for converting celsius to fahrenheit.
        double oz = l * 33.81402;
        oz = Math.round(oz * 100);
        oz = l/100;
        return oz;
    }
    //Liter to fluid ounce
    Double LiterToFluidOunce(double oz){
        //Formula for converting celsius to fahrenheit.
        double l = oz * .0295735296;
        l = Math.round(l * 100);
        l = l/100;
        return l;
    }
    //Cup to fluid ounce
    Double CupToFloz(double c){
        double oz = c * 8.0;
        return oz;
    }
    Double CompareVolume(boolean toImperial, double v){//User inputting imperial measurements
        if (toImperial){
            return this.LiterToFluidOunce(v);
        } else {
            return this.FlozToLiter(v);
        }
    }
    String ConvertSystem(boolean toImperial) {
        if (toImperial) {
            return "ounces";
        } else {
            return "liters";
        }
    }
}
