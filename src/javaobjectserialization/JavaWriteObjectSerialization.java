/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaobjectserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thinkpad
 */
public class JavaWriteObjectSerialization {

    static ArrayList<Mahasiswa> arrMahasiswa = new ArrayList<Mahasiswa>();
    static Mahasiswa mahasiswa;
    static String path = "D:\\mhs.txt";
    static int pilihan;
    static Scanner scInt = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            menu();
            switch (pilihan) {
                case 1:
                    addMahasiswa();
                    break;
                case 2:
                    removeMahasiswa();
                    break;
                case 3:
                    showAllMahasiswa();
                    break;
                case 4:
                    saveObjectToFile();
                    break;
                default:
                    System.out.println("============================================================");
                    System.out.println("Error! Menu tidak tersedia!");
                    System.out.println("============================================================");
                    break;
            }
        } while (pilihan >= 1 && pilihan <= 4);
    }

    private static void menu() {
        System.out.println("==================================================================");
        System.out.println("JAVA WRITE OBJECT SERIALIZATION");
        System.out.println("==================================================================");
        System.out.println("Daftar Menu :");
        System.out.println("1. Tambah data mahasiswa");
        System.out.println("2. Hapus data mahasiswa");
        System.out.println("3. Lihat data mahasiswa");
        System.out.println("4. Simpan data & keluar");
        System.out.println("==================================================================");
        System.out.print("Pilih menu : ");
        pilihan = scInt.nextInt();
    }

    private static void addMahasiswa() {
        System.out.println("==================================================================");
        System.out.println("Tambah data Mahasiswa");
        System.out.println("==================================================================");
        System.out.print("Masukkan NIM mahasiswa \t\t: ");
        int nim = scInt.nextInt();
        System.out.print("Masukkan nama mahasiswa \t: ");
        String nama = scString.nextLine();
        System.out.print("Masukkan alamat mahasiswa \t: ");
        String alamat = scString.nextLine();
        System.out.print("Masukkan jurusan mahasiswa \t: ");
        String jurusan = scString.nextLine();

        mahasiswa = new Mahasiswa(nim, nama, alamat, jurusan);
        arrMahasiswa.add(mahasiswa);

        System.out.println("==================================================================");
        System.out.println("Data berhasil dimasukkan!");
        System.out.println("==================================================================\n");
    }

    private static void removeMahasiswa() {
        System.out.println("==================================================================");
        System.out.println("Hapus data mahasiswa");
        System.out.println("==================================================================");
        System.out.print("Masukkan NIM mahasiswa \t\t: ");
        int nim = scInt.nextInt();
        Iterator itr = arrMahasiswa.iterator();
        while (itr.hasNext()) {
            Mahasiswa ms = (Mahasiswa) itr.next();
            if (ms.nim == nim) {
                itr.remove();
                System.out.println("==================================================================");
                System.out.println("Data mahasiswa " + ms.nim + " berhasil dihapus!");
            }
        }
        System.out.println("==================================================================\n");
    }

    private static void saveObjectToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrMahasiswa);
            oos.flush();
            oos.close();
            fos.close();
            System.out.println("==================================================================");
            System.out.println("Simpan data mahasiswa");
            System.out.println("==================================================================");
            System.out.println("Data Mahasiswa berhasil disimpan!");
            System.out.println("Silahkan buka file tersebut dengan JavaReadObjectSerialization!");
            System.out.println("==================================================================\n");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void showAllMahasiswa() {
        System.out.println("==================================================================");
        System.out.println("Lihat data mahasiswa");
        System.out.println("==================================================================");
        Iterator itr = arrMahasiswa.iterator();
        while (itr.hasNext()) {
            Mahasiswa ms = (Mahasiswa) itr.next();
            System.out.println(
                    "Nim \t: " + ms.nim
                    + "\nNama \t: " + ms.nama
                    + "\nAlamat \t: " + ms.alamat
                    + "\nJurusan : " + ms.jurusan + "\n");
        }
        System.out.println("==================================================================\n");
    }

}
