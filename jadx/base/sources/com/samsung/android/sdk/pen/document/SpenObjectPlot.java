package com.samsung.android.sdk.pen.document;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u0000 ?2\u00020\u0001:\u0002>?B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0019\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0013\u00101\u001a\u0004\u0018\u00010\b2\u0006\u00100\u001a\u00020\u0016H\u0082 J\u001b\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0019\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 J\u0011\u00104\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0016H\u0082 J\u0019\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0011\u00107\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0082 J\u0019\u00108\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0011\u00109\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0082 J)\u0010:\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00162\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0082 J%\u0010;\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"2\u0006\u00106\u001a\u00020\u0016H\u0082 J\u0019\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0016H\u0082 J\u0011\u0010=\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0082 R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bRL\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u0014\u0010'\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0019¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectPlot;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "bitmap", "Landroid/graphics/Bitmap;", "capturedBitmapPlot", "getCapturedBitmapPlot", "()Landroid/graphics/Bitmap;", "setCapturedBitmapPlot", "(Landroid/graphics/Bitmap;)V", "rect", "Landroid/graphics/RectF;", "coordinateRect", "getCoordinateRect", "()Landroid/graphics/RectF;", "setCoordinateRect", "(Landroid/graphics/RectF;)V", "color", "", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "coordinateColor", "getCoordinateColor", "setCoordinateColor", "graphData", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectPlot$GraphData;", "Lkotlin/collections/ArrayList;", "getGraphData", "()Ljava/util/ArrayList;", "setGraphData", "(Ljava/util/ArrayList;)V", "type", "angleType", "getAngleType", "setAngleType", "getType", "throwUncheckedException", "", "errno", "ObjectPlot_init", "handle", "ObjectPlot_getCapturedBitmap", "ObjectPlot_setCapturedBitmap", "ObjectPlot_setCoordinateRect", "ObjectPlot_getCoordinateRect", "ObjectPlot_setCoordinateColor", "nativeHandle", "ObjectPlot_getCoordinateColor", "ObjectPlot_setBackgroundColor", "ObjectPlot_getBackgroundColor", "ObjectPlot_setGraphData", "ObjectPlot_getGraphData", "ObjectPlot_setAngleType", "ObjectPlot_getAngleType", "GraphData", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectPlot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectPlot.kt\ncom/samsung/android/sdk/pen/document/SpenObjectPlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
public final class SpenObjectPlot extends SpenObjectBase {
    public static final int TYPE_ALL = 2;
    public static final int TYPE_DEGREE = 0;
    public static final int TYPE_RADIAN = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectPlot$GraphData;", "", "<init>", "()V", HtmlConstants.LATEX, "", "substitutionLatexs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "color", "", "lineWidth", "", "isShow", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class GraphData {

        @ColorInt
        @JvmField
        public int color;

        @JvmField
        public boolean isShow;

        @JvmField
        @Nullable
        public String latex;

        @JvmField
        public float lineWidth;

        @JvmField
        @Nullable
        public ArrayList<String> substitutionLatexs;
    }

    public SpenObjectPlot() {
        super(20);
    }

    private final native int ObjectPlot_getAngleType(int handle);

    private final native int ObjectPlot_getBackgroundColor(int handle);

    private final native Bitmap ObjectPlot_getCapturedBitmap(int handle);

    private final native int ObjectPlot_getCoordinateColor(int handle);

    private final native RectF ObjectPlot_getCoordinateRect(int handle);

    private final native ArrayList<GraphData> ObjectPlot_getGraphData(int nativeHandle);

    private final native boolean ObjectPlot_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectPlot_setAngleType(int handle, int type);

    private final native boolean ObjectPlot_setBackgroundColor(int nativeHandle, int color);

    private final native boolean ObjectPlot_setCapturedBitmap(int handle, Bitmap bitmap);

    private final native boolean ObjectPlot_setCoordinateColor(int nativeHandle, int color);

    private final native boolean ObjectPlot_setCoordinateRect(int handle, RectF rect);

    private final native boolean ObjectPlot_setGraphData(int nativeHandle, ArrayList<GraphData> graphData);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectPlot(" + this + ") is already closed");
    }

    public final int getAngleType() {
        return ObjectPlot_getAngleType(getMHandle());
    }

    @ColorInt
    public final int getBackgroundColor() {
        return ObjectPlot_getBackgroundColor(getMHandle());
    }

    @Nullable
    public final Bitmap getCapturedBitmapPlot() {
        return ObjectPlot_getCapturedBitmap(getMHandle());
    }

    @ColorInt
    public final int getCoordinateColor() {
        return ObjectPlot_getCoordinateColor(getMHandle());
    }

    @NotNull
    public final RectF getCoordinateRect() {
        return ObjectPlot_getCoordinateRect(getMHandle());
    }

    @Nullable
    public final ArrayList<GraphData> getGraphData() {
        ArrayList<GraphData> arrayListObjectPlot_getGraphData = ObjectPlot_getGraphData(getMHandle());
        if (arrayListObjectPlot_getGraphData == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListObjectPlot_getGraphData;
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    public final void setAngleType(int i) {
        if (ObjectPlot_setAngleType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @ColorInt
    @SuppressLint({"SupportAnnotationUsage"})
    public final void setBackgroundColor(int i) {
        if (ObjectPlot_setBackgroundColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCapturedBitmapPlot(@Nullable Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectPlot_setCapturedBitmap(getMHandle(), bitmap)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @ColorInt
    @SuppressLint({"SupportAnnotationUsage"})
    public final void setCoordinateColor(int i) {
        if (ObjectPlot_setCoordinateColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCoordinateRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ObjectPlot_setCoordinateRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setGraphData(@Nullable ArrayList<GraphData> arrayList) {
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(arrayList);
        if (ObjectPlot_setGraphData(mHandle, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectPlot(boolean z) {
        super(20);
        if (ObjectPlot_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
