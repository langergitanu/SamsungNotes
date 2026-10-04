package com.samsung.android.support.senl.p148nt.model.repository.data.tag;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentTagRepository implements TagDataSource {
    private final List<TagData> mChangedSortedTagList;
    private final List<TagData> mOriginalSortedTagList;
    private static final String TAG = ModelLogger.createTag("DocumentTagRepository");
    public static final Parcelable.Creator<DocumentTagRepository> CREATOR = new Parcelable.Creator<DocumentTagRepository>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.tag.DocumentTagRepository.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentTagRepository createFromParcel(Parcel parcel) {
            return new DocumentTagRepository(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentTagRepository[] newArray(int i) {
            return new DocumentTagRepository[i];
        }
    };

    public DocumentTagRepository() {
        this.mChangedSortedTagList = new ArrayList();
        this.mOriginalSortedTagList = new ArrayList();
        DataLogger.m12307i(TAG, "DocumentTagRepository");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource
    public List<TagData> cloneChangedSortedList() {
        ArrayList arrayList;
        synchronized (this.mChangedSortedTagList) {
            DataLogger.m12307i(TAG, "cloneChangedSortedList : " + this.mChangedSortedTagList);
            arrayList = new ArrayList(this.mChangedSortedTagList);
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource
    public List<TagData> cloneOriginalSortedList() {
        ArrayList arrayList;
        synchronized (this.mOriginalSortedTagList) {
            DataLogger.m12307i(TAG, "cloneOriginalSortedList : " + this.mOriginalSortedTagList);
            arrayList = new ArrayList(this.mOriginalSortedTagList);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource
    public boolean isChanged() {
        synchronized (this.mOriginalSortedTagList) {
            synchronized (this.mChangedSortedTagList) {
                if (this.mOriginalSortedTagList.size() != this.mChangedSortedTagList.size()) {
                    DataLogger.m12307i(TAG, "isChanged, true -> size was changed.");
                    return true;
                }
                for (int i = 0; i < this.mChangedSortedTagList.size(); i++) {
                    TagData tagData = this.mChangedSortedTagList.get(i);
                    TagData tagData2 = this.mOriginalSortedTagList.get(i);
                    if (tagData != null && !tagData.equals(tagData2)) {
                        DataLogger.m12307i(TAG, "isChanged, true -> tagData : " + tagData + ", originalData : " + tagData2);
                        return true;
                    }
                }
                DataLogger.m12307i(TAG, "isChanged, false");
                return false;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource
    public boolean save(@NonNull Context context, @NonNull String str) {
        boolean zIsChanged = isChanged();
        List<TagData> listCloneOriginalSortedList = cloneOriginalSortedList();
        List<TagData> listCloneChangedSortedList = cloneChangedSortedList();
        HashSet hashSet = new HashSet();
        Iterator<TagData> it = listCloneChangedSortedList.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<TagData> it2 = listCloneOriginalSortedList.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().getName());
        }
        DataLogger.m12307i(TAG, "save, isChanged :" + zIsChanged + ", uuid : " + str + ", changedSortedList : " + listCloneChangedSortedList);
        boolean zUpdateTagsByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().updateTagsByDocUuid(hashSet2, hashSet, str, false);
        if (zUpdateTagsByDocUuid) {
            setOriginalSortedList(listCloneChangedSortedList);
        }
        return zUpdateTagsByDocUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource
    public void setChangedSortedList(List<TagData> list) {
        DataLogger.m12307i(TAG, "setChangedSortedList, tags : " + list);
        synchronized (this.mChangedSortedTagList) {
            this.mChangedSortedTagList.clear();
            this.mChangedSortedTagList.addAll(list);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagDataSource
    public void setOriginalSortedList(List<TagData> list) {
        DataLogger.m12307i(TAG, "setOriginalSortedList, tags : " + list);
        synchronized (this.mOriginalSortedTagList) {
            this.mOriginalSortedTagList.clear();
            Iterator<TagData> it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.mOriginalSortedTagList.add(it.next().mo22198clone());
                } catch (CloneNotSupportedException e) {
                    DataLogger.m12303e(TAG, "setOriginalSortedList, e : " + e.getMessage());
                }
            }
        }
        setChangedSortedList(list);
    }

    @NonNull
    public String toString() {
        String str;
        synchronized (this.mOriginalSortedTagList) {
            str = "originalList : " + this.mOriginalSortedTagList + ", changedList : " + this.mChangedSortedTagList;
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        DataLogger.m12307i(TAG, "writeToParcel : " + this);
        synchronized (this.mOriginalSortedTagList) {
            parcel.writeTypedList(this.mOriginalSortedTagList);
        }
        synchronized (this.mChangedSortedTagList) {
            parcel.writeTypedList(this.mChangedSortedTagList);
        }
    }

    public DocumentTagRepository(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.mChangedSortedTagList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.mOriginalSortedTagList = arrayList2;
        String str = TAG;
        DataLogger.m12307i(str, "DocumentTagRepository, in - start : " + parcel);
        ArrayList arrayList3 = new ArrayList();
        Parcelable.Creator<DocumentTag> creator = DocumentTag.CREATOR;
        parcel.readTypedList(arrayList3, creator);
        arrayList2.addAll(arrayList3);
        arrayList3.clear();
        parcel.readTypedList(arrayList3, creator);
        arrayList.addAll(arrayList3);
        DataLogger.m12307i(str, "DocumentTagRepository, in - end : " + this);
    }
}
