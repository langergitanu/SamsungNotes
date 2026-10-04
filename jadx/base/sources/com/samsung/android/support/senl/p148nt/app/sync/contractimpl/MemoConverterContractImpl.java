package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.memoconverter.JSONConverter;
import com.samsung.android.support.senl.document.memoconverter.LMemoConverter;
import com.samsung.android.support.senl.document.memoconverter.NMemoConverter;
import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.document.memoconverter.SNBConverter;
import com.samsung.android.support.senl.document.memoconverter.SPDConverter;
import com.samsung.android.support.senl.document.memoconverter.ScrapBookConverter;
import com.samsung.android.support.senl.document.memoconverter.TMemo1Converter;
import com.samsung.android.support.senl.p148nt.app.sync.memoconvert.QMemoConverter;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import p086V.InterfaceC0318d;
import p086V.InterfaceC0319e;
import p086V.InterfaceC0320f;
import p086V.InterfaceC0321g;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MemoConverterContractImpl implements InterfaceC0321g {
    @Override // p086V.InterfaceC0321g
    public boolean LMemoConvertToSDoc(Object obj, String str, final InterfaceC0318d interfaceC0318d) {
        return interfaceC0318d != null ? ((LMemoConverter) obj).convertToSDoc(str, new ProgressListener() { // from class: com.samsung.android.support.senl.nt.app.sync.contractimpl.MemoConverterContractImpl.2
            @Override // com.samsung.android.support.senl.document.memoconverter.ProgressListener
            public void onProgress(int i, int i2, ArrayList<String> arrayList) {
                interfaceC0318d.onProgress(i, i2, arrayList);
            }
        }) : ((LMemoConverter) obj).convertToSDoc(str, null);
    }

    public int LMemoGetMemoCount(Object obj, String str) {
        return LMemoConverter.getMemoCount(str);
    }

    @Override // p086V.InterfaceC0321g
    public boolean NMemoConvertToSDoc(Object obj, boolean z, String str, int i) {
        return ((NMemoConverter) obj).convertToSDoc(z, str, i);
    }

    @Override // p086V.InterfaceC0321g
    public String NMemoCoreConvertToSDoc(Object obj, boolean z, String str, int i) {
        return ((NMemoConverter) obj).convertToSDoc(str);
    }

    @Override // p086V.InterfaceC0321g
    public List<MemoMetaDataItem> NMemoGetMemoMetaData(Object obj) {
        return ((NMemoConverter) obj).getMemoMetaData();
    }

    @Override // p086V.InterfaceC0321g
    public boolean QMemoConvertToSDoc(Object obj, String str, final InterfaceC0320f interfaceC0320f) {
        return interfaceC0320f != null ? ((QMemoConverter) obj).convertToSDoc(str, new ProgressListener() { // from class: com.samsung.android.support.senl.nt.app.sync.contractimpl.MemoConverterContractImpl.3
            @Override // com.samsung.android.support.senl.document.memoconverter.ProgressListener
            public void onProgress(int i, int i2, ArrayList<String> arrayList) {
                interfaceC0320f.onProgress(i, i2, arrayList);
            }
        }) : ((QMemoConverter) obj).convertToSDoc(str, null);
    }

    public int QMemoGetMemoCount(Object obj, String str) {
        return QMemoConverter.getMemoCount(str);
    }

    @Override // p086V.InterfaceC0321g
    public boolean TMemoConvertToSDoc(Object obj, Context context, String str, final InterfaceC0319e interfaceC0319e) {
        return interfaceC0319e != null ? TMemo1Converter.convertToSDoc(context, str, new ProgressListener() { // from class: com.samsung.android.support.senl.nt.app.sync.contractimpl.MemoConverterContractImpl.1
            @Override // com.samsung.android.support.senl.document.memoconverter.ProgressListener
            public void onProgress(int i, int i2, ArrayList<String> arrayList) {
                interfaceC0319e.onProgress(i, i2);
            }
        }) : TMemo1Converter.convertToSDoc(context, str, null);
    }

    @Override // p086V.InterfaceC0321g
    public ArrayList<MemoMetaDataItem> TMemoGetMemoMetaDataArray(Object obj, Context context, String str) {
        return TMemo1Converter.getMemoMetaDataArray(context, str);
    }

    @Override // p086V.InterfaceC0321g
    public Object createLMemoConverter() {
        return new LMemoConverter(ApplicationManager.getInstance().getAppContext());
    }

    @Override // p086V.InterfaceC0321g
    public Object createNMemoConverter(String str, String str2) {
        return new NMemoConverter(ApplicationManager.getInstance().getAppContext(), str, str2);
    }

    @Override // p086V.InterfaceC0321g
    public Object createQMemoConverter() {
        return new QMemoConverter(ApplicationManager.getInstance().getAppContext());
    }

    @Override // p086V.InterfaceC0321g
    public Object createSNBConverter() {
        return new SNBConverter(ApplicationManager.getInstance().getAppContext());
    }

    @Override // p086V.InterfaceC0321g
    public Object createSPDConverter() {
        return new SPDConverter(ApplicationManager.getInstance().getAppContext());
    }

    @Override // p086V.InterfaceC0321g
    public Object createScrapBookConverter() {
        return new ScrapBookConverter(ApplicationManager.getInstance().getAppContext(), ImageUtils.getMaxTextureSize());
    }

    @Override // p086V.InterfaceC0321g
    public Object createTMemoConverter() {
        return new TMemo1Converter();
    }

    @Override // p086V.InterfaceC0321g
    public int getNMemoValueConvertModeNormal() {
        return 0;
    }

    @Override // p086V.InterfaceC0321g
    public int getSnbConvertModeNormal() {
        return 0;
    }

    public int getSnbConvertModeRename() {
        return 2;
    }

    public int getSnbConvertModeReplace() {
        return 1;
    }

    @Override // p086V.InterfaceC0321g
    public int getSpdConvertModeNormal() {
        return 0;
    }

    public int getSpdConvertModeRename() {
        return 2;
    }

    public int getSpdConvertModeReplace() {
        return 1;
    }

    @Override // p086V.InterfaceC0321g
    public long getSpdLastModifiedTime(Object obj, String str) {
        return ((SPDConverter) obj).getLastModifiedTime(str);
    }

    @Override // p086V.InterfaceC0321g
    public boolean isSnbAlreadyConverted(Object obj, String str) {
        return ((SNBConverter) obj).isAlreadyConverted(str);
    }

    @Override // p086V.InterfaceC0321g
    public boolean isSpdAlreadyConverted(Object obj, String str) {
        return ((SPDConverter) obj).isAlreadyConverted(str);
    }

    @Override // p086V.InterfaceC0321g
    public void jsonConverterConvertToSDoc(Context context, String str, String str2, String str3) {
        JSONConverter.convertToSDoc(context, str, str2, str3);
    }

    public MemoMetaDataItem jsonConverterGetMemoMetaData(String str, String str2, String str3) {
        return JSONConverter.getMemoMetaData(str, str2, str3);
    }

    @Override // p086V.InterfaceC0321g
    public String scrapBookConverterConvertToSDoc(Object obj, JSONObject jSONObject, String str, String str2) {
        return ((ScrapBookConverter) obj).convertToSDoc(jSONObject, str, str2);
    }

    public MemoMetaDataItem scrapBookConverterGetMetaData(Object obj, JSONObject jSONObject, String str, String str2) {
        return ((ScrapBookConverter) obj).getMetaData(jSONObject, str, str2);
    }

    @Override // p086V.InterfaceC0321g
    public boolean snbConvertToSDoc(Object obj, String str, int i) {
        return ((SNBConverter) obj).convertToSDoc(str, i);
    }

    @Override // p086V.InterfaceC0321g
    public String spdConvertToSDoc(Object obj, String str, int i) {
        return ((SPDConverter) obj).convertToSDoc(str, i);
    }
}
