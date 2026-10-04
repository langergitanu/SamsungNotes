package androidx.core.util;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface SeslFadingEdgeHelper {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ScrollInfoProvider {
        int computeVerticalScrollExtent();

        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();

        int getLastItemHeightIfVisible();

        boolean shouldNormalizeFadingEdge();
    }

    void forceBottomFadingEdgeClamped(int i);

    void forceTopFadingEdgeClamped(int i);

    int getFadingEdgeBottomOffset();

    void hideBottomFadingEdge(boolean z);

    void hideTopFadingEdge(boolean z);

    boolean isFadingEdgeEnabled();

    void prepareFadingEffect(Canvas canvas, int i, int i2, int i4, int i5);

    void renderFadingEffect(Canvas canvas, ScrollInfoProvider scrollInfoProvider);

    void setAllowTopFadingEdgeWithoutEdgeToEdge(boolean z);

    void setFadingEdgeBottomOffset(int i);

    void setFadingEdgeColor(@ColorInt int i);

    void setFadingEdgeColor(@ColorInt int i, Runnable runnable);

    void setFadingEdgeEnabled(boolean z);

    void setFadingEdgeEnabled(boolean z, int i, int i2);

    void setFadingEdgeEnabled(boolean z, int i, int i2, boolean z2);

    void setFadingEdgeEnabled(boolean z, boolean z2, boolean z3);

    void setTargetView(View view);

    void setWindowBottomAlignment(boolean z);
}
