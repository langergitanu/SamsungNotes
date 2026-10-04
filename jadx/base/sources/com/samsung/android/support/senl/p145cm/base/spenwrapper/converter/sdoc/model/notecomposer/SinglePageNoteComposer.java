package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ObjectTaskStyle;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\"\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J8\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u00192\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0019H\u0002J \u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010-\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010.2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0011H\u0002J\b\u00105\u001a\u00020\u0017H\u0016R\u001c\u0010\n\u001a\u00020\u000b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00118GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/SinglePageNoteComposer;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/AbsSDocXComposer;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "resourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;)V", "lastComposingHeight", "", "getLastComposingHeight", "()F", "setLastComposingHeight", "(F)V", "lastComposingType", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "getLastComposingType", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "setLastComposingType", "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;)V", "appendObject", "", CoeditServiceConstants.Element.NAME_OBJECT, "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "file", "", "appendTaskObject", "taskStyle", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;", "targetHeight", SecureFolderConstants.TEMP_FOLDER_NAME, "offsetX", "offsetY", "appendObjects", "page", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "rect", "Landroid/graphics/RectF;", "bgImage", "bgColor", "", "moveToBottom", MarketingConstants.PopupConst.COLOR_BACKGROUND, "appendBodyText", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "addNewLinesUntil", "addNewLine", "num", "", "addMargin", "nowAppend", "finish", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SinglePageNoteComposer extends AbsSDocXComposer {
    private static final int INIT_PAGE_COUNT = 500;

    @NotNull
    private static final String TAG = "SinglePageNoteComposer";
    private float lastComposingHeight;

    @NotNull
    private INoteComposer.ComposingObjectType lastComposingType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[INoteComposer.ComposingObjectType.values().length];
            try {
                iArr[INoteComposer.ComposingObjectType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[INoteComposer.ComposingObjectType.OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[INoteComposer.ComposingObjectType.STROKES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[INoteComposer.ComposingObjectType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SinglePageNoteComposer(@NotNull SpenWNote note, @Nullable SpenBodyTextContext spenBodyTextContext, @Nullable IResourceGetter iResourceGetter) {
        super(note, spenBodyTextContext, iResourceGetter);
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNull(iResourceGetter);
        this.lastComposingType = INoteComposer.ComposingObjectType.NONE;
        SpenWPage mFirstPage = getMFirstPage();
        if (mFirstPage != null) {
            mFirstPage.setSize(getWidth(), note.getPageDefaultHeight() * 500);
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        int width = getWidth();
        SpenWPage mFirstPage2 = getMFirstPage();
        companion.m7132d(TAG, "page width : " + width + ",height : " + (mFirstPage2 != null ? Integer.valueOf(mFirstPage2.getHeight()) : null));
    }

    private final void addMargin(INoteComposer.ComposingObjectType nowAppend) {
        int mVerticalMargin;
        float f;
        int i = WhenMappings.$EnumSwitchMapping$0[nowAppend.ordinal()];
        if (i == 1) {
            INoteComposer.ComposingObjectType composingObjectType = this.lastComposingType;
            if (composingObjectType != INoteComposer.ComposingObjectType.OBJECT && composingObjectType != INoteComposer.ComposingObjectType.STROKES) {
                f = 0.0f;
                LoggerBase.INSTANCE.m7132d(TAG, "addMargin# lastHeight : " + this.lastComposingHeight + " + margin height : " + f);
                this.lastComposingHeight = this.lastComposingHeight + f;
            }
            mVerticalMargin = getMVerticalMargin();
        } else {
            if (i != 2 && i != 3) {
                if (i == 4) {
                    throw new NotImplementedError(null, 1, null);
                }
                throw new NoWhenBranchMatchedException();
            }
            mVerticalMargin = getMVerticalMargin();
        }
        f = mVerticalMargin;
        LoggerBase.INSTANCE.m7132d(TAG, "addMargin# lastHeight : " + this.lastComposingHeight + " + margin height : " + f);
        this.lastComposingHeight = this.lastComposingHeight + f;
    }

    private final void addNewLine(int num) {
        if (num <= 0) {
            return;
        }
        char[] cArr = new char[num];
        Arrays.fill(cArr, '\n');
        String text = getMBodyText().getText();
        Intrinsics.checkNotNull(text);
        int length = text.length();
        getMBodyText().insertText(new String(cArr), length, false);
        getMBodyText().appendTextSpan(new SpenFontSizeSpan(length, num + length, 0, 8.0f));
    }

    private final void addNewLinesUntil(float targetHeight) {
        if (targetHeight == 0.0f) {
            return;
        }
        float mVerticalMargin = targetHeight - getMVerticalMargin();
        String text = getMBodyText().getText();
        Intrinsics.checkNotNull(text);
        int length = text.length();
        getMBodyText().appendTextSpan(new SpenFontSizeSpan(length, length, 0, 8.0f));
        int needNewLineCount = getMBodyTextMeasurer().getNeedNewLineCount(mVerticalMargin);
        addNewLine(needNewLineCount);
        LoggerBase.INSTANCE.m7132d(TAG, "addNewLinesUntil# " + needNewLineCount + "lines");
        StringBuilder sb = new StringBuilder("getNeedNewLineCount Error : ");
        while (true) {
            int needNewLineCount2 = getMBodyTextMeasurer().getNeedNewLineCount(mVerticalMargin);
            if (needNewLineCount2 <= 0) {
                LoggerBase.INSTANCE.m7138w(TAG, sb.toString());
                return;
            } else {
                sb.append(needNewLineCount2);
                sb.append(" / ");
                addNewLine(needNewLineCount2);
            }
        }
    }

    private final void move(SpenObjectBase object, float offsetX, float offsetY) {
        if (offsetX == 0.0f && offsetY == 0.0f) {
            return;
        }
        RectF rect = object != null ? object.getRect() : null;
        if (rect != null) {
            rect.offset(offsetX, offsetY);
        }
        if (object != null) {
            object.setRect(rect, false);
        }
    }

    private final void moveToBottom(SpenObjectBase bg) {
        SpenWPage mFirstPage = getMFirstPage();
        if (mFirstPage != null) {
            mFirstPage.moveObjectIndex(bg, getMFirstPage().getObjectIndex(bg) * (-1), false);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.AbsSDocXComposer, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendBodyText(@Nullable SpenObjectTextBox object) {
        String text;
        String text2;
        String text3 = getMBodyText().getText();
        Intrinsics.checkNotNull(text3);
        if (text3.length() > 0 && (object == null || (text2 = object.getText()) == null || text2.compareTo("\n") != 0)) {
            SpenObjectTextBox mBodyText = getMBodyText();
            String text4 = getMBodyText().getText();
            Intrinsics.checkNotNull(text4);
            mBodyText.insertText("\n", text4.length(), false);
        }
        INoteComposer.ComposingObjectType composingObjectType = this.lastComposingType;
        INoteComposer.ComposingObjectType composingObjectType2 = INoteComposer.ComposingObjectType.TEXT;
        if (composingObjectType == composingObjectType2 || composingObjectType == INoteComposer.ComposingObjectType.NONE) {
            SpenObjectTextBox mBodyText2 = getMBodyText();
            String text5 = getMBodyText().getText();
            Intrinsics.checkNotNull(text5);
            mBodyText2.insertText(text5.length(), object, 0, (object == null || (text = object.getText()) == null) ? 0 : text.length());
        } else {
            addMargin(composingObjectType2);
            appendBodyText(object, this.lastComposingHeight);
        }
        this.lastComposingType = composingObjectType2;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.AbsSDocXComposer, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendObject(@Nullable SpenObjectBase object) {
        RectF rect;
        if (this.lastComposingType == INoteComposer.ComposingObjectType.TEXT) {
            this.lastComposingHeight = getMBodyTextMeasurer().measureHeight();
        }
        INoteComposer.ComposingObjectType composingObjectType = INoteComposer.ComposingObjectType.OBJECT;
        addMargin(composingObjectType);
        LoggerBase.INSTANCE.m7132d(TAG, "appendObject# lastHeight : " + this.lastComposingHeight + " + object height : " + ((object == null || (rect = object.getRect()) == null) ? null : Float.valueOf(rect.height())));
        this.lastComposingHeight = appendObject(object, this.lastComposingHeight);
        this.lastComposingType = composingObjectType;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendObjects(@Nullable SpenPageDoc page, @Nullable RectF rect, @Nullable SpenObjectBase bgImage, @Nullable List<? extends SpenObjectBase> bgColor) {
        if (this.lastComposingType == INoteComposer.ComposingObjectType.TEXT) {
            this.lastComposingHeight = getMBodyTextMeasurer().measureHeight();
        }
        addMargin(INoteComposer.ComposingObjectType.STROKES);
        LoggerBase.INSTANCE.m7132d(TAG, "appendObjects# lastHeight : " + this.lastComposingHeight + " + object height : " + (rect != null ? Float.valueOf(rect.height()) : null));
        if (page != null && rect != null) {
            this.lastComposingHeight = appendObjects(page, rect, this.lastComposingHeight);
        }
        if (bgImage != null) {
            moveToBottom(bgImage);
        }
        if (bgColor != null) {
            int size = bgColor.size();
            for (int i = 0; i < size; i++) {
                SpenObjectBase spenObjectBase = bgColor.get(i);
                Intrinsics.checkNotNull(spenObjectBase);
                moveToBottom(spenObjectBase);
            }
        }
        this.lastComposingType = INoteComposer.ComposingObjectType.STROKES;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendTaskObject(@Nullable SpenObjectBase object, @Nullable ObjectTaskStyle taskStyle) {
        float fMeasureHeight;
        RectF rect;
        if (object != null) {
            object.setLayoutType(1);
        }
        if (this.lastComposingType == INoteComposer.ComposingObjectType.TEXT) {
            fMeasureHeight = getMBodyTextMeasurer().measureHeight();
            SpenObjectTextBox mBodyText = getMBodyText();
            String text = getMBodyText().getText();
            Intrinsics.checkNotNull(text);
            mBodyText.insertText("\n", text.length(), false);
        } else {
            addMargin(INoteComposer.ComposingObjectType.OBJECT);
            fMeasureHeight = this.lastComposingHeight;
            addNewLinesUntil(fMeasureHeight);
        }
        if (!CollectionsKt.contains(getMAddedTaskInfo(), taskStyle != null ? Integer.valueOf(taskStyle.getMTaskId()) : null)) {
            SpenObjectTextBox spenObjectTextBoxMakeTaskText = makeTaskText(taskStyle);
            SpenObjectTextBox mBodyText2 = getMBodyText();
            String text2 = getMBodyText().getText();
            Intrinsics.checkNotNull(text2);
            int length = text2.length();
            String text3 = spenObjectTextBoxMakeTaskText.getText();
            Intrinsics.checkNotNull(text3);
            mBodyText2.insertText(length, spenObjectTextBoxMakeTaskText, 0, text3.length());
            addTaskInfo(taskStyle != null ? taskStyle.getMTaskId() : 0, INoteComposer.ComposingObjectType.OBJECT, taskStyle);
        }
        float fHeight = 0.0f;
        move(object, getMDocDP() * (taskStyle != null ? taskStyle.getHorizontalSpace() : 0.0f), fMeasureHeight - (getMDocDP() * 5));
        SpenWPage mFirstPage = getMFirstPage();
        if (mFirstPage != null) {
            mFirstPage.appendObject(object);
        }
        if (object != null && (rect = object.getRect()) != null) {
            fHeight = rect.height();
        }
        this.lastComposingHeight = fMeasureHeight + fHeight;
        this.lastComposingType = INoteComposer.ComposingObjectType.OBJECT;
        if (taskStyle == null || taskStyle.getMType() != 4) {
            return;
        }
        taskStyle.setTaskType(101);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.AbsSDocXComposer, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void finish() {
        if (this.lastComposingType == INoteComposer.ComposingObjectType.TEXT) {
            this.lastComposingHeight = getMBodyTextMeasurer().measureHeight();
        }
        float mVerticalMargin = this.lastComposingHeight + getMVerticalMargin();
        this.lastComposingHeight = mVerticalMargin;
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "finish# lastHeight : " + mVerticalMargin);
        int iCeil = (int) Math.ceil((double) this.lastComposingHeight);
        int pageDefaultHeight = getNote().getPageDefaultHeight();
        int i = iCeil % pageDefaultHeight == 0 ? (iCeil / pageDefaultHeight) + 1 : (iCeil / pageDefaultHeight) + 2;
        companion.m7132d(TAG, "finish# pages : " + i);
        SpenWPage mFirstPage = getMFirstPage();
        if (mFirstPage != null) {
            mFirstPage.setSize(getWidth(), i * pageDefaultHeight);
        }
        SpenWPage mFirstPage2 = getMFirstPage();
        if (mFirstPage2 != null) {
            mFirstPage2.setBackgroundColor(getMPageColor());
        }
        super.finish();
    }

    @VisibleForTesting
    public final float getLastComposingHeight() {
        return this.lastComposingHeight;
    }

    @VisibleForTesting
    @NotNull
    public final INoteComposer.ComposingObjectType getLastComposingType() {
        return this.lastComposingType;
    }

    public final void setLastComposingHeight(float f) {
        this.lastComposingHeight = f;
    }

    public final void setLastComposingType(@NotNull INoteComposer.ComposingObjectType composingObjectType) {
        Intrinsics.checkNotNullParameter(composingObjectType, "<set-?>");
        this.lastComposingType = composingObjectType;
    }

    private final void appendBodyText(SpenObjectTextBox object, float targetHeight) {
        String text;
        addNewLinesUntil(targetHeight);
        SpenObjectTextBox mBodyText = getMBodyText();
        String text2 = getMBodyText().getText();
        Intrinsics.checkNotNull(text2);
        mBodyText.insertText(text2.length(), object, 0, (object == null || (text = object.getText()) == null) ? 0 : text.length());
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.AbsSDocXComposer, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendObject(@Nullable SpenObjectBase object, @Nullable String file) {
        if (object != null) {
            object.attachFile(file);
        }
        appendObject(object);
    }

    private final float appendObjects(SpenPageDoc page, RectF rect, float targetHeight) {
        PointF pointF = new PointF(getMDP() * 24 * 1.0f, targetHeight * 1.0f);
        page.clearHistory();
        SpenWPage mFirstPage = getMFirstPage();
        if (mFirstPage != null) {
            mFirstPage.transferObjects(page, 1.0f, pointF);
        }
        return rect.height() + targetHeight;
    }

    private final float appendObject(SpenObjectBase object, float targetHeight) {
        RectF rect;
        if (object != null) {
            object.setLayoutType(2);
        }
        move(object, getMHorizontalMargin(), targetHeight);
        SpenWPage mFirstPage = getMFirstPage();
        if (mFirstPage != null) {
            mFirstPage.appendObject(object);
        }
        Float fValueOf = (object == null || (rect = object.getRect()) == null) ? null : Float.valueOf(rect.height());
        if (fValueOf != null) {
            return fValueOf.floatValue() + targetHeight;
        }
        return 0.0f;
    }
}
