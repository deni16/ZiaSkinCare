/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.config;

/**
 *
 * @author Ai
 */
public class MessageUtil {
    public static String successSaveMessage(){
    return "Data Berhasil Disimpan";
    }

    public static Object failureMessage() {
    return "Data Gagal Diupdate";
    }

    public static Object successDeleteMessage() {
    return "Data Berhasil Dihapus";
    }

    public static Object failureDeleteMessage() {
        return "Data Gagal Dihapus";
    }

    public static Object successUpdateMessage() {
    return "Data Berhasil Diubah";
    }
}
