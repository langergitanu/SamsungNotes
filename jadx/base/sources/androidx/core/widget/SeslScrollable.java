package androidx.core.widget;

import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface SeslScrollable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslOnGoToTopClickListener {
        void onGoToTopClick(SeslScrollable seslScrollable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslScrollBarOffsetChangedListener {
        void onOffsetChanged(int i, int i2);
    }

    void seslAddOnGoToTopClickListener(@NonNull SeslOnGoToTopClickListener seslOnGoToTopClickListener);

    void seslClearOnGoToTopClickListener();

    void seslForceBottomFadingEdgeClamped(int i);

    void seslForceTopFadingEdgeClamped(int i);

    @Nullable
    Rect seslGetAvailableBounds();

    int seslGetBottomScrollOffset();

    int seslGetGoToTopBottomPadding();

    int seslGetGoToTopDefaultBottomPadding();

    int seslGetHoverBottomPadding();

    int seslGetHoverDefaultBottomPadding();

    int seslGetHoverDefaultTopPadding();

    int seslGetHoverTopPadding();

    int seslGetScrollBarBottomOffset();

    int seslGetScrollBarTopOffset();

    void seslRemoveOnGoToTopClickListener(@NonNull SeslOnGoToTopClickListener seslOnGoToTopClickListener);

    void seslSetAvailableBounds(@Nullable Rect rect);

    void seslSetBottomScrollOffset(int i);

    void seslSetFadingEdgeColor(@ColorInt int i);

    void seslSetFadingEdgeEnabled(boolean z);

    void seslSetFadingEdgeEnabled(boolean z, int i, int i2);

    void seslSetFadingEdgeEnabled(boolean z, boolean z2);

    default void seslSetFadingEdgeEnabled(boolean z, boolean z2, boolean z3) {
    }

    void seslSetGoToTopBottomPadding(int i);

    void seslSetHoverBottomPadding(int i);

    void seslSetHoverTopPadding(int i);

    void seslSetScrollBarBottomOffset(int i);

    void seslSetScrollBarTopOffset(int i);

    default void seslSetFloatingBottomLayoutHeight(int i) {
    }

    default void seslSetScrollBarOffsetChangedListener(@Nullable SeslScrollBarOffsetChangedListener seslScrollBarOffsetChangedListener) {
    }
}
