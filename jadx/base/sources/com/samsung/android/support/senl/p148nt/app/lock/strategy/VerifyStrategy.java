package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.C3970a;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.GUIDManager;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategyUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.convert.VerifyConvertPasswordDialog;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J/\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J'\u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0014¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/VerifyStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "verifyWithGUID", "verifyOtherAccount", "(Landroid/app/Activity;[Ljava/lang/String;)V", "onActivityResult", "", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "", "resultCode", "data", "showLegacyVerifyDialog", "uuid", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVerifyStrategy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyStrategy.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/VerifyStrategy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,215:1\n1#2:216\n37#3:217\n36#3,3:218\n*S KotlinDebug\n*F\n+ 1 VerifyStrategy.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/VerifyStrategy\n*L\n92#1:217\n92#1:218,3\n*E\n"})
public class VerifyStrategy extends LockManagerStrategy {

    @NotNull
    private static final String EXTRA_KEY_LEGACY_LOCK_AFTER_CONVERT = "extra_key_legacy_lock_after_convert";

    @NotNull
    private static final String EXTRA_KEY_LEGACY_PASSWORD = "extra_key_legacy_password";

    @NotNull
    private static final String TAG = LockLogger.createTag("VerifyStrategy");

    @JvmField
    @NotNull
    public static final Parcelable.Creator<VerifyStrategy> CREATOR = new Parcelable.Creator<VerifyStrategy>() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.VerifyStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifyStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new VerifyStrategy(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifyStrategy[] newArray(int size) {
            return new VerifyStrategy[size];
        }
    };

    public VerifyStrategy() {
    }

