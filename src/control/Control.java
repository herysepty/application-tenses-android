package control;

import java.util.ArrayList;


import android.database.Cursor;

public class Control extends Koneksi {
	String URL = "http://10.0.2.2/android_server/server-tenses.php";
	String url = "";
	String response = "";
	
	ArrayList<DataList> arraylist;

	public String tampilTenses() {
		try {
			url = URL + "?operasi=view-tenses";
			System.out.println("URL Tampil Mahasiswa: " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}
	public String tampilSoal() {
		try {
			url = URL + "?operasi=view-soal";
			System.out.println("URL Tampil Mahasiswa: " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}
	public String insertSkor(String nama, int benar, int salah, String nilai) {
		try {
			url = URL + "?operasi=insert&nama=" + nama +"&benar="+benar+"&salah="+salah+"&nilai="+nilai;
			System.out.println("URL Insert Mahasiswa : " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}

/*	public String getTensesById(String id) {
		try {
			url = URL + "?operasi=get_tenses_by_id&nim=" + id;
			System.out.println("URL get Mahasiswa by nim : " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}
*/
	public String getSoalById_tenses(String id) {
		try {
			url = URL + "?operasi=get_soal_by_id_tenses&id_tenses=" + id;
			System.out.println("URL get Mahasiswa by nim : " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}

public String updateMahasiswa(String nim, String nama, String jurusan) {
		try {
			url = URL + "?operasi=update&nim=" + nim + "&nama=" + nama+ "&jurusan=" + jurusan;
			System.out.println("URL Update Mahasiswa");
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}

	public String deleteMahasiswa(String nim) {
		try {
			url = URL + "?operasi=delete&nim=" + nim;
			System.out.println("URL Delete Mahasiswa : " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}
	
	public ArrayList<DataList> getAll(){
		//ArrayList<DataList> listmahasiswa;
		return arraylist;
		
		
	}
	
	
	
}
