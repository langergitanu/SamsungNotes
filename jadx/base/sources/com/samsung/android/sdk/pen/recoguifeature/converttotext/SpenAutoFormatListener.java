package com.samsung.android.sdk.pen.recoguifeature.converttotext;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016JX\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r2\u001e\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0084\u0001\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r2\u001e\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u001e\u0010\u0013\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016Jz\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r2\u001e\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u001e\u0010\u0013\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenAutoFormatListener;", "", "<init>", "()V", "onProgressStart", "", "onProgressStop", "onResultAnalyze", "showContext", "", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "resultViewRectList", "isTextIncluded", "onResultRecognize", "text", "", "originalSpanList", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "language", "onResult", "onRecognitionFailed", "isNoHandwriting", "onRecognitionRunning", "isRunning", "onUpdated", "isMaxLine", "isControlMoved", "onFailed", "onControlClosed", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenAutoFormatListener {
    public void onControlClosed() {
    }

    public void onFailed() {
    }

    public void onProgressStart() {
    }

    public void onProgressStop() {
    }

    public void onRecognitionFailed(boolean isNoHandwriting) {
    }

    public void onRecognitionRunning(boolean isRunning) {
    }

    public void onResult(boolean showContext, @Nullable ArrayList<RectF> resultRectList, @Nullable ArrayList<RectF> resultViewRectList, @Nullable String text, @Nullable ArrayList<SpenTextSpanBase> originalSpanList) {
    }

    public void onResultAnalyze(boolean showContext, @Nullable ArrayList<RectF> resultRectList, @Nullable ArrayList<RectF> resultViewRectList, boolean isTextIncluded) {
    }

    public void onResultRecognize(boolean showContext, @Nullable ArrayList<RectF> resultRectList, @Nullable ArrayList<RectF> resultViewRectList, @Nullable String text, @Nullable ArrayList<SpenTextSpanBase> originalSpanList, @Nullable String language) {
    }

    public void onUpdated(boolean isMaxLine, boolean isControlMoved) {
    }
}
