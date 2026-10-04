package com.samsung.android.app.notes.widget.common.log;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/common/log/WidgetLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "d", "", "tag", "msg", "e", "t", "", "i", "w", "getEncode", "content", "f", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetLogger {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetLogger INSTANCE = new WidgetLogger();

    @NotNull
    private static final String TAG = "NotesWidget$";

    private WidgetLogger() {
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m5154d(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7132d(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m5155i(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7137i(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m5156w(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7138w(TAG + tag, msg);
    }

    /* JADX INFO: renamed from: e */
    public final void m5157e(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7133e(TAG + tag, msg);
    }

    /* JADX INFO: renamed from: f */
    public final void m5159f(@NotNull String tag, @Nullable String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7135f(AbstractC0541b.m772n(TAG, tag), String.valueOf(msg));
    }

    @NotNull
    public final String getEncode(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return LoggerBase.INSTANCE.getEncode(content);
    }

    /* JADX INFO: renamed from: e */
    public final void m5158e(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerBase.INSTANCE.m7134e(TAG + tag, msg, t);
    }
}
