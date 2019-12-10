public class MyCart {

    String pid, name;
    int sno, price, totalprice, quantity;

    public MyCart(String pid, String name, int price, int quantity, int totalprice) {

        this.name = name;
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }
}
