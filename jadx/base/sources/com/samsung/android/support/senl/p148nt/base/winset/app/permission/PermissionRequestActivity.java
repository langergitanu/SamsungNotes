package com.samsung.android.support.senl.p148nt.base.winset.app.permission;

import android.app.Activity;
import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionRequestActivity;", "Landroid/app/Activity;", "<init>", "()V", "mMessage", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPermissionRequestActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionRequestActivity.kt\ncom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionRequestActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,56:1\n1#2:57\n*E\n"})
public final class PermissionRequestActivity extends Activity {

    @NotNull
    public static final String PERMISSION_MESSAGE = "permission_message";

    @Nullable
    private String mMessage;

    @NotNull
    private static final String TAG = Logger.createTag("PermissionRequestActivity");

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.m8697d(TAG, "onCreate#");
        NotificationUtils.checkedNotificationPermissions(this, 10001);
        this.mMessage = getIntent().getStringExtra(PERMISSION_MESSAGE);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Logger.m8697d(TAG, "onDestroy#");
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 10001) {
            if (!PermissionHelper.verifyRequestResult(this, grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
                Logger.m8697d(TAG, "onRequestPermissionsResult# PERMISSION_REQUEST_NOTIFICATION not verified");
            }
            String str = this.mMessage;
            if (str != null) {
                ToastHandler.show(this, str, 1);
            }
        } else {
            Logger.m8698e(TAG, "onRequestPermissionsResult# unexpected requestCode: " + requestCode);
        }
        finish();
    }
}
