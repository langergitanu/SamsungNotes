package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc;

import android.content.Context;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.constants.Constants;
import com.samsung.android.support.senl.p145cm.base.common.util.LockFileUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.SDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.creator.SpenDocCreator;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.ResourceGetter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u000f\u001a\u00020\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/SDocXConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ISDocXConverter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mConverter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/SDocXConverter;", "mDocCreator", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/creator/SpenDocCreator;", "mResourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/ResourceGetter;", "cancel", "", "release", MarkdownConverter.PREFIX_NAME, "inFile", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "hasOldLockedNote", "", "spenSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "postProcess", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SDocXConverterWrapper implements ISDocXConverter {

    @NotNull
    private static final String TAG = "SDocXConverterWrapper";

    @Nullable
    private SDocXConverter mConverter;

    @Nullable
    private SpenDocCreator mDocCreator;

    @NotNull
    private final ResourceGetter mResourceGetter;

    public SDocXConverterWrapper(@Nullable Context context) {
        this.mDocCreator = new SpenDocCreator(context);
        this.mConverter = new SDocXConverter(this.mDocCreator);
        this.mResourceGetter = new ResourceGetter(context);
    }

    private final boolean hasOldLockedNote(Context context, SpenSDoc spenSDoc) {
        int lockTypeFromSdoc = LockFileUtils.getLockTypeFromSdoc(context, spenSDoc);
        return lockTypeFromSdoc == 3 || lockTypeFromSdoc == 2;
    }

    private final void postProcess(SpenSDoc spenSDoc, SpenWNote wNote) {
        try {
            wNote.attachFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY, spenSDoc.getBoundFilePath(Constants.SNote.SDOC_LOCKED_FILE_KEY));
        } catch (Exception e) {
            AbstractC0000a.m23t("postProcess, fail to attach a file : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        try {
            if (spenSDoc.isClosed()) {
                return;
            }
            spenSDoc.close(true);
        } catch (Exception e2) {
            AbstractC0000a.m23t("postProcess, fail to close Sdoc : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void cancel() {
        LoggerBase.INSTANCE.m7137i(TAG, "requested cancel!");
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void convert(@Nullable Context context, @Nullable String inFile, @NotNull SpenWNote wNote) {
        boolean z;
        SpenDocCreator spenDocCreator;
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        SpenDocCreator spenDocCreator2 = this.mDocCreator;
        SpenSDoc spenSDocCreateSDoc = spenDocCreator2 != null ? spenDocCreator2.createSDoc(inFile) : null;
        if (spenSDocCreateSDoc == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "can't create s doc!");
            return;
        }
        if (hasOldLockedNote(context, spenSDocCreateSDoc)) {
            convert(spenSDocCreateSDoc, wNote);
            return;
        }
        if (SpenSDocFile.isLocked(inFile)) {
            SpenDocCreator spenDocCreator3 = this.mDocCreator;
            if (spenDocCreator3 != null) {
                spenDocCreator3.unlockSdoc(inFile);
            }
            z = true;
        } else {
            z = false;
        }
        SDocXConverter sDocXConverter = this.mConverter;
        if (sDocXConverter != null) {
            sDocXConverter.convert(spenSDocCreateSDoc, wNote, this.mResourceGetter);
        }
        if (z && (spenDocCreator = this.mDocCreator) != null) {
            spenDocCreator.lockSdoc(inFile);
        }
        postProcess(spenSDocCreateSDoc, wNote);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void release() {
        SDocXConverter sDocXConverter = this.mConverter;
        if (sDocXConverter != null) {
            sDocXConverter.release();
        }
        this.mConverter = null;
        this.mDocCreator = null;
    }

    public final void convert(@Nullable SpenSDoc spenSDoc, @NotNull SpenWNote wNote) {
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        if (spenSDoc == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "can't create s doc!");
            return;
        }
        SDocXConverter sDocXConverter = this.mConverter;
        if (sDocXConverter != null) {
            sDocXConverter.convert(spenSDoc, wNote, this.mResourceGetter);
        }
        postProcess(spenSDoc, wNote);
    }
}
