package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Reporter;
import org.slf4j.spi.SLF4JServiceProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class MarkerFactory {
    static IMarkerFactory MARKER_FACTORY;

    static {
        SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            MARKER_FACTORY = provider.getMarkerFactory();
            return;
        }
        Reporter.error("Failed to find provider");
        Reporter.error("Defaulting to BasicMarkerFactory.");
        MARKER_FACTORY = new BasicMarkerFactory();
    }

    private MarkerFactory() {
    }

    public static Marker getDetachedMarker(String str) {
        return MARKER_FACTORY.getDetachedMarker(str);
    }

    public static IMarkerFactory getIMarkerFactory() {
        return MARKER_FACTORY;
    }

    public static Marker getMarker(String str) {
        return MARKER_FACTORY.getMarker(str);
    }
}
