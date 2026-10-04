package com.samsung.android.sivs.p144ai.sdkcommon.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DialogInfo implements Parcelable {
    public static final Parcelable.Creator<DialogInfo> CREATOR = new Parcelable.Creator<DialogInfo>() { // from class: com.samsung.android.sivs.ai.sdkcommon.asr.DialogInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialogInfo createFromParcel(Parcel parcel) {
            return new DialogInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialogInfo[] newArray(int i) {
            return new DialogInfo[i];
        }
    };
    private final List<SpeechInfo> speakerInfos;
    private final List<Integer> speakerList;

    public DialogInfo() {
        this((Set<Integer>) Collections.EMPTY_SET);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<SpeechInfo> getSpeakerInfos() {
        return this.speakerInfos;
    }

    public List<Integer> getSpeakerList() {
        return this.speakerList;
    }

    public void setSpeechInfos(List<SpeechInfo> list) {
        this.speakerInfos.clear();
        this.speakerInfos.addAll(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DialogInfo{speakerList=");
        sb.append(this.speakerList);
        sb.append(", speakerInfos=");
        return AbstractC1974b.m1321n(sb, this.speakerInfos, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.speakerList);
        parcel.writeList(this.speakerInfos);
    }

    public DialogInfo(Set<Integer> set) {
        LinkedList linkedList = new LinkedList();
        this.speakerList = linkedList;
        this.speakerInfos = new LinkedList();
        linkedList.addAll(set);
    }

    public DialogInfo(Parcel parcel) {
        LinkedList linkedList = new LinkedList();
        this.speakerList = linkedList;
        LinkedList linkedList2 = new LinkedList();
        this.speakerInfos = linkedList2;
        parcel.readList(linkedList, Integer.class.getClassLoader());
        parcel.readList(linkedList2, SpeechInfo.class.getClassLoader());
    }
}
