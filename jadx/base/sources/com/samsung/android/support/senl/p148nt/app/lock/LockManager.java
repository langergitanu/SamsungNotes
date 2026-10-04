package com.samsung.android.support.senl.p148nt.app.lock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.lock.LockManager;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategyFactory;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J7\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017JA\u0010\u0018\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u001bJA\u0010\u001c\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u001bJA\u0010\u001d\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u001bJA\u0010\u001e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010 \u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\"\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020(H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/LockManager;", "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManager;", "mListener", "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;)V", "mStrategy", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "mStrategyListener", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/ILockStrategyResultListener;", "mLockOperationEnabled", "", "enableLockOperation", "", "enable", "lock", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "uuidList", "", "", "(Landroid/app/Activity;I[Ljava/lang/String;)V", "unlock", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;ILandroid/content/Intent;[Ljava/lang/String;)V", "verify", "verifyWithMultiAccount", "verifyForConvert", "verifyForDelete", "createPassword", "isRequestCodeActivityResult", "onActivityResult", "Landroidx/appcompat/app/AppCompatActivity;", "resultCode", "data", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onRestoreInstanceState", "savedInstanceState", "LockStrategyResultListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockManager implements ILockManager {

    @NotNull
    public static final String EXTRA_KEY_LEGACY_LOCK_AFTER_CONVERT = "extra_key_legacy_lock_after_convert";

    @NotNull
    public static final String EXTRA_KEY_LEGACY_PASSWORD = "extra_key_legacy_password";

    @NotNull
    private static final String KEY_LOCK_MANAGER_STRATEGY = "LockManagerStrategy";

    @NotNull
    private static final String KEY_LOCK_MANAGER_STRATEGY_RESULT_LISTENER = "ILockStrategyResultListener";

    @NotNull
    private final ILockManagerListener mListener;
    private boolean mLockOperationEnabled;

    @Nullable
    private LockManagerStrategy mStrategy;

    @Nullable
    private ILockStrategyResultListener mStrategyListener;

    @NotNull
    private static final String TAG = LockLogger.createTag("LockManager");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0012\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J%\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u0010\"\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/LockManager$LockStrategyResultListener;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/ILockStrategyResultListener;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "getListener", "()Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "setListener", "(Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;)V", "onSuccess", "", "uuid", "", "", "([Ljava/lang/String;)V", "onFail", "failCode", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class LockStrategyResultListener implements ILockStrategyResultListener {

        @Nullable
        private ILockManagerListener listener;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<LockStrategyResultListener> CREATOR = new Parcelable.Creator<LockStrategyResultListener>() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager$LockStrategyResultListener$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LockManager.LockStrategyResultListener createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new LockManager.LockStrategyResultListener(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LockManager.LockStrategyResultListener[] newArray(int size) {
                return new LockManager.LockStrategyResultListener[size];
            }
        };

        public LockStrategyResultListener() {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener, android.os.Parcelable
        public int describeContents() {
            return ILockStrategyResultListener.DefaultImpls.describeContents(this);
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
        @Nullable
        public ILockManagerListener getListener() {
            return this.listener;
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
        public void onFail(int failCode) {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
        public void onSuccess(@NotNull String... uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
        public void setListener(@Nullable ILockManagerListener iLockManagerListener) {
            this.listener = iLockManagerListener;
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            ILockStrategyResultListener.DefaultImpls.writeToParcel(this, parcel, i);
        }

        public LockStrategyResultListener(@Nullable Parcel parcel) {
        }
    }

    public LockManager(@NotNull ILockManagerListener mListener) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.mListener = mListener;
        this.mLockOperationEnabled = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void createPassword(@Nullable Activity activity, final int requestCode, @Nullable final Intent returnData) {
        LockLogger.m7356d(TAG, "createPassword : requestCode(" + requestCode + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.createPassword.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onCreatePasswordFail(requestCode, failCode, returnData);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onCreatePasswordSuccess(requestCode, returnData);
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(7);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.execute(activity, null, returnData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void enableLockOperation(boolean enable) {
        this.mLockOperationEnabled = enable;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public boolean isRequestCodeActivityResult(int requestCode) {
        return requestCode == 1001 || requestCode == 1002 || requestCode == 1003 || requestCode == 1011 || requestCode == 1012 || requestCode == 117;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void lock(@Nullable Activity activity, final int requestCode, @NotNull final String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        String str = TAG;
        String string = Arrays.toString(uuidList);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        LockLogger.m7356d(str, "lock : requestCode(" + requestCode + "), uuidList(" + string + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.lock.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    int i = requestCode;
                    String[] strArr = uuidList;
                    listener.onLockFail(i, failCode, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onLockSuccess(requestCode, new String[0]);
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(1);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setEnabledDBOperation(this.mLockOperationEnabled);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy2 = this.mStrategy;
        if (lockManagerStrategy2 != null) {
            lockManagerStrategy2.execute(activity, uuidList, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy == null) {
            return false;
        }
        Intrinsics.checkNotNull(lockManagerStrategy);
        if (!lockManagerStrategy.isValid()) {
            return false;
        }
        String str = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("onActivityResult from/requestCode/resultCode ", requestCode, activity != null ? activity.getClass().getSimpleName() : null, "/", "/");
        sbM780v.append(resultCode);
        LockLogger.m7356d(str, sbM780v.toString());
        LockManagerStrategy lockManagerStrategy2 = this.mStrategy;
        Intrinsics.checkNotNull(lockManagerStrategy2);
        return lockManagerStrategy2.onActivityResult(activity, requestCode, resultCode, data);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        String str = TAG;
        LockLogger.m7356d(str, "onRestoreInstanceState");
        this.mStrategy = (LockManagerStrategy) savedInstanceState.getParcelable(KEY_LOCK_MANAGER_STRATEGY);
        ILockStrategyResultListener iLockStrategyResultListener = (ILockStrategyResultListener) savedInstanceState.getParcelable(KEY_LOCK_MANAGER_STRATEGY_RESULT_LISTENER);
        this.mStrategyListener = iLockStrategyResultListener;
        if (this.mStrategy == null || iLockStrategyResultListener == null) {
            LockLogger.m7357e(str, "onRestoreInstanceState invalid Strategy!!!");
            return;
        }
        Intrinsics.checkNotNull(iLockStrategyResultListener);
        iLockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        Intrinsics.checkNotNull(lockManagerStrategy);
        lockManagerStrategy.setLockStrategyResultListener(this.mStrategyListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putParcelable(KEY_LOCK_MANAGER_STRATEGY, this.mStrategy);
        outState.putParcelable(KEY_LOCK_MANAGER_STRATEGY_RESULT_LISTENER, this.mStrategyListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void unlock(@Nullable Activity activity, final int requestCode, @Nullable final Intent returnData, @NotNull final String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        String str = TAG;
        String string = Arrays.toString(uuidList);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        LockLogger.m7356d(str, "unlock : requestCode(" + requestCode + "), uuidList(" + string + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.unlock.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    int i = requestCode;
                    String[] strArr = uuidList;
                    listener.onUnlockFail(i, failCode, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    int i = requestCode;
                    Intent intent = returnData;
                    String[] strArr = uuidList;
                    listener.onUnlockSuccess(i, intent, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(2);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setEnabledDBOperation(this.mLockOperationEnabled);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy2 = this.mStrategy;
        if (lockManagerStrategy2 != null) {
            lockManagerStrategy2.execute(activity, uuidList, returnData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void verify(@Nullable Activity activity, final int requestCode, @Nullable final Intent returnData, @NotNull final String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        String str = TAG;
        String string = Arrays.toString(uuidList);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        LockLogger.m7356d(str, "verify : requestCode(" + requestCode + "), uuidList(" + string + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.verify.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    int i = requestCode;
                    String[] strArr = uuidList;
                    listener.onVerifyFail(i, failCode, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onVerifySuccess(requestCode, returnData, (String[]) Arrays.copyOf(uuid, uuid.length));
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(3);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.execute(activity, uuidList, returnData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void verifyForConvert(@Nullable Activity activity, final int requestCode, @Nullable final Intent returnData, @NotNull final String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        String str = TAG;
        String string = Arrays.toString(uuidList);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        LockLogger.m7356d(str, "verifyForConvert : requestCode(" + requestCode + "), uuidList(" + string + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.verifyForConvert.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    int i = requestCode;
                    String[] strArr = uuidList;
                    listener.onVerifyFail(i, failCode, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onVerifySuccess(requestCode, returnData, (String[]) Arrays.copyOf(uuid, uuid.length));
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(4);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.execute(activity, uuidList, returnData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void verifyForDelete(@Nullable Activity activity, final int requestCode) {
        LockLogger.m7356d(TAG, "verifyForDelete : requestCode(" + requestCode + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.verifyForDelete.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onVerifyFail(requestCode, failCode, new String[0]);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onVerifySuccess(requestCode, null, new String[0]);
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(5);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.execute(activity, null, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager
    public void verifyWithMultiAccount(@Nullable Activity activity, final int requestCode, @Nullable final Intent returnData, @NotNull final String... uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        String str = TAG;
        String string = Arrays.toString(uuidList);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        LockLogger.m7356d(str, "verifyWithMultiAccount : requestCode(" + requestCode + "), uuidList(" + string + ")");
        LockStrategyResultListener lockStrategyResultListener = new LockStrategyResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockManager.verifyWithMultiAccount.1
            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onFail(int failCode) {
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    int i = requestCode;
                    String[] strArr = uuidList;
                    listener.onVerifyFail(i, failCode, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.LockManager.LockStrategyResultListener, com.samsung.android.support.senl.p148nt.app.lock.strategy.ILockStrategyResultListener
            public void onSuccess(String... uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ILockManagerListener listener = getListener();
                if (listener != null) {
                    listener.onVerifySuccess(requestCode, returnData, (String[]) Arrays.copyOf(uuid, uuid.length));
                }
            }
        };
        this.mStrategyListener = lockStrategyResultListener;
        Intrinsics.checkNotNull(lockStrategyResultListener);
        lockStrategyResultListener.setListener(this.mListener);
        LockManagerStrategy operator = LockManagerStrategyFactory.INSTANCE.getOperator(6);
        this.mStrategy = operator;
        if (operator != null) {
            operator.setLockStrategyResultListener(this.mStrategyListener);
        }
        LockManagerStrategy lockManagerStrategy = this.mStrategy;
        if (lockManagerStrategy != null) {
            lockManagerStrategy.execute(activity, uuidList, returnData);
        }
    }
}
