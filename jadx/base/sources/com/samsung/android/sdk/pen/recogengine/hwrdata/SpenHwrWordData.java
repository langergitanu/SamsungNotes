package com.samsung.android.sdk.pen.recogengine.hwrdata;

import android.graphics.RectF;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\r2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrWordData;", "", "<init>", "()V", "mRect", "Landroid/graphics/RectF;", "letterDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrLetterData;", "Lkotlin/collections/ArrayList;", "getLetterDataList", "()Ljava/util/ArrayList;", "add", "", "data", "setLetterData", "rect", "getRect", "()Landroid/graphics/RectF;", "setRect", "(Landroid/graphics/RectF;)V", "text", "", "getText", "()Ljava/lang/String;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrWordData {

    @NotNull
    private static final String TAG = "SpenHwrWordData";

    @NotNull
    private RectF mRect = new RectF();

    @NotNull
    private final ArrayList<SpenHwrLetterData> letterDataList = new ArrayList<>();

    public final void add(@NotNull SpenHwrLetterData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.letterDataList.add(data);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{String.valueOf(data.getMLetter())}, 1, "SpenHwrWordData::add letter[%s]", "format(format, *args)", TAG);
    }

    @NotNull
    public final ArrayList<SpenHwrLetterData> getLetterDataList() {
        return this.letterDataList;
    }

    @NotNull
    /* JADX INFO: renamed from: getRect, reason: from getter */
    public final RectF getMRect() {
        return this.mRect;
    }

    @NotNull
    public final String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<SpenHwrLetterData> it = this.letterDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHwrLetterData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            sb.append(next.getMLetter());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void setLetterData(@NotNull ArrayList<SpenHwrLetterData> letterDataList) {
        Intrinsics.checkNotNullParameter(letterDataList, "letterDataList");
        letterDataList.clear();
        int size = letterDataList.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            letterDataList.add(letterDataList.get(i));
            str = str + letterDataList.get(i).getMLetter();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{str}, 1, "SpenHwrWordData::setLetterData [%s]", "format(format, *args)", TAG);
    }

    public final void setRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mRect = rect;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{Float.valueOf(rect.left), Float.valueOf(rect.top), Float.valueOf(rect.right), Float.valueOf(rect.bottom)}, 4, "SpenHwrWordData::setRect [%f, %f, %f, %f]", "format(format, *args)", TAG);
    }
}
