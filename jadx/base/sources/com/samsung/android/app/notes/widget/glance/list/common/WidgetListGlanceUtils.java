package com.samsung.android.app.notes.widget.glance.list.common;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListMediumCoverProvider;
import com.samsung.android.app.notes.widget.lockbrief.list.WidgetListLockBriefProvider;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ.\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\r\u001a\u00020\f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/common/WidgetListGlanceUtils;", "", "<init>", "()V", "addIntentPickNotes", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "widgetId", "", "uuidList", "", "", "providerName", "addStartNotePicker", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "intentStartSetting", "getClassProvider", "Ljava/lang/Class;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListGlanceUtils {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetListGlanceUtils INSTANCE = new WidgetListGlanceUtils();

    private WidgetListGlanceUtils() {
    }

    @NotNull
    public final Intent addIntentPickNotes(@NotNull Context context, int widgetId, @Nullable List<String> uuidList, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, getClassProvider(providerName));
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET_LIST_ACTION_ADD);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        Intrinsics.checkNotNull(uuidList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String?>");
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, (ArrayList) uuidList);
        return intent;
    }

    @NotNull
    public final Intent addStartNotePicker(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, getClassProvider(providerName));
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        return intent;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public final Class<?> getClassProvider(@NotNull String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        switch (providerName.hashCode()) {
            case -722604002:
                return !providerName.equals(BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME) ? WidgetListProvider.class : WidgetListLockBriefProvider.class;
            case -593366001:
                return !providerName.equals(WidgetListLargeCoverProvider.TAG) ? WidgetListProvider.class : WidgetListLargeCoverProvider.class;
            case -504469509:
                return !providerName.equals(WidgetListExtraLargeCoverProvider.TAG) ? WidgetListProvider.class : WidgetListExtraLargeCoverProvider.class;
            case 1564427473:
                return !providerName.equals(WidgetListMediumCoverProvider.TAG) ? WidgetListProvider.class : WidgetListMediumCoverProvider.class;
            default:
                return WidgetListProvider.class;
        }
    }

    @NotNull
    public final Intent intentStartSetting(@NotNull Context context, int appWidgetId, @Nullable List<String> uuidList, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, getClassProvider(providerName));
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(WidgetConstant.SETTING_MEMO_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        Intrinsics.checkNotNull(uuidList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String?>");
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, (ArrayList) uuidList);
        return intent;
    }
}
