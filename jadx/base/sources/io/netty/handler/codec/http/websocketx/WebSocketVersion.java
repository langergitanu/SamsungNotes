package io.netty.handler.codec.http.websocketx;

import io.netty.util.AsciiString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum WebSocketVersion {
    UNKNOWN(AsciiString.cached("")),
    V00(AsciiString.cached("0")),
    V07(AsciiString.cached("7")),
    V08(AsciiString.cached("8")),
    V13(AsciiString.cached("13"));

    private final AsciiString headerValue;

    WebSocketVersion(AsciiString asciiString) {
        this.headerValue = asciiString;
    }

    public AsciiString toAsciiString() {
        if (this != UNKNOWN) {
            return this.headerValue;
        }
        throw new IllegalStateException("Unknown web socket version: " + this);
    }

    public String toHttpHeaderValue() {
        return toAsciiString().toString();
    }
}
