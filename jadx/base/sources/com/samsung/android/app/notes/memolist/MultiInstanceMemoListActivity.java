package com.samsung.android.app.notes.memolist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MultiInstanceMemoListActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MultiTaskManager.getInstance().initialize(MemoListActivity.class);
        MultiTaskManager.getInstance().launchActivity(this);
        finish();
    }
}
