package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.palette.graphics.Palette;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.WebCardDataBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.LinkSourceContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WebCardData extends WebCardDataBase {
    private static final String TAG = Logger.createTag("WebCardData");
    private static final String TEXT_NULL = "null";
    private static final int TIMEOUT_DOWNLOAD_IMAGE = 8000;
    private boolean isFailed;
    private Integer mBackgroundColor;

    private WebCardData() {
    }

    public static WebCardData createWebCard(Context context, String str, String str2, boolean z) {
        Logger.m10999d(TAG, "createWebCard");
        WebCardData webCardData = new WebCardData();
        webCardData.setUrl(str);
        webCardData.setImageTypeId(0);
        String str3 = str2 + FileExtensions.getFileNameByTime("web", "jpg");
        if (z) {
            TextCrawler textCrawler = new TextCrawler();
            LinkSourceContent linkSourceContentMakePreview = textCrawler.makePreview(webCardData.getUrl());
            setBaseData(webCardData, linkSourceContentMakePreview);
            setFaviconData(context, str3, webCardData, linkSourceContentMakePreview);
            if (textCrawler.getError() != null) {
                webCardData.isFailed = true;
            }
        }
        return webCardData;
    }

    private static Bitmap downloadImage(String str) {
        String str2 = TAG;
        AbstractC8014b.m7196B("downloadImage, url: ", str, str2);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    Logger.m10999d(str2, "downloadImage, bitmap: " + bitmapDecodeStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                Logger.m11001e(TAG, "downloadImage# IOException : ", e);
                return null;
            }
        } catch (Exception e2) {
            Logger.m11001e(TAG, "downloadImage# Exception : ", e2);
            return null;
        }
    }

    private static int extractColor(Bitmap bitmap) {
        return Palette.from(bitmap).generate().getDominantColor(0);
    }

    private static void setBaseData(WebCardData webCardData, LinkSourceContent linkSourceContent) {
        String title = linkSourceContent.getTitle();
        String str = "";
        if (TextUtils.isEmpty(title) || TEXT_NULL.equalsIgnoreCase(title)) {
            Logger.m10999d(TAG, "createWebCard, title is empty.");
            title = "";
        }
        webCardData.setTitle(title);
        String description = linkSourceContent.getDescription();
        if (TextUtils.isEmpty(description) || TEXT_NULL.equalsIgnoreCase(description)) {
            Logger.m10999d(TAG, "createWebCard, desc is empty.");
        } else {
            str = description;
        }
        webCardData.setDescription(str);
    }

    private static void setFaviconData(Context context, String str, WebCardData webCardData, LinkSourceContent linkSourceContent) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!linkSourceContent.getImages().isEmpty()) {
            String str2 = linkSourceContent.getImages().get(0);
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap.put(str2, 1);
            }
        }
        linkedHashMap.put(Uri.parse(webCardData.getUrl()).buildUpon().path("favicon.ico").build().toString(), 2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str3 = (String) entry.getKey();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            Bitmap bitmapDownloadImage = downloadImage(str3);
            if (bitmapDownloadImage != null) {
                if (Math.min(bitmapDownloadImage.getWidth(), bitmapDownloadImage.getHeight()) < 48) {
                    bitmapDownloadImage.recycle();
                } else {
                    Bitmap bitmapResizeBitmapImage = ImageUtil.resizeBitmapImage(bitmapDownloadImage, (int) (DisplayUtils.getScreenMinSize(context) * 0.5f));
                    if (bitmapResizeBitmapImage == null) {
                        continue;
                    } else {
                        ImageUtil.saveBitmapToFileCache(bitmapResizeBitmapImage, str, Bitmap.CompressFormat.JPEG, 95);
                        boolean zExists = new File(str).exists();
                        Integer numValueOf = zExists ? Integer.valueOf(extractColor(bitmapResizeBitmapImage)) : null;
                        bitmapResizeBitmapImage.recycle();
                        if (zExists) {
                            webCardData.setPath(str);
                            webCardData.setImageUrl(str3);
                            webCardData.setImageTypeId(iIntValue);
                            webCardData.setBackgroundColor(numValueOf);
                            return;
                        }
                    }
                }
            }
        }
    }

    public Integer getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean isFailed() {
        return this.isFailed;
    }

    public void setBackgroundColor(Integer num) {
        this.mBackgroundColor = num;
    }

    @NonNull
    public String toString() {
        StringBuilder stringBuilder = toStringBuilder();
        stringBuilder.append(", url: ");
        stringBuilder.append(getUrl());
        return stringBuilder.toString();
    }
}
