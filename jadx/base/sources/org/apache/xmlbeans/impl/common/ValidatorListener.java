package org.apache.xmlbeans.impl.common;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ValidatorListener {
    public static final int ATTR = 4;
    public static final int BEGIN = 1;
    public static final int END = 2;
    public static final int ENDATTRS = 5;
    public static final int TEXT = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Event extends PrefixResolver {
        public static final int COLLAPSE = 3;
        public static final int PRESERVE = 1;
        public static final int REPLACE = 2;

        Location getLocation();

        XmlCursor getLocationAsCursor();

        QName getName();

        String getText();

        String getText(int i);

        String getXsiLoc();

        String getXsiNil();

        String getXsiNoLoc();

        String getXsiType();

        boolean textIsWhitespace();
    }

    void nextEvent(int i, Event event);
}
