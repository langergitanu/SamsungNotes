package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheMap;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0005H\u0007J\"\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0007J\u001a\u0010/\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u001a\u00100\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0005H\u0007J \u00101\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0007J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u0005042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0007J \u00105\u001a\u00020.2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0007J\u0018\u00101\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0018\u00107\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0005H\u0002J\u0012\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010\u00052\b\u0010@\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010A\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010B\u001a\u00020.H\u0007J \u0010C\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050D2\u0006\u0010>\u001a\u00020\u0005H\u0007J\u0010\u0010E\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010F\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0018\u0010G\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0018\u0010I\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0007J\u0010\u0010J\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J \u0010G\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0007J\u0010\u0010M\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0018\u0010N\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010O\u001a\u00020PH\u0002J\u0018\u0010Q\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0018\u0010T\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0007J \u0010Q\u001a\u00020.2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010U\u001a\u00020VH\u0007J\u0010\u0010W\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0018\u0010X\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Y\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0007J\u0018\u0010Z\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010O\u001a\u00020PH\u0007J\u0010\u0010[\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0012\u0010\\\u001a\u00020)2\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010]\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0007J\u001c\u0010^\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010\u00052\b\u0010`\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010a\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010b\u001a\u00020 H\u0007J\u0010\u0010c\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010d\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010e\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010f\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010g\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010h\u001a\u00020 H\u0007J\u0010\u0010i\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010j\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0018\u0010k\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010b\u001a\u00020.H\u0007J\u0010\u0010l\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010m\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010n\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010o\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010p\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0018\u0010q\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010r\u001a\u00020sH\u0007J\u0010\u0010t\u001a\u00020s2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010u\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u001a\u0010v\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\b\u0010w\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010x\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0012\u0010y\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0018\u0010z\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010{\u001a\u00020sH\u0007J\u0010\u0010|\u001a\u00020s2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010}\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010~\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010\u007f\u001a\u00020 H\u0007J\u0011\u0010\u0080\u0001\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0005H\u0007J\u0011\u0010\u0081\u0001\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "COEDIT_PREFERENCE", "PREF_UNDOWNLOADED_OBJECT_INFO", "PREF_DOWNLOAD_FILE_NAME", "PREF_DOWNLOAD_STROKE_NAME", "PREF_UNDOWNLOAD_STROKE_NAME", "PREF_LAST_UPDATE_STATE", "PREF_ABNORMAL_RELEASED", "PREF_LOCAL_CHANGED", "PREF_SNAP_UPLOADED_COMPLETED", "PREF_WORKSPACE_VERSION", "PREF_LAST_DOWNLOADED_CHECKPOINT", "PREF_CURRENT_DOCUMENT_SIZE", "PREF_DEVICE_ID", "EMPTY_STRING", "COMMA_STRING", "END_STRING", "COEDIT_DIRECTORY_NAME", "COEDIT_ROOT_DIR", "COEDIT_PREFIX", "COEDIT_UNUPLOADED_CONTENT_FILE_PREFIX", "COEDIT_FORMAT", "CURRENT_CACHE", "SUBMIT_CACHE", "UPDATE_CACHE", "TEMP_CACHE", "XML_UPDATE_START", "", "XML_UPDATE_END", "XML_UPDATE_ABNORMAL_RELEASED", "APPLY_FILE_START", "APPLY_FILE_END", "APPLY_FILE_ABNORMAL_RELEASED", "LOST_RETRY_DATA", "NOT_DEFINED_XML_DOCUMENT_SIZE", "removeComposeCoeditCache", "", "context", "Landroid/content/Context;", "uuid", "needSnap", "", "removeCoeditCache", "createCoeditCachePath", "getUnuploadedContentFileCachePath", "fileId", "getUnuploadedContentFiles", "", "removeUnuploadedContentFileCache", "contentFileCacheDir", "getUnuploadedContentFileCacheDir", "getCoeditBaseCacheDir", "removeCoeditCacheFile", "coeditCachePath", "removeBufferCacheFile", "cachePath", "addUndownloadedObjectInfo", "noteId", "objectId", "downloadSignedUrl", "removeUndownloadedObjectInfo", "isRemoveUrlOnly", "getUndownloadedObjectInfo", "", "clearUndownloadedObjectInfo", "clearDownloadedFileInfo", "saveUndownloadedStrokeInfo", "saveData", "removeUndownloadedStrokeInfo", "clearUndownloadedStrokeInfo", "getUndownloadedStrokeInfo", "objectBinaryHash", "initUndownloadedStrokeInfo", "restoreUndownloadedStrokeInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheUtils$RestoreDownloadListener;", "saveDownloadedStrokeInfo", "clearDownloadedStrokeInfo", "getDownloadedStrokeInfo", "onStrokeApplied", "strokeByte", "", "initDownloadedStrokeInfo", "restoreDownloadedStrokeInfo", "initPrefInfo", "restorePrefInfo", "deletePrefInfo", "release", "saveCoeditCache", "makePrefString", "first", "second", "setRequestUpdate", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "clearRequestUpdateCorrupted", "isRequestUpdateCorrupted", "setForceReopenState", "isLostRetryData", "setAbnormalReleased", "step", "clearAbnormalReleased", "getAbnormalReleased", "setLocalDataChanged", "clearLocalDataChanged", "isLocalDataChanged", "setSnapUploadCompleted", "clearSnapUploadCompleted", "isSnapUploadCompleted", "setWorkspaceVersion", "workspaceVersion", "", "getWorkspaceVersion", "clearWorkspaceVersion", "setDeviceId", "deviceId", "clearDeviceId", "getDeviceId", "setLastDownloadedCheckPoint", "lastDownloadedCheckPoint", "getLastDownloadedCheckPoint", "clearLastDownloadedCheckPoint", "setCurrentDocumentSize", "currentDocumentSize", "getCurrentDocumentSize", "clearCurrentDocumentSize", "RestoreDownloadListener", "CoeditContentFileNameFilter", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCoeditCacheUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoeditCacheUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/CoeditCacheUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,582:1\n739#2,9:583\n739#2,9:597\n739#2,9:610\n739#2,9:623\n739#2,9:636\n37#3:592\n36#3,3:593\n37#3:606\n36#3,3:607\n37#3:619\n36#3,3:620\n37#3:632\n36#3,3:633\n37#3:645\n36#3,3:646\n1#4:596\n*S KotlinDebug\n*F\n+ 1 CoeditCacheUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/CoeditCacheUtils\n*L\n112#1:583,9\n294#1:597,9\n299#1:610,9\n361#1:623,9\n366#1:636,9\n112#1:592\n112#1:593,3\n294#1:606\n294#1:607,3\n299#1:619\n299#1:620,3\n361#1:632\n361#1:633,3\n366#1:645\n366#1:646,3\n*E\n"})
public final class CoeditCacheUtils {
    public static final int APPLY_FILE_ABNORMAL_RELEASED = 5;
    public static final int APPLY_FILE_END = 4;
    public static final int APPLY_FILE_START = 3;

