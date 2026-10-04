package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.IOException;
import p001A.AbstractC0000a;
import p093X.C0338f;
import p093X.InterfaceC0337e;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SaveNoteResolverContractImpl implements InterfaceC0337e {
    private static final int SYNC_SDOC_SAVE_STRATEGY = 6152;
    private static final String TAG = "SaveNoteResolverContractImpl";

    private void close(@NonNull SpenSDoc spenSDoc) {
        Logger.m8697d(TAG, "close, document : " + spenSDoc);
        try {
            if (spenSDoc.isClosed()) {
                return;
            }
            spenSDoc.close(true);
        } catch (IOException e) {
            Logger.m8698e(TAG, "close, e : " + e.getMessage());
        }
    }

    private int getSaveStrategy(boolean z) {
        if (z) {
            return 137224;
        }
        return SYNC_SDOC_SAVE_STRATEGY;
    }

    @Nullable
    private SpenSDoc open(Context context, C0338f c0338f) {
        Logger.m8697d(TAG, "open " + Logger.getEncode(c0338f.f856a.getFilePath()));
        try {
            return new SpenSDoc(context, c0338f.f856a.getFilePath(), LockConstants.EXTRA_VALUE_LOCK_CONFIRMED, new SDocLocker(context).getUserCode(), 0);
        } catch (SpenSDocInvalidPasswordException | SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | SpenAlreadyClosedException | IOException e) {
            AbstractC0000a.m21r(e, new StringBuilder("open, e : "), TAG);
            return null;
        }
    }

    private void save(Context context, C0338f c0338f, @NonNull SpenSDoc spenSDoc) {
        try {
            spenSDoc.removeEmptyContentHandwriting();
            spenSDoc.save(c0338f.f856a.getFilePath(), new SDocLocker(context).getUserCode(), true, spenSDoc.getCreatedTime(), spenSDoc.getModifiedTime());
        } catch (IOException e) {
            Logger.m8701f(TAG, "save, e : ", e);
        }
    }

    @Override // p093X.InterfaceC0337e
    public boolean saveDoc(Context context, C0338f c0338f) {
        SpenSDoc spenSDocOpen = open(context, c0338f);
        boolean z = false;
        if (spenSDocOpen == null) {
            return false;
        }
        try {
            if (c0338f.f856a.isRemoveActionLinkData() && !DeviceUtils.isSpenModel()) {
                z = true;
            }
            boolean z2 = z;
            boolean zSave = DocumentWriteResolver.save(context, c0338f.f857b, c0338f.f856a.getFilePath(), c0338f.f856a, spenSDocOpen, C13541h.m14287e().m14294h(), true, getSaveStrategy(z2), TAG);
            if (z2) {
                save(context, c0338f, spenSDocOpen);
            }
            close(spenSDocOpen);
            new DocumentPostSaveOperation(context, c0338f.f857b, c0338f.f856a, null).setStrategy(8).run();
            return zSave;
        } catch (Throwable th) {
            close(spenSDocOpen);
            throw th;
        }
    }
}
