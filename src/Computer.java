
// -----------------------------------------------------
// Assignment 1
// © Jhanvi Arora, Zalakben Rajendrakumar Patel
// Written by: Jhanvi Arora (40162512), Zalakben Rajendrakumar Patel (40164315)
// -----------------------------------------------------
import java.util.Objects;
/**
 * Class Defining computer object
 */
public class Computer {
    private String brand;
    private String model;
    private long SN;
    private double price;
    private static int noOfObjects = 0;
    public Computer(String p_d, String p_m, long p_sn, double p_pr){
        this.brand = p_d;
        this.model = p_m;
        this.SN = p_sn;
        this.price= p_pr;
        noOfObjects++;
    }
    /*
    Gets Price
     */
    public double getPrice() {
        return price;
    }
    /*
    fetches brand
     */
    public String getBrand() {
        return brand;
    }
    /*
    gets serial number
     */
    public long getSN() {
        return SN;
    }
    /*
    sets SN
     */
    public void setSN(long SN) {
        this.SN = SN;
    }
    /*
    sets brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /*
    sets Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
    sets model
     */
    public void setModel(String model) {
        this.model = model;
    }
    /*
    fetches model
     */
    public String getModel() {
        return model;
    }
    /*
    compares object function
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.price, price) == 0 && Objects.equals(brand, computer.brand) && Objects.equals(model, computer.model);
    }
    /*
    prints object function
     */
    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", SN=" + SN +
                ", price=" + price +
                '}';
    }
    /*
    returns number of Computer objects created
     */
    public static int findNumberOfCreatedComputers(){
        return noOfObjects;
    }

    public static void main(String[] args) {
        Computer c1 = new Computer("xx", "yy", 15000000000L, 40000);
        Computer c2 = new Computer("yz", "za", 15000000001L,34890384);
        Computer c3 = new Computer("xx", "yy",1500000001L, 40000 );
        System.out.println(c1.equals(c3));
        System.out.println(Computer.findNumberOfCreatedComputers());
    }
}
