package com.microsoft.aad.adal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IBrokerAccountService extends IInterface {
    Bundle acquireTokenSilently(Map map);

    Bundle getBrokerUsers();

    Bundle getInactiveBrokerKey(Bundle bundle);

    Intent getIntentForInteractiveRequest();

    void removeAccounts();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IBrokerAccountService {
        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Bundle acquireTokenSilently(Map map) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Bundle getBrokerUsers() {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Bundle getInactiveBrokerKey(Bundle bundle) {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Intent getIntentForInteractiveRequest() {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public void removeAccounts() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IBrokerAccountService {
        private static final String DESCRIPTOR = "com.microsoft.aad.adal.IBrokerAccountService";
        static final int TRANSACTION_acquireTokenSilently = 2;
        static final int TRANSACTION_getBrokerUsers = 1;
        static final int TRANSACTION_getInactiveBrokerKey = 5;
        static final int TRANSACTION_getIntentForInteractiveRequest = 3;
        static final int TRANSACTION_removeAccounts = 4;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IBrokerAccountService {
            public static IBrokerAccountService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Bundle acquireTokenSilently(Map map) {
                Bundle bundleAcquireTokenSilently;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleAcquireTokenSilently = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleAcquireTokenSilently = Stub.getDefaultImpl().acquireTokenSilently(map);
                    }
                    return bundleAcquireTokenSilently;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Bundle getBrokerUsers() {
                Bundle brokerUsers;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        brokerUsers = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        brokerUsers = Stub.getDefaultImpl().getBrokerUsers();
                    }
                    return brokerUsers;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Bundle getInactiveBrokerKey(Bundle bundle) {
                Bundle inactiveBrokerKey;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        inactiveBrokerKey = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        inactiveBrokerKey = Stub.getDefaultImpl().getInactiveBrokerKey(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return inactiveBrokerKey;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Intent getIntentForInteractiveRequest() {
                Intent intentForInteractiveRequest;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForInteractiveRequest = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForInteractiveRequest = Stub.getDefaultImpl().getIntentForInteractiveRequest();
                    }
                    return intentForInteractiveRequest;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public void removeAccounts() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeAccounts();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBrokerAccountService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBrokerAccountService)) ? new Proxy(iBinder) : (IBrokerAccountService) iInterfaceQueryLocalInterface;
        }

        public static IBrokerAccountService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBrokerAccountService iBrokerAccountService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iBrokerAccountService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iBrokerAccountService;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                Bundle brokerUsers = getBrokerUsers();
                parcel2.writeNoException();
                if (brokerUsers != null) {
                    parcel2.writeInt(1);
                    brokerUsers.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                Bundle bundleAcquireTokenSilently = acquireTokenSilently(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                if (bundleAcquireTokenSilently != null) {
                    parcel2.writeInt(1);
                    bundleAcquireTokenSilently.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                Intent intentForInteractiveRequest = getIntentForInteractiveRequest();
                parcel2.writeNoException();
                if (intentForInteractiveRequest != null) {
                    parcel2.writeInt(1);
                    intentForInteractiveRequest.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                removeAccounts();
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            Bundle inactiveBrokerKey = getInactiveBrokerKey(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (inactiveBrokerKey != null) {
                parcel2.writeInt(1);
                inactiveBrokerKey.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
