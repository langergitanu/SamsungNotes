package com.samsung.android.app.notes.widget.lockbrief.list;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J4\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/list/WidgetListLockBriefProvider;", "Lcom/samsung/android/app/notes/widget/WidgetListProvider;", "<init>", "()V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "startNotePicker", "", "context", "Landroid/content/Context;", "widgetId", "", "onNotePickerClickedActionAdd", "uuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "openSelectedNote", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListLockBriefProvider extends WidgetListProvider {
    public static final int $stable = GlanceTemplateAppWidgetReceiver.$stable | GlanceAppWidget.$stable;

    @NotNull
    private final String providerName = BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME;

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    @NotNull
    public String getProviderName() {
        return this.providerName;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    public void onNotePickerClickedActionAdd(@NotNull Context context, int widgetId, @Nullable ArrayList<String> uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        Intrinsics.checkNotNull(uuidList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String?>");
        widgetPreferenceManager.saveNoteUuidListBeforeAdd(widgetId, uuidList);
        Intent intent = new Intent(context, (Class<?>) WidgetListLockBriefUnlockActivity.class);
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET_LIST_ACTION_ADD);
        intent.setFlags(403177472);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, uuidList);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion.getTransparency(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion.getBackgroundColor(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion.getDarkMode(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion.getWidgetMatchSetting(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion.getWidgetBackgroundShape(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, companion.getWidgetBackgroundOnOff(widgetId));
        intent.putExtra(WidgetConstant.EXTRA_KEY_ACTION_ADD_FROM_WIDGET_LIST_GLANCE, true);
        intent.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
        context.startActivity(intent);
    }

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    public void openSelectedNote(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        String stringExtra2 = intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID);
        Intent intent2 = new Intent(context, (Class<?>) WidgetListLockBriefUnlockActivity.class);
        if (!TextUtils.isEmpty(stringExtra2)) {
            intent2.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, stringExtra2);
            intent2.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, intent.getStringExtra(ComposerConstants.ARG_MDE_GROUP_ID));
            intent2.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, intent.getStringExtra(ComposerConstants.ARG_MDE_OWNER_ID));
            intent2.putExtra(ComposerConstants.ARG_MDE_WRITER, intent.getStringExtra(ComposerConstants.ARG_MDE_WRITER));
            intent2.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, intent.getStringExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE));
        }
        intent2.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
        intent2.putExtra("sdoc_uuid", stringExtra);
        intent2.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        context.startActivity(intent2);
    }

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    public void startNotePicker(@NotNull Context context, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) WidgetListLockBriefUnlockActivity.class);
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
        intent.setFlags(403177472);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion.getTransparency(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion.getBackgroundColor(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion.getDarkMode(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion.getWidgetMatchSetting(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion.getWidgetBackgroundShape(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, companion.getWidgetBackgroundOnOff(widgetId));
        intent.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
        context.startActivity(intent);
    }
}
