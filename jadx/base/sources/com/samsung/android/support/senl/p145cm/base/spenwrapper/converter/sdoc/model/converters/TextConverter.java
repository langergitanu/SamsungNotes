package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenComposingBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenComposingSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenComposingTagSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenParsingStateParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.sdk.pen.engine.util.SpenEngineUtil;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 *2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/TextConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", "<init>", "()V", "mNoteComposer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "mConvertParams", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "convertContent", "", "src", ActionHandler.PARAMS, "copyParsingState", "", "dest", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "copyBasic", "copyAlignment", "start", "", "copyTaskStyle", "copySpans", "copySpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "span", "Lcom/samsung/android/sdk/composer/document/sdoc/textspan/SpenTextSpan;", "copyHyperTextSpan", "srcSpan", "destSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenHyperTextSpan;", "copyHyperTextDateTimeType", "updateAlignmentByText", "Lcom/samsung/android/sdk/pen/document/textspan/SpenAlignmentParagraph;", "contentBase", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "startPosition", "resizeFontSizeForCanvas", "", "originSize", "resizeFontSizeBySystem", "release", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextConverter.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/TextConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
public final class TextConverter extends AbsContentConverter<SpenContentText> {
    private static final int DEFAULT_COLOR = -16777216;
    private static final float DEFAULT_TEXT_SIZE_FOR_CANVAS = 16.0f;
    private static final int SDOC_TEXT_LENGTH_LIMIT = 30000;

    @NotNull
    private static final String TAG = "SDocXConverter$TextConverter";

    @Nullable
    private IConvertParams mConvertParams;

    @Nullable
    private INoteComposer mNoteComposer;

    private final void copyAlignment(SpenContentText src, SpenObjectTextBox dest, int start) {
        int alignment = src.getAlignment();
        SpenAlignmentParagraph spenAlignmentParagraphUpdateAlignmentByText = alignment != 0 ? alignment != 1 ? alignment != 2 ? alignment != 3 ? alignment != 4 ? null : updateAlignmentByText(src, start) : new SpenAlignmentParagraph(start, start + 1, 3) : new SpenAlignmentParagraph(start, start + 1, 2) : new SpenAlignmentParagraph(start, start + 1, 1) : new SpenAlignmentParagraph(start, start + 1, 0);
        if (spenAlignmentParagraphUpdateAlignmentByText != null) {
            dest.appendTextParagraph(spenAlignmentParagraphUpdateAlignmentByText);
        }
    }

    private final void copyBasic(SpenContentText src, SpenObjectTextBox dest) {
        dest.setText(src.getText());
        dest.setTextColor(-16777216);
        dest.setFontSize(resizeFontSizeBySystem(16.0f));
    }

    private final void copyHyperTextDateTimeType(SpenTextSpan srcSpan, SpenHyperTextSpan destSpan) {
        destSpan.setDateTimeType(srcSpan.getDateTimeType());
    }

    private final void copyHyperTextSpan(SpenTextSpan srcSpan, SpenHyperTextSpan destSpan) {
        switch (srcSpan.getHypertextType()) {
            case 0:
                destSpan.setHyperTextType(0);
                break;
            case 1:
                destSpan.setHyperTextType(3);
                break;
            case 2:
                destSpan.setHyperTextType(1);
                break;
            case 3:
                destSpan.setHyperTextType(2);
                break;
            case 4:
                destSpan.setHyperTextType(5);
                break;
            case 5:
                destSpan.setHyperTextType(6);
                copyHyperTextDateTimeType(srcSpan, destSpan);
                break;
            case 6:
                destSpan.setHyperTextType(7);
                break;
        }
    }

    private final void copyParsingState(SpenContentText src, SpenObjectTextBox dest) {
        dest.appendTextParagraph(new SpenParsingStateParagraph(0, 1, src.isParsedText()));
    }

    private final SpenTextSpanBase copySpan(SpenTextSpan span) {
        int start = span.getStart();
        int end = span.getEnd();
        switch (span.getType()) {
            case 11:
                return new SpenBoldSpan(start, end, span.getExpansion(), true);
            case 12:
                return new SpenItalicSpan(start, end, span.getExpansion(), true);
            case 13:
                return new SpenUnderlineSpan(start, end, span.getExpansion(), true);
            case 14:
                return new SpenForegroundColorSpan(start, end, span.getExpansion(), span.getForegroundColor());
            case 15:
                return new SpenFontSizeSpan(start, end, span.getExpansion(), resizeFontSizeBySystem(span.getFontSize()));
            case 16:
                SpenHyperTextSpan spenHyperTextSpan = new SpenHyperTextSpan(span.getStart(), span.getEnd(), span.getExpansion());
                copyHyperTextSpan(span, spenHyperTextSpan);
                return spenHyperTextSpan;
            case 17:
                return new SpenComposingBackgroundColorSpan(start, end, span.getExpansion(), span.getComposingBackgroundColor());
            case 18:
                return new SpenComposingSpan(start, end, span.getExpansion(), true);
            case 19:
                return new SpenBackgroundColorSpan(start, end, span.getExpansion(), span.getBackgroundColor());
            case 20:
                return new SpenComposingTagSpan(start, end, span.getExpansion(), true);
            default:
                return null;
        }
    }

