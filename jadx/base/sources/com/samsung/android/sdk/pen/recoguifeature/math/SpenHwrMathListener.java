package com.samsung.android.sdk.pen.recoguifeature.math;

import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J$\u0010\u0005\u001a\u00020\u00032\u001a\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\tH&J$\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J&\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH&J\b\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenHwrMathListener;", "", "onProgressStart", "", "onProgressStop", "onMathResultAppended", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "onMathExpressionUpdated", "resultRect", "latexResult", "", "isPlottable", "", "onMathExpressionFailed", "failCode", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathFailCode;", "onControlVisibleChanged", "isVisible", "onClosed", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenHwrMathListener {
    void onClosed();

    void onControlVisibleChanged(boolean isVisible);

    void onMathExpressionFailed(@Nullable RectF resultRect, @Nullable String latexResult, @Nullable SpenMathFailCode failCode);

    void onMathExpressionUpdated(@Nullable RectF resultRect, @Nullable String latexResult, boolean isPlottable);

    void onMathResultAppended(@NotNull ArrayList<RectF> resultRectList);

    void onProgressStart();

    void onProgressStop();
}
