package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2Stream {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        IDLE(false, false),
        RESERVED_LOCAL(false, false),
        RESERVED_REMOTE(false, false),
        OPEN(true, true),
        HALF_CLOSED_LOCAL(false, true),
        HALF_CLOSED_REMOTE(true, false),
        CLOSED(false, false);

        private final boolean localSideOpen;
        private final boolean remoteSideOpen;

        State(boolean z, boolean z2) {
            this.localSideOpen = z;
            this.remoteSideOpen = z2;
        }

        public boolean localSideOpen() {
            return this.localSideOpen;
        }

        public boolean remoteSideOpen() {
            return this.remoteSideOpen;
        }
    }

    Http2Stream close();

    Http2Stream closeLocalSide();

    Http2Stream closeRemoteSide();

    <V> V getProperty(Http2Connection.PropertyKey propertyKey);

    Http2Stream headersReceived(boolean z);

    Http2Stream headersSent(boolean z);

    /* JADX INFO: renamed from: id */
    int mo13773id();

    boolean isHeadersReceived();

    boolean isHeadersSent();

    boolean isPushPromiseSent();

    boolean isResetSent();

    boolean isTrailersReceived();

    boolean isTrailersSent();

    Http2Stream open(boolean z);

    Http2Stream pushPromiseSent();

    <V> V removeProperty(Http2Connection.PropertyKey propertyKey);

    Http2Stream resetSent();

    <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v);

    State state();
}
