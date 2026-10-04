package io.grpc.okhttp.internal.framed;

import java.io.Closeable;
import java.util.List;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface FrameWriter extends Closeable {
    void ackSettings(Settings settings);

    void connectionPreface();

    void data(boolean z, int i, Buffer buffer, int i2);

    void flush();

    void goAway(int i, ErrorCode errorCode, byte[] bArr);

    void headers(int i, List<Header> list);

    int maxDataLength();

    void ping(boolean z, int i, int i2);

    void pushPromise(int i, int i2, List<Header> list);

    void rstStream(int i, ErrorCode errorCode);

    void settings(Settings settings);

    void synReply(boolean z, int i, List<Header> list);

    void synStream(boolean z, boolean z2, int i, int i2, List<Header> list);

    void windowUpdate(int i, long j);
}
