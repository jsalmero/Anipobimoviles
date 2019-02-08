package eduec.tea.anibopi;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;


public class ActividadPlantas extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener, View.OnTouchListener{

    private static final String TAG = ActividadAnimales.class.getSimpleName();
    public static ImageView a1,p4,p5,a2,a3,p6,btnatras,p4sombra,p5sombra,p6sombra,btnSonido;
    public TableLayout tablelayout;
    public RelativeLayout rel;
    public Random aleatorio;
    public int id1,id2,id3;
    public Intent intent;
    public Intent act1;
    public int cont;
    String msg;
    public  MediaPlayer seleccionaplantas,correctoplanta1,correctoplanta2, correctoplanta3, incorrectoplanta1,incorrectoplanta2,incorrectoplanta3;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    private static final String TAG_PLANTA = "planta";
    private static final String TAG_ANIMAL1 = "animal1";
    private static final String TAG_ANIMAL2 = "animal2";
    private static final String TAG_ANIMAL3 = "animal3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_plantas);
        p4 = (ImageView) findViewById(R.id.p4);
        a1 = (ImageView) findViewById(R.id.a1);
        a2 = (ImageView) findViewById(R.id.a2);

        p5 = (ImageView) findViewById(R.id.p5);
        p6 = (ImageView) findViewById(R.id.p6);
        a3 = (ImageView) findViewById(R.id.a3);
        //p2_2 = (ImageView) findViewById(R.id.p2_2);

        a1.setTag(TAG_ANIMAL1);
        a2.setTag(TAG_ANIMAL2);
        a3.setTag(TAG_ANIMAL3);
        p4.setTag(TAG_PLANTA);
        p5.setTag(TAG_PLANTA);
        p6.setTag(TAG_PLANTA);
        // p2_2.setTag(TAG_PLANTA2);

        p4sombra = (ImageView) findViewById(R.id.p4sombra);
        p5sombra = (ImageView) findViewById(R.id.p5sombra);
        p6sombra = (ImageView) findViewById(R.id.p6sombra);

        //tablelayout = (TableLayout) findViewById(R.id.tablelayout);
        //rel = (RelativeLayout) findViewById(R.id.rel);

        btnatras = (ImageView) findViewById(R.id.btnAtras);
        btnSonido= (ImageView) findViewById(R.id.btnSonido);
        correctoplanta1 = MediaPlayer.create(this, R.raw.correcto1selplanta);
        correctoplanta2 = MediaPlayer.create(this, R.raw.correcto2selplanta);
        correctoplanta3 = MediaPlayer.create(this, R.raw.correcto3selplanta);
        incorrectoplanta1 = MediaPlayer.create(this, R.raw.incorrec1selplanta);
        incorrectoplanta2 = MediaPlayer.create(this, R.raw.incorrec2selplanta);
        incorrectoplanta3 = MediaPlayer.create(this, R.raw.incorrec3selplanta);

        seleccionaplantas = MediaPlayer.create(this, R.raw.actseleccionplanta);

        a2.setVisibility(View.INVISIBLE);
        p5.setVisibility(View.INVISIBLE);
        p6.setVisibility(View.INVISIBLE);
        // p2_2.setVisibility(View.INVISIBLE);
        p5sombra.setVisibility(View.INVISIBLE);
        p6sombra.setVisibility(View.INVISIBLE);


        a1.setOnTouchListener(this);
        a3.setOnTouchListener(this);
        a2.setOnTouchListener(this);
        p4.setOnTouchListener(this);
        p5.setOnTouchListener(this);
        p6.setOnTouchListener(this);
        //  p2_2.setOnTouchListener(this);
        // imageView.setOnLongClickListener(this);
        //   button.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.rel).setOnDragListener(this);

