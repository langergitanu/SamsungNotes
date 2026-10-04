package com.samsung.scsp.framework.core.network;

import com.samsung.scsp.framework.core.ScspException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ByteBufferWriter {
    private static final int BUFFER_SIZE = 327680;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BufferWriterListener {
        void onWritten(long j);
    }

    public static void write(OutputStream outputStream, InputStream inputStream, BufferWriterListener bufferWriterListener, long j) throws ScspException {
        try {
            byte[] bArr = new byte[327680];
            while (j > 0) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                }
                long j2 = i;
                j -= j2;
                outputStream.write(bArr, 0, i);
                if (bufferWriterListener != null) {
                    bufferWriterListener.onWritten(j2);
                }
            }
        } catch (Throwable th) {
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, "An error occurred while transmitting data to the server.", th);
        }
    }
}
