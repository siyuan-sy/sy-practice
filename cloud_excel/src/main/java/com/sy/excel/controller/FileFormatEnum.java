package com.sy.excel.controller;


/**
 * type
 * 1-图片
 * 2-文档
 * 3-应用
 * 4-音频
 * 5-视频
 */
public enum  FileFormatEnum {

    IMAGE_BMP(1,".bmp","image/bmp"),
    IMAGE_GIF(1,".gif","image/gif"),
    IMAGE_JPEG(1,".jpeg","image/jpeg"),
    IMAGE_JPE(1,".jpe","image/jpeg"),
    IMAGE_JPG(1,".jpg","image/jpeg"),
    IMAGE_IEF(1,".ief","image/ief"),
    IMAGE_PNG(1,".png","image/jpeg"),
    IMAGE_TIFF(1,".tiff","image/tiff"),
    IMAGE_TIF(1,".tif","image/tif"),
    TEXT_HTML(2,".html","text/html"),
    TEXT_TXT(2,".txt","text/plain"),
    TEXT_XML(2,".xml","text/xml"),
    TEXT_CSS(2,".css","text/css"),
    APPLICATION_VSD(3,".vsd","notice/vnd.visio"),
    APPLICATION_PPT(3,".ppt","notice/vnd.ms-powerpoint"),
    APPLICATION_PPTX(3,".pptx","notice/vnd.ms-powerpoint"),
    APPLICATION_DOC(3,".doc","notice/msword"),
    APPLICATION_DOCX(3,".docx","notice/msword"),
    APPLICATION_PDF(3,".pdf","notice/pdf"),
    APPLICATION_EXE(3,".exe","notice/octet-stream"),
    APPLICATION_CLASS(3,".class","notice/octet-stream"),
    APPLICATION_DLL(3,".dll","notice/octet-stream"),
    APPLICATION_AI(3,".ai","notice/postscript"),
    APPLICATION_XLS(3,".xls","notice/vnd.ms-excel"),
    APPLICATION_JS(3,".js","notice/x-javascript"),
    APPLICATION_SH(3,".sh","notice/x-sh"),
    APPLICATION_TAR(3,".tar","notice/x-tar"),
    APPLICATION_ZIP(3,".zip","notice/x-tar"),
    AUDIO_MP3(4,".mp3","audio/mpeg"),
    VIDEO_MPEG(5,".mpeg","video/mpeg"),
    VIDEO_MPE(5,".mpe","video/mpeg"),
    VIDEO_MPG(5,".mpg","video/mpeg"),
    VIDEO_QT(5,".qt","video/quicktime"),
    VIDEO_MOV(5,".mov","video/quicktime"),
    VIDEO_AVI(5,".avi","video/x-msvideo"),
    VIDEO_MOVIE(5,".movie","video/x-sgi-movie"),
    VIDEO_MXU(5,".mxu","video/vnd.mpegurl"),
    VIDEO_MP4(5,".mp4","video/mpeg4");

    public static final Integer IMAGE_TYPE=1;
    public static final Integer TEXT_TYPE=2;
    public static final Integer APPLICATION_TYPE=3;
    public static final Integer AUDIO_TYPE=4;
    public static final Integer VIDEO_TYPE=5;

    private Integer type;

    private String name;

    private String contentType;

    FileFormatEnum() {
    }

    FileFormatEnum(Integer type, String name, String contentType) {
        this.type = type;
        this.name = name;
        this.contentType = contentType;
    }

    public static Integer getTypeByName(String name) {
        FileFormatEnum[] types = FileFormatEnum.values();
        for (FileFormatEnum t : types) {
            if (name.equalsIgnoreCase(t.name)) {
                return t.type;
            }
        }
        return null;
    }
    public static String getContentByName(String name) {
        FileFormatEnum[] types = FileFormatEnum.values();
        for (FileFormatEnum t : types) {
            if (name.equalsIgnoreCase(t.name)) {
                return t.contentType;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
