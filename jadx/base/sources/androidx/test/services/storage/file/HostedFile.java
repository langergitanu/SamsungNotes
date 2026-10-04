package androidx.test.services.storage.file;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.test.services.storage.TestStorageConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class HostedFile {
    private static final String TAG = "HostedFile";
    private static final AtomicBoolean loggedOutputDir = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FileHost {
        TEST_FILE(TestStorageConstants.TEST_RUNFILES_PROVIDER_AUTHORITY, false),
        EXPORT_PROPERTIES(TestStorageConstants.OUTPUT_PROPERTIES_PROVIDER_AUTHORITY, true),
        OUTPUT(TestStorageConstants.TEST_OUTPUT_PROVIDER_AUTHORITY, true),
        INTERNAL_USE_ONLY(TestStorageConstants.INTERNAL_USE_PROVIDER_AUTHORITY, true);

        private final String authority;
        private final boolean writeable;

        FileHost(String str, boolean z) {
            this.authority = (String) HostedFile.checkNotNull(str);
            this.writeable = z;
        }

        public String getAuthority() {
            return this.authority;
        }

        public boolean isWritable() {
            return this.writeable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FileType {
        FILE("f"),
        DIRECTORY("d");

        private String type;

        FileType(String str) {
            this.type = (String) HostedFile.checkNotNull(str);
        }

        public static FileType fromTypeCode(String str) {
            for (FileType fileType : values()) {
                if (fileType.getTypeCode().equals(str)) {
                    return fileType;
                }
            }
            throw new IllegalArgumentException(AbstractC0541b.m772n("unknown type: ", str));
        }

        public String getTypeCode() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum HostedFileColumn {
        NAME("name", String.class, 3, 0),
        TYPE("type", String.class, 3, 1),
        SIZE("size", Long.class, 1, 2),
        DATA("_data", Byte[].class, 4, 3),
        DISPLAY_NAME("_display_name", String.class, 3, 4),
        SIZE_2("_size", Long.class, 2, 5);

        private final int androidType;
        private final String columnName;
        private final Class<?> columnType;
        private final int position;

        HostedFileColumn(String str, Class cls, int i, int i2) {
            this.columnName = (String) HostedFile.checkNotNull(str);
            this.columnType = (Class) HostedFile.checkNotNull(cls);
            this.androidType = i;
            this.position = i2;
        }

        public static String[] getColumnNames() {
            HostedFileColumn[] hostedFileColumnArrValues = values();
            int length = hostedFileColumnArrValues.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = hostedFileColumnArrValues[i].getColumnName();
            }
            return strArr;
        }

        public int getAndroidType() {
            return this.androidType;
        }

        public String getColumnName() {
            return this.columnName;
        }

        public Class<?> getColumnType() {
            return this.columnType;
        }

        public int getPosition() {
            return this.position;
        }
    }

    private HostedFile() {
    }

    public static Uri buildUri(FileHost fileHost, String str) {
        return new Uri.Builder().scheme("content").authority(fileHost.getAuthority()).path(str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static File getInputRootDirectory(Context context) {
        return Environment.getExternalStorageDirectory();
    }

    public static File getOutputRootDirectory(Context context) {
        if (((UserManager) context.getSystemService(IdentityApiContract.Token.USER)).isSystemUser()) {
            return Environment.getExternalStorageDirectory();
        }
        if (!loggedOutputDir.getAndSet(true)) {
            Log.d(TAG, "Secondary user detected. Choosing local storage as output root dir: " + context.getCacheDir().getAbsolutePath());
        }
        return context.getCacheDir();
    }
}
