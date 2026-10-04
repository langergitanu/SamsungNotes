package com.samsung.android.sdk.pen.setting.common;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenTouchDelegate;", "", "<init>", "()V", "setDelegateToParent", "", "parent", "Landroid/view/View;", "child", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTouchDelegate {

    @NotNull
    public static final SpenTouchDelegate INSTANCE = new SpenTouchDelegate();

    private SpenTouchDelegate() {
    }

    @JvmStatic
    public static final void setDelegateToParent(@NotNull View parent, @NotNull View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        parent.post(new RunnableC7563h(parent, child, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDelegateToParent$lambda$1(View view, View view2) {
        view.setTouchDelegate(new TouchDelegate(new Rect(0, 0, view.getWidth(), view.getHeight()), view2));
    }
}
