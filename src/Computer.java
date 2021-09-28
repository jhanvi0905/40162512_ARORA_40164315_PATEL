import java.util.Objects;

public class Computer {
    private String brand;
    private String model;
    private Long SN;
    private double price;
    private static int noOfObjects;
    public Computer(String p_d, String p_m, Long p_sn, double p_pr){
        this.brand = p_d;
        this.model = p_m;
        this.SN = p_sn;
        this.price= p_pr;
        noOfObjects++;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Long getSN() {
        return SN;
    }

    public void setSN(Long SN) {
        this.SN = SN;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.price, price) == 0 && Objects.equals(brand, computer.brand) && Objects.equals(model, computer.model);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", SN=" + SN +
                ", price=" + price +
                '}';
    }
    public static int findNumberOfCreatedComputers(){
        return noOfObjects;
    }

    public static void main(String[] args) {
        Computer c1 = new Computer("xx", "yy", 15000000000L, 40000);
        Computer c2 = new Computer("yz", "za", 15000000001L,34890384);
        Computer c3 = new Computer("xx", "yy",1500000001L, 40000 );
        System.out.println(c1.equals(c3));
        System.out.println(findNumberOfCreatedComputers());
    }
}