    @NotNull
    private static final String COEDIT_DIRECTORY_NAME = "coeditCache";

    @NotNull
    private static final String COEDIT_FORMAT = ".bin";

    @NotNull
    public static final String COEDIT_PREFERENCE = "Pref_Coedit";

    @NotNull
    private static final String COEDIT_PREFIX = "coeditCache_";

    @NotNull
    private static final String COEDIT_ROOT_DIR = "coedit_attach";

    @NotNull
    private static final String COEDIT_UNUPLOADED_CONTENT_FILE_PREFIX = "coeditUnuploadedContentFile_";

    @NotNull
    private static final String COMMA_STRING = ",";

    @NotNull
    private static final String CURRENT_CACHE = "c";

    @NotNull
    private static final String EMPTY_STRING = "";

    @NotNull
    private static final String END_STRING = "COEDIT;";

    @NotNull
    public static final CoeditCacheUtils INSTANCE = new CoeditCacheUtils();
    private static final int LOST_RETRY_DATA = 6;
    private static final int NOT_DEFINED_XML_DOCUMENT_SIZE = -1;

    @NotNull
    private static final String PREF_ABNORMAL_RELEASED = "_AbnormalReleased";

    @NotNull
    private static final String PREF_CURRENT_DOCUMENT_SIZE = "_documentSize";

    @NotNull
    private static final String PREF_DEVICE_ID = "_deviceId";

    @NotNull
    private static final String PREF_DOWNLOAD_FILE_NAME = "_PreDownloadFile";

    @NotNull
    private static final String PREF_DOWNLOAD_STROKE_NAME = "_PreDownloadStroke";

    @NotNull
    private static final String PREF_LAST_DOWNLOADED_CHECKPOINT = "_downloadedCheckPoint";

    @NotNull
    private static final String PREF_LAST_UPDATE_STATE = "_LastUpdateStatus";

    @NotNull
    private static final String PREF_LOCAL_CHANGED = "_localChanged";

    @NotNull
    private static final String PREF_SNAP_UPLOADED_COMPLETED = "_snapUploadCompleted";

