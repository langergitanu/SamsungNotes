package com.samsung.scsp.pam.kps.lite;

import com.samsung.scsp.common.PushHandler;
import com.samsung.scsp.common.PushVo;
import com.samsung.scsp.pam.kps.lite.KpsPushHandlerFactory;

/* JADX INFO: renamed from: com.samsung.scsp.pam.kps.lite.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11694e implements PushHandler {
    @Override // com.samsung.scsp.common.PushHandler
    public final boolean handle(Object obj, PushVo pushVo) {
        return KpsPushHandlerFactory.LazyHolder.lambda$static$0((ScspKpsLite) obj, pushVo);
    }
}
