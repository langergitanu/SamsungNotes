package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableLine;", "", "data", "", "poly", "", "Landroid/graphics/Point;", "isVertical", "", "(Ljava/lang/String;[Landroid/graphics/Point;Z)V", "getData", "()Ljava/lang/String;", "()Z", "setVertical", "(Z)V", "getPoly", "()[Landroid/graphics/Point;", "setPoly", "([Landroid/graphics/Point;)V", "[Landroid/graphics/Point;", "selectableWords", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableWord;", "getSelectableWords", "()Ljava/util/List;", "getSelectableCharacters", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SelectableLine {

    @NotNull
    private final String data;
    private boolean isVertical;

    @NotNull
    private Point[] poly;

    @NotNull
    private final List<SelectableWord> selectableWords;

    public SelectableLine(@NotNull String data, @NotNull Point[] poly, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(poly, "poly");
        this.data = data;
        this.poly = poly;
        this.isVertical = z;
        this.selectableWords = new ArrayList();
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final Point[] getPoly() {
        return this.poly;
    }

    @NotNull
    public final List<SelectableCharacter> getSelectableCharacters() {
        ArrayList arrayList = new ArrayList();
        Iterator<SelectableWord> it = this.selectableWords.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getSelectableCharacters());
        }
        return arrayList;
    }

    @NotNull
    public final List<SelectableWord> getSelectableWords() {
        return this.selectableWords;
    }

    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void setPoly(@NotNull Point[] pointArr) {
        Intrinsics.checkNotNullParameter(pointArr, "<set-?>");
        this.poly = pointArr;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }
}
