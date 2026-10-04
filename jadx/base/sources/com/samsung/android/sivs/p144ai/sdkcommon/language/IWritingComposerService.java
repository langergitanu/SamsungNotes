package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IWritingComposerService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.IWritingComposerService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IWritingComposerService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
        public void compose(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, String str3, String str4, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
        public void compose2(Map<String, String> map, String str, List<String> list, List<ParcelFileDescriptor> list2, String str2, String str3, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
        public void composeDynamicStyle(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, String str3, String str4, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
        public void unLoadModel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IWritingComposerService {
        static final int TRANSACTION_compose = 1;
        static final int TRANSACTION_compose2 = 4;
        static final int TRANSACTION_composeDynamicStyle = 3;
        static final int TRANSACTION_unLoadModel = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IWritingComposerService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$compose$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$compose$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$compose2$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$compose2$5(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$composeDynamicStyle$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$composeDynamicStyle$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
            public void compose(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, String str3, String str4, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWritingComposerService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7920h(parcelObtain, 0));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7920h(parcelObtain, 1));
                    }
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
            public void compose2(Map<String, String> map, String str, List<String> list, List<ParcelFileDescriptor> list2, String str2, String str3, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWritingComposerService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7920h(parcelObtain, 2));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7920h(parcelObtain, 3));
                    }
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
            public void composeDynamicStyle(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, String str3, String str4, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWritingComposerService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 28));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 29));
                    }
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return IWritingComposerService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService
            public void unLoadModel() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWritingComposerService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IWritingComposerService.DESCRIPTOR);
        }

        public static IWritingComposerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWritingComposerService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IWritingComposerService)) ? new Proxy(iBinder) : (IWritingComposerService) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$0(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$1(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$2(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$3(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$4(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$5(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, final Parcel parcel, Parcel parcel2, int i2) {
            final HashMap map;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWritingComposerService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWritingComposerService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int i4 = parcel.readInt();
                HashMap map2 = i4 < 0 ? null : new HashMap();
                IntStream.range(0, i4).forEach(new C7917e(parcel, map2, 28));
                String string = parcel.readString();
                String string2 = parcel.readString();
                Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) _Parcel.m7064a(parcel);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                int i5 = parcel.readInt();
                ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                map = i6 >= 0 ? new HashMap() : null;
                IntStream.range(0, i6).forEach(new C7917e(parcel, map, 29));
                compose(map2, string, string2, parcelFileDescriptor, string3, string4, i5, iLlmServiceObserver2AsInterface, map);
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                unLoadModel();
                return true;
            }
            if (i == 3) {
                int i7 = parcel.readInt();
                final HashMap map3 = i7 < 0 ? null : new HashMap();
                final int i8 = 0;
                IntStream.range(0, i7).forEach(new IntConsumer() { // from class: com.samsung.android.sivs.ai.sdkcommon.language.g
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i9) {
                        switch (i8) {
                            case 0:
                                IWritingComposerService.Stub.lambda$onTransact$2(parcel, map3, i9);
                                break;
                            case 1:
                                IWritingComposerService.Stub.lambda$onTransact$3(parcel, map3, i9);
                                break;
                            case 2:
                                IWritingComposerService.Stub.lambda$onTransact$4(parcel, map3, i9);
                                break;
                            default:
                                IWritingComposerService.Stub.lambda$onTransact$5(parcel, map3, i9);
                                break;
                        }
                    }
                });
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                Parcelable.Creator creator2 = ParcelFileDescriptor.CREATOR;
                ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) _Parcel.m7064a(parcel);
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                int i9 = parcel.readInt();
                ILlmServiceObserver2 iLlmServiceObserver2AsInterface2 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                map = i10 >= 0 ? new HashMap() : null;
                final int i11 = 1;
                IntStream.range(0, i10).forEach(new IntConsumer() { // from class: com.samsung.android.sivs.ai.sdkcommon.language.g
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i92) {
                        switch (i11) {
                            case 0:
                                IWritingComposerService.Stub.lambda$onTransact$2(parcel, map, i92);
                                break;
                            case 1:
                                IWritingComposerService.Stub.lambda$onTransact$3(parcel, map, i92);
                                break;
                            case 2:
                                IWritingComposerService.Stub.lambda$onTransact$4(parcel, map, i92);
                                break;
                            default:
                                IWritingComposerService.Stub.lambda$onTransact$5(parcel, map, i92);
                                break;
                        }
                    }
                });
                composeDynamicStyle(map3, string5, string6, parcelFileDescriptor2, string7, string8, i9, iLlmServiceObserver2AsInterface2, map);
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            int i12 = parcel.readInt();
            final HashMap map4 = i12 < 0 ? null : new HashMap();
            final int i13 = 2;
            IntStream.range(0, i12).forEach(new IntConsumer() { // from class: com.samsung.android.sivs.ai.sdkcommon.language.g
                @Override // java.util.function.IntConsumer
                public final void accept(int i92) {
                    switch (i13) {
                        case 0:
                            IWritingComposerService.Stub.lambda$onTransact$2(parcel, map4, i92);
                            break;
                        case 1:
                            IWritingComposerService.Stub.lambda$onTransact$3(parcel, map4, i92);
                            break;
                        case 2:
                            IWritingComposerService.Stub.lambda$onTransact$4(parcel, map4, i92);
                            break;
                        default:
                            IWritingComposerService.Stub.lambda$onTransact$5(parcel, map4, i92);
                            break;
                    }
                }
            });
            String string9 = parcel.readString();
            List<String> listCreateStringArrayList = parcel.createStringArrayList();
            List<ParcelFileDescriptor> listCreateTypedArrayList = parcel.createTypedArrayList(ParcelFileDescriptor.CREATOR);
            String string10 = parcel.readString();
            String string11 = parcel.readString();
            int i14 = parcel.readInt();
            ILlmServiceObserver2 iLlmServiceObserver2AsInterface3 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
            int i15 = parcel.readInt();
            final HashMap map5 = i15 >= 0 ? new HashMap() : null;
            final int i16 = 3;
            IntStream.range(0, i15).forEach(new IntConsumer() { // from class: com.samsung.android.sivs.ai.sdkcommon.language.g
                @Override // java.util.function.IntConsumer
                public final void accept(int i92) {
                    switch (i16) {
                        case 0:
                            IWritingComposerService.Stub.lambda$onTransact$2(parcel, map5, i92);
                            break;
                        case 1:
                            IWritingComposerService.Stub.lambda$onTransact$3(parcel, map5, i92);
                            break;
                        case 2:
                            IWritingComposerService.Stub.lambda$onTransact$4(parcel, map5, i92);
                            break;
                        default:
                            IWritingComposerService.Stub.lambda$onTransact$5(parcel, map5, i92);
                            break;
                    }
                }
            });
            compose2(map4, string9, listCreateStringArrayList, listCreateTypedArrayList, string10, string11, i14, iLlmServiceObserver2AsInterface3, map5);
            parcel2.writeNoException();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m7064a(Parcel parcel) {
            return readTypedObject(parcel, ParcelFileDescriptor.CREATOR);
        }

        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                writeTypedObject(parcel, list.get(i2), i);
            }
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

    void compose(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, String str3, String str4, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void compose2(Map<String, String> map, String str, List<String> list, List<ParcelFileDescriptor> list2, String str2, String str3, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void composeDynamicStyle(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, String str3, String str4, int i, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void unLoadModel();
}
