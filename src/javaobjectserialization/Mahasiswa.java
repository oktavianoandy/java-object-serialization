/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaobjectserialization;

import java.io.Serializable;

/**
 *
 * @author thinkpad
 */
public class Mahasiswa implements Serializable{
    int nim;
    String nama;
    String alamat;
    String jurusan;

    public Mahasiswa(int nim, String nama, String alamat, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.jurusan = jurusan;
    }
    
}
