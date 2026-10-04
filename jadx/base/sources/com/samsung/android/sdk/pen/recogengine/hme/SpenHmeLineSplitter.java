package com.samsung.android.sdk.pen.recogengine.hme;

import android.graphics.PointF;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007JP\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b26\u0010\f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\tj\b\u0012\u0004\u0012\u00020\r`\u000b0\tj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\tj\b\u0012\u0004\u0012\u00020\r`\u000b`\u000bH\u0002JR\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b26\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000b0\tj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000b`\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeLineSplitter;", "", "<init>", "()V", "mNativeHandle", "", "close", "", "convertToStrokeIndicesArrayList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeStrokeIndices;", "Lkotlin/collections/ArrayList;", "segmentedStrokes", "", "segment", "strokes", "Landroid/graphics/PointF;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeLineSplitter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenHmeLineSplitter";
    private long mNativeHandle = INSTANCE.Native_init();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0083 Jy\u0010\u000b\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\fj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e`\u000e2\u0006\u0010\n\u001a\u00020\u000726\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e0\fj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e`\u000eH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeLineSplitter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "Native_finalize", "", "nativeHandle", "Native_segment", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "strokes", "Landroid/graphics/PointF;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenHmeLineSplitter.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenHmeLineSplitter.Native_init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<ArrayList<Integer>> Native_segment(long nativeHandle, ArrayList<ArrayList<PointF>> strokes) {
            return SpenHmeLineSplitter.Native_segment(nativeHandle, strokes);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<ArrayList<Integer>> Native_segment(long j, ArrayList<ArrayList<PointF>> arrayList);

    private final ArrayList<SpenHmeStrokeIndices> convertToStrokeIndicesArrayList(ArrayList<ArrayList<Integer>> segmentedStrokes) {
        ArrayList<SpenHmeStrokeIndices> arrayList = new ArrayList<>();
        Iterator<ArrayList<Integer>> it = segmentedStrokes.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ArrayList<Integer> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            arrayList.add(new SpenHmeStrokeIndices(next));
        }
        return arrayList;
    }

    public final void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    @Nullable
    public final ArrayList<SpenHmeStrokeIndices> segment(@NotNull ArrayList<ArrayList<PointF>> strokes) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return convertToStrokeIndicesArrayList(INSTANCE.Native_segment(j, strokes));
    }
}
