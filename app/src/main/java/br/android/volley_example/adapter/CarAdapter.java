package br.android.volley_example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.android.volley_example.R;
import br.android.volley_example.model.Car;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * CarAdapter.java class.
 * 
 * @author Rodrigo Cericatto
 * @since 15/10/2014
 */
public class CarAdapter extends ArrayAdapter<Car> {

	//--------------------------------------------------
	// Attributes 
	//--------------------------------------------------
	
	private Context mContext;
	
	//--------------------------------------------------
	// Constructor 
	//--------------------------------------------------
	
	public CarAdapter(Context context, List<Car> carList) {
		super(context, R.layout.list_adapter, carList);
		mContext = context;
	}
	
	//--------------------------------------------------
	// Adapter
	//--------------------------------------------------

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Context context = parent.getContext();
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.list_adapter, null);
		}

		getData(convertView, position);
		
		return convertView;
	}
	
	//--------------------------------------------------
	// Methods
	//--------------------------------------------------
	
	/**
	 * Gets the data.
	 * 
	 * @param convertView
	 * @param position
	 */
	public void getData(View convertView, Integer position) {
		ImageView image = (ImageView) convertView.findViewById(R.id.list_adapter__image_view);
		TextView text = (TextView) convertView.findViewById(R.id.list_adapter__text_view);

		Car car = getItem(position);
		text.setText(car.getName());
		setUniversalImage(car.getImageUrl(), image);
	}
	
	/**
	 * Sets the image from each {@link ImageView}.<br>If it exists, get from cache.<br>If isn't, download it.
	 *  
	 * @param url The url of the image.
	 * @param imageView The {@link ImageView} which will receive the image.
	 */
	public void setUniversalImage(String url, ImageView imageView) {
		DisplayImageOptions cache = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
		imageLoader.displayImage(url, imageView, cache);
	}
}