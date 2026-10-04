package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u001a\u0010\u000e\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/FileExtensions;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "previousTimeMillis", "", "mGetFileNameByTime", "FILE_DATAFORMAT", "Ljava/text/SimpleDateFormat;", "getFileNameByTime", "prefix", BundleContract.EXTRA_DATA, "getLogText", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "context", "Landroid/content/Context;", "getImageExtension", "uri", "Landroid/net/Uri;", "mimeType", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFileExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileExtensions.kt\ncom/samsung/android/support/senl/nt/base/common/util/FileExtensions\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final class FileExtensions {

    @Nullable
    private static SimpleDateFormat FILE_DATAFORMAT = null;

    @NotNull
    private static final String TAG = "FileExtensions";
    private static long previousTimeMillis;

    @NotNull
    public static final FileExtensions INSTANCE = new FileExtensions();

    @NotNull
    private static final Object mGetFileNameByTime = new Object();

    private FileExtensions() {
    }

    @JvmStatic
    @NotNull
    public static final String getFileNameByTime(@NotNull String prefix, @NotNull String extension) {
        String str;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(extension, "extension");
        synchronized (mGetFileNameByTime) {
            while (previousTimeMillis == System.currentTimeMillis()) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    Logger.m8698e(TAG, "getFileNameByTime, e : " + e.getMessage());
                }
            }
            previousTimeMillis = System.currentTimeMillis();
            if (FILE_DATAFORMAT == null) {
                if (TextUtils.isEmpty(prefix)) {
                    FILE_DATAFORMAT = new SimpleDateFormat("yyMMdd_HHmmss_SSS.", Locale.ENGLISH);
                } else {
                    FILE_DATAFORMAT = new SimpleDateFormat("_yyMMdd_HHmmss_SSS.", Locale.ENGLISH);
                }
            }
            SimpleDateFormat simpleDateFormat = FILE_DATAFORMAT;
            str = prefix + (simpleDateFormat != null ? simpleDateFormat.format(new Date(previousTimeMillis)) : null) + extension;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getImageExtension(@NotNull Uri uri, @Nullable String mimeType) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            if (mimeType != null) {
                fileExtensionFromUrl = Constants.THUMBNAIL_GIF_EXTENSION;
                if (!StringsKt.m14162r(mimeType, Constants.THUMBNAIL_GIF_EXTENSION)) {
                    fileExtensionFromUrl = "jpg";
                }
            }
        }
        Intrinsics.checkNotNull(fileExtensionFromUrl);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = fileExtensionFromUrl.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @JvmStatic
    @Nullable
    public static final StringBuilder getLogText(@Nullable Context context) {
        List<File> logFiles = Logger.getLogFiles(context);
        if (logFiles.isEmpty()) {
            Logger.m8697d(TAG, "logText path is empty.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (File file : logFiles) {
            String name = file.getName();
            Intrinsics.checkNotNull(name);
            String strSubstring = name.substring(StringsKt.m14130D(name, '.') + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (Intrinsics.areEqual("log", strSubstring) && file.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    sb.append(line);
                                    sb.append('\n');
                                } finally {
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedReader, null);
                            CloseableKt.closeFinally(inputStreamReader, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            sb.append('\n');
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException e) {
                    Logger.m8698e(TAG, "getLogText : " + e);
                    return null;
                }
            }
        }
        return sb;
    }
}
