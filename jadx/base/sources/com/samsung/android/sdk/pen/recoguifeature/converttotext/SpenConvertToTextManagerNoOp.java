package com.samsung.android.sdk.pen.recoguifeature.converttotext;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J0\u0010 \u001a\u00020\u00052\u001e\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"j\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001`$2\u0006\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J(\u0010(\u001a\u00020\u00052\u001e\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"j\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001`$H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J0\u0010(\u001a\u00020\u00052\u001e\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"j\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001`$2\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0012\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J(\u0010.\u001a\u00020\t2\u001e\u0010/\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\"j\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u0001`$H\u0016J\u0012\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\tH\u0016J\u0012\u00105\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000107H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManagerNoOp;", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "<init>", "()V", "isEditing", "", "()Z", "isFloatingViewShown", "setDocument", "", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setNativeHandle", "handle", "", "close", "closeAutoFormat", "setRecognitionListener", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextListener;", "setAutoFormatListener", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenAutoFormatListener;", "setTextTransformEnabled", "enable", "setConvertToTextEnabled", "enabled", "setDarkModeEnabled", "isDarkModeGUI", "isDarkMode", "executeConvertToText", "executeExtractText", "executeAutoFormat", "executeAutoFormatAnalyze", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "isFullyContainedOnly", "nextAutoFormatAnalyze", "maxAutoFormatAnalyze", "executeAutoFormatRecognize", "executeAutoFormatExtractText", "executeConvertToTextFromPoint", "position", "Landroid/graphics/PointF;", "cancelConvertToText", "setRecognitionLanguageList", XmlErrorCodes.LIST, "", "setCanvasLayout", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/view/ViewGroup;", "closeControl", "updateLanguage", "text", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenConvertToTextManagerNoOp implements ISpenConvertToTextManager {
    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean cancelConvertToText() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean closeAutoFormat() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void closeControl() {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormat() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatAnalyze() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatExtractText() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatRecognize(@Nullable ArrayList<RectF> resultRectList) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeConvertToText() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeConvertToTextFromPoint(@Nullable PointF position) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeExtractText() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean isEditing() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean isFloatingViewShown() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean maxAutoFormatAnalyze() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean nextAutoFormatAnalyze() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setAutoFormatListener(@Nullable SpenAutoFormatListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setCanvasLayout(@Nullable ViewGroup layout) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setConvertToTextEnabled(boolean enabled) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setDarkModeEnabled(boolean isDarkModeGUI, boolean isDarkMode) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setDocument(@Nullable SpenWNote doc) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setNativeHandle(long handle) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setRecognitionLanguageList(@Nullable ArrayList<String> list) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setRecognitionListener(@Nullable SpenConvertToTextListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setTextTransformEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void updateLanguage(@Nullable CharSequence text) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatAnalyze(@Nullable ArrayList<RectF> resultRectList, boolean isFullyContainedOnly) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatRecognize(@Nullable ArrayList<RectF> resultRectList, boolean isFullyContainedOnly) {
        return false;
    }
}
