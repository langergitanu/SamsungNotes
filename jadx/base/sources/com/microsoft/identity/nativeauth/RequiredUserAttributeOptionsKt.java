package com.microsoft.identity.nativeauth;

import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeOptionsApiResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0000¨\u0006\u0004"}, m13886d2 = {"toListOfRequiredUserAttributeOptions", "Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeOptionsApiResult;", "", "msal_distRelease"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class RequiredUserAttributeOptionsKt {
    @NotNull
    public static final List<RequiredUserAttributeOptions> toListOfRequiredUserAttributeOptions(@NotNull List<UserAttributeOptionsApiResult> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<UserAttributeOptionsApiResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toListOfRequiredUserAttributeOptions((UserAttributeOptionsApiResult) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final RequiredUserAttributeOptions toListOfRequiredUserAttributeOptions(@NotNull UserAttributeOptionsApiResult userAttributeOptionsApiResult) {
        Intrinsics.checkNotNullParameter(userAttributeOptionsApiResult, "<this>");
        return new RequiredUserAttributeOptions(userAttributeOptionsApiResult.getRegex());
    }
}
