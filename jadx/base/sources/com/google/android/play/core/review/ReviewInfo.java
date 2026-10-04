package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ReviewInfo implements Parcelable {
    /* JADX INFO: renamed from: a */
    public static ReviewInfo m4049a(PendingIntent pendingIntent) {
        return new C5247a(pendingIntent);
    }

    /* JADX INFO: renamed from: a */
    public abstract PendingIntent mo4050a();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mo4050a(), 0);
    }
}
