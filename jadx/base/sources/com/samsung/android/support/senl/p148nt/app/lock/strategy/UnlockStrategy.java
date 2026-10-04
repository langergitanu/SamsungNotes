package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.GUIDManager;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategyUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0012J5\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/UnlockStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "unlockWithGUID", "(Landroid/app/Activity;Landroid/content/Intent;[Ljava/lang/String;)V", "executeUnlockTask", "onPostUnlock", "Ljava/lang/Runnable;", "docUuids", "(Landroid/app/Activity;Ljava/lang/Runnable;[Ljava/lang/String;)V", "onActivityResult", "", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "", "resultCode", "data", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUnlockStrategy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnlockStrategy.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/UnlockStrategy\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,182:1\n37#2:183\n36#2,3:184\n*S KotlinDebug\n*F\n+ 1 UnlockStrategy.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/UnlockStrategy\n*L\n70#1:183\n70#1:184,3\n*E\n"})
public final class UnlockStrategy extends LockManagerStrategy {

    @NotNull
    private static final String TAG = LockLogger.createTag("UnlockStrategy");

    @JvmField
    @NotNull
    public static final Parcelable.Creator<UnlockStrategy> CREATOR = new Parcelable.Creator<UnlockStrategy>() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.UnlockStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnlockStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new UnlockStrategy(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnlockStrategy[] newArray(int size) {
            return new UnlockStrategy[size];
        }
    };

    public UnlockStrategy() {
    }

