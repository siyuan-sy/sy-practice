package com.sy.common;

public class DftProperties {
    private static String encoding;
    private static String encKey;
    private static String signKey;
    private static String pfcpOrgId;
    private static String stqueryUrl;
    private static String syncUrl;
    private static String modifyUrl;

    public static String getEncoding() {
        return encoding;
    }

    public static void setEncoding(String encoding) {
        DftProperties.encoding = encoding;
    }

    public static String getEncKey() {
        return encKey;
    }

    public void setEncKey(String encKey) {
        DftProperties.encKey = encKey;
    }

    public static String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        DftProperties.signKey = signKey;
    }

    public static String getPfcpOrgId() {
        return pfcpOrgId;
    }

    public void setPfcpOrgId(String pfcpOrgId) {
        DftProperties.pfcpOrgId = pfcpOrgId;
    }

    public static String getStqueryUrl() {
        return stqueryUrl;
    }

    public void setStqueryUrl(String stqueryUrl) {
        DftProperties.stqueryUrl = stqueryUrl;
    }

    public static String getSyncUrl() {
        return syncUrl;
    }

    public void setSyncUrl(String syncUrl) {
        DftProperties.syncUrl = syncUrl;
    }

    public static String getModifyUrl() {
        return modifyUrl;
    }

    public void setModifyUrl(String modifyUrl) {
        DftProperties.modifyUrl = modifyUrl;
    }
}
