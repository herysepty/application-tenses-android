package tk.herys.uas_tenses_1211501224;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import control.Control;
import control.DataList;

import android.R.color;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class IsiTenses extends Activity {
	
	Control control = new Control();
	JSONArray arrayMahasiswa;
	
	protected void onStart(){
		super.onStart();
		Intent intent = getIntent();
		DataList dl = (DataList) intent.getSerializableExtra("kirimIsiTenses");
		
		TextView judul = (TextView) this.findViewById(R.id.lblJudul);
		TextView isi = (TextView) this.findViewById(R.id.lblIsi);
		TextView rumus = (TextView) this.findViewById(R.id.lblRumus);
		TextView contoh = (TextView) this.findViewById(R.id.lblContoh);
		judul.setText(dl.judul);
		isi.setText(dl.isi);
		rumus.setTextColor(Color.BLUE);
		rumus.setText(dl.rumus);
		contoh.setText(dl.contoh);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tenses_isi);
		
	}
		public void actionLatihanSoal(View v) {
			LinearLayout linearLayout = new LinearLayout(this);
			linearLayout.setOrientation(LinearLayout.VERTICAL);
			
			final EditText nama = new EditText(this);
			linearLayout.addView(nama);

			AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("Masukan Nama Anda")
			.setView(linearLayout)
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					if(nama.getText().toString().equals("")){
						
						Toast.makeText(getBaseContext(), "Nama Harus diisi", Toast.LENGTH_LONG).show();
						
					}else{
						Intent intent = getIntent();
						DataList dl = (DataList) intent.getSerializableExtra("kirimIsiTenses");
						
						Intent inten = new Intent(getApplicationContext(),SoalTenses.class);
						inten.putExtra("nama", nama.getText().toString());
						inten.putExtra("kirimIsiTenses", dl);
						startActivityForResult(inten, 99);	
						//Toast.makeText(getBaseContext(), nama.getText(), Toast.LENGTH_LONG).show();
					}
					
				}
			})
			.setNeutralButton("Batal", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					arg0.cancel();
				}
			});
			AlertDialog alert = builder.create();
			alert.show();
	}

	

}
