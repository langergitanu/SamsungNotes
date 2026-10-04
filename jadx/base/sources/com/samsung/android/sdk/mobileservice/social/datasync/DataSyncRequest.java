package com.samsung.android.sdk.mobileservice.social.datasync;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DataSyncRequest {
    private static final String BUNDLE_KEY_DATA_LIST = "data_list";
    private final List<IData> mDataList;

    public DataSyncRequest() {
        this.mDataList = new ArrayList(0);
    }

    public List<IData> getData() {
        return this.mDataList;
    }

    public String getServiceName() {
        if (this.mDataList.isEmpty()) {
            return null;
        }
        return this.mDataList.get(0).getSyncServiceName();
    }

    public Boolean isInvalid() {
        if (this.mDataList.isEmpty()) {
            return Boolean.TRUE;
        }
        Iterator<IData> it = this.mDataList.iterator();
        while (it.hasNext()) {
            if (it.next().isInvalid().booleanValue()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Bundle toBundle() {
        if (this.mDataList.isEmpty()) {
            return null;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<IData> it = this.mDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BUNDLE_KEY_DATA_LIST, arrayList);
        return bundle;
    }

    public DataSyncRequest(List<IData> list) {
        this.mDataList = new ArrayList(list);
    }
}
