/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package dev.unbracket.dmf.utors.ocr;

import dev.unbracket.dmf.utors.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author domingos.fernando
 */
@RestController
@RequestMapping(Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.OCR_APP_MODULE)
public class OCRRestController {

    @Autowired
    private OCRRestService ocrRestService;

    @PostMapping(Constants.OCR_TEXT_FROM_FILE)
    public ResponseEntity<?> save(@RequestParam("file") MultipartFile file,
            @RequestParam("contentLimit") String contentLimit) {

        String fileContent = ocrRestService.extractFileContentAsText(file);

        OCREntity ocre = new OCREntity(ocrRestService.getFileName(), "", "", fileContent);

        return new ResponseEntity<OCREntity>(ocre, HttpStatus.OK);
    }

}
