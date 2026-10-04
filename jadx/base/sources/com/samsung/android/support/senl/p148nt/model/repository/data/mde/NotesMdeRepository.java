package com.samsung.android.support.senl.p148nt.model.repository.data.mde;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesMdeRepository implements MdeDataSource {
    private String mGroupId;
    private String mOwnerId;
    private String mSpaceId;
    private static final String TAG = ModelLogger.createTag("NotesMdeRepository");
    public static final Parcelable.Creator<NotesMdeRepository> CREATOR = new Parcelable.Creator<NotesMdeRepository>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.mde.NotesMdeRepository.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotesMdeRepository createFromParcel(Parcel parcel) {
            return new NotesMdeRepository(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotesMdeRepository[] newArray(int i) {
            return new NotesMdeRepository[i];
        }
    };

    public NotesMdeRepository(String str, String str2, String str3) {
        this.mSpaceId = str;
        this.mGroupId = str2;
        this.mOwnerId = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource
    public String getGroupId() {
        DataLogger.m12302d(TAG, "getGroupId : " + this.mGroupId);
        return this.mGroupId;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource
    public String getOwnerId() {
        DataLogger.m12302d(TAG, "getOwnerId : " + this.mOwnerId);
        return this.mOwnerId;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource
    public String getSpaceId() {
        DataLogger.m12302d(TAG, "getSpaceId : " + this.mSpaceId);
        return this.mSpaceId;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource
    public void setGroupId(@NonNull String str) {
        AbstractC11014a.m12334s("setGroupId : ", str, TAG);
        this.mGroupId = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource
    public void setOwnerId(@NonNull String str) {
        AbstractC11014a.m12334s("setOwnerId : ", str, TAG);
        this.mOwnerId = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource
    public void setSpaceId(@NonNull String str) {
        AbstractC11014a.m12334s("setSpaceId : ", str, TAG);
        this.mSpaceId = str;
    }

    public String toString() {
        return "spaceId : " + this.mSpaceId + ", groupId : " + this.mGroupId + ", ownerId : " + this.mOwnerId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSpaceId);
        parcel.writeString(this.mGroupId);
        parcel.writeString(this.mOwnerId);
    }

    public NotesMdeRepository(Parcel parcel) {
        this.mSpaceId = parcel.readString();
        this.mGroupId = parcel.readString();
        this.mOwnerId = parcel.readString();
    }
}
