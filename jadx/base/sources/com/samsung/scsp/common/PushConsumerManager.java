package com.samsung.scsp.common;

import android.accounts.Account;
import android.content.ContentResolver;
import android.os.Bundle;
import androidx.transition.C3970a;
import com.opencsv.bean.C6631n;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PushConsumerManager {
    private final Map<String, Consumer<PushVo>> PUSH_CONSUMER_MAP = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Holder {
        private static final PushConsumerManager INSTANCE = new PushConsumerManager();

        private Holder() {
        }
    }

    public static PushConsumerManager getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$add$0(Supplier supplier, String[] strArr, Bundle bundle) {
        Account account = (Account) supplier.get();
        if (account != null) {
            for (String str : strArr) {
                Logger.get("PushConsumerManager").m12934i("requestSync: " + str);
                ContentResolver.requestSync(account, str, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$add$1(Supplier supplier, String[] strArr, Bundle bundle, PushVo pushVo) {
        FaultBarrier.run(new C3970a(supplier, 5, strArr, bundle));
    }

    public void add(String str, Consumer<PushVo> consumer) {
        this.PUSH_CONSUMER_MAP.put(str, consumer);
    }

    public Consumer<PushVo> get(String str) {
        return this.PUSH_CONSUMER_MAP.get(str);
    }

    public void add(String str, String[] strArr, Supplier<Account> supplier, Bundle bundle) {
        this.PUSH_CONSUMER_MAP.put(str, new C6631n(supplier, 6, strArr, bundle));
    }
}
