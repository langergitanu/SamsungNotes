package com.samsung.android.sdk.pen.recogengine.hme;

import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenRecognizerMathSolver;", "", HtmlConstants.LATEX, "", "<init>", "(Ljava/lang/String;)V", "close", "", "SetSettingParams", "decimalDigits", "", "maxDigitsDecimalNotation", "ResetContext", "Calculate", "s", "IsPlottable", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecognizerMathSolver {
    public SpenRecognizerMathSolver(@Nullable String str) {
    }

    @NotNull
    public final String Calculate(@Nullable String s) {
        return "mathsolver";
    }

    public final boolean IsPlottable(@Nullable String latex) {
        return false;
    }

    public final void ResetContext() {
    }

    public final void SetSettingParams(int decimalDigits, int maxDigitsDecimalNotation) {
    }

    public final void close() {
    }
}
