package eduec.tea.anibopi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Creditos extends AppCompatActivity {

    public Intent act1;
    public ImageView btnatras, btnsiguiente, creditos1;
    public int cont;
    public RelativeLayout rel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        btnatras = (ImageView) findViewById(R.id.btnAtras);
        btnsiguiente = (ImageView) findViewById(R.id.btnSiguiente);

        rel = (RelativeLayout) findViewById(R.id.rel1);

        //creditos1 = (ImageView) findViewById(R.id.creditos);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cont=0;
                try {
                    act1 = new Intent(getApplicationContext(), Inicio.class);
                    startActivity(act1);
                }finally {
                    finish();
                }
            }
        });

        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                String c;
                c = ""+cont;
                if (c.equals("1")) {
                    rel.setBackgroundResource(R.drawable.creditosequipo);
                }else if(c.equals("2")){
                    rel.setBackgroundResource(R.drawable.creditoscolaboradores);
                }else if(c.equals("3")){
                    cont=0;
                    rel.setBackgroundResource(R.drawable.creditosagradecimientos);
                }
            }
        });


    }

    void kill_activity(){finish();}
}
