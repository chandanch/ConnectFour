/* Developed by Chandan */

package chandan.connectfour;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button b1,exit,learn,offical;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button)findViewById(R.id.button1);
		offical = (Button)findViewById(R.id.button3);
		learn = (Button)findViewById(R.id.button2);
		learn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent inlearn = new Intent(getApplicationContext(), Learn.class);
				startActivity(inlearn);
			}
		});
	exit = (Button)findViewById(R.id.button4);
	exit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent inexit = new Intent(Intent.ACTION_MAIN);
			inexit.addCategory(Intent.CATEGORY_HOME);
			inexit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(inexit);
		}
	});
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),Connect4Activity.class );
				startActivity(in);
				
			}
		});
offical.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent browserIntent = 
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://chanappstore.1apps.com"));
		    startActivity(browserIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
