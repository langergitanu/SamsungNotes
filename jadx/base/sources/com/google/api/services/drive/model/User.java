package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class User extends GenericJson {

    @Key
    private String displayName;

    @Key
    private String emailAddress;

    @Key
    private Boolean isAuthenticatedUser;

    @Key
    private String kind;

    @Key
    private String permissionId;

    @Key
    private Picture picture;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public Boolean getIsAuthenticatedUser() {
        return this.isAuthenticatedUser;
    }

    public String getKind() {
        return this.kind;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public User setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public User setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public User setIsAuthenticatedUser(Boolean bool) {
        this.isAuthenticatedUser = bool;
        return this;
    }

    public User setKind(String str) {
        this.kind = str;
        return this;
    }

    public User setPermissionId(String str) {
        this.permissionId = str;
        return this;
    }

    public User setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Picture extends GenericJson {

        @Key
        private String url;

        public String getUrl() {
            return this.url;
        }

        public Picture setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Picture set(String str, Object obj) {
            return (Picture) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Picture clone() {
            return (Picture) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public User set(String str, Object obj) {
        return (User) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public User clone() {
        return (User) super.clone();
    }
}
