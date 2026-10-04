package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LoggingInputStream extends FilterInputStream {
    private final LoggingByteArrayOutputStream logStream;

    public LoggingInputStream(InputStream inputStream, Logger logger, Level level, int i) {
        super(inputStream);
        this.logStream = new LoggingByteArrayOutputStream(logger, level, i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.logStream.close();
        super.close();
    }

    public final LoggingByteArrayOutputStream getLogStream() {
        return this.logStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        this.logStream.write(i);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i4 = super.read(bArr, i, i2);
        if (i4 > 0) {
            this.logStream.write(bArr, i, i4);
        }
        return i4;
    }
}
