package com.adobe.internal.xmp.options;

import androidx.compose.runtime.AbstractC1974b;
import com.adobe.internal.xmp.XMPException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Options {
    private int options = 0;
    private Map optionNames = null;

    public Options() {
    }

    private void assertOptionsValid(int i) throws XMPException {
        int i2 = (~getValidOptions()) & i;
        if (i2 == 0) {
            assertConsistency(i);
            return;
        }
        throw new XMPException("The option bit(s) 0x" + Integer.toHexString(i2) + " are invalid!", 103);
    }

    private String getOptionName(int i) {
        Map mapProcureOptionNames = procureOptionNames();
        Integer num = new Integer(i);
        String str = (String) mapProcureOptionNames.get(num);
        if (str != null) {
            return str;
        }
        String strDefineOptionName = defineOptionName(i);
        if (strDefineOptionName == null) {
            return "<option name not defined>";
        }
        mapProcureOptionNames.put(num, strDefineOptionName);
        return strDefineOptionName;
    }

    private Map procureOptionNames() {
        if (this.optionNames == null) {
            this.optionNames = new HashMap();
        }
        return this.optionNames;
    }

    public void clear() {
        this.options = 0;
    }

    public boolean containsAllOptions(int i) {
        return (getOptions() & i) == i;
    }

    public boolean containsOneOf(int i) {
        return (i & getOptions()) != 0;
    }

    public abstract String defineOptionName(int i);

    public boolean equals(Object obj) {
        return getOptions() == ((Options) obj).getOptions();
    }

    public boolean getOption(int i) {
        return (i & this.options) != 0;
    }

    public int getOptions() {
        return this.options;
    }

    public String getOptionsString() {
        if (this.options == 0) {
            return "<none>";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.options;
        while (i != 0) {
            int i2 = (i - 1) & i;
            stringBuffer.append(getOptionName(i ^ i2));
            if (i2 != 0) {
                stringBuffer.append(" | ");
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    public abstract int getValidOptions();

    public int hashCode() {
        return getOptions();
    }

    public boolean isExactly(int i) {
        return getOptions() == i;
    }

    public void setOption(int i, boolean z) {
        int i2;
        if (z) {
            i2 = i | this.options;
        } else {
            i2 = (~i) & this.options;
        }
        this.options = i2;
    }

    public void setOptions(int i) throws XMPException {
        assertOptionsValid(i);
        this.options = i;
    }

    public String toString() {
        return AbstractC1974b.m1316i(this.options, new StringBuilder("0x"));
    }

    public Options(int i) throws XMPException {
        assertOptionsValid(i);
        setOptions(i);
    }

    public void assertConsistency(int i) {
    }
}
