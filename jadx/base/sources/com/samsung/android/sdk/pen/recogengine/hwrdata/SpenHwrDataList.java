package com.samsung.android.sdk.pen.recogengine.hwrdata;

import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\u000e\u001a\u00020\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 R%\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataList;", "", "<init>", "()V", "wordDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrData;", "Lkotlin/collections/ArrayList;", "getWordDataList", "()Ljava/util/ArrayList;", "clear", "", "add", "data", "setHwrDataList", "hwrDataList", "size", "", "getSize", "()I", "firstDataPageID", "getFirstDataPageID", "getRect", "Landroid/graphics/RectF;", "type", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataType;", "getAbsoluteRect", "getDrawnRect", "getAbsoluteDrawnRect", "getIntersectedPageRect", "printData", "prefix", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrDataList {

    @NotNull
    private static final String TAG = "SpenHwrDataList";

    @NotNull
    private final ArrayList<SpenHwrData> wordDataList = new ArrayList<>();

    public final void add(@Nullable SpenHwrData data) {
        this.wordDataList.add(data);
    }

    public final void clear() {
        this.wordDataList.clear();
    }

    @NotNull
    public final RectF getAbsoluteDrawnRect(@NotNull SpenHwrDataType type) {
        SpenHwrDataType mType;
        Intrinsics.checkNotNullParameter(type, "type");
        RectF rectF = new RectF();
        Iterator<SpenHwrData> it = this.wordDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHwrData next = it.next();
            if (next == null || (mType = next.getMType()) == null || (mType.getValue() & type.getValue()) != 0) {
                if (next != null) {
                    rectF.union(next.getAbsoluteDrawnRect());
                }
            }
        }
        return rectF;
    }

    @NotNull
    public final RectF getAbsoluteRect(@NotNull SpenHwrDataType type) {
        SpenHwrDataType mType;
        Intrinsics.checkNotNullParameter(type, "type");
        RectF rectF = new RectF();
        Iterator<SpenHwrData> it = this.wordDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHwrData next = it.next();
            if (next == null || (mType = next.getMType()) == null || (mType.getValue() & type.getValue()) != 0) {
                if (next != null) {
                    rectF.union(next.getAbsoluteRect());
                }
            }
        }
        return rectF;
    }

    @NotNull
    public final RectF getDrawnRect(@NotNull SpenHwrDataType type) {
        SpenHwrDataType mType;
        Intrinsics.checkNotNullParameter(type, "type");
        RectF rectF = new RectF();
        Iterator<SpenHwrData> it = this.wordDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHwrData next = it.next();
            if (next == null || (mType = next.getMType()) == null || (mType.getValue() & type.getValue()) != 0) {
                if (next != null) {
                    rectF.union(next.getMDrawnRect());
                }
            }
        }
        return rectF;
    }

    public final int getFirstDataPageID() {
        SpenHwrData spenHwrData;
        if (this.wordDataList.isEmpty() || (spenHwrData = this.wordDataList.get(0)) == null) {
            return -1;
        }
        return spenHwrData.getPageId();
    }

    @NotNull
    public final RectF getIntersectedPageRect(@NotNull SpenHwrDataType type) {
        SpenHwrDataType mType;
        Intrinsics.checkNotNullParameter(type, "type");
        RectF rectF = new RectF();
        Iterator<SpenHwrData> it = this.wordDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHwrData next = it.next();
            if (next == null || (mType = next.getMType()) == null || (mType.getValue() & type.getValue()) != 0) {
                if (next != null) {
                    rectF.union(next.getPageRect());
                }
            }
        }
        return rectF;
    }

    @NotNull
    public final RectF getRect(@NotNull SpenHwrDataType type) {
        SpenHwrDataType mType;
        Intrinsics.checkNotNullParameter(type, "type");
        RectF rectF = new RectF();
        Iterator<SpenHwrData> it = this.wordDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHwrData next = it.next();
            if (next == null || (mType = next.getMType()) == null || (mType.getValue() & type.getValue()) != 0) {
                if (next != null) {
                    rectF.union(next.getRect());
                }
            }
        }
        return rectF;
    }

    public final int getSize() {
        return this.wordDataList.size();
    }

    @NotNull
    public final ArrayList<SpenHwrData> getWordDataList() {
        return this.wordDataList;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void printData(@Nullable String prefix) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{prefix, Integer.valueOf(this.wordDataList.size())}, 2, "%s hwrDataList.size(%d)", "format(format, *args)", TAG);
        int size = this.wordDataList.size();
        for (int i = 0; i < size; i++) {
            SpenHwrData spenHwrData = this.wordDataList.get(i);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Integer numValueOf = Integer.valueOf(i);
            Intrinsics.checkNotNull(spenHwrData);
            AbstractC6670b.m4760u(new Object[]{prefix, numValueOf, Integer.valueOf(spenHwrData.getPageId()), spenHwrData.getMType().toString()}, 4, "%s hwrDataList(%d) pageId : %d, type : %s", "format(format, *args)", TAG);
            AbstractC6670b.m4760u(new Object[]{prefix, Integer.valueOf(i), Float.valueOf(spenHwrData.getPageRect().left), Float.valueOf(spenHwrData.getPageRect().top), Float.valueOf(spenHwrData.getPageRect().right), Float.valueOf(spenHwrData.getPageRect().bottom)}, 6, "%s hwrDataList(%d) \t\t pageRect(L:%.2f, T:%.2f, R:%.2f, B:%.2f)", "format(format, *args)", TAG);
            AbstractC6670b.m4760u(new Object[]{prefix, Integer.valueOf(i), Float.valueOf(spenHwrData.getRect().left), Float.valueOf(spenHwrData.getRect().top), Float.valueOf(spenHwrData.getRect().right), Float.valueOf(spenHwrData.getRect().bottom)}, 6, "%s hwrDataList(%d) \t\t rect(L:%.2f, T:%.2f, R:%.2f, B:%.2f)", "format(format, *args)", TAG);
            ArrayList<Integer> runtimeHandleList = spenHwrData.getRuntimeHandleList();
            int size2 = runtimeHandleList.size();
            String str = "";
            for (int i2 = 0; i2 < size2; i2++) {
                str = str + runtimeHandleList.get(i2) + " ";
            }
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            AbstractC6670b.m4760u(new Object[]{prefix, Integer.valueOf(i), str}, 3, "%s hwrDataList(%d) \t\t runtimeHandleList : %s", "format(format, *args)", TAG);
            if (spenHwrData.getMType() == SpenHwrDataType.HWR_DATA_TYPE_LINE) {
                SpenHwrLineData spenHwrLineData = spenHwrData instanceof SpenHwrLineData ? (SpenHwrLineData) spenHwrData : null;
                Intrinsics.checkNotNull(spenHwrLineData);
                if (spenHwrLineData.getText().length() > 0) {
                    AbstractC6670b.m4760u(new Object[]{prefix, Integer.valueOf(i), ((SpenHwrLineData) spenHwrData).getText()}, 3, "%s hwrDataList(%d) \t\t text : %s", "format(format, *args)", TAG);
                }
            } else if (spenHwrData.getMType() == SpenHwrDataType.HWR_DATA_TYPE_EXTRA) {
                AbstractC6670b.m4760u(new Object[]{prefix, Integer.valueOf(i), ((SpenHwrExtraData) spenHwrData).getMExtraDataType().toString()}, 3, "%s hwrDataList(%d) \t\t extra type : %s", "format(format, *args)", TAG);
            }
        }
    }

    public final void setHwrDataList(@NotNull ArrayList<SpenHwrData> hwrDataList) {
        Intrinsics.checkNotNullParameter(hwrDataList, "hwrDataList");
        this.wordDataList.clear();
        int size = hwrDataList.size();
        for (int i = 0; i < size; i++) {
            SpenHwrData spenHwrData = hwrDataList.get(i);
            Intrinsics.checkNotNullExpressionValue(spenHwrData, "get(...)");
            SpenHwrData spenHwrData2 = spenHwrData;
            this.wordDataList.add(spenHwrData2);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("SpenHwrDataList::setHwrDataList add data[%d] %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), spenHwrData2.getMType().toString()}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            Log.d(TAG, str);
        }
    }
}
