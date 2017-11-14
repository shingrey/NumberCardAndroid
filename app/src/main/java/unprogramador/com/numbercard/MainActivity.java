package unprogramador.com.numbercard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText tarjeta;
    Button comprobar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tarjeta = (EditText)findViewById(R.id.tarjeta);
        resultado = (TextView) findViewById(R.id.resultado);
        comprobar = (Button)findViewById(R.id.comprobar);
        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tarjeta.getText().length() > 11){
                    CharSequence numero = tarjeta.getText();
                    Pattern visa, master, american, diners, discover, jcb;
                    visa = Pattern.compile("^4[0-9]{6,}$");
                    master = Pattern.compile("^5[1-5][0-9]{5,}|222[1-9][0-9]{3,}|22[3-9][0-9]{4,}|2[3-6][0-9]{5,}|27[01][0-9]{4,}|2720[0-9]{3,}$");
                    american = Pattern.compile("^3[47][0-9]{5,}$");
                    diners = Pattern.compile("^3(?:0[0-5]|[68][0-9])[0-9]{4,}$");
                    discover = Pattern.compile("^6(?:011|5[0-9]{2})[0-9]{3,}$");
                    jcb = Pattern.compile("^(?:2131|1800|35[0-9]{3})[0-9]{3,}$");

                    if(visa.matcher(numero).matches()){
                        resultado.setText("Visa");
                        limpiar();
                    }else if(master.matcher(numero).matches()){
                        resultado.setText("Masterd");
                        limpiar();

                    }else if(american.matcher(numero).matches()){
                        resultado.setText("American express");
                        limpiar();

                    }
                    else if(diners.matcher(numero).matches()){
                        resultado.setText("Diners club");
                        limpiar();

                    }
                    else if(discover.matcher(numero).matches()){
                        resultado.setText("Discover");
                        limpiar();

                    }
                    else if(jcb.matcher(numero).matches()){
                        resultado.setText("JCB");
                        limpiar();

                    }
                    else{
                        resultado.setText("Otras");
                        limpiar();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Debe tener mas de 12 caracteres",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void limpiar(){
        tarjeta.setText("");
        tarjeta.requestFocus();
    }
}
