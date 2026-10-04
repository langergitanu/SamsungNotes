package com.google.android.material.oneui.floatingdock.controller;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.util.Consumer;
import androidx.core.util.Predicate;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.oneui.common.internal.util.ViewHelperKt;
import com.google.android.material.oneui.floatingdock.FloatingDockLogTag;
import com.google.android.material.oneui.floatingdock.util.HapticFeedbackHelper;
import com.google.android.material.oneui.floatingdock.util.PolicyHelperKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0#H\u0002J\u000e\u0010$\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u000e\u0010&\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010'\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001fH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/controller/DragHandlerController;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "view", "Landroid/view/View;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "onClickListener", "Landroid/view/View$OnClickListener;", "onLongPress", "Landroidx/core/util/Consumer;", "", "(Landroid/view/View;Landroid/view/View$OnTouchListener;Landroid/view/View$OnClickListener;Landroidx/core/util/Consumer;)V", "actionDownStart", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "isInArea", "ev", "Landroid/view/MotionEvent;", "onEventInternal", "event", "trigger", "Landroidx/core/util/Predicate;", "onInterceptTouchEvent", "onInterceptTouchTrigger", "onTouchEvent", "onTouchEventTrigger", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDragHandlerController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragHandlerController.kt\ncom/google/android/material/oneui/floatingdock/controller/DragHandlerController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,109:1\n1#2:110\n*E\n"})
public final class DragHandlerController implements FloatingDockLogTag {
    private boolean actionDownStart;
    private final Context context;

    /* JADX INFO: renamed from: gestureDetector$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gestureDetector;

    @NotNull
    private final String logTag;

    @NotNull
    private final View view;

    public DragHandlerController(@NotNull View view, @NotNull final View.OnTouchListener onTouchListener, @NotNull final View.OnClickListener onClickListener, @NotNull final Consumer<Unit> onLongPress) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Intrinsics.checkNotNullParameter(onLongPress, "onLongPress");
        this.view = view;
        this.logTag = "DragHandlerController";
        this.context = view.getContext();
        this.gestureDetector = LazyKt.lazy(new Function0<GestureDetector>() { // from class: com.google.android.material.oneui.floatingdock.controller.DragHandlerController$gestureDetector$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetector invoke() {
                Context context = this.this$0.context;
                final View.OnTouchListener onTouchListener2 = onTouchListener;
                final DragHandlerController dragHandlerController = this.this$0;
                final View.OnClickListener onClickListener2 = onClickListener;
                final Consumer<Unit> consumer = onLongPress;
                return new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.oneui.floatingdock.controller.DragHandlerController$gestureDetector$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onDown(MotionEvent e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        onTouchListener2.onTouch(dragHandlerController.getView(), e);
                        HapticFeedbackHelper.INSTANCE.onTap(dragHandlerController.getView());
                        return true;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public void onLongPress(MotionEvent e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        consumer.accept(Unit.INSTANCE);
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(MotionEvent e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        onClickListener2.onClick(dragHandlerController.getView());
                        return true;
                    }
                });
            }
        });
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.google.android.material.oneui.floatingdock.controller.DragHandlerController.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                Context context = DragHandlerController.this.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                info.setClickable(!PolicyHelperKt.isPhoneSize(context));
                info.setLongClickable(true);
            }
        });
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    private final boolean onEventInternal(MotionEvent event, Predicate<MotionEvent> trigger) {
        if (event.getAction() == 0) {
            this.actionDownStart = isInArea(this.view, event);
        }
        boolean z = this.actionDownStart && trigger.test(event);
        if (event.getAction() != 3 && event.getAction() != 1) {
            return z;
        }
        this.actionDownStart = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onInterceptTouchEvent$lambda$0(DragHandlerController this$0, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(motionEvent, "motionEvent");
        return this$0.onInterceptTouchTrigger(motionEvent);
    }

    private final boolean onInterceptTouchTrigger(MotionEvent event) {
        boolean zOnTouchEvent = getGestureDetector().onTouchEvent(event);
        LogTagHelperKt.debugTouch(this, "onInterceptTouchEventInternal result=" + zOnTouchEvent);
        return zOnTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTouchEvent$lambda$2(DragHandlerController this$0, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(motionEvent, "motionEvent");
        return this$0.onTouchEventTrigger(motionEvent);
    }

    private final boolean onTouchEventTrigger(MotionEvent event) {
        boolean zOnTouchEvent = getGestureDetector().onTouchEvent(event);
        StringBuilder sbM3200j = AbstractC4539a.m3200j("onTouchEventInternal value=", " result=", zOnTouchEvent);
        sbM3200j.append(event.getAction() != 0 && zOnTouchEvent);
        LogTagHelperKt.debugTouch(this, sbM3200j.toString());
        return event.getAction() != 0 && zOnTouchEvent;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public final boolean isInArea(@NotNull View view, @NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ev, "ev");
        Rect rect = new Rect();
        ViewHelperKt.getCurrentLayoutBounds(view, rect);
        return rect.contains((int) ev.getX(), (int) ev.getY());
    }

    public final boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return onEventInternal(event, new C4792a(this, 0));
    }

    public final boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return onEventInternal(event, new C4792a(this, 1));
    }
}
