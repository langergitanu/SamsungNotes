package com.samsung.android.sdk.pen.recoguifeature.converttotext;

import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextListener;", "", "<init>", "()V", "onProgressStart", "", "onProgressStop", "onConvertToText", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "rect", "Landroid/graphics/RectF;", "onCopySelected", "text", "", "onEditTextOverflow", "maxCount", "", "onEditLineOverflow", "onConvertToTextFailed", "isNoHandwriting", "", "onConvertToTextRunning", "isRunning", "onSetting", "onClose", "onFinished", "onConvertToTextHelpComplete", "onConvertToTextSkewed", "onUpdateRecognitionLanguage", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenConvertToTextListener {
    public void onClose() {
    }

    public void onConvertToText(@Nullable SpannableStringBuilder spannableStringBuilder, @Nullable RectF rect) {
    }

    public void onConvertToTextFailed(boolean isNoHandwriting) {
    }

    public void onConvertToTextHelpComplete() {
    }

    public void onConvertToTextRunning(boolean isRunning) {
    }

    public void onConvertToTextSkewed() {
    }

    public void onCopySelected(@Nullable CharSequence text) {
    }

    public void onEditLineOverflow(int maxCount) {
    }

    public void onEditTextOverflow(int maxCount) {
    }

    public void onFinished() {
    }

    public void onProgressStart() {
    }

    public void onProgressStop() {
    }

    public void onSetting() {
    }

    public void onUpdateRecognitionLanguage() {
    }
}
