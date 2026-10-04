package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableEntity;", "", "data", "", "type", "polyList", "", "", "Landroid/graphics/Point;", "isVertical", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getData", "()Ljava/lang/String;", "()Z", "setVertical", "(Z)V", "overlappingLines", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableLine;", "getOverlappingLines", "()Ljava/util/List;", "getPolyList", "setPolyList", "(Ljava/util/List;)V", "selectableCharacters", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "getSelectableCharacters", "getType", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SelectableEntity {

    @NotNull
    private final String data;
    private boolean isVertical;

    @NotNull
    private final List<SelectableLine> overlappingLines;

    @NotNull
    private List<Point[]> polyList;

    @NotNull
    private final List<SelectableCharacter> selectableCharacters;

    @NotNull
    private final String type;

    public SelectableEntity(@NotNull String data, @NotNull String type, @NotNull List<Point[]> polyList, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(polyList, "polyList");
        this.data = data;
        this.type = type;
        this.polyList = polyList;
        this.isVertical = z;
        this.overlappingLines = new ArrayList();
        this.selectableCharacters = new ArrayList();
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final List<SelectableLine> getOverlappingLines() {
        return this.overlappingLines;
    }

    @NotNull
    public final List<Point[]> getPolyList() {
        return this.polyList;
    }

    @NotNull
    public final List<SelectableCharacter> getSelectableCharacters() {
        return this.selectableCharacters;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void setPolyList(@NotNull List<Point[]> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.polyList = list;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }

    public /* synthetic */ SelectableEntity(String str, String str2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, list, z);
    }
}
