package com.samsung.android.sdk.pen.worddoc;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.util.LogUtil;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.util.WEndTagUtil;
import com.samsung.android.sdk.pen.worddoc.util.WLockUtil;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b)\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H\u0007J\u001c\u0010\u0019\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001c\u0010\u001b\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010 \u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\"\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020$H\u0007J\u001c\u0010%\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010'\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010(\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010)\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010*\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010+\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\fH\u0007J\u0012\u0010.\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010/\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u00100\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00101\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\u001eH\u0007J\u0012\u00103\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00104\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\u001eH\u0007J\u0012\u00105\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J$\u00106\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u00107\u001a\u0004\u0018\u00010\f2\u0006\u00108\u001a\u00020\u0005H\u0007J\u0012\u00109\u001a\u00020:2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010;\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010=\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010>\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010?\u001a\u00020@H\u0007J\u0012\u0010A\u001a\u00020@2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010B\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010C\u001a\u00020DH\u0007J\u0012\u0010E\u001a\u00020D2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010F\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010G\u001a\u00020\u001eH\u0007J\u0012\u0010H\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010I\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010J\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010K\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020NH\u0002J\u0013\u0010O\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010P\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010Q\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010R\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010S\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001d\u0010T\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001d\u0010V\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010W\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0083 J\u001d\u0010X\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010Y\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\fH\u0083 J\u001d\u0010Z\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010[\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010\\\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010]\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\t\u0010^\u001a\u00020\u0005H\u0083 J\u001b\u0010_\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u0005H\u0083 J\u0013\u0010`\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001d\u0010a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\fH\u0083 J\u0015\u0010b\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010c\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u0015\u0010e\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\u001eH\u0083 J\u0013\u0010g\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010h\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\u001eH\u0083 J\u0013\u0010i\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J%\u0010j\u001a\u00020\f2\b\u0010k\u001a\u0004\u0018\u00010\f2\b\u00107\u001a\u0004\u0018\u00010\f2\u0006\u00108\u001a\u00020\u0005H\u0083 J\u0013\u0010l\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001d\u0010m\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010n\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010o\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010?\u001a\u00020\u0005H\u0083 J\u0013\u0010p\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010q\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010C\u001a\u00020\u0005H\u0083 J\u0013\u0010r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010s\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010G\u001a\u00020\u001eH\u0083 J\u0013\u0010t\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0083 J\u001b\u0010u\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010J\u001a\u0004\u0018\u00010\fH\u0083 J\u0013\u0010v\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0083 R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006w"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWNoteFile;", "", "<init>", "()V", "sdkFormatVersion", "", "getSdkFormatVersion$annotations", "getSdkFormatVersion", "()I", "isValid", "", "filePath", "", "getOrientation", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$Orientation;", "getWidth", "getHeight", "getFormatVersion", "hasSnapSavedData", "context", "Landroid/content/Context;", "removeCache", "", "removeCacheDirectory", "count", "removeClosedCache", "removeAllClosedCache", "removeCacheByName", "searchName", "getLastModifiedTime", "", "wdocPath", "getCreatedTime", "getLastRecognizedDataModifiedTime", "setDocumentType", "type", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$DocumentType;", "lock", "password", "unlock", "isLocked", "isEncrypted", "getDocumentType", "setOwnerId", "id", "getOwnerId", "getMinFormatVersion", "getMinUnknownVersion", "getBodyTextString", "setDisplayCreatedTime", "time", "getDisplayCreatedTime", "setDisplayModifiedTime", "getDisplayModifiedTime", "getCachePath", "fileFullPath", "mode", "getPageMode", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$PageMode;", "setFixedFont", "fontName", "getFixedFont", "setFixedTextDirection", "direction", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$TextDirection;", "getFixedTextDirection", "setFixedBackgroundTheme", BaseWidgetConstant.WIDGET_THEME, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$BackgroundTheme;", "getFixedBackgroundTheme", "setServerCheckPoint", "checkPoint", "getServerCheckPoint", "setAppCustomData", "customData", "getAppCustomData", "deleteFile", "dir", "Ljava/io/File;", "WNoteFile_isValid", "WNoteFile_getOrientation", "WNoteFile_getWidth", "WNoteFile_getHeight", "WNoteFile_getFormatVersion", "WNoteFile_hasSnapSavedData", "cacheDirPath", "WNoteFile_removeCache", "WNoteFile_removeCacheDirectory", "WNoteFile_removeClosedCache", "WNoteFile_removeAllClosedCache", "WNoteFile_removeCacheByName", "WNoteFile_getLastModifiedTime", "WNoteFile_getCreatedTime", "WNoteFile_getLastRecognizedDataModifiedTime", "WNoteFile_getSdkFormatVersion", "WNoteFile_setDocumentType", "WNoteFile_getDocumentType", "WNoteFile_setOwnerId", "WNoteFile_getOwnerId", "WNoteFile_getMinFormatVersion", "WNoteFile_getMinUnknownVersion", "WNoteFile_getBodyTextString", "WNoteFile_setDisplayCreatedTime", "WNoteFile_getDisplayCreatedTime", "WNoteFile_setDisplayModifiedTime", "WNoteFile_getDisplayModifiedTime", "WNoteFile_getCachePath", "appFilesDirPath", "WNoteFile_getPageMode", "WNoteFile_setFixedFont", "WNoteFile_getFixedFont", "WNoteFile_setFixedTextDirection", "WNoteFile_getFixedTextDirection", "WNoteFile_setFixedBackgroundTheme", "WNoteFile_getFixedBackgroundTheme", "WNoteFile_setServerCheckPoint", "WNoteFile_getServerCheckPoint", "WNoteFile_setAppCustomData", "WNoteFile_getAppCustomData", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWNoteFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWNoteFile.kt\ncom/samsung/android/sdk/pen/worddoc/SpenWNoteFile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,882:1\n1#2:883\n*E\n"})
public final class SpenWNoteFile {

