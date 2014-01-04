package generic.test;

public class GenericTest {

    public static void main(String[] args) {
        B a = (B)(new A());
        a.print();
    }

}
