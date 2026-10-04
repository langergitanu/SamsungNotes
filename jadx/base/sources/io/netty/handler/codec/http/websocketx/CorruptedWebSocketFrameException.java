package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.CorruptedFrameException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class CorruptedWebSocketFrameException extends CorruptedFrameException {
    private static final long serialVersionUID = 3918055132492988338L;
    private final WebSocketCloseStatus closeStatus;

    public CorruptedWebSocketFrameException() {
        this(WebSocketCloseStatus.PROTOCOL_ERROR, null, null);
    }

    public WebSocketCloseStatus closeStatus() {
        return this.closeStatus;
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, String str, Throwable th) {
        super(str == null ? webSocketCloseStatus.reasonText() : str, th);
        this.closeStatus = webSocketCloseStatus;
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(webSocketCloseStatus, str, null);
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, Throwable th) {
        this(webSocketCloseStatus, null, th);
    }
}
