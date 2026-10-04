package io.netty.handler.codec.http2;

import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2SettingsFrame implements Http2SettingsFrame {
    private final Http2Settings settings;

    public DefaultHttp2SettingsFrame(Http2Settings http2Settings) {
        this.settings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, SettingsConstants.EXTRA_FROM_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Http2SettingsFrame) {
            return this.settings.equals(((Http2SettingsFrame) obj).settings());
        }
        return false;
    }

    public int hashCode() {
        return this.settings.hashCode();
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsFrame, io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "SETTINGS";
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsFrame
    public Http2Settings settings() {
        return this.settings;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(settings=" + this.settings + PropertyUtils.MAPPED_DELIM2;
    }
}
