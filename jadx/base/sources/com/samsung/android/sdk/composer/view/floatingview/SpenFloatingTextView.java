package com.samsung.android.sdk.composer.view.floatingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/floatingview/SpenFloatingTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "nativeViewId", "", "getNativeViewId", "()I", "setNativeViewId", "(I)V", "isLinkPreviewEnabled", "", "()Z", "setLinkPreviewEnabled", "(Z)V", "close", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onHoverEvent", "event", "Landroid/view/MotionEvent;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFloatingTextView extends AppCompatTextView {

    @NotNull
    private static final String TAG = "SpenFloatingTextView";
    private boolean isLinkPreviewEnabled;
    private int nativeViewId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFloatingTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isLinkPreviewEnabled = true;
    }

    public final void close() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public final int getNativeViewId() {
        return this.nativeViewId;
    }

    /* JADX INFO: renamed from: isLinkPreviewEnabled, reason: from getter */
    public final boolean getIsLinkPreviewEnabled() {
        return this.isLinkPreviewEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean focused, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isLinkPreviewEnabled) {
            return false;
        }
        super.onHoverEvent(event);
        return false;
    }

    public final void setLinkPreviewEnabled(boolean z) {
        this.isLinkPreviewEnabled = z;
    }

    public final void setNativeViewId(int i) {
        this.nativeViewId = i;
    }
}
