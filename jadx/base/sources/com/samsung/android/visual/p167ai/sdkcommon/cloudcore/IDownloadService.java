package com.samsung.android.visual.p167ai.sdkcommon.cloudcore;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IDownloadService extends IInterface {
    public static final int CHECK_RESULT_AVAILABLE = 0;
    public static final int CHECK_RESULT_NEED_DOWNLOAD = 1;
    public static final int CHECK_RESULT_NETWORK_UNAVAILABLE = -3;
    public static final int CHECK_RESULT_NOT_SUPPORTED = -1;
    public static final int CHECK_RESULT_SERVER_ERROR = -5;
    public static final int CHECK_RESULT_STORE_NOT_FOUND = -4;
    public static final int CHECK_RESULT_TIMEOUT = -6;
    public static final int CHECK_RESULT_UNKNOWN_FEATURE = -2;
    public static final String DESCRIPTOR = "com.samsung.android.visual.ai.sdkcommon.cloudcore.IDownloadService";
    public static final int RESULT_ADJUST_THREASHOLD = 9000;
    public static final int RESULT_ADJUST_VALUE = 10000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IDownloadService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public boolean cancel(long j) {
            return false;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public int check(String str) {
            return 0;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public int checkAndDownload(String str, String[] strArr, boolean z, boolean z2) {
            return 0;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public int checkStore(String str) {
            return 0;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public long download(Uri uri, ParcelFileDescriptor parcelFileDescriptor, IDownloadCallback iDownloadCallback) {
            return 0L;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public int downloadModelPackages(String str) {
            return 0;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
        public Uri[] getDownloadUris(String str, Bundle bundle) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IDownloadService {
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_check = 4;
        static final int TRANSACTION_checkAndDownload = 7;
        static final int TRANSACTION_checkStore = 5;
        static final int TRANSACTION_download = 2;
        static final int TRANSACTION_downloadModelPackages = 6;
        static final int TRANSACTION_getDownloadUris = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IDownloadService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public boolean cancel(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public int check(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public int checkAndDownload(String str, String[] strArr, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public int checkStore(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public long download(Uri uri, ParcelFileDescriptor parcelFileDescriptor, IDownloadCallback iDownloadCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, uri, 0);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeStrongInterface(iDownloadCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public int downloadModelPackages(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService
            public Uri[] getDownloadUris(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDownloadService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Uri[]) parcelObtain2.createTypedArray(Uri.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDownloadService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IDownloadService.DESCRIPTOR);
        }

        public static IDownloadService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDownloadService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadService)) ? new Proxy(iBinder) : (IDownloadService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDownloadService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDownloadService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    Uri[] downloadUris = getDownloadUris(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(downloadUris, 1);
                    return true;
                case 2:
                    long jDownload = download((Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR), (ParcelFileDescriptor) _Parcel.readTypedObject(parcel, ParcelFileDescriptor.CREATOR), IDownloadCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(jDownload);
                    return true;
                case 3:
                    boolean zCancel = cancel(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancel ? 1 : 0);
                    return true;
                case 4:
                    int iCheck = check(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCheck);
                    return true;
                case 5:
                    int iCheckStore = checkStore(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCheckStore);
                    return true;
                case 6:
                    int iDownloadModelPackages = downloadModelPackages(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDownloadModelPackages);
                    return true;
                case 7:
                    int iCheckAndDownload = checkAndDownload(parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(iCheckAndDownload);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
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

    boolean cancel(long j);

    int check(String str);

    int checkAndDownload(String str, String[] strArr, boolean z, boolean z2);

    int checkStore(String str);

    long download(Uri uri, ParcelFileDescriptor parcelFileDescriptor, IDownloadCallback iDownloadCallback);

    int downloadModelPackages(String str);

    Uri[] getDownloadUris(String str, Bundle bundle);
}
