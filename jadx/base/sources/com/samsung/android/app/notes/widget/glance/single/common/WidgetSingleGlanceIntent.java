package com.samsung.android.app.notes.widget.glance.single.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetProvider;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.cover.WidgetSingleExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleMediumCoverProvider;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.lockbrief.single.WidgetSingleLockBriefProvider;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p044K.C0158a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bJ\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceIntent;", "", "<init>", "()V", "intentStartNotePicker", "Landroid/content/Intent;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "providerName", "", "intentOpenMemoListFromWidget", "intentConvertWidget", "getOpenNoteIntent", "uuid", "getClassProvider", "Ljava/lang/Class;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleGlanceIntent {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetSingleGlanceIntent INSTANCE = new WidgetSingleGlanceIntent();

    private WidgetSingleGlanceIntent() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Class<?> getClassProvider(String providerName) {
        switch (providerName.hashCode()) {
            case -1810065740:
                return !providerName.equals(BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME) ? WidgetProvider.class : WidgetSingleLockBriefProvider.class;
            case 55058489:
                return !providerName.equals("WidgetSingleLargeCoverProvider") ? WidgetProvider.class : WidgetSingleLargeCoverProvider.class;
            case 190750183:
                return !providerName.equals(BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) ? WidgetProvider.class : WidgetSingleMediumCoverProvider.class;
            case 1341081105:
                return !providerName.equals("WidgetSingleExtraLargeCoverProvider") ? WidgetProvider.class : WidgetSingleExtraLargeCoverProvider.class;
            default:
                return WidgetProvider.class;
        }
    }

    @NotNull
    public final Intent getOpenNoteIntent(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            Intent intent = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
            intent.setFlags(402653184);
            return intent;
        }
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent2 = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
        if (C0158a.m407a().m415h()) {
            int i = AbstractC14517a.m15166z(context, uuid) ? 1 : 2;
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
            MdeInfo mdeInfo = new MdeInfo(notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeSpaceId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeGroupId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeOwnerId(), "test", i);
            if (!TextUtils.isEmpty(mdeInfo.getSpaceId())) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
                intent2.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, mdeInfo.getSpaceId());
                intent2.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, mdeInfo.getGroupId());
                intent2.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, mdeInfo.getOwnerId());
                intent2.putExtra(ComposerConstants.ARG_MDE_WRITER, mdeInfo.getCreatorName());
                intent2.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, mdeInfo.getAccountType());
            }
        }
        intent2.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent2.putExtra("sdoc_uuid", uuid);
        intent2.setFlags(268533760);
        return intent2;
    }

    @NotNull
    public final Intent intentConvertWidget(@NotNull Context context, int appWidgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) WidgetProvider.class);
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(WidgetConstant.ACTION_MEMO_CONVERT);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        return intent;
    }

    @NotNull
    public final Intent intentOpenMemoListFromWidget(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, getClassProvider(providerName));
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        return intent;
    }

    @NotNull
    public final Intent intentStartNotePicker(@NotNull Context context, int appWidgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(context, getClassProvider(providerName));
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        return intent;
    }
}
