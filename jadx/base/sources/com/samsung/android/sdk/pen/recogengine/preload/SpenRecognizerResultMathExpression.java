package com.samsung.android.sdk.pen.recogengine.preload;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultMathExpressionInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultMathExpression;", "Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResult;", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultMathExpressionInterface;", "result", "", "<init>", "(J)V", "mResultString", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "resultCount", "", "getResultCount", "()I", "getResultString", "index", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognizerResultMathExpression.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognizerResultMathExpression.kt\ncom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultMathExpression\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class SpenRecognizerResultMathExpression extends SpenRecognizerResult implements SpenRecognizerResultMathExpressionInterface {

    @NotNull
    private static final String TAG = "SpenRecognizerResultMathExpression";

    @NotNull
    private final ArrayList<String> mResultString;

    public SpenRecognizerResultMathExpression(long j) {
        super(j, SpenRecognizerResultInterface.ResultType.MATH);
        this.mResultString = new ArrayList<>();
        int iSPenRecognizerResultMathExpressionInterface_GetResultCount = SpenRecognizerLib.SPenRecognizerResultMathExpressionInterface_GetResultCount(j);
        AbstractC0541b.m755A(iSPenRecognizerResultMathExpressionInterface_GetResultCount, "Result count ", TAG);
        for (int i = 0; i < iSPenRecognizerResultMathExpressionInterface_GetResultCount; i++) {
            String strSPenRecognizerResultMathExpressionInterface_GetResultString = SpenRecognizerLib.SPenRecognizerResultMathExpressionInterface_GetResultString(j, i);
            if (strSPenRecognizerResultMathExpressionInterface_GetResultString != null) {
                this.mResultString.add(strSPenRecognizerResultMathExpressionInterface_GetResultString);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultMathExpressionInterface
    public int getResultCount() {
        checkResult(TAG);
        return this.mResultString.size();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultMathExpressionInterface
    @Nullable
    public String getResultString(int index) {
        checkResult(TAG);
        checkIndex(TAG, index, getResultCount());
        return this.mResultString.get(index);
    }
}
