package com.samsung.android.support.senl.p148nt.app.main.invitation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BaseSesSessionActivity;
import com.samsung.android.support.senl.p148nt.app.main.invitation.View.GcsInvitationFragment;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsInvitationActivity extends BaseSesSessionActivity {
    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(C8003R.id.toolbar);
        toolbar.setTitle(C8003R.string.gcs_invitations);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(C8003R.id.collapsing_app_bar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.BaseSesSessionActivity
    public String getTag() {
        return AbstractC0622a.m1170p(super.getTag(), "GcsInvitationActivity", new StringBuilder());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.BaseSesSessionActivity, com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.gcs_invitation_list_activity);
        initToolBar();
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.fragment_container, new GcsInvitationFragment(), GcsInvitationFragment.TAG).commit();
        }
        ContextUtils.setTaskDescription(this, C8003R.color.task_description_title_color);
        WindowManagerCompat.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.BaseSesSessionActivity
    public boolean onSesSessionConnected() {
        boolean zOnSesSessionConnected = super.onSesSessionConnected();
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof GcsInvitationFragment) {
                ((GcsInvitationFragment) fragment).onSesSessionConnected();
            }
        }
        return zOnSesSessionConnected;
    }
}
