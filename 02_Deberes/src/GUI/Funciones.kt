package GUI

import java.awt.Dimension
import Controlador.MetodosMaquillaje
import java.awt.GridLayout
import java.util.*
import javax.swing.*
import javax.swing.table.DefaultTableModel
import java.awt.BorderLayout
import javax.swing.JScrollPane


fun menu (){
    var num: Int
    var estado:Int = 0
    val seleccion = JOptionPane.showInputDialog("\nBienvenidos a su Catálogo Maquillaje" +"\n" +
            "\n Seleccione:" +"\n" +
            "\n     1. Ingresar al Cátalogo" +"\n" +
            "     2. Ingresar al Modulo de Compras" +"\n" +
            "     0. Salir"+
            "\n")
    if (seleccion.toString().equals("1")) {
        llamarVentanaInicial();
        estado=0
    } else if(seleccion.toString().equals("2")){
        llamarVentanaCompras();
    }else if((seleccion.toString().equals("Cancelar"))||(seleccion.toString().equals("0"))){
        JOptionPane.showMessageDialog(null,"Programa Finalizado")
    }
}


fun llamarVentanaInicial() {
    //static GraphicsConfiguration gc;
    val experimentLayout = GridLayout(5, 5)

    val ventana = JFrame("Catálogo Maquillaje")

    //PONERLE UN LAYOUT
    ventana.getContentPane().setLayout(experimentLayout);

    var botonInsertar = JButton("AÑADIR AL CATÁLOGO");
    var botonVisualizar= JButton("MOSTRAR CATÁLOGO");
    var botonBorrar = JButton("ELIMINAR ARTICULO");
    var botonActualizar = JButton("MODIFICAR CATÁLOGO");
    var botonVolver = JButton("VOLVER MENU PRINCIPAL");

    ventana.getContentPane().add(botonInsertar);
    ventana.getContentPane().add(botonVisualizar);
    ventana.getContentPane().add(botonActualizar);
    ventana.getContentPane().add(botonBorrar);

    ventana.getContentPane().add(botonVolver, BorderLayout.CENTER);


    botonInsertar.addActionListener {
        ventanaInsert();
        ventana.dispose();
    }

    botonVisualizar.addActionListener {
        ventanaConsultar();
        ventana.dispose();
    }

    botonBorrar.addActionListener {
        ventanaDelete();
        ventana.dispose();
    }

    botonActualizar.addActionListener {
        ventanaUpdate();
        ventana.dispose();
    }
    botonVolver.addActionListener {
        menu();
        ventana.dispose();
    }
    //poner caracteristicas
    ventana.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventana.preferredSize = Dimension(300, 200)
    ventana.isResizable = false
    ventana.pack()
    ventana.setLocationRelativeTo(null)
    ventana.isVisible = true
}


fun ventanaInsert() {
    val experimentLayout = GridLayout(7, 7)
    val ventanainsert = JFrame("Inserción de maquillaje");

    ventanainsert.getContentPane().setLayout(experimentLayout);

    var label1 = JLabel("Producto:", 10)
    var textProducto = JTextField("", 10)

    var label2 = JLabel("Color:", 10)
    var textColor = JTextField("", 10)

    var label3 = JLabel("Marca:", 10)
    var textMarca = JTextField("", 10)

    var label4 = JLabel("Precio:", 10)
    var textPrecio = JTextField("", 10)

    var label5 = JLabel("Existencias:", 10)
    var textExistencias = JTextField("", 10)

    var boton = JButton("INSERTAR");
    var botonregresar = JButton("VOLVER");


    ventanainsert.getContentPane().add(label1);
    ventanainsert.getContentPane().add(textProducto);
    ventanainsert.getContentPane().add(label2);
    ventanainsert.getContentPane().add(textColor);
    ventanainsert.getContentPane().add(label3);
    ventanainsert.getContentPane().add(textMarca);
    ventanainsert.getContentPane().add(label4);
    ventanainsert.getContentPane().add(textPrecio);
    ventanainsert.getContentPane().add(label5);
    ventanainsert.getContentPane().add(textExistencias);
    ventanainsert.getContentPane().add(botonregresar);
    ventanainsert.getContentPane().add(boton);

    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanainsert.preferredSize = Dimension(500, 300)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true

    boton.addActionListener {
        var producto = textProducto.getText();
        var color = textColor.getText();
        var marca = textMarca.getText();
        var precio = textPrecio.getText();
        var existencias: Int=0;
        try {
            existencias=textExistencias.getText().toString().toInt()
            insertarTupla(producto, color, marca, precio,existencias);
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se realizó la inserción")
        };

    }

    botonregresar.addActionListener {
        llamarVentanaInicial();
        ventanainsert.dispose();
    }


}

fun insertarTupla(producto: String, color: String, marca: String, precio: String, existencias:Int) {

    var id = MetodosMaquillaje.crearIndex();
    MetodosMaquillaje.insertar(id,producto,color,marca,precio,existencias);

}


fun llenarTabla(): DefaultTableModel {
    var datos = selectDatos();
    var dtm = DefaultTableModel();
    if(!datos.isEmpty()){


        //Agrego columnas a la tabla
        dtm.addColumn("ID");
        dtm.addColumn("Producto");
        dtm.addColumn("Color");
        dtm.addColumn("Marca");
        dtm.addColumn("Precio");
        dtm.addColumn("Existencias");

        if (!datos.isEmpty()) {
            datos.forEach {
                var lista = it.split(',');
                var vector = Vector<String>();
                lista.forEach {

                    vector.add(it);

                }
                dtm.addRow(vector);
            }
        }
    }


    return dtm;
}

