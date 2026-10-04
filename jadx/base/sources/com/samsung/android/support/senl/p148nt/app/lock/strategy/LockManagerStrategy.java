package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockDialogUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnClickListenerC0174a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 42\u00020\u0001:\u00014B\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J,\u0010\u001a\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\bJ\u000e\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\nJ-\u0010#\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010$\u001a\u00020%H\u0004¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+H\u0004J9\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0004¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u0019H\u0016J\u0018\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0019H\u0016R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "Landroid/os/Parcelable;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mListener", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/ILockStrategyResultListener;", "mDBOperationEnabled", "", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "isValid", "()Z", "showToast", "failCode", "", "onActivityResult", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "resultCode", "data", "setLockStrategyResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setEnabledDBOperation", "enabled", "migrateSDOCPreProcess", "cancel", "Ljava/lang/Runnable;", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/Runnable;)Z", "migrateSDOCPostProcess", "currentGuid", "isAccountChanged", "context", "Landroid/content/Context;", "createPasswordAndContinue", "continueRequestCode", "scenario", "(Landroid/app/Activity;II[Ljava/lang/String;)V", "describeContents", "writeToParcel", "parcel", "i", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class LockManagerStrategy implements Parcelable {

    @NotNull
    protected static final String EXTRA_KEY_MIGRATE_SDOC_USER_GUID = "extra_key_migrate_sdoc_user_guid";

    @NotNull
    public static final String EXTRA_KEY_UUID = "extra_uuid";

    @JvmField
    protected boolean mDBOperationEnabled;

    @JvmField
    @Nullable
    protected ILockStrategyResultListener mListener;

    @NotNull
    private static final String TAG = LockLogger.createTag("LockManagerStrategy");

    public LockManagerStrategy() {
        this.mDBOperationEnabled = true;
    }

    private final void migrateSDOCPostProcess(Activity activity, String currentGuid) {
        if (currentGuid == null) {
            return;
        }
        DocumentLockResolver.changeLockGuidForUndefined(activity, currentGuid, 1, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void migrateSDOCPreProcess$lambda$0(Activity activity, String str, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(activity, (Class<?>) LockActivity.class);
        intent.putExtra(EXTRA_KEY_MIGRATE_SDOC_USER_GUID, str);
        intent.putExtra("key_lock_scenario_type", 6);
        activity.startActivityForResult(intent, 1014);
    }

    public final void createPasswordAndContinue(@NotNull Activity activity, int continueRequestCode, int scenario, @Nullable String[] uuidList) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent(activity, (Class<?>) LockActivity.class);
        intent.putExtra(EXTRA_KEY_UUID, uuidList);
        intent.putExtra("key_lock_scenario_type", scenario);
        activity.startActivityForResult(intent, continueRequestCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract void execute(@Nullable Activity activity, @Nullable String[] uuidList, @Nullable Intent returnData);

    public final boolean isAccountChanged(@Nullable Context context) {
        String strM14294h = C13541h.m14287e().m14294h();
        String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        String localPasswordOwnerGuid = LockPrefUtils.getLocalPasswordOwnerGuid(context);
        String localUserID = context == null ? null : LockPrefUtils.getLocalUserID(context);
        if (TextUtils.isEmpty(localPasswordOwnerGuid) && TextUtils.isEmpty(localUserID)) {
            LockPrefUtils.setLocalPasswordOwnerGuid(context, strM14294h);
            return false;
        }
        if (TextUtils.isEmpty(localPasswordOwnerGuid)) {
            if (!Intrinsics.areEqual(localUserID, str)) {
                LockLogger.m7358i(TAG, "account is changed, diff account");
                return true;
            }
        } else if (!Intrinsics.areEqual(localPasswordOwnerGuid, strM14294h)) {
            LockLogger.m7358i(TAG, "account is changed, empty GUID ? : saved = " + LockUtils.isEmptyGuid(localPasswordOwnerGuid) + " cur = " + LockUtils.isEmptyGuid(strM14294h));
            return true;
        }
        return false;
    }

    public final boolean isValid() {
        boolean z = this.mListener != null;
        LockLogger.m7356d(TAG, "isValid " + z);
        return z;
    }

    public final boolean migrateSDOCPreProcess(@NotNull Activity activity, @NotNull String[] uuidList, @NotNull Runnable cancel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        LockLogger.m7356d(TAG, "migrateSdocPreProcess");
        String strM14294h = C13541h.m14287e().m14294h();
        String localUserID = LockPrefUtils.getLocalUserID(activity);
        String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        ArrayList arrayList = new ArrayList();
        for (String str2 : uuidList) {
            if (str2 != null) {
                NotesDocumentEntity noteEntity = LockManagerStrategyUtils.getNoteEntity(activity, str2);
                String lockAccountGuid = noteEntity.getLockAccountGuid();
                if (LockUtils.isLockedSdocType(noteEntity.getIsLock()) && TextUtils.isEmpty(lockAccountGuid) && LockUtils.isNoteOwner(lockAccountGuid, strM14294h, localUserID, str) == 3) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        LockDialogUtils.showSdocMigrationDialog(activity, new DialogInterfaceOnClickListenerC0174a(activity, strM14294h, 1), new DialogInterfaceOnClickListenerC0161a(cancel, 3));
        return true;
    }

    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 1014) {
            return false;
        }
        if (activity == null || resultCode != -1 || data == null) {
            return true;
        }
        migrateSDOCPostProcess(activity, data.getStringExtra(EXTRA_KEY_MIGRATE_SDOC_USER_GUID));
        return true;
    }

    public final void setEnabledDBOperation(boolean enabled) {
        this.mDBOperationEnabled = enabled;
    }

    public final void setLockStrategyResultListener(@Nullable ILockStrategyResultListener listener) {
        this.mListener = listener;
        LockLogger.m7356d(TAG, "setLockStrategyResultListener -> " + (listener != null ? listener.hashCode() : 0));
    }

    public final void showToast(@NotNull Activity activity, int failCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (failCode != 11) {
            LockLogger.m7356d(TAG, "showToast not defined failCode");
            return;
        }
        String string = activity.getString(C9086R.string.composer_can_not_open_file);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ToastHandler.show(activity, string, 1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.writeBoolean(this.mDBOperationEnabled);
        } else {
            parcel.writeInt(this.mDBOperationEnabled ? 1 : 0);
        }
    }

    public LockManagerStrategy(@NotNull Parcel in) {
        boolean z;
        Intrinsics.checkNotNullParameter(in, "in");
        if (Build.VERSION.SDK_INT >= 29) {
            z = in.readBoolean();
        } else {
            z = in.readInt() == 1;
        }
        this.mDBOperationEnabled = z;
    }
}
