package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DataUtil {
    private static final int UNICODE_BOM = 65279;
    static final int boundaryLength = 32;
    private static final int bufferSize = 131072;
    static final String defaultCharset = "UTF-8";
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
    private static final char[] mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private DataUtil() {
    }

    public static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[131072];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static ByteBuffer emptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    public static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            String strReplace = matcher.group(1).trim().replace("charset=", "");
            if (strReplace.length() == 0) {
                return null;
            }
            try {
                if (Charset.isSupported(strReplace)) {
                    return strReplace;
                }
                String upperCase = strReplace.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    public static Document load(File file, String str, String str2) {
        return parseByteData(readFileToByteBuffer(file), str, str2, Parser.htmlParser());
    }

    public static String mimeBoundary() {
        StringBuilder sb = new StringBuilder(32);
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = mimeBoundaryChars;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Document parseByteData(ByteBuffer byteBuffer, String str, String str2, Parser parser) {
        String string;
        Document input;
        String str3 = "UTF-8";
        Document document = null;
        if (str == null) {
            string = Charset.forName("UTF-8").decode(byteBuffer).toString();
            input = parser.parseInput(string, str2);
            Element elementFirst = input.select("meta[http-equiv=content-type], meta[charset]").first();
            if (elementFirst != null) {
                String charsetFromContentType = elementFirst.hasAttr("http-equiv") ? getCharsetFromContentType(elementFirst.attr("content")) : null;
                if (charsetFromContentType == null && elementFirst.hasAttr("charset")) {
                    try {
                        if (Charset.isSupported(elementFirst.attr("charset"))) {
                            charsetFromContentType = elementFirst.attr("charset");
                        }
                    } catch (IllegalCharsetNameException unused) {
                        charsetFromContentType = null;
                    }
                }
                if (charsetFromContentType != null && charsetFromContentType.length() != 0 && !charsetFromContentType.equals("UTF-8")) {
                    str = charsetFromContentType.trim().replaceAll("[\"']", "");
                    byteBuffer.rewind();
                    string = Charset.forName(str).decode(byteBuffer).toString();
                }
            }
            if (string.length() > 0 || string.charAt(0) != UNICODE_BOM) {
                str3 = str;
                document = input;
            } else {
                byteBuffer.rewind();
                string = Charset.forName("UTF-8").decode(byteBuffer).toString().substring(1);
            }
            if (document == null) {
                return document;
            }
            Document input2 = parser.parseInput(string, str2);
            input2.outputSettings().charset(str3);
            return input2;
        }
        Validate.notEmpty(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        string = Charset.forName(str).decode(byteBuffer).toString();
        input = null;
        if (string.length() > 0) {
            str3 = str;
            document = input;
        }
        if (document == null) {
        }
    }

    public static ByteBuffer readFileToByteBuffer(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[(int) randomAccessFile2.length()];
                randomAccessFile2.readFully(bArr);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                randomAccessFile2.close();
                return byteBufferWrap;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z = i > 0;
        byte[] bArr = new byte[131072];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(131072);
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                break;
            }
            if (z) {
                if (i2 > i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= i2;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public static Document load(InputStream inputStream, String str, String str2) {
        return parseByteData(readToByteBuffer(inputStream), str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) {
        return parseByteData(readToByteBuffer(inputStream), str, str2, parser);
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream) {
        return readToByteBuffer(inputStream, 0);
    }
}
