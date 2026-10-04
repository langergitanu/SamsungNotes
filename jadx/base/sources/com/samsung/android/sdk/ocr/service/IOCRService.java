package com.samsung.android.sdk.ocr.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IOCRService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sdk.ocr.service.IOCRService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IOCRService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public void cancel(Bundle bundle) {
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public void close(Bundle bundle) {
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public Bundle detect(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public Bundle detectBlock(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public boolean detectText(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public boolean hasText(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public boolean initialize(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public boolean isHandwritten(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public boolean isPrinted(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public boolean isSupported(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public Bundle recognize(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sdk.ocr.service.IOCRService
        public Bundle recognizeBlockAt(Bundle bundle) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IOCRService {
        static final int TRANSACTION_cancel = 12;
        static final int TRANSACTION_close = 3;
        static final int TRANSACTION_detect = 8;
        static final int TRANSACTION_detectBlock = 9;
        static final int TRANSACTION_detectText = 7;
        static final int TRANSACTION_hasText = 6;
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_isHandwritten = 5;
        static final int TRANSACTION_isPrinted = 4;
        static final int TRANSACTION_isSupported = 2;
        static final int TRANSACTION_recognize = 10;
        static final int TRANSACTION_recognizeBlockAt = 11;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IOCRService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public void cancel(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public void close(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public Bundle detect(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m5791a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public Bundle detectBlock(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m5791a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public boolean detectText(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IOCRService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public boolean hasText(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public boolean initialize(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public boolean isHandwritten(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public boolean isPrinted(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public boolean isSupported(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public Bundle recognize(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m5791a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.ocr.service.IOCRService
            public Bundle recognizeBlockAt(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m5791a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOCRService.DESCRIPTOR);
        }

        public static IOCRService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOCRService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOCRService)) ? new Proxy(iBinder) : (IOCRService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOCRService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOCRService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zInitialize = initialize((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zInitialize ? 1 : 0);
                    return true;
                case 2:
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    boolean zIsSupported = isSupported((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupported ? 1 : 0);
                    return true;
                case 3:
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    close((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    boolean zIsPrinted = isPrinted((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsPrinted ? 1 : 0);
                    return true;
                case 5:
                    Parcelable.Creator creator5 = Bundle.CREATOR;
                    boolean zIsHandwritten = isHandwritten((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsHandwritten ? 1 : 0);
                    return true;
                case 6:
                    Parcelable.Creator creator6 = Bundle.CREATOR;
                    boolean zHasText = hasText((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zHasText ? 1 : 0);
                    return true;
                case 7:
                    Parcelable.Creator creator7 = Bundle.CREATOR;
                    boolean zDetectText = detectText((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zDetectText ? 1 : 0);
                    return true;
                case 8:
                    Parcelable.Creator creator8 = Bundle.CREATOR;
                    Bundle bundleDetect = detect((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleDetect, 1);
                    return true;
                case 9:
                    Parcelable.Creator creator9 = Bundle.CREATOR;
                    Bundle bundleDetectBlock = detectBlock((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleDetectBlock, 1);
                    return true;
                case 10:
                    Parcelable.Creator creator10 = Bundle.CREATOR;
                    Bundle bundleRecognize = recognize((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleRecognize, 1);
                    return true;
                case 11:
                    Parcelable.Creator creator11 = Bundle.CREATOR;
                    Bundle bundleRecognizeBlockAt = recognizeBlockAt((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleRecognizeBlockAt, 1);
                    return true;
                case 12:
                    Parcelable.Creator creator12 = Bundle.CREATOR;
                    cancel((Bundle) _Parcel.m5791a(parcel));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m5791a(Parcel parcel) {
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

    void cancel(Bundle bundle);

    void close(Bundle bundle);

    Bundle detect(Bundle bundle);

    Bundle detectBlock(Bundle bundle);

    boolean detectText(Bundle bundle);

    boolean hasText(Bundle bundle);

    boolean initialize(Bundle bundle);

    boolean isHandwritten(Bundle bundle);

    boolean isPrinted(Bundle bundle);

    boolean isSupported(Bundle bundle);

    Bundle recognize(Bundle bundle);

    Bundle recognizeBlockAt(Bundle bundle);
}