    @NotNull
    public static final SpenWNoteFile INSTANCE = new SpenWNoteFile();

    private SpenWNoteFile() {
    }

    @JvmStatic
    private static final native String WNoteFile_getAppCustomData(String filePath);

    @JvmStatic
    private static final native String WNoteFile_getBodyTextString(String filePath);

    @JvmStatic
    private static final native String WNoteFile_getCachePath(String appFilesDirPath, String fileFullPath, int mode);

    @JvmStatic
    private static final native long WNoteFile_getCreatedTime(String filePath);

    @JvmStatic
    private static final native long WNoteFile_getDisplayCreatedTime(String filePath);

    @JvmStatic
    private static final native long WNoteFile_getDisplayModifiedTime(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getDocumentType(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getFixedBackgroundTheme(String filePath);

    @JvmStatic
    private static final native String WNoteFile_getFixedFont(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getFixedTextDirection(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getFormatVersion(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getHeight(String filePath);

    @JvmStatic
    private static final native long WNoteFile_getLastModifiedTime(String filePath);

    @JvmStatic
    private static final native long WNoteFile_getLastRecognizedDataModifiedTime(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getMinFormatVersion(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getMinUnknownVersion(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getOrientation(String filePath);

    @JvmStatic
    private static final native String WNoteFile_getOwnerId(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getPageMode(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getSdkFormatVersion();

    @JvmStatic
    private static final native long WNoteFile_getServerCheckPoint(String filePath);

    @JvmStatic
    private static final native int WNoteFile_getWidth(String filePath);

    @JvmStatic
    private static final native boolean WNoteFile_hasSnapSavedData(String cacheDirPath, String filePath);

    @JvmStatic
    private static final native boolean WNoteFile_isValid(String filePath);

    @JvmStatic
    private static final native boolean WNoteFile_removeAllClosedCache(String cacheDirPath);

    @JvmStatic
    private static final native boolean WNoteFile_removeCache(String cacheDirPath, String filePath);

    @JvmStatic
    private static final native boolean WNoteFile_removeCacheByName(String cacheDirPath, String searchName);

    @JvmStatic
    private static final native boolean WNoteFile_removeCacheDirectory(String cacheDirPath, int count);

    @JvmStatic
    private static final native boolean WNoteFile_removeClosedCache(String cacheDirPath, String filePath);

    @JvmStatic
    private static final native boolean WNoteFile_setAppCustomData(String filePath, String customData);

    @JvmStatic
    private static final native boolean WNoteFile_setDisplayCreatedTime(String filePath, long time);

    @JvmStatic
    private static final native boolean WNoteFile_setDisplayModifiedTime(String filePath, long time);

    @JvmStatic
    private static final native boolean WNoteFile_setDocumentType(String filePath, int type);

    @JvmStatic
    private static final native boolean WNoteFile_setFixedBackgroundTheme(String filePath, int theme);

    @JvmStatic
    private static final native boolean WNoteFile_setFixedFont(String filePath, String fontName);

    @JvmStatic
    private static final native boolean WNoteFile_setFixedTextDirection(String filePath, int direction);

    @JvmStatic
    private static final native boolean WNoteFile_setOwnerId(String filePath, String id);

    @JvmStatic
    private static final native boolean WNoteFile_setServerCheckPoint(String filePath, long checkPoint);

    private final void deleteFile(File dir) throws IOException {
        File[] fileArrListFiles;
        if (dir.isDirectory() && (fileArrListFiles = dir.listFiles()) != null) {
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                File file = (File) it.next();
                Intrinsics.checkNotNull(file);
                deleteFile(file);
            }
        }
        if (!dir.delete()) {
            throw new IOException(AbstractC0541b.m773o("Fail to delete [", LogUtil.logPath(dir.getPath()), "]"));
        }
    }

    @JvmStatic
    @Nullable
    public static final String getAppCustomData(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return WNoteFile_getAppCustomData(filePath);
    }

    @JvmStatic
    @Nullable
    public static final String getBodyTextString(@Nullable String wdocPath) {
        String strWNoteFile_getBodyTextString = WNoteFile_getBodyTextString(wdocPath);
        if (strWNoteFile_getBodyTextString == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return strWNoteFile_getBodyTextString;
    }

    @JvmStatic
    @NotNull
    public static final String getCachePath(@Nullable Context context, @Nullable String fileFullPath, int mode) {
        if (context != null) {
            return WNoteFile_getCachePath(context.getFilesDir().getAbsolutePath(), fileFullPath, mode);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @JvmStatic
    public static final long getCreatedTime(@Nullable String wdocPath) {
        return WNoteFile_getCreatedTime(wdocPath);
    }

    @JvmStatic
    public static final long getDisplayCreatedTime(@Nullable String wdocPath) {
        return WNoteFile_getDisplayCreatedTime(wdocPath);
    }

    @JvmStatic
    public static final long getDisplayModifiedTime(@Nullable String wdocPath) {
        return WNoteFile_getDisplayModifiedTime(wdocPath);
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote.DocumentType getDocumentType(@Nullable String wdocPath) {
        return SpenWNote.DocumentType.values()[WNoteFile_getDocumentType(wdocPath)];
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote.BackgroundTheme getFixedBackgroundTheme(@Nullable String filePath) {
        int iWNoteFile_getFixedBackgroundTheme = WNoteFile_getFixedBackgroundTheme(filePath);
        if (iWNoteFile_getFixedBackgroundTheme < SpenWNote.BackgroundTheme.THEME_LIGHT.ordinal() || iWNoteFile_getFixedBackgroundTheme > SpenWNote.BackgroundTheme.THEME_MAX.ordinal()) {
            throw new IllegalStateException(AbstractC0541b.m767i(iWNoteFile_getFixedBackgroundTheme, "Background Theme [", "] is invalid.").toString());
        }
        return SpenWNote.BackgroundTheme.values()[iWNoteFile_getFixedBackgroundTheme];
    }

    @JvmStatic
    @NotNull
    public static final String getFixedFont(@Nullable String filePath) {
        return WNoteFile_getFixedFont(filePath);
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote.TextDirection getFixedTextDirection(@Nullable String filePath) {
        int iWNoteFile_getFixedTextDirection = WNoteFile_getFixedTextDirection(filePath);
        if (iWNoteFile_getFixedTextDirection < SpenWNote.TextDirection.TEXT_DIRECTION_LTR.ordinal() || iWNoteFile_getFixedTextDirection > SpenWNote.TextDirection.TEXT_DIRECTION_MAX.ordinal()) {
            throw new IllegalStateException(AbstractC0541b.m767i(iWNoteFile_getFixedTextDirection, "Text Direction [", "] is invalid.").toString());
        }
        return SpenWNote.TextDirection.values()[iWNoteFile_getFixedTextDirection];
    }

    @JvmStatic
    public static final int getFormatVersion(@Nullable String filePath) {
        return WNoteFile_getFormatVersion(filePath);
    }

    @JvmStatic
    public static final int getHeight(@Nullable String filePath) {
        if (filePath != null) {
            return WNoteFile_getHeight(filePath);
        }
        throw new IllegalArgumentException("filePath can not be null.");
    }

    @JvmStatic
    public static final long getLastModifiedTime(@Nullable String wdocPath) {
        return WNoteFile_getLastModifiedTime(wdocPath);
    }

    @JvmStatic
    public static final long getLastRecognizedDataModifiedTime(@Nullable String wdocPath) {
        return WNoteFile_getLastRecognizedDataModifiedTime(wdocPath);
    }

    @JvmStatic
    public static final int getMinFormatVersion(@Nullable String filePath) {
        return WNoteFile_getMinFormatVersion(filePath);
    }

    @JvmStatic
    public static final int getMinUnknownVersion(@Nullable String filePath) {
        return WNoteFile_getMinUnknownVersion(filePath);
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote.Orientation getOrientation(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        int iWNoteFile_getOrientation = WNoteFile_getOrientation(filePath);
        if (iWNoteFile_getOrientation < SpenWNote.Orientation.PORTRAIT.ordinal() || iWNoteFile_getOrientation > SpenWNote.Orientation.LANDSCAPE_NEW.ordinal()) {
            throw new IllegalStateException(AbstractC0541b.m767i(iWNoteFile_getOrientation, "Orientation [", "] is invalid.").toString());
        }
        return SpenWNote.Orientation.values()[iWNoteFile_getOrientation];
    }

    @JvmStatic
    @Nullable
    public static final String getOwnerId(@NotNull String wdocPath) {
        Intrinsics.checkNotNullParameter(wdocPath, "wdocPath");
        String strWNoteFile_getOwnerId = WNoteFile_getOwnerId(wdocPath);
        if (strWNoteFile_getOwnerId == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return strWNoteFile_getOwnerId;
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote.PageMode getPageMode(@Nullable String filePath) {
        int iWNoteFile_getPageMode = WNoteFile_getPageMode(filePath);
        if (iWNoteFile_getPageMode < SpenWNote.PageMode.LIST.ordinal() || iWNoteFile_getPageMode > SpenWNote.PageMode.SINGLE.ordinal()) {
            throw new IllegalStateException(AbstractC0541b.m767i(iWNoteFile_getPageMode, "Page Mode [", "] is invalid.").toString());
        }
        return SpenWNote.PageMode.values()[iWNoteFile_getPageMode];
    }

    public static final int getSdkFormatVersion() {
        return WNoteFile_getSdkFormatVersion();
    }

    @JvmStatic
    public static final long getServerCheckPoint(@Nullable String wdocPath) {
        return WNoteFile_getServerCheckPoint(wdocPath);
    }

    @JvmStatic
    public static final int getWidth(@Nullable String filePath) {
        if (filePath != null) {
            return WNoteFile_getWidth(filePath);
        }
        throw new IllegalArgumentException("filePath can not be null.");
    }

    @JvmStatic
    public static final boolean hasSnapSavedData(@NotNull Context context, @Nullable String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        return WNoteFile_hasSnapSavedData(context.getFilesDir().getAbsolutePath(), filePath);
    }

    @JvmStatic
    public static final boolean isEncrypted(@Nullable String filePath) {
        if (filePath == null || filePath.length() == 0) {
            throw new IllegalArgumentException("isEncrypted() - invalid argument");
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            AbstractC4539a.m3207q("isEncrypted() - the file isn't exist.[", LogUtil.logPath(filePath), "]", "WNoteFile");
            return false;
        }
        try {
            return new WEndTagUtil(filePath).isEncrypted();
        } catch (Exception e) {
            Log.i("WNoteFile", "isEncrypted() - fail to read endtag.[" + LogUtil.logPath(filePath) + "] [" + e + "]");
            return false;
        }
    }

    @JvmStatic
    public static final boolean isLocked(@Nullable String filePath) {
        if (filePath == null || filePath.length() == 0) {
            throw new IllegalArgumentException("isLocked() - invalid argument");
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            AbstractC4539a.m3207q("isLocked() - the file isn't exist.[", LogUtil.logPath(filePath), "]", "WNoteFile");
            return false;
        }
        try {
            return new WEndTagUtil(filePath).getDocumentType() != SpenWNote.DocumentType.UNLOCKED_DOC;
        } catch (Exception e) {
            Log.i("WNoteFile", "isLocked() - fail to read endtag.[" + LogUtil.logPath(filePath) + "] [" + e + "]");
            return false;
        }
    }

    @JvmStatic
    public static final boolean isValid(@Nullable String filePath) {
        return WNoteFile_isValid(filePath);
    }

    @JvmStatic
    public static final void lock(@Nullable String filePath, @Nullable String password) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Log.i("WNoteFile", "lock() [" + LogUtil.logPath(filePath) + "]");
        if (filePath.length() == 0) {
            throw new IllegalArgumentException("lock() - invalid argument1");
        }
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("lock() - invalid argument2");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException(AbstractC0541b.m773o("lock() - the file isn't exist.[", LogUtil.logPath(filePath), "]"));
        }
        WEndTagUtil wEndTagUtil = new WEndTagUtil(filePath);
        if (wEndTagUtil.getDocumentType() != SpenWNote.DocumentType.UNLOCKED_DOC || wEndTagUtil.isEncrypted()) {
            throw new IllegalStateException(AbstractC0541b.m773o("lock() - the file[", LogUtil.logPath(filePath), "] is locked already.").toString());
        }
        if (!file.isDirectory()) {
            wEndTagUtil.setDocumentType(SpenWNote.DocumentType.LOCKED_WDOC);
            wEndTagUtil.replace(filePath);
            WLockUtil.INSTANCE.encrypt(filePath, password);
            return;
        }
        String strConcat = filePath.concat(".enc");
        File file2 = new File(strConcat);
        if (file2.exists()) {
            INSTANCE.deleteFile(file2);
            if (file2.exists()) {
                throw new IOException(AbstractC0541b.m773o("lock() - fail to make file.[", LogUtil.logPath(filePath), "]"));
            }
        }
        SpenWNote.INSTANCE.makeFile(filePath, strConcat);
        WEndTagUtil wEndTagUtil2 = new WEndTagUtil(strConcat);
        wEndTagUtil2.setDocumentType(SpenWNote.DocumentType.LOCKED_WDOC);
        wEndTagUtil2.replace(strConcat);
        WLockUtil.INSTANCE.encrypt(strConcat, password);
        String str = filePath + "_" + System.currentTimeMillis() + ".bak";
        File file3 = new File(str);
        if (!file.renameTo(file3)) {
            throw new IOException(AbstractC0541b.m773o("lock() - fail to make backup.[", LogUtil.logPath(str), "]"));
        }
        if (file2.renameTo(file)) {
            INSTANCE.deleteFile(file3);
        } else {
            file3.renameTo(file);
            throw new IOException(AbstractC0541b.m773o("lock() - fail to recover backup.[", LogUtil.logPath(str), "]"));
        }
    }

    @JvmStatic
    public static final void removeAllClosedCache(@NotNull Context context) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (WNoteFile_removeAllClosedCache(context.getFilesDir().getAbsolutePath())) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void removeCacheByName(@Nullable Context context, @Nullable String searchName) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (WNoteFile_removeCacheByName(context.getFilesDir().getAbsolutePath(), searchName)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void removeCacheDirectory(@NotNull Context context, int count) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (WNoteFile_removeCacheDirectory(context.getFilesDir().getAbsolutePath(), count)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void removeClosedCache(@Nullable Context context, @Nullable String filePath) {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (WNoteFile_removeClosedCache(context.getFilesDir().getAbsolutePath(), filePath)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final boolean setAppCustomData(@NotNull String filePath, @Nullable String customData) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return WNoteFile_setAppCustomData(filePath, customData);
    }

    @JvmStatic
    public static final void setDisplayCreatedTime(@Nullable String wdocPath, long time) {
        if (WNoteFile_setDisplayCreatedTime(wdocPath, time)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void setDisplayModifiedTime(@Nullable String wdocPath, long time) {
        if (WNoteFile_setDisplayModifiedTime(wdocPath, time)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void setDocumentType(@Nullable String wdocPath, @NotNull SpenWNote.DocumentType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (WNoteFile_setDocumentType(wdocPath, type.ordinal())) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final boolean setFixedBackgroundTheme(@Nullable String filePath, @NotNull SpenWNote.BackgroundTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        return WNoteFile_setFixedBackgroundTheme(filePath, theme.ordinal());
    }

    @JvmStatic
    public static final boolean setFixedFont(@Nullable String filePath, @Nullable String fontName) {
        return WNoteFile_setFixedFont(filePath, fontName);
    }

    @JvmStatic
    public static final boolean setFixedTextDirection(@Nullable String filePath, @NotNull SpenWNote.TextDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return WNoteFile_setFixedTextDirection(filePath, direction.ordinal());
    }

    @JvmStatic
    public static final void setOwnerId(@Nullable String wdocPath, @Nullable String id) {
        if (WNoteFile_setOwnerId(wdocPath, id)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void setServerCheckPoint(@Nullable String wdocPath, long checkPoint) {
        if (WNoteFile_setServerCheckPoint(wdocPath, checkPoint)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static final void unlock(@Nullable String filePath, @Nullable String password) throws Exception {
        if (filePath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Log.i("WNoteFile", "unlock() [" + LogUtil.logPath(filePath) + "]");
        if (filePath.length() == 0) {
            throw new IllegalArgumentException("unlock() - invalid argument1");
        }
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("unlock() - invalid argument2");
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            throw new IOException(AbstractC0541b.m773o("unlock() - the file isn't exist.[", LogUtil.logPath(filePath), "]"));
        }
        WEndTagUtil wEndTagUtil = new WEndTagUtil(filePath);
        if (wEndTagUtil.getDocumentType() != SpenWNote.DocumentType.LOCKED_WDOC) {
            throw new IllegalStateException(AbstractC0541b.m773o("unlock() - the file[", LogUtil.logPath(filePath), "] is not locked.").toString());
        }
        if (wEndTagUtil.isEncrypted()) {
            try {
                WLockUtil.INSTANCE.decrypt(filePath, password);
            } catch (Exception e) {
                Log.d("WNoteFile", "unlock - decrypt fail. " + e);
                throw e;
            }
        }
        wEndTagUtil.removeEncryptionInfo();
        wEndTagUtil.setDocumentType(SpenWNote.DocumentType.UNLOCKED_DOC);
        wEndTagUtil.replace(filePath);
    }

    public final void removeCache(@Nullable Context context, @Nullable String filePath) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (WNoteFile_removeCache(context.getFilesDir().getAbsolutePath(), filePath)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmStatic
    public static /* synthetic */ void getSdkFormatVersion$annotations() {
    }
}
