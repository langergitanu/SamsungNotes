package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0017\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingLayoutUtils;", "", "<init>", "()V", "removeBackground", "", "settingLayout", "Landroid/view/View;", "isUnableToHideSettingLayout", "", "settingLayoutType", "", "(Ljava/lang/Integer;)Z", "isNotFloaterToolbarType", "callerType", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingLayoutUtils {

    @NotNull
    public static final InAppSettingLayoutUtils INSTANCE = new InAppSettingLayoutUtils();

    private InAppSettingLayoutUtils() {
    }

    @JvmStatic
    public static final boolean isNotFloaterToolbarType(@Nullable Integer callerType) {
        return (callerType != null && callerType.intValue() == 2) || (callerType != null && callerType.intValue() == 1) || ((callerType != null && callerType.intValue() == 2048) || ((callerType != null && callerType.intValue() == 4) || (callerType != null && callerType.intValue() == 8)));
    }

    @JvmStatic
    public static final boolean isUnableToHideSettingLayout(@Nullable Integer settingLayoutType) {
        return (settingLayoutType != null && settingLayoutType.intValue() == 4) || (settingLayoutType != null && settingLayoutType.intValue() == 1) || ((settingLayoutType != null && settingLayoutType.intValue() == 2) || ((settingLayoutType != null && settingLayoutType.intValue() == 128) || ((settingLayoutType != null && settingLayoutType.intValue() == 256) || ((settingLayoutType != null && settingLayoutType.intValue() == 8) || (settingLayoutType != null && settingLayoutType.intValue() == 16)))));
    }

    @JvmStatic
    public static final void removeBackground(@Nullable View settingLayout) {
        View viewFindViewById;
        if (settingLayout == null || (viewFindViewById = settingLayout.findViewById(C8003R.id.total_layout)) == null) {
            return;
        }
        viewFindViewById.setBackgroundResource(0);
    }
}
