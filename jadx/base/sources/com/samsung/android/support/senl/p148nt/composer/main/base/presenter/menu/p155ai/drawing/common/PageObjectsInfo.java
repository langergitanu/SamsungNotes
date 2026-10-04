package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common;

import android.graphics.RectF;
import android.util.Pair;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRB\u0010\u0010\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00120\u0011j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/PageObjectsInfo;", "", "<init>", "()V", "pageIndex", "", "getPageIndex", "()I", "setPageIndex", "(I)V", "contentRect", "Landroid/graphics/RectF;", "getContentRect", "()Landroid/graphics/RectF;", "setContentRect", "(Landroid/graphics/RectF;)V", "objectInfos", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "getObjectInfos", "()Ljava/util/ArrayList;", "setObjectInfos", "(Ljava/util/ArrayList;)V", "equals", "", "other", "hashCode", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageObjectsInfo {

    @Nullable
    private RectF contentRect;

    @NotNull
    private ArrayList<Pair<SpenObjectBase, Integer>> objectInfos = new ArrayList<>();
    private int pageIndex;

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof PageObjectsInfo)) {
            return super.equals(other);
        }
        PageObjectsInfo pageObjectsInfo = (PageObjectsInfo) other;
        if (this.objectInfos.size() != pageObjectsInfo.objectInfos.size()) {
            return false;
        }
        int size = this.objectInfos.size();
        for (int i = 0; i < size; i++) {
            if (!((SpenObjectBase) this.objectInfos.get(i).first).equals(pageObjectsInfo.objectInfos.get(i).first) || !Intrinsics.areEqual(this.objectInfos.get(i).second, pageObjectsInfo.objectInfos.get(i).second)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final RectF getContentRect() {
        return this.contentRect;
    }

    @NotNull
    public final ArrayList<Pair<SpenObjectBase, Integer>> getObjectInfos() {
        return this.objectInfos;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public int hashCode() {
        return PageObjectsInfo.class.hashCode();
    }

    public final void setContentRect(@Nullable RectF rectF) {
        this.contentRect = rectF;
    }

    public final void setObjectInfos(@NotNull ArrayList<Pair<SpenObjectBase, Integer>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.objectInfos = arrayList;
    }

    public final void setPageIndex(int i) {
        this.pageIndex = i;
    }
}
