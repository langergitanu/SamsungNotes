package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IExtractionService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.IExtractionService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IExtractionService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void extractor(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void extractor2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void extractor3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void extractorMultiModal(Map<String, String> map, String str, String str2, String str3, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void extractorMultiModal2(Map<String, String> map, String str, String str2, List<String> list, List<ParcelFileDescriptor> list2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void extractorMultiModalOnDeviceOnly(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
        public void unLoadModel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IExtractionService {
        static final int TRANSACTION_extractor = 1;
        static final int TRANSACTION_extractor2 = 2;
        static final int TRANSACTION_extractor3 = 3;
        static final int TRANSACTION_extractorMultiModal = 6;
        static final int TRANSACTION_extractorMultiModal2 = 7;
        static final int TRANSACTION_extractorMultiModalOnDeviceOnly = 4;
        static final int TRANSACTION_unLoadModel = 5;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IExtractionService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractor$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractor2$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractor3$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractor3$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractorMultiModal$6(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractorMultiModal$7(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractorMultiModal2$8(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractorMultiModal2$9(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractorMultiModalOnDeviceOnly$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$extractorMultiModalOnDeviceOnly$5(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void extractor(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 20));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void extractor2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 23));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void extractor3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 21));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 22));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void extractorMultiModal(Map<String, String> map, String str, String str2, String str3, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 28));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 29));
                    }
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void extractorMultiModal2(Map<String, String> map, String str, String str2, List<String> list, List<ParcelFileDescriptor> list2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 26));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 27));
                    }
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void extractorMultiModalOnDeviceOnly(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 24));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 25));
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

            public String getInterfaceDescriptor() {
                return IExtractionService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IExtractionService
            public void unLoadModel() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IExtractionService.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IExtractionService.DESCRIPTOR);
        }

        public static IExtractionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IExtractionService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IExtractionService)) ? new Proxy(iBinder) : (IExtractionService) iInterfaceQueryLocalInterface;
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$6(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$7(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$8(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$9(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IExtractionService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IExtractionService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int i4 = parcel.readInt();
                    HashMap map = i4 < 0 ? null : new HashMap();
                    IntStream.range(0, i4).forEach(new C7913a(parcel, map, 20));
                    extractor(map, parcel.readString(), parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int i5 = parcel.readInt();
                    HashMap map2 = i5 < 0 ? null : new HashMap();
                    IntStream.range(0, i5).forEach(new C7913a(parcel, map2, 21));
                    extractor2(map2, parcel.readString(), parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    HashMap map3 = null;
                    int i6 = parcel.readInt();
                    HashMap map4 = i6 < 0 ? null : new HashMap();
                    IntStream.range(0, i6).forEach(new C7913a(parcel, map4, 22));
                    String string = parcel.readString();
                    Map<String, String> map5 = map4;
                    String string2 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i7 = parcel.readInt();
                    if (i7 >= 0) {
                        map3 = new HashMap();
                    }
                    IntStream.range(0, i7).forEach(new C7913a(parcel, map3, 23));
                    extractor3(map5, string, string2, iLlmServiceObserver2AsInterface, map3);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    HashMap map6 = null;
                    int i8 = parcel.readInt();
                    HashMap map7 = i8 < 0 ? null : new HashMap();
                    IntStream.range(0, i8).forEach(new C7913a(parcel, map7, 24));
                    String string3 = parcel.readString();
                    Map<String, String> map8 = map7;
                    String string4 = parcel.readString();
                    Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
                    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) _Parcel.m6926a(parcel);
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface2 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i9 = parcel.readInt();
                    if (i9 >= 0) {
                        map6 = new HashMap();
                    }
                    IntStream.range(0, i9).forEach(new C7913a(parcel, map6, 25));
                    extractorMultiModalOnDeviceOnly(map8, string3, string4, parcelFileDescriptor, iLlmServiceObserver2AsInterface2, map6);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    unLoadModel();
                    return true;
                case 6:
                    HashMap map9 = null;
                    int i10 = parcel.readInt();
                    HashMap map10 = i10 < 0 ? null : new HashMap();
                    IntStream.range(0, i10).forEach(new C7913a(parcel, map10, 26));
                    String string5 = parcel.readString();
                    Map<String, String> map11 = map10;
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    Parcelable.Creator creator2 = ParcelFileDescriptor.CREATOR;
                    ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) _Parcel.m6926a(parcel);
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface3 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i11 = parcel.readInt();
                    if (i11 >= 0) {
                        map9 = new HashMap();
                    }
                    IntStream.range(0, i11).forEach(new C7913a(parcel, map9, 27));
                    extractorMultiModal(map11, string5, string6, string7, parcelFileDescriptor2, iLlmServiceObserver2AsInterface3, map9);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    int i12 = parcel.readInt();
                    HashMap map12 = i12 < 0 ? null : new HashMap();
                    IntStream.range(0, i12).forEach(new C7913a(parcel, map12, 28));
                    String string8 = parcel.readString();
                    HashMap map13 = null;
                    String string9 = parcel.readString();
                    Map<String, String> map14 = map12;
                    List<String> listCreateStringArrayList = parcel.createStringArrayList();
                    List<ParcelFileDescriptor> listCreateTypedArrayList = parcel.createTypedArrayList(ParcelFileDescriptor.CREATOR);
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface4 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i13 = parcel.readInt();
                    if (i13 >= 0) {
                        map13 = new HashMap();
                    }
                    IntStream.range(0, i13).forEach(new C7913a(parcel, map13, 29));
                    extractorMultiModal2(map14, string8, string9, listCreateStringArrayList, listCreateTypedArrayList, iLlmServiceObserver2AsInterface4, map13);
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
        public static /* bridge */ /* synthetic */ Object m6926a(Parcel parcel) {
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

    void extractor(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver);

    void extractor2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2);

    void extractor3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void extractorMultiModal(Map<String, String> map, String str, String str2, String str3, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void extractorMultiModal2(Map<String, String> map, String str, String str2, List<String> list, List<ParcelFileDescriptor> list2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void extractorMultiModalOnDeviceOnly(Map<String, String> map, String str, String str2, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void unLoadModel();
}
