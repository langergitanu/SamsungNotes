package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyFactory;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LOCK", "", "UNLOCK", "VERIFY", "VERIFY_FOR_CONVERT", "VERIFY_FOR_DELETE", "VERIFY_WITH_MULTI_ACCOUNT", CredentialProviderBaseController.CREATE_PASSWORD_TAG, "getOperator", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "type", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockManagerStrategyFactory {
    public static final int CREATE_PASSWORD = 7;
    public static final int LOCK = 1;
    public static final int UNLOCK = 2;
    public static final int VERIFY = 3;
    public static final int VERIFY_FOR_CONVERT = 4;
    public static final int VERIFY_FOR_DELETE = 5;
    public static final int VERIFY_WITH_MULTI_ACCOUNT = 6;

    @NotNull
    public static final LockManagerStrategyFactory INSTANCE = new LockManagerStrategyFactory();

    @NotNull
    private static final String TAG = LockLogger.createTag("LockManagerStrategyFactory");

    private LockManagerStrategyFactory() {
    }

    @NotNull
    public final LockManagerStrategy getOperator(int type) {
        LockLogger.m7356d(TAG, "getOperator : " + type);
        switch (type) {
            case 1:
                return new LockStrategy();
            case 2:
                return new UnlockStrategy();
            case 3:
                return new VerifyStrategy();
            case 4:
                return new VerifyForConvertStrategy();
            case 5:
                return new VerifyForDeleteStrategy();
            case 6:
                return new VerifyWithMultiAccountStrategy();
            case 7:
                return new CreatePasswordStrategy();
            default:
                return new EmptyStrategy();
        }
    }
}
