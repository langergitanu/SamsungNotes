package p086V;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: V.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface InterfaceC0321g {
    boolean LMemoConvertToSDoc(Object obj, String str, InterfaceC0318d interfaceC0318d);

    boolean NMemoConvertToSDoc(Object obj, boolean z, String str, int i);

    String NMemoCoreConvertToSDoc(Object obj, boolean z, String str, int i);

    List NMemoGetMemoMetaData(Object obj);

    boolean QMemoConvertToSDoc(Object obj, String str, InterfaceC0320f interfaceC0320f);

    boolean TMemoConvertToSDoc(Object obj, Context context, String str, InterfaceC0319e interfaceC0319e);

    ArrayList TMemoGetMemoMetaDataArray(Object obj, Context context, String str);

    Object createLMemoConverter();

    Object createNMemoConverter(String str, String str2);

    Object createQMemoConverter();

    Object createSNBConverter();

    Object createSPDConverter();

    Object createScrapBookConverter();

    Object createTMemoConverter();

    int getNMemoValueConvertModeNormal();

    int getSnbConvertModeNormal();

    int getSpdConvertModeNormal();

    long getSpdLastModifiedTime(Object obj, String str);

    boolean isSnbAlreadyConverted(Object obj, String str);

    boolean isSpdAlreadyConverted(Object obj, String str);

    void jsonConverterConvertToSDoc(Context context, String str, String str2, String str3);

    String scrapBookConverterConvertToSDoc(Object obj, JSONObject jSONObject, String str, String str2);

    boolean snbConvertToSDoc(Object obj, String str, int i);

    String spdConvertToSDoc(Object obj, String str, int i);
}
