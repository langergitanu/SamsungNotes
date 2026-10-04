package com.google.android.material.oneui.floatingactioncontainer;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware;", "", "getReferenceView", "Landroid/view/View;", "type", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware$PositionType;", "getReferenceViewInset", "Landroid/graphics/Rect;", "getReferenceViews", "", "onFloatingViewConfigurationChanged", "", Constants.IntentExtraValue.SHOW, "", "newConfig", "Landroid/content/res/Configuration;", "onStartHideFloatingBackground", "onStartShowFloatingBackground", "PositionType", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface FloatingAware {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware$PositionType;", "", "(Ljava/lang/String;I)V", "START_FIRST", "START_SECOND", "END_FIRST", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum PositionType {
        START_FIRST,
        START_SECOND,
        END_FIRST
    }

    @Nullable
    View getReferenceView(@NotNull PositionType type);

    @NotNull
    default Rect getReferenceViewInset(@NotNull PositionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new Rect();
    }

    @Nullable
    default List<View> getReferenceViews(@NotNull PositionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    default void onStartHideFloatingBackground() {
    }

    default void onStartShowFloatingBackground() {
    }

    default void onFloatingViewConfigurationChanged(boolean show, @Nullable Configuration newConfig) {
    }
}
