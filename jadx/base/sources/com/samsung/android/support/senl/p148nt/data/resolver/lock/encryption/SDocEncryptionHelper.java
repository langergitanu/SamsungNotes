package com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AESHelper;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesContentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SDocEncryptionHelper {
    private static final String COVER_THUMBNAIL_NAME;
    private static final String GRID_COVER_THUMBNAIL_NAME;
    public static final int SDOC_LOCKER_32BIT_KEY_INDEX = 0;
    public static final int SDOC_LOCKER_64BIT_KEY_INDEX = 1;
    private static final String TAG = DataLogger.createTag("SDocEncryptionHelper");
    private final Context mContext;
    private String mConvertedBodyTextSearchData = "";
    private final List<NotesContentEntity> mConvertedContentEntities = new ArrayList();
    private final NotesDocumentEntity mDocumentEntity;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        COVER_THUMBNAIL_NAME = AbstractC0622a.m1170p(str, Constants.MAIN_THUMBNAIL_FILE_NAME_COVER, sb);
        GRID_COVER_THUMBNAIL_NAME = AbstractC0541b.m756B(str, Constants.MAIN_THUMBNAIL_FILE_NAME_COVER_GRID);
    }

    public SDocEncryptionHelper(Context context, NotesDocumentEntity notesDocumentEntity) {
        this.mContext = context.getApplicationContext();
        this.mDocumentEntity = notesDocumentEntity;
    }

    public static void convertEncryptContentTo32bit(@NonNull Context context, @NonNull String str) {
        NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
        if (notesDocumentEntityM9f == null) {
            return;
        }
        convertEncryptContentTo32bit(context, notesDocumentEntityM9f.getUuid(), new SDocEncryptionHelper(context, notesDocumentEntityM9f));
    }

    private void encrypt(String str, boolean z, boolean z2) {
        String str2 = TAG;
        DataLogger.m12302d(str2, "encryptContents, docUuid: " + this.mDocumentEntity.getUuid() + ", isLocked : " + z + ", checkInvalidEncryptedContent : " + z2);
        int contentSecureVersion = this.mDocumentEntity.getContentSecureVersion();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(z ? 1 : 0, contentSecureVersion, "encrypt, contentSecureVersion: ", "  currentVersion: ", ", checkInvalidEncryptedContent : ");
        sbM1173s.append(z2);
        DataLogger.m12302d(str2, sbM1173s.toString());
        if (contentSecureVersion != z) {
            if (this.mDocumentEntity.isSdoc() && z2 && !z && isEncryptedBy64BitKey(this.mContext, SpenSDocFile.getEncryptedCode(this.mDocumentEntity.getFilePath(), ToolConstructor.makeSDocLocker(this.mContext).getUserCode()))) {
                convertEncryptContentTo32bit(this.mContext, this.mDocumentEntity.getUuid(), this);
            }
            encryptSDocTable(z, str);
        }
        encryptThumbnails(z, str);
        updateDB();
        DataLogger.m12302d(str2, "encrypt, done");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x005c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void encryptSDocTable(boolean r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption.SDocEncryptionHelper.encryptSDocTable(boolean, java.lang.String):void");
    }

    public static void encryptTextSearchData(Context context, String str) {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(context);
        NotesDocumentEntity notesDocumentEntity = notesDataRepositoryFactoryNewInstance.createDocumentDataRepository().get(str);
        boolean zIsLockedType = LockUtils.isLockedType(notesDocumentEntity.getIsLock());
        if (zIsLockedType) {
            String strEncryptTextSearchData = encryptTextSearchData(context, str, notesDocumentEntity.getFilePath(), zIsLockedType, ToolConstructor.makeSDocLocker(context).getUserCode()[0], !zIsLockedType);
            if (TextUtils.isEmpty(strEncryptTextSearchData)) {
                return;
            }
            notesDataRepositoryFactoryNewInstance.createDocumentContentRepository().updateStrippedContent(str, notesDocumentEntity.getFilePath(), strEncryptTextSearchData);
        }
    }

    private void encryptThumbnails(boolean z, String str) {
        boolean zEncrypt;
        NotesContentRepository notesContentRepositoryCreateDocumentContentRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentContentRepository();
        StringBuilder sb = new StringBuilder();
        for (NotesContentEntity notesContentEntity : notesContentRepositoryCreateDocumentContentRepository.getEntitiesWithNonMatchingVersion(this.mDocumentEntity.getUuid(), z ? 1 : 0)) {
            String mediaData = notesContentEntity.getMediaData();
            if (TextUtils.isEmpty(mediaData)) {
                sb.append("encryptThumbnails, path is empty.\n");
            } else if (!mediaData.endsWith(COVER_THUMBNAIL_NAME) && !mediaData.endsWith(GRID_COVER_THUMBNAIL_NAME)) {
                File file = new File(mediaData);
                if (file.exists()) {
                    sb.append("encryptThumbnails, path: ");
                    sb.append(DataLogger.getEncode(mediaData));
                    sb.append('\n');
                    if (z) {
                        try {
                            zEncrypt = AESHelper.encrypt(file, ".aes", str);
                        } catch (Exception e) {
                            AbstractC11014a.m12333r(e, new StringBuilder("encryptThumbnails, e: "), TAG);
                        }
                    } else {
                        zEncrypt = AESHelper.decrypt(file, ".aes", str);
                    }
                    sb.append("encryptThumbnails, result: ");
                    sb.append(zEncrypt);
                    sb.append('\n');
                    if (zEncrypt) {
                        notesContentEntity.setContentSecureVersion(z ? 1 : 0);
                        this.mConvertedContentEntities.add(notesContentEntity);
                    }
                } else {
                    sb.append("encryptThumbnails, file is not exist.\n");
                }
            }
        }
        DataLogger.m12307i(TAG, sb.toString());
    }

    public static boolean isEncryptedBy64BitKey(@NonNull Context context, @Nullable String str) {
        String str2 = TAG;
        DataLogger.m12302d(str2, "isEncryptedBy64BitKey : usedKey : " + str);
        SDocLocker sDocLockerMakeSDocLocker = ToolConstructor.makeSDocLocker(context);
        if (TextUtils.isEmpty(str)) {
            DataLogger.m12302d(str2, "isEncryptedBy64BitKey : usedKey is null");
            return false;
        }
        if (!sDocLockerMakeSDocLocker.is64bitCodeAvailable()) {
            DataLogger.m12302d(str2, "isEncryptedBy64BitKey, 64bit is not available : false");
            return false;
        }
        boolean zEquals = TextUtils.equals(str, sDocLockerMakeSDocLocker.getUserCode()[1]);
        DataLogger.m12302d(str2, "isEncryptedBy64BitKey : " + zEquals + ", usedKey : " + str);
        return zEquals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertEncryptContentTo32bit$1(SDocEncryptionHelper sDocEncryptionHelper, String[] strArr, String str) {
        try {
            sDocEncryptionHelper.encrypt(strArr[1], false, false);
            sDocEncryptionHelper.encrypt(strArr[0], true, false);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, AbstractC0000a.m15l("convertEncryptContentTo32bit, uuid : ", str, ", e : "), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDB$0(NotesDocumentRepository notesDocumentRepository, NotesContentRepository notesContentRepository) {
        notesDocumentRepository.update(this.mDocumentEntity);
        if (!TextUtils.isEmpty(this.mConvertedBodyTextSearchData)) {
            notesContentRepository.updateStrippedContent(this.mDocumentEntity.getUuid(), this.mDocumentEntity.getFilePath(), this.mConvertedBodyTextSearchData);
        }
        if (this.mConvertedContentEntities.isEmpty()) {
            return;
        }
        notesContentRepository.update(this.mConvertedContentEntities);
    }

    private void updateDB() {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(this.mContext);
        NotesDatabaseManager.getInstance().runInTransaction(new RunnableC8928b(this, 28, notesDataRepositoryFactoryNewInstance.createDocumentDataRepository(), notesDataRepositoryFactoryNewInstance.createDocumentContentRepository()));
    }

    public void encryptContents() {
        encrypt(ToolConstructor.makeSDocLocker(this.mContext).getUserCode()[0], LockUtils.isLockedType(this.mDocumentEntity.getIsLock()), true);
    }

    private static void convertEncryptContentTo32bit(@NonNull Context context, String str, SDocEncryptionHelper sDocEncryptionHelper) {
        NotesDatabaseManager.getInstance().runInTransaction(new RunnableC8928b(sDocEncryptionHelper, 27, ToolConstructor.makeSDocLocker(context).getUserCode(), str));
        AbstractC11014a.m12334s("convertEncryptContentTo32bit - end, uuid : ", str, TAG);
    }

    public static String encryptTextSearchData(Context context, String str, String str2, boolean z, String str3, boolean z2) {
        byte[] bArrDecrypt;
        byte[] strippedContent = NotesDataRepositoryFactory.newInstance(context).createDocumentContentRepository().getStrippedContent(str);
        if (strippedContent != null) {
            DataLogger.m12302d(TAG, "encryptTextSearchData, encrypt STRIPPED_CONTENT, length: " + strippedContent.length);
            if (z) {
                strippedContent = AESHelper.encrypt(strippedContent, str3);
            } else {
                try {
                    byte[] bArrDecode = Base64.decode(NotesDataConverter.byteToString(strippedContent), 2);
                    strippedContent = (bArrDecode == null || (bArrDecrypt = AESHelper.decrypt(bArrDecode, str3)) == null) ? AESHelper.decrypt(strippedContent, str3) : bArrDecrypt;
                } catch (IllegalArgumentException unused) {
                    strippedContent = AESHelper.decrypt(strippedContent, str3);
                }
            }
            if (z2) {
                return NotesDataConverter.byteToString(strippedContent);
            }
            try {
                return Base64Utils.encodeBase64(strippedContent);
            } catch (UnsupportedEncodingException e) {
                DataLogger.m12303e(TAG, "encryptTextSearchData, e: " + e.getMessage());
            }
        }
        return "";
    }
}
