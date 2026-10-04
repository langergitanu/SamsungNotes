package com.samsung.android.support.senl.p148nt.base.widget.preference;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/preference/BaseWidgetPreferenceManager;", "", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BaseWidgetPreferenceManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bJ\u0016\u0010$\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u0018\u0010&\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\tJ\u0010\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u0016\u0010-\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u001e\u00100\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u000e\u00103\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u0010\u00104\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u000bH\u0007J\u0016\u00105\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\tJ\u0016\u00107\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0018J\u0010\u00109\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000bH\u0007J\u0016\u0010:\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0018J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000bH\u0007J\u0016\u0010=\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000bJ\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0007J\u0016\u0010@\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u0018J\u000e\u0010B\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000bR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/preference/BaseWidgetPreferenceManager$Companion;", "", "<init>", "()V", BaseWidgetConstant.WIDGET_PREFERENCES, "Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat;", "getWidgetPref", "()Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat;", "getUUID", "", "key", "", "saveUuid", "", "uuid", "getTransparency", "getReverseTransparency", "saveTransparency", "transparency", "getBackgroundColor", "saveWidgetBackgroundColorPref", "backgroundColor", "getDarkMode", "getWidgetNightModeTheme", "", "saveWidgetNightModeThemePref", "isNightModeTheme", "saveDarkModePref", "darkMode", "isReverseTransparency", "saveTrueReverseTransparency", "saveWidgetOrientationPref", "orientation", "getWidgetOrientationPref", "saveWidgetHeightPref", "height", "getWidgetHeightPref", "defaultHeight", "saveOneUiWidgetSource", "oneUiWidgetSource", "getOneUiWidgetSource", "saveColumnSpan", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "column", "getColumnSpan", "saveRowSpan", "row", "getRowSpan", "saveMinWidthHeight", "width", "getMinWidth", "getMinHeight", "getCreatorSelectedList", "saveCreatorSelectedList", "selectedListString", "saveWidgetMatchSetting", "isMatch", "getWidgetMatchSetting", "saveWidgetBackgroundOnOff", "isBackgroundOnOff", "getWidgetBackgroundOnOff", "saveWidgetBackgroundShape", VMetaDataKey.META_KEY_SHAPE, "getWidgetBackgroundShape", "saveWidgetData", "isData", "getWidgetData", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int getBackgroundColor(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, 1);
        }

        public final int getColumnSpan(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN, 0);
        }

        @JvmStatic
        @NotNull
        public final String getCreatorSelectedList(int appWidgetId) {
            String strM13955n;
            Set<String> stringSet = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getStringSet(AbstractC0541b.m767i(appWidgetId, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.KEY_SELECTED_ITEMS), SetsKt.emptySet());
            return (stringSet == null || (strM13955n = CollectionsKt.m13955n(stringSet, SQLKeyword.COMMA, null, null, null, 62)) == null) ? "" : strM13955n;
        }

        @JvmStatic
        public final int getDarkMode(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(AbstractC0541b.m767i(key, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE), BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? -1 : 1);
        }

        public final int getMinHeight(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT, 0);
        }

        public final int getMinWidth(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH, 0);
        }

        @Nullable
        public final String getOneUiWidgetSource(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_ONE_UI_SOURCE, "one_none");
        }

        public final int getReverseTransparency(int key) {
            return 100 - SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(AbstractC0541b.m767i(key, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY), BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? 75 : 100);
        }

        public final int getRowSpan(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_ROW_SPAN, 0);
        }

        @JvmStatic
        public final int getTransparency(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(AbstractC0541b.m767i(key, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY), BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? 75 : 100);
        }

        @NotNull
        public final String getUUID(int key) {
            return String.valueOf(SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + key, BaseWidgetConstant.NONE));
        }

        @JvmStatic
        public final boolean getWidgetBackgroundOnOff(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, true);
        }

        @JvmStatic
        public final int getWidgetBackgroundShape(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, 0);
        }

        public final boolean getWidgetData(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_DATA, false);
        }

        public final int getWidgetHeightPref(int key, int defaultHeight) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_HEIGHT, defaultHeight);
        }

        @JvmStatic
        public final boolean getWidgetMatchSetting(int appWidgetId) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getBoolean(AbstractC0541b.m767i(appWidgetId, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING), BaseWidgetUtils.INSTANCE.isSupportedNewWidget());
        }

        public final boolean getWidgetNightModeTheme(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getBoolean(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_NIGHT_MODE, false);
        }

        public final int getWidgetOrientationPref(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + key + "orientation", -1);
        }

        @NotNull
        public final SharedPreferencesCompat getWidgetPref() {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES);
        }

        @JvmStatic
        public final boolean isReverseTransparency(int key) {
            return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getBoolean(AbstractC0541b.m767i(key, BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE), BaseWidgetUtils.INSTANCE.isSupportedNewWidget());
        }

        public final void saveColumnSpan(int appWidgetId, int column) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN, column);
        }

        public final void saveCreatorSelectedList(int appWidgetId, @NotNull String selectedListString) {
            Intrinsics.checkNotNullParameter(selectedListString, "selectedListString");
            Set<String> set = CollectionsKt.toSet(StringsKt__StringsKt.split$default(selectedListString, new String[]{SQLKeyword.COMMA}, false, 0, 6, (Object) null));
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putStringSet(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_SELECTED_ITEMS, set);
        }

        public final void saveDarkModePref(int key, int darkMode) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, darkMode);
        }

        public final void saveMinWidthHeight(int appWidgetId, int width, int height) {
            SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
            companion.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH, width);
            companion.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT, height);
        }

        public final void saveOneUiWidgetSource(int key, @Nullable String oneUiWidgetSource) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_ONE_UI_SOURCE, oneUiWidgetSource);
        }

        public final void saveRowSpan(int appWidgetId, int row) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.WIDGET_GLANCE_ROW_SPAN, row);
        }

        public final void saveTransparency(int key, int transparency) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, transparency);
            saveTrueReverseTransparency(key);
        }

        public final void saveTrueReverseTransparency(int key) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putBoolean(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE, true);
        }

        public final void saveUuid(int key, @NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + key, uuid);
        }

        public final void saveWidgetBackgroundColorPref(int key, int backgroundColor) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, backgroundColor);
        }

        public final void saveWidgetBackgroundOnOff(int appWidgetId, boolean isBackgroundOnOff) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, isBackgroundOnOff);
        }

        public final void saveWidgetBackgroundShape(int appWidgetId, int shape) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, shape);
        }

        public final void saveWidgetData(int appWidgetId, boolean isData) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_DATA, isData);
        }

        public final void saveWidgetHeightPref(int key, int height) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_HEIGHT, height);
        }

        public final void saveWidgetMatchSetting(int appWidgetId, boolean isMatch) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetId + BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, isMatch);
        }

        public final void saveWidgetNightModeThemePref(int key, boolean isNightModeTheme) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putBoolean(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_NIGHT_MODE, isNightModeTheme);
        }

        public final void saveWidgetOrientationPref(int key, int orientation) {
            SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + key + "orientation", orientation);
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final int getBackgroundColor(int i) {
        return INSTANCE.getBackgroundColor(i);
    }

    @JvmStatic
    @NotNull
    public static final String getCreatorSelectedList(int i) {
        return INSTANCE.getCreatorSelectedList(i);
    }

    @JvmStatic
    public static final int getDarkMode(int i) {
        return INSTANCE.getDarkMode(i);
    }

    @JvmStatic
    public static final int getTransparency(int i) {
        return INSTANCE.getTransparency(i);
    }

    @JvmStatic
    public static final boolean getWidgetBackgroundOnOff(int i) {
        return INSTANCE.getWidgetBackgroundOnOff(i);
    }

    @JvmStatic
    public static final int getWidgetBackgroundShape(int i) {
        return INSTANCE.getWidgetBackgroundShape(i);
    }

    @JvmStatic
    public static final boolean getWidgetMatchSetting(int i) {
        return INSTANCE.getWidgetMatchSetting(i);
    }

    @JvmStatic
    public static final boolean isReverseTransparency(int i) {
        return INSTANCE.isReverseTransparency(i);
    }
}