        seleccionaplantas.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    try {

                        seleccionaplantas.reset();
                        correctoplanta1.reset();
                        correctoplanta2.reset();
                        correctoplanta3.reset();
                        incorrectoplanta1.reset();
                        incorrectoplanta2.reset();
                        incorrectoplanta3.reset();

                        seleccionaplantas.prepare();
                        correctoplanta1.prepare();
                        correctoplanta2.prepare();
                        correctoplanta3.prepare();
                        incorrectoplanta1.prepare();
                        incorrectoplanta2.prepare();
                        incorrectoplanta3.prepare();

                        seleccionaplantas.stop();
                        correctoplanta1.stop();
                        correctoplanta2.stop();
                        correctoplanta3.stop();
                        incorrectoplanta1.stop();
                        incorrectoplanta2.stop();
                        incorrectoplanta3.stop();

                        seleccionaplantas.release();
                        correctoplanta1.release();
                        correctoplanta2.release();
                        correctoplanta3.release();
                        incorrectoplanta1.release();
                        incorrectoplanta2.release();
                        incorrectoplanta3.release();

                        seleccionaplantas=null;
                        correctoplanta1=null;
                        correctoplanta2=null;
                        correctoplanta3=null;
                        incorrectoplanta1=null;
                        incorrectoplanta2=null;
                        incorrectoplanta3=null;
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

                if(incorrectoplanta2.isPlaying()){
                    incorrectoplanta2.stop();

                }else if(incorrectoplanta3.isPlaying()){
                    incorrectoplanta3.stop();

                }else if(incorrectoplanta1.isPlaying()){
                    incorrectoplanta1.stop();

                }else if(correctoplanta1.isPlaying()){
                    correctoplanta1.stop();

                }else if(correctoplanta2.isPlaying()){
                    correctoplanta2.stop();

                }else if(correctoplanta3.isPlaying()){
                    correctoplanta3.stop();
                }

                seleccionaplantas.start();
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
                if(dragData.equals("planta")){
                    cont++;
                    //Toast.makeText(this, "Correcto ", Toast.LENGTH_SHORT).show();
                    String c;
                    c = ""+cont;
                    Log.e("mostrar:", c);


                    if(incorrectoplanta2.isPlaying()){
                        incorrectoplanta2.stop();
                        incorrectoplanta2 = MediaPlayer.create(this, R.raw.incorrec2selplanta);

                    }else if(incorrectoplanta1.isPlaying()){
                        incorrectoplanta1.stop();
                        incorrectoplanta1 = MediaPlayer.create(this, R.raw.incorrec1selplanta);

                    }else if(incorrectoplanta3.isPlaying()){
                        incorrectoplanta3.stop();
                        incorrectoplanta3 = MediaPlayer.create(this, R.raw.incorrec3selplanta);

                    }else if(seleccionaplantas.isPlaying()){
                        seleccionaplantas.stop();
                        seleccionaplantas = MediaPlayer.create(this, R.raw.actseleccionplanta);
                    }

                    if(c.equals("1")){

                        a1.setEnabled(false);
                        a3.setEnabled(false);

                        p4.setVisibility(View.INVISIBLE);
                        p4sombra.setImageResource(R.mipmap.p4resultado);

                        correctoplanta1 = MediaPlayer.create(this, R.raw.correcto1selplanta);
                        correctoplanta1.start();
                        Home.acierto++;
                    }
                    if(c.equals("2")){

                        a1.setEnabled(false);
                        a2.setEnabled(false);

                        p5.setVisibility(View.INVISIBLE);
                        p5sombra.setImageResource(R.mipmap.p5resultado);

                        correctoplanta2 = MediaPlayer.create(this, R.raw.correcto2selplanta);
                        correctoplanta2.start();
                        Home.acierto++;
                    }
                    if(c.equals("3")){

                        a2.setEnabled(false);
                        a3.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        p6.setVisibility(View.INVISIBLE);
                        p6sombra.setImageResource(R.mipmap.p6resultado);

                        correctoplanta3 = MediaPlayer.create(this, R.raw.correcto3selplanta);
                        correctoplanta3.start();

                    }

                    Handler h = new Handler();
                    h.postDelayed(r, 4000);

                    // view.setVisibility(View.INVISIBLE);
                }
                else if(dragData.equals("animal1")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoplanta1.isPlaying()){
                        incorrectoplanta1.stop();
                        incorrectoplanta1 = MediaPlayer.create(this, R.raw.incorrec1selplanta);

                    }else if(incorrectoplanta2.isPlaying()){
                        incorrectoplanta2.stop();
                        incorrectoplanta2 = MediaPlayer.create(this, R.raw.incorrec2selplanta);

                    }else if(incorrectoplanta3.isPlaying()){
                        incorrectoplanta3.stop();
                        incorrectoplanta3 = MediaPlayer.create(this, R.raw.incorrec3selplanta);

                    }else if(seleccionaplantas.isPlaying()){
                        seleccionaplantas.stop();
                        seleccionaplantas = MediaPlayer.create(this, R.raw.actseleccionplanta);
                    }

                    incorrectoplanta1 = MediaPlayer.create(this, R.raw.incorrec1selplanta);
                    incorrectoplanta1.start();
                    Home.equivocacion++;
                }
                else if(dragData.equals("animal2")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoplanta2.isPlaying()){
                        incorrectoplanta2.stop();
                        incorrectoplanta2 = MediaPlayer.create(this, R.raw.incorrec2selplanta);

                    }else if(incorrectoplanta1.isPlaying()){
                        incorrectoplanta1.stop();
                        incorrectoplanta1 = MediaPlayer.create(this, R.raw.incorrec1selplanta);

                    }else if(incorrectoplanta3.isPlaying()){
                        incorrectoplanta3.stop();
                        incorrectoplanta3 = MediaPlayer.create(this, R.raw.incorrec3selplanta);

                    }else if(seleccionaplantas.isPlaying()){
                        seleccionaplantas.stop();
                        seleccionaplantas = MediaPlayer.create(this, R.raw.actseleccionplanta);
                    }

