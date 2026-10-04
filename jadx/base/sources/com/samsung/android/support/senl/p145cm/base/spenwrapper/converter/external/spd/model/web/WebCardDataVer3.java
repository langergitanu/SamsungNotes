package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.utils.ImageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebCardDataVer3;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebCardDataBase;", "<init>", "()V", "toString", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WebCardDataVer3 extends WebCardDataBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$WebCardData";
    public static final int THUMBNAIL_COMPRESS_HIGH_QUALITY = 100;
    public static final int THUMBNAIL_COMPRESS_QUALITY = 95;

    @NotNull
    public static final String THUMBNAIL_EXTENSION = "jpg";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebCardDataVer3$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "THUMBNAIL_COMPRESS_QUALITY", "", "THUMBNAIL_COMPRESS_HIGH_QUALITY", "THUMBNAIL_EXTENSION", "createWebCard", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebCardDataVer3;", "url", "cachePath", "isPreviewOn", "", "screenMinSize", "", "fileNameByTime", "getFileNameByTime", "()Ljava/lang/String;", "downloadImage", "Landroid/graphics/Bitmap;", "urlStr", "timeout", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bitmap downloadImage(String urlStr, int timeout) {
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(WebCardDataVer3.TAG, "downloadImage");
            try {
                HttpURLConnection connection = WebConstructor.getConnection(urlStr);
                if (connection == null) {
                    return null;
                }
                connection.setConnectTimeout(timeout);
                connection.setReadTimeout(timeout);
                try {
                    InputStream inputStream = connection.getInputStream();
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                        companion.m7132d(WebCardDataVer3.TAG, "downloadImage, bitmap: " + bitmapDecodeStream);
                        CloseableKt.closeFinally(inputStream, null);
                        return bitmapDecodeStream;
                    } finally {
                    }
                } catch (IOException e) {
                    LoggerBase.INSTANCE.m7134e(WebCardDataVer3.TAG, "downloadImage IOException : ", e);
                }
            } catch (Exception e2) {
                LoggerBase.INSTANCE.m7134e(WebCardDataVer3.TAG, "downloadImage", e2);
            }
            return null;
        }

        private final String getFileNameByTime() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("_yyMMdd_HHmmss_SSS_", Locale.ENGLISH);
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String strSubstring = string.substring(string.length() - 3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return AbstractC0541b.m774p("web", simpleDateFormat.format(new Date()), strSubstring, ".jpg");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        @NotNull
        public final WebCardDataVer3 createWebCard(@Nullable String url, @Nullable String cachePath, boolean isPreviewOn, float screenMinSize) {
            String str;
            String str2;
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(WebCardDataVer3.TAG, "createWebCard");
            String str3 = null;
            WebCardDataVer3 webCardDataVer3 = new WebCardDataVer3(null == true ? 1 : 0);
            webCardDataVer3.setUrl(String.valueOf(url));
            String str4 = cachePath + getFileNameByTime();
            webCardDataVer3.setImageTypeId(0);
            String str5 = "";
            if (isPreviewOn) {
                str = url;
                LinkSourceContentVer3 linkSourceContentVer3MakePreview = new TextCrawlerVer3().makePreview(str);
                String title = linkSourceContentVer3MakePreview.getTitle();
                if (TextUtils.isEmpty(title)) {
                    companion.m7132d(WebCardDataVer3.TAG, "createWebCard, title is empty.");
                    title = "";
                }
                webCardDataVer3.setTitle(title);
                String description = linkSourceContentVer3MakePreview.getDescription();
                if (TextUtils.isEmpty(description)) {
                    companion.m7132d(WebCardDataVer3.TAG, "createWebCard, desc is empty.");
                    description = "";
                }
                webCardDataVer3.setDescription(description);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (linkSourceContentVer3MakePreview.getImages().size() > 0) {
                    String str6 = linkSourceContentVer3MakePreview.getImages().get(0);
                    Intrinsics.checkNotNull(str6);
                    String str7 = str6;
                    if (!TextUtils.isEmpty(str7)) {
                        linkedHashMap.put(str7, 1);
                    }
                }
                linkedHashMap.put(Uri.parse(str).buildUpon().path("favicon.ico").build().toString(), 2);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str8 = (String) entry.getKey();
                    int iIntValue = ((Number) entry.getValue()).intValue();
                    Bitmap bitmapDownloadImage = downloadImage(str8, 8000);
                    if (bitmapDownloadImage != null) {
                        str2 = str5;
                        if (((int) Math.min(bitmapDownloadImage.getWidth(), bitmapDownloadImage.getHeight())) >= 48) {
                            Bitmap bitmapResizeBitmapImage = ImageUtils.resizeBitmapImage(bitmapDownloadImage, (int) (0.5f * screenMinSize));
                            if (bitmapResizeBitmapImage != null) {
                                ImageUtils.saveBitmapToFileCache(bitmapResizeBitmapImage, str4, Bitmap.CompressFormat.JPEG, 95, 0);
                                bitmapResizeBitmapImage.recycle();
                                if (AbstractC2322a.m1607A(str4)) {
                                    webCardDataVer3.setImageUrl(str8);
                                    webCardDataVer3.setImageTypeId(iIntValue);
                                    str3 = str4;
                                    break;
                                }
                            }
                        } else {
                            bitmapDownloadImage.recycle();
                        }
                        str5 = str2;
                    }
                }
            } else {
                str = url;
            }
            str2 = str5;
            if (TextUtils.isEmpty(str3)) {
                webCardDataVer3.setImageTypeId(0);
                ImageUtils.saveBitmapToFileCache(new LetterTileProvider().getLetterTile(WebCardDataBase.getFirstChar(str), 768, VUtilString.GRAY), str4, Bitmap.CompressFormat.JPEG, 100, 0);
                if (new File(str4.toString()).exists()) {
                    LoggerBase.INSTANCE.m7132d(WebCardDataVer3.TAG, "createWebCard, set tile letter image.");
                    String string = Uri.fromFile(new File(str4.toString())).toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    webCardDataVer3.setImageUrl(string);
                    webCardDataVer3.setImageTypeId(2);
                } else {
                    str4 = str2;
                }
            } else {
                str4 = str3;
            }
            Intrinsics.checkNotNull(str4);
            webCardDataVer3.setPath(str4);
            return webCardDataVer3;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WebCardDataVer3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final WebCardDataVer3 createWebCard(@Nullable String str, @Nullable String str2, boolean z, float f) {
        return INSTANCE.createWebCard(str, str2, z, f);
    }

    @NotNull
    public String toString() {
        String string = toStringBuilder().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private WebCardDataVer3() {
    }
}
