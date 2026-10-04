package com.samsung.scsp.pam.kps.lite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.gson.Gson;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.error.Result;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.AbstractApiControl;
import com.samsung.scsp.framework.core.api.ApiClass;
import com.samsung.scsp.framework.core.api.RequestClasses;
import com.samsung.scsp.framework.core.api.Requests;
import com.samsung.scsp.framework.core.decorator.AbstractDecorator;
import com.samsung.scsp.framework.core.decorator.SdkConfig;
import com.samsung.scsp.framework.core.decorator.SdkFeature;
import com.samsung.scsp.framework.core.util.StringUtil;
import com.samsung.scsp.pam.kps.lite.KpsApiContract;
import java.util.function.BiFunction;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@SdkConfig(name = BuildConfig.LIBRARY_PACKAGE_NAME, version = "1.2.0000")
public class ScspKpsLite extends AbstractDecorator implements BiFunction<String, Bundle, Bundle> {
    private static final String ACTION_NAME = "actionName";
    private static final String PACKAGE_NAME = "packageName";
    private final KeyManagementLite keyManagement;
    private final Logger logger;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiClass(KpsApiImpl.class)
    @RequestClasses({JoinRequestImpl.class, LeaveImpl.class})
    @Requests({KpsLiteApiSpec.GET_GROUP_STATE, KpsLiteApiSpec.GET_POLICY})
    public static class KpsApiControlImpl extends AbstractApiControl {
        private KpsApiControlImpl() {
        }
    }

    public ScspKpsLite(KeyManagementLite keyManagementLite) {
        super(KpsApiControlImpl.class, new SdkFeature[0]);
        this.logger = Logger.get("ScspKpsLite");
        this.keyManagement = keyManagementLite;
    }

    private KpsPolicies getCachedPolicies(String str) throws ScspException {
        try {
            return (KpsPolicies) new Gson().fromJson(str, KpsPolicies.class);
        } catch (Exception e) {
            this.logger.m12932e(e.getMessage());
            KpsLitePreferences.get().clear();
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeySync$2(String str, String str2, Holder holder) {
        try {
            execute("JOIN", null, null, new Pair(KpsApiContract.Parameter.E2EE_GROUP_ID, str), new Pair("serviceId", str2));
        } catch (ScspException e) {
            holder.hold(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestKeySync$3(Thread thread, Holder holder) throws InterruptedException {
        thread.join(60000L);
        if (thread.isAlive()) {
            holder.hold(new ScspException(KpsApiContract.CODE.GET_SERVICE_KEY_TIMEOUT, "Time out, 60000"));
            thread.interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendResult$4(Bundle bundle, FaultBarrier.ThrowableRunnable throwableRunnable) {
        String string = bundle.getString(ACTION_NAME);
        String string2 = bundle.getString("packageName", "");
        Intent intent = new Intent();
        intent.setAction(string);
        intent.setPackage(string2);
        intent.putExtras(FaultBarrier.run(throwableRunnable).bundle());
        ContextFactory.getApplicationContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: leave, reason: merged with bridge method [inline-methods] */
    public void lambda$apply$1(Bundle bundle) {
        this.logger.m12934i("leave");
        String string = bundle.getString(KpsApiContract.Parameter.E2EE_GROUP_ID);
        execute(KpsApiContract.Control.LEAVE, null, null, new Pair(KpsApiContract.Parameter.E2EE_GROUP_ID, string), new Pair(KpsApiContract.Parameter.RECOVERY_CODE, bundle.getString(KpsApiContract.Parameter.RECOVERY_CODE)));
        this.keyManagement.onLeaveCompleted(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestKeySync, reason: merged with bridge method [inline-methods] */
    public void lambda$apply$0(Bundle bundle) throws ScspException {
        this.logger.m12934i("requestKeySync");
        String string = bundle.getString(KpsApiContract.Parameter.E2EE_GROUP_ID);
        String string2 = bundle.getString("serviceId");
        Holder holder = new Holder();
        Thread thread = new Thread(new RunnableC0218a((Object) this, string, (Object) string2, (Object) holder, 21));
        thread.start();
        FaultBarrier.run(new C11690a(thread, holder, 1));
        if (holder.get() != null) {
            throw ((ScspException) holder.get());
        }
        this.keyManagement.onJoinCompleted(string);
    }

    private Bundle sendResult(final Bundle bundle, final FaultBarrier.ThrowableRunnable throwableRunnable) {
        new Thread(new Runnable() { // from class: com.samsung.scsp.pam.kps.lite.g
            @Override // java.lang.Runnable
            public final void run() {
                ScspKpsLite.lambda$sendResult$4(bundle, throwableRunnable);
            }
        }).start();
        return new Result().bundle();
    }

    @Override // com.samsung.scsp.framework.core.decorator.AbstractDecorator
    public Pair<String, Object>[] getCommonParameter() {
        return new Pair[]{new Pair(KpsApiContract.Parameter.KEY_MANAGEMENT, this.keyManagement)};
    }

    public KpsState getGroupState() {
        return (KpsState) execute(KpsLiteApiSpec.GET_GROUP_STATE, null, null, new Pair[0]);
    }

    public KpsPolicies getPolicy() {
        String str = KpsLitePreferences.get().eTag.get();
        String str2 = KpsLitePreferences.get().policies.get();
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            this.logger.m12934i("getPolicy - without eTag");
            return (KpsPolicies) execute(KpsLiteApiSpec.GET_POLICY, null, null, new Pair[0]);
        }
        if (KpsLitePreferences.get().expiredTime.get().longValue() > System.currentTimeMillis()) {
            this.logger.m12934i("getPolicy - using cachedPolicies");
            return getCachedPolicies(str2);
        }
        this.logger.m12934i("getPolicy - with eTag");
        return (KpsPolicies) execute(KpsLiteApiSpec.GET_POLICY, null, str, new Pair[0]);
    }

    @Override // java.util.function.BiFunction
    public Bundle apply(String str, final Bundle bundle) {
        str.getClass();
        if (str.equals("leave")) {
            final int i = 1;
            return sendResult(bundle, new FaultBarrier.ThrowableRunnable(this) { // from class: com.samsung.scsp.pam.kps.lite.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ ScspKpsLite f8257b;

                {
                    this.f8257b = this;
                }

                @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                public final void run() throws ScspException {
                    switch (i) {
                        case 0:
                            this.f8257b.lambda$apply$0(bundle);
                            break;
                        default:
                            this.f8257b.lambda$apply$1(bundle);
                            break;
                    }
                }
            });
        }
        if (!str.equals("requestKeySync")) {
            return new Result(ScspException.Code.BAD_IMPLEMENTATION, "not defined command. ".concat(str)).bundle();
        }
        final int i2 = 0;
        return sendResult(bundle, new FaultBarrier.ThrowableRunnable(this) { // from class: com.samsung.scsp.pam.kps.lite.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ ScspKpsLite f8257b;

            {
                this.f8257b = this;
            }

            @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
            public final void run() throws ScspException {
                switch (i2) {
                    case 0:
                        this.f8257b.lambda$apply$0(bundle);
                        break;
                    default:
                        this.f8257b.lambda$apply$1(bundle);
                        break;
                }
            }
        });
    }
}
