package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notecomposer;

import android.graphics.PointF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 52\u00020\u0001:\u00015B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001b\u001a\u00020\u00152\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001eH\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\"\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0012\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u00103\u001a\u00020\u0015H\u0016J\b\u00104\u001a\u00020\u0015H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010'\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0014\u0010-\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notecomposer/MultiPageNoteComposer;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/INoteComposer;", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "pageWidth", "", "pageHeight", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Ljava/lang/Integer;Ljava/lang/Integer;)V", "mWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "mWNote", "getWNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "width", "getWidth", "()I", "height", "getHeight", "getPageWidth", "transferObject", "", "spenPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "appendObject", CoeditServiceConstants.Element.NAME_OBJECT, "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "appendObjects", "objects", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "appendPage", "setBackgroundForPage", "colorBg", "imageBgPath", "", "imageMode", "getPage", "index", "backgroundColorPage", "getBackgroundColorPage", "setTitle", "title", "removeObject", "spenObjectBase", "cachePath", "getCachePath", "()Ljava/lang/String;", "objectList", "getObjectList", "()Ljava/util/ArrayList;", "setBodyTextFontSizeDelta", "release", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MultiPageNoteComposer implements INoteComposer {

    @NotNull
    private static final String TAG = "MultiPageNoteComposer";

    @Nullable
    private SpenWNote mWNote;

    @Nullable
    private SpenWPage mWPage;

    public MultiPageNoteComposer(@Nullable SpenWNote spenWNote, @Nullable Integer num, @Nullable Integer num2) {
        this.mWNote = spenWNote;
        if (spenWNote != null) {
            spenWNote.setPageDefaultWidth(num != null ? num.intValue() : 0);
        }
        if (spenWNote != null) {
            spenWNote.setPageDefaultHeight(num2 != null ? num2.intValue() : 0);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void appendObject(@Nullable SpenObjectBase object) {
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            spenWPage.appendObject(object);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void appendObjects(@Nullable ArrayList<SpenObjectBase> objects) {
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            spenWPage.appendObjectList(objects);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    @Nullable
    public SpenWPage appendPage(int width, int height) {
        SpenWPage spenWPageAppendPage = getWNote().appendPage(width, height);
        this.mWPage = spenWPageAppendPage;
        return spenWPageAppendPage;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public int getBackgroundColorPage() {
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            return spenWPage.getBackgroundColor();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    @NotNull
    public String getCachePath() {
        return AbstractC0541b.m756B(getWNote().getInternalTempDirectory(), File.separator);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public int getHeight() {
        return getWNote().getPageDefaultHeight();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    @Nullable
    public ArrayList<SpenObjectBase> getObjectList() {
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            return spenWPage.getObjectList();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    @Nullable
    public SpenWPage getPage(int index) {
        return getWNote().getPage(index);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public int getPageWidth() {
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            return spenWPage.getWidth();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    @NotNull
    public SpenWNote getWNote() {
        SpenWNote spenWNote = this.mWNote;
        Intrinsics.checkNotNull(spenWNote);
        return spenWNote;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public int getWidth() {
        return getWNote().getPageDefaultWidth();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void release() {
        this.mWNote = null;
        this.mWPage = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void removeObject(@Nullable SpenObjectBase spenObjectBase) {
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            spenWPage.removeObject(spenObjectBase);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void setBackgroundForPage(int colorBg, @Nullable String imageBgPath, int imageMode) {
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("set background - colour : ", colorBg, " - image path : ", companion.getEncode(imageBgPath), " - imageMode : ");
        sbM1629s.append(imageMode);
        companion.m7132d(TAG, sbM1629s.toString());
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            spenWPage.setBackgroundColor(colorBg);
        }
        if (imageBgPath != null) {
            SpenWPage spenWPage2 = this.mWPage;
            if (spenWPage2 != null) {
                spenWPage2.setBackgroundImage(imageBgPath);
            }
            SpenWPage spenWPage3 = this.mWPage;
            if (spenWPage3 != null) {
                spenWPage3.setBackgroundImageMode(imageMode);
            }
            SpenWPage spenWPage4 = this.mWPage;
            if (spenWPage4 != null) {
                spenWPage4.setTemplateType(12);
            }
            SpenWPage spenWPage5 = this.mWPage;
            if (spenWPage5 != null) {
                spenWPage5.setTemplateURI(imageBgPath);
            }
            getWNote().invertBackgroundColor(false);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void setBodyTextFontSizeDelta() {
        getWNote().setBodyTextFontSizeDelta(0);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void setTitle(@Nullable String title) {
        getWNote().getTitle().setText(title);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer
    public void transferObject(@Nullable SpenPageDoc spenPageDoc) {
        LoggerBase.INSTANCE.m7132d(TAG, "transfer Object");
        PointF pointF = new PointF(0.0f, 0.0f);
        SpenWPage spenWPage = this.mWPage;
        if (spenWPage != null) {
            spenWPage.transferObjects(spenPageDoc, 1.0f, pointF);
        }
    }
}
