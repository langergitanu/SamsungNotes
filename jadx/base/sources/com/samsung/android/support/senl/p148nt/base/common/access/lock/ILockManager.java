package com.samsung.android.support.senl.p148nt.base.common.access.lock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJA\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000fJA\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000fJA\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000fJA\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH&J,\u0010\u0016\u001a\u00020\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0017H&J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u001fH&¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManager;", "", "lock", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "uuidList", "", "", "(Landroid/app/Activity;I[Ljava/lang/String;)V", "unlock", "data", "Landroid/content/Intent;", "(Landroid/app/Activity;ILandroid/content/Intent;[Ljava/lang/String;)V", "verify", "verifyWithMultiAccount", "returnData", "verifyForConvert", "verifyForDelete", "createPassword", "onActivityResult", "", "Landroidx/appcompat/app/AppCompatActivity;", "resultCode", "enableLockOperation", "enable", "isRequestCodeActivityResult", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onRestoreInstanceState", "savedInstanceState", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILockManager {
    void createPassword(@Nullable Activity activity, int requestCode, @Nullable Intent returnData);

    void enableLockOperation(boolean enable);

    boolean isRequestCodeActivityResult(int requestCode);

    void lock(@Nullable Activity activity, int requestCode, @NotNull String... uuidList);

    boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data);

    void onRestoreInstanceState(@NotNull Bundle savedInstanceState);

    void onSaveInstanceState(@NotNull Bundle outState);

    void unlock(@Nullable Activity activity, int requestCode, @Nullable Intent data, @NotNull String... uuidList);

    void verify(@Nullable Activity activity, int requestCode, @Nullable Intent data, @NotNull String... uuidList);

    void verifyForConvert(@Nullable Activity activity, int requestCode, @Nullable Intent returnData, @NotNull String... uuidList);

    void verifyForDelete(@Nullable Activity activity, int requestCode);

    void verifyWithMultiAccount(@Nullable Activity activity, int requestCode, @Nullable Intent returnData, @NotNull String... uuidList);
}
