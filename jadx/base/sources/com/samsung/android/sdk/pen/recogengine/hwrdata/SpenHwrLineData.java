package com.samsung.android.sdk.pen.recogengine.hwrdata;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\u000b2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrLineData;", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrData;", "<init>", "()V", "wordDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrWordData;", "Lkotlin/collections/ArrayList;", "getWordDataList", "()Ljava/util/ArrayList;", "clear", "", "add", "data", "setWordData", "text", "", "getText", "()Ljava/lang/String;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrLineData extends SpenHwrData {

    @NotNull
    private static final String TAG = "SpenHwrLineData";

    @NotNull
    private final ArrayList<SpenHwrWordData> wordDataList = new ArrayList<>();

    public SpenHwrLineData() {
        this.mType = SpenHwrDataType.HWR_DATA_TYPE_LINE;
    }

    public final void add(@NotNull SpenHwrWordData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.wordDataList.add(data);
    }

    public final void clear() {
        this.wordDataList.clear();
    }

    @NotNull
    public final String getText() {
        StringBuilder sb = new StringBuilder();
        int size = this.wordDataList.size();
        int i = 0;
        while (i < size) {
            SpenHwrWordData spenHwrWordData = this.wordDataList.get(i);
            Intrinsics.checkNotNullExpressionValue(spenHwrWordData, "get(...)");
            sb.append(spenHwrWordData.getText());
            i++;
            if (i < this.wordDataList.size()) {
                sb.append(" ");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public final ArrayList<SpenHwrWordData> getWordDataList() {
        return this.wordDataList;
    }

    public final void setWordData(@NotNull ArrayList<SpenHwrWordData> wordDataList) {
        Intrinsics.checkNotNullParameter(wordDataList, "wordDataList");
        wordDataList.clear();
        int size = wordDataList.size();
        String strM757C = "";
        for (int i = 0; i < size; i++) {
            wordDataList.add(wordDataList.get(i));
            strM757C = AbstractC0541b.m757C(strM757C, wordDataList.get(i).getText(), " ");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{strM757C}, 1, "SpenHwrLineData::setWordData [%s]", "format(format, *args)", TAG);
    }
}
