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
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J0\u0010\u001e\u001a\u00020\u00032\u001e\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 j\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u0001`\"2\u0006\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J(\u0010&\u001a\u00020\u00032\u001e\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 j\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u0001`\"H&J\b\u0010'\u001a\u00020\u0003H&J0\u0010&\u001a\u00020\u00032\u001e\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 j\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u0001`\"2\u0006\u0010#\u001a\u00020\u0003H&J\u0012\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*H&J\b\u0010+\u001a\u00020\u0003H&J(\u0010,\u001a\u00020\u00072\u001e\u0010-\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010 j\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u0001`\"H&J\u0012\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u000101H&J\b\u00102\u001a\u00020\u0007H&J\u0012\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u000105H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "", "isEditing", "", "()Z", "isFloatingViewShown", "setDocument", "", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setNativeHandle", "handle", "", "close", "closeAutoFormat", "setRecognitionListener", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextListener;", "setAutoFormatListener", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenAutoFormatListener;", "setTextTransformEnabled", "enable", "setConvertToTextEnabled", "enabled", "setDarkModeEnabled", "isDarkModeGUI", "isDarkMode", "executeConvertToText", "executeExtractText", "executeAutoFormat", "executeAutoFormatAnalyze", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "isFullyContainedOnly", "nextAutoFormatAnalyze", "maxAutoFormatAnalyze", "executeAutoFormatRecognize", "executeAutoFormatExtractText", "executeConvertToTextFromPoint", "position", "Landroid/graphics/PointF;", "cancelConvertToText", "setRecognitionLanguageList", XmlErrorCodes.LIST, "", "setCanvasLayout", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/view/ViewGroup;", "closeControl", "updateLanguage", "text", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenConvertToTextManager {
    boolean cancelConvertToText();

    void close();

    boolean closeAutoFormat();

    void closeControl();

    boolean executeAutoFormat();

    boolean executeAutoFormatAnalyze();

    boolean executeAutoFormatAnalyze(@Nullable ArrayList<RectF> resultRectList, boolean isFullyContainedOnly);

    boolean executeAutoFormatExtractText();

    boolean executeAutoFormatRecognize(@Nullable ArrayList<RectF> resultRectList);

    boolean executeAutoFormatRecognize(@Nullable ArrayList<RectF> resultRectList, boolean isFullyContainedOnly);

    boolean executeConvertToText();

    boolean executeConvertToTextFromPoint(@Nullable PointF position);

    boolean executeExtractText();

    boolean isEditing();

    boolean isFloatingViewShown();

    boolean maxAutoFormatAnalyze();

    boolean nextAutoFormatAnalyze();

    void setAutoFormatListener(@Nullable SpenAutoFormatListener l);

    void setCanvasLayout(@Nullable ViewGroup layout);

    void setConvertToTextEnabled(boolean enabled);

    void setDarkModeEnabled(boolean isDarkModeGUI, boolean isDarkMode);

    void setDocument(@Nullable SpenWNote doc);

    void setNativeHandle(long handle);

    void setRecognitionLanguageList(@Nullable ArrayList<String> list);

    void setRecognitionListener(@Nullable SpenConvertToTextListener l);

    void setTextTransformEnabled(boolean enable);

    void updateLanguage(@Nullable CharSequence text);
}
