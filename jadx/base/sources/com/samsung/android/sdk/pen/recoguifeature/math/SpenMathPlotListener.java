package com.samsung.android.sdk.pen.recoguifeature.math;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathPlotListener;", "", "onGraphSelected", "", "graphID", "", "x", "", "y", "selected", "", "onControlVisibleChanged", "isVisible", "onClosed", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenMathPlotListener {
    void onClosed();

    void onControlVisibleChanged(boolean isVisible);

    void onGraphSelected(int graphID, float x, float y2, boolean selected);
}
