package androidx.test.services.storage.internal;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.test.internal.util.Checks;
import androidx.test.services.storage.TestStorageException;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class TestStorageUtil {
    private TestStorageUtil() {
    }

    public static InputStream getInputStream(Uri uri, ContentResolver contentResolver) {
        Checks.checkNotNull(uri);
        ContentProviderClient contentProviderClientMakeContentProviderClient = null;
        try {
            try {
                contentProviderClientMakeContentProviderClient = makeContentProviderClient(contentResolver, uri);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new ParcelFileDescriptor.AutoCloseInputStream(contentProviderClientMakeContentProviderClient.openFile(uri, "r")));
                contentProviderClientMakeContentProviderClient.release();
                return bufferedInputStream;
            } catch (RemoteException e) {
                throw new TestStorageException("Unable to access content provider: " + uri, e);
            }
        } catch (Throwable th) {
            if (contentProviderClientMakeContentProviderClient != null) {
                contentProviderClientMakeContentProviderClient.release();
            }
            throw th;
        }
    }

    public static OutputStream getOutputStream(Uri uri, ContentResolver contentResolver) {
        return getOutputStream(uri, contentResolver, false);
    }

    private static ContentProviderClient makeContentProviderClient(ContentResolver contentResolver, Uri uri) {
        Checks.checkNotNull(contentResolver);
        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(uri);
        if (contentProviderClientAcquireContentProviderClient != null) {
            return contentProviderClientAcquireContentProviderClient;
        }
        throw new TestStorageException(String.format("No content provider registered for: %s. Are all test services apks installed?", uri));
    }

    public static OutputStream getOutputStream(Uri uri, ContentResolver contentResolver, boolean z) {
        Checks.checkNotNull(uri);
        ContentProviderClient contentProviderClientMakeContentProviderClient = null;
        try {
            try {
                contentProviderClientMakeContentProviderClient = makeContentProviderClient(contentResolver, uri);
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentProviderClientMakeContentProviderClient.openFile(uri, z ? VPathDataCmd.ClockWiseArcTo : "wt"));
                contentProviderClientMakeContentProviderClient.release();
                return autoCloseOutputStream;
            } catch (RemoteException e) {
                throw new TestStorageException("Unable to access content provider: " + uri, e);
            }
        } catch (Throwable th) {
            if (contentProviderClientMakeContentProviderClient != null) {
                contentProviderClientMakeContentProviderClient.release();
            }
            throw th;
        }
    }
}
