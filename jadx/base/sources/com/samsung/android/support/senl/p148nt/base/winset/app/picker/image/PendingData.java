package com.samsung.android.support.senl.p148nt.base.winset.app.picker.image;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.content.FileProvider;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\nR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/PendingData;", "", "<init>", "()V", "value", "Landroid/net/Uri;", "takenPictureUri", "getTakenPictureUri", "()Landroid/net/Uri;", "takenPictureFilePath", "", "getTakenPictureFilePath", "()Ljava/lang/String;", "setTakenPictureFilePath", "(Ljava/lang/String;)V", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/content/Intent;", "getPendingIntent", "()Landroid/content/Intent;", "setPendingIntent", "(Landroid/content/Intent;)V", "getTakePictureUri", "context", "Landroid/content/Context;", "getUriAsFileProviderType", "file", "Ljava/io/File;", "deleteFileForTakePicture", "", "clear", "setTakenPictureFileUri", "uriString", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PendingData {

    @NotNull
    private static final String TAG = "PendingData";

    @Nullable
    private Intent pendingIntent;

    @Nullable
    private String takenPictureFilePath;

    @Nullable
    private Uri takenPictureUri;

    private final Uri getUriAsFileProviderType(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, ShareFileProvider.INSTANCE.getAUTHORITY(), file);
        } catch (Exception e) {
            AbstractC4539a.m3214x("getUriAsFileProviderType# Exception occured + ", e.getMessage(), TAG);
            return null;
        }
    }

    public final void clear() {
        this.takenPictureUri = null;
        this.takenPictureFilePath = null;
        this.pendingIntent = null;
    }

    public final void deleteFileForTakePicture() {
        if (this.takenPictureFilePath != null) {
            File file = new File(this.takenPictureFilePath);
            if (file.exists()) {
                Logger.m8702i(TAG, "deleteFileForTakePicture, isDeleted = " + file.delete());
            }
            this.takenPictureFilePath = null;
        }
    }

    @Nullable
    public final Intent getPendingIntent() {
        return this.pendingIntent;
    }

    @Nullable
    public final Uri getTakePictureUri(@Nullable Context context) {
        File file = new File(AbstractC11014a.m12320e(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "/Camera"), AbstractC0541b.m756B(new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), ".jpg"));
        if (file.getParentFile() != null && !file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            Logger.m8698e(TAG, "getTakePictureUri# mkdirs fail");
        }
        this.takenPictureFilePath = file.getAbsolutePath();
        if (context != null) {
            this.takenPictureUri = getUriAsFileProviderType(context, file);
        }
        return this.takenPictureUri;
    }

    @Nullable
    public final String getTakenPictureFilePath() {
        return this.takenPictureFilePath;
    }

    @Nullable
    public final Uri getTakenPictureUri() {
        return this.takenPictureUri;
    }

    public final void setPendingIntent(@Nullable Intent intent) {
        this.pendingIntent = intent;
    }

    public final void setTakenPictureFilePath(@Nullable String str) {
        this.takenPictureFilePath = str;
    }

    public final void setTakenPictureFileUri(@Nullable String uriString) {
        this.takenPictureUri = Uri.parse(uriString);
    }
}
