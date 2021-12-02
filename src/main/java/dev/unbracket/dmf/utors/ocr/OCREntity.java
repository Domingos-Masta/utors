/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.unbracket.dmf.utors.ocr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author domingos.fernando
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OCREntity {

    private String fileName;
    private String fileSize;
    private String fileType;
    private String fileContent;

}
