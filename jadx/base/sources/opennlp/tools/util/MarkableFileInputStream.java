package opennlp.tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class MarkableFileInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    private final FileInputStream f9697in;
    private IOException markException;
    private long markedPosition = -1;

    public MarkableFileInputStream(File file) {
        this.f9697in = new FileInputStream(file);
    }

    private void throwMarkExceptionIfOccurred() throws IOException {
        IOException iOException = this.markException;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        try {
            this.markedPosition = this.f9697in.getChannel().position();
        } catch (IOException unused) {
            this.markedPosition = -1L;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f9697in.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throwMarkExceptionIfOccurred();
        if (this.markedPosition < 0) {
            throw new IOException("Stream has to be marked before it can be reset!");
        }
        this.f9697in.getChannel().position(this.markedPosition);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.f9697in.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.f9697in.read(bArr, i, i2);
    }
}
