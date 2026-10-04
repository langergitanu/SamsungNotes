package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u000eJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0010J'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0010J\u001d\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0014J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\u0017¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/SOLogger;", "", "<init>", "()V", "createTag", "", "tag", "d", "", "msg", "SOLoggerD", "i", "SOLoggerI", "w", "SOLoggerW", "e", "SOLoggerE", "tr", "", "f", "SOLoggerF", "getEncode", "content", "SOLoggerGetEncord", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SOLogger {

    @NotNull
    public static final SOLogger INSTANCE = new SOLogger();

    private SOLogger() {
    }

    @JvmStatic
    @NotNull
    public static final String createTag(@Nullable String tag) {
        return AbstractC0541b.m772n("CPLog$SO$", tag);
    }

    @JvmName(name = "SOLoggerD")
    public final void SOLoggerD(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m10999d(tag, msg);
    }

    @JvmName(name = "SOLoggerE")
    public final void SOLoggerE(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m11000e(tag, msg);
    }

    @JvmName(name = "SOLoggerF")
    public final void SOLoggerF(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m11002f(tag, msg);
    }

    @JvmName(name = "SOLoggerGetEncord")
    @NotNull
    public final String SOLoggerGetEncord(@Nullable String content) {
        String encode = Logger.getEncode(content);
        Intrinsics.checkNotNullExpressionValue(encode, "getEncode(...)");
        return encode;
    }

    @JvmName(name = "SOLoggerI")
    public final void SOLoggerI(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m11003i(tag, msg);
    }

    @JvmName(name = "SOLoggerW")
    public final void SOLoggerW(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m11004w(tag, msg);
    }

    @JvmName(name = "SOLoggerE")
    public final void SOLoggerE(@NotNull String tag, @NotNull String msg, @Nullable Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m11001e(tag, msg, tr);
    }
}
