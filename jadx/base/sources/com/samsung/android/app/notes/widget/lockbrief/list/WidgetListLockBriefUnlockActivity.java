package com.samsung.android.app.notes.widget.lockbrief.list;

import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/list/WidgetListLockBriefUnlockActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "<init>", "()V", "startActivity", "", "pickerActivity", "openItemActivity", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListLockBriefUnlockActivity extends BaseWidgetLockBriefUnlockActivity {

    @NotNull
    private static final String TAG = "WidgetListLockBriefUnlockActivity";
    public static final int $stable = 8;

    public final void openItemActivity() {
        if (DocumentAccessHandler.getContract() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        if (DocumentAccessHandler.getContract() == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, "openSelectedNote# getContract is null");
            return;
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            Intent intent = new Intent(this, (Class<?>) StorageErrorDialogActivity.class);
            intent.setFlags(402653184);
            startActivity(intent);
            return;
        }
        String stringExtra = getIntent().getStringExtra("sdoc_uuid");
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(String.valueOf(stringExtra));
        if (path == null || path.length() <= 0) {
            if (NoteListAccessHandler.getNoteListClass() == null) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            }
            Intent intent2 = new Intent(this, NoteListAccessHandler.getNoteListClass());
            WidgetBroadcast.sendUpdateAllWidgetBroadcast(this);
            intent2.setFlags(335544320);
            MultiTaskManager.INSTANCE.getInstance().startActivity(this, intent2);
            return;
        }
        WidgetLogger.m5155i(TAG, "openSelectedNote# uuid : " + stringExtra);
        DocumentAccessHandler.DocumentAccessContract contract = DocumentAccessHandler.getContract();
        Intent intent3 = new Intent(this, contract != null ? contract.getDocOpenTriggerClass() : null);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        intent3.putExtras(extras);
        intent3.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent3.addFlags(276856832);
        startActivity(intent3);
    }

    public final void pickerActivity() {
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(this, NoteListAccessHandler.getNotePickerClass());
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        intent.putExtras(extras);
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
        intent.addFlags(276856832);
        startActivity(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity
    public void startActivity() {
        String action = getIntent().getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -634570312) {
                if (iHashCode != 1369566824) {
                    if (iHashCode == 1751413455 && action.equals(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET)) {
                        pickerActivity();
                    }
                } else if (action.equals(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET_LIST_ACTION_ADD)) {
                    pickerActivity();
                }
            } else if (action.equals(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET)) {
                openItemActivity();
            }
        }
        finish();
    }
}
