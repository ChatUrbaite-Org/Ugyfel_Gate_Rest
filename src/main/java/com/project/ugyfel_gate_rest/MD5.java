package com.project.ugyfel_gate_rest;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
    public static String Translate_to_MD5_HASH(@NotNull String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return  DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
