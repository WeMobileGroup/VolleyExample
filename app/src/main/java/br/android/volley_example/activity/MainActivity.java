package br.android.volley_example.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;
import br.android.volley_example.adapter.CarAdapter;
import br.android.volley_example.model.Car;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

/**
 * MainActivity.java class.
 * 
 * @author Rodrigo Cericatto
 * @since 15/10/2014
 */
public class MainActivity extends ListActivity implements
	Response.Listener<JSONObject>, Response.ErrorListener {

	//--------------------------------------------------
	// Activity Life Cycle
	//--------------------------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String url = "http://www.livroandroid.com.br/livro/carros/carros_classicos.json";
		RequestQueue queue = Volley.newRequestQueue(this);

		JsonObjectRequest jsonObjectRequest =
			new JsonObjectRequest(
			Request.Method.GET,		// Requisition via HTTP_GET
			url,					// URL of the requisition
			null,					// JSONObject to be sent through POST
			this,					// Response.Listener
			this);					// Response.ErrorListener
		queue.add(jsonObjectRequest);
	}
	
	//--------------------------------------------------
	// Listeners
	//--------------------------------------------------

	@Override
	public void onResponse(JSONObject response) {
		List<Car> carList = new ArrayList<Car>();

		try {
			// N�o precisamos converter o InputStream em String.
			JSONObject carListJson = response.
				getJSONObject("carros");
			JSONArray carJson = carListJson.
				getJSONArray("carro");

			for (int i = 0; i < carJson.length(); i++) {
				JSONObject item = carJson.getJSONObject(i);
				String name = item.getString("nome");
				String thumbnail = item.getString("url_foto");

				Car car = new Car(name, thumbnail);
				carList.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setListAdapter(new CarAdapter(this, carList));
	}

	@Override
	public void onErrorResponse(VolleyError error) {
		Toast.makeText(this, "Erro!",
			Toast.LENGTH_SHORT).show();
	}
}