package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsConstants;
import com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J&\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsSdocHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "unlockSdoc", "", "context", "Landroid/content/Context;", "path", "isLockedDocument", "bundle", "Landroid/os/Bundle;", "requestUnlock", "", "action", "", "lockHelper", "Lcom/samsung/android/support/senl/nt/app/lock/helper/ILockHelper;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AddonsSdocHelper {

    @NotNull
    public static final AddonsSdocHelper INSTANCE = new AddonsSdocHelper();

    @NotNull
    private static final String TAG = "AddonsSdocHelper";

    private AddonsSdocHelper() {
    }

    @JvmStatic
    public static final boolean isLockedDocument(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (bundle == null) {
            return false;
        }
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(bundle.getString(AddonsConstants.ADDONS_DOCUMENT_UUID, ""));
        if (mainListDocumentData == null) {
            return false;
        }
        return LockUtils.isLockedSdocType(mainListDocumentData.getIsLock());
    }

    @JvmStatic
    public static final void requestUnlock(@Nullable Bundle bundle, @AddonsConstants.Action int action, @Nullable ILockHelper lockHelper) {
        String string = bundle != null ? bundle.getString(AddonsConstants.ADDONS_DOCUMENT_UUID, "") : null;
        Intent intent = new Intent();
        intent.putExtra("sdoc_uuid", string);
        intent.putExtra("doc_path", bundle != null ? bundle.getString(AddonsConstants.ADDONS_DOCUMENT_PATH, "") : null);
        intent.putExtra("highlighttext", bundle != null ? bundle.getString("highlighttext", "") : null);
        intent.putExtra(AddonsConstants.ADDONS_KEY_START_MODE, bundle != null ? Integer.valueOf(bundle.getInt(AddonsConstants.ADDONS_KEY_START_MODE, 1)) : null);
        intent.putExtra(AddonsConstants.ADDONS_RESULT_ACTION, action);
        if (lockHelper != null) {
            lockHelper.verifyLockedNoteWithMultiAccount(901, intent, string);
        }
    }

    @JvmStatic
    public static final boolean unlockSdoc(@Nullable Context context, @Nullable String path) {
        if (!SpenSdkInitializer.initialize(context)) {
            return false;
        }
        if (!SpenSDocFile.isLocked(path)) {
            return true;
        }
        try {
            SpenSDocFile.unlock(path, new SDocLocker(context).getUserCode());
            return true;
        } catch (Exception e) {
            Logger.m7101e(TAG, "unlock failed : " + e.getMessage());
            return false;
        }
    }
}
