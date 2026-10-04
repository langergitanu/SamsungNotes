package com.samsung.android.sdk.pdf;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\nHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "", "title", "", DBSchema.CategoryTreeClosure.DEPTH, "", "pageIndex", "pageLabel", "children", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;)V", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "getDepth", "()I", "getPageIndex", "getPageLabel", "getChildren", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenPdfBookmark {

    @NotNull
    private final ArrayList<SpenPdfBookmark> children;
    private final int depth;
    private final int pageIndex;

    @Nullable
    private final String pageLabel;

    @Nullable
    private final String title;

    public SpenPdfBookmark(@Nullable String str, int i, int i2, @Nullable String str2, @NotNull ArrayList<SpenPdfBookmark> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        this.title = str;
        this.depth = i;
        this.pageIndex = i2;
        this.pageLabel = str2;
        this.children = children;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpenPdfBookmark copy$default(SpenPdfBookmark spenPdfBookmark, String str, int i, int i2, String str2, ArrayList arrayList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = spenPdfBookmark.title;
        }
        if ((i4 & 2) != 0) {
            i = spenPdfBookmark.depth;
        }
        if ((i4 & 4) != 0) {
            i2 = spenPdfBookmark.pageIndex;
        }
        if ((i4 & 8) != 0) {
            str2 = spenPdfBookmark.pageLabel;
        }
        if ((i4 & 16) != 0) {
            arrayList = spenPdfBookmark.children;
        }
        ArrayList arrayList2 = arrayList;
        int i5 = i2;
        return spenPdfBookmark.copy(str, i, i5, str2, arrayList2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPageLabel() {
        return this.pageLabel;
    }

    @NotNull
    public final ArrayList<SpenPdfBookmark> component5() {
        return this.children;
    }

    @NotNull
    public final SpenPdfBookmark copy(@Nullable String title, int depth, int pageIndex, @Nullable String pageLabel, @NotNull ArrayList<SpenPdfBookmark> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        return new SpenPdfBookmark(title, depth, pageIndex, pageLabel, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenPdfBookmark)) {
            return false;
        }
        SpenPdfBookmark spenPdfBookmark = (SpenPdfBookmark) other;
        return Intrinsics.areEqual(this.title, spenPdfBookmark.title) && this.depth == spenPdfBookmark.depth && this.pageIndex == spenPdfBookmark.pageIndex && Intrinsics.areEqual(this.pageLabel, spenPdfBookmark.pageLabel) && Intrinsics.areEqual(this.children, spenPdfBookmark.children);
    }

    @NotNull
    public final ArrayList<SpenPdfBookmark> getChildren() {
        return this.children;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    @Nullable
    public final String getPageLabel() {
        return this.pageLabel;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iM1157c = AbstractC0622a.m1157c(this.pageIndex, AbstractC0622a.m1157c(this.depth, (str == null ? 0 : str.hashCode()) * 31, 31), 31);
        String str2 = this.pageLabel;
        return this.children.hashCode() + ((iM1157c + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        int i = this.depth;
        int i2 = this.pageIndex;
        String str2 = this.pageLabel;
        ArrayList<SpenPdfBookmark> arrayList = this.children;
        StringBuilder sbM780v = AbstractC0541b.m780v("SpenPdfBookmark(title=", i, str, ", depth=", ", pageIndex=");
        AbstractC1974b.m1331x(sbM780v, i2, ", pageLabel=", str2, ", children=");
        sbM780v.append(arrayList);
        sbM780v.append(")");
        return sbM780v.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SpenPdfBookmark(String str, int i, int i2, String str2, ArrayList arrayList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        ArrayList arrayList2;
        String str3;
        str = (i4 & 1) != 0 ? null : str;
        if ((i4 & 8) != 0) {
            arrayList2 = arrayList;
            str3 = null;
        } else {
            arrayList2 = arrayList;
            str3 = str2;
        }
        this(str, i, i2, str3, arrayList2);
    }
}
