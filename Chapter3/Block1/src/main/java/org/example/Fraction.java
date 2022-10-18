package org.example;

import java.util.List;

public final class Fraction {
    private int nominator;
    private int denominator;

    public Fraction(int nominator, int denominator){
        if(denominator == 0)
            throw new IllegalArgumentException("denominator cannot be zero");

        this.nominator = nominator;
        this.denominator = denominator;

        if(nominator < 0 && denominator < 0){
            this.nominator *= -1;
            this.denominator *= -1;
        }
    }

    public int getNominator(){
        return nominator;
    }

    public int getDenominator(){
        return denominator;
    }

    public Fraction sumWith(Fraction fraction){
        int resultNominator, resultDenominator;

        resultNominator = nominator * fraction.getDenominator() + fraction.getNominator() * denominator;
        resultDenominator = denominator * fraction.getDenominator();

        Fraction result = new Fraction(resultNominator, resultDenominator);
        result.cutDown();
        return result;
    }

    public Fraction sumWith(int number){
        return sumWith(new Fraction(number,1));
    }
    public Fraction substractWith(int number){
        return substractWith(new Fraction(number,1));
    }
    public Fraction multiplyBy(int number){
        return multiplyBy(new Fraction(number,1));
    }
    public Fraction divideBy(int number){
        return divideBy(new Fraction(number,1));
    }

    public Fraction substractWith(Fraction fraction){
        int resultNominator, resultDenominator;

        resultNominator = nominator * fraction.getDenominator() - fraction.getNominator() * denominator;
        resultDenominator = denominator * fraction.getDenominator();

        Fraction result = new Fraction(resultNominator, resultDenominator);
        result.cutDown();
        return result;
    }

    public Fraction multiplyBy(Fraction fraction){
        int resultNominator, resultDenominator;

        resultNominator = nominator * fraction.getNominator();
        resultDenominator = denominator * fraction.getDenominator();

        Fraction result = new Fraction(resultNominator, resultDenominator);
        result.cutDown();
        return result;
    }

    public Fraction divideBy(Fraction fraction){

        if(fraction.getNominator() == 0)
            throw new IllegalArgumentException("division by zero");

        int resultNominator, resultDenominator;

        resultNominator = nominator * fraction.getDenominator();
        resultDenominator = denominator * fraction.getNominator();

        Fraction result = new Fraction(resultNominator, resultDenominator);
        result.cutDown();
        return result;
    }

    private void cutDown(){
        int min = Math.abs(nominator) < Math.abs(denominator) ? Math.abs(nominator) : Math.abs(denominator);

        for(int i = 2; i < Math.sqrt(min); i++){
            if(nominator%i == 0 && denominator%i == 0){
                nominator/=i;
                denominator/=i;
                cutDown();
            }
        }
    }

    public String toString(){
        return nominator+" / "+denominator;
    }
}
