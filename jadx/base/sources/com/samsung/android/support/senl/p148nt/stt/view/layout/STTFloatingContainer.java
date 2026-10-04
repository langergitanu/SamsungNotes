package com.samsung.android.support.senl.p148nt.stt.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/layout/STTFloatingContainer;", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloatLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "onActionStart", "onActionEnd", "onLongPress", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTFloatingContainer extends FloatLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public STTFloatingContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    private final void init() {
        this.mHasScrollable = true;
        setClipChildren(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public STTFloatingContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public STTFloatingContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public STTFloatingContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onActionEnd() {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onActionStart() {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onLongPress() {
    }
}
