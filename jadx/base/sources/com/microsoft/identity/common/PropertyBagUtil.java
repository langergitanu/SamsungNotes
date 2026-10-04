package com.microsoft.identity.common;

import android.os.Bundle;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PropertyBagUtil {
    public static PropertyBag fromBundle(@NonNull Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("bundle is marked non-null but is null");
        }
        PropertyBag propertyBag = new PropertyBag();
        for (String str : bundle.keySet()) {
            propertyBag.put(str, bundle.getSerializable(str));
        }
        return propertyBag;
    }

    public static Bundle toBundle(@NonNull PropertyBag propertyBag) {
        if (propertyBag == null) {
            throw new NullPointerException("propertyBag is marked non-null but is null");
        }
        Bundle bundle = new Bundle();
        for (String str : propertyBag.keySet()) {
            bundle.putSerializable(str, propertyBag.get(str));
        }
        return bundle;
    }
}
