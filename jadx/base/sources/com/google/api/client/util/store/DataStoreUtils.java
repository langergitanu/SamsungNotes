package com.google.api.client.util.store;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class DataStoreUtils {
    private DataStoreUtils() {
    }

    public static String toString(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            boolean z = true;
            for (String str : dataStore.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(SQLKeyword.COMMA);
                }
                sb.append(str);
                sb.append('=');
                sb.append(dataStore.get(str));
            }
            sb.append('}');
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
