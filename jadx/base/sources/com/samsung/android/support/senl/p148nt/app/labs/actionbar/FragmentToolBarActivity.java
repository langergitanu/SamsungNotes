package com.samsung.android.support.senl.p148nt.app.labs.actionbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FragmentToolBarActivity extends AppCompatActivity {
    private void initRightFragment() {
        if (getSupportFragmentManager().findFragmentByTag("ActionBarRightFragment") != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(C8003R.id.rightFragmentContainer, new RightToolbarFragment(), "ActionBarRightFragment").commit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.labs_actionbar_activity);
        getSupportActionBar().hide();
        if (bundle == null) {
            initRightFragment();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