    @NotNull
    private static final String PREF_UNDOWNLOADED_OBJECT_INFO = "_PrefUndownloadedObjectInfo";

    @NotNull
    private static final String PREF_UNDOWNLOAD_STROKE_NAME = "_PreUndownloadStroke";

    @NotNull
    private static final String PREF_WORKSPACE_VERSION = "_workspaceVersion";

    @NotNull
    private static final String SUBMIT_CACHE = "s";

    @NotNull
    public static final String TAG = "CoeditCacheUtils";

    @NotNull
    private static final String TEMP_CACHE = "t";

    @NotNull
    private static final String UPDATE_CACHE = "u";
    public static final int XML_UPDATE_ABNORMAL_RELEASED = 2;
    private static final int XML_UPDATE_END = 1;
    public static final int XML_UPDATE_START = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheUtils$CoeditContentFileNameFilter;", "Ljava/io/FilenameFilter;", "<init>", "()V", "accept", "", "dir", "Ljava/io/File;", "name", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CoeditContentFileNameFilter implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(@NotNull File dir, @NotNull String name) {
            Intrinsics.checkNotNullParameter(dir, "dir");
            Intrinsics.checkNotNullParameter(name, "name");
            return StringsKt.m14145S(name, CoeditCacheUtils.COEDIT_UNUPLOADED_CONTENT_FILE_PREFIX) && StringsKt.m14167w(name, CoeditCacheUtils.COEDIT_FORMAT);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheUtils$RestoreDownloadListener;", "", "restoreUndownloadStroke", "", "objectId", "", "objectBinaryHash", "restoreDownloadStroke", "strokeByte", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface RestoreDownloadListener {
        void restoreDownloadStroke(@Nullable String objectBinaryHash, @Nullable byte[] strokeByte);

