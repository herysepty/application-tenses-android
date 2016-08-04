package control;

import java.util.ArrayList;

import tk.herys.uas_tenses_1211501224.R;
import tk.herys.uas_tenses_1211501224.R.id;
import tk.herys.uas_tenses_1211501224.R.layout;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DataAdapter extends ArrayAdapter<DataList> {
	ArrayList<DataList> arrayListData;
	
	public DataAdapter(Context context, int resource, 
			ArrayList<DataList> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		
		this.arrayListData = objects;
	}
	
	public View getView(int pos, View convertView, ViewGroup parent){
		View v = convertView;
		if(v == null){
			LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.row_tenses, null);
		}
		
		DataList dl = arrayListData.get(pos);
		if(dl != null){
			TextView judul = (TextView) v.findViewById(R.id.lblJudulTenses);
			
			judul.setText(dl.judul);
			//kelas.setText(dl.kelas);
			
		}
		
		return v;
	}
	
	

}