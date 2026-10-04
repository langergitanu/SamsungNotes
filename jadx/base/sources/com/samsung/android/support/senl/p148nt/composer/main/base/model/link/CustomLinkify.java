package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Patterns;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.core.util.PatternsCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomLinkify {
    private static final int MAP_LENGTH_MINIMUM_DIGITS = 10;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 9;
    private static HyperTextEntityExtractor mHyperTextEntityExtractor;
    private static CustomLinkify mInstance;
    private static Locale mLocale;
    Comparator<CustomLinkSpec> mCustomLinkSpecComparator = new Comparator<CustomLinkSpec>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.2
        @Override // java.util.Comparator
        public final int compare(CustomLinkSpec customLinkSpec, CustomLinkSpec customLinkSpec2) {
            int i;
            int i2;
            int i4 = customLinkSpec.start;
            int i5 = customLinkSpec2.start;
            if (i4 < i5) {
                return -1;
            }
            if (i4 <= i5 && (i = customLinkSpec.end) >= (i2 = customLinkSpec2.end)) {
                return i > i2 ? -1 : 0;
            }
            return 1;
        }
    };
    private final CustomLinkifyImpl mImpl;
    private static final String TAG = Logger.createTag("CustomLinkify");
    private static final Linkify.MatchFilter sPhoneNumberOnlyCountMatchFilter = new Linkify.MatchFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.1
        @Override // android.text.util.Linkify.MatchFilter
        public boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            boolean z = false;
            int i4 = 0;
            while (i < i2) {
                if (Character.isDigit(charSequence.charAt(i))) {
                    i4++;
                    if (i4 >= 9) {
                        return true;
                    }
                    z = false;
                } else {
                    if (z) {
                        return false;
                    }
                    z = true;
                }
                i++;
            }
            return false;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomLinkifyCommonImpl extends CustomLinkifyImpl {
        public CustomLinkifyCommonImpl(Context context) {
            super(0);
            DateTimeString.setWesternDateTimeFormat(context);
        }

        private boolean gatherPhoneLinks(List<CustomLinkSpec> list, String str) {
            SpannableString spannableString = new SpannableString(str);
            Linkify.addLinks(spannableString, Patterns.PHONE, "tel:", CustomLinkify.sPhoneNumberOnlyCountMatchFilter, (Linkify.TransformFilter) null);
            int size = list.size();
            for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
                int spanStart = spannableString.getSpanStart(uRLSpan);
                int spanEnd = spannableString.getSpanEnd(uRLSpan);
                int i = size - 1;
                while (true) {
                    if (i < 0) {
                        list.add(new CustomLinkSpec(2, spanStart, spanEnd));
                        break;
                    }
                    int i2 = list.get(i).start;
                    int i4 = list.get(i).end;
                    if (i2 > spanStart || spanEnd > i4) {
                        i--;
                    }
                }
            }
            return list.size() > size;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyImpl
        public void addLinks(ArrayList<CustomLinkSpec> arrayList, String str, int i) {
            if ((i & 4) != 0) {
                gatherPhoneLinks(arrayList, str);
            }
            if ((i & 16) != 0) {
                arrayList.addAll(DateLinkify.addLinks(new SpannableStringBuilder(str), arrayList, CustomLinkify.mLocale));
            }
            super.addLinks(arrayList, str, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomLinkifyCustomImpl extends CustomLinkifyCommonImpl {
        private final MatchFilter sUrlMatchFilter;

        public CustomLinkifyCustomImpl(Context context) {
            super(context);
            this.sUrlMatchFilter = new MatchFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyCustomImpl.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.MatchFilter
                public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
                    return i == 0 || charSequence.charAt(i - 1) != '@';
                }
            };
        }

        private boolean gatherMapLinks(List<CustomLinkSpec> list, String str) {
            int iIndexOf;
            int size = list.size();
            int i = 0;
            while (true) {
                try {
                    String strFindAddress = WebView.findAddress(str);
                    if (strFindAddress == null || (iIndexOf = str.indexOf(strFindAddress)) < 0) {
                        break;
                    }
                    int length = strFindAddress.length() + iIndexOf;
                    int i2 = iIndexOf + i;
                    i += length;
                    CustomLinkSpec customLinkSpec = new CustomLinkSpec(5, i2, i);
                    str = str.substring(length);
                    list.add(customLinkSpec);
                } catch (Error | Exception unused) {
                }
            }
            return list.size() > size;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyCommonImpl, com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyImpl
        @SuppressLint({"RestrictedApi"})
        public void addLinks(ArrayList<CustomLinkSpec> arrayList, String str, int i) {
            if ((i & 1) != 0) {
                gatherLinks(arrayList, str.toLowerCase(), PatternsCompat.AUTOLINK_WEB_URL, this.sUrlMatchFilter, 3);
            }
            if ((i & 2) != 0) {
                gatherLinks(arrayList, str, Patterns.EMAIL_ADDRESS, null, 1);
            }
            if ((i & 8) != 0 && str.length() >= 10) {
                gatherMapLinks(arrayList, str);
            }
            super.addLinks(arrayList, str, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomLinkifyFrameworkImpl extends CustomLinkifyCommonImpl {
        public CustomLinkifyFrameworkImpl(Context context) {
            super(context);
        }

        private void gatherLinksByFramework(List<CustomLinkSpec> list, String str, int i, int i2) {
            try {
                SpannableString spannableString = new SpannableString(str);
                Linkify.addLinks(spannableString, i);
                URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
                for (int i4 = 0; i4 < uRLSpanArr.length; i4++) {
                    list.add(new CustomLinkSpec(i2, spannableString.getSpanStart(uRLSpanArr[i4]), spannableString.getSpanEnd(uRLSpanArr[i4])));
                }
            } catch (Exception e) {
                String str2 = CustomLinkify.TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "gatherLinksByFramework error=", "/", " ex =");
                sbM1173s.append(e);
                Logger.m11000e(str2, sbM1173s.toString());
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyCommonImpl, com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyImpl
        public void addLinks(ArrayList<CustomLinkSpec> arrayList, String str, int i) {
            if ((i & 1) != 0) {
                gatherLinksByFramework(arrayList, str.toLowerCase(Locale.US), 1, 3);
            }
            if ((i & 2) != 0) {
                gatherLinksByFramework(arrayList, str, 2, 1);
            }
            if ((i & 8) != 0 && str.length() >= 10) {
                gatherLinksByFramework(arrayList, str, 8, 5);
            }
            super.addLinks(arrayList, str, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomLinkifyImpl {
        private final MatchFilter sCalculatorFormulaMatchFilter;

        public /* synthetic */ CustomLinkifyImpl(int i) {
            this();
        }

        public void addLinks(ArrayList<CustomLinkSpec> arrayList, String str, int i) {
            if ((i & 32) != 0) {
                gatherLinks(arrayList, str, Patterns.CALCULATOR_FORMULA, this.sCalculatorFormulaMatchFilter, 7);
            }
        }

        public void gatherLinks(List<CustomLinkSpec> list, String str, Pattern pattern, MatchFilter matchFilter, int i) {
            int iStart;
            int iEnd;
            Matcher matcher = pattern.matcher(str);
            while (true) {
                if (matchFilter != null) {
                    while (matcher.find()) {
                        iStart = matcher.start();
                        iEnd = matcher.end();
                        if (matchFilter.acceptMatch(str, iStart, iEnd)) {
                            break;
                        }
                    }
                    return;
                }
                if (!matcher.find()) {
                    return;
                }
                iStart = matcher.start();
                iEnd = matcher.end();
                list.add(new CustomLinkSpec(i, iStart, iEnd));
            }
        }

        private CustomLinkifyImpl() {
            this.sCalculatorFormulaMatchFilter = new MatchFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyImpl.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.MatchFilter
                public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
                    if (charSequence.charAt(i2 - 1) != '=') {
                        return false;
                    }
                    int i4 = 0;
                    boolean z = false;
                    while (i < i2) {
                        char cCharAt = charSequence.charAt(i);
                        if (cCharAt == '(') {
                            i4++;
                        } else if (cCharAt == ')') {
                            i4--;
                        }
                        if (i4 < 0) {
                            return false;
                        }
                        if (!z && (cCharAt == '+' || cCharAt == '-' || cCharAt == '*' || cCharAt == '/' || cCharAt == 247 || cCharAt == 215)) {
                            z = true;
                        }
                        i++;
                    }
                    return i4 == 0 && z;
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntityExtractorImpl extends CustomLinkifyImpl {
        public /* synthetic */ EntityExtractorImpl(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.CustomLinkify.CustomLinkifyImpl
        public synchronized void addLinks(ArrayList<CustomLinkSpec> arrayList, String str, int i) {
            arrayList.addAll(CustomLinkify.mHyperTextEntityExtractor.addLinks(str, i));
            super.addLinks(arrayList, str, i);
        }

        private EntityExtractorImpl() {
            super(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MatchFilter {
        boolean acceptMatch(CharSequence charSequence, int i, int i2);
    }

    private CustomLinkify(CustomLinkifyImpl customLinkifyImpl) {
        this.mImpl = customLinkifyImpl;
    }

    public static synchronized CustomLinkify getInstance(Context context) {
        return getInstance(context, Locale.getDefault());
    }

    private void pruneOverlaps(List<CustomLinkSpec> list) {
        int i;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list, this.mCustomLinkSpecComparator);
        int size = list.size();
        int i2 = 0;
        while (i2 < size - 1) {
            CustomLinkSpec customLinkSpec = list.get(i2);
            int i4 = i2 + 1;
            CustomLinkSpec customLinkSpec2 = list.get(i4);
            int i5 = customLinkSpec.start;
            int i6 = customLinkSpec2.start;
            if (i5 <= i6 && (i = customLinkSpec.end) > i6) {
                int i7 = customLinkSpec2.end;
                int i8 = (i7 > i && i - i5 <= i7 - i6) ? i - i5 < i7 - i6 ? i2 : -1 : i4;
                if (i8 != -1) {
                    list.remove(i8);
                    size--;
                }
            }
            i2 = i4;
        }
    }

    @NonNull
    public ArrayList<CustomLinkSpec> addLinks(String str, int i) {
        ArrayList<CustomLinkSpec> arrayList = new ArrayList<>();
        if (i == 0) {
            return arrayList;
        }
        this.mImpl.addLinks(arrayList, str, i);
        pruneOverlaps(arrayList);
        return arrayList;
    }

    public static synchronized CustomLinkify getInstance(Context context, Locale locale) {
        if (locale != null) {
            try {
                if (!locale.equals(mLocale)) {
                    mLocale = locale;
                    mInstance = null;
                    mHyperTextEntityExtractor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        CustomLinkify customLinkify = mInstance;
        if (customLinkify != null) {
            return customLinkify;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            if (mHyperTextEntityExtractor == null) {
                HyperTextEntityExtractor hyperTextEntityExtractor = HyperTextEntityExtractor.getInstance(context);
                mHyperTextEntityExtractor = hyperTextEntityExtractor;
                hyperTextEntityExtractor.setLocale(mLocale);
            }
            if (mHyperTextEntityExtractor.isSupported()) {
                mInstance = new CustomLinkify(new EntityExtractorImpl(0));
            } else {
                mInstance = new CustomLinkify(new CustomLinkifyFrameworkImpl(context));
            }
        } else {
            mInstance = new CustomLinkify(new CustomLinkifyCustomImpl(context));
        }
        return mInstance;
    }
}
