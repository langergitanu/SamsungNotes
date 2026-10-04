package com.samsung.android.sdk.pen.document.util;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/util/LogUtil;", "", "<init>", "()V", "isEngineerMode", "", "STR_USER_MODE", "", "logPath", "filePath", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LogUtil {

    @NotNull
    private static final String STR_USER_MODE = "[##### User mode]";

    @NotNull
    public static final LogUtil INSTANCE = new LogUtil();
    private static final boolean isEngineerMode = Intrinsics.areEqual("eng", Build.TYPE);

    private LogUtil() {
    }

    @JvmStatic
    @NotNull
    public static final String logPath(@Nullable String filePath) {
        if (!isEngineerMode) {
            return STR_USER_MODE;
        }
        Intrinsics.checkNotNull(filePath);
        return filePath;
    }
}
