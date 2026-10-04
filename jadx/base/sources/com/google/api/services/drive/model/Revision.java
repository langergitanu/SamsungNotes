package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Revision extends GenericJson {

    @Key
    private String downloadUrl;

    @Key
    private String etag;

    @Key
    private Map<String, String> exportLinks;

    @JsonString
    @Key
    private Long fileSize;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3264id;

    @Key
    private String kind;

    @Key
    private User lastModifyingUser;

    @Key
    private String lastModifyingUserName;

    @Key
    private String md5Checksum;

    @Key
    private String mimeType;

    @Key
    private DateTime modifiedDate;

    @Key
    private String originalFilename;

    @Key
    private Boolean pinned;

    @Key
    private Boolean publishAuto;

    @Key
    private Boolean published;

    @Key
    private String publishedLink;

    @Key
    private Boolean publishedOutsideDomain;

    @Key
    private String selfLink;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getEtag() {
        return this.etag;
    }

    public Map<String, String> getExportLinks() {
        return this.exportLinks;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public String getId() {
        return this.f3264id;
    }

    public String getKind() {
        return this.kind;
    }

    public User getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getLastModifyingUserName() {
        return this.lastModifyingUserName;
    }

    public String getMd5Checksum() {
        return this.md5Checksum;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public DateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getPinned() {
        return this.pinned;
    }

    public Boolean getPublishAuto() {
        return this.publishAuto;
    }

    public Boolean getPublished() {
        return this.published;
    }

    public String getPublishedLink() {
        return this.publishedLink;
    }

    public Boolean getPublishedOutsideDomain() {
        return this.publishedOutsideDomain;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public Revision setDownloadUrl(String str) {
        this.downloadUrl = str;
        return this;
    }

    public Revision setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Revision setExportLinks(Map<String, String> map) {
        this.exportLinks = map;
        return this;
    }

    public Revision setFileSize(Long l) {
        this.fileSize = l;
        return this;
    }

    public Revision setId(String str) {
        this.f3264id = str;
        return this;
    }

    public Revision setKind(String str) {
        this.kind = str;
        return this;
    }

    public Revision setLastModifyingUser(User user) {
        this.lastModifyingUser = user;
        return this;
    }

    public Revision setLastModifyingUserName(String str) {
        this.lastModifyingUserName = str;
        return this;
    }

    public Revision setMd5Checksum(String str) {
        this.md5Checksum = str;
        return this;
    }

    public Revision setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public Revision setModifiedDate(DateTime dateTime) {
        this.modifiedDate = dateTime;
        return this;
    }

    public Revision setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public Revision setPinned(Boolean bool) {
        this.pinned = bool;
        return this;
    }

    public Revision setPublishAuto(Boolean bool) {
        this.publishAuto = bool;
        return this;
    }

    public Revision setPublished(Boolean bool) {
        this.published = bool;
        return this;
    }

    public Revision setPublishedLink(String str) {
        this.publishedLink = str;
        return this;
    }

    public Revision setPublishedOutsideDomain(Boolean bool) {
        this.publishedOutsideDomain = bool;
        return this;
    }

    public Revision setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Revision set(String str, Object obj) {
        return (Revision) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Revision clone() {
        return (Revision) super.clone();
    }
}
