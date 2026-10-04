package com.samsung.android.app.notes.widget.configure;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.SharedPreferences;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.app.notes.widget.common.DeviceTypeChecker;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/configure/WidgetListConfigureActivity;", "Lcom/samsung/android/app/notes/widget/configure/AbsWidgetConfigureActivity;", "<init>", "()V", "providerClass", "Ljava/lang/Class;", "getProviderClass", "()Ljava/lang/Class;", "maxCount", "", "getMaxCount", "()I", "widgetCount", "getWidgetCount", "startPickerActivity", "", "widgetId", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListConfigureActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListConfigureActivity.kt\ncom/samsung/android/app/notes/widget/configure/WidgetListConfigureActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class WidgetListConfigureActivity extends AbsWidgetConfigureActivity {
    public static final int $stable = 8;

    @Override // com.samsung.android.app.notes.widget.configure.AbsWidgetConfigureActivity
    public int getMaxCount() {
        return DeviceUtils.isOldSepLiteModel() ? 3 : -1;
    }

    @Override // com.samsung.android.app.notes.widget.configure.AbsWidgetConfigureActivity
    @Nullable
    public Class<?> getProviderClass() {
        return WidgetListProvider.class;
    }

    @Override // com.samsung.android.app.notes.widget.configure.AbsWidgetConfigureActivity
    public int getWidgetCount() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        Class<?> providerClass = getProviderClass();
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(providerClass != null ? new ComponentName(this, providerClass) : null);
        int length = appWidgetIds.length;
        String string = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        WidgetLogger.m5155i(AbsWidgetConfigureActivity.TAG, "getWidgetCount: " + length + ", widgetIds: " + string);
        SharedPreferences sharedPreferences = getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        int displayDeviceType = DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(this);
        String homeMode = HomeScreenUtils.INSTANCE.getHomeMode(this);
        boolean zIsFoldDeviceType = DeviceTypeChecker.INSTANCE.isFoldDeviceType();
        int i = 0;
        for (int i2 : appWidgetIds) {
            Intrinsics.checkNotNull(sharedPreferences);
            if (ProviderUtils.canIncreaseWidgetCount(sharedPreferences, displayDeviceType, zIsFoldDeviceType, BaseWidgetConstant.NONE, i2, homeMode)) {
                i++;
            }
        }
        return i;
    }

    @Override // com.samsung.android.app.notes.widget.configure.AbsWidgetConfigureActivity
    public void startPickerActivity(int widgetId) {
        startMultiSelectPicker(widgetId);
    }
}
