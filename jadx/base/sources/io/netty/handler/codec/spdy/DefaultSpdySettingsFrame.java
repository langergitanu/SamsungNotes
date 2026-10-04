package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSpdySettingsFrame implements SpdySettingsFrame {
    private boolean clear;
    private final Map<Integer, Setting> settingsMap = new TreeMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Setting {
        private boolean persist;
        private boolean persisted;
        private int value;

        public Setting(int i, boolean z, boolean z2) {
            this.value = i;
            this.persist = z;
            this.persisted = z2;
        }

        public int getValue() {
            return this.value;
        }

        public boolean isPersist() {
            return this.persist;
        }

        public boolean isPersisted() {
            return this.persisted;
        }

        public void setPersist(boolean z) {
            this.persist = z;
        }

        public void setPersisted(boolean z) {
            this.persisted = z;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    private void appendSettings(StringBuilder sb) {
        for (Map.Entry<Integer, Setting> entry : getSettings()) {
            Setting value = entry.getValue();
            sb.append("--> ");
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(value.getValue());
            sb.append(" (persist value: ");
            sb.append(value.isPersist());
            sb.append("; persisted: ");
            sb.append(value.isPersisted());
            sb.append(PropertyUtils.MAPPED_DELIM2);
            sb.append(StringUtil.NEWLINE);
        }
    }

    private Set<Map.Entry<Integer, Setting>> getSettings() {
        return this.settingsMap.entrySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean clearPreviouslyPersistedSettings() {
        return this.clear;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public int getValue(int i) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        if (setting != null) {
            return setting.getValue();
        }
        return -1;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public Set<Integer> ids() {
        return this.settingsMap.keySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersistValue(int i) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        return setting != null && setting.isPersist();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersisted(int i) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        return setting != null && setting.isPersisted();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isSet(int i) {
        return this.settingsMap.containsKey(Integer.valueOf(i));
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame removeValue(int i) {
        this.settingsMap.remove(Integer.valueOf(i));
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z) {
        this.clear = z;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersistValue(int i, boolean z) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        if (setting != null) {
            setting.setPersist(z);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersisted(int i, boolean z) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        if (setting != null) {
            setting.setPersisted(z);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i, int i2) {
        return setValue(i, i2, false, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        appendSettings(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i, int i2, boolean z, boolean z2) {
        if (i < 0 || i > 16777215) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Setting ID is not valid: "));
        }
        Integer numValueOf = Integer.valueOf(i);
        Setting setting = this.settingsMap.get(numValueOf);
        if (setting == null) {
            this.settingsMap.put(numValueOf, new Setting(i2, z, z2));
            return this;
        }
        setting.setValue(i2);
        setting.setPersist(z);
        setting.setPersisted(z2);
        return this;
    }
}
