package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class TeamDrive extends GenericJson {

    @Key
    private Capabilities capabilities;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3265id;

    @Key
    private String kind;

    @Key
    private String name;

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public String getId() {
        return this.f3265id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public TeamDrive setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public TeamDrive setId(String str) {
        this.f3265id = str;
        return this;
    }

    public TeamDrive setKind(String str) {
        this.kind = str;
        return this;
    }

    public TeamDrive setName(String str) {
        this.name = str;
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
        private Boolean canDeleteTeamDrive;

        @Key
        private Boolean canDownload;

        @Key
        private Boolean canEdit;

        @Key
        private Boolean canListChildren;

        @Key
        private Boolean canManageMembers;

        @Key
        private Boolean canReadRevisions;

        @Key
        private Boolean canRemoveChildren;

        @Key
        private Boolean canRename;

        @Key
        private Boolean canRenameTeamDrive;

        @Key
        private Boolean canShare;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Boolean getCanDeleteTeamDrive() {
            return this.canDeleteTeamDrive;
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

        public Boolean getCanManageMembers() {
            return this.canManageMembers;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Boolean getCanRemoveChildren() {
            return this.canRemoveChildren;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Boolean getCanRenameTeamDrive() {
            return this.canRenameTeamDrive;
        }

        public Boolean getCanShare() {
            return this.canShare;
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

        public Capabilities setCanDeleteTeamDrive(Boolean bool) {
            this.canDeleteTeamDrive = bool;
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

        public Capabilities setCanManageMembers(Boolean bool) {
            this.canManageMembers = bool;
            return this;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
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

        public Capabilities setCanRenameTeamDrive(Boolean bool) {
            this.canRenameTeamDrive = bool;
            return this;
        }

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
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

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public TeamDrive set(String str, Object obj) {
        return (TeamDrive) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public TeamDrive clone() {
        return (TeamDrive) super.clone();
    }
}
