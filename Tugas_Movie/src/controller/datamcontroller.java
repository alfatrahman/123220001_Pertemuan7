/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdatam.datamDAO;
import DAOImplement.datamImplement;
import model.*;
import view.MainView;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class datamcontroller {

    MainView frame;
    datamImplement impldatam;
    List<datam> dp;

    public datamcontroller(MainView frame) {
        this.frame = frame;
        impldatam = new datamDAO();
        dp = impldatam.getAll();

    }

    public void isitabel() {
        dp = impldatam.getAll();
        modeltabeldatam mp = new modeltabeldatam(dp);
        frame.getTableDatam().setModel(mp);

    }

    public void insert() {
        // Mendapatkan nilai dari JTextField
        String judul = frame.getJTxtjudul().getText();
        String alurText = frame.getJTxtalur().getText();
        String penokohanText = frame.getJTxtpenokohan().getText();
        String aktingText = frame.getJTxtakting().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (judul.isEmpty() || alurText.isEmpty() || penokohanText.isEmpty() || aktingText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        double alur, penokohan, akting;
        try {
            // Mengonversi nilai-nilai alur, penokohan, dan akting ke dalam tipe data double
            alur = Double.parseDouble(frame.getJTxtalur().getText());
            penokohan = Double.parseDouble(frame.getJTxtpenokohan().getText());
            akting = Double.parseDouble(frame.getJTxtakting().getText());

            // Memastikan nilai alur, penokohan, dan akting berada dalam rentang 0 hingga 5
            if (alur < 0 || alur > 5 || penokohan < 0 || penokohan > 5 || akting < 0 || akting > 5) {
                // Menampilkan pesan kesalahan jika nilai di luar rentang yang diizinkan
                JOptionPane.showMessageDialog(frame, "Nilai alur, penokohan, atau akting harus berada dalam rentang 0 hingga 5", "Error", JOptionPane.ERROR_MESSAGE);
                frame.getJTxtalur().setText("");
                frame.getJTxtpenokohan().setText("");
                frame.getJTxtakting().setText("");
                return; // Keluar dari metode insert() jika terjadi kesalahan
            }

            // Jika semua nilai berada dalam rentang yang diizinkan, maka data dimasukkan ke dalam objek datam
            datam dp = new datam();
            dp.setJudul(judul);
            dp.setAlur(alur);
            dp.setPenokohan(penokohan);
            dp.setAkting(akting);
            impldatam.insert(dp);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            frame.getJTxtjudul().setText("");
            frame.getJTxtalur().setText("");
            frame.getJTxtpenokohan().setText("");
            frame.getJTxtakting().setText("");

        } catch (NumberFormatException e) {
            // Menangani jika input dari pengguna tidak bisa diubah menjadi tipe data double
            JOptionPane.showMessageDialog(frame, "Nilai alur, penokohan, atau akting harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void update() {
        String judul = frame.getJTxtjudul().getText();
        String alurText = frame.getJTxtalur().getText();
        String penokohanText = frame.getJTxtpenokohan().getText();
        String aktingText = frame.getJTxtakting().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (judul.isEmpty() || alurText.isEmpty() || penokohanText.isEmpty() || aktingText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        double alur, penokohan, akting;
        try {
            // Mengonversi nilai-nilai alur, penokohan, dan akting ke dalam tipe data double
            alur = Double.parseDouble(frame.getJTxtalur().getText());
            penokohan = Double.parseDouble(frame.getJTxtpenokohan().getText());
            akting = Double.parseDouble(frame.getJTxtakting().getText());

            // Memastikan nilai alur, penokohan, dan akting berada dalam rentang 0 hingga 5
            if (alur < 0 || alur > 5 || penokohan < 0 || penokohan > 5 || akting < 0 || akting > 5) {
                // Menampilkan pesan kesalahan jika nilai di luar rentang yang diizinkan
                JOptionPane.showMessageDialog(frame, "Nilai alur, penokohan, atau akting harus berada dalam rentang 0 hingga 5", "Error", JOptionPane.ERROR_MESSAGE);
                frame.getJTxtalur().setText("");
                frame.getJTxtpenokohan().setText("");
                frame.getJTxtakting().setText("");
                return; // Keluar dari metode insert() jika terjadi kesalahan
            }

            // Jika semua nilai berada dalam rentang yang diizinkan, maka data dimasukkan ke dalam objek datam
            datam dp = new datam();
            dp.setJudul(judul);
            dp.setAlur(alur);
            dp.setPenokohan(penokohan);
            dp.setAkting(akting);
            impldatam.update(dp);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

            frame.getJTxtjudul().setText("");
            frame.getJTxtalur().setText("");
            frame.getJTxtpenokohan().setText("");
            frame.getJTxtakting().setText("");

        } catch (NumberFormatException e) {
            // Menangani jika input dari pengguna tidak bisa diubah menjadi tipe data double
            JOptionPane.showMessageDialog(frame, "Nilai alur, penokohan, atau akting harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void delete() {
        String judul = frame.getJTxtjudul().getText();
        impldatam.delete(judul);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        frame.getJTxtjudul().setText("");
        frame.getJTxtalur().setText("");
        frame.getJTxtpenokohan().setText("");
        frame.getJTxtakting().setText("");
    }
    
    public void clear(){
         frame.getJTxtjudul().setText("");
        frame.getJTxtalur().setText("");
        frame.getJTxtpenokohan().setText("");
        frame.getJTxtakting().setText("");
    }
}
