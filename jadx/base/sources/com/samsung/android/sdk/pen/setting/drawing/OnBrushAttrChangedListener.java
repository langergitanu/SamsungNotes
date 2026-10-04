package com.samsung.android.sdk.pen.setting.drawing;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/OnBrushAttrChangedListener;", "", "onSizeChanged", "", "size", "", "sizeLevel", "", "onOpacityChanged", "color", "onDensityChanged", "density", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface OnBrushAttrChangedListener {
    void onDensityChanged(int density);

    void onOpacityChanged(int color);

    void onSizeChanged(float size, int sizeLevel);
}
