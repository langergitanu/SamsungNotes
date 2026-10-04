package io.netty.handler.codec;

import io.netty.util.Signal;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DecoderResult {
    protected static final Signal SIGNAL_SUCCESS;
    protected static final Signal SIGNAL_UNFINISHED;
    public static final DecoderResult SUCCESS;
    public static final DecoderResult UNFINISHED;
    private final Throwable cause;

    static {
        Signal signalValueOf = Signal.valueOf(DecoderResult.class, "UNFINISHED");
        SIGNAL_UNFINISHED = signalValueOf;
        Signal signalValueOf2 = Signal.valueOf(DecoderResult.class, "SUCCESS");
        SIGNAL_SUCCESS = signalValueOf2;
        UNFINISHED = new DecoderResult(signalValueOf);
        SUCCESS = new DecoderResult(signalValueOf2);
    }

    public DecoderResult(Throwable th) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
    }

    public static DecoderResult failure(Throwable th) {
        return new DecoderResult((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    public Throwable cause() {
        if (isFailure()) {
            return this.cause;
        }
        return null;
    }

    public boolean isFailure() {
        Throwable th = this.cause;
        return (th == SIGNAL_SUCCESS || th == SIGNAL_UNFINISHED) ? false : true;
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public String toString() {
        if (!isFinished()) {
            return "unfinished";
        }
        if (isSuccess()) {
            return "success";
        }
        String string = cause().toString();
        StringBuilder sb = new StringBuilder(string.length() + 17);
        sb.append("failure(");
        sb.append(string);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
