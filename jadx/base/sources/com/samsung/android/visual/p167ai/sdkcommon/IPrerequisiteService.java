package com.samsung.android.visual.p167ai.sdkcommon;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IPrerequisiteService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.visual.ai.sdkcommon.IPrerequisiteService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IPrerequisiteService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IPrerequisiteService
        public boolean enableTermsAgreement(boolean z) {
            return false;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IPrerequisiteService
        public Bundle isAvailable() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IPrerequisiteService
        public boolean loginSamsungAccount() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IPrerequisiteService {
        static final int TRANSACTION_enableTermsAgreement = 3;
        static final int TRANSACTION_isAvailable = 1;
        static final int TRANSACTION_loginSamsungAccount = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IPrerequisiteService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IPrerequisiteService
            public boolean enableTermsAgreement(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPrerequisiteService.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IPrerequisiteService.DESCRIPTOR;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IPrerequisiteService
            public Bundle isAvailable() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPrerequisiteService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m12860a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IPrerequisiteService
            public boolean loginSamsungAccount() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPrerequisiteService.DESCRIPTOR);
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
            attachInterface(this, IPrerequisiteService.DESCRIPTOR);
        }

        public static IPrerequisiteService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPrerequisiteService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPrerequisiteService)) ? new Proxy(iBinder) : (IPrerequisiteService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPrerequisiteService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPrerequisiteService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                Bundle bundleIsAvailable = isAvailable();
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleIsAvailable, 1);
                return true;
            }
            if (i == 2) {
                boolean zLoginSamsungAccount = loginSamsungAccount();
                parcel2.writeNoException();
                parcel2.writeInt(zLoginSamsungAccount ? 1 : 0);
                return true;
            }
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            boolean zEnableTermsAgreement = enableTermsAgreement(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zEnableTermsAgreement ? 1 : 0);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m12860a(Parcel parcel) {
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

    boolean enableTermsAgreement(boolean z);

    Bundle isAvailable();

    boolean loginSamsungAccount();
}
