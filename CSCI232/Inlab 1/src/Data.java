/**
 *
 * @author Gavin Goroski
 * 1/24/2014
 */
public class Data {

    private String name;
    private int year;


    public Data(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public boolean match(String firstName, String lastName, String phoneStr, String email) {
        if (!name.equals("") && !firstName.equals(this.name)) {
            return false;
        }
        if (!phoneStr.equals("") && Integer.parseInt(phoneStr) != this.year) {
            return false;
        }
        return true;


    }

    public String getName() {
        return name;
    }


    public int getYear() {
        return year;
    }

    public void print() {
        System.out.print(name + " ");
        System.out.println(year);
    }
}
