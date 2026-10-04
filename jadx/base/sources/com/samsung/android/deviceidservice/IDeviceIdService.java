package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IDeviceIdService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.deviceidservice.IDeviceIdService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IDeviceIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public String getAAID(String str) {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public String getOAID() {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public String getVAID(String str) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IDeviceIdService {
        static final int TRANSACTION_getAAID = 3;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getVAID = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IDeviceIdService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public String getAAID(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceIdService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDeviceIdService.DESCRIPTOR;
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public String getOAID() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceIdService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public String getVAID(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeviceIdService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceIdService.DESCRIPTOR);
        }

        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDeviceIdService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceIdService)) ? new Proxy(iBinder) : (IDeviceIdService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceIdService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDeviceIdService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
            } else if (i == 2) {
                String vaid = getVAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(vaid);
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                String aaid = getAAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(aaid);
            }
            return true;
        }
    }

    String getAAID(String str);

    String getOAID();

    String getVAID(String str);
}
