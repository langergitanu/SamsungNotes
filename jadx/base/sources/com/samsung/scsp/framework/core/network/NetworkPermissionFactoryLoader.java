package com.samsung.scsp.framework.core.network;

import android.content.Context;
import android.os.Bundle;
import com.samsung.scsp.error.FaultBarrier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NetworkPermissionFactoryLoader {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NetworkPermissionFactoryHolder {
        private Supplier<Predicate<String>> instance;

        public /* synthetic */ NetworkPermissionFactoryHolder(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(String str) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Predicate lambda$new$1() {
            return new C11682c(0);
        }

        private NetworkPermissionFactoryHolder() {
            this.instance = new C11683d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$0(NetworkPermissionFactoryHolder networkPermissionFactoryHolder, String str) {
        networkPermissionFactoryHolder.instance = (Supplier) Class.forName(str).newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$1(Bundle bundle, NetworkPermissionFactoryHolder networkPermissionFactoryHolder, String str) {
        Object obj = bundle.get(str);
        if ((obj instanceof String) && "NetworkPermissionFactory".equals(obj)) {
            FaultBarrier.run(new C11669a(0, networkPermissionFactoryHolder, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$2(Context context, final NetworkPermissionFactoryHolder networkPermissionFactoryHolder) {
        final Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        bundle.keySet().forEach(new Consumer() { // from class: com.samsung.scsp.framework.core.network.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                NetworkPermissionFactoryLoader.lambda$load$1(bundle, networkPermissionFactoryHolder, (String) obj);
            }
        });
    }

    public static Supplier<Predicate<String>> load(Context context) {
        NetworkPermissionFactoryHolder networkPermissionFactoryHolder = new NetworkPermissionFactoryHolder(0);
        FaultBarrier.run(new C11669a(context, networkPermissionFactoryHolder), true);
        return networkPermissionFactoryHolder.instance;
    }
}
