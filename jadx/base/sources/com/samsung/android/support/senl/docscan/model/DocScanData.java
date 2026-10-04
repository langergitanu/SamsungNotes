package com.samsung.android.support.senl.docscan.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 22\u00020\u0001:\u000212B9\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\b\u0010\"\u001a\u00020\u000fH\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0013\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020$J\u001f\u0010*\u001a\u00020$2\u0012\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000fJ\u0016\u0010.\u001a\u00020$2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\bJ\u001f\u0010)\u001a\u00020$2\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0007H\u0002¢\u0006\u0002\u00100R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "Landroid/os/Parcelable;", "pathToSave", "", "editingPath", "thumbnailPath", "vertexList", "", "Landroid/graphics/PointF;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Landroid/graphics/PointF;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "numOfAngle", "", "getNumOfAngle", "()I", "setNumOfAngle", "(I)V", "value", "getPathToSave", "()Ljava/lang/String;", "getEditingPath", "getThumbnailPath", "mVertexList", "Lcom/samsung/android/support/senl/docscan/model/DocScanData$Vertex;", "[Lcom/samsung/android/support/senl/docscan/model/DocScanData$Vertex;", "scanBitmap", "Landroid/graphics/Bitmap;", "getScanBitmap", "()Landroid/graphics/Bitmap;", "setScanBitmap", "(Landroid/graphics/Bitmap;)V", "describeContents", "writeToParcel", "", "dest", "flags", "getVertexList", "()[Landroid/graphics/PointF;", "sortVertexList", "setVertexList", "([Landroid/graphics/PointF;)V", "getVertex", "vertexIdx", "setVertex", "pos", "([Lcom/samsung/android/support/senl/docscan/model/DocScanData$Vertex;)V", "Vertex", "CREATOR", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocScanData implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String editingPath;

    @Nullable
    private Vertex[] mVertexList;
    private int numOfAngle;

    @Nullable
    private String pathToSave;

    @Nullable
    private Bitmap scanBitmap;

    @Nullable
    private String thumbnailPath;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.docscan.model.DocScanData$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/model/DocScanData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<DocScanData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DocScanData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DocScanData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DocScanData[] newArray(int size) {
            return new DocScanData[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/model/DocScanData$Vertex;", "Landroid/os/Parcelable;", "<init>", "()V", "pos", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "describeContents", "", "writeToParcel", "dest", "flags", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Vertex implements Parcelable {
        private float x;
        private float y;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<Vertex> CREATOR = new Parcelable.Creator<Vertex>() { // from class: com.samsung.android.support.senl.docscan.model.DocScanData$Vertex$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DocScanData.Vertex createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new DocScanData.Vertex(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DocScanData.Vertex[] newArray(int size) {
                return new DocScanData.Vertex[size];
            }
        };

        public Vertex() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public final void set(@NotNull PointF pos) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            this.x = pos.x;
            this.y = pos.y;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final void setY(float f) {
            this.y = f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeFloat(this.x);
            dest.writeFloat(this.y);
        }

        public Vertex(@NotNull PointF pos) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            this.x = pos.x;
            this.y = pos.y;
        }

        public Vertex(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            this.x = in.readFloat();
            this.y = in.readFloat();
        }
    }

    public DocScanData(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull PointF[] vertexList) {
        Intrinsics.checkNotNullParameter(vertexList, "vertexList");
        this.pathToSave = str;
        this.editingPath = str2;
        this.thumbnailPath = str3;
        setVertexList(vertexList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getEditingPath() {
        return this.editingPath;
    }

    public final int getNumOfAngle() {
        return this.numOfAngle;
    }

    @Nullable
    public final String getPathToSave() {
        return this.pathToSave;
    }

    @Nullable
    public final Bitmap getScanBitmap() {
        return this.scanBitmap;
    }

    @Nullable
    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    @NotNull
    public final PointF getVertex(int vertexIdx) {
        if (this.mVertexList == null) {
            this.mVertexList = new Vertex[this.numOfAngle];
        }
        Vertex[] vertexArr = this.mVertexList;
        Intrinsics.checkNotNull(vertexArr);
        if (vertexArr[vertexIdx] == null) {
            Vertex[] vertexArr2 = this.mVertexList;
            Intrinsics.checkNotNull(vertexArr2);
            vertexArr2[vertexIdx] = new Vertex();
        }
        Vertex[] vertexArr3 = this.mVertexList;
        Intrinsics.checkNotNull(vertexArr3);
        Vertex vertex = vertexArr3[vertexIdx];
        Intrinsics.checkNotNull(vertex);
        float x = vertex.getX();
        Vertex[] vertexArr4 = this.mVertexList;
        Intrinsics.checkNotNull(vertexArr4);
        Vertex vertex2 = vertexArr4[vertexIdx];
        Intrinsics.checkNotNull(vertex2);
        return new PointF(x, vertex2.getY());
    }

    @NotNull
    public final PointF[] getVertexList() {
        sortVertexList();
        Vertex[] vertexArr = this.mVertexList;
        Intrinsics.checkNotNull(vertexArr);
        PointF[] pointFArr = new PointF[vertexArr.length];
        Vertex[] vertexArr2 = this.mVertexList;
        Intrinsics.checkNotNull(vertexArr2);
        int length = vertexArr2.length;
        for (int i = 0; i < length; i++) {
            Vertex[] vertexArr3 = this.mVertexList;
            Intrinsics.checkNotNull(vertexArr3);
            Vertex vertex = vertexArr3[i];
            Intrinsics.checkNotNull(vertex);
            float x = vertex.getX();
            Vertex[] vertexArr4 = this.mVertexList;
            Intrinsics.checkNotNull(vertexArr4);
            Vertex vertex2 = vertexArr4[i];
            Intrinsics.checkNotNull(vertex2);
            pointFArr[i] = new PointF(x, vertex2.getY());
        }
        return pointFArr;
    }

    public final void setNumOfAngle(int i) {
        this.numOfAngle = i;
    }

    public final void setScanBitmap(@Nullable Bitmap bitmap) {
        this.scanBitmap = bitmap;
    }

    public final void setVertex(int vertexIdx, @NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        if (this.mVertexList == null) {
            this.mVertexList = new Vertex[this.numOfAngle];
        }
        Vertex[] vertexArr = this.mVertexList;
        Intrinsics.checkNotNull(vertexArr);
        if (vertexArr[vertexIdx] == null) {
            Vertex[] vertexArr2 = this.mVertexList;
            Intrinsics.checkNotNull(vertexArr2);
            vertexArr2[vertexIdx] = new Vertex(pos);
        } else {
            Vertex[] vertexArr3 = this.mVertexList;
            Intrinsics.checkNotNull(vertexArr3);
            Vertex vertex = vertexArr3[vertexIdx];
            Intrinsics.checkNotNull(vertex);
            vertex.set(pos);
        }
    }

    public final void setVertexList(@Nullable PointF[] vertexList) {
        if (vertexList == null) {
            return;
        }
        this.mVertexList = new Vertex[vertexList.length];
        int length = vertexList.length;
        for (int i = 0; i < length; i++) {
            Vertex[] vertexArr = this.mVertexList;
            Intrinsics.checkNotNull(vertexArr);
            PointF pointF = vertexList[i];
            Intrinsics.checkNotNull(pointF);
            vertexArr[i] = new Vertex(pointF);
        }
    }

    public final void sortVertexList() {
        if (this.mVertexList == null) {
            this.mVertexList = new Vertex[this.numOfAngle];
        }
        sortVertexList(this.mVertexList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.numOfAngle);
        dest.writeString(this.pathToSave);
        dest.writeString(this.editingPath);
        dest.writeString(this.thumbnailPath);
        dest.writeTypedArray(this.mVertexList, flags);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.samsung.android.support.senl.docscan.model.DocScanData$sortVertexList$1] */
    private final void sortVertexList(Vertex[] vertexList) {
        if (vertexList == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(vertexList);
        float x = 0.0f;
        float y2 = 0.0f;
        while (it.hasNext()) {
            Vertex vertex = (Vertex) it.next();
            if (vertex == null) {
                return;
            }
            x += vertex.getX();
            y2 += vertex.getY();
        }
        final float length = x / vertexList.length;
        final float length2 = y2 / vertexList.length;
        ArraysKt___ArraysJvmKt.sortWith(vertexList, new Comparator<Vertex>() { // from class: com.samsung.android.support.senl.docscan.model.DocScanData.sortVertexList.1
            @Override // java.util.Comparator
            public int compare(Vertex o12, Vertex o22) {
                if (o12 != null && o22 != null) {
                    double dAtan2 = Math.atan2(o12.getY() - length2, o12.getX() - length);
                    double dAtan22 = Math.atan2(o22.getY() - length2, o22.getX() - length);
                    if (dAtan2 < dAtan22) {
                        return -1;
                    }
                    if (dAtan2 > dAtan22) {
                        return 1;
                    }
                }
                return 0;
            }
        });
    }

    public DocScanData(@NotNull Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        this.numOfAngle = in.readInt();
        this.pathToSave = in.readString();
        this.editingPath = in.readString();
        this.thumbnailPath = in.readString();
        this.mVertexList = (Vertex[]) in.createTypedArray(Vertex.CREATOR);
    }
}
