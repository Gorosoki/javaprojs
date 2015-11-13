package hashlab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavin
 */
public class Data
{
   private String line;
    private int number;


    public Data(String line, int number) {
        this.line = line;
        this.number = number;
    }

    public boolean match(String name) {
        if (!line.equals("") && !name.equals(this.line)) {
            return false;
        }
        return true;


    }

    public String getLine() {
        return line;
    }


    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.print(line + " ");
        System.out.println(number);
    } 
}
