/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.unbracket.dmf.utors.files;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author domingos.fernando
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ConfigurationProperties(prefix = "file")
public class FileEntity implements Serializable {

    private Integer userId;
    private String fileName;
    private String fileType;
    private String fileFormat;
    private String uploadDir;

}
