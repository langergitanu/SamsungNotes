package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/CreatePasswordStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "onActivityResult", "", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "", "resultCode", "data", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CreatePasswordStrategy extends LockManagerStrategy {

    @NotNull
    private static final String TAG = LockLogger.createTag("CreatePasswordStrategy");

    @JvmField
    @NotNull
    public static final Parcelable.Creator<CreatePasswordStrategy> CREATOR = new Parcelable.Creator<CreatePasswordStrategy>() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.CreatePasswordStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreatePasswordStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new CreatePasswordStrategy(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreatePasswordStrategy[] newArray(int size) {
            return new CreatePasswordStrategy[size];
        }
    };

    public CreatePasswordStrategy() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public void execute(@Nullable Activity activity, @Nullable String[] uuidList, @Nullable Intent returnData) {
        LockLogger.m7356d(TAG, "execute");
        Intent intent = new Intent(activity, (Class<?>) LockActivity.class);
        intent.putExtra("key_lock_scenario_type", 1);
        if (activity != null) {
            activity.startActivityForResult(intent, 1013);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        LockLogger.m7356d(TAG, "onActivityResult : request/result -> " + requestCode + "/" + resultCode);
        super.onActivityResult(activity, requestCode, resultCode, data);
        if (requestCode != 1013) {
            return false;
        }
        if (resultCode == -1) {
            ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
            if (iLockStrategyResultListener == null) {
                return true;
            }
            iLockStrategyResultListener.onSuccess(new String[0]);
            return true;
        }
        ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
        if (iLockStrategyResultListener2 == null) {
            return true;
        }
        iLockStrategyResultListener2.onFail(6);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatePasswordStrategy(@NotNull Parcel in) {
        super(in);
        Intrinsics.checkNotNullParameter(in, "in");
    }
}
