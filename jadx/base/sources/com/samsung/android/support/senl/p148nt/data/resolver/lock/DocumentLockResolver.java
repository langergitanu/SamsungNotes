package com.samsung.android.support.senl.p148nt.data.resolver.lock;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.SdocDocumentLocker;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.SdocXDocumentLocker;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.UnknownDocumentLocker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentLockResolver {
    private static final String TAG = DataLogger.createTag("DocumentLockResolver");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DocumentLockerFactory {
        public static DocumentLocker create(Context context, String str, boolean z) {
            NotesDocumentEntity entity = getEntity(context, str);
            if (entity != null) {
                String filePath = entity.getFilePath();
                if (filePath.endsWith(".sdoc")) {
                    return new SdocDocumentLocker(context, entity, z);
                }
                if (filePath.endsWith(".sdocx")) {
                    return new SdocXDocumentLocker(context, entity, z);
                }
            }
            return new UnknownDocumentLocker();
        }

        @Nullable
        private static NotesDocumentEntity getEntity(Context context, String str) {
            if (!TextUtils.isEmpty(str)) {
                return AbstractC0000a.m9f(context, str);
            }
            DataLogger.m12303e(DocumentLockResolver.TAG, "getEntity, docUuid is null.");
            return null;
        }
    }

    public static List<NotesDocumentEntity> changeAccountGUIDs(@NonNull Context context, List<NotesDocumentEntity> list, String str) {
        boolean zInitialize = SpenSdkInitializer.initialize(context.getApplicationContext());
        ArrayList arrayList = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : list) {
            if (notesDocumentEntity.isSdocx()) {
                if (zInitialize) {
                    try {
                        SpenWNoteFile.setOwnerId(notesDocumentEntity.getFilePath(), str);
                    } catch (Exception e) {
                        DataLogger.m12303e(TAG, "changeAccountGUIDs, e: " + e.getMessage());
                        arrayList.add(notesDocumentEntity);
                    }
                }
            }
            notesDocumentEntity.setLockAccountGuid(str);
        }
        list.removeAll(arrayList);
        NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().update(list, false);
        return arrayList;
    }

    public static void changeAccountGuidByUuid(@NonNull Context context, String str, String str2, String str3) {
        if (str3.endsWith(".sdocx")) {
            if (!SpenSdkInitializer.initialize(context.getApplicationContext())) {
                return;
            }
            try {
                SpenWNoteFile.setOwnerId(str3, str2);
            } catch (RuntimeException e) {
                DataLogger.m12303e(TAG, "changeAccountGuidByUuid, e: " + e.getMessage());
                return;
            }
        }
        NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().changeAccountGuidByUuid(str, str2);
    }

    public static void changeLockGuidForUndefined(Context context, String str, @LockType int... iArr) {
        if (SpenSdkInitializer.initialize(context.getApplicationContext())) {
            NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().changeLockGuidForUndefined(str, iArr);
        }
    }

    public static boolean execute(Context context, String str, boolean z) {
        return z ? lock(context, str) : unlock(context, str);
    }

    public static boolean lock(Context context, String str) {
        return lock(context, str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unlock(Context context, String str) {
        boolean z;
        DataLogger.m12302d(TAG, "unlock() : docUuid = " + str);
        if (SpenSdkInitializer.initialize(context)) {
            z = DocumentLockerFactory.create(context.getApplicationContext(), str, true).unlock();
        }
        if (z) {
            DataUpdateManager.getInstance().onDocumentUnlocked(Collections.singleton(str));
        }
        return z;
    }

    public static boolean lock(Context context, String str, boolean z) {
        DataLogger.m12302d(TAG, "lock() : docUuid = " + str);
        boolean z2 = SpenSdkInitializer.initialize(context) && DocumentLockerFactory.create(context.getApplicationContext(), str, z).lock();
        if (z2) {
            DataUpdateManager.getInstance().onDocumentLocked(Collections.singleton(str));
        }
        return z2;
    }
}
