package com.samsung.android.sdk.pen.recogengine.hme;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeStrokeIndices;", "", "strokeIndices", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "indices", "getIndices", "()Ljava/util/ArrayList;", "setIndices", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeStrokeIndices {

    @Nullable
    private ArrayList<Integer> indices;

    public SpenHmeStrokeIndices(@Nullable ArrayList<Integer> arrayList) {
        this.indices = arrayList;
    }

    @Nullable
    public final ArrayList<Integer> getIndices() {
        return this.indices;
    }

    public final void setIndices(@Nullable ArrayList<Integer> arrayList) {
        this.indices = arrayList;
    }
}
