package com.samsung.android.sdk.pen.control;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "", "<init>", "()V", "onItemClicked", "", "toolType", "", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "onItemLongClicked", "onSelectedItemClicked", "onSelectedItemLongClicked", "onItemButtonClicked", "onItemShowContextAllCellsMenu", "rect", "Landroid/graphics/RectF;", "onItemShowContextRowMenu", "onItemShowContextColumnMenu", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenControlObjectListener {
    public boolean onItemButtonClicked(@Nullable SpenObjectBase objectBase) {
        return false;
    }

    public boolean onItemClicked(int toolType, @Nullable SpenObjectBase objectBase) {
        return false;
    }

    public boolean onItemLongClicked(int toolType, @Nullable SpenObjectBase objectBase) {
        return false;
    }

    public boolean onItemShowContextAllCellsMenu(@Nullable SpenObjectBase objectBase, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return false;
    }

    public boolean onItemShowContextColumnMenu(@Nullable SpenObjectBase objectBase, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return false;
    }

    public boolean onItemShowContextRowMenu(@Nullable SpenObjectBase objectBase, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return false;
    }

    public boolean onSelectedItemClicked(@Nullable SpenObjectBase objectBase) {
        return false;
    }

    public boolean onSelectedItemLongClicked(@Nullable SpenObjectBase objectBase) {
        return false;
    }
}
