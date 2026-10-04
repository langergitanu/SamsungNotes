package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.account.GUIDManager;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0010\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J/\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\nH\u0002¢\u0006\u0002\u0010\u001eJ,\u0010\u001f\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mGUIDManager", "Lcom/samsung/android/support/senl/nt/app/account/GUIDManager;", "mUuidList", "", "", "[Ljava/lang/String;", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "requestGuid", "needToCheckAccount", "", "lockWithGUID", "scenario", "", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "executeLockTask", "requestUuids", "(Landroid/app/Activity;[Ljava/lang/String;)V", "onActivityResult", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "resultCode", "data", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLockStrategy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockStrategy.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/LockStrategy\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n37#2:157\n36#2,3:158\n1#3:161\n*S KotlinDebug\n*F\n+ 1 LockStrategy.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/LockStrategy\n*L\n102#1:157\n102#1:158,3\n*E\n"})
public final class LockStrategy extends LockManagerStrategy {

    @Nullable
    private GUIDManager mGUIDManager;

    @Nullable
    private String[] mUuidList;

    @NotNull
    private static final String TAG = LockLogger.createTag("LockStrategy");

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LockStrategy> CREATOR = new Parcelable.Creator<LockStrategy>() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.LockStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LockStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new LockStrategy(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LockStrategy[] newArray(int size) {
            return new LockStrategy[size];
        }
    };

    public LockStrategy() {
        this.mGUIDManager = new GUIDManager();
    }

    private final void executeLockTask(Activity activity, String[] requestUuids) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<NotesDocumentEntity> unLockedEntities = LockManagerStrategyUtils.getUnLockedEntities(activity, CollectionsKt.listOf(Arrays.copyOf(requestUuids, requestUuids.length)));
        if (unLockedEntities.isEmpty()) {
            ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
            if (iLockStrategyResultListener != null) {
                iLockStrategyResultListener.onFail(1);
                return;
            }
            return;
        }
        for (NotesDocumentEntity notesDocumentEntity : unLockedEntities) {
            if (notesDocumentEntity.getIsDeleted() == 0) {
                String uuid = notesDocumentEntity.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
                arrayList.add(new LockTask.DocumentInfo(uuid, notesDocumentEntity.isSdoc()));
                String uuid2 = notesDocumentEntity.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                arrayList2.add(uuid2);
            }
        }
        if (arrayList2.size() < unLockedEntities.size()) {
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onFail(10);
                return;
            }
            return;
        }
        RunnableC4199v runnableC4199v = new RunnableC4199v(this, (String[]) arrayList2.toArray(new String[0]), 19);
        if (!this.mDBOperationEnabled) {
            runnableC4199v.run();
            return;
        }
        LockLogger.m7356d(TAG, "executeLockNotes# uuid length : " + arrayList2.size());
        new LockTask(activity, true, false, runnableC4199v).executeOnExecutor(LockTask.SINGLE_THREAD_EXECUTOR, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeLockTask$lambda$0(LockStrategy lockStrategy, String[] strArr) {
        ILockStrategyResultListener iLockStrategyResultListener = lockStrategy.mListener;
        if (iLockStrategyResultListener != null) {
            iLockStrategyResultListener.onSuccess((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lockWithGUID(Activity activity, String[] uuidList, int scenario) {
        if (!isAccountChanged(activity) && LockUtils.isSetPassword(activity)) {
            executeLockTask(activity, uuidList);
        } else {
            LockLogger.m7357e(TAG, "account changed or no password");
            createPasswordAndContinue(activity, 1001, scenario, uuidList);
        }
    }

    private final void requestGuid(final Activity activity, final boolean needToCheckAccount) {
        LockLogger.m7356d(TAG, "requestGuid needToCheckAccount " + needToCheckAccount);
        if (this.mGUIDManager == null) {
            this.mGUIDManager = new GUIDManager();
        }
        GUIDManager gUIDManager = this.mGUIDManager;
        if (gUIDManager != null) {
            gUIDManager.requestGUID(activity, new GUIDManager.OnRequestGUIDListener() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.LockStrategy.requestGuid.1
                @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                public void onFail() {
                    LockLogger.m7356d(LockStrategy.TAG, "onFail");
                    ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
                    if (iLockStrategyResultListener != null) {
                        iLockStrategyResultListener.onFail(7);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                public void onSuccess(String guid) {
                    Intrinsics.checkNotNullParameter(guid, "guid");
                    LockLogger.m7356d(LockStrategy.TAG, "onSuccess, GUID received");
                    int i = needToCheckAccount ? 1 : 11;
                    String[] strArr = this.mUuidList;
                    if (strArr != null) {
                        this.lockWithGUID(activity, strArr, i);
                    }
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public void execute(@Nullable Activity activity, @Nullable String[] uuidList, @Nullable Intent returnData) {
        String str = TAG;
        LockLogger.m7356d(str, "execute");
        if (activity == null || uuidList == null || uuidList.length == 0) {
            LockLogger.m7357e(str, "empty");
            ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
            if (iLockStrategyResultListener != null) {
                iLockStrategyResultListener.onFail(1);
                return;
            }
            return;
        }
        if (PermissionHelper.isPermissionGrantedWithoutNotice(activity, "android.permission.GET_ACCOUNTS")) {
            this.mUuidList = uuidList;
            requestGuid(activity, true);
        } else {
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onFail(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        LockLogger.m7356d(TAG, "onActivityResult : request/result -> " + requestCode + "/" + resultCode);
        super.onActivityResult(activity, requestCode, resultCode, data);
        if (activity == null || requestCode != 117) {
            if (requestCode != 1001) {
                return false;
            }
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
        if (resultCode == -1) {
            GUIDManager gUIDManager = this.mGUIDManager;
            if (gUIDManager != null) {
                Intrinsics.checkNotNull(gUIDManager);
                if (gUIDManager.isGuidReceived(activity)) {
                    String[] strArr = this.mUuidList;
                    if (strArr != null) {
                        lockWithGUID(activity, strArr, 11);
                    }
                } else {
                    requestGuid(activity, false);
                }
            }
        } else {
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onFail(2);
            }
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockStrategy(@Nullable Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNull(parcel);
    }
}
