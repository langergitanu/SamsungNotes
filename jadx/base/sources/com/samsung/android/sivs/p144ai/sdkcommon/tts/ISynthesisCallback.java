package com.samsung.android.sivs.p144ai.sdkcommon.tts;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ISynthesisCallback extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.tts.ISynthesisCallback";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ISynthesisCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
        public void onDone(String str) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
        public void onError(String str, int i) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
        public void onProgress(String str, byte[] bArr, int i, int i2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
        public void onRangeStart(String str, int i, int i2, int i4) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
        public void onStart(String str, int i, int i2, int i4) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ISynthesisCallback {
        static final int TRANSACTION_onDone = 2;
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onProgress = 5;
        static final int TRANSACTION_onRangeStart = 4;
        static final int TRANSACTION_onStart = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ISynthesisCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISynthesisCallback.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
            public void onDone(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISynthesisCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
            public void onError(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISynthesisCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
            public void onProgress(String str, byte[] bArr, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISynthesisCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
            public void onRangeStart(String str, int i, int i2, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISynthesisCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i4);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
            public void onStart(String str, int i, int i2, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISynthesisCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i4);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISynthesisCallback.DESCRIPTOR);
        }

        public static ISynthesisCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISynthesisCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISynthesisCallback)) ? new Proxy(iBinder) : (ISynthesisCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISynthesisCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISynthesisCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onStart(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 2) {
                onDone(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 3) {
                onError(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 4) {
                onRangeStart(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                onProgress(parcel.readString(), parcel.createByteArray(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onDone(String str);

    void onError(String str, int i);

    void onProgress(String str, byte[] bArr, int i, int i2);

    void onRangeStart(String str, int i, int i2, int i4);

    void onStart(String str, int i, int i2, int i4);
}
