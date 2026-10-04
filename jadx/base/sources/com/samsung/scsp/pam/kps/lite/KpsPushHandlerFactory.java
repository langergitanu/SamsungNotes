package com.samsung.scsp.pam.kps.lite;

import com.samsung.scsp.common.PushHandler;
import com.samsung.scsp.common.PushVo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KpsPushHandlerFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final Map<String, PushHandler<ScspKpsLite>> MAP = new HashMap<String, PushHandler<ScspKpsLite>>() { // from class: com.samsung.scsp.pam.kps.lite.KpsPushHandlerFactory.LazyHolder.1
            {
                put("kps.e2eeWrappedServiceKeyReady", KpsServiceKeyReadyPushHandlerFactory.get());
            }
        };
        private static final PushHandler<ScspKpsLite> INSTANCE = new C11694e();

        private LazyHolder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$static$0(ScspKpsLite scspKpsLite, PushVo pushVo) {
            PushHandler<ScspKpsLite> pushHandler = MAP.get(pushVo.category);
            if (pushHandler != null) {
                return pushHandler.handle(scspKpsLite, pushVo);
            }
            return false;
        }
    }

    public static PushHandler<ScspKpsLite> get() {
        return LazyHolder.INSTANCE;
    }
}
