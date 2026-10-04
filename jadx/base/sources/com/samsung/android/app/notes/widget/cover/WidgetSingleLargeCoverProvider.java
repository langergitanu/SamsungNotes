package com.samsung.android.app.notes.widget.cover;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.widget.WidgetProvider;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/cover/WidgetSingleLargeCoverProvider;", "Lcom/samsung/android/app/notes/widget/WidgetProvider;", "<init>", "()V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "onAppWidgetOptionsChanged", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "newOptions", "Landroid/os/Bundle;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleLargeCoverProvider extends WidgetProvider {
    public static final int WIDGET_HEIGHT = 339;
    public static final int WIDGET_WIDTH = 352;

    @NotNull
    private final String providerName = "WidgetSingleLargeCoverProvider";
    public static final int $stable = 8;

    @Override // com.samsung.android.app.notes.widget.WidgetProvider
    @NotNull
    public String getProviderName() {
        return this.providerName;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetProvider, androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Bundle newOptions) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        int i = newOptions.getInt("appWidgetMinWidth");
        int i2 = newOptions.getInt("appWidgetMinHeight");
        int i4 = newOptions.getInt("semAppWidgetRowSpan");
        int i5 = newOptions.getInt("semAppWidgetColumnSpan");
        Bundle bundle = new Bundle(newOptions);
        boolean z2 = true;
        if (i4 < 2) {
            bundle.putInt("semAppWidgetRowSpan", 2);
            z = true;
        } else {
            z = false;
        }
        if (i5 < 4) {
            bundle.putInt("semAppWidgetColumnSpan", 4);
            z = true;
        }
        if (i <= 0 || i2 <= 0) {
            bundle.putInt("appWidgetMinWidth", 352);
            bundle.putInt("appWidgetMinHeight", 339);
        } else {
            z2 = z;
        }
        NotesSamsungAnalytics.INSTANCE.insertStatusLog("WDGT0001", i4 + " x " + i5);
        String providerName = getProviderName();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(appWidgetId, i, "onAppWidgetOptionsChanged# appWidgetID: ", ", minWidth : ", ", minHeight : ");
        AbstractC2821a.m2235z(sbM1173s, i2, i4, ", row : ", ", column : ");
        sbM1173s.append(i5);
        sbM1173s.append(", isUpdateOption : ");
        sbM1173s.append(z2);
        WidgetLogger.m5154d(providerName, sbM1173s.toString());
        if (z2) {
            appWidgetManager.updateAppWidgetOptions(appWidgetId, bundle);
        }
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override // com.samsung.android.app.notes.widget.WidgetProvider, androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i : appWidgetIds) {
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i);
            int i2 = appWidgetOptions.getInt("appWidgetMinWidth");
            int i4 = appWidgetOptions.getInt("appWidgetMinHeight");
            int i5 = appWidgetOptions.getInt("semAppWidgetRowSpan");
            int i6 = appWidgetOptions.getInt("semAppWidgetColumnSpan");
            Bundle bundle = new Bundle(appWidgetOptions);
            if (i5 < 2) {
                bundle.putInt("semAppWidgetRowSpan", 2);
                z = true;
            } else {
                z = false;
            }
            if (i6 < 4) {
                bundle.putInt("semAppWidgetColumnSpan", 4);
                z = true;
            }
            if (i2 <= 0 || i4 <= 0) {
                bundle.putInt("appWidgetMinWidth", 352);
                bundle.putInt("appWidgetMinHeight", 339);
                z = true;
            }
            String providerName = getProviderName();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onUpdate updateOption: ", ", minWidth : ", ", minHeight : ");
            AbstractC2821a.m2235z(sbM1173s, i4, i5, ", row : ", ", column : ");
            sbM1173s.append(i6);
            sbM1173s.append(", isUpdateOption : ");
            sbM1173s.append(z);
            WidgetLogger.m5154d(providerName, sbM1173s.toString());
            if (z) {
                appWidgetManager.updateAppWidgetOptions(i, bundle);
            }
        }
    }
}
