package com.microsoft.identity.common.java.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RemoveAccountCommandParameters extends CommandParameters {
    private IAccountRecord account;
    private List<BrowserDescriptor> browserSafeList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class RemoveAccountCommandParametersBuilder<C extends RemoveAccountCommandParameters, B extends RemoveAccountCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private IAccountRecord account;
        private List<BrowserDescriptor> browserSafeList;

        private static void $fillValuesFromInstanceIntoBuilder(RemoveAccountCommandParameters removeAccountCommandParameters, RemoveAccountCommandParametersBuilder<?, ?> removeAccountCommandParametersBuilder) {
            removeAccountCommandParametersBuilder.account(removeAccountCommandParameters.account);
            removeAccountCommandParametersBuilder.browserSafeList(removeAccountCommandParameters.browserSafeList);
        }

        public B account(IAccountRecord iAccountRecord) {
            this.account = iAccountRecord;
            return (B) self();
        }

        public B browserSafeList(List<BrowserDescriptor> list) {
            this.browserSafeList = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("RemoveAccountCommandParameters.RemoveAccountCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", account=");
            sb.append(this.account);
            sb.append(", browserSafeList=");
            return AbstractC0541b.m777s(sb, this.browserSafeList, ")");
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((RemoveAccountCommandParameters) c, (RemoveAccountCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class RemoveAccountCommandParametersBuilderImpl extends RemoveAccountCommandParametersBuilder<RemoveAccountCommandParameters, RemoveAccountCommandParametersBuilderImpl> {
        private RemoveAccountCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters.RemoveAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public RemoveAccountCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters.RemoveAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public RemoveAccountCommandParameters build() {
            return new RemoveAccountCommandParameters(this);
        }
    }

    public RemoveAccountCommandParameters(RemoveAccountCommandParametersBuilder<?, ?> removeAccountCommandParametersBuilder) {
        super(removeAccountCommandParametersBuilder);
        this.account = ((RemoveAccountCommandParametersBuilder) removeAccountCommandParametersBuilder).account;
        this.browserSafeList = ((RemoveAccountCommandParametersBuilder) removeAccountCommandParametersBuilder).browserSafeList;
    }

    public static RemoveAccountCommandParametersBuilder<?, ?> builder() {
        return new RemoveAccountCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof RemoveAccountCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoveAccountCommandParameters)) {
            return false;
        }
        RemoveAccountCommandParameters removeAccountCommandParameters = (RemoveAccountCommandParameters) obj;
        if (!removeAccountCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        IAccountRecord account = getAccount();
        IAccountRecord account2 = removeAccountCommandParameters.getAccount();
        if (account != null ? !account.equals(account2) : account2 != null) {
            return false;
        }
        List<BrowserDescriptor> browserSafeList = getBrowserSafeList();
        List<BrowserDescriptor> browserSafeList2 = removeAccountCommandParameters.getBrowserSafeList();
        return browserSafeList != null ? browserSafeList.equals(browserSafeList2) : browserSafeList2 == null;
    }

    public IAccountRecord getAccount() {
        return this.account;
    }

    public List<BrowserDescriptor> getBrowserSafeList() {
        if (this.browserSafeList == null) {
            return null;
        }
        return new ArrayList(this.browserSafeList);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        IAccountRecord account = getAccount();
        int iHashCode2 = (iHashCode * 59) + (account == null ? 43 : account.hashCode());
        List<BrowserDescriptor> browserSafeList = getBrowserSafeList();
        return (iHashCode2 * 59) + (browserSafeList != null ? browserSafeList.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public RemoveAccountCommandParametersBuilder<?, ?> toBuilder() {
        return new RemoveAccountCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
