package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\b\u0010%\u001a\u00020\u001aH\u0002J\u0006\u0010&\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0011¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/ConvertUtils;", "", "<init>", "()V", "STT_FILE", "", "STT_CONVERT_TEMP_FOLDER", SearchConstants.TargetContents.TAG, "lock", "Ljava/lang/Object;", "isLocking", "", "()Z", "setLocking", "(Z)V", "sttCacheDir", "getSttCacheDir", "()Ljava/lang/String;", "sttFastConvertCacheDir", "getSttFastConvertCacheDir$annotations", "getSttFastConvertCacheDir", "makeSttCacheFilePath", "session", "pcmFileIndex", "", "cleanSTTCacheFolder", "", "deleteFileInFolder", "dir", "Ljava/io/File;", "getVoiceSavedDataTempFile", "voicePath", "getSessionID", "item", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "lockCacheFolder", "unlockCacheFolder", "waitCacheFolder", "isCacheFolderLocked", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConvertUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConvertUtils.kt\ncom/samsung/android/support/senl/nt/stt/base/audio/ConvertUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,140:1\n739#2,9:141\n37#3:150\n36#3,3:151\n*S KotlinDebug\n*F\n+ 1 ConvertUtils.kt\ncom/samsung/android/support/senl/nt/stt/base/audio/ConvertUtils\n*L\n99#1:141,9\n100#1:150\n100#1:151,3\n*E\n"})
public final class ConvertUtils {
    private static boolean isLocking;

    @NotNull
    public static final ConvertUtils INSTANCE = new ConvertUtils();

    @NotNull
    private static final String STT_FILE = "/voice_note.stt";

    @NotNull
    private static final String STT_CONVERT_TEMP_FOLDER = "fast_convert";

    @NotNull
    private static final String TAG = "ConvertUtils";

    @NotNull
    private static final Object lock = new Object();

    private ConvertUtils() {
    }

    @JvmStatic
    public static final void cleanSTTCacheFolder() {
        ConvertUtils convertUtils = INSTANCE;
        convertUtils.waitCacheFolder();
        File file = new File(getSttFastConvertCacheDir());
        if (file.exists()) {
            if (convertUtils.deleteFileInFolder(file)) {
                Logger.m12710d(TAG, "cleanCacheFolder success");
            } else {
                Logger.m12710d(TAG, "cannot cleanCacheFolder");
            }
        }
    }

    private final boolean deleteFileInFolder(File dir) {
        try {
            File[] fileArrListFiles = dir.listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    File file = (File) it.next();
                    Intrinsics.checkNotNull(file);
                    deleteFileInFolder(file);
                }
            }
            return dir.delete();
        } catch (Exception e) {
            Logger.m12711e(TAG, String.valueOf(e.getMessage()));
            return false;
        }
    }

    @JvmStatic
    @Nullable
    public static final String getSessionID(@Nullable SpenVoiceData item) {
        List listEmptyList;
        if (item == null || item.getAttachedFile() == null) {
            return null;
        }
        String absolutePath = new File(item.getAttachedFile()).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String strM14139M = StringsKt.m14139M(absolutePath, "/", "");
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        String packageName = applicationContext.getPackageName();
        Intrinsics.checkNotNull(packageName);
        List<String> listSplit = new Regex(packageName).split(strM14139M, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        return strArr.length == 2 ? strArr[1] : strM14139M;
    }

    private final String getSttCacheDir() {
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        File externalFilesDir = applicationContext.getExternalFilesDir(null);
        Intrinsics.checkNotNull(externalFilesDir);
        return AbstractC0541b.m757C(externalFilesDir.getPath(), File.separator, STTConstant.STT_CACHE_FOLDER_NAME);
    }

    @NotNull
    public static final String getSttFastConvertCacheDir() {
        return AbstractC0541b.m757C(INSTANCE.getSttCacheDir(), File.separator, STT_CONVERT_TEMP_FOLDER);
    }

    @JvmStatic
    @Nullable
    public static final File getVoiceSavedDataTempFile(@Nullable String voicePath) {
        if (voicePath == null) {
            return null;
        }
        File file = new File(voicePath);
        File file2 = new File(getSttFastConvertCacheDir());
        if (file2.exists() && file2.isFile() && file2.delete()) {
            Logger.m12710d(TAG, "getVoiceSavedDataTempFile# cacheDir as file");
        }
        if (file2.mkdirs()) {
            Logger.m12710d(TAG, "getVoiceSavedDataTempFile# make cacheDir");
        }
        return new File(file2, file.getName());
    }

    @JvmStatic
    @NotNull
    public static final String makeSttCacheFilePath(@NotNull String session, int pcmFileIndex) {
        Intrinsics.checkNotNullParameter(session, "session");
        String sttFastConvertCacheDir = getSttFastConvertCacheDir();
        String str = File.separator;
        String strM1622l = AbstractC2322a.m1622l(sttFastConvertCacheDir, str, "pcm_temp", str, session);
        String str2 = TAG;
        Logger.m12713i(str2, "makeSttCacheFilePath " + strM1622l);
        File file = new File(strM1622l);
        if (!file.isDirectory() && file.mkdirs()) {
            Logger.m12713i(str2, "makeSttCacheFilePath success");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC11014a.m12323h(new Object[]{AbstractC0541b.m756B(strM1622l, STT_FILE), Integer.valueOf(pcmFileIndex)}, 2, Locale.US, "%s%2$03d", "format(...)");
    }

    private final void waitCacheFolder() {
        Object obj = lock;
        synchronized (obj) {
            try {
                if (isLocking) {
                    String str = TAG;
                    Logger.m12713i(str, "waitCacheFolder# is waiting, isLocking: true");
                    obj.wait(1000L);
                    Logger.m12713i(str, "waitCacheFolder# waiting time out");
                    isLocking = false;
                }
                Logger.m12713i(TAG, "waitCacheFolder# no need to waiting, isLocking: false");
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isCacheFolderLocked() {
        boolean z;
        synchronized (lock) {
            z = isLocking;
        }
        return z;
    }

    public final boolean isLocking() {
        return isLocking;
    }

    public final void lockCacheFolder() {
        Object obj = lock;
        synchronized (obj) {
            isLocking = true;
            obj.notify();
            Logger.m12713i(TAG, "lockCacheFolder# locked success");
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setLocking(boolean z) {
        isLocking = z;
    }

    public final void unlockCacheFolder() {
        Object obj = lock;
        synchronized (obj) {
            isLocking = false;
            obj.notify();
            Logger.m12713i(TAG, "unlockCacheFolder# unlocked success");
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static /* synthetic */ void getSttFastConvertCacheDir$annotations() {
    }
}
