package com.samsung.android.support.senl.p148nt.base.common.access.composer;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR6\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR6\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/composer/ComposerAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "COMPOSER_ACTIVITY_CLASS", "Ljava/lang/Class;", "NATIVE_COMPOSER_ACTION_NEW_ACTIVITY_CLASS", "composerPdfReaderClass", "getComposerPdfReaderClass$annotations", "getComposerPdfReaderClass", "()Ljava/lang/Class;", "setComposerPdfReaderClass", "(Ljava/lang/Class;)V", "CREATE_NOTE_CLASS", "POPUP_NOTE_SERVICE_CLASS", "getComposerActivityClass", "setComposerActivityClass", "", "executor", "nativeComposerActionNewActivityClass", "getNativeComposerActionNewActivityClass$annotations", "getNativeComposerActionNewActivityClass", "setNativeComposerActionNewActivityClass", "setPdfReaderActivityClass", "createNoteActivityClass", "getCreateNoteActivityClass$annotations", "getCreateNoteActivityClass", "setCreateNoteActivityClass", "popupNoteServiceClass", "getPopupNoteServiceClass$annotations", "getPopupNoteServiceClass", "setPopupNoteServiceClass", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerAccessHandler {

    @Nullable
    private static Class<?> COMPOSER_ACTIVITY_CLASS = null;

    @Nullable
    private static Class<?> CREATE_NOTE_CLASS = null;

    @NotNull
    public static final ComposerAccessHandler INSTANCE = new ComposerAccessHandler();

    @Nullable
    private static Class<?> NATIVE_COMPOSER_ACTION_NEW_ACTIVITY_CLASS = null;

    @Nullable
    private static Class<?> POPUP_NOTE_SERVICE_CLASS = null;

    @NotNull
    private static final String TAG = "ComposerAccessHandler";

    @Nullable
    private static Class<?> composerPdfReaderClass;

    private ComposerAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getComposerActivityClass() {
        return COMPOSER_ACTIVITY_CLASS;
    }

    @Nullable
    public static final Class<?> getComposerPdfReaderClass() {
        return composerPdfReaderClass;
    }

    @JvmStatic
    public static /* synthetic */ void getComposerPdfReaderClass$annotations() {
    }

    @Nullable
    public static final Class<?> getCreateNoteActivityClass() {
        return CREATE_NOTE_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getCreateNoteActivityClass$annotations() {
    }

    @Nullable
    public static final Class<?> getNativeComposerActionNewActivityClass() {
        return NATIVE_COMPOSER_ACTION_NEW_ACTIVITY_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getNativeComposerActionNewActivityClass$annotations() {
    }

    @Nullable
    public static final Class<?> getPopupNoteServiceClass() {
        return POPUP_NOTE_SERVICE_CLASS;
    }

    @JvmStatic
    public static /* synthetic */ void getPopupNoteServiceClass$annotations() {
    }

    @JvmStatic
    public static final void setComposerActivityClass(@Nullable Class<?> executor) {
        if (COMPOSER_ACTIVITY_CLASS != null) {
            Logger.m8698e(TAG, "setComposerActivityClass, twice access! only first trial is accepted");
        } else {
            COMPOSER_ACTIVITY_CLASS = executor;
            Logger.m8697d(TAG, "setComposerActivityClass. ");
        }
    }

    public static final void setComposerPdfReaderClass(@Nullable Class<?> cls) {
        composerPdfReaderClass = cls;
    }

    public static final void setCreateNoteActivityClass(@Nullable Class<?> cls) {
        if (CREATE_NOTE_CLASS != null) {
            Logger.m8698e(TAG, "setCreateNoteActivityClass, twice access! only first trial is accepted");
        } else {
            CREATE_NOTE_CLASS = cls;
            Logger.m8697d(TAG, "setCreateNoteActivityClass. ");
        }
    }

    public static final void setNativeComposerActionNewActivityClass(@Nullable Class<?> cls) {
        if (NATIVE_COMPOSER_ACTION_NEW_ACTIVITY_CLASS != null) {
            Logger.m8698e(TAG, "setNativeComposerActionNewActivityClass, twice access! only first trial is accepted");
        } else {
            NATIVE_COMPOSER_ACTION_NEW_ACTIVITY_CLASS = cls;
            Logger.m8697d(TAG, "setNativeComposerActionNewActivityClass. ");
        }
    }

    @JvmStatic
    public static final void setPdfReaderActivityClass(@Nullable Class<?> executor) {
        if (composerPdfReaderClass != null) {
            Logger.m8698e(TAG, "setPdfReaderActivityClass, twice access! only first trial is accepted");
        } else {
            composerPdfReaderClass = executor;
            Logger.m8697d(TAG, "setPdfReaderActivityClass. ");
        }
    }

    public static final void setPopupNoteServiceClass(@Nullable Class<?> cls) {
        if (POPUP_NOTE_SERVICE_CLASS != null) {
            Logger.m8698e(TAG, "setPopupNoteServiceClass, twice access! only first trial is accepted");
        } else {
            POPUP_NOTE_SERVICE_CLASS = cls;
            Logger.m8697d(TAG, "setPopupNoteServiceClass. ");
        }
    }
}
