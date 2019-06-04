package com.dalealdado.choised.view.Aventura;

        import android.app.Activity;
        import android.content.ClipData;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.DragEvent;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.LinearLayout;

        import com.dalealdado.dalealdado.R;

public class Huerto extends Activity {

    ImageButton mIzquierda;
    Intent intent1;
    LinearLayout linear1 , linear2, linear3,linear4, hueco2,hueco3,hueco4,hueco5,hueco6;
    ImageView planta1, planta2, planta3,planta4,planta5,planta6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huerto);

        planta1 = (ImageView) findViewById(R.id.planta1);
        planta2 = (ImageView) findViewById(R.id.planta2);
        planta3 = (ImageView) findViewById(R.id.planta3);
        planta4 = (ImageView) findViewById(R.id.planta4);
        planta5 = (ImageView) findViewById(R.id.planta5);
        planta6 = (ImageView) findViewById(R.id.planta6);

        linear1 = (LinearLayout) findViewById(R.id.semilla1);
        linear2 = (LinearLayout) findViewById(R.id.semilla2);
        linear3 = (LinearLayout) findViewById(R.id.semilla3);

        linear4 = (LinearLayout) findViewById(R.id.hueco1);
        hueco2 = (LinearLayout) findViewById(R.id.hueco2);
        hueco3 = (LinearLayout) findViewById(R.id.hueco3);
        hueco4 = (LinearLayout) findViewById(R.id.hueco4);
        hueco5 = (LinearLayout) findViewById(R.id.hueco5);
        hueco6 = (LinearLayout) findViewById(R.id.hueco6);



        linear1.setOnLongClickListener(longClickListener);
        linear2.setOnLongClickListener(longClickListener);
        linear3.setOnLongClickListener(longClickListener);

        linear4.setOnDragListener(dragListener);
        hueco2.setOnDragListener(dragListener);
        hueco3.setOnDragListener(dragListener);
        hueco4.setOnDragListener(dragListener);
        hueco5.setOnDragListener(dragListener);
        hueco6.setOnDragListener(dragListener);

        mIzquierda = findViewById(R.id.izquierda10);
        intent1 = new Intent(this, CasaSenyorHuerto.class);

        mIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
                mIzquierda.setEnabled(false);
            }
        });

    }
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.semilla1 && v.getId() == R.id.hueco1){
                        planta1.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla1 && v.getId() == R.id.hueco2){
                        planta2.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla1 && v.getId() == R.id.hueco3){
                        planta3.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla1 && v.getId() == R.id.hueco4){
                        planta4.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla1 && v.getId() == R.id.hueco5){
                        planta5.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla1 && v.getId() == R.id.hueco6){
                        planta6.setVisibility(View.VISIBLE);
                    }

                    if (view.getId() == R.id.semilla2 && v.getId() == R.id.hueco1){
                        planta1.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla2 && v.getId() == R.id.hueco2){
                        planta2.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla2 && v.getId() == R.id.hueco3){
                        planta3.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla2 && v.getId() == R.id.hueco4){
                        planta4.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla2 && v.getId() == R.id.hueco5){
                        planta5.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla2 && v.getId() == R.id.hueco6){
                        planta6.setVisibility(View.VISIBLE);
                    }

                    if (view.getId() == R.id.semilla3 && v.getId() == R.id.hueco1){
                        planta1.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla3 && v.getId() == R.id.hueco2){
                        planta2.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla3 && v.getId() == R.id.hueco3){
                        planta3.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla3 && v.getId() == R.id.hueco4){
                        planta4.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla3 && v.getId() == R.id.hueco5){
                        planta5.setVisibility(View.VISIBLE);
                    }
                    else if (view.getId() == R.id.semilla3 && v.getId() == R.id.hueco6){
                        planta6.setVisibility(View.VISIBLE);
                    }

                    break;
            }

            return true;
        }
    };
}
