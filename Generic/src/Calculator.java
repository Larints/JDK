public class Calculator {

    static <T extends Number> Number sum(T x, T y) {
        double result = x.doubleValue() + y.doubleValue();
        if (x instanceof Double) {
            return result;
        } else if (x instanceof Float) {
            return (float) result;
        } else if (x instanceof Long) {
            return (long) result;
        } else {
            return (int) result;
        }
    }

    static <T extends Number> Number multiply(T x, T y) {
        double result = x.doubleValue() * y.doubleValue();
        if (x instanceof Double) {
            return result;
        } else if (x instanceof Float) {
            return (float) result;
        } else if (x instanceof Long) {
            return (long) result;
        } else {
            return (int) result;
        }
    }

    static <T extends Number> Number div(T x, T y) {
        if (y.doubleValue() == 0) return null;
        double result = x.doubleValue() / y.doubleValue();
        if (x instanceof Double) {
            return result;
        } else if (x instanceof Float) {
            return (float) result;
        } else if (x instanceof Long) {
            return (long) result;
        } else {
            return (int) result;
        }
    }

    static <T extends Number> Number subtract(T x, T y) {
        double result = Math.pow(x.doubleValue(), y.doubleValue());
        if (x instanceof Double) {
            return result;
        } else if (x instanceof Float) {
            return (float) result;
        } else if (x instanceof Long) {
            return (long) result;
        } else {
            return (int) result;
        }
    }
}