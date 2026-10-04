package com.samsung.android.app.notes.widget.cover.setting;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RequiresPermission;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.setting.WidgetPinSettingsActivity;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0015¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/cover/setting/WidgetSingleCoverSettingActivity;", "Lcom/samsung/android/app/notes/widget/setting/WidgetPinSettingsActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleCoverSettingActivity extends WidgetPinSettingsActivity {
    public static final int $stable = 8;

    @Override // com.samsung.android.app.notes.widget.setting.WidgetPinSettingsActivity, com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresPermission(anyOf = {"android.permission.READ_WALLPAPER_INTERNAL", "android.permission.MANAGE_EXTERNAL_STORAGE"})
    public void onCreate(@Nullable Bundle savedInstanceState) throws Exception {
        super.onCreate(savedInstanceState);
        View viewFindViewById = findViewById(C11391R.id.widget_setting_layout_root);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) viewFindViewById).setBackground(WallpaperManager.getInstance(this).getDrawable());
    }
}
