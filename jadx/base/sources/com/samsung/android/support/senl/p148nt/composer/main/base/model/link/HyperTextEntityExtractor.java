package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.text.entity.BasicEntity;
import com.samsung.android.sdk.scs.p142ai.text.entity.BasicEntityExtractor;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HyperTextEntityExtractor {
    private static final String TAG = Logger.createTag("HyperTextEntityExtractor");
    private static HyperTextEntityExtractor mInstance = null;
    private final BasicEntityExtractor mBasicEntityExtractor;
    private String mCountry;
    private String mLanguage;
    private Set<BasicEntityExtractor.EntityType> mEntitiesToExtract = new HashSet();
    private Boolean mIsTextSupported = null;
    private Boolean mIsPhoneNumberSupported = null;
    private Boolean mIsDateTimeSupported = null;

    public HyperTextEntityExtractor(Context context) {
        this.mBasicEntityExtractor = AiServices.getBasicEntityExtractor(context.getApplicationContext());
        Logger.m11003i(TAG, "HyperTextEntityExtractor# AiServices.getBasicEntityExtractor:");
        setEntityTypes(context);
    }

    private Set<BasicEntityExtractor.EntityType> getEntityType(int i) {
        HashSet hashSet = new HashSet();
        if ((i & 1) != 0) {
            Set<BasicEntityExtractor.EntityType> set = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType = BasicEntityExtractor.EntityType.URL;
            if (set.contains(entityType)) {
                hashSet.add(entityType);
            }
        }
        if ((i & 2) != 0) {
            Set<BasicEntityExtractor.EntityType> set2 = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType2 = BasicEntityExtractor.EntityType.EMAIL_ADDRESS;
            if (set2.contains(entityType2)) {
                hashSet.add(entityType2);
            }
        }
        if ((i & 8) != 0) {
            Set<BasicEntityExtractor.EntityType> set3 = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType3 = BasicEntityExtractor.EntityType.MAP_ADDRESS;
            if (set3.contains(entityType3)) {
                hashSet.add(entityType3);
            }
            Set<BasicEntityExtractor.EntityType> set4 = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType4 = BasicEntityExtractor.EntityType.MAP_ADDRESS_POI;
            if (set4.contains(entityType4)) {
                hashSet.add(entityType4);
            }
        }
        if ((i & 4) != 0) {
            Set<BasicEntityExtractor.EntityType> set5 = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType5 = BasicEntityExtractor.EntityType.PHONE_NUMBER;
            if (set5.contains(entityType5)) {
                hashSet.add(entityType5);
            }
        }
        if ((i & 16) != 0) {
            Set<BasicEntityExtractor.EntityType> set6 = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType6 = BasicEntityExtractor.EntityType.DATE_TIME;
            if (set6.contains(entityType6)) {
                hashSet.add(entityType6);
            }
            Set<BasicEntityExtractor.EntityType> set7 = this.mEntitiesToExtract;
            BasicEntityExtractor.EntityType entityType7 = BasicEntityExtractor.EntityType.DATE_TIME_NUMERAL;
            if (set7.contains(entityType7)) {
                hashSet.add(entityType7);
            }
        }
        return hashSet;
    }

    public static synchronized HyperTextEntityExtractor getInstance(Context context) {
        try {
            if (mInstance == null) {
                mInstance = new HyperTextEntityExtractor(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private void initExtractionSupported(Context context) {
        if (this.mIsTextSupported == null) {
            this.mIsTextSupported = Boolean.valueOf(Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY") == 0);
            Logger.m11003i(TAG, "initExtractionSupported# mIsTextSupported:" + this.mIsTextSupported);
        }
        if (this.mIsPhoneNumberSupported == null) {
            this.mIsPhoneNumberSupported = Boolean.valueOf(Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_PHONE_NUMBER") == 0);
            Logger.m11003i(TAG, "initExtractionSupported# mIsPhoneNumberSupported:" + this.mIsPhoneNumberSupported);
        }
        if (this.mIsDateTimeSupported == null) {
            this.mIsDateTimeSupported = Boolean.valueOf(Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_DATETIME_NUMERAL") == 0);
            Logger.m11003i(TAG, "initExtractionSupported# mIsDateTimeSupported:" + this.mIsDateTimeSupported);
        }
    }

    private void setEntityTypes(Context context) {
        initExtractionSupported(context);
        if (this.mIsTextSupported.booleanValue()) {
            this.mEntitiesToExtract.add(BasicEntityExtractor.EntityType.EMAIL_ADDRESS);
            this.mEntitiesToExtract.add(BasicEntityExtractor.EntityType.URL);
            this.mEntitiesToExtract.add(BasicEntityExtractor.EntityType.MAP_ADDRESS);
        }
        if (this.mIsPhoneNumberSupported.booleanValue()) {
            this.mEntitiesToExtract.add(BasicEntityExtractor.EntityType.PHONE_NUMBER);
        }
        if (this.mIsDateTimeSupported.booleanValue()) {
            this.mEntitiesToExtract.add(BasicEntityExtractor.EntityType.DATE_TIME_NUMERAL);
        }
    }

    @NonNull
    public ArrayList<CustomLinkSpec> addLinks(String str, int i) {
        List<BasicEntity> listExtract;
        int i2;
        Logger.m11003i(TAG, "addLinks# Start : " + str.length() + "/" + i);
        ArrayList<CustomLinkSpec> arrayList = new ArrayList<>();
        Set<BasicEntityExtractor.EntityType> entityType = getEntityType(i);
        if (entityType != null && !entityType.isEmpty() && (listExtract = this.mBasicEntityExtractor.extract(str, this.mLanguage, this.mCountry, entityType)) != null && !listExtract.isEmpty()) {
            for (BasicEntity basicEntity : listExtract) {
                if (basicEntity.getType().equals(BasicEntityExtractor.EntityType.DATE_TIME) || basicEntity.getType().equals(BasicEntityExtractor.EntityType.DATE_TIME_NUMERAL)) {
                    i2 = 6;
                } else {
                    int i4 = 0;
                    if (basicEntity.getType().equals(BasicEntityExtractor.EntityType.MAP_ADDRESS) || basicEntity.getType().equals(BasicEntityExtractor.EntityType.MAP_ADDRESS_POI)) {
                        if (basicEntity.isMappable()) {
                            i4 = 5;
                        }
                    } else if (basicEntity.getType().equals(BasicEntityExtractor.EntityType.EMAIL_ADDRESS)) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                        if (basicEntity.getType().equals(BasicEntityExtractor.EntityType.URL)) {
                            int iLastIndexOf = basicEntity.getString().lastIndexOf(Extension.DOT);
                            if (iLastIndexOf > 0 && iLastIndexOf < basicEntity.getString().length() - 2) {
                                String strSubstring = basicEntity.getString().substring(iLastIndexOf + 1);
                                strSubstring.getClass();
                                switch (strSubstring) {
                                    case "kt":
                                    case "py":
                                    case "cpp":
                                    case "java":
                                        break;
                                    default:
                                        i4 = 3;
                                        break;
                                }
                            } else {
                                i4 = 3;
                            }
                        } else if (!basicEntity.getType().equals(BasicEntityExtractor.EntityType.PHONE_NUMBER)) {
                        }
                    }
                    i2 = i4;
                }
                if (i2 != 0) {
                    if (i2 == 6) {
                        arrayList.add(new DateLinkSpec(i2, basicEntity.getStartIndex(), basicEntity.getEndIndex(), basicEntity.getStartDateTime(), basicEntity.getEndDateTime()));
                    } else {
                        arrayList.add(new CustomLinkSpec(i2, basicEntity.getStartIndex(), basicEntity.getEndIndex()));
                    }
                }
            }
            Logger.m11003i(TAG, "addLinks# End : " + arrayList.size());
        }
        return arrayList;
    }

    public boolean isSupported() {
        return this.mBasicEntityExtractor.isSupported(this.mLanguage, this.mCountry);
    }

    public void setLocale(Locale locale) {
        this.mLanguage = locale.getLanguage();
        this.mCountry = locale.getCountry();
    }
}
