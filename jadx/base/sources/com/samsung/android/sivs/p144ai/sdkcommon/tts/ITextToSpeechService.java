package com.samsung.android.sivs.p144ai.sdkcommon.tts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ITextToSpeechService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.tts.ITextToSpeechService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ITextToSpeechService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int createCustomVoiceSynthesizer(String str, int i, ISynthesizerInitCallback iSynthesizerInitCallback) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int createSynthesizer(String str, int i, ISynthesizerInitCallback iSynthesizerInitCallback) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public List<String> getAvailableCustomVoiceLocales(String str, int i) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public List<String> getAvailableLocales(String str, int i) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int getAvailableSynthesizerCount(String str, int i) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public String getCustomVoicePackageName(String str, int i, String str2) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public List<String> getSupportCustomVoiceLocales(String str, int i) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public List<String> getSupportLocales(String str, int i) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public Voice getVoice(String str, int i, String str2, String str3, String str4) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public List<Voice> getVoices(String str, int i) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public List<Voice> getVoicesWithLocale(String str, int i, String str2) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int isLanguageAvailable(String str, int i, String str2, String str3, String str4) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int releaseSynthesizer(String str, int i) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int removeCustomVoice(String str, int i, Voice voice) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int renameCustomVoice(String str, int i, Voice voice, String str2) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int setVoice(String str, int i, Voice voice) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int speak(String str, int i, Voice voice, CharSequence charSequence, int i2, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int stop(String str, int i) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int synthesize(String str, int i, Voice voice, CharSequence charSequence, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback) {
            return 0;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
        public int synthesizeToFile(String str, int i, Voice voice, CharSequence charSequence, ParcelFileDescriptor parcelFileDescriptor, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ITextToSpeechService {
        static final int TRANSACTION_createCustomVoiceSynthesizer = 15;
        static final int TRANSACTION_createSynthesizer = 7;
        static final int TRANSACTION_getAvailableCustomVoiceLocales = 16;
        static final int TRANSACTION_getAvailableLocales = 2;
        static final int TRANSACTION_getAvailableSynthesizerCount = 14;
        static final int TRANSACTION_getCustomVoicePackageName = 20;
        static final int TRANSACTION_getSupportCustomVoiceLocales = 17;
        static final int TRANSACTION_getSupportLocales = 1;
        static final int TRANSACTION_getVoice = 5;
        static final int TRANSACTION_getVoices = 3;
        static final int TRANSACTION_getVoicesWithLocale = 4;
        static final int TRANSACTION_isLanguageAvailable = 6;
        static final int TRANSACTION_releaseSynthesizer = 8;
        static final int TRANSACTION_removeCustomVoice = 18;
        static final int TRANSACTION_renameCustomVoice = 19;
        static final int TRANSACTION_setVoice = 9;
        static final int TRANSACTION_speak = 10;
        static final int TRANSACTION_stop = 13;
        static final int TRANSACTION_synthesize = 11;
        static final int TRANSACTION_synthesizeToFile = 12;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ITextToSpeechService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int createCustomVoiceSynthesizer(String str, int i, ISynthesizerInitCallback iSynthesizerInitCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iSynthesizerInitCallback);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int createSynthesizer(String str, int i, ISynthesizerInitCallback iSynthesizerInitCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongInterface(iSynthesizerInitCallback);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public List<String> getAvailableCustomVoiceLocales(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public List<String> getAvailableLocales(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int getAvailableSynthesizerCount(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public String getCustomVoicePackageName(String str, int i, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ITextToSpeechService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public List<String> getSupportCustomVoiceLocales(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public List<String> getSupportLocales(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public Voice getVoice(String str, int i, String str2, String str3, String str4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Voice) _Parcel.readTypedObject(parcelObtain2, Voice.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public List<Voice> getVoices(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Voice.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public List<Voice> getVoicesWithLocale(String str, int i, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Voice.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int isLanguageAvailable(String str, int i, String str2, String str3, String str4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int releaseSynthesizer(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int removeCustomVoice(String str, int i, Voice voice) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, voice, 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int renameCustomVoice(String str, int i, Voice voice, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, voice, 0);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int setVoice(String str, int i, Voice voice) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, voice, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int speak(String str, int i, Voice voice, CharSequence charSequence, int i2, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, voice, 0);
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iSynthesisCallback);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i4 = parcelObtain2.readInt();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return i4;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int stop(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int synthesize(String str, int i, Voice voice, CharSequence charSequence, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, voice, 0);
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iSynthesisCallback);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return i2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService
            public int synthesizeToFile(String str, int i, Voice voice, CharSequence charSequence, ParcelFileDescriptor parcelFileDescriptor, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITextToSpeechService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, voice, 0);
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iSynthesisCallback);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return i2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, ITextToSpeechService.DESCRIPTOR);
        }

        public static ITextToSpeechService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITextToSpeechService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITextToSpeechService)) ? new Proxy(iBinder) : (ITextToSpeechService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITextToSpeechService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITextToSpeechService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    List<String> supportLocales = getSupportLocales(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringList(supportLocales);
                    return true;
                case 2:
                    List<String> availableLocales = getAvailableLocales(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringList(availableLocales);
                    return true;
                case 3:
                    List<Voice> voices = getVoices(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    _Parcel.writeTypedList(parcel2, voices, 1);
                    return true;
                case 4:
                    List<Voice> voicesWithLocale = getVoicesWithLocale(parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    _Parcel.writeTypedList(parcel2, voicesWithLocale, 1);
                    return true;
                case 5:
                    Voice voice = getVoice(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, voice, 1);
                    return true;
                case 6:
                    int iIsLanguageAvailable = isLanguageAvailable(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iIsLanguageAvailable);
                    return true;
                case 7:
                    int iCreateSynthesizer = createSynthesizer(parcel.readString(), parcel.readInt(), ISynthesizerInitCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateSynthesizer);
                    return true;
                case 8:
                    int iReleaseSynthesizer = releaseSynthesizer(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iReleaseSynthesizer);
                    return true;
                case 9:
                    int voice2 = setVoice(parcel.readString(), parcel.readInt(), (Voice) _Parcel.readTypedObject(parcel, Voice.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(voice2);
                    return true;
                case 10:
                    int iSpeak = speak(parcel.readString(), parcel.readInt(), (Voice) _Parcel.readTypedObject(parcel, Voice.CREATOR), (CharSequence) _Parcel.readTypedObject(parcel, TextUtils.CHAR_SEQUENCE_CREATOR), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readString(), ISynthesisCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iSpeak);
                    return true;
                case 11:
                    int iSynthesize = synthesize(parcel.readString(), parcel.readInt(), (Voice) _Parcel.readTypedObject(parcel, Voice.CREATOR), (CharSequence) _Parcel.readTypedObject(parcel, TextUtils.CHAR_SEQUENCE_CREATOR), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readString(), ISynthesisCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iSynthesize);
                    return true;
                case 12:
                    int iSynthesizeToFile = synthesizeToFile(parcel.readString(), parcel.readInt(), (Voice) _Parcel.readTypedObject(parcel, Voice.CREATOR), (CharSequence) _Parcel.readTypedObject(parcel, TextUtils.CHAR_SEQUENCE_CREATOR), (ParcelFileDescriptor) _Parcel.readTypedObject(parcel, ParcelFileDescriptor.CREATOR), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readString(), ISynthesisCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iSynthesizeToFile);
                    return true;
                case 13:
                    int iStop = stop(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iStop);
                    return true;
                case 14:
                    int availableSynthesizerCount = getAvailableSynthesizerCount(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(availableSynthesizerCount);
                    return true;
                case 15:
                    int iCreateCustomVoiceSynthesizer = createCustomVoiceSynthesizer(parcel.readString(), parcel.readInt(), ISynthesizerInitCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateCustomVoiceSynthesizer);
                    return true;
                case 16:
                    List<String> availableCustomVoiceLocales = getAvailableCustomVoiceLocales(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringList(availableCustomVoiceLocales);
                    return true;
                case 17:
                    List<String> supportCustomVoiceLocales = getSupportCustomVoiceLocales(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringList(supportCustomVoiceLocales);
                    return true;
                case 18:
                    int iRemoveCustomVoice = removeCustomVoice(parcel.readString(), parcel.readInt(), (Voice) _Parcel.readTypedObject(parcel, Voice.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRemoveCustomVoice);
                    return true;
                case 19:
                    int iRenameCustomVoice = renameCustomVoice(parcel.readString(), parcel.readInt(), (Voice) _Parcel.readTypedObject(parcel, Voice.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iRenameCustomVoice);
                    return true;
                case 20:
                    String customVoicePackageName = getCustomVoicePackageName(parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(customVoicePackageName);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
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

    int createCustomVoiceSynthesizer(String str, int i, ISynthesizerInitCallback iSynthesizerInitCallback);

    int createSynthesizer(String str, int i, ISynthesizerInitCallback iSynthesizerInitCallback);

    List<String> getAvailableCustomVoiceLocales(String str, int i);

    List<String> getAvailableLocales(String str, int i);

    int getAvailableSynthesizerCount(String str, int i);

    String getCustomVoicePackageName(String str, int i, String str2);

    List<String> getSupportCustomVoiceLocales(String str, int i);

    List<String> getSupportLocales(String str, int i);

    Voice getVoice(String str, int i, String str2, String str3, String str4);

    List<Voice> getVoices(String str, int i);

    List<Voice> getVoicesWithLocale(String str, int i, String str2);

    int isLanguageAvailable(String str, int i, String str2, String str3, String str4);

    int releaseSynthesizer(String str, int i);

    int removeCustomVoice(String str, int i, Voice voice);

    int renameCustomVoice(String str, int i, Voice voice, String str2);

    int setVoice(String str, int i, Voice voice);

    int speak(String str, int i, Voice voice, CharSequence charSequence, int i2, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback);

    int stop(String str, int i);

    int synthesize(String str, int i, Voice voice, CharSequence charSequence, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback);

    int synthesizeToFile(String str, int i, Voice voice, CharSequence charSequence, ParcelFileDescriptor parcelFileDescriptor, Bundle bundle, String str2, ISynthesisCallback iSynthesisCallback);
}
