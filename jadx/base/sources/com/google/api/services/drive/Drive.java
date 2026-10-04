package com.google.api.services.drive;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.drive.model.App;
import com.google.api.services.drive.model.AppList;
import com.google.api.services.drive.model.Change;
import com.google.api.services.drive.model.ChangeList;
import com.google.api.services.drive.model.Channel;
import com.google.api.services.drive.model.ChildList;
import com.google.api.services.drive.model.ChildReference;
import com.google.api.services.drive.model.Comment;
import com.google.api.services.drive.model.CommentList;
import com.google.api.services.drive.model.CommentReply;
import com.google.api.services.drive.model.CommentReplyList;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.GeneratedIds;
import com.google.api.services.drive.model.ParentList;
import com.google.api.services.drive.model.ParentReference;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.drive.model.PermissionId;
import com.google.api.services.drive.model.PermissionList;
import com.google.api.services.drive.model.Property;
import com.google.api.services.drive.model.PropertyList;
import com.google.api.services.drive.model.Revision;
import com.google.api.services.drive.model.RevisionList;
import com.google.api.services.drive.model.StartPageToken;
import com.google.api.services.drive.model.TeamDrive;
import com.google.api.services.drive.model.TeamDriveList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Drive extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://www.googleapis.com/drive/v2/";
    public static final String DEFAULT_ROOT_URL = "https://www.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "drive/v2/";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class About {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<com.google.api.services.drive.model.About> {
            private static final String REST_PATH = "about";

            @Key
            private Boolean includeSubscribed;

            @Key
            private Long maxChangeIdCount;

            @Key
            private Long startChangeId;

            public Get() {
                super(Drive.this, "GET", REST_PATH, null, com.google.api.services.drive.model.About.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public Boolean getIncludeSubscribed() {
                return this.includeSubscribed;
            }

            public Long getMaxChangeIdCount() {
                return this.maxChangeIdCount;
            }

            public Long getStartChangeId() {
                return this.startChangeId;
            }

            public boolean isIncludeSubscribed() {
                Boolean bool = this.includeSubscribed;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public Get setIncludeSubscribed(Boolean bool) {
                this.includeSubscribed = bool;
                return this;
            }

            public Get setMaxChangeIdCount(Long l) {
                this.maxChangeIdCount = l;
                return this;
            }

            public Get setStartChangeId(Long l) {
                this.startChangeId = l;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public About() {
        }

        public Get get() {
            Get get = new Get();
            Drive.this.initialize(get);
            return get;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Apps {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<App> {
            private static final String REST_PATH = "apps/{appId}";

            @Key
            private String appId;

            public Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, App.class);
                this.appId = (String) Preconditions.checkNotNull(str, "Required parameter appId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getAppId() {
                return this.appId;
            }

            public Get setAppId(String str) {
                this.appId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<App> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<App> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<App> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<App> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<App> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<App> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<App> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<AppList> {
            private static final String REST_PATH = "apps";

            @Key
            private String appFilterExtensions;

            @Key
            private String appFilterMimeTypes;

            @Key
            private String languageCode;

            public List() {
                super(Drive.this, "GET", "apps", null, AppList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getAppFilterExtensions() {
                return this.appFilterExtensions;
            }

            public String getAppFilterMimeTypes() {
                return this.appFilterMimeTypes;
            }

            public String getLanguageCode() {
                return this.languageCode;
            }

            public List setAppFilterExtensions(String str) {
                this.appFilterExtensions = str;
                return this;
            }

            public List setAppFilterMimeTypes(String str) {
                this.appFilterMimeTypes = str;
                return this;
            }

            public List setLanguageCode(String str) {
                this.languageCode = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<AppList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<AppList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<AppList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<AppList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<AppList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<AppList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<AppList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Apps() {
        }

        public Get get(String str) {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public List list() {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Changes {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<Change> {
            private static final String REST_PATH = "changes/{changeId}";

            @Key
            private String changeId;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            public Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, Change.class);
                this.changeId = (String) Preconditions.checkNotNull(str, "Required parameter changeId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getChangeId() {
                return this.changeId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setChangeId(String str) {
                this.changeId = str;
                return this;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Get setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Change> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Change> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Change> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Change> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Change> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Change> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Change> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class GetStartPageToken extends DriveRequest<StartPageToken> {
            private static final String REST_PATH = "changes/startPageToken";

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            public GetStartPageToken() {
                super(Drive.this, "GET", REST_PATH, null, StartPageToken.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public GetStartPageToken setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public GetStartPageToken setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<StartPageToken> setAlt2(String str) {
                return (GetStartPageToken) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<StartPageToken> setFields2(String str) {
                return (GetStartPageToken) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<StartPageToken> setKey2(String str) {
                return (GetStartPageToken) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<StartPageToken> setOauthToken2(String str) {
                return (GetStartPageToken) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<StartPageToken> setPrettyPrint2(Boolean bool) {
                return (GetStartPageToken) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<StartPageToken> setQuotaUser2(String str) {
                return (GetStartPageToken) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<StartPageToken> setUserIp2(String str) {
                return (GetStartPageToken) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GetStartPageToken set(String str, Object obj) {
                return (GetStartPageToken) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<ChangeList> {
            private static final String REST_PATH = "changes";

            @Key
            private Boolean includeCorpusRemovals;

            @Key
            private Boolean includeDeleted;

            @Key
            private Boolean includeSubscribed;

            @Key
            private Boolean includeTeamDriveItems;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private String spaces;

            @Key
            private Long startChangeId;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            public List() {
                super(Drive.this, "GET", REST_PATH, null, ChangeList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public Boolean getIncludeCorpusRemovals() {
                return this.includeCorpusRemovals;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Boolean getIncludeSubscribed() {
                return this.includeSubscribed;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Long getStartChangeId() {
                return this.startChangeId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isIncludeCorpusRemovals() {
                Boolean bool = this.includeCorpusRemovals;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeSubscribed() {
                Boolean bool = this.includeSubscribed;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setIncludeCorpusRemovals(Boolean bool) {
                this.includeCorpusRemovals = bool;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setIncludeSubscribed(Boolean bool) {
                this.includeSubscribed = bool;
                return this;
            }

            public List setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public List setStartChangeId(Long l) {
                this.startChangeId = l;
                return this;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public List setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ChangeList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ChangeList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ChangeList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ChangeList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ChangeList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ChangeList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ChangeList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "changes/watch";

            @Key
            private Boolean includeCorpusRemovals;

            @Key
            private Boolean includeDeleted;

            @Key
            private Boolean includeSubscribed;

            @Key
            private Boolean includeTeamDriveItems;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private String spaces;

            @Key
            private Long startChangeId;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            public Watch(Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
            }

            public Boolean getIncludeCorpusRemovals() {
                return this.includeCorpusRemovals;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Boolean getIncludeSubscribed() {
                return this.includeSubscribed;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Long getStartChangeId() {
                return this.startChangeId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isIncludeCorpusRemovals() {
                Boolean bool = this.includeCorpusRemovals;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeSubscribed() {
                Boolean bool = this.includeSubscribed;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Watch setIncludeCorpusRemovals(Boolean bool) {
                this.includeCorpusRemovals = bool;
                return this;
            }

            public Watch setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public Watch setIncludeSubscribed(Boolean bool) {
                this.includeSubscribed = bool;
                return this;
            }

            public Watch setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public Watch setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public Watch setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Watch setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Watch setStartChangeId(Long l) {
                this.startChangeId = l;
                return this;
            }

            public Watch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Watch setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Channel> setUserIp2(String str) {
                return (Watch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }

        public Changes() {
        }

        public Get get(String str) {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public GetStartPageToken getStartPageToken() {
            GetStartPageToken getStartPageToken = new GetStartPageToken();
            Drive.this.initialize(getStartPageToken);
            return getStartPageToken;
        }

        public List list() {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public Watch watch(Channel channel) {
            Watch watch = new Watch(channel);
            Drive.this.initialize(watch);
            return watch;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Channels {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Stop extends DriveRequest<Void> {
            private static final String REST_PATH = "channels/stop";

            public Stop(Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Stop) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Stop) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Stop) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Stop) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Stop) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Stop) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Stop) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Stop set(String str, Object obj) {
                return (Stop) super.set(str, obj);
            }
        }

        public Channels() {
        }

        public Stop stop(Channel channel) {
            Stop stop = new Stop(channel);
            Drive.this.initialize(stop);
            return stop;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Children {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{folderId}/children/{childId}";

            @Key
            private String childId;

            @Key
            private String folderId;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.folderId = (String) Preconditions.checkNotNull(str, "Required parameter folderId must be specified.");
                this.childId = (String) Preconditions.checkNotNull(str2, "Required parameter childId must be specified.");
            }

            public String getChildId() {
                return this.childId;
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Delete setChildId(String str) {
                this.childId = str;
                return this;
            }

            public Delete setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<ChildReference> {
            private static final String REST_PATH = "files/{folderId}/children/{childId}";

            @Key
            private String childId;

            @Key
            private String folderId;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, ChildReference.class);
                this.folderId = (String) Preconditions.checkNotNull(str, "Required parameter folderId must be specified.");
                this.childId = (String) Preconditions.checkNotNull(str2, "Required parameter childId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getChildId() {
                return this.childId;
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Get setChildId(String str) {
                this.childId = str;
                return this;
            }

            public Get setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ChildReference> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ChildReference> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ChildReference> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ChildReference> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ChildReference> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ChildReference> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ChildReference> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<ChildReference> {
            private static final String REST_PATH = "files/{folderId}/children";

            @Key
            private String folderId;

            @Key
            private Boolean supportsTeamDrives;

            public Insert(String str, ChildReference childReference) {
                super(Drive.this, "POST", REST_PATH, childReference, ChildReference.class);
                this.folderId = (String) Preconditions.checkNotNull(str, "Required parameter folderId must be specified.");
                checkRequiredParameter(childReference, "content");
                checkRequiredParameter(childReference.getId(), "ChildReference.getId()");
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Insert setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            public Insert setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ChildReference> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ChildReference> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ChildReference> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ChildReference> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ChildReference> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ChildReference> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ChildReference> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<ChildList> {
            private static final String REST_PATH = "files/{folderId}/children";

            @Key
            private String folderId;

            @Key
            private Integer maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            /* JADX INFO: renamed from: q */
            @Key
            private String f3254q;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, ChildList.class);
                this.folderId = (String) Preconditions.checkNotNull(str, "Required parameter folderId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getQ() {
                return this.f3254q;
            }

            public List setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setQ(String str) {
                this.f3254q = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ChildList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ChildList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ChildList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ChildList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ChildList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ChildList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ChildList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Children() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(String str, ChildReference childReference) {
            Insert insert = new Insert(str, childReference);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list(String str) {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Comments {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @Key
            private String fileId;

            public Insert(String str, Comment comment) {
                super(Drive.this, "POST", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<CommentList> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private String updatedMin;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, CommentList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getUpdatedMin() {
                return this.updatedMin;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setUpdatedMin(String str) {
                this.updatedMin = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<CommentList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<CommentList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<CommentList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<CommentList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<CommentList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Patch extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            public Patch(String str, String str2, Comment comment) {
                super(Drive.this, "PATCH", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            public Update(String str, String str2, Comment comment) {
                super(Drive.this, "PUT", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Comments() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(String str, Comment comment) {
            Insert insert = new Insert(str, comment);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list(String str) {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Patch patch(String str, String str2, Comment comment) {
            Patch patch = new Patch(str, str2, comment);
            Drive.this.initialize(patch);
            return patch;
        }

        public Update update(String str, String str2, Comment comment) {
            Update update = new Update(str, str2, comment);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Parents {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/parents/{parentId}";

            @Key
            private String fileId;

            @Key
            private String parentId;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.parentId = (String) Preconditions.checkNotNull(str2, "Required parameter parentId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getParentId() {
                return this.parentId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setParentId(String str) {
                this.parentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<ParentReference> {
            private static final String REST_PATH = "files/{fileId}/parents/{parentId}";

            @Key
            private String fileId;

            @Key
            private String parentId;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, ParentReference.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.parentId = (String) Preconditions.checkNotNull(str2, "Required parameter parentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getParentId() {
                return this.parentId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setParentId(String str) {
                this.parentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ParentReference> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ParentReference> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ParentReference> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ParentReference> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ParentReference> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ParentReference> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ParentReference> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<ParentReference> {
            private static final String REST_PATH = "files/{fileId}/parents";

            @Key
            private String fileId;

            @Key
            private Boolean supportsTeamDrives;

            public Insert(String str, ParentReference parentReference) {
                super(Drive.this, "POST", REST_PATH, parentReference, ParentReference.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(parentReference, "content");
                checkRequiredParameter(parentReference.getId(), "ParentReference.getId()");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Insert setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ParentReference> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ParentReference> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ParentReference> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ParentReference> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ParentReference> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ParentReference> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ParentReference> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<ParentList> {
            private static final String REST_PATH = "files/{fileId}/parents";

            @Key
            private String fileId;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, ParentList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<ParentList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<ParentList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<ParentList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<ParentList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<ParentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<ParentList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<ParentList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Parents() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(String str, ParentReference parentReference) {
            Insert insert = new Insert(str, parentReference);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list(String str) {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Permissions {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean supportsTeamDrives;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Delete setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean supportsTeamDrives;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class GetIdForEmail extends DriveRequest<PermissionId> {
            private static final String REST_PATH = "permissionIds/{email}";

            @Key
            private String email;

            public GetIdForEmail(String str) {
                super(Drive.this, "GET", REST_PATH, null, PermissionId.class);
                this.email = (String) Preconditions.checkNotNull(str, "Required parameter email must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getEmail() {
                return this.email;
            }

            public GetIdForEmail setEmail(String str) {
                this.email = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<PermissionId> setAlt2(String str) {
                return (GetIdForEmail) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<PermissionId> setFields2(String str) {
                return (GetIdForEmail) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<PermissionId> setKey2(String str) {
                return (GetIdForEmail) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<PermissionId> setOauthToken2(String str) {
                return (GetIdForEmail) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<PermissionId> setPrettyPrint2(Boolean bool) {
                return (GetIdForEmail) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<PermissionId> setQuotaUser2(String str) {
                return (GetIdForEmail) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<PermissionId> setUserIp2(String str) {
                return (GetIdForEmail) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GetIdForEmail set(String str, Object obj) {
                return (GetIdForEmail) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions";

            @Key
            private String emailMessage;

            @Key
            private String fileId;

            @Key
            private Boolean sendNotificationEmails;

            @Key
            private Boolean supportsTeamDrives;

            public Insert(String str, Permission permission) {
                super(Drive.this, "POST", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getRole(), "Permission.getRole()");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getType(), "Permission.getType()");
            }

            public String getEmailMessage() {
                return this.emailMessage;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSendNotificationEmails() {
                return this.sendNotificationEmails;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSendNotificationEmails() {
                Boolean bool = this.sendNotificationEmails;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Insert setEmailMessage(String str) {
                this.emailMessage = str;
                return this;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Insert setSendNotificationEmails(Boolean bool) {
                this.sendNotificationEmails = bool;
                return this;
            }

            public Insert setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<PermissionList> {
            private static final String REST_PATH = "files/{fileId}/permissions";

            @Key
            private String fileId;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private Boolean supportsTeamDrives;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, PermissionList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<PermissionList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<PermissionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<PermissionList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<PermissionList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<PermissionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<PermissionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<PermissionList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Patch extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean removeExpiration;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean transferOwnership;

            public Patch(String str, String str2, Permission permission) {
                super(Drive.this, "PATCH", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getRemoveExpiration() {
                return this.removeExpiration;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public boolean isRemoveExpiration() {
                Boolean bool = this.removeExpiration;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isTransferOwnership() {
                Boolean bool = this.transferOwnership;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Patch setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Patch setRemoveExpiration(Boolean bool) {
                this.removeExpiration = bool;
                return this;
            }

            public Patch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Patch setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean removeExpiration;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean transferOwnership;

            public Update(String str, String str2, Permission permission) {
                super(Drive.this, "PUT", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Boolean getRemoveExpiration() {
                return this.removeExpiration;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public boolean isRemoveExpiration() {
                Boolean bool = this.removeExpiration;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isTransferOwnership() {
                Boolean bool = this.transferOwnership;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Update setRemoveExpiration(Boolean bool) {
                this.removeExpiration = bool;
                return this;
            }

            public Update setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Update setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Permissions() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public GetIdForEmail getIdForEmail(String str) {
            GetIdForEmail getIdForEmail = new GetIdForEmail(str);
            Drive.this.initialize(getIdForEmail);
            return getIdForEmail;
        }

        public Insert insert(String str, Permission permission) {
            Insert insert = new Insert(str, permission);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list(String str) {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Patch patch(String str, String str2, Permission permission) {
            Patch patch = new Patch(str, str2, permission);
            Drive.this.initialize(patch);
            return patch;
        }

        public Update update(String str, String str2, Permission permission) {
            Update update = new Update(str, str2, permission);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Properties {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.checkNotNull(str2, "Required parameter propertyKey must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public Delete setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Property.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.checkNotNull(str2, "Required parameter propertyKey must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public Get setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties";

            @Key
            private String fileId;

            public Insert(String str, Property property) {
                super(Drive.this, "POST", REST_PATH, property, Property.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<PropertyList> {
            private static final String REST_PATH = "files/{fileId}/properties";

            @Key
            private String fileId;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, PropertyList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<PropertyList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<PropertyList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<PropertyList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<PropertyList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<PropertyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<PropertyList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<PropertyList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Patch extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            public Patch(String str, String str2, Property property) {
                super(Drive.this, "PATCH", REST_PATH, property, Property.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.checkNotNull(str2, "Required parameter propertyKey must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Patch setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public Patch setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            public Update(String str, String str2, Property property) {
                super(Drive.this, "PUT", REST_PATH, property, Property.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.checkNotNull(str2, "Required parameter propertyKey must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public Update setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Properties() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(String str, Property property) {
            Insert insert = new Insert(str, property);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list(String str) {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Patch patch(String str, String str2, Property property) {
            Patch patch = new Patch(str, str2, property);
            Drive.this.initialize(patch);
            return patch;
        }

        public Update update(String str, String str2, Property property) {
            Update update = new Update(str, str2, property);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Replies {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            public Delete(String str, String str2, String str3) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private String replyId;

            public Get(String str, String str2, String str3) {
                super(Drive.this, "GET", REST_PATH, null, CommentReply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public Get setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @Key
            private String commentId;

            @Key
            private String fileId;

            public Insert(String str, String str2, CommentReply commentReply) {
                super(Drive.this, "POST", REST_PATH, commentReply, CommentReply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<CommentReplyList> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            public List(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, CommentReplyList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<CommentReplyList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<CommentReplyList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<CommentReplyList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<CommentReplyList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentReplyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentReplyList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<CommentReplyList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Patch extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            public Patch(String str, String str2, String str3, CommentReply commentReply) {
                super(Drive.this, "PATCH", REST_PATH, commentReply, CommentReply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Patch setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Patch setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            public Update(String str, String str2, String str3, CommentReply commentReply) {
                super(Drive.this, "PUT", REST_PATH, commentReply, CommentReply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
                checkRequiredParameter(commentReply, "content");
                checkRequiredParameter(commentReply.getContent(), "CommentReply.getContent()");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Replies() {
        }

        public Delete delete(String str, String str2, String str3) {
            Delete delete = new Delete(str, str2, str3);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2, String str3) {
            Get get = new Get(str, str2, str3);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(String str, String str2, CommentReply commentReply) {
            Insert insert = new Insert(str, str2, commentReply);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list(String str, String str2) {
            List list = new List(str, str2);
            Drive.this.initialize(list);
            return list;
        }

        public Patch patch(String str, String str2, String str3, CommentReply commentReply) {
            Patch patch = new Patch(str, str2, str3, commentReply);
            Drive.this.initialize(patch);
            return patch;
        }

        public Update update(String str, String str2, String str3, CommentReply commentReply) {
            Update update = new Update(str, str2, str3, commentReply);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Revisions {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Revision.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<RevisionList> {
            private static final String REST_PATH = "files/{fileId}/revisions";

            @Key
            private String fileId;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, RevisionList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<RevisionList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<RevisionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<RevisionList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<RevisionList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<RevisionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<RevisionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<RevisionList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Patch extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            public Patch(String str, String str2, Revision revision) {
                super(Drive.this, "PATCH", REST_PATH, revision, Revision.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Patch setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            public Update(String str, String str2, Revision revision) {
                super(Drive.this, "PUT", REST_PATH, revision, Revision.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Revisions() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str) {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Patch patch(String str, String str2, Revision revision) {
            Patch patch = new Patch(str, str2, revision);
            Drive.this.initialize(patch);
            return patch;
        }

        public Update update(String str, String str2, Revision revision) {
            Update update = new Update(str, str2, revision);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Teamdrives {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";

            @Key
            private String teamDriveId;

            public Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.teamDriveId = (String) Preconditions.checkNotNull(str, "Required parameter teamDriveId must be specified.");
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Delete setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";

            @Key
            private String teamDriveId;

            public Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, TeamDrive.class);
                this.teamDriveId = (String) Preconditions.checkNotNull(str, "Required parameter teamDriveId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Get setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<TeamDrive> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives";

            @Key
            private String requestId;

            public Insert(String str, TeamDrive teamDrive) {
                super(Drive.this, "POST", REST_PATH, teamDrive, TeamDrive.class);
                this.requestId = (String) Preconditions.checkNotNull(str, "Required parameter requestId must be specified.");
            }

            public String getRequestId() {
                return this.requestId;
            }

            public Insert setRequestId(String str) {
                this.requestId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<TeamDrive> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<TeamDriveList> {
            private static final String REST_PATH = "teamdrives";

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            public List() {
                super(Drive.this, "GET", REST_PATH, null, TeamDriveList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<TeamDriveList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<TeamDriveList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<TeamDriveList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDriveList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDriveList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDriveList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<TeamDriveList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";

            @Key
            private String teamDriveId;

            public Update(String str, TeamDrive teamDrive) {
                super(Drive.this, "PUT", REST_PATH, teamDrive, TeamDrive.class);
                this.teamDriveId = (String) Preconditions.checkNotNull(str, "Required parameter teamDriveId must be specified.");
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Update setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<TeamDrive> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Teamdrives() {
        }

        public Delete delete(String str) {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str) {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(String str, TeamDrive teamDrive) {
            Insert insert = new Insert(str, teamDrive);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list() {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, TeamDrive teamDrive) {
            Update update = new Update(str, teamDrive);
            Drive.this.initialize(update);
            return update;
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.22.0 of the Drive API library.", GoogleUtils.VERSION);
    }

    public Drive(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    public About about() {
        return new About();
    }

    public Apps apps() {
        return new Apps();
    }

    public Changes changes() {
        return new Changes();
    }

    public Channels channels() {
        return new Channels();
    }

    public Children children() {
        return new Children();
    }

    public Comments comments() {
        return new Comments();
    }

    public Files files() {
        return new Files();
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        super.initialize(abstractGoogleClientRequest);
    }

    public Parents parents() {
        return new Parents();
    }

    public Permissions permissions() {
        return new Permissions();
    }

    public Properties properties() {
        return new Properties();
    }

    public Realtime realtime() {
        return new Realtime();
    }

    public Replies replies() {
        return new Replies();
    }

    public Revisions revisions() {
        return new Revisions();
    }

    public Teamdrives teamdrives() {
        return new Teamdrives();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, Drive.DEFAULT_ROOT_URL, Drive.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
        }

        public Builder setDriveRequestInitializer(DriveRequestInitializer driveRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) driveRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Drive build() {
            return new Drive(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Files {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Copy extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/copy";

            @Key
            private Boolean convert;

            @Key
            private String fileId;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private String visibility;

            public Copy(String str, File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public boolean isConvert() {
                Boolean bool = this.convert;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isOcr() {
                Boolean bool = this.ocr;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isPinned() {
                Boolean bool = this.pinned;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Copy setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public Copy setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Copy setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public Copy setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Copy setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public Copy setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Copy setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            public Copy setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            public Copy setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Copy) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Copy) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Copy) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Copy) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Copy) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Copy) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Copy) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Copy set(String str, Object obj) {
                return (Copy) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String fileId;

            @Key
            private Boolean supportsTeamDrives;

            public Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class EmptyTrash extends DriveRequest<Void> {
            private static final String REST_PATH = "files/trash";

            public EmptyTrash() {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (EmptyTrash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (EmptyTrash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (EmptyTrash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (EmptyTrash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (EmptyTrash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (EmptyTrash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (EmptyTrash) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public EmptyTrash set(String str, Object obj) {
                return (EmptyTrash) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Export extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/export";

            @Key
            private String fileId;

            @Key
            private String mimeType;

            public Export(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.mimeType = (String) Preconditions.checkNotNull(str2, "Required parameter mimeType must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getMimeType() {
                return this.mimeType;
            }

            public Export setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Export setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Export) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Export) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Export) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Export) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Export) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Export) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Export) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Export set(String str, Object obj) {
                return (Export) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class GenerateIds extends DriveRequest<GeneratedIds> {
            private static final String REST_PATH = "files/generateIds";

            @Key
            private Integer maxResults;

            @Key
            private String space;

            public GenerateIds() {
                super(Drive.this, "GET", REST_PATH, null, GeneratedIds.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getSpace() {
                return this.space;
            }

            public GenerateIds setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public GenerateIds setSpace(String str) {
                this.space = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<GeneratedIds> setAlt2(String str) {
                return (GenerateIds) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<GeneratedIds> setFields2(String str) {
                return (GenerateIds) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<GeneratedIds> setKey2(String str) {
                return (GenerateIds) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<GeneratedIds> setOauthToken2(String str) {
                return (GenerateIds) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<GeneratedIds> setPrettyPrint2(Boolean bool) {
                return (GenerateIds) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<GeneratedIds> setQuotaUser2(String str) {
                return (GenerateIds) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<GeneratedIds> setUserIp2(String str) {
                return (GenerateIds) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GenerateIds set(String str, Object obj) {
                return (GenerateIds) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String projection;

            @Key
            private String revisionId;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean updateViewedDate;

            public Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public GenericUrl buildHttpRequestUrl() {
                String baseUrl;
                if ("media".equals(get("alt")) && getMediaHttpUploader() == null) {
                    baseUrl = Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath();
                } else {
                    baseUrl = Drive.this.getBaseUrl();
                }
                return new GenericUrl(UriTemplate.expand(baseUrl, getUriTemplate(), this, true));
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getProjection() {
                return this.projection;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUpdateViewedDate() {
                Boolean bool = this.updateViewedDate;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setProjection(String str) {
                this.projection = str;
                return this;
            }

            public Get setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Get setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Insert extends DriveRequest<File> {
            private static final String REST_PATH = "files";

            @Key
            private Boolean convert;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private Boolean useContentAsIndexableText;

            @Key
            private String visibility;

            public Insert(File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public boolean isConvert() {
                Boolean bool = this.convert;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isOcr() {
                Boolean bool = this.ocr;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isPinned() {
                Boolean bool = this.pinned;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Insert setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public Insert setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public Insert setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Insert setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public Insert setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Insert setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            public Insert setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            public Insert setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            public Insert setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public Insert(File file, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "POST", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class List extends DriveRequest<FileList> {
            private static final String REST_PATH = "files";

            @Key
            private String corpora;

            @Key
            private String corpus;

            @Key
            private Boolean includeTeamDriveItems;

            @Key
            private Integer maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            @Key
            private String projection;

            /* JADX INFO: renamed from: q */
            @Key
            private String f3255q;

            @Key
            private String spaces;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            public List() {
                super(Drive.this, "GET", REST_PATH, null, FileList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getCorpora() {
                return this.corpora;
            }

            public String getCorpus() {
                return this.corpus;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public String getProjection() {
                return this.projection;
            }

            public String getQ() {
                return this.f3255q;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setCorpora(String str) {
                this.corpora = str;
                return this;
            }

            public List setCorpus(String str) {
                this.corpus = str;
                return this;
            }

            public List setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public List setProjection(String str) {
                this.projection = str;
                return this;
            }

            public List setQ(String str) {
                this.f3255q = str;
                return this;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public List setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<FileList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<FileList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<FileList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<FileList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<FileList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<FileList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<FileList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Patch extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String addParents;

            @Key
            private Boolean convert;

            @Key
            private String fileId;

            @Key
            private String modifiedDateBehavior;

            @Key
            private Boolean newRevision;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private String removeParents;

            @Key
            private Boolean setModifiedDate;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private Boolean updateViewedDate;

            @Key
            private Boolean useContentAsIndexableText;

            public Patch(String str, File file) {
                super(Drive.this, "PATCH", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getAddParents() {
                return this.addParents;
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getModifiedDateBehavior() {
                return this.modifiedDateBehavior;
            }

            public Boolean getNewRevision() {
                return this.newRevision;
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public String getRemoveParents() {
                return this.removeParents;
            }

            public Boolean getSetModifiedDate() {
                return this.setModifiedDate;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public boolean isConvert() {
                Boolean bool = this.convert;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isNewRevision() {
                Boolean bool = this.newRevision;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isOcr() {
                Boolean bool = this.ocr;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isPinned() {
                Boolean bool = this.pinned;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSetModifiedDate() {
                Boolean bool = this.setModifiedDate;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUpdateViewedDate() {
                Boolean bool = this.updateViewedDate;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Patch setAddParents(String str) {
                this.addParents = str;
                return this;
            }

            public Patch setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Patch setModifiedDateBehavior(String str) {
                this.modifiedDateBehavior = str;
                return this;
            }

            public Patch setNewRevision(Boolean bool) {
                this.newRevision = bool;
                return this;
            }

            public Patch setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public Patch setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Patch setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public Patch setRemoveParents(String str) {
                this.removeParents = str;
                return this;
            }

            public Patch setSetModifiedDate(Boolean bool) {
                this.setModifiedDate = bool;
                return this;
            }

            public Patch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Patch setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            public Patch setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            public Patch setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            public Patch setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Touch extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/touch";

            @Key
            private String fileId;

            @Key
            private Boolean supportsTeamDrives;

            public Touch(String str) {
                super(Drive.this, "POST", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Touch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Touch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Touch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Touch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Touch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Touch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Touch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Touch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Touch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Touch set(String str, Object obj) {
                return (Touch) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Trash extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/trash";

            @Key
            private String fileId;

            @Key
            private Boolean supportsTeamDrives;

            public Trash(String str) {
                super(Drive.this, "POST", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Trash setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Trash setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Trash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Trash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Trash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Trash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Trash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Trash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Trash) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Trash set(String str, Object obj) {
                return (Trash) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Untrash extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/untrash";

            @Key
            private String fileId;

            @Key
            private Boolean supportsTeamDrives;

            public Untrash(String str) {
                super(Drive.this, "POST", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Untrash setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Untrash setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Untrash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Untrash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Untrash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Untrash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Untrash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Untrash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Untrash) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Untrash set(String str, Object obj) {
                return (Untrash) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String addParents;

            @Key
            private Boolean convert;

            @Key
            private String fileId;

            @Key
            private String modifiedDateBehavior;

            @Key
            private Boolean newRevision;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private String removeParents;

            @Key
            private Boolean setModifiedDate;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private Boolean updateViewedDate;

            @Key
            private Boolean useContentAsIndexableText;

            public Update(String str, File file) {
                super(Drive.this, "PUT", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getAddParents() {
                return this.addParents;
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getModifiedDateBehavior() {
                return this.modifiedDateBehavior;
            }

            public Boolean getNewRevision() {
                return this.newRevision;
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public String getRemoveParents() {
                return this.removeParents;
            }

            public Boolean getSetModifiedDate() {
                return this.setModifiedDate;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public boolean isConvert() {
                Boolean bool = this.convert;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isNewRevision() {
                Boolean bool = this.newRevision;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isOcr() {
                Boolean bool = this.ocr;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isPinned() {
                Boolean bool = this.pinned;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSetModifiedDate() {
                Boolean bool = this.setModifiedDate;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUpdateViewedDate() {
                Boolean bool = this.updateViewedDate;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return bool.booleanValue();
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Update setAddParents(String str) {
                this.addParents = str;
                return this;
            }

            public Update setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setModifiedDateBehavior(String str) {
                this.modifiedDateBehavior = str;
                return this;
            }

            public Update setNewRevision(Boolean bool) {
                this.newRevision = bool;
                return this;
            }

            public Update setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public Update setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Update setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public Update setRemoveParents(String str) {
                this.removeParents = str;
                return this;
            }

            public Update setSetModifiedDate(Boolean bool) {
                this.setModifiedDate = bool;
                return this;
            }

            public Update setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Update setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            public Update setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            public Update setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            public Update setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public Update(String str, File file, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "PUT", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "files/{fileId}/watch";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String projection;

            @Key
            private String revisionId;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean updateViewedDate;

            public Watch(String str, Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public GenericUrl buildHttpRequestUrl() {
                String baseUrl;
                if ("media".equals(get("alt")) && getMediaHttpUploader() == null) {
                    baseUrl = Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath();
                } else {
                    baseUrl = Drive.this.getBaseUrl();
                }
                return new GenericUrl(UriTemplate.expand(baseUrl, getUriTemplate(), this, true));
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() {
                return super.executeMediaAsInputStream();
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getProjection() {
                return this.projection;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public boolean isUpdateViewedDate() {
                Boolean bool = this.updateViewedDate;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Watch setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public Watch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Watch setProjection(String str) {
                this.projection = str;
                return this;
            }

            public Watch setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            public Watch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public Watch setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Channel> setUserIp2(String str) {
                return (Watch) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }

        public Files() {
        }

        public Copy copy(String str, File file) {
            Copy copy = new Copy(str, file);
            Drive.this.initialize(copy);
            return copy;
        }

        public Delete delete(String str) {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public EmptyTrash emptyTrash() {
            EmptyTrash emptyTrash = new EmptyTrash();
            Drive.this.initialize(emptyTrash);
            return emptyTrash;
        }

        public Export export(String str, String str2) {
            Export export = new Export(str, str2);
            Drive.this.initialize(export);
            return export;
        }

        public GenerateIds generateIds() {
            GenerateIds generateIds = new GenerateIds();
            Drive.this.initialize(generateIds);
            return generateIds;
        }

        public Get get(String str) {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public Insert insert(File file) {
            Insert insert = new Insert(file);
            Drive.this.initialize(insert);
            return insert;
        }

        public List list() {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public Patch patch(String str, File file) {
            Patch patch = new Patch(str, file);
            Drive.this.initialize(patch);
            return patch;
        }

        public Touch touch(String str) {
            Touch touch = new Touch(str);
            Drive.this.initialize(touch);
            return touch;
        }

        public Trash trash(String str) {
            Trash trash = new Trash(str);
            Drive.this.initialize(trash);
            return trash;
        }

        public Untrash untrash(String str) {
            Untrash untrash = new Untrash(str);
            Drive.this.initialize(untrash);
            return untrash;
        }

        public Update update(String str, File file) {
            Update update = new Update(str, file);
            Drive.this.initialize(update);
            return update;
        }

        public Watch watch(String str, Channel channel) {
            Watch watch = new Watch(str, channel);
            Drive.this.initialize(watch);
            return watch;
        }

        public Insert insert(File file, AbstractInputStreamContent abstractInputStreamContent) {
            Insert insert = new Insert(file, abstractInputStreamContent);
            Drive.this.initialize(insert);
            return insert;
        }

        public Update update(String str, File file, AbstractInputStreamContent abstractInputStreamContent) {
            Update update = new Update(str, file, abstractInputStreamContent);
            Drive.this.initialize(update);
            return update;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Realtime {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Get extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/realtime";

            @Key
            private String fileId;

            @Key
            private Integer revision;

            public Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() {
                return super.executeUsingHead();
            }

            public String getFileId() {
                return this.fileId;
            }

            public Integer getRevision() {
                return this.revision;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setRevision(Integer num) {
                this.revision = num;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class Update extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/realtime";

            @Key
            private String baseRevision;

            @Key
            private String fileId;

            public Update(String str) {
                super(Drive.this, "PUT", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            public String getBaseRevision() {
                return this.baseRevision;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setBaseRevision(String str) {
                this.baseRevision = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* JADX INFO: renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public Update(String str, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "PUT", "/upload/" + Drive.this.getServicePath() + REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Realtime() {
        }

        public Get get(String str) {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public Update update(String str) {
            Update update = new Update(str);
            Drive.this.initialize(update);
            return update;
        }

        public Update update(String str, AbstractInputStreamContent abstractInputStreamContent) {
            Update update = new Update(str, abstractInputStreamContent);
            Drive.this.initialize(update);
            return update;
        }
    }

    public Drive(Builder builder) {
        super(builder);
    }
}
