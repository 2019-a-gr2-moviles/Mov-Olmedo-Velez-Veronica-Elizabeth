package GUI

import Controlador.MetodoCompras
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.util.*
import javax.swing.*
import javax.swing.table.DefaultTableModel


fun llamarVentanaCompras() {


    val experimentLayout = GridLayout(5,5)
    val ventana = JFrame("COMPRAS ONLINE")

    //PONERLE UN LAYOUT
    ventana.getContentPane().setLayout(experimentLayout);


    var botonInsertCompra = JButton("AÑADIR AL CARRITO");
    var botonVerCompra = JButton("ARTICULOS COMPRADOS");
    var botonEliminarCompra = JButton("ELIMINAR COMPRA");
    var botonModificarCompra = JButton("MODIFICAR COMPRA");
    var botonRegresarCompra = JButton("VOLVER AL MENU PRINCIPAL")

    ventana.getContentPane().add(botonInsertCompra);
    ventana.getContentPane().add(botonVerCompra);
    ventana.getContentPane().add(botonEliminarCompra);
    ventana.getContentPane().add(botonModificarCompra);
    ventana.getContentPane().add(botonRegresarCompra);

    botonInsertCompra.addActionListener {
        ventanaInsertCompra();
        ventana.dispose();
    }

    botonVerCompra.addActionListener {
        ventanaConsultarCompra();
        ventana.dispose();
    }

    botonEliminarCompra.addActionListener {
        ventanaDeleteCompra();
        ventana.dispose();
    }

    botonModificarCompra.addActionListener {
        ventanaUpdateCompra();
        ventana.dispose();
    }

    botonRegresarCompra.addActionListener {
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


fun ventanaInsertCompra() {

    var maquillaje = JPanel();
    //var maquillaje= ventanaConsultar();
    var panelBoton = JPanel();
    var panelCampos = JPanel();
    val ventanainsert = JFrame("AÑADIR AL CARRITO");

    ventanainsert.getContentPane().add(panelBoton, BorderLayout.CENTER);
    ventanainsert.getContentPane().add(panelCampos, BorderLayout.SOUTH);
    ventanainsert.getContentPane().add(maquillaje, BorderLayout.NORTH);

    //Instacia de la tabla
    var dtm=llenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    maquillaje.add(jsp);



    var label1 = JLabel("Producto:", 10)
    var textProducto = JTextField("", 10)

    var label2 = JLabel("Cantidad:", 10)
    var textCantidad = JTextField("", 10)

    var label3 = JLabel("Fecha Compra:", 10)
    var textFechaCompra = JTextField("", 10)

    var label4 = JLabel("Usuario:", 10)
    var textUsuario = JTextField("", 10)

    var label5 = JLabel("Cedula:", 10)
    var textCedula = JTextField("", 10)

    var label6 = JLabel("ValorTotal:", 10)
    var textValorTotal = JTextField("", 10)

    var boton = JButton("INSERTAR");
    var botonregresar = JButton("VOLVER");


    val experimentLayout = GridLayout(7, 7)
    panelCampos.setLayout(experimentLayout);

    panelCampos.add(label1);
    panelCampos.add(textProducto);
    panelCampos.add(label2);
    panelCampos.add(textCantidad);
    panelCampos.add(label3);
    panelCampos.add(textFechaCompra);
    panelCampos.add(label4);
    panelCampos.add(textUsuario);
    panelCampos.add(label5);
    panelCampos.add(textCedula);
    panelCampos.add(label6);
    panelCampos.add(textValorTotal);
    panelCampos.add(botonregresar);
    panelCampos.add(boton);

    /*ventanainsert.getContentPane().setLayout(experimentLayout);

    ventanainsert.getContentPane().add(label1);
    ventanainsert.getContentPane().add(textFechaCompra);
    ventanainsert.getContentPane().add(label2);
    ventanainsert.getContentPane().add(textUsuario);
    ventanainsert.getContentPane().add(label3);
    ventanainsert.getContentPane().add(textCedula);
    ventanainsert.getContentPane().add(label4);
    ventanainsert.getContentPane().add(textValorTotal);

    ventanainsert.getContentPane().add(botonregresar);
    ventanainsert.getContentPane().add(boton);*/

    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanainsert.preferredSize = Dimension(500, 670)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true

    boton.addActionListener {
        var producto = textProducto.getText();
        var cantidad = textCantidad.getText();
        var fechaCompra = textFechaCompra.getText();
        var usuario = textUsuario.getText();
        var cedula = textCedula.getText();
        var valorTotal: Double = 0.0

        try {
            valorTotal=textValorTotal.getText().toString().toDouble()
            insertarTuplaCompra(fechaCompra, cantidad,producto,usuario, cedula, valorTotal);
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "NO SE INSERTO EN LA TABLA")
        };

    }

    botonregresar.addActionListener {
        llamarVentanaCompras();
        ventanainsert.dispose();
    }


}

fun insertarTuplaCompra(producto:String,cantidad: String,fechaCompra: String, usuario: String, cedula: String,valorTotal: Double) {

    var idCompra = MetodoCompras.crearIndice();
    MetodoCompras.insertarCompra(idCompra,producto,cantidad,fechaCompra,usuario,cedula,valorTotal);

}


fun rellenarTabla(): DefaultTableModel {
    var datos = Datos();
    var dtm = DefaultTableModel();
    if(!datos.isEmpty()){


        //Agrego columnas a la tabla
        dtm.addColumn("ID");
        dtm.addColumn("Producto");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Fecha Compra");
        dtm.addColumn("Usuario");
        dtm.addColumn("Cedula");
        dtm.addColumn("Valor Total");


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

fun ventanaConsultarCompra() {

    var panelTabla = JPanel();
    var panelBoton = JPanel();

    val ventanaconsultar = JFrame("CONSULTAR CATALOGO");

    ventanaconsultar.getContentPane().add(panelTabla, BorderLayout.CENTER);
    ventanaconsultar.getContentPane().add(panelBoton, BorderLayout.SOUTH);


    //Instan de la tabla
    var tabla = JTable(rellenarTabla())

    tabla.dragEnabled = false;

    //Scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);


    var botonVolver = JButton("VOLVER");
    panelBoton.add(botonVolver);


    ventanaconsultar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanaconsultar.pack()
    ventanaconsultar.setLocationRelativeTo(null)
    ventanaconsultar.isVisible = true

    botonVolver.addActionListener {
        llamarVentanaCompras();
        ventanaconsultar.dispose();
    }
}


fun Datos(): List<String> {
    var retorna = MetodoCompras.leer();
    return retorna;
}


fun ventanaDeleteCompra() {
    var panelTabla = JPanel();
    var panelBoton = JPanel();

    val ventanaeliminar = JFrame("ELIMINAR ELEMENTO");

    ventanaeliminar.getContentPane().add(panelTabla, BorderLayout.CENTER);
    ventanaeliminar.getContentPane().add(panelBoton, BorderLayout.SOUTH);

    //Instancio la tabla
    var dtm=rellenarTabla();
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
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanaeliminar.pack()
    ventanaeliminar.setLocationRelativeTo(null)
    ventanaeliminar.isVisible = true


    botonVolver.addActionListener {
        llamarVentanaCompras();
        ventanaeliminar.dispose();
    }


    botonEliminar.addActionListener {
        //println(tabla.rowCount)
        if (tabla.rowCount > 0) {
            var i = tabla.getSelectedRow();
            if (i != -1) {
                var indice = dtm.getValueAt(i, 0).toString().toInt();
                println(indice)
                eliminarTuplaCompra(indice);
            } else {
                JOptionPane.showMessageDialog(null, "ESCOJER REGISTRO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTE EL REGISTRO!");
        }


    }
}


fun eliminarTuplaCompra(i: Number) {
    MetodoCompras.eliminar(i);
}

fun ventanaUpdateCompra() {
    var panelTabla = JPanel();
    //panelTabla.preferredSize=Dimension(500, 300)

    var panelBoton = JPanel();
    var panelCampos = JPanel();

    val ventanaactualizar = JFrame("ACTUALIZAR ELEMENTO");

    ventanaactualizar.getContentPane().add(panelTabla, BorderLayout.NORTH);

    ventanaactualizar.getContentPane().add(panelBoton, BorderLayout.CENTER);
    ventanaactualizar.getContentPane().add(panelCampos, BorderLayout.SOUTH);

    //Instancio la tabla
    var dtm=rellenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);

    var botonEscojer = JButton("EDITAR");
    panelBoton.add(botonEscojer);


    var label1 = JLabel("Producto:", 10)
    var textProducto = JTextField("", 10)

    var label2 = JLabel("Cantidad:", 10)
    var textCantidad = JTextField("", 10)

    var label3 = JLabel("Fecha Compra:", 10)
    var textFechaCompra = JTextField("", 10)

    var label4 = JLabel("Usuario:", 10)
    var textUsuario = JTextField("", 10)

    var label5 = JLabel("Cedula:", 10)
    var textCedula = JTextField("", 10)

    var label6 = JLabel("ValorTotal:", 10)
    var textValorTotal = JTextField("", 10)


    var boton = JButton("ACTUALIZAR");
    var botonregresar = JButton("VOLVER");


    val experimentLayout = GridLayout(7, 7)
    panelCampos.setLayout(experimentLayout);

    panelCampos.add(label1);
    panelCampos.add(textProducto);
    panelCampos.add(label2);
    panelCampos.add(textCantidad);
    panelCampos.add(label3);
    panelCampos.add(textFechaCompra);
    panelCampos.add(label4);
    panelCampos.add(textUsuario);
    panelCampos.add(label5);
    panelCampos.add(textCedula);
    panelCampos.add(label6);
    panelCampos.add(textValorTotal);

    panelCampos.add(botonregresar);
    panelCampos.add(boton);



    ventanaactualizar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanaactualizar.pack()
    ventanaactualizar.setLocationRelativeTo(null)
    ventanaactualizar.isVisible = true

    botonregresar.addActionListener {
        llamarVentanaCompras();
        ventanaactualizar.dispose();
    }

    var id = -1;
    botonEscojer.addActionListener {
        var i = tabla.getSelectedRow();
        if(i!=-1){
            id = dtm.getValueAt(i, 0).toString().toInt();
            var productoaux = dtm.getValueAt(i, 1);
            var cantidadaux = dtm.getValueAt(i, 2);
            var fechaCompraaux = dtm.getValueAt(i, 3);
            var usuarioaux = dtm.getValueAt(i, 4);
            var cedulaaux = dtm.getValueAt(i, 5);
            var valorTotalaux = dtm.getValueAt(i, 6);

            textProducto.text = productoaux.toString();
            textCantidad.text = cantidadaux.toString();
            textFechaCompra.text = fechaCompraaux.toString();
            textUsuario.text = usuarioaux.toString();
            textCedula.text = cedulaaux.toString();
            textValorTotal.text = valorTotalaux.toString();

        }else{
            JOptionPane.showMessageDialog(null,"ESCOJA REGISTRO");
        }

    }

    boton.addActionListener {

        if (id != -1 && !textProducto.getText().isEmpty() && !textCantidad.getText().isEmpty() && !textFechaCompra.getText().isEmpty() && !textUsuario.getText().isEmpty() &&
            !textCedula.getText().isEmpty() && !textValorTotal.getText().isEmpty()
        ) {
            actualizarTuplaCompra(
                id,
                textProducto.getText(),
                textCantidad.getText(),
                textFechaCompra.getText(),
                textUsuario.getText(),
                textCedula.getText(),
                textValorTotal.getText().toDouble()
            );

        }


    }

}

fun actualizarTuplaCompra(idCompra:Number,producto: String, cantidad:String, fechaCompra: String, usuario: String, cedula: String,valorTotal: Double) {

    MetodoCompras.actualizar(idCompra,producto,cantidad,fechaCompra,usuario,cedula,valorTotal);
}
