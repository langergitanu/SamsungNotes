package androidx.test.services.storage.file;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.test.internal.util.Checks;
import androidx.test.services.storage.TestStorageConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PropertyFile {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Authority {
        TEST_ARGS(TestStorageConstants.TEST_ARGS_PROVIDER_AUTHORITY);

        private final String authority;

        Authority(String str) {
            this.authority = (String) Checks.checkNotNull(str);
        }

        public String getAuthority() {
            return this.authority;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Column {
        NAME("name", 0),
        VALUE("value", 1);

        private final String columnName;
        private final int position;

        Column(String str, int i) {
            this.columnName = (String) Checks.checkNotNull(str);
            this.position = i;
        }

        public static String[] getNames() {
            Column[] columnArrValues = values();
            int length = values().length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = columnArrValues[i].getName();
            }
            return strArr;
        }

        public String getName() {
            return this.columnName;
        }

        public int getPosition() {
            return this.position;
        }
    }

    private PropertyFile() {
    }

    public static Uri buildUri(Authority authority) {
        Checks.checkNotNull(authority);
        return new Uri.Builder().scheme("content").authority(authority.getAuthority()).build();
    }

    public static Uri buildUri(Authority authority, String str) {
        Checks.checkNotNull(authority);
        Checks.checkNotNull(str);
        return new Uri.Builder().scheme("content").authority(authority.getAuthority()).path(str).build();
    }
}
