package com.itvo.examenunidad2_dmoviles

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Asignatura: Dispositivos Moviles 2
 * Docente: I.S.C. Kevin David Molina Gomez
 * Archivo: RegistroActivity.kt - Actividad que registra a los usuarios.
 * TODO: NOMBRE DEL ALUMNO: "Pérez Gerónimo Larry giovanni"
 */


class InicioSesionActivity : AppCompatActivity() {

    /**
     * Se declaran las view (Vistas), se declaran en esta parte por que se podran usar desde cualquier metodo, sin tener que declararlas de nuevo
     * El lateint sirve para que no tengamos que inicializar las vistas aqui, si no hasta cuando queramos, que seria en el metodo inicializarVistas.
     * */
    private lateinit var etCorreo: EditText
    private lateinit var etContrasena: EditText
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnRegistrarse: Button
    private val minimaLongitud = 6

    /**
     *  Metodo principal de la actividad en android, aqui se mandan a llamar los demas metodos para separar el codigo.
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        // Se manda a llamar  al metodo inicializarVistas que inicializara todos los EditText, TextView y Buttons que halla dentro del layout.
        inicializarVistas()

        iniciarSesion()
        abrirRegistroActivity()
    }

    /**
     * Metodo que inicializa las view (Vistas), que se declararon en el activity_inicio_sesion.xml
     * */
    private fun inicializarVistas() {
        // Se inicializan los EditText de correo y contrasena de la vista activity_inicio_sesion.xml
        etCorreo = findViewById(R.id.et_correo)
        etContrasena = findViewById(R.id.et_contrasena)
        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion)
        btnRegistrarse = findViewById(R.id.btn_registarse)

        // Se activa el soporte para la barra con el boton regresar para navegar entre las actividades.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    /**
     * Metodo que valida si la informacion que ingresamos es valida.
     * */
    private fun validadDatos(): Boolean {

        // Condiciones que validan que los campos de los EditText no esten vacios.
        if (etCorreo.text.toString() == "") {
            etCorreo.error = "Por Favor Ingresa un Correo"
            return false
        }
        if (etContrasena.text.toString() == "") {
            etContrasena.error = "Por favor Ingresa una Contraseña"
            return false
        }

        // checking the proper email format
        if (!validarCorreo(etCorreo.text.toString())) {
            etCorreo.error = "Por favor Ingresa un Correo Valido"
            return false
        }

        // checking minimum password Length
        if (etContrasena.text.length < minimaLongitud) {
            etContrasena.error = "La contraseña debe ser mayor a $minimaLongitud digitos"
            return false
        }
        return true
    }

    /**
     * Metodo que valida que el correo contenga el simbolo @ y tenga la estructura de un correo.
     * */
    private fun validarCorreo(email: String?): Boolean {
        // Manda a llamar un metodo especial del SDK de Android que verifica el correo.
        return Patterns.EMAIL_ADDRESS.matcher(email!!).matches()
    }

    /**
     * Metodo que se activa cuando presionamos al boton Iniciar Sesion
     * */
    fun iniciarSesion() {
        btnIniciarSesion.setOnClickListener {
            // Condicion que si se cumple, los datos ingresados fueron validos, dentro escribiran su codigo.
            if (validadDatos()) {

                //TODO: ESCRIBIR CODIGO PARA OBTENER EL CORREO Y LA CONTRASEÑA DE LOS EDITTEXT Y MOSTRAR UN Toast diciendo que se Inicio sesion correctamente, mostrando el correo.

                val correo: TextView = findViewById(R.id.et_correo)
                val login: Button = findViewById(R.id.btn_iniciar_sesion)
                login.setOnClickListener(View.OnClickListener {
                    Toast.makeText(this, "INICIO DE SESION CON CORREO:  "+ correo.text,
                        Toast.LENGTH_LONG).show()
                })

            }
        }
    }

    /**
     * Metodo que se activa cuando presionamos que no tenemos una cuenta y queremos Registrarnos, esta nos mandara a la
     * Acitivity RegistroActivity.
     * */
    fun abrirRegistroActivity() {

        btnRegistrarse.setOnClickListener {

            //TODO: ESCRIBIR CODIGO PARA IR A LA ACTIVITY RegistroActivity, con el uso de Intents.

            btnRegistrarse.setOnClickListener {
                val intent = Intent(this, RegistroActivity::class.java )
                startActivity(intent)
            }
        }

    }
}