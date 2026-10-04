package com.samsung.android.sivs.p144ai.sdkcommon.translation;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ChunkPair implements Parcelable {
    public static final Parcelable.Creator<ChunkPair> CREATOR = new Parcelable.Creator<ChunkPair>() { // from class: com.samsung.android.sivs.ai.sdkcommon.translation.ChunkPair.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChunkPair createFromParcel(Parcel parcel) {
            return new ChunkPair(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChunkPair[] newArray(int i) {
            return new ChunkPair[i];
        }
    };
    private String delimiter;
    private String sentence;

    public /* synthetic */ ChunkPair(Parcel parcel, int i) {
        this(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.sentence = parcel.readString();
        this.delimiter = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChunkPair chunkPair = (ChunkPair) obj;
            if (Objects.equals(this.sentence, chunkPair.sentence) && Objects.equals(this.delimiter, chunkPair.delimiter)) {
                return true;
            }
        }
        return false;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getSentence() {
        return this.sentence;
    }

    public int hashCode() {
        return Objects.hash(this.sentence, this.delimiter);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sentence);
        parcel.writeString(this.delimiter);
    }

    public ChunkPair(String str, String str2) {
        this.sentence = str;
        this.delimiter = str2;
    }

    private ChunkPair(Parcel parcel) {
        readFromParcel(parcel);
    }
}
