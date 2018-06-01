package test.com.nodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText entrada;
TextView salida;
TextView boton;
int[] numeros;
Nodo arbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada=(EditText) findViewById(R.id.entrada);
        salida=(TextView)findViewById(R.id.salida);
        boton=(Button)findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*******************************************************/
                String[] valores=entrada.getText().toString().split(",");
                numeros=new int[valores.length];

                arbol=null;
                int x=0;
                salida.setText("");
                if(valores.length!=0){
                    for (String valor:valores) {
                        try{
                            numeros[x]=Integer.valueOf(valor);
                           // salida.setText(salida.getText()+"\n"+valor);
                        }catch (Exception ex){
                        }
                        x++;
                    }
                }
                /**
                /*********************************************************/

                for (int n:numeros
                     ) {

                    if(arbol==null) {
                      arbol=setnodo( n);
                    }else{
                          arbol.hijos= sethijos(arbol.hijos,setnodo(n));
                    }
                }
                salida.setText(arbol.toString(1));
                /***********************/
            }
        });
    }

    boolean establecido=false;
    Nodo[] sethijos(Nodo[] nodo,Nodo hijo){
       establecido=false;
        while (establecido!=true){
            if(nodo==null){
                nodo=new Nodo[2];
            }else{
                if(nodo[0]==null){
                    nodo[0]= hijo;
                    establecido=true;
                }else if(nodo[1]==null){
                    nodo[1]= hijo;
                    establecido=true;
                }else{
                    if(nodo[0]==null) {
                        nodo[0].hijos = sethijos(nodo[0].hijos, hijo);
                        establecido = true;
                    } else
                    if(nodo[1]==null) {
                        nodo[1].hijos = sethijos(nodo[1].hijos, hijo);
                        establecido = true;
                    }else{
                        for (Nodo item:nodo
                             ) {
                            item.hijos=sethijos(item.hijos,hijo);
                        }
                    }
                }
            }
        }
        return nodo;
    }

   boolean hijosnull(Nodo[] nodo){
        if((nodo[0]==null)||(nodo[1]==null)){
            return true;
        }else{
            return false;
        }
   }
    Nodo setnodo(int valor){
        Nodo nodo=new Nodo(valor,new Nodo[2]);
        return nodo;
    }

}
