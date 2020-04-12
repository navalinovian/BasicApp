package org.aplas.basicapp;

public class Distance {

    private  double meter;


    void setMeter(double value) {
        this.meter = value;
    }
    void setInch(double value){
        this.meter = value/39.3701;

    }
    void setMile(double value){
        this.meter = value/0.000621371;
    }
    void setFoot(double value){
        this.meter = value/3.28084;
    }
    double getMeter(){
        return this.meter;
    }
    double getInch(){
        return this.meter*39.3701;
    }
    double getMile(){
        return this.meter*0.000621371;
    }
    double getFoot(){
        return this.meter*3.28084;
    }

    double convert(String oriUnit, String convUnit, double value){
        switch (oriUnit){
            case "Mtr":
                switch (convUnit){
                    case "Inc":
                        value = getInch();
                        break;
                    case "Mil":
                        value = getMile();
                        break;
                    case "Ft":
                        value = getFoot();
                        break;
                    case "Mtr":
                        value = getMeter();
                        break;
                }
            case "Inc":
                switch (convUnit){
                    case "Inc":
                        value = getInch();
                        break;
                    case "Mil":
                        value = getMile();
                        break;
                    case "Ft":
                        value = getFoot();
                        break;
                    case "Mtr":
                        value = getMeter();
                        break;
                }
            case "Ft":
                switch (convUnit){
                    case "Inc":
                        value = getInch();
                        break;
                    case "Mil":
                        value = getMile();
                        break;
                    case "Ft":
                        value = getFoot();
                        break;
                    case "Mtr":
                        value = getMeter();
                        break;
                }
            case "Mil":
                switch (convUnit){
                    case "Inc":
                        value = getInch();
                        break;
                    case "Mil":
                        value = getMile();
                        break;
                    case "Ft":
                        value = getFoot();
                        break;
                    case "Mtr":
                        value = getMeter();
                        break;
                }
        }

        return value;
    }
}
