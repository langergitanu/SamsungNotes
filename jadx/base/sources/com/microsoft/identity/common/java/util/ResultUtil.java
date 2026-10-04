package com.microsoft.identity.common.java.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.IResult;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultUtil {
    public static void logExposedFieldsOfObject(@NonNull String str, @NonNull Object obj) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (obj == null) {
            throw new NullPointerException("object is marked non-null but is null");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, ":");
        sbM781w.append(obj.getClass().getSimpleName());
        Logger.info(sbM781w.toString(), ObjectMapper.serializeExposedFieldsOfObjectToJsonString(obj));
    }

    public static void logResult(@NonNull String str, @NonNull IResult iResult) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (iResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, ":");
        sbM781w.append(iResult.getClass().getSimpleName());
        String string = sbM781w.toString();
        if (iResult.getSuccess()) {
            Logger.info(string, "Success Result");
            logExposedFieldsOfObject(string, iResult.getSuccessResponse());
        } else {
            Logger.warn(string, "Failure Result");
            if (iResult.getErrorResponse() != null) {
                if (iResult.getErrorResponse().getError() != null) {
                    Logger.warn(string, "Error: " + iResult.getErrorResponse().getError());
                }
                if (iResult.getErrorResponse().getErrorDescription() != null) {
                    Logger.warnPII(string, "Description: " + iResult.getErrorResponse().getErrorDescription());
                }
                logExposedFieldsOfObject(string, iResult.getErrorResponse());
            }
        }
        if (iResult instanceof AuthorizationResult) {
            AuthorizationResult authorizationResult = (AuthorizationResult) iResult;
            if (authorizationResult.getAuthorizationStatus() != null) {
                Logger.info(string, "Authorization Status: " + authorizationResult.getAuthorizationStatus().toString());
            }
        }
    }
}
