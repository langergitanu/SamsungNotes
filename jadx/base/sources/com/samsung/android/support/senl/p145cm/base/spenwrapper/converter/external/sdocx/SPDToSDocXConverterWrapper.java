package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.SPDConverter;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISPDConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.SPDToSDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.VoiceConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notedoc.ResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notedoc.SpenNoteDocManager;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p014C3.RunnableC0054a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001/B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0018\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010(\u001a\u00020)2\b\u0010'\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010.\u001a\u00020+2\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/SPDToSDocXConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/AbsSDocXConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISPDConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISPDConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ISDocXConverter;", "context", "Landroid/content/Context;", "converter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/SPDToSDocXConverter;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/SPDToSDocXConverter;)V", "mConverter", "mNoteDocManager", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notedoc/SpenNoteDocManager;", "mResourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notedoc/ResourceGetter;", "mSPDConverter", "Lcom/samsung/android/support/senl/document/memoconverter/SPDConverter;", "mVoiceConverter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/VoiceConverter;", "mConvertVoiceDataThread", "Ljava/lang/Thread;", "mIsCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", MarkdownConverter.PREFIX_NAME, "", "inFile", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "postProcess", "makeParams", "path", "password", "cancel", "release", "releaseThread", "isAlreadyConverted", "", "filePath", "getLastModifiedTime", "", "resultType", "", "getResultType", "()I", "getStatus", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSPDToSDocXConverterWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SPDToSDocXConverterWrapper.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/SPDToSDocXConverterWrapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
public final class SPDToSDocXConverterWrapper extends AbsSDocXConverterWrapper<ISPDConverter.ConverterParams> implements ISPDConverter, ISDocXConverter {

    @NotNull
    private static final String TAG = "SPDToSDocXConverterWrapper";

    @Nullable
    private Thread mConvertVoiceDataThread;

    @Nullable
    private SPDToSDocXConverter mConverter;

    @NotNull
    private final AtomicBoolean mIsCanceled;

    @Nullable
    private SpenNoteDocManager mNoteDocManager;

    @NotNull
    private final ResourceGetter mResourceGetter;

    @Nullable
    private SPDConverter mSPDConverter;

    @Nullable
    private VoiceConverter mVoiceConverter;

