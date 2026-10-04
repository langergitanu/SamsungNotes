package com.samsung.android.sdk.pen.recoguifeature.alignment;

import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J(\u0010\u001b\u001a\u00020\u00052\u001e\u0010\u001c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u0001`\u001fH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0012\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J \u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0016J(\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/alignment/SpenAlignmentManagerNoOp;", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "<init>", "()V", "isRunning", "", "()Z", "isBeautificationSupported", "letterCorrectionEnabled", "getLetterCorrectionEnabled", "lineCorrectionEnabled", "getLineCorrectionEnabled", "wordSpacingEnabled", "getWordSpacingEnabled", "setNativeHandle", "", "handle", "", "close", "setListener", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/SPenAlignmentListener;", "setEnabled", "enable", "executeAlignment", "executeSelectionAlignment", "cancelAlignment", "executeCleanUp", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "executeSelectionCleanUp", "cancel", "confirm", "updateLanguage", "text", "", "setBeautificationOptions", "fixShapeOfLetters", "alignLetters", "evenlySpaceWords", "straighten", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAlignmentManagerNoOp implements ISPenAlignmentManager {
    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean cancel() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean cancelAlignment() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean confirm() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeAlignment() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeCleanUp() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeSelectionAlignment() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeSelectionCleanUp() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean getLetterCorrectionEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean getLineCorrectionEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean getWordSpacingEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean isBeautificationSupported() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean isRunning() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setBeautificationOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean evenlySpaceWords) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setListener(@Nullable SPenAlignmentListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setNativeHandle(long handle) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void updateLanguage(@Nullable CharSequence text) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeCleanUp(@Nullable ArrayList<RectF> resultRectList) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setBeautificationOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean evenlySpaceWords, boolean straighten) {
    }
}
