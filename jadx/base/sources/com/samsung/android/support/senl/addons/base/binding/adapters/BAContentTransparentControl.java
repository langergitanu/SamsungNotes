package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAContentTransparentControl;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "defalutElevation", "", "setTransparency", "", "view", "Landroid/view/View;", "transparent", "", "setTransparencyInner", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAContentTransparentControl {

    @NotNull
    public static final BAContentTransparentControl INSTANCE = new BAContentTransparentControl();

    @NotNull
    private static final String TAG = Logger.createTag("BAContentTransparentControl");
    private static float defalutElevation = -1.0f;

    private BAContentTransparentControl() {
    }

    private final void setTransparencyInner(View view, boolean transparent) {
        Window window;
        Context context = view.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (defalutElevation == -1.0f) {
            float elevation = decorView.getElevation();
            defalutElevation = elevation;
            Logger.m7100d(TAG, "set defalut elevation = " + elevation);
        }
        float f = transparent ? 0.0f : defalutElevation;
        Logger.m7100d(TAG, "transparent = " + transparent + ", elevation = " + (decorView.getElevation() + f));
        decorView.setElevation(f);
    }

    public final void setTransparency(@NotNull View view, boolean transparent) {
        Intrinsics.checkNotNullParameter(view, "view");
        setTransparencyInner(view, transparent);
    }
}
