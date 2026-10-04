package org.junit.runner;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.manipulation.Filter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
class FilterFactories {
    public static Filter createFilter(String str, FilterFactoryParams filterFactoryParams) {
        return createFilterFactory(str).createFilter(filterFactoryParams);
    }

    public static FilterFactory createFilterFactory(String str) throws FilterFactory.FilterNotCreatedException {
        try {
            return createFilterFactory((Class<? extends FilterFactory>) Classes.getClass(str).asSubclass(FilterFactory.class));
        } catch (Exception e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }

    public static Filter createFilterFromFilterSpec(Request request, String str) {
        Description description = request.getRunner().getDescription();
        String[] strArrSplit = str.contains(MarketingConstants.REFERRER_DELIMITER_U003D) ? str.split(MarketingConstants.REFERRER_DELIMITER_U003D, 2) : new String[]{str, ""};
        return createFilter(strArrSplit[0], new FilterFactoryParams(description, strArrSplit[1]));
    }

    public static Filter createFilter(Class<? extends FilterFactory> cls, FilterFactoryParams filterFactoryParams) {
        return createFilterFactory(cls).createFilter(filterFactoryParams);
    }

    public static FilterFactory createFilterFactory(Class<? extends FilterFactory> cls) throws FilterFactory.FilterNotCreatedException {
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }
}
