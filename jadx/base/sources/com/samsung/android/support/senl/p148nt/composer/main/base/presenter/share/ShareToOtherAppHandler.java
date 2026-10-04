package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseShareUtil;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareToOtherAppHandler {
    private static final String TAG = Logger.createTag("ShareToOtherAppHandler");
    private boolean mIsCanceled = false;
    private final MakeUriHelper mMakeUriHelper;
    private final ShareCacheHelper mShareCacheHelper;
    private final ShareUriHelper mShareUriHelper;

    public ShareToOtherAppHandler() {
        ShareCacheHelper shareCacheHelper = new ShareCacheHelper();
        this.mShareCacheHelper = shareCacheHelper;
        this.mShareUriHelper = new ShareUriHelper(shareCacheHelper);
        this.mMakeUriHelper = new MakeUriHelper(shareCacheHelper);
    }

    private Intent shareFile(Context context, ArrayList<Uri> arrayList, String str, @Nullable ShareCallbackReceiver.ShareCaller shareCaller, ShareData shareData) {
        Intent intentShareFile = shareFile(context, arrayList, str, shareCaller);
        shareData.setShareTo(intentShareFile);
        return intentShareFile;
    }

    private void startImageChooserActivity(Context context, ArrayList<String> arrayList, int i, boolean z, ShareData shareData) {
        ArrayList<Uri> contextShareUri = this.mShareUriHelper.getContextShareUri(context, arrayList, z, Constants.MIME_IMAGE);
        if (contextShareUri == null || contextShareUri.isEmpty()) {
            return;
        }
        startChooserActivity(context, shareFile(context, contextShareUri, Constants.MIME_IMAGE, null, shareData), i);
    }

    private void startPdfChooserActivity(Context context, String str, ShareCacheHelper.ReturnValueForShareDir returnValueForShareDir, int i, ShareData shareData) {
        if (!TextUtils.isEmpty(str) && AbstractC2322a.m1607A(str)) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            Uri contextShareUri = this.mShareUriHelper.getContextShareUri(context, str, returnValueForShareDir.mUseFileProvider, Constants.MIME_PDF);
            if (contextShareUri != null) {
                arrayList.add(contextShareUri);
                startChooserActivity(context, shareFile(context, arrayList, Constants.MIME_PDF, null, shareData), i);
            }
        }
    }

    public void cancel() {
        Logger.m10999d(TAG, "cancel ");
        this.mIsCanceled = true;
        this.mMakeUriHelper.cancel();
    }

    public Intent createIntentToShareText(Context context, SpenWNote spenWNote, String str, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) {
        if (spenWNote == null) {
            return null;
        }
        Pair<StringBuilder, CharSequence> pairExportText = this.mMakeUriHelper.exportText(spenWNote);
        String strTrim = ((StringBuilder) pairExportText.first).toString().trim();
        CharSequence charSequence = (CharSequence) pairExportText.second;
        String str2 = TAG;
        Logger.m10999d(str2, "shared text : title = " + Logger.getLength(str) + " / content = " + Logger.getLength(strTrim));
        if (TextUtils.isEmpty(strTrim)) {
            Logger.m10999d(str2, "createIntentToShareText# title and content is empty.");
            return new Intent("android.intent.action.VIEW");
        }
        Intent baseIntentWithActionSend = ShareIntentCreationHelper.getBaseIntentWithActionSend();
        ArrayList arrayList = new ArrayList();
        String html = HtmlUtils.toHtml(SpannableString.valueOf(charSequence));
        if (!TextUtils.isEmpty(html)) {
            html = html.replace("<img src=", "<img style=\"max-width: 100%;\" src=");
        }
        if (TextUtils.isEmpty(html) || html.length() < 150000) {
            baseIntentWithActionSend.setType("text/plain");
            if (TextUtils.isEmpty(strTrim)) {
                baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", str);
            } else {
                baseIntentWithActionSend.putExtra("android.intent.extra.SUBJECT", str);
                baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", strTrim);
            }
            arrayList.add(ShareIntentCreationHelper.createIntentForEmail(str, html));
        } else {
            baseIntentWithActionSend.setType(Constants.MIME_HTML);
            if (!TextUtils.isEmpty(str)) {
                baseIntentWithActionSend.putExtra("android.intent.extra.SUBJECT", str);
            }
            Uri uriCreateTextFileUri = createTextFileUri(context, strTrim, LockUtils.isLocked(spenWNote));
            if (uriCreateTextFileUri != null) {
                baseIntentWithActionSend.putExtra("android.intent.extra.STREAM", uriCreateTextFileUri);
                baseIntentWithActionSend.addFlags(1);
            }
        }
        baseIntentWithActionSend.putExtra("exit_on_sent", true);
        return ShareIntentCreationHelper.createChooserIntentCompat(context, baseIntentWithActionSend, arrayList, shareCaller);
    }

    public Uri createTextFileUri(Context context, String str, boolean z) {
        File fileCreateHtmlFile = ShareHtmlFile.createHtmlFile(context, str);
        if (fileCreateHtmlFile == null || !fileCreateHtmlFile.exists()) {
            return null;
        }
        return this.mShareUriHelper.getContextShareUri(z, context, fileCreateHtmlFile.getAbsolutePath(), UUID.randomUUID().toString(), null);
    }

    public MakeUriHelper getMakeUriHelper() {
        return this.mMakeUriHelper;
    }

    public ShareCacheHelper getShareCacheHelper() {
        return this.mShareCacheHelper;
    }

    public ShareUriHelper getShareUriHelper() {
        return this.mShareUriHelper;
    }

    public void shareImage(Context context, SpenWNote spenWNote, ShareData shareData, int i) {
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(spenWNote));
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            Logger.m10999d(TAG, "shareImage# failed to getPathForShare");
            return;
        }
        ArrayList<String> arrayListMakeImage = this.mMakeUriHelper.makeImage(context, spenWNote, ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), "jpg"));
        if (this.mIsCanceled) {
            return;
        }
        startImageChooserActivity(context, arrayListMakeImage, i, contextShareDir.mUseFileProvider, shareData);
    }

    public void sharePageImage(Context context, final SpenWNote spenWNote, List<Integer> list, ShareData shareData, int i) {
        final ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(spenWNote));
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            Logger.m10999d(TAG, "sharePageImage# failed to getPathForShare");
            return;
        }
        final NoteCaptureControl noteCaptureControl = new NoteCaptureControl(context);
        noteCaptureControl.setWNote(spenWNote);
        final String strGenerateNewFileName = ShareUtils.generateNewFileName(shareData.getTitle(), shareData.getLastModifiedTime());
        final ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5, new SenlThreadFactory(TAG));
        ArrayList<Future> arrayList = new ArrayList();
        final HashMap map = new HashMap();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            final int iIntValue = it.next().intValue();
            arrayList.add(executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.ShareToOtherAppHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmapCapturePage;
                    SpenWPage spenWPage = (SpenWPage) pageList.get(iIntValue);
                    synchronized (ShareToOtherAppHandler.class) {
                        noteCaptureControl.setContents(spenWPage, spenWNote.getBodyText(), iIntValue);
                        bitmapCapturePage = noteCaptureControl.capturePage(1.0f);
                    }
                    String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(contextShareDir.mDir, strGenerateNewFileName + "_" + (iIntValue + 1), "jpg");
                    ShareToOtherAppHandler.this.mMakeUriHelper.makeJpg(bitmapCapturePage, strGenerateUniqueFilePath);
                    if (new File(strGenerateUniqueFilePath).exists()) {
                        map.put(Integer.valueOf(iIntValue), strGenerateUniqueFilePath);
                    }
                }
            }));
        }
        for (Future future : arrayList) {
            try {
                if (this.mIsCanceled) {
                    executorServiceNewFixedThreadPool.shutdownNow();
                    executorServiceNewFixedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
                    noteCaptureControl.close();
                    return;
                }
                future.get();
            } catch (InterruptedException e) {
                e = e;
                Logger.m10999d(TAG, "sharePageImage# fail " + e.toString());
            } catch (ExecutionException e2) {
                e = e2;
                Logger.m10999d(TAG, "sharePageImage# fail " + e.toString());
            }
        }
        TreeMap treeMap = new TreeMap(map);
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator it2 = treeMap.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
        }
        Logger.m10999d(TAG, "sharePageImage# page capture done " + arrayList2.size());
        noteCaptureControl.close();
        startImageChooserActivity(context, arrayList2, i, contextShareDir.mUseFileProvider, shareData);
    }

    public void sharePdf(Context context, SpenNotePdfExport spenNotePdfExport, int i, ShareData shareData, int i2) {
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            Logger.m10999d(TAG, "sharePdf# failed to getPathForShare");
            return;
        }
        String strMakePdf = this.mMakeUriHelper.makePdf(context, spenNotePdfExport, i, ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), Constants.PDF_EXTENSION));
        if (this.mIsCanceled) {
            return;
        }
        startPdfChooserActivity(context, strMakePdf, contextShareDir, i2, shareData);
    }

    public void sharePlainText(Context context, String str, int i) {
        Intent baseIntentWithActionSend = ShareIntentCreationHelper.getBaseIntentWithActionSend();
        baseIntentWithActionSend.setType("text/plain");
        baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", str);
        startChooserActivity(context, ShareIntentCreationHelper.createChooserIntentCompat(context, baseIntentWithActionSend, null, null), i);
    }

    public void sharePowerPoint(Context context, SpenWNote spenWNote, ShareData shareData, int i) {
        if (CommonUtil.initSpenSdk(context)) {
            ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
            if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                Logger.m10999d(TAG, "sharePowerPoint# failed to getPathForShare");
                return;
            }
            String strMakeMsPPT = this.mMakeUriHelper.makeMsPPT(context, spenWNote, shareData.getPath(), ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), Constants.PPT_EXTENSION));
            if (!this.mIsCanceled && AbstractC2322a.m1607A(strMakeMsPPT)) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Uri contextShareUri = this.mShareUriHelper.getContextShareUri(context, strMakeMsPPT, contextShareDir.mUseFileProvider, Constants.MIME_PPTX);
                if (contextShareUri != null) {
                    arrayList.add(contextShareUri);
                    startChooserActivity(context, shareFile(context, arrayList, Constants.MIME_PPTX, null, shareData), i);
                }
            }
        }
    }

    public Intent shareSDoc(Context context, @NonNull ShareData shareData, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) throws ShareException {
        Uri contextShareUri;
        Intent baseIntentWithActionSend = ShareIntentCreationHelper.getBaseIntentWithActionSend();
        baseIntentWithActionSend.setType(Constants.MIME_SDOC);
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            Logger.m10999d(TAG, "shareSDoc# failed to getPathForShare");
            return null;
        }
        String strMakeSDoc = this.mMakeUriHelper.makeSDoc(context, shareData, ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), "sdocx"));
        if (this.mIsCanceled || TextUtils.isEmpty(strMakeSDoc) || !AbstractC2322a.m1607A(strMakeSDoc) || (contextShareUri = this.mShareUriHelper.getContextShareUri(context, strMakeSDoc, contextShareDir.mUseFileProvider, Constants.MIME_SDOC)) == null) {
            return null;
        }
        baseIntentWithActionSend.putExtra("android.intent.extra.STREAM", ShareUtils.attachUserIdToAuthority(contextShareUri, UserHandleCompat.getInstance().getUserId(0)));
        baseIntentWithActionSend.addFlags(1);
        return ShareIntentCreationHelper.createChooserIntentCompat(context, baseIntentWithActionSend, null, shareCaller);
    }

    public void shareVoiceData(Context context, SpenWNote spenWNote, List<SpenVoiceData> list, String str, int i) {
        if (list.isEmpty()) {
            return;
        }
        boolean zIsLocked = LockUtils.isLocked(spenWNote);
        ArrayList<Uri> arrayList = new ArrayList<>();
        HandleVoice handleVoice = new HandleVoice(this.mShareUriHelper);
        Iterator<SpenVoiceData> it = list.iterator();
        while (it.hasNext()) {
            handleVoice.handleVoiceData(context, arrayList, it.next(), zIsLocked, str);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        startChooserActivity(context, shareFile(context, arrayList, "audio/mp4", null), i);
    }

    public void shareWord(Context context, SpenWNote spenWNote, ShareData shareData, int i) {
        if (CommonUtil.initSpenSdk(context)) {
            ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(shareData.getPath()));
            if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                Logger.m10999d(TAG, "shareWord# failed to getPathForShare");
                return;
            }
            String strMakeMsWord = this.mMakeUriHelper.makeMsWord(context, spenWNote, shareData.getPath(), ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), Constants.DOC_EXTENSION));
            if (!this.mIsCanceled && AbstractC2322a.m1607A(strMakeMsWord)) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Uri contextShareUri = this.mShareUriHelper.getContextShareUri(context, strMakeMsWord, contextShareDir.mUseFileProvider, Constants.MIME_DOCX);
                if (contextShareUri != null) {
                    arrayList.add(contextShareUri);
                    startChooserActivity(context, shareFile(context, arrayList, Constants.MIME_DOCX, null, shareData), i);
                }
            }
        }
    }

    public void startChooserActivity(Context context, final Intent intent, int i) {
        BaseShareUtil.startChooserActivity(TAG, context, intent, i, ComposerRequestCode.ShareVia.getId(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.ShareToOtherAppHandler.2
            @Override // java.lang.Runnable
            public void run() {
                Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
                if (intent2 != null) {
                    ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra(Constants.KEY_COVER_SUMMARY_FOR_SHARE);
                    String str = ShareToOtherAppHandler.TAG;
                    StringBuilder sb = new StringBuilder("startChooserActivity# cover : ");
                    sb.append(stringArrayListExtra != null ? Integer.valueOf(stringArrayListExtra.size()) : "empty");
                    Logger.m10999d(str, sb.toString());
                }
            }
        });
    }

    public Intent shareFile(Context context, ArrayList<Uri> arrayList, String str, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) {
        Intent baseIntentWithActionSendMultiple;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int userId = UserHandleCompat.getInstance().getUserId(0);
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ShareUtils.grantUriPermissionForChooser(context, ShareUtils.attachUserIdToAuthority(it.next(), userId)));
        }
        if (arrayList.size() == 1) {
            baseIntentWithActionSendMultiple = ShareIntentCreationHelper.getBaseIntentWithActionSend();
            baseIntentWithActionSendMultiple.putExtra("android.intent.extra.STREAM", arrayList2.get(0));
        } else {
            baseIntentWithActionSendMultiple = ShareIntentCreationHelper.getBaseIntentWithActionSendMultiple();
            baseIntentWithActionSendMultiple.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
        }
        baseIntentWithActionSendMultiple.setType(str);
        baseIntentWithActionSendMultiple.addFlags(1);
        if (str.equals(Constants.MIME_IMAGE)) {
            baseIntentWithActionSendMultiple.putExtra(Constants.OCF_RESOURCE_TYPE, Constants.OCF_TYPE_MEMO);
        }
        Intent intentCreateChooserIntentCompat = ShareIntentCreationHelper.createChooserIntentCompat(context, baseIntentWithActionSendMultiple, null, shareCaller);
        if ((str.equals(Constants.MIME_DOCX) || str.equals(Constants.MIME_PPTX)) && arrayList.size() == 1) {
            ShareIntentCreationHelper.insertInitialIntentWithMsOfficeApp(context, intentCreateChooserIntentCompat, arrayList.get(0), str);
        }
        return intentCreateChooserIntentCompat;
    }
}
