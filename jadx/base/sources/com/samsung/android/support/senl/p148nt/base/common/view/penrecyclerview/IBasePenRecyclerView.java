package com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/IBasePenRecyclerView;", "", "getWidth", "", "getHeight", "getChildCount", "getChildAt", "Landroid/view/View;", "index", "getChildAdapterPosition", "child", "invalidate", "", "getGapStrategy", "setGapStrategy", "gapStrategy", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBasePenRecyclerView {
    int getChildAdapterPosition(@NotNull View child);

    @NotNull
    View getChildAt(int index);

    int getChildCount();

    int getGapStrategy();

    int getHeight();

    int getWidth();

    void invalidate();

    void setGapStrategy(int gapStrategy);
}
