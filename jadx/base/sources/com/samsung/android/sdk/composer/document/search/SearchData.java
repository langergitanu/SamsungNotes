package com.samsung.android.sdk.composer.document.search;

import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/search/SearchData;", "", "_pageIndex", "", "_isFills", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "_rects", "Landroid/graphics/RectF;", "<init>", "(ILjava/util/ArrayList;Ljava/util/ArrayList;)V", "pageIndex", "getPageIndex", "()I", "IsFills", "getIsFills", "()Ljava/util/ArrayList;", "rects", "getRects", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SearchData {

    @Nullable
    private final ArrayList<Boolean> IsFills;
    private final int pageIndex;

    @Nullable
    private final ArrayList<RectF> rects;

    public SearchData(int i, @Nullable ArrayList<Boolean> arrayList, @Nullable ArrayList<RectF> arrayList2) {
        this.pageIndex = i;
        this.IsFills = arrayList;
        this.rects = arrayList2;
    }

    @Nullable
    public final ArrayList<Boolean> getIsFills() {
        return this.IsFills;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    @Nullable
    public final ArrayList<RectF> getRects() {
        return this.rects;
    }
}
