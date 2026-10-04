package com.google.android.material.oneui.floatingdock;

import android.graphics.Rect;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001!J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001d\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0015\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback;", "", "onFloatingMoved", "", "left", "", "top", "onInsert", "rect", "Landroid/graphics/Rect;", "onLayoutChanged", "right", "bottom", "onMinimizedChanged", "mode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "isMinimized", "", "(IZ)V", "onModeChanged", "newMode", "(I)V", "onPreInsert", "onResizeAnimate", Constants.MessagePayloadKeys.FROM, "to", XmlErrorCodes.DURATION, "", "onStateChanged", "state", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "onVisibilityChanged", "visibility", "AnimationListener", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface IFloatingPaneCallback {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;", "", "onAnimationEnd", "", "value", "Landroid/graphics/Rect;", "onAnimationStart", "onAnimationUpdate", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface AnimationListener {
        void onAnimationEnd(@NotNull Rect value);

        void onAnimationStart(@NotNull Rect value);

        void onAnimationUpdate(@NotNull Rect value);
    }

    default void onResizeAnimate(@NotNull Rect from, @NotNull Rect to, long duration) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    default void onInsert(@Nullable Rect rect) {
    }

    @JvmName(name = "onModeChanged")
    default void onModeChanged(int newMode) {
    }

    default void onPreInsert(@Nullable Rect rect) {
    }

    @JvmName(name = "onStateChanged")
    default void onStateChanged(int state) {
    }

    default void onVisibilityChanged(int visibility) {
    }

    default void onFloatingMoved(int left, int top) {
    }

    @JvmName(name = "onMinimizedChanged")
    default void onMinimizedChanged(int mode, boolean isMinimized) {
    }

    default void onLayoutChanged(int left, int top, int right, int bottom) {
    }
}
