package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Base64;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class File extends GenericJson {

    @Key
    private String alternateLink;

    @Key
    private Boolean appDataContents;

    @Key
    private Boolean canComment;

    @Key
    private Boolean canReadRevisions;

    @Key
    private Capabilities capabilities;

    @Key
    private Boolean copyable;

    @Key
    private DateTime createdDate;

    @Key
    private String defaultOpenWithLink;

    @Key
    private String description;

    @Key
    private String downloadUrl;

    @Key
    private Boolean editable;

    @Key
    private String embedLink;

    @Key
    private String etag;

    @Key
    private Boolean explicitlyTrashed;

    @Key
    private Map<String, String> exportLinks;

    @Key
    private String fileExtension;

    @JsonString
    @Key
    private Long fileSize;

    @Key
    private String folderColorRgb;

    @Key
    private String fullFileExtension;

    @Key
    private Boolean hasAugmentedPermissions;

    @Key
    private Boolean hasThumbnail;

    @Key
    private String headRevisionId;

    @Key
    private String iconLink;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3260id;

    @Key
    private ImageMediaMetadata imageMediaMetadata;

    @Key
    private IndexableText indexableText;

    @Key
    private Boolean isAppAuthorized;

    @Key
    private String kind;

    @Key
    private Labels labels;

    @Key
    private User lastModifyingUser;

    @Key
    private String lastModifyingUserName;

    @Key
    private DateTime lastViewedByMeDate;

    @Key
    private DateTime markedViewedByMeDate;

    @Key
    private String md5Checksum;

    @Key
    private String mimeType;

    @Key
    private DateTime modifiedByMeDate;

    @Key
    private DateTime modifiedDate;

    @Key
    private Map<String, String> openWithLinks;

    @Key
    private String originalFilename;

    @Key
    private Boolean ownedByMe;

    @Key
    private List<String> ownerNames;

    @Key
    private List<User> owners;

    @Key
    private List<ParentReference> parents;

    @Key
    private List<Permission> permissions;

    @Key
    private List<Property> properties;

    @JsonString
    @Key
    private Long quotaBytesUsed;

    @Key
    private String selfLink;

    @Key
    private Boolean shareable;

    @Key
    private Boolean shared;

    @Key
    private DateTime sharedWithMeDate;

    @Key
    private User sharingUser;

    @Key
    private List<String> spaces;

    @Key
    private String teamDriveId;

    @Key
    private Thumbnail thumbnail;

    @Key
    private String thumbnailLink;

    @JsonString
    @Key
    private Long thumbnailVersion;

    @Key
    private String title;

    @Key
    private DateTime trashedDate;

    @Key
    private User trashingUser;

    @Key
    private Permission userPermission;

    @JsonString
    @Key
    private Long version;

    @Key
    private VideoMediaMetadata videoMediaMetadata;

    @Key
    private String webContentLink;

    @Key
    private String webViewLink;

    @Key
    private Boolean writersCanShare;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ImageMediaMetadata extends GenericJson {

        @Key
        private Float aperture;

        @Key
        private String cameraMake;

        @Key
        private String cameraModel;

        @Key
        private String colorSpace;

        @Key
        private String date;

        @Key
        private Float exposureBias;

        @Key
        private String exposureMode;

        @Key
        private Float exposureTime;

        @Key
        private Boolean flashUsed;

        @Key
        private Float focalLength;

        @Key
        private Integer height;

        @Key
        private Integer isoSpeed;

        @Key
        private String lens;

        @Key
        private Location location;

        @Key
        private Float maxApertureValue;

        @Key
        private String meteringMode;

        @Key
        private Integer rotation;

        @Key
        private String sensor;

        @Key
        private Integer subjectDistance;

        @Key
        private String whiteBalance;

        @Key
        private Integer width;

        public Float getAperture() {
            return this.aperture;
        }

        public String getCameraMake() {
            return this.cameraMake;
        }

        public String getCameraModel() {
            return this.cameraModel;
        }

        public String getColorSpace() {
            return this.colorSpace;
        }

        public String getDate() {
            return this.date;
        }

        public Float getExposureBias() {
            return this.exposureBias;
        }

        public String getExposureMode() {
            return this.exposureMode;
        }

        public Float getExposureTime() {
            return this.exposureTime;
        }

        public Boolean getFlashUsed() {
            return this.flashUsed;
        }

        public Float getFocalLength() {
            return this.focalLength;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getIsoSpeed() {
            return this.isoSpeed;
        }

        public String getLens() {
            return this.lens;
        }

        public Location getLocation() {
            return this.location;
        }

        public Float getMaxApertureValue() {
            return this.maxApertureValue;
        }

        public String getMeteringMode() {
            return this.meteringMode;
        }

        public Integer getRotation() {
            return this.rotation;
        }

        public String getSensor() {
            return this.sensor;
        }

        public Integer getSubjectDistance() {
            return this.subjectDistance;
        }

        public String getWhiteBalance() {
            return this.whiteBalance;
        }

        public Integer getWidth() {
            return this.width;
        }

        public ImageMediaMetadata setAperture(Float f) {
            this.aperture = f;
            return this;
        }

        public ImageMediaMetadata setCameraMake(String str) {
            this.cameraMake = str;
            return this;
        }

        public ImageMediaMetadata setCameraModel(String str) {
            this.cameraModel = str;
            return this;
        }

        public ImageMediaMetadata setColorSpace(String str) {
            this.colorSpace = str;
            return this;
        }

        public ImageMediaMetadata setDate(String str) {
            this.date = str;
            return this;
        }

        public ImageMediaMetadata setExposureBias(Float f) {
            this.exposureBias = f;
            return this;
        }

        public ImageMediaMetadata setExposureMode(String str) {
            this.exposureMode = str;
            return this;
        }

        public ImageMediaMetadata setExposureTime(Float f) {
            this.exposureTime = f;
            return this;
        }

        public ImageMediaMetadata setFlashUsed(Boolean bool) {
            this.flashUsed = bool;
            return this;
        }

        public ImageMediaMetadata setFocalLength(Float f) {
            this.focalLength = f;
            return this;
        }

        public ImageMediaMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public ImageMediaMetadata setIsoSpeed(Integer num) {
            this.isoSpeed = num;
            return this;
        }

        public ImageMediaMetadata setLens(String str) {
            this.lens = str;
            return this;
        }

        public ImageMediaMetadata setLocation(Location location) {
            this.location = location;
            return this;
        }

        public ImageMediaMetadata setMaxApertureValue(Float f) {
            this.maxApertureValue = f;
            return this;
        }

        public ImageMediaMetadata setMeteringMode(String str) {
            this.meteringMode = str;
            return this;
        }

        public ImageMediaMetadata setRotation(Integer num) {
            this.rotation = num;
            return this;
        }

        public ImageMediaMetadata setSensor(String str) {
            this.sensor = str;
            return this;
        }

        public ImageMediaMetadata setSubjectDistance(Integer num) {
            this.subjectDistance = num;
            return this;
        }

        public ImageMediaMetadata setWhiteBalance(String str) {
            this.whiteBalance = str;
            return this;
        }

        public ImageMediaMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Location extends GenericJson {

            @Key
            private Double altitude;

            @Key
            private Double latitude;

            @Key
            private Double longitude;

            public Double getAltitude() {
                return this.altitude;
            }

            public Double getLatitude() {
                return this.latitude;
            }

            public Double getLongitude() {
                return this.longitude;
            }

            public Location setAltitude(Double d) {
                this.altitude = d;
                return this;
            }

            public Location setLatitude(Double d) {
                this.latitude = d;
                return this;
            }

            public Location setLongitude(Double d) {
                this.longitude = d;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Location set(String str, Object obj) {
                return (Location) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Location clone() {
                return (Location) super.clone();
            }
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public ImageMediaMetadata set(String str, Object obj) {
            return (ImageMediaMetadata) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public ImageMediaMetadata clone() {
            return (ImageMediaMetadata) super.clone();
        }
    }

    public String getAlternateLink() {
        return this.alternateLink;
    }

    public Boolean getAppDataContents() {
        return this.appDataContents;
    }

    public Boolean getCanComment() {
        return this.canComment;
    }

    public Boolean getCanReadRevisions() {
        return this.canReadRevisions;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public Boolean getCopyable() {
        return this.copyable;
    }

    public DateTime getCreatedDate() {
        return this.createdDate;
    }

    public String getDefaultOpenWithLink() {
        return this.defaultOpenWithLink;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public Boolean getEditable() {
        return this.editable;
    }

    public String getEmbedLink() {
        return this.embedLink;
    }

    public String getEtag() {
        return this.etag;
    }

    public Boolean getExplicitlyTrashed() {
        return this.explicitlyTrashed;
    }

    public Map<String, String> getExportLinks() {
        return this.exportLinks;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public String getFolderColorRgb() {
        return this.folderColorRgb;
    }

    public String getFullFileExtension() {
        return this.fullFileExtension;
    }

    public Boolean getHasAugmentedPermissions() {
        return this.hasAugmentedPermissions;
    }

    public Boolean getHasThumbnail() {
        return this.hasThumbnail;
    }

    public String getHeadRevisionId() {
        return this.headRevisionId;
    }

    public String getIconLink() {
        return this.iconLink;
    }

    public String getId() {
        return this.f3260id;
    }

    public ImageMediaMetadata getImageMediaMetadata() {
        return this.imageMediaMetadata;
    }

    public IndexableText getIndexableText() {
        return this.indexableText;
    }

    public Boolean getIsAppAuthorized() {
        return this.isAppAuthorized;
    }

    public String getKind() {
        return this.kind;
    }

    public Labels getLabels() {
        return this.labels;
    }

    public User getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getLastModifyingUserName() {
        return this.lastModifyingUserName;
    }

    public DateTime getLastViewedByMeDate() {
        return this.lastViewedByMeDate;
    }

    public DateTime getMarkedViewedByMeDate() {
        return this.markedViewedByMeDate;
    }

    public String getMd5Checksum() {
        return this.md5Checksum;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public DateTime getModifiedByMeDate() {
        return this.modifiedByMeDate;
    }

    public DateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public Map<String, String> getOpenWithLinks() {
        return this.openWithLinks;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getOwnedByMe() {
        return this.ownedByMe;
    }

    public List<String> getOwnerNames() {
        return this.ownerNames;
    }

    public List<User> getOwners() {
        return this.owners;
    }

    public List<ParentReference> getParents() {
        return this.parents;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public Long getQuotaBytesUsed() {
        return this.quotaBytesUsed;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public Boolean getShareable() {
        return this.shareable;
    }

    public Boolean getShared() {
        return this.shared;
    }

    public DateTime getSharedWithMeDate() {
        return this.sharedWithMeDate;
    }

    public User getSharingUser() {
        return this.sharingUser;
    }

    public List<String> getSpaces() {
        return this.spaces;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public String getThumbnailLink() {
        return this.thumbnailLink;
    }

    public Long getThumbnailVersion() {
        return this.thumbnailVersion;
    }

    public String getTitle() {
        return this.title;
    }

    public DateTime getTrashedDate() {
        return this.trashedDate;
    }

    public User getTrashingUser() {
        return this.trashingUser;
    }

    public Permission getUserPermission() {
        return this.userPermission;
    }

    public Long getVersion() {
        return this.version;
    }

    public VideoMediaMetadata getVideoMediaMetadata() {
        return this.videoMediaMetadata;
    }

    public String getWebContentLink() {
        return this.webContentLink;
    }

    public String getWebViewLink() {
        return this.webViewLink;
    }

    public Boolean getWritersCanShare() {
        return this.writersCanShare;
    }

    public File setAlternateLink(String str) {
        this.alternateLink = str;
        return this;
    }

    public File setAppDataContents(Boolean bool) {
        this.appDataContents = bool;
        return this;
    }

    public File setCanComment(Boolean bool) {
        this.canComment = bool;
        return this;
    }

    public File setCanReadRevisions(Boolean bool) {
        this.canReadRevisions = bool;
        return this;
    }

    public File setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public File setCopyable(Boolean bool) {
        this.copyable = bool;
        return this;
    }

    public File setCreatedDate(DateTime dateTime) {
        this.createdDate = dateTime;
        return this;
    }

    public File setDefaultOpenWithLink(String str) {
        this.defaultOpenWithLink = str;
        return this;
    }

    public File setDescription(String str) {
        this.description = str;
        return this;
    }

    public File setDownloadUrl(String str) {
        this.downloadUrl = str;
        return this;
    }

    public File setEditable(Boolean bool) {
        this.editable = bool;
        return this;
    }

    public File setEmbedLink(String str) {
        this.embedLink = str;
        return this;
    }

    public File setEtag(String str) {
        this.etag = str;
        return this;
    }

    public File setExplicitlyTrashed(Boolean bool) {
        this.explicitlyTrashed = bool;
        return this;
    }

    public File setExportLinks(Map<String, String> map) {
        this.exportLinks = map;
        return this;
    }

    public File setFileExtension(String str) {
        this.fileExtension = str;
        return this;
    }

    public File setFileSize(Long l) {
        this.fileSize = l;
        return this;
    }

    public File setFolderColorRgb(String str) {
        this.folderColorRgb = str;
        return this;
    }

    public File setFullFileExtension(String str) {
        this.fullFileExtension = str;
        return this;
    }

    public File setHasAugmentedPermissions(Boolean bool) {
        this.hasAugmentedPermissions = bool;
        return this;
    }

    public File setHasThumbnail(Boolean bool) {
        this.hasThumbnail = bool;
        return this;
    }

    public File setHeadRevisionId(String str) {
        this.headRevisionId = str;
        return this;
    }

    public File setIconLink(String str) {
        this.iconLink = str;
        return this;
    }

    public File setId(String str) {
        this.f3260id = str;
        return this;
    }

    public File setImageMediaMetadata(ImageMediaMetadata imageMediaMetadata) {
        this.imageMediaMetadata = imageMediaMetadata;
        return this;
    }

    public File setIndexableText(IndexableText indexableText) {
        this.indexableText = indexableText;
        return this;
    }

    public File setIsAppAuthorized(Boolean bool) {
        this.isAppAuthorized = bool;
        return this;
    }

    public File setKind(String str) {
        this.kind = str;
        return this;
    }

    public File setLabels(Labels labels) {
        this.labels = labels;
        return this;
    }

    public File setLastModifyingUser(User user) {
        this.lastModifyingUser = user;
        return this;
    }

    public File setLastModifyingUserName(String str) {
        this.lastModifyingUserName = str;
        return this;
    }

    public File setLastViewedByMeDate(DateTime dateTime) {
        this.lastViewedByMeDate = dateTime;
        return this;
    }

    public File setMarkedViewedByMeDate(DateTime dateTime) {
        this.markedViewedByMeDate = dateTime;
        return this;
    }

    public File setMd5Checksum(String str) {
        this.md5Checksum = str;
        return this;
    }

    public File setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public File setModifiedByMeDate(DateTime dateTime) {
        this.modifiedByMeDate = dateTime;
        return this;
    }

    public File setModifiedDate(DateTime dateTime) {
        this.modifiedDate = dateTime;
        return this;
    }

    public File setOpenWithLinks(Map<String, String> map) {
        this.openWithLinks = map;
        return this;
    }

    public File setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public File setOwnedByMe(Boolean bool) {
        this.ownedByMe = bool;
        return this;
    }

    public File setOwnerNames(List<String> list) {
        this.ownerNames = list;
        return this;
    }

    public File setOwners(List<User> list) {
        this.owners = list;
        return this;
    }

    public File setParents(List<ParentReference> list) {
        this.parents = list;
        return this;
    }

    public File setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    public File setProperties(List<Property> list) {
        this.properties = list;
        return this;
    }

    public File setQuotaBytesUsed(Long l) {
        this.quotaBytesUsed = l;
        return this;
    }

    public File setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public File setShareable(Boolean bool) {
        this.shareable = bool;
        return this;
    }

    public File setShared(Boolean bool) {
        this.shared = bool;
        return this;
    }

    public File setSharedWithMeDate(DateTime dateTime) {
        this.sharedWithMeDate = dateTime;
        return this;
    }

    public File setSharingUser(User user) {
        this.sharingUser = user;
        return this;
    }

    public File setSpaces(List<String> list) {
        this.spaces = list;
        return this;
    }

    public File setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public File setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public File setThumbnailLink(String str) {
        this.thumbnailLink = str;
        return this;
    }

    public File setThumbnailVersion(Long l) {
        this.thumbnailVersion = l;
        return this;
    }

    public File setTitle(String str) {
        this.title = str;
        return this;
    }

    public File setTrashedDate(DateTime dateTime) {
        this.trashedDate = dateTime;
        return this;
    }

    public File setTrashingUser(User user) {
        this.trashingUser = user;
        return this;
    }

    public File setUserPermission(Permission permission) {
        this.userPermission = permission;
        return this;
    }

    public File setVersion(Long l) {
        this.version = l;
        return this;
    }

    public File setVideoMediaMetadata(VideoMediaMetadata videoMediaMetadata) {
        this.videoMediaMetadata = videoMediaMetadata;
        return this;
    }

    public File setWebContentLink(String str) {
        this.webContentLink = str;
        return this;
    }

    public File setWebViewLink(String str) {
        this.webViewLink = str;
        return this;
    }

    public File setWritersCanShare(Boolean bool) {
        this.writersCanShare = bool;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Capabilities extends GenericJson {

        @Key
        private Boolean canAddChildren;

        @Key
        private Boolean canComment;

        @Key
        private Boolean canCopy;

        @Key
        private Boolean canDelete;

        @Key
        private Boolean canDownload;

        @Key
        private Boolean canEdit;

        @Key
        private Boolean canListChildren;

        @Key
        private Boolean canMoveItemIntoTeamDrive;

        @Key
        private Boolean canMoveTeamDriveItem;

        @Key
        private Boolean canReadRevisions;

        @Key
        private Boolean canReadTeamDrive;

        @Key
        private Boolean canRemoveChildren;

        @Key
        private Boolean canRename;

        @Key
        private Boolean canShare;

        @Key
        private Boolean canTrash;

        @Key
        private Boolean canUntrash;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Boolean getCanDelete() {
            return this.canDelete;
        }

        public Boolean getCanDownload() {
            return this.canDownload;
        }

        public Boolean getCanEdit() {
            return this.canEdit;
        }

        public Boolean getCanListChildren() {
            return this.canListChildren;
        }

        public Boolean getCanMoveItemIntoTeamDrive() {
            return this.canMoveItemIntoTeamDrive;
        }

        public Boolean getCanMoveTeamDriveItem() {
            return this.canMoveTeamDriveItem;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Boolean getCanReadTeamDrive() {
            return this.canReadTeamDrive;
        }

        public Boolean getCanRemoveChildren() {
            return this.canRemoveChildren;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Boolean getCanShare() {
            return this.canShare;
        }

        public Boolean getCanTrash() {
            return this.canTrash;
        }

        public Boolean getCanUntrash() {
            return this.canUntrash;
        }

        public Capabilities setCanAddChildren(Boolean bool) {
            this.canAddChildren = bool;
            return this;
        }

        public Capabilities setCanComment(Boolean bool) {
            this.canComment = bool;
            return this;
        }

        public Capabilities setCanCopy(Boolean bool) {
            this.canCopy = bool;
            return this;
        }

        public Capabilities setCanDelete(Boolean bool) {
            this.canDelete = bool;
            return this;
        }

        public Capabilities setCanDownload(Boolean bool) {
            this.canDownload = bool;
            return this;
        }

        public Capabilities setCanEdit(Boolean bool) {
            this.canEdit = bool;
            return this;
        }

        public Capabilities setCanListChildren(Boolean bool) {
            this.canListChildren = bool;
            return this;
        }

        public Capabilities setCanMoveItemIntoTeamDrive(Boolean bool) {
            this.canMoveItemIntoTeamDrive = bool;
            return this;
        }

        public Capabilities setCanMoveTeamDriveItem(Boolean bool) {
            this.canMoveTeamDriveItem = bool;
            return this;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
            return this;
        }

        public Capabilities setCanReadTeamDrive(Boolean bool) {
            this.canReadTeamDrive = bool;
            return this;
        }

        public Capabilities setCanRemoveChildren(Boolean bool) {
            this.canRemoveChildren = bool;
            return this;
        }

        public Capabilities setCanRename(Boolean bool) {
            this.canRename = bool;
            return this;
        }

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
            return this;
        }

        public Capabilities setCanTrash(Boolean bool) {
            this.canTrash = bool;
            return this;
        }

        public Capabilities setCanUntrash(Boolean bool) {
            this.canUntrash = bool;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Capabilities set(String str, Object obj) {
            return (Capabilities) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Capabilities clone() {
            return (Capabilities) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class IndexableText extends GenericJson {

        @Key
        private String text;

        public String getText() {
            return this.text;
        }

        public IndexableText setText(String str) {
            this.text = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public IndexableText set(String str, Object obj) {
            return (IndexableText) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public IndexableText clone() {
            return (IndexableText) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Labels extends GenericJson {

        @Key
        private Boolean hidden;

        @Key
        private Boolean modified;

        @Key
        private Boolean restricted;

        @Key
        private Boolean starred;

        @Key
        private Boolean trashed;

        @Key
        private Boolean viewed;

        public Boolean getHidden() {
            return this.hidden;
        }

        public Boolean getModified() {
            return this.modified;
        }

        public Boolean getRestricted() {
            return this.restricted;
        }

        public Boolean getStarred() {
            return this.starred;
        }

        public Boolean getTrashed() {
            return this.trashed;
        }

        public Boolean getViewed() {
            return this.viewed;
        }

        public Labels setHidden(Boolean bool) {
            this.hidden = bool;
            return this;
        }

        public Labels setModified(Boolean bool) {
            this.modified = bool;
            return this;
        }

        public Labels setRestricted(Boolean bool) {
            this.restricted = bool;
            return this;
        }

        public Labels setStarred(Boolean bool) {
            this.starred = bool;
            return this;
        }

        public Labels setTrashed(Boolean bool) {
            this.trashed = bool;
            return this;
        }

        public Labels setViewed(Boolean bool) {
            this.viewed = bool;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Labels set(String str, Object obj) {
            return (Labels) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Labels clone() {
            return (Labels) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Thumbnail extends GenericJson {

        @Key
        private String image;

        @Key
        private String mimeType;

        public byte[] decodeImage() {
            return Base64.decodeBase64(this.image);
        }

        public Thumbnail encodeImage(byte[] bArr) {
            this.image = Base64.encodeBase64URLSafeString(bArr);
            return this;
        }

        public String getImage() {
            return this.image;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public Thumbnail setImage(String str) {
            this.image = str;
            return this;
        }

        public Thumbnail setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Thumbnail set(String str, Object obj) {
            return (Thumbnail) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Thumbnail clone() {
            return (Thumbnail) super.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class VideoMediaMetadata extends GenericJson {

        @JsonString
        @Key
        private Long durationMillis;

        @Key
        private Integer height;

        @Key
        private Integer width;

        public Long getDurationMillis() {
            return this.durationMillis;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public VideoMediaMetadata setDurationMillis(Long l) {
            this.durationMillis = l;
            return this;
        }

        public VideoMediaMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public VideoMediaMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public VideoMediaMetadata set(String str, Object obj) {
            return (VideoMediaMetadata) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public VideoMediaMetadata clone() {
            return (VideoMediaMetadata) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public File set(String str, Object obj) {
        return (File) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public File clone() {
        return (File) super.clone();
    }
}
