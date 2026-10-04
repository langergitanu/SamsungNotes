package com.samsung.android.sdk.scs.p142ai.asr.p143io;

import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class NullOutputStream extends OutputStream {
    private final String TAG = "NullOutputStream@" + hashCode();
    private volatile boolean closed;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        Log.m6489i(this.TAG, "closed");
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        ensureOpen();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int length = bArr.length;
        if (i >= 0 && i2 >= 0 && length >= 0 && i <= length - i2) {
            ensureOpen();
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i, "Range [", SQLKeyword.COMMA, " + ");
        sbM1173s.append(i2);
        sbM1173s.append(") out of bounds for length ");
        sbM1173s.append(length);
        throw new IndexOutOfBoundsException(sbM1173s.toString());
    }
}
