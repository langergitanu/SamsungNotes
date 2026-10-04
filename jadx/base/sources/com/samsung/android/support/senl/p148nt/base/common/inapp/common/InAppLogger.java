package com.samsung.android.support.senl.p148nt.base.common.inapp.common;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/common/InAppLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "d", "", "tag", "msg", "e", "t", "", "i", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppLogger {

    @NotNull
    public static final InAppLogger INSTANCE = new InAppLogger();

    @NotNull
    private static final String TAG = "InApp$";

    private InAppLogger() {
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8595d(@Nullable String tag, @Nullable String msg) {
        LoggerBase.INSTANCE.m7132d(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8596e(@Nullable String tag, @Nullable String msg) {
        LoggerBase.INSTANCE.m7133e(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m8598i(@Nullable String tag, @Nullable String msg) {
        LoggerBase.INSTANCE.m7137i(TAG + tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8597e(@Nullable String tag, @Nullable String msg, @Nullable Throwable t) {
        LoggerBase.INSTANCE.m7134e(TAG + tag, msg, t);
    }
}
