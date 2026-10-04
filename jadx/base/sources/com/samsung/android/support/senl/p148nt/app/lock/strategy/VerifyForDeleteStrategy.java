package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.account.GUIDManager;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/VerifyForDeleteStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "verifyWithGUID", "(Landroid/app/Activity;[Ljava/lang/String;)V", "onActivityResult", "", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "", "resultCode", "data", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VerifyForDeleteStrategy extends LockManagerStrategy {

    @NotNull
    private static final String TAG = LockLogger.createTag("VerifyForDeleteStrategy");

    @JvmField
    @NotNull
    public static final Parcelable.Creator<VerifyForDeleteStrategy> CREATOR = new Parcelable.Creator<VerifyForDeleteStrategy>() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.VerifyForDeleteStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifyForDeleteStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new VerifyForDeleteStrategy(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifyForDeleteStrategy[] newArray(int size) {
            return new VerifyForDeleteStrategy[size];
        }
    };

    public VerifyForDeleteStrategy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyWithGUID(Activity activity, String[] uuidList) {
        if (activity != null && (isAccountChanged(activity) || !LockUtils.isSetPassword(activity))) {
            LockLogger.m7357e(TAG, "account changed or no password");
            createPasswordAndContinue(activity, 1005, 1, uuidList);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) LockActivity.class);
        intent.putExtra("key_lock_scenario_type", 5);
        if (activity != null) {
            activity.startActivityForResult(intent, 1015);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public void execute(@Nullable final Activity activity, @Nullable final String[] uuidList, @Nullable Intent returnData) {
        LockLogger.m7356d(TAG, "execute");
        new GUIDManager().requestGUID(activity, new GUIDManager.OnRequestGUIDListener() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.VerifyForDeleteStrategy.execute.1
            @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
            public void onFail() {
                ILockStrategyResultListener iLockStrategyResultListener = VerifyForDeleteStrategy.this.mListener;
                if (iLockStrategyResultListener != null) {
                    iLockStrategyResultListener.onFail(7);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
            public void onSuccess(String guid) {
                Intrinsics.checkNotNullParameter(guid, "guid");
                LockLogger.m7356d(VerifyForDeleteStrategy.TAG, "GUID received");
                VerifyForDeleteStrategy.this.verifyWithGUID(activity, uuidList);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        LockLogger.m7356d(TAG, "onActivityResult : request/result -> " + requestCode + "/" + resultCode);
        super.onActivityResult(activity, requestCode, resultCode, data);
        if (requestCode == 1005) {
            if (resultCode == -1) {
                execute(activity, data != null ? data.getStringArrayExtra(LockManagerStrategy.EXTRA_KEY_UUID) : null, data);
            } else {
                ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
                if (iLockStrategyResultListener != null) {
                    iLockStrategyResultListener.onFail(5);
                }
            }
            return true;
        }
        if (requestCode != 1015) {
            return false;
        }
        if (resultCode == -1) {
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onSuccess(new String[0]);
            }
        } else {
            ILockStrategyResultListener iLockStrategyResultListener3 = this.mListener;
            if (iLockStrategyResultListener3 != null) {
                iLockStrategyResultListener3.onFail(6);
            }
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyForDeleteStrategy(@NotNull Parcel in) {
        super(in);
        Intrinsics.checkNotNullParameter(in, "in");
    }
}
