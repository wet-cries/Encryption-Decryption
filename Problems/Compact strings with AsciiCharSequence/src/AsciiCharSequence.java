public class AsciiCharSequence implements java.lang.CharSequence/* extends/implements */ {
    byte[] bytes;

    AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subSequence = new byte[end - start];
        for (int i = 0; i < subSequence.length; i++) {
            subSequence[i] = bytes[start + i];
        }
        return new AsciiCharSequence(subSequence);
    }

    public String toString() {
        return new String(bytes);
    } // implementation
}