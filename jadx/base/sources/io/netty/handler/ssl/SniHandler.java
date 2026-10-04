package io.netty.handler.ssl;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.util.AsyncMapping;
import io.netty.util.DomainNameMapping;
import io.netty.util.Mapping;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SniHandler extends AbstractSniHandler<SslContext> {
    private static final Selection EMPTY_SELECTION = new Selection(null, null);
    protected final AsyncMapping<String, SslContext> mapping;
    private volatile Selection selection;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AsyncMappingAdapter implements AsyncMapping<String, SslContext> {
        private final Mapping<? super String, ? extends SslContext> mapping;

        private AsyncMappingAdapter(Mapping<? super String, ? extends SslContext> mapping) {
            this.mapping = (Mapping) ObjectUtil.checkNotNull(mapping, "mapping");
        }

        @Override // io.netty.util.AsyncMapping
        public Future<SslContext> map(String str, Promise<SslContext> promise) {
            try {
                return promise.setSuccess(this.mapping.map(str));
            } catch (Throwable th) {
                return promise.setFailure(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Selection {
        final SslContext context;
        final String hostname;

        public Selection(SslContext sslContext, String str) {
            this.context = sslContext;
            this.hostname = str;
        }
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping) {
        this(new AsyncMappingAdapter(mapping));
    }

    public String hostname() {
        return this.selection.hostname;
    }

    @Override // io.netty.handler.ssl.AbstractSniHandler
    public Future<SslContext> lookup(ChannelHandlerContext channelHandlerContext, String str) {
        return this.mapping.map(str, channelHandlerContext.executor().newPromise());
    }

    public SslHandler newSslHandler(SslContext sslContext, ByteBufAllocator byteBufAllocator) {
        SslHandler sslHandlerNewHandler = sslContext.newHandler(byteBufAllocator);
        sslHandlerNewHandler.setHandshakeTimeoutMillis(this.handshakeTimeoutMillis);
        return sslHandlerNewHandler;
    }

    @Override // io.netty.handler.ssl.AbstractSniHandler
    public final void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<SslContext> future) throws Throwable {
        if (!future.isSuccess()) {
            Throwable thCause = future.cause();
            if (!(thCause instanceof Error)) {
                throw new DecoderException(AbstractC0541b.m772n("failed to get the SslContext for ", str), thCause);
            }
            throw ((Error) thCause);
        }
        SslContext now = future.getNow();
        this.selection = new Selection(now, str);
        try {
            replaceHandler(channelHandlerContext, str, now);
        } catch (Throwable th) {
            this.selection = EMPTY_SELECTION;
            PlatformDependent.throwException(th);
        }
    }

    public void replaceHandler(ChannelHandlerContext channelHandlerContext, String str, SslContext sslContext) {
        SslHandler sslHandlerNewSslHandler = null;
        try {
            sslHandlerNewSslHandler = newSslHandler(sslContext, channelHandlerContext.alloc());
            channelHandlerContext.pipeline().replace(this, SslHandler.class.getName(), sslHandlerNewSslHandler);
        } catch (Throwable th) {
            if (sslHandlerNewSslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandlerNewSslHandler.engine());
            }
            throw th;
        }
    }

    public SslContext sslContext() {
        return this.selection.context;
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping, long j) {
        this(new AsyncMappingAdapter(mapping), j);
    }

    public SniHandler(DomainNameMapping<? extends SslContext> domainNameMapping) {
        this((Mapping<? super String, ? extends SslContext>) domainNameMapping);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping) {
        this(asyncMapping, 0L);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping, long j) {
        super(j);
        this.selection = EMPTY_SELECTION;
        this.mapping = (AsyncMapping) ObjectUtil.checkNotNull(asyncMapping, "mapping");
    }
}
