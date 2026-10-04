package io.netty.handler.codec.http.multipart;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class FileUploadUtil {
    private FileUploadUtil() {
    }

    public static int compareTo(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().compareToIgnoreCase(fileUpload2.getName());
    }

    public static boolean equals(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().equalsIgnoreCase(fileUpload2.getName());
    }

    public static int hashCode(FileUpload fileUpload) {
        return fileUpload.getName().hashCode();
    }
}
