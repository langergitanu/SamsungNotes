package com.samsung.android.sivs.p144ai.sdkcommon.tts;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new Parcelable.Creator<Voice>() { // from class: com.samsung.android.sivs.ai.sdkcommon.tts.Voice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Voice createFromParcel(Parcel parcel) {
            return new Voice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Voice[] newArray(int i) {
            return new Voice[i];
        }
    };
    public static final String KEY_FEATURE_BOOL_IS_AI_VOICE = "KEY_FEATURE_BOOL_IS_AI_VOICE";
    public static final String KEY_FEATURE_BOOL_IS_BIXBY_VOICE = "KEY_FEATURE_BOOL_IS_BIXBY_VOICE";
    public static final String KEY_FEATURE_BOOL_IS_PERSONAL_TTS = "KEY_FEATURE_BOOL_IS_PERSONAL_TTS";
    public static final String KEY_FEATURE_BOOL_IS_SERVER_TTS = "KEY_FEATURE_BOOL_IS_SERVER_TTS";
    public static final String KEY_FEATURE_BOOL_REQUIRES_AUTHORIZATION = "KEY_FEATURE_BOOL_REQUIRES_AUTHORIZATION";
    public static final String KEY_FEATURE_INT_VERSION_CODE = "KEY_FEATURE_INT_VERSION_CODE";
    public static final String KEY_FEATURE_STRING_MODEL_TYPE = "KEY_FEATURE_STRING_MODEL_TYPE";
    public static final String KEY_FEATURE_STRING_PACKAGE_NAME = "KEY_FEATURE_STRING_PACKAGE_NAME";
    public static final String KEY_FEATURE_STRING_PERSONAL_TTS_STATUS = "KEY_FEATURE_STRING_PERSONAL_TTS_STATUS";
    public static final String KEY_FEATURE_STRING_PERSONAL_TTS_UID = "KEY_FEATURE_STRING_PERSONAL_TTS_UID";
    public static final String KEY_FEATURE_STRING_VERSION_NAME = "KEY_FEATURE_STRING_VERSION_NAME";
    public static final String KEY_FEATURE_STRING_VOICE_NAME = "KEY_FEATURE_STRING_VOICE_NAME";
    private Bundle mFeatures;
    private Locale mLocale;
    private String mTag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum eCUSTOM_VOICE_STATUS {
        IDLE,
        ON_TRAINING,
        TRAINING_DONE,
        UNKNOWN,
        NOT_CUSTOM_VOICE
    }

    public Voice(String str, Locale locale, Bundle bundle) {
        this.mTag = str;
        this.mLocale = locale;
        this.mFeatures = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public eCUSTOM_VOICE_STATUS getCustomVoiceStatus() {
        if (isCustomVoice()) {
            try {
                return eCUSTOM_VOICE_STATUS.valueOf(getFeatures().getString(KEY_FEATURE_STRING_PERSONAL_TTS_STATUS, eCUSTOM_VOICE_STATUS.UNKNOWN.name()));
            } catch (Exception unused) {
            }
        }
        return eCUSTOM_VOICE_STATUS.NOT_CUSTOM_VOICE;
    }

    public Bundle getFeatures() {
        return this.mFeatures;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public String getLocaleISO3Code() {
        if (this.mLocale == null) {
            return null;
        }
        return this.mLocale.getISO3Language() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.mLocale.getISO3Country();
    }

    public String getLocaleISOCode() {
        if (this.mLocale == null) {
            return null;
        }
        return this.mLocale.getLanguage() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.mLocale.getCountry();
    }

    public String getPackageName() {
        if (getFeatures() != null) {
            return getFeatures().getString(KEY_FEATURE_STRING_PACKAGE_NAME, null);
        }
        return null;
    }

    public String getTag() {
        return this.mTag;
    }

    public String getVariant() {
        Locale locale = this.mLocale;
        if (locale != null) {
            return locale.getVariant();
        }
        return null;
    }

    public int getVersionCode() {
        if (getFeatures() != null) {
            return getFeatures().getInt(KEY_FEATURE_INT_VERSION_CODE, -1);
        }
        return -1;
    }

    public String getVersionName() {
        if (getFeatures() != null) {
            return getFeatures().getString(KEY_FEATURE_STRING_VERSION_NAME, null);
        }
        return null;
    }

    public String getVoiceName() {
        return getFeatures() != null ? getFeatures().getString(KEY_FEATURE_STRING_VOICE_NAME, "unknown") : "unknown";
    }

    public boolean isCustomVoice() {
        return getFeatures().getBoolean(KEY_FEATURE_BOOL_IS_PERSONAL_TTS, false);
    }

    public String toString() {
        Locale locale = this.mLocale;
        return locale != null ? AbstractC2322a.m1622l(locale.getISO3Language(), CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, this.mLocale.getISO3Country(), CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, this.mLocale.getVariant()) : "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTag);
        parcel.writeSerializable(this.mLocale);
        parcel.writeBundle(this.mFeatures);
    }

    public Voice(Parcel parcel) {
        this.mTag = parcel.readString();
        if (Build.VERSION.SDK_INT >= 33) {
            this.mLocale = (Locale) parcel.readSerializable(Locale.class.getClassLoader(), Locale.class);
        } else {
            this.mLocale = (Locale) parcel.readSerializable();
        }
        this.mFeatures = parcel.readBundle();
    }
}
