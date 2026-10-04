package com.samsung.android.app.notes.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.DeviceTypeChecker;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListMediumCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleMediumCoverProvider;
import com.samsung.android.app.notes.widget.lockbrief.single.WidgetSingleLockBriefProvider;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.util.WidgetBRHelper;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005J0\u0010\u0018\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00190\u0014j\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019`\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0015H\u0007JB\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bJ \u0010'\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0005J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/AppWidgetUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sWidgetProviderList", "", "Ljava/lang/Class;", "widgetSingleCoverProviderClassList", "getWidgetSingleCoverProviderClassList", "()Ljava/util/List;", "widgetListCoverProviderClassList", "widgetSingleLockBriefProviderClassList", "getWidgetSingleLockBriefProviderClassList", "widgetProviderClassAll", "getWidgetUuidList", "context", "Landroid/content/Context;", "getWidgetIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uuid", "getWidgetInfoList", "", "isAvailableToAddWidget", "", "widgetId", "canIncreaseWidgetCount", BaseWidgetConstant.WIDGET_PREFERENCES, "Landroid/content/SharedPreferences;", "currentDisplay", "isFoldDevice", "wId", "currentHomeMode", "getWidgetRatio", "", "provider", "updateWidgetFilePath", "newPath", "deleteOldWidgetBackupData", "", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppWidgetUtils {
    public static final int $stable;

    @NotNull
    public static final AppWidgetUtils INSTANCE = new AppWidgetUtils();

    @NotNull
    private static final String TAG = "AppWidgetUtils";

    @NotNull
    private static final List<Class<?>> sWidgetProviderList;

    @NotNull
    private static final List<Class<?>> widgetListCoverProviderClassList;

    @NotNull
    private static final List<Class<?>> widgetProviderClassAll;

    @NotNull
    private static final List<Class<?>> widgetSingleCoverProviderClassList;

    @NotNull
    private static final List<Class<?>> widgetSingleLockBriefProviderClassList;

    static {
        ArrayList arrayList = new ArrayList(CollectionsKt.listOf((Object[]) new Class[]{WidgetProvider.class, WidgetImgShortCutProvider.class, WidgetListProvider.class}));
        sWidgetProviderList = arrayList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.listOf((Object[]) new Class[]{WidgetSingleMediumCoverProvider.class, WidgetSingleLargeCoverProvider.class, WidgetSingleExtraLargeCoverProvider.class}));
        widgetSingleCoverProviderClassList = arrayList2;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.listOf((Object[]) new Class[]{WidgetListMediumCoverProvider.class, WidgetListLargeCoverProvider.class, WidgetListExtraLargeCoverProvider.class}));
        widgetListCoverProviderClassList = arrayList3;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.listOf(WidgetSingleLockBriefProvider.class));
        widgetSingleLockBriefProviderClassList = arrayList4;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(arrayList);
        listCreateListBuilder.addAll(arrayList2);
        listCreateListBuilder.addAll(arrayList3);
        listCreateListBuilder.addAll(arrayList4);
        widgetProviderClassAll = CollectionsKt.build(listCreateListBuilder);
        $stable = 8;
    }

    private AppWidgetUtils() {
    }

    private final boolean canIncreaseWidgetCount(SharedPreferences widgetPref, int currentDisplay, boolean isFoldDevice, String uuid, int widgetId, int wId, String currentHomeMode) {
        String string = widgetPref.getString(BaseWidgetConstant.WIDGET_ID + wId, BaseWidgetConstant.NONE);
        int i = widgetPref.getInt(AbstractC0541b.m767i(wId, BaseWidgetConstant.WIDGET_ID, WidgetConstant.WIDGET_DISPLAY_DEVICE), DisplayDeviceTypeCompat.INSTANCE.getDISPLAY_DEVICE_TYPE_NONE());
        String string2 = widgetPref.getString(BaseWidgetConstant.WIDGET_ID + wId + BaseWidgetConstant.WIDGET_HOME_MODE, BaseWidgetConstant.NONE_HOME_MODE);
        boolean z = Intrinsics.areEqual(string, uuid) && wId != widgetId;
        boolean zAreEqual = Intrinsics.areEqual(string2, currentHomeMode);
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        String encode = widgetLogger.getEncode(uuid);
        String encode2 = widgetLogger.getEncode(String.valueOf(string));
        StringBuilder sbM1173s = AbstractC0622a.m1173s(wId, widgetId, "canIncreaseWidgetCount - id : ", " widgetId: ", ", uuid: ");
        sbM1173s.append(encode);
        sbM1173s.append(", referUuid: ");
        sbM1173s.append(encode2);
        WidgetLogger.m5154d(TAG, sbM1173s.toString());
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
    @NotNull
    public static final ArrayList<String[]> getWidgetInfoList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<String[]> arrayList = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        for (Class<?> cls : widgetProviderClassAll) {
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, cls));
            if (Intrinsics.areEqual(WidgetListProvider.class, cls) || Intrinsics.areEqual(WidgetListMediumCoverProvider.class, cls) || Intrinsics.areEqual(WidgetListLargeCoverProvider.class, cls) || Intrinsics.areEqual(WidgetListExtraLargeCoverProvider.class, cls)) {
                for (int i : appWidgetIds) {
                    arrayList.add(new String[]{String.valueOf(i), null});
                }
            } else {
                for (int i2 : appWidgetIds) {
                    arrayList.add(new String[]{String.valueOf(i2), sharedPreferences.getString(BaseWidgetConstant.WIDGET_ID + i2, BaseWidgetConstant.NONE)});
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<String> getWidgetUuidList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        arrayList.add(sharedPreferences.getString(WidgetConstant.WIDGET_PIN_TO_HOME, BaseWidgetConstant.NONE));
        for (Class<?> cls : widgetProviderClassAll) {
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, cls));
            if (Intrinsics.areEqual(WidgetListProvider.class, cls) || Intrinsics.areEqual(WidgetListMediumCoverProvider.class, cls) || Intrinsics.areEqual(WidgetListLargeCoverProvider.class, cls) || Intrinsics.areEqual(WidgetListExtraLargeCoverProvider.class, cls)) {
                for (int i : appWidgetIds) {
                    arrayList.addAll(WidgetPreferenceManager.INSTANCE.getNoteUuidList(i));
                }
            } else {
                for (int i2 : appWidgetIds) {
                    arrayList.add(sharedPreferences.getString(BaseWidgetConstant.WIDGET_ID + i2, BaseWidgetConstant.NONE));
                }
            }
        }
        return arrayList;
    }

    public final void deleteOldWidgetBackupData(@NotNull AppWidgetManager appWidgetManager, int appWidgetId) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        if (appWidgetManager.getAppWidgetOptions(appWidgetId) != null) {
            i = appWidgetManager.getAppWidgetOptions(appWidgetId).getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
            i2 = appWidgetManager.getAppWidgetOptions(appWidgetId).getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
        } else {
            i = 0;
            i2 = 0;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "deleteOldWidgetBackupData# oldWidgetID = ", "/ newWidgetID = ", " appWidgetId ");
        sbM1173s.append(appWidgetId);
        WidgetLogger.m5155i(TAG, sbM1173s.toString());
        if (i == 0 || i2 == 0) {
            return;
        }
        WidgetBRHelper.deleteWidgetInfoWithoutUuid(i);
    }

    @NotNull
    public final ArrayList<Integer> getWidgetIdList(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ArrayList<Integer> arrayList = new ArrayList<>();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        Iterator<Class<?>> it = sWidgetProviderList.iterator();
        while (it.hasNext()) {
            for (int i : appWidgetManager.getAppWidgetIds(new ComponentName(context, it.next()))) {
                if (Intrinsics.areEqual(uuid, sharedPreferences.getString(BaseWidgetConstant.WIDGET_ID + i, BaseWidgetConstant.NONE))) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList;
    }

    public final float getWidgetRatio(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getWidgetRatio(context, null);
    }

    @NotNull
    public final List<Class<?>> getWidgetSingleCoverProviderClassList() {
        return widgetSingleCoverProviderClassList;
    }

    @NotNull
    public final List<Class<?>> getWidgetSingleLockBriefProviderClassList() {
        return widgetSingleLockBriefProviderClassList;
    }

    public final boolean isAvailableToAddWidget(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return isAvailableToAddWidget(context, uuid, -1);
    }

    public final boolean updateWidgetFilePath(@NotNull Context context, @NotNull String uuid, @Nullable String newPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        boolean z = false;
        for (Class<?> cls : sWidgetProviderList) {
            if (cls != null) {
                for (int i : appWidgetManager.getAppWidgetIds(new ComponentName(context, cls))) {
                    if (Intrinsics.areEqual(sharedPreferences.getString(BaseWidgetConstant.WIDGET_ID + i, BaseWidgetConstant.NONE), uuid)) {
                        WidgetPreferenceManager.INSTANCE.saveWidgetPrefFilePath(i, newPath);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isAvailableToAddWidget(@NotNull Context context, @NotNull String uuid, int widgetId) {
        List<Class<?>> list;
        Intrinsics.checkNotNullParameter(context, "context");
        String uuid2 = uuid;
        Intrinsics.checkNotNullParameter(uuid2, "uuid");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        HomeScreenUtils homeScreenUtils = HomeScreenUtils.INSTANCE;
        int widgetAddDisplayType = homeScreenUtils.getWidgetAddDisplayType(context);
        String homeMode = homeScreenUtils.getHomeMode(context);
        boolean zIsFoldDeviceType = DeviceTypeChecker.INSTANCE.isFoldDeviceType();
        String string = sharedPreferences.getString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.WIDGET_PROVIDER_NAME, "");
        if (string != null) {
            switch (string.hashCode()) {
                case -1810065740:
                    list = string.equals(BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME) ? widgetSingleLockBriefProviderClassList : sWidgetProviderList;
                    break;
                case 55058489:
                    if (string.equals("WidgetSingleLargeCoverProvider")) {
                        list = widgetSingleCoverProviderClassList;
                        break;
                    }
                    break;
                case 190750183:
                    if (!string.equals(BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME)) {
                    }
                    break;
                case 1341081105:
                    if (string.equals("WidgetSingleExtraLargeCoverProvider")) {
                    }
                    break;
            }
        }
        int i = 0;
        for (Class<?> cls : list) {
            WidgetLogger.m5154d(TAG, "isAvailableToAddWidget - widgetClass: " + cls);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, cls));
            int length = appWidgetIds.length;
            int i2 = i;
            int i4 = 0;
            while (i4 < length) {
                int i5 = appWidgetIds[i4];
                AppWidgetUtils appWidgetUtils = INSTANCE;
                Intrinsics.checkNotNull(sharedPreferences);
                if (appWidgetUtils.canIncreaseWidgetCount(sharedPreferences, widgetAddDisplayType, zIsFoldDeviceType, uuid2, widgetId, i5, homeMode)) {
                    i2++;
                }
                i4++;
                uuid2 = uuid;
            }
            uuid2 = uuid;
            i = i2;
        }
        WidgetLogger.m5154d(TAG, "isAvailableToAddWidget - widgetId: " + widgetId + ", count : " + i);
        return i < 1;
    }

    public final float getWidgetRatio(@NotNull Context context, @Nullable Class<?> provider) {
        Intrinsics.checkNotNullParameter(context, "context");
        float f = 720 >= context.getResources().getDisplayMetrics().widthPixels ? 0.8f : 0.7f;
        if (provider != null && BaseWidgetUtils.INSTANCE.getWidgetCount(context, provider) <= 10) {
            f = 1.0f;
        }
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() * 0.6f < runtime.totalMemory() - runtime.freeMemory()) {
            f = 0.25f;
        }
        WidgetLogger.m5154d(TAG, "widget ratio  = " + f);
        return f;
    }
}
