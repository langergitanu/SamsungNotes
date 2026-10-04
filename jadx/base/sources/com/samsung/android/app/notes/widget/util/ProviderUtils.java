package com.samsung.android.app.notes.widget.util;

import android.app.KeyguardManager;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.DeviceTypeChecker;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J:\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fJ$\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\bJ\u0018\u0010%\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0018H\u0002J\u0018\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0005J\"\u0010(\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\bJ@\u0010-\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bJ\u0018\u00105\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u000e\u00106\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J(\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010,\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010:\u001a\u00020\u0005J\u001e\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=J\u0016\u0010@\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010A\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010D\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J(\u0010E\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\u0006\u0010,\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0005H\u0007J\u000e\u0010G\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/util/ProviderUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DISPLAY_CATEGORY_BUILTIN", "EXTRA_BUILT_IN_DISPLAY", "", "mObserverEasyMode", "Landroid/database/ContentObserver;", "sProviderClass", "Ljava/lang/Class;", "sShortcutProviderClass", "setProviderClasses", "", "providerClass", "shortCutProviderClass", "isProviderWidget", "", "context", "Landroid/content/Context;", "widgetId", "getWidgetIdList", "", "registerEasyModeContentObserver", "unregisterEasyModeContentObserver", "canIncreaseWidgetCount", BaseWidgetConstant.WIDGET_PREFERENCES, "Landroid/content/SharedPreferences;", "currentDisplay", "isFoldDevice", "uuid", "wId", "currentHomeMode", "isAvailableToReferWidget", "widgetProviderClass", "isWidgetMaxCount", "wIds", "isMakeWidgetContent", "isCurrentProviderWidget", "provider", "Landroid/content/ComponentName;", "convertOpacity", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "setWidgetTitle", "remoteViews", "Landroid/widget/RemoteViews;", "title", "isVisible", "layoutId", "titleId", "titleShadowId", "removePreviousCache", "openMemoList", "updateAppWidget", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", NotesConstants.KEY_CALLER, "checkEventTime", "currentTime", "", "previousTime", "skipTime", "isTextOnlyNote", "isCoverScreen", "getDisplayForSubAlert", "Landroid/view/Display;", "createWidgetCoverContext", "getCoverScreenCutout", "providerName", "isFullScreenSubDisplay", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nProviderUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderUtils.kt\ncom/samsung/android/app/notes/widget/util/ProviderUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,337:1\n1#2:338\n*E\n"})
public final class ProviderUtils {

    @NotNull
    private static final String DISPLAY_CATEGORY_BUILTIN = "com.samsung.android.hardware.display.category.BUILTIN";
    public static final int EXTRA_BUILT_IN_DISPLAY = 1;

    @NotNull
    private static final String TAG = "ProviderUtils";

    @Nullable
    private static ContentObserver mObserverEasyMode;

    @Nullable
    private static Class<?> sProviderClass;

    @Nullable
    private static Class<?> sShortcutProviderClass;

    @NotNull
    public static final ProviderUtils INSTANCE = new ProviderUtils();
    public static final int $stable = 8;

    private ProviderUtils() {
    }

