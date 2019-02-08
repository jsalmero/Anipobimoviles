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

public class ActividadEvaluacion extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener, View.OnTouchListener{

    private ImageView t2,t3,t4,t5,t6,t7,t8,t9, btnatras,t1sombra,btnSonido,btnSonidoSNV;
    private ImageView tsnv3,tsnv4,tsnv8;

    // public Random aleatorio;
    //public int id1,id2,id3;

    public TableLayout tablelayout;
    public RelativeLayout rel;
    public Random aleatorio;
    public int id1,id2,id3;
    public int num;
    public Intent intent;
    public Intent act1;
    public int cont=0, bnd=0;
    public String numaleat;
    String msg;

    public MediaPlayer correctoseresvivos,incorrectoservivo,seleccionaservivo, correctoseresnovivos,incorrectosernovivo,seleccionasernovivo;

    private static final String TAG_PIEZACO1 = "piezacorrecta1";
    private static final String TAG_PIEZACO2 = "piezacorrecta2";
    private static final String TAG_PIEZAINC = "piezaincorrecta";

    private static final String TAG_PIEZACOSNV1 = "piezacorrectasnv1";
    private static final String TAG_PIEZACOSNV2 = "piezacorrectasnv2";
    private static final String TAG_PIEZAINCSNV = "piezaincorrectasnv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_evaluacion);
        t1sombra = (ImageView) findViewById(R.id.t1);

        t2 = (ImageView) findViewById(R.id.t2);
        t3 = (ImageView) findViewById(R.id.t3);
        t4 = (ImageView) findViewById(R.id.t4);

        t5 = (ImageView) findViewById(R.id.t5);
        t6 = (ImageView) findViewById(R.id.t6);
        t7 = (ImageView) findViewById(R.id.t7);
        t8 = (ImageView) findViewById(R.id.t8);
        t9 = (ImageView) findViewById(R.id.t9);
        //a1sombra = (ImageView) findViewById(R.id.a1sombra);

        tsnv3 = (ImageView) findViewById(R.id.tsnv3);
        tsnv4 = (ImageView) findViewById(R.id.tsnv4);
        tsnv8 = (ImageView) findViewById(R.id.tsnv8);

        btnatras = (ImageView) findViewById(R.id.btnAtras);
        btnSonido= (ImageView) findViewById(R.id.btnSonido);
        btnSonidoSNV= (ImageView) findViewById(R.id.btnSonidoSNV);

        t3.setTag(TAG_PIEZACO1);
        t2.setTag(TAG_PIEZACO2);
        t4.setTag(TAG_PIEZAINC);

        t5.setTag(TAG_PIEZACO1);
        t9.setTag(TAG_PIEZACO2);
        t8.setTag(TAG_PIEZAINC);

        t6.setTag(TAG_PIEZACO1);
        t7.setTag(TAG_PIEZACO2);

