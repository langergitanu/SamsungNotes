package com.samsung.android.support.senl.p148nt.app.main.hashtag;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.widget.AppWidgetUtils;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.hashtag.HashTagListPreferenceHelper;
import com.samsung.android.support.senl.p148nt.app.main.common.task.ShareToOtherAppsTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.IntentFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.NotesFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.UnlockConfirmDialogHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.UnlockedConfirmDialog;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HashTagNotesActivity extends AbsAppCompatActivity {
    private static final String EXTRA_LAST_MODIFIED_AT = "last_modified_at";
    private static final String EXTRA_TITLE = "title";
    private static final String TAG = "HashTagNotesActivity";
    private int mCaller;
    private NotesFragment mNotesFragment;
    private int mWidgetId;

    private void executeShareToOtherAppsTask(MainEntryParam mainEntryParam) {
        MainLogger.m7254d(TAG, "executeShareToOtherAppsTask");
        new ShareToOtherAppsTask(this, mainEntryParam, getCallingPackage(), getIntent().getType()).execute(new Void[0]);
    }

    private Bundle getHashTagNoteData(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putInt("mode", 20);
        if (intent == null) {
            return bundle;
        }
        MainHandoffManager.Companion companion = MainHandoffManager.INSTANCE;
        if (companion.getInstance().isHandoffAction(intent)) {
            companion.getInstance().openNoteByHandoff(this, bundle);
            return bundle;
        }
        bundle.putInt(NotesConstants.KEY_CALLER, this.mCaller);
        bundle.putSerializable(Constants.KEY_SELECTED_TAGS, (Serializable) getSelectedTagsFromIntent(intent));
        return bundle;
    }

    @NonNull
    private Set<String> getSelectedTagsFromIntent(Intent intent) {
        Set<String> set = (Set) intent.getSerializableExtra(Constants.KEY_SELECTED_TAGS);
        return set == null ? HashTagListPreferenceHelper.getInstance().getSelectedTags() : set;
    }

    private void onNoteSelectedFromList(MainEntryParam mainEntryParam) {
        int i;
        int lockType = mainEntryParam.getLockType();
        Intent intentMakeIntent = IntentFactory.makeIntent(4, this, mainEntryParam);
        if (lockType == 5 || LockUtils.isLockedSdocType(lockType)) {
            if (intentMakeIntent.getComponent() != null) {
                intentMakeIntent.putExtra(NotesConstants.COMPONENT_NAME, intentMakeIntent.getComponent().getClassName());
            }
            this.mNotesFragment.verifyLockedNote(100, intentMakeIntent, mainEntryParam.getUuid());
            i = 100;
        } else {
            i = 3;
            startActivityForResult(intentMakeIntent, 3);
        }
        AbstractC8014b.m7201c(i, "onNoteSelectedFromList# requestCode : ", TAG);
    }

    private void onNoteSelectedFromOtherApps(MainEntryParam mainEntryParam) {
        int lockType = mainEntryParam.getLockType();
        if (lockType != 5 && !LockUtils.isLockedSdocType(lockType)) {
            executeShareToOtherAppsTask(mainEntryParam);
            return;
        }
        MainLogger.m7258i(TAG, "onNoteSelectedFromOtherApps# lockType : " + lockType);
        String uuid = mainEntryParam.getUuid();
        Intent intent = new Intent();
        intent.putExtra("sdoc_uuid", uuid);
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
        intent.putExtra("doc_path", mainEntryParam.getFilePath());
        intent.putExtra("title", mainEntryParam.getDocTitle());
        intent.putExtra(EXTRA_LAST_MODIFIED_AT, mainEntryParam.getLastModifiedAt());
        this.mNotesFragment.verifyLockedNote(113, intent, uuid);
    }

    private void onNoteSelectedFromWidget(MainEntryParam mainEntryParam) {
        int lockType = mainEntryParam.getLockType();
        MainLogger.m7258i(TAG, "onNoteSelectedFromWidget# lockType : " + lockType);
        String uuid = mainEntryParam.getUuid();
        if (!AppWidgetUtils.isAvailableToAddWidget(getApplicationContext(), uuid, this.mWidgetId)) {
            MainLogger.m7258i(TAG, "onNoteSelectedFromWidget# not availableToAddWidget");
            WidgetUtils.showWidgetAlreadyPinToast(getApplicationContext());
            return;
        }
        if (lockType == 5) {
            showUnlockedConfirmDialog(mainEntryParam);
            return;
        }
        if (LockUtils.isLockedOtherDocType(lockType)) {
            this.mNotesFragment.verifyLockedNote(110, IntentFactory.makeIntent(6, this, mainEntryParam), uuid);
            return;
        }
        Intent intent = new Intent();
        if (getIntent().getBooleanExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false)) {
            intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        } else {
            WidgetBroadcast.sendPickWidgetBroadcast(this, uuid, this.mWidgetId);
        }
        setResult(-1, intent);
        finish();
    }

    private void setBackgroundResources(View view) {
        if (DeviceInfo.isVSTModel()) {
            view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
    }

    private void showUnlockedConfirmDialog(final MainEntryParam mainEntryParam) {
        MainLogger.m7254d(TAG, "showUnlockedConfirmDialog");
        final String uuid = mainEntryParam.getUuid();
        new UnlockedConfirmDialog(this, new UnlockConfirmDialogHelper(this, UnlockConfirmDialogHelper.Caller.PICKER, 0, false), new DialogViewContract.IUnlockConfirmDialog() { // from class: com.samsung.android.support.senl.nt.app.main.hashtag.HashTagNotesActivity.1
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IUnlockConfirmDialog
            public void unLock() {
                Intent intent = new Intent();
                intent.putExtra("sdoc_uuid", uuid);
                intent.putExtra("category_id", mainEntryParam.getFolderUuid());
                intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
                intent.putExtra("doc_path", mainEntryParam.getFilePath());
                HashTagNotesActivity.this.mNotesFragment.unlockNote(108, intent, uuid);
            }
        }).show();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        NotesFragment notesFragment;
        super.onActivityResult(i, i2, intent);
        if (this.mNotesFragment.onActivityResultFromLockManager(i, i2, intent) || (notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG)) == null) {
            return;
        }
        notesFragment.onActivityResultAfterVerify(i, i2, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.execute_noteslist_activity);
        setSupportActionBar((Toolbar) findViewById(C8003R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        this.mWidgetId = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        if (WidgetConstant.ACTION_MEMO_PICK.equals(intent.getAction())) {
            this.mCaller = 1;
        } else if (WidgetConstant.ACTION_MEMO_PICK_COVER.equals(intent.getAction())) {
            this.mCaller = 13;
        } else {
            this.mCaller = intent.getIntExtra(NotesConstants.KEY_CALLER, 0);
        }
        if (bundle != null) {
            this.mNotesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        }
        if (this.mNotesFragment == null) {
            this.mNotesFragment = new NotesFragment(getHashTagNoteData(intent));
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.notes_fragment_container, this.mNotesFragment, NotesFragment.TAG).commitNow();
        }
        this.mNotesFragment.setContract(this);
        setBackgroundResources(findViewById(C8003R.id.activity_container));
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent, NotesFragment.TAG);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return onKeyUp(i, keyEvent, NotesFragment.TAG);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mWidgetId = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment != null) {
            notesFragment.onTagSelectedFromTagActivity(getSelectedTagsFromIntent(intent));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        AbstractC8014b.m7212n(new StringBuilder("onNoteSelected# mCallee: "), TAG, this.mCaller);
        int i = this.mCaller;
        if (i != 1) {
            if (i == 2) {
                onNoteSelectedFromOtherApps(mainEntryParam);
                return;
            } else if (i != 13) {
                onNoteSelectedFromList(mainEntryParam);
                return;
            }
        }
        onNoteSelectedFromWidget(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNotesDataMove(String str) {
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment != null) {
            notesFragment.onNotesDataMove(str);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment != null) {
            notesFragment.onSaveInstanceState(bundle);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void resultVerifyLockNote(Intent intent) {
        executeShareToOtherAppsTask(new MainEntryParam.Builder().setUuid(intent.getStringExtra("sdoc_uuid")).setFilePath(intent.getStringExtra("doc_path")).setGuid(intent.getStringExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID)).setTitle(intent.getStringExtra("title")).setLastModifiedAt(intent.getLongExtra(EXTRA_LAST_MODIFIED_AT, 0L)).build());
    }
}
