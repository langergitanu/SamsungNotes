package com.samsung.android.sdk.pen.engine.deltaZoom;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoomListener;", "", "onZoom", "", "panX", "", "panY", "ratioX", "ratioY", "zoomRatio", "onContentRectUpdated", "left", "top", "right", "bottom", "onViewSizeUpdated", "width", "height", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenDeltaZoomListener {
    void onContentRectUpdated(float left, float top, float right, float bottom);

    void onViewSizeUpdated(float width, float height);

    void onZoom(float panX, float panY, float ratioX, float ratioY, float zoomRatio);
}
