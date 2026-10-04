package com.samsung.android.sdk.pen.recogengine.preload;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000b\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultText;", "Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResult;", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultTextInterface;", "result", "", "<init>", "(J)V", "mResultString", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mCharacterIndex", "", "getResultString", "index", "getResultCount", "getStrokeIndex", "", "characterIndex", "getStartStrokeIndex", "getEndStrokeIndex", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecognizerResultText extends SpenRecognizerResult implements SpenRecognizerResultTextInterface {

    @NotNull
    private static final String TAG = "SpenRecognizerResultText";

    @NotNull
    private final ArrayList<ArrayList<Integer>> mCharacterIndex;

    @NotNull
    private final ArrayList<String> mResultString;

    public SpenRecognizerResultText(long j) {
        super(j, SpenRecognizerResultInterface.ResultType.TEXT);
        this.mResultString = new ArrayList<>();
        this.mCharacterIndex = new ArrayList<>();
        Log.d(TAG, "result address = " + j);
        int iSPenRecognizerResultTextInterface_GetResultCount = SpenRecognizerLib.SPenRecognizerResultTextInterface_GetResultCount(j);
        AbstractC0541b.m755A(iSPenRecognizerResultTextInterface_GetResultCount, "Result count = ", TAG);
        for (int i = 0; i < iSPenRecognizerResultTextInterface_GetResultCount; i++) {
            this.mResultString.add(SpenRecognizerLib.SPenRecognizerResultTextInterface_GetResultString(j, i));
        }
        String str = this.mResultString.get(0);
        Intrinsics.checkNotNull(str);
        int length = str.length();
        AbstractC0541b.m755A(length, "Result length = ", TAG);
        for (int i2 = 0; i2 < length; i2++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int[] iArrSPenRecognizerResultTextInterface_GetStrokeIndex = SpenRecognizerLib.SPenRecognizerResultTextInterface_GetStrokeIndex(j, i2);
            if (iArrSPenRecognizerResultTextInterface_GetStrokeIndex != null) {
                int length2 = iArrSPenRecognizerResultTextInterface_GetStrokeIndex.length;
                for (int iM1200a = 0; iM1200a < length2; iM1200a = AbstractC1038a.m1200a(iArrSPenRecognizerResultTextInterface_GetStrokeIndex[iM1200a], iM1200a, 1, arrayList)) {
                }
            }
            this.mCharacterIndex.add(arrayList);
        }
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface
    public int getEndStrokeIndex(int characterIndex) {
        checkResult(TAG);
        ArrayList<Integer> arrayList = this.mCharacterIndex.get(characterIndex);
        Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
        return ((Number) AbstractC0000a.m10g(arrayList, 1)).intValue();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface
    public int getResultCount() {
        checkResult(TAG);
        return this.mResultString.size();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface
    @Nullable
    public String getResultString(int index) {
        checkResult(TAG);
        checkIndex(TAG, index, getResultCount());
        return this.mResultString.get(index);
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface
    public int getStartStrokeIndex(int characterIndex) {
        checkResult(TAG);
        Integer num = this.mCharacterIndex.get(characterIndex).get(0);
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        return num.intValue();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface
    @Nullable
    public List<Integer> getStrokeIndex(int characterIndex) {
        checkResult(TAG);
        return this.mCharacterIndex.get(characterIndex);
    }
}