    private final void executeUnlockTask(Activity activity, Runnable onPostUnlock, String... docUuids) {
        if (!this.mDBOperationEnabled) {
            onPostUnlock.run();
            return;
        }
        LockLogger.m7356d(TAG, "executeUnlockNotes# uuid length : " + docUuids.length);
        ArrayList arrayList = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : LockManagerStrategyUtils.getLockedEntitiesWithExcludeTypes(activity, CollectionsKt.listOf(Arrays.copyOf(docUuids, docUuids.length)))) {
            String uuid = notesDocumentEntity.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            arrayList.add(new LockTask.DocumentInfo(uuid, notesDocumentEntity.isSdoc()));
        }
        new LockTask(activity, false, false, onPostUnlock).executeOnExecutor(LockTask.SINGLE_THREAD_EXECUTOR, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$1(UnlockStrategy unlockStrategy) {
        ILockStrategyResultListener iLockStrategyResultListener = unlockStrategy.mListener;
        if (iLockStrategyResultListener != null) {
            iLockStrategyResultListener.onSuccess(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unlockWithGUID(Activity activity, Intent returnData, String... uuidList) {
        LockManagerStrategyUtils.OwnerNotes ownerNotesExcludeNotOwnerNote = LockManagerStrategyUtils.excludeNotOwnerNote(activity, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        if (ownerNotesExcludeNotOwnerNote.hasInvalidNote()) {
            LockLogger.m7357e(TAG, "invalid uuid");
            showToast(activity, 11);
            ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
            if (iLockStrategyResultListener != null) {
                iLockStrategyResultListener.onFail(11);
                return;
            }
            return;
        }
        String[] strArr = (String[]) ownerNotesExcludeNotOwnerNote.getValidNote().toArray(new String[0]);
        if (strArr.length == 0) {
            LockLogger.m7357e(TAG, "not owner");
            if (migrateSDOCPreProcess(activity, (String[]) Arrays.copyOf(uuidList, uuidList.length), new RunnableC8115a(this, 1))) {
                return;
            }
            ToastHandler.show(activity, C8003R.string.lock_note_cannot_open_another_account, 0);
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onFail(1);
                return;
            }
            return;
        }
        String[] strArrExcludeLegacyNote = LockManagerStrategyUtils.excludeLegacyNote(activity, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (strArrExcludeLegacyNote.length == 0) {
            LockLogger.m7357e(TAG, "only have legacy note");
            ToastHandler.show(activity, "only have legacy note", 0);
            ILockStrategyResultListener iLockStrategyResultListener3 = this.mListener;
            if (iLockStrategyResultListener3 != null) {
                iLockStrategyResultListener3.onFail(4);
                return;
            }
            return;
        }
        if (LockManagerStrategyUtils.excludeUnlockedNote(activity, strArrExcludeLegacyNote).length == 0) {
            LockLogger.m7357e(TAG, "unlock# unlocked notes only, no need to verify");
            ILockStrategyResultListener iLockStrategyResultListener4 = this.mListener;
            if (iLockStrategyResultListener4 != null) {
                iLockStrategyResultListener4.onSuccess((String[]) Arrays.copyOf(strArrExcludeLegacyNote, strArrExcludeLegacyNote.length));
                return;
            }
            return;
        }
        if (isAccountChanged(activity) || !LockUtils.isSetPassword(activity)) {
            LockLogger.m7357e(TAG, "account changed or no password");
            createPasswordAndContinue(activity, 1002, 1, strArrExcludeLegacyNote);
            return;
        }
        if (returnData != null) {
            Intrinsics.checkNotNull(returnData.setComponent(new ComponentName(activity, (Class<?>) LockActivity.class)));
        } else {
            returnData = new Intent(activity, (Class<?>) LockActivity.class);
        }
        returnData.putExtra(LockManagerStrategy.EXTRA_KEY_UUID, strArrExcludeLegacyNote);
        returnData.putExtra("key_lock_scenario_type", 5);
        activity.startActivityForResult(returnData, 1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unlockWithGUID$lambda$0(UnlockStrategy unlockStrategy) {
        ILockStrategyResultListener iLockStrategyResultListener = unlockStrategy.mListener;
        if (iLockStrategyResultListener != null) {
            iLockStrategyResultListener.onFail(9);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public void execute(@Nullable final Activity activity, @Nullable final String[] uuidList, @Nullable final Intent returnData) {
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
            new GUIDManager().requestGUID(activity, new GUIDManager.OnRequestGUIDListener() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.UnlockStrategy.execute.1
                @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                public void onFail() {
                    ILockStrategyResultListener iLockStrategyResultListener2 = UnlockStrategy.this.mListener;
                    if (iLockStrategyResultListener2 != null) {
                        iLockStrategyResultListener2.onFail(7);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                public void onSuccess(String guid) {
                    Intrinsics.checkNotNullParameter(guid, "guid");
                    LockLogger.m7356d(UnlockStrategy.TAG, "GUID received");
                    UnlockStrategy unlockStrategy = UnlockStrategy.this;
                    Activity activity2 = activity;
                    Intent intent = returnData;
                    String[] strArr = uuidList;
                    unlockStrategy.unlockWithGUID(activity2, intent, (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            });
            return;
        }
        ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
        if (iLockStrategyResultListener2 != null) {
            iLockStrategyResultListener2.onFail(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        LockLogger.m7356d(TAG, "onActivityResult : request/result -> " + requestCode + "/" + resultCode);
        super.onActivityResult(activity, requestCode, resultCode, data);
        if (requestCode != 1002) {
            if (requestCode != 1011) {
                return false;
            }
            if (resultCode == -1) {
                String[] stringArrayExtra = data != null ? data.getStringArrayExtra(LockManagerStrategy.EXTRA_KEY_UUID) : null;
                if (activity != null && stringArrayExtra != null) {
                    executeUnlockTask(activity, new RunnableC8115a(this, 0), (String[]) Arrays.copyOf(stringArrayExtra, stringArrayExtra.length));
                    return true;
                }
            } else {
                ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
                if (iLockStrategyResultListener != null) {
                    iLockStrategyResultListener.onFail(6);
                    return true;
                }
            }
        } else {
            if (resultCode == -1) {
                execute(activity, data != null ? data.getStringArrayExtra(LockManagerStrategy.EXTRA_KEY_UUID) : null, data);
                return true;
            }
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onFail(5);
            }
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnlockStrategy(@NotNull Parcel in) {
        super(in);
        Intrinsics.checkNotNullParameter(in, "in");
    }
}
