package javaIn;



public class BitVector {

    private long[] bitSize ;
    public BitVector () {

    }

    public BitVector (int size) {

        int count = ((size - 1) / 64) + 1;

         bitSize = new long[count];

    }
    public void set(int setNum) {
        long xor = 1;


        if (setNum <= 64){
            xor <<= (setNum - 1);
            long l = bitSize[0] & xor;
            if (l != xor) {
                bitSize[0] = bitSize[0] ^ xor;
            }
        } else {
            int longIndex = setNum / 64;
            int flag = setNum - (64 * (longIndex + 1));
            xor <<= flag -1;
            long l = bitSize[longIndex] & xor;
            if (l != xor) {
                bitSize[longIndex] = bitSize[longIndex] ^ xor;
          }
        }
    }

    public void reSet(int setNum) {
        long xor = 1;

        if (setNum <= 64) {
            xor <<= (setNum - 1);
            long l = bitSize[0] & xor;
            if (l == xor) {
                bitSize[0] = bitSize[0] ^ xor;
            }
        } else {
            int longIndex = setNum / 64;
            int flag = setNum - (64 * (longIndex + 1));
            xor <<= flag -1;
            long l = bitSize[longIndex] & xor;
            if (l == xor) {
                bitSize[longIndex] = bitSize[longIndex] ^ xor;
            }
        }
    }
}
