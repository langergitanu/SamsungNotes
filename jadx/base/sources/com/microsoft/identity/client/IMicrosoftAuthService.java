package com.microsoft.identity.client;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IMicrosoftAuthService extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IMicrosoftAuthService {
        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle acquireTokenSilently(Bundle bundle) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle generateSignedHttpRequest(Bundle bundle) {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle getAccounts(Bundle bundle) {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle getCurrentAccount(Bundle bundle) {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle getDeviceMode() {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Intent getIntentForInteractiveRequest() {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle hello(Bundle bundle) {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle removeAccount(Bundle bundle) {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle removeAccountFromSharedDevice(Bundle bundle) {
            return null;
        }
    }

    Bundle acquireTokenSilently(Bundle bundle);

    Bundle generateSignedHttpRequest(Bundle bundle);

    Bundle getAccounts(Bundle bundle);

    Bundle getCurrentAccount(Bundle bundle);

    Bundle getDeviceMode();

    Intent getIntentForInteractiveRequest();

    Bundle hello(Bundle bundle);

    Bundle removeAccount(Bundle bundle);

    Bundle removeAccountFromSharedDevice(Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IMicrosoftAuthService {
        private static final String DESCRIPTOR = "com.microsoft.identity.client.IMicrosoftAuthService";
        static final int TRANSACTION_acquireTokenSilently = 3;
        static final int TRANSACTION_generateSignedHttpRequest = 9;
        static final int TRANSACTION_getAccounts = 2;
        static final int TRANSACTION_getCurrentAccount = 7;
        static final int TRANSACTION_getDeviceMode = 6;
        static final int TRANSACTION_getIntentForInteractiveRequest = 4;
        static final int TRANSACTION_hello = 1;
        static final int TRANSACTION_removeAccount = 5;
        static final int TRANSACTION_removeAccountFromSharedDevice = 8;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IMicrosoftAuthService {
            public static IMicrosoftAuthService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle acquireTokenSilently(Bundle bundle) {
                Bundle bundleAcquireTokenSilently;
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
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleAcquireTokenSilently = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleAcquireTokenSilently = Stub.getDefaultImpl().acquireTokenSilently(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleAcquireTokenSilently;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle generateSignedHttpRequest(Bundle bundle) {
                Bundle bundleGenerateSignedHttpRequest;
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
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleGenerateSignedHttpRequest = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleGenerateSignedHttpRequest = Stub.getDefaultImpl().generateSignedHttpRequest(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleGenerateSignedHttpRequest;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle getAccounts(Bundle bundle) {
                Bundle accounts;
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
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        accounts = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        accounts = Stub.getDefaultImpl().getAccounts(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return accounts;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle getCurrentAccount(Bundle bundle) {
                Bundle currentAccount;
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
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        currentAccount = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        currentAccount = Stub.getDefaultImpl().getCurrentAccount(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return currentAccount;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle getDeviceMode() {
                Bundle deviceMode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        deviceMode = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        deviceMode = Stub.getDefaultImpl().getDeviceMode();
                    }
                    return deviceMode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Intent getIntentForInteractiveRequest() {
                Intent intentForInteractiveRequest;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
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

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle hello(Bundle bundle) {
                Bundle bundleHello;
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
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleHello = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleHello = Stub.getDefaultImpl().hello(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleHello;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle removeAccount(Bundle bundle) {
                Bundle bundleRemoveAccount;
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
                        bundleRemoveAccount = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleRemoveAccount = Stub.getDefaultImpl().removeAccount(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleRemoveAccount;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle removeAccountFromSharedDevice(Bundle bundle) {
                Bundle bundleRemoveAccountFromSharedDevice;
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
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        bundleRemoveAccountFromSharedDevice = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        bundleRemoveAccountFromSharedDevice = Stub.getDefaultImpl().removeAccountFromSharedDevice(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundleRemoveAccountFromSharedDevice;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMicrosoftAuthService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMicrosoftAuthService)) ? new Proxy(iBinder) : (IMicrosoftAuthService) iInterfaceQueryLocalInterface;
        }

        public static IMicrosoftAuthService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMicrosoftAuthService iMicrosoftAuthService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMicrosoftAuthService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMicrosoftAuthService;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleHello = hello(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleHello != null) {
                        parcel2.writeInt(1);
                        bundleHello.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle accounts = getAccounts(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (accounts != null) {
                        parcel2.writeInt(1);
                        accounts.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleAcquireTokenSilently = acquireTokenSilently(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleAcquireTokenSilently != null) {
                        parcel2.writeInt(1);
                        bundleAcquireTokenSilently.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
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
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleRemoveAccount = removeAccount(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleRemoveAccount != null) {
                        parcel2.writeInt(1);
                        bundleRemoveAccount.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle deviceMode = getDeviceMode();
                    parcel2.writeNoException();
                    if (deviceMode != null) {
                        parcel2.writeInt(1);
                        deviceMode.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle currentAccount = getCurrentAccount(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (currentAccount != null) {
                        parcel2.writeInt(1);
                        currentAccount.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleRemoveAccountFromSharedDevice = removeAccountFromSharedDevice(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleRemoveAccountFromSharedDevice != null) {
                        parcel2.writeInt(1);
                        bundleRemoveAccountFromSharedDevice.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle bundleGenerateSignedHttpRequest = generateSignedHttpRequest(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleGenerateSignedHttpRequest != null) {
                        parcel2.writeInt(1);
                        bundleGenerateSignedHttpRequest.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
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
