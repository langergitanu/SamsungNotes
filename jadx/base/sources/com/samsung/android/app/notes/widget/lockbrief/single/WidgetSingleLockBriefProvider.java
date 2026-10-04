package com.samsung.android.app.notes.widget.lockbrief.single;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetProvider;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p044K.C0158a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/single/WidgetSingleLockBriefProvider;", "Lcom/samsung/android/app/notes/widget/WidgetProvider;", "<init>", "()V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "pickMemoListFromWidget", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "previousEventTime", "", "checkWidgetCount", "", "openMemoListFromWidget", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleLockBriefProvider extends WidgetProvider {

    @NotNull
    private static final String TAG = "WWidgetSingleLockBriefProvider";

    @NotNull
    private final String providerName = BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME;
    public static final int $stable = 8;

    @Override // com.samsung.android.app.notes.widget.WidgetProvider
    @NotNull
    public String getProviderName() {
        return this.providerName;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetProvider
    public void openMemoListFromWidget(@NotNull Context context, @NotNull Intent intent, long previousEventTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5154d(TAG, "openMemoListFromWidget#");
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!StorageUtils.isAvailableMemoryForNewMemo()) {
                Intent intent2 = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
                intent2.setFlags(402653184);
                context.startActivity(intent2);
                return;
            }
            if (ProviderUtils.INSTANCE.checkEventTime(jCurrentTimeMillis, previousEventTime, 1000L)) {
                int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
                String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(intExtra);
                if (WidgetUtils.INSTANCE.isSDoc(context, uuid)) {
                    WidgetLogger.m5156w(TAG, "openMemoListFromWidget# need to convert");
                    if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
                        onUpdate(context, appWidgetManager, new int[]{intExtra});
                    }
                }
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
                Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
                String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid);
                WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
                String encode = widgetLogger.getEncode(uuid);
                if (path != null) {
                    WidgetLogger.m5154d(TAG, "openMemoListFromWidget# widgetId : " + intExtra + " uuid : " + encode + " path :" + widgetLogger.getEncode(path));
                    if (ComposerAccessHandler.getComposerActivityClass() == null) {
                        PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
                    }
                    Intent intent3 = new Intent(context, (Class<?>) WidgetSingleLockBriefUnlockActivity.class);
                    if (C0158a.m407a().m415h()) {
                        MdeInfo mdeInfo = new MdeInfo(notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeSpaceId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeGroupId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeOwnerId(), "test", AbstractC14517a.m15166z(context, uuid) ? 1 : 2);
                        if (!TextUtils.isEmpty(mdeInfo.getSpaceId())) {
                            WidgetLogger.m5154d(TAG, "openMemoListFromWidget# this is mde file");
                            PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
                            intent3.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, mdeInfo.getSpaceId());
                            intent3.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, mdeInfo.getGroupId());
                            intent3.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, mdeInfo.getOwnerId());
                            intent3.putExtra(ComposerConstants.ARG_MDE_WRITER, mdeInfo.getCreatorName());
                            intent3.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, mdeInfo.getAccountType());
                        }
                    }
                    intent3.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
                    intent3.putExtra("sdoc_uuid", uuid);
                    intent3.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
                    context.startActivity(intent3);
                } else {
                    WidgetLogger.m5154d(TAG, "openMemoListFromWidget# widgetId : " + intExtra + "uuid : " + encode);
                    if (NoteListAccessHandler.getNoteListClass() == null) {
                        PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
                    }
                    WidgetBroadcast.sendUpdateAllWidgetBroadcast(context);
                    Intent intent4 = new Intent(context, (Class<?>) WidgetSingleLockBriefUnlockActivity.class);
                    intent4.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
                    intent4.setFlags(335544320);
                    MultiTaskManager.INSTANCE.getInstance().startActivity(context, intent4);
                }
                setPreviousEventTime(jCurrentTimeMillis + 1000);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.samsung.android.app.notes.widget.WidgetProvider
    public void pickMemoListFromWidget(@NotNull Context context, @NotNull Intent intent, long previousEventTime, boolean checkWidgetCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5154d(TAG, "pickMemoListFromWidget#");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ProviderUtils providerUtils = ProviderUtils.INSTANCE;
        if (providerUtils.checkEventTime(jCurrentTimeMillis, previousEventTime, 1000L)) {
            if (WidgetAccessHandler.INSTANCE.getWidgetResolverClass() == null || NoteListAccessHandler.getNotePickerClass() == null) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            }
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (!checkWidgetCount || providerUtils.isAvailableToReferWidget(context, WidgetSingleLockBriefProvider.class, intExtra)) {
                Intent intent2 = new Intent(context, (Class<?>) WidgetSingleLockBriefUnlockActivity.class);
                intent2.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
                intent2.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
                intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, intExtra);
                context.startActivity(intent2);
            } else {
                WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, context, 0, 2, null);
            }
            setPreviousEventTime(jCurrentTimeMillis + 1000);
        }
    }
}
