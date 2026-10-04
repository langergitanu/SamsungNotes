package io.netty.handler.codec.spdy;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpdyProtocolException extends Exception {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 7870000537743847264L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StacklessSpdyProtocolException extends SpdyProtocolException {
        private static final long serialVersionUID = -6302754207557485099L;

        public StacklessSpdyProtocolException(String str) {
            super(str);
        }

        public StacklessSpdyProtocolException(String str, boolean z) {
            super(str, z);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static SpdyProtocolException newStatic(String str, Class<?> cls, String str2) {
        return (SpdyProtocolException) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessSpdyProtocolException(str, true) : new StacklessSpdyProtocolException(str), cls, str2);
    }

    public SpdyProtocolException() {
    }

    public SpdyProtocolException(String str, Throwable th) {
        super(str, th);
    }

    public SpdyProtocolException(String str) {
        super(str);
    }

    public SpdyProtocolException(Throwable th) {
        super(th);
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    private SpdyProtocolException(String str, boolean z) {
        super(str, null, false, true);
    }
}
