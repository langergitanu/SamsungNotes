package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.p172io.EofSensor;
import cz.msebera.android.httpclient.p172io.HttpTransportMetrics;
import cz.msebera.android.httpclient.p172io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
public class LoggingSessionInputBuffer implements SessionInputBuffer, EofSensor {
    private final String charset;
    private final EofSensor eofSensor;

    /* JADX INFO: renamed from: in */
    private final SessionInputBuffer f8502in;
    private final Wire wire;

    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire, String str) {
        this.f8502in = sessionInputBuffer;
        this.eofSensor = sessionInputBuffer instanceof EofSensor ? (EofSensor) sessionInputBuffer : null;
        this.wire = wire;
        this.charset = str == null ? Consts.ASCII.name() : str;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.f8502in.getMetrics();
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public boolean isDataAvailable(int i) {
        return this.f8502in.isDataAvailable(i);
    }

    @Override // cz.msebera.android.httpclient.p172io.EofSensor
    public boolean isEof() {
        EofSensor eofSensor = this.eofSensor;
        if (eofSensor != null) {
            return eofSensor.isEof();
        }
        return false;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i4 = this.f8502in.read(bArr, i, i2);
        if (this.wire.enabled() && i4 > 0) {
            this.wire.input(bArr, i, i4);
        }
        return i4;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public String readLine() throws IOException {
        String line = this.f8502in.readLine();
        if (this.wire.enabled() && line != null) {
            this.wire.input(line.concat("\r\n").getBytes(this.charset));
        }
        return line;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read() throws IOException {
        int i = this.f8502in.read();
        if (this.wire.enabled() && i != -1) {
            this.wire.input(i);
        }
        return i;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        int line = this.f8502in.readLine(charArrayBuffer);
        if (this.wire.enabled() && line >= 0) {
            this.wire.input(new String(charArrayBuffer.buffer(), charArrayBuffer.length() - line, line).concat("\r\n").getBytes(this.charset));
        }
        return line;
    }

    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire) {
        this(sessionInputBuffer, wire, null);
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public int read(byte[] bArr) throws IOException {
        int i = this.f8502in.read(bArr);
        if (this.wire.enabled() && i > 0) {
            this.wire.input(bArr, 0, i);
        }
        return i;
    }
}
