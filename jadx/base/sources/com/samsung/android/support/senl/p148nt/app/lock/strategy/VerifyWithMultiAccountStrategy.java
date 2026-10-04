package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyMultiAccountDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0014¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/VerifyWithMultiAccountStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/VerifyStrategy;", "<init>", "()V", "mDocEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "verifyOtherAccount", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "(Landroid/app/Activity;[Ljava/lang/String;)V", "onActivityResult", "", "Landroidx/appcompat/app/AppCompatActivity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "unlock", "context", "Landroid/content/Context;", "verifyAccount", "uuid", "userGUID", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VerifyWithMultiAccountStrategy extends VerifyStrategy {

    @NotNull
    private static final String TAG = LockLogger.createTag("VerifyWithMultiAccountStrategy");

    @Nullable
    private NotesDocumentEntity mDocEntity;

    private final void unlock(Context context) {
        NotesDocumentEntity notesDocumentEntity = this.mDocEntity;
        if (notesDocumentEntity == null) {
            return;
        }
        Intrinsics.checkNotNull(notesDocumentEntity);
        boolean zUnlock = DocumentLockResolver.unlock(context, notesDocumentEntity.getUuid());
        LockLogger.m7358i(TAG, "unlock# unlockSuccess : " + zUnlock);
    }

    private final boolean verifyAccount(AppCompatActivity activity, String uuid, String userGUID) {
        if (!HashUtils.isHashed(userGUID)) {
            userGUID = HashUtils.generateSha256(userGUID);
        }
        LockLogger.m7356d(TAG, AbstractC0541b.m775q("verifyAccount : uuid(", uuid, "), account(", LockLogger.getEncode(String.valueOf(userGUID)), ")"));
        return LockManagerStrategyUtils.isNoteOwner(activity, uuid, userGUID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void verifyOtherAccount$lambda$0(Activity activity, VerifyWithMultiAccountStrategy verifyWithMultiAccountStrategy, boolean z) {
        if (z) {
            AccountHelper.loginSamsungAccountForLock(activity, 1016);
            return;
        }
        ToastHandler.show(activity, C8003R.string.lock_note_cannot_open_another_account, 0);
        ILockStrategyResultListener iLockStrategyResultListener = verifyWithMultiAccountStrategy.mListener;
        if (iLockStrategyResultListener != null) {
            iLockStrategyResultListener.onFail(3);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.VerifyStrategy, com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public boolean onActivityResult(@Nullable AppCompatActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        NotesDocumentEntity notesDocumentEntity;
        super.onActivityResult(activity, requestCode, resultCode, data);
        if (requestCode != 1016) {
            return false;
        }
        LockLogger.m7356d(TAG, AbstractC0622a.m1164j(requestCode, resultCode, "onActivityResult : requestCode(", "), resultCode(", ")"));
        if (resultCode != -1) {
            if (((data != null ? data.getIntExtra(SamsungAccountLoginForLockActivity.ERROR_FLAG_NAME, 0) : 0) & 1) != 1) {
                ToastHandler.show(activity, C8003R.string.lock_note_cannot_open_another_account, 0);
            }
            ILockStrategyResultListener iLockStrategyResultListener = this.mListener;
            if (iLockStrategyResultListener != null) {
                iLockStrategyResultListener.onFail(3);
            }
        } else {
            if (data == null || (notesDocumentEntity = this.mDocEntity) == null || activity == null) {
                return false;
            }
            Intrinsics.checkNotNull(notesDocumentEntity);
            String uuid = notesDocumentEntity.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            if (verifyAccount(activity, uuid, data.getStringExtra(SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID))) {
                unlock(activity);
            } else {
                ToastHandler.show(activity, C8003R.string.lock_note_cannot_open_another_account, 0);
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.VerifyStrategy
    public void verifyOtherAccount(@Nullable Activity activity, @NotNull String[] uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        if (uuidList.length > 1) {
            LockLogger.m7356d(TAG, "verifyOtherAccount# uuidList more than 1");
            return;
        }
        NotesDocumentEntity noteEntityNotOwner = LockManagerStrategyUtils.getNoteEntityNotOwner(activity, uuidList[0]);
        this.mDocEntity = noteEntityNotOwner;
        if (noteEntityNotOwner == null) {
            LockLogger.m7356d(TAG, "verifyOtherAccount# Note owner or Entity is null");
            return;
        }
        VerifyMultiAccountDialogFragment verifyMultiAccountDialogFragment = new VerifyMultiAccountDialogFragment();
        verifyMultiAccountDialogFragment.setOnResultListener(new C0287e(activity, this, 9));
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        verifyMultiAccountDialogFragment.show(((AppCompatActivity) activity).getSupportFragmentManager(), VerifyMultiAccountDialogFragment.TAG);
    }
}
