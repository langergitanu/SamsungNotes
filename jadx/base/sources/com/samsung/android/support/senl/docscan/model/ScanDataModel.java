package com.samsung.android.support.senl.docscan.model;

import android.os.Bundle;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.docscan.common.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0006R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "", "<init>", "()V", "mScanDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "Lkotlin/collections/ArrayList;", "load", "", "bundle", "Landroid/os/Bundle;", "save", "getScanDataList", "", "setScanData", "position", "", "docScanData", "addScanData", "removeScanData", "isScanDataEmpty", "", "()Z", "scanDataCount", "getScanDataCount", "()I", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScanDataModel {

    @NotNull
    private static final String TAG = "ScanDataModel";

    @Nullable
    private ArrayList<DocScanData> mScanDataList;

    public final synchronized void addScanData(@NotNull DocScanData docScanData) {
        try {
            Intrinsics.checkNotNullParameter(docScanData, "docScanData");
            if (this.mScanDataList == null) {
                this.mScanDataList = new ArrayList<>();
            }
            ArrayList<DocScanData> arrayList = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(docScanData);
            ArrayList<DocScanData> arrayList2 = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList2);
            Logger.m7145d(TAG, "addDocScanData# size : " + arrayList2.size());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int getScanDataCount() {
        int size;
        ArrayList<DocScanData> arrayList = this.mScanDataList;
        if (arrayList == null) {
            size = 0;
        } else {
            Intrinsics.checkNotNull(arrayList);
            size = arrayList.size();
        }
        return size;
    }

    @NotNull
    public final synchronized List<DocScanData> getScanDataList() {
        ArrayList<DocScanData> arrayList;
        try {
            if (this.mScanDataList == null) {
                this.mScanDataList = new ArrayList<>();
            }
            arrayList = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.support.senl.docscan.model.DocScanData>");
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean isScanDataEmpty() {
        boolean z;
        ArrayList<DocScanData> arrayList = this.mScanDataList;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            z = arrayList.isEmpty();
        }
        return z;
    }

    public final synchronized void load(@Nullable Bundle bundle) {
        try {
            this.mScanDataList = bundle != null ? bundle.getParcelableArrayList(Constant.KEY_DOC_SCAN_DATA_LIST) : new ArrayList<>();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void removeScanData(@NotNull DocScanData docScanData) {
        try {
            Intrinsics.checkNotNullParameter(docScanData, "docScanData");
            if (this.mScanDataList == null) {
                this.mScanDataList = new ArrayList<>();
            }
            ArrayList<DocScanData> arrayList = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList);
            arrayList.remove(docScanData);
            ArrayList<DocScanData> arrayList2 = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList2);
            Logger.m7145d(TAG, "removeScanData# size : " + arrayList2.size());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void save(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putParcelableArrayList(Constant.KEY_DOC_SCAN_DATA_LIST, this.mScanDataList);
    }

    public final synchronized void setScanData(int position, @NotNull DocScanData docScanData) {
        try {
            Intrinsics.checkNotNullParameter(docScanData, "docScanData");
            if (this.mScanDataList == null) {
                this.mScanDataList = new ArrayList<>();
            }
            ArrayList<DocScanData> arrayList = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList);
            if (position <= arrayList.size()) {
                return;
            }
            ArrayList<DocScanData> arrayList2 = this.mScanDataList;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.set(position, docScanData);
        } catch (Throwable th) {
            throw th;
        }
    }
}
