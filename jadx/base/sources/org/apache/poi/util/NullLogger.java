package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class NullLogger extends POILogger {
    @Override // org.apache.poi.util.POILogger
    public void _log(int i, Object obj) {
    }

    @Override // org.apache.poi.util.POILogger
    public boolean check(int i) {
        return false;
    }

    @Override // org.apache.poi.util.POILogger
    public void _log(int i, Object obj, Throwable th) {
    }

    @Override // org.apache.poi.util.POILogger
    public void initialize(String str) {
    }

    @Override // org.apache.poi.util.POILogger
    public void log(int i, Object... objArr) {
    }
}
