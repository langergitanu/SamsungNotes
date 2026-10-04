package com.msc.p133sa.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ISACallback extends IInterface {
    public static final String DESCRIPTOR = "com.msc.sa.aidl.ISACallback";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m4631a(Parcel parcel) {
            return readTypedObject(parcel, Bundle.CREATOR);
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

    void onReceiveAccessToken(int i, boolean z, Bundle bundle);

    void onReceiveAuthCode(int i, boolean z, Bundle bundle);

    void onReceiveChecklistValidation(int i, boolean z, Bundle bundle);

    void onReceiveClearConsentData(int i, boolean z, Bundle bundle);

    void onReceiveDisclaimerAgreement(int i, boolean z, Bundle bundle);

    void onReceivePasswordConfirmation(int i, boolean z, Bundle bundle);

    void onReceiveRLControlFMM(int i, boolean z, Bundle bundle);

    void onReceiveRequiredConsent(int i, boolean z, Bundle bundle);

    void onReceiveRubinRequest(int i, boolean z, Bundle bundle);

    void onReceiveSCloudAccessToken(int i, boolean z, Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ISACallback {
        static final int TRANSACTION_onReceiveAccessToken = 1;
        static final int TRANSACTION_onReceiveAuthCode = 4;
        static final int TRANSACTION_onReceiveChecklistValidation = 2;
        static final int TRANSACTION_onReceiveClearConsentData = 10;
        static final int TRANSACTION_onReceiveDisclaimerAgreement = 3;
        static final int TRANSACTION_onReceivePasswordConfirmation = 6;
        static final int TRANSACTION_onReceiveRLControlFMM = 7;
        static final int TRANSACTION_onReceiveRequiredConsent = 9;
        static final int TRANSACTION_onReceiveRubinRequest = 8;
        static final int TRANSACTION_onReceiveSCloudAccessToken = 5;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ISACallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISACallback.DESCRIPTOR;
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveAccessToken(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveAuthCode(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveChecklistValidation(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveClearConsentData(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveDisclaimerAgreement(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceivePasswordConfirmation(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveRLControlFMM(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveRequiredConsent(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveRubinRequest(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveSCloudAccessToken(int i, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISACallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISACallback.DESCRIPTOR);
        }

        public static ISACallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISACallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISACallback)) ? new Proxy(iBinder) : (ISACallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISACallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISACallback.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int i4 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator = Bundle.CREATOR;
                    onReceiveAccessToken(i4, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int i5 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    onReceiveChecklistValidation(i5, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i6 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    onReceiveDisclaimerAgreement(i6, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int i7 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    onReceiveAuthCode(i7, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    int i8 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator5 = Bundle.CREATOR;
                    onReceiveSCloudAccessToken(i8, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int i9 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator6 = Bundle.CREATOR;
                    onReceivePasswordConfirmation(i9, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    int i10 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator7 = Bundle.CREATOR;
                    onReceiveRLControlFMM(i10, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    int i11 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator8 = Bundle.CREATOR;
                    onReceiveRubinRequest(i11, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    int i12 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator9 = Bundle.CREATOR;
                    onReceiveRequiredConsent(i12, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    int i13 = parcel.readInt();
                    z = parcel.readInt() != 0;
                    Parcelable.Creator creator10 = Bundle.CREATOR;
                    onReceiveClearConsentData(i13, z, (Bundle) _Parcel.m4631a(parcel));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ISACallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveAccessToken(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveAuthCode(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveChecklistValidation(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveClearConsentData(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveDisclaimerAgreement(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceivePasswordConfirmation(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveRLControlFMM(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveRequiredConsent(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveRubinRequest(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveSCloudAccessToken(int i, boolean z, Bundle bundle) {
        }
    }
}
