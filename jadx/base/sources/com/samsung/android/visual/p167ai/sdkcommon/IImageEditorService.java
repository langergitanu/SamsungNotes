package com.samsung.android.visual.p167ai.sdkcommon;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IImageEditorService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.visual.ai.sdkcommon.IImageEditorService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IImageEditorService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
        public Bundle cancel(int i, Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
        public Bundle generate(int i, Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
        public void prepare(int i) {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
        public void release(int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IImageEditorService {
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_generate = 2;
        static final int TRANSACTION_prepare = 1;
        static final int TRANSACTION_release = 4;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IImageEditorService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
            public Bundle cancel(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageEditorService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m12856a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
            public Bundle generate(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageEditorService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m12856a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IImageEditorService.DESCRIPTOR;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
            public void prepare(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageEditorService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService
            public void release(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageEditorService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IImageEditorService.DESCRIPTOR);
        }

        public static IImageEditorService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IImageEditorService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IImageEditorService)) ? new Proxy(iBinder) : (IImageEditorService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IImageEditorService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IImageEditorService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                prepare(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                int i4 = parcel.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundleGenerate = generate(i4, (Bundle) _Parcel.m12856a(parcel));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleGenerate, 1);
                return true;
            }
            if (i != 3) {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                release(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            int i5 = parcel.readInt();
            Parcelable.Creator creator2 = Bundle.CREATOR;
            Bundle bundleCancel = cancel(i5, (Bundle) _Parcel.m12856a(parcel));
            parcel2.writeNoException();
            _Parcel.writeTypedObject(parcel2, bundleCancel, 1);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m12856a(Parcel parcel) {
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

    Bundle cancel(int i, Bundle bundle);

    Bundle generate(int i, Bundle bundle);

    void prepare(int i);

    void release(int i);
}
