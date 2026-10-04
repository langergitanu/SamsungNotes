package com.samsung.android.sdk.pen.recogengine.hme;

import android.graphics.PointF;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ>\u0010\n\u001a\u00020\u000326\u0010\u000b\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\fj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e`\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRecognizerLatex;", "", "modelPath", "", "<init>", "(Ljava/lang/String;)V", "mNativeHandle", "", "close", "", "recognize", "strokes", "Ljava/util/ArrayList;", "Landroid/graphics/PointF;", "Lkotlin/collections/ArrayList;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeRecognizerLatex {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenHmeRecognizerLatex";
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0083 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 JI\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000726\u0010\r\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\u000ej\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010`\u0010H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRecognizerLatex$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "modelPath", "Native_finalize", "", "nativeHandle", "Native_recognize", "strokes", "Ljava/util/ArrayList;", "Landroid/graphics/PointF;", "Lkotlin/collections/ArrayList;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenHmeRecognizerLatex.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(String modelPath) {
            return SpenHmeRecognizerLatex.Native_init(modelPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_recognize(long nativeHandle, ArrayList<ArrayList<PointF>> strokes) {
            return SpenHmeRecognizerLatex.Native_recognize(nativeHandle, strokes);
        }

        private Companion() {
        }
    }

    public SpenHmeRecognizerLatex(@NotNull String modelPath) {
        Intrinsics.checkNotNullParameter(modelPath, "modelPath");
        this.mNativeHandle = INSTANCE.Native_init(modelPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_recognize(long j, ArrayList<ArrayList<PointF>> arrayList);

    public final void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    @NotNull
    public final String recognize(@NotNull ArrayList<ArrayList<PointF>> strokes) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        long j = this.mNativeHandle;
        return j == 0 ? "" : INSTANCE.Native_recognize(j, strokes);
    }
}
