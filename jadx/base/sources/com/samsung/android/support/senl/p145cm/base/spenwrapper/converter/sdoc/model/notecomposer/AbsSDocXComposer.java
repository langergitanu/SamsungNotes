package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer;

import android.graphics.RectF;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ObjectTaskStyle;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 a2\u00020\u0001:\u0001aB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH&J\u001c\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010T\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020 H\u0016J\b\u0010W\u001a\u00020NH\u0016J\u0010\u0010X\u001a\u00020\u00172\b\u0010Y\u001a\u0004\u0018\u00010+J\u0016\u0010Z\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010[\u001a\u00020\rJ\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020 H\u0016J$\u0010_\u001a\u00020N2\u0006\u0010^\u001a\u00020 2\b\u0010`\u001a\u0004\u0018\u00010%2\b\u0010S\u001a\u0004\u0018\u00010+H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u0017X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0012\u001a\u0004\u0018\u00010%@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0012\u001a\u0004\u0018\u00010+@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u000102X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b9\u00107R\u0014\u0010:\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000fR\u001a\u0010<\u001a\u00020 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00107\"\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bA\u00107R\u0011\u0010B\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bC\u00107R\u0014\u0010D\u001a\u00020 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0014\u0010F\u001a\u00020 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00107R\u0014\u0010H\u001a\u00020 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00107R\u000e\u0010J\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u000f¨\u0006b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/AbsSDocXComposer;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "resourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;)V", "getNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mDP", "", "getMDP", "()F", "setMDP", "(F)V", "value", "oldObjectMaxWidth", "getOldObjectMaxWidth", "setOldObjectMaxWidth", "mBodyText", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "getMBodyText", "()Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "mBodyTextMeasurer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/BodyTextMeasurer;", "getMBodyTextMeasurer", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/BodyTextMeasurer;", "mAddedTaskInfo", "", "", "getMAddedTaskInfo", "()Ljava/util/List;", "setMAddedTaskInfo", "(Ljava/util/List;)V", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "lastTaskObjectType", "getLastTaskObjectType", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "setLastTaskObjectType", "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;)V", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;", "lastTaskStyle", "getLastTaskStyle", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;", "setLastTaskStyle", "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;)V", "mFirstPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getMFirstPage", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "width", "getWidth", "()I", "height", "getHeight", "mPageMinHeight", "getMPageMinHeight", "mPageColor", "getMPageColor", "setMPageColor", "(I)V", "objectMaxWidth", "getObjectMaxWidth", "objectMaxHeight", "getObjectMaxHeight", "mHorizontalMargin", "getMHorizontalMargin", "mVerticalMargin", "getMVerticalMargin", "mVerticalMargin2", "getMVerticalMargin2", "mDocDP", "dPI", "getDPI", "appendObject", "", CoeditServiceConstants.Element.NAME_OBJECT, "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "file", "", "taskStyle", "appendBodyText", "setPageColor", "color", "finish", "makeTaskText", "style", "applyScale", WiggleAnimationConfig.KEY_SCALE, "isAddedTask", "", "taskId", "addTaskInfo", "type", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSDocXComposer implements INoteComposer {
    public static final int FONT_SIZE_DEFAULT = 17;
    public static final int FONT_SIZE_MIN = 8;
    private static final int H_MARGIN_DDP = 16;
    private static final float MIN_PAGE_PERCENTAGE = 0.75f;
    public static final int OLD_COMPOSER_H_MARGIN_DP = 24;

    @NotNull
    private static final String TAG = "AbsSDocXComposer";
    private static final int V_MARGIN_DDP = 10;
    private final int height;

    @Nullable
    private INoteComposer.ComposingObjectType lastTaskObjectType;

    @Nullable
    private ObjectTaskStyle lastTaskStyle;

    @NotNull
    private List<Integer> mAddedTaskInfo;

    @NotNull
    private final SpenObjectTextBox mBodyText;

    @NotNull
    private final BodyTextMeasurer mBodyTextMeasurer;
    private float mDP;
    private final float mDocDP;

    @Nullable
    private final SpenWPage mFirstPage;
    private final int mHorizontalMargin;
    private int mPageColor;
    private final float mPageMinHeight;
    private final int mVerticalMargin;
    private final int mVerticalMargin2;

    @NotNull
    private final SpenWNote note;
    private final int objectMaxHeight;
    private final int objectMaxWidth;
    private float oldObjectMaxWidth;
    private final int width;

    public AbsSDocXComposer(@NotNull SpenWNote note, @Nullable SpenBodyTextContext spenBodyTextContext, @NotNull IResourceGetter resourceGetter) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(resourceGetter, "resourceGetter");
        this.note = note;
        SpenObjectTextBox bodyText = note.getBodyText();
        this.mBodyText = bodyText;
        this.mBodyTextMeasurer = new BodyTextMeasurer(spenBodyTextContext, note);
        this.mAddedTaskInfo = new ArrayList();
        this.lastTaskObjectType = INoteComposer.ComposingObjectType.NONE;
        this.mFirstPage = note.appendPage();
        int pageDefaultWidth = note.getPageDefaultWidth();
        this.width = pageDefaultWidth;
        int pageDefaultHeight = note.getPageDefaultHeight();
        this.height = pageDefaultHeight;
        this.mPageMinHeight = pageDefaultHeight * 0.75f;
        float f = pageDefaultWidth / 360.0f;
        this.mDocDP = f;
        int i = (int) (16 * f);
        this.mHorizontalMargin = i;
        int i2 = (int) (10 * f);
        this.mVerticalMargin = i2;
        int i4 = i2 * 2;
        this.mVerticalMargin2 = i4;
        this.objectMaxWidth = pageDefaultWidth - (i * 2);
        this.objectMaxHeight = pageDefaultHeight - i4;
        bodyText.setMargin(16.0f, 10.0f, 16.0f, 10.0f);
        bodyText.setFontSize(17.0f);
        if (resourceGetter.getDisplayMetrics() != null) {
            float f4 = r5.densityDpi / 160;
            this.mDP = f4;
            setOldObjectMaxWidth(pageDefaultWidth - (48 * f4));
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void addTaskInfo(int taskId, @Nullable INoteComposer.ComposingObjectType type, @Nullable ObjectTaskStyle taskStyle) {
        this.mAddedTaskInfo.add(Integer.valueOf(taskId));
        setLastTaskObjectType(type);
        setLastTaskStyle(taskStyle);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public abstract void appendBodyText(@Nullable SpenObjectTextBox object);

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public abstract void appendObject(@Nullable SpenObjectBase object);

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendObject(@Nullable SpenObjectBase object, @Nullable String file) {
        if (object != null) {
            object.attachFile(file);
        }
        appendObject(object);
    }

    public final void applyScale(@NotNull SpenObjectBase object, float scale) {
        Intrinsics.checkNotNullParameter(object, "object");
        if (scale < 0.0f || scale > 1.0f) {
            return;
        }
        RectF rect = object.getRect();
        rect.set(rect.left, rect.top, rect.right * scale, rect.bottom * scale);
        object.setRect(rect, false);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void finish() {
        this.mBodyTextMeasurer.release();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    /* JADX INFO: renamed from: getDPI, reason: from getter */
    public float getMDocDP() {
        return this.mDocDP;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public final int getHeight() {
        return this.height;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    @Nullable
    public INoteComposer.ComposingObjectType getLastTaskObjectType() {
        return this.lastTaskObjectType;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    @Nullable
    public ObjectTaskStyle getLastTaskStyle() {
        return this.lastTaskStyle;
    }

    @NotNull
    public final List<Integer> getMAddedTaskInfo() {
        return this.mAddedTaskInfo;
    }

    @NotNull
    public final SpenObjectTextBox getMBodyText() {
        return this.mBodyText;
    }

    @NotNull
    public final BodyTextMeasurer getMBodyTextMeasurer() {
        return this.mBodyTextMeasurer;
    }

    public final float getMDP() {
        return this.mDP;
    }

    @Nullable
    public final SpenWPage getMFirstPage() {
        return this.mFirstPage;
    }

    public final int getMHorizontalMargin() {
        return this.mHorizontalMargin;
    }

    public final int getMPageColor() {
        return this.mPageColor;
    }

    public final float getMPageMinHeight() {
        return this.mPageMinHeight;
    }

    public final int getMVerticalMargin() {
        return this.mVerticalMargin;
    }

    public final int getMVerticalMargin2() {
        return this.mVerticalMargin2;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    @NotNull
    public final SpenWNote getNote() {
        return this.note;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public final int getObjectMaxHeight() {
        return this.objectMaxHeight;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public final int getObjectMaxWidth() {
        return this.objectMaxWidth;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public float getOldObjectMaxWidth() {
        return this.oldObjectMaxWidth;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public final int getWidth() {
        return this.width;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public boolean isAddedTask(int taskId) {
        return this.mAddedTaskInfo.contains(Integer.valueOf(taskId));
    }

    @NotNull
    public final SpenObjectTextBox makeTaskText(@Nullable ObjectTaskStyle style) {
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBox = SpenObjectConstructor.makeObjectTextBox("\n");
        spenObjectTextBoxMakeObjectTextBox.setFontSize(17.0f);
        SpenBulletParagraph spenBulletParagraph = null;
        Integer numValueOf = style != null ? Integer.valueOf(style.getMType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            LoggerBase.INSTANCE.m7132d(TAG, "add task : todo");
            spenBulletParagraph = new SpenBulletParagraph(0, 1, 2);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            LoggerBase.INSTANCE.m7132d(TAG, "add task : done");
            spenBulletParagraph = new SpenBulletParagraph(0, 1, 2);
            spenBulletParagraph.Checkout(true);
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            LoggerBase.INSTANCE.m7132d(TAG, "add task : bullet");
            spenBulletParagraph = new SpenBulletParagraph(0, 1, 8);
        } else if (numValueOf != null && numValueOf.intValue() == 4) {
            LoggerBase.INSTANCE.m7132d(TAG, "add task : number : " + style.getMInfo());
            spenObjectTextBoxMakeObjectTextBox.setText(style.getMTaskNumber() + Extension.DOT);
        }
        if (spenBulletParagraph != null) {
            spenObjectTextBoxMakeObjectTextBox.appendTextParagraph(spenBulletParagraph);
        }
        return spenObjectTextBoxMakeObjectTextBox;
    }

    public void setLastTaskObjectType(@Nullable INoteComposer.ComposingObjectType composingObjectType) {
        this.lastTaskObjectType = composingObjectType;
    }

    public void setLastTaskStyle(@Nullable ObjectTaskStyle objectTaskStyle) {
        this.lastTaskStyle = objectTaskStyle;
    }

    public final void setMAddedTaskInfo(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mAddedTaskInfo = list;
    }

    public final void setMDP(float f) {
        this.mDP = f;
    }

    public final void setMPageColor(int i) {
        this.mPageColor = i;
    }

    public void setOldObjectMaxWidth(float f) {
        this.oldObjectMaxWidth = f;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void setPageColor(int color) {
        this.mPageColor = color;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer
    public void appendObject(@Nullable SpenObjectBase object, @Nullable String file, @Nullable ObjectTaskStyle taskStyle) {
        if (object != null) {
            object.attachFile(file);
        }
        appendTaskObject(object, taskStyle);
    }
}
