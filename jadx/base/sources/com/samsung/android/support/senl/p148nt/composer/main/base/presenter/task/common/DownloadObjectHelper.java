package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.web.WebCardData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.AudioUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadObjectHelper {
    private static final String TAG = Logger.createTag("DownloadObjectHelper");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadAudioTask implements Callable<Boolean> {
        private static final String TAG = Logger.createTag("DownloadAudioTask");
        Content.Audio mContent;
        Context mContext;

        public DownloadAudioTask(Context context, Content.Audio audio) {
            this.mContext = context;
            this.mContent = audio;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Throwable {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            try {
                String audioFileName = AudioUtil.getAudioFileName(this.mContext, this.mContent.getUri());
                if (TextUtils.isEmpty(audioFileName)) {
                    Logger.m11000e(TAG, "DownloadAudioTask# title is empty.");
                } else {
                    this.mContent.setTitle(AudioUtil.getFilenameWithoutExtension(audioFileName));
                    Content.Audio audio = this.mContent;
                    audio.setPath(AudioUtil.getAudioFilePath(audio.getPath(), this.mContent.getTitle(), false));
                    if (UriFileUtils.saveUriToFile(this.mContext, this.mContent.getUri(), this.mContent.getPath())) {
                        if (!new File(this.mContent.getPath()).exists()) {
                            Logger.m11000e(TAG, "DownloadAudioTask# file is not exist.");
                        } else if (AudioUtil.isSupportedAudio(this.mContent.getPath())) {
                            z = true;
                        } else {
                            Logger.m11000e(TAG, "DownloadAudioTask# not supported audio file.");
                        }
                    }
                }
            } catch (Exception e) {
                Logger.m11001e(TAG, "DownloadAudioTask# exception ", e);
            }
            if (!z) {
                this.mContent.setError(256);
                this.mContent.setPath("");
            }
            String str = TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("DownloadAudioTask# result - ", " ", z);
            sbM3200j.append(System.currentTimeMillis() - jCurrentTimeMillis);
            Logger.m11003i(str, sbM3200j.toString());
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadGifTask implements Callable<Boolean> {
        Content.Image mContent;
        Context mContext;

        public DownloadGifTask(Context context, Content.Image image) {
            this.mContext = context;
            this.mContent = image;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zDownloadGif = this.mContent.downloadGif(this.mContext);
            String str = DownloadObjectHelper.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("DownloadGifTask# result - ", " ", zDownloadGif);
            sbM3200j.append(System.currentTimeMillis() - jCurrentTimeMillis);
            Logger.m11003i(str, sbM3200j.toString());
            if (!zDownloadGif) {
                this.mContent.setError(256);
                this.mContent.setPath("");
            }
            return Boolean.valueOf(zDownloadGif);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadImageTask implements Callable<Boolean> {
        Content.Image mContent;
        Context mContext;

        public DownloadImageTask(Context context, Content.Image image) {
            this.mContext = context;
            this.mContent = image;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zDownload = this.mContent.download(this.mContext);
            String str = DownloadObjectHelper.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("DownloadImageTask# result - ", " ", zDownload);
            sbM3200j.append(System.currentTimeMillis() - jCurrentTimeMillis);
            Logger.m11003i(str, sbM3200j.toString());
            if (!zDownload) {
                this.mContent.setError(256);
                this.mContent.setPath("");
            }
            return Boolean.valueOf(zDownload);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadWebCardTask implements Callable<Boolean> {
        String mCachePath;
        Content.WebCard mContent;
        Context mContext;
        boolean mIsEnabledPreview;

        public DownloadWebCardTask(Context context, Content.WebCard webCard, String str, boolean z) {
            this.mContext = context;
            this.mContent = webCard;
            this.mCachePath = str;
            this.mIsEnabledPreview = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            boolean z;
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                WebCardData webCardDataCreateWebCard = WebCardData.createWebCard(this.mContext, this.mContent.getUrl(), this.mCachePath, this.mIsEnabledPreview);
                this.mContent.setPath(webCardDataCreateWebCard.getPath());
                this.mContent.setTitle(webCardDataCreateWebCard.getTitle());
                this.mContent.setDescription(webCardDataCreateWebCard.getDescription());
                this.mContent.setImageTypeId(webCardDataCreateWebCard.getImageTypeId());
                this.mContent.setBgColor(webCardDataCreateWebCard.getBackgroundColor());
                this.mContent.setFailed(webCardDataCreateWebCard.isFailed());
                z = true;
            } catch (Exception e) {
                Logger.m11001e(DownloadObjectHelper.TAG, e.getMessage(), e);
                z = false;
            }
            String str = DownloadObjectHelper.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("DownloadWebCardTask# result - ", " ", z);
            sbM3200j.append(System.currentTimeMillis() - jCurrentTimeMillis);
            Logger.m10999d(str, sbM3200j.toString());
            return Boolean.valueOf(z);
        }
    }
}
