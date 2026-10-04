package com.samsung.scsp.framework.core;

import android.annotation.SuppressLint;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.identity.AccountInfoSupplier;
import com.samsung.scsp.framework.core.identity.DeviceIdSupplier;
import com.samsung.scsp.framework.core.identity.E2eeInfoSupplier;
import com.samsung.scsp.framework.core.identity.PushInfoSupplier;
import com.samsung.scsp.framework.core.network.NetworkFunction;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SContext {
    AccountInfoSupplier accountInfoSupplier;
    private String appId;
    Supplier<String> appVersionSupplier;
    DeviceIdSupplier deviceIdSupplier;
    E2eeInfoSupplier e2eeInfoSupplier;
    NetworkFunction networkFunction;
    PushInfoSupplier pushInfoSupplier;
    ScspConfig scspConfig;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final SContext scontext = new SContext(0);

        private LazyHolder() {
        }
    }

    public /* synthetic */ SContext(int i) {
        this();
    }

    public static SContext getInstance() {
        return LazyHolder.scontext;
    }

    public static void initialize(String str, ScspSuppliers scspSuppliers) {
        SContext sContext = LazyHolder.scontext;
        sContext.appId = str;
        if (scspSuppliers != null) {
            sContext.accountInfoSupplier = scspSuppliers.accountInfoSupplier;
            sContext.pushInfoSupplier = scspSuppliers.pushInfoSupplier;
            sContext.deviceIdSupplier = scspSuppliers.deviceIdSupplier;
            sContext.e2eeInfoSupplier = scspSuppliers.e2eeInfoSupplier;
            sContext.networkFunction = scspSuppliers.networkFunction;
            sContext.scspConfig = scspSuppliers.scspConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0() {
        return ContextFactory.getApplicationContext().getPackageManager().getPackageInfo(ContextFactory.getApplicationContext().getPackageName(), 0).versionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String lambda$new$1() {
        return (String) FaultBarrier.get(new C8416h(15), CoverStickerConstants.Category.NONE.NAME).obj;
    }

    public AccountInfoSupplier getAccountInfoSupplier() {
        return this.accountInfoSupplier;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersionSupplier.get();
    }

    public DeviceIdSupplier getDeviceIdSupplier() {
        return this.deviceIdSupplier;
    }

    public E2eeInfoSupplier getE2eeInfoSupplier() {
        return this.e2eeInfoSupplier;
    }

    public PushInfoSupplier getPushInfoSupplier() {
        return this.pushInfoSupplier;
    }

    public NetworkFunction getUrlStreamHandlerFactorySupplier() {
        return this.networkFunction;
    }

    private SContext() {
        this.appVersionSupplier = new C2747a(8);
    }
}
