package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/Chunk;", "Landroid/os/Parcelable;", "startPos", "", "text", "", "spanObjList", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObject;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getStartPos", "()I", "getText", "()Ljava/lang/String;", "getSpanObjList", "()Ljava/util/List;", "getResolvedText", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nChunk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Chunk.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/Chunk\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,39:1\n1056#2:40\n*S KotlinDebug\n*F\n+ 1 Chunk.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/Chunk\n*L\n19#1:40\n*E\n"})
public final class Chunk implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Chunk> CREATOR = new Creator();

    @NotNull
    private final List<ResolvableSpanObject> spanObjList;
    private final int startPos;

    @NotNull
    private final String text;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<Chunk> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Chunk createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i4 = 0; i4 != i2; i4++) {
                arrayList.add(ResolvableSpanObject.CREATOR.createFromParcel(parcel));
            }
            return new Chunk(i, string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Chunk[] newArray(int i) {
            return new Chunk[i];
        }
    }

    public Chunk(int i, @NotNull String text, @NotNull List<ResolvableSpanObject> spanObjList) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanObjList, "spanObjList");
        this.startPos = i;
        this.text = text;
        this.spanObjList = spanObjList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @NotNull
    public final String getResolvedText() {
        if (this.spanObjList.isEmpty()) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (ResolvableSpanObject resolvableSpanObject : CollectionsKt.sortedWith(this.spanObjList, new Comparator() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.modelinput.chunking.Chunk$getResolvedText$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ResolvableSpanObject) t).getPosition()), Integer.valueOf(((ResolvableSpanObject) t2).getPosition()));
            }
        })) {
            int position = resolvableSpanObject.getPosition() - this.startPos;
            if (position >= 0 && position <= this.text.length()) {
                if (i < position) {
                    String strSubstring = this.text.substring(i, position);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                }
                sb.append(resolvableSpanObject.getReplacement());
                i = position + 1;
            }
        }
        if (i < this.text.length()) {
            String strSubstring2 = this.text.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            sb.append(strSubstring2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public final List<ResolvableSpanObject> getSpanObjList() {
        return this.spanObjList;
    }

    public final int getStartPos() {
        return this.startPos;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.startPos);
        dest.writeString(this.text);
        List<ResolvableSpanObject> list = this.spanObjList;
        dest.writeInt(list.size());
        Iterator<ResolvableSpanObject> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
