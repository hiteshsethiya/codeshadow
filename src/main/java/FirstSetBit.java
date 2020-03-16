public class FirstSetBit {

    public static int getFirstSetBitPos(int n) {

        // Your code here
        if (n >= 1) {
            int a = (n) ^ (n - 1);
            return (int) (Math.log(a + 1) / Math.log(2));
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getFirstSetBitPos(1));
        System.out.println(getFirstSetBitPos(18));
        System.out.println(getFirstSetBitPos(Integer.MAX_VALUE));
        System.out.println(getFirstSetBitPos(-18));
        System.out.println(getFirstSetBitPos(12));
        System.out.println(getFirstSetBitPos(0));
    }
}
