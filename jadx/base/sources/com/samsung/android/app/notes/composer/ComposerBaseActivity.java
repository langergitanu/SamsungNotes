package com.samsung.android.app.notes.composer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.app.notes.nativecomposer.NativeComposerReminderTriggerActivity;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.EntryAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/notes/composer/ComposerBaseActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startPopupNoteService", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerBaseActivity extends Activity {
    private static final int REQUEST_CALLER_OTHER = 101;

    @NotNull
    private static final String TAG = "ComposerBaseActivity";

    private final void startPopupNoteService() {
        Intent intent = new Intent(this, (Class<?>) PopupNoteService.class);
        intent.setAction(PopupNoteService.ACTION_AIRCOMMAND);
        ServiceManager.INSTANCE.getInstance().startService(this, intent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AbstractC14516b.m15114b(requestCode, resultCode, "onActivityResult requestCode:", ", resultCode:", TAG);
        if (requestCode == 101) {
            if (resultCode == -1) {
                String stringExtra = data != null ? data.getStringExtra("sdoc_uuid") : null;
                if (stringExtra != null && stringExtra.length() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("sdoc_uuid", stringExtra);
                    setResult(resultCode, intent);
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (EntryAction.isSendAction(intent) == 1) {
            Logger.m10999d(TAG, "ActionSend ");
            intent.setClass(this, ComposerActivity.class);
            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            intent.addFlags(1);
            startActivity(intent);
        } else {
            if (Intrinsics.areEqual(ComposerConstants.ACTION_NEW_MEMO, action)) {
                Logger.m10999d(TAG, "ACTION_NEW_MEMO ");
                intent.setClass(this, ComposerActivity.class);
                intent.putExtra(ComposerConstants.EXTRA_KEY_PICK_NOTE, true);
                startActivityForResult(intent, 101);
                return;
            }
            if (Intrinsics.areEqual(ComposerConstants.ACTION_OPEN_MEMO, action)) {
                Logger.m10999d(TAG, "ACTION_OPEN_MEMO ");
                intent.setClass(this, NativeComposerReminderTriggerActivity.class);
                startActivity(intent);
            } else {
                Logger.m11000e(TAG, "onCreate, trigger by unknown intent: " + intent);
                startPopupNoteService();
            }
        }
        finish();
    }
}
