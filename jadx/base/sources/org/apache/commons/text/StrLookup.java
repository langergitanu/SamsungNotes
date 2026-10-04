package org.apache.commons.text;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import org.apache.commons.text.lookup.StringLookup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public abstract class StrLookup<V> implements StringLookup {
    private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup(null);
    private static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP = new SystemPropertiesStrLookup();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MapStrLookup<V> extends StrLookup<V> {
        private final Map<String, V> map;

        @Override // org.apache.commons.text.lookup.StringLookup
        public String lookup(String str) {
            return Objects.toString(this.map.get(str), null);
        }

        public String toString() {
            return super.toString() + " [map=" + this.map + "]";
        }

        private MapStrLookup(Map<String, V> map) {
            this.map = map == null ? Collections.EMPTY_MAP : map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ResourceBundleLookup extends StrLookup<String> {
        private final ResourceBundle resourceBundle;

        @Override // org.apache.commons.text.lookup.StringLookup
        public String lookup(String str) {
            ResourceBundle resourceBundle = this.resourceBundle;
            if (resourceBundle == null || str == null || !resourceBundle.containsKey(str)) {
                return null;
            }
            return this.resourceBundle.getString(str);
        }

        public String toString() {
            return super.toString() + " [resourceBundle=" + this.resourceBundle + "]";
        }

        private ResourceBundleLookup(ResourceBundle resourceBundle) {
            this.resourceBundle = resourceBundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SystemPropertiesStrLookup extends StrLookup<String> {
        @Override // org.apache.commons.text.lookup.StringLookup
        public String lookup(String str) {
            if (str.isEmpty()) {
                return null;
            }
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }

        private SystemPropertiesStrLookup() {
        }
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> resourceBundleLookup(ResourceBundle resourceBundle) {
        return new ResourceBundleLookup(resourceBundle);
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }
}
