package com.samsung.android.app.notes.widget.glance.common;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.util.WidgetToolbarUtils;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/common/WidgetCreatorUtil;", "", "<init>", "()V", "addIntentToLaunchNotes", "Landroid/content/Intent;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "providerName", "", "addIntentToComposerText", "addIntentToComposerPen", "addIntentToComposerDrawing", "addIntentToComposerImage", "addIntentToComposerVoice", "getLaunchNotesIntent", "getOpenIntent", "widgetAction", "insertLog", "", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorUtil {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetCreatorUtil INSTANCE = new WidgetCreatorUtil();

    private WidgetCreatorUtil() {
    }

    public static /* synthetic */ Intent addIntentToComposerDrawing$default(WidgetCreatorUtil widgetCreatorUtil, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str = "WidgetToolBarProvider";
        }
        return widgetCreatorUtil.addIntentToComposerDrawing(context, i, str);
    }

    public static /* synthetic */ Intent addIntentToComposerImage$default(WidgetCreatorUtil widgetCreatorUtil, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str = "WidgetToolBarProvider";
        }
        return widgetCreatorUtil.addIntentToComposerImage(context, i, str);
    }

    public static /* synthetic */ Intent addIntentToComposerPen$default(WidgetCreatorUtil widgetCreatorUtil, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str = "WidgetToolBarProvider";
        }
        return widgetCreatorUtil.addIntentToComposerPen(context, i, str);
    }

    public static /* synthetic */ Intent addIntentToComposerText$default(WidgetCreatorUtil widgetCreatorUtil, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str = "WidgetToolBarProvider";
        }
        return widgetCreatorUtil.addIntentToComposerText(context, i, str);
    }

    public static /* synthetic */ Intent addIntentToComposerVoice$default(WidgetCreatorUtil widgetCreatorUtil, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str = "WidgetToolBarProvider";
        }
        return widgetCreatorUtil.addIntentToComposerVoice(context, i, str);
    }

    public static /* synthetic */ Intent addIntentToLaunchNotes$default(WidgetCreatorUtil widgetCreatorUtil, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            str = "WidgetToolBarProvider";
        }
        return widgetCreatorUtil.addIntentToLaunchNotes(context, i, str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void insertLog(String widgetAction) {
        switch (widgetAction.hashCode()) {
            case -1327778454:
                if (widgetAction.equals(ComposerConstants.NEW_MEMO_INSERT_OPEN)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog("611", "6105");
                    break;
                }
                break;
            case -889698351:
                if (widgetAction.equals(ComposerConstants.NEW_MEMO_DRAWING_OPEN)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog("611", "6104");
                    break;
                }
                break;
            case -833164099:
                if (widgetAction.equals(ComposerConstants.NEW_MEMO_VOICE_OPEN)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog("611", "6106");
                    break;
                }
                break;
            case 226248240:
                if (widgetAction.equals(ComposerConstants.NEW_MEMO_OPEN)) {
                    NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
                    companion.insertLog("611", "6102");
                    companion.insertStatusLog("9985", "Widget_Keypad");
                }
                break;
            case 1118161363:
                if (widgetAction.equals(ComposerConstants.NEW_MEMO_WRITING_OPEN)) {
                    NotesSamsungAnalytics.Companion companion2 = NotesSamsungAnalytics.INSTANCE;
                    companion2.insertLog("611", "6103");
                    companion2.insertStatusLog("9985", "Widget_Brush");
                    break;
                }
                break;
        }
    }

    @NotNull
    public final Intent addIntentToComposerDrawing(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, WidgetToolbarUtils.INSTANCE.getClassProvider(providerName));
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_DRAWING_OPEN);
        return intent;
    }

    @NotNull
    public final Intent addIntentToComposerImage(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, WidgetToolbarUtils.INSTANCE.getClassProvider(providerName));
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_INSERT_OPEN);
        return intent;
    }

    @NotNull
    public final Intent addIntentToComposerPen(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, WidgetToolbarUtils.INSTANCE.getClassProvider(providerName));
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_WRITING_OPEN);
        return intent;
    }

    @NotNull
    public final Intent addIntentToComposerText(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, WidgetToolbarUtils.INSTANCE.getClassProvider(providerName));
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_OPEN);
        return intent;
    }

    @NotNull
    public final Intent addIntentToComposerVoice(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, WidgetToolbarUtils.INSTANCE.getClassProvider(providerName));
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_VOICE_OPEN);
        return intent;
    }

    @NotNull
    public final Intent addIntentToLaunchNotes(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, WidgetToolbarUtils.INSTANCE.getClassProvider(providerName));
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(BaseWidgetConstant.LAUNCH_NOTES_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        return intent;
    }

    @NotNull
    public final Intent getLaunchNotesIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotesSamsungAnalytics.INSTANCE.insertLog("611", "6101");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
        if (launchIntentForPackage == null) {
            Intent intent = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
            intent.setFlags(402653184);
            return intent;
        }
        launchIntentForPackage.setAction("android.intent.action.MAIN");
        launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        launchIntentForPackage.addFlags(268435456);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.setPackage(null);
        return launchIntentForPackage;
    }

    @NotNull
    public final Intent getOpenIntent(@NotNull Context context, @NotNull String widgetAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetAction, "widgetAction");
        insertLog(widgetAction);
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            Intent intent = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
            intent.setFlags(402653184);
            return intent;
        }
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent2 = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
        intent2.setFlags(268533760);
        intent2.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, widgetAction);
        intent2.setAction(ComposerConstants.ACTION_WIDGET);
        return intent2;
    }
}
