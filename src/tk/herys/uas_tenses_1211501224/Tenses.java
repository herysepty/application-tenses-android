package tk.herys.uas_tenses_1211501224;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import control.Control;
import control.DataAdapter;
import control.DataList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class Tenses extends Activity {
	Control control = new Control();
	JSONArray arrayMahasiswa;
	
	ArrayList<DataList> items2 = new ArrayList<DataList>();
	DataAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tenses);	
		
		adapter = new DataAdapter(this,R.layout.row_tenses, items2);
		try {
			arrayMahasiswa = new JSONArray(control.tampilTenses());

			for (int i = 0; i < arrayMahasiswa.length(); i++) {
				JSONObject jsonChildNode = arrayMahasiswa.getJSONObject(i);
				String id_tenses = jsonChildNode.optString("id_tenses");
				String judul = jsonChildNode.optString("judul");
				String isi = jsonChildNode.optString("isi");
				String rumus = jsonChildNode.optString("rumus");
				String contoh = jsonChildNode.optString("contoh");

				items2.add(new DataList(id_tenses,judul,isi,rumus,contoh));
			}
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		ListView itemListView = (ListView) this.findViewById(R.id.listViewTenses);
		itemListView.setAdapter(adapter);
		
		itemListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				DataList dl = items2.get(arg2);
				Intent inten = new Intent(getApplicationContext(),IsiTenses.class);
				inten.putExtra("kirimIsiTenses", dl);
				startActivityForResult(inten, 99);	
				
		
			}
		});
	}
	

}
