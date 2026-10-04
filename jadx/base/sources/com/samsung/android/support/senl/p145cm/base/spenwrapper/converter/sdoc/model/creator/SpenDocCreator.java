package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.creator;

import android.content.Context;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ISpenDocCreator;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.IBodyTextCreator;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\fR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/creator/SpenDocCreator;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/IBodyTextCreator;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContextRef", "Ljava/lang/ref/WeakReference;", "createSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "path", "", "createPaintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "width", "", "height", "file", "createBodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "createCapturePage", "Lcom/samsung/android/sdk/pen/engine/SpenCapturePage;", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "unlockSdoc", "", "inFile", "lockSdoc", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenDocCreator implements ISpenDocCreator, IBodyTextCreator {

    @NotNull
    private static final String TAG = "SpenDocCreator";

    @NotNull
    private final WeakReference<Context> mContextRef;

    public SpenDocCreator(@Nullable Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.IBodyTextCreator
    @Nullable
    public SpenBodyTextContext createBodyTextContext() {
        Context context = this.mContextRef.get();
        if (context != null) {
            return ToolConstructor.makeSpenBodyTextContext(context);
        }
        LoggerBase.INSTANCE.m7138w(TAG, "createBodyTextContext : null context");
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ISpenDocCreator
    @Nullable
    public SpenCapturePage createCapturePage(@Nullable SpenPageDoc pageDoc) {
        if (this.mContextRef.get() == null || pageDoc == null) {
            return null;
        }
        SpenCapturePage spenCapturePageMakeSpenCapturePage = ToolConstructor.makeSpenCapturePage(this.mContextRef.get());
        spenCapturePageMakeSpenCapturePage.setPageDoc(pageDoc);
        return spenCapturePageMakeSpenCapturePage;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ISpenDocCreator
    @Nullable
    public SpenPaintingDoc createPaintingDoc(int width, int height, @Nullable String file) {
        Context context = this.mContextRef.get();
        if (context == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "createPaintingDoc : null context");
            return null;
        }
        try {
            return DocumentConstructor.makeSpenPaintingDoc(context, width, height, file);
        } catch (IOException e) {
            AbstractC0000a.m23t("failed create painting doc : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ISpenDocCreator
    @Nullable
    public SpenSDoc createSDoc(@Nullable String path) {
        Context context = this.mContextRef.get();
        if (context == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "createSDoc : null context");
            return null;
        }
        try {
            return DocumentConstructor.makeSpenSDoc(context, path, LockConstants.EXTRA_VALUE_LOCK_CONFIRMED, ToolConstructor.makeSDocLocker(context).getUserCode(), 5);
        } catch (SpenSDocInvalidPasswordException e) {
            AbstractC0000a.m23t("failed create sdoc doc : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        } catch (SpenSDocUnsupportedFileException e2) {
            AbstractC0000a.m23t("failed create sdoc doc : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        } catch (SpenSDocUnsupportedVersionException e3) {
            AbstractC0000a.m23t("failed create sdoc doc : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        } catch (IOException e5) {
            AbstractC0000a.m23t("failed create sdoc doc : ", e5.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        }
    }

    public final boolean lockSdoc(@Nullable String inFile) {
        Context context = this.mContextRef.get();
        if (context == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "lockSdoc : null context");
            return false;
        }
        try {
            SpenSDocFile.lock(inFile, ToolConstructor.makeSDocLocker(context).getUserCode());
            return true;
        } catch (SpenSDocUnsupportedFileException e) {
            LoggerBase.INSTANCE.m7138w(TAG, "lockSdoc, e : " + e.getMessage());
            return false;
        } catch (SpenSDocUnsupportedVersionException e2) {
            LoggerBase.INSTANCE.m7138w(TAG, "lockSdoc, e : " + e2.getMessage());
            return false;
        } catch (IOException e3) {
            LoggerBase.INSTANCE.m7138w(TAG, "lockSdoc, e : " + e3.getMessage());
            return false;
        } catch (IllegalArgumentException e5) {
            LoggerBase.INSTANCE.m7138w(TAG, "lockSdoc, e : " + e5.getMessage());
            return false;
        }
    }

    public final boolean unlockSdoc(@Nullable String inFile) {
        Context context = this.mContextRef.get();
        if (context == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "unlockSdoc : null context");
            return false;
        }
        try {
            SpenSDocFile.unlock(inFile, ToolConstructor.makeSDocLocker(context).getUserCode());
            return true;
        } catch (SpenSDocInvalidPasswordException e) {
            LoggerBase.INSTANCE.m7138w(TAG, "unlockSdoc, e : " + e.getMessage());
            return false;
        } catch (SpenSDocUnsupportedFileException e2) {
            LoggerBase.INSTANCE.m7138w(TAG, "unlockSdoc, e : " + e2.getMessage());
            return false;
        } catch (SpenSDocUnsupportedVersionException e3) {
            LoggerBase.INSTANCE.m7138w(TAG, "unlockSdoc, e : " + e3.getMessage());
            return false;
        } catch (IOException e5) {
            LoggerBase.INSTANCE.m7138w(TAG, "unlockSdoc, e : " + e5.getMessage());
            return false;
        } catch (IllegalArgumentException e6) {
            LoggerBase.INSTANCE.m7138w(TAG, "unlockSdoc, e : " + e6.getMessage());
            return false;
        }
    }
}
