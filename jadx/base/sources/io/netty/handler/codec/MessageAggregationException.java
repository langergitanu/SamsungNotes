package io.netty.handler.codec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class MessageAggregationException extends IllegalStateException {
    private static final long serialVersionUID = -1995826182950310255L;

    public MessageAggregationException() {
    }

    public MessageAggregationException(String str) {
        super(str);
    }

    public MessageAggregationException(String str, Throwable th) {
        super(str, th);
    }

    public MessageAggregationException(Throwable th) {
        super(th);
    }
}
