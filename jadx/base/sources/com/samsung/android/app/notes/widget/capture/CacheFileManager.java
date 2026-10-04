package com.samsung.android.app.notes.widget.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetCacheInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 d2\u00020\u0001:\u0003bcdB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ,\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013J2\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018J\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006JD\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0013H\u0002JF\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-H\u0002JH\u00100\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u0001022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eJH\u00104\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u0001022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eH\u0002J0\u00105\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<H\u0002J8\u0010=\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u00072\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0013H\u0002J&\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0018J0\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-J \u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006J \u0010A\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0018H\u0002JH\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00132\b\b\u0002\u0010E\u001a\u00020\u0006J\u0016\u0010F\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J\u001e\u0010F\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0018J\u001c\u0010F\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eJ\u0010\u0010H\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J,\u0010I\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u000e\u0010J\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010K\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010L\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010M\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010N\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010O\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0018J(\u0010P\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0018H\u0002J\u0018\u0010S\u001a\u00020T2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010U\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u001a\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0012\u0010X\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0006H\u0002J6\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00180Zj\b\u0012\u0004\u0012\u00020\u0018`[2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010]\u001a\u00020\u0013H\u0002J.\u0010^\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eH\u0002JJ\u0010`\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u000e\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\b\u0010a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/CacheFileManager;", "", "<init>", "()V", "mCacheInfoList", "", "", "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$CacheDataInfo;", "mSync", "mTextOnlyNoteManager", "Lcom/samsung/android/app/notes/widget/capture/TextOnlyNoteManager;", "init", "", "context", "Landroid/content/Context;", "makeCacheInfoList", "cacheInfoList", "uuid", "isInitialized", "", "()Z", "getFilePath", "getThumbnailPath", "idx", "", "isDarkMode", "getTextOnlyThumbnailPath", "orientation", "width", "getBitmapList", "", "Landroid/graphics/Bitmap;", "getPageColor", "getPageCount", "isListPageMode", "isNextPage", "isTextOnlyNote", "hasBackgroundImage", "existVoiceRecording", "createCacheInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetCacheInfo;", "widgetId", "filePath", "isOnePage", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$Callback;", "thumbnail", "data", "createThumbnail", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "widgetIds", "captureThumbnail", "captureBitmap", "", "captureManager", "Lcom/samsung/android/app/notes/widget/capture/CaptureManager;", "pageCount", "pageWidth", "themeInfo", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "saveThumbnailFile", "dataInfo", "sources", "dark", "removeCache", "captureTextOnlyBitmap", "widgetWidth", "shortcut", "providerName", "removeCacheInfo", "uuidList", "initSpen", "getValidFilePath", "isValidFiles", "isCacheFilesCleared", "isValidCacheFiles", "isDoneState", "isAfterLastModifyTime", "isCreateWidgetState", "isStateToStopThread", "info", "expectedState", "getLastModifiedTime", "", "getBackgroundColorInverted", "getEntityFromUuid", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "isFileExistWithFilePath", "getUpdateThemeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "widgetIdList", "darkTheme", "checkCreateCache", "widgetList", "saveTextOnlyData", "mUuid", "Callback", "CacheDataInfo", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CacheFileManager {

    @NotNull
    private static final String TAG = "CacheFileManager";

    @Nullable
    private static CacheFileManager mInstance;

    @Nullable
    private Map<String, CacheDataInfo> mCacheInfoList;

    @NotNull
    private final Object mSync;

    @NotNull
    private final TextOnlyNoteManager mTextOnlyNoteManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\bA\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001jB\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u0015H\u0016J\u0010\u0010c\u001a\u00020\u001e2\b\u0010d\u001a\u0004\u0018\u00010`J\b\u0010e\u001a\u00020\u0000H\u0016J\u001a\u0010f\u001a\u00020\u001e2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R4\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R4\u00100\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R$\u00103\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R$\u00106\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R$\u00109\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R4\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010M\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010;\"\u0004\bO\u0010=R$\u0010P\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010;\"\u0004\bR\u0010=R$\u0010S\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010;\"\u0004\bU\u0010=R$\u0010V\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010#\"\u0004\bX\u0010%R4\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010-\"\u0004\b[\u0010/R4\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010-\"\u0004\b^\u0010/R\"\u0010_\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010-\"\u0004\bb\u0010/¨\u0006k"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$CacheDataInfo;", "Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetCacheInfo;", "Ljava/io/Serializable;", "", "<init>", "()V", "mState", "", "mFilePath", "", "mThumbnailList", "", "mTextOnlyThumbnailList", "mPageColor", "mPageCount", "mListMode", "", "mBackgroundInvert", "mWidgetIdList", "", "mDocLastModifiedTime", "", "mTextOnly", "mBackgroundImage", "mVoiceRecording", "mTextPageCount", "mLightBitmapList", "Landroid/graphics/Bitmap;", "mDarkBitmapList", "init", "", "initWidgetIdList", "value", "state", "getState", "()I", "setState", "(I)V", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "thumbnailList", "getThumbnailList", "()Ljava/util/List;", "setThumbnailList", "(Ljava/util/List;)V", "textOnlyThumbnailList", "getTextOnlyThumbnailList", "setTextOnlyThumbnailList", "pageColor", "getPageColor", "setPageColor", "pageCount", "getPageCount", "setPageCount", "listMode", "getListMode", "()Z", "setListMode", "(Z)V", "backgroundInvert", "getBackgroundInvert", "setBackgroundInvert", "widgetIdList", "getWidgetIdList", "()Ljava/util/Set;", "setWidgetIdList", "(Ljava/util/Set;)V", "docLastModified", "getDocLastModified", "()J", "setDocLastModified", "(J)V", "setDocLastModifiedTime", "docLastModifiedTime", "textOnly", "getTextOnly", "setTextOnly", "backgroundImage", "getBackgroundImage", "setBackgroundImage", "voiceRecording", "getVoiceRecording", "setVoiceRecording", "textPageCount", "getTextPageCount", "setTextPageCount", "lightBitmapList", "getLightBitmapList", "setLightBitmapList", "darkBitmapList", "getDarkBitmapList", "setDarkBitmapList", "callbackList", "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$Callback;", "getCallbackList", "setCallbackList", "addCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "clone", "saveData", "context", "Landroid/content/Context;", "uuid", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CacheDataInfo implements IAppWidgetCacheInfo, Serializable, Cloneable {
        public static final int DELETING = 8;
        public static final int DONE = 7;
        public static final int DONE_CAPTURE_INFO_CREATE = 4;
        public static final int DONE_DARK_THUMBNAIL_CAPTURE = 6;
        public static final int DONE_LIGHT_THUMBNAIL_CAPTURE = 5;
        public static final int INIT = 0;
        public static final int READY_BY_SERVICE = 9;
        public static final int READY_THREAD = 1;
        public static final int START_CAPTURE = 2;
        public static final int START_TEXT_ONLY_NOTE_COPY = 3;

        @Nullable
        private List<Callback> callbackList;
        private boolean mBackgroundImage;
        private transient boolean mBackgroundInvert;

        @Nullable
        private transient List<Bitmap> mDarkBitmapList;
        private long mDocLastModifiedTime;

        @Nullable
        private String mFilePath;

        @Nullable
        private transient List<Bitmap> mLightBitmapList;
        private boolean mListMode;
        private int mPageColor;
        private int mPageCount;
        private int mState = 0;
        private boolean mTextOnly;

        @Nullable
        private List<String> mTextOnlyThumbnailList;
        private int mTextPageCount;

        @Nullable
        private List<String> mThumbnailList;
        private boolean mVoiceRecording;

        @Nullable
        private transient Set<Integer> mWidgetIdList;
        public static final int $stable = 8;

        public CacheDataInfo() {
            init();
        }

        public final void addCallback(@Nullable Callback callback) {
            if (callback == null) {
                return;
            }
            if (this.callbackList == null) {
                this.callbackList = new ArrayList(5);
            }
            List<Callback> list = this.callbackList;
            if (list != null) {
                list.add(callback);
            }
        }

        /* JADX INFO: renamed from: getBackgroundImage, reason: from getter */
        public final boolean getMBackgroundImage() {
            return this.mBackgroundImage;
        }

        /* JADX INFO: renamed from: getBackgroundInvert, reason: from getter */
        public final boolean getMBackgroundInvert() {
            return this.mBackgroundInvert;
        }

        @Nullable
        public final List<Callback> getCallbackList() {
            return this.callbackList;
        }

        @Nullable
        public final List<Bitmap> getDarkBitmapList() {
            return this.mDarkBitmapList;
        }

        /* JADX INFO: renamed from: getDocLastModified, reason: from getter */
        public final long getMDocLastModifiedTime() {
            return this.mDocLastModifiedTime;
        }

        @Nullable
        /* JADX INFO: renamed from: getFilePath, reason: from getter */
        public final String getMFilePath() {
            return this.mFilePath;
        }

        @Nullable
        public final List<Bitmap> getLightBitmapList() {
            return this.mLightBitmapList;
        }

        /* JADX INFO: renamed from: getListMode, reason: from getter */
        public final boolean getMListMode() {
            return this.mListMode;
        }

        /* JADX INFO: renamed from: getPageColor, reason: from getter */
        public final int getMPageColor() {
            return this.mPageColor;
        }

        /* JADX INFO: renamed from: getPageCount, reason: from getter */
        public final int getMPageCount() {
            return this.mPageCount;
        }

        /* JADX INFO: renamed from: getState, reason: from getter */
        public final int getMState() {
            return this.mState;
        }

        /* JADX INFO: renamed from: getTextOnly, reason: from getter */
        public final boolean getMTextOnly() {
            return this.mTextOnly;
        }

        @Nullable
        public final List<String> getTextOnlyThumbnailList() {
            return this.mTextOnlyThumbnailList;
        }

        /* JADX INFO: renamed from: getTextPageCount, reason: from getter */
        public final int getMTextPageCount() {
            return this.mTextPageCount;
        }

        @Nullable
        public final List<String> getThumbnailList() {
            return this.mThumbnailList;
        }

        /* JADX INFO: renamed from: getVoiceRecording, reason: from getter */
        public final boolean getMVoiceRecording() {
            return this.mVoiceRecording;
        }

        @Nullable
        public final Set<Integer> getWidgetIdList() {
            return this.mWidgetIdList;
        }

        public final void init() {
            this.mThumbnailList = Collections.synchronizedList(new ArrayList(4));
            this.mTextOnlyThumbnailList = Collections.synchronizedList(new ArrayList(20));
            initWidgetIdList();
        }

        public final void initWidgetIdList() {
            this.mWidgetIdList = Collections.synchronizedSet(new HashSet());
        }

        public final void saveData(@Nullable Context context, @Nullable String uuid) {
            Logger.m8697d(CacheFileManager.TAG, "saveData#");
            File file = new File(WidgetUtils.INSTANCE.getCacheDataFilePath(context, String.valueOf(uuid)));
            if (!file.exists()) {
                try {
                    if (!file.createNewFile()) {
                        Logger.m8703w(CacheFileManager.TAG, "saveData# fail to create file");
                        return;
                    }
                } catch (IOException e) {
                    Logger.m8699e(CacheFileManager.TAG, e.getMessage(), e);
                    return;
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream.writeObject(m22120clone());
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(objectOutputStream, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e2) {
                Logger.m8698e(CacheFileManager.TAG, e2.getMessage());
            } catch (CloneNotSupportedException e3) {
                Logger.m8698e(CacheFileManager.TAG, e3.getMessage());
            }
        }

        public final void setBackgroundImage(boolean z) {
            this.mBackgroundImage = z;
        }

        public final void setBackgroundInvert(boolean z) {
            this.mBackgroundInvert = z;
        }

        public final void setCallbackList(@Nullable List<Callback> list) {
            this.callbackList = list;
        }

        public final void setDarkBitmapList(@Nullable List<Bitmap> list) {
            this.mDarkBitmapList = list;
        }

        public final void setDocLastModified(long j) {
            this.mDocLastModifiedTime = j;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetCacheInfo
        public void setDocLastModifiedTime(long docLastModifiedTime) {
            setDocLastModified(docLastModifiedTime);
        }

        public final void setFilePath(@Nullable String str) {
            this.mFilePath = str;
        }

        public final void setLightBitmapList(@Nullable List<Bitmap> list) {
            this.mLightBitmapList = list;
        }

        public final void setListMode(boolean z) {
            this.mListMode = z;
        }

        public final void setPageColor(int i) {
            this.mPageColor = i;
        }

        public final void setPageCount(int i) {
            this.mPageCount = i;
        }

        public final void setState(int i) {
            this.mState = i;
        }

        public final void setTextOnly(boolean z) {
            this.mTextOnly = z;
        }

        public final void setTextOnlyThumbnailList(@Nullable List<String> list) {
            this.mTextOnlyThumbnailList = list;
        }

        public final void setTextPageCount(int i) {
            this.mTextPageCount = i;
        }

        public final void setThumbnailList(@Nullable List<String> list) {
            this.mThumbnailList = list;
        }

        public final void setVoiceRecording(boolean z) {
            this.mVoiceRecording = z;
        }

        public final void setWidgetIdList(@Nullable Set<Integer> set) {
            this.mWidgetIdList = set;
        }

        @NotNull
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public CacheDataInfo m22120clone() throws CloneNotSupportedException {
            Object objClone = super.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.capture.CacheFileManager.CacheDataInfo");
            return (CacheDataInfo) objClone;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$Callback;", "", "onCacheCreated", "", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onCacheCreated();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/app/notes/widget/capture/CacheFileManager;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized CacheFileManager getInstance() {
            CacheFileManager cacheFileManager;
            try {
                if (CacheFileManager.mInstance == null) {
                    CacheFileManager.mInstance = new CacheFileManager(null);
                }
                cacheFileManager = CacheFileManager.mInstance;
                Intrinsics.checkNotNull(cacheFileManager);
            } catch (Throwable th) {
                throw th;
            }
            return cacheFileManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CacheFileManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final List<Bitmap> captureBitmap(CaptureManager captureManager, int pageCount, int pageWidth, ThemeInfo themeInfo) {
        ArrayList arrayList = new ArrayList(2);
        if (!captureManager.isListPageMode()) {
            return TypeIntrinsics.asMutableList(captureManager.captureSinglePage(pageCount, themeInfo));
        }
        int iMin = (int) Math.min(pageCount, 2.0d);
        for (int i = 0; i < iMin; i++) {
            Bitmap bitmapCaptureListPage = captureManager.captureListPage(i, pageWidth, themeInfo);
            if (bitmapCaptureListPage != null) {
                arrayList.add(bitmapCaptureListPage);
            }
        }
        return arrayList;
    }

    private final void captureThumbnail(Context context, String uuid, String filePath, CacheDataInfo data, boolean isOnePage, SpenWNote note, List<Integer> widgetIds) {
        CaptureManager captureManager;
        CaptureManager captureManager2;
        int i;
        int iMin;
        CacheDataInfo cacheDataInfo;
        List<Integer> list;
        List<Bitmap> lightBitmapList;
        List<Bitmap> lightBitmapList2;
        ArrayList<SpenVoiceData> voiceDataList;
        WidgetAccessContract widgetAccessContract;
        Context context2 = context;
        SpenWNote note2 = note;
        String encode = Logger.getEncode(uuid);
        AbstractC4539a.m3206p("createThumbnail# capture start ", encode, TAG);
        MainListDocumentData entityFromUuid = getEntityFromUuid(context, uuid);
        if (entityFromUuid == null || !isFileExistWithFilePath(filePath)) {
            synchronized (this.mSync) {
                Map<String, CacheDataInfo> map = this.mCacheInfoList;
                Intrinsics.checkNotNull(map);
                map.remove(uuid);
            }
            return;
        }
        if (checkCreateCache(context2, data, uuid, widgetIds)) {
            Logger.m8698e(TAG, "createThumbnail# already creating");
            return;
        }
        data.setState(2);
        if (data.getCallbackList() == null && (widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract()) != null) {
            widgetAccessContract.sendUpdateWidgetSettingBroadcast(context2, uuid, WidgetConstant.ACTION_WIDGET_SETTING_CREATE_CACHE);
        }
        if (note2 == null || (!DisplayUtils.isIsMainDisplay() && DeviceUtils.isFoldableModel())) {
            captureManager = new CaptureManager(context2, filePath);
            note2 = captureManager.getNote();
        } else {
            captureManager = new CaptureManager(context2, note2, filePath, false);
        }
        CaptureManager captureManager3 = captureManager;
        int pageColor = captureManager3.getPageColor();
        int pageCount = captureManager3.getPageCount();
        boolean zIsListPageMode = captureManager3.isListPageMode();
        boolean zIsTextOnlyNote = captureManager3.getIsTextOnlyNote();
        if (isOnePage) {
            i = pageColor;
            captureManager2 = captureManager3;
            iMin = 1;
        } else {
            captureManager2 = captureManager3;
            i = pageColor;
            iMin = (int) Math.min(pageCount, 2.0d);
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        int i2 = iMin;
        int iMin2 = (int) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        data.setFilePath(filePath);
        data.setPageColor(i);
        data.setPageCount(pageCount);
        data.setListMode(zIsListPageMode);
        data.setBackgroundInvert(entityFromUuid.getBackgroundColorInverted() == 1);
        data.setTextOnly(zIsTextOnlyNote);
        data.setBackgroundImage(captureManager2.getIsBackgroundImage());
        data.setVoiceRecording((note2 == null || (voiceDataList = note2.getVoiceDataList()) == null || !(voiceDataList.isEmpty() ^ true)) ? false : true);
        Logger.m8702i(TAG, "createThumbnail# capture init done " + encode + ", isTextOnly : " + zIsTextOnlyNote + ", listMode : " + zIsListPageMode);
        if (zIsTextOnlyNote) {
            if (isStateToStopThread(context2, data, uuid, 2)) {
                return;
            }
            data.setState(3);
            this.mTextOnlyNoteManager.createTextOnlyNote(context, filePath, uuid, zIsListPageMode, iMin2, captureManager2.getNote());
            context2 = context;
        }
        data.setState(4);
        CaptureManager captureManager4 = captureManager2;
        data.setLightBitmapList(captureBitmap(captureManager4, i2, iMin2, new ThemeInfo(1)));
        if (isStateToStopThread(context2, data, uuid, 4)) {
            if (data.getLightBitmapList() == null || (lightBitmapList2 = data.getLightBitmapList()) == null) {
                return;
            }
            lightBitmapList2.clear();
            return;
        }
        data.setState(5);
        ArrayList arrayList = new ArrayList(data.getWidgetIdList());
        ArrayList<Integer> updateThemeList = getUpdateThemeList(context2, arrayList, false);
        AbstractC4539a.m3206p("createThumbnail# capture default Done ", encode, TAG);
        if (isStateToStopThread(context2, data, uuid, 5)) {
            if (data.getLightBitmapList() == null || (lightBitmapList = data.getLightBitmapList()) == null) {
                return;
            }
            lightBitmapList.clear();
            return;
        }
        data.setDarkBitmapList(captureBitmap(captureManager4, i2, iMin2, new ThemeInfo(0)));
        if (isStateToStopThread(context2, data, uuid, 5)) {
            if (data.getLightBitmapList() == null || data.getDarkBitmapList() == null) {
                return;
            }
            List<Bitmap> lightBitmapList3 = data.getLightBitmapList();
            if (lightBitmapList3 != null) {
                lightBitmapList3.clear();
            }
            List<Bitmap> darkBitmapList = data.getDarkBitmapList();
            if (darkBitmapList != null) {
                darkBitmapList.clear();
                return;
            }
            return;
        }
        data.setState(6);
        ArrayList<Integer> updateThemeList2 = getUpdateThemeList(context2, arrayList, true);
        AbstractC4539a.m3206p("capture complete Done ", encode, TAG);
        if (isStateToStopThread(context2, data, uuid, 6)) {
            if (data.getLightBitmapList() == null || data.getDarkBitmapList() == null) {
                return;
            }
            List<Bitmap> lightBitmapList4 = data.getLightBitmapList();
            if (lightBitmapList4 != null) {
                lightBitmapList4.clear();
            }
            List<Bitmap> darkBitmapList2 = data.getDarkBitmapList();
            if (darkBitmapList2 != null) {
                darkBitmapList2.clear();
                return;
            }
            return;
        }
        captureManager4.release();
        if (saveThumbnailFile(context2, data, data.getLightBitmapList(), uuid, false)) {
            cacheDataInfo = data;
            if (saveThumbnailFile(context, cacheDataInfo, data.getDarkBitmapList(), uuid, true)) {
                if (updateThemeList.isEmpty() && cacheDataInfo.getLightBitmapList() != null) {
                    List<Bitmap> lightBitmapList5 = cacheDataInfo.getLightBitmapList();
                    Intrinsics.checkNotNull(lightBitmapList5);
                    for (Bitmap bitmap : lightBitmapList5) {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                    List<Bitmap> lightBitmapList6 = cacheDataInfo.getLightBitmapList();
                    if (lightBitmapList6 != null) {
                        lightBitmapList6.clear();
                    }
                }
                if (updateThemeList2.isEmpty() && cacheDataInfo.getDarkBitmapList() != null) {
                    List<Bitmap> darkBitmapList3 = cacheDataInfo.getDarkBitmapList();
                    Intrinsics.checkNotNull(darkBitmapList3);
                    for (Bitmap bitmap2 : darkBitmapList3) {
                        if (!bitmap2.isRecycled()) {
                            bitmap2.recycle();
                        }
                    }
                    List<Bitmap> darkBitmapList4 = cacheDataInfo.getDarkBitmapList();
                    if (darkBitmapList4 != null) {
                        darkBitmapList4.clear();
                    }
                }
                cacheDataInfo.setState(7);
                if (cacheDataInfo.getCallbackList() != null) {
                    List<Callback> callbackList = cacheDataInfo.getCallbackList();
                    Intrinsics.checkNotNull(callbackList);
                    Iterator<Callback> it = callbackList.iterator();
                    while (it.hasNext()) {
                        it.next().onCacheCreated();
                    }
                    List<Callback> callbackList2 = cacheDataInfo.getCallbackList();
                    Intrinsics.checkNotNull(callbackList2);
                    callbackList2.clear();
                    cacheDataInfo.setCallbackList(null);
                } else {
                    WidgetAccessContract widgetAccessContract2 = WidgetAccessHandler.getWidgetAccessContract();
                    if (widgetAccessContract2 != null) {
                        widgetAccessContract2.sendUpdateWidgetSettingBroadcast(context, uuid, WidgetConstant.ACTION_WIDGET_SETTING_DONE_CACHE);
                    }
                }
                cacheDataInfo.saveData(context, uuid);
                Logger.m8702i(TAG, "createThumbnail# capture end " + encode);
                if (FileUtils.exists(WidgetUtils.INSTANCE.createCacheFilePath(context, uuid))) {
                    WidgetAccessContract widgetAccessContract3 = WidgetAccessHandler.getWidgetAccessContract();
                    if (widgetAccessContract3 != null) {
                        list = widgetIds;
                        widgetAccessContract3.sendUpdateWidgetCacheDoneBroadcast(context, !widgetIds.isEmpty() ? list.get(0).intValue() : -1, uuid);
                    } else {
                        list = widgetIds;
                    }
                    Logger.m8702i(TAG, "createThumbnail# capture end send update done widgetId: " + list);
                    return;
                }
                return;
            }
        } else {
            cacheDataInfo = data;
        }
        if (cacheDataInfo.getLightBitmapList() == null || cacheDataInfo.getDarkBitmapList() == null) {
            return;
        }
        List<Bitmap> lightBitmapList7 = cacheDataInfo.getLightBitmapList();
        if (lightBitmapList7 != null) {
            lightBitmapList7.clear();
        }
        List<Bitmap> darkBitmapList5 = cacheDataInfo.getDarkBitmapList();
        if (darkBitmapList5 != null) {
            darkBitmapList5.clear();
        }
    }

    private final boolean checkCreateCache(Context context, CacheDataInfo data, String uuid, List<Integer> widgetList) {
        long lastModifiedTime = getLastModifiedTime(context, uuid);
        if (lastModifiedTime <= 0) {
            return false;
        }
        if (data.getMDocLastModifiedTime() != lastModifiedTime) {
            data.setDocLastModifiedTime(lastModifiedTime);
        } else {
            if (data.getMState() >= 2 && data.getMState() <= 4) {
                Logger.m8703w(TAG, "checkCreateCache. start capture :" + data.getMState());
                return true;
            }
            if (data.getMState() >= 5 && data.getMState() <= 6) {
                Logger.m8703w(TAG, "checkCreateCache. thumbnail creating :" + data.getMState());
                ArrayList<Integer> arrayList = new ArrayList<>();
                if (data.getMState() == 5) {
                    arrayList = getUpdateThemeList(context, widgetList, false);
                } else if (data.getMState() == 6) {
                    arrayList = getUpdateThemeList(context, widgetList, true);
                }
                if (!arrayList.isEmpty()) {
                    WidgetBroadcast.sendWaitCreateCacheFileUuid(context, arrayList);
                }
                return true;
            }
            Logger.m8703w(TAG, "checkCreateCache. other state :" + data.getMState());
        }
        return false;
    }

    private final IAppWidgetCacheInfo createCacheInfo(Context context, String uuid, int widgetId, String filePath, boolean isOnePage, Callback callback, boolean thumbnail) {
        String encode = Logger.getEncode(uuid);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("createCacheInfo# ", widgetId, " ", encode, " ");
        sbM1629s.append(thumbnail);
        Logger.m8697d(TAG, sbM1629s.toString());
        init(context);
        String validFilePath = getValidFilePath(context, filePath, widgetId, uuid);
        if (TextUtils.isEmpty(validFilePath) || Intrinsics.areEqual(BaseWidgetConstant.NONE, validFilePath)) {
            AbstractC4539a.m3214x("createCacheInfo. wrong path info. ", validFilePath, TAG);
            return null;
        }
        initSpen(context);
        synchronized (this.mSync) {
            try {
                WidgetLogger.m5154d(TAG, "check thread: createCacheInfo - " + Thread.currentThread().getName());
                Map<String, CacheDataInfo> map = this.mCacheInfoList;
                Intrinsics.checkNotNull(map);
                CacheDataInfo cacheDataInfo = map.get(uuid);
                if (cacheDataInfo != null) {
                    Set<Integer> widgetIdList = cacheDataInfo.getWidgetIdList();
                    Intrinsics.checkNotNull(widgetIdList);
                    widgetIdList.add(Integer.valueOf(widgetId));
                    if (isCacheFilesCleared(context, uuid)) {
                        cacheDataInfo.setState(0);
                    }
                    int mState = cacheDataInfo.getMState();
                    if (mState != 0 && mState != 8) {
                        if (callback != null) {
                            cacheDataInfo.addCallback(callback);
                        } else if (cacheDataInfo.getMState() == 7) {
                            Logger.m8697d(TAG, "createCacheInfo# callback broadcast " + uuid);
                            WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
                            if (widgetAccessContract != null) {
                                widgetAccessContract.sendUpdateWidgetCacheDoneBroadcast(context, widgetId, uuid);
                            }
                        }
                        Logger.m8697d(TAG, "createCacheInfo# exist info# " + cacheDataInfo.getMState() + " " + encode);
                        return cacheDataInfo;
                    }
                } else {
                    cacheDataInfo = new CacheDataInfo();
                    Map<String, CacheDataInfo> map2 = this.mCacheInfoList;
                    Intrinsics.checkNotNull(map2);
                    map2.put(uuid, cacheDataInfo);
                }
                if (!thumbnail) {
                    Logger.m8697d(TAG, "createCacheInfo# setState READY_BY_SERVICE#" + encode);
                    cacheDataInfo.setState(9);
                }
                Unit unit = Unit.INSTANCE;
                if (thumbnail) {
                    createCacheInfo(context, uuid, widgetId, validFilePath, cacheDataInfo, isOnePage, callback);
                }
                return cacheDataInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCacheInfo$lambda$5(CacheDataInfo cacheDataInfo, int i, CacheFileManager cacheFileManager, Context context, String str, String str2, boolean z) {
        WidgetLogger.m5154d(TAG, "check thread: createCacheInfo createThumbnail - " + Thread.currentThread().getName());
        Set<Integer> widgetIdList = cacheDataInfo.getWidgetIdList();
        Intrinsics.checkNotNull(widgetIdList);
        widgetIdList.add(Integer.valueOf(i));
        cacheFileManager.createThumbnail(context, str, str2, cacheDataInfo, z, null, CollectionsKt.listOf(Integer.valueOf(i)));
    }

    private final boolean getBackgroundColorInverted(Context context, String uuid) {
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(uuid);
        return mainListDocumentData != null && mainListDocumentData.getBackgroundColorInverted() == 1;
    }

    private final MainListDocumentData getEntityFromUuid(Context context, String uuid) {
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(uuid);
        if (mainListDocumentData == null) {
            Logger.m8698e(TAG, "getEntityFromUuid# entry is null");
        }
        return mainListDocumentData;
    }

    @NotNull
    public static final synchronized CacheFileManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final long getLastModifiedTime(Context context, String uuid) {
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(uuid);
        if (mainListDocumentData != null) {
            return mainListDocumentData.getLastModifiedAt();
        }
        return -1L;
    }

    private final ArrayList<Integer> getUpdateThemeList(Context context, List<Integer> widgetIdList, boolean darkTheme) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<Integer> it = widgetIdList.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (new ThemeInfo(context, iIntValue).isDarkMode() == darkTheme) {
                arrayList.add(Integer.valueOf(iIntValue));
            }
        }
        if (!arrayList.isEmpty()) {
            WidgetBroadcast.sendWaitCreateCacheFileUuid(context, arrayList);
        }
        return arrayList;
    }

    private final String getValidFilePath(Context context, String filePath, int widgetId, String uuid) {
        String path = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getPath(uuid);
        if (TextUtils.isEmpty(filePath)) {
            String filePath2 = WidgetPreferenceManager.INSTANCE.getFilePath(widgetId);
            if (!Intrinsics.areEqual(BaseWidgetConstant.NONE, filePath2)) {
                return filePath2;
            }
            if (TextUtils.isEmpty(path)) {
                Logger.m8698e(TAG, "filePath invalid. ");
                return null;
            }
        } else if (TextUtils.isEmpty(path) || Intrinsics.areEqual(filePath, path)) {
            return filePath;
        }
        return path;
    }

    private final void initSpen(Context context) {
        try {
            SpenSdkInitializer.initialize(context);
            SpenComposerSdkInitializer.initialize(context);
        } catch (Exception e) {
            AbstractC4539a.m3214x("spen init exception. ", e.getMessage(), TAG);
        }
    }

    private final boolean isFileExistWithFilePath(String filePath) {
        if (!TextUtils.isEmpty(filePath)) {
            Intrinsics.checkNotNull(filePath);
            if (new File(filePath).exists()) {
                return true;
            }
        }
        AbstractC4539a.m3214x("isFileExistWithFilePath# the path is invalid : ", filePath, TAG);
        return false;
    }

    private final boolean isStateToStopThread(Context context, CacheDataInfo info, String uuid, int expectedState) {
        WidgetAccessContract widgetAccessContract;
        int mState = info.getMState();
        if (mState == expectedState) {
            return false;
        }
        Logger.m8703w(TAG, "isStateToStopThread# cur:" + mState + " expect:" + expectedState);
        if (info.getCallbackList() != null || (widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract()) == null) {
            return true;
        }
        widgetAccessContract.sendUpdateWidgetSettingBroadcast(context, uuid, WidgetConstant.ACTION_WIDGET_SETTING_CANCEL_CACHE);
        return true;
    }

    private final void makeCacheInfoList(Context context, Map<String, CacheDataInfo> cacheInfoList, String uuid) {
        boolean z;
        boolean z2;
        File file = new File(WidgetUtils.INSTANCE.getCacheDataFilePath(context, uuid));
        if (!file.exists()) {
            return;
        }
        String encode = Logger.getEncode(uuid);
        if (cacheInfoList.get(uuid) != null) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.capture.CacheFileManager.CacheDataInfo");
                    CacheDataInfo cacheDataInfo = (CacheDataInfo) object;
                    if (cacheDataInfo.getThumbnailList() != null && cacheDataInfo.getTextOnlyThumbnailList() != null) {
                        List<String> thumbnailList = cacheDataInfo.getThumbnailList();
                        Intrinsics.checkNotNull(thumbnailList);
                        Iterator<String> it = thumbnailList.iterator();
                        while (true) {
                            z = false;
                            if (!it.hasNext()) {
                                z2 = true;
                                break;
                            }
                            String next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            if (!new File(next).exists()) {
                                z2 = false;
                                break;
                            }
                        }
                        List<String> textOnlyThumbnailList = cacheDataInfo.getTextOnlyThumbnailList();
                        Intrinsics.checkNotNull(textOnlyThumbnailList);
                        Iterator<String> it2 = textOnlyThumbnailList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = z2;
                                break;
                            }
                            String next2 = it2.next();
                            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                            if (!new File(next2).exists()) {
                                break;
                            }
                        }
                        Logger.m8697d(TAG, "makeCacheInfoList#success# " + encode + " " + z);
                        if (z) {
                            cacheDataInfo.setBackgroundInvert(getBackgroundColorInverted(context, uuid));
                            cacheDataInfo.initWidgetIdList();
                            cacheInfoList.put(uuid, cacheDataInfo);
                        } else {
                            file.deleteOnExit();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(objectInputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, e.getMessage());
        }
    }

    private final void removeCache(Context context, String uuid, int widgetId) {
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            if (!isDoneState(uuid)) {
                cacheDataInfo.setState(0);
                return;
            }
            Set<Integer> widgetIdList = cacheDataInfo.getWidgetIdList();
            Intrinsics.checkNotNull(widgetIdList);
            widgetIdList.remove(Integer.valueOf(widgetId));
            Set<Integer> widgetIdList2 = cacheDataInfo.getWidgetIdList();
            Intrinsics.checkNotNull(widgetIdList2);
            if (widgetIdList2.isEmpty()) {
                WidgetUtils.INSTANCE.removeCacheFiles(context, uuid);
                cacheDataInfo.setState(8);
                synchronized (this.mSync) {
                    Map<String, CacheDataInfo> map2 = this.mCacheInfoList;
                    Intrinsics.checkNotNull(map2);
                    map2.remove(uuid);
                }
            }
        }
    }

    private final boolean saveThumbnailFile(Context context, CacheDataInfo dataInfo, List<Bitmap> sources, String uuid, boolean dark) {
        Context context2;
        String str;
        boolean z;
        if (sources != null && !sources.isEmpty()) {
            int size = sources.size();
            int i = 0;
            while (i < size) {
                if (isStateToStopThread(context, dataInfo, uuid, 6)) {
                    return false;
                }
                List<String> thumbnailList = dataInfo.getThumbnailList();
                if (thumbnailList != null) {
                    context2 = context;
                    str = uuid;
                    z = dark;
                    thumbnailList.add(String.valueOf(WidgetUtils.INSTANCE.saveCaptureBitmap(context2, sources.get(i), str, i, z)));
                } else {
                    context2 = context;
                    str = uuid;
                    z = dark;
                }
                i++;
                context = context2;
                uuid = str;
                dark = z;
            }
        }
        return true;
    }

    @Nullable
    public final List<Bitmap> captureTextOnlyBitmap(@NotNull Context context, @NotNull String uuid, int widgetId, int widgetWidth, boolean isDarkMode, boolean shortcut, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().countUp("WIDGET_CAPTURE_TEXT_ONLY_NOTE");
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        List<Bitmap> listCaptureTextOnlyBitmap = this.mTextOnlyNoteManager.captureTextOnlyBitmap(context, map.get(uuid), uuid, widgetId, widgetWidth, isDarkMode, shortcut, providerName);
        companion.getInstance().countDown("WIDGET_CAPTURE_TEXT_ONLY_NOTE");
        return listCaptureTextOnlyBitmap;
    }

    public final void createThumbnail(@NotNull Context context, @NotNull String uuid, @Nullable String filePath, @NotNull CacheDataInfo data, boolean isOnePage, @Nullable SpenWNote note, @NotNull List<Integer> widgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(widgetIds, "widgetIds");
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().countUp("WIDGET_CREATE_THUMBNAIL");
        captureThumbnail(context, uuid, String.valueOf(filePath), data, isOnePage, note, widgetIds);
        companion.getInstance().countDown("WIDGET_CREATE_THUMBNAIL");
    }

    public final boolean existVoiceRecording(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return false;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMVoiceRecording();
        }
        return false;
    }

    @Nullable
    public final List<Bitmap> getBitmapList(@NotNull String uuid, boolean isDarkMode) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return null;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return isDarkMode ? cacheDataInfo.getDarkBitmapList() : cacheDataInfo.getLightBitmapList();
        }
        return null;
    }

    @Nullable
    public final String getFilePath(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return null;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMFilePath();
        }
        return null;
    }

    public final int getPageColor(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return -1;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMPageColor();
        }
        return -1;
    }

    public final int getPageCount(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return 0;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMTextOnly() ? (int) Math.max(cacheDataInfo.getMTextPageCount(), cacheDataInfo.getMPageCount()) : cacheDataInfo.getMPageCount();
        }
        return 0;
    }

    @Nullable
    public final String getTextOnlyThumbnailPath(@Nullable String uuid, int idx, boolean isDarkMode, int orientation, int width) {
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return null;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo == null || cacheDataInfo.getTextOnlyThumbnailList() == null) {
            return null;
        }
        List<String> textOnlyThumbnailList = cacheDataInfo.getTextOnlyThumbnailList();
        Intrinsics.checkNotNull(textOnlyThumbnailList);
        if (textOnlyThumbnailList.isEmpty()) {
            return null;
        }
        List<String> textOnlyThumbnailList2 = cacheDataInfo.getTextOnlyThumbnailList();
        Intrinsics.checkNotNull(textOnlyThumbnailList2);
        for (String str : textOnlyThumbnailList2) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            String str3 = width + "_" + orientation + "_" + idx + (isDarkMode ? WidgetUtils.BLACK_THEME_FILE_NAME : WidgetUtils.WHITE_THEME_FILE_NAME);
            if (!TextUtils.isEmpty(str2) && StringsKt.m14162r(str2, str3)) {
                return str2;
            }
        }
        return null;
    }

    @Nullable
    public final String getThumbnailPath(@NotNull String uuid, int idx, boolean isDarkMode) {
        List<String> thumbnailList;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return null;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo == null || (thumbnailList = cacheDataInfo.getThumbnailList()) == null || thumbnailList.isEmpty()) {
            return null;
        }
        List<String> thumbnailList2 = cacheDataInfo.getThumbnailList();
        Intrinsics.checkNotNull(thumbnailList2);
        for (String str : thumbnailList2) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            String strM1615e = AbstractC2322a.m1615e(idx, isDarkMode ? WidgetUtils.BLACK_THEME_FILE_NAME : WidgetUtils.WHITE_THEME_FILE_NAME);
            if (!TextUtils.isEmpty(str2) && StringsKt.m14162r(str2, strM1615e)) {
                return str2;
            }
        }
        return null;
    }

    public final boolean hasBackgroundImage(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return false;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMBackgroundImage();
        }
        return false;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetLogger.m5154d(TAG, "check thread: init - " + Thread.currentThread().getName());
        Logger.m8697d(TAG, "init#");
        synchronized (this.mSync) {
            try {
                if (this.mCacheInfoList != null) {
                    return;
                }
                Logger.m8697d(TAG, "init# start");
                this.mCacheInfoList = new ConcurrentHashMap();
                initSpen(context);
                for (int i : ProviderUtils.INSTANCE.getWidgetIdList(context)) {
                    String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(i);
                    Map<String, CacheDataInfo> map = this.mCacheInfoList;
                    Intrinsics.checkNotNull(map, "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.String, com.samsung.android.app.notes.widget.capture.CacheFileManager.CacheDataInfo>");
                    makeCacheInfoList(context, (ConcurrentHashMap) map, uuid);
                }
                Logger.m8697d(TAG, "init# end");
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isAfterLastModifyTime(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList != null && !TextUtils.isEmpty(uuid)) {
            Map<String, CacheDataInfo> map = this.mCacheInfoList;
            Intrinsics.checkNotNull(map);
            CacheDataInfo cacheDataInfo = map.get(uuid);
            long lastModifiedTime = getLastModifiedTime(context, uuid);
            if (cacheDataInfo != null && lastModifiedTime > 0 && cacheDataInfo.getMDocLastModifiedTime() < lastModifiedTime) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCacheFilesCleared(@Nullable Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList != null && !TextUtils.isEmpty(uuid)) {
            Map<String, CacheDataInfo> map = this.mCacheInfoList;
            Intrinsics.checkNotNull(map);
            CacheDataInfo cacheDataInfo = map.get(uuid);
            if (cacheDataInfo == null) {
                Logger.m8697d(TAG, "isValidCacheFiles# cacheDataInfo is null");
                return true;
            }
            if (!FileUtils.exists(WidgetUtils.INSTANCE.createCacheFilePath(context, uuid)) && cacheDataInfo.getMState() == 7) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCreateWidgetState(@Nullable Context context, @NotNull String uuid, int widgetId) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        boolean z = false;
        if (this.mCacheInfoList != null && !TextUtils.isEmpty(uuid)) {
            Map<String, CacheDataInfo> map = this.mCacheInfoList;
            Intrinsics.checkNotNull(map);
            CacheDataInfo cacheDataInfo = map.get(uuid);
            if (cacheDataInfo != null) {
                boolean z2 = cacheDataInfo.getMState() == 7;
                if (z2) {
                    z = z2;
                } else if (!new ThemeInfo(context, widgetId).isDarkMode() ? cacheDataInfo.getMState() == 6 || cacheDataInfo.getMState() == 5 : cacheDataInfo.getMState() == 6) {
                    z = true;
                }
            }
        }
        String encode = Logger.getEncode(uuid);
        StringBuilder sbM2226q = AbstractC2821a.m2226q("isCreateWidgetState# ", widgetId, ": ", z, " ");
        sbM2226q.append(encode);
        Logger.m8697d(TAG, sbM2226q.toString());
        return z;
    }

    public final boolean isDoneState(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        boolean z = false;
        if (this.mCacheInfoList != null && !TextUtils.isEmpty(uuid)) {
            Map<String, CacheDataInfo> map = this.mCacheInfoList;
            Intrinsics.checkNotNull(map);
            CacheDataInfo cacheDataInfo = map.get(uuid);
            if (cacheDataInfo != null && cacheDataInfo.getMState() == 7) {
                z = true;
            }
        }
        Logger.m8697d(TAG, "isDoneState# " + z + " " + Logger.getEncode(uuid));
        return z;
    }

    public final boolean isInitialized() {
        boolean z;
        synchronized (this.mSync) {
            z = this.mCacheInfoList != null;
            Unit unit = Unit.INSTANCE;
        }
        return z;
    }

    public final boolean isListPageMode(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return true;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMListMode();
        }
        return true;
    }

    public final boolean isNextPage(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList != null && !TextUtils.isEmpty(uuid)) {
            Map<String, CacheDataInfo> map = this.mCacheInfoList;
            Intrinsics.checkNotNull(map);
            CacheDataInfo cacheDataInfo = map.get(uuid);
            if (cacheDataInfo != null) {
                String thumbnailPath = INSTANCE.getInstance().getThumbnailPath(uuid, 1, false);
                if (cacheDataInfo.getMListMode() && WidgetUtils.INSTANCE.getCacheThumbnailFile(thumbnailPath) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isTextOnlyNote(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return false;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            return cacheDataInfo.getMTextOnly();
        }
        return false;
    }

    public final boolean isValidCacheFiles(@NotNull String uuid) {
        List<String> thumbnailList;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        boolean zIsEmpty = TextUtils.isEmpty(uuid);
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        boolean z = map == null;
        if (zIsEmpty || z) {
            Logger.m8697d(TAG, "isValidCacheFiles# empty, list: " + zIsEmpty + " " + z);
            return false;
        }
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo == null) {
            Logger.m8697d(TAG, "isValidCacheFiles# cacheDataInfo is null");
            return false;
        }
        if (cacheDataInfo.getThumbnailList() == null || ((thumbnailList = cacheDataInfo.getThumbnailList()) != null && thumbnailList.isEmpty())) {
            Logger.m8697d(TAG, "isValidCacheFiles# thumbnail list is null or empty");
            return false;
        }
        List<String> thumbnailList2 = cacheDataInfo.getThumbnailList();
        Intrinsics.checkNotNull(thumbnailList2);
        for (String str : thumbnailList2) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            if (!FileUtils.exists(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isValidFiles(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        boolean zIsEmpty = TextUtils.isEmpty(uuid);
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        boolean z = map == null;
        if (!zIsEmpty && !z) {
            CacheDataInfo cacheDataInfo = map != null ? map.get(uuid) : null;
            if (cacheDataInfo != null) {
                return FileUtils.exists(String.valueOf(cacheDataInfo.getMFilePath()));
            }
            Logger.m8697d(TAG, "isValidFiles# cacheDataInfo is null");
            return false;
        }
        Logger.m8697d(TAG, "isValidFiles# empty, list: " + zIsEmpty + " " + z);
        return false;
    }

    public final void removeCacheInfo(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        init(context);
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo != null) {
            String encode = Logger.getEncode(uuid);
            Logger.m8702i(TAG, "removeCacheInfo# start " + encode);
            if (isDoneState(uuid)) {
                AbstractC4539a.m3188B("removeCacheInfo# remove ", encode, TAG);
                WidgetUtils.INSTANCE.removeCacheFiles(context, uuid);
                cacheDataInfo.setState(8);
                synchronized (this.mSync) {
                    Map<String, CacheDataInfo> map2 = this.mCacheInfoList;
                    Intrinsics.checkNotNull(map2);
                    map2.remove(uuid);
                }
            } else if (cacheDataInfo.getMState() == 9) {
                AbstractC4539a.m3206p("removeCacheInfo# current state is READY_BY_SERVICE", encode, TAG);
            } else {
                long lastModifiedTime = getLastModifiedTime(context, uuid);
                if (lastModifiedTime > 0 && cacheDataInfo.getMDocLastModifiedTime() < lastModifiedTime) {
                    Logger.m8697d(TAG, "removeCacheInfo# state init " + encode);
                    cacheDataInfo.setState(0);
                }
            }
            AbstractC4539a.m3206p("removeCacheInfo# end ", encode, TAG);
        }
    }

    public final void saveTextOnlyData(@NotNull Context context, @Nullable String uuid, @NotNull List<Bitmap> sources, @Nullable String mUuid, boolean isDarkMode, int width, int orientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sources, "sources");
        if (this.mCacheInfoList == null || TextUtils.isEmpty(uuid)) {
            return;
        }
        Map<String, CacheDataInfo> map = this.mCacheInfoList;
        Intrinsics.checkNotNull(map);
        CacheDataInfo cacheDataInfo = map.get(uuid);
        if (cacheDataInfo == null || cacheDataInfo.getTextOnlyThumbnailList() == null) {
            return;
        }
        int size = sources.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            String cacheTextOnlyFilePath = companion.getCacheTextOnlyFilePath(context, mUuid, i, isDarkMode, width, orientation);
            if (!TextUtils.isEmpty(cacheTextOnlyFilePath)) {
                List<String> textOnlyThumbnailList = cacheDataInfo.getTextOnlyThumbnailList();
                Intrinsics.checkNotNull(textOnlyThumbnailList);
                if (!textOnlyThumbnailList.contains(cacheTextOnlyFilePath)) {
                    List<String> textOnlyThumbnailList2 = cacheDataInfo.getTextOnlyThumbnailList();
                    Intrinsics.checkNotNull(textOnlyThumbnailList2);
                    textOnlyThumbnailList2.add(cacheTextOnlyFilePath);
                    companion.saveCaptureTextOnlyBitmap(sources.get(i), cacheTextOnlyFilePath);
                    z = true;
                }
            }
        }
        if (z) {
            cacheDataInfo.saveData(context, uuid);
        }
    }

    private CacheFileManager() {
        this.mSync = new Object();
        this.mTextOnlyNoteManager = new TextOnlyNoteManager();
    }

    public final void removeCacheInfo(@NotNull Context context, @NotNull String uuid, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        init(context);
        removeCache(context, uuid, widgetId);
    }

    public final void removeCacheInfo(@NotNull Context context, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        Iterator<String> it = uuidList.iterator();
        while (it.hasNext()) {
            removeCacheInfo(context, it.next());
        }
    }

    private final void createCacheInfo(final Context context, final String uuid, final int widgetId, final String filePath, final CacheDataInfo data, final boolean isOnePage, Callback callback) {
        AbstractC4539a.m3203m(widgetId, "createCacheInfo# ", TAG);
        if (data == null || data.getMState() != 0) {
            return;
        }
        data.setState(1);
        Logger.m8697d(TAG, "createCacheInfo# capture state. start " + Logger.getEncode(uuid));
        data.addCallback(callback);
        new SenlThreadFactory(TAG).newThread(new Runnable() { // from class: L1.a
            @Override // java.lang.Runnable
            public final void run() {
                CacheFileManager.createCacheInfo$lambda$5(data, widgetId, this, context, uuid, filePath, isOnePage);
            }
        }).start();
    }

    public final void createCacheInfo(@NotNull Context context, @NotNull String uuid, @NotNull String filePath, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        createCacheInfo(context, uuid, widgetId, filePath, false, (Callback) null, true);
    }

    public final void createCacheInfo(@NotNull Context context, @NotNull String uuid, @NotNull String filePath, int widgetId, @Nullable Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        createCacheInfo(context, uuid, widgetId, filePath, false, callback, true);
    }

    @Nullable
    public final IAppWidgetCacheInfo createCacheInfo(@NotNull Context context, @NotNull String uuid, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return createCacheInfo(context, uuid, -1, filePath, false, (Callback) null, false);
    }
}
