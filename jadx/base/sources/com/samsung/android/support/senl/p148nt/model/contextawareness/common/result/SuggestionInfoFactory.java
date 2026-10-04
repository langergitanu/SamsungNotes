package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.constants.Constants;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SuggestionInfoFactory {
    private static final String TAG = CALogger.createTag("SuggestionInfoFactory");
    private static SuggestionInfoFactory sInstance = null;

    private String getDonateType(SuggestionData suggestionData) {
        String string = suggestionData.getExtras().getString("source");
        Context applicationContext = BaseUtils.getApplicationContext();
        ListIterator listIterator = Arrays.asList(applicationContext.getResources().getStringArray(C11397R.array.donated_app_image)).listIterator();
        while (listIterator.hasNext()) {
            if (string.equals(listIterator.next())) {
                return Constants.DonateType.IMAGE_OBJECT;
            }
        }
        ListIterator listIterator2 = Arrays.asList(applicationContext.getResources().getStringArray(C11397R.array.donated_app_internet)).listIterator();
        while (listIterator2.hasNext()) {
            if (string.equals(listIterator2.next())) {
                return Constants.DonateType.WEB_PAGE;
            }
        }
        ListIterator listIterator3 = Arrays.asList(applicationContext.getResources().getStringArray(C11397R.array.donated_app_message)).listIterator();
        while (listIterator3.hasNext()) {
            if (string.equals(listIterator3.next())) {
                return "Message";
            }
        }
        DataLogger.m12302d(TAG, "getDonateType invalid packageName");
        return null;
    }

    public static synchronized SuggestionInfoFactory getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new SuggestionInfoFactory();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private Class getSuggestionInfoClass(String str) {
        return Constants.DonateType.IMAGE_OBJECT.equals(str) ? MediaObjectSuggestionInfo.class : Constants.DonateType.WEB_PAGE.equals(str) ? WebPageSuggestionInfo.class : "Message".equals(str) ? MessageSuggestionInfo.class : UnknownSuggestionInfo.class;
    }

    @NonNull
    public List<SuggestionInfo> makeSuggestionInfo(SuggestionItem suggestionItem) {
        ArrayList arrayList = new ArrayList();
        try {
            Class<?>[] clsArr = {SuggestionData.class};
            for (SuggestionData suggestionData : suggestionItem.getItems()) {
                Constructor declaredConstructor = getSuggestionInfoClass(getDonateType(suggestionData)).getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                arrayList.add((SuggestionInfo) declaredConstructor.newInstance(suggestionData));
            }
            return arrayList;
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("makeSuggestionInfo# "), TAG);
            return arrayList;
        }
    }

    @NonNull
    public List<SuggestionInfo> makeSuggestionInfo(Intent intent) {
        ArrayList arrayList = new ArrayList();
        String donateType = getDonateType(intent);
        String str = TAG;
        DataLogger.m12302d(str, "makeSuggestionInfo donateType " + donateType);
        if (Constants.DonateType.IMAGE_OBJECT.equals(donateType)) {
            arrayList.add(new MediaObjectSuggestionInfo(intent));
            return arrayList;
        }
        if (Constants.DonateType.WEB_PAGE.equals(donateType)) {
            arrayList.add(new WebPageSuggestionInfo(intent));
            return arrayList;
        }
        if ("Message".equals(donateType)) {
            arrayList.add(new MessageSuggestionInfo(intent));
            return arrayList;
        }
        DataLogger.m12302d(str, "makeSuggestionInfo invalid donateType");
        arrayList.add(new UnknownSuggestionInfo(intent));
        return arrayList;
    }

    private String getDonateType(Intent intent) {
        return intent.getStringExtra("type");
    }

    @NonNull
    public SuggestionInfo makeSuggestionInfo(SuggestionData suggestionData) {
        String donateType = getDonateType(suggestionData);
        String str = TAG;
        DataLogger.m12302d(str, "makeSuggestionInfo donateType " + donateType);
        if (Constants.DonateType.IMAGE_OBJECT.equals(donateType)) {
            return new MediaObjectSuggestionInfo(suggestionData);
        }
        if (Constants.DonateType.WEB_PAGE.equals(donateType)) {
            return new WebPageSuggestionInfo(suggestionData);
        }
        if ("Message".equals(donateType)) {
            return new MessageSuggestionInfo(suggestionData);
        }
        DataLogger.m12302d(str, "makeSuggestionInfo invalid donateType");
        return new UnknownSuggestionInfo(suggestionData);
    }
}
