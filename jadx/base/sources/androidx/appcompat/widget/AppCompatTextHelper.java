package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.C0419R;
import androidx.collection.LruCache;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Pair;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.microsoft.identity.common.java.WarningType;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;

    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;

    @NonNull
    private final TextView mView;
    private int mStyle = 0;
    private int mFontWeight = -1;

    @Nullable
    private String mFontVariationSettings = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(26)
    public static class Api26Impl {

        @Nullable
        private static Paint sPaint;
        private static final LruCache<Pair<Typeface, String>, Typeface> sVariationsCache = new LruCache<>(30);

        private Api26Impl() {
        }

        @Nullable
        @UiThread
        public static Typeface createVariationInstance(@Nullable Typeface typeface, @Nullable String str) {
            Pair<Typeface, String> pair = new Pair<>(typeface, str);
            LruCache<Pair<Typeface, String>, Typeface> lruCache = sVariationsCache;
            Typeface typeface2 = lruCache.get(pair);
            if (typeface2 != null) {
                return typeface2;
            }
            Paint paint = sPaint;
            if (paint == null) {
                paint = new Paint();
                sPaint = paint;
            }
            if (Objects.equals(paint.getFontVariationSettings(), str)) {
                paint.setFontVariationSettings(null);
            }
            paint.setTypeface(typeface);
            if (!paint.setFontVariationSettings(str)) {
                return null;
            }
            Typeface typeface3 = paint.getTypeface();
            lruCache.put(pair, typeface3);
            return typeface3;
        }

        public static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static String getFontVariationSettings(TextView textView) {
            return textView.getFontVariationSettings();
        }

        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i4, i5);
        }

        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        public static boolean setFontVariationSettings(TextView textView, String str) {
            if (Objects.equals(textView.getFontVariationSettings(), str)) {
                textView.setFontVariationSettings("");
            }
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Typeface create(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public AppCompatTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
    }

    private void applyFontAndVariationSettings(boolean z) {
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                this.mView.setTypeface(typeface, this.mStyle);
            } else {
                this.mView.setTypeface(typeface);
            }
        } else if (z) {
            this.mView.setTypeface(null);
        }
        String str = this.mFontVariationSettings;
        if (str != null) {
            Api26Impl.setFontVariationSettings(this.mView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyNewTypefacePreservingVariationSettings(TextView textView, Typeface typeface, int i) {
        String fontVariationSettings = Api26Impl.getFontVariationSettings(textView);
        if (!TextUtils.isEmpty(fontVariationSettings)) {
            Api26Impl.setFontVariationSettings(textView, null);
        }
        textView.setTypeface(typeface, i);
        if (TextUtils.isEmpty(fontVariationSettings)) {
            return;
        }
        Api26Impl.setFontVariationSettings(textView, fontVariationSettings);
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    @NonNull
    private ResourcesCompat.FontCallback makeFontCallback(final int i, final int i2) {
        final WeakReference weakReference = new WeakReference(this.mView);
        return new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
            @Override // androidx.core.content.res.ResourcesCompat.FontCallback
            /* JADX INFO: renamed from: onFontRetrieved */
            public void lambda$callbackSuccessAsync$0(@NonNull Typeface typeface) {
                int i4;
                if (Build.VERSION.SDK_INT >= 28 && (i4 = i) != -1) {
                    typeface = Api28Impl.create(typeface, i4, (i2 & 2) != 0);
                }
                AppCompatTextHelper.this.onAsyncTypefaceReceived(weakReference, typeface);
            }

            @Override // androidx.core.content.res.ResourcesCompat.FontCallback
            /* JADX INFO: renamed from: onFontRetrievalFailed */
            public void lambda$callbackFailAsync$1(int i4) {
            }
        };
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.mView;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.mView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
        TextView textView2 = this.mView;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    private boolean updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        int i;
        Typeface typeface;
        this.mStyle = tintTypedArray.getInt(C0419R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i4 = tintTypedArray.getInt(C0419R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i4;
            if (i4 != -1) {
                this.mStyle &= 2;
            }
        }
        if (tintTypedArray.hasValue(C0419R.styleable.TextAppearance_fontVariationSettings)) {
            this.mFontVariationSettings = tintTypedArray.getString(C0419R.styleable.TextAppearance_fontVariationSettings);
        }
        if (!tintTypedArray.hasValue(C0419R.styleable.TextAppearance_android_fontFamily) && !tintTypedArray.hasValue(C0419R.styleable.TextAppearance_fontFamily)) {
            if (!tintTypedArray.hasValue(C0419R.styleable.TextAppearance_android_typeface)) {
                if (i2 < 28 || (i = this.mFontWeight) == -1 || (typeface = this.mFontTypeface) == null) {
                    return false;
                }
                this.mFontTypeface = Api28Impl.create(typeface, i, (this.mStyle & 2) != 0);
                return true;
            }
            this.mAsyncFontPending = false;
            int i5 = tintTypedArray.getInt(C0419R.styleable.TextAppearance_android_typeface, 1);
            if (i5 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i5 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i5 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
            return true;
        }
        this.mFontTypeface = null;
        int i6 = tintTypedArray.hasValue(C0419R.styleable.TextAppearance_fontFamily) ? C0419R.styleable.TextAppearance_fontFamily : C0419R.styleable.TextAppearance_android_fontFamily;
        int i7 = this.mFontWeight;
        int i8 = this.mStyle;
        if (!context.isRestricted()) {
            try {
                Typeface font = tintTypedArray.getFont(i6, this.mStyle, makeFontCallback(i7, i8));
                if (font != null) {
                    if (i2 < 28 || this.mFontWeight == -1) {
                        this.mFontTypeface = font;
                    } else {
                        this.mFontTypeface = Api28Impl.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                    }
                }
                this.mAsyncFontPending = this.mFontTypeface == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.mFontTypeface == null && (string = tintTypedArray.getString(i6)) != null) {
            if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                this.mFontTypeface = Typeface.create(string, this.mStyle);
            } else {
                this.mFontTypeface = Api28Impl.create(Typeface.create(string, 0), this.mFontWeight, (this.mStyle & 2) != 0);
            }
        }
        return true;
    }

    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint == null && this.mDrawableEndTint == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    @Nullable
    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    @SuppressLint({WarningType.NewApi})
    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String string;
        int unitFromComplexDimension;
        float dimensionPixelSize;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.AppCompatTextHelper, i, 0);
        TextView textView = this.mView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), C0419R.styleable.AppCompatTextHelper, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        boolean z3 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (resourceId != -1) {
            TintTypedArray tintTypedArrayObtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, resourceId, C0419R.styleable.TextAppearance);
            if (z3 || !tintTypedArrayObtainStyledAttributes2.hasValue(C0419R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z = tintTypedArrayObtainStyledAttributes2.getBoolean(C0419R.styleable.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            updateTypefaceAndStyle(context, tintTypedArrayObtainStyledAttributes2);
            string = tintTypedArrayObtainStyledAttributes2.hasValue(C0419R.styleable.TextAppearance_textLocale) ? tintTypedArrayObtainStyledAttributes2.getString(C0419R.styleable.TextAppearance_textLocale) : null;
            tintTypedArrayObtainStyledAttributes2.recycle();
        } else {
            z = false;
            z2 = false;
            string = null;
        }
        TintTypedArray tintTypedArrayObtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.TextAppearance, i, 0);
        if (z3 || !tintTypedArrayObtainStyledAttributes3.hasValue(C0419R.styleable.TextAppearance_textAllCaps)) {
            z4 = z2;
        } else {
            z = tintTypedArrayObtainStyledAttributes3.getBoolean(C0419R.styleable.TextAppearance_textAllCaps, false);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (tintTypedArrayObtainStyledAttributes3.hasValue(C0419R.styleable.TextAppearance_textLocale)) {
            string = tintTypedArrayObtainStyledAttributes3.getString(C0419R.styleable.TextAppearance_textLocale);
        }
        if (i2 >= 28 && tintTypedArrayObtainStyledAttributes3.hasValue(C0419R.styleable.TextAppearance_android_textSize) && tintTypedArrayObtainStyledAttributes3.getDimensionPixelSize(C0419R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, tintTypedArrayObtainStyledAttributes3);
        tintTypedArrayObtainStyledAttributes3.recycle();
        if (!z3 && z4) {
            setAllCaps(z);
        }
        applyFontAndVariationSettings(false);
        if (string != null) {
            Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(string));
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
            int[] autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if (autoSizeTextAvailableSizes.length > 0) {
                if (Api26Impl.getAutoSizeStepGranularity(this.mView) != -1.0f) {
                    Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                } else {
                    Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, autoSizeTextAvailableSizes, 0);
                }
            }
        }
        TintTypedArray tintTypedArrayObtainStyledAttributes4 = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.AppCompatTextView);
        int resourceId2 = tintTypedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawable = resourceId2 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId2) : null;
        int resourceId3 = tintTypedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawable2 = resourceId3 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId3) : null;
        int resourceId4 = tintTypedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawable3 = resourceId4 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId4) : null;
        int resourceId5 = tintTypedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawable4 = resourceId5 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId5) : null;
        int resourceId6 = tintTypedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawable5 = resourceId6 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId6) : null;
        int resourceId7 = tintTypedArrayObtainStyledAttributes4.getResourceId(C0419R.styleable.AppCompatTextView_drawableEndCompat, -1);
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId7 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId7) : null);
        if (tintTypedArrayObtainStyledAttributes4.hasValue(C0419R.styleable.AppCompatTextView_drawableTint)) {
            TextViewCompat.setCompoundDrawableTintList(this.mView, tintTypedArrayObtainStyledAttributes4.getColorStateList(C0419R.styleable.AppCompatTextView_drawableTint));
        }
        if (tintTypedArrayObtainStyledAttributes4.hasValue(C0419R.styleable.AppCompatTextView_drawableTintMode)) {
            TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes4.getInt(C0419R.styleable.AppCompatTextView_drawableTintMode, -1), null));
        }
        int dimensionPixelSize2 = tintTypedArrayObtainStyledAttributes4.getDimensionPixelSize(C0419R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize3 = tintTypedArrayObtainStyledAttributes4.getDimensionPixelSize(C0419R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        if (tintTypedArrayObtainStyledAttributes4.hasValue(C0419R.styleable.AppCompatTextView_lineHeight)) {
            TypedValue typedValuePeekValue = tintTypedArrayObtainStyledAttributes4.peekValue(C0419R.styleable.AppCompatTextView_lineHeight);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                dimensionPixelSize = tintTypedArrayObtainStyledAttributes4.getDimensionPixelSize(C0419R.styleable.AppCompatTextView_lineHeight, -1);
                unitFromComplexDimension = -1;
            } else {
                unitFromComplexDimension = TypedValueCompat.getUnitFromComplexDimension(typedValuePeekValue.data);
                dimensionPixelSize = TypedValue.complexToFloat(typedValuePeekValue.data);
            }
        } else {
            unitFromComplexDimension = -1;
            dimensionPixelSize = -1.0f;
        }
        tintTypedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != -1) {
            TextViewCompat.setFirstBaselineToTopHeight(this.mView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            TextViewCompat.setLastBaselineToBottomHeight(this.mView, dimensionPixelSize3);
        }
        if (dimensionPixelSize != -1.0f) {
            if (unitFromComplexDimension == -1) {
                TextViewCompat.setLineHeight(this.mView, (int) dimensionPixelSize);
            } else {
                TextViewCompat.setLineHeight(this.mView, unitFromComplexDimension, dimensionPixelSize);
            }
        }
    }

    public void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (!textView.isAttachedToWindow()) {
                    applyNewTypefacePreservingVariationSettings(textView, typeface, this.mStyle);
                } else {
                    final int i = this.mStyle;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatTextHelper.applyNewTypefacePreservingVariationSettings(textView, typeface, i);
                        }
                    });
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return;
        }
        autoSizeText();
    }

    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    public void onSetTextAppearance(Context context, int i) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, C0419R.styleable.TextAppearance);
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.TextAppearance_textAllCaps, false));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.TextAppearance_android_textSize) && tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        boolean zUpdateTypefaceAndStyle = updateTypefaceAndStyle(context, tintTypedArrayObtainStyledAttributes);
        tintTypedArrayObtainStyledAttributes.recycle();
        applyFontAndVariationSettings(zUpdateTypefaceAndStyle);
    }

    public void populateSurroundingTextIfNeeded(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
    }

    public void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i4, int i5) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i4, i5);
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    public void setCompoundDrawableTintList(@Nullable ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        setCompoundTints();
    }

    public void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        setCompoundTints();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSize(int i, float f) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE || isAutoSizeEnabled()) {
            return;
        }
        setTextSizeInternal(i, f);
    }
}
