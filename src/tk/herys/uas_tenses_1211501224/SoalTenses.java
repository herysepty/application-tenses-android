package tk.herys.uas_tenses_1211501224;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import control.Control;
import control.DataList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SoalTenses extends Activity {

	Control control = new Control();
	JSONArray arraySoal;	
	
	private CountDownTimer mCountDownTimer;
	private int detik = 600 * 200;
	int  index = 0,Benar=0,Salah=0;
	int skor=0;
	
	/*@Override
	protected void onStart(){
		super.onStart();
		
	}*/
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_soal);
        
    	Button btnSelesai = (Button)this.findViewById(R.id.btnSelesai);
    	btnSelesai.setVisibility(View.GONE);
		tampilPertanyaan(0);
		//setUpWaktu();
		Toast.makeText(getBaseContext(), "Isikan Pertanyaan yang Kosong dengan jawaban yang benar :) ", Toast.LENGTH_LONG).show();
	}

	
	public void tampilPertanyaan(int indexke){
		
		Intent intent = getIntent();
    	DataList dl = (DataList) intent.getSerializableExtra("kirimIsiTenses");
    	
    	TextView soal=(TextView)findViewById(R.id.lblPertanyaan);
    	RadioButton rbA= (RadioButton) this.findViewById(R.id.rbA);
    	RadioButton rbB= (RadioButton) this.findViewById(R.id.rbB);
    	RadioButton rbC= (RadioButton) this.findViewById(R.id.rbC);
    	TextView txtJwb=(TextView)findViewById(R.id.txtJwbBenar);
    	txtJwb.setVisibility(View.GONE);
		
		try {
			arraySoal = new JSONArray(control.getSoalById_tenses(dl.id_tenses));
			
				JSONObject jsonChildNode = arraySoal.getJSONObject(indexke);
				String id_soal = jsonChildNode.optString("id_soal");
				String pertanyaan = jsonChildNode.optString("pertanyaan");
				String a = jsonChildNode.optString("jwb_a");
				String b = jsonChildNode.optString("jwb_b");
				String c = jsonChildNode.optString("jwb_c");
				String jwbBenar = jsonChildNode.optString("jwb_benar");
				
			    soal.setText(pertanyaan);
			    rbA.setText(a);
			    rbB.setText(b);
			    rbC.setText(c);
			    rbA.setChecked(false);
			    rbB.setChecked(false);
			    rbC.setChecked(false);
			    txtJwb.setText(jwbBenar);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void btnNext(View bebas){
		Button btn = (Button) this.findViewById(R.id.button1);
		Button btnSelesai = (Button) this.findViewById(R.id.btnSelesai);
		if(index<arraySoal.length()-1){
			cekJawaban();
			index++;
			tampilPertanyaan(index);
		}
		if(index>arraySoal.length()-2){
			btn.setVisibility(View.GONE);
			btnSelesai.setVisibility(View.VISIBLE);
			
		}
	}
	
	public void cekJawaban(){
		RadioButton vrbA= (RadioButton) this.findViewById(R.id.rbA);
    	RadioButton vrbB= (RadioButton) this.findViewById(R.id.rbB);
    	RadioButton vrbC= (RadioButton) this.findViewById(R.id.rbC);
		TextView txtJwb=(TextView)findViewById(R.id.txtJwbBenar);
		
		if((vrbA.isChecked())&&(txtJwb.getText().toString().equals("a"))){
			
			Benar++;
	       	
	    }else if((vrbB.isChecked()) && (txtJwb.getText().toString().equals("b"))){
	    	Benar++;
	    	
	    }else if((vrbC.isChecked()) && (txtJwb.getText().toString().equals("c"))){
	    	Benar++;
	    	
	    }else{
	    	Salah++;
	    }
		
	}
	
	public void btnSelesai(View bebas){
		
		Intent intent = getIntent();
    	final String data = (String) intent.getSerializableExtra("nama");
    	
		cekJawaban();
		skor=((100/arraySoal.length()) * Benar);
		
		final String sSkor = String.valueOf(skor);
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("Nilai Kamu "+data)
		.setMessage("\n\n                       "+sSkor)
		.setView(linearLayout)
		.setPositiveButton("SIMPAN SKOR", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				control.insertSkor(data, Benar, Salah, sSkor);
				Toast.makeText(getBaseContext(), "Skor Berhasil disimpan", Toast.LENGTH_LONG).show();
				finish();
				
			}
		})
		.setNeutralButton("Kembali", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				//arg0.cancel();
				finish();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		
	}
}
