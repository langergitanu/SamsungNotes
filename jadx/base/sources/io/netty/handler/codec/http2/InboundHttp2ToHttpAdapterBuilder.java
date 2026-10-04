package io.netty.handler.codec.http2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class InboundHttp2ToHttpAdapterBuilder extends AbstractInboundHttp2ToHttpAdapterBuilder<InboundHttp2ToHttpAdapter, InboundHttp2ToHttpAdapterBuilder> {
    public InboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        super(http2Connection);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapter build() {
        return super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapter build(Http2Connection http2Connection, int i, boolean z, boolean z2) {
        return new InboundHttp2ToHttpAdapter(http2Connection, i, z, z2);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder maxContentLength(int i) {
        return (InboundHttp2ToHttpAdapterBuilder) super.maxContentLength(i);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder propagateSettings(boolean z) {
        return (InboundHttp2ToHttpAdapterBuilder) super.propagateSettings(z);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder validateHttpHeaders(boolean z) {
        return (InboundHttp2ToHttpAdapterBuilder) super.validateHttpHeaders(z);
    }
}
