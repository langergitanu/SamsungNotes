package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.SNBConverter;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISNBConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.SPDToSDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notedoc.ResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notedoc.SpenNoteDocManager;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001)B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010(\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/SNBToSDocXConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/AbsSDocXConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISNBConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISNBConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ISDocXConverter;", "context", "Landroid/content/Context;", "converter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/SPDToSDocXConverter;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/SPDToSDocXConverter;)V", "mConverter", "mNoteDocManager", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notedoc/SpenNoteDocManager;", "mResourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notedoc/ResourceGetter;", "mSNBConverter", "Lcom/samsung/android/support/senl/document/memoconverter/SNBConverter;", "mIsCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", MarkdownConverter.PREFIX_NAME, "", "inFile", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "postProcess", "spdPath", "makeParams", "path", "password", "cancel", "release", "isAlreadyConverted", "", "filePath", "resultType", "", "getResultType", "()I", "getStatus", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSNBToSDocXConverterWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SNBToSDocXConverterWrapper.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/SNBToSDocXConverterWrapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
public final class SNBToSDocXConverterWrapper extends AbsSDocXConverterWrapper<ISNBConverter.ConverterParams> implements ISNBConverter, ISDocXConverter {

    @NotNull
    private static final String TAG = "SNBToSDocXConverterWrapper";

    @Nullable
    private SPDToSDocXConverter mConverter;

    @NotNull
    private final AtomicBoolean mIsCanceled;

    @Nullable
    private SpenNoteDocManager mNoteDocManager;

    @NotNull
    private final ResourceGetter mResourceGetter;

    @Nullable
    private SNBConverter mSNBConverter;

    public SNBToSDocXConverterWrapper(@NotNull Context context, @NotNull SPDToSDocXConverter converter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.mResourceGetter = new ResourceGetter(context);
        this.mIsCanceled = new AtomicBoolean(false);
        this.mConverter = converter;
        this.mSNBConverter = DocumentConstructor.makeSNBConverter(context);
    }

    private final void postProcess(String spdPath) {
        if (spdPath != null) {
            try {
                FileUtil.deleteFile(new File(spdPath));
            } catch (IOException unused) {
                LoggerBase.INSTANCE.m7133e(TAG, "can't delete spd file!");
            }
        }
        SpenNoteDocManager spenNoteDocManager = this.mNoteDocManager;
        if (spenNoteDocManager != null) {
            spenNoteDocManager.closeSpenNoteDoc();
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void cancel() {
        LoggerBase.INSTANCE.m7137i(TAG, "requested cancel!");
        this.mIsCanceled.set(true);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void convert(@Nullable Context context, @Nullable String inFile, @NotNull SpenWNote wNote) {
        SPDToSDocXConverter sPDToSDocXConverter;
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        if (!verifySourcePath(inFile)) {
            LoggerBase.INSTANCE.m7133e(TAG, "verifySourcePath false");
            return;
        }
        SNBConverter sNBConverter = this.mSNBConverter;
        String strConvertToSpdFile = sNBConverter != null ? sNBConverter.convertToSpdFile(inFile, getMPassWord()) : null;
        SpenNoteDocManager spenNoteDocManager = new SpenNoteDocManager(context, strConvertToSpdFile, this.mResourceGetter);
        this.mNoteDocManager = spenNoteDocManager;
        if (!spenNoteDocManager.isValid()) {
            LoggerBase.INSTANCE.m7133e(TAG, inFile + " : is not a spd file");
            postProcess(strConvertToSpdFile);
            return;
        }
        SpenNoteDocManager spenNoteDocManager2 = this.mNoteDocManager;
        if ((spenNoteDocManager2 != null ? spenNoteDocManager2.createSpenNoteDoc(getMPassWord(), wNote.getPageDefaultWidth()) : null) == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "can't create spd file!");
            postProcess(strConvertToSpdFile);
            return;
        }
        if (this.mIsCanceled.get()) {
            LoggerBase.INSTANCE.m7133e(TAG, "already canceled");
        } else {
            SpenNoteDocManager spenNoteDocManager3 = this.mNoteDocManager;
            if (spenNoteDocManager3 != null && (sPDToSDocXConverter = this.mConverter) != null) {
                sPDToSDocXConverter.convert(context, spenNoteDocManager3, wNote, this.mResourceGetter);
            }
        }
        postProcess(strConvertToSpdFile);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getResultType() {
        return 9;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getStatus(@Nullable String path) {
        SNBConverter sNBConverter = this.mSNBConverter;
        if (sNBConverter == null || !sNBConverter.isLocked(path)) {
            return super.getStatus(path);
        }
        return 3;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISNBConverter
    public boolean isAlreadyConverted(@Nullable String filePath) {
        SNBConverter sNBConverter = this.mSNBConverter;
        return sNBConverter != null && sNBConverter.isAlreadyConverted(filePath);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public void release() {
        SPDToSDocXConverter sPDToSDocXConverter = this.mConverter;
        if (sPDToSDocXConverter != null) {
            sPDToSDocXConverter.release();
        }
        this.mConverter = null;
        SpenNoteDocManager spenNoteDocManager = this.mNoteDocManager;
        if (spenNoteDocManager != null) {
            spenNoteDocManager.release();
        }
        this.mNoteDocManager = null;
        this.mSNBConverter = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ISNBConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        ISNBConverter.ConverterParams filePath = new ISNBConverter.ConverterParams().setFilePath(path);
        if (filePath != null) {
            return filePath.setPassword(password);
        }
        return null;
    }
}
