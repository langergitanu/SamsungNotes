package com.samsung.android.app.notes.nativecomposer;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/nativecomposer/ComposerAppToNoteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startComposer", "startComposerActivity", "startComposerActivityFromOtherApp", "createNewNote", "setResultWithUuid", "uuid", "", "resultOk", "", "moveRunningActivityToFront", "", "checkIfExistInDB", "openNote", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerAppToNoteActivity extends AppCompatActivity {

    @NotNull
    private static final String ARG_APP_TO_NOTE = "app_to_note";

    @NotNull
    private static final String ARG_APP_TO_NOTE_NEW = "app_to_note_new";

    @NotNull
    private static final String ARG_APP_TO_NOTE_POS_RECT = "app_to_note_pos_rect";

    @NotNull
    private static final String ARG_APP_TO_NOTE_TOAST_DELETED = "app_to_note_toast_deleted";

    @NotNull
    private static final String ARG_APP_TO_NOTE_UUID = "app_to_note_uuid";

    @NotNull
    private static final String TAG = "ComposerAppToNoteActivity";

    private final boolean checkIfExistInDB(String uuid) {
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository().get(uuid);
        if (mainListDocumentData != null && mainListDocumentData.getIsDeleted() == 0) {
            return true;
        }
        Logger.m8698e(TAG, "not exist or delete ");
        return false;
    }

    private final void createNewNote() {
        String strNewUUID = UUIDUtils.newUUID(this);
        setResultWithUuid(strNewUUID, -1);
        startComposerActivity(strNewUUID);
        Logger.m8702i(TAG, "createNewNote");
    }

    private final boolean moveRunningActivityToFront(String uuid) {
        Activity composerActivity = ComposerManager.INSTANCE.getInstance().getComposerActivity(uuid);
        if (composerActivity == null) {
            return false;
        }
        Logger.m8702i(TAG, "moveRunningActivityToFront : existComposer ");
        AppTaskCompat.INSTANCE.getInstance().moveTaskToFront(this, composerActivity.getTaskId());
        return true;
    }

    private final void openNote(String uuid) {
        setResultWithUuid(uuid, -1);
        getIntent().setAction(ComposerConstants.ACTION_OPEN_MEMO);
        getIntent().setClass(this, NativeComposerReminderTriggerActivity.class);
        getIntent().putExtra(NativeComposerReminderTriggerActivity.ARG_POS_RECT_POPUP, getIntent().getParcelableExtra(ARG_APP_TO_NOTE_POS_RECT));
        startComposerActivity(uuid);
        Logger.m8702i(TAG, "openNote");
    }

    private final void setResultWithUuid(String uuid, int resultOk) {
        Intent intent = new Intent();
        intent.putExtra(ARG_APP_TO_NOTE_UUID, uuid);
        setResult(resultOk, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startComposer() {
        if (!Intrinsics.areEqual("android.intent.action.SEND", getIntent().getAction()) && !Intrinsics.areEqual("android.intent.action.SEND_MULTIPLE", getIntent().getAction())) {
            String action = getIntent().getAction();
            if (action == null) {
                action = "null";
            }
            Logger.m8698e(TAG, "onCreate, trigger by unknown action: ".concat(action));
            return;
        }
        ActivityUtil activityUtil = ActivityUtil.INSTANCE;
        activityUtil.executePostLaunchManager();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        String name = ComposerAppToNoteActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        activityUtil.makeIntentForComposer(applicationContext, intent, name);
        startComposerActivity();
    }

    private final void startComposerActivity() {
        if (getIntent().getBooleanExtra(ARG_APP_TO_NOTE, false)) {
            startComposerActivityFromOtherApp();
        } else {
            startActivity(getIntent());
        }
    }

    private final void startComposerActivityFromOtherApp() {
        String stringExtra = getIntent().getStringExtra(ARG_APP_TO_NOTE_UUID);
        if (stringExtra == null || stringExtra.length() == 0) {
            createNewNote();
            return;
        }
        AbstractC4539a.m3206p("uuid = ", stringExtra, TAG);
        if (moveRunningActivityToFront(stringExtra)) {
            Logger.m8702i(TAG, "moveRunningActivityToFront");
            setResultWithUuid(stringExtra, -1);
        } else if (checkIfExistInDB(stringExtra)) {
            openNote(stringExtra);
        } else {
            if (getIntent().getBooleanExtra(ARG_APP_TO_NOTE_NEW, false)) {
                createNewNote();
                return;
            }
            if (getIntent().getBooleanExtra(ARG_APP_TO_NOTE_TOAST_DELETED, true)) {
                ToastHandler.show(this, C8003R.string.unable_to_open_note, 0);
            }
            setResultWithUuid(stringExtra, 0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KeyguardManagerCompat.Companion companion = KeyguardManagerCompat.INSTANCE;
        if (companion.getInstance().isKeyguardSecureOn(getApplicationContext())) {
            companion.getInstance().requestDismissKeyguard(this, new KeyguardManager.KeyguardDismissCallback() { // from class: com.samsung.android.app.notes.nativecomposer.ComposerAppToNoteActivity.onCreate.1
                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissCancelled() {
                    Logger.m8702i(ComposerAppToNoteActivity.TAG, "onDismissCancelled");
                    super.onDismissCancelled();
                    ComposerAppToNoteActivity.this.finish();
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissError() {
                    Logger.m8702i(ComposerAppToNoteActivity.TAG, "onDismissError");
                    super.onDismissError();
                    ComposerAppToNoteActivity.this.finish();
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissSucceeded() {
                    super.onDismissSucceeded();
                    ComposerAppToNoteActivity.this.startComposer();
                    ComposerAppToNoteActivity.this.finish();
                }
            });
        } else {
            startComposer();
            finish();
        }
    }

    private final void startComposerActivity(String uuid) {
        getIntent().putExtra("sdoc_uuid", uuid);
        Bundle optionsForPopupWindow = ActivityUtil.INSTANCE.getOptionsForPopupWindow(getIntent().getParcelableExtra(ARG_APP_TO_NOTE_POS_RECT));
        if (optionsForPopupWindow != null) {
            startActivity(getIntent(), optionsForPopupWindow);
        } else {
            startActivity(getIntent());
        }
    }
}
