package opennlp.tools.p217ml.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ModelParameterChunker {
    private static final int MAX_CHUNK_SIZE_BYTES = 65535;
    public static final String SIGNATURE_CHUNKED_PARAMS = "CHUNKED-MODEL-PARAMS:";

    private ModelParameterChunker() {
    }

    public static String readUTF(DataInputStream dataInputStream) throws IOException {
        String utf = dataInputStream.readUTF();
        if (!utf.startsWith(SIGNATURE_CHUNKED_PARAMS)) {
            return utf;
        }
        int i = Integer.parseInt(utf.replace(SIGNATURE_CHUNKED_PARAMS, ""));
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(dataInputStream.readUTF());
        }
        return sb.toString();
    }

    private static String[] splitByByteLength(String str) {
        CharBuffer charBufferWrap = CharBuffer.wrap(str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(65535);
        CharsetEncoder charsetEncoderNewEncoder = StandardCharsets.UTF_8.newEncoder();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            CoderResult coderResultEncode = charsetEncoderNewEncoder.encode(charBufferWrap, byteBufferAllocate, true);
            int length = str.length() - charBufferWrap.length();
            arrayList.add(str.substring(i, length));
            if (!coderResultEncode.isOverflow()) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            i = length;
        }
    }

    public static void writeUTF(DataOutputStream dataOutputStream, String str) throws IOException {
        try {
            dataOutputStream.writeUTF(str);
        } catch (UTFDataFormatException unused) {
            String[] strArrSplitByByteLength = splitByByteLength(str);
            dataOutputStream.writeUTF(SIGNATURE_CHUNKED_PARAMS + strArrSplitByByteLength.length);
            for (String str2 : strArrSplitByByteLength) {
                dataOutputStream.writeUTF(str2);
            }
        }
    }
}
