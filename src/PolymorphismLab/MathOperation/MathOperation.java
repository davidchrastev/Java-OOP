package PolymorphismLab.MathOperation;

public class MathOperation {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return add(a,add(b,c));
    }

    public int add(int a, int b,int c,int d) {
        return add(a,add(b,c,a));
    }
    public void sout(){
        System.out.println("asdasdasdasda");
        sout();

    }


}
