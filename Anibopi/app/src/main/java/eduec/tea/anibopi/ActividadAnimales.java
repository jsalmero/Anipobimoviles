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


public class ActividadAnimales extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener, View.OnTouchListener{

    private static final String TAG = ActividadAnimales.class.getSimpleName();
    public static ImageView a1,p1,p2,a2,a3,p3,btnatras,a1sombra,a2sombra,a3sombra,btnSonido;
    public TableLayout tablelayout;
    public RelativeLayout rel;
    public Random aleatorio;
    public int id1,id2,id3;
    public Intent intent;
    public Intent act1;
    public int cont;


    String msg;
    public  MediaPlayer seleccionanimales, correctoanimal1,correctoanimal2, correctoanimal3, incorrectoanimal1,incorrectoanimal2,incorrectoanimal3;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    private static final String TAG_ANIMAL = "animal";
    private static final String TAG_PLANTA1 = "planta1";
    private static final String TAG_PLANTA2 = "planta2";
    private static final String TAG_PLANTA3 = "planta3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_animales);

        a1 = (ImageView) findViewById(R.id.a1);
        p1 = (ImageView) findViewById(R.id.p1);
        p2 = (ImageView) findViewById(R.id.p2);

        a2 = (ImageView) findViewById(R.id.a2);
        a3 = (ImageView) findViewById(R.id.a3);
        p3 = (ImageView) findViewById(R.id.p3);
        //p2_2 = (ImageView) findViewById(R.id.p2_2);

        a1.setTag(TAG_ANIMAL);
        a2.setTag(TAG_ANIMAL);
        a3.setTag(TAG_ANIMAL);
        p1.setTag(TAG_PLANTA1);
        p2.setTag(TAG_PLANTA2);
        p3.setTag(TAG_PLANTA3);
        // p2_2.setTag(TAG_PLANTA2);

        a1sombra = (ImageView) findViewById(R.id.a1sombra);
        a2sombra = (ImageView) findViewById(R.id.a2sombra);
        a3sombra = (ImageView) findViewById(R.id.a3sombra);

        //tablelayout = (TableLayout) findViewById(R.id.tablelayout);
        //rel = (RelativeLayout) findViewById(R.id.rel);

        btnatras = (ImageView) findViewById(R.id.btnAtras);
        btnSonido= (ImageView) findViewById(R.id.btnSonido);

        correctoanimal1 = MediaPlayer.create(this, R.raw.correcto1selanimal);
        correctoanimal2 = MediaPlayer.create(this, R.raw.correcto2selanimal);
        correctoanimal3 = MediaPlayer.create(this, R.raw.correcto3selanimal);
        incorrectoanimal1 = MediaPlayer.create(this, R.raw.incorrec1selanimal);
        incorrectoanimal2 = MediaPlayer.create(this, R.raw.incorrec2selanimal);
        incorrectoanimal3 = MediaPlayer.create(this, R.raw.incorrec3selanimal);

        seleccionanimales = MediaPlayer.create(this, R.raw.actseleccionanimal);

        a2.setVisibility(View.INVISIBLE);
        a3.setVisibility(View.INVISIBLE);
        p3.setVisibility(View.INVISIBLE);
        // p2_2.setVisibility(View.INVISIBLE);
        a2sombra.setVisibility(View.INVISIBLE);
        a3sombra.setVisibility(View.INVISIBLE);


        a1.setOnTouchListener(this);
        a3.setOnTouchListener(this);
        p1.setOnTouchListener(this);
        p2.setOnTouchListener(this);
        a2.setOnTouchListener(this);
        p3.setOnTouchListener(this);
        //  p2_2.setOnTouchListener(this);
        // imageView.setOnLongClickListener(this);
        //   button.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.rel).setOnDragListener(this);

