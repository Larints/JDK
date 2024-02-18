public class Compare {

    static <T> boolean compareArrays(T[] firstArray, T[] secondArray) {
        if (firstArray.length != secondArray.length) return false;

        for (int i = 0; i < firstArray.length; i++) {
            if (!firstArray[i].equals(secondArray[i])) {
                return false;
            }
        }

        return true;
    }
}