                    incorrectoplanta2 = MediaPlayer.create(this, R.raw.incorrec2selplanta);
                    incorrectoplanta2.start();
                    Home.equivocacion++;
                }
                else if(dragData.equals("animal3")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoplanta3.isPlaying()){
                        incorrectoplanta3.stop();
                        incorrectoplanta3 = MediaPlayer.create(this, R.raw.incorrec3selplanta);

                    }else if(incorrectoplanta2.isPlaying()){
                        incorrectoplanta2.stop();
                        incorrectoplanta2 = MediaPlayer.create(this, R.raw.incorrec2selplanta);

                    }else if(incorrectoplanta1.isPlaying()){
                        incorrectoplanta1.stop();
                        incorrectoplanta1 = MediaPlayer.create(this, R.raw.incorrec1selplanta);

                    }else if(seleccionaplantas.isPlaying()){
                        seleccionaplantas.stop();
                        seleccionaplantas = MediaPlayer.create(this, R.raw.actseleccionplanta);
                    }

                    incorrectoplanta3 = MediaPlayer.create(this, R.raw.incorrec3selplanta);
                    incorrectoplanta3.start();
                    Home.equivocacion++;
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


                if (c.equals("1")) {
                    seleccionaplantas.start();

                    a1.setEnabled(true);
                    a3.setEnabled(true);

                    p4.setVisibility(View.INVISIBLE);
                    a3.setVisibility(View.INVISIBLE);
                    p5.setVisibility(View.VISIBLE);
                    a2.setVisibility(View.VISIBLE);

                    p4sombra.setVisibility(View.INVISIBLE);
                    p6sombra.setVisibility(View.INVISIBLE);
                    p5sombra.setVisibility(View.VISIBLE);

                }
                if (c.equals("2")) {
                    seleccionaplantas.start();

                    a1.setEnabled(true);
                    a2.setEnabled(true);

                    p5.setVisibility(View.INVISIBLE);
                    a1.setVisibility(View.INVISIBLE);
                    p6.setVisibility(View.VISIBLE);
                    a3.setVisibility(View.VISIBLE);

                    p4sombra.setVisibility(View.INVISIBLE);
                    p5sombra.setVisibility(View.INVISIBLE);
                    p6sombra.setVisibility(View.VISIBLE);

                }

                if (c.equals("3")) {

                    try {
                        cont = 0;
                        act1 = new Intent(getApplicationContext(), Home.class);
                        startActivity(act1);
                    }finally {
                        finish();
                    }
                }


        }
    };


}