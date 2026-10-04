package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.reflect.content.SeslContextReflector;
import androidx.reflect.media.SeslAudioAttributesReflector;
import androidx.reflect.media.SeslRingtoneManagerReflector;
import androidx.reflect.p112os.SeslUserHandleReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslRingtonePreference extends Preference {
    private int mRingtoneType;
    private boolean mShowDefault;
    private boolean mShowSilent;
    private int mUserId;

    public SeslRingtonePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3711R.styleable.RingtonePreference, i, i2);
        this.mRingtoneType = typedArrayObtainStyledAttributes.getInt(C3711R.styleable.RingtonePreference_android_ringtoneType, 1);
        this.mShowDefault = typedArrayObtainStyledAttributes.getBoolean(C3711R.styleable.RingtonePreference_android_showDefault, true);
        this.mShowSilent = typedArrayObtainStyledAttributes.getBoolean(C3711R.styleable.RingtonePreference_android_showSilent, true);
        setIntent(new Intent("android.intent.action.RINGTONE_PICKER"));
        setUserId(SeslUserHandleReflector.myUserId());
        typedArrayObtainStyledAttributes.recycle();
    }

    @RequiresApi(api = 24)
    private Context createPackageContextAsUser(Context context, int i) {
        return SeslContextReflector.createPackageContextAsUser(context, context.getPackageName(), 0, UserHandle.getUserHandleForUid(i));
    }

    public int getRingtoneType() {
        return this.mRingtoneType;
    }

    public boolean getShowDefault() {
        return this.mShowDefault;
    }

    public boolean getShowSilent() {
        return this.mShowSilent;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (intent == null) {
            return true;
        }
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        if (!callChangeListener(uri != null ? uri.toString() : "")) {
            return true;
        }
        onSaveRingtone(uri);
        return true;
    }

    @Override // androidx.preference.Preference
    public void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public void onPrepareRingtonePickerIntent(Intent intent) {
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", onRestoreRingtone());
        intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", this.mShowDefault);
        if (this.mShowDefault) {
            intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(getRingtoneType()));
        }
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", this.mShowSilent);
        intent.putExtra("android.intent.extra.ringtone.TYPE", this.mRingtoneType);
        intent.putExtra("android.intent.extra.ringtone.TITLE", getTitle());
        intent.putExtra(SeslRingtoneManagerReflector.getField_EXTRA_RINGTONE_AUDIO_ATTRIBUTES_FLAGS(), SeslAudioAttributesReflector.getField_FLAG_BYPASS_INTERRUPTION_POLICY());
    }

    public Uri onRestoreRingtone() {
        String persistedString = getPersistedString(null);
        if (TextUtils.isEmpty(persistedString)) {
            return null;
        }
        return Uri.parse(persistedString);
    }

    public void onSaveRingtone(Uri uri) {
        persistString(uri != null ? uri.toString() : "");
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        String str = (String) obj;
        if (z || TextUtils.isEmpty(str)) {
            return;
        }
        onSaveRingtone(Uri.parse(str));
    }

    public void setRingtoneType(int i) {
        this.mRingtoneType = i;
    }

    public void setShowDefault(boolean z) {
        this.mShowDefault = z;
    }

    public void setShowSilent(boolean z) {
        this.mShowSilent = z;
    }

    public void setUserId(int i) {
        this.mUserId = i;
    }

    public SeslRingtonePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslRingtonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3711R.attr.ringtonePreferenceStyle);
    }

    public SeslRingtonePreference(Context context) {
        this(context, null);
    }
}
