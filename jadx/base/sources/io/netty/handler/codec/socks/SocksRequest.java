package io.netty.handler.codec.socks;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SocksRequest extends SocksMessage {
    private final SocksRequestType requestType;

    public SocksRequest(SocksRequestType socksRequestType) {
        super(SocksMessageType.REQUEST);
        this.requestType = (SocksRequestType) ObjectUtil.checkNotNull(socksRequestType, TextConst.KEY_PARAM_REQUEST_TYPE);
    }

    public SocksRequestType requestType() {
        return this.requestType;
    }
}
