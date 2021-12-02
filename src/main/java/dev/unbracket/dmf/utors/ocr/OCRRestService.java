/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.unbracket.dmf.utors.ocr;

import dev.unbracket.dmf.utors.files.FileStorageService;
import java.io.File;
import java.util.logging.Level;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author domingos.fernando
 */
@Service
public class OCRRestService {

    @Autowired
    private FileStorageService fileStorageService;

    private static final Logger LOG = LoggerFactory.getLogger(OCRRestController.class);

    private String fileName;
    private String fileType;

    public String extractFileContentAsText(MultipartFile file) {

        this.fileName = fileStorageService.store(file);
        String filePath = fileStorageService.getFileAbsolutePath(fileName);
        LOG.info("FilePath finded ... : " + filePath);

        File image = new File(filePath);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata");
        tesseract.setLanguage("por");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        String result = "";
        try {
            result = tesseract.doOCR(image);
        } catch (TesseractException ex) {
            java.util.logging.Logger.getLogger(OCRRestService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public String getFileName() {
        return fileName;
    }

}
