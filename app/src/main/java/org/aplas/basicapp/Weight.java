package org.aplas.basicapp;

public class Weight {
    private  double gram;


    void setGram(double value) {
        this.gram = value;
    }
    void setOunce(double value){
        this.gram = value*28.3495231 ;

    }
    void setPound(double value){
        this.gram = value*453.59237;
    }
    double getGram(){
        return this.gram;
    }
    double getOunce(){
        return this.gram/28.3495231;
    }
    double getPound(){
        return this.gram/453.59237;
    }

    double convert(String oriUnit, String convUnit, double value){
        switch (oriUnit){
            case "Grm":
                switch (convUnit){
                    case "Grm":
                        value = getGram();
                        break;
                    case "Onc":
                        value = getOunce();
                        break;
                    case "Pnd":
                        value = getPound();
                        break;
                }
            case "Pnd":
                switch (convUnit){
                    case "Grm":
                        value = getGram();
                        break;
                    case "Onc":
                        value = getOunce();
                        break;
                    case "Pnd":
                        value = getPound();
                        break;
                }
            case "Onc":
                switch (convUnit){
                    case "Grm":
                        value = getGram();
                        break;
                    case "Onc":
                        value = getOunce();
                        break;
                    case "Pnd":
                        value = getPound();
                        break;
                }
        }

        return value;
    }
}
