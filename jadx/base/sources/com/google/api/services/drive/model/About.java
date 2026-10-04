package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class About extends GenericJson {

    @Key
    private List<AdditionalRoleInfo> additionalRoleInfo;

    @Key
    private String domainSharingPolicy;

    @Key
    private String etag;

    @Key
    private List<ExportFormats> exportFormats;

    @Key
    private List<Features> features;

    @Key
    private List<String> folderColorPalette;

    @Key
    private List<ImportFormats> importFormats;

    @Key
    private Boolean isCurrentAppInstalled;

    @Key
    private String kind;

    @Key
    private String languageCode;

    @JsonString
    @Key
    private Long largestChangeId;

    @Key
    private List<MaxUploadSizes> maxUploadSizes;

    @Key
    private String name;

    @Key
    private String permissionId;

    @Key
    private List<QuotaBytesByService> quotaBytesByService;

    @JsonString
    @Key
    private Long quotaBytesTotal;

    @JsonString
    @Key
    private Long quotaBytesUsed;

    @JsonString
    @Key
    private Long quotaBytesUsedAggregate;

    @JsonString
    @Key
    private Long quotaBytesUsedInTrash;

    @Key
    private String quotaType;

    @JsonString
    @Key
    private Long remainingChangeIds;

    @Key
    private String rootFolderId;

    @Key
    private String selfLink;

    @Key
    private User user;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AdditionalRoleInfo extends GenericJson {

        @Key
        private List<RoleSets> roleSets;

        @Key
        private String type;

        static {
            Data.nullOf(RoleSets.class);
        }

        public List<RoleSets> getRoleSets() {
            return this.roleSets;
        }

        public String getType() {
            return this.type;
        }

        public AdditionalRoleInfo setRoleSets(List<RoleSets> list) {
            this.roleSets = list;
            return this;
        }

        public AdditionalRoleInfo setType(String str) {
            this.type = str;
            return this;
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class RoleSets extends GenericJson {

            @Key
            private List<String> additionalRoles;

            @Key
            private String primaryRole;

            public List<String> getAdditionalRoles() {
                return this.additionalRoles;
            }

            public String getPrimaryRole() {
                return this.primaryRole;
            }

            public RoleSets setAdditionalRoles(List<String> list) {
                this.additionalRoles = list;
                return this;
            }

            public RoleSets setPrimaryRole(String str) {
                this.primaryRole = str;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public RoleSets set(String str, Object obj) {
                return (RoleSets) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public RoleSets clone() {
                return (RoleSets) super.clone();
            }
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public AdditionalRoleInfo set(String str, Object obj) {
            return (AdditionalRoleInfo) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public AdditionalRoleInfo clone() {
            return (AdditionalRoleInfo) super.clone();
        }
    }

    static {
        Data.nullOf(AdditionalRoleInfo.class);
        Data.nullOf(ExportFormats.class);
        Data.nullOf(Features.class);
        Data.nullOf(ImportFormats.class);
        Data.nullOf(MaxUploadSizes.class);
        Data.nullOf(QuotaBytesByService.class);
    }

    public List<AdditionalRoleInfo> getAdditionalRoleInfo() {
        return this.additionalRoleInfo;
    }

    public String getDomainSharingPolicy() {
        return this.domainSharingPolicy;
    }

    public String getEtag() {
        return this.etag;
    }

    public List<ExportFormats> getExportFormats() {
        return this.exportFormats;
    }

    public List<Features> getFeatures() {
        return this.features;
    }

    public List<String> getFolderColorPalette() {
        return this.folderColorPalette;
    }

    public List<ImportFormats> getImportFormats() {
        return this.importFormats;
    }

    public Boolean getIsCurrentAppInstalled() {
        return this.isCurrentAppInstalled;
    }

    public String getKind() {
        return this.kind;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public Long getLargestChangeId() {
        return this.largestChangeId;
    }

    public List<MaxUploadSizes> getMaxUploadSizes() {
        return this.maxUploadSizes;
    }

    public String getName() {
        return this.name;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public List<QuotaBytesByService> getQuotaBytesByService() {
        return this.quotaBytesByService;
    }

    public Long getQuotaBytesTotal() {
        return this.quotaBytesTotal;
    }

    public Long getQuotaBytesUsed() {
        return this.quotaBytesUsed;
    }

    public Long getQuotaBytesUsedAggregate() {
        return this.quotaBytesUsedAggregate;
    }

    public Long getQuotaBytesUsedInTrash() {
        return this.quotaBytesUsedInTrash;
    }

    public String getQuotaType() {
        return this.quotaType;
    }

    public Long getRemainingChangeIds() {
        return this.remainingChangeIds;
    }

    public String getRootFolderId() {
        return this.rootFolderId;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public User getUser() {
        return this.user;
    }

    public About setAdditionalRoleInfo(List<AdditionalRoleInfo> list) {
        this.additionalRoleInfo = list;
        return this;
    }

    public About setDomainSharingPolicy(String str) {
        this.domainSharingPolicy = str;
        return this;
    }

    public About setEtag(String str) {
        this.etag = str;
        return this;
    }

    public About setExportFormats(List<ExportFormats> list) {
        this.exportFormats = list;
        return this;
    }

    public About setFeatures(List<Features> list) {
        this.features = list;
        return this;
    }

    public About setFolderColorPalette(List<String> list) {
        this.folderColorPalette = list;
        return this;
    }

    public About setImportFormats(List<ImportFormats> list) {
        this.importFormats = list;
        return this;
    }

    public About setIsCurrentAppInstalled(Boolean bool) {
        this.isCurrentAppInstalled = bool;
        return this;
    }

    public About setKind(String str) {
        this.kind = str;
        return this;
    }

    public About setLanguageCode(String str) {
        this.languageCode = str;
        return this;
    }

    public About setLargestChangeId(Long l) {
        this.largestChangeId = l;
        return this;
    }

    public About setMaxUploadSizes(List<MaxUploadSizes> list) {
        this.maxUploadSizes = list;
        return this;
    }

    public About setName(String str) {
        this.name = str;
        return this;
    }

    public About setPermissionId(String str) {
        this.permissionId = str;
        return this;
    }

    public About setQuotaBytesByService(List<QuotaBytesByService> list) {
        this.quotaBytesByService = list;
        return this;
    }

    public About setQuotaBytesTotal(Long l) {
        this.quotaBytesTotal = l;
        return this;
    }

    public About setQuotaBytesUsed(Long l) {
        this.quotaBytesUsed = l;
        return this;
    }

    public About setQuotaBytesUsedAggregate(Long l) {
        this.quotaBytesUsedAggregate = l;
        return this;
    }

    public About setQuotaBytesUsedInTrash(Long l) {
        this.quotaBytesUsedInTrash = l;
        return this;
    }

    public About setQuotaType(String str) {
        this.quotaType = str;
        return this;
    }

    public About setRemainingChangeIds(Long l) {
        this.remainingChangeIds = l;
        return this;
    }

    public About setRootFolderId(String str) {
        this.rootFolderId = str;
        return this;
    }

    public About setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public About setUser(User user) {
        this.user = user;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ExportFormats extends GenericJson {

        @Key
        private String source;

        @Key
        private List<String> targets;

        public String getSource() {
            return this.source;
        }

        public List<String> getTargets() {
            return this.targets;
        }

        public ExportFormats setSource(String str) {
            this.source = str;
            return this;
        }

        public ExportFormats setTargets(List<String> list) {
            this.targets = list;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public ExportFormats set(String str, Object obj) {
            return (ExportFormats) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public ExportFormats clone() {
            return (ExportFormats) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Features extends GenericJson {

        @Key
        private String featureName;

        @Key
        private Double featureRate;

        public String getFeatureName() {
            return this.featureName;
        }

        public Double getFeatureRate() {
            return this.featureRate;
        }

        public Features setFeatureName(String str) {
            this.featureName = str;
            return this;
        }

        public Features setFeatureRate(Double d) {
            this.featureRate = d;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Features set(String str, Object obj) {
            return (Features) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Features clone() {
            return (Features) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ImportFormats extends GenericJson {

        @Key
        private String source;

        @Key
        private List<String> targets;

        public String getSource() {
            return this.source;
        }

        public List<String> getTargets() {
            return this.targets;
        }

        public ImportFormats setSource(String str) {
            this.source = str;
            return this;
        }

        public ImportFormats setTargets(List<String> list) {
            this.targets = list;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public ImportFormats set(String str, Object obj) {
            return (ImportFormats) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public ImportFormats clone() {
            return (ImportFormats) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MaxUploadSizes extends GenericJson {

        @JsonString
        @Key
        private Long size;

        @Key
        private String type;

        public Long getSize() {
            return this.size;
        }

        public String getType() {
            return this.type;
        }

        public MaxUploadSizes setSize(Long l) {
            this.size = l;
            return this;
        }

        public MaxUploadSizes setType(String str) {
            this.type = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public MaxUploadSizes set(String str, Object obj) {
            return (MaxUploadSizes) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public MaxUploadSizes clone() {
            return (MaxUploadSizes) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class QuotaBytesByService extends GenericJson {

        @JsonString
        @Key
        private Long bytesUsed;

        @Key
        private String serviceName;

        public Long getBytesUsed() {
            return this.bytesUsed;
        }

        public String getServiceName() {
            return this.serviceName;
        }

        public QuotaBytesByService setBytesUsed(Long l) {
            this.bytesUsed = l;
            return this;
        }

        public QuotaBytesByService setServiceName(String str) {
            this.serviceName = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public QuotaBytesByService set(String str, Object obj) {
            return (QuotaBytesByService) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public QuotaBytesByService clone() {
            return (QuotaBytesByService) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public About set(String str, Object obj) {
        return (About) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public About clone() {
        return (About) super.clone();
    }
}