    public SPDToSDocXConverterWrapper(@NotNull Context context, @NotNull SPDToSDocXConverter converter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.mResourceGetter = new ResourceGetter(context);
        this.mIsCanceled = new AtomicBoolean(false);
        this.mConverter = converter;
        this.mSPDConverter = DocumentConstructor.makeSPDConverter(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.util.ArrayMap] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.util.ArrayMap] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static final void convert$lambda$1(SPDToSDocXConverterWrapper sPDToSDocXConverterWrapper, SpenWNote spenWNote) {
        synchronized (sPDToSDocXConverterWrapper) {
            try {
                SpenNoteDocManager spenNoteDocManager = sPDToSDocXConverterWrapper.mNoteDocManager;
                if (spenNoteDocManager == null) {
                    return;
                }
                Object voiceCreateTimeMap = spenNoteDocManager.getVoiceCreateTimeMap();
                SpenNoteDocManager spenNoteDocManager2 = sPDToSDocXConverterWrapper.mNoteDocManager;
                Object voicePathMap = spenNoteDocManager2 != null ? spenNoteDocManager2.getVoicePathMap() : 0;
                SpenNoteDocManager spenNoteDocManager3 = sPDToSDocXConverterWrapper.mNoteDocManager;
                ArrayList<String> voiceMemoTable = spenNoteDocManager3 != null ? spenNoteDocManager3.getVoiceMemoTable() : null;
                if (voiceMemoTable == null || voicePathMap == 0 || voiceCreateTimeMap == 0) {
                    LoggerBase.Companion companion = LoggerBase.INSTANCE;
                    String str = voiceMemoTable != null ? voiceMemoTable : "null";
                    if (voicePathMap == 0) {
                        voicePathMap = "null";
                    }
                    if (voiceCreateTimeMap == 0) {
                        voiceCreateTimeMap = "null";
                    }
                    companion.m7137i(TAG, "voice map null: " + str + " " + voicePathMap + " " + voiceCreateTimeMap);
                } else {
                    sPDToSDocXConverterWrapper.mVoiceConverter = new VoiceConverter();
                    Iterator<String> it = voiceMemoTable.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        String next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        String str2 = next;
                        Long l = (Long) voiceCreateTimeMap.get(str2);
                        if (l == null) {
                            l = -1L;
                        }
                        VoiceConverter voiceConverter = sPDToSDocXConverterWrapper.mVoiceConverter;
                        if (voiceConverter != null) {
                            voiceConverter.runConverterVoiceData(spenWNote, String.valueOf(voicePathMap.get(str2)), l.longValue());
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void postProcess() {
        SpenNoteDocManager spenNoteDocManager = this.mNoteDocManager;
        if (spenNoteDocManager != null) {
            spenNoteDocManager.closeSpenNoteDoc();
        }
    }

    private final void releaseThread() {
        Thread thread = this.mConvertVoiceDataThread;
        if (thread != null) {
            Intrinsics.checkNotNull(thread);
            boolean z = !thread.isInterrupted();
            Thread thread2 = this.mConvertVoiceDataThread;
            Intrinsics.checkNotNull(thread2);
            if (z && thread2.isAlive()) {
                Thread thread3 = this.mConvertVoiceDataThread;
                Intrinsics.checkNotNull(thread3);
                thread3.interrupt();
                this.mConvertVoiceDataThread = null;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void cancel() {
        LoggerBase.INSTANCE.m7137i(TAG, "requested cancel!");
        this.mIsCanceled.set(true);
        releaseThread();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void convert(@Nullable Context context, @Nullable String inFile, @NotNull SpenWNote wNote) {
        SPDToSDocXConverter sPDToSDocXConverter;
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        if (!verifySourcePath(inFile)) {
            LoggerBase.INSTANCE.m7133e(TAG, "spd file path  is null or not true");
            return;
        }
        SpenNoteDocManager spenNoteDocManager = new SpenNoteDocManager(context, inFile, this.mResourceGetter);
        this.mNoteDocManager = spenNoteDocManager;
        if (!spenNoteDocManager.isValid()) {
            LoggerBase.INSTANCE.m7133e(TAG, inFile + " : is not a spd file");
            return;
        }
        SpenNoteDocManager spenNoteDocManager2 = this.mNoteDocManager;
        if ((spenNoteDocManager2 != null ? spenNoteDocManager2.createSpenNoteDoc(getMPassWord(), wNote.getPageDefaultWidth()) : null) == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "can't create spd file!");
            return;
        }
        if (this.mIsCanceled.get()) {
            LoggerBase.INSTANCE.m7133e(TAG, "already canceled!");
            postProcess();
            return;
        }
        SpenNoteDocManager spenNoteDocManager3 = this.mNoteDocManager;
        if (spenNoteDocManager3 != null) {
            spenNoteDocManager3.extractVoice();
        }
        Thread threadNewThread = new SenlThreadFactory(TAG).newThread(new RunnableC0054a(this, wNote, 1));
        this.mConvertVoiceDataThread = threadNewThread;
        if (threadNewThread != null) {
            threadNewThread.start();
        }
        SpenNoteDocManager spenNoteDocManager4 = this.mNoteDocManager;
        if (spenNoteDocManager4 != null && (sPDToSDocXConverter = this.mConverter) != null) {
            sPDToSDocXConverter.convert(context, spenNoteDocManager4, wNote, this.mResourceGetter);
        }
        try {
            Thread thread = this.mConvertVoiceDataThread;
            if (thread != null) {
                thread.join();
            }
        } catch (InterruptedException e) {
            LoggerBase.INSTANCE.m7133e(TAG, "convertVoiceDataTask, e: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        postProcess();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISPDConverter
    public long getLastModifiedTime(@Nullable String filePath) {
        SPDConverter sPDConverter = this.mSPDConverter;
        if (sPDConverter != null) {
            return sPDConverter.getLastModifiedTime(filePath);
        }
        return 0L;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getResultType() {
        return 9;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getStatus(@Nullable String path) {
        SPDConverter sPDConverter = this.mSPDConverter;
        if (sPDConverter == null || !sPDConverter.isLocked(path)) {
            return super.getStatus(path);
        }
        return 3;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISPDConverter
    public boolean isAlreadyConverted(@Nullable String filePath) {
        SPDConverter sPDConverter = this.mSPDConverter;
        return sPDConverter != null && sPDConverter.isAlreadyConverted(filePath);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public synchronized void release() {
        try {
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
            this.mVoiceConverter = null;
            this.mSPDConverter = null;
            releaseThread();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ISPDConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        ISPDConverter.ConverterParams filePath = new ISPDConverter.ConverterParams().setFilePath(path);
        if (filePath != null) {
            return filePath.setPassword(password);
        }
        return null;
    }
}
