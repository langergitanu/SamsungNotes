package com.samsung.android.support.senl.addons.executor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/DataHandler;", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "<init>", "()V", "mIsSPenSupported", "", "onCreate", "", "context", "Landroid/content/Context;", "savedInstance", "Landroid/os/Bundle;", "isSPenSupport", "isSPenOnlyMode", "setSPenOnlyMode", "enable", "checkSPenOnlyMode", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DataHandler implements IDataHandler {

    @NotNull
    private static final String TAG = Logger.createTag("DataHandler");
    private boolean mIsSPenSupported;

    private final void checkSPenOnlyMode() {
        boolean zIsSpenModel = PlatformUtil.isSpenModel();
        this.mIsSPenSupported = zIsSpenModel;
        Logger.m7100d(TAG, "checkSPenOnlyMode, mIsSPenSupported = " + zIsSpenModel + ", mIsSpenOnlyMode = " + isSPenOnlyMode());
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISPenOnlyModeHandler
    public boolean isSPenOnlyMode() {
        SharedPreferences sharedPreferences;
        if (!this.mIsSPenSupported) {
            return false;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Boolean boolValueOf = (applicationContext == null || (sharedPreferences = applicationContext.getSharedPreferences("Settings", 0)) == null) ? null : Boolean.valueOf(sharedPreferences.getBoolean("settings_spen_only_mode", this.mIsSPenSupported));
        Logger.m7100d(TAG, "isSPenOnlyMode? " + (boolValueOf == null ? "null" : boolValueOf));
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISPenOnlyModeHandler
    /* JADX INFO: renamed from: isSPenSupport, reason: from getter */
    public boolean getMIsSPenSupported() {
        return this.mIsSPenSupported;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IDataHandler
    public void onCreate(@Nullable Context context) {
        checkSPenOnlyMode();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISPenOnlyModeHandler
    public void setSPenOnlyMode(boolean enable) {
        SharedPreferences sharedPreferences;
        Context applicationContext = BaseUtils.getApplicationContext();
        SharedPreferences.Editor editorEdit = (applicationContext == null || (sharedPreferences = applicationContext.getSharedPreferences("Settings", 0)) == null) ? null : sharedPreferences.edit();
        if (editorEdit != null) {
            editorEdit.putBoolean("settings_spen_only_mode", enable);
        }
        if (editorEdit != null) {
            editorEdit.apply();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IDataHandler
    public void onCreate(@Nullable Context context, @Nullable Bundle savedInstance) {
        onCreate(context);
    }
}
