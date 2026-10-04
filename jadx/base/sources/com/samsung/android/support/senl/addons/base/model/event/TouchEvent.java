package com.samsung.android.support.senl.addons.base.model.event;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\u000f\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/event/TouchEvent;", "Lcom/samsung/android/support/senl/addons/base/model/event/ITouchEvent;", "<init>", "()V", "mView", "Landroid/view/View;", "mMotionEvent", "Landroid/view/MotionEvent;", "setView", "", "view", "setEvent", "motionEvent", "getView", TextConst.METHOD_GET_EVENT, "release", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TouchEvent implements ITouchEvent {

    @Nullable
    private MotionEvent mMotionEvent;

    @Nullable
    private View mView;

    @Override // com.samsung.android.support.senl.addons.base.model.event.ITouchEvent
    @Nullable
    /* JADX INFO: renamed from: getEvent, reason: from getter */
    public MotionEvent getMMotionEvent() {
        return this.mMotionEvent;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.event.ITouchEvent
    @Nullable
    /* JADX INFO: renamed from: getView, reason: from getter */
    public View getMView() {
        return this.mView;
    }

    public final void release() {
        this.mView = null;
        this.mMotionEvent = null;
    }

    public final void setEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        this.mMotionEvent = motionEvent;
    }

    public final void setView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mView = view;
    }
}
