package com.itvo.examenunidad2_dmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
/**
 * Asignatura: Dispositivos Moviles 2
 * Docente: I.S.C. Kevin David Molina Gomez
 * Archivo: PerfilActivity.kt - Actividad que registra a los usuarios.
 * TODO: NOMBRE DEL ALUMNO: "Larry Giovanni Pérez Gerónimo"
 */
class PerfilActivity : AppCompatActivity() {

    /**
     * Se declaran las view (Vistas), se declaran en esta parte por que se podran usar desde cualquier metodo, sin tener que declararlas de nuevo
     * El lateint sirve para que no tengamos que inicializar las vistas aqui, si no hasta cuando queramos, que seria en el metodo inicializarVistas.
     * */
    private lateinit var txvNombre:TextView
    private lateinit var txvApellido :TextView
    private lateinit var txvCorreo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        inicializarVistas()
        obtenerDatosdelIntent()
    }

    /**
     * Metodo que inicializa las view (Vistas), que se declararon en el activity_inicio_sesion.xml
     * */
    private fun inicializarVistas() {
        txvNombre = findViewById(R.id.txv_nombre)
        txvApellido = findViewById(R.id.txv_apellido)
        txvCorreo =findViewById(R.id.txv_correo)
    }

    /**
     * Metodo que obtiene los datos del intent que viene de RegistroActivity.
     * */
    private fun obtenerDatosdelIntent(){

        //TODO: CODIGO DONDE CONSEGUIMOS EL NOMBRE, APELLIDO Y CORREO DE LOS DATOS DEL INTENT que viene de RegistroActivity Y LOS ESTABLECEMOS EN LAS VISTAS CORRESPONDIENTES.

        val n = findViewById<TextView>(R.id.txv_nombre)
        val a = findViewById<TextView>(R.id.txv_apellido)
        val cro = findViewById<TextView>(R.id.txv_correo)

        var Nombre = intent.getStringExtra("nombre")
        var Apellido = intent.getStringExtra("apellido")
        var Correo = intent.getStringExtra("correo")

        n.text = Nombre.toString()
        a.text = Apellido.toString()
        cro.text= Correo.toString()



    }
}