    private final void copySpans(SpenContentText src, SpenObjectTextBox dest) {
        int length;
        ArrayList<SpenTextSpan> span = src.getSpan();
        ArrayList<SpenTextSpanBase> textSpan = dest.getTextSpan() != null ? dest.getTextSpan() : new ArrayList<>();
        if (span == null) {
            return;
        }
        if (src.getText() != null) {
            String text = src.getText();
            Intrinsics.checkNotNull(text);
            length = text.length();
        } else {
            length = 0;
        }
        Iterator<SpenTextSpan> it = span.iterator();
        while (it.hasNext()) {
            SpenTextSpanBase spenTextSpanBaseCopySpan = copySpan(it.next());
            if (spenTextSpanBaseCopySpan != null) {
                int start = spenTextSpanBaseCopySpan.getStart();
                int end = spenTextSpanBaseCopySpan.getEnd();
                if (start <= length) {
                    if (end > length) {
                        spenTextSpanBaseCopySpan.setPosition(start, length);
                    }
                    if (textSpan != null) {
                        textSpan.add(spenTextSpanBaseCopySpan);
                    }
                }
            }
        }
        dest.setTextSpan(textSpan);
    }

    private final void copyTaskStyle(SpenContentText src, SpenObjectTextBox dest, int start) {
        SpenBulletParagraph spenBulletParagraph;
        INoteComposer iNoteComposer;
        ObjectTaskStyle lastTaskStyle;
        INoteComposer iNoteComposer2 = this.mNoteComposer;
        if (iNoteComposer2 != null && iNoteComposer2.isAddedTask(src.getTaskId())) {
            dest.appendTextParagraph(new SpenIndentLevelParagraph(start, start + 1, 2));
            return;
        }
        ObjectTaskStyle objectTaskStyle = new ObjectTaskStyle(src);
        int taskStyle = src.getTaskStyle();
        if (taskStyle == 0) {
            spenBulletParagraph = new SpenBulletParagraph(start, start + 1, 0);
        } else if (taskStyle == 1) {
            spenBulletParagraph = new SpenBulletParagraph(start, start + 1, 2);
        } else if (taskStyle == 2) {
            SpenBulletParagraph spenBulletParagraph2 = new SpenBulletParagraph(start, start + 1, 2);
            spenBulletParagraph2.Checkout(true);
            spenBulletParagraph = spenBulletParagraph2;
        } else if (taskStyle != 3) {
            spenBulletParagraph = null;
            if (taskStyle == 4) {
                INoteComposer iNoteComposer3 = this.mNoteComposer;
                if ((iNoteComposer3 != null ? iNoteComposer3.getLastTaskObjectType() : null) == INoteComposer.ComposingObjectType.NONE || (iNoteComposer = this.mNoteComposer) == null || (lastTaskStyle = iNoteComposer.getLastTaskStyle()) == null || lastTaskStyle.getMType() != 101) {
                    spenBulletParagraph = new SpenBulletParagraph(start, start + 1, 4);
                    spenBulletParagraph.setBulletNumber(src.getTaskNumber());
                } else {
                    SpenObjectTextBox spenObjectTextBoxMakeObjectTextBox = SpenObjectConstructor.makeObjectTextBox(src.getTaskNumber() + ". ");
                    String text = spenObjectTextBoxMakeObjectTextBox.getText();
                    Intrinsics.checkNotNull(text);
                    dest.insertText(0, spenObjectTextBoxMakeObjectTextBox, 0, text.length());
                    objectTaskStyle.setTaskType(101);
                }
            }
        } else {
            spenBulletParagraph = new SpenBulletParagraph(start, start + 1, 8);
        }
        if (spenBulletParagraph != null) {
            dest.appendTextParagraph(spenBulletParagraph);
        }
        int taskId = src.getTaskId();
        if (taskId != -1) {
            INoteComposer.ComposingObjectType composingObjectType = INoteComposer.ComposingObjectType.TEXT;
            INoteComposer iNoteComposer4 = this.mNoteComposer;
            if (iNoteComposer4 != null) {
                iNoteComposer4.addTaskInfo(taskId, composingObjectType, objectTaskStyle);
            }
        }
    }