    private final void showLegacyVerifyDialog(Activity activity, String uuid, Intent returnData) {
        NotesDocumentEntity noteEntity = LockManagerStrategyUtils.getNoteEntity(activity, uuid);
        String filePath = noteEntity.getFilePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        int isLock = noteEntity.getIsLock();
        VerifyConvertPasswordDialog verifyConvertPasswordDialog = new VerifyConvertPasswordDialog(true);
        Bundle bundle = new Bundle();
        bundle.putString("doc_path", filePath);
        bundle.putInt(ComposerConstants.ARG_LOCK_TYPE, isLock);
        verifyConvertPasswordDialog.setArguments(bundle);
        verifyConvertPasswordDialog.setOnResultListener(new C3970a(this, 2, returnData, activity));
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        verifyConvertPasswordDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), VerifyConvertPasswordDialog.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLegacyVerifyDialog$lambda$3(VerifyStrategy verifyStrategy, Intent intent, Activity activity, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            ILockStrategyResultListener iLockStrategyResultListener = verifyStrategy.mListener;
            if (iLockStrategyResultListener != null) {
                iLockStrategyResultListener.onFail(6);
                return;
            }
            return;
        }
        if (intent != null) {
            intent.putExtra("extra_key_legacy_password", str2);
        }
        boolean zM14285a = ((C13540g) C13541h.m14287e().f9588a).m14285a();
        boolean zIsEmpty = TextUtils.isEmpty(C13541h.m14287e().m14294h());
        boolean zIsAccountChanged = verifyStrategy.isAccountChanged(activity);
        boolean zIsSetPassword = LockUtils.isSetPassword(activity);
        if (intent != null) {
            intent.putExtra("extra_key_legacy_lock_after_convert", zM14285a && zIsSetPassword && !zIsEmpty && !zIsAccountChanged);
        }
        ILockStrategyResultListener iLockStrategyResultListener2 = verifyStrategy.mListener;
        if (iLockStrategyResultListener2 != null) {
            iLockStrategyResultListener2.onSuccess(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyWithGUID(Activity activity, String[] uuidList, Intent returnData) {
        int iCountLegacyNotes = LockManagerStrategyUtils.countLegacyNotes(activity, CollectionsKt.listOf(Arrays.copyOf(uuidList, uuidList.length)));
        if (uuidList.length == 1 && iCountLegacyNotes == uuidList.length) {
            String str = uuidList[0];
            if (str != null) {
                showLegacyVerifyDialog(activity, str, returnData);
                return;
            }
            return;
        }
        String[] strArrExcludeLegacyNote = LockManagerStrategyUtils.excludeLegacyNote(activity, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        if (strArrExcludeLegacyNote.length == 0) {
            LockLogger.m7357e(TAG, "only have legacy note");
            ToastHandler.show(activity, "only have legacy note", 0);
            ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
            if (iLockStrategyResultListener != null) {
                iLockStrategyResultListener.onFail(4);
                return;
            }
            return;
        }
        LockManagerStrategyUtils.OwnerNotes ownerNotesExcludeNotOwnerNote = LockManagerStrategyUtils.excludeNotOwnerNote(activity, (String[]) Arrays.copyOf(uuidList, uuidList.length));
        if (ownerNotesExcludeNotOwnerNote.hasInvalidNote()) {
            LockLogger.m7357e(TAG, "invalid uuid");
            showToast(activity, 11);
            ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
            if (iLockStrategyResultListener2 != null) {
                iLockStrategyResultListener2.onFail(11);
                return;
            }
            return;
        }
        String[] strArr = (String[]) ownerNotesExcludeNotOwnerNote.getValidNote().toArray(new String[0]);
        if (strArr.length == 0) {
            LockLogger.m7357e(TAG, "not owner");
            if (migrateSDOCPreProcess(activity, strArrExcludeLegacyNote, new RunnableC7599e(this, 16))) {
                return;
            }
            verifyOtherAccount(activity, uuidList);
            return;
        }
        if (LockManagerStrategyUtils.excludeUnlockedNote(activity, strArr).length == 0) {
            LockLogger.m7357e(TAG, "verify# unlocked notes only, no need to verify");
            ILockStrategyResultListener iLockStrategyResultListener3 = this.mListener;
            if (iLockStrategyResultListener3 != null) {
                iLockStrategyResultListener3.onSuccess((String[]) Arrays.copyOf(strArr, strArr.length));
                return;
            }
            return;
        }
        if (isAccountChanged(activity) || !LockUtils.isSetPassword(activity)) {
            LockLogger.m7357e(TAG, "verify# account changed or no password");
            createPasswordAndContinue(activity, 1003, 1, strArr);
            return;
        }
        if (returnData != null) {
            Intrinsics.checkNotNull(returnData.setComponent(new ComponentName(activity, (Class<?>) LockActivity.class)));
        } else {
            returnData = new Intent(activity, (Class<?>) LockActivity.class);
        }
        returnData.putExtra(LockManagerStrategy.EXTRA_KEY_UUID, strArr);
        returnData.putExtra("key_lock_scenario_type", 5);
        activity.startActivityForResult(returnData, 1012);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void verifyWithGUID$lambda$1(VerifyStrategy verifyStrategy) {
        ILockStrategyResultListener iLockStrategyResultListener = verifyStrategy.mListener;
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
            new GUIDManager().requestGUID(activity, new GUIDManager.OnRequestGUIDListener() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.VerifyStrategy.execute.1
                @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                public void onFail() {
                    ILockStrategyResultListener iLockStrategyResultListener2 = VerifyStrategy.this.mListener;
                    if (iLockStrategyResultListener2 != null) {
                        iLockStrategyResultListener2.onFail(7);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.account.GUIDManager.OnRequestGUIDListener
                public void onSuccess(String guid) {
                    Intrinsics.checkNotNullParameter(guid, "guid");
                    LockLogger.m7356d(VerifyStrategy.TAG, "GUID received");
                    VerifyStrategy verifyStrategy = VerifyStrategy.this;
                    Activity activity2 = activity;
                    String[] strArr = uuidList;
                    verifyStrategy.verifyWithGUID(activity2, (String[]) Arrays.copyOf(strArr, strArr.length), returnData);
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
        ILockStrategyResultListener iLockStrategyResultListener;
        String str = TAG;
        ILockStrategyResultListener iLockStrategyResultListener2 = this.mListener;
        Integer numValueOf = iLockStrategyResultListener2 != null ? Integer.valueOf(iLockStrategyResultListener2.hashCode()) : null;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(requestCode, resultCode, "onActivityResult : request/result/listener -> ", "/", "/");
        sbM1173s.append(numValueOf);
        LockLogger.m7356d(str, sbM1173s.toString());
        super.onActivityResult(activity, requestCode, resultCode, data);
        if (requestCode == 1003) {
            if (resultCode == -1) {
                execute(activity, data != null ? data.getStringArrayExtra(LockManagerStrategy.EXTRA_KEY_UUID) : null, data);
            } else {
                ILockStrategyResultListener iLockStrategyResultListener3 = this.mListener;
                if (iLockStrategyResultListener3 != null) {
                    iLockStrategyResultListener3.onFail(5);
                }
            }
            return true;
        }
        if (requestCode != 1012) {
            return false;
        }
        if (resultCode == -1) {
            String[] stringArrayExtra = data != null ? data.getStringArrayExtra(LockManagerStrategy.EXTRA_KEY_UUID) : null;
            if (stringArrayExtra != null && (iLockStrategyResultListener = this.mListener) != null) {
                iLockStrategyResultListener.onSuccess((String[]) Arrays.copyOf(stringArrayExtra, stringArrayExtra.length));
            }
        } else {
            ILockStrategyResultListener iLockStrategyResultListener4 = this.mListener;
            if (iLockStrategyResultListener4 != null) {
                iLockStrategyResultListener4.onFail(5);
            }
        }
        return true;
    }

    public void verifyOtherAccount(@Nullable Activity activity, @NotNull String[] uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        ToastHandler.show(activity, C8003R.string.lock_note_cannot_open_another_account, 0);
        ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
        if (iLockStrategyResultListener != null) {
            iLockStrategyResultListener.onFail(3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyStrategy(@NotNull Parcel in) {
        super(in);
        Intrinsics.checkNotNullParameter(in, "in");
    }
}
