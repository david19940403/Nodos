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
                          arbol= sethijos(arbol,n);
                       }
                salida.setText(arbol.toString(1));
                /***********************/
            }
        });
    }

    boolean establecido=false;
    Nodo sethijos(Nodo nodo,int valor){
       establecido=false;
        while (establecido!=true){
            if(nodo==null){
                nodo=setnodo(valor);
                establecido=true;
            }else {
                if (nodo.hijos[0] == null) {
                    nodo.hijos[0] = sethijos(nodo.hijos[0], valor);
                    establecido = true;
                } else if (nodo.hijos[1] == null) {
                    nodo.hijos[1] = sethijos(nodo.hijos[1], valor);
                    establecido = true;
                }else{
                    if(isnull(nodo.hijos[0])!=-1){
                        nodo.hijos[0].hijos[isnull(nodo.hijos[0])]=sethijos(nodo.hijos[0],valor);
                        establecido=true;
                    }else  if(isnull(nodo.hijos[1])!=-1){
                        nodo.hijos[1].hijos[isnull(nodo.hijos[1])]=sethijos(nodo.hijos[1],valor);
                        establecido=true;
                    }
                }
            }
        }
        return nodo;
    }

int isnull(Nodo n){
        if(n.hijos[0]==null){
            return  0;
        }else if(n.hijos[1]==null){
            return 1;
        }else{
            return -1;
        }
}

    Nodo setnodo(int valor){
        Nodo nodo=new Nodo(valor,new Nodo[2]);
        return nodo;
    }

}