    private final float resizeFontSizeBySystem(float originSize) {
        IResourceGetter resourceGetter;
        DisplayMetrics displayMetrics;
        IResourceGetter resourceGetter2;
        IConvertParams iConvertParams = this.mConvertParams;
        if (iConvertParams == null || (resourceGetter = iConvertParams.getResourceGetter()) == null || (displayMetrics = resourceGetter.getDisplayMetrics()) == null) {
            return originSize;
        }
        float width = (displayMetrics.scaledDensity * originSize) / ((this.mNoteComposer != null ? r1.getWidth() : 1080) / 360.0f);
        IConvertParams iConvertParams2 = this.mConvertParams;
        float defaultTextSizeDeltaByDevice = width - ((iConvertParams2 == null || (resourceGetter2 = iConvertParams2.getResourceGetter()) == null) ? 0.0f : resourceGetter2.getDefaultTextSizeDeltaByDevice());
        IConvertParams iConvertParams3 = this.mConvertParams;
        Intrinsics.checkNotNull(iConvertParams3);
        IResourceGetter resourceGetter3 = iConvertParams3.getResourceGetter();
        Intrinsics.checkNotNull(resourceGetter3);
        String[] hWSelectableTextSize = resourceGetter3.getHWSelectableTextSize();
        if (hWSelectableTextSize == null || hWSelectableTextSize.length == 0) {
            LoggerBase.INSTANCE.m7132d(TAG, "selectable string is empty");
            return resizeFontSizeForCanvas(originSize);
        }
        int length = hWSelectableTextSize.length;
        float[] fArr = new float[length];
        int length2 = hWSelectableTextSize.length;
        for (int i = 0; i < length2; i++) {
            String str = hWSelectableTextSize[i];
            Intrinsics.checkNotNull(str);
            fArr[i] = Float.parseFloat(str);
        }
        float f = fArr[0];
        for (int i2 = 1; i2 < length; i2++) {
            if (Math.abs(f - defaultTextSizeDeltaByDevice) > Math.abs(fArr[i2] - defaultTextSizeDeltaByDevice)) {
                f = fArr[i2];
            }
        }
        return f;
    }

    private final float resizeFontSizeForCanvas(float originSize) {
        if (originSize == 17.0f) {
            return 16.0f;
        }
        if (originSize == 23.0f) {
            return 20.0f;
        }
        if (originSize == 27.0f) {
            return 24.0f;
        }
        LoggerBase.INSTANCE.m7133e(TAG, "resizeFontSizeForCanvas# unexpected size : " + originSize);
        return originSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SpenAlignmentParagraph updateAlignmentByText(SpenContentBase contentBase, int startPosition) {
        int iIsRTLMode;
        String text;
        if (contentBase.getType() == 1) {
            boolean zIsChanged = contentBase.isChanged();
            boolean zIsRTLMode = (TextUtils.isEmpty(contentBase.getText()) || (text = contentBase.getText()) == null) ? LocaleUtils.isRTLMode() : SpenEngineUtil.isRTL(text, LocaleUtils.isRTLMode());
            contentBase.setAlignment(zIsRTLMode ? 1 : 0);
            iIsRTLMode = zIsRTLMode;
            if (!zIsChanged) {
                contentBase.clearChangedFlag();
                iIsRTLMode = zIsRTLMode;
            }
        } else {
            iIsRTLMode = LocaleUtils.isRTLMode();
        }
        return new SpenAlignmentParagraph(startPosition, startPosition + 1, iIsRTLMode);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public void release() {
        this.mNoteComposer = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public boolean convertContent(@Nullable SpenContentText src, @NotNull IConvertParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "convert content");
        this.mConvertParams = params;
        this.mNoteComposer = params.getComposer();
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBox = SpenObjectConstructor.makeObjectTextBox();
        spenObjectTextBoxMakeObjectTextBox.setTextLimit(30000);
        String text = src != null ? src.getText() : null;
        int i = 0;
        if (text == null || text.length() == 0) {
            spenObjectTextBoxMakeObjectTextBox.setText("\n");
            spenObjectTextBoxMakeObjectTextBox.setTextColor(-16777216);
            spenObjectTextBoxMakeObjectTextBox.setFontSize(resizeFontSizeBySystem(16.0f));
            if ((src != null ? src.getSpan() : null) != null) {
                ArrayList<SpenTextSpan> span = src.getSpan();
                Intrinsics.checkNotNull(span);
                if (span.size() > 0) {
                    ArrayList<SpenTextSpan> span2 = src.getSpan();
                    Intrinsics.checkNotNull(span2);
                    if (span2.get(0).getType() == 15) {
                        ArrayList<SpenTextSpan> span3 = src.getSpan();
                        Intrinsics.checkNotNull(span3);
                        spenObjectTextBoxMakeObjectTextBox.setFontSize(span3.get(0).getFontSize());
                    }
                }
            }
            i = 1;
        } else {
            copyBasic(src, spenObjectTextBoxMakeObjectTextBox);
            copyParsingState(src, spenObjectTextBoxMakeObjectTextBox);
        }
        if (src != null) {
            copyAlignment(src, spenObjectTextBoxMakeObjectTextBox, i);
            copySpans(src, spenObjectTextBoxMakeObjectTextBox);
            copyTaskStyle(src, spenObjectTextBoxMakeObjectTextBox, i);
        }
        INoteComposer iNoteComposer = this.mNoteComposer;
        if (iNoteComposer != null) {
            iNoteComposer.appendBodyText(spenObjectTextBoxMakeObjectTextBox);
        }
        companion.m7132d(TAG, "end convert.");
        return true;
    }
}
