package com.samsung.android.support.senl.p148nt.base.widget.util;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/util/BaseWidgetUtils;", "", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BaseWidgetUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_NEED_DARK_FONT = "need_dark_font";
    private static final int NEED_DARK_FONT_DEFAULT = 0;

    @NotNull
    private static final String TAG = "BaseWidgetUtils";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ,\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bJ\u0018\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\bJ2\u0010\u001b\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001fJ0\u0010 \u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\"0!j\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\"`#2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010&\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ0\u0010'\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bJ\u0018\u0010,\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\bJ\u0016\u0010.\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010-\u001a\u00020\bJ \u0010/\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bJ,\u00101\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00102\u001a\u0004\u0018\u00010\u00052\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u000104J\u001e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005J\b\u0010:\u001a\u00020\nH\u0007J\u0006\u0010;\u001a\u00020\nJ\u0010\u0010<\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0006\u0010=\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0011\u0010%\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010\u000e¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/util/BaseWidgetUtils$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "KEY_NEED_DARK_FONT", "NEED_DARK_FONT_DEFAULT", "", "isWhiteWallPaper", "", "context", "Landroid/content/Context;", "isNotSupportMatchWithDarkMode", "()Z", "checkTheme", "transparency", "backgroundColor", "checkThemeSetting", "oneUiWidgetSource", "checkThemeOneUi7x", "convertAlpha", "alpha", "getProgressToString", "progress", "isMatchWithDarkModeAndNightMode", "darkMode", "isChangedTheme", BaseWidgetConstant.WIDGET_THEME, "getWidgetCount", "provider", "Ljava/lang/Class;", "getWidgetToolbarInfoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isFoldSettingLayout", "isFoldWidgetLayout", "isTabletLandscapeLayout", "getWidgetLayoutId", "widgetId", "phonePortLayout", "phoneLayout", "defaultLayout", "isDarkModeChange", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "isFoldOrientationChange", "getCurrentBackgroundColor", "bgColor", "isWidgetNote", "docUuid", "widgetUuids", "", "notifyWidgetNoteConverted", "", StateHandler.KEY_APP_STATE, "sdocUuid", "sdocxUuid", "isSupportedNewWidget", "isSupportedOneUI7WidgetEnabled", "getWidgetAddDisplayType", "isQ7mModel", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nBaseWidgetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseWidgetUtils.kt\ncom/samsung/android/support/senl/nt/base/widget/util/BaseWidgetUtils$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,266:1\n1#2:267\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ int checkThemeSetting$default(Companion companion, Context context, int i, int i2, String str, int i4, Object obj) {
            if ((i4 & 8) != 0) {
                str = null;
            }
            return companion.checkThemeSetting(context, i, i2, str);
        }

        public final int checkTheme(@Nullable Context context, int transparency, int backgroundColor) {
            if (isSupportedNewWidget()) {
                return checkThemeOneUi7x(backgroundColor);
            }
            boolean zIsWhiteWallPaper = isWhiteWallPaper(context);
            return backgroundColor == 1 ? (!zIsWhiteWallPaper && transparency > 50) ? 0 : 1 : (!zIsWhiteWallPaper || transparency <= 50) ? 0 : 1;
        }

        public final int checkThemeOneUi7x(int backgroundColor) {
            return backgroundColor == 1 ? 1 : 0;
        }

        public final int checkThemeSetting(@Nullable Context context, int transparency, int backgroundColor, @Nullable String oneUiWidgetSource) {
            boolean zIsWhiteWallPaper = isWhiteWallPaper(context);
            if (backgroundColor != 1) {
                return zIsWhiteWallPaper ? transparency <= 50 ? 0 : 1 : (transparency <= 50 || !Intrinsics.areEqual(oneUiWidgetSource, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE) || ContextUtils.isNightMode(context)) ? 0 : 1;
            }
            if (zIsWhiteWallPaper) {
                return 1;
            }
            return Intrinsics.areEqual(oneUiWidgetSource, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE) ? (ContextUtils.isNightMode(context) && transparency > 50) ? 0 : 1 : transparency <= 50 ? 1 : 0;
        }

        public final int convertAlpha(int alpha) {
            int i = 100 - alpha;
            if (i == 0) {
                return i;
            }
            return (int) ((i / 100.0f) * 255);
        }

        public final int getCurrentBackgroundColor(@Nullable Context context, int bgColor, int darkMode) {
            if (isMatchWithDarkModeAndNightMode(context, darkMode)) {
                return 0;
            }
            return bgColor;
        }

        @NotNull
        public final String getProgressToString(int progress) {
            return AbstractC0541b.m756B(LocaleUtils.isRTLMode() ? LocaleUtils.convertToArabicNumber(progress) : String.valueOf(progress), "%");
        }

        public final int getWidgetAddDisplayType(@Nullable Context context) {
            return DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(context);
        }

        public final int getWidgetCount(@NotNull Context context, @Nullable Class<?> provider) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppWidgetManager.getInstance(context).getAppWidgetIds(provider != null ? new ComponentName(context, provider) : null).length;
        }

        public final int getWidgetLayoutId(@Nullable Context context, int widgetId, int phonePortLayout, int phoneLayout, int defaultLayout) {
            if (!isFoldWidgetLayout()) {
                Logger.m8702i(BaseWidgetUtils.TAG, "getWidgetLayoutId# widgetId: " + widgetId + ", default layout");
                return defaultLayout;
            }
            if (HomeScreenUtils.INSTANCE.isCurrentCoverScreenMirroringDisplay(context)) {
                Logger.m8702i(BaseWidgetUtils.TAG, "getWidgetLayoutId# widgetId: " + widgetId + ",  phone portrait layout");
                return phonePortLayout;
            }
            Logger.m8702i(BaseWidgetUtils.TAG, "getWidgetLayoutId# widgetId: " + widgetId + ", phone layout");
            return phoneLayout;
        }

        @JvmStatic
        @NotNull
        public final ArrayList<String[]> getWidgetToolbarInfoList(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList<String[]> arrayList = new ArrayList<>();
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            try {
                Class<?> widgetToolbarProviderClass = WidgetAccessHandler.getWidgetToolbarProviderClass();
                if (widgetToolbarProviderClass == null) {
                    PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
                    widgetToolbarProviderClass = WidgetAccessHandler.getWidgetToolbarProviderClass();
                }
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(widgetToolbarProviderClass != null ? new ComponentName(context, widgetToolbarProviderClass) : null);
                for (int i : appWidgetIds) {
                    arrayList.add(new String[]{String.valueOf(i), null});
                }
                return arrayList;
            } catch (Exception e) {
                AbstractC4539a.m3214x("getWidgetToolbarInfoList# fail toolbarWidget list. ", e.getMessage(), BaseWidgetUtils.TAG);
                return arrayList;
            }
        }

        public final boolean isChangedTheme(@Nullable Context context, int theme, int transparency, int backgroundColor, @Nullable String oneUiWidgetSource) {
            return checkThemeSetting(context, transparency, backgroundColor, oneUiWidgetSource) != theme;
        }

        public final boolean isDarkModeChange(@Nullable Context context, int appWidgetId) {
            if (isSupportedNewWidget()) {
                return (BaseWidgetPreferenceManager.INSTANCE.getDarkMode(appWidgetId) == 1) != ContextUtils.isNightMode(context);
            }
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            return companion.getDarkMode(appWidgetId) == 1 && companion.getWidgetNightModeTheme(appWidgetId) != ContextUtils.isNightMode(context);
        }

        public final boolean isFoldOrientationChange(@NotNull Context context, int appWidgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
            int widgetOrientationPref = BaseWidgetPreferenceManager.INSTANCE.getWidgetOrientationPref(appWidgetId);
            int i = context.getResources().getConfiguration().orientation;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(appWidgetId, widgetOrientationPref, "isFoldOrientationChange# ", SQLKeyword.COMMA, SQLKeyword.COMMA);
            sbM1173s.append(i);
            Logger.m8702i(BaseWidgetUtils.TAG, sbM1173s.toString());
            return isFoldWidgetLayout() && HomeScreenUtils.INSTANCE.getWidgetAddDisplayType(context) == DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_SUB && widgetOrientationPref != i;
        }

        public final boolean isFoldSettingLayout() {
            return (!ModelFeature.getFeature().isFoldableModel() || ModelFeature.getFeature().getIsWinnerDevice() || isQ7mModel()) ? false : true;
        }

        public final boolean isFoldWidgetLayout() {
            return ModelFeature.getFeature().getIsQ2Device() || ModelFeature.getFeature().getIsQ4Device() || ModelFeature.getFeature().getIsQ5Device() || ModelFeature.getFeature().getIsQ6Device() || ModelFeature.getFeature().getIsQ7Device();
        }

        public final boolean isMatchWithDarkModeAndNightMode(@Nullable Context context, int darkMode) {
            return !isNotSupportMatchWithDarkMode() && darkMode == 1 && ContextUtils.isNightMode(context);
        }

        public final boolean isNotSupportMatchWithDarkMode() {
            return Build.VERSION.SDK_INT < 29;
        }

        public final boolean isQ7mModel() {
            return StringsKt.m14145S(DeviceUtils.getSubModelName(), "F968");
        }

        @JvmStatic
        public final boolean isSupportedNewWidget() {
            return isSupportedOneUI7WidgetEnabled();
        }

        public final boolean isSupportedOneUI7WidgetEnabled() {
            int oneUIVersion = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion();
            AbstractC4539a.m3212v(oneUIVersion, "isSupportedOneUI7WidgetEnabled# oneUIVersion : ", BaseWidgetUtils.TAG);
            return oneUIVersion >= 70000;
        }

        public final boolean isTabletLandscapeLayout(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return DeviceUtils.isTabletModel() && (context.getResources().getConfiguration().orientation == 2);
        }

        public final boolean isWhiteWallPaper(@Nullable Context context) {
            return Settings.System.getInt(context != null ? context.getContentResolver() : null, BaseWidgetUtils.KEY_NEED_DARK_FONT, 0) > 0;
        }

        public final boolean isWidgetNote(@Nullable Context context, @Nullable String docUuid, @Nullable List<String> widgetUuids) {
            if (widgetUuids == null) {
                WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
                widgetUuids = widgetAccessContract != null ? context != null ? widgetAccessContract.getWidgetUuids(context) : null : new ArrayList<>();
            }
            if (TextUtils.isEmpty(docUuid)) {
                return false;
            }
            Intrinsics.checkNotNull(widgetUuids);
            return widgetUuids.contains(docUuid);
        }

        public final void notifyWidgetNoteConverted(@NotNull Context appContext, @NotNull String sdocUuid, @NotNull String sdocxUuid) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(sdocUuid, "sdocUuid");
            Intrinsics.checkNotNullParameter(sdocxUuid, "sdocxUuid");
            WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
            if (widgetAccessContract != null) {
                widgetAccessContract.sendConvertWidgetBroadcast(appContext, sdocUuid, sdocxUuid);
            }
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String[]> getWidgetToolbarInfoList(@NotNull Context context) {
        return INSTANCE.getWidgetToolbarInfoList(context);
    }

    @JvmStatic
    public static final boolean isSupportedNewWidget() {
        return INSTANCE.isSupportedNewWidget();
    }
}
