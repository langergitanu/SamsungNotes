package com.samsung.android.smartswitchfileshare;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileShareException extends IOException {
    public static final int alreadyExistDstDir = 3;
    public static final int invalidSrcUri = 5;
    public static final int ioException = 7;
    public static final int noDstUris = 0;
    public static final int noSrcFile = 2;
    public static final int noSrcUris = 1;
    public static final int noUriInIntent = 6;
    public static final int srcUriNotDocumentUri = 4;
    int error;

    private FileShareException(String str, int i) {
        super(str);
        this.error = i;
    }

    private static String getMsg(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append(str);
        sb.append(" - ");
        switch (i) {
            case 0:
                sb.append("No DstUri");
                break;
            case 1:
                sb.append("No srcUris");
                break;
            case 2:
                sb.append("No sourceFile : ");
                break;
            case 3:
                sb.append("Already DstDir exist..");
                break;
            case 4:
                sb.append("SrcUri is not DocumentUri");
                break;
            case 5:
                sb.append("Wrong SrcUri!");
                break;
            case 6:
                sb.append("invalid SAVE_PATH_URIS and SAVE_URIS_FILE");
                break;
            case 7:
                sb.append("failed IO");
                break;
        }
        if (str2 != null && str2.isEmpty()) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static FileShareException makeFileShareException(String str, int i) {
        return makeFileShareException(str, i, null);
    }

    public static FileShareException makeFileShareException(String str, int i, @Nullable String str2) {
        return new FileShareException(getMsg(str, i, str2), i);
    }
}
