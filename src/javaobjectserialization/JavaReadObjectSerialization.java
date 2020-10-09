/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaobjectserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author thinkpad
 */
public class JavaReadObjectSerialization {

    static String path = "D:\\mhs.txt";
    static ArrayList<Mahasiswa> mhs = new ArrayList<>();
    
    public static void main(String[] args) throws ClassNotFoundException {
        readObject();
    }

    @SuppressWarnings("unchecked")
    static private void readObject() throws ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            mhs = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            showAllMahasiswa();
        } catch (IOException e) {
            System.out.println("Ups! Error!");
            System.out.println(e);
        }
    }
    
    static private void showAllMahasiswa(){
        System.out.println("==================================================================");
        System.out.println("JAVA READ OBJECT SERIALIZATION");
        System.out.println("==================================================================");
        System.out.println("Daftar Mahasiswa ");
        System.out.println("==================================================================");
        for (Mahasiswa mhs : mhs) {
            System.out.println(
                    "Nim \t: " + mhs.nim
                    + "\nNama \t: " + mhs.nama
                    + "\nAlamat \t: " + mhs.alamat
                    + "\nJurusan : " + mhs.jurusan + "\n");
        }
        System.out.println("==================================================================");
    }
}
