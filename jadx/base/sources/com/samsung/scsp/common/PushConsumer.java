package com.samsung.scsp.common;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.identity.PushInfoList;
import com.samsung.scsp.framework.core.identity.ScspCorePreferences;
import com.samsung.scsp.framework.core.util.HashUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.function.Consumer;
import java.util.function.Supplier;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PushConsumer implements Consumer<PushVo> {
    private static final String CID_LIST = "cidList";
    private static final String SYNC = "sync";
    private final Supplier<String> userIdSupplier;
    private final Logger logger = Logger.get("PushConsumer");
    private final PushConsumerManager pushClientManager = PushConsumerManager.getInstance();
    private final Consumer<PushVo> consumer = new C4191n(this, 20);

    public PushConsumer(Supplier<String> supplier) {
        this.userIdSupplier = supplier == null ? new C11623b(2) : supplier;
    }

    private void executeSyncPushExecutor(PushVo pushVo) {
        FaultBarrier.run(new C11626e(this, pushVo, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isValidDeviceSignature(String str) {
        if (StringUtil.isEmpty(str)) {
            this.logger.m12934i("isValidDeviceSignature: empty, true");
            return true;
        }
        boolean zEquals = str.equals((String) FaultBarrier.get(new C11632k(ScspCorePreferences.get().cdid.get(), (String) FaultBarrier.get(new C11631j(1), null).obj, 1), null).obj);
        this.logger.m12934i("isValidDeviceSignature: " + zEquals);
        return zEquals;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isValidSignature(String str) {
        if (StringUtil.isEmpty(str)) {
            this.logger.m12934i("isValidSignature: empty, true");
            return true;
        }
        boolean zEquals = str.equals((String) FaultBarrier.get(new C11632k(this.userIdSupplier.get(), (String) FaultBarrier.get(new C11631j(0), null).obj, 0), null).obj);
        this.logger.m12934i("isValidSignature: " + zEquals);
        return zEquals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSyncPushExecutor$6(PushVo pushVo) {
        for (String str : pushVo.data.get(CID_LIST).getAsString().split(",")) {
            Consumer<PushVo> consumer = this.pushClientManager.get(str);
            if (consumer != null) {
                consumer.accept(pushVo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isValidDeviceSignature$4() {
        return new PushInfoList(ScspCorePreferences.get().pushInfos.get()).getPushInfoList().get(0).getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isValidDeviceSignature$5(String str, String str2) {
        return HashUtil.getStringSHA256(str + ":" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isValidSignature$2() {
        return new PushInfoList(ScspCorePreferences.get().pushInfos.get()).getPushInfoList().get(0).getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isValidSignature$3(String str, String str2) {
        return HashUtil.getStringSHA256(str + ":" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(PushVo pushVo) {
        this.logger.m12934i(pushVo.category);
        if (isValidSignature(pushVo.signature) && isValidDeviceSignature(pushVo.deviceSignature)) {
            if ("sync".equals(pushVo.category)) {
                executeSyncPushExecutor(pushVo);
                return;
            }
            Consumer<PushVo> consumer = this.pushClientManager.get(pushVo.category);
            if (consumer != null) {
                consumer.accept(pushVo);
            }
        }
    }

    @Override // java.util.function.Consumer
    public void accept(PushVo pushVo) {
        this.consumer.accept(pushVo);
    }
}