    @JvmStatic
    public static final boolean canIncreaseWidgetCount(@NotNull SharedPreferences widgetPref, int currentDisplay, boolean isFoldDevice, @NotNull String uuid, int wId, @Nullable String currentHomeMode) {
        Intrinsics.checkNotNullParameter(widgetPref, "widgetPref");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        String string = widgetPref.getString(BaseWidgetConstant.WIDGET_ID + wId, BaseWidgetConstant.NONE);
        int i = widgetPref.getInt(AbstractC0541b.m767i(wId, BaseWidgetConstant.WIDGET_ID, WidgetConstant.WIDGET_DISPLAY_DEVICE), DisplayDeviceTypeCompat.INSTANCE.getDISPLAY_DEVICE_TYPE_NONE());
        String string2 = widgetPref.getString(BaseWidgetConstant.WIDGET_ID + wId + BaseWidgetConstant.WIDGET_HOME_MODE, BaseWidgetConstant.NONE_HOME_MODE);
        boolean z = Intrinsics.areEqual(BaseWidgetConstant.NONE, string) || Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE) || Intrinsics.areEqual(string, uuid);
        boolean zAreEqual = Intrinsics.areEqual(string2, currentHomeMode);
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        String encode = widgetLogger.getEncode(uuid);
        Intrinsics.checkNotNull(string);
        String encode2 = widgetLogger.getEncode(string);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("canIncreaseWidgetCount - id : ", wId, ", uuid: ", encode, ", referUuid: ");
        sbM1629s.append(encode2);
        WidgetLogger.m5154d(TAG, sbM1629s.toString());
        WidgetLogger.m5154d(TAG, "canIncreaseWidgetCount - widgetHomeMode: " + string2 + ", currentHomeMode: " + currentHomeMode);
        if (!zAreEqual) {
            return false;
        }
        if (!isFoldDevice) {
            return z;
        }
        WidgetLogger.m5154d(TAG, "canIncreaseWidgetCount - widgetDisplay: " + i + ", currentDisplay: " + currentDisplay);
        return z && currentDisplay == i;
    }

    @JvmStatic
    @Nullable
    public static final Context createWidgetCoverContext(@Nullable Context context) {
        Object systemService = context != null ? context.getSystemService("display") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Iterator it = ArrayIteratorKt.iterator(((DisplayManager) systemService).getDisplays(DISPLAY_CATEGORY_BUILTIN));
        while (it.hasNext()) {
            Display display = (Display) it.next();
            if (display.getDisplayId() == 1) {
                return context.createDisplayContext(display);
            }
        }
        return context;
    }

    @JvmStatic
    public static final boolean isProviderWidget(@NotNull Context context, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Class<?> cls = sProviderClass;
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(cls != null ? new ComponentName(context, cls) : null)) {
            if (i == widgetId) {
                return true;
            }
        }
        return false;
    }

    private final boolean isWidgetMaxCount(Context context, int[] wIds) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        int displayDeviceType = DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(context);
        String homeMode = HomeScreenUtils.INSTANCE.getHomeMode(context);
        boolean zIsFoldDeviceType = DeviceTypeChecker.INSTANCE.isFoldDeviceType();
        int i = 0;
        for (int i2 : wIds) {
            if (i2 != -1) {
                Intrinsics.checkNotNull(sharedPreferences);
                if (canIncreaseWidgetCount(sharedPreferences, displayDeviceType, zIsFoldDeviceType, BaseWidgetConstant.NONE, i2, homeMode)) {
                    i++;
                }
            }
        }
        WidgetLogger.m5154d(TAG, "isWidgetMaxCount - count : " + i);
        return i < (DeviceUtils.isOldSepLiteModel() ? 3 : 20);
    }

    public final boolean checkEventTime(long currentTime, long previousTime, long skipTime) {
        return currentTime > previousTime || currentTime + skipTime < previousTime;
    }

    public final void convertOpacity(int appWidgetId) {
        int widgetPreferenceManagerReverseTransparency;
        int iRound;
        if (WidgetUtils.INSTANCE.needReverseColor(appWidgetId)) {
            WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
            if (widgetPreferenceManager.getEmptyTransparency(appWidgetId) < 0) {
                widgetPreferenceManagerReverseTransparency = -1;
                iRound = 100;
            } else {
                widgetPreferenceManagerReverseTransparency = widgetPreferenceManager.getWidgetPreferenceManagerReverseTransparency(appWidgetId);
                iRound = Math.round(widgetPreferenceManagerReverseTransparency / 10.0f) * 10;
            }
            StringBuilder sbM1173s = AbstractC0622a.m1173s(appWidgetId, widgetPreferenceManagerReverseTransparency, "convertOpacity# ", " : ", SQLKeyword.COMMA);
            sbM1173s.append(iRound);
            WidgetLogger.m5154d(TAG, sbM1173s.toString());
            BaseWidgetPreferenceManager.INSTANCE.saveTransparency(appWidgetId, iRound);
        }
    }

    @RequiresApi(33)
    public final int getCoverScreenCutout(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(appWidgetId);
        boolean zIsFullScreenSubDisplay = isFullScreenSubDisplay(context);
        Rect rect = (Rect) appWidgetOptions.getParcelable("cutOutTopRect", Rect.class);
        Rect rect2 = (Rect) appWidgetOptions.getParcelable("cutOutBottomRect", Rect.class);
        WidgetLogger.m5154d(providerName, "isFullScreenSubDisplay : " + zIsFullScreenSubDisplay + ", cutoutTopRect : " + rect + ", cutoutBottomRect : " + rect2 + "top width-height: " + (rect != null ? Integer.valueOf(rect.width()) : null) + " - " + (rect != null ? Integer.valueOf(rect.height()) : null) + "bottom width-height: " + (rect2 != null ? Integer.valueOf(rect2.width()) : null) + " - " + (rect2 != null ? Integer.valueOf(rect2.height()) : null));
        if (!zIsFullScreenSubDisplay) {
            return 0;
        }
        if (rect != null && rect.width() > 0 && rect.height() > 0) {
            WidgetLogger.m5154d(providerName, "update widget with cutout top rect");
            return 1;
        }
        if (rect2 == null || rect2.width() <= 0 || rect2.height() <= 0) {
            return 0;
        }
        WidgetLogger.m5154d(providerName, "update widget with cutout bottom rect");
        return 2;
    }

    @Nullable
    public final Display getDisplayForSubAlert(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display[] displays = ((DisplayManager) systemService).getDisplays(DISPLAY_CATEGORY_BUILTIN);
        if (displays.length > 1) {
            return displays[1];
        }
        return null;
    }

    @NotNull
    public final int[] getWidgetIdList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Class<?> cls = sShortcutProviderClass;
        ComponentName componentName = cls != null ? new ComponentName(context, cls) : null;
        Class<?> cls2 = sProviderClass;
        ComponentName componentName2 = cls2 != null ? new ComponentName(context, cls2) : null;
        int[] appWidgetIds = componentName2 != null ? AppWidgetManager.getInstance(context).getAppWidgetIds(componentName2) : new int[0];
        int[] appWidgetIds2 = componentName != null ? AppWidgetManager.getInstance(context).getAppWidgetIds(componentName) : new int[0];
        int[] iArr = new int[appWidgetIds.length + appWidgetIds2.length];
        System.arraycopy(appWidgetIds, 0, iArr, 0, appWidgetIds.length);
        System.arraycopy(appWidgetIds2, 0, iArr, appWidgetIds.length, appWidgetIds2.length);
        return iArr;
    }

    public final boolean isAvailableToReferWidget(@NotNull Context context, @Nullable Class<?> widgetProviderClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(widgetProviderClass != null ? new ComponentName(context, widgetProviderClass) : null);
        Intrinsics.checkNotNull(appWidgetIds);
        return isWidgetMaxCount(context, appWidgetIds);
    }

    public final boolean isCoverScreen(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        return ((KeyguardManager) systemService).isKeyguardLocked();
    }

    public final boolean isCurrentProviderWidget(@Nullable Context context, @Nullable ComponentName provider, int widgetId) {
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(provider)) {
            if (i == widgetId) {
                return true;
            }
        }
        return false;
    }

    public final boolean isFullScreenSubDisplay(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("com.samsung.feature.full_screen_sub_display");
    }

    public final boolean isMakeWidgetContent(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository();
        return mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(String.valueOf(uuid)) != null && mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(String.valueOf(uuid)).getIsDeleted() == 0 && mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(String.valueOf(uuid)).getIsLock() == 0;
    }

    public final boolean isTextOnlyNote(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            return false;
        }
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        if (!companion.getInstance().isInitialized()) {
            companion.getInstance().init(context);
        }
        return companion.getInstance().isTextOnlyNote(uuid);
    }

    public final void openMemoList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (NoteListAccessHandler.getNoteListClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(context, NoteListAccessHandler.getNoteListClass());
        WidgetBroadcast.sendUpdateAllWidgetBroadcast(context);
        intent.setFlags(335544320);
        MultiTaskManager.INSTANCE.getInstance().startActivity(context, intent);
    }

    public final void registerEasyModeContentObserver(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (ProviderUtils.class) {
            try {
                if (mObserverEasyMode == null) {
                    WidgetLogger.m5154d(TAG, "create EasyMode ContentObserver");
                    final Handler handler = new Handler();
                    mObserverEasyMode = new ContentObserver(handler) { // from class: com.samsung.android.app.notes.widget.util.ProviderUtils$registerEasyModeContentObserver$1$1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean selfChange) {
                            super.onChange(selfChange);
                            WidgetLogger.m5154d("ProviderUtils", "onChange EasyMode - " + (SettingsCompat.INSTANCE.getInstance().getEasyMode(context) != 1));
                            WidgetBroadcast.sendUpdateAllWidgetBroadcast(context);
                        }
                    };
                    Uri easyModeUri = SettingsCompat.INSTANCE.getInstance().getEasyModeUri();
                    if (mObserverEasyMode != null && easyModeUri != null) {
                        ContentResolver contentResolver = context.getContentResolver();
                        ContentObserver contentObserver = mObserverEasyMode;
                        Intrinsics.checkNotNull(contentObserver);
                        contentResolver.registerContentObserver(easyModeUri, false, contentObserver);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void removePreviousCache(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        if (!companion.getInstance().isInitialized()) {
            companion.getInstance().init(context);
        }
        if (companion.getInstance().isDoneState(String.valueOf(uuid)) && companion.getInstance().isAfterLastModifyTime(context, String.valueOf(uuid))) {
            companion.getInstance().removeCacheInfo(context, String.valueOf(uuid));
        } else {
            WidgetLogger.m5156w(TAG, "removePreviousCache# skip");
        }
    }

    public final void setProviderClasses(@Nullable Class<?> providerClass, @Nullable Class<?> shortCutProviderClass) {
        sProviderClass = providerClass;
        sShortcutProviderClass = shortCutProviderClass;
    }

    public final void setWidgetTitle(@NotNull Context context, @NotNull RemoteViews remoteViews, @Nullable String title, boolean isVisible, int layoutId, int titleId, int titleShadowId) {
        String strM756B;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        if (TextUtils.isEmpty(title)) {
            strM756B = AbstractC0541b.m756B(context.getResources().getString(C11391R.string.widget_shortcut_to_untitled_note), SQLKeyword.COMMA);
            title = " ";
        } else {
            strM756B = AbstractC0541b.m756B(context.getResources().getString(C11391R.string.widget_shortcut_to_title_note, title), SQLKeyword.COMMA);
        }
        remoteViews.setViewVisibility(layoutId, isVisible ? 0 : 8);
        remoteViews.setTextViewText(titleId, title);
        remoteViews.setTextViewText(titleShadowId, title);
        remoteViews.setContentDescription(titleId, strM756B + context.getResources().getString(C11391R.string.widget_shortcut_open_note));
    }

    public final void unregisterEasyModeContentObserver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (ProviderUtils.class) {
            try {
                if (mObserverEasyMode != null) {
                    WidgetLogger.m5154d(TAG, "unregisterEasyModeContentObserver");
                    ContentResolver contentResolver = context.getContentResolver();
                    ContentObserver contentObserver = mObserverEasyMode;
                    Intrinsics.checkNotNull(contentObserver);
                    contentResolver.unregisterContentObserver(contentObserver);
                    mObserverEasyMode = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateAppWidget(@NotNull AppWidgetManager appWidgetManager, int appWidgetId, @Nullable RemoteViews remoteViews, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(caller, "caller");
        if (remoteViews == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, AbstractC2322a.m1616f(appWidgetId, "updateAppWidget# remoteViews is null from id = ", "/ caller = ", caller));
            return;
        }
        WidgetLogger.m5155i(TAG, "updateAppWidget# widgetId = " + appWidgetId + "/ caller = " + caller);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    public final boolean isAvailableToReferWidget(@NotNull Context context, @Nullable Class<?> widgetProviderClass, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(widgetProviderClass != null ? new ComponentName(context, widgetProviderClass) : null);
        int length = appWidgetIds.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (appWidgetIds[i] == widgetId) {
                appWidgetIds[i] = -1;
                break;
            }
            i++;
        }
        Intrinsics.checkNotNull(appWidgetIds);
        return isWidgetMaxCount(context, appWidgetIds);
    }
}