        seleccionanimales.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    try {

                        seleccionanimales.reset();
                        correctoanimal1.reset();
                        correctoanimal2.reset();
                        correctoanimal3.reset();
                        incorrectoanimal1.reset();
                        incorrectoanimal2.reset();
                        incorrectoanimal3.reset();

                        seleccionanimales.prepare();
                        correctoanimal1.prepare();
                        correctoanimal2.prepare();
                        correctoanimal3.prepare();
                        incorrectoanimal1.prepare();
                        incorrectoanimal2.prepare();
                        incorrectoanimal3.prepare();

                        seleccionanimales.stop();
                        correctoanimal1.stop();
                        correctoanimal2.stop();
                        correctoanimal3.stop();
                        incorrectoanimal1.stop();
                        incorrectoanimal2.stop();
                        incorrectoanimal3.stop();

                        seleccionanimales.release();
                        correctoanimal1.release();
                        correctoanimal2.release();
                        correctoanimal3.release();
                        incorrectoanimal1.release();
                        incorrectoanimal2.release();
                        incorrectoanimal3.release();

                        seleccionanimales=null;
                        correctoanimal1=null;
                        correctoanimal2=null;
                        correctoanimal3=null;
                        incorrectoanimal1=null;
                        incorrectoanimal2=null;
                        incorrectoanimal3=null;

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



                    if(incorrectoanimal2.isPlaying()){
                        incorrectoanimal2.stop();

                    }else if(incorrectoanimal3.isPlaying()){
                        incorrectoanimal3.stop();

                    }else if(incorrectoanimal1.isPlaying()){
                        incorrectoanimal1.stop();

                    }else if(correctoanimal1.isPlaying()){
                        correctoanimal1.stop();

                    }else if(correctoanimal2.isPlaying()){
                        correctoanimal2.stop();

                    }else if(correctoanimal3.isPlaying()){
                        correctoanimal3.stop();
                    }

                    seleccionanimales.start();


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
                if(dragData.equals("animal")){
                    cont++;
                    //Toast.makeText(this, "Correcto ", Toast.LENGTH_SHORT).show();

                    String c;
                    c = ""+cont;
                    Log.e("mostrar:", c);

                    if(incorrectoanimal2.isPlaying()){
                        incorrectoanimal2.stop();
                        incorrectoanimal2 = MediaPlayer.create(this, R.raw.incorrec2selanimal);

                    }else if(incorrectoanimal1.isPlaying()){
                        incorrectoanimal1.stop();
                        incorrectoanimal1 = MediaPlayer.create(this, R.raw.incorrec1selanimal);

                    }else if(incorrectoanimal3.isPlaying()){
                        incorrectoanimal3.stop();
                        incorrectoanimal3 = MediaPlayer.create(this, R.raw.incorrec3selanimal);

                    }else if(seleccionanimales.isPlaying()){
                        seleccionanimales.stop();
                        seleccionanimales = MediaPlayer.create(this, R.raw.actseleccionanimal);
                    }

                    if(c.equals("1")){

                        p1.setEnabled(false);
                        p2.setEnabled(false);

                        a1.setVisibility(View.INVISIBLE);
                        a1sombra.setImageResource(R.mipmap.a1resultado);

                        correctoanimal1 = MediaPlayer.create(this, R.raw.correcto1selanimal);
                        correctoanimal1.start();

                    }
                    if(c.equals("2")){

                        p2.setEnabled(false);
                        p3.setEnabled(false);

                        a2.setVisibility(View.INVISIBLE);
                        a2sombra.setImageResource(R.mipmap.a3resultado);

                        correctoanimal2 = MediaPlayer.create(this, R.raw.correcto2selanimal);
                        correctoanimal2.start();

                    }
                    if(c.equals("3")){

                        p1.setEnabled(false);
                        p3.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        a3.setVisibility(View.INVISIBLE);
                        a3sombra.setImageResource(R.mipmap.a2resultado);

                        correctoanimal3 = MediaPlayer.create(this, R.raw.correcto3selanimal);
                        correctoanimal3.start();
                    }

                    Handler h = new Handler();
                    h.postDelayed(r, 4000);

                    // view.setVisibility(View.INVISIBLE);
                }
                else if(dragData.equals("planta1")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoanimal1.isPlaying()){
                        incorrectoanimal1.stop();
                        incorrectoanimal1 = MediaPlayer.create(this, R.raw.incorrec1selanimal);

                    }else if(incorrectoanimal2.isPlaying()){
                        incorrectoanimal2.stop();
                        incorrectoanimal2 = MediaPlayer.create(this, R.raw.incorrec2selanimal);

                    }else if(incorrectoanimal3.isPlaying()){
                        incorrectoanimal3.stop();
                        incorrectoanimal3 = MediaPlayer.create(this, R.raw.incorrec3selanimal);

                    }else if(seleccionanimales.isPlaying()){
                        seleccionanimales.stop();
                        seleccionanimales = MediaPlayer.create(this, R.raw.actseleccionanimal);
                    }

                    incorrectoanimal1 = MediaPlayer.create(this, R.raw.incorrec1selanimal);
                    incorrectoanimal1.start();

                }

