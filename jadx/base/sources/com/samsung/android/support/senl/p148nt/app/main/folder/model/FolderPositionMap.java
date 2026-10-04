package com.samsung.android.support.senl.p148nt.app.main.folder.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderPositionMap {
    int[] mAdapterPosition = null;

    public void arrangePosition(int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i >= i2) {
            int i4 = this.mAdapterPosition[i];
            while (i > i2) {
                int[] iArr = this.mAdapterPosition;
                iArr[i] = iArr[i - 1];
                i--;
            }
            this.mAdapterPosition[i2] = i4;
            return;
        }
        int i5 = this.mAdapterPosition[i];
        while (i < i2) {
            int[] iArr2 = this.mAdapterPosition;
            int i6 = i + 1;
            iArr2[i] = iArr2[i6];
            i = i6;
        }
        this.mAdapterPosition[i2] = i5;
    }

    public int getPosition(int i) {
        int[] iArr = this.mAdapterPosition;
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }

    public void init(int i) {
        this.mAdapterPosition = null;
        if (i > 0) {
            this.mAdapterPosition = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.mAdapterPosition[i2] = i2;
            }
        }
    }
}
