package control;

import java.io.Serializable;


public class DataList implements Serializable{

	public String id_tenses;
	public String judul;
	public String isi;
	public String rumus;
	public String contoh;
	
	
	public DataList(String id_tenses, String judul, String isi, String rumus, String contoh){
		this.id_tenses = id_tenses;
		this.judul = judul;
		this.isi = isi;
		this.rumus = rumus;
		this.contoh = contoh;
		
	}


	public String getId_tenses() {
		return id_tenses;
	}


	public void setId_tenses(String id_tenses) {
		this.id_tenses = id_tenses;
	}


	public String getJudul() {
		return judul;
	}


	public void setJudul(String judul) {
		this.judul = judul;
	}


	public String getIsi() {
		return isi;
	}


	public void setIsi(String isi) {
		this.isi = isi;
	}


	public String getRumus() {
		return rumus;
	}


	public void setRumus(String rumus) {
		this.rumus = rumus;
	}


	public String getContoh() {
		return contoh;
	}


	public void setContoh(String contoh) {
		this.contoh = contoh;
	}
	
	//public String toString(){
		//return judul+" : "+keterangan+" : "+alamat+" : "+noHP;
	//}
}