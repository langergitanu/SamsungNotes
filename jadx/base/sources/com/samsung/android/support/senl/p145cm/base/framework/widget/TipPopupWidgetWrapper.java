package com.samsung.android.support.senl.p145cm.base.framework.widget;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.TipPopupImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0019J\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/widget/TipPopupWidgetWrapper;", "", "parentView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mode", "", "(Landroid/view/View;I)V", "mTipPopupImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/TipPopupImpl;", "setOnStateChangeListener", "", "changeListener", "Lcom/samsung/android/support/senl/cm/base/framework/widget/TipPopupWidgetWrapper$OnStateChangeListener;", Constants.IntentExtraValue.SHOW, "direction", "setMessage", "message", "", "setAction", "actionText", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "isShowing", "", "()Z", "dismiss", "withAnimation", "setExpanded", "expanded", "setTargetPosition", "x", "y", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "setMessageTextColor", "color", "setBackgroundColor", "setBorderColor", "OnStateChangeListener", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TipPopupWidgetWrapper {
    public static final int DIRECTION_BOTTOM_LEFT = 2;
    public static final int DIRECTION_DEFAULT = -1;
    public static final int DIRECTION_TOP_LEFT = 0;
    public static final int DIRECTION_TOP_RIGHT = 1;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRANSLUCENT = 1;
    public static final int STATE_DISMISSED = 0;
    public static final int STATE_EXPANDED = 2;
    public static final int STATE_HINT = 1;

    @NotNull
    private final TipPopupImpl mTipPopupImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/widget/TipPopupWidgetWrapper$OnStateChangeListener;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/TipPopupImpl$OnStateChangeListener;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnStateChangeListener extends TipPopupImpl.OnStateChangeListener {
    }

    public TipPopupWidgetWrapper(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.mTipPopupImpl = new TipPopupImpl(parentView);
    }

    public final void dismiss(boolean withAnimation) {
        this.mTipPopupImpl.dismiss(withAnimation);
    }

    public final boolean isShowing() {
        return this.mTipPopupImpl.isShowing();
    }

    public final void setAction(@Nullable CharSequence actionText, @Nullable View.OnClickListener listener) {
        this.mTipPopupImpl.setAction(actionText, listener);
    }

    public final void setBackgroundColor(int color) {
        this.mTipPopupImpl.setBackgroundColor(color);
    }

    public final void setBorderColor(int color) {
        this.mTipPopupImpl.setBorderColor(color);
    }

    public final void setExpanded(boolean expanded) {
        this.mTipPopupImpl.setExpanded(expanded);
    }

    public final void setMessage(@Nullable CharSequence message) {
        this.mTipPopupImpl.setMessage(message);
    }

    public final void setMessageTextColor(int color) {
        this.mTipPopupImpl.setMessageTextColor(color);
    }

    public final void setOnStateChangeListener(@Nullable OnStateChangeListener changeListener) {
        this.mTipPopupImpl.setOnStateChangeListener(changeListener);
    }

    public final void setTargetPosition(int x, int y2) {
        this.mTipPopupImpl.setTargetPosition(x, y2);
    }

    public final void show(int direction) {
        this.mTipPopupImpl.show(direction);
    }

    public final void update() {
        this.mTipPopupImpl.update();
    }

    public TipPopupWidgetWrapper(@NotNull View parentView, int i) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.mTipPopupImpl = new TipPopupImpl(parentView, i);
    }
}
