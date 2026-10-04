package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentSubscriptionId implements Parcelable {
    public static final DocumentSubscriptionId BACKGROUND_DOCUMENT_SERVICE_ID;
    public static final DocumentSubscriptionId COMPOSER_SERVICE_ID;
    public static final DocumentSubscriptionId CONVERT_SERVICE_ID;
    public static final Parcelable.Creator<DocumentSubscriptionId> CREATOR;
    public static final DocumentSubscriptionId DOCUMENT_SERVICE_ID;
    public static final DocumentSubscriptionId REFERENCE_SKIP_ID;
    public static final List<DocumentSubscriptionId> SKIPPED_USERS;
    public static final DocumentSubscriptionId SYNC_SERVICE_ID;
    private static final String TAG = ModelLogger.createTag("DocumentSubscriptionId");
    public static final DocumentSubscriptionId UI_LIST_SERVICE_ID;
    private final long mUsedTime;
    private final String mUser;

    static {
        DocumentSubscriptionId documentSubscriptionIdCreate = create("DOCUMENT_SERVICE", null);
        DOCUMENT_SERVICE_ID = documentSubscriptionIdCreate;
        DocumentSubscriptionId documentSubscriptionIdCreate2 = create("BACKGROUND_DOCUMENT_SERVICE_ID", null);
        BACKGROUND_DOCUMENT_SERVICE_ID = documentSubscriptionIdCreate2;
        COMPOSER_SERVICE_ID = create("COMPOSER_SERVICE", null);
        CONVERT_SERVICE_ID = create("CONVERT_SERVICE", null);
        SYNC_SERVICE_ID = create("SYNC_SERVICE", null);
        UI_LIST_SERVICE_ID = create("UI_LIST_SERVICE", null);
        REFERENCE_SKIP_ID = create("SKIP_USER", null);
        ArrayList arrayList = new ArrayList();
        SKIPPED_USERS = arrayList;
        arrayList.add(documentSubscriptionIdCreate);
        arrayList.add(documentSubscriptionIdCreate2);
        CREATOR = new Parcelable.Creator<DocumentSubscriptionId>() { // from class: com.samsung.android.support.senl.nt.model.documents.data.DocumentSubscriptionId.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DocumentSubscriptionId createFromParcel(Parcel parcel) {
                return new DocumentSubscriptionId(parcel, 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DocumentSubscriptionId[] newArray(int i) {
                return new DocumentSubscriptionId[i];
            }
        };
    }

    public /* synthetic */ DocumentSubscriptionId(Parcel parcel, int i) {
        this(parcel);
    }

    public static DocumentSubscriptionId create(@NonNull String str, @Nullable DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12307i(TAG, "create, userName : " + str + ", restoredId : " + documentSubscriptionId);
        return documentSubscriptionId != null ? documentSubscriptionId : new DocumentSubscriptionId(str, System.currentTimeMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        DataLogger.m12307i(TAG, "equals, obj : " + obj);
        if (!(obj instanceof DocumentSubscriptionId)) {
            return false;
        }
        DocumentSubscriptionId documentSubscriptionId = (DocumentSubscriptionId) obj;
        return this.mUser.compareTo(documentSubscriptionId.getUser()) == 0 && this.mUsedTime == documentSubscriptionId.getUsedTime();
    }

    public long getUsedTime() {
        return this.mUsedTime;
    }

    public String getUser() {
        return this.mUser;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("DocumentSubscriptionId{mUsedTime=");
        sb.append(this.mUsedTime);
        sb.append(", mUser='");
        return AbstractC0622a.m1170p(this.mUser, "'}", sb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUsedTime);
        parcel.writeString(this.mUser);
    }

    private DocumentSubscriptionId(@NonNull String str, long j) {
        DataLogger.m12302d(TAG, "DocumentUser, user : " + str + ", usedTime : " + j);
        this.mUser = str;
        this.mUsedTime = j;
    }

    private DocumentSubscriptionId(Parcel parcel) {
        long j = parcel.readLong();
        this.mUsedTime = j;
        String string = parcel.readString();
        this.mUser = string;
        DataLogger.m12302d(TAG, "DocumentUser - parcel, user : " + string + ", usedTime : " + j);
    }
}
