package com.google.android.material.oneui.floatingactioncontainer.manager.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.SeslScrollable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.floatingactioncontainer.manager.SeslScrollableListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "", "addSeslScrollableListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/material/oneui/floatingactioncontainer/manager/SeslScrollableListener;", "dispose", "getFloatingScrollable", "Landroidx/core/widget/SeslScrollable;", "isEmptyView", "", "view", "Landroid/view/View;", "isInScreen", "availHeight", "", "appbarOffset", "appbarRange", "isValidCondition", "removeSeslScrollableListener", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface FloatingScrollableAdapter {
    static /* synthetic */ boolean isInScreen$default(FloatingScrollableAdapter floatingScrollableAdapter, int i, int i2, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isInScreen");
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return floatingScrollableAdapter.isInScreen(i, i2, i4);
    }

    void addSeslScrollableListener(@NotNull SeslScrollableListener listener);

    void dispose();

    @Nullable
    default SeslScrollable getFloatingScrollable() {
        return null;
    }

    default boolean isEmptyView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                if (it.next().getVisibility() == 0) {
                    return false;
                }
            }
        } else {
            if (view instanceof TextView) {
                CharSequence text = ((TextView) view).getText();
                return text == null || text.length() == 0;
            }
            if (view.getClass() != View.class) {
                return false;
            }
        }
        return true;
    }

    default boolean isInScreen(int availHeight, int appbarOffset, int appbarRange) {
        return false;
    }

    default boolean isValidCondition(@NotNull SeslScrollable view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rectSeslGetAvailableBounds = view.seslGetAvailableBounds();
        return rectSeslGetAvailableBounds != null && rectSeslGetAvailableBounds.bottom > 0;
    }

    void removeSeslScrollableListener(@NotNull SeslScrollableListener listener);
}
