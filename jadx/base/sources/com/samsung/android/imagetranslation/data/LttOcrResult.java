package com.samsung.android.imagetranslation.data;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttOcrResult implements Parcelable {
    public static final Parcelable.Creator<LttOcrResult> CREATOR = new Parcelable.Creator<LttOcrResult>() { // from class: com.samsung.android.imagetranslation.data.LttOcrResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LttOcrResult createFromParcel(Parcel parcel) {
            return new LttOcrResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LttOcrResult[] newArray(int i) {
            return new LttOcrResult[i];
        }
    };

    @NonNull
    private final List<BlockInfo> blockInfoList;
    private List<String> languageTagList;

    public LttOcrResult(@NonNull List<BlockInfo> list) {
        this.blockInfoList = list;
        this.languageTagList = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<BlockInfo> getBlockInfoList() {
        return this.blockInfoList;
    }

    @NonNull
    public List<String> getLanguageTagList() {
        return this.languageTagList;
    }

    @NonNull
    public List<LineInfo> getLineInfoList() {
        ArrayList arrayList = new ArrayList();
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getLineInfo());
        }
        return arrayList;
    }

    @NonNull
    public List<WordInfo> getWordInfoList() {
        ArrayList arrayList = new ArrayList();
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            Iterator<LineInfo> it2 = it.next().getLineInfo().iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getWordInfo());
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.blockInfoList);
    }

    public LttOcrResult(@NonNull List<BlockInfo> list, @NonNull List<String> list2) {
        this.blockInfoList = list;
        this.languageTagList = list2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CharInfo implements Parcelable {
        public static final Parcelable.Creator<CharInfo> CREATOR = new Parcelable.Creator<CharInfo>() { // from class: com.samsung.android.imagetranslation.data.LttOcrResult.CharInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CharInfo createFromParcel(Parcel parcel) {
                return new CharInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CharInfo[] newArray(int i) {
                return new CharInfo[i];
            }
        };
        private final String charString;
        private boolean isLinked;
        private final Point[] poly;
        private final Rect rect;

        public CharInfo(String str, Rect rect, Point[] pointArr) {
            this.charString = str;
            this.rect = rect;
            this.poly = pointArr;
            this.isLinked = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getChar() {
            return this.charString;
        }

        public Point[] getPoly() {
            return this.poly;
        }

        public Rect getRect() {
            return this.rect;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.charString);
            parcel.writeParcelable(this.rect, i);
            parcel.writeTypedArray(this.poly, i);
            parcel.writeByte(this.isLinked ? (byte) 1 : (byte) 0);
        }

        public CharInfo(Parcel parcel) {
            this.charString = parcel.readString();
            this.rect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.poly = (Point[]) parcel.createTypedArray(Point.CREATOR);
            this.isLinked = parcel.readByte() != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LineInfo implements Parcelable {
        public static final Parcelable.Creator<LineInfo> CREATOR = new Parcelable.Creator<LineInfo>() { // from class: com.samsung.android.imagetranslation.data.LttOcrResult.LineInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LineInfo createFromParcel(Parcel parcel) {
                return new LineInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LineInfo[] newArray(int i) {
                return new LineInfo[i];
            }
        };
        private String langCode;
        private Point[] poly;
        private Rect rect;

        @NonNull
        private final List<WordInfo> wordInfoList;

        public LineInfo(@NonNull ArrayList<WordInfo> arrayList, Rect rect, Point[] pointArr, String str) {
            this.wordInfoList = arrayList;
            this.rect = rect;
            this.poly = pointArr;
            this.langCode = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getLangCode() {
            return this.langCode;
        }

        public Point[] getPoly() {
            return this.poly;
        }

        public Rect getRect() {
            return this.rect;
        }

        public String getString() {
            StringBuilder sb = new StringBuilder();
            Iterator<WordInfo> it = this.wordInfoList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString());
            }
            return sb.toString();
        }

        @NonNull
        public List<WordInfo> getWordInfo() {
            return this.wordInfoList;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.wordInfoList);
            parcel.writeParcelable(this.rect, i);
            parcel.writeTypedArray(this.poly, i);
            parcel.writeString(this.langCode);
        }

        public LineInfo(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            this.wordInfoList = arrayList;
            parcel.readTypedList(arrayList, WordInfo.CREATOR);
            this.rect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.poly = (Point[]) parcel.createTypedArray(Point.CREATOR);
            this.langCode = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WordInfo implements Parcelable {
        public static final Parcelable.Creator<WordInfo> CREATOR = new Parcelable.Creator<WordInfo>() { // from class: com.samsung.android.imagetranslation.data.LttOcrResult.WordInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WordInfo createFromParcel(Parcel parcel) {
                return new WordInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WordInfo[] newArray(int i) {
                return new WordInfo[i];
            }
        };

        @NonNull
        private final List<CharInfo> charInfoList;
        private final String langCode;
        private final Point[] poly;
        private final Rect rect;

        public WordInfo(@NonNull ArrayList<CharInfo> arrayList, Rect rect, Point[] pointArr, String str) {
            this.charInfoList = arrayList;
            this.rect = rect;
            this.poly = pointArr;
            this.langCode = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public List<CharInfo> getCharInfo() {
            return this.charInfoList;
        }

        public String getLangCode() {
            return this.langCode;
        }

        public Point[] getPoly() {
            return this.poly;
        }

        public Rect getRect() {
            return this.rect;
        }

        public String getString() {
            StringBuilder sb = new StringBuilder();
            Iterator<CharInfo> it = this.charInfoList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getChar());
            }
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.charInfoList);
            parcel.writeParcelable(this.rect, i);
            parcel.writeTypedArray(this.poly, i);
            parcel.writeString(this.langCode);
        }

        public WordInfo(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            this.charInfoList = arrayList;
            parcel.readTypedList(arrayList, CharInfo.CREATOR);
            this.rect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.poly = (Point[]) parcel.createTypedArray(Point.CREATOR);
            this.langCode = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockInfo implements Parcelable {
        public static final Parcelable.Creator<BlockInfo> CREATOR = new Parcelable.Creator<BlockInfo>() { // from class: com.samsung.android.imagetranslation.data.LttOcrResult.BlockInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BlockInfo createFromParcel(Parcel parcel) {
                return new BlockInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BlockInfo[] newArray(int i) {
                return new BlockInfo[i];
            }
        };
        private final int blockType;
        private final String langCode;

        @NonNull
        private final List<LineInfo> lineInfoList;
        private final Point[] poly;
        private final Rect rect;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum BLOCK_TYPE {
            DEFAULT,
            TABULAR
        }

        public BlockInfo(@NonNull List<LineInfo> list, Rect rect, Point[] pointArr, String str, int i) {
            this.lineInfoList = list;
            this.rect = rect;
            this.poly = pointArr;
            this.langCode = str;
            this.blockType = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getBlockType() {
            return this.blockType;
        }

        public String getLangCode() {
            return this.langCode;
        }

        @NonNull
        public List<LineInfo> getLineInfo() {
            return this.lineInfoList;
        }

        public Point[] getPoly() {
            return this.poly;
        }

        public Rect getRect() {
            return this.rect;
        }

        public String getString() {
            StringBuilder sb = new StringBuilder();
            Iterator<LineInfo> it = this.lineInfoList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString());
            }
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.lineInfoList);
            parcel.writeParcelable(this.rect, i);
            parcel.writeTypedArray(this.poly, i);
            parcel.writeString(this.langCode);
            parcel.writeInt(this.blockType);
        }

        public BlockInfo(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            this.lineInfoList = arrayList;
            parcel.readTypedList(arrayList, LineInfo.CREATOR);
            this.rect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.poly = (Point[]) parcel.createTypedArray(Point.CREATOR);
            this.langCode = parcel.readString();
            this.blockType = parcel.readInt();
        }
    }

    public LttOcrResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.blockInfoList = arrayList;
        parcel.readTypedList(arrayList, BlockInfo.CREATOR);
    }
}
