package com.microsoft.identity.nativeauth;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "regex", "", "(Ljava/lang/String;)V", "getRegex", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final /* data */ class RequiredUserAttributeOptions implements ILoggable {

    @Nullable
    private final String regex;

    public RequiredUserAttributeOptions(@Nullable String str) {
        this.regex = str;
    }

    public static /* synthetic */ RequiredUserAttributeOptions copy$default(RequiredUserAttributeOptions requiredUserAttributeOptions, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requiredUserAttributeOptions.regex;
        }
        return requiredUserAttributeOptions.copy(str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRegex() {
        return this.regex;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    @NotNull
    public final RequiredUserAttributeOptions copy(@Nullable String regex) {
        return new RequiredUserAttributeOptions(regex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequiredUserAttributeOptions) && Intrinsics.areEqual(this.regex, ((RequiredUserAttributeOptions) other).regex);
    }

    @Nullable
    public final String getRegex() {
        return this.regex;
    }

    public int hashCode() {
        String str = this.regex;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return toUnsanitizedString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.regex, new StringBuilder("RequiredUserAttributeOptions(regex="));
    }
}
