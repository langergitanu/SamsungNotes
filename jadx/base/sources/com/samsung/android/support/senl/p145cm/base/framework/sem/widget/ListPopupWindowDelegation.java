package com.samsung.android.support.senl.p145cm.base.framework.sem.widget;

import android.widget.PopupWindow;
import androidx.appcompat.widget.ListPopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/ListPopupWindowDelegation;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/AbsListPopupWindowDelegation;", "<init>", "()V", "seslGetPopupWindow", "Landroid/widget/PopupWindow;", "listPopupWindow", "Landroidx/appcompat/widget/ListPopupWindow;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ListPopupWindowDelegation extends AbsListPopupWindowDelegation {
    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.widget.AbsListPopupWindowDelegation
    @Nullable
    public PopupWindow seslGetPopupWindow(@NotNull ListPopupWindow listPopupWindow) {
        Intrinsics.checkNotNullParameter(listPopupWindow, "listPopupWindow");
        return listPopupWindow.seslGetPopupWindow();
    }
}
