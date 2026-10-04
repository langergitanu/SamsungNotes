package com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p059N3.ViewOnApplyWindowInsetsListenerC0186a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/util/CaptionBarHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "NOT_MEASURED", "", "sCaptionBarHeight", "init", "", "rootView", "Landroid/view/View;", "release", "getCaptionBarHeight", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CaptionBarHelper {
    private static final int NOT_MEASURED = 0;
    private static int sCaptionBarHeight;

    @NotNull
    public static final CaptionBarHelper INSTANCE = new CaptionBarHelper();

    @NotNull
    private static final String TAG = Logger.createTag("CaptionBarHelper");

    private CaptionBarHelper() {
    }

    @JvmStatic
    public static final int getCaptionBarHeight(@Nullable Context context) {
        if (DesktopModeCompat.INSTANCE.getInstance().isDexNewDexMode(context)) {
            return sCaptionBarHeight;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets init$lambda$0(View view, View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (sCaptionBarHeight != 0) {
            view.setOnApplyWindowInsetsListener(null);
            return v.onApplyWindowInsets(insets);
        }
        Intrinsics.checkNotNullExpressionValue(insets.getInsets(WindowInsets.Type.captionBar()), "getInsets(...)");
        int iAbs = (int) Math.abs(r0.top - r0.bottom);
        if (iAbs != 0) {
            sCaptionBarHeight = iAbs;
            view.setOnApplyWindowInsetsListener(null);
            AbstractC4539a.m3203m(sCaptionBarHeight, "init sCaptionBarHeight ", TAG);
        }
        return v.onApplyWindowInsets(insets);
    }

    @SuppressLint({WarningType.NewApi})
    public final void init(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Logger.m8697d(TAG, "init");
        if (DesktopModeCompat.INSTANCE.getInstance().isDexNewDexMode(rootView.getContext())) {
            rootView.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0186a(rootView, 3));
        }
    }

    public final void release(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Logger.m8697d(TAG, "release");
        if (DesktopModeCompat.INSTANCE.getInstance().isDexNewDexMode(rootView.getContext())) {
            rootView.setOnApplyWindowInsetsListener(null);
            sCaptionBarHeight = 0;
        }
    }
}
