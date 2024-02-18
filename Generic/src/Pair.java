public class Pair<T, V> {

    private T firstValue;

    private V secondValue;

    public Pair(T firstValue, V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public V getSecondValue() {
        return secondValue;
    }

    public void setFirstValue(T firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(V secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                '}';
    }
}
