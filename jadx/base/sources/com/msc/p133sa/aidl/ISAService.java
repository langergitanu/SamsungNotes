package com.msc.p133sa.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.msc.p133sa.aidl.ISACallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ISAService extends IInterface {
    public static final String DESCRIPTOR = "com.msc.sa.aidl.ISAService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ISAService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public String registerCallback(String str, String str2, String str3, ISACallback iSACallback) {
            return null;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestAccessToken(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestAuthCode(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestChecklistValidation(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestClearConsentData(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestDisclaimerAgreement(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestPasswordConfirmation(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestRLControlFMM(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestRequiredConsent(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestRubinRequest(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean requestSCloudAccessToken(int i, String str, Bundle bundle) {
            return false;
        }

        @Override // com.msc.p133sa.aidl.ISAService
        public boolean unregisterCallback(String str) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m4633a(Parcel parcel) {
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

    String registerCallback(String str, String str2, String str3, ISACallback iSACallback);

    boolean requestAccessToken(int i, String str, Bundle bundle);

    boolean requestAuthCode(int i, String str, Bundle bundle);

    boolean requestChecklistValidation(int i, String str, Bundle bundle);

    boolean requestClearConsentData(int i, String str, Bundle bundle);

    boolean requestDisclaimerAgreement(int i, String str, Bundle bundle);

    boolean requestPasswordConfirmation(int i, String str, Bundle bundle);

    boolean requestRLControlFMM(int i, String str, Bundle bundle);

    boolean requestRequiredConsent(int i, String str, Bundle bundle);

    boolean requestRubinRequest(int i, String str, Bundle bundle);

    boolean requestSCloudAccessToken(int i, String str, Bundle bundle);

    boolean unregisterCallback(String str);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ISAService {
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_requestAccessToken = 3;
        static final int TRANSACTION_requestAuthCode = 6;
        static final int TRANSACTION_requestChecklistValidation = 4;
        static final int TRANSACTION_requestClearConsentData = 12;
        static final int TRANSACTION_requestDisclaimerAgreement = 5;
        static final int TRANSACTION_requestPasswordConfirmation = 8;
        static final int TRANSACTION_requestRLControlFMM = 9;
        static final int TRANSACTION_requestRequiredConsent = 11;
        static final int TRANSACTION_requestRubinRequest = 10;
        static final int TRANSACTION_requestSCloudAccessToken = 7;
        static final int TRANSACTION_unregisterCallback = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ISAService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISAService.DESCRIPTOR;
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public String registerCallback(String str, String str2, String str3, ISACallback iSACallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongInterface(iSACallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestAccessToken(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestAuthCode(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestChecklistValidation(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestClearConsentData(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestDisclaimerAgreement(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestPasswordConfirmation(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestRLControlFMM(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestRequiredConsent(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestRubinRequest(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean requestSCloudAccessToken(int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.msc.p133sa.aidl.ISAService
            public boolean unregisterCallback(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISAService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISAService.DESCRIPTOR);
        }

        public static ISAService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISAService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISAService)) ? new Proxy(iBinder) : (ISAService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISAService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISAService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    String strRegisterCallback = registerCallback(parcel.readString(), parcel.readString(), parcel.readString(), ISACallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(strRegisterCallback);
                    return true;
                case 2:
                    boolean zUnregisterCallback = unregisterCallback(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnregisterCallback ? 1 : 0);
                    return true;
                case 3:
                    int i4 = parcel.readInt();
                    String string = parcel.readString();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zRequestAccessToken = requestAccessToken(i4, string, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestAccessToken ? 1 : 0);
                    return true;
                case 4:
                    int i5 = parcel.readInt();
                    String string2 = parcel.readString();
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    boolean zRequestChecklistValidation = requestChecklistValidation(i5, string2, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestChecklistValidation ? 1 : 0);
                    return true;
                case 5:
                    int i6 = parcel.readInt();
                    String string3 = parcel.readString();
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    boolean zRequestDisclaimerAgreement = requestDisclaimerAgreement(i6, string3, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestDisclaimerAgreement ? 1 : 0);
                    return true;
                case 6:
                    int i7 = parcel.readInt();
                    String string4 = parcel.readString();
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    boolean zRequestAuthCode = requestAuthCode(i7, string4, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestAuthCode ? 1 : 0);
                    return true;
                case 7:
                    int i8 = parcel.readInt();
                    String string5 = parcel.readString();
                    Parcelable.Creator creator5 = Bundle.CREATOR;
                    boolean zRequestSCloudAccessToken = requestSCloudAccessToken(i8, string5, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestSCloudAccessToken ? 1 : 0);
                    return true;
                case 8:
                    int i9 = parcel.readInt();
                    String string6 = parcel.readString();
                    Parcelable.Creator creator6 = Bundle.CREATOR;
                    boolean zRequestPasswordConfirmation = requestPasswordConfirmation(i9, string6, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestPasswordConfirmation ? 1 : 0);
                    return true;
                case 9:
                    int i10 = parcel.readInt();
                    String string7 = parcel.readString();
                    Parcelable.Creator creator7 = Bundle.CREATOR;
                    boolean zRequestRLControlFMM = requestRLControlFMM(i10, string7, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestRLControlFMM ? 1 : 0);
                    return true;
                case 10:
                    int i11 = parcel.readInt();
                    String string8 = parcel.readString();
                    Parcelable.Creator creator8 = Bundle.CREATOR;
                    boolean zRequestRubinRequest = requestRubinRequest(i11, string8, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestRubinRequest ? 1 : 0);
                    return true;
                case 11:
                    int i12 = parcel.readInt();
                    String string9 = parcel.readString();
                    Parcelable.Creator creator9 = Bundle.CREATOR;
                    boolean zRequestRequiredConsent = requestRequiredConsent(i12, string9, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestRequiredConsent ? 1 : 0);
                    return true;
                case 12:
                    int i13 = parcel.readInt();
                    String string10 = parcel.readString();
                    Parcelable.Creator creator10 = Bundle.CREATOR;
                    boolean zRequestClearConsentData = requestClearConsentData(i13, string10, (Bundle) _Parcel.m4633a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestClearConsentData ? 1 : 0);
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
}
