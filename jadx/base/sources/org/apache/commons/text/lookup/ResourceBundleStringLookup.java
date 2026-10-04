package org.apache.commons.text.lookup;

import androidx.collection.AbstractC0622a;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class ResourceBundleStringLookup extends AbstractStringLookup {
    static final ResourceBundleStringLookup INSTANCE = new ResourceBundleStringLookup();
    private final String bundleName;

    private ResourceBundleStringLookup() {
        this(null);
    }

    public ResourceBundle getBundle(String str) {
        return ResourceBundle.getBundle(str);
    }

    public String getString(String str, String str2) {
        return getBundle(str).getString(str2);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(AbstractStringLookup.SPLIT_STR);
        int length = strArrSplit.length;
        String str2 = this.bundleName;
        boolean z = str2 == null;
        if (z && length != 2) {
            throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is BundleName:KeyName.", str);
        }
        if (str2 != null && length != 1) {
            throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is KeyName.", str);
        }
        if (z) {
            str2 = strArrSplit[0];
        }
        String str3 = z ? strArrSplit[1] : strArrSplit[0];
        try {
            return getString(str2, str3);
        } catch (MissingResourceException unused) {
            return null;
        } catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up resource bundle [%s] and key [%s].", str2, str3);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [bundleName=");
        return AbstractC0622a.m1170p(this.bundleName, "]", sb);
    }

    public ResourceBundleStringLookup(String str) {
        this.bundleName = str;
    }
}
