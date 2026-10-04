package com.samsung.android.support.senl.p148nt.base.winset.app.permission;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002R\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/permission/GoToSettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mRequiredPermissions", "", "", "[Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "", "checkPermission", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class GoToSettingsActivity extends AppCompatActivity {

    @NotNull
    public static final String EXTRA_KEY_PERMISSION_MSG_TYPE = "extra_key_permission_msg";

    @NotNull
    public static final String EXTRA_KEY_REQUIRED_PERMISSION_LIST = "extra_key_permission_list";

    @Nullable
    private String[] mRequiredPermissions = new String[0];

    private final void checkPermission() {
        String[] strArr = this.mRequiredPermissions;
        Intrinsics.checkNotNull(strArr);
        boolean z = true;
        for (String str : strArr) {
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(this, str)) {
                z = false;
            }
        }
        if (z) {
            setResult(-1);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        setContentView(C8875R.layout.goto_settings_activity);
        TextView textView = (TextView) findViewById(C8875R.id.goto_setting_title);
        if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
            textView.setText(C8875R.string.notes_jp);
        } else {
            textView.setText(C8875R.string.notes);
        }
        if (getIntent().getIntExtra(EXTRA_KEY_PERMISSION_MSG_TYPE, 0) == 0) {
            string = getResources().getString(C8875R.string.goto_settings_to_get_permission);
            Intrinsics.checkNotNull(string);
        } else {
            string = getResources().getString(C8875R.string.goto_settings_to_get_permissions);
            Intrinsics.checkNotNull(string);
        }
        ((TextView) findViewById(C8875R.id.goto_setting_msg)).setText(string);
        ((Button) findViewById(C8875R.id.goto_setting_btn)).setOnClickListener(new ViewOnClickListenerC8556a(this, 8));
        if (getIntent().hasExtra(EXTRA_KEY_REQUIRED_PERMISSION_LIST)) {
            this.mRequiredPermissions = getIntent().getStringArrayExtra(EXTRA_KEY_REQUIRED_PERMISSION_LIST);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            checkPermission();
        }
    }
}
