package com.samsung.android.support.senl.p148nt.base.widget.lockbrief;

import android.app.KeyguardManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startActivity", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseWidgetLockBriefUnlockActivity extends AppCompatActivity {

    @NotNull
    private static final String TAG = "WidgetLockBriefConfigActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KeyguardManagerCompat.Companion companion = KeyguardManagerCompat.INSTANCE;
        if (companion.getInstance().isKeyguardLocked(this) || companion.getInstance().isKeyguardSecureOn(this)) {
            companion.getInstance().requestDismissKeyguard(this, new KeyguardManager.KeyguardDismissCallback() { // from class: com.samsung.android.support.senl.nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity.onCreate.1
                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissCancelled() {
                    super.onDismissCancelled();
                    BaseWidgetLockBriefUnlockActivity.this.finish();
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissError() {
                    super.onDismissError();
                    BaseWidgetLockBriefUnlockActivity.this.finish();
                }

                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissSucceeded() {
                    super.onDismissSucceeded();
                    BaseWidgetLockBriefUnlockActivity.this.startActivity();
                }
            });
            return;
        }
        WindowManagerCompat.Companion companion2 = WindowManagerCompat.INSTANCE;
        companion2.getInstance().setShowWhenLocked(this, true, false);
        companion2.getInstance().setTurnScreenOn(this, true, false);
        startActivity();
    }

    public abstract void startActivity();
}
