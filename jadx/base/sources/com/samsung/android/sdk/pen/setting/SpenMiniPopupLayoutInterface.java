package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0003H&J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\fH&¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupLayoutInterface;", "", "getChildLayoutLayoutId", "", "getDefaultButtonParams", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "adjustOverlapMargin", "", "margin", "firstView", "Landroid/view/View;", "secondView", "adjustFront", "view", "frontId", "addView", "parent", "Landroid/view/ViewGroup;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenMiniPopupLayoutInterface {
    void addView(@Nullable ViewGroup parent, @Nullable View view);

    void adjustFront(@Nullable View view, int frontId);

    void adjustOverlapMargin(int margin, @Nullable View firstView, @Nullable View secondView);

    int getChildLayoutLayoutId();

    @NotNull
    LinearLayout.LayoutParams getDefaultButtonParams(@NotNull Context context);
}
