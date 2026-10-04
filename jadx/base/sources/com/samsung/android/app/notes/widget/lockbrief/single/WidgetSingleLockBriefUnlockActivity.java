package com.samsung.android.app.notes.widget.lockbrief.single;

import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0005¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/single/WidgetSingleLockBriefUnlockActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "<init>", "()V", "startActivity", "", "pickerActivity", "widgetId", "", "openActivity", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleLockBriefUnlockActivity extends BaseWidgetLockBriefUnlockActivity {

    @NotNull
    private static final String TAG = "WidgetLockBriefConfigActivity";
    public static final int $stable = 8;

    public final void openActivity() {
        Intent intent = new Intent(this, ComposerAccessHandler.getComposerActivityClass());
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        intent.putExtras(extras);
        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent.addFlags(276856832);
        startActivity(intent);
    }

    public final void pickerActivity(int widgetId) {
        Intent intent;
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        if (NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository().getAllNoteCount(0, true) == 0) {
            intent = new Intent(this, ComposerAccessHandler.getComposerActivityClass());
            intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
            intent.setFlags(276856832);
            intent.putExtra(ComposerConstants.NEW_MEMO_FROM_PICKER, widgetId);
            intent.putExtra("tool_type", 1);
        } else {
            intent = new Intent(this, NoteListAccessHandler.getNotePickerClass());
            intent.setAction(WidgetConstant.ACTION_MEMO_PICK);
            intent.setFlags(276824064);
            intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
            intent.putExtra(WidgetConstant.Pick.TYPE, 1);
            intent.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME);
        }
        startActivity(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity
    public void startActivity() {
        int intExtra = getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        String action = getIntent().getAction();
        WidgetLogger.m5154d(TAG, "startActivity - widgetId : " + intExtra + ", action : " + action);
        if (Intrinsics.areEqual(action, WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET)) {
            pickerActivity(intExtra);
        } else if (Intrinsics.areEqual(action, WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET)) {
            openActivity();
        }
        finish();
    }
}
