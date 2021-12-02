/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.unbracket.dmf.utors.utils;

import java.util.regex.Pattern;

/**
 *
 * @author domingos.fernando
 */
public class Constants {

    public static final String SECRET_KEY = "sDt+gt45Cta/oEsrDS/KWyOhIL680kbRRQLfmKdFY4EpCbYp1kierUa8kgYQMcXz6rqFtavv9kKMqMtBFsmoBg==";
    public static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile("^[a-z0-9!#$%&'*+\\/=?^_`{|}~.-]+@[a-z0-9]([a-z0-9-]*[a-z0-9])?(\\.[a-z0-9]([a-z0-9-]*[a-z0-9])?)*$", Pattern.CASE_INSENSITIVE);

    public static final String DEFAULT_APP_URL_BASE = "/utors";
    public static final String DEFAULT_APP_API_VERSION = "/v1";
    private static final String APP_MODULE = "/module";

    /**
     * Modules: OCR, PDF to IMAGE, DOCX to PDF, DOCX to HTML
     */
    public static final String OCR_APP_MODULE = APP_MODULE + "/ocr";
    public static final String UTILITARIES_APP_MODULE = APP_MODULE + "/utils";

    /**
     * Modules: OCR, PDF to IMAGE, DOCX to PDF, DOCX to HTML Utilitaries:
     * converters->image size reduce
     */
    public static final String PDF_TO_IMAGE_APP_MODULE = "/pdf_to_image";
    public static final String DOCX_TO_PDF_APP_MODULE = "/docx_to_pdf";
    public static final String DOCX_TO_HTML_APP_MODULE = "/docx_to_html";
    public static final String IMAGE_RESIZE = "/image_resize";

    public static final String OCR_TEXT_FROM_FILE = "/text_from_file";
    public static final String OCR_IMG_FROM_FILE = "/img_from_file";

}
