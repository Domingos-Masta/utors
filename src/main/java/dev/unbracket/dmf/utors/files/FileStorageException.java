/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.unbracket.dmf.utors.files;

/**
 *
 * @author domingos.fernando
 */
public class FileStorageException extends RuntimeException
{

    public FileStorageException(String message)
    {
        super(message);
    }

    public FileStorageException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
