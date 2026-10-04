package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzev;
import com.google.android.gms.internal.drive.zzhs;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "CompletionEventCreator")
@SafeParcelable.Reserved({1})
public final class CompletionEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;

    @SafeParcelable.Field(m3227id = 8)
    private final int status;

    @Nullable
    @SafeParcelable.Field(m3227id = 3)
    private final String zzca;

    @Nullable
    @SafeParcelable.Field(m3227id = 4)
    private final ParcelFileDescriptor zzcb;

    @Nullable
    @SafeParcelable.Field(m3227id = 5)
    private final ParcelFileDescriptor zzcc;

    @Nullable
    @SafeParcelable.Field(m3227id = 6)
    private final MetadataBundle zzcd;

    @SafeParcelable.Field(m3227id = 7)
    private final List<String> zzce;

    @SafeParcelable.Field(m3227id = 9)
    private final IBinder zzcf;
    private boolean zzcg = false;
    private boolean zzch = false;
    private boolean zzci = false;

    @SafeParcelable.Field(m3227id = 2)
    private final DriveId zzk;
    private static final GmsLogger zzbz = new GmsLogger("CompletionEvent", "");
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zzg();

    @SafeParcelable.Constructor
    public CompletionEvent(@SafeParcelable.Param(m3228id = 2) DriveId driveId, @SafeParcelable.Param(m3228id = 3) String str, @SafeParcelable.Param(m3228id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(m3228id = 5) ParcelFileDescriptor parcelFileDescriptor2, @SafeParcelable.Param(m3228id = 6) MetadataBundle metadataBundle, @SafeParcelable.Param(m3228id = 7) List<String> list, @SafeParcelable.Param(m3228id = 8) int i, @SafeParcelable.Param(m3228id = 9) IBinder iBinder) {
        this.zzk = driveId;
        this.zzca = str;
        this.zzcb = parcelFileDescriptor;
        this.zzcc = parcelFileDescriptor2;
        this.zzcd = metadataBundle;
        this.zzce = list;
        this.status = i;
        this.zzcf = iBinder;
    }

    private final void zza(boolean z) {
        zzv();
        this.zzci = true;
        IOUtils.closeQuietly(this.zzcb);
        IOUtils.closeQuietly(this.zzcc);
        MetadataBundle metadataBundle = this.zzcd;
        if (metadataBundle != null) {
            MetadataField<BitmapTeleporter> metadataField = zzhs.zzkq;
            if (metadataBundle.zzd(metadataField)) {
                ((BitmapTeleporter) this.zzcd.zza(metadataField)).release();
            }
        }
        IBinder iBinder = this.zzcf;
        if (iBinder == null) {
            zzbz.efmt("CompletionEvent", "No callback on %s", z ? "snooze" : "dismiss");
            return;
        }
        try {
            zzev.zza(iBinder).zza(z);
        } catch (RemoteException e) {
            zzbz.m3220e("CompletionEvent", "RemoteException on ".concat(z ? "snooze" : "dismiss"), e);
        }
    }

    private final void zzv() {
        if (this.zzci) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public final void dismiss() {
        zza(false);
    }

    @Nullable
    public final String getAccountName() {
        zzv();
        return this.zzca;
    }

    @Nullable
    public final InputStream getBaseContentsInputStream() {
        zzv();
        if (this.zzcb == null) {
            return null;
        }
        if (this.zzcg) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzcg = true;
        return new FileInputStream(this.zzcb.getFileDescriptor());
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        zzv();
        return this.zzk;
    }

    @Nullable
    public final InputStream getModifiedContentsInputStream() {
        zzv();
        if (this.zzcc == null) {
            return null;
        }
        if (this.zzch) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzch = true;
        return new FileInputStream(this.zzcc.getFileDescriptor());
    }

    @Nullable
    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        zzv();
        if (this.zzcd != null) {
            return new MetadataChangeSet(this.zzcd);
        }
        return null;
    }

    public final int getStatus() {
        zzv();
        return this.status;
    }

    public final List<String> getTrackingTags() {
        zzv();
        return new ArrayList(this.zzce);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 2;
    }

    public final void snooze() {
        zza(true);
    }

    public final String toString() {
        String string;
        List<String> list = this.zzce;
        if (list == null) {
            string = "<null>";
        } else {
            String strJoin = TextUtils.join("','", list);
            StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(2, strJoin));
            sb.append("'");
            sb.append(strJoin);
            sb.append("'");
            string = sb.toString();
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.zzk, Integer.valueOf(this.status), string);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzca, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcb, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcc, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcd, i2, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzce, false);
        SafeParcelWriter.writeInt(parcel, 8, this.status);
        SafeParcelWriter.writeIBinder(parcel, 9, this.zzcf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