fun ventanaConsultar() {

    var panelTabla = JPanel();
    var panelBoton = JPanel();

    val ventanaconsultar = JFrame("CONSULTAR CATALOGO");

    ventanaconsultar.getContentPane().add(panelTabla, BorderLayout.CENTER);
    ventanaconsultar.getContentPane().add(panelBoton, BorderLayout.SOUTH);


    //Instancio la tabla
    var tabla = JTable(llenarTabla())

    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);


    var botonVolver = JButton("VOLVER");
    panelBoton.add(botonVolver);


    ventanaconsultar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanaconsultar.pack()
    ventanaconsultar.setLocationRelativeTo(null)
    ventanaconsultar.isVisible = true

    botonVolver.addActionListener {
        llamarVentanaInicial();
        ventanaconsultar.dispose();
    }
}


fun selectDatos(): List<String> {
    var retorno = MetodosMaquillaje.leer();
    return retorno;
}


fun ventanaDelete() {
    var panelTabla = JPanel();
    var panelBoton = JPanel();

    val ventanaeliminar = JFrame("ELIMINAR ELEMENTO");

    ventanaeliminar.getContentPane().add(panelTabla, BorderLayout.CENTER);
    ventanaeliminar.getContentPane().add(panelBoton, BorderLayout.SOUTH);

    //Instancio la tabla
    var dtm=llenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);


    var botonVolver = JButton("VOLVER");
    var botonEliminar = JButton("ELIMINAR ELEMENTO.");
    panelBoton.add(botonVolver);
    panelBoton.add(botonEliminar);


    ventanaeliminar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanaeliminar.pack()
    ventanaeliminar.setLocationRelativeTo(null)
    ventanaeliminar.isVisible = true


    botonVolver.addActionListener {
        llamarVentanaInicial();
        ventanaeliminar.dispose();
    }


    botonEliminar.addActionListener {
        //println(tabla.rowCount)
        if (tabla.rowCount > 0) {
            var i = tabla.getSelectedRow();
            if (i != -1) {
                var index = dtm.getValueAt(i, 0).toString().toInt();
                println(index)
                eliminarTupla(index);
            } else {
                JOptionPane.showMessageDialog(null, "ESCOJA REGISTRO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTE EL REGISTRO!");
        }


    }
}


fun eliminarTupla(i: Number) {
    MetodosMaquillaje.eliminar(i);
}

fun ventanaUpdate() {
    var panelTabla = JPanel();
    var panelBoton = JPanel();
    var panelCampos = JPanel();

    val ventanaactualizar = JFrame("ACTUALIZAR ELEMENTO");

    ventanaactualizar.getContentPane().add(panelTabla, BorderLayout.NORTH);

    ventanaactualizar.getContentPane().add(panelBoton, BorderLayout.CENTER);
    ventanaactualizar.getContentPane().add(panelCampos, BorderLayout.SOUTH);

    //Instacia de la tabla
    var dtm=llenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);

    var botonEscojer = JButton("Editar");
    panelBoton.add(botonEscojer);


    var label1 = JLabel("Producto:", 10)

    var textProducto = JTextField("", 10)

    var label2 = JLabel("Color:", 10)
    var textColor = JTextField("", 10)

    var label3 = JLabel("Marca:", 10)
    var textMarca = JTextField("", 10)

    var label4 = JLabel("Precio:", 10)
    var textPrecio = JTextField("", 10)

    var label5 = JLabel("Existencias:", 10)
    var textExistencias = JTextField("", 10)

    var boton = JButton("ACTUALIZAR");
    var botonregresar = JButton("VOLVER");


    val experimentLayout = GridLayout(7, 7)
    panelCampos.setLayout(experimentLayout);

    panelCampos.add(label1);
    panelCampos.add(textProducto);
    panelCampos.add(label2);
    panelCampos.add(textColor);
    panelCampos.add(label3);
    panelCampos.add(textMarca);
    panelCampos.add(label4);
    panelCampos.add(textPrecio);
    panelCampos.add(label5);
    panelCampos.add(textExistencias);
    panelCampos.add(botonregresar);
    panelCampos.add(boton);



    ventanaactualizar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanaactualizar.pack()
    ventanaactualizar.setLocationRelativeTo(null)
    ventanaactualizar.isVisible = true

    botonregresar.addActionListener {
        llamarVentanaInicial();
        ventanaactualizar.dispose();
    }

    var id = -1;
    botonEscojer.addActionListener {
        var i = tabla.getSelectedRow();
        if(i!=-1){
            id = dtm.getValueAt(i, 0).toString().toInt();
            var productoaux = dtm.getValueAt(i, 1);
            var coloraux = dtm.getValueAt(i, 2);
            var marcaaux = dtm.getValueAt(i, 3);
            var precioaux = dtm.getValueAt(i, 4);
            var existenciasaux = dtm.getValueAt(i, 5);

            textProducto.text = productoaux.toString();
            textColor.text = coloraux.toString();
            textMarca.text = marcaaux.toString();
            textPrecio.text = precioaux.toString();
            textExistencias.text = existenciasaux.toString();
        }else{
            JOptionPane.showMessageDialog(null,"ESCOJA REGISTRO");
        }

    }

    boton.addActionListener {

        if (id != -1 && !textProducto.getText().isEmpty() && !textColor.getText().isEmpty() &&
            !textMarca.getText().isEmpty() && !textPrecio.getText().isEmpty() && !textExistencias.getText().isEmpty()
        ) {
            actualizarTupla(
                id,
                textProducto.getText(),
                textColor.getText(),
                textMarca.getText(),
                textPrecio.getText(),
                textExistencias.getText().toInt()
            );

        }


    }

}

fun actualizarTupla(id: Number, producto: String, color: String, marca: String, precio: String, existencias: Int) {

    MetodosMaquillaje.actualizar(id,producto,color,marca,precio,existencias);
}
