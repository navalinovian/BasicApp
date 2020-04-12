package org.aplas.basicapp;

public class Temperature {

    private double celcius;

    public Temperature() {
        this.celcius = 0;
    }

    void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    void setFahrenheit(double fahrenheit){
        this.celcius = (fahrenheit-32)/9*5;
    }
    void setKelvins(double kelvin){
        this.celcius = kelvin - 273.15;
    }
    double getCelcius(){
        return this.celcius;
    }
    double getFahrenheit(){
        double fahrenheit = celcius*9/5+32;
        return fahrenheit;
    }
    double getKelvins(){
        double kelvins = celcius +273.15;
        return kelvins;
    }

    double convert(String oriUnit, String convUnit, double value){
        switch (oriUnit){
            case "°C":
                switch (convUnit){
                    case "°F":
                        value = getFahrenheit();
                        break;
                    case "K":
                        value = getKelvins();
                        break;
                    case "°C":
                        value = getCelcius();
                        break;
                }
            case "°F":
                switch (convUnit){
                    case "°F":
                        value = getFahrenheit();
                        break;
                    case "K":
                        value = getKelvins();
                        break;
                    case "°C":
                        value = getCelcius();
                        break;
                }
            case "K":
                switch (convUnit){
                    case "°F":
                        value = getFahrenheit();
                        break;
                    case "K":
                        value = getKelvins();
                        break;
                    case "°C":
                        value = getCelcius();
                        break;
                }
        }

        return value;
    }

}
