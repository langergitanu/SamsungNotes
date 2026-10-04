package com.samsung.android.sdk.pen.recogengine.preload;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0004R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResult;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface;", "<init>", "()V", "result", "", "type", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface$ResultType;", "(JLcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface$ResultType;)V", "mResult", "mResultType", "getResultType", "checkResult", "", "tag", "", "checkIndex", "index", "", "size", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenRecognizerResult implements SpenRecognizerResultInterface {

    @NotNull
    private static final String TAG;
    private long mResult;

    @NotNull
    private SpenRecognizerResultInterface.ResultType mResultType;

    static {
        Intrinsics.checkNotNullExpressionValue("SpenRecognizerResultText", "getSimpleName(...)");
        TAG = "SpenRecognizerResultText";
    }

    public SpenRecognizerResult() {
        this.mResultType = SpenRecognizerResultInterface.ResultType.UNKNOWN;
    }

    public final void checkIndex(@NotNull String tag, int index, int size) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (index < 0 || index >= size) {
            Log.e(tag, AbstractC0622a.m1164j(index, size - 1, "Index(", ") out of bound(0 ~ ", ")"));
            throw new InvalidParameterException("Index out of bound");
        }
    }

    public final void checkResult(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (this.mResult != 0) {
            return;
        }
        Log.e(tag, "The result is not initialized!");
        throw new IllegalStateException("The result is not initialized!");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface
    @NotNull
    public SpenRecognizerResultInterface.ResultType getResultType() {
        checkResult(TAG);
        return this.mResultType;
    }

    public SpenRecognizerResult(long j, @NotNull SpenRecognizerResultInterface.ResultType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        SpenRecognizerResultInterface.ResultType resultType = SpenRecognizerResultInterface.ResultType.TEXT;
        this.mResult = j;
        this.mResultType = type;
    }
}
