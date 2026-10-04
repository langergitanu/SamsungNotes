package com.samsung.android.support.senl.p148nt.word.base;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJM\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00070\r2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0005j\b\u0012\u0004\u0012\u00020\u000f`\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/SpenWPageHelper;", "", "<init>", "()V", "getTextExtractInfosFixedPage", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/data/TextInfo;", "Lkotlin/collections/ArrayList;", "extractResult", "", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getTextExtractInfosContinuousPage", "", "thumbnailRects", "Landroid/graphics/RectF;", "(Ljava/util/List;Ljava/util/ArrayList;)[Ljava/util/ArrayList;", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenWPageHelper {

    @NotNull
    public static final SpenWPageHelper INSTANCE = new SpenWPageHelper();

    private SpenWPageHelper() {
    }

    @NotNull
    public final ArrayList<TextInfo>[] getTextExtractInfosContinuousPage(@Nullable List<? extends TextInfo> extractResult, @NotNull ArrayList<RectF> thumbnailRects) {
        Intrinsics.checkNotNullParameter(thumbnailRects, "thumbnailRects");
        ArrayList<TextInfo>[] arrayListArr = new ArrayList[thumbnailRects.size()];
        if (extractResult != null) {
            ArrayList arrayList = new ArrayList(thumbnailRects);
            int i = 0;
            for (TextInfo textInfo : extractResult) {
                RectF rectF = textInfo.rect;
                if (rectF != null) {
                    float f = rectF.top;
                    double d = ((rectF.bottom - f) / 2) + f;
                    while (!arrayList.isEmpty() && d > ((RectF) arrayList.get(0)).bottom) {
                        arrayList.remove(0);
                        i++;
                    }
                    if (arrayListArr[i] == null) {
                        arrayListArr[i] = new ArrayList<>();
                    }
                    ArrayList<TextInfo> arrayList2 = arrayListArr[i];
                    Intrinsics.checkNotNull(arrayList2);
                    arrayList2.add(textInfo);
                }
            }
        }
        return arrayListArr;
    }

    @NotNull
    public final ArrayList<TextInfo> getTextExtractInfosFixedPage(@Nullable List<? extends TextInfo> extractResult, @NotNull SpenWPage spenWPage) {
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
        ArrayList<TextInfo> arrayList = new ArrayList<>();
        if (extractResult != null) {
            for (TextInfo textInfo : extractResult) {
                if (Intrinsics.areEqual(spenWPage.getId(), textInfo.pageUuid)) {
                    arrayList.add(textInfo);
                }
            }
        }
        return arrayList;
    }
}
