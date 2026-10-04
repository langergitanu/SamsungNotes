package com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.view.CoeditSpacePickerFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnectorImpl;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpacePickerActivity extends AbsAppCompatActivity {
    private static final String TAG = "CoeditSpacePickerActivity";
    private CoeditSessionConnector mSessionConnector;

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(C8003R.id.toolbar);
        toolbar.setTitle(C8003R.string.co_edit_space_select);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFragment(@Nullable Bundle bundle) {
        if (this.mSessionConnector.isStorageFull()) {
            ToastHandler.show(getApplicationContext(), getString(C8003R.string.co_edit_cannot_create_shared_note_storage_full), 1, false);
            finish();
            return;
        }
        CoeditSpacePickerFragment coeditSpacePickerFragment = bundle != null ? (CoeditSpacePickerFragment) getSupportFragmentManager().findFragmentByTag(CoeditSpacePickerFragment.TAG) : null;
        if (coeditSpacePickerFragment == null) {
            coeditSpacePickerFragment = new CoeditSpacePickerFragment();
            Intent intent = getIntent();
            if (intent != null) {
                coeditSpacePickerFragment.setArguments(intent.getExtras());
            }
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.fragment_container, coeditSpacePickerFragment, CoeditSpacePickerFragment.TAG).commit();
        }
        coeditSpacePickerFragment.setCoeditSessionConnector(this.mSessionConnector);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DisplayUtils.updateListWidthByScreenSize(this, findViewById(C8003R.id.activity_layout));
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.coedit_space_picker_activity);
        initToolBar();
        MainCoeditLogger.m7250d(TAG, "onCreate");
        CoeditSessionConnectorImpl coeditSessionConnectorImpl = new CoeditSessionConnectorImpl(getApplicationContext(), TAG, new CoeditSessionConnector.ActivityContract() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.CoeditSpacePickerActivity.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void finishActivity() {
                CoeditSpacePickerActivity.this.finish();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public FragmentActivity getActivity() {
                return CoeditSpacePickerActivity.this;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback) {
                CoeditSpacePickerActivity.this.launchActivity(intent, notesActivityResultCallback);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void onSessionConnected(boolean z) {
                if (z) {
                    CoeditSpacePickerActivity.this.setFragment(bundle);
                } else {
                    CoeditSpacePickerActivity.this.finish();
                }
            }
        });
        this.mSessionConnector = coeditSessionConnectorImpl;
        if (!coeditSessionConnectorImpl.isLatestNotesVersion()) {
            MainCoeditLogger.m7253i(TAG, "onCreate# isLatestNotesVersion false");
            return;
        }
        if (this.mSessionConnector.connect()) {
            setFragment(bundle);
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE_PICKER);
        WindowManagerCompat.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mSessionConnector.disconnect();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DisplayUtils.updateListWidthByScreenSize(this, findViewById(C8003R.id.activity_layout));
    }
}
