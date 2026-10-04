package com.samsung.android.visual.p167ai.sdkcommon.cloudcore;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IDownloadCallback extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.visual.ai.sdkcommon.cloudcore.IDownloadCallback";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IDownloadCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadCallback
        public void onError(long j, Uri uri, String str) {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadCallback
        public void onSuccess(long j, Uri uri) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IDownloadCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IDownloadCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDownloadCallback.DESCRIPTOR;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadCallback
            public void onError(long j, Uri uri, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadCallback.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    _Parcel.writeTypedObject(parcelObtain, uri, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadCallback
            public void onSuccess(long j, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadCallback.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    _Parcel.writeTypedObject(parcelObtain, uri, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDownloadCallback.DESCRIPTOR);
        }

        public static IDownloadCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDownloadCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadCallback)) ? new Proxy(iBinder) : (IDownloadCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDownloadCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDownloadCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                long j = parcel.readLong();
                Parcelable.Creator creator = Uri.CREATOR;
                onSuccess(j, (Uri) _Parcel.m12865a(parcel));
                return true;
            }
            if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            long j2 = parcel.readLong();
            Parcelable.Creator creator2 = Uri.CREATOR;
            onError(j2, (Uri) _Parcel.m12865a(parcel), parcel.readString());
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m12865a(Parcel parcel) {
            return readTypedObject(parcel, Uri.CREATOR);
        }

        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void onError(long j, Uri uri, String str);

    void onSuccess(long j, Uri uri);
}
