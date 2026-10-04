package com.microsoft.identity.common.java.dto;

import com.google.gson.JsonElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AccountCredentialBase implements Cloneable {
    private transient Map<String, JsonElement> mAdditionalFields = Collections.synchronizedMap(new HashMap());

    public Map<String, JsonElement> getAdditionalFields() {
        return this.mAdditionalFields;
    }

    public void mergeAdditionalFields(@NonNull AccountCredentialBase accountCredentialBase) {
        if (accountCredentialBase == null) {
            throw new NullPointerException("other is marked non-null but is null");
        }
        if (this.mAdditionalFields == null) {
            this.mAdditionalFields = Collections.synchronizedMap(new HashMap());
        }
        if (accountCredentialBase.getAdditionalFields() != null) {
            for (Map.Entry<String, JsonElement> entry : accountCredentialBase.getAdditionalFields().entrySet()) {
                if (!this.mAdditionalFields.containsKey(entry.getKey())) {
                    this.mAdditionalFields.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public void setAdditionalFields(@NonNull Map<String, JsonElement> map) {
        if (map == null) {
            throw new NullPointerException("additionalFields is marked non-null but is null");
        }
        this.mAdditionalFields = Collections.synchronizedMap(map);
    }

    public String toString() {
        return "AccountCredentialBase{mAdditionalFields=" + this.mAdditionalFields + '}';
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AccountCredentialBase m22118clone() {
        AccountCredentialBase accountCredentialBase = (AccountCredentialBase) super.clone();
        accountCredentialBase.setAdditionalFields(new HashMap(this.mAdditionalFields));
        return accountCredentialBase;
    }
}
