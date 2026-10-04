package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadObjectHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionSendHelperMultiple extends ActionSendHelperCommon {
    public static final int ERROR_VIDEO = 1;
    private static final String TAG = Logger.createTag("ActionSendHelperMultiple");
    private final List<Uri> mPdfUriList;
    private final List<Uri> mTextUriList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SolveImage extends Content.Image {
        private RectF mRect;

        public SolveImage(Uri uri, String str) {
            super(uri, str);
            this.mRect = null;
            this.mType = 1;
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.Image, com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(Content.ConvertContract convertContract) {
            SpenObjectImage spenObjectImage = new SpenObjectImage();
            spenObjectImage.setImage(getPath());
            RectF rectF = this.mRect;
            if (rectF != null) {
                spenObjectImage.setRect(rectF, false);
            }
            return spenObjectImage;
        }

        public void setRect(RectF rectF) {
            this.mRect = rectF;
        }
    }

    public ActionSendHelperMultiple(@NonNull String str) {
        super(str);
        this.mPdfUriList = new ArrayList();
        this.mTextUriList = new ArrayList();
    }

    private void handleAudio(Context context, Intent intent) {
        ArrayList parcelableArrayListExtra;
        String action = intent.getAction();
        Logger.m10999d(TAG, "handleSendAudio, action: " + action);
        ArrayList arrayList = new ArrayList();
        if ("android.intent.action.SEND".equals(action)) {
            arrayList.add((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"));
        } else if ("android.intent.action.SEND_MULTIPLE".equals(action) && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM")) != null) {
            arrayList.addAll(parcelableArrayListExtra);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            makeAudioContent(context, (Uri) it.next());
        }
        this.mContentList.add(new Content.Text(getText(intent)));
    }

    private int handleMultiple(Context context, Intent intent) {
        ArrayList<Uri> parcelableArrayListExtra;
        String text = getText(intent);
        if (!TextUtils.isEmpty(text)) {
            this.mContentList.add(new Content.Text(text));
        }
        if (intent.getParcelableArrayListExtra("android.intent.extra.STREAM") != null) {
            parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"));
            parcelableArrayListExtra = arrayList;
        }
        int i = 0;
        if (parcelableArrayListExtra == null) {
            return 0;
        }
        String type = intent.getType();
        Boolean boolValueOf = null;
        for (Uri uri : parcelableArrayListExtra) {
            String mimeType = UriFileUtils.getMimeType(context, uri);
            if (this.mDownloadObjList.size() >= 100) {
                return i | 512;
            }
            if (mimeType == null || TextUtils.isEmpty(mimeType)) {
                if (boolValueOf == null) {
                    boolValueOf = Boolean.valueOf(SettingsCompat.getInstance().isAutoBlocking(context));
                }
                if (boolValueOf.booleanValue() && type != null && type.startsWith(Constants.MIME_IMAGE_START)) {
                    makeImageContent(context, uri, mimeType);
                } else {
                    i |= 256;
                    AbstractC8014b.m7196B("handleImages# ", mimeType, TAG);
                }
            } else if (mimeType.startsWith(Constants.MIME_IMAGE_START) || mimeType.equals(Constants.MIME_IMAGE_DIR)) {
                makeImageContent(context, uri, mimeType);
            } else if (mimeType.startsWith(Constants.MIME_AUDIO_START) || mimeType.equals(Constants.MIME_AUDIO_DIR)) {
                makeAudioContent(context, uri);
            } else if (mimeType.startsWith(Constants.MIME_PDF)) {
                this.mPdfUriList.add(uri);
            } else if (mimeType.startsWith("text/plain")) {
                this.mTextUriList.add(uri);
            } else if (mimeType.startsWith(Constants.MIME_VIDEO_START)) {
                i |= 1;
            } else {
                i |= 256;
                Logger.m10999d(TAG, "handleSendMultipleImages, " + mimeType + " not supported mime type.");
            }
        }
        return i;
    }

    private void makeAudioContent(Context context, Uri uri) {
        Content.Audio audio = new Content.Audio(uri, this.mCachePath);
        this.mContentList.add(audio);
        this.mDownloadObjList.add(audio);
        this.mCallableList.add(new DownloadObjectHelper.DownloadAudioTask(context, audio));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperCommon
    public void clear() {
        super.clear();
        this.mPdfUriList.clear();
    }

    public List<Uri> getPdfUriList() {
        return this.mPdfUriList;
    }

    public List<Uri> getTextUriList() {
        return this.mTextUriList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperCommon
    public int handleIntent(Context context, Intent intent) {
        String type = intent.getType();
        if (type == null || !type.startsWith(Constants.MIME_AUDIO_START)) {
            return handleMultiple(context, intent);
        }
        handleAudio(context, intent);
        return 0;
    }

    public boolean hasPdfUriList() {
        List<Uri> list = this.mPdfUriList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean hasTextUriList() {
        List<Uri> list = this.mTextUriList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean hasUriList() {
        return hasPdfUriList() || hasTextUriList();
    }

    public void makeImageContent(Context context, Uri uri, String str) {
        Logger.m10999d(TAG, "handleSendImage, imageUri: " + uri + ", mimeType: " + str);
        String imageExtension = FileExtensions.getImageExtension(uri, str);
        Content.Image image = new Content.Image(uri, AbstractC0622a.m1170p(this.mCachePath, FileExtensions.getFileNameByTime(String.valueOf(this.mContentList.size()), imageExtension), new StringBuilder()));
        image.setMimeType(str);
        Callable<Boolean> downloadGifTask = Constants.THUMBNAIL_GIF_EXTENSION.equals(imageExtension) ? new DownloadObjectHelper.DownloadGifTask(context, image) : new DownloadObjectHelper.DownloadImageTask(context, image);
        this.mContentList.add(image);
        this.mDownloadObjList.add(image);
        this.mCallableList.add(downloadGifTask);
    }
}
