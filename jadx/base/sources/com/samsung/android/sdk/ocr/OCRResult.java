package com.samsung.android.sdk.ocr;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OCRResult implements Parcelable {
    public static final Parcelable.Creator<OCRResult> CREATOR = new Parcelable.Creator<OCRResult>() { // from class: com.samsung.android.sdk.ocr.OCRResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OCRResult createFromParcel(Parcel parcel) {
            return new OCRResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OCRResult[] newArray(int i) {
            return new OCRResult[i];
        }
    };
    private static final boolean SUPPORT_UNION_RECT = true;
    private static final String TAG = "OCRResult";
    private ArrayList<BlockData> mBlockDataList;
    private ProcessInfo mProcessInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProcessInfo implements Parcelable {
        public static final Parcelable.Creator<ProcessInfo> CREATOR = new Parcelable.Creator<ProcessInfo>() { // from class: com.samsung.android.sdk.ocr.OCRResult.ProcessInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProcessInfo createFromParcel(Parcel parcel) {
                return new ProcessInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProcessInfo[] newArray(int i) {
                return new ProcessInfo[i];
            }
        };
        private boolean mHasText;
        private boolean mIsHandwrittenResult;
        private String mMOCREngineVersion;
        private String mSOCREngineVersion;

        public ProcessInfo() {
            this.mMOCREngineVersion = "";
            this.mSOCREngineVersion = "";
            this.mIsHandwrittenResult = false;
            this.mHasText = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getEngineVersion() {
            return this.mIsHandwrittenResult ? this.mSOCREngineVersion : this.mMOCREngineVersion;
        }

        public boolean hasText() {
            return this.mHasText;
        }

        public boolean isHandwrittenResult() {
            return this.mIsHandwrittenResult;
        }

        public void setEngineVersion(String str, boolean z) {
            if (z) {
                this.mSOCREngineVersion = str;
            } else {
                this.mMOCREngineVersion = str;
            }
        }

        public void setHandwrittenResult(boolean z) {
            this.mIsHandwrittenResult = z;
        }

        public void setHasText(boolean z) {
            this.mHasText = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT < 29) {
                parcel.writeInt(this.mHasText ? 1 : 0);
                parcel.writeInt(this.mIsHandwrittenResult ? 1 : 0);
            } else {
                parcel.writeBoolean(this.mHasText);
                parcel.writeBoolean(this.mIsHandwrittenResult);
                parcel.writeString(this.mSOCREngineVersion);
                parcel.writeString(this.mMOCREngineVersion);
            }
        }

        public String getEngineVersion(boolean z) {
            return z ? this.mSOCREngineVersion : this.mMOCREngineVersion;
        }

        public ProcessInfo(Parcel parcel) {
            this.mIsHandwrittenResult = false;
            this.mHasText = false;
            this.mMOCREngineVersion = "";
            this.mSOCREngineVersion = "";
            if (Build.VERSION.SDK_INT >= 29) {
                this.mHasText = parcel.readBoolean();
                this.mIsHandwrittenResult = parcel.readBoolean();
                this.mSOCREngineVersion = parcel.readString();
                this.mMOCREngineVersion = parcel.readString();
                return;
            }
            this.mHasText = parcel.readInt() == 1;
            this.mIsHandwrittenResult = parcel.readInt() == 1;
            this.mSOCREngineVersion = "Not defined";
            this.mMOCREngineVersion = "Not defined";
        }
    }

    public OCRResult() {
        this.mBlockDataList = null;
        this.mProcessInfo = null;
        init();
    }

    public static Point[] getRotatedCorner(Point[] pointArr, float f, PointF pointF) {
        if (pointArr.length != 4) {
            Log.e(TAG, "The number of corner points is not 4.");
            return null;
        }
        Point[] pointArr2 = new Point[4];
        int i = 0;
        for (Point point : pointArr) {
            Point point2 = new Point(point);
            pointArr2[i] = point2;
            rotate(point2, f, pointF);
            i++;
        }
        return pointArr2;
    }

    private void init() {
        this.mBlockDataList = new ArrayList<>();
        this.mProcessInfo = new ProcessInfo();
    }

    public static void printRect(Point[] pointArr, String str, String str2) {
        if (str2 != null) {
            Log.i(TAG, String.format("%s [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)] %s", str, Integer.valueOf(pointArr[0].x), Integer.valueOf(pointArr[0].y), Integer.valueOf(pointArr[1].x), Integer.valueOf(pointArr[1].y), Integer.valueOf(pointArr[2].x), Integer.valueOf(pointArr[2].y), Integer.valueOf(pointArr[3].x), Integer.valueOf(pointArr[3].y), str2));
        } else {
            Log.i(TAG, String.format("%s [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", str, Integer.valueOf(pointArr[0].x), Integer.valueOf(pointArr[0].y), Integer.valueOf(pointArr[1].x), Integer.valueOf(pointArr[1].y), Integer.valueOf(pointArr[2].x), Integer.valueOf(pointArr[2].y), Integer.valueOf(pointArr[3].x), Integer.valueOf(pointArr[3].y)));
        }
    }

    public static void rotate(Point point, float f, PointF pointF) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float f4 = point.x;
        float f5 = pointF.x;
        double d2 = f4 - f5;
        double d3 = point.y - pointF.y;
        point.x = (int) AbstractC0000a.m5b(d, d3, AbstractC2821a.m2210a(d, d2, f5));
        point.y = (int) AbstractC2821a.m2210a(d, d3, ((double) pointF.y) - (Math.sin(d) * d2));
    }

    public void add(BlockData blockData) {
        this.mBlockDataList.add(blockData);
    }

    public void clear() {
        init();
    }

    public void clearResult() {
        this.mBlockDataList = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<BlockData> getBlockDataList() {
        return this.mBlockDataList;
    }

    public ProcessInfo getProcessInfo() {
        return this.mProcessInfo;
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<BlockData> it = this.mBlockDataList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
            sb.append(MarkdownDocument.NEW_LINE);
        }
        return new String(sb).trim();
    }

    public Point[] getTextRect() {
        Log.w(TAG, "OCRResult.getTextRect() was deprecated. Use getUnionRect() instead!");
        return getUnionRect();
    }

    public Point[] getUnionRect() {
        Point[] pointArrCreateInitialRect = OCRResultUtils.createInitialRect();
        Iterator<BlockData> it = this.mBlockDataList.iterator();
        while (it.hasNext()) {
            OCRResultUtils.unionRect(pointArrCreateInitialRect, it.next().getUnionRect());
        }
        return pointArrCreateInitialRect;
    }

    public boolean logInfo() {
        Log.i(TAG, "=====================================================================");
        Log.i(TAG, "Is Handwritten = " + this.mProcessInfo.isHandwrittenResult());
        Log.i(TAG, "Engine Version(SOCR) = " + this.mProcessInfo.getEngineVersion(true));
        Log.i(TAG, "Engine Version(MOCR) = " + this.mProcessInfo.getEngineVersion(false));
        Log.i(TAG, "---------------------------------------------------------------------");
        printRect(getUnionRect(), "OCRResult[mUnionRect]", String.format(" contains %d Blocks", Integer.valueOf(this.mBlockDataList.size())));
        Log.i(TAG, "OCRResult::Text:");
        Iterator<BlockData> it = this.mBlockDataList.iterator();
        while (it.hasNext()) {
            if (!it.next().logInfo()) {
                return false;
            }
        }
        return true;
    }

    public boolean offset(int i, int i2) {
        Iterator<BlockData> it = this.mBlockDataList.iterator();
        while (it.hasNext()) {
            if (!it.next().offset(i, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean scale(float f) {
        Iterator<BlockData> it = this.mBlockDataList.iterator();
        while (it.hasNext()) {
            if (!it.next().scale(f)) {
                return false;
            }
        }
        return true;
    }

    public void setBlockDataList(ArrayList<BlockData> arrayList) {
        this.mBlockDataList.addAll(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ArrayList<BlockData> arrayList = this.mBlockDataList;
        if (arrayList != null) {
            parcel.writeTypedList(arrayList);
        }
        parcel.writeTypedObject(this.mProcessInfo, i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CharData extends AbsData {
        public static final Parcelable.Creator<CharData> CREATOR = new Parcelable.Creator<CharData>() { // from class: com.samsung.android.sdk.ocr.OCRResult.CharData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CharData createFromParcel(Parcel parcel) {
                return new CharData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CharData[] newArray(int i) {
                return new CharData[i];
            }
        };
        private String mText;

        public CharData() {
            this.mText = "";
        }

        public void clear() {
            this.mText = "";
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ float getAngle() {
            return super.getAngle();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ PointF getCenter() {
            return super.getCenter();
        }

        public final String getText() {
            return this.mText;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean offset(int i, int i2) {
            return super.offset(i, i2);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean rotate(float f, PointF pointF) {
            return super.rotate(f, pointF);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean scale(float f) {
            return super.scale(f);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setAngle(float f) {
            super.setAngle(f);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setRect(Point[] pointArr) {
            super.setRect(pointArr);
        }

        public void setText(String str) {
            this.mText = str;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Log.i(OCRResult.TAG, "writeToParcel: CharData");
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mText);
        }

        public CharData(Parcel parcel) {
            super(parcel);
            this.mText = "";
            this.mText = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AbsData implements Parcelable {
        public static final Parcelable.Creator<AbsData> CREATOR = new Parcelable.Creator<AbsData>() { // from class: com.samsung.android.sdk.ocr.OCRResult.AbsData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AbsData createFromParcel(Parcel parcel) {
                return new AbsData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AbsData[] newArray(int i) {
                return new AbsData[i];
            }
        };
        protected float mAngle;
        protected Point[] mRect;

        public AbsData() {
            this.mRect = new Point[4];
            this.mAngle = 0.0f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public float getAngle() {
            return this.mAngle;
        }

        public PointF getCenter() {
            Point[] pointArr = this.mRect;
            int length = pointArr.length;
            if (length <= 0) {
                throw new UnsupportedOperationException("mRect should not be defined to calculate center");
            }
            int i = 0;
            int i2 = 0;
            for (Point point : pointArr) {
                i += point.x;
                i2 += point.y;
            }
            float f = length;
            return new PointF(i / f, i2 / f);
        }

        public final float[] getLines() {
            Point[] pointArr = this.mRect;
            Point point = pointArr[0];
            int i = point.x;
            int i2 = point.y;
            Point point2 = pointArr[1];
            int i4 = point2.x;
            int i5 = point2.y;
            Point point3 = pointArr[2];
            int i6 = point3.x;
            int i7 = point3.y;
            Point point4 = pointArr[3];
            int i8 = point4.x;
            int i9 = point4.y;
            return new float[]{i, i2, i4, i5, i4, i5, i6, i7, i6, i7, i8, i9, i8, i9, i, i2};
        }

        public Point[] getRect() {
            return this.mRect;
        }

        public boolean offset(int i, int i2) {
            Point[] pointArr = this.mRect;
            if (pointArr.length <= 0) {
                return false;
            }
            for (Point point : pointArr) {
                point.offset(i, i2);
            }
            return true;
        }

        public boolean rotate(float f, PointF pointF) {
            this.mAngle += f;
            this.mRect = OCRResult.getRotatedCorner(this.mRect, f, pointF);
            return true;
        }

        public boolean scale(float f) {
            for (Point point : this.mRect) {
                point.x = (int) (point.x * f);
                point.y = (int) (point.y * f);
            }
            return true;
        }

        public void setAngle(float f) {
            this.mAngle = f;
        }

        public void setRect(Point[] pointArr) {
            this.mRect = pointArr;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Log.i(OCRResult.TAG, "writeIntArray");
            Point[] pointArr = this.mRect;
            Point point = pointArr[0];
            int i2 = point.x;
            int i4 = point.y;
            Point point2 = pointArr[1];
            int i5 = point2.x;
            int i6 = point2.y;
            Point point3 = pointArr[2];
            int i7 = point3.x;
            int i8 = point3.y;
            Point point4 = pointArr[3];
            parcel.writeIntArray(new int[]{i2, i4, i5, i6, i7, i8, point4.x, point4.y});
            parcel.writeFloat(this.mAngle);
        }

        public AbsData(Parcel parcel) {
            this.mRect = new Point[4];
            this.mAngle = 0.0f;
            int[] iArr = new int[8];
            Log.i(OCRResult.TAG, "readIntArray");
            parcel.readIntArray(iArr);
            this.mRect[0] = new Point(iArr[0], iArr[1]);
            this.mRect[1] = new Point(iArr[2], iArr[3]);
            this.mRect[2] = new Point(iArr[4], iArr[5]);
            this.mRect[3] = new Point(iArr[6], iArr[7]);
            this.mAngle = parcel.readFloat();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LineData extends AbsData {
        public static final Parcelable.Creator<LineData> CREATOR = new Parcelable.Creator<LineData>() { // from class: com.samsung.android.sdk.ocr.OCRResult.LineData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LineData createFromParcel(Parcel parcel) {
                return new LineData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LineData[] newArray(int i) {
                return new LineData[i];
            }
        };
        private ArrayList<WordData> mWordDataList;

        public LineData() {
            this.mWordDataList = null;
            this.mWordDataList = new ArrayList<>();
        }

        public void add(WordData wordData) {
            this.mWordDataList.add(wordData);
        }

        public void clear() {
            this.mWordDataList.clear();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ float getAngle() {
            return super.getAngle();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ PointF getCenter() {
            return super.getCenter();
        }

        public final String getText() {
            StringBuilder sb = new StringBuilder();
            Iterator<WordData> it = this.mWordDataList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(" ");
            }
            return sb.toString().trim();
        }

        public ArrayList<WordData> getWordDataList() {
            return this.mWordDataList;
        }

        public boolean logInfo() {
            Log.i(OCRResult.TAG, "------------------------------------------------------------------");
            OCRResult.printRect(super.getRect(), "OCRResult::Line[mRect]", String.format(" contains %d Words", Integer.valueOf(this.mWordDataList.size())));
            Iterator<WordData> it = this.mWordDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().logInfo()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public boolean offset(int i, int i2) {
            super.offset(i, i2);
            Iterator<WordData> it = this.mWordDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().offset(i, i2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public boolean rotate(float f, PointF pointF) {
            super.rotate(f, pointF);
            Iterator<WordData> it = this.mWordDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().rotate(f, pointF)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public boolean scale(float f) {
            super.scale(f);
            Iterator<WordData> it = this.mWordDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().scale(f)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setAngle(float f) {
            super.setAngle(f);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setRect(Point[] pointArr) {
            super.setRect(pointArr);
        }

        public void setWordDataList(ArrayList<WordData> arrayList) {
            this.mWordDataList.addAll(arrayList);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Log.i(OCRResult.TAG, "writeToParcel: LineData");
            super.writeToParcel(parcel, i);
            ArrayList<WordData> arrayList = this.mWordDataList;
            if (arrayList != null) {
                parcel.writeTypedList(arrayList);
            }
        }

        public LineData(Parcel parcel) {
            super(parcel);
            this.mWordDataList = null;
            ArrayList<WordData> arrayList = new ArrayList<>();
            this.mWordDataList = arrayList;
            parcel.readTypedList(arrayList, WordData.CREATOR);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WordData extends AbsData {
        public static final Parcelable.Creator<WordData> CREATOR = new Parcelable.Creator<WordData>() { // from class: com.samsung.android.sdk.ocr.OCRResult.WordData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WordData createFromParcel(Parcel parcel) {
                return new WordData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WordData[] newArray(int i) {
                return new WordData[i];
            }
        };
        private ArrayList<CharData> mCharDataList;
        private Point[] mPoly;

        public WordData() {
            this.mCharDataList = null;
            this.mPoly = null;
            this.mCharDataList = new ArrayList<>();
        }

        private void setPolyWithRect() {
            Point[] pointArr = this.mRect;
            if (pointArr != null && pointArr.length > 0) {
                if (pointArr[0] != null) {
                    this.mPoly = new Point[pointArr.length];
                    for (int i = 0; i < this.mRect.length; i++) {
                        Point[] pointArr2 = this.mPoly;
                        Point point = this.mRect[i];
                        pointArr2[i] = new Point(point.x, point.y);
                    }
                    return;
                }
            }
            Log.w(OCRResult.TAG, "mRect is null or zero-length or its elements are null!");
        }

        public void add(CharData charData) {
            this.mCharDataList.add(charData);
        }

        public void clear() {
            this.mCharDataList.clear();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ float getAngle() {
            return super.getAngle();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ PointF getCenter() {
            return super.getCenter();
        }

        public ArrayList<CharData> getCharDataList() {
            return this.mCharDataList;
        }

        public final Point[] getPoly() {
            if (this.mPoly == null) {
                Log.i(OCRResult.TAG, "mPoly is null, so set poly with rect");
                setPolyWithRect();
            }
            return this.mPoly;
        }

        public final String getText() {
            StringBuilder sb = new StringBuilder();
            Iterator<CharData> it = this.mCharDataList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
            }
            return sb.toString().trim();
        }

        public boolean logInfo() {
            OCRResult.printRect(super.getRect(), "OCRResult::Word[mRect]", String.format(" contains %d Characters", Integer.valueOf(this.mCharDataList.size())));
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean offset(int i, int i2) {
            return super.offset(i, i2);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean rotate(float f, PointF pointF) {
            return super.rotate(f, pointF);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean scale(float f) {
            return super.scale(f);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setAngle(float f) {
            super.setAngle(f);
        }

        public void setCharDataList(ArrayList<CharData> arrayList) {
            this.mCharDataList.addAll(arrayList);
        }

        public void setPoly(Point[] pointArr) {
            if (pointArr == null || pointArr.length <= 0) {
                Log.w(OCRResult.TAG, "setPoly : poly is null or zero-length");
            } else {
                this.mPoly = pointArr;
            }
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setRect(Point[] pointArr) {
            super.setRect(pointArr);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Log.i(OCRResult.TAG, "writeToParcel: WordData");
            super.writeToParcel(parcel, i);
            ArrayList<CharData> arrayList = this.mCharDataList;
            if (arrayList != null) {
                parcel.writeTypedList(arrayList);
            }
        }

        public WordData(Parcel parcel) {
            super(parcel);
            this.mCharDataList = null;
            this.mPoly = null;
            ArrayList<CharData> arrayList = new ArrayList<>();
            this.mCharDataList = arrayList;
            parcel.readTypedList(arrayList, CharData.CREATOR);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BlockData extends AbsData {
        public static final Parcelable.Creator<BlockData> CREATOR = new Parcelable.Creator<BlockData>() { // from class: com.samsung.android.sdk.ocr.OCRResult.BlockData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BlockData createFromParcel(Parcel parcel) {
                return new BlockData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BlockData[] newArray(int i) {
                return new BlockData[i];
            }
        };
        private int mIsTabular;
        private ArrayList<LineData> mLineDataList;

        public BlockData(Parcel parcel) {
            super(parcel);
            this.mLineDataList = null;
            this.mIsTabular = 0;
            ArrayList<LineData> arrayList = new ArrayList<>();
            this.mLineDataList = arrayList;
            parcel.readTypedList(arrayList, LineData.CREATOR);
        }

        public void add(LineData lineData) {
            this.mLineDataList.add(lineData);
        }

        public void clear() {
            this.mLineDataList.clear();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ float getAngle() {
            return super.getAngle();
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ PointF getCenter() {
            return super.getCenter();
        }

        public ArrayList<LineData> getLineDataList() {
            return this.mLineDataList;
        }

        public String getText() {
            StringBuilder sb = new StringBuilder();
            Iterator<LineData> it = this.mLineDataList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append("\n");
            }
            return new String(sb).trim();
        }

        public Point[] getTextRect() {
            Log.w(OCRResult.TAG, "BlockData.getTextRect() was deprecated. Use getUnionRect() instead!");
            return getUnionRect();
        }

        public Point[] getUnionRect() {
            Point[] pointArrCreateInitialRect = OCRResultUtils.createInitialRect();
            Iterator<LineData> it = this.mLineDataList.iterator();
            while (it.hasNext()) {
                OCRResultUtils.unionRect(pointArrCreateInitialRect, it.next().getRect());
            }
            return pointArrCreateInitialRect;
        }

        public int isTabular() {
            return this.mIsTabular;
        }

        public boolean logInfo() {
            Log.i(OCRResult.TAG, "=====================================================================");
            OCRResult.printRect(getUnionRect(), "OCRResult::Block[mUnionRect]", String.format(" contains %d Lines", Integer.valueOf(this.mLineDataList.size())));
            OCRResult.printRect(super.getRect(), "OCRResult::Block[mRect]", String.format(" contains %d Lines", Integer.valueOf(this.mLineDataList.size())));
            Log.i(OCRResult.TAG, "OCRResult::BlockData Text:");
            Iterator<LineData> it = this.mLineDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().logInfo()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public boolean offset(int i, int i2) {
            super.offset(i, i2);
            Iterator<LineData> it = this.mLineDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().offset(i, i2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ boolean rotate(float f, PointF pointF) {
            return super.rotate(f, pointF);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public boolean scale(float f) {
            super.scale(f);
            Iterator<LineData> it = this.mLineDataList.iterator();
            while (it.hasNext()) {
                if (!it.next().scale(f)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setAngle(float f) {
            super.setAngle(f);
        }

        public void setLineDataList(ArrayList<LineData> arrayList) {
            this.mLineDataList.addAll(arrayList);
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData
        public /* bridge */ /* synthetic */ void setRect(Point[] pointArr) {
            super.setRect(pointArr);
        }

        public void setTabular(int i) {
            this.mIsTabular = i;
        }

        @Override // com.samsung.android.sdk.ocr.OCRResult.AbsData, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Log.i(OCRResult.TAG, "writeToParcel: BlockData");
            super.writeToParcel(parcel, i);
            ArrayList<LineData> arrayList = this.mLineDataList;
            if (arrayList != null) {
                parcel.writeTypedList(arrayList);
            }
        }

        public BlockData() {
            this.mLineDataList = null;
            this.mIsTabular = 0;
            this.mLineDataList = new ArrayList<>();
        }
    }

    public OCRResult(Parcel parcel) {
        this.mBlockDataList = null;
        this.mProcessInfo = null;
        ArrayList<BlockData> arrayList = new ArrayList<>();
        this.mBlockDataList = arrayList;
        parcel.readTypedList(arrayList, BlockData.CREATOR);
        this.mProcessInfo = new ProcessInfo();
        this.mProcessInfo = (ProcessInfo) parcel.readTypedObject(ProcessInfo.CREATOR);
    }
}
