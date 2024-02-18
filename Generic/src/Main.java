public class Main {

    public static void main(String[] args) {
        System.out.println(Calculator.sum(0.3f,1f).getClass());
        System.out.println(Calculator.div(0.3,0));
        System.out.println(Calculator.subtract(0,0));
        Pair<String, String> pair = new Pair<>("Calculator","Calculator");
        System.out.println(pair.getFirstValue());
    }
}
