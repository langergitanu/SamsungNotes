package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/util/ClipboardUtil;", "", "()V", "copyClipboard", "", "context", "Landroid/content/Context;", "text", "", "setPrimaryClip", "", "clip", "Landroid/content/ClipData;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ClipboardUtil {

    @NotNull
    public static final ClipboardUtil INSTANCE = new ClipboardUtil();

    private ClipboardUtil() {
    }

    private final boolean setPrimaryClip(Context context, ClipData clip) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        try {
            ((ClipboardManager) systemService).setPrimaryClip(clip);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void copyClipboard(@NotNull Context context, @NotNull String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        ClipData copyData = ClipData.newPlainText(null, text);
        Intrinsics.checkNotNullExpressionValue(copyData, "copyData");
        setPrimaryClip(context, copyData);
    }
}
