package org.apache.xmlbeans.impl.common;

import org.apache.poi.javax.xml.stream.Location;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InvalidLexicalValueException extends RuntimeException {
    private Location _location;

    public InvalidLexicalValueException() {
    }

    public Location getLocation() {
        return this._location;
    }

    public void setLocation(Location location) {
        this._location = location;
    }

    public InvalidLexicalValueException(String str) {
        super(str);
    }

    public InvalidLexicalValueException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidLexicalValueException(Throwable th) {
        super(th);
    }

    public InvalidLexicalValueException(String str, Location location) {
        super(str);
        setLocation(location);
    }

    public InvalidLexicalValueException(String str, Throwable th, Location location) {
        super(str, th);
        setLocation(location);
    }

    public InvalidLexicalValueException(Throwable th, Location location) {
        super(th);
        setLocation(location);
    }
}
