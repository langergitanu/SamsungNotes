package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class App extends GenericJson {

    @Key
    private Boolean authorized;

    @Key
    private String createInFolderTemplate;

    @Key
    private String createUrl;

    @Key
    private Boolean hasDriveWideScope;

    @Key
    private List<Icons> icons;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3256id;

    @Key
    private Boolean installed;

    @Key
    private String kind;

    @Key
    private String longDescription;

    @Key
    private String name;

    @Key
    private String objectType;

    @Key
    private String openUrlTemplate;

    @Key
    private List<String> primaryFileExtensions;

    @Key
    private List<String> primaryMimeTypes;

    @Key
    private String productId;

    @Key
    private String productUrl;

    @Key
    private List<String> secondaryFileExtensions;

    @Key
    private List<String> secondaryMimeTypes;

    @Key
    private String shortDescription;

    @Key
    private Boolean supportsCreate;

    @Key
    private Boolean supportsImport;

    @Key
    private Boolean supportsMultiOpen;

    @Key
    private Boolean supportsOfflineCreate;

    @Key
    private Boolean useByDefault;

    static {
        Data.nullOf(Icons.class);
    }

    public Boolean getAuthorized() {
        return this.authorized;
    }

    public String getCreateInFolderTemplate() {
        return this.createInFolderTemplate;
    }

    public String getCreateUrl() {
        return this.createUrl;
    }

    public Boolean getHasDriveWideScope() {
        return this.hasDriveWideScope;
    }

    public List<Icons> getIcons() {
        return this.icons;
    }

    public String getId() {
        return this.f3256id;
    }

    public Boolean getInstalled() {
        return this.installed;
    }

    public String getKind() {
        return this.kind;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public String getName() {
        return this.name;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getOpenUrlTemplate() {
        return this.openUrlTemplate;
    }

    public List<String> getPrimaryFileExtensions() {
        return this.primaryFileExtensions;
    }

    public List<String> getPrimaryMimeTypes() {
        return this.primaryMimeTypes;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public List<String> getSecondaryFileExtensions() {
        return this.secondaryFileExtensions;
    }

    public List<String> getSecondaryMimeTypes() {
        return this.secondaryMimeTypes;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public Boolean getSupportsCreate() {
        return this.supportsCreate;
    }

    public Boolean getSupportsImport() {
        return this.supportsImport;
    }

    public Boolean getSupportsMultiOpen() {
        return this.supportsMultiOpen;
    }

    public Boolean getSupportsOfflineCreate() {
        return this.supportsOfflineCreate;
    }

    public Boolean getUseByDefault() {
        return this.useByDefault;
    }

    public App setAuthorized(Boolean bool) {
        this.authorized = bool;
        return this;
    }

    public App setCreateInFolderTemplate(String str) {
        this.createInFolderTemplate = str;
        return this;
    }

    public App setCreateUrl(String str) {
        this.createUrl = str;
        return this;
    }

    public App setHasDriveWideScope(Boolean bool) {
        this.hasDriveWideScope = bool;
        return this;
    }

    public App setIcons(List<Icons> list) {
        this.icons = list;
        return this;
    }

    public App setId(String str) {
        this.f3256id = str;
        return this;
    }

    public App setInstalled(Boolean bool) {
        this.installed = bool;
        return this;
    }

    public App setKind(String str) {
        this.kind = str;
        return this;
    }

    public App setLongDescription(String str) {
        this.longDescription = str;
        return this;
    }

    public App setName(String str) {
        this.name = str;
        return this;
    }

    public App setObjectType(String str) {
        this.objectType = str;
        return this;
    }

    public App setOpenUrlTemplate(String str) {
        this.openUrlTemplate = str;
        return this;
    }

    public App setPrimaryFileExtensions(List<String> list) {
        this.primaryFileExtensions = list;
        return this;
    }

    public App setPrimaryMimeTypes(List<String> list) {
        this.primaryMimeTypes = list;
        return this;
    }

    public App setProductId(String str) {
        this.productId = str;
        return this;
    }

    public App setProductUrl(String str) {
        this.productUrl = str;
        return this;
    }

    public App setSecondaryFileExtensions(List<String> list) {
        this.secondaryFileExtensions = list;
        return this;
    }

    public App setSecondaryMimeTypes(List<String> list) {
        this.secondaryMimeTypes = list;
        return this;
    }

    public App setShortDescription(String str) {
        this.shortDescription = str;
        return this;
    }

    public App setSupportsCreate(Boolean bool) {
        this.supportsCreate = bool;
        return this;
    }

    public App setSupportsImport(Boolean bool) {
        this.supportsImport = bool;
        return this;
    }

    public App setSupportsMultiOpen(Boolean bool) {
        this.supportsMultiOpen = bool;
        return this;
    }

    public App setSupportsOfflineCreate(Boolean bool) {
        this.supportsOfflineCreate = bool;
        return this;
    }

    public App setUseByDefault(Boolean bool) {
        this.useByDefault = bool;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Icons extends GenericJson {

        @Key
        private String category;

        @Key
        private String iconUrl;

        @Key
        private Integer size;

        public String getCategory() {
            return this.category;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public Integer getSize() {
            return this.size;
        }

        public Icons setCategory(String str) {
            this.category = str;
            return this;
        }

        public Icons setIconUrl(String str) {
            this.iconUrl = str;
            return this;
        }

        public Icons setSize(Integer num) {
            this.size = num;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Icons set(String str, Object obj) {
            return (Icons) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Icons clone() {
            return (Icons) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public App set(String str, Object obj) {
        return (App) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public App clone() {
        return (App) super.clone();
    }
}
