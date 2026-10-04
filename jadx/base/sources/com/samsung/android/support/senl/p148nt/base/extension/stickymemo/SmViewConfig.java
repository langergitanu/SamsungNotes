package com.samsung.android.support.senl.p148nt.base.extension.stickymemo;

import android.graphics.Rect;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001!BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B1\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig;", "", "x", "", "y", "width", "height", "docWidth", "filePath", "", "savePath", XMLWriter.STANDALONE, "", "memoObjectInfo", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;", "<init>", "(IIIIILjava/lang/String;Ljava/lang/String;ZLcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;)V", "rect", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;ILjava/lang/String;Ljava/lang/String;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;)V", "getX", "()I", "getY", "getWidth", "getHeight", "getDocWidth", "getFilePath", "()Ljava/lang/String;", "getSavePath", "getStandalone", "()Z", "getMemoObjectInfo", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;", "MemoObjectInfo", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmViewConfig {
    private final int docWidth;

    @NotNull
    private final String filePath;
    private final int height;

    @Nullable
    private final MemoObjectInfo memoObjectInfo;

    @NotNull
    private final String savePath;
    private final boolean standalone;
    private final int width;
    private final int x;
    private final int y;

    public SmViewConfig(int i, int i2, int i4, int i5, int i6, @NotNull String filePath, @NotNull String savePath, boolean z, @Nullable MemoObjectInfo memoObjectInfo) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        this.x = i;
        this.y = i2;
        this.width = i4;
        this.height = i5;
        this.docWidth = i6;
        this.filePath = filePath;
        this.savePath = savePath;
        this.standalone = z;
        this.memoObjectInfo = memoObjectInfo;
    }

    public final int getDocWidth() {
        return this.docWidth;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final MemoObjectInfo getMemoObjectInfo() {
        return this.memoObjectInfo;
    }

    @NotNull
    public final String getSavePath() {
        return this.savePath;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;", "", "pageIndex", "", "obj", "Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "isNew", "", "updatePos", "<init>", "(ILcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;ZZ)V", "getPageIndex", "()I", "setPageIndex", "(I)V", "getObj", "()Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "()Z", "getUpdatePos", "isPageIndexChanged", "setPageIndexChanged", "(Z)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MemoObjectInfo {
        private final boolean isNew;
        private boolean isPageIndexChanged;

        @NotNull
        private final SpenStickyNote obj;
        private int pageIndex;
        private final boolean updatePos;

        public MemoObjectInfo(int i, @NotNull SpenStickyNote obj, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            this.pageIndex = i;
            this.obj = obj;
            this.isNew = z;
            this.updatePos = z2;
        }

        @NotNull
        public final SpenStickyNote getObj() {
            return this.obj;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final boolean getUpdatePos() {
            return this.updatePos;
        }

        /* JADX INFO: renamed from: isNew, reason: from getter */
        public final boolean getIsNew() {
            return this.isNew;
        }

        /* JADX INFO: renamed from: isPageIndexChanged, reason: from getter */
        public final boolean getIsPageIndexChanged() {
            return this.isPageIndexChanged;
        }

        public final void setPageIndex(int i) {
            this.pageIndex = i;
        }

        public final void setPageIndexChanged(boolean z) {
            this.isPageIndexChanged = z;
        }

        public /* synthetic */ MemoObjectInfo(int i, SpenStickyNote spenStickyNote, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, spenStickyNote, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
        }
    }

    public /* synthetic */ SmViewConfig(int i, int i2, int i4, int i5, int i6, String str, String str2, boolean z, MemoObjectInfo memoObjectInfo, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i4, i5, i6, (i7 & 32) != 0 ? "" : str, (i7 & 64) != 0 ? "" : str2, (i7 & 128) != 0 ? true : z, (i7 & 256) != 0 ? null : memoObjectInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmViewConfig(@NotNull Rect rect, int i, @NotNull String filePath, @NotNull String savePath, @NotNull MemoObjectInfo memoObjectInfo) {
        this(rect.left, rect.top, rect.width(), rect.height(), i, filePath, savePath, false, memoObjectInfo);
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(memoObjectInfo, "memoObjectInfo");
    }
}
