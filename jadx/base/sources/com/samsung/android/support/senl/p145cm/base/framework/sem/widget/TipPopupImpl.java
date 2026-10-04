package com.samsung.android.support.senl.p145cm.base.framework.sem.widget;

import android.view.View;
import com.samsung.android.widget.SemTipPopup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/TipPopupImpl;", "Lcom/samsung/android/widget/SemTipPopup;", "parentView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mode", "", "(Landroid/view/View;I)V", "Companion", "OnStateChangeListener", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TipPopupImpl extends SemTipPopup {
    public static final int DIRECTION_BOTTOM_LEFT = 2;
    public static final int DIRECTION_BOTTOM_RIGHT = 1;
    public static final int DIRECTION_DEFAULT = -1;
    public static final int DIRECTION_TOP_LEFT = 0;
    public static final int DIRECTION_TOP_RIGHT = 1;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRANSLUCENT = 1;
    public static final int STATE_DISMISSED = 0;
    public static final int STATE_EXPANDED = 2;
    public static final int STATE_HINT = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/TipPopupImpl$OnStateChangeListener;", "Lcom/samsung/android/widget/SemTipPopup$OnStateChangeListener;", "onStateChanged", "", "var1", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnStateChangeListener extends SemTipPopup.OnStateChangeListener {
        void onStateChanged(int var1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipPopupImpl(@NotNull View parentView) {
        super(parentView);
        Intrinsics.checkNotNullParameter(parentView, "parentView");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipPopupImpl(@NotNull View parentView, int i) {
        super(parentView, i);
        Intrinsics.checkNotNullParameter(parentView, "parentView");
    }
}