        void restoreUndownloadStroke(@Nullable String objectId, @Nullable String objectBinaryHash);
    }

    private CoeditCacheUtils() {
    }

    @JvmStatic
    public static final synchronized void addUndownloadedObjectInfo(@NotNull String noteId, @Nullable String objectId, @Nullable String downloadSignedUrl) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Map<String, String> undownloadedObjectInfo = getUndownloadedObjectInfo(noteId);
        undownloadedObjectInfo.put(objectId, downloadSignedUrl);
        JSONObject jSONObject = new JSONObject(undownloadedObjectInfo);
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putString(noteId + PREF_UNDOWNLOADED_OBJECT_INFO, String.valueOf(jSONObject));
    }

    private final void clearAbnormalReleased(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_ABNORMAL_RELEASED);
    }

    private final void clearCurrentDocumentSize(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_CURRENT_DOCUMENT_SIZE);
    }

    private final void clearDeviceId(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_DEVICE_ID);
    }

    private final void clearDownloadedFileInfo(String noteId) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(noteId + PREF_DOWNLOAD_FILE_NAME);
    }

    private final void clearDownloadedStrokeInfo(String noteId) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(noteId + PREF_DOWNLOAD_STROKE_NAME);
    }

    private final void clearLastDownloadedCheckPoint(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_LAST_DOWNLOADED_CHECKPOINT);
    }

    private final void clearLocalDataChanged(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_LOCAL_CHANGED);
    }

    private final void clearRequestUpdateCorrupted(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_LAST_UPDATE_STATE);
    }

    private final void clearSnapUploadCompleted(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_SNAP_UPLOADED_COMPLETED);
    }

    private final void clearUndownloadedObjectInfo(String noteId) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(noteId + PREF_UNDOWNLOADED_OBJECT_INFO);
    }

    private final void clearUndownloadedStrokeInfo(String noteId) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(noteId + PREF_UNDOWNLOAD_STROKE_NAME);
    }

    private final void clearWorkspaceVersion(String uuid) {
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).remove(uuid + PREF_WORKSPACE_VERSION);
    }

    @JvmStatic
    @NotNull
    public static final String createCoeditCachePath(@Nullable Context context, @NotNull String uuid) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (context == null) {
            LoggerBase.INSTANCE.m7132d(TAG, "createCoeditCachePath# context is null");
            return "";
        }
        String coeditBaseCacheDir = INSTANCE.getCoeditBaseCacheDir(context);
        if (!FileUtils.makeDirectory(coeditBaseCacheDir)) {
            LoggerBase.INSTANCE.m7132d(TAG, "createFilePath# Failed to create directory");
            return "";
        }
        List listM13999t = AbstractC12991c.m13999t(0, COEDIT_ROOT_DIR, AbstractC0541b.m773o(COEDIT_PREFIX, uuid, COEDIT_FORMAT));
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        return AbstractC0541b.m756B(coeditBaseCacheDir, AbstractC0541b.m772n("/", StringsKt.m14139M(strArr[strArr.length - 1], "/", "")));
    }

    private final void deletePrefInfo(String noteId) {
        clearDownloadedFileInfo(noteId);
        clearDownloadedStrokeInfo(noteId);
        clearUndownloadedStrokeInfo(noteId);
        clearUndownloadedObjectInfo(noteId);
        clearRequestUpdateCorrupted(noteId);
        clearAbnormalReleased(noteId);
        clearLocalDataChanged(noteId);
    }

    @JvmStatic
    public static final int getAbnormalReleased(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getInt(uuid + PREF_ABNORMAL_RELEASED, 0);
    }

    private final String getCoeditBaseCacheDir(Context context) {
        return AbstractC0541b.m756B(context.getFilesDir().getPath(), "/coeditCache");
    }

    @JvmStatic
    public static final int getCurrentDocumentSize(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getInt(uuid + PREF_CURRENT_DOCUMENT_SIZE, -1);
    }

    @JvmStatic
    @Nullable
    public static final String getDeviceId(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getString(uuid + PREF_DEVICE_ID, "");
    }

    private final String getDownloadedStrokeInfo(String noteId) {
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getString(noteId + PREF_DOWNLOAD_STROKE_NAME, "");
    }

    @JvmStatic
    public static final long getLastDownloadedCheckPoint(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getLong(uuid + PREF_LAST_DOWNLOADED_CHECKPOINT, -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized Map<String, String> getUndownloadedObjectInfo(@NotNull String noteId) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        HashMap map = new HashMap();
        String string = SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getString(noteId + PREF_UNDOWNLOADED_OBJECT_INFO, new JSONObject().toString());
        JSONObject jSONObject = null;
        if (string != null) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                LoggerBase.INSTANCE.m7133e(TAG, "getUndownloadedObjectInfo# can not get JsonObject from Json String, JSONException: " + e.getMessage());
            }
            if (jSONObject != null) {
                return map;
            }
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (jSONObject.has(next)) {
                        Object obj = jSONObject.get(next);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        map.put(next, (String) obj);
                    }
                }
            } catch (JSONException e2) {
                LoggerBase.INSTANCE.m7133e(TAG, "getUndownloadedObjectInfo# Exception: " + e2.getMessage());
            }
            return map;
        }
        if (jSONObject != null) {
        }
    }

    private final String getUndownloadedStrokeInfo(String noteId) {
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getString(noteId + PREF_UNDOWNLOAD_STROKE_NAME, "");
    }

    private final String getUnuploadedContentFileCacheDir(Context context, String uuid) {
        return AbstractC0541b.m757C(getCoeditBaseCacheDir(context), "/", uuid);
    }

    @JvmStatic
    @NotNull
    public static final String getUnuploadedContentFileCachePath(@NotNull Context context, @NotNull String uuid, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        String unuploadedContentFileCacheDir = coeditCacheUtils.getUnuploadedContentFileCacheDir(context, uuid);
        if (FileUtils.makeDirectory(unuploadedContentFileCacheDir)) {
            return coeditCacheUtils.getUnuploadedContentFileCachePath(unuploadedContentFileCacheDir, fileId);
        }
        LoggerBase.INSTANCE.m7132d(TAG, "createCoeditContentFileCachePath# Failed to create directory");
        return "";
    }

    @JvmStatic
    @NotNull
    public static final List<String> getUnuploadedContentFiles(@NotNull Context context, @NotNull String uuid) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        String unuploadedContentFileCacheDir = INSTANCE.getUnuploadedContentFileCacheDir(context, uuid);
        ArrayList arrayList = new ArrayList();
        if (FileUtils.exists(unuploadedContentFileCacheDir) && (fileArrListFiles = new File(unuploadedContentFileCacheDir).listFiles(new CoeditContentFileNameFilter())) != null) {
            LoggerBase.INSTANCE.m7132d(TAG, "getCoeditContentFileCacheFiles: " + fileArrListFiles.length);
            Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
            while (it.hasNext()) {
                String absolutePath = ((File) it.next()).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                arrayList.add(absolutePath);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final long getWorkspaceVersion(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getLong(uuid + PREF_WORKSPACE_VERSION, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initDownloadedStrokeInfo(String noteId) {
        String[] strArr;
        List listEmptyList;
        List listM13999t;
        List listEmptyList2;
        String downloadedStrokeInfo = getDownloadedStrokeInfo(noteId);
        if (TextUtils.isEmpty(downloadedStrokeInfo)) {
            return;
        }
        if (downloadedStrokeInfo == null || (listM13999t = AbstractC12991c.m13999t(0, END_STRING, downloadedStrokeInfo)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList2 = CollectionsKt.emptyList();
            if (listEmptyList2 == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList2 = CollectionsKt.emptyList();
            if (listEmptyList2 == null) {
                strArr = (String[]) listEmptyList2.toArray(new String[0]);
            }
        }
        if (strArr != null) {
            AbstractC4539a.m3203m(strArr.length, "initDownloadedStrokeInfo# ", TAG);
            Iterator it = ArrayIteratorKt.iterator(strArr);
            while (it.hasNext()) {
                List listM13999t2 = AbstractC12991c.m13999t(0, ",", (String) it.next());
                if (listM13999t2.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    ListIterator listIterator2 = listM13999t2.listIterator(listM13999t2.size());
                    while (listIterator2.hasPrevious()) {
                        if (((String) listIterator2.previous()).length() != 0) {
                            listEmptyList = AbstractC12991c.m14000u(listIterator2, 1, listM13999t2);
                            break;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                }
                String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                CoeditCacheMap.getNoteInfo(noteId).putDownloadedStroke(strArr2[0], strArr2[1]);
            }
        }
    }

    @JvmStatic
    public static final void initPrefInfo(@NotNull String noteId) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        CoeditCacheMap.getNoteInfo(noteId).setRestored(false);
        CoeditCacheMap.getNoteInfo(noteId).setReleased(false);
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        coeditCacheUtils.initDownloadedStrokeInfo(noteId);
        coeditCacheUtils.initUndownloadedStrokeInfo(noteId);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initUndownloadedStrokeInfo(String noteId) {
        String[] strArr;
        List listEmptyList;
        List listM13999t;
        List listEmptyList2;
        String undownloadedStrokeInfo = getUndownloadedStrokeInfo(noteId);
        if (TextUtils.isEmpty(undownloadedStrokeInfo)) {
            return;
        }
        if (undownloadedStrokeInfo == null || (listM13999t = AbstractC12991c.m13999t(0, END_STRING, undownloadedStrokeInfo)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList2 = CollectionsKt.emptyList();
            if (listEmptyList2 == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList2 = CollectionsKt.emptyList();
            if (listEmptyList2 == null) {
                strArr = (String[]) listEmptyList2.toArray(new String[0]);
            }
        }
        if (strArr != null) {
            AbstractC4539a.m3203m(strArr.length, "initUndownloadedStrokeInfo# ", TAG);
            Iterator it = ArrayIteratorKt.iterator(strArr);
            while (it.hasNext()) {
                List listM13999t2 = AbstractC12991c.m13999t(0, ",", (String) it.next());
                if (listM13999t2.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    ListIterator listIterator2 = listM13999t2.listIterator(listM13999t2.size());
                    while (listIterator2.hasPrevious()) {
                        if (((String) listIterator2.previous()).length() != 0) {
                            listEmptyList = AbstractC12991c.m14000u(listIterator2, 1, listM13999t2);
                            break;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                }
                String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                if (!CoeditCacheMap.getNoteInfo(noteId).containsDownloadedStrokeKey(strArr2[0])) {
                    CoeditCacheMap.getNoteInfo(noteId).putUndownloadedStroke(strArr2[0], strArr2[1]);
                }
            }
        }
    }

    @JvmStatic
    public static final boolean isLocalDataChanged(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getBoolean(uuid + PREF_LOCAL_CHANGED, false);
    }

    private final boolean isLostRetryData(String uuid) {
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE);
        StringBuilder sb = new StringBuilder();
        sb.append(uuid);
        sb.append(PREF_LAST_UPDATE_STATE);
        return companion.getInt(sb.toString(), 1) == 6;
    }

    @JvmStatic
    public static final boolean isRequestUpdateCorrupted(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE);
        StringBuilder sb = new StringBuilder();
        sb.append(uuid);
        sb.append(PREF_LAST_UPDATE_STATE);
        return companion.getInt(sb.toString(), 1) != 1;
    }

    @JvmStatic
    public static final boolean isSnapUploadCompleted(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).getBoolean(uuid + PREF_SNAP_UPLOADED_COMPLETED, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String makePrefString(String first, String second) {
        return AbstractC2821a.m2221l(first, ",", second, END_STRING);
    }

    @JvmStatic
    public static final void onStrokeApplied(@NotNull String noteId, @NotNull String objectBinaryHash) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(objectBinaryHash, "objectBinaryHash");
        CoeditCacheMap.getNoteInfo(noteId).removeDownloadedStroke(objectBinaryHash);
    }

    @JvmStatic
    public static final void release(@Nullable String noteId) {
        if (noteId != null) {
            CoeditCacheMap.getNoteInfo(noteId).setReleased(true);
            CoeditCacheMap.getNoteInfo(noteId).clearUndownloadedStroke();
            CoeditCacheMap.getNoteInfo(noteId).clearDownloadedStroke();
            CoeditCacheMap.release(noteId);
        }
    }

    private final boolean removeBufferCacheFile(String cachePath) {
        File file = cachePath != null ? new File(cachePath) : null;
        Boolean boolValueOf = file != null ? Boolean.valueOf(file.exists()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        if (!boolValueOf.booleanValue()) {
            return false;
        }
        try {
            try {
                boolean zDeleteFile = FileUtils.deleteFile(file);
                LoggerBase.Companion companion = LoggerBase.INSTANCE;
                companion.m7137i(TAG, "removeCoeditCacheFile# filePath/isDeleted : " + companion.getEncode(file.getAbsolutePath()) + " / " + zDeleteFile);
                return zDeleteFile;
            } catch (IOException e) {
                LoggerBase.INSTANCE.m7133e(TAG, "removeCoeditCacheFile# exception: " + e.getMessage());
                LoggerBase.INSTANCE.m7137i(TAG, "removeCoeditCacheFile# filePath/isDeleted : " + LoggerBase.INSTANCE.getEncode(file.getAbsolutePath()) + " / false");
                return false;
            }
        } catch (Throwable th) {
            LoggerBase.Companion companion2 = LoggerBase.INSTANCE;
            companion2.m7137i(TAG, "removeCoeditCacheFile# filePath/isDeleted : " + companion2.getEncode(file.getAbsolutePath()) + " / false");
            throw th;
        }
    }

    @JvmStatic
    public static final void removeCoeditCache(@Nullable Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (context == null) {
            LoggerBase.INSTANCE.m7132d(TAG, "removeCoeditCache# context is null");
            return;
        }
        removeComposeCoeditCache(context, uuid);
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        coeditCacheUtils.clearSnapUploadCompleted(uuid);
        coeditCacheUtils.clearWorkspaceVersion(uuid);
        coeditCacheUtils.clearDeviceId(uuid);
    }

    private final void removeCoeditCacheFile(String coeditCachePath) {
        removeBufferCacheFile(coeditCachePath);
        removeBufferCacheFile(AbstractC0541b.m756B(coeditCachePath, "c"));
        removeBufferCacheFile(AbstractC0541b.m756B(coeditCachePath, "s"));
        removeBufferCacheFile(AbstractC0541b.m756B(coeditCachePath, "u"));
        removeBufferCacheFile(AbstractC0541b.m756B(coeditCachePath, "t"));
    }

    @JvmStatic
    public static final void removeComposeCoeditCache(@Nullable Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        removeComposeCoeditCache(context, uuid, true);
    }

    @JvmStatic
    public static final synchronized void removeUndownloadedObjectInfo(@NotNull String noteId, @Nullable String objectId, boolean isRemoveUrlOnly) {
        try {
            Intrinsics.checkNotNullParameter(noteId, "noteId");
            Map<String, String> undownloadedObjectInfo = getUndownloadedObjectInfo(noteId);
            if (isRemoveUrlOnly) {
                undownloadedObjectInfo.put(objectId, "");
            } else {
                undownloadedObjectInfo.remove(objectId);
            }
            JSONObject jSONObject = undownloadedObjectInfo != null ? new JSONObject(undownloadedObjectInfo) : null;
            SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putString(noteId + PREF_UNDOWNLOADED_OBJECT_INFO, String.valueOf(jSONObject));
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final void removeUndownloadedStrokeInfo(@NotNull String noteId, @NotNull String objectId) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        CoeditCacheMap.getNoteInfo(noteId).removeUndownloadedStroke(objectId);
    }

    @JvmStatic
    public static final boolean removeUnuploadedContentFileCache(@NotNull Context context, @NotNull String uuid, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        String unuploadedContentFileCacheDir = coeditCacheUtils.getUnuploadedContentFileCacheDir(context, uuid);
        if (!FileUtils.exists(unuploadedContentFileCacheDir)) {
            LoggerBase.INSTANCE.m7132d(TAG, "removeUnuploadedContentFileCache# dir is not exist");
            return false;
        }
        boolean zRemoveBufferCacheFile = coeditCacheUtils.removeBufferCacheFile(coeditCacheUtils.getUnuploadedContentFileCachePath(unuploadedContentFileCacheDir, fileId));
        File[] fileArrListFiles = new File(unuploadedContentFileCacheDir).listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length == 0) {
            coeditCacheUtils.removeBufferCacheFile(unuploadedContentFileCacheDir);
        }
        return zRemoveBufferCacheFile;
    }

    private final void restoreDownloadedStrokeInfo(String noteId, final RestoreDownloadListener listener) {
        CoeditCacheMap.getNoteInfo(noteId).getDownloadedStrokeEntrySet(new CoeditCacheMap.MapContract() { // from class: com.samsung.android.support.senl.nt.base.common.util.CoeditCacheUtils.restoreDownloadedStrokeInfo.1
            @Override // com.samsung.android.support.senl.nt.base.common.util.CoeditCacheMap.MapContract
            public void getEntry(String key, String value) {
                listener.restoreDownloadStroke(key, Base64Utils.decodeBase64ToByteArray(value));
            }
        });
    }

    @JvmStatic
    public static final void restorePrefInfo(@NotNull String noteId, @NotNull RestoreDownloadListener listener) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CoeditCacheMap.getNoteInfo(noteId).setRestored(true);
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        coeditCacheUtils.restoreUndownloadedStrokeInfo(noteId, listener);
        coeditCacheUtils.restoreDownloadedStrokeInfo(noteId, listener);
    }

    private final void restoreUndownloadedStrokeInfo(String noteId, final RestoreDownloadListener listener) {
        CoeditCacheMap.getNoteInfo(noteId).getUndownloadedStrokeEntrySet(new CoeditCacheMap.MapContract() { // from class: com.samsung.android.support.senl.nt.base.common.util.CoeditCacheUtils.restoreUndownloadedStrokeInfo.1
            @Override // com.samsung.android.support.senl.nt.base.common.util.CoeditCacheMap.MapContract
            public void getEntry(String key, String value) {
                listener.restoreUndownloadStroke(key, value);
            }
        });
    }

    @JvmStatic
    public static final void saveCoeditCache(@NotNull String noteId) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        if (CoeditCacheMap.getNoteInfo(noteId).getIsReleased()) {
            return;
        }
        int undownloadedStrokeSize = CoeditCacheMap.getNoteInfo(noteId).getUndownloadedStrokeSize();
        int downloadedStrokeSize = CoeditCacheMap.getNoteInfo(noteId).getDownloadedStrokeSize();
        final StringBuilder sb = new StringBuilder();
        CoeditCacheMap.getNoteInfo(noteId).getUndownloadedStrokeEntrySet(new CoeditCacheMap.MapContract() { // from class: com.samsung.android.support.senl.nt.base.common.util.CoeditCacheUtils.saveCoeditCache.1
            @Override // com.samsung.android.support.senl.nt.base.common.util.CoeditCacheMap.MapContract
            public void getEntry(String key, String value) {
                sb.append(CoeditCacheUtils.INSTANCE.makePrefString(key, value));
            }
        });
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        coeditCacheUtils.saveUndownloadedStrokeInfo(noteId, string);
        final StringBuilder sb2 = new StringBuilder();
        CoeditCacheMap.getNoteInfo(noteId).getDownloadedStrokeEntrySet(new CoeditCacheMap.MapContract() { // from class: com.samsung.android.support.senl.nt.base.common.util.CoeditCacheUtils.saveCoeditCache.2
            @Override // com.samsung.android.support.senl.nt.base.common.util.CoeditCacheMap.MapContract
            public void getEntry(String key, String value) {
                sb2.append(CoeditCacheUtils.INSTANCE.makePrefString(key, value));
            }
        });
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        coeditCacheUtils.saveDownloadedStrokeInfo(noteId, string2);
        Logger.m8702i(TAG, "saveCoeditCache, undownloaded/downloaded : " + undownloadedStrokeSize + " / " + downloadedStrokeSize);
    }

    private final void saveDownloadedStrokeInfo(String noteId, String saveData) {
        if (TextUtils.isEmpty(saveData)) {
            clearDownloadedStrokeInfo(noteId);
            return;
        }
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putString(noteId + PREF_DOWNLOAD_STROKE_NAME, saveData);
    }

    private final void saveUndownloadedStrokeInfo(String noteId, String saveData) {
        if (TextUtils.isEmpty(saveData)) {
            clearUndownloadedStrokeInfo(noteId);
            return;
        }
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putString(noteId + PREF_UNDOWNLOAD_STROKE_NAME, saveData);
    }

    @JvmStatic
    public static final void setAbnormalReleased(@NotNull String uuid, int step) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putInt(uuid + PREF_ABNORMAL_RELEASED, step);
    }

    @JvmStatic
    public static final void setCurrentDocumentSize(@NotNull String uuid, int currentDocumentSize) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putInt(uuid + PREF_CURRENT_DOCUMENT_SIZE, currentDocumentSize);
    }

    @JvmStatic
    public static final void setDeviceId(@NotNull String uuid, @Nullable String deviceId) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putString(uuid + PREF_DEVICE_ID, deviceId);
    }

    @JvmStatic
    public static final void setForceReopenState(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        removeComposeCoeditCache(BaseUtils.getApplicationContext(), uuid);
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putInt(uuid + PREF_LAST_UPDATE_STATE, 6);
    }

    @JvmStatic
    public static final void setLastDownloadedCheckPoint(@NotNull String uuid, long lastDownloadedCheckPoint) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putLong(uuid + PREF_LAST_DOWNLOADED_CHECKPOINT, lastDownloadedCheckPoint);
    }

    @JvmStatic
    public static final void setLocalDataChanged(@NotNull String uuid, boolean set) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putBoolean(uuid + PREF_LOCAL_CHANGED, set);
    }

    @JvmStatic
    public static final void setRequestUpdate(@NotNull String uuid, int set) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (INSTANCE.isLostRetryData(uuid)) {
            return;
        }
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putInt(uuid + PREF_LAST_UPDATE_STATE, set);
    }

    @JvmStatic
    public static final void setSnapUploadCompleted(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putBoolean(uuid + PREF_SNAP_UPLOADED_COMPLETED, true);
    }

    @JvmStatic
    public static final void setWorkspaceVersion(@NotNull String uuid, long workspaceVersion) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SharedPreferencesCompat.INSTANCE.getInstance(COEDIT_PREFERENCE).putLong(uuid + PREF_WORKSPACE_VERSION, workspaceVersion);
    }

    @JvmStatic
    public static final void removeComposeCoeditCache(@Nullable Context context, @NotNull String uuid, boolean needSnap) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (context == null) {
            LoggerBase.INSTANCE.m7132d(TAG, "removeComposeCoeditCache# context is null");
            return;
        }
        CoeditCacheUtils coeditCacheUtils = INSTANCE;
        coeditCacheUtils.deletePrefInfo(uuid);
        if (FileUtils.exists(coeditCacheUtils.getCoeditBaseCacheDir(context))) {
            coeditCacheUtils.removeCoeditCacheFile(createCoeditCachePath(context, uuid));
            coeditCacheUtils.removeCoeditCacheFile(coeditCacheUtils.getUnuploadedContentFileCacheDir(context, uuid));
            if (needSnap) {
                coeditCacheUtils.clearLastDownloadedCheckPoint(uuid);
            }
            coeditCacheUtils.clearCurrentDocumentSize(uuid);
        }
    }

    @JvmStatic
    public static final boolean saveDownloadedStrokeInfo(@NotNull String noteId, @NotNull String objectBinaryHash, @NotNull byte[] strokeByte) {
        String strEncodeBase64;
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(objectBinaryHash, "objectBinaryHash");
        Intrinsics.checkNotNullParameter(strokeByte, "strokeByte");
        try {
            strEncodeBase64 = Base64Utils.encodeBase64(strokeByte);
        } catch (UnsupportedEncodingException e) {
            AbstractC4539a.m3214x("saveDownloadedStrokeInfo UnsupportedEncodingException: ", e.getMessage(), TAG);
            strEncodeBase64 = null;
        }
        if (TextUtils.isEmpty(strEncodeBase64)) {
            Logger.m8703w(TAG, "saveDownloadedStrokeInfo can't convert to string " + objectBinaryHash);
            return false;
        }
        Boolean boolValueOf = strEncodeBase64 != null ? Boolean.valueOf(CoeditCacheMap.getNoteInfo(noteId).putDownloadedStroke(objectBinaryHash, strEncodeBase64)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    @JvmStatic
    public static final void saveUndownloadedStrokeInfo(@NotNull String noteId, @NotNull String objectId, @NotNull String objectBinaryHash) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(objectBinaryHash, "objectBinaryHash");
        CoeditCacheMap.getNoteInfo(noteId).putUndownloadedStroke(objectId, objectBinaryHash);
    }

    private final String getUnuploadedContentFileCachePath(String contentFileCacheDir, String fileId) {
        return AbstractC2821a.m2221l(contentFileCacheDir, "/coeditUnuploadedContentFile_", fileId, COEDIT_FORMAT);
    }
}
