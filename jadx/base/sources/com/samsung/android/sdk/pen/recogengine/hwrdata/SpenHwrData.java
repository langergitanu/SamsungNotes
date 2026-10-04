package com.samsung.android.sdk.pen.recogengine.hwrdata;

import android.graphics.RectF;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0011\b\u0016\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00058F@DX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010)\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R$\u0010,\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R$\u0010/\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u0011\u00102\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b3\u0010\u000fR\u0011\u00104\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b5\u0010\u000fRD\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001a2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u001c\"\u0004\b$\u0010\u001e¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrData;", "", "<init>", "()V", "mType", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataType;", "pageId", "", "getPageId", "()I", "setPageId", "(I)V", "mRect", "Landroid/graphics/RectF;", "getMRect", "()Landroid/graphics/RectF;", "setMRect", "(Landroid/graphics/RectF;)V", "mDrawnRect", "getMDrawnRect", "setMDrawnRect", "mPageRect", "getMPageRect", "setMPageRect", "mRuntimeHandleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMRuntimeHandleList", "()Ljava/util/ArrayList;", "setMRuntimeHandleList", "(Ljava/util/ArrayList;)V", "type", "getType", "()Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataType;", "setType", "(Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataType;)V", "setRuntimeHandleList", "", "runtimeHandleList", "", "len", "rect", "getRect", "setRect", "drawnRect", "getDrawnRect", "setDrawnRect", "pageRect", "getPageRect", "setPageRect", "absoluteRect", "getAbsoluteRect", "absoluteDrawnRect", "getAbsoluteDrawnRect", "getRuntimeHandleList", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenHwrData {

    @NotNull
    private static final String TAG = "SpenHwrData";

    @JvmField
    @NotNull
    protected SpenHwrDataType mType = SpenHwrDataType.HWR_DATA_TYPE_NONE;
    private int pageId = -1;

    @NotNull
    private RectF mRect = new RectF();

    @NotNull
    private RectF mDrawnRect = new RectF();

    @NotNull
    private RectF mPageRect = new RectF();

    @NotNull
    private ArrayList<Integer> mRuntimeHandleList = new ArrayList<>();

    @NotNull
    public final RectF getAbsoluteDrawnRect() {
        RectF rectF = this.mDrawnRect;
        RectF rectF2 = this.mPageRect;
        rectF.offset(rectF2.left, rectF2.top);
        return rectF;
    }

    @NotNull
    public final RectF getAbsoluteRect() {
        RectF rectF = this.mRect;
        RectF rectF2 = this.mPageRect;
        rectF.offset(rectF2.left, rectF2.top);
        return rectF;
    }

    @NotNull
    /* JADX INFO: renamed from: getDrawnRect, reason: from getter */
    public final RectF getMDrawnRect() {
        return this.mDrawnRect;
    }

    @NotNull
    public final RectF getMDrawnRect() {
        return this.mDrawnRect;
    }

    @NotNull
    public final RectF getMPageRect() {
        return this.mPageRect;
    }

    @NotNull
    public final RectF getMRect() {
        return this.mRect;
    }

    @NotNull
    public final ArrayList<Integer> getMRuntimeHandleList() {
        return this.mRuntimeHandleList;
    }

    public final int getPageId() {
        return this.pageId;
    }

    @NotNull
    public final RectF getPageRect() {
        return this.mPageRect;
    }

    @NotNull
    public final RectF getRect() {
        return this.mRect;
    }

    @NotNull
    public final ArrayList<Integer> getRuntimeHandleList() {
        return this.mRuntimeHandleList;
    }

    @NotNull
    /* JADX INFO: renamed from: getType, reason: from getter */
    public final SpenHwrDataType getMType() {
        return this.mType;
    }

    public final void setDrawnRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mDrawnRect = rect;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{Float.valueOf(rect.left), Float.valueOf(rect.top), Float.valueOf(rect.right), Float.valueOf(rect.bottom)}, 4, "SpenHwrData::setDrawnRect [%f, %f, %f, %f]", "format(format, *args)", TAG);
    }

    public final void setMDrawnRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.mDrawnRect = rectF;
    }

    public final void setMPageRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.mPageRect = rectF;
    }

    public final void setMRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.mRect = rectF;
    }

    public final void setMRuntimeHandleList(@NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mRuntimeHandleList = arrayList;
    }

    public final void setPageId(int i) {
        this.pageId = i;
    }

    public final void setPageRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mPageRect = rect;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{Float.valueOf(rect.left), Float.valueOf(rect.top), Float.valueOf(rect.right), Float.valueOf(rect.bottom)}, 4, "SpenHwrData::setPageRect [%f, %f, %f, %f]", "format(format, *args)", TAG);
    }

    public final void setRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mRect = rect;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{Float.valueOf(rect.left), Float.valueOf(rect.top), Float.valueOf(rect.right), Float.valueOf(rect.bottom)}, 4, "SpenHwrData::setRect [%f, %f, %f, %f]", "format(format, *args)", TAG);
    }

    public final void setRuntimeHandleList(@NotNull int[] runtimeHandleList, int len) {
        Intrinsics.checkNotNullParameter(runtimeHandleList, "runtimeHandleList");
        String str = "";
        for (int i = 0; i < len; i++) {
            this.mRuntimeHandleList.add(Integer.valueOf(runtimeHandleList[i]));
            str = str + runtimeHandleList[i] + " ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{str}, 1, "SpenHwrData::setRuntimeHandleList [%s]", "format(format, *args)", TAG);
    }

    public final void setType(@NotNull SpenHwrDataType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{type.toString()}, 1, "SpenHwrData::setType : %s", "format(format, *args)", TAG);
        this.mType = type;
    }

    public final void setRuntimeHandleList(@NotNull ArrayList<Integer> runtimeHandleList) {
        Intrinsics.checkNotNullParameter(runtimeHandleList, "runtimeHandleList");
        this.mRuntimeHandleList.clear();
        int size = runtimeHandleList.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            this.mRuntimeHandleList.add(runtimeHandleList.get(i));
            str = str + runtimeHandleList.get(i) + " ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{str}, 1, "SpenHwrData::setRuntimeHandleList [%s]", "format(format, *args)", TAG);
    }
}
