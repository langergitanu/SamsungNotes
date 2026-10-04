package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder;
import io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractInboundHttp2ToHttpAdapterBuilder<T extends InboundHttp2ToHttpAdapter, B extends AbstractInboundHttp2ToHttpAdapterBuilder<T, B>> {
    private final Http2Connection connection;
    private int maxContentLength;
    private boolean propagateSettings;
    private boolean validateHttpHeaders;

    public AbstractInboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public T build() {
        try {
            T t = (T) build(connection(), maxContentLength(), isValidateHttpHeaders(), isPropagateSettings());
            this.connection.addListener(t);
            return t;
        } catch (Throwable th) {
            throw new IllegalStateException("failed to create a new InboundHttp2ToHttpAdapter", th);
        }
    }

    public abstract T build(Http2Connection http2Connection, int i, boolean z, boolean z2);

    public Http2Connection connection() {
        return this.connection;
    }

    public boolean isPropagateSettings() {
        return this.propagateSettings;
    }

    public boolean isValidateHttpHeaders() {
        return this.validateHttpHeaders;
    }

    public int maxContentLength() {
        return this.maxContentLength;
    }

    public B propagateSettings(boolean z) {
        this.propagateSettings = z;
        return (B) self();
    }

    public B validateHttpHeaders(boolean z) {
        this.validateHttpHeaders = z;
        return (B) self();
    }

    public B maxContentLength(int i) {
        this.maxContentLength = i;
        return (B) self();
    }

    public final B self() {
        return this;
    }
}
