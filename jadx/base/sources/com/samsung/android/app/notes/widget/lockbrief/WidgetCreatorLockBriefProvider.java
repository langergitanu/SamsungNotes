package com.samsung.android.app.notes.widget.lockbrief;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import com.samsung.android.app.notes.widget.WidgetToolBarProvider;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBriefProvider;", "Lcom/samsung/android/app/notes/widget/WidgetToolBarProvider;", "<init>", "()V", "glanceAppWidget", "Landroidx/glance/appwidget/GlanceAppWidget;", "getGlanceAppWidget", "()Landroidx/glance/appwidget/GlanceAppWidget;", "providerName", "", "getProviderName", "()Ljava/lang/String;", "actionPendingIntentToLaunchNotes", "", "context", "Landroid/content/Context;", "actionPendingIntentToComposerOther", "widgetAction", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorLockBriefProvider extends WidgetToolBarProvider {
    public static final int $stable;

    @NotNull
    public static final String ACTION_LAUNCH_COMPOSER_OTHER = "Widget.LAUNCH_COMPOSER_OTHER";

    @NotNull
    public static final String ACTION_LAUNCH_NOTES = "Widget.LAUNCH_NOTES";

    @NotNull
    private static final String TAG = "WidgetCreatorLockBriefProvider";

    @NotNull
    private final GlanceAppWidget glanceAppWidget = new WidgetCreatorLockBrief();

    @NotNull
    private final String providerName = TAG;

    static {
        int i = GlanceTemplateAppWidgetReceiver.$stable;
        int i2 = GlanceAppWidget.$stable;
        $stable = i | i2 | i2;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetToolBarProvider
    public void actionPendingIntentToComposerOther(@NotNull Context context, @Nullable String widgetAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(context, (Class<?>) WidgetCreatorLockBriefUnlockActivity.class);
        intent.setAction(ACTION_LAUNCH_COMPOSER_OTHER);
        intent.setFlags(403177472);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, widgetAction);
        context.startActivity(intent);
    }

    @Override // com.samsung.android.app.notes.widget.WidgetToolBarProvider
    public void actionPendingIntentToLaunchNotes(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) WidgetCreatorLockBriefUnlockActivity.class);
        intent.setAction(ACTION_LAUNCH_NOTES);
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        context.startActivity(intent);
    }

    @Override // com.samsung.android.app.notes.widget.WidgetToolBarProvider, androidx.glance.appwidget.GlanceAppWidgetReceiver
    @NotNull
    public GlanceAppWidget getGlanceAppWidget() {
        return this.glanceAppWidget;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetToolBarProvider
    @NotNull
    public String getProviderName() {
        return this.providerName;
    }
}
