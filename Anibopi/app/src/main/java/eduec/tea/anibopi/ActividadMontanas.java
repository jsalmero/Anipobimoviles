package eduec.tea.anibopi;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;


public class ActividadMontanas extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener, View.OnTouchListener{

    private ImageView t2,t3,t4, btnatras,t1sombra,btnSonido;

    // public Random aleatorio;
    //public int id1,id2,id3;

    public TableLayout tablelayout;
    public RelativeLayout rel;
    public Random aleatorio;
    public int id1,id2,id3;
    public Intent intent;
    public Intent act1;
    public int cont=0;
    String msg;

    public MediaPlayer correctomontana1,incorrectomontana1,incorrectomontana2,completarompecabezas;

    private static final String TAG_PIEZACO = "piezacorrecta";
    private static final String TAG_PIEZAINC1 = "piezaincorrecta1";
    private static final String TAG_PIEZAINC2 = "piezaincorrecta2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_montanas);

        t1sombra = (ImageView) findViewById(R.id.t1);

        t2 = (ImageView) findViewById(R.id.t2);
        t3 = (ImageView) findViewById(R.id.t3);
        t4 = (ImageView) findViewById(R.id.t4);
        //a1sombra = (ImageView) findViewById(R.id.a1sombra);

        btnatras = (ImageView) findViewById(R.id.btnAtras);
        btnSonido= (ImageView) findViewById(R.id.btnSonido);

        t3.setTag(TAG_PIEZACO);
        t2.setTag(TAG_PIEZAINC1);
        t4.setTag(TAG_PIEZAINC2);

        correctomontana1 = MediaPlayer.create(this, R.raw.correctorpmontanas);
        incorrectomontana1 = MediaPlayer.create(this, R.raw.incorrec1montanas);
        incorrectomontana2 = MediaPlayer.create(this, R.raw.incorrec2montanas);
        completarompecabezas = MediaPlayer.create(this, R.raw.actropmontanas);

        t2.setOnTouchListener(this);
        t3.setOnTouchListener(this);
        t4.setOnTouchListener(this);

        //  p2_2.setOnTouchListener(this);
        // imageView.setOnLongClickListener(this);
        //   button.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.rel).setOnDragListener(this);

        completarompecabezas.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    try {

                        correctomontana1.reset();
                        incorrectomontana1.reset();
                        incorrectomontana2.reset();
                        completarompecabezas.reset();

                        correctomontana1.prepare();
                        incorrectomontana1.prepare();
                        incorrectomontana2.prepare();
                        completarompecabezas.prepare();

                        correctomontana1.stop();
                        incorrectomontana1.stop();
                        incorrectomontana2.stop();
                        completarompecabezas.stop();

                        correctomontana1.release();
                        incorrectomontana1.release();
                        incorrectomontana2.release();
                        completarompecabezas.release();

                        correctomontana1=null;
                        incorrectomontana1=null;
                        incorrectomontana2=null;
                        completarompecabezas=null;
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

        btnSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(incorrectomontana1.isPlaying()){
                    incorrectomontana1.stop();

                }else if(incorrectomontana2.isPlaying()){
                    incorrectomontana2.stop();

                }else if(correctomontana1.isPlaying()){
                    correctomontana1.stop();

                }

                completarompecabezas.start();
            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(data//data to be dragged
                , shadowBuilder //drag shadow
                , view//local data about the drag and drop operation
                , 0//no needed flags
        );
        // view.setVisibility(View.INVISIBLE);
        return true;
    }

    @Override
    public boolean onLongClick(View view) {

        return true;
    }

    @Override
    public boolean onDrag(View view, DragEvent event) {
        int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);//set background color to your view

                    //  view.invalidate();

                    return true;
                }
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
//                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                view.invalidate();

                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                view.invalidate();

                return true;
            case DragEvent.ACTION_DROP:
                ClipData.Item item = event.getClipData().getItemAt(0);
                String dragData = item.getText().toString();
                //   Toast.makeText(this, "Muy bien " + dragData, Toast.LENGTH_SHORT).show();
                // Toast.makeText(this, " "+dragData, Toast.LENGTH_SHORT).show();
                // Log.e("mostrar:", dragData);
                if(dragData.equals("piezacorrecta")){

                    if(incorrectomontana1.isPlaying()){
                        incorrectomontana1.stop();
                        incorrectomontana1 = MediaPlayer.create(this, R.raw.incorrec1montanas);

                    }else if(incorrectomontana2.isPlaying()){
                        incorrectomontana2.stop();
                        incorrectomontana2 = MediaPlayer.create(this, R.raw.incorrec2montanas);

                    }else if(completarompecabezas.isPlaying()){
                        completarompecabezas.stop();
                        completarompecabezas = MediaPlayer.create(this, R.raw.actropmontanas);
                    }

                    cont++;
                    t3.setVisibility(View.INVISIBLE);

                    t2.setEnabled(false);
                    t4.setEnabled(false);
                    btnSonido.setVisibility(View.INVISIBLE);

                    t1sombra.setImageResource(R.mipmap.montanasrompecabezas);

                    correctomontana1 = MediaPlayer.create(this, R.raw.correctorpmontanas);
                    correctomontana1.start();

                    Handler h = new Handler();
                    h.postDelayed(r, 4000);

                }
                else if(dragData.equals("piezaincorrecta1")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectomontana1.isPlaying()){
                        incorrectomontana1.stop();
                        incorrectomontana1 = MediaPlayer.create(this, R.raw.incorrec1montanas);

                    }else if(incorrectomontana2.isPlaying()){
                        incorrectomontana2.stop();
                        incorrectomontana2 = MediaPlayer.create(this, R.raw.incorrec2montanas);

                    }else if(completarompecabezas.isPlaying()){
                        completarompecabezas.stop();
                        completarompecabezas = MediaPlayer.create(this, R.raw.actropmontanas);
                    }

                    incorrectomontana1 = MediaPlayer.create(this, R.raw.incorrec1montanas);
                    incorrectomontana1.start();
                }

                else if(dragData.equals("piezaincorrecta2")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectomontana2.isPlaying()){
                        incorrectomontana2.stop();
                        incorrectomontana2 = MediaPlayer.create(this, R.raw.incorrec2montanas);

                    }else if(incorrectomontana1.isPlaying()){
                        incorrectomontana1.stop();
                        incorrectomontana1 = MediaPlayer.create(this, R.raw.incorrec1montanas);

                    }else if(completarompecabezas.isPlaying()){
                        completarompecabezas.stop();
                        completarompecabezas = MediaPlayer.create(this, R.raw.actropmontanas);
                    }

                    incorrectomontana2 = MediaPlayer.create(this, R.raw.incorrec2montanas);
                    incorrectomontana2.start();
                }


                //  validar(dragData);
                //   view.getBackground().clearColorFilter();
                view.invalidate();
                View v = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) v.getParent();
                //  owner.removeView(v);//remove the dragged view
                RelativeLayout container = (RelativeLayout) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                //  container.addView(v);//Add the dragged view
                // v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
//                view.getBackground().clearColorFilter();

                view.invalidate();
                // view.setVisibility(View.VISIBLE);
                if (event.getResult()){
                    // Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Toast.makeText(this, "Mover hacia la casilla.", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    public void validar(String str){

    }

    void kill_activity(){finish();}

    Runnable r = new Runnable() {
        @Override
        public void run(){
            String c;
            c = ""+cont;
            try {
                if(c.equals("1")){

                    cont=0;


                        act1=new Intent(getApplicationContext(),Home.class);
                        startActivity(act1);

                }
            }finally {
                finish();
            }


        }
    };

}
