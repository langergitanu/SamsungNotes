package com.samsung.android.sivs.p144ai.sdkcommon.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.TtsPackageInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.TtsSpeakerInfo;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BTCLocaleInfo extends LocaleInfo {
    public static final Parcelable.Creator<LocaleInfo> CREATOR = new Parcelable.Creator<LocaleInfo>() { // from class: com.samsung.android.sivs.ai.sdkcommon.asr.BTCLocaleInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: createFromParcel, reason: merged with bridge method [inline-methods] */
        public LocaleInfo createFromParcel2(Parcel parcel) {
            return new BTCLocaleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: newArray, reason: merged with bridge method [inline-methods] */
        public LocaleInfo[] newArray2(int i) {
            return new BTCLocaleInfo[i];
        }
    };
    private final TtsSpeakerInfo defaultSpeaker;
    private final List<TtsPackageInfo> ttsPackage;
    private final List<TtsSpeakerInfo> ttsSpeaker;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public BTCLocaleInfo(Locale locale, String str, int i, TtsSpeakerInfo ttsSpeakerInfo) {
        super(locale, str, i);
        this.ttsSpeaker = new LinkedList();
        this.ttsPackage = new LinkedList();
        this.defaultSpeaker = ttsSpeakerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getDefaultPackages$0(TtsPackageInfo ttsPackageInfo) {
        return ttsPackageInfo.getSpeakerInfo().contains(this.defaultSpeaker);
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.LocaleInfo, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    public List<TtsPackageInfo> getDefaultPackages() {
        return (List) this.ttsPackage.stream().filter(new C7233a(this, 2)).distinct().collect(Collectors.toList());
    }

    public TtsSpeakerInfo getDefaultSpeaker() {
        return this.defaultSpeaker;
    }

    public List<TtsPackageInfo> getTtsPackages() {
        return this.ttsPackage;
    }

    public List<TtsSpeakerInfo> getTtsSpeakers() {
        return this.ttsSpeaker;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPackageInfo(List<TtsPackageInfo> list) {
        if (list != null) {
            this.ttsPackage.clear();
            this.ttsPackage.addAll(list);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setSpeakerInfo(List<TtsSpeakerInfo> list) {
        if (list != null) {
            this.ttsSpeaker.clear();
            this.ttsSpeaker.addAll(list);
        }
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.LocaleInfo
    public String toString() {
        StringBuilder sb = new StringBuilder("BTCLocaleInfo{localeInfo=");
        sb.append(super.toString());
        sb.append(", defaultSpeaker=");
        sb.append(this.defaultSpeaker);
        sb.append(", speaker=");
        sb.append(this.ttsSpeaker);
        sb.append(", package=");
        return AbstractC1974b.m1321n(sb, this.ttsPackage, '}');
    }

    @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.LocaleInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.defaultSpeaker, 0);
        parcel.writeList(this.ttsSpeaker);
        parcel.writeList(this.ttsPackage);
    }

    public BTCLocaleInfo(Parcel parcel) {
        super(parcel);
        LinkedList linkedList = new LinkedList();
        this.ttsSpeaker = linkedList;
        LinkedList linkedList2 = new LinkedList();
        this.ttsPackage = linkedList2;
        this.defaultSpeaker = (TtsSpeakerInfo) parcel.readParcelable(TtsSpeakerInfo.class.getClassLoader());
        parcel.readList(linkedList, TtsSpeakerInfo.class.getClassLoader());
        parcel.readList(linkedList2, TtsPackageInfo.class.getClassLoader());
    }
}
