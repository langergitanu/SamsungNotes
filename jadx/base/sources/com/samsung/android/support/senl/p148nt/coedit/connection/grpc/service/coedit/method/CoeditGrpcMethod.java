package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.method.GrpcMethod;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface CoeditGrpcMethod extends GrpcMethod {
    public static final int Base = 100;
    public static final int CatchUp = 110;
    public static final int Compose = 109;
    public static final int DownloadStroke = 105;
    public static final int GetDeviceList = 111;
    public static final int GetObjectUploadUrl = 101;
    public static final int GetSignedDownloadUrl = 102;
    public static final int MultipleTransform = 107;
    public static final int RequestPermission = 112;
    public static final int ResetWorkspace = 113;
    public static final int Submit = 103;
    public static final int Transform = 106;
    public static final int TransformWithMultiple = 108;
    public static final int UploadStroke = 104;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Caller {
        public static final String Base = "Base";
        public static final String CLOSE = "CLOSE";
        public static final String CatchUp = "CatchUp";
        public static final String Compose = "Compose";
        public static final String DownloadStroke = "DownloadStroke";
        public static final String END = "END";
        public static final String GetDeviceList = "GetDeviceList";
        public static final String GetObjectUploadUrl = "GetObjectUploadUrl";
        public static final String GetSignedDownloadUrl = "GetSignedDownloadUrl";
        public static final String MultipleTransform = "MultipleTransform";
        public static final String OPEN = "OPEN";
        public static final String REFRESH = "REFRESH";
        public static final String REOPEN = "REOPEN";
        public static final String RequestPermission = "RequestPermission";
        public static final String ResetWorkspace = "ResetWorkspace";
        public static final String START = "START";
        public static final String STOP = "STOP";
        public static final String Submit = "Submit";
        public static final String Transform = "Transform";
        public static final String TransformWithMultiple = "TransformWithMultiple";
        public static final String UploadStroke = "UploadStroke";
    }
}