                else if(dragData.equals("planta2")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoanimal2.isPlaying()){
                        incorrectoanimal2.stop();
                        incorrectoanimal2 = MediaPlayer.create(this, R.raw.incorrec2selanimal);

                    }else if(incorrectoanimal1.isPlaying()){
                        incorrectoanimal1.stop();
                        incorrectoanimal1 = MediaPlayer.create(this, R.raw.incorrec1selanimal);

                    }else if(incorrectoanimal3.isPlaying()){
                        incorrectoanimal3.stop();
                        incorrectoanimal3 = MediaPlayer.create(this, R.raw.incorrec3selanimal);

                    }else if(seleccionanimales.isPlaying()){
                        seleccionanimales.stop();
                        seleccionanimales = MediaPlayer.create(this, R.raw.actseleccionanimal);
                    }

                    incorrectoanimal2 = MediaPlayer.create(this, R.raw.incorrec2selanimal);
                    incorrectoanimal2.start();

                }
                else if(dragData.equals("planta3")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoanimal3.isPlaying()){
                        incorrectoanimal3.stop();
                        incorrectoanimal3 = MediaPlayer.create(this, R.raw.incorrec3selanimal);

                    }else if(incorrectoanimal2.isPlaying()){
                        incorrectoanimal2.stop();
                        incorrectoanimal2 = MediaPlayer.create(this, R.raw.incorrec2selanimal);

                    }else if(incorrectoanimal1.isPlaying()){
                        incorrectoanimal1.stop();
                        incorrectoanimal1 = MediaPlayer.create(this, R.raw.incorrec1selanimal);

                    }else if(seleccionanimales.isPlaying()){
                        seleccionanimales.stop();
                        seleccionanimales = MediaPlayer.create(this, R.raw.actseleccionanimal);
                    }

                    incorrectoanimal3 = MediaPlayer.create(this, R.raw.incorrec3selanimal);
                    incorrectoanimal3.start();

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

                    seleccionanimales.start();

                    p1.setEnabled(true);
                    p2.setEnabled(true);

                    a1.setVisibility(View.INVISIBLE);
                    p1.setVisibility(View.INVISIBLE);
                    a1sombra.setVisibility(View.INVISIBLE);
                    a2.setVisibility(View.VISIBLE);
                    p3.setVisibility(View.VISIBLE);
                    a2sombra.setVisibility(View.VISIBLE);

                }
                if (c.equals("2")) {
                    seleccionanimales.start();

                    p2.setEnabled(true);
                    p3.setEnabled(true);

                    p2.setVisibility(View.INVISIBLE);
                    a2.setVisibility(View.INVISIBLE);
                    p2.setVisibility(View.INVISIBLE);
                    a2sombra.setVisibility(View.INVISIBLE);
                    a3.setVisibility(View.VISIBLE);
                    p1.setVisibility(View.VISIBLE);
                    a3sombra.setVisibility(View.VISIBLE);
                }

                if (c.equals("3")) {

                    try {
                        act1 = new Intent(getApplicationContext(), Home.class);
                        startActivity(act1);
                    }finally {
                        finish();
                    }
                }


        }
    };
}