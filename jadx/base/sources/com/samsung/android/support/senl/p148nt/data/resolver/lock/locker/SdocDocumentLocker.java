package com.samsung.android.support.senl.p148nt.data.resolver.lock.locker;

import android.content.Context;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption.SDocEncryptionHelper;
import com.samsung.android.support.senl.p148nt.data.resolver.tag.OldHashtagResolver;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SdocDocumentLocker extends AbsDocumentLocker {
    private static final String TAG = DataLogger.createTag("SdocDocumentLocker");

    public SdocDocumentLocker(Context context, NotesDocumentEntity notesDocumentEntity, boolean z) {
        super(context, notesDocumentEntity, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker, com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    @LockType
    public int getLockType() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker, com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public /* bridge */ /* synthetic */ boolean lock() {
        return super.lock();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker
    public boolean lockFile() {
        boolean zIsLocked = SpenSDocFile.isLocked(this.mDocPath);
        AbstractC11014a.m12335t("lockFile, isLocked : ", TAG, zIsLocked);
        if (zIsLocked) {
            return true;
        }
        try {
            SpenSDocFile.lock(this.mDocPath, ToolConstructor.makeSDocLocker(this.mAppContext).getUserCode());
            return true;
        } catch (SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e) {
            AbstractC11014a.m12333r(e, new StringBuilder("lockFile, e : "), TAG);
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker
    public void notifyToTagBoard() {
        OldHashtagResolver.notifyTagBoardByUuid(this.mAppContext, this.mDocUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker, com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public /* bridge */ /* synthetic */ boolean unlock() {
        return super.unlock();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker
    public boolean unlockFile() {
        boolean zIsLocked = SpenSDocFile.isLocked(this.mDocPath);
        AbstractC11014a.m12335t("unlockFile, isLocked : ", TAG, zIsLocked);
        if (!zIsLocked) {
            return true;
        }
        try {
            if (SDocEncryptionHelper.isEncryptedBy64BitKey(this.mAppContext, SpenSDocFile.unlock(this.mDocPath, ToolConstructor.makeSDocLocker(this.mAppContext).getUserCode()))) {
                SDocEncryptionHelper.convertEncryptContentTo32bit(this.mAppContext, this.mDocUuid);
            }
            return true;
        } catch (SpenSDocInvalidPasswordException | SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e) {
            AbstractC11014a.m12333r(e, new StringBuilder("unlockFile, e : "), TAG);
            return false;
        }
    }
}
