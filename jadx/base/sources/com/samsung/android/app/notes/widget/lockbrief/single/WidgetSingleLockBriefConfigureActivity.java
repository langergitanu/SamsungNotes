package com.samsung.android.app.notes.widget.lockbrief.single;

import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/single/WidgetSingleLockBriefConfigureActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "<init>", "()V", "mAppWidgetId", "", "mUUID", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "startActivity", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleLockBriefConfigureActivity extends BaseWidgetLockBriefUnlockActivity {

    @NotNull
    private static final String TAG = "WidgetSingleLockBriefSettingActivity";
    private int mAppWidgetId = -1;

    @NotNull
    private String mUUID = "";
    public static final int $stable = 8;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1) {
            String stringExtra = data != null ? data.getStringExtra(WidgetConstant.EXTRA_KEY_UUID) : null;
            if (stringExtra != null) {
                Logger.m8697d(TAG, "onActivityResult# new uuid : " + stringExtra + " old uuid :" + this.mUUID);
            } else {
                Logger.m8697d(TAG, "onActivityResult# new uuid null");
            }
            String stringExtra2 = data != null ? data.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH) : null;
            if (stringExtra != null && !this.mUUID.contentEquals(stringExtra)) {
                WidgetBroadcast.INSTANCE.sendPickWidgetBroadcast(this, stringExtra, stringExtra2, this.mAppWidgetId);
            }
        }
        finishAndRemoveTask();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity
    public void startActivity() {
        int intExtra = getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        this.mAppWidgetId = intExtra;
        this.mUUID = BaseWidgetPreferenceManager.INSTANCE.getUUID(intExtra);
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        setIntent(new Intent(this, NoteListAccessHandler.getNotePickerClass()));
        getIntent().setAction(WidgetConstant.ACTION_MEMO_PICK);
        getIntent().putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        getIntent().putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, true);
        getIntent().putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mAppWidgetId);
        getIntent().putExtra(WidgetConstant.Pick.TYPE, 1);
        getIntent().putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, WidgetPreferenceManager.INSTANCE.getWidgetProviderName(this.mAppWidgetId));
        startActivityForResult(getIntent(), 1);
    }
}