        tsnv4.setTag(TAG_PIEZACOSNV1);
        tsnv8.setTag(TAG_PIEZACOSNV2);
        tsnv3.setTag(TAG_PIEZAINCSNV);

        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
        incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);
        seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);

        correctoseresnovivos = MediaPlayer.create(this, R.raw.correcto1selsnv);
        incorrectosernovivo = MediaPlayer.create(this, R.raw.incorrec1selsnv);
        seleccionasernovivo = MediaPlayer.create(this, R.raw.actseleccionsnv);

        t2.setOnTouchListener(this);
        t3.setOnTouchListener(this);
        t4.setOnTouchListener(this);


        t5.setOnTouchListener(this);
        t6.setOnTouchListener(this);
        t7.setOnTouchListener(this);
        t8.setOnTouchListener(this);
        t9.setOnTouchListener(this);

        tsnv4.setOnTouchListener(this);
        tsnv8.setOnTouchListener(this);
        tsnv3.setOnTouchListener(this);

        aleatorio = new Random();
        num = aleatorio.nextInt(3) + 1;

        numaleat = ""+num;


        if (numaleat.equals("1")) {

            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);

            t5.setVisibility(View.INVISIBLE);
            t6.setVisibility(View.INVISIBLE);
            t7.setVisibility(View.INVISIBLE);
            t8.setVisibility(View.INVISIBLE);
            t9.setVisibility(View.INVISIBLE);

            tsnv4.setVisibility(View.INVISIBLE);
            tsnv8.setVisibility(View.INVISIBLE);
            tsnv3.setVisibility(View.INVISIBLE);

        }else if(numaleat.equals("2")){

            t5.setVisibility(View.VISIBLE);
            t8.setVisibility(View.VISIBLE);
            t9.setVisibility(View.VISIBLE);

            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
            t6.setVisibility(View.INVISIBLE);
            t7.setVisibility(View.INVISIBLE);

            tsnv4.setVisibility(View.INVISIBLE);
            tsnv8.setVisibility(View.INVISIBLE);
            tsnv3.setVisibility(View.INVISIBLE);

        }else if(numaleat.equals("3")){

            t6.setVisibility(View.VISIBLE);
            t7.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);

            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            t5.setVisibility(View.INVISIBLE);
            t8.setVisibility(View.INVISIBLE);
            t9.setVisibility(View.INVISIBLE);

            tsnv4.setVisibility(View.INVISIBLE);
            tsnv8.setVisibility(View.INVISIBLE);
            tsnv3.setVisibility(View.INVISIBLE);
        }

        //  p2_2.setOnTouchListener(this);
        // imageView.setOnLongClickListener(this);
        //   button.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.rel).setOnDragListener(this);


        seleccionaservivo.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    try {
                        correctoseresvivos.reset();
                        incorrectoservivo.reset();
                        seleccionaservivo.reset();
                        correctoseresnovivos.reset();
                        incorrectosernovivo.reset();
                        seleccionasernovivo.reset();

                        correctoseresvivos.prepare();
                        incorrectoservivo.prepare();
                        seleccionaservivo.prepare();
                        correctoseresnovivos.prepare();
                        incorrectosernovivo.prepare();
                        seleccionasernovivo.prepare();

                        correctoseresvivos.stop();
                        incorrectoservivo.stop();
                        seleccionaservivo.stop();
                        correctoseresnovivos.stop();
                        incorrectosernovivo.stop();
                        seleccionasernovivo.stop();

                        correctoseresvivos.release();
                        incorrectoservivo.release();
                        seleccionaservivo.release();
                        correctoseresnovivos.release();
                        incorrectosernovivo.release();
                        seleccionasernovivo.release();

                        correctoseresvivos=null;
                        incorrectoservivo=null;
                        seleccionaservivo=null;
                        correctoseresnovivos=null;
                        incorrectosernovivo=null;
                        seleccionasernovivo=null;
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

                if(correctoseresvivos.isPlaying()){
                    correctoseresvivos.stop();

                }else if(incorrectoservivo.isPlaying()){
                    incorrectoservivo.stop();

                }

                seleccionaservivo.start();
            }
        });

        btnSonidoSNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(correctoseresnovivos.isPlaying()){
                    correctoseresnovivos.stop();

                }else if(incorrectosernovivo.isPlaying()){
                    incorrectosernovivo.stop();

                }

                seleccionasernovivo.start();
            }
        });

        btnSonidoSNV.setVisibility(View.INVISIBLE);

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

                //Toast.makeText(this, "este es:"+numaleat + dragData, Toast.LENGTH_SHORT).show();
                // Toast.makeText(this, " "+dragData, Toast.LENGTH_SHORT).show();
                // Log.e("mostrar:", dragData);
                if(dragData.equals("piezacorrecta1") && numaleat.equals("1")){


                    t3.setVisibility(View.INVISIBLE);


                    String c;
                    c = ""+cont;

                    if(c.equals("1")){
                        bnd++;

                        t4.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.sv2);

                        if(incorrectoservivo.isPlaying()){
                            incorrectoservivo.stop();
                            incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);

                        }else if(seleccionaservivo.isPlaying()){
                            seleccionaservivo.stop();
                            seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                        }

                        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
                        correctoseresvivos.start();
                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.sv2loro);
                    }

                }
                else if(dragData.equals("piezacorrecta2") && numaleat.equals("1")){


                    t2.setVisibility(View.INVISIBLE);

                    String c;
                    c = ""+cont;

                    if(c.equals("1")){
                        bnd++;

                        t4.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.sv2);

                        if(incorrectoservivo.isPlaying()){
                            incorrectoservivo.stop();
                            incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);

                        }else if(seleccionaservivo.isPlaying()){
                            seleccionaservivo.stop();
                            seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                        }

                        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
                        correctoseresvivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.sv2arbol);
                    }



                }
                else if(dragData.equals("piezaincorrecta") && numaleat.equals("1")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectoservivo.isPlaying()){
                        incorrectoservivo.stop();
                        incorrectoservivo= MediaPlayer.create(this, R.raw.incorrec1selsv);

                    }else if(seleccionaservivo.isPlaying()){
                        seleccionaservivo.stop();
                        seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                    }

                    incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);
                    incorrectoservivo.start();
                }

                if(dragData.equals("piezacorrecta1") && numaleat.equals("2")){


                    t5.setVisibility(View.INVISIBLE);


                    String c;
                    c = ""+cont;

                    if(c.equals("1")){
                        bnd++;

                        t8.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.sv3);

                        if(incorrectoservivo.isPlaying()){
                            incorrectoservivo.stop();
                            incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);

                        }else if(seleccionaservivo.isPlaying()){
                            seleccionaservivo.stop();
                            seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                        }

                        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
                        correctoseresvivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.sv3arbol);
                    }

                }
                else if(dragData.equals("piezacorrecta2") && numaleat.equals("2")){


                    t9.setVisibility(View.INVISIBLE);

                    String c;
                    c = ""+cont;

                    if(c.equals("1")){

                        bnd++;

                        t8.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.sv3);

                        if(incorrectoservivo.isPlaying()){
                            incorrectoservivo.stop();
                            incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);

                        }else if(seleccionaservivo.isPlaying()){
                            seleccionaservivo.stop();
                            seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                        }

                        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
                        correctoseresvivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.sv3iguana);
                    }



                }

                else if(dragData.equals("piezaincorrecta") && numaleat.equals("2")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();
                    if(incorrectoservivo.isPlaying()){
                        incorrectoservivo.stop();
                        incorrectoservivo= MediaPlayer.create(this, R.raw.incorrec1selsv);

                    }else if(seleccionaservivo.isPlaying()){
                        seleccionaservivo.stop();
                        seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                    }

                    incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);
                    incorrectoservivo.start();
                }


                if(dragData.equals("piezacorrecta1") && numaleat.equals("3")){


                    t6.setVisibility(View.INVISIBLE);


                    String c;
                    c = ""+cont;

                    if(c.equals("1")){
                        bnd++;

                        t4.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.sv1);

                        if(incorrectoservivo.isPlaying()){
                            incorrectoservivo.stop();
                            incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);

                        }else if(seleccionaservivo.isPlaying()){
                            seleccionaservivo.stop();
                            seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                        }

                        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
                        correctoseresvivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.sv1arbol);
                    }

                }
                else if(dragData.equals("piezacorrecta2") && numaleat.equals("3")){


                    t7.setVisibility(View.INVISIBLE);

                    String c;
                    c = ""+cont;

                    if(c.equals("1")){

                        bnd++;

                        t4.setEnabled(false);
                        btnSonido.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.sv1);


                        if(incorrectoservivo.isPlaying()){
                            incorrectoservivo.stop();
                            incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);

                        }else if(seleccionaservivo.isPlaying()){
                            seleccionaservivo.stop();
                            seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                        }

                        correctoseresvivos = MediaPlayer.create(this, R.raw.correcto1selsv);
                        correctoseresvivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.sv1venado);
                    }



                }
                else if(dragData.equals("piezaincorrecta") && numaleat.equals("3")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();
                    if(incorrectoservivo.isPlaying()){
                        incorrectoservivo.stop();
                        incorrectoservivo= MediaPlayer.create(this, R.raw.incorrec1selsv);

                    }else if(seleccionaservivo.isPlaying()){
                        seleccionaservivo.stop();
                        seleccionaservivo = MediaPlayer.create(this, R.raw.actseleccionsv);
                    }

                    incorrectoservivo = MediaPlayer.create(this, R.raw.incorrec1selsv);
                    incorrectoservivo.start();
                }

                if(dragData.equals("piezacorrectasnv1")){


                    tsnv4.setVisibility(View.INVISIBLE);


                    String c;
                    c = ""+cont;

                    if(c.equals("1")){
                        bnd++;

                        tsnv3.setEnabled(false);
                        btnSonidoSNV.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.nsv);

                        if(incorrectosernovivo.isPlaying()){
                            incorrectosernovivo.stop();
                            incorrectosernovivo = MediaPlayer.create(this, R.raw.incorrec1selsnv);

                        }else if(seleccionasernovivo.isPlaying()){
                            seleccionasernovivo.stop();
                            seleccionasernovivo = MediaPlayer.create(this, R.raw.actseleccionsnv);
                        }

                        correctoseresnovivos = MediaPlayer.create(this, R.raw.correcto1selsnv);
                        correctoseresnovivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.nrocas);
                    }

                }
                else if(dragData.equals("piezacorrectasnv2")){


                    tsnv8.setVisibility(View.INVISIBLE);

                    String c;
                    c = ""+cont;

                    if(c.equals("1")){
                        bnd++;

                        tsnv3.setEnabled(false);
                        btnSonidoSNV.setVisibility(View.INVISIBLE);

                        t1sombra.setImageResource(R.mipmap.nsv);

                        if(incorrectosernovivo.isPlaying()){
                            incorrectosernovivo.stop();
                            incorrectosernovivo = MediaPlayer.create(this, R.raw.incorrec1selsnv);

                        }else if(seleccionasernovivo.isPlaying()){
                            seleccionasernovivo.stop();
                            seleccionasernovivo = MediaPlayer.create(this, R.raw.actseleccionsnv);
                        }

                        correctoseresnovivos = MediaPlayer.create(this, R.raw.correcto1selsnv);
                        correctoseresnovivos.start();

                        Handler h = new Handler();
                        h.postDelayed(r, 5000);
                    }else{
                        cont++;
                        t1sombra.setImageResource(R.mipmap.nmontanas);
                    }



                }
                else if(dragData.equals("piezaincorrectasnv")){
                    //Toast.makeText(this, "Incorrecto ", Toast.LENGTH_SHORT).show();

                    if(incorrectosernovivo.isPlaying()){
                        incorrectosernovivo.stop();
                        incorrectosernovivo= MediaPlayer.create(this, R.raw.incorrec1selsnv);

                    }else if(seleccionasernovivo.isPlaying()){
                        seleccionasernovivo.stop();
                        seleccionasernovivo = MediaPlayer.create(this, R.raw.actseleccionsnv);
                    }

                    incorrectosernovivo = MediaPlayer.create(this, R.raw.incorrec1selsnv);
                    incorrectosernovivo.start();
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


            String bandera;
            bandera = ""+bnd;

            cont=0;

            if (bandera.equals("1")) {

                seleccionasernovivo.start();

                t4.setEnabled(true);
                t8.setEnabled(true);

                btnSonido.setVisibility(View.INVISIBLE);
                btnSonidoSNV.setVisibility(View.VISIBLE);

                t1sombra.setImageResource(R.mipmap.cuadro);

                tsnv4.setVisibility(View.VISIBLE);
                tsnv8.setVisibility(View.VISIBLE);
                tsnv3.setVisibility(View.VISIBLE);

                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                t5.setVisibility(View.INVISIBLE);
                t6.setVisibility(View.INVISIBLE);
                t7.setVisibility(View.INVISIBLE);
                t8.setVisibility(View.INVISIBLE);
                t9.setVisibility(View.INVISIBLE);
            }

            if (bandera.equals("2")) {

                bnd=0;
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
