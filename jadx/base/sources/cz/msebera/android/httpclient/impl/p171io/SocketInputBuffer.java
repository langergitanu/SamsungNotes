package cz.msebera.android.httpclient.impl.p171io;

import cz.msebera.android.httpclient.p172io.EofSensor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.eof = false;
        i = i < 0 ? socket.getReceiveBufferSize() : i;
        init(socket.getInputStream(), i < 1024 ? 1024 : i, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.p171io.AbstractSessionInputBuffer
    public int fillBuffer() {
        int iFillBuffer = super.fillBuffer();
        this.eof = iFillBuffer == -1;
        return iFillBuffer;
    }

    @Override // cz.msebera.android.httpclient.p172io.SessionInputBuffer
    public boolean isDataAvailable(int i) throws SocketException {
        boolean zHasBufferedData = hasBufferedData();
        if (zHasBufferedData) {
            return zHasBufferedData;
        }
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(i);
            fillBuffer();
            return hasBufferedData();
        } finally {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    @Override // cz.msebera.android.httpclient.p172io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
