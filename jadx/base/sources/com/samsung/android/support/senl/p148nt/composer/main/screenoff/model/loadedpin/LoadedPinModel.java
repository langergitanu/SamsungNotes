package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.loadedpin;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadedpin/LoadedPinModel;", "", "<init>", "()V", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mUuid", "", "mNotePath", "init", "", "composerModel", "uuid", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "notePath", "getNotePath", "setNotePath", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LoadedPinModel {

    @NotNull
    private static final String TAG = SOLogger.createTag("LoadedPinModel");

    @Nullable
    private ComposerModel mComposerModel;

    @Nullable
    private String mNotePath;

    @Nullable
    private String mUuid;

    @Nullable
    public final String getNotePath() {
        DocInfo docInfo;
        String str = this.mNotePath;
        if (str != null && (str == null || str.length() != 0)) {
            return this.mNotePath;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "getNotePath return docInfo's");
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null || (docInfo = composerModel.getDocInfo()) == null) {
            return null;
        }
        return docInfo.getDocPath();
    }

    @Nullable
    public final String getUuid() {
        DocInfo docInfo;
        String str = this.mUuid;
        if (str != null && (str == null || str.length() != 0)) {
            return this.mUuid;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "getUuid return docInfo's");
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null || (docInfo = composerModel.getDocInfo()) == null) {
            return null;
        }
        return docInfo.getUuid();
    }

    public final void init(@Nullable ComposerModel composerModel) {
        this.mComposerModel = composerModel;
    }

    public final void setNotePath(@Nullable String str) {
        this.mNotePath = str;
        AbstractC8014b.m7208j("setNotePath ", Logger.getEncode(str), SOLogger.INSTANCE, TAG);
    }

    public final void setUuid(@Nullable String str) {
        this.mUuid = str;
        AbstractC8014b.m7208j("setUuid ", str, SOLogger.INSTANCE, TAG);
    }
}
