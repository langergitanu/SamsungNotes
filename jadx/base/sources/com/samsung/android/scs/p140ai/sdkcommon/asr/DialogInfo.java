package com.samsung.android.scs.p140ai.sdkcommon.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DialogInfo implements Parcelable {
    public static final Parcelable.Creator<DialogInfo> CREATOR = new Parcelable.Creator<DialogInfo>() { // from class: com.samsung.android.scs.ai.sdkcommon.asr.DialogInfo.1
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
    private final List<Integer> speakerList;
    private final List<SpeechInfo> speechInfos;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DialogInfo() {
        this((Set<Integer>) Collections.EMPTY_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSpeechInfosById$0(int i, SpeechInfo speechInfo) {
        return speechInfo.getSpeaker() == i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Integer> getSpeakerList() {
        return this.speakerList;
    }

    public List<SpeechInfo> getSpeechInfos() {
        return this.speechInfos;
    }

    public List<SpeechInfo> getSpeechInfosById(int i) {
        return (List) this.speechInfos.stream().filter(new C0231c(i, 2)).collect(Collectors.toList());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setSpeechInfos(List<SpeechInfo> list) {
        this.speechInfos.clear();
        this.speechInfos.addAll(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DialogInfo{speakerList=");
        sb.append(this.speakerList);
        sb.append(", speechInfos=");
        return AbstractC1974b.m1321n(sb, this.speechInfos, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.speakerList);
        parcel.writeList(this.speechInfos);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DialogInfo(Set<Integer> set) {
        LinkedList linkedList = new LinkedList();
        this.speakerList = linkedList;
        this.speechInfos = new LinkedList();
        linkedList.addAll(set);
    }

    public DialogInfo(Parcel parcel) {
        LinkedList linkedList = new LinkedList();
        this.speakerList = linkedList;
        LinkedList linkedList2 = new LinkedList();
        this.speechInfos = linkedList2;
        parcel.readList(linkedList, Integer.class.getClassLoader());
        parcel.readList(linkedList2, SpeechInfo.class.getClassLoader());
    }
}
