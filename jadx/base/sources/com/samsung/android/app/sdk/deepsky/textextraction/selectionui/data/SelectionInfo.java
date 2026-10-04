package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Point;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectionInfo;", "", "selectedText", "", "selectedPolyList", "", "", "Landroid/graphics/Point;", "(Ljava/lang/String;Ljava/util/List;)V", "getSelectedPolyList", "()Ljava/util/List;", "getSelectedText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class SelectionInfo {

    @NotNull
    private final List<Point[]> selectedPolyList;

    @NotNull
    private final String selectedText;

    public SelectionInfo(@NotNull String selectedText, @NotNull List<Point[]> selectedPolyList) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(selectedPolyList, "selectedPolyList");
        this.selectedText = selectedText;
        this.selectedPolyList = selectedPolyList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SelectionInfo copy$default(SelectionInfo selectionInfo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectionInfo.selectedText;
        }
        if ((i & 2) != 0) {
            list = selectionInfo.selectedPolyList;
        }
        return selectionInfo.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSelectedText() {
        return this.selectedText;
    }

    @NotNull
    public final List<Point[]> component2() {
        return this.selectedPolyList;
    }

    @NotNull
    public final SelectionInfo copy(@NotNull String selectedText, @NotNull List<Point[]> selectedPolyList) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(selectedPolyList, "selectedPolyList");
        return new SelectionInfo(selectedText, selectedPolyList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectionInfo)) {
            return false;
        }
        SelectionInfo selectionInfo = (SelectionInfo) other;
        return Intrinsics.areEqual(this.selectedText, selectionInfo.selectedText) && Intrinsics.areEqual(this.selectedPolyList, selectionInfo.selectedPolyList);
    }

    @NotNull
    public final List<Point[]> getSelectedPolyList() {
        return this.selectedPolyList;
    }

    @NotNull
    public final String getSelectedText() {
        return this.selectedText;
    }

    public int hashCode() {
        return this.selectedPolyList.hashCode() + (this.selectedText.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "SelectionInfo(selectedText=" + this.selectedText + ", selectedPolyList=" + this.selectedPolyList + ")";
    }
}
