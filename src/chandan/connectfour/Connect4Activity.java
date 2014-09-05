/* Developed by Chandan */

package chandan.connectfour;



import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Connect4Activity extends Activity {
	private int rowNumber = 6;
	private int colNumber = 7;
	Connect4View connect4View;
	GameImp game;
    TextView depthTV;
    CheckBox humanFirstCB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.game);
        
        game = new GameImp(rowNumber,colNumber, GameImp.HUMAN_SIDE);
        
        connect4View = (Connect4View) this.findViewById(R.id.connect4View);
        
        connect4View.setGame(game);
        int depth = game.getPlyDepth();
        
        depthTV= (TextView)this.findViewById(R.id.plidDepth);
        depthTV.setText("  Current Depth is: "+depth);
        
        humanFirstCB = (CheckBox)this.findViewById(R.id.humanFirstCB);
        humanFirstCB.setChecked(true);
        
        Button start_btn = (Button)this.findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				boolean humanFirst = humanFirstCB.isChecked();
				if(humanFirst){
					game = new GameImp(rowNumber,colNumber, GameImp.HUMAN_SIDE);
				}else{
					game = new GameImp(rowNumber,colNumber, GameImp.COMPUTER_SIDE);
					game.nextComputer();
				}
				connect4View.setGame(game);
				int d = game.getPlyDepth();
				depthTV.setText("  Current Depth is: "+d);
			}}); 
        
        Button depth_add_btn = (Button)this.findViewById(R.id.depth_add_btn);
        depth_add_btn.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				int d = game.getPlyDepth()+1;
				if(d>10) return;
				game.setPlyDepth(d);
				depthTV.setText("  Current Depth is: "+d);
			}}); 
        Button depth_minus_btn = (Button)this.findViewById(R.id.depth_minus_btn);
        depth_minus_btn.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				int d = game.getPlyDepth()-1;
				if(d<2) return;
				game.setPlyDepth(d);
				depthTV.setText("  Current Depth is: "+d);
			}}); 

    }

    
}
