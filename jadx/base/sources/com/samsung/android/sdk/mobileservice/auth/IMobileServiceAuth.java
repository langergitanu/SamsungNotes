package com.samsung.android.sdk.mobileservice.auth;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sdk.mobileservice.auth.IAccessTokenResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IAuthCodeResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IAuthResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IDisclaimerAgreementForThirdPartyResultCallback;
import com.samsung.android.sdk.mobileservice.auth.IValidationResultCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IMobileServiceAuth extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IMobileServiceAuth {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public boolean getAccountValidation() {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Bundle getAuthInfoCached() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Bundle getDeviceAuthInfoCached() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public boolean getDisclaimerAgreementForService(int i) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public boolean getDisclaimerAgreementForSocial() {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountAccessTokenRequest(String str, String str2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountDisclaimerAgreement(String str, boolean z) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountPasswordConfirmation(String str) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountPasswordConfirmationPopup(String str) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountProfileModification(String str) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountSetupWizard(boolean z) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountSignIn() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountSignInPopup() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForAccountValidationRequest(String str, boolean z, boolean z2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForSocialDisclaimerAgreement(boolean z, boolean z2) {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForSocialDisclaimerDisplay() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForSocialRegistrationInformation() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForSocialSignUp() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public Intent getIntentForSocialTnC() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public boolean getNeedToShowSocialTncPopup() {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public boolean isServiceRegistered(int i) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public void requestAccessTokenForAccount(String str, String str2, Bundle bundle, IAccessTokenResultCallback iAccessTokenResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public void requestAuthCode(String str, String str2, Bundle bundle, IAuthCodeResultCallback iAuthCodeResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public void requestAuthInfo(String str, String str2, Bundle bundle, IAuthResultCallback iAuthResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public void requestDisclaimerAgreementForThirdParty(String str, String str2, Bundle bundle, IDisclaimerAgreementForThirdPartyResultCallback iDisclaimerAgreementForThirdPartyResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public void requestRenewAccessTokenForAccount(String str, String str2, Bundle bundle, String str3, IAccessTokenResultCallback iAccessTokenResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public void requestValidation(String str, String str2, Bundle bundle, IValidationResultCallback iValidationResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
        public boolean setDisclaimerAgreementForSocial(boolean z) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IMobileServiceAuth {
        private static final String DESCRIPTOR = "com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth";
        static final int TRANSACTION_getAccountValidation = 23;
        static final int TRANSACTION_getAuthInfoCached = 18;
        static final int TRANSACTION_getDeviceAuthInfoCached = 19;
        static final int TRANSACTION_getDisclaimerAgreementForService = 25;
        static final int TRANSACTION_getDisclaimerAgreementForSocial = 24;
        static final int TRANSACTION_getIntentForAccountAccessTokenRequest = 1;
        static final int TRANSACTION_getIntentForAccountDisclaimerAgreement = 2;
        static final int TRANSACTION_getIntentForAccountPasswordConfirmation = 3;
        static final int TRANSACTION_getIntentForAccountPasswordConfirmationPopup = 4;
        static final int TRANSACTION_getIntentForAccountProfileModification = 5;
        static final int TRANSACTION_getIntentForAccountSetupWizard = 6;
        static final int TRANSACTION_getIntentForAccountSignIn = 7;
        static final int TRANSACTION_getIntentForAccountSignInPopup = 8;
        static final int TRANSACTION_getIntentForAccountValidationRequest = 9;
        static final int TRANSACTION_getIntentForSocialDisclaimerAgreement = 10;
        static final int TRANSACTION_getIntentForSocialDisclaimerDisplay = 11;
        static final int TRANSACTION_getIntentForSocialRegistrationInformation = 12;
        static final int TRANSACTION_getIntentForSocialSignUp = 13;
        static final int TRANSACTION_getIntentForSocialTnC = 27;
        static final int TRANSACTION_getNeedToShowSocialTncPopup = 26;
        static final int TRANSACTION_isServiceRegistered = 14;
        static final int TRANSACTION_requestAccessTokenForAccount = 15;
        static final int TRANSACTION_requestAuthCode = 16;
        static final int TRANSACTION_requestAuthInfo = 17;
        static final int TRANSACTION_requestDisclaimerAgreementForThirdParty = 22;
        static final int TRANSACTION_requestRenewAccessTokenForAccount = 20;
        static final int TRANSACTION_requestValidation = 21;
        static final int TRANSACTION_setDisclaimerAgreementForSocial = 28;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IMobileServiceAuth {
            public static IMobileServiceAuth sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public boolean getAccountValidation() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(23, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAccountValidation();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Bundle getAuthInfoCached() {
                Bundle authInfoCached;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        authInfoCached = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        authInfoCached = Stub.getDefaultImpl().getAuthInfoCached();
                    }
                    return authInfoCached;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Bundle getDeviceAuthInfoCached() {
                Bundle deviceAuthInfoCached;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(19, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        deviceAuthInfoCached = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        deviceAuthInfoCached = Stub.getDefaultImpl().getDeviceAuthInfoCached();
                    }
                    return deviceAuthInfoCached;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public boolean getDisclaimerAgreementForService(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(25, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDisclaimerAgreementForService(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public boolean getDisclaimerAgreementForSocial() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(24, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDisclaimerAgreementForSocial();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountAccessTokenRequest(String str, String str2) {
                Intent intentForAccountAccessTokenRequest;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountAccessTokenRequest = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountAccessTokenRequest = Stub.getDefaultImpl().getIntentForAccountAccessTokenRequest(str, str2);
                    }
                    return intentForAccountAccessTokenRequest;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountDisclaimerAgreement(String str, boolean z) {
                Intent intentForAccountDisclaimerAgreement;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountDisclaimerAgreement = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountDisclaimerAgreement = Stub.getDefaultImpl().getIntentForAccountDisclaimerAgreement(str, z);
                    }
                    return intentForAccountDisclaimerAgreement;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountPasswordConfirmation(String str) {
                Intent intentForAccountPasswordConfirmation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountPasswordConfirmation = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountPasswordConfirmation = Stub.getDefaultImpl().getIntentForAccountPasswordConfirmation(str);
                    }
                    return intentForAccountPasswordConfirmation;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountPasswordConfirmationPopup(String str) {
                Intent intentForAccountPasswordConfirmationPopup;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountPasswordConfirmationPopup = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountPasswordConfirmationPopup = Stub.getDefaultImpl().getIntentForAccountPasswordConfirmationPopup(str);
                    }
                    return intentForAccountPasswordConfirmationPopup;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountProfileModification(String str) {
                Intent intentForAccountProfileModification;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountProfileModification = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountProfileModification = Stub.getDefaultImpl().getIntentForAccountProfileModification(str);
                    }
                    return intentForAccountProfileModification;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountSetupWizard(boolean z) {
                Intent intentForAccountSetupWizard;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountSetupWizard = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountSetupWizard = Stub.getDefaultImpl().getIntentForAccountSetupWizard(z);
                    }
                    return intentForAccountSetupWizard;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountSignIn() {
                Intent intentForAccountSignIn;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountSignIn = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountSignIn = Stub.getDefaultImpl().getIntentForAccountSignIn();
                    }
                    return intentForAccountSignIn;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountSignInPopup() {
                Intent intentForAccountSignInPopup;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountSignInPopup = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountSignInPopup = Stub.getDefaultImpl().getIntentForAccountSignInPopup();
                    }
                    return intentForAccountSignInPopup;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForAccountValidationRequest(String str, boolean z, boolean z2) {
                Intent intentForAccountValidationRequest;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForAccountValidationRequest = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForAccountValidationRequest = Stub.getDefaultImpl().getIntentForAccountValidationRequest(str, z, z2);
                    }
                    return intentForAccountValidationRequest;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForSocialDisclaimerAgreement(boolean z, boolean z2) {
                Intent intentForSocialDisclaimerAgreement;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForSocialDisclaimerAgreement = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForSocialDisclaimerAgreement = Stub.getDefaultImpl().getIntentForSocialDisclaimerAgreement(z, z2);
                    }
                    return intentForSocialDisclaimerAgreement;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForSocialDisclaimerDisplay() {
                Intent intentForSocialDisclaimerDisplay;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForSocialDisclaimerDisplay = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForSocialDisclaimerDisplay = Stub.getDefaultImpl().getIntentForSocialDisclaimerDisplay();
                    }
                    return intentForSocialDisclaimerDisplay;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForSocialRegistrationInformation() {
                Intent intentForSocialRegistrationInformation;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForSocialRegistrationInformation = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForSocialRegistrationInformation = Stub.getDefaultImpl().getIntentForSocialRegistrationInformation();
                    }
                    return intentForSocialRegistrationInformation;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForSocialSignUp() {
                Intent intentForSocialSignUp;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForSocialSignUp = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForSocialSignUp = Stub.getDefaultImpl().getIntentForSocialSignUp();
                    }
                    return intentForSocialSignUp;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public Intent getIntentForSocialTnC() {
                Intent intentForSocialTnC;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(27, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        intentForSocialTnC = parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        intentForSocialTnC = Stub.getDefaultImpl().getIntentForSocialTnC();
                    }
                    return intentForSocialTnC;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public boolean getNeedToShowSocialTncPopup() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(26, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNeedToShowSocialTncPopup();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public boolean isServiceRegistered(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isServiceRegistered(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public void requestAccessTokenForAccount(String str, String str2, Bundle bundle, IAccessTokenResultCallback iAccessTokenResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iAccessTokenResultCallback != null ? iAccessTokenResultCallback.asBinder() : null);
                    if (this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestAccessTokenForAccount(str, str2, bundle, iAccessTokenResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public void requestAuthCode(String str, String str2, Bundle bundle, IAuthCodeResultCallback iAuthCodeResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iAuthCodeResultCallback != null ? iAuthCodeResultCallback.asBinder() : null);
                    if (this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestAuthCode(str, str2, bundle, iAuthCodeResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public void requestAuthInfo(String str, String str2, Bundle bundle, IAuthResultCallback iAuthResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iAuthResultCallback != null ? iAuthResultCallback.asBinder() : null);
                    if (this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestAuthInfo(str, str2, bundle, iAuthResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public void requestDisclaimerAgreementForThirdParty(String str, String str2, Bundle bundle, IDisclaimerAgreementForThirdPartyResultCallback iDisclaimerAgreementForThirdPartyResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iDisclaimerAgreementForThirdPartyResultCallback != null ? iDisclaimerAgreementForThirdPartyResultCallback.asBinder() : null);
                    if (this.mRemote.transact(22, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestDisclaimerAgreementForThirdParty(str, str2, bundle, iDisclaimerAgreementForThirdPartyResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public void requestRenewAccessTokenForAccount(String str, String str2, Bundle bundle, String str3, IAccessTokenResultCallback iAccessTokenResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iAccessTokenResultCallback != null ? iAccessTokenResultCallback.asBinder() : null);
                    if (this.mRemote.transact(20, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestRenewAccessTokenForAccount(str, str2, bundle, str3, iAccessTokenResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public void requestValidation(String str, String str2, Bundle bundle, IValidationResultCallback iValidationResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iValidationResultCallback != null ? iValidationResultCallback.asBinder() : null);
                    if (this.mRemote.transact(21, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestValidation(str, str2, bundle, iValidationResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.auth.IMobileServiceAuth
            public boolean setDisclaimerAgreementForSocial(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(28, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setDisclaimerAgreementForSocial(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMobileServiceAuth asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMobileServiceAuth)) ? new Proxy(iBinder) : (IMobileServiceAuth) iInterfaceQueryLocalInterface;
        }

        public static IMobileServiceAuth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMobileServiceAuth iMobileServiceAuth) {
            if (Proxy.sDefaultImpl != null || iMobileServiceAuth == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMobileServiceAuth;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
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
                    Intent intentForAccountAccessTokenRequest = getIntentForAccountAccessTokenRequest(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (intentForAccountAccessTokenRequest != null) {
                        parcel2.writeInt(1);
                        intentForAccountAccessTokenRequest.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountDisclaimerAgreement = getIntentForAccountDisclaimerAgreement(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (intentForAccountDisclaimerAgreement != null) {
                        parcel2.writeInt(1);
                        intentForAccountDisclaimerAgreement.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountPasswordConfirmation = getIntentForAccountPasswordConfirmation(parcel.readString());
                    parcel2.writeNoException();
                    if (intentForAccountPasswordConfirmation != null) {
                        parcel2.writeInt(1);
                        intentForAccountPasswordConfirmation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountPasswordConfirmationPopup = getIntentForAccountPasswordConfirmationPopup(parcel.readString());
                    parcel2.writeNoException();
                    if (intentForAccountPasswordConfirmationPopup != null) {
                        parcel2.writeInt(1);
                        intentForAccountPasswordConfirmationPopup.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountProfileModification = getIntentForAccountProfileModification(parcel.readString());
                    parcel2.writeNoException();
                    if (intentForAccountProfileModification != null) {
                        parcel2.writeInt(1);
                        intentForAccountProfileModification.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountSetupWizard = getIntentForAccountSetupWizard(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (intentForAccountSetupWizard != null) {
                        parcel2.writeInt(1);
                        intentForAccountSetupWizard.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountSignIn = getIntentForAccountSignIn();
                    parcel2.writeNoException();
                    if (intentForAccountSignIn != null) {
                        parcel2.writeInt(1);
                        intentForAccountSignIn.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountSignInPopup = getIntentForAccountSignInPopup();
                    parcel2.writeNoException();
                    if (intentForAccountSignInPopup != null) {
                        parcel2.writeInt(1);
                        intentForAccountSignInPopup.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForAccountValidationRequest = getIntentForAccountValidationRequest(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (intentForAccountValidationRequest != null) {
                        parcel2.writeInt(1);
                        intentForAccountValidationRequest.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForSocialDisclaimerAgreement = getIntentForSocialDisclaimerAgreement(parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (intentForSocialDisclaimerAgreement != null) {
                        parcel2.writeInt(1);
                        intentForSocialDisclaimerAgreement.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForSocialDisclaimerDisplay = getIntentForSocialDisclaimerDisplay();
                    parcel2.writeNoException();
                    if (intentForSocialDisclaimerDisplay != null) {
                        parcel2.writeInt(1);
                        intentForSocialDisclaimerDisplay.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForSocialRegistrationInformation = getIntentForSocialRegistrationInformation();
                    parcel2.writeNoException();
                    if (intentForSocialRegistrationInformation != null) {
                        parcel2.writeInt(1);
                        intentForSocialRegistrationInformation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForSocialSignUp = getIntentForSocialSignUp();
                    parcel2.writeNoException();
                    if (intentForSocialSignUp != null) {
                        parcel2.writeInt(1);
                        intentForSocialSignUp.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsServiceRegistered = isServiceRegistered(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsServiceRegistered ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestAccessTokenForAccount(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IAccessTokenResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestAuthCode(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IAuthCodeResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestAuthInfo(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IAuthResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle authInfoCached = getAuthInfoCached();
                    parcel2.writeNoException();
                    if (authInfoCached != null) {
                        parcel2.writeInt(1);
                        authInfoCached.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle deviceAuthInfoCached = getDeviceAuthInfoCached();
                    parcel2.writeNoException();
                    if (deviceAuthInfoCached != null) {
                        parcel2.writeInt(1);
                        deviceAuthInfoCached.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestRenewAccessTokenForAccount(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString(), IAccessTokenResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestValidation(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IValidationResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestDisclaimerAgreementForThirdParty(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IDisclaimerAgreementForThirdPartyResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean accountValidation = getAccountValidation();
                    parcel2.writeNoException();
                    parcel2.writeInt(accountValidation ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean disclaimerAgreementForSocial = getDisclaimerAgreementForSocial();
                    parcel2.writeNoException();
                    parcel2.writeInt(disclaimerAgreementForSocial ? 1 : 0);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean disclaimerAgreementForService = getDisclaimerAgreementForService(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(disclaimerAgreementForService ? 1 : 0);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean needToShowSocialTncPopup = getNeedToShowSocialTncPopup();
                    parcel2.writeNoException();
                    parcel2.writeInt(needToShowSocialTncPopup ? 1 : 0);
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    Intent intentForSocialTnC = getIntentForSocialTnC();
                    parcel2.writeNoException();
                    if (intentForSocialTnC != null) {
                        parcel2.writeInt(1);
                        intentForSocialTnC.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean disclaimerAgreementForSocial2 = setDisclaimerAgreementForSocial(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(disclaimerAgreementForSocial2 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean getAccountValidation();

    Bundle getAuthInfoCached();

    Bundle getDeviceAuthInfoCached();

    boolean getDisclaimerAgreementForService(int i);

    boolean getDisclaimerAgreementForSocial();

    Intent getIntentForAccountAccessTokenRequest(String str, String str2);

    Intent getIntentForAccountDisclaimerAgreement(String str, boolean z);

    Intent getIntentForAccountPasswordConfirmation(String str);

    Intent getIntentForAccountPasswordConfirmationPopup(String str);

    Intent getIntentForAccountProfileModification(String str);

    Intent getIntentForAccountSetupWizard(boolean z);

    Intent getIntentForAccountSignIn();

    Intent getIntentForAccountSignInPopup();

    Intent getIntentForAccountValidationRequest(String str, boolean z, boolean z2);

    Intent getIntentForSocialDisclaimerAgreement(boolean z, boolean z2);

    Intent getIntentForSocialDisclaimerDisplay();

    Intent getIntentForSocialRegistrationInformation();

    Intent getIntentForSocialSignUp();

    Intent getIntentForSocialTnC();

    boolean getNeedToShowSocialTncPopup();

    boolean isServiceRegistered(int i);

    void requestAccessTokenForAccount(String str, String str2, Bundle bundle, IAccessTokenResultCallback iAccessTokenResultCallback);

    void requestAuthCode(String str, String str2, Bundle bundle, IAuthCodeResultCallback iAuthCodeResultCallback);

    void requestAuthInfo(String str, String str2, Bundle bundle, IAuthResultCallback iAuthResultCallback);

    void requestDisclaimerAgreementForThirdParty(String str, String str2, Bundle bundle, IDisclaimerAgreementForThirdPartyResultCallback iDisclaimerAgreementForThirdPartyResultCallback);

    void requestRenewAccessTokenForAccount(String str, String str2, Bundle bundle, String str3, IAccessTokenResultCallback iAccessTokenResultCallback);

    void requestValidation(String str, String str2, Bundle bundle, IValidationResultCallback iValidationResultCallback);

    boolean setDisclaimerAgreementForSocial(boolean z);
}
