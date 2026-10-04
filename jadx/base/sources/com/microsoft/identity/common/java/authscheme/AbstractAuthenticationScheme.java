package com.microsoft.identity.common.java.authscheme;

import androidx.collection.AbstractC0622a;
import com.google.gson.annotations.SerializedName;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractAuthenticationScheme implements INameable {
    private static final long serialVersionUID = -2437270903389813253L;

    @SerializedName("name")
    private final String mName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbstractAuthenticationSchemeBuilder<C extends AbstractAuthenticationScheme, B extends AbstractAuthenticationSchemeBuilder<C, B>> {
        private String name;

        private static void $fillValuesFromInstanceIntoBuilder(AbstractAuthenticationScheme abstractAuthenticationScheme, AbstractAuthenticationSchemeBuilder<?, ?> abstractAuthenticationSchemeBuilder) {
            abstractAuthenticationSchemeBuilder.name(abstractAuthenticationScheme.mName);
        }

        public B $fillValuesFrom(C c) {
            $fillValuesFromInstanceIntoBuilder(c, this);
            return (B) self();
        }

        public abstract C build();

        public B name(String str) {
            this.name = str;
            return (B) self();
        }

        public abstract B self();

        public String toString() {
            return AbstractC0622a.m1170p(this.name, ")", new StringBuilder("AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder(name="));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedNames {
        public static final String NAME = "name";
    }

    public AbstractAuthenticationScheme(AbstractAuthenticationSchemeBuilder<?, ?> abstractAuthenticationSchemeBuilder) {
        this.mName = ((AbstractAuthenticationSchemeBuilder) abstractAuthenticationSchemeBuilder).name;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AbstractAuthenticationScheme;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractAuthenticationScheme)) {
            return false;
        }
        AbstractAuthenticationScheme abstractAuthenticationScheme = (AbstractAuthenticationScheme) obj;
        if (!abstractAuthenticationScheme.canEqual(this)) {
            return false;
        }
        String name = getName();
        String name2 = abstractAuthenticationScheme.getName();
        return name != null ? name.equals(name2) : name2 == null;
    }

    @Override // com.microsoft.identity.common.java.authscheme.INameable
    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        String name = getName();
        return 59 + (name == null ? 43 : name.hashCode());
    }

    public String toString() {
        return AbstractC0622a.m1170p(this.mName, "'}", new StringBuilder("AbstractAuthenticationScheme{mName='"));
    }

    public AbstractAuthenticationScheme(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mName = str;
    }
}
