package com.samsung.android.app.sdk.deepsky.textextraction.result;

import android.app.RemoteAction;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0007\"#$%&'(B/\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001dH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "Landroid/os/Parcelable;", "blockInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "entityInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo;", "languageTags", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBlockInfoList", "()Ljava/util/List;", "charInfoList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$CharInfo;", "getCharInfoList", "getEntityInfoList", "getLanguageTags", "()Ljava/lang/String;", "lineInfoList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", "getLineInfoList", "wordInfoList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "getWordInfoList", "describeContents", "", "writeToParcel", "", "dest", "flags", "BlockInfo", "CharInfo", "Companion", "EntityInfo", "LineInfo", "UnderlineInfo", "WordInfo", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class OcrResult implements Parcelable {

    @NotNull
    private final List<BlockInfo> blockInfoList;

    @NotNull
    private final List<EntityInfo> entityInfoList;

    @NotNull
    private final String languageTags;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<OcrResult> CREATOR = new Parcelable.Creator<OcrResult>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OcrResult createFromParcel(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new OcrResult(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OcrResult[] newArray(int size) {
            return new OcrResult[size];
        }
    };

    public /* synthetic */ OcrResult(List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new ArrayList() : list2, (i & 4) != 0 ? "" : str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<BlockInfo> getBlockInfoList() {
        return this.blockInfoList;
    }

    @NotNull
    public final List<CharInfo> getCharInfoList() {
        ArrayList arrayList = new ArrayList();
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            Iterator<LineInfo> it2 = it.next().getLineInfo().iterator();
            while (it2.hasNext()) {
                Iterator<WordInfo> it3 = it2.next().getWordInfo().iterator();
                while (it3.hasNext()) {
                    arrayList.addAll(it3.next().getCharInfo());
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<EntityInfo> getEntityInfoList() {
        return this.entityInfoList;
    }

    @NotNull
    public final String getLanguageTags() {
        return this.languageTags;
    }

    @NotNull
    public final List<LineInfo> getLineInfoList() {
        ArrayList arrayList = new ArrayList();
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getLineInfo());
        }
        return arrayList;
    }

    @NotNull
    public final List<WordInfo> getWordInfoList() {
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
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeTypedList(this.blockInfoList);
        dest.writeTypedList(this.entityInfoList);
        dest.writeString(this.languageTags);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "start", "Landroid/graphics/PointF;", "stop", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "getStart", "()Landroid/graphics/PointF;", "getStop", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class UnderlineInfo implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private final PointF start;

        @Nullable
        private final PointF stop;

        /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$UnderlineInfo$CREATOR, reason: from kotlin metadata */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion implements Parcelable.Creator<UnderlineInfo> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public UnderlineInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new UnderlineInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public UnderlineInfo[] newArray(int size) {
                return new UnderlineInfo[size];
            }
        }

        public UnderlineInfo(@Nullable PointF pointF, @Nullable PointF pointF2) {
            this.start = pointF;
            this.stop = pointF2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final PointF getStart() {
            return this.start;
        }

        @Nullable
        public final PointF getStop() {
            return this.stop;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.start, flags);
            parcel.writeParcelable(this.stop, flags);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public UnderlineInfo(@NotNull Parcel parcel) {
            this((PointF) parcel.readParcelable(PointF.class.getClassLoader()), (PointF) parcel.readParcelable(PointF.class.getClassLoader()));
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B+\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "Landroid/os/Parcelable;", "lineInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "lineInfo", "getLineInfo", "()Ljava/util/List;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "", "getString", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class BlockInfo implements Parcelable {

        @NotNull
        private final List<LineInfo> lineInfo;

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<BlockInfo> CREATOR = new Parcelable.Creator<BlockInfo>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$BlockInfo$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.BlockInfo createFromParcel(@NotNull Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new OcrResult.BlockInfo(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.BlockInfo[] newArray(int size) {
                return new OcrResult.BlockInfo[size];
            }
        };

        public BlockInfo(@NotNull List<LineInfo> lineInfoList, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(lineInfoList, "lineInfoList");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.lineInfo = lineInfoList;
            this.rect = rect;
            this.poly = poly;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<LineInfo> getLineInfo() {
            return this.lineInfo;
        }

        @NotNull
        public final Point[] getPoly() {
            return this.poly;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        @NotNull
        public final String getString() {
            StringBuilder sb = new StringBuilder();
            Iterator<LineInfo> it = this.lineInfo.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString());
                sb.append("\n");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "str.toString()");
            return StringsKt.trim((CharSequence) string).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeTypedList(this.lineInfo);
            dest.writeParcelable(this.rect, flags);
            dest.writeTypedArray(this.poly, flags);
        }

        public BlockInfo(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            ArrayList arrayList = new ArrayList();
            this.lineInfo = arrayList;
            in.readTypedList(arrayList, LineInfo.CREATOR);
            Rect rect = (Rect) in.readParcelable(Rect.class.getClassLoader());
            this.rect = rect == null ? new Rect() : rect;
            Point[] pointArr = (Point[]) in.createTypedArray(Point.CREATOR);
            this.poly = pointArr == null ? new Point[0] : pointArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$CharInfo;", "Landroid/os/Parcelable;", "character", "", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "getString", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class CharInfo implements Parcelable {

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @Nullable
        private final String string;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<CharInfo> CREATOR = new Parcelable.Creator<CharInfo>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$CharInfo$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.CharInfo createFromParcel(@NotNull Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new OcrResult.CharInfo(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.CharInfo[] newArray(int size) {
                return new OcrResult.CharInfo[size];
            }
        };

        public CharInfo(@NotNull String character, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(character, "character");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.string = character;
            this.rect = rect;
            this.poly = poly;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Point[] getPoly() {
            return this.poly;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        @Nullable
        public final String getString() {
            return this.string;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.string);
            dest.writeParcelable(this.rect, flags);
            dest.writeTypedArray(this.poly, flags);
        }

        public CharInfo(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            this.string = in.readString();
            Rect rect = (Rect) in.readParcelable(Rect.class.getClassLoader());
            this.rect = rect == null ? new Rect() : rect;
            Point[] pointArr = (Point[]) in.createTypedArray(Point.CREATOR);
            this.poly = pointArr == null ? new Point[0] : pointArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B+\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", "Landroid/os/Parcelable;", "wordInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "", "getString", "()Ljava/lang/String;", "wordInfo", "getWordInfo", "()Ljava/util/List;", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class LineInfo implements Parcelable {

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @NotNull
        private final List<WordInfo> wordInfo;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<LineInfo> CREATOR = new Parcelable.Creator<LineInfo>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$LineInfo$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.LineInfo createFromParcel(@NotNull Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new OcrResult.LineInfo(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.LineInfo[] newArray(int size) {
                return new OcrResult.LineInfo[size];
            }
        };

        /* JADX WARN: Multi-variable type inference failed */
        public LineInfo(@NotNull List<? extends WordInfo> wordInfoList, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(wordInfoList, "wordInfoList");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.wordInfo = wordInfoList;
            this.rect = rect;
            this.poly = poly;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Point[] getPoly() {
            return this.poly;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        @NotNull
        public final String getString() {
            StringBuilder sb = new StringBuilder();
            Iterator<WordInfo> it = this.wordInfo.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString());
                sb.append(" ");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "str.toString()");
            return StringsKt.trim((CharSequence) string).toString();
        }

        @NotNull
        public final List<WordInfo> getWordInfo() {
            return this.wordInfo;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeTypedList(this.wordInfo);
            dest.writeParcelable(this.rect, flags);
            dest.writeTypedArray(this.poly, flags);
        }

        public LineInfo(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            ArrayList arrayList = new ArrayList();
            this.wordInfo = arrayList;
            in.readTypedList(arrayList, WordInfo.CREATOR);
            Rect rect = (Rect) in.readParcelable(Rect.class.getClassLoader());
            this.rect = rect == null ? new Rect() : rect;
            Point[] pointArr = (Point[]) in.createTypedArray(Point.CREATOR);
            this.poly = pointArr == null ? new Point[0] : pointArr;
        }
    }

    public OcrResult(@NotNull List<BlockInfo> blockInfoList, @NotNull List<EntityInfo> entityInfoList, @NotNull String languageTags) {
        Intrinsics.checkNotNullParameter(blockInfoList, "blockInfoList");
        Intrinsics.checkNotNullParameter(entityInfoList, "entityInfoList");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        this.blockInfoList = blockInfoList;
        this.entityInfoList = entityInfoList;
        this.languageTags = languageTags;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B+\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB%\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rB\u000f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0014H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u0006("}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "Landroid/os/Parcelable;", "charInfo", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$CharInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "wordString", "", "(Ljava/lang/String;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCharInfo", "()Ljava/util/List;", "label", "", "getLabel", "()I", "setLabel", "(I)V", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "getString", "()Ljava/lang/String;", "getWordString", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class WordInfo implements Parcelable {

        @NotNull
        private final List<CharInfo> charInfo;
        private int label;

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @NotNull
        private final String wordString;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<WordInfo> CREATOR = new Parcelable.Creator<WordInfo>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$WordInfo$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.WordInfo createFromParcel(@NotNull Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new OcrResult.WordInfo(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public OcrResult.WordInfo[] newArray(int size) {
                return new OcrResult.WordInfo[size];
            }
        };

        /* JADX WARN: Multi-variable type inference failed */
        public WordInfo(@NotNull List<? extends CharInfo> charInfo, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(charInfo, "charInfo");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.charInfo = charInfo;
            this.rect = rect;
            this.poly = poly;
            this.label = -1;
            this.wordString = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<CharInfo> getCharInfo() {
            return this.charInfo;
        }

        public final int getLabel() {
            return this.label;
        }

        @NotNull
        public final Point[] getPoly() {
            return this.poly;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        @NotNull
        public final String getString() {
            if (this.wordString.length() > 0) {
                return this.wordString;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<CharInfo> it = this.charInfo.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString());
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "str.toString()");
            return StringsKt.trim((CharSequence) string).toString();
        }

        @NotNull
        public final String getWordString() {
            return this.wordString;
        }

        public final void setLabel(int i) {
            this.label = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeTypedList(this.charInfo);
            dest.writeParcelable(this.rect, flags);
            dest.writeTypedArray(this.poly, flags);
            dest.writeInt(this.label);
            dest.writeString(this.wordString);
        }

        public WordInfo(@NotNull String wordString, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(wordString, "wordString");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.label = -1;
            this.wordString = wordString;
            this.charInfo = CollectionsKt.emptyList();
            this.rect = rect;
            this.poly = poly;
            this.label = -1;
        }

        public WordInfo(@NotNull Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            this.label = -1;
            ArrayList arrayList = new ArrayList();
            this.charInfo = arrayList;
            in.readTypedList(arrayList, CharInfo.CREATOR);
            Rect rect = (Rect) in.readParcelable(Rect.class.getClassLoader());
            this.rect = rect == null ? new Rect() : rect;
            Point[] pointArr = (Point[]) in.createTypedArray(Point.CREATOR);
            this.poly = pointArr == null ? new Point[0] : pointArr;
            this.label = in.readInt();
            String string = in.readString();
            this.wordString = string == null ? "" : string;
        }
    }

    public OcrResult(@NotNull Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        ArrayList arrayList = new ArrayList();
        this.blockInfoList = arrayList;
        in.readTypedList(arrayList, BlockInfo.CREATOR);
        ArrayList arrayList2 = new ArrayList();
        this.entityInfoList = arrayList2;
        in.readTypedList(arrayList2, EntityInfo.INSTANCE);
        String string = in.readString();
        this.languageTags = string == null ? "" : string;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B]\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010)\u001a\u00020\u0018H\u0016J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0018H\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0006¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'¨\u00060"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo;", "Landroid/os/Parcelable;", "text", "", "type", "rects", "", "Landroid/graphics/Rect;", "polys", "Landroid/graphics/Point;", "underlines", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "score", "", "actions", "", "Landroid/app/RemoteAction;", "(Ljava/lang/String;Ljava/lang/String;[Landroid/graphics/Rect;[[Landroid/graphics/Point;[Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;FLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActions", "()Ljava/util/List;", "label", "", "getLabel", "()I", "getPolys", "()[[Landroid/graphics/Point;", "[[Landroid/graphics/Point;", "getRects", "()[Landroid/graphics/Rect;", "[Landroid/graphics/Rect;", "getScore", "()F", "getText", "()Ljava/lang/String;", "getType", "getUnderlines", "()[Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "[Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "describeContents", "getFlattenedPoly", "()[Landroid/graphics/Point;", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nOcrResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrResult.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,480:1\n37#2,2:481\n37#2,2:484\n1#3:483\n*S KotlinDebug\n*F\n+ 1 OcrResult.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo\n*L\n349#1:481,2\n370#1:484,2\n*E\n"})
    public static final class EntityInfo implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final List<RemoteAction> actions;
        private final int label;

        @NotNull
        private final Point[][] polys;

        @NotNull
        private final Rect[] rects;
        private final float score;

        @NotNull
        private final String text;

        @NotNull
        private final String type;

        @NotNull
        private final UnderlineInfo[] underlines;

        /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult$EntityInfo$CREATOR, reason: from kotlin metadata */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion implements Parcelable.Creator<EntityInfo> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public EntityInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new EntityInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public EntityInfo[] newArray(int size) {
                return new EntityInfo[size];
            }
        }

        public EntityInfo(@NotNull String text, @NotNull String type, @NotNull Rect[] rects, @NotNull Point[][] polys, @NotNull UnderlineInfo[] underlines, float f, @NotNull List<RemoteAction> actions) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(rects, "rects");
            Intrinsics.checkNotNullParameter(polys, "polys");
            Intrinsics.checkNotNullParameter(underlines, "underlines");
            Intrinsics.checkNotNullParameter(actions, "actions");
            this.text = text;
            this.type = type;
            this.rects = rects;
            this.polys = polys;
            this.underlines = underlines;
            this.label = -1;
            this.score = f;
            this.actions = actions;
        }

        private final Point[] getFlattenedPoly() {
            ArrayList arrayList = new ArrayList();
            for (Point[] pointArr : this.polys) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, pointArr);
            }
            return (Point[]) arrayList.toArray(new Point[0]);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<RemoteAction> getActions() {
            return this.actions;
        }

        public final int getLabel() {
            return this.label;
        }

        @NotNull
        public final Point[][] getPolys() {
            return this.polys;
        }

        @NotNull
        public final Rect[] getRects() {
            return this.rects;
        }

        public final float getScore() {
            return this.score;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final UnderlineInfo[] getUnderlines() {
            return this.underlines;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Object objM22215constructorimpl;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
            parcel.writeString(this.type);
            try {
                Result.Companion companion = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl((Rect) ArraysKt.first(this.rects));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            Rect rect = (Rect) objM22215constructorimpl;
            if (rect == null) {
                rect = new Rect();
            }
            Point[] flattenedPoly = getFlattenedPoly();
            parcel.writeParcelable(rect, flags);
            parcel.writeTypedArray(flattenedPoly, flags);
            parcel.writeTypedArray(this.underlines, flags);
            parcel.writeInt(this.label);
            parcel.writeFloat(this.score);
            parcel.writeTypedList(this.actions);
        }

        public EntityInfo(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            this.text = string == null ? "" : string;
            String string2 = parcel.readString();
            this.type = string2 != null ? string2 : "";
            Rect rect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            rect = rect == null ? new Rect() : rect;
            Point[] pointArr = (Point[]) parcel.createTypedArray(Point.CREATOR);
            pointArr = pointArr == null ? new Point[0] : pointArr;
            UnderlineInfo[] underlineInfoArr = (UnderlineInfo[]) parcel.createTypedArray(UnderlineInfo.INSTANCE);
            this.underlines = underlineInfoArr == null ? new UnderlineInfo[0] : underlineInfoArr;
            this.label = parcel.readInt();
            this.score = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.actions = arrayList;
            parcel.readTypedList(arrayList, RemoteAction.CREATOR);
            this.rects = new Rect[]{rect};
            ArrayList arrayList2 = new ArrayList();
            int length = pointArr.length / 4;
            for (int i = 0; i < length; i++) {
                int i2 = i * 4;
                Point point = pointArr[i2];
                Intrinsics.checkNotNullExpressionValue(point, "poly[i * 4]");
                Point point2 = pointArr[i2 + 1];
                Intrinsics.checkNotNullExpressionValue(point2, "poly[i * 4 + 1]");
                Point point3 = pointArr[i2 + 2];
                Intrinsics.checkNotNullExpressionValue(point3, "poly[i * 4 + 2]");
                Point point4 = pointArr[i2 + 3];
                Intrinsics.checkNotNullExpressionValue(point4, "poly[i * 4 + 3]");
                arrayList2.add(new Point[]{point, point2, point3, point4});
            }
            this.polys = (Point[][]) arrayList2.toArray(new Point[0][]);
        }
    }
}
