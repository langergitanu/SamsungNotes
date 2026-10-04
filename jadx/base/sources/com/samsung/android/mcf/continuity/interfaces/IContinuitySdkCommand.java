package com.samsung.android.mcf.continuity.interfaces;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IContinuitySdkCommand extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IContinuitySdkCommand {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand
        public int internalCommand(Message message) {
            return 0;
        }

        @Override // com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand
        public int internalCommandWithReturnValue(Message message, Bundle bundle) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IContinuitySdkCommand {
        private static final String DESCRIPTOR = "com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand";
        public static final int TRANSACTION_internalCommand = 1;
        public static final int TRANSACTION_internalCommandWithReturnValue = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IContinuitySdkCommand {
            public static IContinuitySdkCommand sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand
            public int internalCommand(Message message) {
                int iInternalCommand;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iInternalCommand = parcelObtain2.readInt();
                    } else {
                        iInternalCommand = Stub.getDefaultImpl().internalCommand(message);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iInternalCommand;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand
            public int internalCommandWithReturnValue(Message message, Bundle bundle) {
                int iInternalCommandWithReturnValue;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iInternalCommandWithReturnValue = parcelObtain2.readInt();
                        if (parcelObtain2.readInt() != 0) {
                            bundle.readFromParcel(parcelObtain2);
                        }
                    } else {
                        iInternalCommandWithReturnValue = Stub.getDefaultImpl().internalCommandWithReturnValue(message, bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iInternalCommandWithReturnValue;
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

        public static IContinuitySdkCommand asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IContinuitySdkCommand)) ? new Proxy(iBinder) : (IContinuitySdkCommand) iInterfaceQueryLocalInterface;
        }

        public static IContinuitySdkCommand getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IContinuitySdkCommand iContinuitySdkCommand) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iContinuitySdkCommand == null) {
                return false;
            }
            Proxy.sDefaultImpl = iContinuitySdkCommand;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int iInternalCommand = internalCommand(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(iInternalCommand);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            Message message = parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null;
            Bundle bundle = new Bundle();
            int iInternalCommandWithReturnValue = internalCommandWithReturnValue(message, bundle);
            parcel2.writeNoException();
            parcel2.writeInt(iInternalCommandWithReturnValue);
            parcel2.writeInt(1);
            bundle.writeToParcel(parcel2, 1);
            return true;
        }
    }

    int internalCommand(Message message);

    int internalCommandWithReturnValue(Message message, Bundle bundle);
}
