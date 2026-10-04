package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.util.HashUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserIdentityImpl extends AbstractIdentityImpl {
    private final Consumer<String> deregisterConsumer;

    public UserIdentityImpl() {
        super(true);
        UserRegistration userRegistration = new UserRegistration(new UserRegisterApiImpl(this.scontextHolder));
        this.deregisterConsumer = new C11664i(userRegistration, 0);
        this.registration = userRegistration;
        this.token = new UserToken(new UserTokenApiImpl(this.scontextHolder));
        this.updater = new UserUpdater(new UserUpdateApiImpl(this.scontextHolder, new C11662g(this, 2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkE2eeType() {
        E2eeInfoSupplier e2eeInfoSupplier = SContext.getInstance().getE2eeInfoSupplier();
        if (e2eeInfoSupplier == null || StringUtil.isEmpty(e2eeInfoSupplier.getSakUid())) {
            return;
        }
        if (StringUtil.equals(ScspCorePreferences.get().e2eeType.get(), (String) FaultBarrier.get(new C11665j(e2eeInfoSupplier, 0), "non").obj)) {
            return;
        }
        this.logger.m12932e("Re-register is required due to e2eeType changed");
        ScspCorePreferences.get().clearUser();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkUserId(AccountInfoSupplier accountInfoSupplier) {
        if (accountInfoSupplier != null) {
            String str = ScspCorePreferences.get().hashedUid.get();
            String str2 = (String) FaultBarrier.get(new C11656a(accountInfoSupplier, 4), "", true).obj;
            if (str.equals(str2)) {
                return;
            }
            this.logger.m12932e("Current uid is not same with stored uid. " + str2);
            ScspCorePreferences.get().clearUser();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$checkE2eeType$4(E2eeInfoSupplier e2eeInfoSupplier) {
        return E2eeInfoSupplier.TYPES[e2eeInfoSupplier.getType()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$checkUserId$3(AccountInfoSupplier accountInfoSupplier) {
        return HashUtil.getStringSHA256(accountInfoSupplier.getUserId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1(UserRegistration userRegistration, String str) {
        FaultBarrier.run(new C11658c(userRegistration, str, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signOut$2(String str) {
        this.deregisterConsumer.accept(str);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractIdentityImpl, com.samsung.scsp.framework.core.identity.Identity
    public boolean initialize() {
        checkUserId(SContext.getInstance().getAccountInfoSupplier());
        checkE2eeType();
        return super.initialize();
    }

    public void onUnauthenticatedForSA() {
        SContext.getInstance().getAccountInfoSupplier().onUnauthorized();
    }

    public void signOut() {
        final String str = ScspCorePreferences.get().userToken.get();
        if (!StringUtil.isEmpty(str)) {
            new Thread(new Runnable() { // from class: com.samsung.scsp.framework.core.identity.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8215a.lambda$signOut$2(str);
                }
            }).start();
        }
        ScspCorePreferences.get().clearUser();
    }
}
