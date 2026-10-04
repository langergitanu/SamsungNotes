package com.samsung.android.app.notes.nativecomposer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\nH\u0002J+\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/notes/nativecomposer/NativeComposerActionNewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "printCaller", "checkPermissions", "", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNativeComposerActionNewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NativeComposerActionNewActivity.kt\ncom/samsung/android/app/notes/nativecomposer/NativeComposerActionNewActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,76:1\n37#2:77\n36#2,3:78\n*S KotlinDebug\n*F\n+ 1 NativeComposerActionNewActivity.kt\ncom/samsung/android/app/notes/nativecomposer/NativeComposerActionNewActivity\n*L\n48#1:77\n48#1:78,3\n*E\n"})
public final class NativeComposerActionNewActivity extends AppCompatActivity {

    @NotNull
    private static final String ARG_CALLER = "caller";

    @NotNull
    private static final String TAG = "NativeComposerActionNewActivity";

    private final boolean checkPermissions() {
        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(4)).toArray(new String[0]);
        if (PermissionHelper.isPermissionGrantedWithoutNotice(this, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            return false;
        }
        Logger.m8702i(TAG, "onCreate# to get WRITE_EXTERNAL_STORAGE permission");
        PermissionHelper.requestPermissions((Activity) this, 102, true, (String[]) Arrays.copyOf(strArr, strArr.length));
        return true;
    }

    private final void printCaller() {
        AbstractC4539a.m3203m(getIntent().getIntExtra("caller", -1), "ARG_CALLER : ", TAG);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Intrinsics.areEqual("android.intent.action.SEND", getIntent().getAction()) || Intrinsics.areEqual("android.intent.action.SEND_MULTIPLE", getIntent().getAction())) {
            printCaller();
            ActivityUtil activityUtil = ActivityUtil.INSTANCE;
            activityUtil.executePostLaunchManager();
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            String name = NativeComposerActionNewActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            activityUtil.makeIntentForComposer(applicationContext, intent, name);
            if (checkPermissions()) {
                return;
            } else {
                startActivity(getIntent());
            }
        } else if (Intrinsics.areEqual(ComposerConstants.ACTION_NEW_MEMO_MATH, getIntent().getAction())) {
            Logger.m8697d(TAG, "onCreate, trigger by math action");
            ActivityUtil activityUtil2 = ActivityUtil.INSTANCE;
            activityUtil2.executePostLaunchManager();
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
            String name2 = NativeComposerActionNewActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            activityUtil2.makeIntentForComposer(applicationContext2, intent2, name2);
            FolderManager.getInstance().initializePredefined(8);
            getIntent().putExtra("category_id", PredefinedCategory.MATH_NOTES.getUuid());
            if (checkPermissions()) {
                return;
            } else {
                startActivity(getIntent());
            }
        } else {
            AbstractC4539a.m3214x("onCreate, trigger by unknown action: ", getIntent().getAction(), TAG);
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AbstractC4539a.m3212v(requestCode, "onRequestPermissionsResult# requestCode: ", TAG);
        if (requestCode != 102) {
            return;
        }
        if (PermissionHelper.verifyRequestResult(this, grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
            startActivity(getIntent());
        } else {
            Logger.m8702i(TAG, "onRequestPermissionsResult# permission is not granted.");
        }
        finish();
    }
}
