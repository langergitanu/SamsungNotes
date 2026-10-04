package io.netty.handler.codec.http2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface StreamByteDistributor {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StreamState {
        boolean hasFrame();

        long pendingBytes();

        Http2Stream stream();

        int windowSize();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Writer {
        void write(Http2Stream http2Stream, int i);
    }

    boolean distribute(int i, Writer writer);

    void updateDependencyTree(int i, int i2, short s, boolean z);

    void updateStreamableBytes(StreamState streamState);
}
