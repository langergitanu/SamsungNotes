package com.samsung.android.scloud.rpc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ISamsungCloudRPC extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.scloud.rpc.ISamsungCloudRPC";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ISamsungCloudRPC {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
        public void cancel(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback) {
        }

        @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
        public Bundle getProfile(String str, SamsungCloudRPCProfile samsungCloudRPCProfile) {
            return null;
        }

        @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
        public void showSetting(String str) {
        }

        @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
        public void start(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback) {
        }

        @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
        public Bundle switchOnOff(String str, int i) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ISamsungCloudRPC {
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_getProfile = 1;
        static final int TRANSACTION_showSetting = 5;
        static final int TRANSACTION_start = 2;
        static final int TRANSACTION_switchOnOff = 4;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ISamsungCloudRPC {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
            public void cancel(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISamsungCloudRPC.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iSamsungCloudRPCCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ISamsungCloudRPC.DESCRIPTOR;
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
            public Bundle getProfile(String str, SamsungCloudRPCProfile samsungCloudRPCProfile) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISamsungCloudRPC.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, samsungCloudRPCProfile, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Bundle bundle = (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        samsungCloudRPCProfile.readFromParcel(parcelObtain2);
                    }
                    return bundle;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
            public void showSetting(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISamsungCloudRPC.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
            public void start(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISamsungCloudRPC.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iSamsungCloudRPCCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPC
            public Bundle switchOnOff(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISamsungCloudRPC.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISamsungCloudRPC.DESCRIPTOR);
        }

        public static ISamsungCloudRPC asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISamsungCloudRPC.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISamsungCloudRPC)) ? new Proxy(iBinder) : (ISamsungCloudRPC) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISamsungCloudRPC.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISamsungCloudRPC.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String string = parcel.readString();
                SamsungCloudRPCProfile samsungCloudRPCProfile = (SamsungCloudRPCProfile) _Parcel.readTypedObject(parcel, SamsungCloudRPCProfile.CREATOR);
                Bundle profile = getProfile(string, samsungCloudRPCProfile);
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, profile, 1);
                _Parcel.writeTypedObject(parcel2, samsungCloudRPCProfile, 1);
                return true;
            }
            if (i == 2) {
                start(parcel.readString(), ISamsungCloudRPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                cancel(parcel.readString(), ISamsungCloudRPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                Bundle bundleSwitchOnOff = switchOnOff(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleSwitchOnOff, 1);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            showSetting(parcel.readString());
            parcel2.writeNoException();
            return true;
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

    void cancel(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback);

    Bundle getProfile(String str, SamsungCloudRPCProfile samsungCloudRPCProfile);

    void showSetting(String str);

    void start(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback);

    Bundle switchOnOff(String str, int i);
}
