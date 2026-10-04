package io.netty.handler.codec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class PrematureChannelClosureException extends CodecException {
    private static final long serialVersionUID = 4907642202594703094L;

    public PrematureChannelClosureException() {
    }

    public PrematureChannelClosureException(String str, Throwable th) {
        super(str, th);
    }

    public PrematureChannelClosureException(String str) {
        super(str);
    }

    public PrematureChannelClosureException(Throwable th) {
        super(th);
    }
}
