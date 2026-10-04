package p079T;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.documentfile.provider.DocumentFile;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.SharedItemWithUriList;
import com.samsung.android.sdk.mobileservice.social.share.result.ContentDownloadResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListWithUriListResult;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.MdeNotificationHelper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.SpenSdkCompat;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p075S.AbstractC0248O;
import p075S.AbstractC0267s;
import p075S.C0243J;
import p075S.C0244K;
import p075S.C0262n;
import p075S.C0265q;
import p086V.C0322h;

/* JADX INFO: renamed from: T.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0298p {
    /* JADX INFO: renamed from: a */
    public static boolean m579a(Context context, File file) throws ShareException {
        try {
            Debugger.m8616s("Mde$SesShareUtil", "checkValidSDocFile");
            SpenSdkCompat.with(context).asSpenSDocFile().checkValidity(file.getAbsolutePath());
            return true;
        } catch (SpenSDocUnsupportedFileException e) {
            Debugger.m8609e("Mde$SesShareUtil", e.toString());
            if (file.delete()) {
                return false;
            }
            Debugger.m8609e("Mde$SesShareUtil", "UnsupportedFileException : can't delete the file!");
            return false;
        } catch (SpenSDocUnsupportedVersionException e2) {
            Debugger.m8609e("Mde$SesShareUtil", e2.toString());
            return true;
        } catch (IOException e3) {
            Debugger.m8609e("Mde$SesShareUtil", e3.toString());
            throw new ShareException(ShareConstants$ResultCode.FAIL_FILE_WRITE_EXCEPTION, "Failed to checkValidity!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m580b(Context context, boolean z, String str, long j, long j2, String str2, String str3, String str4, String str5, String str6) throws Throwable {
        NotesDocumentEntity notesDocumentEntity;
        Exception exc;
        StringBuilder sb;
        if (z) {
            notesDocumentEntity = new NotesDocumentEntity();
        } else {
            notesDocumentEntity = AbstractC0000a.m9f(context, str);
            if (notesDocumentEntity == null) {
                Debugger.m8618w("Mde$SesShareUtil", "convertAndSaveToDb() : saveParam is null!");
                return;
            }
        }
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str6);
        notesDocumentEntity.setServerTimestamp(Long.valueOf(j2));
        notesDocumentEntity.setIsDirty(0);
        notesDocumentEntity.setDirtySkipped(true);
        notesDocumentEntity.setKeepServerTimestamp(true);
        notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(j), Long.valueOf(j2));
        notesDocumentEntity.setRemoveActionLinkData(true);
        notesDocumentEntity.setFirstOpendAt(0L);
        notesDocumentEntity.setMdeSpaceId(str2);
        notesDocumentEntity.setMdeItemId(str3);
        notesDocumentEntity.setMdeGroupId(str4);
        notesDocumentEntity.setMdeOwnerId(str5);
        notesDocumentEntity.setCategoryUuid(PredefinedCategory.SHARED_NOTE_BOOK.getUuid());
        SpenSDoc spenSDoc = null;
        try {
            try {
                spenSDoc = new SpenSDoc(context, str6, LockConstants.EXTRA_VALUE_LOCK_CONFIRMED, new SDocLocker(context).getUserCode(), 0);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SpenSDocInvalidPasswordException e) {
            e = e;
        } catch (SpenSDocUnsupportedFileException e2) {
            e = e2;
        } catch (SpenSDocUnsupportedVersionException e3) {
            e = e3;
        } catch (IOException e5) {
            e = e5;
        }
        try {
            if (!DocumentWriteResolver.save(context, z, str6, notesDocumentEntity, spenSDoc, (String) null, true, "Mde$SesShareUtil")) {
                throw new ShareException(ShareConstants$ResultCode.FAIL_DB_EXCEPTION, "fail to save document");
            }
            try {
                if (spenSDoc.isClosed()) {
                    return;
                }
                spenSDoc.close(true);
                return;
            } catch (Exception e6) {
                exc = e6;
                sb = new StringBuilder("close, e : ");
                AbstractC4539a.m3213w(exc, sb, "Mde$SesShareUtil");
            }
        } catch (SpenSDocInvalidPasswordException e7) {
            e = e7;
            spenSDoc = spenSDoc;
            Debugger.m8609e("Mde$SesShareUtil", "convert, SpenSDocInvalidPasswordException e : " + e.getMessage());
            if (spenSDoc == null) {
            }
        } catch (SpenSDocUnsupportedFileException e8) {
            e = e8;
            spenSDoc = spenSDoc;
            Debugger.m8609e("Mde$SesShareUtil", "convert, SpenSDocUnsupportedFileException e : " + e.getMessage());
            if (spenSDoc != null) {
                try {
                    if (spenSDoc.isClosed()) {
                        return;
                    }
                    spenSDoc.close(true);
                    return;
                } catch (Exception e9) {
                    exc = e9;
                    sb = new StringBuilder("close, e : ");
                    AbstractC4539a.m3213w(exc, sb, "Mde$SesShareUtil");
                }
            }
            return;
        } catch (SpenSDocUnsupportedVersionException e10) {
            e = e10;
            spenSDoc = spenSDoc;
            Debugger.m8609e("Mde$SesShareUtil", "convert, SpenSDocUnsupportedVersionExceptione : " + e.getMessage());
            if (spenSDoc != null) {
                try {
                    if (spenSDoc.isClosed()) {
                        return;
                    }
                    spenSDoc.close(true);
                    return;
                } catch (Exception e11) {
                    exc = e11;
                    sb = new StringBuilder("close, e : ");
                    AbstractC4539a.m3213w(exc, sb, "Mde$SesShareUtil");
                }
            }
            return;
        } catch (IOException e12) {
            e = e12;
            spenSDoc = spenSDoc;
            Debugger.m8609e("Mde$SesShareUtil", "convert, e : " + e.getMessage());
            if (spenSDoc != null) {
                try {
                    if (spenSDoc.isClosed()) {
                        return;
                    }
                    spenSDoc.close(true);
                    return;
                } catch (Exception e13) {
                    exc = e13;
                    sb = new StringBuilder("close, e : ");
                    AbstractC4539a.m3213w(exc, sb, "Mde$SesShareUtil");
                }
            }
            return;
        } catch (Throwable th2) {
            th = th2;
            spenSDoc = spenSDoc;
            Throwable th3 = th;
            if (spenSDoc == null) {
                throw th3;
            }
            try {
                if (spenSDoc.isClosed()) {
                    throw th3;
                }
                spenSDoc.close(true);
                throw th3;
            } catch (Exception e14) {
                AbstractC4539a.m3213w(e14, new StringBuilder("close, e : "), "Mde$SesShareUtil");
                throw th3;
            }
        }
        Debugger.m8609e("Mde$SesShareUtil", "convert, SpenSDocInvalidPasswordException e : " + e.getMessage());
        if (spenSDoc == null) {
            try {
                if (spenSDoc.isClosed()) {
                    return;
                }
                spenSDoc.close(true);
            } catch (Exception e15) {
                exc = e15;
                sb = new StringBuilder("close, e : ");
                AbstractC4539a.m3213w(exc, sb, "Mde$SesShareUtil");
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m581c(Context context, String str) {
        File shareDir = ShareFileProvider.getShareDir(context);
        if (shareDir == null || !shareDir.exists()) {
            return;
        }
        Debugger.m8607d("Mde$SesShareUtil", "remove temp file, start.");
        try {
            boolean zDelete = new File(shareDir.getCanonicalPath() + "/" + str).delete();
            StringBuilder sb = new StringBuilder("delete ret : ");
            sb.append(zDelete);
            Debugger.m8607d("Mde$SesShareUtil", sb.toString());
            Debugger.m8607d("Mde$SesShareUtil", "remove temp file, done.");
        } catch (IOException e) {
            Debugger.m8607d("Mde$SesShareUtil", e.toString());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:257|56|(1:58)(1:60)|59|61|(2:64|(1:66)(1:67))|(1:69)(24:71|(1:73)|(2:75|(1:250)(3:251|78|264))(1:248)|(1:80)(1:81)|82|(1:84)(2:85|(2:87|(1:89))(1:90))|(1:92)(3:93|(1:95)(1:96)|97)|(1:99)(2:100|(2:102|(1:104)(1:105))(0))|106|232|107|(3:109|(1:111)|117)|118|(3:120|(1:124)|(2:128|(2:130|(1:132))(1:133)))(2:134|(1:136))|137|138|(2:140|(5:253|142|(1:146)|147|263))(3:252|148|(9:151|185|186|222|187|(1:189)|194|195|262))|224|152|(6:234|154|155|236|156|157)(7:166|230|167|168|228|169|170)|220|171|195|262)|70|(0)(0)|(0)(0)|82|(0)(0)|(0)(0)|(0)(0)|106|232|107|(0)|118|(0)(0)|137|138|(0)(0)|224|152|(0)(0)|220|171|195|262) */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02a4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02a5, code lost:
    
        r3 = r6;
        r4 = r14;
        r2 = r15;
        r34 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03f3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03f4, code lost:
    
        r3 = r6;
        r35 = r14;
        r2 = r15;
        r34 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03fb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x042c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x042e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0295 A[Catch: ShareException | IOException -> 0x02a4, IOException -> 0x02ac, TryCatch #13 {ShareException | IOException -> 0x02a4, blocks: (B:107:0x028f, B:109:0x0295, B:111:0x02a0, B:120:0x02b3, B:122:0x02bc, B:124:0x02c2, B:126:0x02c9, B:128:0x02cf, B:130:0x02de, B:132:0x02e4, B:133:0x02e8, B:137:0x02fe, B:140:0x0306, B:142:0x0311, B:144:0x0318, B:146:0x031e, B:147:0x0321, B:148:0x0337, B:134:0x02ee, B:136:0x02fb), top: B:232:0x028f }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b3 A[Catch: ShareException | IOException -> 0x02a4, IOException -> 0x02ac, TRY_ENTER, TryCatch #13 {ShareException | IOException -> 0x02a4, blocks: (B:107:0x028f, B:109:0x0295, B:111:0x02a0, B:120:0x02b3, B:122:0x02bc, B:124:0x02c2, B:126:0x02c9, B:128:0x02cf, B:130:0x02de, B:132:0x02e4, B:133:0x02e8, B:137:0x02fe, B:140:0x0306, B:142:0x0311, B:144:0x0318, B:146:0x031e, B:147:0x0321, B:148:0x0337, B:134:0x02ee, B:136:0x02fb), top: B:232:0x028f }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ee A[Catch: ShareException | IOException -> 0x02a4, IOException -> 0x02ac, TryCatch #13 {ShareException | IOException -> 0x02a4, blocks: (B:107:0x028f, B:109:0x0295, B:111:0x02a0, B:120:0x02b3, B:122:0x02bc, B:124:0x02c2, B:126:0x02c9, B:128:0x02cf, B:130:0x02de, B:132:0x02e4, B:133:0x02e8, B:137:0x02fe, B:140:0x0306, B:142:0x0311, B:144:0x0318, B:146:0x031e, B:147:0x0321, B:148:0x0337, B:134:0x02ee, B:136:0x02fb), top: B:232:0x028f }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0306 A[Catch: ShareException | IOException -> 0x02a4, IOException -> 0x02ac, TRY_ENTER, TryCatch #13 {ShareException | IOException -> 0x02a4, blocks: (B:107:0x028f, B:109:0x0295, B:111:0x02a0, B:120:0x02b3, B:122:0x02bc, B:124:0x02c2, B:126:0x02c9, B:128:0x02cf, B:130:0x02de, B:132:0x02e4, B:133:0x02e8, B:137:0x02fe, B:140:0x0306, B:142:0x0311, B:144:0x0318, B:146:0x031e, B:147:0x0321, B:148:0x0337, B:134:0x02ee, B:136:0x02fb), top: B:232:0x028f }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0376 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0337 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x023a  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C6906i m582d(Context context, String str, List list, HashMap map, String str2) throws Throwable {
        String str3;
        String str4;
        C6906i c6906i;
        List<ContentDownloadResult.DownloadedContent> successList;
        C6747p c6747p;
        boolean z;
        File file;
        String name;
        SharedItem sharedItemByItemId;
        String str5;
        String str6;
        String str7;
        long createdTime;
        long jLongValue;
        SyncNoteDataRepository syncNoteDataRepository;
        long j;
        Uri uri;
        String str8;
        String str9;
        C6906i c6906i2;
        String str10;
        String str11;
        Context context2 = context;
        String str12 = str;
        String str13 = "Mde$SesShareUtil";
        C6906i c6906i3 = new C6906i(4);
        try {
            Intent intent = new Intent(MdeNotificationHelper.MDE_NOTIFICATION_ADDED_ITEM_OPENED_FROM_SES);
            intent.setPackage(context2.getPackageName());
            intent.putExtra("spaceId", str12);
            intent.putExtra("groupId", SesShareReadResolver.getInstance().getGroupId(str12));
            ContentDownloadResult contentDownloadResultM528b = AbstractC0248O.m528b(str12, list, str2, PendingIntent.getBroadcast(context2, str12.hashCode(), intent, 201326592));
            String str14 = "getSuccessList size ";
            if (contentDownloadResultM528b == null || (successList = contentDownloadResultM528b.getSuccessList()) == null) {
                str3 = "getSuccessList size ";
                str4 = "Mde$SesShareUtil";
                c6906i = c6906i3;
            } else {
                Debugger.m8607d("Mde$SesShareUtil", "getSuccessList size " + successList.size());
                if (successList.isEmpty()) {
                    c6747p = null;
                } else {
                    C6747p c6747p2 = new C6747p(context2);
                    c6747p2.m4869a();
                    c6747p = c6747p2;
                }
                SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
                NotesDataRepositoryFactory.newInstance(context2).createDocumentTagRepository();
                NotesDataRepositoryFactory.newInstance(context2).createNotesDocumentPageRepository();
                NotesDataRepositoryFactory.newInstance(context2).createMappedDocumentRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                for (ContentDownloadResult.DownloadedContent downloadedContent : successList) {
                    Uri fileUri = downloadedContent.getFileUri();
                    Uri contentUri = downloadedContent.getContentUri();
                    String itemId = downloadedContent.getItemId();
                    String uuidByItemId = syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidByItemId(str12, itemId);
                    if (contentUri != null && context2.getApplicationInfo().targetSdkVersion >= 30) {
                        if (TextUtils.isEmpty(contentUri.getPath())) {
                            String originalUriByItemId = SesShareReadResolver.getInstance().getOriginalUriByItemId(context2, str12, itemId);
                            contentUri = originalUriByItemId != null ? Uri.parse(originalUriByItemId) : null;
                            if (contentUri == null) {
                                Debugger.m8609e(str13, "There is no content uri from ses provider ");
                                c6906i3.m5137a(itemId);
                            }
                        }
                        String path = contentUri.getPath();
                        if (TextUtils.isEmpty(path)) {
                            Debugger.m8609e(str13, "getFileNameFromContentUri, contentUriPath is empty!");
                        } else {
                            int iLastIndexOf = path.endsWith(".sdocx") ? path.lastIndexOf(".sdocx") : path.lastIndexOf(".sdoc");
                            int iLastIndexOf2 = path.lastIndexOf(47);
                            if (iLastIndexOf2 > 0 && iLastIndexOf > iLastIndexOf2) {
                                name = path.substring(iLastIndexOf2 + 1);
                            }
                            if (name != null || name.isEmpty()) {
                                name = (String) map.get(str12 + itemId);
                                if (name != null || name.isEmpty()) {
                                    Debugger.m8609e(str13, "There is no file name! ");
                                    c6906i3.m5137a(itemId);
                                }
                            }
                            file = null;
                            z = true;
                            if (uuidByItemId == null) {
                            }
                            String groupId = SesShareReadResolver.getInstance().getGroupId(str12);
                            sharedItemByItemId = SesShareReadResolver.getInstance().getSharedItemByItemId(context2, str12, itemId);
                            if (sharedItemByItemId != null) {
                            }
                            if (sharedItemByItemId != null) {
                            }
                            if (str6 != null) {
                            }
                            if (sharedItemByItemId == null) {
                            }
                            long j2 = 0;
                            if (sharedItemByItemId == null) {
                            }
                            if (sharedItemByItemId == null) {
                            }
                            if (sharedItemByItemId == null) {
                            }
                            String strM387b = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), name + ".temp");
                            String strM387b2 = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), name);
                            if (name.endsWith(".sdoc")) {
                            }
                            if (z) {
                            }
                            if (!name.endsWith(".sdoc")) {
                            }
                            Debugger.m8607d(str13, "save before timestamp : " + j + " uuid : " + uuidByItemId);
                            if (name.endsWith(".sdoc")) {
                            }
                            ((ArrayList) c6906i2.f4483b).add(str8);
                            str9 = str11;
                            str12 = str;
                            c6906i3 = c6906i2;
                            str13 = str9;
                            syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                            str14 = str10;
                        }
                        name = null;
                        if (name != null) {
                            name = (String) map.get(str12 + itemId);
                            if (name != null) {
                            }
                            Debugger.m8609e(str13, "There is no file name! ");
                            c6906i3.m5137a(itemId);
                        }
                    } else if (fileUri == null) {
                        Debugger.m8609e(str13, "There is no fileUri!");
                        c6906i3.m5137a(itemId);
                    } else {
                        File file2 = new File(fileUri.getPath());
                        if (file2.exists()) {
                            file = file2;
                            name = file2.getName();
                            z = false;
                            boolean z2 = uuidByItemId == null;
                            String groupId2 = SesShareReadResolver.getInstance().getGroupId(str12);
                            sharedItemByItemId = SesShareReadResolver.getInstance().getSharedItemByItemId(context2, str12, itemId);
                            if (sharedItemByItemId != null) {
                                Object obj = sharedItemByItemId.getMetaData().get("uuid");
                                uuidByItemId = obj != null ? (String) obj : null;
                            }
                            if (sharedItemByItemId != null) {
                                str5 = str14;
                            } else {
                                str5 = str14;
                                Object obj2 = sharedItemByItemId.getMetaData().get("uuid");
                                str6 = obj2 != null ? (String) obj2 : null;
                                if (str6 != null) {
                                    NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context2, str6);
                                    if (!z2 && notesDocumentEntityM9f != null) {
                                        Debugger.m8609e(str13, "uuid conflict");
                                        str14 = str5;
                                    }
                                }
                                String leaderId = sharedItemByItemId == null ? null : sharedItemByItemId.getLeaderId();
                                long j22 = 0;
                                if (sharedItemByItemId == null) {
                                    str7 = leaderId;
                                    createdTime = 0;
                                } else {
                                    str7 = leaderId;
                                    Object obj3 = sharedItemByItemId.getMetaData().get("createdAt");
                                    if (obj3 != null) {
                                        createdTime = ((Long) obj3).longValue();
                                        if (createdTime == 0) {
                                            createdTime = sharedItemByItemId.getCreatedTime();
                                        }
                                    } else {
                                        createdTime = sharedItemByItemId.getCreatedTime();
                                    }
                                }
                                if (sharedItemByItemId == null) {
                                    syncNoteDataRepository = syncNoteDataRepositoryCreateSyncNoteDataRepository;
                                    j = 0;
                                    jLongValue = 0;
                                } else {
                                    Object obj4 = sharedItemByItemId.getMetaData().get("lastModifiedAt");
                                    jLongValue = obj4 != null ? ((Long) obj4).longValue() : 0L;
                                    syncNoteDataRepository = syncNoteDataRepositoryCreateSyncNoteDataRepository;
                                    j = jLongValue;
                                }
                                if (sharedItemByItemId == null) {
                                    uri = fileUri;
                                } else {
                                    uri = fileUri;
                                    Object obj5 = sharedItemByItemId.getMetaData().get("DoclastModifiedAt");
                                    if (obj5 != null) {
                                        long jLongValue2 = ((Long) obj5).longValue();
                                        j22 = jLongValue2 == 0 ? jLongValue : jLongValue2;
                                    }
                                }
                                String strM387b3 = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), name + ".temp");
                                String strM387b22 = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), name);
                                if (name.endsWith(".sdoc")) {
                                    File file3 = new File(strM387b22);
                                    if (file3.isDirectory()) {
                                        FileUtils.deleteFile(file3);
                                    }
                                    strM387b3 = strM387b22;
                                }
                                if (z) {
                                    BaseUtils.copyFileFromContentUri(contentUri, strM387b3);
                                    DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(context2, contentUri);
                                    if (documentFileFromSingleUri != null && !documentFileFromSingleUri.delete()) {
                                        Debugger.m8609e(str13, "Failed to delete temporary file(uri).");
                                    }
                                    if (uri != null && uri.getPath() != null) {
                                        file = new File(uri.getPath());
                                        if (!file.canWrite()) {
                                            Debugger.m8607d(str13, "Failed to delete temporary file. - can not access by file uri");
                                        } else if (!file.delete()) {
                                            Debugger.m8609e(str13, "Failed to delete temporary file.");
                                        }
                                    }
                                } else {
                                    BaseUtils.copyFile(file.getAbsolutePath(), strM387b3);
                                    if (!file.delete()) {
                                        Debugger.m8609e(str13, "Failed to delete temporary file.");
                                    }
                                }
                                if (!name.endsWith(".sdoc")) {
                                    SpenSdkInitializer.initialize(context2);
                                    boolean zM584f = m584f(context2, strM387b3);
                                    File file4 = new File(strM387b3);
                                    if (!SpenWNoteFile.isValid(strM387b3) || zM584f) {
                                        str8 = uuidByItemId;
                                        c6906i2 = c6906i3;
                                        str10 = str5;
                                        str9 = str13;
                                        try {
                                            Debugger.m8615i(str9, "Not valid sdocx file!");
                                            if (!file4.delete()) {
                                                Debugger.m8609e(str9, "failed to delete temporary file!");
                                            }
                                            c6906i2.m5137a(itemId);
                                            AbstractC0299q.m623d(context2, downloadedContent.getItemId(), downloadedContent.getSpaceId());
                                        } catch (ShareException e) {
                                            e = e;
                                            c6906i2.m5137a(str8);
                                            AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                        } catch (IOException e2) {
                                            e = e2;
                                            c6906i2.m5137a(str8);
                                            AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                        }
                                        str12 = str;
                                        c6906i3 = c6906i2;
                                        str13 = str9;
                                        syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                        str14 = str10;
                                    }
                                } else if (!m579a(context2, new File(strM387b3))) {
                                    Debugger.m8615i(str13, "Not valid sdoc file!");
                                    if (file != null && !file.delete()) {
                                        Debugger.m8609e(str13, "failed to delete temporary file!");
                                    }
                                    c6906i3.m5137a(itemId);
                                    AbstractC0299q.m623d(context2, downloadedContent.getItemId(), downloadedContent.getSpaceId());
                                    str12 = str;
                                    str14 = str5;
                                    syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                }
                                Debugger.m8607d(str13, "save before timestamp : " + j + " uuid : " + uuidByItemId);
                                if (name.endsWith(".sdoc")) {
                                    try {
                                        int i = Resources.getSystem().getDisplayMetrics().widthPixels;
                                        str8 = uuidByItemId;
                                        str10 = str5;
                                    } catch (ShareException | IOException e3) {
                                        e = e3;
                                        str8 = uuidByItemId;
                                        str10 = str5;
                                    }
                                    try {
                                        m580b(context2, !z2, str8, createdTime, j, str, itemId, groupId2, str7, strM387b22);
                                        context2 = context;
                                        str11 = str13;
                                        c6906i2 = c6906i3;
                                    } catch (ShareException e5) {
                                        e = e5;
                                        context2 = context;
                                        str9 = str13;
                                        c6906i2 = c6906i3;
                                        c6906i2.m5137a(str8);
                                        AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                    } catch (IOException e6) {
                                        e = e6;
                                        context2 = context;
                                        str9 = str13;
                                        c6906i2 = c6906i3;
                                        c6906i2.m5137a(str8);
                                        AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                    }
                                } else {
                                    long j3 = j;
                                    str8 = uuidByItemId;
                                    C6906i c6906i4 = c6906i3;
                                    str10 = str5;
                                    long j5 = createdTime;
                                    try {
                                        SpenWNoteFile.setOwnerId(strM387b3, "");
                                        SpenWNoteFile.setDocumentType(strM387b3, SpenWNote.DocumentType.UNLOCKED_DOC);
                                        str11 = str13;
                                        context2 = context;
                                        try {
                                            m588j(context2, !z2, str8, j5, j3, j22, str, itemId, groupId2, str7, strM387b3, strM387b22, c6747p);
                                            c6906i2 = c6906i4;
                                        } catch (ShareException e7) {
                                            e = e7;
                                            c6906i2 = c6906i4;
                                            str9 = str11;
                                            c6906i2.m5137a(str8);
                                            AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                            str12 = str;
                                            c6906i3 = c6906i2;
                                            str13 = str9;
                                            syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                            str14 = str10;
                                        } catch (IOException e8) {
                                            e = e8;
                                            c6906i2 = c6906i4;
                                            str9 = str11;
                                            c6906i2.m5137a(str8);
                                            AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                            str12 = str;
                                            c6906i3 = c6906i2;
                                            str13 = str9;
                                            syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                            str14 = str10;
                                        }
                                    } catch (ShareException e9) {
                                        e = e9;
                                        c6906i2 = c6906i4;
                                        str11 = str13;
                                        context2 = context;
                                        str9 = str11;
                                        c6906i2.m5137a(str8);
                                        AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                        str12 = str;
                                        c6906i3 = c6906i2;
                                        str13 = str9;
                                        syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                        str14 = str10;
                                    } catch (IOException e10) {
                                        e = e10;
                                        c6906i2 = c6906i4;
                                        str11 = str13;
                                        context2 = context;
                                        str9 = str11;
                                        c6906i2.m5137a(str8);
                                        AbstractC4539a.m3213w(e, new StringBuilder("Exception while downloadAndSaveMdeSdoc. "), str9);
                                        str12 = str;
                                        c6906i3 = c6906i2;
                                        str13 = str9;
                                        syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                        str14 = str10;
                                    }
                                }
                                ((ArrayList) c6906i2.f4483b).add(str8);
                                str9 = str11;
                                str12 = str;
                                c6906i3 = c6906i2;
                                str13 = str9;
                                syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                                str14 = str10;
                            }
                            if (str6 != null) {
                            }
                            if (sharedItemByItemId == null) {
                            }
                            long j222 = 0;
                            if (sharedItemByItemId == null) {
                            }
                            if (sharedItemByItemId == null) {
                            }
                            if (sharedItemByItemId == null) {
                            }
                            String strM387b32 = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), name + ".temp");
                            String strM387b222 = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), name);
                            if (name.endsWith(".sdoc")) {
                            }
                            if (z) {
                            }
                            if (!name.endsWith(".sdoc")) {
                            }
                            Debugger.m8607d(str13, "save before timestamp : " + j + " uuid : " + uuidByItemId);
                            if (name.endsWith(".sdoc")) {
                            }
                            ((ArrayList) c6906i2.f4483b).add(str8);
                            str9 = str11;
                            str12 = str;
                            c6906i3 = c6906i2;
                            str13 = str9;
                            syncNoteDataRepositoryCreateSyncNoteDataRepository = syncNoteDataRepository;
                            str14 = str10;
                        } else {
                            Debugger.m8609e(str13, "There is no completeFile! ");
                            c6906i3.m5137a(itemId);
                        }
                    }
                }
                str3 = str14;
                str4 = str13;
                c6906i = c6906i3;
                if (!list.isEmpty()) {
                    Intent intentM2214e = AbstractC2821a.m2214e("com.samsung.android.mobileservice.ACTION_DELETE_ORIGINAL_ITEM", "com.samsung.android.mobileservice");
                    intentM2214e.putStringArrayListExtra("item_ids", new ArrayList<>(list));
                    try {
                        context2.sendBroadcast(intentM2214e, "com.samsung.android.mobileservice.social.share.item.provider.permission.WRITE");
                    } catch (RuntimeException e11) {
                        throw e11;
                    } catch (Exception e12) {
                        AbstractC4539a.m3213w(e12, new StringBuilder("Exception while downloadAndSaveMdeSdoc request temp clean"), str4);
                    }
                }
                if (c6747p != null) {
                    c6747p.m4870b();
                }
            }
            Debugger.m8607d(str4, str3 + ((ArrayList) c6906i.f4483b).size());
            Debugger.m8607d(str4, "getFailedList size " + ((ArrayList) c6906i.f4484c).size());
            return c6906i;
        } catch (Exception e13) {
            AbstractC4539a.m3213w(e13, new StringBuilder("[CS1-2] Exception while downloadAndSaveMdeSdoc. "), "Mde$SesShareUtil");
            return c6906i3;
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m583e(String str) {
        if (str == null || str.length() <= 200) {
            return str;
        }
        return str.substring(0, 200) + Typography.ellipsis;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m584f(Context context, String str) {
        int minFormatVersion = SpenWNoteFile.getMinFormatVersion(str);
        int sdkFormatVersion = SpenWNoteFile.getSdkFormatVersion();
        if (minFormatVersion <= sdkFormatVersion) {
            return false;
        }
        Debugger.m8609e("Mde$SesShareUtil", "minFormat is larger, minFormatVerison : " + minFormatVersion + " sdkFormatVersion  : " + sdkFormatVersion);
        if (!SyncState.isAppUpdateNeeded(context)) {
            SyncState.setAppUpdateNeeded(context, true);
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m585g(String str, SharedItem sharedItem, String str2) {
        if (sharedItem.getTitle().equals(str2)) {
            return false;
        }
        return (TextUtils.isEmpty(str2) && sharedItem.getTitle().equals(str)) ? false : true;
    }

    /* JADX INFO: renamed from: h */
    public static C6906i m586h(Context context, String str, String str2, ArrayList arrayList) {
        C6906i c6906i = new C6906i(4);
        CompletableFuture completableFuture = new CompletableFuture();
        AbstractC0267s.m543a().requestShare(str, arrayList, new C0262n(completableFuture), (PendingIntent) null, (Bundle) null).setShareStatusListener(new C0265q());
        SharedItemListWithUriListResult sharedItemListWithUriListResult = (SharedItemListWithUriListResult) completableFuture.get(2000000L, TimeUnit.MILLISECONDS);
        List<SharedItemWithUriList> successList = sharedItemListWithUriListResult.getSuccessList();
        if (successList == null || successList.isEmpty()) {
            Debugger.m8609e("Mde$SesShareUtil", "[CS5-2] Can't coeditCreateNote, uuid = " + str2);
            List<ShareApi.SharedItemWithUriListRequest> failureList = sharedItemListWithUriListResult.getFailureList();
            if (failureList != null && !failureList.isEmpty()) {
                Iterator<ShareApi.SharedItemWithUriListRequest> it = failureList.iterator();
                while (it.hasNext()) {
                    c6906i.m5137a((String) it.next().getMetaData().get("uuid"));
                }
            }
        } else {
            SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
            for (SharedItemWithUriList sharedItemWithUriList : successList) {
                String string = ((HashMap) sharedItemWithUriList.getMetaData()).get("uuid").toString();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(context, context);
                NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f.setMdeItemId(string, sharedItemWithUriList.getItemId());
                syncNoteDataRepositoryM3196f.updateModifiedTime(string, sharedItemWithUriList.getModifiedTime());
                syncNoteDataRepositoryM3196f.updateCreatedAt(string, sharedItemWithUriList.getCreatedTime());
                syncNoteDataRepository.updateFirstOpenedAt(str2, System.currentTimeMillis());
                ((ArrayList) c6906i.f4483b).add(string);
                Debugger.m8607d("Mde$SesShareUtil", "[CS5-1] coeditCreateNote uuid = " + string + ", itemId = " + sharedItemWithUriList.getItemId() + ", leaderId = " + sharedItemWithUriList.getLeaderId());
            }
        }
        int code = sharedItemListWithUriListResult.getStatus().getCode();
        if (code == 109) {
            Debugger.m8609e("Mde$SesShareUtil", "[CS5-2] Can't coeditCreateNote due to quota, uuid = " + str2);
            return c6906i;
        }
        if (code != 1) {
            Debugger.m8609e("Mde$SesShareUtil", "[CS5-2] Can't coeditCreateNote, resultCode = " + code);
        }
        return c6906i;
    }

    /* JADX INFO: renamed from: i */
    public static void m587i(Context context, boolean z, String str, long j, long j2, long j3, String str2, String str3, String str4, String str5, String str6, String str7, C6747p c6747p) throws IOException {
        NotesDocumentEntity notesDocumentEntity;
        SpenWNoteFile.setOwnerId(str7, "");
        SpenWNoteFile.setDocumentType(str7, SpenWNote.DocumentType.UNLOCKED_DOC);
        if (z) {
            notesDocumentEntity = AbstractC0000a.m9f(context, str);
            if (notesDocumentEntity == null) {
                Debugger.m8618w("Mde$SesShareUtil", "[CS7] saveCoeditNote() : saveParam is null!");
                return;
            }
        } else {
            notesDocumentEntity = new NotesDocumentEntity();
        }
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str6);
        notesDocumentEntity.setServerTimestamp(Long.valueOf(j2));
        notesDocumentEntity.setIsDirty(0);
        notesDocumentEntity.setDirtySkipped(true);
        notesDocumentEntity.setKeepServerTimestamp(true);
        notesDocumentEntity.getTimeSaveParam().setForceUpdate(true);
        notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(j), Long.valueOf(j3));
        notesDocumentEntity.setRemoveActionLinkData(true);
        if (notesDocumentEntity.getFirstOpendAt() != SharedPreferencesCompat.getInstance("CoeditPref").getLong("CoeditPrefKeyReadAllTime", -1L)) {
            notesDocumentEntity.setFirstOpendAt(0L);
        }
        notesDocumentEntity.setMdeSpaceId(str2);
        notesDocumentEntity.setMdeItemId(str3);
        notesDocumentEntity.setMdeGroupId(str4);
        notesDocumentEntity.setMdeOwnerId(str5);
        notesDocumentEntity.setCategoryUuid("coedit:///");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSdocConverted", false);
        } catch (JSONException e) {
            Logger.m8697d("Mde$SesShareUtil", e.getMessage());
        }
        notesDocumentEntity.setMdeExtra(jSONObject.toString());
        c6747p.m4872d(str7, !z, notesDocumentEntity);
    }

    /* JADX INFO: renamed from: j */
    public static void m588j(Context context, boolean z, String str, long j, long j2, long j3, String str2, String str3, String str4, String str5, String str6, String str7, C6747p c6747p) throws IOException, ShareException {
        NotesDocumentEntity notesDocumentEntity;
        if (z) {
            notesDocumentEntity = new NotesDocumentEntity();
        } else {
            notesDocumentEntity = AbstractC0000a.m9f(context, str);
            if (notesDocumentEntity == null) {
                Debugger.m8618w("Mde$SesShareUtil", "saveMdeSDocToDb() : saveParam is null!");
                return;
            }
        }
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str7);
        notesDocumentEntity.setServerTimestamp(Long.valueOf(j2));
        notesDocumentEntity.setIsDirty(0);
        notesDocumentEntity.setDirtySkipped(true);
        notesDocumentEntity.setKeepServerTimestamp(true);
        notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(j), Long.valueOf(j3));
        notesDocumentEntity.setRemoveActionLinkData(true);
        notesDocumentEntity.setFirstOpendAt(0L);
        notesDocumentEntity.setMdeSpaceId(str2);
        notesDocumentEntity.setMdeItemId(str3);
        notesDocumentEntity.setMdeGroupId(str4);
        notesDocumentEntity.setMdeOwnerId(str5);
        notesDocumentEntity.setCategoryUuid(PredefinedCategory.SHARED_NOTE_BOOK.getUuid());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSdocConverted", false);
        } catch (JSONException e) {
            Logger.m8697d("Mde$SesShareUtil", e.getMessage());
        }
        notesDocumentEntity.setMdeExtra(jSONObject.toString());
        if (0 > j3) {
            Debugger.m8615i("Mde$SesShareUtil", "saveMdeSDocToDb() : ignore saving the shared doc because it was updated locally : " + str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_FILE_WRITE_EXCEPTION, "the local note is updated");
        }
        if (c6747p.m4871c(str)) {
            c6747p.m4872d(str6, z, notesDocumentEntity);
            return;
        }
        Debugger.m8615i("Mde$SesShareUtil", "saveMdeSDocToDb() : ignore saving the shared doc because it is being updated locally : " + str);
        throw new ShareException(ShareConstants$ResultCode.FAIL_FILE_WRITE_EXCEPTION, "the local note is being updated locally");
    }

    /* JADX INFO: renamed from: k */
    public static C6906i m589k(Context context, String str, List list) {
        C6906i c6906i = new C6906i(4);
        ArrayList arrayList = new ArrayList();
        SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0297o c0297o = (C0297o) it.next();
            ShareSyncEntry shareSyncEntry = syncNoteDataRepository.getShareSyncEntry(c0297o.f766a);
            String filePath = shareSyncEntry.getFilePath();
            String name = new File(filePath).getName();
            Uri uri = ShareFileProvider.getUri(context, filePath, name);
            context.grantUriPermission("com.samsung.android.mobileservice", uri, 1);
            Long serverTimestamp = shareSyncEntry.getServerTimestamp();
            serverTimestamp.getClass();
            long createdAt = shareSyncEntry.getCreatedAt();
            long lastModifiedAt = shareSyncEntry.getLastModifiedAt();
            ShareApi.SharedItemWithUriRequest sharedItemWithUriRequest = new ShareApi.SharedItemWithUriRequest(name);
            sharedItemWithUriRequest.setUri(uri);
            sharedItemWithUriRequest.setContentMimeType(Constants.MIME_SDOC);
            HashMap map = new HashMap();
            map.put("uuid", c0297o.f766a);
            map.put("lastModifiedAt", serverTimestamp);
            map.put("createdAt", Long.valueOf(createdAt));
            map.put("DoclastModifiedAt", Long.valueOf(lastModifiedAt));
            sharedItemWithUriRequest.setMetaData(map);
            sharedItemWithUriRequest.setItemId(c0297o.f767b);
            arrayList.add(sharedItemWithUriRequest);
        }
        try {
            if (C6716p.m4809q().m4801j()) {
                SharedItemListResult sharedItemListResultM531e = AbstractC0248O.m531e(str, arrayList);
                if (sharedItemListResultM531e.getStatus() != null) {
                    Debugger.m8607d("Mde$SesShareUtil", "updateMdeSdoc : Result = " + sharedItemListResultM531e.getStatus().getCode() + ", Message = " + sharedItemListResultM531e.getStatus().getMessage());
                }
                for (SharedItem sharedItem : sharedItemListResultM531e.getSuccessList()) {
                    ((ArrayList) c6906i.f4483b).add(((HashMap) sharedItem.getMetaData()).get("uuid").toString());
                    m581c(context, sharedItem.getTitle());
                }
                for (ShareApi.SharedItemRequest sharedItemRequest : sharedItemListResultM531e.getFailureList()) {
                    c6906i.m5137a(((HashMap) sharedItemRequest.getMetaData()).get("uuid").toString());
                    m581c(context, sharedItemRequest.getTitle());
                }
            }
            return c6906i;
        } catch (Exception e) {
            AbstractC4539a.m3213w(e, new StringBuilder("fail to update mde sdoc. "), "Mde$SesShareUtil");
            return c6906i;
        }
    }

    /* JADX INFO: renamed from: l */
    public static C6906i m590l(Context context, String str, List list) {
        C6906i c6906i = new C6906i(4);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(context, context);
            NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ShareSyncEntry shareSyncEntry = syncNoteDataRepository.getShareSyncEntry(str2);
                String filePath = shareSyncEntry.getFilePath();
                File file = new File(filePath);
                if (file.exists()) {
                    String name = file.getName();
                    Uri uri = ShareFileProvider.getUri(context, filePath, name);
                    if (uri == null) {
                        c6906i.m5137a(str2);
                    } else {
                        context.grantUriPermission("com.samsung.android.mobileservice", uri, 1);
                        Long serverTimestamp = shareSyncEntry.getServerTimestamp();
                        serverTimestamp.getClass();
                        long createdAt = shareSyncEntry.getCreatedAt();
                        long lastModifiedAt = shareSyncEntry.getLastModifiedAt();
                        ShareApi.SharedItemWithUriRequest sharedItemWithUriRequest = new ShareApi.SharedItemWithUriRequest(name);
                        sharedItemWithUriRequest.setUri(uri);
                        sharedItemWithUriRequest.setContentMimeType(Constants.MIME_SDOC);
                        sharedItemWithUriRequest.setTitle(name);
                        HashMap map = new HashMap();
                        map.put("uuid", str2);
                        map.put("lastModifiedAt", serverTimestamp);
                        map.put("createdAt", Long.valueOf(createdAt));
                        map.put("DoclastModifiedAt", Long.valueOf(lastModifiedAt));
                        sharedItemWithUriRequest.setMetaData(map);
                        arrayList.add(sharedItemWithUriRequest);
                    }
                } else {
                    Debugger.m8609e("Mde$SesShareUtil", "uploadMdeSdoc. File doesn't exist.");
                    c6906i.m5137a(str2);
                }
            }
            try {
                if (C6716p.m4809q().m4801j()) {
                    CompletableFuture completableFuture = new CompletableFuture();
                    AbstractC0248O.m527a().requestShare(str, arrayList, new C0243J(completableFuture), (PendingIntent) null, (Bundle) null).setShareStatusListener(new C0244K());
                    SharedItemListResult sharedItemListResult = (SharedItemListResult) completableFuture.get(2000000L, TimeUnit.MILLISECONDS);
                    List<SharedItem> successList = sharedItemListResult.getSuccessList();
                    if (successList == null || successList.isEmpty()) {
                        Debugger.m8609e("Mde$SesShareUtil", "Can't upload sdoc for MDE!");
                        List<ShareApi.SharedItemRequest> failureList = sharedItemListResult.getFailureList();
                        if (failureList != null && !failureList.isEmpty()) {
                            Iterator<ShareApi.SharedItemRequest> it2 = failureList.iterator();
                            while (it2.hasNext()) {
                                c6906i.m5137a((String) it2.next().getMetaData().get("uuid"));
                            }
                        }
                    } else {
                        for (SharedItem sharedItem : successList) {
                            String string = ((HashMap) sharedItem.getMetaData()).get("uuid").toString();
                            syncNoteDataRepositoryM3196f.setMdeItemId(string, sharedItem.getItemId());
                            ((ArrayList) c6906i.f4483b).add(string);
                            Debugger.m8607d("Mde$SesShareUtil", "uploadMdeSdoc : " + string + SQLKeyword.COMMA + sharedItem.getItemId() + SQLKeyword.COMMA + sharedItem.getLeaderId());
                        }
                    }
                    sharedItemListResult.getStatus().getCode();
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    m581c(context, ((ShareApi.SharedItemRequest) it3.next()).getTitle());
                }
            } catch (Exception e) {
                Debugger.m8609e("Mde$SesShareUtil", e.toString());
                return c6906i;
            }
        }
        return c6906i;
    }
}
