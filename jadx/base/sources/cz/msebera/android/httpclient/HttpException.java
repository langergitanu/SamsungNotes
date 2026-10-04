package cz.msebera.android.httpclient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HttpException extends Exception {
    private static final int FIRST_VALID_CHAR = 32;
    private static final long serialVersionUID = -5437299376222011036L;

    public HttpException() {
    }

    public static String clean(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length && charArray[i] >= ' ') {
            i++;
        }
        if (i == charArray.length) {
            return str;
        }
        StringBuilder sb = new StringBuilder(charArray.length * 2);
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (c < ' ') {
                sb.append("[0x");
                String hexString = Integer.toHexString(i2);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append("]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public HttpException(String str) {
        super(clean(str));
    }

    public HttpException(String str, Throwable th) {
        super(clean(str));
        initCause(th);
    }
}
