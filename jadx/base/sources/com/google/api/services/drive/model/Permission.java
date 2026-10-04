package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Permission extends GenericJson {

    @Key
    private List<String> additionalRoles;

    @Key
    private String authKey;

    @Key
    private String domain;

    @Key
    private String emailAddress;

    @Key
    private String etag;

    @Key
    private DateTime expirationDate;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3262id;

    @Key
    private String kind;

    @Key
    private String name;

    @Key
    private String photoLink;

    @Key
    private String role;

    @Key
    private String selfLink;

    @Key
    private List<TeamDrivePermissionDetails> teamDrivePermissionDetails;

    @Key
    private String type;

    @Key
    private String value;

    @Key
    private Boolean withLink;

    static {
        Data.nullOf(TeamDrivePermissionDetails.class);
    }

    public List<String> getAdditionalRoles() {
        return this.additionalRoles;
    }

    public String getAuthKey() {
        return this.authKey;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getEtag() {
        return this.etag;
    }

    public DateTime getExpirationDate() {
        return this.expirationDate;
    }

    public String getId() {
        return this.f3262id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public String getRole() {
        return this.role;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public List<TeamDrivePermissionDetails> getTeamDrivePermissionDetails() {
        return this.teamDrivePermissionDetails;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public Boolean getWithLink() {
        return this.withLink;
    }

    public Permission setAdditionalRoles(List<String> list) {
        this.additionalRoles = list;
        return this;
    }

    public Permission setAuthKey(String str) {
        this.authKey = str;
        return this;
    }

    public Permission setDomain(String str) {
        this.domain = str;
        return this;
    }

    public Permission setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public Permission setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Permission setExpirationDate(DateTime dateTime) {
        this.expirationDate = dateTime;
        return this;
    }

    public Permission setId(String str) {
        this.f3262id = str;
        return this;
    }

    public Permission setKind(String str) {
        this.kind = str;
        return this;
    }

    public Permission setName(String str) {
        this.name = str;
        return this;
    }

    public Permission setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public Permission setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public Permission setTeamDrivePermissionDetails(List<TeamDrivePermissionDetails> list) {
        this.teamDrivePermissionDetails = list;
        return this;
    }

    public Permission setType(String str) {
        this.type = str;
        return this;
    }

    public Permission setValue(String str) {
        this.value = str;
        return this;
    }

    public Permission setWithLink(Boolean bool) {
        this.withLink = bool;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TeamDrivePermissionDetails extends GenericJson {

        @Key
        private List<String> additionalRoles;

        @Key
        private Boolean inherited;

        @Key
        private String inheritedFrom;

        @Key
        private String role;

        @Key
        private String teamDrivePermissionType;

        public List<String> getAdditionalRoles() {
            return this.additionalRoles;
        }

        public Boolean getInherited() {
            return this.inherited;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public String getRole() {
            return this.role;
        }

        public String getTeamDrivePermissionType() {
            return this.teamDrivePermissionType;
        }

        public TeamDrivePermissionDetails setAdditionalRoles(List<String> list) {
            this.additionalRoles = list;
            return this;
        }

        public TeamDrivePermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public TeamDrivePermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public TeamDrivePermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        public TeamDrivePermissionDetails setTeamDrivePermissionType(String str) {
            this.teamDrivePermissionType = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public TeamDrivePermissionDetails set(String str, Object obj) {
            return (TeamDrivePermissionDetails) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public TeamDrivePermissionDetails clone() {
            return (TeamDrivePermissionDetails) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Permission clone() {
        return (Permission) super.clone();
    }
}
