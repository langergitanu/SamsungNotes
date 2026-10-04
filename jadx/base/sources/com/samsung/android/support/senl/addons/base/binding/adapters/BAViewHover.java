package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAViewHover;", "", "<init>", "()V", "setHoverListenerForConsuming", "", "view", "Landroid/view/View;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAViewHover {

    @NotNull
    public static final BAViewHover INSTANCE = new BAViewHover();

    private BAViewHover() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setHoverListenerForConsuming$lambda$0(View view, MotionEvent motionEvent) {
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setPointerIcon(view, motionEvent.getToolType(0), companion.getInstance().getHoveringSpenIconDefault());
        return true;
    }

    public final void setHoverListenerForConsuming(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnHoverListener(new ViewOnHoverListenerC7469a(6));
    }
}
