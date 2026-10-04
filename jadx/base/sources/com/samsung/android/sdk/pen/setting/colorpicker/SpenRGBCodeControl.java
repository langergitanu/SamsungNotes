package com.samsung.android.sdk.pen.setting.colorpicker;

import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003*\u0001*\b\u0000\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0002>?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J2\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J.\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006J\u0010\u0010%\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\"\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0018H\u0002J\u0018\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u00104\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aH\u0002J\"\u00105\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001aH\u0002J \u00107\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aH\u0002J \u00108\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0012\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010=H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenRGBCodeControl;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewInterface;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventListener;", "<init>", "()V", "mRed", "Landroid/widget/EditText;", "mGreen", "mBlue", "mRGBCode", "mPickerColor", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColor;", "mOnEditorActionListener", "Landroid/widget/TextView$OnEditorActionListener;", "mIsUpdating", "", "setTouchUpListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewTouchUpListener;", "setPickerColor", "pickerColor", Constants.ARG_UPDATE, "who", "", "color", "", "hue", "", "saturation", "value", "release", "setRGBView", "colorText", "red", "green", "blue", "setEditorActionListener", "mRGBCodeTextWatcher", "Landroid/text/TextWatcher;", "mColorTextWatcher", "mAccessibilityDelegate", "com/samsung/android/sdk/pen/setting/colorpicker/SpenRGBCodeControl$mAccessibilityDelegate$1", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenRGBCodeControl$mAccessibilityDelegate$1;", "getSelectionIndex", "editText", "textValue", TextConst.KEY_PARAM_NUMBER, "getNumber", "stringNumber", "updateColorByUser", "hex", "notifyColorChanged", "updateColor", "selectionIndex", "updateView", "updateCodeText", "mRGBCodeTextFilter", "Landroid/text/InputFilter;", "checkActionKey", "chars", "", "Companion", "InputFilterMinMax", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRGBCodeControl implements SpenColorViewInterface, SpenPickerColorEventListener {
    private static final int COLOR_CHANEL_MAX_VALUE = 255;
    private static final int COLOR_CHANEL_MIN_VALUE = 0;
    private static final int HEX_BLUE = 3;
    private static final int HEX_GREEN = 2;
    private static final int HEX_RED = 1;
    private static final int NEW_LINE_CHARECTER_ASCII = 10;

    @NotNull
    private static final String RGB_HEX_CHARACTERS = "ABCDEFabcdef";
    private static final int RGB_HEX_MAX_LENGTH = 6;

    @NotNull
    private static final String RGB_HEX_PATTERN = "^[a-fA-F0-9]+$";

    @NotNull
    private static final String RGB_HEX_STRING_DEFAULT = "000000";

    @NotNull
    private static final String TAG = "SpenHexColorControl";

    @Nullable
    private EditText mBlue;

    @Nullable
    private EditText mGreen;
    private boolean mIsUpdating;

    @Nullable
    private TextView.OnEditorActionListener mOnEditorActionListener;

    @Nullable
    private SpenPickerColor mPickerColor;

    @Nullable
    private EditText mRGBCode;

    @Nullable
    private EditText mRed;

    @NotNull
    private final TextWatcher mRGBCodeTextWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenRGBCodeControl$mRGBCodeTextWatcher$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Intrinsics.checkNotNullParameter(s, "s");
            if (this.this$0.mPickerColor == null) {
                return;
            }
            String string = s.toString();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            String strSubstring = (upperCase + "000000").substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            int color = Color.parseColor(ContentUtils.HASH_SYMBOL + strSubstring);
            int iRed = Color.red(color);
            int iGreen = Color.green(color);
            int iBlue = Color.blue(color);
            SpenRGBCodeControl spenRGBCodeControl = this.this$0;
            spenRGBCodeControl.updateColor(spenRGBCodeControl.mRed, iRed, -1);
            SpenRGBCodeControl spenRGBCodeControl2 = this.this$0;
            spenRGBCodeControl2.updateColor(spenRGBCodeControl2.mGreen, iGreen, -1);
            SpenRGBCodeControl spenRGBCodeControl3 = this.this$0;
            spenRGBCodeControl3.updateColor(spenRGBCodeControl3.mBlue, iBlue, -1);
            this.this$0.notifyColorChanged(iRed, iGreen, iBlue);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s, "s");
        }
    };

    @NotNull
    private final TextWatcher mColorTextWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenRGBCodeControl$mColorTextWatcher$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            int i;
            Intrinsics.checkNotNullParameter(s, "s");
            if (this.this$0.mPickerColor == null) {
                return;
            }
            String string = s.toString();
            int number = this.this$0.getNumber(s.toString());
            EditText editText = this.this$0.mRed;
            if (Intrinsics.areEqual(string, String.valueOf(editText != null ? editText.getEditableText() : null))) {
                SpenRGBCodeControl spenRGBCodeControl = this.this$0;
                int selectionIndex = spenRGBCodeControl.getSelectionIndex(spenRGBCodeControl.mRed, string, number);
                SpenRGBCodeControl spenRGBCodeControl2 = this.this$0;
                spenRGBCodeControl2.updateColor(spenRGBCodeControl2.mRed, number, selectionIndex);
                i = 1;
            } else {
                EditText editText2 = this.this$0.mGreen;
                if (Intrinsics.areEqual(string, String.valueOf(editText2 != null ? editText2.getEditableText() : null))) {
                    SpenRGBCodeControl spenRGBCodeControl3 = this.this$0;
                    int selectionIndex2 = spenRGBCodeControl3.getSelectionIndex(spenRGBCodeControl3.mGreen, string, number);
                    SpenRGBCodeControl spenRGBCodeControl4 = this.this$0;
                    spenRGBCodeControl4.updateColor(spenRGBCodeControl4.mGreen, number, selectionIndex2);
                    i = 2;
                } else {
                    EditText editText3 = this.this$0.mBlue;
                    if (!Intrinsics.areEqual(string, String.valueOf(editText3 != null ? editText3.getEditableText() : null))) {
                        return;
                    }
                    SpenRGBCodeControl spenRGBCodeControl5 = this.this$0;
                    int selectionIndex3 = spenRGBCodeControl5.getSelectionIndex(spenRGBCodeControl5.mBlue, string, number);
                    SpenRGBCodeControl spenRGBCodeControl6 = this.this$0;
                    spenRGBCodeControl6.updateColor(spenRGBCodeControl6.mBlue, number, selectionIndex3);
                    i = 3;
                }
            }
            if (this.this$0.mIsUpdating) {
                return;
            }
            this.this$0.updateColorByUser(i, number);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s, "s");
        }
    };

    @NotNull
    private final SpenRGBCodeControl$mAccessibilityDelegate$1 mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenRGBCodeControl$mAccessibilityDelegate$1
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            Editable text;
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            String string = null;
            info.setHintText(null);
            EditText editText = host instanceof EditText ? (EditText) host : null;
            String string2 = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
            if (string2 == null || string2.length() == 0) {
                return;
            }
            EditText editText2 = (EditText) host;
            int id = editText2.getId();
            if (id == C7932R.id.rgb_code) {
                string = editText2.getResources().getString(C7932R.string.pen_string_hex);
            } else if (id == C7932R.id.red_code) {
                string = editText2.getResources().getString(C7932R.string.pen_string_red);
            } else if (id == C7932R.id.green_code) {
                string = editText2.getResources().getString(C7932R.string.pen_string_green);
            } else if (id == C7932R.id.blue_code) {
                string = editText2.getResources().getString(C7932R.string.pen_string_blue);
            }
            if (string != null) {
                info.setText(string2 + SQLKeyword.COMMA + string);
            }
        }
    };

    @NotNull
    private final InputFilter mRGBCodeTextFilter = new C7544f(this, 0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J:\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenRGBCodeControl$InputFilterMinMax;", "Landroid/text/InputFilter;", VElementFormulasCmd.FMIN, "", VElementFormulasCmd.FMAX, "<init>", "(Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenRGBCodeControl;II)V", "filter", "", "source", "", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "isInRange", "", "value", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class InputFilterMinMax implements InputFilter {
        private final int max;
        private final int min;

        public InputFilterMinMax(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        private final boolean isInRange(int start, int end, int value) {
            return end > start ? start <= value && value <= end : end <= value && value <= start;
        }

        @Override // android.text.InputFilter
        @Nullable
        public String filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            SpenRGBCodeControl.this.checkActionKey(source);
            try {
                String strSubstring = dest.toString().substring(0, dstart);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = dest.toString().substring(dend, dest.toString().length());
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                String str = strSubstring + strSubstring2;
                String strSubstring3 = str.substring(0, dstart);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring4 = str.substring(dstart, str.length());
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                if (isInRange(this.min, this.max, Integer.parseInt(strSubstring3 + ((Object) source) + strSubstring4))) {
                    return null;
                }
                return "";
            } catch (NumberFormatException unused) {
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkActionKey(CharSequence chars) {
        TextView.OnEditorActionListener onEditorActionListener;
        if (chars == null || chars.length() != 1 || chars.charAt(0) != '\n' || (onEditorActionListener = this.mOnEditorActionListener) == null) {
            return;
        }
        onEditorActionListener.onEditorAction(null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNumber(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSelectionIndex(EditText editText, String textValue, int number) {
        if (editText == null || TextUtils.isEmpty(textValue)) {
            return -1;
        }
        return textValue.length() > String.valueOf(number).length() ? editText.getSelectionStart() - (textValue.length() - String.valueOf(number).length()) : editText.getSelectionStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence mRGBCodeTextFilter$lambda$5(SpenRGBCodeControl spenRGBCodeControl, CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
        spenRGBCodeControl.checkActionKey(charSequence);
        Pattern patternCompile = Pattern.compile(RGB_HEX_PATTERN);
        if (Intrinsics.areEqual(charSequence, "") || patternCompile.matcher(charSequence).matches()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            if (Character.isDigit(charSequence.charAt(i)) || StringsKt.m14128B(RGB_HEX_CHARACTERS, charSequence.charAt(i), 0, 6) > -1) {
                sb.append(charSequence.subSequence(i, i + 1));
            }
            i++;
        }
        return sb.length() > 0 ? sb : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyColorChanged(int red, int green, int blue) {
        AbstractC11014a.m12329n(blue, ")", TAG, AbstractC0622a.m1173s(red, green, "notifyColorChanged(", SQLKeyword.COMMA, SQLKeyword.COMMA));
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.setColor(TAG, Color.rgb(red, green, blue));
        }
    }

    private final void updateCodeText(int red, int green, int blue) {
        EditText editText = this.mRGBCode;
        if (editText != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            Log.i(TAG, "updateCodeText() ".concat(str));
            String str2 = String.format("%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue)}, 3));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            editText.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColor(EditText editText, int color, int selectionIndex) {
        if (editText == null || this.mIsUpdating) {
            return;
        }
        String strValueOf = String.valueOf(color);
        if (Intrinsics.areEqual(strValueOf, editText.getEditableText().toString())) {
            return;
        }
        this.mIsUpdating = true;
        Log.d(TAG, "updateColor() color=" + strValueOf);
        editText.setText(strValueOf);
        if (selectionIndex == -1) {
            editText.setSelection(strValueOf.length());
        } else {
            editText.setSelection(selectionIndex);
        }
        this.mIsUpdating = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorByUser(int hex, int color) {
        int i;
        int i2;
        if (hex == 1) {
            EditText editText = this.mGreen;
            i = Integer.parseInt(String.valueOf(editText != null ? editText.getText() : null));
            EditText editText2 = this.mBlue;
            i2 = Integer.parseInt(String.valueOf(editText2 != null ? editText2.getText() : null));
        } else if (hex == 2) {
            EditText editText3 = this.mRed;
            int i4 = Integer.parseInt(String.valueOf(editText3 != null ? editText3.getText() : null));
            EditText editText4 = this.mBlue;
            i2 = Integer.parseInt(String.valueOf(editText4 != null ? editText4.getText() : null));
            color = i4;
            i = color;
        } else {
            if (hex != 3) {
                return;
            }
            EditText editText5 = this.mRed;
            int i5 = Integer.parseInt(String.valueOf(editText5 != null ? editText5.getText() : null));
            EditText editText6 = this.mGreen;
            color = i5;
            i = Integer.parseInt(String.valueOf(editText6 != null ? editText6.getText() : null));
            i2 = color;
        }
        updateCodeText(color, i, i2);
        notifyColorChanged(color, i, i2);
    }

    private final void updateView(int red, int green, int blue) {
        EditText editText = this.mRed;
        if (editText != null && this.mGreen != null && this.mBlue != null) {
            updateColor(editText, red, -1);
            updateColor(this.mGreen, green, -1);
            updateColor(this.mBlue, blue, -1);
        }
        updateCodeText(red, green, blue);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void release() {
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.removeEventListener(this);
        }
        this.mPickerColor = null;
        this.mOnEditorActionListener = null;
        this.mRed = null;
        this.mGreen = null;
        this.mBlue = null;
    }

    public final void setEditorActionListener(@Nullable TextView.OnEditorActionListener listener) {
        this.mOnEditorActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setPickerColor(@NotNull SpenPickerColor pickerColor) {
        Intrinsics.checkNotNullParameter(pickerColor, "pickerColor");
        this.mPickerColor = pickerColor;
        int color = pickerColor.getColor();
        updateView(Color.red(color), Color.green(color), Color.blue(color));
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.addEventListener(this);
        }
    }

    public final void setRGBView(@Nullable EditText colorText, @Nullable EditText red, @Nullable EditText green, @Nullable EditText blue) {
        if (red == null || green == null || blue == null) {
            return;
        }
        this.mRGBCode = colorText;
        if (colorText != null) {
            colorText.setFilters(new InputFilter[]{this.mRGBCodeTextFilter, new InputFilter.LengthFilter(6)});
            colorText.addTextChangedListener(this.mRGBCodeTextWatcher);
            colorText.setAccessibilityDelegate(this.mAccessibilityDelegate);
        }
        this.mRed = red;
        red.setFilters(new InputFilter[]{new InputFilterMinMax(0, 255)});
        red.addTextChangedListener(this.mColorTextWatcher);
        red.setAccessibilityDelegate(this.mAccessibilityDelegate);
        this.mGreen = green;
        green.setFilters(new InputFilter[]{new InputFilterMinMax(0, 255)});
        green.addTextChangedListener(this.mColorTextWatcher);
        green.setAccessibilityDelegate(this.mAccessibilityDelegate);
        this.mBlue = blue;
        blue.setFilters(new InputFilter[]{new InputFilterMinMax(0, 255)});
        blue.addTextChangedListener(this.mColorTextWatcher);
        blue.setAccessibilityDelegate(this.mAccessibilityDelegate);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenPickerColorEventListener
    public void update(@Nullable String who, int color, float hue, float saturation, float value) {
        if (Intrinsics.areEqual(who, TAG)) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{who, Integer.valueOf(color), Integer.valueOf(Color.red(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.blue(color)), Float.valueOf(hue), Float.valueOf(saturation), Float.valueOf(value)}, 8, "received update() eventType=%s, color=%X(%d,%d,%d), hsv[%f, %f, %f]", "format(format, *args)", TAG);
        updateView(Color.red(color), Color.green(color), Color.blue(color));
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setTouchUpListener(@Nullable SpenColorViewTouchUpListener listener) {
    }
}
