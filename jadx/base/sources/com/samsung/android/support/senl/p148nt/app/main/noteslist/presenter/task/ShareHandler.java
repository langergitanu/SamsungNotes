package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.MakeUriHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareHandler {
    private static final int BUFFER = 10240;
    private static final String TAG = "ShareHandler";
    private String mDestPath;
    private boolean mIsCanceled;
    private final ShareToOtherAppHandler mShareToOtherAppHandler = new ShareToOtherAppHandler();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onProgressMakePdf(int i, int i2);

        void onStartMakePdf(String str);
    }

    private void closeSpenWNote(SpenWNote spenWNote, String str) {
        closeSpenWNote(spenWNote, str, "normally");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCoverSummary(Context context, String str) {
        DocumentCoverStateTuple coverStateTuple;
        return (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000 && (coverStateTuple = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository().getCoverStateTuple(str)) != null && coverStateTuple.isEnabled()) ? coverStateTuple.getSummary() : "";
    }

    private void removeAllCustomObject(SpenWNote spenWNote) {
        for (SpenWPage spenWPage : spenWNote.getPageList()) {
            if (spenWPage.getCustomObjectCount() > 0) {
                spenWPage.removeAllCustomObject();
            }
        }
    }

    private void setDefaultPageSize(SpenWNote spenWNote, int i) {
        if (spenWNote.getPageDefaultWidth() == 0) {
            spenWNote.setPageDefaultWidth(1080);
        }
        if (spenWNote.getPageDefaultHeight() == 0) {
            spenWNote.setPageDefaultHeight(i);
        }
    }

    public void cancel() {
        MainLogger.m7258i(TAG, "cancel");
        this.mIsCanceled = true;
        this.mShareToOtherAppHandler.getMakeUriHelper().cancel();
    }

    public Intent createIntentToShareText(Context context, SpenWNote spenWNote, String str) {
        return this.mShareToOtherAppHandler.createIntentToShareText(context, spenWNote, str, ShareCallbackReceiver.ShareCaller.MemoList);
    }

    public void deleteFile(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new File(it.next()).delete()) {
                MainLogger.m7258i(TAG, "deleteFile - delete fail");
            }
        }
    }

    public String generateNewFilePath(String str, String str2, long j, String str3) {
        return (TextUtils.isEmpty(this.mDestPath) || TextUtils.isEmpty(str)) ? ShareUtils.generateNewFilePath(str, str2, j, str3) : this.mDestPath;
    }

    public String getDestPath() {
        return this.mDestPath;
    }

    public MakeUriHelper getMakeUriHelper() {
        return this.mShareToOtherAppHandler.getMakeUriHelper();
    }

    public ArrayList<String> makePDFFiles(Context context, SpenNotePdfExport spenNotePdfExport, List<ShareData> list, String str, Callback callback) {
        String str2;
        SpenWNote spenWNoteOpen;
        try {
            CommonUtil.initSpenSdk(context);
            SpenComposerSdkInitializer.initialize(context);
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("makePDFFiles# initSpenSdk, SpenComposerSdk.initialize : "), TAG);
        }
        MainLogger.m7258i(TAG, "makePDFFiles");
        ArrayList<String> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size && !this.mIsCanceled; i++) {
            ShareData shareData = list.get(i);
            String path = shareData.getPath();
            String strGenerateNewFilePath = generateNewFilePath(str, shareData.getTitle(), shareData.getLastModifiedTime(), Constants.PDF_EXTENSION);
            if (callback != null) {
                callback.onStartMakePdf(FileUtils.getFileNameFromFilePath(strGenerateNewFilePath));
            }
            try {
                boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(shareData.getUuid());
                try {
                    spenWNoteOpen = DocumentFileManager.getInstance().open(context, path, DocumentFileUtil.getSize(path, zIsCoeditUuid ? DocumentFileUtil.DocumentFileSizeType.CoEdit : DocumentFileUtil.DocumentFileSizeType.Document, 0).getWidth(), 1000, true, true, zIsCoeditUuid);
                    str2 = path;
                } catch (Exception e2) {
                    e = e2;
                    str2 = path;
                    AbstractC14516b.m15115c(e, new StringBuilder("makePDFFiles# new SpenWNote fail e : "), TAG);
                    spenWNoteOpen = null;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = path;
            }
            if (spenWNoteOpen != null) {
                removeAllCustomObject(spenWNoteOpen);
                spenNotePdfExport.setDocument(spenWNoteOpen);
                String strMakePdf = this.mShareToOtherAppHandler.getMakeUriHelper().makePdf(context, spenNotePdfExport, spenWNoteOpen.getPageDefaultHeight(), strGenerateNewFilePath);
                if (!TextUtils.isEmpty(strMakePdf) && AbstractC2322a.m1607A(strMakePdf)) {
                    arrayList.add(strMakePdf);
                    if (callback != null) {
                        callback.onProgressMakePdf(size, arrayList.size());
                    }
                }
                try {
                    DocumentFileManager.getInstance().close(str2, spenWNoteOpen, true);
                } catch (IOException e5) {
                    MainLogger.m7255e(TAG, "makePDFFiles# " + e5.getMessage());
                }
            }
        }
        return arrayList;
    }

    public void makeShareImageList(Context context, List<ShareData> list) throws IOException {
        Uri contextShareUri;
        ArrayList<Uri> arrayList = new ArrayList<>();
        for (ShareData shareData : list) {
            SpenWNote spenWNote = NotesUtils.getSpenWNote(context, shareData.getPath(), UUIDUtils.isCoeditUuid(shareData.getUuid()));
            if (spenWNote != null) {
                ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context, LockUtils.isLocked(spenWNote));
                if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                    closeSpenWNote(spenWNote, shareData.getPath(), "makeShareImageList shareDir is invalid ");
                } else {
                    ArrayList<String> arrayListMakeImage = this.mShareToOtherAppHandler.getMakeUriHelper().makeImage(context, spenWNote, generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), "jpg"));
                    if (this.mIsCanceled) {
                        closeSpenWNote(spenWNote, shareData.getPath(), "makeShareImageList isCanceled");
                        return;
                    }
                    String strGenerateNewFilePath = generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), "zip");
                    zip(arrayListMakeImage, strGenerateNewFilePath);
                    closeSpenWNote(spenWNote, shareData.getPath());
                    if (AbstractC2322a.m1607A(strGenerateNewFilePath) && (contextShareUri = this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context, strGenerateNewFilePath, contextShareDir.mUseFileProvider, "zip")) != null) {
                        arrayList.add(contextShareUri);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        startChooserActivity(context, this.mShareToOtherAppHandler.shareFile(context, arrayList, Constants.MINE_ZIP_EXTENSION, null));
    }

    public void makeShareTextList(Context context, List<ShareData> list) {
        Uri contextShareUri;
        ArrayList<Uri> arrayList = new ArrayList<>();
        for (ShareData shareData : list) {
            SpenWNote spenWNote = NotesUtils.getSpenWNote(context, shareData.getPath(), UUIDUtils.isCoeditUuid(shareData.getUuid()));
            if (spenWNote != null) {
                ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context, LockUtils.isLocked(spenWNote));
                if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                    closeSpenWNote(spenWNote, shareData.getPath(), "makeShareTextList shareDir is invalid");
                } else {
                    if (this.mIsCanceled) {
                        closeSpenWNote(spenWNote, shareData.getPath(), "makeShareTextList isCanceled");
                        return;
                    }
                    String strMakeText = this.mShareToOtherAppHandler.getMakeUriHelper().makeText(context, spenWNote, generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), Constants.TEXT_EXTENSION));
                    closeSpenWNote(spenWNote, shareData.getPath());
                    if (AbstractC2322a.m1607A(strMakeText) && (contextShareUri = this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context, strMakeText, contextShareDir.mUseFileProvider, "text/plain")) != null) {
                        arrayList.add(contextShareUri);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        startChooserActivity(context, this.mShareToOtherAppHandler.shareFile(context, arrayList, "text/plain", null));
    }

    public void setRenamedFilePath(String str) {
        this.mDestPath = str;
    }

    public void shareImage(Context context, SpenWNote spenWNote, ShareData shareData) {
        this.mShareToOtherAppHandler.shareImage(context, spenWNote, shareData, 3);
    }

    public void shareOfficeFile(Context context, int i, List<ShareData> list) {
        String str;
        Uri contextShareUri;
        if (i != 2) {
            if (i == 3) {
                str = Constants.MIME_PPTX;
            }
        }
        str = Constants.MIME_DOCX;
        if (CommonUtil.initSpenSdk(context)) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            for (ShareData shareData : list) {
                SpenWNote spenWNoteForExportOffice = NotesUtils.getSpenWNoteForExportOffice(context, shareData.getPath(), UUIDUtils.isCoeditUuid(shareData.getUuid()));
                if (spenWNoteForExportOffice != null) {
                    ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
                    if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                        MainLogger.m7258i(TAG, "sharePowerPoint# failed to getPathForShare");
                        return;
                    }
                    if (this.mIsCanceled) {
                        closeSpenWNote(spenWNoteForExportOffice, shareData.getPath(), "shareOfficeFile isCanceled");
                        return;
                    }
                    String strGenerateNewFilePath = generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), Constants.PPT_EXTENSION);
                    String strMakeMsWord = i == 2 ? this.mShareToOtherAppHandler.getMakeUriHelper().makeMsWord(context, spenWNoteForExportOffice, shareData.getPath(), strGenerateNewFilePath) : this.mShareToOtherAppHandler.getMakeUriHelper().makeMsPPT(context, spenWNoteForExportOffice, shareData.getPath(), strGenerateNewFilePath);
                    closeSpenWNote(spenWNoteForExportOffice, shareData.getPath());
                    if (AbstractC2322a.m1607A(strMakeMsWord) && (contextShareUri = this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context, strMakeMsWord, contextShareDir.mUseFileProvider, str)) != null) {
                        arrayList.add(contextShareUri);
                    }
                }
            }
            startChooserActivity(context, this.mShareToOtherAppHandler.shareFile(context, arrayList, str, null));
        }
    }

    public int sharePdf(Context context, SpenNotePdfExport spenNotePdfExport, List<ShareData> list, Callback callback) {
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context, LockUtils.isLocked(list.get(0).getPath()));
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            MainLogger.m7258i(TAG, "sharePdf# failed to getPathForShare");
            return 0;
        }
        ArrayList<Uri> contextShareUri = this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context, makePDFFiles(context, spenNotePdfExport, list, contextShareDir.mDir, callback), contextShareDir.mUseFileProvider, Constants.MIME_PDF);
        if (contextShareUri == null || contextShareUri.isEmpty()) {
            return 0;
        }
        ShareToOtherAppHandler shareToOtherAppHandler = this.mShareToOtherAppHandler;
        shareToOtherAppHandler.startChooserActivity(context, shareToOtherAppHandler.shareFile(context, contextShareUri, Constants.MIME_PDF, null), 3);
        return contextShareUri.size();
    }

    public Intent shareSDoc(Context context, @NonNull ShareData shareData, @Nullable ShareCallbackReceiver.ShareCaller shareCaller, boolean z) throws ShareException {
        Uri contextShareUri;
        Intent baseIntentWithActionSend = ShareIntentCreationHelper.getBaseIntentWithActionSend();
        baseIntentWithActionSend.setType(Constants.MIME_SDOC);
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            Logger.m10999d(TAG, "shareSDoc# failed to getPathForShare");
            return null;
        }
        String strMakeSDoc = this.mShareToOtherAppHandler.getMakeUriHelper().makeSDoc(context, shareData, ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), z ? "sdoc" : "sdocx"));
        if (this.mIsCanceled || TextUtils.isEmpty(strMakeSDoc) || !AbstractC2322a.m1607A(strMakeSDoc) || (contextShareUri = this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context, strMakeSDoc, contextShareDir.mUseFileProvider, Constants.MIME_SDOC)) == null) {
            return null;
        }
        int userId = UserHandleCompat.getInstance().getUserId(0);
        String coverSummary = getCoverSummary(context, shareData.getUuid());
        if (!TextUtils.isEmpty(coverSummary)) {
            baseIntentWithActionSend.putStringArrayListExtra(Constants.KEY_COVER_SUMMARY_FOR_SHARE, new ArrayList<>(Collections.singleton(coverSummary)));
        }
        baseIntentWithActionSend.putExtra("android.intent.extra.STREAM", ShareUtils.attachUserIdToAuthority(contextShareUri, userId));
        baseIntentWithActionSend.addFlags(1);
        return ShareIntentCreationHelper.createChooserIntentCompat(context, baseIntentWithActionSend, null, shareCaller);
    }

    public void startChooserActivity(Context context, Intent intent) {
        this.mShareToOtherAppHandler.startChooserActivity(context, intent, 3);
    }

    public void zip(ArrayList<String> arrayList, String str) throws IOException {
        byte[] bArr = new byte[10240];
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            try {
                for (String str2 : arrayList) {
                    FileInputStream fileInputStream = new FileInputStream(str2);
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 10240);
                        zipOutputStream.putNextEntry(new ZipEntry(str2.substring(str2.lastIndexOf(47) + 1)));
                        while (true) {
                            int i = bufferedInputStream.read(bArr, 0, 10240);
                            if (i == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, i);
                            }
                        }
                        zipOutputStream.closeEntry();
                        bufferedInputStream.close();
                        fileInputStream.close();
                    } finally {
                    }
                }
                zipOutputStream.close();
                fileOutputStream.close();
                MainLogger.m7258i(TAG, "SHARE_IMAGE_ZIP - end");
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void closeSpenWNote(SpenWNote spenWNote, String str, String str2) {
        AbstractC8014b.m7209k("closeSpenWNote# ", str2, TAG);
        try {
            DocumentFileManager.getInstance().close(str, spenWNote, true);
        } catch (IOException e) {
            MainLogger.m7255e(TAG, "closeSpenWNote# : " + e.getMessage());
        }
    }

    public Intent shareSDoc(final Context context, List<ShareData> list, @Nullable ShareCallbackReceiver.ShareCaller shareCaller, boolean z) throws ShareException {
        CommonUtil.initSpenSdk(context);
        int i = 0;
        final int userId = UserHandleCompat.getInstance().getUserId(0);
        MainLogger.m7258i(TAG, "shareSDoc# shareDataList size : " + list.size());
        if (list.size() == 1) {
            return shareSDoc(context, list.get(0), shareCaller, z);
        }
        ShareHandler shareHandler = this;
        final List<ShareData> list2 = list;
        final boolean z2 = z;
        Intent baseIntentWithActionSendMultiple = ShareIntentCreationHelper.getBaseIntentWithActionSendMultiple();
        final ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList<String> arrayList3 = new ArrayList<>();
        baseIntentWithActionSendMultiple.setType(Constants.MIME_SDOC);
        ArrayList arrayList4 = new ArrayList();
        for (int size = list2.size(); i < size; size = size) {
            ShareHandler shareHandler2 = shareHandler;
            final int i2 = i;
            arrayList4.add(new Callable<Void>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareHandler.1
                @Override // java.util.concurrent.Callable
                public Void call() throws ShareException {
                    Uri contextShareUri;
                    ShareData shareData = (ShareData) list2.get(i2);
                    ShareCacheHelper.ReturnValueForShareDir contextShareDir = ShareHandler.this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
                    if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                        AbstractC8014b.m7212n(new StringBuilder("shareSDoc# failed to getPathForShare : "), ShareHandler.TAG, i2);
                        return null;
                    }
                    String strGenerateNewFileName = ShareUtils.generateNewFileName(shareData.getTitle(), shareData.getLastModifiedTime());
                    synchronized (arrayList2) {
                        try {
                            if (arrayList2.contains(strGenerateNewFileName)) {
                                strGenerateNewFileName = strGenerateNewFileName + '_' + arrayList2.size();
                            }
                            arrayList2.add(strGenerateNewFileName);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    String strMakeSDoc = ShareHandler.this.mShareToOtherAppHandler.getMakeUriHelper().makeSDoc(context, shareData, FileUtils.generateUniqueFilePath(contextShareDir.mDir, strGenerateNewFileName, z2 ? "sdoc" : "sdocx"));
                    if (!ShareHandler.this.mIsCanceled && !TextUtils.isEmpty(strMakeSDoc) && AbstractC2322a.m1607A(strMakeSDoc) && (contextShareUri = ShareHandler.this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context, strMakeSDoc, contextShareDir.mUseFileProvider, Constants.MIME_SDOC)) != null) {
                        Uri uriAttachUserIdToAuthority = ShareUtils.attachUserIdToAuthority(contextShareUri, userId);
                        synchronized (arrayList) {
                            arrayList.add(uriAttachUserIdToAuthority);
                        }
                        String coverSummary = ShareHandler.this.getCoverSummary(context, shareData.getUuid());
                        if (!TextUtils.isEmpty(coverSummary)) {
                            synchronized (arrayList3) {
                                arrayList3.add(coverSummary);
                            }
                            return null;
                        }
                    }
                    return null;
                }
            });
            i = i2 + 1;
            shareHandler = this;
            list2 = list;
            z2 = z;
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5, new SenlThreadFactory(TAG));
        try {
            Iterator it = executorServiceNewFixedThreadPool.invokeAll(arrayList4).iterator();
            while (it.hasNext()) {
                try {
                    ((Future) it.next()).get();
                } catch (InterruptedException e) {
                    MainLogger.m7255e(TAG, "shareSDoc# " + e.getMessage());
                    Thread.currentThread().interrupt();
                    return null;
                } catch (ExecutionException e2) {
                    MainLogger.m7255e(TAG, "shareSDoc# " + e2.getMessage());
                    if (e2.getCause() == null) {
                        continue;
                    } else if (e2.getCause() instanceof ShareException) {
                        executorServiceNewFixedThreadPool.shutdownNow();
                        throw ((ShareException) e2.getCause());
                    }
                }
            }
            executorServiceNewFixedThreadPool.shutdown();
            executorServiceNewFixedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
            baseIntentWithActionSendMultiple.addFlags(1);
            baseIntentWithActionSendMultiple.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            baseIntentWithActionSendMultiple.putStringArrayListExtra(Constants.KEY_COVER_SUMMARY_FOR_SHARE, arrayList3);
            return ShareIntentCreationHelper.createChooserIntentCompat(context, baseIntentWithActionSendMultiple, null, shareCaller);
        } catch (InterruptedException e3) {
            MainLogger.m7255e(TAG, "shareSDoc# " + e3.getMessage());
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
