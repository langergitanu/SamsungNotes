package org.apache.xmlbeans.impl.regex;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParseException extends RuntimeException {
    int location;

    public ParseException(String str, int i) {
        super(str);
        this.location = i;
    }

    public int getLocation() {
        return this.location;
    }
}
