package com.sec.android.diagmonagent.p168sa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IDMAInterface extends IInterface {
    public static final String DESCRIPTOR = "com.sec.android.diagmonagent.sa.IDMAInterface";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IDMAInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.sec.android.diagmonagent.p168sa.IDMAInterface
        public String checkToken() {
            return null;
        }

        @Override // com.sec.android.diagmonagent.p168sa.IDMAInterface
        public int sendCommon(int i, String str, String str2, String str3) {
            return 0;
        }

        @Override // com.sec.android.diagmonagent.p168sa.IDMAInterface
        public int sendLog(int i, String str, String str2, long j, String str3) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IDMAInterface {
        static final int TRANSACTION_checkToken = 1;
        static final int TRANSACTION_sendCommon = 2;
        static final int TRANSACTION_sendLog = 3;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IDMAInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.sec.android.diagmonagent.p168sa.IDMAInterface
            public String checkToken() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDMAInterface.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDMAInterface.DESCRIPTOR;
            }

            @Override // com.sec.android.diagmonagent.p168sa.IDMAInterface
            public int sendCommon(int i, String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDMAInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.sec.android.diagmonagent.p168sa.IDMAInterface
            public int sendLog(int i, String str, String str2, long j, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDMAInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDMAInterface.DESCRIPTOR);
        }

        public static IDMAInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDMAInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDMAInterface)) ? new Proxy(iBinder) : (IDMAInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDMAInterface.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDMAInterface.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String strCheckToken = checkToken();
                parcel2.writeNoException();
                parcel2.writeString(strCheckToken);
            } else if (i == 2) {
                int iSendCommon = sendCommon(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iSendCommon);
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                int iSendLog = sendLog(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iSendLog);
            }
            return true;
        }
    }

    String checkToken();

    int sendCommon(int i, String str, String str2, String str3);

    int sendLog(int i, String str, String str2, long j, String str3);
}
