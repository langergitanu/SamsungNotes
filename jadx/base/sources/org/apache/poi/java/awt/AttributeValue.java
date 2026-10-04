package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
abstract class AttributeValue {
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.AttributeValue");
    private final String[] names;
    private final int value;

    public AttributeValue(int i, String[] strArr) {
        PlatformLogger platformLogger = log;
        if (platformLogger.isLoggable(300)) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "value = ", ", names = ");
            sbM778t.append(strArr);
            platformLogger.finest(sbM778t.toString());
        }
        if (platformLogger.isLoggable(400) && (i < 0 || strArr == null || i >= strArr.length)) {
            platformLogger.finer("Assertion failed");
        }
        this.value = i;
        this.names = strArr;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return this.names[this.value];
    }
}
