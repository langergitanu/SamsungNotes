package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CreateIntentForPicker {
    public static final int CALENDAR_SHARE_IMAGE_SIZE_DP = 68;
    private static final String TAG = Logger.createTag("CreateIntentForPicker");
    private boolean mIsCanceled;
    private final MakeUriHelper mMakeUriHelper;
    private final ShareCacheHelper mShareCacheHelper;
    private final ShareUriHelper mShareUriHelper;

    public CreateIntentForPicker() {
        ShareCacheHelper shareCacheHelper = new ShareCacheHelper();
        this.mShareCacheHelper = shareCacheHelper;
        this.mShareUriHelper = new ShareUriHelper(shareCacheHelper);
        this.mMakeUriHelper = new MakeUriHelper(shareCacheHelper);
        this.mIsCanceled = false;
    }

    private void createHtmlFile(Context context, SpenWNote spenWNote, ArrayList<Uri> arrayList, String str) {
        File fileCreateHtmlFile = ShareHtmlFile.createHtmlFile(context, str);
        if (fileCreateHtmlFile == null || !fileCreateHtmlFile.exists()) {
            return;
        }
        Uri contextShareUri = this.mShareUriHelper.getContextShareUri(LockUtils.isLocked(spenWNote), context, fileCreateHtmlFile.getAbsolutePath(), UUID.randomUUID().toString(), null);
        if (contextShareUri != null) {
            arrayList.add(contextShareUri);
        }
    }

    private void handleDrawRect(Context context, SpenWNote spenWNote, ShareData shareData, ArrayList<Uri> arrayList, ArrayList<Integer> arrayList2) {
        if (hasDrawRect(spenWNote)) {
            ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareCacheHelper.getContextShareDir(context, LockUtils.isLocked(spenWNote));
            if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                return;
            }
            ArrayList<Uri> contextShareUri = this.mShareUriHelper.getContextShareUri(context, this.mMakeUriHelper.makeImage(context, spenWNote, ShareUtils.generateNewFilePath(contextShareDir.mDir, shareData.getTitle(), shareData.getLastModifiedTime(), "jpg")), contextShareDir.mUseFileProvider, Constants.MIME_IMAGE);
            if (contextShareUri == null || contextShareUri.isEmpty()) {
                return;
            }
            arrayList.addAll(contextShareUri);
            arrayList2.add(3);
        }
    }

    private void handleText(SpenWNote spenWNote, StringBuilder sb, ArrayList<Integer> arrayList) {
        Pair<StringBuilder, CharSequence> pairExportText = this.mMakeUriHelper.exportText(spenWNote);
        if (TextUtils.isEmpty((CharSequence) pairExportText.second)) {
            return;
        }
        sb.append((CharSequence) pairExportText.first);
        arrayList.add(2);
    }

    private void handleVoice(Context context, SpenWNote spenWNote, ArrayList<Uri> arrayList, ArrayList<Integer> arrayList2, String str) {
        boolean zIsLocked = LockUtils.isLocked(spenWNote);
        HandleVoice handleVoice = new HandleVoice(this.mShareUriHelper);
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList != null) {
            Iterator<SpenVoiceData> it = voiceDataList.iterator();
            while (it.hasNext()) {
                Context context2 = context;
                handleVoice.handleVoiceData(context2, arrayList, it.next(), zIsLocked, str);
                arrayList2.add(10);
                context = context2;
            }
        }
        Context context3 = context;
        handleVoiceContent(context3, arrayList, arrayList2, zIsLocked, spenWNote.getBodyObjectList(512));
        Iterator<SpenWPage> it2 = spenWNote.getPageList().iterator();
        while (it2.hasNext()) {
            handleVoiceContent(context3, arrayList, arrayList2, zIsLocked, it2.next().getObjectList(512));
        }
    }

    private void handleVoiceContent(Context context, ArrayList<Uri> arrayList, ArrayList<Integer> arrayList2, boolean z, ArrayList<SpenObjectBase> arrayList3) {
        if (arrayList3 == null) {
            return;
        }
        HandleVoice handleVoice = new HandleVoice(this.mShareUriHelper);
        Iterator<SpenObjectBase> it = arrayList3.iterator();
        while (it.hasNext()) {
            handleVoice.handleVoiceContent(context, arrayList, (SpenObjectVoice) it.next(), z);
            arrayList2.add(10);
        }
    }

    private boolean hasDrawRect(SpenWNote spenWNote) {
        ArrayList<SpenObjectSpan> objectSpan = spenWNote.getBodyText().getObjectSpan();
        if (objectSpan != null && !objectSpan.isEmpty()) {
            return true;
        }
        for (SpenWPage spenWPage : spenWNote.getPageList()) {
            if (!spenWPage.getDrawnRectOfAllObject().isEmpty() || spenWPage.hasPDF()) {
                return true;
            }
        }
        return false;
    }

    private void insertUriListToIntent(Context context, Intent intent, ArrayList<Uri> arrayList, String str) {
        ArrayList<Uri> arrayListCutOverMaxUriCount = this.mShareUriHelper.cutOverMaxUriCount(arrayList);
        Iterator<Uri> it = arrayListCutOverMaxUriCount.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(str, it.next(), 1);
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayListCutOverMaxUriCount);
        Logger.m10999d(TAG, "insertUriListToIntent, action: " + intent.getAction());
        intent.addFlags(1);
    }

    public void cancel() {
        Logger.m10999d(TAG, "cancel ");
        this.mIsCanceled = true;
        this.mMakeUriHelper.cancel();
    }

    public Intent createIntentNotePicker(Context context, SpenWNote spenWNote, ShareData shareData, String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        handleText(spenWNote, sb, arrayList);
        if (this.mIsCanceled) {
            return new Intent();
        }
        ArrayList<Uri> arrayList2 = new ArrayList<>();
        handleDrawRect(context, spenWNote, shareData, arrayList2, arrayList);
        handleVoice(context, spenWNote, arrayList2, arrayList, shareData.getPath());
        if (this.mIsCanceled) {
            return new Intent();
        }
        Intent intent = new Intent();
        String text = spenWNote.getTitle().getText();
        if (!TextUtils.isEmpty(text)) {
            intent.putExtra("android.intent.extra.SUBJECT", text);
        }
        String strTrim = sb.toString().trim();
        String shareType = ShareUtils.getShareType(arrayList);
        if (TextUtils.isEmpty(strTrim) || strTrim.length() < 150000) {
            intent.putExtra("android.intent.extra.TEXT", TextUtils.isEmpty(strTrim) ? "" : strTrim);
        } else {
            createHtmlFile(context, spenWNote, arrayList2, strTrim);
            shareType = "text/plain".equals(shareType) ? Constants.MIME_HTML : "*/*";
        }
        if ("text/plain".equals(shareType) && !TextUtils.isEmpty(text) && TextUtils.isEmpty(strTrim)) {
            intent.removeExtra("android.intent.extra.SUBJECT");
            intent.putExtra("android.intent.extra.TEXT", text);
        }
        AbstractC8014b.m7197C("createIntentNotePicker, type: ", shareType, TAG);
        insertUriListToIntent(context, intent, arrayList2, str);
        return intent;
    }

    public Intent createIntentUUIDPicker(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.SDOC_UUID, str);
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(context, 68.0f);
        Bitmap bitmapDecodeFile = !TextUtils.isEmpty(str2) ? BitmapFactory.decodeFile(str2) : null;
        int color = ResourceUtils.getColor(context, C9086R.color.composer_main_background_light);
        try {
            if (bitmapDecodeFile == null) {
                Logger.m10999d(TAG, "createIntentUUIDPicker# captureBitmap is null");
                bitmapDecodeFile = Bitmap.createBitmap(iConvertDpToPixel, iConvertDpToPixel, Bitmap.Config.ARGB_8888);
                bitmapDecodeFile.eraseColor(color);
            } else if (bitmapDecodeFile.getHeight() < iConvertDpToPixel) {
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setBackgroundColor(color);
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(bitmapDecodeFile);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(iConvertDpToPixel, iConvertDpToPixel));
                frameLayout.addView(imageView);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iConvertDpToPixel, 1073741824);
                frameLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
                bitmapDecodeFile = Bitmap.createBitmap(frameLayout.getWidth(), frameLayout.getHeight(), Bitmap.Config.ARGB_8888);
                frameLayout.draw(new Canvas(bitmapDecodeFile));
            } else {
                bitmapDecodeFile = Bitmap.createScaledBitmap(bitmapDecodeFile, iConvertDpToPixel, iConvertDpToPixel, true);
            }
            Uri contextShareUri = this.mShareUriHelper.getContextShareUri(false, context, bitmapDecodeFile, (String) null);
            if (contextShareUri != null) {
                context.grantUriPermission(str3, contextShareUri, 1);
                intent.putExtra("android.intent.extra.STREAM", contextShareUri);
                intent.addFlags(1);
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("createIntentUUIDPicker# "), TAG);
        }
        if (bitmapDecodeFile != null) {
            bitmapDecodeFile.recycle();
        }
        return intent;
    }
}
