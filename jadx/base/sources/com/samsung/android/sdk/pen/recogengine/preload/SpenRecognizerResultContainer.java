package com.samsung.android.sdk.pen.recogengine.preload;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultContainer;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "container", "", "<init>", "(J)V", "mContainer", "mResultList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface;", "Lkotlin/collections/ArrayList;", "getResultCount", "", "getResult", "index", "checkContainer", "", "getResultClass", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognizerResultContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognizerResultContainer.kt\ncom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultContainer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
public final class SpenRecognizerResultContainer implements SpenRecognizerResultContainerInterface {

    @NotNull
    private static final String TAG = "SpenRecognizerResultContainer";
    private long mContainer;

    @NotNull
    private final ArrayList<SpenRecognizerResultInterface> mResultList = new ArrayList<>();

    public SpenRecognizerResultContainer(long j) {
        this.mContainer = j;
        int iSPenRecognizerResultContainer_GetResultCount = SpenRecognizerLib.SPenRecognizerResultContainer_GetResultCount(j);
        AbstractC0541b.m755A(iSPenRecognizerResultContainer_GetResultCount, "result count = ", TAG);
        for (int i = 0; i < iSPenRecognizerResultContainer_GetResultCount; i++) {
            this.mResultList.add(getResultClass(i));
        }
    }

    private final SpenRecognizerResultInterface getResultClass(int index) {
        checkContainer();
        long jSPenRecognizerResultContainer_GetResult = SpenRecognizerLib.SPenRecognizerResultContainer_GetResult(this.mContainer, index);
        int iSPenRecognizerResultInterface_GetResultType = SpenRecognizerLib.SPenRecognizerResultInterface_GetResultType(jSPenRecognizerResultContainer_GetResult);
        AbstractC0541b.m755A(iSPenRecognizerResultInterface_GetResultType, "result type = ", TAG);
        if (iSPenRecognizerResultInterface_GetResultType == 0) {
            return new SpenRecognizerResultText(jSPenRecognizerResultContainer_GetResult);
        }
        if (iSPenRecognizerResultInterface_GetResultType == 1) {
            return new SpenRecognizerResultDocument(jSPenRecognizerResultContainer_GetResult);
        }
        if (iSPenRecognizerResultInterface_GetResultType == 2) {
            return new SpenRecognizerResultShape(jSPenRecognizerResultContainer_GetResult);
        }
        if (iSPenRecognizerResultInterface_GetResultType == 4) {
            return new SpenRecognizerResultMathExpression(jSPenRecognizerResultContainer_GetResult);
        }
        if (iSPenRecognizerResultInterface_GetResultType != 7) {
            return null;
        }
        return new SpenRecognizerResultBeautifier(jSPenRecognizerResultContainer_GetResult);
    }

    public final void checkContainer() {
        if (this.mContainer == 0) {
            throw new IllegalArgumentException("Recognition result container is not initialized!");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface
    @Nullable
    public SpenRecognizerResultInterface getResult(int index) {
        int size = this.mResultList.size();
        if (index >= 0 && index < size) {
            return this.mResultList.get(index);
        }
        Log.e(TAG, AbstractC0622a.m1164j(index, size, "Index(", ") out of bound(0 ~ ", ")"));
        throw new InvalidParameterException(AbstractC0622a.m1164j(index, size, "Index(", ") out of bound(0 ~ ", ")"));
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface
    public int getResultCount() {
        return this.mResultList.size();
    }
}
