package com.samsung.android.scs.p140ai.sdkcommon.image.localization;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BoundaryInternal implements Parcelable {
    public static final Parcelable.Creator<BoundaryInternal> CREATOR = new Parcelable.Creator<BoundaryInternal>() { // from class: com.samsung.android.scs.ai.sdkcommon.image.localization.BoundaryInternal.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoundaryInternal createFromParcel(Parcel parcel) {
            return BoundaryInternal.readBoundaryRectsFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoundaryInternal[] newArray(int i) {
            return new BoundaryInternal[i];
        }
    };
    private Rect mBlockRect;
    private int mBlockType;
    private List<BoundaryInternal> mChildBlocks;

    private BoundaryInternal() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BoundaryInternal readBoundaryRectsFromParcel(Parcel parcel) {
        BoundaryInternal boundaryInternal = new BoundaryInternal();
        boundaryInternal.mBlockRect = new Rect(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        boundaryInternal.mBlockType = parcel.readInt();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(readBoundaryRectsFromParcel(parcel));
        }
        boundaryInternal.mChildBlocks = arrayList;
        return boundaryInternal;
    }

    private void writeBoundaryRectsToParcel(Parcel parcel, BoundaryInternal boundaryInternal) {
        parcel.writeInt(boundaryInternal.mBlockRect.left);
        parcel.writeInt(boundaryInternal.mBlockRect.top);
        parcel.writeInt(boundaryInternal.mBlockRect.right);
        parcel.writeInt(boundaryInternal.mBlockRect.bottom);
        parcel.writeInt(boundaryInternal.mBlockType);
        List<BoundaryInternal> list = boundaryInternal.mChildBlocks;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(list.size());
        if (boundaryInternal.mChildBlocks.size() > 0) {
            Iterator<BoundaryInternal> it = boundaryInternal.mChildBlocks.iterator();
            while (it.hasNext()) {
                writeBoundaryRectsToParcel(parcel, it.next());
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Rect getBlockRect() {
        return this.mBlockRect;
    }

    public int getBlockType() {
        return this.mBlockType;
    }

    public List<BoundaryInternal> getChildBlocks() {
        return this.mChildBlocks;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeBoundaryRectsToParcel(parcel, this);
    }

    public BoundaryInternal(Rect rect, int i, List<BoundaryInternal> list) {
        this.mBlockRect = rect;
        this.mBlockType = i;
        this.mChildBlocks = list;
    }
}
