package com.samsung.android.vexfwk.param;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.TranslatorCommonHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Parcelize
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0005\u001c\u001d\u001e\u001f B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "Landroid/os/Parcelable;", "blockInfoList", "", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$BlockInfo;", "(Ljava/util/List;)V", "getBlockInfoList", "()Ljava/util/List;", "charInfoList", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$CharInfo;", "getCharInfoList", "lineInfoList", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$LineInfo;", "getLineInfoList", "wordInfoList", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$WordInfo;", "getWordInfoList", "describeContents", "", "equals", "", "other", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "BlockInfo", "CharInfo", "Companion", "LineInfo", "WordInfo", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkOcrResult implements Parcelable {

    @NotNull
    private final List<BlockInfo> blockInfoList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<VexFwkOcrResult> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Parcelize
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$CharInfo;", "Landroid/os/Parcelable;", "string", "", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "getString", "()Ljava/lang/String;", "describeContents", "", "equals", "", "other", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class CharInfo implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<CharInfo> CREATOR = new Creator();

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @Nullable
        private final String string;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Creator implements Parcelable.Creator<CharInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CharInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String string = parcel.readString();
                Rect rect = (Rect) parcel.readParcelable(CharInfo.class.getClassLoader());
                int i = parcel.readInt();
                Point[] pointArr = new Point[i];
                for (int i2 = 0; i2 != i; i2++) {
                    pointArr[i2] = parcel.readParcelable(CharInfo.class.getClassLoader());
                }
                return new CharInfo(string, rect, pointArr);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CharInfo[] newArray(int i) {
                return new CharInfo[i];
            }
        }

        public CharInfo(@Nullable String str, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.string = str;
            this.rect = rect;
            this.poly = poly;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CharInfo)) {
                return false;
            }
            CharInfo charInfo = (CharInfo) other;
            return Intrinsics.areEqual(this.string, charInfo.string) && Intrinsics.areEqual(this.rect, charInfo.rect) && Arrays.equals(this.poly, charInfo.poly);
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
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.string);
            parcel.writeParcelable(this.rect, flags);
            Point[] pointArr = this.poly;
            int length = pointArr.length;
            parcel.writeInt(length);
            for (int i = 0; i != length; i++) {
                parcel.writeParcelable(pointArr[i], flags);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseParcelable;", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "()V", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion extends VexFwkParamBaseParcelable<VexFwkOcrResult> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
            super(new C2747a(7));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<VexFwkOcrResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkOcrResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(BlockInfo.CREATOR.createFromParcel(parcel));
            }
            return new VexFwkOcrResult(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkOcrResult[] newArray(int i) {
            return new VexFwkOcrResult[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Parcelize
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$LineInfo;", "Landroid/os/Parcelable;", "wordInfo", "", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$WordInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "", "getString", "()Ljava/lang/String;", "getWordInfo", "()Ljava/util/List;", "describeContents", "", "equals", "", "other", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LineInfo implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<LineInfo> CREATOR = new Creator();

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @NotNull
        private final List<WordInfo> wordInfo;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Creator implements Parcelable.Creator<LineInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LineInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(WordInfo.CREATOR.createFromParcel(parcel));
                }
                Rect rect = (Rect) parcel.readParcelable(LineInfo.class.getClassLoader());
                int i4 = parcel.readInt();
                Point[] pointArr = new Point[i4];
                for (int i5 = 0; i5 != i4; i5++) {
                    pointArr[i5] = parcel.readParcelable(LineInfo.class.getClassLoader());
                }
                return new LineInfo(arrayList, rect, pointArr);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LineInfo[] newArray(int i) {
                return new LineInfo[i];
            }
        }

        public LineInfo(@NotNull List<WordInfo> wordInfo, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.wordInfo = wordInfo;
            this.rect = rect;
            this.poly = poly;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LineInfo)) {
                return false;
            }
            LineInfo lineInfo = (LineInfo) other;
            if (this.wordInfo.size() != lineInfo.wordInfo.size()) {
                return false;
            }
            int size = this.wordInfo.size();
            for (int i = 0; i < size; i++) {
                if (!this.wordInfo.get(i).equals(lineInfo.wordInfo.get(i))) {
                    return false;
                }
            }
            return Intrinsics.areEqual(this.rect, lineInfo.rect) && Arrays.equals(this.poly, lineInfo.poly);
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
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return StringsKt.trim((CharSequence) string).toString();
        }

        @NotNull
        public final List<WordInfo> getWordInfo() {
            return this.wordInfo;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<WordInfo> list = this.wordInfo;
            parcel.writeInt(list.size());
            Iterator<WordInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
            parcel.writeParcelable(this.rect, flags);
            Point[] pointArr = this.poly;
            int length = pointArr.length;
            parcel.writeInt(length);
            for (int i = 0; i != length; i++) {
                parcel.writeParcelable(pointArr[i], flags);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Parcelize
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$WordInfo;", "Landroid/os/Parcelable;", "charInfo", "", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$CharInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "getCharInfo", "()Ljava/util/List;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "", "getString", "()Ljava/lang/String;", "describeContents", "", "equals", "", "other", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class WordInfo implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<WordInfo> CREATOR = new Creator();

        @NotNull
        private final List<CharInfo> charInfo;

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Creator implements Parcelable.Creator<WordInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final WordInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(CharInfo.CREATOR.createFromParcel(parcel));
                }
                Rect rect = (Rect) parcel.readParcelable(WordInfo.class.getClassLoader());
                int i4 = parcel.readInt();
                Point[] pointArr = new Point[i4];
                for (int i5 = 0; i5 != i4; i5++) {
                    pointArr[i5] = parcel.readParcelable(WordInfo.class.getClassLoader());
                }
                return new WordInfo(arrayList, rect, pointArr);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final WordInfo[] newArray(int i) {
                return new WordInfo[i];
            }
        }

        public WordInfo(@NotNull List<CharInfo> charInfo, @NotNull Rect rect, @NotNull Point[] poly) {
            Intrinsics.checkNotNullParameter(charInfo, "charInfo");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.charInfo = charInfo;
            this.rect = rect;
            this.poly = poly;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WordInfo)) {
                return false;
            }
            WordInfo wordInfo = (WordInfo) other;
            if (this.charInfo.size() != wordInfo.charInfo.size()) {
                return false;
            }
            int size = this.charInfo.size();
            for (int i = 0; i < size; i++) {
                if (!this.charInfo.get(i).equals(wordInfo.charInfo.get(i))) {
                    return false;
                }
            }
            return Intrinsics.areEqual(this.rect, wordInfo.rect) && Arrays.equals(this.poly, wordInfo.poly);
        }

        @NotNull
        public final List<CharInfo> getCharInfo() {
            return this.charInfo;
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
            Iterator<CharInfo> it = this.charInfo.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString());
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return StringsKt.trim((CharSequence) string).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<CharInfo> list = this.charInfo;
            parcel.writeInt(list.size());
            Iterator<CharInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
            parcel.writeParcelable(this.rect, flags);
            Point[] pointArr = this.poly;
            int length = pointArr.length;
            parcel.writeInt(length);
            for (int i = 0; i != length; i++) {
                parcel.writeParcelable(pointArr[i], flags);
            }
        }
    }

    public VexFwkOcrResult(@NotNull List<BlockInfo> blockInfoList) {
        Intrinsics.checkNotNullParameter(blockInfoList, "blockInfoList");
        this.blockInfoList = blockInfoList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkOcrResult)) {
            return false;
        }
        VexFwkOcrResult vexFwkOcrResult = (VexFwkOcrResult) other;
        if (this.blockInfoList.size() != vexFwkOcrResult.blockInfoList.size()) {
            return false;
        }
        int size = this.blockInfoList.size();
        for (int i = 0; i < size; i++) {
            if (!this.blockInfoList.get(i).equals(vexFwkOcrResult.blockInfoList.get(i))) {
                return false;
            }
        }
        return true;
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
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<BlockInfo> list = this.blockInfoList;
        parcel.writeInt(list.size());
        Iterator<BlockInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Parcelize
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001e¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$BlockInfo;", "Landroid/os/Parcelable;", "lineInfo", "", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$LineInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "isTabular", "", TranslatorCommonHelper.EXTRA_KEY_TRANSLATED_TEXT, "", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;ILjava/lang/String;)V", "()I", "setTabular", "(I)V", "getLineInfo", "()Ljava/util/List;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getRect", "()Landroid/graphics/Rect;", "string", "getString", "()Ljava/lang/String;", "getTranslatedText", "setTranslatedText", "(Ljava/lang/String;)V", "describeContents", "equals", "", "other", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class BlockInfo implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<BlockInfo> CREATOR = new Creator();
        private int isTabular;

        @NotNull
        private final List<LineInfo> lineInfo;

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @NotNull
        private String translatedText;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Creator implements Parcelable.Creator<BlockInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BlockInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(LineInfo.CREATOR.createFromParcel(parcel));
                }
                Rect rect = (Rect) parcel.readParcelable(BlockInfo.class.getClassLoader());
                int i4 = parcel.readInt();
                Point[] pointArr = new Point[i4];
                for (int i5 = 0; i5 != i4; i5++) {
                    pointArr[i5] = parcel.readParcelable(BlockInfo.class.getClassLoader());
                }
                return new BlockInfo(arrayList, rect, pointArr, parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BlockInfo[] newArray(int i) {
                return new BlockInfo[i];
            }
        }

        public BlockInfo(@NotNull List<LineInfo> lineInfo, @NotNull Rect rect, @NotNull Point[] poly, int i, @NotNull String translatedText) {
            Intrinsics.checkNotNullParameter(lineInfo, "lineInfo");
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(poly, "poly");
            Intrinsics.checkNotNullParameter(translatedText, "translatedText");
            this.lineInfo = lineInfo;
            this.rect = rect;
            this.poly = poly;
            this.isTabular = i;
            this.translatedText = translatedText;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockInfo)) {
                return false;
            }
            BlockInfo blockInfo = (BlockInfo) other;
            if (this.lineInfo.size() != blockInfo.lineInfo.size()) {
                return false;
            }
            int size = this.lineInfo.size();
            for (int i = 0; i < size; i++) {
                if (!this.lineInfo.get(i).equals(blockInfo.lineInfo.get(i))) {
                    return false;
                }
            }
            return Intrinsics.areEqual(this.rect, blockInfo.rect) && Arrays.equals(this.poly, blockInfo.poly) && this.isTabular == blockInfo.isTabular;
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
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return StringsKt.trim((CharSequence) string).toString();
        }

        @NotNull
        public final String getTranslatedText() {
            return this.translatedText;
        }

        /* JADX INFO: renamed from: isTabular, reason: from getter */
        public final int getIsTabular() {
            return this.isTabular;
        }

        public final void setTabular(int i) {
            this.isTabular = i;
        }

        public final void setTranslatedText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.translatedText = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<LineInfo> list = this.lineInfo;
            parcel.writeInt(list.size());
            Iterator<LineInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
            parcel.writeParcelable(this.rect, flags);
            Point[] pointArr = this.poly;
            int length = pointArr.length;
            parcel.writeInt(length);
            for (int i = 0; i != length; i++) {
                parcel.writeParcelable(pointArr[i], flags);
            }
            parcel.writeInt(this.isTabular);
            parcel.writeString(this.translatedText);
        }

        public /* synthetic */ BlockInfo(List list, Rect rect, Point[] pointArr, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, rect, pointArr, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? "" : str);
        }
    }
}
