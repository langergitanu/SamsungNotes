package com.google.android.material.oneui.floatingdock;

import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.util.FloatingPaneCallbackNotifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "state", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "callbackNotifier", "Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "(ILcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "value", "getState-T0mN_rU", "()I", "setState-IywsXb8", "(I)V", "I", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FloatingPaneViewModel implements FloatingDockLogTag {

    @NotNull
    private final FloatingPaneCallbackNotifier callbackNotifier;

    @NotNull
    private final String logTag;
    private int state;

    public /* synthetic */ FloatingPaneViewModel(int i, FloatingPaneCallbackNotifier floatingPaneCallbackNotifier, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, floatingPaneCallbackNotifier);
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    /* JADX INFO: renamed from: getState-T0mN_rU, reason: not valid java name and from getter */
    public final int getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: setState-IywsXb8, reason: not valid java name */
    public final void m22108setStateIywsXb8(int i) {
        if (FloatingPane.FloatingPaneState.m22091equalsimpl0(this.state, i)) {
            return;
        }
        LogTagHelperKt.debug(this, "callback onStateChanged=" + ((Object) FloatingPane.FloatingPaneState.m22093toStringimpl(i)));
        this.callbackNotifier.onStateChanged(i);
        this.state = i;
    }

    private FloatingPaneViewModel(int i, FloatingPaneCallbackNotifier callbackNotifier) {
        Intrinsics.checkNotNullParameter(callbackNotifier, "callbackNotifier");
        this.callbackNotifier = callbackNotifier;
        this.logTag = "FloatingPaneViewModel";
        this.state = i;
    }
}
