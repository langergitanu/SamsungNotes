package io.netty.channel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ChannelPipelineException extends ChannelException {
    private static final long serialVersionUID = 3379174210419885980L;

    public ChannelPipelineException() {
    }

    public ChannelPipelineException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelPipelineException(String str) {
        super(str);
    }

    public ChannelPipelineException(Throwable th) {
        super(th);
    }
}
