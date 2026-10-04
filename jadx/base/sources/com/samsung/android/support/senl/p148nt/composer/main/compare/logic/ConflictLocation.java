package com.samsung.android.support.senl.p148nt.composer.main.compare.logic;

import android.graphics.Point;
import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00014B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0007J&\u00100\u001a\u00020-2\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019J\u001a\u00103\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u00010\u001a2\b\u00102\u001a\u0004\u0018\u00010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R2\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019j\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR2\u0010 \u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019j\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR2\u0010#\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019j\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/ConflictLocation;", "", "mType", "", "isPageOrObject", "", "mPointSync", "Landroid/graphics/Point;", "mPointLocal", "<init>", "(IZLandroid/graphics/Point;Landroid/graphics/Point;)V", "getMType", "()I", "setMType", "(I)V", "()Z", "setPageOrObject", "(Z)V", "getMPointSync", "()Landroid/graphics/Point;", "setMPointSync", "(Landroid/graphics/Point;)V", "getMPointLocal", "setMPointLocal", "mRectLocals", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "getMRectLocals", "()Ljava/util/ArrayList;", "setMRectLocals", "(Ljava/util/ArrayList;)V", "mRectSyncs", "getMRectSyncs", "setMRectSyncs", "mRectMerges", "getMRectMerges", "setMRectMerges", "mInformationConflict", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "getMInformationConflict", "()Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "setMInformationConflict", "(Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;)V", "setPoint", "", "local", "sync", "setRectF", "localRect", "syncRect", "setObjectRectF", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConflictLocation {
    public static final int TYPE_DELETE = 1;
    public static final int TYPE_FORMATTING = 2;
    public static final int TYPE_INSERT = 0;
    private boolean isPageOrObject;

    @Nullable
    private InformationConflict mInformationConflict;

    @Nullable
    private Point mPointLocal;

    @Nullable
    private Point mPointSync;

    @Nullable
    private ArrayList<RectF> mRectLocals;

    @Nullable
    private ArrayList<RectF> mRectMerges;

    @Nullable
    private ArrayList<RectF> mRectSyncs;
    private int mType;

    public ConflictLocation(int i, boolean z, @Nullable Point point, @Nullable Point point2) {
        this.mType = i;
        this.isPageOrObject = z;
        this.mPointSync = point;
        this.mPointLocal = point2;
    }

    @Nullable
    public final InformationConflict getMInformationConflict() {
        return this.mInformationConflict;
    }

    @Nullable
    public final Point getMPointLocal() {
        return this.mPointLocal;
    }

    @Nullable
    public final Point getMPointSync() {
        return this.mPointSync;
    }

    @Nullable
    public final ArrayList<RectF> getMRectLocals() {
        return this.mRectLocals;
    }

    @Nullable
    public final ArrayList<RectF> getMRectMerges() {
        return this.mRectMerges;
    }

    @Nullable
    public final ArrayList<RectF> getMRectSyncs() {
        return this.mRectSyncs;
    }

    public final int getMType() {
        return this.mType;
    }

    /* JADX INFO: renamed from: isPageOrObject, reason: from getter */
    public final boolean getIsPageOrObject() {
        return this.isPageOrObject;
    }

    public final void setMInformationConflict(@Nullable InformationConflict informationConflict) {
        this.mInformationConflict = informationConflict;
    }

    public final void setMPointLocal(@Nullable Point point) {
        this.mPointLocal = point;
    }

    public final void setMPointSync(@Nullable Point point) {
        this.mPointSync = point;
    }

    public final void setMRectLocals(@Nullable ArrayList<RectF> arrayList) {
        this.mRectLocals = arrayList;
    }

    public final void setMRectMerges(@Nullable ArrayList<RectF> arrayList) {
        this.mRectMerges = arrayList;
    }

    public final void setMRectSyncs(@Nullable ArrayList<RectF> arrayList) {
        this.mRectSyncs = arrayList;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setObjectRectF(@Nullable RectF localRect, @Nullable RectF syncRect) {
        ArrayList<RectF> arrayList = new ArrayList<>();
        this.mRectLocals = arrayList;
        arrayList.add(localRect);
        ArrayList<RectF> arrayList2 = this.mRectLocals;
        if (arrayList2 != null) {
            arrayList2.add(localRect);
        }
        ArrayList<RectF> arrayList3 = new ArrayList<>();
        this.mRectSyncs = arrayList3;
        arrayList3.add(syncRect);
        ArrayList<RectF> arrayList4 = this.mRectSyncs;
        if (arrayList4 != null) {
            arrayList4.add(syncRect);
        }
    }

    public final void setPageOrObject(boolean z) {
        this.isPageOrObject = z;
    }

    public final void setPoint(@Nullable Point local, @Nullable Point sync) {
        this.mPointLocal = local;
        this.mPointSync = sync;
    }

    public final void setRectF(@NotNull ArrayList<RectF> localRect, @NotNull ArrayList<RectF> syncRect) {
        Intrinsics.checkNotNullParameter(localRect, "localRect");
        Intrinsics.checkNotNullParameter(syncRect, "syncRect");
        this.mRectLocals = localRect;
        this.mRectSyncs = syncRect;
    }
}
